package pe.gob.mef.registramef.bs.service.imp;

import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import java.sql.Timestamp;
import java.util.Calendar;
import pe.gob.mef.web.security.Encriptar;

public class Test01 {

	public static void main(String[] args) {
		
		Encriptar enc = new Encriptar();
		
		/*String emcriptado = enc.EncriptarData("jzarate",
				"jzarate");
		
		System.out.println(emcriptado);*/
		
//long flagAsistencia=PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_SI, PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_SI).longValue();
		
	//	System.out.println("flagAsistencia: "+ flagAsistencia);
		
		
		// Get the current date and time
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // Create a specific Timestamp to compare with (example: 2024-12-31 23:59:59)
        Timestamp specificTimestamp = Timestamp.valueOf("2024-08-06 11:16:00");

        // Add 30 minutes to the current time
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(specificTimestamp.getTime());
        cal.add(Calendar.MINUTE, 30);
        Timestamp specificTimestampPlus30Minutes = new Timestamp(cal.getTimeInMillis());

        // Check if the current time + 30 minutes is before the specific timestamp
        if (currentTimestamp.before(specificTimestampPlus30Minutes)) {
            //System.out.println("The current time + 30 minutes is before the specific timestamp.");
        	System.out.println("puede registrar");
        } else {
            //System.out.println("The current time + 30 minutes is after or equal to the specific timestamp.");
        	System.out.println("no puede registrar");
        }
		

	}

}
