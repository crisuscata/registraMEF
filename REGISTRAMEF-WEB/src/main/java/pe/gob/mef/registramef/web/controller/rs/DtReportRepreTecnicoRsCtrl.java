package pe.gob.mef.registramef.web.controller.rs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.domain.ReporteAsistenciaDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacionDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteConsulta;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsSedesBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsSisAdmistrativoBk;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.web.controller.rs.data.RespuestaError;

@RestController
@Path("/ctrlDtReportRepreTecnico")
public class DtReportRepreTecnicoRsCtrl {
	
	@Autowired
	private Servicio servicio;
	
	
	

	@GET
	@Path("/descargarXLS")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response descargarFormato(@Context HttpServletRequest req, 
	                                 @Context HttpServletResponse res,
	                                 @HeaderParam("authorization") String authString
	                                 ) throws ParseException {
		
		
		String sfechaInicio = req.getParameter("fechaInicio");
		String sfechaFin = req.getParameter("fechaFin");
		Long idTipoServicio = Long.parseLong(req.getParameter("idTipoServicio"));
		Long idSede = Long.parseLong(req.getParameter("idSede"));
		Long idSisAdmin = Long.parseLong(req.getParameter("idSisAdmin"));
		Long idUserInt = Long.parseLong(req.getParameter("idUserInt"));
		Long idEstado = Long.parseLong(req.getParameter("idEstado"));
		boolean flagAsis = Boolean.getBoolean(req.getParameter("flagAsis"));
		
		
	 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date fechaInicio = null;
	    Date fechaFin = null;
	    
	    if (sfechaInicio != null) {
            fechaInicio = formatter.parse(sfechaInicio);
        }
        if (sfechaFin != null) {
            fechaFin = formatter.parse(sfechaFin);
        }
		
		
		
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
			
			Integer maxRegistro=30000; 
			
			Properties sistemaProperties = PropertiesMg.getSistemaProperties();
			
			if (sistemaProperties.getProperty("LIMITE_REGISTRO") == null || sistemaProperties.getProperty("LIMITE_REGISTRO").trim().length() < 1) {
				sistemaProperties.put("LIMITE_REGISTRO","30000");
				maxRegistro=30000;
				PropertiesMg.saveSistemaProperties(sistemaProperties);
			} else {
				maxRegistro = Integer.valueOf( sistemaProperties.getProperty("LIMITE_REGISTRO"));
			}
			
			Long idAsistencia = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_ASISTEN);
			Long idCapacitacion = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CAPA);
			Long idConsulta = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_CONSULTA);
			Long idVisita = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_SERVICIO_VISITA);
			
			String nombrePlantilla="";
			String nombreServicio="";
			if(idTipoServicio.longValue()==idAsistencia.longValue()){
				nombrePlantilla="PLANTILLA_REPRE_TEC_ASIS.xlsx";
				nombreServicio="Asistencia";
			}else if(idTipoServicio.longValue()==idCapacitacion.longValue()){
				nombrePlantilla="PLANTILLA_REPRE_TEC_CAPA.xlsx";
				nombreServicio="Capacitacion";
			}else if(idTipoServicio.longValue()==idConsulta.longValue()){
				nombrePlantilla="PLANTILLA_REPRE_TEC_CONSUL.xlsx";
				nombreServicio="Consulta";
			}else if(idTipoServicio.longValue()==idVisita.longValue()){
				nombrePlantilla="PLANTILLA_REPRE_TEC_VISITA.xlsx";
				nombreServicio="Visita";
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmss");
			//Long idusuario
			
			String directorio = "Reporte_"+nombreServicio +  msUsuariosBk.getIdusuario()+sdf.format(new Date());	
			Long flagUserHome = PropertiesMg.getSistemLong(PropertiesMg.KEY_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO,
					PropertiesMg.DEFAULT_FLAG_REPORTE_RESUMEN_USER_HOME_SI_UNO_NO_CERO);
			String nuevoDirectorio=null;
			if(flagUserHome.intValue()==1){
				 String home = System.getProperty("user.home", ".");		
				 nuevoDirectorio = home+System.getProperty("file.separator")+"REPORTE_RESUMEN"+System.getProperty("file.separator")+directorio;			
			}else{
				nuevoDirectorio= FuncionesStaticas.getRutaFileNameSistemaSearchSystem(directorio);
			}
			
			File F_RUTAROOT = new File(nuevoDirectorio);
			if (!F_RUTAROOT.exists()) {
				if (!F_RUTAROOT.mkdirs()) {
					//return;
				}
			}
			
			ClassLoader classLoader = this.getClass().getClassLoader();
			
			FileInputStream filePlantilla = new FileInputStream(classLoader.getResource(nombrePlantilla).getFile());
			
			String rutaArchivo = "";
			String nombreArchivo="";
			
			if(idTipoServicio.longValue()==idAsistencia.longValue()) {
				
				rutaArchivo = this.generarReporteAsistencia(filePlantilla, maxRegistro, nuevoDirectorio, fechaInicio, fechaFin, idTipoServicio, idSede, idSisAdmin, idUserInt, idEstado, msUsuariosBk.getIdusuario());
				nombreArchivo = "ReporteRepresentantesTecnicos_AsistenciasTecnicas.xls";
				
			} else if(idTipoServicio.longValue()==idCapacitacion.longValue()) {
				
				rutaArchivo = this.generarReporteCapacitacion(filePlantilla,maxRegistro,nuevoDirectorio, fechaInicio, fechaFin, idTipoServicio, idSede, idSisAdmin, idUserInt, idEstado, msUsuariosBk.getIdusuario(), flagAsis);
				nombreArchivo = "ReporteRepresentantesTecnicos_Capacitaciones.xls";
				
			} else if(idTipoServicio.longValue()==idConsulta.longValue()) {
				
				rutaArchivo = this.generarReporteConsulta(filePlantilla,maxRegistro,nuevoDirectorio, fechaInicio, fechaFin, idTipoServicio, idSede, idSisAdmin, idUserInt, idEstado, msUsuariosBk.getIdusuario());
				nombreArchivo = "ReporteRepresentantesTecnicos_Consultas.xls";
				
			} 
			
			ResponseBuilder rb = Response.ok(new File(rutaArchivo));
			rb.header("Content-Disposition", "attachment; filename= "+ nombreArchivo );
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
	

	private String generarReporteAsistencia(FileInputStream filePlantilla, 
										  Integer maxRegistro, 
										  String nuevoDirectorio,
										  Date fechaInicio,
										  Date fechaFin,
										  Long idTipoServicio,
										  Long idSede,
										  Long idSisAdmin,
										  Long idUserInt,
										  Long idEstado,
										  Long kyUsuarioMod
										  ) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		//file=null; 

		List<ReporteAsistenciaDetallado> reporteList=new ArrayList<ReporteAsistenciaDetallado>();
		Long totalRegistro=0L;
		try{
			totalRegistro=servicio.getTotalReporteAsistenciaDetalleBkList(fechaInicio, fechaFin, idSisAdmin, idSede, idUserInt, idEstado);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String nombrearchivo = null;
		
		SimpleDateFormat sdf = null;	
		SimpleDateFormat sdFH = null;
		String sfechaini = null;
		String sfechafin = null;
		Timestamp hoy = null;
		XSSFRow filaExcel = null;
		XSSFCell celdaExcel = null;
	
		XSSFWorkbook wb;
		XSSFSheet sheet;
		MsSisAdmistrativoBk   msSisAdm;
		MsSedesBk sedeBk;
		String strCriterioBusqueda;
		String fecha;
		String hora ;
		FileOutputStream output_file ;	
		
		int cantMax=maxRegistro.intValue();		
		int total = totalRegistro.intValue();
		int numVuelta=0;
		
		if (total > cantMax) {
			numVuelta = total / cantMax;
			if ((total % cantMax) > 0)
				numVuelta = numVuelta + 1;
		} else
			numVuelta = 1;
		
				
		for(int y=0;y<numVuelta;y++){
			
			try{
//				reporteList=servicio.getReporteAsistenciaDetalleBkList(fechaInicio, fechaFin, idSisAdmin, idSede,  (y == (numVuelta - 1) ? total - (y * cantMax) : cantMax),y * cantMax);
				reporteList=servicio.getReporteAsistenciaDetalleBkList(idEstado,idUserInt,fechaInicio, fechaFin, idSisAdmin, idSede,  (y == (numVuelta - 1) ? total - (y * cantMax) : cantMax),y * cantMax);//SPRINT_8.3
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		sdf = new SimpleDateFormat("yyyyMMddmmss");		
		nombrearchivo= nuevoDirectorio+ System.getProperty("file.separator")+ "Resu_part_"+(y+1)+"_de_"+numVuelta+"_" +kyUsuarioMod+ sdf.format(new Date())+".xlsx";
		//File fileAux = new File(nombrearchivo);
		//FuncionesStaticas.copyFile(filePlantilla, fileAux);
				
		
		hoy = new Timestamp(System.currentTimeMillis());
		sdf = new SimpleDateFormat("dd/MM/yyyy");		
		sfechaini = fechaInicio != null ? sdf.format(fechaInicio) : "";
		sfechafin = fechaFin != null ? sdf.format(fechaFin) : "";
						
			//FileInputStream inputfile = new FileInputStream(filePlantilla);
		
		
		
			 wb = new XSSFWorkbook(filePlantilla);
			int sheetIndxConsolidado = wb.getSheetIndex("DATO");
			 sheet = wb.getSheetAt(sheetIndxConsolidado);
		
			
			 fecha = sdf.format(hoy);
			sdf = new SimpleDateFormat("HH:mm:ss");
			 hora = sdf.format(hoy);

			int row = 0;
			int col = 20;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(fecha);
			
			filaExcel = sheet.getRow(++row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(hora);
				

	
			
			if (idSisAdmin!=null && idSisAdmin.longValue()>0)
				msSisAdm= this.servicio.getMsSisAdmistrativoBkXid(idSisAdmin);
			else 
				msSisAdm=null;
			
			if (idSede!=null && idSede.longValue()>0)
				sedeBk = this.servicio.getMsSedesBkXid(idSede);
			else
				sedeBk=null;
			
			
			strCriterioBusqueda = "DEL " + sfechaini + " AL " + sfechafin + " - "
					+ (sedeBk != null ? sedeBk.getSede().toUpperCase() : " TODAS LAS SEDES ") + " - "
					+ (msSisAdm != null ? msSisAdm.getDescripcion().toUpperCase()
							: " TODOS LOS SISTEMAS ADMINISTATIVOS ")
					+ " - USUARIO EXTERNO ";
			
			row=3;
			col = 0;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(strCriterioBusqueda);
						
		
			int i = 5;//fila		
			int dcount = 0; // columnas
			int items = 1;// correlativo

			sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdFH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
	
			for(ReporteAsistenciaDetallado reporteAsistenciaBk: reporteList)	{
					
				filaExcel = sheet.getRow(i);
				if (filaExcel == null && i!=5)
					filaExcel = copyRowXYStyle(wb, sheet, 5, i, null);
			
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getIdAsistencia() == null ? "": reporteAsistenciaBk.getIdAsistencia().toString()));
				
				//SPRINT01 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaSoli() == null ? "" : sdf.format(reporteAsistenciaBk.getFechaSoli())));
				
				//SPRINT01  FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaAsistencia() == null ? "" : sdf.format(reporteAsistenciaBk.getFechaAsistencia())));
				
				//SPRINT_4 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);				
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);	
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaAsistencia() == null ? "" : FuncionesStaticas.getMonthName(reporteAsistenciaBk.getFechaAsistencia(),false)));
							
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaReprog() == null ? "" : sdf.format(reporteAsistenciaBk.getFechaReprog())));

				//SPRINT_4 FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getModalidad() == null ? "" : reporteAsistenciaBk.getModalidad()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getOrigen() == null ? "" : reporteAsistenciaBk.getOrigen()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getProgramacion() == null ? "" : reporteAsistenciaBk.getProgramacion()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFinanciamiento() == null ? "" : reporteAsistenciaBk.getFinanciamiento()));
				
				//SPRINT_4 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getDepartamentoEnt() == null ? "" : reporteAsistenciaBk.getDepartamentoEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getProvinciaEnt() == null ? "" : reporteAsistenciaBk.getProvinciaEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getDistritoEnt() == null ? "" : reporteAsistenciaBk.getDistritoEnt()));

				
				//SPRINT_4 FIN
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getCodEjecutora() == null ? "" : reporteAsistenciaBk.getCodEjecutora()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getEntidad() == null ? "" : reporteAsistenciaBk.getEntidad()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getTipoEntidad() == null ? "" : reporteAsistenciaBk.getTipoEntidad()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue(
						(reporteAsistenciaBk.getTema() == null ? "" : reporteAsistenciaBk.getTema()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getSubtema()== null ? "" : reporteAsistenciaBk.getSubtema()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getDetalle() == null ? "" : reporteAsistenciaBk.getDetalle()));				
				
//				dcount++;
//				celdaExcel = filaExcel.getCell(dcount);
//				if(celdaExcel==null)
//					celdaExcel=filaExcel.createCell(dcount);
//				celdaExcel.setCellValue((reporteAsistenciaBk.getEstadoTema() == null ? "" : reporteAsistenciaBk.getEstadoTema()));
//				SPRINT02 inicio
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getUserCrea() == null ? "" : reporteAsistenciaBk.getUserCrea()));
				
				//sprint01 inicio
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getUsuarioInterno() == null ? "" : reporteAsistenciaBk.getUsuarioInterno()));
				//sprint01 fin
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getSistAdmin() == null ? "" : reporteAsistenciaBk.getSistAdmin()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getSede() == null ? "" : reporteAsistenciaBk.getSede()));
				
				//SPRINT02  FIN

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaCrea() == null ? "" : sdFH.format(reporteAsistenciaBk.getFechaCrea())));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getEstado() == null ? "" : reporteAsistenciaBk.getEstado()));

				
//				dcount++;
//				celdaExcel = filaExcel.getCell(dcount);
//				if(celdaExcel==null)
//					celdaExcel=filaExcel.createCell(dcount);
//				celdaExcel.setCellValue((reporteAsistenciaBk.getIdEstado() == null ? "" : reporteAsistenciaBk.getIdEstado().toString()));

			
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getParticipante() == null ? "" : reporteAsistenciaBk.getParticipante()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getDni() == null ? "" : reporteAsistenciaBk.getDni()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getCargo() == null ? "" : reporteAsistenciaBk.getCargo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getCorreo() == null ? "" : reporteAsistenciaBk.getCorreo()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getTelefonoFijo() == null ? "" : reporteAsistenciaBk.getTelefonoFijo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getTelefonoCelular() == null ? "" : reporteAsistenciaBk.getTelefonoCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getOtroCelular() == null ? "" : reporteAsistenciaBk.getOtroCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getOtroTelefono() == null ? "" : reporteAsistenciaBk.getOtroTelefono()));

				//SPRINT02 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getControlConfirmacion_txt() == null ? "" : reporteAsistenciaBk.getControlConfirmacion_txt()));
				//SPRINT02 FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteAsistenciaBk.getFechaFinalizacion() == null ? "" : sdFH.format(reporteAsistenciaBk.getFechaFinalizacion())));

//				dcount++;
//				celdaExcel = filaExcel.getCell(dcount);
//				if(celdaExcel==null)
//					celdaExcel=filaExcel.createCell(dcount);
//				celdaExcel.setCellValue((reporteAsistenciaBk.getEstadoParti() == null ? "" : reporteAsistenciaBk.getEstadoParti()));
				
				dcount = 0;
								
				items++;
				i++;
			}		
				filePlantilla.close();
				output_file= new FileOutputStream(nombrearchivo);
				wb.write(output_file);
				output_file.close(); 	
			
			}
				reporteList=null;
				
			return nombrearchivo;	
	}
	
	private List<ReporteCapacitacionDetallado> getListCapa(List<ReporteCapacitacionDetallado> reporteList){
		
		List<ReporteCapacitacionDetallado> detailedReportList = reporteList.stream()
			    .collect(Collectors.groupingBy(
			        ReporteCapacitacionDetallado::getIdCapacitacion,  
			        Collectors.mapping(                               
			            r -> new AbstractMap.SimpleEntry<>(r.getTema(), r),  
			            Collectors.toSet()  
			        )
			    ))
			    .entrySet().stream()
			    .map(entry -> {
			        Long idCapacitacion = entry.getKey();

			        Map<String, Set<ReporteCapacitacionDetallado>> temasWithDetails = entry.getValue().stream()
			            .collect(Collectors.groupingBy(
			                Map.Entry::getKey,  
			                Collectors.mapping(Map.Entry::getValue, Collectors.toSet()) 
			            ));

			        String temasConcatenated = temasWithDetails.keySet().stream()
			            .collect(Collectors.joining(", "));  

			        String subtemasConcatenated = temasWithDetails.values().stream()
			            .flatMap(set -> set.stream().map(ReporteCapacitacionDetallado::getSubtema)) 
			            .distinct()  
			            .collect(Collectors.joining(", ")); 

			        String sistAdminConcatenated = temasWithDetails.values().stream()
			            .flatMap(set -> set.stream().map(ReporteCapacitacionDetallado::getSistAdmin))  
			            .distinct()  
			            .collect(Collectors.joining(", "));  

			        String gestEspImplConcatenated = temasWithDetails.values().stream()
			            .flatMap(set -> set.stream().map(ReporteCapacitacionDetallado::getGestEspImpl))  
			            .distinct()  
			            .collect(Collectors.joining(", "));  

			        ReporteCapacitacionDetallado representative = temasWithDetails.values().stream()
			            .flatMap(Set::stream)
			            .findFirst()
			            .orElse(null); 

			        return new ReporteCapacitacionDetallado(
			        	    idCapacitacion,                  
			        	    temasConcatenated,               
			        	    subtemasConcatenated,            
			        	    sistAdminConcatenated,           
			        	    gestEspImplConcatenated,         

			        	    representative.getNomEvento(),       // nomEvento
			        	    representative.getFechaInic(),       // fechaInic
			        	    representative.getFechaFin(),        // fechaFin
			        	    representative.getOrigen(),          // origen
			        	    representative.getModo(),            // modo
			        	    representative.getProgramacion(),    // programacion
			        	    representative.getFinanciamiento(),  // financiamiento
			        	    representative.getLocal(),           // local
			        	    representative.getCantPartic(),      // cantPartic
			        	    representative.getCantParticAsist(), // cantParticAsist
			        	    representative.getNivel(),           // nivel
			        	    representative.getPrestacion(),      // prestacion
			        	    representative.getTipo(),            // tipo
			        	    representative.getSisAdmPonente(),   // sisAdmPonente
			        	    representative.getUserCrea(),        // userCrea
			        	    representative.getSede(),            // sede
			        	    representative.getIdSistAdmin(),     // idSistAdmin
			        	    representative.getAbreviaturaAdmin(),// abreviaturaAdmin
			        	    representative.getFechaCrea(),       // fechaCrea
			        	    representative.getEstado(),          // estado
			        	    representative.getIdCapaPadre(),     // idCapaPadre
			        	    representative.getParticipante(),    // participante
			        	    representative.getDni(),             // dni
			        	    representative.getCargo(),           // cargo
			        	    representative.getTelefonoFijo(),    // telefonoFijo
			        	    representative.getTelefonoCelular(), // telefonoCelular
			        	    representative.getOtroCelular(),     // otroCelular
			        	    representative.getOtroTelefono(),    // otroTelefono
			        	    representative.getEntidad(),         // entidad
			        	    representative.getCodEjecut(),       // codEjecut
			        	    representative.getIdUsuExtern(),     // idUsuExtern
			        	    representative.getCorreoParti(),     // correoParti
			        	    representative.getAsitio(),          // asitio
			        	    representative.getConfirmar(),       // confirmar
			        	    representative.getEnlaceConeVirtual(),// enlaceConeVirtual
			        	    representative.getPublicado(),       // publicado
			        	    representative.getModalidad(),       // modalidad
			        	    representative.getFechaFinalizacion(),// fechaFinalizacion
			        	    representative.getDepartamentoEnt(),  // departamentoEnt
			        	    representative.getProvinciaEnt(),     // provinciaEnt
			        	    representative.getDistritoEnt(),      // distritoEnt
			        	    representative.getFechaInicRepro(),   // fechaInicRepro
			        	    representative.getFechaFinRepro(),    // fechaFinRepro
			        	    representative.getFechaSoli(),        // fechaSoli
			        	    representative.getHojaRuta(),         // hojaRuta
			        	    representative.getModalidadIng(),     // modalidadIng
			        	    representative.getMotivoEjecucion(),  // motivoEjecucion
			        	    representative.getFlagEjecucion()     // flagEjecucion
			        	);

			    })
			    .collect(Collectors.toList());
		
		return detailedReportList;
	}
		
	private String generarReporteCapacitacion(FileInputStream filePlantilla, Integer maxRegistro, String nuevoDirectorio, Date fechaInicio,
			  Date fechaFin,
			  Long idTipoServicio,
			  Long idSede,
			  Long idSisAdmin,
			  Long idUserInt,
			  Long idEstado,
			  Long kyUsuarioMod, boolean flagAsis) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		List<ReporteCapacitacionDetallado> reporteList=new ArrayList<ReporteCapacitacionDetallado>();
		Long totalRegistro=0L;
		
		try{		
			totalRegistro=servicio.getTotalResumenCapacitacionDetallado(fechaInicio, fechaFin, idSisAdmin, idSede,idUserInt,idEstado,flagAsis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		String nombrearchivo="";
		
		SimpleDateFormat sdf = null;	
		SimpleDateFormat sdFH = null;
		String sfechaini = null;
		String sfechafin = null;
		Timestamp hoy = null;
		XSSFRow filaExcel = null;
		XSSFCell celdaExcel = null;
	
		XSSFWorkbook wb;
		XSSFSheet sheet;
		MsSisAdmistrativoBk   msSisAdm;
		MsSedesBk sedeBk;
		String strCriterioBusqueda;
		String fecha;
		String hora ;		
		int cantMax=maxRegistro.intValue();
		FileOutputStream output_file =null;		
		int total = totalRegistro.intValue();

		int numVuelta=0;
		
		if (total > cantMax) {
			numVuelta = total / cantMax;
			if ((total % cantMax) > 0)
				numVuelta = numVuelta + 1;
		} else
			numVuelta = 1;
		
				
		for(int y=0;y<numVuelta;y++){
		
			try{			
				reporteList=servicio.getResumenCapacitacionDetallado(idUserInt,idEstado,flagAsis,fechaInicio, fechaFin, idSisAdmin, idSede, (y == (numVuelta - 1) ? total - (y * cantMax) : cantMax),y * cantMax);
				
				reporteList =	this.getListCapa(reporteList);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		sdf = new SimpleDateFormat("yyyyMMddmmss");		
		nombrearchivo= nuevoDirectorio+ System.getProperty("file.separator")+ "Resu_part_"+(y+1)+"_de_"+numVuelta+"_" +kyUsuarioMod+ sdf.format(new Date())+".xlsx";

		hoy = new Timestamp(System.currentTimeMillis());
		sdf = new SimpleDateFormat("dd/MM/yyyy");		
		sfechaini = fechaInicio != null ? sdf.format(fechaInicio) : "";
		sfechafin = fechaFin != null ? sdf.format(fechaFin) : "";
						
		

			//FileInputStream inputfile = new FileInputStream(filePlantilla);
			 wb = new XSSFWorkbook(filePlantilla);
			int sheetIndxConsolidado = wb.getSheetIndex("DATO");
			 sheet = wb.getSheetAt(sheetIndxConsolidado);
		
			
			 fecha = sdf.format(hoy);
			sdf = new SimpleDateFormat("HH:mm:ss");
			 hora = sdf.format(hoy);

			int row = 0;
			int col = 20;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(fecha);
			
			filaExcel = sheet.getRow(++row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(hora);
				

			
			if (idSisAdmin!=null && idSisAdmin.longValue()>0)
				msSisAdm= this.servicio.getMsSisAdmistrativoBkXid(idSisAdmin);
			else 
				msSisAdm=null;
			
			if (idSede!=null && idSede.longValue()>0)
				sedeBk = this.servicio.getMsSedesBkXid(idSede);
			else
				sedeBk=null;
			
			
			 strCriterioBusqueda= "DEL "+sfechaini+" AL "+sfechafin+" - " +(sedeBk!=null?sedeBk.getSede().toUpperCase():" TODAS LAS SEDES ")+
			" - "+(msSisAdm!=null?msSisAdm.getDescripcion().toUpperCase():" TODOS LOS SISTEMAS ADMINISTATIVOS ")+" - USUARIO EXTERNO ";
			
			row=3;
			col = 0;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(strCriterioBusqueda);
						
		
			int i = 5;//fila		
			int dcount = 0; // columnas
			int items = 1;// correlativo

			sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdFH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

				for (ReporteCapacitacionDetallado reporteBk: reporteList) {
			
			
				
				filaExcel = sheet.getRow(i);
				if (filaExcel == null && i!=5)
					filaExcel = copyRowXYStyle(wb, sheet, 5, i, null);
			
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getIdCapacitacion() == null ? "": reporteBk.getIdCapacitacion().toString()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getNomEvento() == null ? "": reporteBk.getNomEvento().toString()));
				
				//SPRINT01 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaSoli() == null ? "": sdf.format(reporteBk.getFechaSoli())));
				//SPRINT01 FIN
				//SPRINT02 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getHojaRuta() == null ? "": reporteBk.getHojaRuta()));
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFlagEjecucion() == null ? "": reporteBk.getFlagEjecucion()));
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getMotivoEjecucion() == null ? "": reporteBk.getMotivoEjecucion()));
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getModalidadIng() == null ? "":reporteBk.getModalidadIng()));
				
				//SPRINT02 FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaInic() == null ? "" : sdFH.format(reporteBk.getFechaInic())));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaFin() == null ? "" : sdFH.format(reporteBk.getFechaFin())));
				//SPRINT_4 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaInic() == null ? "" : FuncionesStaticas.getMonthName(reporteBk.getFechaInic(),false)));
					
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaInicRepro() == null ? "" : sdFH.format(reporteBk.getFechaInicRepro())));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaFinRepro() == null ? "" : sdFH.format(reporteBk.getFechaFinRepro())));
				
				
				//SPRINT_4 FIN
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getOrigen() == null ? "" : reporteBk.getOrigen()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getModo() == null ? "" : reporteBk.getModo()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getProgramacion() == null ? "" : reporteBk.getProgramacion()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFinanciamiento() == null ? "" : reporteBk.getFinanciamiento()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getLocal() == null ? "" : reporteBk.getLocal()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCantPartic() == null ? "" : reporteBk.getCantPartic().toString()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCantParticAsist() == null ? "" : reporteBk.getCantParticAsist().toString()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getNivel() == null ? "" : reporteBk.getNivel()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getPrestacion() == null ? "" : reporteBk.getPrestacion()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTipo() == null ? "" : reporteBk.getTipo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getGestEspImpl() == null ? "" : reporteBk.getGestEspImpl()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSisAdmPonente() == null ? "" : reporteBk.getSisAdmPonente()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTema() == null ? "" : reporteBk.getTema()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSubtema() == null ? "" : reporteBk.getSubtema()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getUserCrea() == null ? "" : reporteBk.getUserCrea()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSede() == null ? "" : reporteBk.getSede()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSistAdmin() == null ? "" : reporteBk.getSistAdmin()));

				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaCrea() == null ? "" :sdFH.format(reporteBk.getFechaCrea())));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEstado() == null ? "" : reporteBk.getEstado()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getIdCapaPadre() == null ? "" : reporteBk.getIdCapaPadre().toString()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getParticipante() == null ? "" : reporteBk.getParticipante()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDni() == null ? "" : reporteBk.getDni()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCargo() == null ? "" : reporteBk.getCargo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTelefonoFijo() == null ? "" : reporteBk.getTelefonoFijo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTelefonoCelular() == null ? "" : reporteBk.getTelefonoCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getOtroCelular() == null ? "" : reporteBk.getOtroCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getOtroTelefono() == null ? "" : reporteBk.getOtroTelefono()));
				
				//SPRINT_4 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDepartamentoEnt() == null ? "" : reporteBk.getDepartamentoEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getProvinciaEnt() == null ? "" : reporteBk.getProvinciaEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDistritoEnt() == null ? "" : reporteBk.getDistritoEnt()));

			
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEntidad() == null ? "" : reporteBk.getEntidad()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCodEjecut() == null ? "" : reporteBk.getCodEjecut()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getIdUsuExtern() == null ? "" : reporteBk.getIdUsuExtern().toString()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCorreoParti() == null ? "" : reporteBk.getCorreoParti()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getAsitio() == null ? "" : reporteBk.getAsitio()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getConfirmar() == null ? "" : reporteBk.getConfirmar()));

				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEnlaceConeVirtual() == null ? "" : reporteBk.getEnlaceConeVirtual()));
				
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getPublicado() == null ? "" : reporteBk.getPublicado()));
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getModalidad() == null ? "" : reporteBk.getModalidad()));
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaFinalizacion() == null ? "" : sdFH.format(reporteBk.getFechaFinalizacion())));
				
				
				dcount = 0;
								
				items++;
				i++;
			}		
				
				filePlantilla.close();
				output_file= new FileOutputStream(nombrearchivo);
				wb.write(output_file);
				output_file.close(); 	
			
			}
			reporteList=null;
		
			return nombrearchivo;
	}
	
	private String generarReporteConsulta(FileInputStream filePlantilla, Integer maxRegistro, String nuevoDirectorio, Date fechaInicio,
			  Date fechaFin,
			  Long idTipoServicio,
			  Long idSede,
			  Long idSisAdmin,
			  Long idUserInt,
			  Long idEstado,
			  Long kyUsuarioMod) throws IOException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		List<ReporteConsulta> reporteList=new ArrayList<ReporteConsulta>();
		Long totalRegistro=0L;
		try{
			totalRegistro=servicio.getTotalResumenConsultas(fechaInicio, fechaFin, idSisAdmin, idSede, idUserInt,idEstado);//SPRINT_8.3
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String nombrearchivo="";
		
		SimpleDateFormat sdf = null;	
		SimpleDateFormat sdFH = null;
		String sfechaini = null;
		String sfechafin = null;
		Timestamp hoy = null;
		XSSFRow filaExcel = null;
		XSSFCell celdaExcel = null;
	
		XSSFWorkbook wb;
		XSSFSheet sheet;
		MsSisAdmistrativoBk   msSisAdm;
		MsSedesBk sedeBk;
		String strCriterioBusqueda;
		String fecha;
		String hora ;
		
		int cantMax=maxRegistro.intValue();
		FileOutputStream output_file ;		
		int total = totalRegistro.intValue();

		int numVuelta=0;
		
		if (total > cantMax) {
			numVuelta = total / cantMax;
			if ((total % cantMax) > 0)
				numVuelta = numVuelta + 1;
		} else
			numVuelta = 1;
		
				
		for(int y=0;y<numVuelta;y++){		
			
			try{
				reporteList=servicio.getResumenConsultas(idEstado,idUserInt, fechaInicio, fechaFin, idSisAdmin, idSede,  (y == (numVuelta - 1) ? total - (y * cantMax) : cantMax),y * cantMax);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		sdf = new SimpleDateFormat("yyyyMMddmmss");		
		nombrearchivo= nuevoDirectorio+ System.getProperty("file.separator")+ "Resu_part_"+(y+1)+"_de_"+numVuelta+"_" +kyUsuarioMod+ sdf.format(new Date())+".xlsx";
		//File fileAux = new File(nombrearchivo);
		//FuncionesStaticas.copyFile(filePlantilla, fileAux);
				

		
		
		hoy = new Timestamp(System.currentTimeMillis());
		sdf = new SimpleDateFormat("dd/MM/yyyy");		
		sfechaini = fechaInicio != null ? sdf.format(fechaInicio) : "";
		sfechafin = fechaFin != null ? sdf.format(fechaFin) : "";
						
		

		//FileInputStream inputfile = new FileInputStream(fileAux);
		wb= new XSSFWorkbook(filePlantilla);	
		sheet = wb.getSheetAt(wb.getSheetIndex("DATO"));
		
			
		fecha= sdf.format(hoy);
			sdf = new SimpleDateFormat("HH:mm:ss");
			hora= sdf.format(hoy);

			int row = 0;
			int col = 20;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(fecha);
			
			filaExcel = sheet.getRow(++row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(hora);
				

			
			
			if (idSisAdmin!=null && idSisAdmin.longValue()>0)
				msSisAdm= this.servicio.getMsSisAdmistrativoBkXid(idSisAdmin);
			else 
				msSisAdm=null;
			
			if (idSede!=null && idSede.longValue()>0)
				sedeBk = this.servicio.getMsSedesBkXid(idSede);
			else
				sedeBk=null;
			
			
			strCriterioBusqueda= "DEL "+sfechaini+" AL "+sfechafin+" - " +(sedeBk!=null?sedeBk.getSede().toUpperCase():" TODAS LAS SEDES ")+
			" - "+(msSisAdm!=null?msSisAdm.getDescripcion().toUpperCase():" TODOS LOS SISTEMAS ADMINISTATIVOS ")+" - USUARIO EXTERNO ";
			
			row=3;
			col = 0;
			
			filaExcel = sheet.getRow(row);
			celdaExcel = filaExcel.getCell(col);
			if(celdaExcel==null)
				celdaExcel=filaExcel.createCell(col);
			celdaExcel.setCellValue(strCriterioBusqueda);
						
		
			int i = 5;//fila		
			int dcount = 0; // columnas
			int items = 1;// correlativo

			sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdFH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			for (ReporteConsulta reporteBk: reporteList) {		
			
				filaExcel = sheet.getRow(i);
				if (filaExcel == null && i!=5)
					filaExcel = copyRowXYStyle(wb, sheet, 5, i, null);
			
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getIdConsulta() == null ? "": reporteBk.getIdConsulta().toString()));
				
				//SPRINT_4 INICIO
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDepartamentoEnt() == null ? "": reporteBk.getDepartamentoEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getProvinciaEnt() == null ? "": reporteBk.getProvinciaEnt()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDistritoEnt() == null ? "": reporteBk.getDistritoEnt()));

				//SPRINT_4 FIN

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEntidad() == null ? "": reporteBk.getEntidad()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEjecutora() == null ? "" : reporteBk.getEjecutora()));
				
				//SPRINT01 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaSoli() == null ? "" : sdf.format(reporteBk.getFechaSoli())));
				//SPRINT01  FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaConsu() == null ? "" : sdf.format(reporteBk.getFechaConsu())));
				
				//SPRINT_4 INICIO
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaConsu() == null ? "" : FuncionesStaticas.getMonthName(reporteBk.getFechaConsu(),false) ));
				
				//SPRINT_4 FIN
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getModalidad() == null ? "" : reporteBk.getModalidad()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTema() == null ? "" : reporteBk.getTema()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSubtema() == null ? "" : reporteBk.getSubtema()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getRespuesta() == null ? "" : reporteBk.getRespuesta()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getEstado() == null ? "" : reporteBk.getEstado()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getUserCrea() == null ? "" : reporteBk.getUserCrea()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaCrea()== null ? "" :sdFH.format( reporteBk.getFechaCrea())));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSede() == null ? "" : reporteBk.getSede()));
				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getSistAdmin() == null ? "" : reporteBk.getSistAdmin()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getParticipante() == null ? "" : reporteBk.getParticipante()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getDni() == null ? "" : reporteBk.getDni()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCargo() == null ? "" : reporteBk.getCargo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getCorreo() == null ? "" : reporteBk.getCorreo()));

				
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTelefonoFijo() == null ? "" : reporteBk.getTelefonoFijo()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getTelefonoCelular() == null ? "" : reporteBk.getTelefonoCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getOtroCelular() == null ? "" : reporteBk.getOtroCelular()));

				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getOtroTelefono() == null ? "" : reporteBk.getOtroTelefono()));

						
				dcount++;
				celdaExcel = filaExcel.getCell(dcount);
				if(celdaExcel==null)
					celdaExcel=filaExcel.createCell(dcount);
				celdaExcel.setCellValue((reporteBk.getFechaFinalizacion() == null ? "" : sdFH.format(reporteBk.getFechaFinalizacion())));
				
				
				dcount = 0;
								
				items++;
				i++;
			}					
			output_file= new FileOutputStream(nombrearchivo);
			wb.write(output_file);
			output_file.close(); 	
		
		}
		
			return nombrearchivo;
			
	}
	
	private XSSFRow copyRowXYStyle(XSSFWorkbook workbook, XSSFSheet worksheet, int sourceRowNum, int destinationRowNum, XSSFCellStyle newCellStyleComun) {

		XSSFRow newRow = worksheet.getRow(destinationRowNum);
		XSSFRow sourceRow = worksheet.getRow(sourceRowNum);

		if (newRow != null) {
			worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
		} else {
			newRow = worksheet.createRow(destinationRowNum);
		}

		if (sourceRow == null) {
			sourceRow = worksheet.createRow(sourceRowNum);
		}
		for (int i = 0; i < sourceRow.getLastCellNum(); i++) {

			XSSFCell oldCell = sourceRow.getCell(i);
			XSSFCell newCell = newRow.createCell(i);
			if (oldCell == null) {
				newCell = null;
				continue;
			}

			XSSFCellStyle newCellStyle = null;
			if (newCellStyleComun == null) {
				newCellStyle = oldCell.getCellStyle();
			} else {
				newCellStyle = newCellStyleComun;
			}

			newCell.setCellStyle(newCellStyle);

			if (oldCell.getCellComment() != null) {
				newCell.setCellComment(oldCell.getCellComment());
			}

			if (oldCell.getHyperlink() != null) {
				newCell.setHyperlink(oldCell.getHyperlink());
			}

			newCell.setCellType(oldCell.getCellType());
		}
		return newRow;
	}

}
