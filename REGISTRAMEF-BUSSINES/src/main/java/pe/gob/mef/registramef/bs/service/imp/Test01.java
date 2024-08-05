package pe.gob.mef.registramef.bs.service.imp;

import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.web.security.Encriptar;

public class Test01 {

	public static void main(String[] args) {
		
		Encriptar enc = new Encriptar();
		
		/*String emcriptado = enc.EncriptarData("jzarate",
				"jzarate");
		
		System.out.println(emcriptado);*/
		
long flagAsistencia=PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_SI, PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_SI).longValue();
		
		System.out.println("flagAsistencia: "+ flagAsistencia);

	}

}
