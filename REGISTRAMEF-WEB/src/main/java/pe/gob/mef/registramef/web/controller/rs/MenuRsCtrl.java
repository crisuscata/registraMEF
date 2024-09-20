package pe.gob.mef.registramef.web.controller.rs;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.web.controller.rs.data.MenuaccesosJS;
import pe.gob.mef.registramef.web.controller.rs.data.MsUsuariosPerfilJS;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;

@Path("/ctrlmenu")
public class MenuRsCtrl {

	@Autowired
	private Servicio servicio = null;

	public MenuRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/perfilusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMsUsuarios(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
//		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());
		MsUsuariosBk msUsuariosBk = null;
		if(servicio!=null && usuario!=null)
		msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());


		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {

			MenuaccesosJS menuaccesosJS = new MenuaccesosJS();

			List<String> roles = msUsuariosBk.getRolesSistema();
			
			//MODULO REGISTRO Y PROGRAMACION
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTASISTENCIA_VE)  || roles.contains(Roles.DTASISTENCIA_CREA) ) {
				menuaccesosJS.setProgramacionasistencia(true);
				menuaccesosJS.setRegistroasistencia(true);
			}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCAPACITACION_VE)  || roles.contains(Roles.DTCAPACITACION_CREA) ) {
				menuaccesosJS.setProgramacioncapacitacion(true);
				menuaccesosJS.setRegistrocapacitacion(true);
			}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTVISITAS_VE) ||roles.contains(Roles.DTVISITAS_CREA)) {
				menuaccesosJS.setProgramacionreunion(true);
				menuaccesosJS.setRegistroreunion(true);
			}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTCONSULTAS_VE) ||roles.contains(Roles.DTCONSULTAS_CREA)) {
				menuaccesosJS.setRegistroconsulta(true);
			}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PUBLICA_DTCAPACITACION_CREA) ) {
				menuaccesosJS.setRegistrocapacitacionpubli(true);
			}
			
			//MODULO REPORTES
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_SERVICIO_RESUMEN) ) {
				menuaccesosJS.setReporteservicioresumen(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_SERVICIO_SEDE) ) {
				menuaccesosJS.setReporteserviciosede(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_SERVICIO_REPRESENTANTE) ) {
				menuaccesosJS.setReporteserviciorepresentante(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_GENERICO) ) {
				menuaccesosJS.setReportegenerico(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_AVANCE_METAS) ) {
				menuaccesosJS.setReportemetas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_ENCUESTAS) ) {
				menuaccesosJS.setReporteencuestas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_GEOZONA) ) {
				menuaccesosJS.setReporteentidadesgeozona(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_COBERTURA) ) {
				menuaccesosJS.setReporteentidadescobertura(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_DIRECTORIO) ) {
				menuaccesosJS.setReporteusuariosdirectorio(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_USU_INTERNO) ) {
				menuaccesosJS.setReporteusuariosinterno(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.REPORTE_USU_EXTERNO) ) {
				menuaccesosJS.setReporteusuariosexterno(true);
			}
			
			//DATOS SERVICIOS
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUSUARIOS_CREA) || roles.contains(Roles.MSUSUARIOS_VE)) {
				menuaccesosJS.setUsuarios(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTUSUARIOEXTERNO_CREA) || roles.contains(Roles.DTUSUARIOEXTERNO_VE)) {
				menuaccesosJS.setUsuariosexternos(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSISADMISTRATIVO_CREA) || roles.contains(Roles.MSSISADMISTRATIVO_VE)) {
				menuaccesosJS.setDatossisadministrativo(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSTEMA_CREA) || roles.contains(Roles.MSTEMA_VE)) {
				menuaccesosJS.setDatostemas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSUBTEMA_CREA) || roles.contains(Roles.MSSUBTEMA_VE)) {
				menuaccesosJS.setDatossubtemas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADES_CREA) || roles.contains(Roles.DTENTIDADES_VE)) {
				menuaccesosJS.setEntidades(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSLOCAL_CREA) || roles.contains(Roles.MSLOCAL_VE)) {
				menuaccesosJS.setDatolocales(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) ) {
				menuaccesosJS.setDatogeozona(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSSEDES_CREA) || roles.contains(Roles.MSSEDES_VE)) {
				menuaccesosJS.setDatosede(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSMETA_CREA) || roles.contains(Roles.MSMETA_VE)) {
				menuaccesosJS.setDatometas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSINDICADOR_CREA) || roles.contains(Roles.MSINDICADOR_VE)) {
				menuaccesosJS.setDatoindicadores(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENCUESTA_CREA) || roles.contains(Roles.DTENCUESTA_VE)) {
				menuaccesosJS.setDatoencuestas(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPROYECTOINVERSION_CREA) || roles.contains(Roles.MSPROYECTOINVERSION_VE)) {
				menuaccesosJS.setDatoproyectos(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTAMPLIACIONFECHA_CREA) || roles.contains(Roles.DTAMPLIACIONFECHA_VE)) {
				menuaccesosJS.setDatoampliacion(true);
			}
			
			//CONFIGURACION
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PRTPARAMETROS_CREA) || roles.contains(Roles.PRTPARAMETROS_VE)) {
				menuaccesosJS.setParametros(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSPAISES_CREA) || roles.contains(Roles.MSPAISES_VE)) {
				menuaccesosJS.setPaises(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUBIGEO_CREA) || roles.contains(Roles.MSUBIGEO_VE)) {
				menuaccesosJS.setUbigeo(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.TAFERIADOS_CREA) || roles.contains(Roles.TAFERIADOS_VE)) {
				menuaccesosJS.setFeriados(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSALERTA_CREA) || roles.contains(Roles.MSALERTA_VE)) {
				menuaccesosJS.setAlerta(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR)) {
				menuaccesosJS.setMantenimiento(true);
			}
					
			GenericEntity<MenuaccesosJS> registrosx = new GenericEntity<MenuaccesosJS>(menuaccesosJS) {
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@POST
	@Path("/actualizarperfil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarMsUsuarios(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, MsUsuariosPerfilJS msUsuariosPerfilJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
//		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());
		MsUsuariosBk msUsuariosBk = null;
		if(servicio!=null && usuario!=null)
		msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());


		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		MsUsuariosBk msUsuariosBkC = new MsUsuariosBk();
		FuncionesStaticas.copyPropertiesObject(msUsuariosBkC, msUsuariosBk);
		msUsuariosBkC.setContrasenia(msUsuariosPerfilJS.getContrasenia());
		msUsuariosBkC.setContraseniaConfir(msUsuariosPerfilJS.getContraseniaConfir());
		
		try {
			msUsuariosBkC = servicio.saveorupdateMsUsuariosBk(msUsuariosBkC, msUsuariosBk.getUsername(),
					msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), null, adressRemoto, true);
			
			msUsuariosPerfilJS = new MsUsuariosPerfilJS();
			msUsuariosPerfilJS.setIdunidad(msUsuariosBkC.getIdSede());
			msUsuariosPerfilJS.setIdunidadTxt(msUsuariosBkC.getIdSedeTxt());
			msUsuariosPerfilJS.setIdusuario(msUsuariosBkC.getIdusuario());
			msUsuariosPerfilJS.setNombrecompleto(FuncionesStaticas.getNombreCompleto(msUsuariosBkC));
			msUsuariosPerfilJS.setUsername(msUsuariosBkC.getUsername());
			req.getSession().setAttribute("MsUsuariosPerfilJS",msUsuariosPerfilJS);
			
			GenericEntity<MsUsuariosPerfilJS> registrors = new GenericEntity<MsUsuariosPerfilJS>(msUsuariosPerfilJS) {
			};
			return Response.status(200).entity(registrors).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	private String getRemoteAdress(HttpServletRequest request) {
		String s = "";
		try {
			String hostname = "";
			try {
				InetAddress addr = InetAddress.getByName(request.getRemoteHost());
				hostname = addr.getHostName();
			} catch (UnknownHostException e) {
			}
			s = (hostname + "_" + request.getRemoteHost() + "_" + getClientIpAddress(request)); // request.getRemoteAddr());
			s = s.substring(0, 50);
		} catch (Exception e) {
		}
		return s;
	}
	
	private String getClientIpAddress(HttpServletRequest request) {
		String[] IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR",
				"HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED",
				"HTTP_VIA", "REMOTE_ADDR" };
		for (String header : IP_HEADER_CANDIDATES) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
	
	//INIICIO 11082023 LLEYVAH
//		@POST
//		@Path("/changepassword")
//		@Consumes(MediaType.APPLICATION_JSON)
//		@Produces(MediaType.APPLICATION_JSON)
//		public Response changeUserPasswordEndpoint(@Context HttpServletRequest req, 
//		                                           @Context HttpServletResponse res,
//		                                           @HeaderParam("authorization") String authString,
//		                                           ChangePasswordRequest passwordRequest) {
//		    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//
//		    Principal usuario = req.getUserPrincipal();
//		    MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());
//
//		    if (msUsuariosBk == null)
//		        return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
//		                .entity(new GenericEntity<RespuestaError>(
//		                        new RespuestaError("ERROR: No tiene autorización para realizar esta operación.",
//		                                HttpURLConnection.HTTP_UNAUTHORIZED)) {}).build();
//
//		    try {
//		        // Verificar si las contraseñas proporcionadas son iguales
//		        if (!passwordRequest.getNewPassword().equals(passwordRequest.getRepeatPassword())) {
//		            throw new Validador("Las contraseñas no coinciden.");
//		        }
//
//		        // Cambiar la contraseña usando el método proporcionado
//		        servicio.changeUserPassword(msUsuariosBk.getIdusuario(), passwordRequest.getNewPassword(), passwordRequest.getRepeatPassword());
//		        
//		        return Response.status(200).entity(new GenericEntity<Map<String, String>>(Collections.singletonMap("message", "Contraseña actualizada con éxito!")) {}).build();
//
//
//
//		    } catch (Validador e) {
//		        String mensaje = e.getMessage();
//		        System.out.println("ERROR: " + mensaje);
//		        return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
//		                new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {}).build();
//		    } catch (Exception e) {
//		        String mensaje = e.getMessage();
//		        System.out.println("ERROR: " + mensaje);
//		        return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(
//		                new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_INTERNAL_ERROR)) {}).build();
//		    }
//		}

		// Clase que representa el cuerpo del request, para recibir la nueva contraseña y su repetición
//		public static class ChangePasswordRequest {
//		    private String newPassword;
//		    private String repeatPassword;
//		    
//		    // Getters y setters
//		    public String getNewPassword() {
//		        return newPassword;
//		    }
//		    public void setNewPassword(String newPassword) {
//		        this.newPassword = newPassword;
//		    }
//		    public String getRepeatPassword() {
//		        return repeatPassword;
//		    }
//		    public void setRepeatPassword(String repeatPassword) {
//		        this.repeatPassword = repeatPassword;
//		    }
//		}
		//FIN 11082023 LLEYVAH
	//NO CUMPLE CON LOS CAMPOS DE AUDITORIA
	
}
