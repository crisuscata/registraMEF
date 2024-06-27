// PURIBE 15042024 - INICIO -->
package pe.gob.mef.registramef.web.controller.rs;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors; //PURIBE 01022024 - INICIO-->

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.DtEntidadesDto;//PURIBE
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.IIDValorDto;
import pe.gob.mef.registramef.bs.transfer.MsUsuariosDto;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSisAdminBk;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuinternosBk;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.MsTemaBk;//PURIBE
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg; //PURIBE
import pe.gob.mef.registramef.web.controller.DtVisitasData;
import pe.gob.mef.registramef.web.controller.rs.data.DtVisitasJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtVisitasLC;
import pe.gob.mef.registramef.web.controller.rs.data.LandingJS;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;
import pe.gob.mef.registramef.web.rs.reporte.StyleUtils;

@Path("/ctrldtLanding")
public class DtLandingRsCtrl {

	@Autowired
	private Servicio servicio = null;

	public DtLandingRsCtrl() {
	}

// PURIBE 04042024 - INICIO
		@GET
		@Path("/loadvalorcrearleer")
		@Produces(MediaType.APPLICATION_JSON)
		public Response loadvalorcrear(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString) {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
						.entity(new GenericEntity<RespuestaError>(
								new RespuestaError("Error no tiene autorización para realizar esta operación.",
										HttpURLConnection.HTTP_UNAUTHORIZED)) {
						}).build();
		
			
			if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
					&& !req.isUserInRole(Roles.DTVISITAS_VE) &&!req.isUserInRole(Roles.PERFIL_USU_OGC)
					&& !req.isUserInRole(Roles.PERFIL_GC) && !req.isUserInRole(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT)
					&& !req.isUserInRole(Roles.PERFIL_ADMINISTRADOR))
				
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("Error no tiene autorización para realizar esta operación.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();
				

		try {

			IDValorDto  datos = new IDValorDto();
			List<String> roles = msUsuariosBk.getRolesSistema();
			
			
			LandingJS landingJS = new LandingJS ();

			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTVISITAS_CREA)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setRegistroreunion(true);
							
						}else {
							landingJS.setRegistroreunion(false);
						}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTASISTENCIA_CREA)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setRegistroasistencia(true);
							
						}else {
							landingJS.setRegistroasistencia(false);
						}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTCAPACITACION_CREA)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setRegistrocapacitacion(true);
							
						}else {
							landingJS.setRegistrocapacitacion(false);
						}
						
			
		
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTVISITAS_VE)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setListareunion(true);
							
						}else {
							landingJS.setListareunion(false);
						}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTASISTENCIA_VE)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setListaasistencia(true);
							
						}else {
							landingJS.setListaasistencia(false);
						}
			
			if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
					|| roles.contains(Roles.DTCAPACITACION_VE)
					|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
							landingJS.setListacapacitacion(true);
							
						}else {
							landingJS.setListacapacitacion(false);
						}
			
			GenericEntity<LandingJS> registrosx = new GenericEntity<LandingJS>(landingJS) {
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

		// PURIBE 04042024 - FIN

	
}
//PURIBE 15042024 - FIN-->