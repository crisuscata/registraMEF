package pe.gob.mef.registramef.web.controller.rs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
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
import org.apache.poi.xwpf.usermodel.PositionInParagraph;
import org.apache.poi.xwpf.usermodel.TextSegement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
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
import pe.gob.mef.registramef.bs.transfer.DtUsuarioExternoDto;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.bs.transfer.IIDValorDto;
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCargosUsuexterBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.web.controller.DtAsistenciaData;
import pe.gob.mef.registramef.web.controller.rs.data.DtAnexosJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtAsistenciaJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtAsistenciaLC;
import pe.gob.mef.registramef.web.controller.rs.data.DtAsistenciaTemasJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtEntidadesJS;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;
import pe.gob.mef.registramef.web.controller.rs.data.UbigeoXDefectoJS;
import pe.gob.mef.registramef.web.rs.reporte.StyleUtils;
import pe.gob.mef.registramef.web.utils.ZipDirectory;

@Path("/ctrldtAsistencia")
public class DtAsistenciaRsCtrl {

	@Autowired
	private Servicio servicio = null;
	
	public DtAsistenciaRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/listadtAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarDtAsistencia(
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA) && !req.isUserInRole(Roles.DTASISTENCIA_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			//MPINARES 24012023 - INICIO
			String fechaInicio = req.getParameter("fechaInicio");
			String fechaFin = req.getParameter("fechaFin");
//			String idsedeTxt = req.getParameter("idsedeTxt");
			String idSedeTxt = req.getParameter("idSedeTxt");//MPINARES 13022024 - INICIO
			String idEntidadTxt = req.getParameter("idEntidadTxt");
			String idProgramacion = req.getParameter("idProgramacion");
			//MPINARES 24012023 - FIN
			
			//MPINARES 13022024 - INICIO
			String idAsistencia = req.getParameter("idAsistencia");
			String dniUserTxt = req.getParameter("dniUserTxt");
			String usuExtTxt = req.getParameter("usuExtTxt");
			String codEjecutora = req.getParameter("codEjecutora");
			String idUsuinternoTxt = req.getParameter("idUsuinternoTxt");
			String idSistAdmTxt = req.getParameter("idSistAdmTxt");
			String idOrigenTxt = req.getParameter("idOrigenTxt");
			String estadoTxt = req.getParameter("estadoTxt");
			//MPINARES 13022024 - FIN
			
            String sestado = req.getParameter("estado");
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}		
			
//			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(idEntidad,idSede,fechaAsistencia,idUsuinterno,idSistAdm,idOrigen,idProgramacion,estado,iestado);
//			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(fechaInicio, fechaFin, idsedeTxt, idEntidadTxt, idProgramacion, iestado)	;	//MPINARES 24012023 - INICIO
			//MPINARES 13022024 - INICIO
			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(fechaInicio, fechaFin, idSedeTxt, idEntidadTxt, idProgramacion, 
					idAsistencia, dniUserTxt, usuExtTxt, codEjecutora, idUsuinternoTxt, idSistAdmTxt, idOrigenTxt, estadoTxt, iestado);	
			//MPINARES 13022024 - FIN
			
//			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
//			if(dtAsistenciaData==null){
//				dtAsistenciaData = new DtAsistenciaData();
//				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
//			}
			//MPINARES 13022024 - INICIO
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
//			DtAsistenciaData dtAsistenciaData = new DtAsistenciaData();
//			req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			//MPINARES 13022024 - FIN
			
			DtAsistenciaLC dtAsistenciaLC = new DtAsistenciaLC();
			long inicio = System.currentTimeMillis();
//			List<DtAsistenciaBk> dtAsistenciasss = dtAsistenciaData.getDtAsistenciaActivos(servicio,msUsuariosBk.getIdusuario());
			List<DtAsistenciaBk> dtAsistenciasss = dtAsistenciaData.getDtAsistenciaActivos(servicio,msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion);//MPINARES 24012023 - INICIO
			long lfinal =System.currentTimeMillis()-inicio;
			dtAsistenciaLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTASISTENCIA_CREA)){
				dtAsistenciaLC.setCreamodifica(true);
			}			
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtAsistenciaBk> dtAsistenciasssData = new ArrayList<DtAsistenciaBk> ();
			if(dtAsistenciaFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtAsistenciaBk dtAsistenciaAct : dtAsistenciasss){
	            boolean match = true;	            
	            Field camposdea[] = dtAsistenciaFiltro.getClass().getDeclaredFields();
//	            if(dtAsistenciaAct.getIdAsistencia.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
//					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1 || camponame.indexOf("fechaInicio")>-1 || camponame.indexOf("fechaFin")>-1) continue;//MPINARES 24012023 - INICIO
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtAsistenciaFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtAsistenciaFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
						Method claseMethod = dtAsistenciaAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtAsistenciaAct, new Object[0]);
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
					dtAsistenciasssData.add(dtAsistenciaAct);
	            }	            
	        }}else{
	        	dtAsistenciasssData = dtAsistenciasss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null && sorder.trim().length()>1) {
	            Collections.sort(dtAsistenciasssData, new Comparator<DtAsistenciaBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtAsistenciaBk dtAsistencia1, DtAsistenciaBk dtAsistencia2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtAsistenciaBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtAsistencia1, new Object[0]);
						Object value2 = method.invoke(dtAsistencia2, new Object[0]);
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
	        int dataSize = dtAsistenciasssData.size();
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
	        dtAsistenciaLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtAsistenciaLC.setData(dtAsistenciasssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtAsistenciaLC.setData(dtAsistenciasssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtAsistenciaLC.setData(dtAsistenciasssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtAsistenciaLC.setTiempoenproceso(lfinal);
			/////			
			
			GenericEntity<DtAsistenciaLC> registrosx = new GenericEntity<DtAsistenciaLC>(dtAsistenciaLC) {
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
	@Path("/salvardtAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarDtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtAsistenciaJS dtAsistenciaJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaJS);
		//MPINARES 24012023 - INICIO
		dtAsistenciaC.setVistaProgramado(dtAsistenciaJS.isVistaProgramado());
		dtAsistenciaC.setIdSede(msUsuariosBk.getIdSede());
		dtAsistenciaC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());
		dtAsistenciaC.setIdUsuinterno(msUsuariosBk.getIdusuario());
		//MPINARES 24012023 - FIN
		
		dtAsistenciaC.setFechaSoli( new Timestamp(dtAsistenciaJS.getFechaSoliJUD().getTime()) );
		dtAsistenciaC.setFechaAsistencia( new Timestamp(dtAsistenciaJS.getFechaServicioJUD().getTime()) );

		try {
			
			Long idProgramacion = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
			Long idOrigen = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDORIGEN_DEMANDA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDORIGEN_DEMANDA);
			
			dtAsistenciaC.setIdProgramacion(idProgramacion);
			dtAsistenciaC.setIdOrigen(idOrigen);
			
			Long pagOrigen = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PAGINA_ORIGEN_NO_PROGRAMADO,
					PropertiesMg.DEFAULT_PAGINA_ORIGEN_NO_PROGRAMADO);
			
			List<DtAnexosJS> tdAnexosJSsss = dtAsistenciaJS.getTdAnexosJSss();
			List<DtAnexoBk> tdAnexosBkss = null;
			if (tdAnexosJSsss != null && !tdAnexosJSsss.isEmpty()) {
				tdAnexosBkss = new ArrayList<DtAnexoBk>();
				for (DtAnexosJS tdAnexosJS : tdAnexosJSsss) {
					DtAnexoBk tdAnexosBk = new DtAnexoBk();
					FuncionesStaticas.copyPropertiesObject(tdAnexosBk, tdAnexosJS);
					tdAnexosBkss.add(tdAnexosBk);
				}
			}
			
			dtAsistenciaC = servicio.saveorupdateDtAsistenciaBk(dtAsistenciaC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto, tdAnexosBkss);
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			dtAsistenciaData.add(servicio, msUsuariosBk.getIdusuario(), dtAsistenciaC);
			
			GenericEntity<DtAsistenciaBk> registrors = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
	
	@POST
	@Path("/enviarConstanciaAtencion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response enviarConstanciaAtencion(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtAsistenciaJS dtAsistenciaJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaJS);
		//MPINARES 24012023 - INICIO

		try {
			
			dtAsistenciaC = servicio.enviarConstanciaAtencion(dtAsistenciaC, this.getURlPageConfirmation(req),msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto);
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			dtAsistenciaData.add(servicio, msUsuariosBk.getIdusuario(), dtAsistenciaC);
			
			GenericEntity<DtAsistenciaBk> registrors = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
	
	private String getURlPageConfirmation(HttpServletRequest request) {
		String scheme = request.getScheme(); 
        String hostname = request.getServerName(); 
        int port = request.getServerPort(); 
		
        String url = scheme + "://" + hostname + ":" + port + "/registramef/confirmacion-page";
		
		return url;
	}
	
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
	
	@GET
   	@Path("/buscarDtUsuarioXnombre/{nombreapellidos}")
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response listaDtUsuarioXNombre(@Context HttpServletRequest req, @Context HttpServletResponse res,
   			@HeaderParam("authorization") String authString, @PathParam("nombreapellidos") String nombreapellidos) {
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
   			
   			List<DtUsuarioExternoBk> listaUserExterBK = new ArrayList<DtUsuarioExternoBk>();
   					
   			listaUserExterBK = servicio.getMsUsuariosExternoBkXnombreapellido(nombreapellidos);
   			
   			List<DtUsuarioExternoDto> listaUserExtDTO=listaUserExterBK.stream().map(this::convertToDto).collect(Collectors.toList());
   			
   			
   			GenericEntity<List<DtUsuarioExternoDto>> registrosOut = new GenericEntity<List<DtUsuarioExternoDto>>(listaUserExtDTO) {
			};
			return Response.status(200).entity(registrosOut).build();
   			
   		} catch (Exception e) {
   			String mensaje = e.getMessage();
   			System.out.println("ERROR: " + mensaje);
   			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
   					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
   					}).build();
   		}
   	}
	
	@GET
   	@Path("/listaCargoPorIdUsuarioExt/{idUsuextEnti}")
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response listaCargoPorIdUsuario(@Context HttpServletRequest req, @Context HttpServletResponse res,
   			@HeaderParam("authorization") String authString, @PathParam("idUsuextEnti") Long idUsuextEnti ) {
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
   			
   			List<DtCargosUsuexterBk>  listaCargoUsuBK = servicio.getDtCargosUsuexterXFiltro(idUsuextEnti, null, null);
   			
   			GenericEntity<List<DtCargosUsuexterBk>> registrosOut = new GenericEntity<List<DtCargosUsuexterBk>>(listaCargoUsuBK) {
			};
			return Response.status(200).entity(registrosOut).build();
   			
   		} catch (Exception e) {
   			String mensaje = e.getMessage();
   			System.out.println("ERROR: " + mensaje);
   			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
   					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
   					}).build();
   		}
   	}
	
	private DtUsuarioExternoDto convertToDto(DtUsuarioExternoBk bk) {
	    DtUsuarioExternoDto dto = new DtUsuarioExternoDto();
	    dto.setIdUsuexterno(bk.getIdUsuexterno());
	    dto.setNombre(bk.getNombre());
	    dto.setAPaterno(bk.getApaterno());
	    dto.setAMaterno(bk.getAmaterno());
	    dto.setNombresCompletos(bk.getNombresCompletos());
	    dto.setCorreo(bk.getCorreo());
	    dto.setNumDocum(bk.getNumDocum());
	    dto.setOtroTelefono(bk.getOtroTelefono());
	    dto.setOtroCelular(bk.getOtroCelular());
	    return dto;
	}

	@POST
	@Path("/eliminardtAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarDtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtAsistenciaJS dtAsistenciaE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);

		try {
			servicio.deleteDtAsistencia(dtAsistenciaC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
			GenericEntity<DtAsistenciaBk> registro = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
	@Path("/activardtAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activarDtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtAsistenciaJS dtAsistenciaE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);

		try {
			servicio.activarDtAsistencia(dtAsistenciaC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
			GenericEntity<DtAsistenciaBk> registro = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
	@Path("/eliminarListadtAsistencia")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarListaDtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, List<Long> dtAsistenciaE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                if(dtAsistenciaE==null || dtAsistenciaE.isEmpty())
			return Response.status(HttpURLConnection.HTTP_NO_CONTENT).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR LA LISTA A ELIMINAR SE ENCUENTRA VACÍA.", HttpURLConnection.HTTP_NO_CONTENT)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		
		try {
			int tamanio = dtAsistenciaE.size();
			for (Long idAsistencia : dtAsistenciaE) {
				DtAsistenciaBk dtAsistenciaC = servicio.getDtAsistenciaBkXid(idAsistencia, msUsuariosBk.getIdusuario());
				servicio.deleteDtAsistencia(dtAsistenciaC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			}
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
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
	@Path("/editardtAsistencia/{idAsistencia}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editarDtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, @PathParam("idAsistencia") Long idAsistencia) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA) && !req.isUserInRole(Roles.DTASISTENCIA_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();	

		try {
			DtAsistenciaBk dtAsistenciaE = servicio.getDtAsistenciaBkXid(idAsistencia,msUsuariosBk.getIdusuario());
			
			GenericEntity<DtAsistenciaBk> registro = new GenericEntity<DtAsistenciaBk>(dtAsistenciaE) {
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
	@Path("/listaDtEntidadesIdEntidadIdEntidad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaDtEntidadesIdEntidadIdEntidad(@Context HttpServletRequest req, @Context HttpServletResponse res,
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
			List<IDValorDto> datos = servicio.getDtEntidadesIdEntidadIdEntidad();			
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdModalidad();			
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA) && !req.isUserInRole(Roles.DTASISTENCIA_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                     //DESPUES DE VALIDAR valor del filtro if(filtroValue==null) continue; else if(filtroValue.toString().length()<1) continue;
		    //filtrosaplicados.append(Messages.getStringToKey("dtAsistencia."+camponame)).append("=").append(filtroValue).append(" ");
		    StringBuffer filtrosaplicados = new StringBuffer();
                    boolean primerregistro = true;
                    boolean primerfiltro = true;
            ///////////////IGUAL QUE AL LISTAR
		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			//MPINARES 24012023 - INICIO
			String fechaInicio = req.getParameter("fechaInicio");
			String fechaFin = req.getParameter("fechaFin");
			String idSedeTxt = req.getParameter("idSedeTxt");//MPINARES 13022024 - INICIO
			String idEntidadTxt = req.getParameter("idEntidadTxt");//MPINARES 13022024 - INICIO
			String idProgramacion = req.getParameter("idProgramacion");
			//MPINARES 24012023 - FIN
			
			//MPINARES 13022024 - INICIO
			String idAsistencia = req.getParameter("idAsistencia");
			String dniUserTxt = req.getParameter("dniUserTxt");
			String usuExtTxt = req.getParameter("usuExtTxt");
			String codEjecutora = req.getParameter("codEjecutora");
			String idUsuinternoTxt = req.getParameter("idUsuinternoTxt");
			String idSistAdmTxt = req.getParameter("idSistAdmTxt");
			String idOrigenTxt = req.getParameter("idOrigenTxt");
			String estadoTxt = req.getParameter("estadoTxt");
			//MPINARES 13022024 - FIN
			
            String sestado = req.getParameter("estado");
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}		
			
//			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(idEntidad,idSede,fechaAsistencia,idUsuinterno,idSistAdm,idOrigen,idProgramacion,estado,iestado);
//			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(fechaInicio, fechaFin, idsedeTxt, idEntidadtxt, idProgramacion, iestado)	;//MPINARES 24012023 - INICIO/
			//MPINARES 13022024 - INICIO
			DtAsistenciaFiltro dtAsistenciaFiltro = new DtAsistenciaFiltro(fechaInicio, fechaFin, idSedeTxt, idEntidadTxt, idProgramacion, 
					idAsistencia, dniUserTxt, usuExtTxt, codEjecutora, idUsuinternoTxt, idSistAdmTxt, idOrigenTxt, estadoTxt, iestado);	
			//MPINARES 13022024 - FIN
			
			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
			if(dtAsistenciaData==null){
				dtAsistenciaData = new DtAsistenciaData();
				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
			}
			
			DtAsistenciaLC dtAsistenciaLC = new DtAsistenciaLC();
			long inicio = System.currentTimeMillis();
//			List<DtAsistenciaBk> dtAsistenciasss = dtAsistenciaData.getDtAsistenciaActivos(servicio,msUsuariosBk.getIdusuario());
			List<DtAsistenciaBk> dtAsistenciasss = dtAsistenciaData.getDtAsistenciaActivos(servicio,msUsuariosBk.getIdusuario(), fechaInicio, fechaFin, idProgramacion);//MPINARES 24012023 - INICIO
			long lfinal =System.currentTimeMillis()-inicio;
			dtAsistenciaLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTASISTENCIA_CREA)){
				dtAsistenciaLC.setCreamodifica(true);
			}			
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtAsistenciaBk> dtAsistenciasssData = new ArrayList<DtAsistenciaBk> ();
			if(dtAsistenciaFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtAsistenciaBk dtAsistenciaAct : dtAsistenciasss){
	            boolean match = true;	            
	            Field camposdea[] = dtAsistenciaFiltro.getClass().getDeclaredFields();
//	            if(dtAsistenciaAct.getIdAsistencia.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
//					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1 || camponame.indexOf("fechaInicio")>-1 || camponame.indexOf("fechaFin")>-1) continue;
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtAsistenciaFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtAsistenciaFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
                                                
                                                if(primerregistro)
                                                filtrosaplicados.append(Messages.getStringToKey("dtAsistencia."+camponame)).append("=").append(filtroValue).append(", ");

						Method claseMethod = dtAsistenciaAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtAsistenciaAct, new Object[0]);
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
					dtAsistenciasssData.add(dtAsistenciaAct);
	                        }
                        primerregistro = false;
	        }}else{
	        	dtAsistenciasssData = dtAsistenciasss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null) {
	            Collections.sort(dtAsistenciasssData, new Comparator<DtAsistenciaBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtAsistenciaBk dtAsistencia1, DtAsistenciaBk dtAsistencia2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtAsistenciaBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtAsistencia1, new Object[0]);
						Object value2 = method.invoke(dtAsistencia2, new Object[0]);
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
	        int dataSize = dtAsistenciasssData.size();
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
	        dtAsistenciaLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtAsistenciaLC.setData(dtAsistenciasssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtAsistenciaLC.setData(dtAsistenciasssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtAsistenciaLC.setData(dtAsistenciasssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtAsistenciaLC.setTiempoenproceso(lfinal);
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
			wb.setSheetName(sheetIndxResumen, "AT_" + sdf.format(hoy));
			StyleUtils styleUtils = new StyleUtils(wb);
                        String titulo = "ASISTENCIA TÉCNICA"
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

//			List<String> caposvista = Arrays.asList("idEntidad","idSede","fechaAsistencia","idUsuinterno","idSistAdm","idOrigen","idProgramacion","estado");
			List<String> caposvista = Arrays.asList("idAsistencia","dniUserTxt","usuExtTxt","codEjecutora","idEntidadTxt","idSedeTxt","fechaAsistencia","idUsuinternoTxt","idSistAdmTxt","idOrigenTxt","estadoTxt");//MPINARES 24012023 - INICIO
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
				cellxX.setCellValue(Messages.getStringToKey("dtAsistencia."+camponame));
				tituloscontador++;
			} 

                        int contador = 7;
			int contadorfor = 1;		
			for (DtAsistenciaBk dtAsistenciaBk : dtAsistenciasssData) {
				rowX = hoja.getRow(contador);
				styleUtils.copyRow(wb, hoja, contador, contador+1, null);
			
				Cell cellAAX = rowX.getCell(0);
				cellAAX.setCellValue(contadorfor);
				
				if(dtAsistenciaBk.getCclase()!=null){
					if(dtAsistenciaBk.getCclase().equals("cverde")){
						cellAAX.setCellStyle(cellStyleV);
					}else if(dtAsistenciaBk.getCclase().equals("camarillo")){
						cellAAX.setCellStyle(cellStyleA);
					}else if(dtAsistenciaBk.getCclase().equals("crojo")){
						cellAAX.setCellStyle(cellStyleR);
				}}
				
				int columna = 1;
				for (String camponame : caposvista) {
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))+ camponame.substring(1);
			        Class<?>[] types = new Class[] {};
			       try {
				        Method claseMethod = dtAsistenciaBk.getClass().getMethod(claseGetMetod, types);
				        Object claseValue = claseMethod.invoke(dtAsistenciaBk, new Object[0]);
				        Cell cellxX = rowX.getCell(columna);
                                          if (claseValue != null) {                                                
				        	if(cellxX==null){
								cellxX = rowX.createCell(columna);
							}
                                                columna++;
				        	cellxX.setCellStyle(cellStyleDATO);
				        	if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
//				        		Timestamp valor = (Timestamp) claseValue;				        		
//								cellxX.setCellValue(valor);
				        		//MPINARES 24012023 - INICIO
				        		Timestamp valor = (Timestamp) claseValue;				        		
//								cellxX.setCellValue(valor);
								String fechaformat=FuncionesStaticas.getFechaCorta(valor);
								cellxX.setCellValue(fechaformat);
								//MPINARES 24012023 - FIN
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
        
        
      //MPINARES 24012023 - INICIO
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

    	    if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA) && !req.isUserInRole(Roles.DTASISTENCIA_VE))
    	        return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED)
    	                .entity(new GenericEntity<RespuestaError>(
    	                        new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.",
    	                                HttpURLConnection.HTTP_UNAUTHORIZED)) {
    	                }).build();

    	    try {
    	        List<DtEntidadesDto> msInstitucionesDtosss = servicio.getMsInstitucionesXCodigoEjecutora(codigoEjecutora, msUsuariosBk.getIdSistAdmi()); // Asegúrate de tener este método en tu servicio
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
        
      //INICIO CUSCATA - 18062024
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCONSULTAS_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {	
    			
    			List<IDValorDto> datos =new ArrayList<IDValorDto>();
    			if(msUsuariosBk.getPerfilesSistema().contains(Roles.PERFIL_USU_OGC) || 
    					msUsuariosBk.getPerfilesSistema().contains(Roles.PERFIL_GC) ||
    					msUsuariosBk.getPerfilesSistema().contains(Roles.PERFIL_ADMIN_REPORTES) ||
    					msUsuariosBk.getPerfilesSistema().contains(Roles.PERFIL_USUARIO_EXTERNO_OGC) ||
    					msUsuariosBk.getPerfilesSistema().contains(Roles.PERFIL_ADMINISTRADOR)  ) {
    				datos = servicio.getMsTemaIdTemaIdTema();
    			} else {
    				datos = servicio.getMsTemaIdTemaIdTemaXSisAdmin(msUsuariosBk.getIdSistAdmi());	
    			}
    			
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
    	@Path("/descargarFormato/{idAsistencia}")
    	@Produces(MediaType.APPLICATION_OCTET_STREAM)
    	public Response descargarFormato(@Context HttpServletRequest req, 
    									 @Context HttpServletResponse res,
    									 @HeaderParam("authorization") String authString, 
    									 @PathParam("idAsistencia") Long idAsistencia) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		try {
    			DtAsistenciaBk dtAsistenciaBk = servicio.getDtAsistenciaBkXid(idAsistencia, msUsuariosBk.getIdusuario());
    			
    			
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");			
				String directorio = "Reporte_"+"fmtAsist" + msUsuariosBk.getIdusuario()+sdf.format(new Date());	
			
				Long flagUserHome = PropertiesMg.getSistemLong(PropertiesMg.KEY_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO,
						PropertiesMg.DEFAULT_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO);
				String nuevoDirectorio=null;
				if(flagUserHome.intValue()==1){
					 String home = System.getProperty("user.home", ".");		
					 nuevoDirectorio = home+System.getProperty("file.separator")+"REPORTE_RESUMEN"+System.getProperty("file.separator")+directorio;			
				}else{
					nuevoDirectorio= FuncionesStaticas.getRutaFileNameSistemaSearchSystem(directorio); 
				}
				//log.error(" Creando directorio para el  reporte resumen nuevoDirectorio= "+nuevoDirectorio);

				File F_RUTAROOT = new File(nuevoDirectorio);
				if (!F_RUTAROOT.exists()) {
					if (!F_RUTAROOT.mkdirs()) {
						return null;
					}
				}
				
    			
				generarFormatoAsistencia(nuevoDirectorio, dtAsistenciaBk, msUsuariosBk.getIdusuario());
    			
    			
				String zipFile = nuevoDirectorio+System.getProperty("file.separator")+directorio+ ".zip";
				File fileAux2 = new File(zipFile);
				InputStream in = new FileInputStream(fileAux2);
    			
				Response response = null;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				
				
				int nRead;
				byte[] data = new byte[16384];

				while ((nRead = in.read(data, 0, data.length)) != -1) {
					bos.write(data, 0, nRead);
				}
				
				in.close();
				bos.close();
				
				ResponseBuilder rb = Response.ok(bos.toByteArray());
				rb.header("Content-Disposition", "attachment; filename=" + (directorio+ ".zip"));
				response = rb.build();
				
				return response;
    			
    		} catch (Exception e) {
    			String mensaje = e.getMessage();
    			System.out.println("ERROR: " + mensaje);
    			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    					}).build();
    		}
    	}
        
        private void generarFormatoAsistencia(String nuevoDirectorio, DtAsistenciaBk dtAsistenciaBk, Long kyUsuarioMod) {
        	try {
        		String nombrearchivo;
    			String etiqueta_FechaServicio = "<fecha_servicio>";
    			String etiqueta_SedeConectamef = "<sede_conectamef>";
    			String etiqueta_Origen = "<origen>";
    			String etiqueta_UsuarioRegistra = "<usuario_registra>";
    			String etiqueta_Entidad = "<entidad>";
    			String etiqueta_Ejecutora = "<ejecutora>";
    			String etiqueta_UsuariosAtiende = "<usuarios_atiende>";
    			String etiqueta_Dni = "<dni>";
    			String etiqueta_Cargo = "<cargo>";
    			String etiqueta_Fijo = "<fijo>";
    			String etiqueta_Correo = "<correo>";
    			String etiqueta_Celular = "<celular>";
    			String etiqueta_DetalleTema = "<detalle_tema>";
    			String etiqueta_IdAsistencia = "<id_asistencia>";
    			String etiqueta_Tema = "<tema>";
    			String etiqueta_Subtema = "<subtema>";
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
    			String dato_Ejecutora = "";
    			String dato_UsuariosAtiende = "";
    			String dato_Dni = "";
    			String dato_Cargo = "";
    			String dato_Fijo = "";
    			String dato_Correo = "";
    			String dato_Celular = "";
    			String dato_FechaServicio="";
    			String dato_SedeConectamef ="";
    			String dato_Origen ="";
    			String dato_UsuarioRegistra="";
    			String dato_Entidad ="";
    			DtEntidadesBk entidad=null;
    			String dato_DetalleTema="";
    			String dato_IdAsistencia="";
    			String dato_Tema="";
    			String dato_Subtema = "";
    			Map<String, String> datos ;
    			//FileOutputStream fos ;	
    			int num=0;
    			ClassLoader classLoader = this.getClass().getClassLoader();
    			for (DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBka : dtAsistenciaBk.getDtAsistenciaUsuariosBkJSss()) {
    				++num;
    				try {			

    					dato_FechaServicio = dtAsistenciaBk.getFechaAsistencia() != null ? FuncionesStaticas.getfechaLargaFormateadaSinHora(new Timestamp(dtAsistenciaBk.getFechaAsistencia().getTime())): "";
    					dato_SedeConectamef = dtAsistenciaBk.getIdSedeTxt() != null ? dtAsistenciaBk.getIdSedeTxt() : "";
    					dato_Origen = dtAsistenciaBk.getIdOrigenTxt() != null ? dtAsistenciaBk.getIdOrigenTxt() : "";
    					//dato_UsuarioRegistra = dtAsistenciaBk.getIdusserCreaTxt() != null? dtAsistenciaBk.getIdusserCreaTxt() : "";
    					dato_UsuarioRegistra = dtAsistenciaBk.getIdUsuinternoTxt() != null? dtAsistenciaBk.getIdUsuinternoTxt() : "";
    					dato_Entidad = dtAsistenciaBk.getIdEntidadTxt() != null ? dtAsistenciaBk.getIdEntidadTxt(): "";
    					
    					//if (dtAsistenciaBk.getIdEntidad() != null && dtAsistenciaBk.getIdEntidad().longValue() > 0) {
    					//	 entidad = servicio.getDtEntidadById(dtAsistenciaBk.getIdEntidad());
    						//if (entidad != null) {
    							dato_Ejecutora = dtAsistenciaBk.getCodEjecutora();
    					//	}
    				//	}
    					dato_UsuariosAtiende = dtAsistenciaUsuexternosBka.getNombre()+ " " + dtAsistenciaUsuexternosBka.getaPaterno()+ " "+dtAsistenciaUsuexternosBka.getaMaterno();
    					dato_Dni = (dtAsistenciaUsuexternosBka.getNumDocu() == null ? "":  dtAsistenciaUsuexternosBka.getNumDocu() + ", ");
    					dato_Cargo = (dtAsistenciaUsuexternosBka.getIdCargoUsuextTxt() == null ? "":  dtAsistenciaUsuexternosBka.getIdCargoUsuextTxt() + ", ");
    					dato_Fijo = (dtAsistenciaUsuexternosBka.getFijoUsuext() == null ? ""	:  dtAsistenciaUsuexternosBka.getFijoUsuext() + ", ");
    					dato_Correo = (dtAsistenciaUsuexternosBka.getCorreoUsuext() == null ? "":  dtAsistenciaUsuexternosBka.getCorreoUsuext() + ", ");
    					dato_Celular = (dtAsistenciaUsuexternosBka.getCelularUsuext() == null ? "":  dtAsistenciaUsuexternosBka.getCelularUsuext() + ", ");
    						
    					 dato_DetalleTema = dtAsistenciaBk.getDetalle() != null ? dtAsistenciaBk.getDetalle()	: "";
    					 dato_IdAsistencia = dtAsistenciaBk.getIdAsistencia() != null	? String.valueOf(dtAsistenciaBk.getIdAsistencia()) : "";
    					 dato_Tema = dtAsistenciaBk.getTemasTxt() != null ? dtAsistenciaBk.getTemasTxt() : "";
    					 dato_Subtema = dtAsistenciaBk.getSubtemastTxt() != null ? dtAsistenciaBk.getSubtemastTxt() : "";

    					dato_Dni = FuncionesStaticas.removerUltCaracter(dato_Dni.trim());
    					dato_Cargo = FuncionesStaticas.removerUltCaracter(dato_Cargo.trim());
    					dato_Fijo = FuncionesStaticas.removerUltCaracter(dato_Fijo.trim());
    					dato_Correo = FuncionesStaticas.removerUltCaracter(dato_Correo.trim());
    					dato_Celular = FuncionesStaticas.removerUltCaracter(dato_Celular.trim());
    					dato_DetalleTema = FuncionesStaticas.removerUltCaracter(dato_DetalleTema.trim());
    					dato_Tema = FuncionesStaticas.removerUltCaracter(dato_Tema.trim());
    					dato_Subtema = FuncionesStaticas.removerUltCaracter(dato_Subtema.trim());
    					
    					datos = new HashMap<String, String>();
    					datos.put(etiqueta_FechaServicio, dato_FechaServicio);
    					datos.put(etiqueta_SedeConectamef, dato_SedeConectamef);
    					datos.put(etiqueta_Origen, dato_Origen);
    					datos.put(etiqueta_UsuarioRegistra, dato_UsuarioRegistra);
    					datos.put(etiqueta_Entidad, dato_Entidad);
    					datos.put(etiqueta_Ejecutora, dato_Ejecutora);
    					datos.put(etiqueta_UsuariosAtiende, dato_UsuariosAtiende);
    					datos.put(etiqueta_Dni, dato_Dni);
    					datos.put(etiqueta_Cargo, dato_Cargo);
    					datos.put(etiqueta_Fijo, dato_Fijo);
    					datos.put(etiqueta_Correo, dato_Correo);
    					datos.put(etiqueta_Celular, dato_Celular);
    					datos.put(etiqueta_DetalleTema, dato_DetalleTema);
    					datos.put(etiqueta_IdAsistencia, dato_IdAsistencia);
    					datos.put(etiqueta_Tema, dato_Tema);
    					datos.put(etiqueta_Subtema, dato_Subtema);

    								
    					sdf = new SimpleDateFormat("yyyyMMddmmss");		
    					nombrearchivo= nuevoDirectorio+ System.getProperty("file.separator")+ num+"_asist_"+dtAsistenciaUsuexternosBka.getIdAsistUsuext()+"_de_" +kyUsuarioMod+ sdf.format(new Date())+".docx";
    				
    					FileInputStream fileInputStream = new FileInputStream(classLoader.getResource("plantilla_asistencia_2022.docx").getFile());
    					
    					XWPFDocument doc = new XWPFDocument(fileInputStream);

    					List<XWPFTable> tablas = doc.getTables();
    					for (XWPFTable tbl : tablas) {
    						for (XWPFTableRow row : tbl.getRows()) {
    							for (XWPFTableCell cell : row.getTableCells()) {
    								for (XWPFParagraph p : cell.getParagraphs()) {
    									List<XWPFRun> runs = p.getRuns();
    									if (runs != null) {
    										for (Map.Entry<String, String> entry : datos.entrySet()) {
    											String key = entry.getKey();
    											String value = entry.getValue();
    											TextSegement found = p.searchText(key, new PositionInParagraph());
    											if (found != null) {
    												if (found.getBeginRun() == found.getEndRun()) {
    													XWPFRun run = runs.get(found.getBeginRun());
    													String runText = run.getText(run.getTextPosition());
    													String replaced = runText.replace(key, value);
    													run.setText(replaced, 0);
    												} else {
    													StringBuilder b = new StringBuilder();
    													for (int runPos = found.getBeginRun(); runPos <= found
    															.getEndRun(); runPos++) {
    														XWPFRun run = runs.get(runPos);
    														b.append(run.getText(run.getTextPosition()));
    													}
    													String connectedRuns = b.toString();
    													String replaced = connectedRuns.replace(key, value);
    													XWPFRun partOne = runs.get(found.getBeginRun());
    													partOne.setText(replaced, 0);
    													for (int runPos = found.getBeginRun() + 1; runPos <= found
    															.getEndRun(); runPos++) {
    														XWPFRun partNext = runs.get(runPos);
    														partNext.setText("", 0);
    													}
    												}
    											}
    										}
    									}
    								}
    							}
    						}
    					}

    					//String fechaActualConMilisegundos = FechaHoraUtil.fechaActualString()+"_";
    					//String fileOutFormatoConformidad = FuncionesStaticas.getFileNameRutaSistema(fechaActualConMilisegundos+Constantes.SALIDA_PLANTILLA_CONFORMIDAD_CONTRATO); 
    					
    					fileInputStream.close();
    					FileOutputStream fos = new FileOutputStream(nombrearchivo);
    					//fileAux=null;				
    					doc.write(fos);
    					fos.close(); 	
    					doc.close();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    				
    		
    			}
        		
			} catch (Exception e) {
				String mensaje = e.getMessage().toUpperCase().charAt(0) + e.getMessage().substring(1, e.getMessage().length()).toLowerCase();
    			System.out.println("ERROR: " + mensaje);
			}
        	
        	new ZipDirectory(nuevoDirectorio);
        }
        //FIN CUSCATA - 18062024
        
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTCONSULTAS_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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
        
        
        @POST
    	@Path("/eliminardtAsistenciaTema")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response eliminarDtAsistenciaTema(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtAsistenciaTemasJS dtAsistenciaTemasE) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtAsistenciaTemasBk dtAsistenciaTemasC = new DtAsistenciaTemasBk();
    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaTemasC, dtAsistenciaTemasE);

    		try {
    			servicio.deleteDtAsistenciaTemas(dtAsistenciaTemasC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
    			
//    			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
//    			if(dtAsistenciaData==null){
//    				dtAsistenciaData = new DtAsistenciaData();
//    				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
//    			}
//    			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
    			
    			GenericEntity<DtAsistenciaTemasBk> registro = new GenericEntity<DtAsistenciaTemasBk>(dtAsistenciaTemasC) {
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

    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		try {
    			List<DtEntidadesBk> datos = servicio.getMsInstitucionesIdprovee(idprovee, msUsuariosBk.getIdSistAdmi());  
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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

    		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
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
    	@Path("/anulardtAsistenciaList")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response anulardtAsistenciaList(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtAsistenciaBk[] dtAsistenciaEList) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
//    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);
    		
    		List<DtAsistenciaBk> dtAsistenciaBklist = Arrays.asList(dtAsistenciaEList);

    		try {
    			
    			for(DtAsistenciaBk dtAsistenciaBka:dtAsistenciaBklist){
    				FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaBka);
    				servicio.deleteDtAsistencia(dtAsistenciaBka, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSede(), adressRemoto);
        		}
    			
    			DtAsistenciaData dtAsistenciaData = new DtAsistenciaData();
    			req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
//    			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
    			
    			GenericEntity<DtAsistenciaBk> registro = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
    	@Path("/reactivardtAsistencia")
    	@Produces(MediaType.APPLICATION_JSON)
    	public Response reactivardtAsistencia(@Context HttpServletRequest req, @Context HttpServletResponse res,
    			@HeaderParam("authorization") String authString, DtAsistenciaJS dtAsistenciaE) {
    		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    		Principal usuario = req.getUserPrincipal();
    		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    		if (msUsuariosBk == null)
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();

    		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    			}).build();
    		
    		String adressRemoto = getRemoteAdress(req);
    		DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
    		FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaE);

    		try {
    			servicio.reactivarDtAsistencia(dtAsistenciaC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), msUsuariosBk.getIdSistAdmi(), adressRemoto);
    			
    			DtAsistenciaData dtAsistenciaData = new DtAsistenciaData();
    			req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
    			
//    			DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
//    			if(dtAsistenciaData==null){
//    				dtAsistenciaData = new DtAsistenciaData();
//    				req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
//    			}
//    			dtAsistenciaData.refrescar(servicio, msUsuariosBk.getIdusuario());
    			
    			GenericEntity<DtAsistenciaBk> registro = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
        
      //MPINARES 24012023 - FIN
    	
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
    							&& !req.isUserInRole(Roles.DTASISTENCIA_VE) &&!req.isUserInRole(Roles.PERFIL_USU_OGC)
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
    							|| roles.contains(Roles.DTASISTENCIA_CREA)
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
    				
    				//INICIO CUSCATA - 18062024	
    				@GET
    				@Path("/buscarPorNumDoc/{numDoc}")
    				@Produces(MediaType.APPLICATION_JSON)
    				public Response buscarPorNumDoc(@Context HttpServletRequest req, @Context HttpServletResponse res,
    						@HeaderParam("authorization") String authString, @PathParam("numDoc") Long numDocum) {

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

    						DtUsuarioExternoBk usuarioExterno = servicio.getUsuarioPorDNI(numDocum, msUsuariosBk.getIdusuario());

    						GenericEntity<DtUsuarioExternoBk> registrosx = new GenericEntity<DtUsuarioExternoBk>(usuarioExterno) {
    						};

    						return Response.status(200).entity(registrosx).build();
    					} catch (Exception e) {
    						String mensaje = e.getMessage();
    						return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
    								new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
    								}).build();
    					}
    				}
    				
    				
    				@POST
    				@Path("/finalizardtAsistencia")
    				@Produces(MediaType.APPLICATION_JSON)
    				public Response finalizardtAsistencia(@Context HttpServletRequest req, 
    													  @Context HttpServletResponse res,
    													  @HeaderParam("authorization") String authString, 
    													  DtAsistenciaJS dtAsistenciaJS) {
    					SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    					Principal usuario = req.getUserPrincipal();
    					MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

    					if (msUsuariosBk == null)
    						return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    						}).build();
    					
    					if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTASISTENCIA_CREA))
    						return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
    								new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
    						}).build();
    					
    					String adressRemoto = getRemoteAdress(req);

    					DtAsistenciaBk dtAsistenciaC = new DtAsistenciaBk();
    					FuncionesStaticas.copyPropertiesObject(dtAsistenciaC, dtAsistenciaJS);
    					// MPINARES 24012023 - INICIO
    					dtAsistenciaC.setVistaProgramado(dtAsistenciaJS.isVistaProgramado());
    					dtAsistenciaC.setIdSede(msUsuariosBk.getIdSede());
    					dtAsistenciaC.setIdSistAdm(msUsuariosBk.getIdSistAdmi());
    					dtAsistenciaC.setIdUsuinterno(msUsuariosBk.getIdusuario());
    					// MPINARES 24012023 - FIN

    					try {
    						dtAsistenciaC = servicio.finalizarDtAsistenciaBk(dtAsistenciaC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto);
    						
    						DtAsistenciaData dtAsistenciaData = (DtAsistenciaData) req.getSession().getAttribute("DtAsistenciaData");
    						if(dtAsistenciaData==null){
    							dtAsistenciaData = new DtAsistenciaData();
    							req.getSession().setAttribute("DtAsistenciaData",dtAsistenciaData);
    						}
    						dtAsistenciaData.add(servicio, msUsuariosBk.getIdusuario(), dtAsistenciaC);
    						
    						GenericEntity<DtAsistenciaBk> registrors = new GenericEntity<DtAsistenciaBk>(dtAsistenciaC) {
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
    				//FIN CUSCATA - 18062024

}
