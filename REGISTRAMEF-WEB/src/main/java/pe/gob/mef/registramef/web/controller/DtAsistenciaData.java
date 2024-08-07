package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtAsistenciaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtAsistenciaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtAsistenciaData() {
	}

	@SuppressWarnings("unchecked")
//	public List<DtAsistenciaBk> getDtAsistenciaActivos(Servicio servicio, Long kyUsuarioMod){		
	public List<DtAsistenciaBk> getDtAsistenciaActivos(Servicio servicio, Long kyUsuarioMod, String fechaInicio, String fechaFin,String idProgramacion,int reload, long sede,int rol,long sistemaadmi){
		List<DtAsistenciaBk> dtAsistenciaBksss = null;
		String key = DtAsistenciaBk.class.getSimpleName();
		if(reload==1)
		{
			dataCache = new HashMap<>();
		}
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtAsistenciaBksss = (List<DtAsistenciaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
//		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
		                	//MPINARES 24012023 - INICIO
//		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
		            		Long idProgramacionl=Long.parseLong(idProgramacion);
		                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		                	Date fechaIniciod=sdformat.parse(fechaInicio);
		                	Date fechaFind=sdformat.parse(fechaFin);
//		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getDtAsistenciaXFiltroV(fechaIniciod, fechaIniciod, idProgramacionl, kyUsuarioMod);
		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getDtAsistenciaXFiltroV2(fechaIniciod, fechaIniciod, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
		                	//MPINARES 24012023 - FIN
		    				entrada.setLista(dtAsistenciaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			
			//MPINARES 24012023 - INICIO
			try {
			Entrada entrada = new Entrada();
//			dtAsistenciaBksss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
			Long idProgramacionl=Long.parseLong(idProgramacion);
        	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        	Date fechaIniciod=sdformat.parse(fechaInicio);
        	Date fechaFind=sdformat.parse(fechaFin);
//			dtAsistenciaBksss = servicio.getDtAsistenciaXFiltroV(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod);
        	dtAsistenciaBksss = servicio.getDtAsistenciaXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
			
			entrada.setLista(dtAsistenciaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
			}catch (Exception ex) {
            	log.info(ex.getMessage());
                
            } 
			//MPINARES 24012023 - FIN			
		}
		return dtAsistenciaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtAsistenciaBk dtAsistenciaC, String fechaInicio, String fechaFin,String idProgramacion, long sede,int rol,long sistemaadmi){		
		List<DtAsistenciaBk> dtAsistenciaBksss = null;
		String key = DtAsistenciaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtAsistenciaBksss = (List<DtAsistenciaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	Long idProgramacionl=Long.parseLong(idProgramacion);
		                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		                	Date fechaIniciod=sdformat.parse(fechaInicio);
		                	Date fechaFind=sdformat.parse(fechaFin);
//		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
		                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getDtAsistenciaXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
		    				entrada.setLista(dtAsistenciaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			try {
			Entrada entrada = new Entrada();
			Long idProgramacionl=Long.parseLong(idProgramacion);
        	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        	Date fechaIniciod=sdformat.parse(fechaInicio);
        	Date fechaFind=sdformat.parse(fechaFin);
//			dtAsistenciaBksss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
			dtAsistenciaBksss = servicio.getDtAsistenciaXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
			entrada.setLista(dtAsistenciaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
			} catch (Exception ex) {
            	log.info(ex.getMessage());
                
            } 
		}
		if (!dtAsistenciaBksss.contains(dtAsistenciaC)) {
			dtAsistenciaBksss.add(dtAsistenciaC);
		} else {
			int itemIndex = dtAsistenciaBksss.indexOf(dtAsistenciaC);
			if (itemIndex != -1) {
				dtAsistenciaBksss.set(itemIndex, dtAsistenciaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod, String fechaInicio, String fechaFin,String idProgramacion, long sede,int rol,long sistemaadmi){
		String key = DtAsistenciaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	Long idProgramacionl=Long.parseLong(idProgramacion);
                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                	Date fechaIniciod=sdformat.parse(fechaInicio);
                	Date fechaFind=sdformat.parse(fechaFin);
//                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getDtAsistenciaXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
    				entrada.setLista(dtAsistenciaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
	
	//INICIO CUSCATA - 10072024
		public List<DtAsistenciaBk> getDtAsistenciaNoProgActivos(Servicio servicio, Long kyUsuarioMod, String fechaInicio, String fechaFin,String idProgramacion, long sede,int rol,long sistemaadmi){
			List<DtAsistenciaBk> dtAsistenciaBksss = null;
			String key = DtAsistenciaBk.class.getSimpleName();
			if(dataCache.containsKey(key)){
				System.out.println("EXISTE DATA EN CACHE");
				Entrada entrada = dataCache.get(key);
				dtAsistenciaBksss = (List<DtAsistenciaBk>) entrada.getLista();
				long ultimoacceso = entrada.getUltimoacceso();
				entrada.setUltimoacceso(System.currentTimeMillis());
				if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
					new Thread() {
			            public void run() {
			                try {
			                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			                	Date fechaIniciod=sdformat.parse(fechaInicio);
			                	Date fechaFind=sdformat.parse(fechaFin);
			                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getDtAsistenciaXFiltro(fechaIniciod, fechaFind, null, kyUsuarioMod, sede, rol, sistemaadmi);
			    				entrada.setLista(dtAsistenciaBkssss);
			    				entrada.setUltimoacceso(System.currentTimeMillis());
			                } catch (Exception ex) {
			                	log.info(ex.getMessage());
			                    
			                } 
			            }		 
			        }.start();				
				}
			}else{
				try {
					System.out.println("NO - EXISTE DATA EN CACHE");
					Entrada entrada = new Entrada();
		        	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		        	Date fechaIniciod=sdformat.parse(fechaInicio);
		        	Date fechaFind=sdformat.parse(fechaFin);
					dtAsistenciaBksss = servicio.getDtAsistenciaXFiltro(fechaIniciod, fechaFind, null, kyUsuarioMod, sede, rol, sistemaadmi);
					
					entrada.setLista(dtAsistenciaBksss);
					entrada.setTiempomuerto(60000);
					entrada.setUltimoacceso(System.currentTimeMillis());
					dataCache.put(key, entrada);
				} catch (Exception ex) {
	            	log.info(ex.getMessage());
	            } 
			}
			return dtAsistenciaBksss;		
		}
		//FIN CUSCATA - 10072024
		
		@SuppressWarnings("unchecked")
		public void addV1(Servicio servicio, Long kyUsuarioMod, DtAsistenciaBk dtAsistenciaC){		
			List<DtAsistenciaBk> dtAsistenciaBksss = null;
			String key = DtAsistenciaBk.class.getSimpleName();
			if(dataCache.containsKey(key)){
				Entrada entrada = dataCache.get(key);
				dtAsistenciaBksss = (List<DtAsistenciaBk>) entrada.getLista();
				entrada.setUltimoacceso(System.currentTimeMillis());
				if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
					new Thread() {
			            public void run() {
			                try {
			                	List<DtAsistenciaBk> dtAsistenciaBkssss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
			    				entrada.setLista(dtAsistenciaBkssss);
			    				entrada.setUltimoacceso(System.currentTimeMillis());
			                } catch (Exception ex) {
			                	log.info(ex.getMessage());
			                    
			                } 
			            }		 
			        }.start();				
				}
			}else{
				Entrada entrada = new Entrada();
				dtAsistenciaBksss = servicio.getAllDtAsistenciaActivosCero(kyUsuarioMod);
				entrada.setLista(dtAsistenciaBksss);
				entrada.setTiempomuerto(60000);
				entrada.setUltimoacceso(System.currentTimeMillis());
				dataCache.put(key, entrada);
			}
			if (!dtAsistenciaBksss.contains(dtAsistenciaC)) {
				dtAsistenciaBksss.add(dtAsistenciaC);
			} else {
				int itemIndex = dtAsistenciaBksss.indexOf(dtAsistenciaC);
				if (itemIndex != -1) {
					dtAsistenciaBksss.set(itemIndex, dtAsistenciaC);
				}
			}		
		}
}
