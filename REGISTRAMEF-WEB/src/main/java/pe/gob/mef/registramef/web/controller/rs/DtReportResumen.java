package pe.gob.mef.registramef.web.controller.rs;

import java.net.HttpURLConnection;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;

@Path("/ctrlDtReportResumen")
public class DtReportResumen {
	
	@Autowired
	private Servicio servicio = null;
	
	
	@GET
	@Path("/listaParametrosXIdPadreToIdParamTipoServicio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaParametrosXIdPadreToIdParamTipoServicio(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getIDValorPrtParametrosXIdPadreToIdParamTipoServicio();		
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	@GET
	@Path("/listaIDValorMsSisAdmiTemaCapa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaIDValorMsSisAdmiTemaCapa(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getIDValorMsSisAdmiTemaCapa();		
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	@GET
	@Path("/listaIDValorMsSisAdmiBksss")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaIDValorMsSisAdmiBksss(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getIDValorMsSisAdmiBksss();		
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	@GET
	@Path("/listaIDValorMsUserTemaCapaBySedeBySisAdm/{idSede}/{idSistAdm}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaIDValorMsUserTemaCapaBySedeBySisAdm(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString, 
																@PathParam("idSede") Long idSede,
																@PathParam("idSistAdm") Long idSistAdm) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getIDValorMsUserTemaCapaBySedeBySisAdm(idSede, idSistAdm);
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	@GET
	@Path("/listaIDValorMsUserBySedeBySisAdm/{idSede}/{idSistAdm}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaIDValorMsUserBySedeBySisAdm(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString, 
																@PathParam("idSede") Long idSede,
																@PathParam("idSistAdm") Long idSistAdm) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getIDValorMsUserBySedeBySisAdm(idSede, idSistAdm);
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	@GET
	@Path("/listaMsEstado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaMsEstado(@Context HttpServletRequest req, 
																@Context HttpServletResponse res,
																@HeaderParam("authorization") String authString) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getParametroPorIdPadreToCombo(1L);		
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	
	
	
	
	
	

}
