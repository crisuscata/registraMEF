package pe.gob.mef.registramef.web.srvlt;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;

public class ConfirmationPageServlet extends HttpServlet {
	
	private Servicio servicio;
	
	public void init() throws ServletException {
        super.init();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        servicio = ctx.getBean(Servicio.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("-------GET------");
        
        Long idUsuarioAsisExt = Long.parseLong(request.getParameter("idu"));
        Long idAsistencia = Long.parseLong(request.getParameter("ids"));
        
        System.out.println("idUsuarioAsisExt:" + idUsuarioAsisExt);
        System.out.println("idAsistencia:" + idAsistencia);
        
        
        DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk = servicio.getDtAsistenciaUsuexternosBkXid(idUsuarioAsisExt, null);
        Long confirmoCorreo=2L;
        Long paramIdModalidadVirtual = 137L;
        
        if(dtAsistenciaUsuexternosBk!=null) {
        	
        	if(dtAsistenciaUsuexternosBk.getCtrlConfirmacion()==confirmoCorreo) {
        		request.setAttribute("usuarioConfirmoCorreo", "SI");
        		request.setAttribute("mensajeConfirmacion", "LA ATENCIÓN YA HA SIDO CONFIRMADO POR EL USUARIO.");
        	}else {
        		DtAsistenciaBk dtAsistenciaBk = servicio.getDtAsistenciaBkXid(idAsistencia, null);
        		if(dtAsistenciaBk!=null) {
        			if(String.valueOf(dtAsistenciaBk.getIdModalidad()).equals(String.valueOf(paramIdModalidadVirtual)) ) {
        				request.setAttribute("usuarioConfirmoCorreo", "NO");
	            		request.setAttribute("idAsistencia", dtAsistenciaBk.getIdAsistencia());
	            		SimpleDateFormat sdfddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
	            		String fechaAsistencia = sdfddMMyyyy.format(dtAsistenciaBk.getFechaAsistencia());
	            		request.setAttribute("fechaAsistencia", fechaAsistencia);
	            		request.setAttribute("temaTotal", this.temaTotal(dtAsistenciaBk).get("temaTotal"));
	            		request.setAttribute("especiaTotal", this.temaTotal(dtAsistenciaBk).get("especiaTotal"));
	            		request.setAttribute("fechaLargaSinAnio", this.fechaLargaSinAnio(dtAsistenciaBk));
	            		
	            		request.setAttribute("actionForm", "confirmacion-page?idu="+idUsuarioAsisExt+"&ids="+idAsistencia);
        			} else {
        				request.setAttribute("usuarioConfirmoCorreo", "SI");
                		request.setAttribute("mensajeConfirmacion", "LA ASISTENCIA TÉCNICA DEBE DE SER  VIRTUAL.");
        			}
        		}
        	}
        }
        response.setContentType("text/html");
        request.getRequestDispatcher("/confirmation-page.htm").forward(request, response);
        
    }
    
    private String fechaLargaSinAnio(DtAsistenciaBk dtAsistenciaBk) {
    	return FuncionesStaticas.getfechaLargaFormateadaSinHoraAnio(new Timestamp(dtAsistenciaBk.getFechaAsistencia().getTime()));
    }
    
    private Map<String, String> temaTotal(DtAsistenciaBk dtAsistenciaBk) {
    	Map<String, String> map = new HashMap<>();
    	String temaTotal = "";
    	String especiaTotal = "";
    	if(dtAsistenciaBk.getDtAsistenciaTemasBkJSss()!=null && !dtAsistenciaBk.getDtAsistenciaTemasBkJSss().isEmpty()) {
    		for (DtAsistenciaTemasBk dtAsisTema : dtAsistenciaBk.getDtAsistenciaTemasBkJSss()) {
    			
   			 if(!temaTotal.trim().toUpperCase().contains(dtAsisTema.getIdTemaTxt().trim().toUpperCase())){
   					temaTotal = temaTotal + " " +  FuncionesStaticas.convertirFrasePrimerCaracMayuscula(dtAsisTema.getIdTemaTxt().trim().toLowerCase())+ ", ";
   			 }
   			 
   			if(!especiaTotal.trim().toUpperCase().contains((dtAsistenciaBk.getIdUsuinternoTxt().trim().toLowerCase()).trim().toUpperCase())){
				especiaTotal = especiaTotal + " " + FuncionesStaticas.convertirFrasePrimerCaracMayuscula(dtAsistenciaBk.getIdUsuinternoTxt().trim().toLowerCase()) +".";
   			}
   			 
   		}
    	}
    	
    	map.put("temaTotal", temaTotal.trim());
    	map.put("especiaTotal", especiaTotal.trim());
    	
    	return map;
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("-------POST------");
    	
        String idu = request.getParameter("idu");

        request.setAttribute("mensajeConfirmacion", "LA ATENCIÓN YA HA SIDO CONFIRMADO POR EL USUARIO.");
        
        try {
        	servicio.updateDtAsistenciaUsuexCorreo( Long.parseLong(idu));
		} catch (Exception e) {
			request.setAttribute("mensajeConfirmacion", "HUBO UN INCOVENIENTE AL CONFIRMAR, FAVOR DE REFRESCAR LA PAGINA");
		}

        request.getRequestDispatcher("/confirmation-page.htm").forward(request, response);
    }
    
    
}
