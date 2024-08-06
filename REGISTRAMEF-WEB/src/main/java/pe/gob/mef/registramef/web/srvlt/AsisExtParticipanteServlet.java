package pe.gob.mef.registramef.web.srvlt;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.web.utils.Util;

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
	
	private String fechaFinTexto(Timestamp fechaInicio, Timestamp fechaFin) {
		String formatFecha="";
		Date fechaI=null;
		Date fechaF=null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");
		if(fechaFin!=null && fechaInicio!=null){
			fechaI=Util.getSoloFecha(fechaInicio);
			fechaF=Util.getSoloFecha(fechaFin);
			if(fechaI.compareTo(fechaF)==0)
				formatFecha=sdh.format(fechaFin);
			else 
				formatFecha=sdf.format(fechaFin);
			
			
		}
		return formatFecha ;
	}
	
	private String lugar(DtCapacitacionBk dtCapacitacionBk) {
		
		Long idVirtual = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
				PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);
		
		if (dtCapacitacionBk.getIdModalidad() != null
				&& dtCapacitacionBk.getIdModalidad().compareTo(
						idVirtual) == 0)
			return "CAPACITACION VIRTUAL";
		else
			
			return (dtCapacitacionBk.getIdSedeTxt()
					+ (dtCapacitacionBk.getIdLocalTxt() == null ? ""
							: "-" + dtCapacitacionBk.getIdLocalTxt()));
			
		
	}
	
	
	private void loadValues(HttpServletRequest request, Long idCapa, Long est) {
		DtCapacitacionBk dtCapacitacionBk = servicio.getDtCapacitacionBkXid(idCapa, null);
        
        request.setAttribute("idCapacitacion", dtCapacitacionBk.getIdCapacitacion());
        request.setAttribute("descripcionEvento", dtCapacitacionBk.getNomEvento());
        
        Timestamp fecInicio= (dtCapacitacionBk.getFechaInic() == null ? dtCapacitacionBk.getFechaIniProgramada() : dtCapacitacionBk
				.getFechaInic());
        
        String fechaInicio = Util.formatToStringTimestamp(fecInicio, "dd/MM/yyyy HH:mm");
        
        
        request.setAttribute("fechaInicio", fechaInicio);
        request.setAttribute("fechaFin", this.fechaFinTexto(dtCapacitacionBk.getFechaInic(), dtCapacitacionBk.getFechaFin()));
        request.setAttribute("lugar", this.lugar(dtCapacitacionBk));
        
        
        request.setAttribute("actionForm", "servicio-inscripcion-page?idCapa="+idCapa+"&est="+est);
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------GET AsisExtParticipanteServlet------");
		
	
		String captcha = this.generateCaptcha();
        request.getSession().setAttribute("info_captcha", captcha);
		
		Long idCapa = Long.parseLong(request.getParameter("idCapa"));
        Long est = Long.parseLong(request.getParameter("est"));
		
        this.loadValues(request, idCapa, est);
        request.setAttribute("flagBuscar", "flagBuscar");
		
		response.setContentType("text/html");
        request.getRequestDispatcher("/servicio-inscripcion-page.htm").forward(request, response);
	}
	
	private void notExitUser(HttpServletRequest request, String idCapa, String est) {
		
		String msnUno= Messages.getStringToKey("registro.participante.no.asistencia");
		String msnDos=Messages.getStringToKey("registro.participante.registrese.aqui");
		
		request.setAttribute("msnUno", msnUno);
		request.setAttribute("msnDos", msnDos);
		
		request.setAttribute("flagNuevaConsulta", "flagNuevaConsulta");
		request.setAttribute("flagResultado", "flagResultado");
		request.setAttribute("urlCapaExt", "http://host/servicioInscripcion/dtCapacitacionExtView.htm"+"?idCapa="+idCapa);
		this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------POST AsisExtParticipanteServlet------");
		
		String txtInputCaptcha = request.getParameter("j_captcha");	
		String txtDni = request.getParameter("txtDni");	
		String captchaGenerado = (String) request.getSession().getAttribute("info_captcha");
		String flagRegistrar = (String) request.getSession().getAttribute("flagRegistrar");
		
		String idCapa = request.getParameter("idCapa");
		String est = request.getParameter("est");
		
		System.out.println("idCapa:"+idCapa);
		System.out.println("est:"+est);
		
		System.out.println("flagRegistrar:"+flagRegistrar);
		
		System.out.println("txtInputCaptcha:"+txtInputCaptcha);
		System.out.println("captchaGenerado:"+captchaGenerado);
		
		if(txtInputCaptcha.equalsIgnoreCase(captchaGenerado)) {

			if(txtDni!=null && !txtDni.isEmpty()) {
				
				String msnUno="";
				String msnDos="";
				String msnTres="";
				
				if (txtDni.trim().length()!=8) {
					request.setAttribute("mensajeErrorDNI", Messages.getStringToKey("dtcapacitacion.ingrese.dni.error"));
					this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
				} else {
					
					Long estadoProceso = PropertiesMg.getSistemLong(
							PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
							PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
					
					DtCapacitacionBk dtCapacitacionBk = servicio.getOnlyDtCapacitacionBkById(Long.parseLong(idCapa));
					
					if(dtCapacitacionBk!=null && dtCapacitacionBk.getEstado().longValue()!=estadoProceso){
						msnUno= Messages.getStringToKey("registro.participante.capac.finalizado");
						request.setAttribute("msnUno", msnUno);
						
						request.setAttribute("flagNuevaConsulta", "flagNuevaConsulta");
						request.setAttribute("flagResultado", "flagResultado");
						
					} else {
						
						try {
							DtUsuarioExternoBk dtUsuarioExternoBk= servicio.getDtUsuarioExtByDni(txtDni);
							
							if(dtUsuarioExternoBk!=null && dtUsuarioExternoBk.getIdUsuexterno()!=null){
								
								DtCapaUsuexternosBk dtCapaUsuexternosBk=servicio.getDtCapaUsuexternos(Long.parseLong(idCapa), dtUsuarioExternoBk.getIdUsuexterno());
								
								if(dtCapaUsuexternosBk!=null && dtCapaUsuexternosBk.getIdCapaUsuext()!=null){
									
									long flagAsistencia=PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_ASISTENCIA_SI, PropertiesMg.DEFAULT_PRTPARAMETROS_ASISTENCIA_SI).longValue();
									if(dtCapaUsuexternosBk.getFlagAsistencia()!=null && dtCapaUsuexternosBk.getFlagAsistencia().longValue()==flagAsistencia){
										msnUno=dtUsuarioExternoBk.getNombreCompleto().toUpperCase();
										msnDos="DNI: "+dtUsuarioExternoBk.getNumDocum();
										msnTres=Messages.getStringToKey("registro.participante.si.asistio");
										
										request.setAttribute("msnUno", msnUno);
										request.setAttribute("msnDos", msnDos);
										request.setAttribute("msnTres", msnTres);
										
										request.setAttribute("flagNuevaConsulta", "flagNuevaConsulta");
										request.setAttribute("flagResultado", "flagResultado");
										this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
									} else {
										
										msnUno=dtUsuarioExternoBk.getNombreCompleto().toUpperCase();
										msnDos="DNI: "+dtUsuarioExternoBk.getNumDocum();
										
										request.setAttribute("msnUno", msnUno);
										request.setAttribute("msnDos", msnDos);
										
										request.setAttribute("flagNuevaConsulta", "flagNuevaConsulta");
										request.setAttribute("flagResultado", "flagResultado");
										request.setAttribute("flagRegistrar", "flagRegistrar");
										this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
									}
									
								} else {
									this.notExitUser(request, idCapa, est);
								}
								
							} else {
								this.notExitUser(request, idCapa, est);
							}
							
						} catch (Validador e) {
							this.notExitUser(request, idCapa, est);
						}	
					}
				}
				
			} else {
				request.setAttribute("mensajeErrorDNI", Messages.getStringToKey("dtcapacitacion.ingrese.dni.vacio"));
				this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
			}
			
		} else {
			request.setAttribute("mensajeConfirmacion", Messages.getStringToKey("registro.participante.capa.captcha.invalido"));
			this.loadValues(request, Long.parseLong(idCapa), Long.parseLong(est));
		}
		
		request.getRequestDispatcher("/servicio-inscripcion-page.htm").forward(request, response);

	}

}
