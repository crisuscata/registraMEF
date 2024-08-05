package pe.gob.mef.registramef.web.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Util {
	//JPUYEN 17062024 - NUEVA CLASE
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}
	
	
	public static String getBaseURL() {
		String puerto = getRequest().getServerPort() == 0 ? "" : ":" + getRequest().getServerPort();
		return getRequest().getScheme() + "://" + getRequest().getServerName() + puerto + getRequest().getContextPath();	
	}
	
	
	//JPUYEN 17062024 - FIN NUEVA CLASE
	
	
	public static String formatToStringTimestamp(Timestamp timestamp,String formato) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		
		return sdf.format(timestamp);
	}
	
	public static Date getSoloFecha(Timestamp fecha) {
		Calendar calendar1 = Calendar.getInstance();

		calendar1.setTime(new Date(fecha.getTime()));
		calendar1.set(Calendar.HOUR_OF_DAY, 0);
		calendar1.set(Calendar.MINUTE, 0);
		calendar1.set(Calendar.SECOND, 0);
		calendar1.set(Calendar.MILLISECOND, 0);

		return calendar1.getTime();
	}
	
	
}
