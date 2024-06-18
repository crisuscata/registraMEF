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
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {

			MenuaccesosJS menuaccesosJS = new MenuaccesosJS();

			List<String> roles = msUsuariosBk.getRolesSistema();

			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.DTENTIDADES_CREA) || roles.contains(Roles.DTENTIDADES_VE)) {
				menuaccesosJS.setEntidades(true);
			}			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUSUARIOS_CREA) || roles.contains(Roles.MSUSUARIOS_VE)) {
				menuaccesosJS.setUsuarios(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.MSUBIGEO_CREA) || roles.contains(Roles.MSUBIGEO_VE)) {
				menuaccesosJS.setUbigeo(true);
			}
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PRTPARAMETROS_CREA) || roles.contains(Roles.PRTPARAMETROS_VE)) {
				menuaccesosJS.setParametros(true);
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
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

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
