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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;//INICIO CUSCATA - 18072024
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;//INICIO CUSCATA - 18072024
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
import pe.gob.mef.registramef.bs.transfer.DtEntidadesDto;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.IIDValorDto;
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;//INICIO CUSCATA - 18072024
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;//INICIO CUSCATA - 18072024
import pe.gob.mef.registramef.web.controller.DtAsistenciaData;
import pe.gob.mef.registramef.web.controller.DtCapacitacionData;
import pe.gob.mef.registramef.web.controller.rs.data.DtAnexosJS;//INICIO CUSCATA - 18072024
import pe.gob.mef.registramef.web.controller.rs.data.DtAsistenciaJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtAsistenciaTemasJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtCapaEntidadesJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtCapaTemasJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtCapacitacionJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtCapacitacionLC;
import pe.gob.mef.registramef.web.controller.rs.data.DtEntidadesJS;
import pe.gob.mef.registramef.web.controller.rs.data.ExpedienteJS;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;
import pe.gob.mef.registramef.web.controller.rs.data.UbigeoXDefectoJS;
import pe.gob.mef.registramef.web.rs.reporte.StyleUtils;
import pe.gob.mef.std.bs.web.ws.ConsultasstdProxy;
import pe.gob.mef.std.bs.web.ws.ExpedienteRegWSDto;

@Path("/ctrldtCapacitacion")
public class DtCapacitacionRsCtrl {

	@Autowired
	private Servicio servicio = null;
	
	public DtCapacitacionRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/listadtCapacitacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarDtCapacitacion(
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA) && !req.isUserInRole(Roles.DTCAPACITACION_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			//MPINARES 14022024 - INICIO
		      String fechaInicio = req.getParameter("fechaInicio");
		      String fechaFin = req.getParameter("fechaFin");
		      String idSedeTxt = req.getParameter("idSedeTxt");
		      String entidadesTxt = req.getParameter("entidadesTxt");
		      String idProgramacion = req.getParameter("idProgramacion");
		      
		      String idCapacitacion = req.getParameter("idCapacitacion");
		      String nomEvento = req.getParameter("nomEvento");
		      String idSistAdmTxt = req.getParameter("idSistAdmTxt");
		      String idUsuinternoTxt = req.getParameter("idUsuinternoTxt");
		      String temasTxt = req.getParameter("temasTxt");
		      String flagPubliTxt = req.getParameter("flagPubliTxt");
		      String idModoTxt = req.getParameter("idModoTxt");
		      String estadoTxt = req.getParameter("estadoTxt");
			
			//MPINARES 14022024 - FIN
			
            String sestado = req.getParameter("estado");
            int reload = Integer.parseInt(req.getParameter("reload"));
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}		
			
			int rol=-1;
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC))
			{
				rol =0;
			}else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC))
				{
				rol =1;
					}
			else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))
			{
			rol =2;
			}
			
//			DtCapacitacionFiltro dtCapacitacionFiltro = new DtCapacitacionFiltro(fechaInic,fechaFin,nomEvento,idSistAdm,idUsuinterno,flagPubli,idModalidad,idProgramacion,estado,cantPartic,iestado);
			//MPINARES 14022024 - INICIO
			DtCapacitacionFiltro dtCapacitacionFiltro = new DtCapacitacionFiltro(fechaInicio, fechaFin, idSedeTxt, entidadesTxt, idProgramacion, idCapacitacion, nomEvento, 
					idSistAdmTxt, idUsuinternoTxt, temasTxt, flagPubliTxt, idModoTxt, estadoTxt, iestado);
					//MPINARES 14022024 - FIN
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
			
			DtCapacitacionLC dtCapacitacionLC = new DtCapacitacionLC();
			long inicio = System.currentTimeMillis();
//			List<DtCapacitacionBk> dtCapacitacionsss = dtCapacitacionData.getDtCapacitacionActivos(servicio,msUsuariosBk.getIdusuario());
			List<DtCapacitacionBk> dtCapacitacionsss = dtCapacitacionData.getDtCapacitacionActivos(servicio,msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion, reload, msUsuariosBk.getIdSede(), rol, msUsuariosBk.getIdSistAdmi());
			long lfinal =System.currentTimeMillis()-inicio;
			dtCapacitacionLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTCAPACITACION_CREA)){
				dtCapacitacionLC.setCreamodifica(true);
			}		
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC) 
					|| msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC) || req.isUserInRole(Roles.PRE_PUBLICA_DTCAPACITACION_CREA)){
				dtCapacitacionLC.setPrepublicar(true);
			}
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC) 
					|| msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC) || req.isUserInRole(Roles.ACUMULAR_DTCAPACITACION_CREA)){
				dtCapacitacionLC.setAcumular(true);
			}
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtCapacitacionBk> dtCapacitacionsssData = new ArrayList<DtCapacitacionBk> ();
			if(dtCapacitacionFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtCapacitacionBk dtCapacitacionAct : dtCapacitacionsss){
	            boolean match = true;	            
	            Field camposdea[] = dtCapacitacionFiltro.getClass().getDeclaredFields();
//	            if(dtCapacitacionAct.getIdCapacitacion.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
//					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1 || camponame.indexOf("fechaInicio")>-1 || camponame.indexOf("fechaFin")>-1) continue;//MPINARES 14022024 - INICIO
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtCapacitacionFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtCapacitacionFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
						Method claseMethod = dtCapacitacionAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtCapacitacionAct, new Object[0]);
						if(claseValue!=null){
							if(claseValue.getClass().getName().indexOf("Timestamp") > -1){
								String claseValueTxt = sdf.format(claseValue);
								String filterValueString = filtroValue.toString();
								if(filterValueString.trim().length()<1){
									continue;
								}
								if(filterValueString.contains("-")){
									filterValueString = filterValueString.replace("-","");
								}
    							if (claseValueTxt.startsWith(filterValueString)) {
    								match = true;
    							}else {
    								match = false;
    								break;
    							}
							}else if (claseValue instanceof java.lang.Number) {
									String claseValueTxt = String.valueOf(claseValue).toLowerCase();
									String filterValueString = filtroValue.toString().toLowerCase();
									if(filterValueString.startsWith("*")){
										filterValueString = filterValueString.substring(1);
										if(claseValueTxt.contains(filterValueString)){
											match = true;
										}else{
											match = false;
		    								break;
										}
									}else
									if (claseValueTxt.equals(filterValueString)) {
										match = true;
									} else {
										match = false;
										break;
									}
								}
                                                        else{
								String claseValueTxt = String.valueOf(claseValue).toLowerCase();
								String filterValueString = filtroValue.toString().toLowerCase();
								if(filterValueString.startsWith("*")){
									filterValueString = filterValueString.substring(1);
									if(claseValueTxt.contains(filterValueString)){
										match = true;
									}else{
										match = false;
	    								break;
									}
								}else{
									if(claseValueTxt.startsWith(filterValueString)){
										match = true;
									}else{
										match = false;
	    								break;
									}
								}								
							}
						}else{
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
				if(match) {
					dtCapacitacionsssData.add(dtCapacitacionAct);
	            }	            
	        }}else{
	        	dtCapacitacionsssData = dtCapacitacionsss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null && sorder.trim().length()>1) {
	            Collections.sort(dtCapacitacionsssData, new Comparator<DtCapacitacionBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtCapacitacionBk dtCapacitacion1, DtCapacitacionBk dtCapacitacion2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtCapacitacionBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtCapacitacion1, new Object[0]);
						Object value2 = method.invoke(dtCapacitacion2, new Object[0]);
						if(value1==null && value2==null) return 0;
						else if(value1==null) return 1;
						else if(value2==null) return -1;
						int value = ((Comparable)value1).compareTo(value2);						
						return sortorden ? value : -1 * value;
	                	}catch(Exception e){
	                		return 0;
	                	}
	                }
	            });
	        }
	 
	        //rowCount
	        int dataSize = dtCapacitacionsssData.size();
	        int pageSize = 100;
	        try{
	        	if(slimit!=null && slimit.trim().length()>0){
	        		pageSize = Integer.parseInt(slimit);
	        	}
	        	if(pageSize<0)pageSize*=-1;
	        }catch(Exception e){}
	        int first = 1;
	        try{
	        	if(spage!=null && spage.trim().length()>0){
	        		first = Integer.parseInt(spage);
	        	}
	        	if(first<0)first*=-1;
	        }catch(Exception e){}
	        
	        //paginate
	        dtCapacitacionLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtCapacitacionLC.setData(dtCapacitacionsssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtCapacitacionLC.setData(dtCapacitacionsssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtCapacitacionLC.setData(dtCapacitacionsssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtCapacitacionLC.setTiempoenproceso(lfinal);
			/////			
			
			GenericEntity<DtCapacitacionLC> registrosx = new GenericEntity<DtCapacitacionLC>(dtCapacitacionLC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@POST
	@Path("/salvardtCapacitacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarDtCapacitacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionJS);
		//MPINARES 14022024 - INICIO
				dtCapacitacionC.setIdUsuinterno(msUsuariosBk.getIdusuario());
				dtCapacitacionC.setIdSede(msUsuariosBk.getIdSede());
				dtCapacitacionC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());
				//MPINARES 14022024 - INICIO

		try {
			dtCapacitacionC = servicio.saveorupdateDtCapacitacionBk(dtCapacitacionC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto);
//			dtCapacitacionJS = new DtCapacitacionJS();
//			FuncionesStaticas.copyPropertiesObject(dtCapacitacionJS, dtCapacitacionC);
//			dtCapacitacionJS.setEditopcion(dtCapacitacionC.getdtCapacitacionACL().getEditopcion());
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
//			dtCapacitacionData.add(servicio, msUsuariosBk.getIdusuario(), dtCapacitacionC);//MPINARES 14022024 - INICIO
			
			GenericEntity<DtCapacitacionBk> registrors = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrors).build();
		} catch (Validador e) {
			// e.printStackTrace();
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	//INICIO CUSCATA - 18072024
    @POST
	@Path("/insertarchivo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertArchivo(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtAnexosJS tdAnexosJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
					.entity(new GenericEntity<RespuestaError>(
							new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.",
									HttpURLConnection.HTTP_UNAUTHORIZED)) {
					}).build();


		String sdata = tdAnexosJS.getData().substring(tdAnexosJS.getData().indexOf(";base64,") + 8);
		byte[] data = Base64.getDecoder().decode(sdata);
		String filename = null;
		String rutaFilename = null;
		if (tdAnexosJS.getFilename() == null) {
			if (tdAnexosJS.getIdAnexo() != null && tdAnexosJS.getIdAnexo().longValue() > 0
					&& tdAnexosJS.getIddocumento() != null && tdAnexosJS.getIddocumento().longValue() > 0) {
				filename = FuncionesStaticas.getFileNameSistema(tdAnexosJS.getIddocumento(), tdAnexosJS.getIdAnexo(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede());
			} else {
				filename = FuncionesStaticas.getFileNameTempSistema(msUsuariosBk.getIdusuario(),msUsuariosBk.getIdSede());
			}
			rutaFilename = FuncionesStaticas.getFileNameRutaSistema(filename);
		} else {
			filename = tdAnexosJS.getFilename();
			rutaFilename = FuncionesStaticas.getFileNameRutaSistema(filename);
		}

		try {
			FileOutputStream fos = new FileOutputStream(rutaFilename, true);
			fos.write(data);
			fos.close();

			tdAnexosJS.setData(null);
			tdAnexosJS.setFilename(filename);

			GenericEntity<DtAnexosJS> registrors = new GenericEntity<DtAnexosJS>(tdAnexosJS) {
			};
			return Response.status(200).entity(registrors).build();
		} catch (Exception e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
	@POST
	@Path("/salvardtCapacitacionNoProg")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvardtCapacitacionNoProg(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionJS);
		dtCapacitacionC.setIdUsuinterno(msUsuariosBk.getIdusuario());
		dtCapacitacionC.setIdSede(msUsuariosBk.getIdSede());
		dtCapacitacionC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());

		try {
			
			Long idProgramacion = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
			
			/*Long idOrigen = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDORIGEN_DEMANDA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDORIGEN_DEMANDA);
			//SPRINT60 INICIO
			Long pagOrigen = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PAGINA_ORIGEN_NO_PROGRAMADO,
					PropertiesMg.DEFAULT_PAGINA_ORIGEN_NO_PROGRAMADO);*/
			
			dtCapacitacionC.setIdProgramacion(idProgramacion);
			
			
			List<DtAnexosJS> tdAnexosJSsss = dtCapacitacionJS.getTdAnexosJSss();
			List<DtAnexoBk> tdAnexosBkss = null;
			if (tdAnexosJSsss != null && !tdAnexosJSsss.isEmpty()) {
				tdAnexosBkss = new ArrayList<DtAnexoBk>();
				for (DtAnexosJS tdAnexosJS : tdAnexosJSsss) {
					DtAnexoBk tdAnexosBk = new DtAnexoBk();
					
					FuncionesStaticas.copyPropertiesObject(tdAnexosBk, tdAnexosJS);
					
					if(tdAnexosJS.isMaterialCapa()){
						tdAnexosBk.setFlagMaterialCapa(1L);
					}else{
						tdAnexosBk.setFlagMaterialCapa(0L);
					}
					
					tdAnexosBkss.add(tdAnexosBk);
				}
			}
			
			dtCapacitacionC = servicio.saveorupdateDtCapacitacionNoProg(dtCapacitacionC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto,tdAnexosBkss);
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
			
			GenericEntity<DtCapacitacionBk> registrors = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrors).build();
		} catch (Validador e) {
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
//FIN CUSCATA - 18072024
	@POST
	@Path("/eliminardtCapacitacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarDtCapacitacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionE);

		try {
			servicio.deleteDtCapacitacion(dtCapacitacionC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			String fechaInicio = req.getParameter("fechaInicio");
			String fechaFin = req.getParameter("fechaFin");
			String idProgramacion = req.getParameter("idProgramacion");
			int rol=-1;
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC))
			{
				rol =0;
			}else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC))
				{
				rol =1;
					}
			else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))
			{
			rol =2;
			}
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
//			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario());
			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion, msUsuariosBk.getIdSede(), rol, msUsuariosBk.getIdSistAdmi());
			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

        @POST
	@Path("/activardtCapacitacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activarDtCapacitacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionE);

		try {
			servicio.activarDtCapacitacion(dtCapacitacionC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			String fechaInicio = req.getParameter("fechaInicio");
			String fechaFin = req.getParameter("fechaFin");
			String idProgramacion = req.getParameter("idProgramacion");
			int rol=-1;
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC))
			{
				rol =0;
			}else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC))
				{
				rol =1;
					}
			else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))
			{
			rol =2;
			}
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
//			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario());
			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion, msUsuariosBk.getIdSede(), rol, msUsuariosBk.getIdSistAdmi());
			
			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
        @POST
	@Path("/eliminarListadtCapacitacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarListaDtCapacitacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, List<Long> dtCapacitacionE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                if(dtCapacitacionE==null || dtCapacitacionE.isEmpty())
			return Response.status(HttpURLConnection.HTTP_NO_CONTENT).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR LA LISTA A ELIMINAR SE ENCUENTRA VACÍA.", HttpURLConnection.HTTP_NO_CONTENT)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		
		try {
			int tamanio = dtCapacitacionE.size();
			for (Long idCapacitacion : dtCapacitacionE) {
				DtCapacitacionBk dtCapacitacionC = servicio.getDtCapacitacionBkXid(idCapacitacion, msUsuariosBk.getIdusuario());
				servicio.deleteDtCapacitacion(dtCapacitacionC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			}
			String fechaInicio = req.getParameter("fechaInicio");
			String fechaFin = req.getParameter("fechaFin");
			String idProgramacion = req.getParameter("idProgramacion");
			int rol=-1;
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC))
			{
				rol =0;
			}else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC))
				{
				rol =1;
					}
			else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))
			{
			rol =2;
			}
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
//			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario());
			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion, msUsuariosBk.getIdSede(), rol, msUsuariosBk.getIdSistAdmi());
                        GenericEntity<String> registro = new GenericEntity<String>("SE ELIMINARON "+tamanio+" REGISTROS.") {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@GET
	@Path("/editardtCapacitacion/{idCapacitacion}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editarDtCapacitacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, @PathParam("idCapacitacion") Long idCapacitacion) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA) && !req.isUserInRole(Roles.DTCAPACITACION_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();	

		try {
			DtCapacitacionBk dtCapacitacionE = servicio.getDtCapacitacionBkXid(idCapacitacion,msUsuariosBk.getIdusuario());
			
			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionE) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Exception e) {
			// e.printStackTrace();
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
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
	
        
        @GET
	@Path("/listaPrtParametrosIdparametroIdModalidad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdModalidad(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {	
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdModalidadCapas();//MPINARES 14022024 - INICIO
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaMsLocalIdLocalIdLocal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaMsLocalIdLocalIdLocal(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
//			List<IDValorDto> datos = servicio.getMsLocalIdLocalIdLocal();	
			List<IDValorDto> datos = servicio.getIDValorMsLocalBksssXSede(msUsuariosBk.getIdSede());
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdModo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdModo(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdModo();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdNivel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdNivel(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdNivel();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdOrigen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdOrigen(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdOrigen();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdPrestacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdPrestacion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdPrestacion();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdTipo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdTipo(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdTipo();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}        
        @GET
	@Path("/listaPrtParametrosIdparametroIdFinancia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdFinancia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdFinancia();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

        @GET
    @Path("/descargarvista")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response descargarFile(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA) && !req.isUserInRole(Roles.DTCAPACITACION_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                     //DESPUES DE VALIDAR valor del filtro if(filtroValue==null) continue; else if(filtroValue.toString().length()<1) continue;
		    //filtrosaplicados.append(Messages.getStringToKey("dtCapacitacion."+camponame)).append("=").append(filtroValue).append(" ");
		    StringBuffer filtrosaplicados = new StringBuffer();
                    boolean primerregistro = true;
                    boolean primerfiltro = true;
            ///////////////IGUAL QUE AL LISTAR
		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			//MPINARES 14022024 - INICIO
	          String fechaInicio = req.getParameter("fechaInicio");
	          String fechaFin = req.getParameter("fechaFin");
	          String idSedeTxt = req.getParameter("idSedeTxt");
	          String entidadesTxt = req.getParameter("entidadesTxt");
	          String idProgramacion = req.getParameter("idProgramacion");
	          
	          String idCapacitacion = req.getParameter("idCapacitacion");
            String nomEvento = req.getParameter("nomEvento");
            String idSistAdmTxt = req.getParameter("idSistAdmTxt");
            String idUsuinternoTxt = req.getParameter("idUsuinternoTxt");
            String temasTxt = req.getParameter("temasTxt");
            String flagPubliTxt = req.getParameter("flagPubliTxt");
            String idModoTxt = req.getParameter("idModoTxt");
            String estadoTxt = req.getParameter("estadoTxt");
	        //MPINARES 14022024 - INICIO
			
            String sestado = req.getParameter("estado");
            int reload = Integer.parseInt(req.getParameter("reload"));
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}	
			
			int rol=-1;
			if (req.isUserInRole(Roles.ADMINISTRADOR) || msUsuariosBk.getPerfil().contains(Roles.PERFIL_USU_OGC))
			{
				rol =0;
			}else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_GC))
				{
				rol =1;
					}
			else if (msUsuariosBk.getPerfil().contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))
			{
			rol =2;
			}
			
//			DtCapacitacionFiltro dtCapacitacionFiltro = new DtCapacitacionFiltro(fechaInic,fechaFin,nomEvento,idSistAdm,idUsuinterno,flagPubli,idModalidad,idProgramacion,estado,cantPartic,iestado);
			//MPINARES 14022024 - INICIO
            DtCapacitacionFiltro dtCapacitacionFiltro = new DtCapacitacionFiltro(fechaInicio, fechaFin, idSedeTxt, entidadesTxt, "", idCapacitacion, nomEvento, 
                            idSistAdmTxt, idUsuinternoTxt, temasTxt, flagPubliTxt, idModoTxt, estadoTxt, iestado);
                            //MPINARES 14022024 - FIN	
			
			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
			if(dtCapacitacionData==null){
				dtCapacitacionData = new DtCapacitacionData();
				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
			}
			
			DtCapacitacionLC dtCapacitacionLC = new DtCapacitacionLC();
			long inicio = System.currentTimeMillis();
//			List<DtCapacitacionBk> dtCapacitacionsss = dtCapacitacionData.getDtCapacitacionActivos(servicio,msUsuariosBk.getIdusuario());
			List<DtCapacitacionBk> dtCapacitacionsss = dtCapacitacionData.getDtCapacitacionActivos(servicio,msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion, reload, msUsuariosBk.getIdSede(), rol, msUsuariosBk.getIdSistAdmi());//MPINARES 14022024 - INICIO
			long lfinal =System.currentTimeMillis()-inicio;
			dtCapacitacionLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTCAPACITACION_CREA)){
				dtCapacitacionLC.setCreamodifica(true);
			}			
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtCapacitacionBk> dtCapacitacionsssData = new ArrayList<DtCapacitacionBk> ();
			if(dtCapacitacionFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtCapacitacionBk dtCapacitacionAct : dtCapacitacionsss){
	            boolean match = true;	            
	            Field camposdea[] = dtCapacitacionFiltro.getClass().getDeclaredFields();
//	            if(dtCapacitacionAct.getIdCapacitacion.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
//					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1 || camponame.indexOf("fechaInicio")>-1 || camponame.indexOf("fechaFin")>-1) continue;//MPINARES 14022024 - INICIO
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtCapacitacionFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtCapacitacionFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
                                                
                                                if(primerregistro){
                                                	if(primerfiltro){
                                                		filtrosaplicados.append(Messages.getStringToKey("dtCapacitacion."+camponame)).append("=").append(filtroValue).append(" ");
                                                		primerfiltro=false;
                                                	}else{
                                                		filtrosaplicados.append(", ").append(Messages.getStringToKey("dtCapacitacion."+camponame)).append("=").append(filtroValue).append(" ");
                                                	}
                                                		
                                                	
                                                }
                                                

						Method claseMethod = dtCapacitacionAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtCapacitacionAct, new Object[0]);
						if(claseValue!=null){
							if(claseValue.getClass().getName().indexOf("Timestamp") > -1){
								String claseValueTxt = sdf.format(claseValue);
								String filterValueString = filtroValue.toString();
								if(filterValueString.trim().length()<1){
									continue;
								}
								if(filterValueString.contains("-")){
									filterValueString = filterValueString.replace("-","");
								}
    							if (claseValueTxt.startsWith(filterValueString)) {
    								match = true;
    							}else {
    								match = false;
    								break;
    							}
							}else if (claseValue instanceof java.lang.Number) {
									String claseValueTxt = String.valueOf(claseValue).toLowerCase();
									String filterValueString = filtroValue.toString().toLowerCase();
									if(filterValueString.startsWith("*")){
										filterValueString = filterValueString.substring(1);
										if(claseValueTxt.contains(filterValueString)){
											match = true;
										}else{
											match = false;
		    								break;
										}
									}else
									if (claseValueTxt.equals(filterValueString)) {
										match = true;
									} else {
										match = false;
										break;
									}
								}
                                                        else{
								String claseValueTxt = String.valueOf(claseValue).toLowerCase();
								String filterValueString = filtroValue.toString().toLowerCase();
								if(filterValueString.startsWith("*")){
									filterValueString = filterValueString.substring(1);
									if(claseValueTxt.contains(filterValueString)){
										match = true;
									}else{
										match = false;
	    								break;
									}
								}else{
									if(claseValueTxt.startsWith(filterValueString)){
										match = true;
									}else{
										match = false;
	    								break;
									}
								}								
							}
						}else{
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
				if(match) {
					dtCapacitacionsssData.add(dtCapacitacionAct);
	                        }
                        primerregistro = false;
	        }}else{
	        	dtCapacitacionsssData = dtCapacitacionsss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null) {
	            Collections.sort(dtCapacitacionsssData, new Comparator<DtCapacitacionBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtCapacitacionBk dtCapacitacion1, DtCapacitacionBk dtCapacitacion2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtCapacitacionBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtCapacitacion1, new Object[0]);
						Object value2 = method.invoke(dtCapacitacion2, new Object[0]);
						if(value1==null && value2==null) return 0;
						else if(value1==null) return 1;
						else if(value2==null) return -1;
						int value = ((Comparable)value1).compareTo(value2);						
						return sortorden ? value : -1 * value;
	                	}catch(Exception e){
	                		return 0;
	                	}
	                }
	            });
	        }
	 
	        //rowCount
	        int dataSize = dtCapacitacionsssData.size();
	        int pageSize = 100;
	        try{
	        	if(slimit!=null && slimit.trim().length()>0){
	        		pageSize = Integer.parseInt(slimit);
	        	}
	        	if(pageSize<0)pageSize*=-1;
	        }catch(Exception e){}
	        int first = 1;
	        try{
	        	if(spage!=null && spage.trim().length()>0){
	        		first = Integer.parseInt(spage);
	        	}
	        	if(first<0)first*=-1;
	        }catch(Exception e){}
	        
	        //paginate
	        dtCapacitacionLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtCapacitacionLC.setData(dtCapacitacionsssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtCapacitacionLC.setData(dtCapacitacionsssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtCapacitacionLC.setData(dtCapacitacionsssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtCapacitacionLC.setTiempoenproceso(lfinal);
			/////			
		///////////////FIN IGUAL QUE AL LISTAR
			
			///EXCEL	 
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
			File temp = new File(tmpdir, "Reporte"+ sdf.format(hoy)+".xls");//File.createTempFile("Reporte" + sdf.format(hoy), ".xls", tmpdir);
//			temp.deleteOnExit();
			FuncionesStaticas.copyFile(temp, plantilla);

			////////EXCEL////////
			FileInputStream inputfile = new FileInputStream(temp);
			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(inputfile));
			int sheetIndxResumen = wb.getSheetIndex("AT");
			Sheet hoja = wb.getSheetAt(sheetIndxResumen);
			wb.setSheetName(sheetIndxResumen, "CAP_" + sdf.format(hoy));
			StyleUtils styleUtils = new StyleUtils(wb);
                        String titulo = "CAPACITACIONES"
			+"\nTOTAL DE REGISTROS "+dataSize;

                        Row row0 = hoja.getRow(0);
			if (row0 == null) {
				row0 = hoja.createRow(0);
			}
			Cell cellE4 = row0.getCell(4);
			if(cellE4==null){
				cellE4 = row0.createCell(4);
			}
			cellE4.setCellValue(titulo);
			
			Row row3 = hoja.getRow(3);
			if (row3 == null) {
				row3 = hoja.createRow(3);
			}
			
			Cell cell3D = row3.getCell(3);
			if(cell3D==null){
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
			if(cell4D==null){
				cell4D = row4.createCell(3);
			}
			cell4D.setCellValue(filtrosaplicados.toString());
			
			Cell cell0Q = row0.getCell(16);
			if(cell0Q==null){
				cell0Q = row0.createCell(16);
			}
			Cell cell1Q = row1.getCell(16);
			if(cell1Q==null){
				cell1Q = row1.createCell(16);
			}
			Cell cell2Q = row2.getCell(16);
			if(cell2Q==null){
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
			if(cell6A==null){
				cell6A = row6.createCell(0);
			}			
			CellStyle cellStyleTITULO = cell6A.getCellStyle();
			Row row7 = hoja.getRow(7);
			if (row7 == null) {
				row7 = hoja.createRow(7);
			}
			Cell cell7A = row7.getCell(0);
			if(cell7A==null){
				cell7A = row7.createCell(0);
			}			
			CellStyle cellStyleDATO = cell7A.getCellStyle();

			List<String> caposvista = Arrays.asList("fechaInic","fechaFin","nomEvento","idSistAdmTxt","idUsuinternoTxt","temasTxt","flagPubliTxt","idModoTxt","estadoTxt");
                        int tituloscontador = 1;
			int titulofilacontador = 6;
			Row rowX = hoja.getRow(titulofilacontador);
			if (rowX == null) {
				rowX = hoja.createRow(titulofilacontador);
			}
			for (String camponame : caposvista) {
				Cell cellxX = rowX.getCell(tituloscontador);
				if(cellxX==null){
					cellxX = rowX.createCell(tituloscontador);
				}
				cellxX.setCellStyle(cellStyleTITULO);
				cellxX.setCellValue(Messages.getStringToKey("dtCapacitacion."+camponame));
				tituloscontador++;
			} 

                        int contador = 7;
			int contadorfor = 1;		
			for (DtCapacitacionBk dtCapacitacionBk : dtCapacitacionsssData) {
				rowX = hoja.getRow(contador);
				styleUtils.copyRow(wb, hoja, contador, contador+1, null);
			
				Cell cellAAX = rowX.getCell(0);
				cellAAX.setCellValue(contadorfor);
				
				if(dtCapacitacionBk.getCclase()!=null){
					if(dtCapacitacionBk.getCclase().equals("cverde")){
						cellAAX.setCellStyle(cellStyleV);
					}else if(dtCapacitacionBk.getCclase().equals("camarillo")){
						cellAAX.setCellStyle(cellStyleA);
					}else if(dtCapacitacionBk.getCclase().equals("crojo")){
						cellAAX.setCellStyle(cellStyleR);
				}}
				
				int columna = 1;
				for (String camponame : caposvista) {
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))+ camponame.substring(1);
			        Class<?>[] types = new Class[] {};
			       try {
				        Method claseMethod = dtCapacitacionBk.getClass().getMethod(claseGetMetod, types);
				        Object claseValue = claseMethod.invoke(dtCapacitacionBk, new Object[0]);
				        Cell cellxX = rowX.getCell(columna);
                                          if (claseValue != null) {                                                
				        	if(cellxX==null){
								cellxX = rowX.createCell(columna);
							}
                                                columna++;
				        	cellxX.setCellStyle(cellStyleDATO);
				        	if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
				        		//MPINARES 14022024 - INICIO
				        		Timestamp valor = (Timestamp) claseValue;				        		
//								cellxX.setCellValue(valor);
								String fechaformat=FuncionesStaticas.getFechaCortaHHMM(valor);
								cellxX.setCellValue(fechaformat);
								//MPINARES 14022024 - FIN
				        	}else if (claseValue.getClass().getName().indexOf("Date") > -1) {
				        		Date valor = (Date) claseValue;
				        		cellxX.setCellValue(valor);
				        	}else if (claseValue.getClass().getName().indexOf("Integer") > -1) {
				        		Integer valor = (Integer) claseValue;
				        		cellxX.setCellValue(valor);
				        	}else if (claseValue.getClass().getName().indexOf("Long") > -1) {
				        		Long valor = (Long) claseValue;
				        		cellxX.setCellValue(valor);
				        	}else if (claseValue.getClass().getName().indexOf("Double") > -1) {
				        		Double valor = (Double) claseValue;
				        		cellxX.setCellValue(valor);
				        	}else if (claseValue.getClass().getName().indexOf("String") > -1) {
				        		String valor = (String) claseValue;
				        		cellxX.setCellValue(valor);
				        	}else{
				        		String valor = claseValue.toString();
				        		cellxX.setCellValue(valor);
				        	}				        	
				        	}else{
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
			
			////////FIN EXCEL////////
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
//			String mensaje = e.getMessage().toUpperCase();
			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
        
      //MPINARES 14022024 - INICIO
        @GET
    	@Path("/listamsSedes")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listamsSedes(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
//    			List<IDValorDto> datos = servicio.getMsSedesIdSedeIdSede();	
    			List<IDValorDto> datos = servicio.getMsSedesIdSedeIdSedeExTodas();
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	} 
        
        @GET
    	@Path("/listaMsTemaIdTemaIdTema")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaMsTemaIdTemaIdTema(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {	
    			
    			List<IDValorDto> datos =new ArrayList<IDValorDto>();
    			if(req.isUserInRole(Roles.ADMINISTRADOR)){
    				datos = servicio.getMsTemaIdTemaIdTema();
    				
    			}else{
    				datos = servicio.getMsTemaIdTemaIdTemaXSisAdmin(msUsuariosBk.getIdSistAdmi());		
    			}
    			
    			
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	} 
        
        @GET
    	@Path("/listaMsSubtemaIdSubtemaIdSubtema/{idTema}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaMsSubtemaIdSubtemaIdSubtema(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, @PathParam("idTema") Long idTema) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		if (idTema == null || idTema.longValue()<= 0)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR SELECCIONE EL TEMA.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getSubTemaByIdSistemaAdminTema(idTema);		
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	} 
        
        
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

    	    if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA) && !req.isUserInRole(Roles.DTCAPACITACION_VE))
    	        return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
    	                .entity(new GenericEntity<RespuestaError>(
    	                        new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
    	                                HttpURLConnection.HTTP_UNAUTHORIZED)) {
    	                }).build();

    	    try {
    	        List<DtEntidadesDto> msInstitucionesDtosss = servicio.getMsInstitucionesXEjecutoraSisAdminSede(codigoEjecutora, msUsuariosBk.getIdSistAdmi(), msUsuariosBk.getIdSede()); // Asegúrate de tener este método en tu servicio
    	        GenericEntity<List<DtEntidadesDto>> registrosx = new GenericEntity<List<DtEntidadesDto>>(
    	                msInstitucionesDtosss) {
    	        };
    	        return Response.status(200).entity(registrosx).build();
    	    } catch (Exception e) {
//    	        String mensaje = e.getMessage().toUpperCase();
    	    	String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
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

    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			List<DtEntidadesBk> datos = servicio.getMsInstitucionesIdSisadminIdsede(idprovee, msUsuariosBk.getIdSistAdmi(), msUsuariosBk.getIdSede());  
    			GenericEntity<List<DtEntidadesBk>> registrosx = new GenericEntity<List<DtEntidadesBk>>(datos) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        @GET
    	@Path("/listaPrtParametrosIdparametroIdPublico")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaPrtParametrosIdparametroIdPublico(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdCargo();	
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        @GET
    	@Path("/situaciontramite/{anio}/{numero}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response situaciontramite(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, @PathParam("anio") Integer anio,
    			@PathParam("numero") String numero) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
//    			String endpointstdventanilla = "http://localhost:8380/tramite/webservice/consultasstd";
    			String endpointstdventanilla = servicio.getEndpointVentanilla();
    			ConsultasstdProxy consultasstdProxy=new ConsultasstdProxy(endpointstdventanilla);
				 ExpedienteRegWSDto expedienteDto=consultasstdProxy.consultaExpedienteReg(anio, numero);
				 
				 ExpedienteJS expedienteJS = new ExpedienteJS();
	    		 FuncionesStaticas.copyPropertiesObject(expedienteJS, expedienteDto);

    			GenericEntity<ExpedienteJS> registrosx = new GenericEntity<ExpedienteJS>(expedienteJS) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			if (mensaje != null && mensaje.contains("expediente cannot be null"))
    				mensaje = "Expediente no encontrado...";
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        @GET
    	@Path("/listaProcedeEjecucion")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaProcedeEjecucion(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getListaProcedeEjecucion();	
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaPrtParametrosIdparametroIdTipoEntidad")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaPrtParametrosIdparametroIdTipoEntidad(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdTipoEntidad();			
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaPrtParametrosIdparametroIdCaracteristica")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaPrtParametrosIdparametroIdCaracteristica(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdCaract();		
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaPaises")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaPaises(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();


    		try {
    			List<IDValorDto> iDValorDtosss = servicio.getListaMsPaisesActivos();
    			GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(iDValorDtosss) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaCoddptos")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaDepartamentos(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			List<IIDValorDto> iDValorDtosss = servicio.getDepartamentosV();
    			GenericEntity<List<IIDValorDto>> registrosx = new GenericEntity<List<IIDValorDto>>(iDValorDtosss) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaCodprov/{coddptos}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaProvincias(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, @PathParam("coddptos") Integer coddptos) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			List<IIDValorDto> iDValorDtosss = servicio.getProvinciasV(coddptos);
    			GenericEntity<List<IIDValorDto>> registrosx = new GenericEntity<List<IIDValorDto>>(iDValorDtosss) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listaCoddist/{coddptos}/{codprov}")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listaDistritos(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, @PathParam("coddptos") Integer coddptos,
    			@PathParam("codprov") Integer codprov) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			List<IIDValorDto> iDValorDtosss = servicio.getDistritosV(coddptos, codprov);
    			GenericEntity<List<IIDValorDto>> registrosx = new GenericEntity<List<IIDValorDto>>(iDValorDtosss) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @POST
    	@Path("/salvardtEntidades")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response salvardtEntidades(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtEntidadesJS dtEntidadesJS) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		String adressRemoto = getRemoteAdress(req);

    		DtEntidadesBk dtEntidadesC = new DtEntidadesBk();
    		FuncionesStaticas.copyPropertiesObject(dtEntidadesC, dtEntidadesJS);
    		dtEntidadesC.setRtmaddress(adressRemoto);
    		dtEntidadesC.setRtmaddressrst(adressRemoto);
//    		dtEntidadesC.setEstado(3L);

    		try {
    			dtEntidadesC = servicio.saveorupdateDtEntidadesBk(dtEntidadesC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), 
    					msUsuariosBk.getIdSistAdmi(), adressRemoto);
    			GenericEntity<DtEntidadesBk> registrors = new GenericEntity<DtEntidadesBk>(dtEntidadesC) {
    			};
    			return Response.status(200).entity(registrors).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/ubigeodefecto")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response ubigeoXDefecto(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			Long xDefectoCodpais = servicio.getxDefectoCodpais();
    			Integer xDefectoCoddpto = servicio.getxDefectoCoddpto();
    			Integer xDefectoCodprov = servicio.getxDefectoCodprov();
    			Integer xDefectoCoddist = servicio.getxDefectoCoddist();
    			UbigeoXDefectoJS ubigeoXDefectoJS = new UbigeoXDefectoJS(xDefectoCodpais, xDefectoCoddpto, xDefectoCodprov,
    					xDefectoCoddist);
    			GenericEntity<UbigeoXDefectoJS> registrosx = new GenericEntity<UbigeoXDefectoJS>(ubigeoXDefectoJS) {
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @GET
    	@Path("/listamsSisAdmin")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response listamsSisAdmin(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {			
    			List<IDValorDto> datos = servicio.getMsSisAdmistrativoIdSistAdmiIdSistAdmi();			
    			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
    			};
    			return Response.status(200).entity(registrosx).build();
    		} catch (Exception e) {
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	} 
        
        
        @POST
    	@Path("/prepublicardtCapacitacionList")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response prepublicardtCapacitacionList(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtCapacitacionBk[] dtCapacitacionEList) {
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
//    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);
    		
    		List<DtCapacitacionBk> dtCapacitacionBklist = Arrays.asList(dtCapacitacionEList);

    		try {
    			
    			for(DtCapacitacionBk dtCapacitacionBka:dtCapacitacionBklist){
    				servicio.prepublicarDtCapacitacion(dtCapacitacionBka,  msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSistAdmi(), adressRemoto);
    				DtCapacitacionBk dtCapacitacionBko=servicio.getDtCapacitacionBkXid(dtCapacitacionBka.getIdCapacitacion(), msUsuariosBk.getIdusuario());
    				FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionBko);
        		}
    			
    			DtCapacitacionData dtCapacitacionData = new DtCapacitacionData();
    			req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
//    			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
    			
    			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
    			};
    			return Response.status(200).entity(registro).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        @POST
    	@Path("/anulardtCapacitacionList")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response anulardtCapacitacionList(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtCapacitacionBk[] dtCapacitacionEList) {
    		
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
//    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);
    		
    		List<DtCapacitacionBk> dtCapacitacionBklist = Arrays.asList(dtCapacitacionEList);

    		try {
    			
//    			  String fechaInicio = req.getParameter("fechaInicio");
//	  		      String fechaFin = req.getParameter("fechaFin");
//	  		      String idProgramacion = req.getParameter("idProgramacion");
    			
    			for(DtCapacitacionBk dtCapacitacionBka:dtCapacitacionBklist){
    				FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionBka);
    				servicio.deleteDtCapacitacion(dtCapacitacionBka, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSistAdmi(), adressRemoto);
        		}
    			
    			DtCapacitacionData dtCapacitacionData = new DtCapacitacionData();
    			req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
    			
//    			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
//    			if(dtCapacitacionData==null){
//    				dtCapacitacionData = new DtCapacitacionData();
//    				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
//    			}
//    			dtCapacitacionData.refrescar(servicio, msUsuariosBk.getIdusuario(),fechaInicio, fechaFin, idProgramacion);
    			
    			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
    			};
    			return Response.status(200).entity(registro).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        
        @POST
    	@Path("/validacmularCapacitacionList")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response validacmularCapacitacionList(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtCapacitacionBk[] dtCapacitacionEList) {
    		
        	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
//    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);
    		
    		List<DtCapacitacionBk> dtCapacitacionBklist = Arrays.asList(dtCapacitacionEList);

    		try {
    			
    			dtCapacitacionC=servicio.validDtCapacitacionList(dtCapacitacionBklist, msUsuariosBk.getIdusuario());
    			
    			DtCapacitacionData dtCapacitacionData = new DtCapacitacionData();
    			req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
    			
    			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
    			};
    			return Response.status(200).entity(registro).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        @POST
    	@Path("/salvardtCapacitacionAcumula")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response salvardtCapacitacionAcumula(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionJS) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);

    		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
    		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionJS);
    		//MPINARES 14022024 - INICIO
    		dtCapacitacionC.setIdUsuinterno(msUsuariosBk.getIdusuario());
    		dtCapacitacionC.setIdSede(msUsuariosBk.getIdSede());
    		dtCapacitacionC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());
    		//MPINARES 14022024 - INICIO

    		try {
    			dtCapacitacionC = servicio.saveorupdateDtCapacitacionBk(dtCapacitacionC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(),adressRemoto);
//    			dtCapacitacionJS = new DtCapacitacionJS();
//    			FuncionesStaticas.copyPropertiesObject(dtCapacitacionJS, dtCapacitacionC);
//    			dtCapacitacionJS.setEditopcion(dtCapacitacionC.getdtCapacitacionACL().getEditopcion());
    			
    			DtCapacitacionData dtCapacitacionData = (DtCapacitacionData) req.getSession().getAttribute("DtCapacitacionData");
    			if(dtCapacitacionData==null){
    				dtCapacitacionData = new DtCapacitacionData();
    				req.getSession().setAttribute("DtCapacitacionData",dtCapacitacionData);
    			}
//    			dtCapacitacionData.add(servicio, msUsuariosBk.getIdusuario(), dtCapacitacionC);//MPINARES 14022024 - INICIO
    			
    			GenericEntity<DtCapacitacionBk> registrors = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
    			};
    			return Response.status(200).entity(registrors).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        
        @POST
    	@Path("/reactivardtCapacitacion")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response reactivardtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtCapacitacionJS dtCapacitacionE) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtCapacitacionBk dtCapacitacionC = new DtCapacitacionBk();
    		FuncionesStaticas.copyPropertiesObject(dtCapacitacionC, dtCapacitacionE);

    		try {
    			servicio.reactivarDtCapacitacion(dtCapacitacionC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSistAdmi(), adressRemoto);
    			
    			DtAsistenciaData dtAsistenciaData = new DtAsistenciaData();
    			req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
    			
//    			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
//    			if(dtAsistenciaData==null){
//    				dtAsistenciaData = new DtAsistenciaData();
//    				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
//    			}
//    			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
    			
    			GenericEntity<DtCapacitacionBk> registro = new GenericEntity<DtCapacitacionBk>(dtCapacitacionC) {
    			};
    			return Response.status(200).entity(registro).build();
    		} catch (Validador e) {
    			// e.printStackTrace();
//    			String mensaje = e.getMessage().toUpperCase();
    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
      //MPINARES 14022024 - FIN
        
     // PURIBE 15042024 - INICIO
     			@GET
     			@Path("/loadvalorcrear")
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
     						&& !req.isUserInRole(Roles.DTCAPACITACION_VE) &&!req.isUserInRole(Roles.PERFIL_USU_OGC)
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
     						
     				if (roles.contains(Roles.ADMINISTRADOR) || roles.contains(Roles.PERFIL_ADMINISTRADOR) 
     						|| roles.contains(Roles.DTCAPACITACION_CREA)
     						|| roles.contains(Roles.PERFIL_USU_OGC) || roles.contains(Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT))  {
     								datos.setId(2L);
     								
     							}else {
     								datos.setId(1L);
     							}
     							
     				GenericEntity<IDValorDto> registrosx = new GenericEntity<IDValorDto>(datos) {
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

     			// PURIBE 15042024 - FIN
     			
     			@POST
     	    	@Path("/eliminardtCapaTemas")
     	    	@Produces(MediaType.APPLICATION_JSON)
     	    	public Response eliminardtCapaTemas(@Context HttpServletRequest req, @Context HttpServletResponse res,
     	    			@HeaderParam("authorization") String authString, DtCapaTemasJS dtCapaTemasE) {
     	    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
     	    		Principal usuario = req.getUserPrincipal();
     	    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

     	    		if (msUsuariosBk == null)
     	    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
     	    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
     	    			}).build();

     	    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
     	    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
     	    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
     	    			}).build();
     	    		
     	    		String adressRemoto = getRemoteAdress(req);
     	    		DtCapaTemasBk dtCapaTemasC = new DtCapaTemasBk();
     	    		FuncionesStaticas.copyPropertiesObject(dtCapaTemasC, dtCapaTemasE);

     	    		try {
//     	    			servicio.deleteDtAsistenciaTemas(dtAsistenciaTemasC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
     	    			servicio.deleteDtCapaTemas(dtCapaTemasC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
     	    			
     	    			GenericEntity<DtCapaTemasBk> registro = new GenericEntity<DtCapaTemasBk>(dtCapaTemasC) {
     	    			};
     	    			return Response.status(200).entity(registro).build();
     	    		} catch (Validador e) {
     	    			// e.printStackTrace();
//     	    			String mensaje = e.getMessage().toUpperCase();
     	    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
     	    			System.out.println("ERROR: " + mensaje);
     	    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
     	    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
     	    					}).build();
     	    		}
     	    	}
     			
     			
     			@POST
     	    	@Path("/eliminardtCapaEntidades")
     	    	@Produces(MediaType.APPLICATION_JSON)
     	    	public Response eliminardtCapaEntidades(@Context HttpServletRequest req, @Context HttpServletResponse res,
     	    			@HeaderParam("authorization") String authString, DtCapaEntidadesJS dtCapaEntidadesE) {
     	    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
     	    		Principal usuario = req.getUserPrincipal();
     	    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

     	    		if (msUsuariosBk == null)
     	    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
     	    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
     	    			}).build();

     	    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCAPACITACION_CREA))
     	    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
     	    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
     	    			}).build();
     	    		
     	    		String adressRemoto = getRemoteAdress(req);
     	    		DtCapaEntidadesBk dtCapaEntidadesC = new DtCapaEntidadesBk();
     	    		FuncionesStaticas.copyPropertiesObject(dtCapaEntidadesC, dtCapaEntidadesE);

     	    		try {
//     	    			servicio.deleteDtAsistenciaTemas(dtAsistenciaTemasC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
     	    			servicio.deleteDtCapaEntidades(dtCapaEntidadesC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
     	    			
     	    			GenericEntity<DtCapaEntidadesBk> registro = new GenericEntity<DtCapaEntidadesBk>(dtCapaEntidadesC) {
     	    			};
     	    			return Response.status(200).entity(registro).build();
     	    		} catch (Validador e) {
     	    			// e.printStackTrace();
//     	    			String mensaje = e.getMessage().toUpperCase();
     	    			String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
     	    			System.out.println("ERROR: " + mensaje);
     	    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
     	    					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
     	    					}).build();
     	    		}
     	    	}

}
