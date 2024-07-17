package pe.gob.mef.registramef.web.srvlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.mef.registramef.bs.service.Servicio;

public class AsisExtParticipanteServlet extends HttpServlet {
	
	private Servicio servicio;
	
	public void init() throws ServletException {
        super.init();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        servicio = ctx.getBean(Servicio.class);
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------GET AsisExtParticipanteServlet------");
		
		Long idCapa = Long.parseLong(request.getParameter("idCapa"));
        Long est = Long.parseLong(request.getParameter("est"));
		
		
		response.setContentType("text/html");
        request.getRequestDispatcher("/servicio-inscripcion-page.htm").forward(request, response);
	}

}
