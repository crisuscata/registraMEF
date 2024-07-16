package pe.gob.mef.registramef.web.utils;

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
}
