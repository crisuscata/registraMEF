package pe.gob.mef.registramef.web.srvlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

public class AsisExtParticipanteServlet extends HttpServlet {
	
	private Servicio servicio;
	
	public void init() throws ServletException {
        super.init();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        servicio = ctx.getBean(Servicio.class);
    }
	
	private String generateCaptcha() {
        int charsToPrint = 6;
        String elegibleChars = "ABCDEFGHJKLMPQRSTUVWXY23456789";
        char[] chars = elegibleChars.toCharArray();
        StringBuffer finalString = new StringBuffer();

        for (int i = 0; i < charsToPrint; i++) {
            double randomValue = Math.random();
            int randomIndex = (int) Math.round(randomValue * (chars.length - 1));
            char characterToShow = chars[randomIndex];
            finalString.append(characterToShow);
        }

        return finalString.toString();
    }
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------GET AsisExtParticipanteServlet------");
		
	
		String captcha = this.generateCaptcha();
        request.getSession().setAttribute("info_captcha", captcha);
		
		Long idCapa = Long.parseLong(request.getParameter("idCapa"));
        Long est = Long.parseLong(request.getParameter("est"));
		
        System.out.println("captcha: "  + captcha);
        
        request.setAttribute("actionForm", "servicio-inscripcion-page?idCapa="+idCapa+"&est="+est);
		
		response.setContentType("text/html");
        request.getRequestDispatcher("/servicio-inscripcion-page.htm").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------POST AsisExtParticipanteServlet------");
		
		String txtInputCaptcha = request.getParameter("j_captcha");	
		String txtDni = request.getParameter("txtDni");	
		String captchaGenerado = (String) request.getSession().getAttribute("info_captcha");
		
		String idCapa = request.getParameter("idCapa");
		String est = request.getParameter("est");
		
		System.out.println("idCapa:"+idCapa);
		System.out.println("est:"+est);
		
		System.out.println("txtInputCaptcha:"+txtInputCaptcha);
		System.out.println("captchaGenerado:"+captchaGenerado);
		
		if(txtInputCaptcha.equalsIgnoreCase(captchaGenerado)) {

			if(txtDni!=null && !txtDni.isEmpty()) {
				
				Long estadoProceso = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
						PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
				
				DtCapacitacionBk dtCapacitacionBk = servicio.getDtCapacitacionBkXid(Long.parseLong(idCapa), null);
				
				dtCapacitacionBk.getCantPartic();
				System.out.println("dtCapacitacionBk.getCantPartic(): " + dtCapacitacionBk.getCantPartic());
				
			} else {
				request.setAttribute("mensajeErrorDNI", "Ingrese su número de documento de identidad.");
			}
			
		} else {
			request.setAttribute("mensajeConfirmacion", "El código ingresado es incorrecto, favor de volver a intentar.");
		}
		
		request.getRequestDispatcher("/servicio-inscripcion-page.htm").forward(request, response);

	}

}
