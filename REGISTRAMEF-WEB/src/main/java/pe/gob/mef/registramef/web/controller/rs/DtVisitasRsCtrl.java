package pe.gob.mef.registramef.web.controller.rs;
 // PURIBE 14032024 - INICIO -->
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
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;
import pe.gob.mef.registramef.web.rs.reporte.StyleUtils;

@Path("/ctrldtVisitas")
public class DtVisitasRsCtrl {

	@Autowired
	private Servicio servicio = null;

	public DtVisitasRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/listadtVisitas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarDtVisitas(@Context HttpServletRequest req, @Context HttpServletResponse res,
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.DTVISITAS_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			String sorder = req.getParameter("order");
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			// PURIBE 01022024 - INICIO-->
			String fechaVisita = req.getParameter("fechaVisita");
			String idOrigen = req.getParameter("idOrigen");
			String idProgramacion = req.getParameter("idProgramacion");
			String idModalidad = req.getParameter("idModalidad");
			String idTipo = req.getParameter("idTipo");
			String idLugar = req.getParameter("idLugar");
			String idEntidad = req.getParameter("idEntidad");
			String idSede = req.getParameter("idSede");
			String idSistAdm = req.getParameter("idSistAdm");
			String idFinancia = req.getParameter("idFinancia");
			String fechaProgramada = req.getParameter("fechaProgramada");

			String idSistAdmTxt = req.getParameter("idSistAdmTxt");
			String idSedeTxt = req.getParameter("idSedeTxt");
			String idOrigenTxt = req.getParameter("idOrigenTxt");
			String idProgramacionTxt = req.getParameter("idProgramacionTxt");
			String idVisita = req.getParameter("idVisita");

			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDateIni = sdff.parse(req.getParameter("fechaInicio"));
			Date fechaDateFin = sdff.parse(req.getParameter("fechaFin"));

			Timestamp fechaInicio = new Timestamp(fechaDateIni.getTime());
			Timestamp fechaFin = new Timestamp(fechaDateFin.getTime());

			String Departamento = req.getParameter("Departamento");
			String Entidad = req.getParameter("Entidad");
//			String Participante = req.getParameter("participante");
			String Participante = req.getParameter("idParticipanteTxt"); // PURIBE 29032024 - INICIO-->

			String sestado = req.getParameter("estado");
			
			int reload = Integer.parseInt(req.getParameter("reload"));
			int programada = Integer.parseInt(req.getParameter("programada"));

			Integer iestado = null;
			if (sestado != null) {
				try {
					iestado = Integer.parseInt(sestado);
				} catch (Exception e) {
				}
			}

			DtVisitasFiltro dtVisitasFiltro = new DtVisitasFiltro(fechaVisita, idOrigen, idProgramacion, idModalidad,
					idTipo, idLugar, idEntidad, idSede, idSistAdm, idFinancia, fechaProgramada, iestado, idSistAdmTxt,
					idSedeTxt, idOrigenTxt, idProgramacionTxt, idVisita);

			DtVisitasData dtVisitasData = (DtVisitasData) req.getSession().getAttribute("DtVisitasData");
			if (dtVisitasData == null) {
				dtVisitasData = new DtVisitasData();
				req.getSession().setAttribute("DtVisitasData", dtVisitasData);
			}
			// PURIBE 01022024 - FIN-->
			DtVisitasLC dtVisitasLC = new DtVisitasLC();
			long inicio = System.currentTimeMillis();
			
			//puribe
			List<DtVisitasBk> dtVisitasSinfiltro = dtVisitasData.getDtVisitasActivos(servicio,
					msUsuariosBk.getIdusuario(),fechaInicio,fechaFin,reload,programada);
			//puribe
			//puribe
			// PURIBE 29032024 - INICIO-->
						List<DtVisitasBk> dtVisitassss = dtVisitasSinfiltro.stream()
								.filter(registro -> Departamento == null || Departamento.isEmpty()
										|| registro.getIdSedeTxt().toLowerCase().contains(Departamento.toLowerCase()))
								.filter(registro -> Entidad == null || Entidad.isEmpty()
										|| registro.getIdEntidadTxt().toLowerCase().contains(Entidad.toLowerCase()))
								.filter(registro -> Participante == null || Participante.isEmpty()
										|| contieneCoincidencia(registro.getIdParticipanteTxt(), Participante))
								.collect(Collectors.toList());
						// PURIBE 29032024 - FIN-->
			//puribe
			long lfinal = System.currentTimeMillis() - inicio;
			dtVisitasLC.setTiempoenBD(lfinal);

			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTVISITAS_CREA)) {
				dtVisitasLC.setCreamodifica(true);
			}

			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtVisitasBk> dtVisitassssData = new ArrayList<DtVisitasBk>();
			if (dtVisitasFiltro.isActivo()) {
				// filter
				// int contador = 0;
				for (DtVisitasBk dtVisitasAct : dtVisitassss) {
					boolean match = true;
					Field camposdea[] = dtVisitasFiltro.getClass().getDeclaredFields();
					// if(dtVisitasAct.getIdVisita.longValue()==56L){
					// System.out.println("AQUI....");
					// }
					for (int i = 0; i < camposdea.length; i++) {
						// contador++;
						// System.out.println("Contador");
						String camponame = camposdea[i].getName();
						if (camponame.indexOf("serial") > -1 || camponame.indexOf("activo") > -1)
							continue;

						String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))
								+ camponame.substring(1);
						String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))
								+ camponame.substring(1);
						Class<?>[] types = new Class[] {};
						try {
							Method filtroMethod = dtVisitasFiltro.getClass().getMethod(filtroGetMetod, types);
							Object filtroValue = filtroMethod.invoke(dtVisitasFiltro, new Object[0]);
							if (filtroValue == null)
								continue;
							else if (filtroValue.toString().length() < 1)
								continue;
							Method claseMethod = dtVisitasAct.getClass().getMethod(claseGetMetod, types);
							Object claseValue = claseMethod.invoke(dtVisitasAct, new Object[0]);
							if (claseValue != null) {
								if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
									String claseValueTxt = sdf.format(claseValue);
									String filterValueString = filtroValue.toString();
									if (filterValueString.trim().length() < 1) {
										continue;
									}
									if (filterValueString.contains("-")) {
										filterValueString = filterValueString.replace("-", "");
									}
									if (claseValueTxt.contains(filterValueString)) { // PURIBE 29032024 - INICIO-->
										match = true;
									} else {
										match = false;
										break;
									}
								} else {
									String claseValueTxt = String.valueOf(claseValue).toLowerCase();
									String filterValueString = filtroValue.toString().toLowerCase();
									if (filterValueString.startsWith("*")) {
										filterValueString = filterValueString.substring(1);
										if (claseValueTxt.contains(filterValueString)) {
											match = true;
										} else {
											match = false;
											break;
										}
									} else {
										if (claseValueTxt.contains(filterValueString)) {// PURIBE 29032024 - INICIO-->
											match = true;
										} else {
											match = false;
											break;
										}
									}
								}
							} else {
								match = false;
								break;
							}
						} catch (NoSuchMethodException exception) {
							System.out.println("Error Exception: " + exception.getMessage());
							continue;
						} catch (Exception exception) {
							System.out.println("Error Exception: " + exception.getMessage());
							continue;
						}
					}
					if (match) {
						dtVisitassssData.add(dtVisitasAct);
					}
				}
			} else {
				dtVisitassssData = dtVisitassss;
			}
			// sort
			// System.setProperty("java.util.Arrays.useLegacyMergeSort",
			// "true");
			if (sorder != null && sorder.trim().length() > 1) {
				Collections.sort(dtVisitassssData, new Comparator<DtVisitasBk>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtVisitasBk dtVisitas1, DtVisitasBk dtVisitas2) {
						boolean sortorden = true;
						String order = sorder;
						if (order.startsWith("-")) {
							sortorden = false;
							order = order.substring(1);
						}
						try {
							String getMetod = "get" + Character.toUpperCase(order.charAt(0)) + order.substring(1);
							Class<?>[] types = new Class[] {};
							Method method = DtVisitasBk.class.getMethod(getMetod, types);
							Object value1 = method.invoke(dtVisitas1, new Object[0]);
							Object value2 = method.invoke(dtVisitas2, new Object[0]);
							if (value1 == null && value2 == null)
								return 0;
							else if (value1 == null)
								return 1;
							else if (value2 == null)
								return -1;
							int value = ((Comparable) value1).compareTo(value2);
							return sortorden ? value : -1 * value;
						} catch (Exception e) {
							return 0;
						}
					}
				});
			}

			// rowCount
			int dataSize = dtVisitassssData.size();
			int pageSize = 100;
			try {
				if (slimit != null && slimit.trim().length() > 0) {
					pageSize = Integer.parseInt(slimit);
				}
				if (pageSize < 0)
					pageSize *= -1;
			} catch (Exception e) {
			}
			int first = 1;
			try {
				if (spage != null && spage.trim().length() > 0) {
					first = Integer.parseInt(spage);
				}
				if (first < 0)
					first *= -1;
			} catch (Exception e) {
			}

			// paginate
			dtVisitasLC.setContador(dataSize);

			if (dataSize > pageSize) {
				int iniciodelista = ((first - 1) * pageSize);
				try {
					dtVisitasLC.setData(dtVisitassssData.subList(iniciodelista, iniciodelista + pageSize));
				} catch (IndexOutOfBoundsException e) {
					dtVisitasLC.setData(dtVisitassssData.subList(iniciodelista, iniciodelista + (dataSize % pageSize)));
				}
			} else {
				dtVisitasLC.setData(dtVisitassssData);
			}
			lfinal = System.currentTimeMillis() - inicio;
			System.out.println("EJECUCIÓN EN: " + (lfinal) + " MILISEGUNDOS.");
			dtVisitasLC.setTiempoenproceso(lfinal);
			/////

			GenericEntity<DtVisitasLC> registrosx = new GenericEntity<DtVisitasLC>(dtVisitasLC) {
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

	// PURIBE
	@GET
	@Path("/buscarcodejec/{codigoEjecutora}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaInstitucionesXCodEjec(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, @PathParam("codigoEjecutora") String codigoEjecutora) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

   		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.DTVISITAS_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			
			Long sprogramada = Long.parseLong(req.getParameter("programada"));
			Long soferta = Long.parseLong(req.getParameter("oferta"));
			
			List<DtEntidadesDto> msInstitucionesDtosss= servicio.getMsInstitucionesXCodigoEjecutora(codigoEjecutora,msUsuariosBk.getIdSistAdmi()); //PURIBE 14032024 - INICIO-->
			boolean isFound = true;
			if (msInstitucionesDtosss != null && msInstitucionesDtosss.size() > 0) {

				Long idProgramacion = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
				Long idOrigen = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDORIGEN_OFERTA,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDORIGEN_OFERTA);

				
				if(soferta==idOrigen && sprogramada==idProgramacion){
				
					
					if (msInstitucionesDtosss.get(0).getIdEntidad() != null
							&& msInstitucionesDtosss.get(0).getIdEntidad().intValue() > 0) {
						Long sisAdminUser=msUsuariosBk.getIdSistAdmi();
						List<DtEntidadSisAdminBk> dtEntidadSistemaAdminList=servicio.getDtEntidadSisAdminXFiltro(msInstitucionesDtosss.get(0).getIdEntidad(),msUsuariosBk.getIdusuario());
						if(dtEntidadSistemaAdminList!=null && dtEntidadSistemaAdminList.size()>0){
							boolean estaVinculado=false;
							for(DtEntidadSisAdminBk dtEntidadSistemaAdminBkko:dtEntidadSistemaAdminList){
								if(dtEntidadSistemaAdminBkko.getIdSistAdmi()!=null && dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue()>0){
									if(dtEntidadSistemaAdminBkko.getIdSistAdmi().longValue()==sisAdminUser){
										estaVinculado=true;
									}
								}
							}
							if(estaVinculado==false){
								throw new Validador("LA ENTIDAD NO ESTA VINCULADA A SUS SISTEMA ADMINISTRATIVO");
							}
								
							
						}else{
							throw new Validador("LA ENTIDAD NO ESTA VINCULADA A SUS SISTEMA ADMINISTRATIVO");
						}
					  }
					
					
				}
			}
			else {
				throw new Validador("NO SE ENCONTRÓ LA ENTIDAD CON CÓDIGO EJECUTORA");
				
			}

			GenericEntity<List<DtEntidadesDto>> registrosx = new GenericEntity<List<DtEntidadesDto>>(
					msInstitucionesDtosss) {
			};
			return Response.status(200).entity(registrosx).build();
		} catch (Validador e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}


	   @GET
   	@Path("/listaMsInstitucionesIdprovee/{idprovee}")
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response listaMsInstitucionesIdprovee(@Context HttpServletRequest req, @Context HttpServletResponse res,
   			@HeaderParam("authorization") String authString, @PathParam("idprovee") String idprovee) {
       	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   		Principal usuario = req.getUserPrincipal();
   		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

   		if (msUsuariosBk == null)
   			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
   					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
   			}).build();

   		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.DTVISITAS_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

   		try {
   			Long idProgramacion = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
   			Long sprogramada = Long.parseLong(req.getParameter("programada"));
   			
   			List<DtEntidadesBk> datos ;
   			if(sprogramada==idProgramacion){
   			
   			datos= servicio.getMsInstitucionesIdprovee(idprovee,msUsuariosBk.getIdSistAdmi()); 
   			}
   			else
   			{
   				datos =  new ArrayList<DtEntidadesBk>();
   			//activas
   			}
   			
   			GenericEntity<List<DtEntidadesBk>> registrosx = new GenericEntity<List<DtEntidadesBk>>(datos) {
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
       
     //MPINARES 24012023 - FIN
	   
	   
	   @GET
	   	@Path("/listaMsUsuExterno/{documento}")
	   	@Produces(MediaType.APPLICATION_JSON)
	   	public Response listaMsUsuExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
	   			@HeaderParam("authorization") String authString, @PathParam("documento") String documento) {
	       	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	   		Principal usuario = req.getUserPrincipal();
	   		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

	   		if (msUsuariosBk == null)
	   			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
	   					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
	   			}).build();
	
	   		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA) && !req.isUserInRole(Roles.PERFIL_USU_OGC)
	   				&& !req.isUserInRole(Roles.DTVISITAS_CREA) && !req.isUserInRole(Roles.DTVISITAS_VE))// PURIBE 14032024 - INICIO -->
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
						.entity(new GenericEntity<RespuestaError>(
								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
										HttpURLConnection.HTTP_UNAUTHORIZED)) {
						}).build();
	   		
	   		

	   		try {
	   			Long idProgramacion = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
	   			
	   			
	   			
		   			if(documento == null || documento.trim().isEmpty()) {
						throw new Validador("Ingrese documento"); 
					}
				
	   			
	   			List<DtUsuarioExternoBk> datos;
	   			
	   			datos= servicio.getDtUsuarioExternoXFiltro(null,null,null,null,null,null,null,documento,msUsuariosBk.getIdusuario()); 
	   			
	   			if (datos.size()>1)
	   			{
	   				throw new Validador("Se encontro mas de un registro con ese DNI");
	   				
	   			}
	   			else if (datos.size()==0)
	   			{
	   				throw new Validador("DNI  No encontrado");
	   			}
	   			
	   			GenericEntity<DtUsuarioExternoBk> registrosx = new GenericEntity<DtUsuarioExternoBk>(datos.get(0)) {
	   			};
	   			return Response.status(200).entity(registrosx).build();
	   		} catch (Validador e) {
	   			String mensaje = e.getMessage();
	   			System.out.println("ERROR: " + mensaje);
	   			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
	   					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
	   					}).build();
	   		}
	   	}
	       
	
	      
	   //puribe
	   @GET
		@Path("/prtParametros/{idpadre}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response editarPrtParametros(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString,@PathParam("idpadre") Long idPadre) {
			
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
					&& !req.isUserInRole(Roles.DTVISITAS_VE))
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
						}).build();
			
			try {
			//	Long idPadre = PropertiesMg.getSistemLong(
				//		PropertiesMg.KEY_PRTPARAMETROS_IDPARAMLUGARVISITA,
					//	PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMLUGARVISITA);
				
				
				List<PrtParametrosBk> prtParametrosE = servicio.getPrtParametrosXFiltro(idPadre,"",msUsuariosBk.getIdusuario());
				
				  GenericEntity<List<PrtParametrosBk>> registrosx = 
						  new GenericEntity<List<PrtParametrosBk>>(
								  prtParametrosE) {};
				
			
				return Response.status(200).entity(registrosx).build();
			} catch (Exception e) {
				// e.printStackTrace();
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}
	   
	   @GET
	 		@Path("/listausuarios")
	 		@Produces(MediaType.APPLICATION_JSON)
	   public Response listausuarios(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString) {
			
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
					&& !req.isUserInRole(Roles.DTVISITAS_VE))
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
						}).build();
			
			try {
			//	Long idPadre = PropertiesMg.getSistemLong(
				//		PropertiesMg.KEY_PRTPARAMETROS_IDPARAMLUGARVISITA,
					//	PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMLUGARVISITA);
				
				List<MsUsuariosDto>prtUsuariosE = servicio.getMsUsuariosCachee();
				
				  GenericEntity<List<MsUsuariosDto>> registrosx = 
						  new GenericEntity<List<MsUsuariosDto>>(
								  prtUsuariosE) {};
				
				return Response.status(200).entity(registrosx).build();
			} catch (Exception e) {
				// e.printStackTrace();
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}
	   
	   
	   @GET
	 		@Path("/listamstemas/{idsistadmin}") 
	 		@Produces(MediaType.APPLICATION_JSON)
	   public Response listamstemas(@Context HttpServletRequest req, @Context HttpServletResponse res,
				@HeaderParam("authorization") String authString,@PathParam("idsistadmin") Long idsistadmin) {
			
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			Principal usuario = req.getUserPrincipal();
			MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

			if (msUsuariosBk == null)
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
						new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
				}).build();

			if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
					&& !req.isUserInRole(Roles.DTVISITAS_VE))
				return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
						}).build();
			
			try {
			
				List<MsTemaBk> prtUsuariosE = servicio.getMsTemaXFiltro("",idsistadmin,null,msUsuariosBk.getIdusuario());
				
				  GenericEntity<List<MsTemaBk>> registrosx = 
						  new GenericEntity<List<MsTemaBk>>(
								  prtUsuariosE) {};
				
				return Response.status(200).entity(registrosx).build();
			} catch (Exception e) {
				// e.printStackTrace();
				String mensaje = e.getMessage();
				System.out.println("ERROR: " + mensaje);
				return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
						.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
						}).build();
			}
		}
	   
	   //puribe
	
	// PURIBE
	
	@POST
	@Path("/salvardtVisitas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarDtVisitas(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString,DtVisitasJS dtVisitasJS) throws ParseException {
		//DtVisitasJS dtVisitasJS DatosContenedor DatosContenedor
		// DtVisitasJS dtVisitasJS = (DtVisitasJS) data.get("dtVisitasModelo");
		// List<DtVisitasUsuinternosBk> listaUsuarioVisita = (List<DtVisitasUsuinternosBk>) data.get("UsuarioVisita");
		//	DtVisitasBk  dtVisitasC = DatosContenedor.getDtVisitasModelo();
		  //  List<DtVisitasUsuinternosBk> visitaUsuarios = DatosContenedor.getVisitaUsuarios();
		  
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();
		
		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.ADMINISTRADOR_VISITAS_EDITOR) && !req.isUserInRole(Roles.PERFIL_USU_OGC))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		String adressRemoto = getRemoteAdress(req);

	//	DtVisitasBk dtVisitasC = new DtVisitasBk();
	//	FuncionesStaticas.copyPropertiesObject(dtVisitasC, dtVisitasJS);

		try {
			
			Long idProgram = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
		

			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDateIni = sdff.parse(req.getParameter("fechaInicio"));
			Date fechaDateFin = sdff.parse(req.getParameter("fechaFin"));

			Timestamp fechaInicio = new Timestamp(fechaDateIni.getTime());
			Timestamp fechaFin = new Timestamp(fechaDateFin.getTime());
			int programada = Integer.parseInt(req.getParameter("programada"));
			
			//if (dtVisitasBk.getIdProgramacion()!=null && 
				//	dtVisitasBk.getIdProgramacion().compareTo(idProgram)==0 &&
				//	pagOrigen!=null && pagOrigen.compareTo(pagOriProg)==0 ){
				//dtVisitasBk.setFechaVisita(dtVisitasBk.getFechaReprogramable());
			//}
			
			
			if (!(dtVisitasJS.getVisitaUsuarios().size()>0)) {
				throw new Validador("LISTA VACIA DE TEMAS AGENDADOS");
				
			}
			
			DtVisitasBk dtVisitasC = new DtVisitasBk();
			 FuncionesStaticas.copyPropertiesObject(dtVisitasC,dtVisitasJS);
			 dtVisitasC.setIdSede(msUsuariosBk.getIdSede());
			 dtVisitasC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());
			 
			 dtVisitasC.setIdProgramacion(idProgram);
			 
			// if (dtVisitasC.getIdProgramacion()!=null ){
			 dtVisitasC.setFechaProgramada(dtVisitasC.getFechaVisita());
			 dtVisitasC.setFechaFinalizacion(null);
			 

				//}
			// dtVisitasJS.setEditopcion(dtVisitasC.getdtVisitasACL().getEditopcion());
			
			dtVisitasC = servicio.saveorupdateDtVisitasBk(dtVisitasC, msUsuariosBk.getUsername(),
					msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
			// dtVisitasJS = new DtVisitasJS();
			// FuncionesStaticas.copyPropertiesObject(dtVisitasJS, dtVisitasC);
			// dtVisitasJS.setEditopcion(dtVisitasC.getdtVisitasACL().getEditopcion());
			List<DtVisitasUsuinternosBk> ouserVisitJS = new ArrayList<>();
		
			
			
			if (dtVisitasC !=null) {
				// Save Participantes
				for (DtVisitasUsuinternosBk oUserVisit : dtVisitasJS.getVisitaUsuarios()) {
					oUserVisit.setIdVisita(dtVisitasC.getIdVisita());
					DtVisitasUsuinternosBk ouserVisitBK = new DtVisitasUsuinternosBk();
					
					
					ouserVisitBK =servicio.saveorupdateDtVisitasUsuinternosBk(oUserVisit, 
							msUsuariosBk.getUsername(),
							msUsuariosBk.getIdusuario(),
							msUsuariosBk.getIdSede(),
							adressRemoto
							);
					
					ouserVisitJS.add(ouserVisitBK);
				}				
			}
			
			
			DtVisitasData dtVisitasData = (DtVisitasData) req.getSession().getAttribute("DtVisitasData");
			if (dtVisitasData == null) {
				dtVisitasData = new DtVisitasData();
				req.getSession().setAttribute("DtVisitasData", dtVisitasData);
			}
			dtVisitasData.add(servicio, msUsuariosBk.getIdusuario(), dtVisitasC,fechaInicio,fechaFin,programada);
			dtVisitasC.setVisitaUsuarios(ouserVisitJS);

			GenericEntity<DtVisitasBk> registrors = new GenericEntity<DtVisitasBk>(dtVisitasC) {
			};
			return Response.status(200).entity(registrors).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	
	// PURIBE
	
	
	// PURIBE 01022024 - INICIO-->
	//puribe
	@POST
	@Path("/eliminardtVisitas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarDtVisitas(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, List<DtVisitasJS> dtVisitasEL) throws ParseException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (dtVisitasEL == null || dtVisitasEL.size() == 0) {
			//PURIBE 29032024  INICIO-->
			String mensaje = "Seleccione los registros"; 
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
			//PURIBE 29032024  FIN->
		}

		if (msUsuariosBk == null)
			//PURIBE 29032024  INICIO-->
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("Error no tiene autorización a realizar esta operación.", 
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();
		//PURIBE 29032024  FIN->

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.ADMINISTRADOR_VISITAS_EDITOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.PERFIL_USU_OGC)) //PURIBE 14032024 - INICIO-->
			//PURIBE 29032024  INICIO-->
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("Error no tiene autorización para realizar esta operación.", 
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();
				//PURIBE 29032024  FIN-->

		String adressRemoto = getRemoteAdress(req);
		List<DtVisitasBk> dtVisitasCL = new ArrayList<>();

		// FuncionesStaticas.copyPropertiesObject(dtVisitasC, dtVisitasE);

		try {

			for (DtVisitasJS dtVisitasE : dtVisitasEL) {
				DtVisitasBk dtVisitasC = new DtVisitasBk();
				FuncionesStaticas.copyPropertiesObject(dtVisitasC, dtVisitasE);
				dtVisitasCL.add(dtVisitasC);
			}


			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDateIni = sdff.parse(req.getParameter("fechaInicio"));
			Date fechaDateFin = sdff.parse(req.getParameter("fechaFin"));

			Timestamp fechaInicio = new Timestamp(fechaDateIni.getTime());
			Timestamp fechaFin = new Timestamp(fechaDateFin.getTime());
			int programada = Integer.parseInt(req.getParameter("programada"));
			
			servicio.deleteDtVisitas(dtVisitasCL, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(),
					msUsuariosBk.getIdSede(), adressRemoto);

			DtVisitasData dtVisitasData = (DtVisitasData) req.getSession().getAttribute("DtVisitasData");
			if (dtVisitasData == null) {
				dtVisitasData = new DtVisitasData();
				req.getSession().setAttribute("DtVisitasData", dtVisitasData);
			}
			dtVisitasData.refrescar(servicio, msUsuariosBk.getIdusuario(),fechaInicio,fechaFin,programada);

			// GenericEntity<DtVisitasBk> registro = new
			// GenericEntity<DtVisitasBk>(dtVisitasCL) {
			// };
			return Response.status(200).entity(dtVisitasCL).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	//puribe
	// PURIBE 01022024 - FIN-->

	// PURIBE 12022024 - INICIO-->
	//puribe
	@POST
	@Path("/reactivardtVisitas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response reactivarDtVisitas(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtVisitasJS dtVisitasE) throws ParseException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		if (dtVisitasE == null) {
			String mensaje = "SELECCIONE EL REGISTRO";
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}

		String adressRemoto = getRemoteAdress(req);

		try {

			DtVisitasBk dtVisitasC = new DtVisitasBk();
			FuncionesStaticas.copyPropertiesObject(dtVisitasC, dtVisitasE);
			

			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDateIni = sdff.parse(req.getParameter("fechaInicio"));
			Date fechaDateFin = sdff.parse(req.getParameter("fechaFin"));

			Timestamp fechaInicio = new Timestamp(fechaDateIni.getTime());
			Timestamp fechaFin = new Timestamp(fechaDateFin.getTime());
			int programada = Integer.parseInt(req.getParameter("programada"));

			Long idSistemaAdmin = msUsuariosBk.getIdSistAdmi();
			Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
			dtVisitasC.setEstado(estadoNuevo);

			servicio.reactivarDtVisitas(dtVisitasC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(),
					msUsuariosBk.getIdSede(), adressRemoto);

			DtVisitasData dtVisitasData = (DtVisitasData) req.getSession().getAttribute("DtVisitasData");
			if (dtVisitasData == null) {
				dtVisitasData = new DtVisitasData();
				req.getSession().setAttribute("DtVisitasData", dtVisitasData);
			}
			dtVisitasData.refrescar(servicio, msUsuariosBk.getIdusuario(),fechaInicio,fechaFin,programada);

			GenericEntity<DtVisitasBk> registro = new GenericEntity<DtVisitasBk>(dtVisitasC) {
			};
			return Response.status(200).entity(registro).build();
		} catch (Validador e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	//puribe
	// PURIBE 12022024 - FIN-->

	//puribe
	@GET
	@Path("/editardtVisitas/{idVisita}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editarDtVisitas(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, @PathParam("idVisita") Long idVisita) {

		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.DTVISITAS_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			DtVisitasBk dtVisitasE = servicio.getDtVisitasBkXid(idVisita, msUsuariosBk.getIdusuario());
			
			
			dtVisitasE.setVisitaUsuarios(servicio.getDtVisitasUsuinternosXFiltro(idVisita,msUsuariosBk.getIdusuario()));
			
			GenericEntity<DtVisitasBk> registro = new GenericEntity<DtVisitasBk>(dtVisitasE) {
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
	//puribe

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

	static boolean contieneCoincidencia(String cadena, String entidad) {
		// Dividir la cadena en un array utilizando ","
		String[] entidades = cadena.split(",");

		// Verificar cada elemento del array
		for (String item : entidades) {
			// Verificar si el elemento contiene la entidad buscada
			if (item.trim().toLowerCase().contains(entidad.toLowerCase())) {
				return true; // Coincidencia encontrada
			}
		}
		return false; // No se encontró ninguna coincidencia
	}

	private String getClientIpAddress(HttpServletRequest request) {
		String[] IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
				"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
				"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };
		for (String header : IP_HEADER_CANDIDATES) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	/// ADICIONALES

	@GET
	@Path("/listaPrtParametrosIdparametroIdOrigen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdOrigen(@Context HttpServletRequest req,
			@Context HttpServletResponse res, @HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdOrigen();
			GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos) {
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

	@GET
	@Path("/listaPrtParametrosIdparametroIdModalidad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdModalidad(@Context HttpServletRequest req,
			@Context HttpServletResponse res, @HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdModalidad();
			GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos) {
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

	@GET
	@Path("/listaPrtParametrosIdparametroIdTipo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdTipo(@Context HttpServletRequest req,
			@Context HttpServletResponse res, @HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdTipo();
			GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos) {
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

	@GET
	@Path("/listaMsSedesIdSedeIdSede")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaMsSedesIdSedeIdSede(@Context HttpServletRequest req, @Context HttpServletResponse res,
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		try {
			List<IDValorDto> datos = servicio.getMsSedesIdSedeIdSede();
			GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos) {
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

//puribe
	@GET
	@Path("/descargarvista")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response descargarFile(@Context HttpServletRequest req, @Context HttpServletResponse res,
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA)
				&& !req.isUserInRole(Roles.DTVISITAS_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();

		// DESPUES DE VALIDAR valor del filtro if(filtroValue==null) continue;
		// else if(filtroValue.toString().length()<1) continue;
		// filtrosaplicados.append(Messages.getStringToKey("dtVisitas."+camponame)).append("=").append(filtroValue).append("
		// ");
		StringBuffer filtrosaplicados = new StringBuffer();
		boolean primerregistro = true;
		/////////////// IGUAL QUE AL LISTAR
		try {
			String sorder = req.getParameter("order");
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");

			String fechaVisita = req.getParameter("fechaVisita");
			String idOrigen = req.getParameter("idOrigen");
			String idProgramacion = req.getParameter("idProgramacion");
			String idModalidad = req.getParameter("idModalidad");
			String idTipo = req.getParameter("idTipo");
			String idLugar = req.getParameter("idLugar");
			String idEntidad = req.getParameter("idEntidad");
			String idSede = req.getParameter("idSede");
			String idSistAdm = req.getParameter("idSistAdm");
			String idFinancia = req.getParameter("idFinancia");
			String fechaProgramada = req.getParameter("fechaProgramada");

			// PURIBE 01022024 - INICIO-->
			String idSistAdmTxt = req.getParameter("idSistAdmTxt");
			String idSedeTxt = req.getParameter("idSedeTxt");
			String idOrigenTxt = req.getParameter("idOrigenTxt");
			String idProgramacionTxt = req.getParameter("idProgramacionTxt");
			String idVisita = req.getParameter("idVisita");
			
			//puribe
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDateIni = sdff.parse(req.getParameter("fechaInicio"));
			Date fechaDateFin = sdff.parse(req.getParameter("fechaFin"));

			Timestamp fechaInicio = new Timestamp(fechaDateIni.getTime());
			Timestamp fechaFin = new Timestamp(fechaDateFin.getTime());
			int reload = Integer.parseInt(req.getParameter("reload"));
			int programada = Integer.parseInt(req.getParameter("programada"));
			//puribe 

			String sestado = req.getParameter("estado");

			Integer iestado = null;
			if (sestado != null) {
				try {
					iestado = Integer.parseInt(sestado);
				} catch (Exception e) {
				}
			}

			DtVisitasFiltro dtVisitasFiltro = new DtVisitasFiltro(fechaVisita, idOrigen, idProgramacion, idModalidad,
					idTipo, idLugar, idEntidad, idSede, idSistAdm, idFinancia, fechaProgramada, iestado, idSistAdmTxt,
					idSedeTxt, idOrigenTxt, idProgramacionTxt, idVisita);
			// PURIBE 01022024 - FIN-->
			DtVisitasData dtVisitasData = (DtVisitasData) req.getSession().getAttribute("DtVisitasData");
			if (dtVisitasData == null) {
				dtVisitasData = new DtVisitasData();
				req.getSession().setAttribute("DtVisitasData", dtVisitasData);
			}

			DtVisitasLC dtVisitasLC = new DtVisitasLC();
			long inicio = System.currentTimeMillis();
			List<DtVisitasBk> dtVisitassss = dtVisitasData.getDtVisitasActivos(servicio, msUsuariosBk.getIdusuario(),fechaInicio,fechaFin,reload,programada);
			long lfinal = System.currentTimeMillis() - inicio;
			dtVisitasLC.setTiempoenBD(lfinal);

			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTVISITAS_CREA)) {
				dtVisitasLC.setCreamodifica(true);
			}

			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtVisitasBk> dtVisitassssData = new ArrayList<DtVisitasBk>();
			if (dtVisitasFiltro.isActivo()) {
				// filter
				// int contador = 0;
				for (DtVisitasBk dtVisitasAct : dtVisitassss) {
					boolean match = true;
					Field camposdea[] = dtVisitasFiltro.getClass().getDeclaredFields();
					// if(dtVisitasAct.getIdVisita.longValue()==56L){
					// System.out.println("AQUI....");
					// }
					for (int i = 0; i < camposdea.length; i++) {
						// contador++;
						// System.out.println("Contador");
						String camponame = camposdea[i].getName();
						if (camponame.indexOf("serial") > -1 || camponame.indexOf("activo") > -1)
							continue;

						String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))
								+ camponame.substring(1);
						String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))
								+ camponame.substring(1);
						Class<?>[] types = new Class[] {};
						try {
							Method filtroMethod = dtVisitasFiltro.getClass().getMethod(filtroGetMetod, types);
							Object filtroValue = filtroMethod.invoke(dtVisitasFiltro, new Object[0]);
							if (filtroValue == null)
								continue;
							else if (filtroValue.toString().length() < 1)
								continue;

							if (primerregistro)
								filtrosaplicados.append(Messages.getStringToKey("dtVisitas." + camponame)).append("=")
										.append(filtroValue).append(" ");

							Method claseMethod = dtVisitasAct.getClass().getMethod(claseGetMetod, types);
							Object claseValue = claseMethod.invoke(dtVisitasAct, new Object[0]);
							if (claseValue != null) {
								if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
									String claseValueTxt = sdf.format(claseValue);
									String filterValueString = filtroValue.toString();
									if (filterValueString.trim().length() < 1) {
										continue;
									}
									if (filterValueString.contains("-")) {
										filterValueString = filterValueString.replace("-", "");
									}
									if (claseValueTxt.startsWith(filterValueString)) {
										match = true;
									} else {
										match = false;
										break;
									}
								} else {
									String claseValueTxt = String.valueOf(claseValue).toLowerCase();
									String filterValueString = filtroValue.toString().toLowerCase();
									if (filterValueString.startsWith("*")) {
										filterValueString = filterValueString.substring(1);
										if (claseValueTxt.contains(filterValueString)) {
											match = true;
										} else {
											match = false;
											break;
										}
									} else {
										if (claseValueTxt.startsWith(filterValueString)) {
											match = true;
										} else {
											match = false;
											break;
										}
									}
								}
							} else {
								match = false;
								break;
							}
						} catch (NoSuchMethodException exception) {
							System.out.println("Error Exception: " + exception.getMessage());
							continue;
						} catch (Exception exception) {
							System.out.println("Error Exception: " + exception.getMessage());
							continue;
						}
					}
					if (match) {
						dtVisitassssData.add(dtVisitasAct);
					}
					primerregistro = false;
				}
			} else {
				dtVisitassssData = dtVisitassss;
			}
			// sort
			// System.setProperty("java.util.Arrays.useLegacyMergeSort",
			// "true");
			if (sorder != null) {
				Collections.sort(dtVisitassssData, new Comparator<DtVisitasBk>() {
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtVisitasBk dtVisitas1, DtVisitasBk dtVisitas2) {
						boolean sortorden = true;
						String order = sorder;
						if (order.startsWith("-")) {
							sortorden = false;
							order = order.substring(1);
						}
						try {
							String getMetod = "get" + Character.toUpperCase(order.charAt(0)) + order.substring(1);
							Class<?>[] types = new Class[] {};
							Method method = DtVisitasBk.class.getMethod(getMetod, types);
							Object value1 = method.invoke(dtVisitas1, new Object[0]);
							Object value2 = method.invoke(dtVisitas2, new Object[0]);
							if (value1 == null && value2 == null)
								return 0;
							else if (value1 == null)
								return 1;
							else if (value2 == null)
								return -1;
							int value = ((Comparable) value1).compareTo(value2);
							return sortorden ? value : -1 * value;
						} catch (Exception e) {
							return 0;
						}
					}
				});
			}

			// rowCount
			int dataSize = dtVisitassssData.size();
			int pageSize = 100;
			try {
				if (slimit != null && slimit.trim().length() > 0) {
					pageSize = Integer.parseInt(slimit);
				}
				if (pageSize < 0)
					pageSize *= -1;
			} catch (Exception e) {
			}
			int first = 1;
			try {
				if (spage != null && spage.trim().length() > 0) {
					first = Integer.parseInt(spage);
				}
				if (first < 0)
					first *= -1;
			} catch (Exception e) {
			}

			// paginate
			dtVisitasLC.setContador(dataSize);

			if (dataSize > pageSize) {
				int iniciodelista = ((first - 1) * pageSize);
				try {
					dtVisitasLC.setData(dtVisitassssData.subList(iniciodelista, iniciodelista + pageSize));
				} catch (IndexOutOfBoundsException e) {
					dtVisitasLC.setData(dtVisitassssData.subList(iniciodelista, iniciodelista + (dataSize % pageSize)));
				}
			} else {
				dtVisitasLC.setData(dtVisitassssData);
			}
			lfinal = System.currentTimeMillis() - inicio;
			System.out.println("EJECUCIÓN EN: " + (lfinal) + " MILISEGUNDOS.");
			dtVisitasLC.setTiempoenproceso(lfinal);
			/////
			/////////////// FIN IGUAL QUE AL LISTAR

			/// EXCEL
			ClassLoader classLoader = this.getClass().getClassLoader();
			File plantilla = new File(classLoader.getResource("plantillaexcel.xls").getFile());
			if (!plantilla.exists()) {
				Resource resource = new ClassPathResource("plantillaexcel.xls");
				try {
					plantilla = resource.getFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String tempdir = System.getProperty("java.io.tmpdir");
			if (!(tempdir.endsWith("/") || tempdir.endsWith("\\")))
				tempdir = tempdir + System.getProperty("file.separator");
			File tmpdir = new File(tempdir);
			if (!tmpdir.exists())
				tmpdir.mkdirs();

			Date hoy = new Date(System.currentTimeMillis());
			File temp = new File(tmpdir, "Reporte" + sdf.format(hoy) + ".xls");// File.createTempFile("Reporte"
																				// +
																				// sdf.format(hoy),
																				// ".xls",
																				// tmpdir);
			// temp.deleteOnExit();
			FuncionesStaticas.copyFile(temp, plantilla);

			//////// EXCEL////////
			FileInputStream inputfile = new FileInputStream(temp);
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(inputfile));
			int sheetIndxResumen = wb.getSheetIndex("AT");
			Sheet hoja = wb.getSheetAt(sheetIndxResumen);
			wb.setSheetName(sheetIndxResumen, "RT_" + sdf.format(hoy));
			StyleUtils styleUtils = new StyleUtils(wb);
			String titulo = "VISITAS" + "\nTOTAL DE REGISTROS " + dataSize;

			Row row0 = hoja.getRow(0);
			if (row0 == null) {
				row0 = hoja.createRow(0);
			}
			Cell cellE4 = row0.getCell(4);
			if (cellE4 == null) {
				cellE4 = row0.createCell(4);
			}
			cellE4.setCellValue(titulo);

			Row row3 = hoja.getRow(3);
			if (row3 == null) {
				row3 = hoja.createRow(3);
			}

			Cell cell3D = row3.getCell(3);
			if (cell3D == null) {
				cell3D = row3.createCell(3);
			}
			cell3D.setCellValue(hoy);

			Row row1 = hoja.getRow(1);
			if (row1 == null) {
				row1 = hoja.createRow(1);
			}

			Row row2 = hoja.getRow(2);
			if (row2 == null) {
				row2 = hoja.createRow(2);
			}

			Row row4 = hoja.getRow(4);
			if (row4 == null) {
				row4 = hoja.createRow(4);
			}
			Cell cell4D = row4.getCell(3);
			if (cell4D == null) {
				cell4D = row4.createCell(3);
			}
			cell4D.setCellValue(filtrosaplicados.toString());

			Cell cell0Q = row0.getCell(16);
			if (cell0Q == null) {
				cell0Q = row0.createCell(16);
			}
			Cell cell1Q = row1.getCell(16);
			if (cell1Q == null) {
				cell1Q = row1.createCell(16);
			}
			Cell cell2Q = row2.getCell(16);
			if (cell2Q == null) {
				cell2Q = row2.createCell(16);
			}

			CellStyle cellStyleV = cell0Q.getCellStyle();
			CellStyle cellStyleA = cell1Q.getCellStyle();
			CellStyle cellStyleR = cell2Q.getCellStyle();

			/////
			Row row6 = hoja.getRow(6);
			if (row6 == null) {
				row6 = hoja.createRow(6);
			}
			Cell cell6A = row6.getCell(0);
			if (cell6A == null) {
				cell6A = row6.createCell(0);
			}
			CellStyle cellStyleTITULO = cell6A.getCellStyle();
			Row row7 = hoja.getRow(7);
			if (row7 == null) {
				row7 = hoja.createRow(7);
			}
			Cell cell7A = row7.getCell(0);
			if (cell7A == null) {
				cell7A = row7.createCell(0);
			}
			CellStyle cellStyleDATO = cell7A.getCellStyle();

			// PURIBE 29032024 - INICIO
						List<String> caposvista = Arrays.asList("idVisita", "fechaProgramada", "idSistAdmTxt", "idParticipanteTxt",
								"idSedeTxt", "idOrigenTxt", "idProgramacionTxt","estadoTxt");// PURIBE
																					// 01022024
																					// -
																					// INICIO-->
						// PURIBE 29032024 - FIN
			int tituloscontador = 1;
			int titulofilacontador = 6;
			Row rowX = hoja.getRow(titulofilacontador);
			if (rowX == null) {
				rowX = hoja.createRow(titulofilacontador);
			}
			for (String camponame : caposvista) {
				Cell cellxX = rowX.getCell(tituloscontador);
				if (cellxX == null) {
					cellxX = rowX.createCell(tituloscontador);
				}
				cellxX.setCellStyle(cellStyleTITULO);
				cellxX.setCellValue(Messages.getStringToKey("dtVisitas." + camponame));
				tituloscontador++;
			}

			int contador = 7;
			int contadorfor = 1;
			for (DtVisitasBk dtVisitasBk : dtVisitassssData) {
				rowX = hoja.getRow(contador);
				styleUtils.copyRow(wb, hoja, contador, contador + 1, null);

				Cell cellAAX = rowX.getCell(0);
				cellAAX.setCellValue(contadorfor);

				if (dtVisitasBk.getCclase() != null) {
					if (dtVisitasBk.getCclase().equals("cverde")) {
						cellAAX.setCellStyle(cellStyleV);
					} else if (dtVisitasBk.getCclase().equals("camarillo")) {
						cellAAX.setCellStyle(cellStyleA);
					} else if (dtVisitasBk.getCclase().equals("crojo")) {
						cellAAX.setCellStyle(cellStyleR);
					}
				}

				int columna = 1;
				for (String camponame : caposvista) {
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					Class<?>[] types = new Class[] {};
					try {
						Method claseMethod = dtVisitasBk.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtVisitasBk, new Object[0]);
						Cell cellxX = rowX.getCell(columna);
						if (claseValue != null) {
							if (cellxX == null) {
								cellxX = rowX.createCell(columna);
							}
							columna++;
							cellxX.setCellStyle(cellStyleDATO);
							if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
								// PURIBE 01022024 - INICIO
								Timestamp valor = (Timestamp) claseValue;
								// cellxX.setCellValue(valor);
								String fechaformat = FuncionesStaticas.getFechaCorta(valor);
								cellxX.setCellValue(fechaformat);
								// PURIBE 01022024- FIN
							} else if (claseValue.getClass().getName().indexOf("Date") > -1) {
								Date valor = (Date) claseValue;
								cellxX.setCellValue(valor);
							} else if (claseValue.getClass().getName().indexOf("Integer") > -1) {
								Integer valor = (Integer) claseValue;
								cellxX.setCellValue(valor);
							} else if (claseValue.getClass().getName().indexOf("Long") > -1) {
								Long valor = (Long) claseValue;
								cellxX.setCellValue(valor);
							} else if (claseValue.getClass().getName().indexOf("Double") > -1) {
								Double valor = (Double) claseValue;
								cellxX.setCellValue(valor);
							} else if (claseValue.getClass().getName().indexOf("String") > -1) {
								String valor = (String) claseValue;
								cellxX.setCellValue(valor);
							} else {
								String valor = claseValue.toString();
								cellxX.setCellValue(valor);
							}
						} else {
							if (cellxX == null) {
								cellxX = rowX.createCell(columna);
							}
							columna++;
							cellxX.setCellStyle(cellStyleDATO);
							cellxX.setCellValue("");
						}
					} catch (NoSuchMethodException exception) {
						System.out.println("Error Exception: " + exception.getMessage());
						continue;
					} catch (Exception exception) {
						System.out.println("Error Exception: " + exception.getMessage());
						continue;
					}
				}
				contador++;
				contadorfor++;
			}
			////

			//////// FIN EXCEL////////
			inputfile.close();
			FileOutputStream output_file = new FileOutputStream(temp); // Open
			wb.write(output_file); // write changes
			output_file.close(); // close the stream

			ResponseBuilder rb = Response.ok(temp);
			rb.header("Content-Disposition", "attachment; filename=" + temp.getName());
			rb.header("Content-Length", temp.length());
			Response response = rb.build();
			return response;
		} catch (Exception e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
//puribe
// PURIBE 14032024 - FIN-->
	
	 @GET
 	@Path("/listaCoddptos")
 	@Produces(MediaType.APPLICATION_JSON)
 	public Response listaDepartamentos(@Context HttpServletRequest req, @Context HttpServletResponse res,
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

 		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTVISITAS_CREA))
 			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
 					.entity(new GenericEntity<RespuestaError>(
 							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
 									HttpURLConnection.HTTP_UNAUTHORIZED)) {
 					}).build();

 		try {
 			List<IIDValorDto> iDValorDtosss = servicio.getDepartamentosV();
 			GenericEntity<List<IIDValorDto>> registrosx = new GenericEntity<List<IIDValorDto>>(iDValorDtosss) {
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
}
