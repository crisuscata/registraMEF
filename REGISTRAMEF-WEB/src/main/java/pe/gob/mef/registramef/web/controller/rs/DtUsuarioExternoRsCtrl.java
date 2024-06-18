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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.transfer.IDValorDto;
import pe.gob.mef.registramef.web.controller.DtUsuarioExternoData;
import pe.gob.mef.registramef.web.controller.rs.data.DtUsuarioExternoJS;
import pe.gob.mef.registramef.web.controller.rs.data.DtUsuarioExternoLC;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;
import pe.gob.mef.registramef.web.rs.reporte.StyleUtils;

@Path("/ctrldtUsuarioExterno")
public class DtUsuarioExternoRsCtrl {

	@Autowired
	private Servicio servicio = null;
	
	public DtUsuarioExternoRsCtrl() {
	}

	/////////////////////////////////////////
	@GET
	@Path("/listadtUsuarioExterno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarDtUsuarioExterno(
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			String aPaterno = req.getParameter("aPaterno");
			String aMaterno = req.getParameter("aMaterno");
			String nombre = req.getParameter("nombre");
			String numDocu = req.getParameter("numDocu");
			String correo = req.getParameter("correo");
			String telefFijo = req.getParameter("telefFijo");
			String telefCell = req.getParameter("telefCell");
			String fechaModif = req.getParameter("fechaModif");
			String estado = req.getParameter("estado");
			
            String sestado = req.getParameter("estado");
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}		
			
			DtUsuarioExternoFiltro dtUsuarioExternoFiltro = new DtUsuarioExternoFiltro(aPaterno,aMaterno,nombre,numDocu,correo,telefFijo,telefCell,fechaModif,estado,iestado);		
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			
			DtUsuarioExternoLC dtUsuarioExternoLC = new DtUsuarioExternoLC();
			long inicio = System.currentTimeMillis();
			List<DtUsuarioExternoBk> dtUsuarioExternosss = dtUsuarioExternoData.getDtUsuarioExternoActivos(servicio,msUsuariosBk.getIdusuario());
			long lfinal =System.currentTimeMillis()-inicio;
			dtUsuarioExternoLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA)){
				dtUsuarioExternoLC.setCreamodifica(true);
			}			
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtUsuarioExternoBk> dtUsuarioExternosssData = new ArrayList<DtUsuarioExternoBk> ();
			if(dtUsuarioExternoFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtUsuarioExternoBk dtUsuarioExternoAct : dtUsuarioExternosss){
	            boolean match = true;	            
	            Field camposdea[] = dtUsuarioExternoFiltro.getClass().getDeclaredFields();
//	            if(dtUsuarioExternoAct.getIdUsuexterno.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtUsuarioExternoFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtUsuarioExternoFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
						Method claseMethod = dtUsuarioExternoAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtUsuarioExternoAct, new Object[0]);
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
					dtUsuarioExternosssData.add(dtUsuarioExternoAct);
	            }	            
	        }}else{
	        	dtUsuarioExternosssData = dtUsuarioExternosss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null && sorder.trim().length()>1) {
	            Collections.sort(dtUsuarioExternosssData, new Comparator<DtUsuarioExternoBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtUsuarioExternoBk dtUsuarioExterno1, DtUsuarioExternoBk dtUsuarioExterno2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtUsuarioExternoBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtUsuarioExterno1, new Object[0]);
						Object value2 = method.invoke(dtUsuarioExterno2, new Object[0]);
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
	        int dataSize = dtUsuarioExternosssData.size();
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
	        dtUsuarioExternoLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtUsuarioExternoLC.setData(dtUsuarioExternosssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtUsuarioExternoLC.setData(dtUsuarioExternosssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtUsuarioExternoLC.setData(dtUsuarioExternosssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtUsuarioExternoLC.setTiempoenproceso(lfinal);
			/////			
			
			GenericEntity<DtUsuarioExternoLC> registrosx = new GenericEntity<DtUsuarioExternoLC>(dtUsuarioExternoLC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@POST
	@Path("/salvardtUsuarioExterno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarDtUsuarioExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtUsuarioExternoJS dtUsuarioExternoJS) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);

		DtUsuarioExternoBk dtUsuarioExternoC = new DtUsuarioExternoBk();
		FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoC, dtUsuarioExternoJS);

		try {
			dtUsuarioExternoC = servicio.saveorupdateDtUsuarioExternoBk(dtUsuarioExternoC, msUsuariosBk.getUsername(),msUsuariosBk.getIdusuario(), null,adressRemoto);
//			dtUsuarioExternoJS = new DtUsuarioExternoJS();
//			FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoJS, dtUsuarioExternoC);
//			dtUsuarioExternoJS.setEditopcion(dtUsuarioExternoC.getdtUsuarioExternoACL().getEditopcion());
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			dtUsuarioExternoData.add(servicio, msUsuariosBk.getIdusuario(), dtUsuarioExternoC);
			
			GenericEntity<DtUsuarioExternoBk> registrors = new GenericEntity<DtUsuarioExternoBk>(dtUsuarioExternoC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrors).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@POST
	@Path("/eliminardtUsuarioExterno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarDtUsuarioExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtUsuarioExternoJS dtUsuarioExternoE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtUsuarioExternoBk dtUsuarioExternoC = new DtUsuarioExternoBk();
		FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoC, dtUsuarioExternoE);

		try {
			servicio.deleteDtUsuarioExterno(dtUsuarioExternoC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			dtUsuarioExternoData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
			GenericEntity<DtUsuarioExternoBk> registro = new GenericEntity<DtUsuarioExternoBk>(dtUsuarioExternoC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

        @POST
	@Path("/activardtUsuarioExterno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activarDtUsuarioExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, DtUsuarioExternoJS dtUsuarioExternoE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		DtUsuarioExternoBk dtUsuarioExternoC = new DtUsuarioExternoBk();
		FuncionesStaticas.copyPropertiesObject(dtUsuarioExternoC, dtUsuarioExternoE);

		try {
			servicio.activarDtUsuarioExterno(dtUsuarioExternoC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			dtUsuarioExternoData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
			GenericEntity<DtUsuarioExternoBk> registro = new GenericEntity<DtUsuarioExternoBk>(dtUsuarioExternoC) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}
	
        @POST
	@Path("/eliminarListadtUsuarioExterno")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarListaDtUsuarioExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, List<Long> dtUsuarioExternoE) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                if(dtUsuarioExternoE==null || dtUsuarioExternoE.isEmpty())
			return Response.status(HttpURLConnection.HTTP_NO_CONTENT).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR LA LISTA A ELIMINAR SE ENCUENTRA VACÍA.", HttpURLConnection.HTTP_NO_CONTENT)) {
			}).build();
		
		String adressRemoto = getRemoteAdress(req);
		
		try {
			int tamanio = dtUsuarioExternoE.size();
			for (Long idUsuexterno : dtUsuarioExternoE) {
				DtUsuarioExternoBk dtUsuarioExternoC = servicio.getDtUsuarioExternoBkXid(idUsuexterno, msUsuariosBk.getIdusuario());
				servicio.deleteDtUsuarioExterno(dtUsuarioExternoC, msUsuariosBk.getUsername(), msUsuariosBk.getIdusuario(), null, adressRemoto);
			}
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			dtUsuarioExternoData.refrescar(servicio, msUsuariosBk.getIdusuario());
			
                        GenericEntity<String> registro = new GenericEntity<String>("SE ELIMINARON "+tamanio+" REGISTROS.") {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Validador e) {
			// e.printStackTrace();
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

	@GET
	@Path("/editardtUsuarioExterno/{idUsuexterno}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editarDtUsuarioExterno(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString, @PathParam("idUsuexterno") Long idUsuexterno) {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if(!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();	

		try {
			DtUsuarioExternoBk dtUsuarioExternoE = servicio.getDtUsuarioExternoBkXid(idUsuexterno,msUsuariosBk.getIdusuario());
			
			GenericEntity<DtUsuarioExternoBk> registro = new GenericEntity<DtUsuarioExternoBk>(dtUsuarioExternoE) {
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registro).build();
		} catch (Exception e) {
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
	
        
        @GET
	@Path("/listaPrtParametrosIdparametroIdTipodocumento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaPrtParametrosIdparametroIdTipodocumento(@Context HttpServletRequest req, @Context HttpServletResponse res,
			@HeaderParam("authorization") String authString) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		Principal usuario = req.getUserPrincipal();
		MsUsuariosBk msUsuariosBk = servicio.getMsUsuariosBkXUsername(usuario.getName());

		if (msUsuariosBk == null)
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN A REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

		try {			
			List<IDValorDto> datos = servicio.getPrtParametrosIdparametroIdTipodocumento();			
			   GenericEntity<List<IDValorDto>> registrosx = new GenericEntity<List<IDValorDto>>(datos){
			};
			return Response.status(HttpURLConnection.HTTP_OK).entity(registrosx).build();
		} catch (Exception e) {
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity(new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

        @GET
	@Path("/descargar")
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

		if (!req.isUserInRole(Roles.ADMINISTRADOR) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA) && !req.isUserInRole(Roles.DTUSUARIOEXTERNO_VE))
			return Response.status(HttpURLConnection.HTTP_UNAUTHORIZED).entity(new GenericEntity<RespuestaError>(
					new RespuestaError("ERROR NO TIENE AUTORIZACIÓN PARA REALIZAR ESTA OPERACIÓN.", HttpURLConnection.HTTP_UNAUTHORIZED)) {
			}).build();

                     //DESPUES DE VALIDAR valor del filtro if(filtroValue==null) continue; else if(filtroValue.toString().length()<1) continue;
		    //filtrosaplicados.append(Messages.getStringToKey("dtUsuarioExterno."+camponame)).append("=").append(filtroValue).append(" ");
		    StringBuffer filtrosaplicados = new StringBuffer();
                    boolean primerregistro = true;
            ///////////////IGUAL QUE AL LISTAR
		try {
			String sorder = req.getParameter("order"); 
			String slimit = req.getParameter("limit");
			String spage = req.getParameter("page");
			
			String aPaterno = req.getParameter("aPaterno");
			String aMaterno = req.getParameter("aMaterno");
			String nombre = req.getParameter("nombre");
			String numDocu = req.getParameter("numDocu");
			String correo = req.getParameter("correo");
			String telefFijo = req.getParameter("telefFijo");
			String telefCell = req.getParameter("telefCell");
			String fechaModif = req.getParameter("fechaModif");
			String estado = req.getParameter("estado");
			
            String sestado = req.getParameter("estado");
			
			Integer iestado = null;
			if(sestado!=null){
				try{
					iestado = Integer.parseInt(sestado);
				}catch(Exception e){}
			}		
			
			DtUsuarioExternoFiltro dtUsuarioExternoFiltro = new DtUsuarioExternoFiltro(aPaterno,aMaterno,nombre,numDocu,correo,telefFijo,telefCell,fechaModif,estado,iestado);		
			
			DtUsuarioExternoData dtUsuarioExternoData = (DtUsuarioExternoData) req.getSession().getAttribute("DtUsuarioExternoData");
			if(dtUsuarioExternoData==null){
				dtUsuarioExternoData = new DtUsuarioExternoData();
				req.getSession().setAttribute("DtUsuarioExternoData",dtUsuarioExternoData);
			}
			
			DtUsuarioExternoLC dtUsuarioExternoLC = new DtUsuarioExternoLC();
			long inicio = System.currentTimeMillis();
			List<DtUsuarioExternoBk> dtUsuarioExternosss = dtUsuarioExternoData.getDtUsuarioExternoActivos(servicio,msUsuariosBk.getIdusuario());
			long lfinal =System.currentTimeMillis()-inicio;
			dtUsuarioExternoLC.setTiempoenBD(lfinal);
			
			if (req.isUserInRole(Roles.ADMINISTRADOR) || req.isUserInRole(Roles.DTUSUARIOEXTERNO_CREA)){
				dtUsuarioExternoLC.setCreamodifica(true);
			}			
			
			/////
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			List<DtUsuarioExternoBk> dtUsuarioExternosssData = new ArrayList<DtUsuarioExternoBk> ();
			if(dtUsuarioExternoFiltro.isActivo()){
			//filter
//				int contador = 0;
	        for(DtUsuarioExternoBk dtUsuarioExternoAct : dtUsuarioExternosss){
	            boolean match = true;	            
	            Field camposdea[] = dtUsuarioExternoFiltro.getClass().getDeclaredFields();
//	            if(dtUsuarioExternoAct.getIdUsuexterno.longValue()==56L){
//	            	System.out.println("AQUI....");
//	            }
				for (int i = 0; i < camposdea.length; i++) {
//					contador++;
//					System.out.println("Contador");
					String camponame = camposdea[i].getName();
					if(camponame.indexOf("serial")>-1 || camponame.indexOf("activo")>-1) continue;
					
					String filtroGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);					
					Class<?>[] types = new Class[] {};
					try {
						Method filtroMethod = dtUsuarioExternoFiltro.getClass().getMethod(filtroGetMetod, types);												
						Object filtroValue = filtroMethod.invoke(dtUsuarioExternoFiltro, new Object[0]);
						if(filtroValue==null) continue;
						else if(filtroValue.toString().length()<1) continue;
                                                
                                                if(primerregistro)
                                                filtrosaplicados.append(Messages.getStringToKey("dtUsuarioExterno."+camponame)).append("=").append(filtroValue).append(" ");

						Method claseMethod = dtUsuarioExternoAct.getClass().getMethod(claseGetMetod, types);
						Object claseValue = claseMethod.invoke(dtUsuarioExternoAct, new Object[0]);
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
					dtUsuarioExternosssData.add(dtUsuarioExternoAct);
	                        }
                        primerregistro = false;
	        }}else{
	        	dtUsuarioExternosssData = dtUsuarioExternosss;
	        }	 
	        //sort
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
	        if(sorder != null) {
	            Collections.sort(dtUsuarioExternosssData, new Comparator<DtUsuarioExternoBk>() {
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					public int compare(DtUsuarioExternoBk dtUsuarioExterno1, DtUsuarioExternoBk dtUsuarioExterno2) {	                	
	                	boolean sortorden = true;
	                	String order = sorder;
	                	if(order.startsWith("-")){
	                		sortorden = false;
	                		order = order.substring(1);
	                	}	                	
	                	try{
	                	String getMetod = "get" + Character.toUpperCase(order.charAt(0))+order.substring(1);
	                	Class<?>[] types = new Class[] {};
						Method method = DtUsuarioExternoBk.class.getMethod(getMetod, types);
						Object value1 = method.invoke(dtUsuarioExterno1, new Object[0]);
						Object value2 = method.invoke(dtUsuarioExterno2, new Object[0]);
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
	        int dataSize = dtUsuarioExternosssData.size();
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
	        dtUsuarioExternoLC.setContador(dataSize);
			
	        if(dataSize > pageSize) {
	        	int iniciodelista = ((first-1)*pageSize);
	            try {
	                dtUsuarioExternoLC.setData(dtUsuarioExternosssData.subList(iniciodelista, iniciodelista+pageSize));
	            }
	            catch(IndexOutOfBoundsException e) {
	            	dtUsuarioExternoLC.setData(dtUsuarioExternosssData.subList(iniciodelista, iniciodelista+(dataSize % pageSize)));
	            }
	        }else{
	        	dtUsuarioExternoLC.setData(dtUsuarioExternosssData);
	        }
	        lfinal =System.currentTimeMillis()-inicio;
			 System.out.println("EJECUCIÓN EN: "+(lfinal)+" MILISEGUNDOS.");
			 dtUsuarioExternoLC.setTiempoenproceso(lfinal);
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
                        String titulo = "USUARIOS EXTERNOS"
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

			List<String> caposvista = Arrays.asList("aPaterno","aMaterno","nombre","numDocu","correo","telefFijo","telefCell","fechaModif","estado");
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
				cellxX.setCellValue(Messages.getStringToKey("dtUsuarioExterno."+camponame));
				tituloscontador++;
			} 

                        int contador = 7;
			int contadorfor = 1;		
			for (DtUsuarioExternoBk dtUsuarioExternoBk : dtUsuarioExternosssData) {
				rowX = hoja.getRow(contador);
				styleUtils.copyRow(wb, hoja, contador, contador+1, null);
			
				Cell cellAAX = rowX.getCell(0);
				cellAAX.setCellValue(contadorfor);
				
				if(dtUsuarioExternoBk.getCclase()!=null){
					if(dtUsuarioExternoBk.getCclase().equals("cverde")){
						cellAAX.setCellStyle(cellStyleV);
					}else if(dtUsuarioExternoBk.getCclase().equals("camarillo")){
						cellAAX.setCellStyle(cellStyleA);
					}else if(dtUsuarioExternoBk.getCclase().equals("crojo")){
						cellAAX.setCellStyle(cellStyleR);
				}}
				
				int columna = 1;
				for (String camponame : caposvista) {
					String claseGetMetod = "get" + Character.toUpperCase(camponame.charAt(0))+ camponame.substring(1);
			        Class<?>[] types = new Class[] {};
			       try {
				        Method claseMethod = dtUsuarioExternoBk.getClass().getMethod(claseGetMetod, types);
				        Object claseValue = claseMethod.invoke(dtUsuarioExternoBk, new Object[0]);
				        Cell cellxX = rowX.getCell(columna);
                                          if (claseValue != null) {                                                
				        	if(cellxX==null){
								cellxX = rowX.createCell(columna);
							}
                                                columna++;
				        	cellxX.setCellStyle(cellStyleDATO);
				        	if (claseValue.getClass().getName().indexOf("Timestamp") > -1) {
				        		Timestamp valor = (Timestamp) claseValue;				        		
								cellxX.setCellValue(valor);
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
			String mensaje = e.getMessage();
			System.out.println("ERROR: " + mensaje);
			return Response.status(HttpURLConnection.HTTP_BAD_REQUEST).entity(
					new GenericEntity<RespuestaError>(new RespuestaError(mensaje, HttpURLConnection.HTTP_BAD_REQUEST)) {
					}).build();
		}
	}

}
