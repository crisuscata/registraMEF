package pe.gob.mef.registramef.web.controller.rs;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.web.controller.rs.data.MsUsuariosPerfilJS;
import pe.gob.mef.registramef.web.controller.rs.data.PrtParametrosJS;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;

@Path("/ctrltitulo")
public class TituloRsCtrl {

	@Autowired
	private Servicio servicio = null;
	
	public TituloRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/perfilusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMsUsuarios(
			@Context HttpServletRequest req, 
			@Context HttpServletResponse res,
			@HeaderParam("authorization") String authString			
			) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

//		if (!req.isUserInRole(Roles.ADMINISTRADOR) 
//			&& !req.isUserInRole(Roles.ADMINISTRADOR_USUARIOS))
//			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
//					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
//			}).build();

		try {
			
			MsUsuariosPerfilJS msUsuariosPerfilJS = (MsUsuariosPerfilJS) req.getSession().getAttribute("MsUsuariosPerfilJS");
			if(msUsuariosPerfilJS==null){
				msUsuariosPerfilJS = new MsUsuariosPerfilJS();
				msUsuariosPerfilJS.setIdunidad(msUsuariosBk.getIdSistAdmi());
				msUsuariosPerfilJS.setIdunidadTxt(msUsuariosBk.getIdSistAdmiTxt());
				msUsuariosPerfilJS.setIdusuario(msUsuariosBk.getIdusuario());
				msUsuariosPerfilJS.setNombrecompleto(FuncionesStaticas.getNombreCompleto(msUsuariosBk));
				msUsuariosPerfilJS.setSede(msUsuariosBk.getIdSedeTxt());
				msUsuariosPerfilJS.setUsername(msUsuariosBk.getUsername());
				req.getSession().setAttribute("MsUsuariosPerfilJS",msUsuariosPerfilJS);
			}

			GenericEntity<MsUsuariosPerfilJS> registrosx = new GenericEntity<MsUsuariosPerfilJS>(msUsuariosPerfilJS) {
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
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
		
//		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.ADMINISTRADOR_USUARIOS))
//			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
//					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
//			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		MsUsuariosBk msUsuariosBkC = new MsUsuariosBk();
		FuncionesStaticas.copyPropertiesObject(msUsuariosBkC, msUsuariosBk);
		msUsuariosBkC.setContrasenia(msUsuariosPerfilJS.getContrasenia());
		msUsuariosBkC.setContraseniaConfir(msUsuariosPerfilJS.getContraseniaConfir());
		
		msUsuariosBkC.setRtmaddress(adressRemoto);
		msUsuariosBkC.setRtmaddressmodif(adressRemoto);
		
		try {
			msUsuariosBkC = servicio.saveorupdateMsUsuariosBk(msUsuariosBkC, msUsuariosBk.getUsername(),
					msUsuariosBk.getIdusuario(), null, null, adressRemoto,true);
			
			msUsuariosPerfilJS = new MsUsuariosPerfilJS();
			msUsuariosPerfilJS.setIdunidad(msUsuariosBkC.getIdSede());
			msUsuariosPerfilJS.setIdunidadTxt(msUsuariosBkC.getIdSedeTxt());
			msUsuariosPerfilJS.setIdusuario(msUsuariosBkC.getIdusuario());
			msUsuariosPerfilJS.setNombrecompleto(FuncionesStaticas.getNombreCompleto(msUsuariosBkC));
			msUsuariosPerfilJS.setSede(msUsuariosBkC.getIdSedeTxt());
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

	///ADICIONALES
//	@GET
//	@Path("/listatdPendientes")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response listarPendientesTdAtenciones(@Context HttpServletRequest req, @Context HttpServletResponse res,
//			@HeaderParam("authorization") String authString) {
//		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//
//		Principal usuario = req.getUserPrincipal();
//		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());
//
//		if (msUsuariosBk == null)
//			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
//					.entity(new GenericEntity<RespuestaError>(
//							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
//									HttpURLConnection.HTTP_UNAUTHORIZED)) {
//					}).build();
//
//		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.TDATENCIONES_CREA)
//				&& !req.isUserInRole(Roles.TDATENCIONES_VE) && !req.isUserInRole(Roles.CORDINADOR_AREA)
//				&& !req.isUserInRole(Roles.CORDINADOR_TITULAR_AREA)
//				)
//			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
//					.entity(new GenericEntity<RespuestaError>(
//							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
//									HttpURLConnection.HTTP_UNAUTHORIZED)) {
//					}).build();
//
//		try {
//			TdAtencionesLC tdAtencionesLC = new TdAtencionesLC();
//			long inicio = System.currentTimeMillis();
//			List<TdAtencionesBk> tdAtencionessss = servicio.getTdAtencionesXNuevosEnProceso(msUsuariosBk);			
//			long lfinal = System.currentTimeMillis() - inicio;
//			tdAtencionesLC.setTiempoenBD(lfinal);
//
//			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.TDATENCIONES_CREA)) {
//				tdAtencionesLC.setCreamodifica(true);
//			}
//			// rowCount
//			int dataSize = tdAtencionessss.size();
//			// paginate
//			tdAtencionesLC.setContador(dataSize);
//			tdAtencionesLC.setData(tdAtencionessss);
//			lfinal = System.currentTimeMillis() - inicio;
//			System.out.println("EJECUCIÓN PENDIENTES EN : " + (lfinal) + " MILISEGUNDOS.");
//			tdAtencionesLC.setTiempoenproceso(lfinal);
//			/////
//			GenericEntity<TdAtencionesLC> registrosx = new GenericEntity<TdAtencionesLC>(tdAtencionesLC) {
//			};
//			return Response.status(200).entity(registrosx).build();
//		} catch (Exception e) {
//			String mensaje = e.getMessage();
//			System.out.println("ERROR: " + mensaje);
//			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
//					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
//					}).build();
//		}
//	}
	
	//MPINARES 14022024 - INICIO
		@GET
		@Path("/listaPrtParametrosIdparametroIdTipoServicio")
		@Produces(MediaType.APPLICATION_JSON)
		public Response listaPrtParametrosIdparametroIdTipoServicio(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString) {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			try {			
				List<IDValorDto> datos = servicio.getPrtParametrosIdparametroTipoServicio();	
				   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
				};
				return Response.status(200).entity(registrosx).build();
			} catch (Exception e) {
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}
		//MPINARES 14022024 - FIN
		
		@GET
		@Path("/editarprtParametros/{idparametro}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response editarPrtParametros(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString, @PathParam("idparametro") Long idparametro) {

			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			try {
				// PURIBE 25012024 - INICIO
				if (idparametro == 0) {
					idparametro = Long.parseLong(PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPONOTIFICACION); //PURIBE 29032024 - INICIO

				}
				//PURIBE 29032024 - INICIO
				//	PrtParametrosBk prtParametrosE = servicio.getPrtParametrosBkXid(idparametro, msUsuariosBk.getIdusuario());
					List<PrtParametrosBk> prtParametrosE = servicio.getPrtParametrosXFiltro(idparametro,"",msUsuariosBk.getIdusuario());
					List<PrtParametrosBk> prtParametrosF = new ArrayList();
					//PURIBE 29032024 - FIN

				HttpSession session = req.getSession();

				Object usuarioAttribute = session.getAttribute("usuario");

				if (usuarioAttribute != null) {

					Integer usuarioValue = Integer.parseInt(usuarioAttribute.toString());
					//PURIBE 29032024 - INICIO
					for (PrtParametrosBk PrtParametros : prtParametrosE)
						
					{

						PrtParametros.setNotificacion(usuarioValue);
						prtParametrosF.add(PrtParametros);
					}
					//PURIBE 29032024 - FIN
				} else {
					//PURIBE 29032024 - INICIO
					for (PrtParametrosBk PrtParametros : prtParametrosE)
						
					{

						PrtParametros.setNotificacion(0);
						prtParametrosF.add(PrtParametros);
					}
				}
				// FIN PURIBE 25012024 - INICIO
				// PrtParametrosBk prtParametrosE =
				// servicio.getPrtParametrosBkXid(idparametro,msUsuariosBk.getIdusuario());

				GenericEntity<List<PrtParametrosBk>> registro = new GenericEntity<List<PrtParametrosBk>>(prtParametrosE) {
				};
				//PURIBE 29032024 - FIN
				return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
			} catch (Exception e) {
				// e.printStackTrace();
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
						new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}

		// PURIBE 25012024 - INICIO
		@POST
		@Path("/actualizanotificacion")
		@Produces(MediaType.APPLICATION_JSON)
		public Response actualizanotificacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString, List<PrtParametrosJS> prtParametrosE) { // PURIBE 29032024 - INICIO
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			// PURIBE 29032024 - INICIO
						List<PrtParametrosBk> prtParametrosF = new ArrayList();
						for (PrtParametrosJS prtParametros : prtParametrosE)
						{
						PrtParametrosBk prtParametrosC = new PrtParametrosBk();
						FuncionesStaticas.copyPropertiesObject(prtParametrosC, prtParametros);
						prtParametrosF.add(prtParametrosC);
						}
						// PURIBE 29032024 - FIN

			try {
				// servicio.deletePrtParametros(prtParametrosC,
				// msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(),
				// msUsuariosBk.getIdSede(), adressRemoto);

				// PrtParametrosData prtParametrosData = (PrtParametrosData)
				// req.getSession().getAttribute("PrtParametrosData");

				req.getSession().setAttribute("usuario", 0);
				HttpSession session = req.getSession();
				Object usuarioAttribute = session.getAttribute("usuario");

				if (usuarioAttribute != null) {
					// PURIBE 29032024 - INICIO
					for (PrtParametrosBk prtParametrosbk : prtParametrosF)
					{
					
					Integer usuarioValue = Integer.parseInt(usuarioAttribute.toString());

					prtParametrosbk.setNotificacion(usuarioValue);
					
					}
					// PURIBE 29032024 - FIN
				} else {
					// PURIBE 29032024 - INICIO
					for (PrtParametrosBk prtParametrosbk : prtParametrosF)
					{
					
						prtParametrosbk.setNotificacion(0);
					}
					// PURIBE 29032024 - FIN
				}
				// prtParametrosData.refrescar(servicio,
				// msUsuariosBk.getIdusuario());

				GenericEntity<List<PrtParametrosBk>> registro = new GenericEntity<List<PrtParametrosBk>>(prtParametrosF) { 	// PURIBE 29032024 - INICIO
				};
				return Response.status(200).entity(registro).build();
			} catch (Exception e) {
				// e.printStackTrace();
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
						new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}

		// PURIBE 25012024 - FIN
}
