package pe.gob.mef.registramef.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {

	public ZipDirectory(String directorio) {
		File directoryToZip = new File(directorio);
		List<File> fileList = new ArrayList<File>();
		getAllFiles(directoryToZip, fileList);
		writeZipFile(directoryToZip, fileList);
	}



	public void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {				
				if (file.isDirectory() && !file.getName().equals(".") && !file.getName().equals("..")) {					
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
					if (!file.getName().equals(".") && !file.getName().equals(".."))
					    fileList.add(file);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeZipFile(File directoryToZip, List<File> fileList) {

		try {

			String zipFie = directoryToZip.getAbsoluteFile() + System.getProperty("file.separator") + directoryToZip.getName() + ".zip";
			FileOutputStream fos = new FileOutputStream(zipFie);
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException, IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1, file.getCanonicalPath().length());
		System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
	
	//SPRINT24 INICIO
	public static void deleteFile(File element) {
	       if (element.isDirectory()) {
	           for (File sub : element.listFiles()) {	        	  
	               deleteFile(sub);               
	           }
	       }
//	       FileUtils.delete(element);  //SPRINT26
	       element.delete();
//	       boolean ver=element.delete();
//	       System.out.println(ver+"");
	}
	//SPRINT24 FIN
}