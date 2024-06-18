package pe.gob.mef.registramef.bs.val.validator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.domain.DtAsistencia;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_ASISTENCIA SERVICIO VALIDACIÓN: ALMACENA LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA "ASISTENCIA TÉCNICA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtAsistenciaMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtAsistenciaMng.class.getName());
	
	public static void validarDtAsistenciaBk (DtAsistenciaBk dtAsistenciaBk, DtAmpliacionFecha autorizacionProgramacion, 
			DtAmpliacionFecha autorizacionEjecucion, boolean esAdminOGC, DtAsistencia dtAsistenciaOrig)
	 throws Validador
	{
		
		//MPINARES 24012023 - INICIO
				validarFechaSoli(dtAsistenciaBk.getFechaSoli());
				validarFechaAsistencia(dtAsistenciaBk.getFechaAsistencia());
				validarDtCapacitacionFechaSoliAntesFechaServicio(dtAsistenciaBk.getFechaSoli(),dtAsistenciaBk.getFechaAsistencia());
				validarIdModalidad(dtAsistenciaBk.getIdModalidad());
				validarIdFinancia(dtAsistenciaBk.getIdFinancia());
				validarIdEntidad(dtAsistenciaBk.getIdEntidad());
				
				if(dtAsistenciaBk.getIdProgramacion()!=null){
					validarFechaServicioMensual(dtAsistenciaBk,autorizacionEjecucion, autorizacionProgramacion, dtAsistenciaOrig);
				}
				
				//MPINARES 24012023 - FIN
				
                //FORANEAS
                if(dtAsistenciaBk.getEstado()!=null && dtAsistenciaBk.getEstado().longValue()<=0){
			dtAsistenciaBk.setEstado(null);
		}
	        if(dtAsistenciaBk.getIdUsuinterno()!=null && dtAsistenciaBk.getIdUsuinterno().longValue()<=0){
			dtAsistenciaBk.setIdUsuinterno(null);
		}
	        if(dtAsistenciaBk.getIdEntidad()!=null && dtAsistenciaBk.getIdEntidad().longValue()<=0){
			dtAsistenciaBk.setIdEntidad(null);
		}
	        if(dtAsistenciaBk.getIdOrigen()!=null && dtAsistenciaBk.getIdOrigen().longValue()<=0){
			dtAsistenciaBk.setIdOrigen(null);
		}
	        if(dtAsistenciaBk.getIdProgramacion()!=null && dtAsistenciaBk.getIdProgramacion().longValue()<=0){
			dtAsistenciaBk.setIdProgramacion(null);
		}
	        if(dtAsistenciaBk.getIdModalidad()!=null && dtAsistenciaBk.getIdModalidad().longValue()<=0){
			dtAsistenciaBk.setIdModalidad(null);
		}
	        if(dtAsistenciaBk.getIdSede()!=null && dtAsistenciaBk.getIdSede().longValue()<=0){
			dtAsistenciaBk.setIdSede(null);
		}
	        if(dtAsistenciaBk.getIdSistAdm()!=null && dtAsistenciaBk.getIdSistAdm().longValue()<=0){
			dtAsistenciaBk.setIdSistAdm(null);
		}
	        if(dtAsistenciaBk.getIdFinancia()!=null && dtAsistenciaBk.getIdFinancia().longValue()<=0){
			dtAsistenciaBk.setIdFinancia(null);
		}
	        
		

		
		if(dtAsistenciaBk.getDetalle()!=null){
				if(dtAsistenciaBk.getDetalle().trim().length()>300)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtAsistencia.noexceder"),
							Messages.getStringToKey("dtAsistencia.detalle"),
							Messages.getStringToKey("dtAsistencia.titulotabla"),
							300,
							Messages.getStringToKey("dtAsistencia.articuloDetalle")
									));				
				}

		
		
		
		
		
		

				
	}

	public static void validarFechaAsistencia(Timestamp fechaAsistencia)
	 throws Validador
	{				
					if(fechaAsistencia==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
			Messages.getStringToKey("dtAsistencia.fechaAsistencia"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloFechaAsistencia")));
		}
	
	public static void validarDetalle(String detalle)
	 throws Validador
	{					
			if(detalle==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.ingrese"),
			Messages.getStringToKey("dtAsistencia.detalle"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloDetalle")));
			if(detalle.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
			Messages.getStringToKey("dtAsistencia.detalle"),
			Messages.getStringToKey("dtAsistencia.titulotabla")));						
			if(detalle!=null){
				if(detalle.trim().length()>300)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.noexceder"),
			Messages.getStringToKey("dtAsistencia.detalle"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),300,
			Messages.getStringToKey("dtAsistencia.articuloDetalle")));
				}
	}
	
	
	
	
	
	
	public static void validarIdUsuinterno(Long idUsuinterno)
	 throws Validador
	{				
					if(idUsuinterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.seleccione"),
			Messages.getStringToKey("dtAsistencia.idUsuinterno"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdUsuinterno")));
			if(idUsuinterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoseleccione"),
			Messages.getStringToKey("dtAsistencia.idUsuinterno"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdUsuinterno")));			
	}
	public static void validarIdEntidad(Long idEntidad)
			 throws Validador
				{				
								if(idEntidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
						Messages.getStringToKey("dtAsistencia.idEntidad"),
						Messages.getStringToKey("dtAsistencia.titulotabla"),
						Messages.getStringToKey("dtAsistencia.articuloIdEntidad")));
					}
	
	public static void validarIdOrigen(Long idOrigen)
			 throws Validador
				{				
								if(idOrigen==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
						Messages.getStringToKey("dtAsistencia.idOrigen"),
						Messages.getStringToKey("dtAsistencia.titulotabla"),
						Messages.getStringToKey("dtAsistencia.articuloIdOrigen")));
					}
	
	
	public static void validarIdProgramacion(Long idProgramacion)
	 throws Validador
	{				
					if(idProgramacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.seleccione"),
			Messages.getStringToKey("dtAsistencia.idProgramacion"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdProgramacion")));
			if(idProgramacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoseleccione"),
			Messages.getStringToKey("dtAsistencia.idProgramacion"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdProgramacion")));			
	}
	
	
	public static void validarIdModalidad(Long idModalidad)
			 throws Validador
				{				
								if(idModalidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
						Messages.getStringToKey("dtAsistencia.idModalidad"),
						Messages.getStringToKey("dtAsistencia.titulotabla"),
						Messages.getStringToKey("dtAsistencia.articuloIdModalidad")));
					}
	
	
	public static void validarIdSede(Long idSede)
	 throws Validador
	{				
					if(idSede==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.seleccione"),
			Messages.getStringToKey("dtAsistencia.idSede"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdSede")));
			if(idSede.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoseleccione"),
			Messages.getStringToKey("dtAsistencia.idSede"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdSede")));			
	}
	
	public static void validarIdSistAdm(Long idSistAdm)
	 throws Validador
	{				
					if(idSistAdm==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.seleccione"),
			Messages.getStringToKey("dtAsistencia.idSistAdm"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdSistAdm")));
			if(idSistAdm.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoseleccione"),
			Messages.getStringToKey("dtAsistencia.idSistAdm"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloIdSistAdm")));			
	}
	public static void validarIdFinancia(Long idFinancia)
			 throws Validador
				{				
								if(idFinancia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
						Messages.getStringToKey("dtAsistencia.idFinancia"),
						Messages.getStringToKey("dtAsistencia.titulotabla"),
						Messages.getStringToKey("dtAsistencia.articuloIdFinancia")));
					}
	
	
	public static void validarFechaFinalizacion(Timestamp fechaFinalizacion)
	 throws Validador
	{				
					if(fechaFinalizacion==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
			Messages.getStringToKey("dtAsistencia.fechaFinalizacion"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloFechaFinalizacion")));
		}
	
	public static void validarFechaProgramada(Timestamp fechaProgramada)
	 throws Validador
	{				
					if(fechaProgramada==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
			Messages.getStringToKey("dtAsistencia.fechaProgramada"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloFechaProgramada")));
		}
	
	public static void validarFechaSoli(Timestamp fechaSoli)
	 throws Validador
	{				
					if(fechaSoli==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtAsistencia.invalidoingrese"),
			Messages.getStringToKey("dtAsistencia.fechaSoli"),
			Messages.getStringToKey("dtAsistencia.titulotabla"),
			Messages.getStringToKey("dtAsistencia.articuloFechaSoli")));
		}
	
	//MPINARES 24012023 - INICIO
		public static void validarFechaServicioMensual(DtAsistenciaBk dtAsistenciaBk, DtAmpliacionFecha autorizacionEjecucion, 
				DtAmpliacionFecha autorizacionProgramacion, DtAsistencia dtAsistenciaOrig) throws Validador{
			//ID PROGRAMADA Y NO PROG
			Long idNoProgram = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
			Long idProgram = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
			
			GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
			GregorianCalendar fechaServicio = new GregorianCalendar();
			GregorianCalendar fechaHOy = new GregorianCalendar();
			
			Date fechaHoy=new Date();
			//***************PARA PROBAR FECHAS
//			try {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			    String dateInString = "21/09/2021 10:10:45";
//			    fechaHoy = sdf.parse(dateInString);
//				System.out.println(fechaHoy); //Tue Aug 31 10:20:56 SGT 1982
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//*************
		
			fechaHOy.setTimeInMillis(fechaHoy.getTime());
			fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, 0);
			Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
			fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaHoy, 0, diasHabEjec); //EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES 
			
			GregorianCalendar fechaLimitIniMesSgte= new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesSgte = new GregorianCalendar();
			
			Long diasLimitProg = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIALIMIT_PROGRAMAR,PropertiesMg.DEFOULT_DIALIMIT_PROGRAMAR);
			int diaHoy=fechaHOy.get(Calendar.DATE);
			fechaServicio.setTimeInMillis(dtAsistenciaBk.getFechaAsistencia().getTime());

			
			if(diaHoy>diasLimitProg){
				fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, 2);
				fechaLimitFinMesSgte=VerfechaLimitFinMes(fechaHoy, 2);
			}else{
				fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, 1);;
				fechaLimitFinMesSgte=VerfechaLimitFinMes(fechaHoy, 1);
			}
			
			//MPINARES - CREACION DE SERV PROGRAM DE MES ANTERIOR - CON AMPLIACION
			if(autorizacionProgramacion!=null && autorizacionProgramacion.getFechaFin()!=null){
				GregorianCalendar fechaautorizacionProgramacion = new GregorianCalendar();
				fechaautorizacionProgramacion=VerfechaLimitFinDay(autorizacionProgramacion.getFechaFin(), 0);
				if(fechaHOy.before(fechaautorizacionProgramacion)){
					fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, 1);
				}
			}
			
			//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
			if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
				GregorianCalendar fechaParamEjec= new GregorianCalendar();
				fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
				if(fechaHOy.before(fechaParamEjec)){
					fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
					fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
				}
			}
			
			if(dtAsistenciaBk.getIdAsistencia()==null){
				if(dtAsistenciaBk.getIdProgramacion().longValue()==idProgram){
					
					if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesSgte);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
					    fmt.setCalendar(fechaLimitFinMesSgte);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

						throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}

					
				}else if (dtAsistenciaBk.getIdProgramacion().longValue()==idNoProgram){
					//PARA NUEVA FECHA INICIAL CON LOS DIAS HABILES POSTERIOR AL FIN DE MES
					 //diasHabEjec
					GregorianCalendar fechaLimitDiasHabEjecu= new GregorianCalendar();
					fechaLimitDiasHabEjecu=VerfechaLimitdiasHabilesEjecu(fechaHoy, diasHabEjec);
					if(fechaHOy.before(fechaLimitDiasHabEjecu)){
						fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
					}
					
					//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
					if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
						GregorianCalendar fechaParamEjec= new GregorianCalendar();
						fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
						if(fechaHOy.before(fechaParamEjec)){
							fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
							fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
						}
					}		
					
					if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesActual);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
					    fmt.setCalendar(fechaLimitFinMesActual);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

						throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
//					    throw new Validador(MessageFormat.format("LA FECHA DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
				}
				
			}else{
				
//				//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
//				if(autorizacionEjecucion!=null && autorizacionEjecucion.getIdAutorizacion()!=null){
//					fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
//					fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
//				}
				
				if(dtAsistenciaBk.getIdProgramacion().longValue()==idProgram){
					
					if(dtAsistenciaBk.isVistaProgramado()){
						if(dtAsistenciaOrig!=null && dtAsistenciaOrig.getFechaAsistencia()!=null){
							if(!dtAsistenciaOrig.getFechaAsistencia().equals(dtAsistenciaBk.getFechaAsistencia())){
								if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesSgte);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
								    fmt.setCalendar(fechaLimitFinMesSgte);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

									throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
											Messages.getStringToKey("dtAsistencias.fecha"),
											Messages.getStringToKey("dtAsistencias.titulotabla")));
								
								}
							}
						}
					}else{
						//PARA NUEVA FECHA INICIAL CON LOS DIAS HABILES POSTERIOR AL FIN DE MES
						 //diasHabEjec
						GregorianCalendar fechaLimitDiasHabEjecu= new GregorianCalendar();
						fechaLimitDiasHabEjecu=VerfechaLimitdiasHabilesEjecu(fechaHoy, diasHabEjec);
						if(fechaHOy.before(fechaLimitDiasHabEjecu)){
							fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
						}
						
						//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
						if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
							GregorianCalendar fechaParamEjec= new GregorianCalendar();
							fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
							if(fechaHOy.before(fechaParamEjec)){
								fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
//								fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaHoy, 0, diasHabEjec);
								fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
							}
						}	
						
//						String fechaa=fechaLimitIniMesActual.getTime()+"";
//						String fechaass=fechaLimitFinMesActual.getTime()+"";
						
						if(dtAsistenciaOrig!=null && dtAsistenciaOrig.getFechaAsistencia()!=null){
							if(!dtAsistenciaOrig.getFechaAsistencia().equals(dtAsistenciaBk.getFechaAsistencia())){
//								if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
								if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesActual);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
								    fmt.setCalendar(fechaLimitFinMesActual);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

									throw new Validador(MessageFormat.format("SOLO PUEDE EDITAR EL SERVICIO PROGRAMADO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
											Messages.getStringToKey("dtAsistencias.fecha"),
											Messages.getStringToKey("dtAsistencias.titulotabla")));
								
								}
							}
						}
					}
					

					
					
					//SPRINT_4.1
					
				}else

				if (dtAsistenciaBk.getIdProgramacion().longValue()==idNoProgram ){
					//PARA NUEVA FECHA INICIAL CON LOS DIAS HABILES POSTERIOR AL FIN DE MES
					 //diasHabEjec
					GregorianCalendar fechaLimitDiasHabEjecu= new GregorianCalendar();
					fechaLimitDiasHabEjecu=VerfechaLimitdiasHabilesEjecu(fechaHoy, diasHabEjec);
					if(fechaHOy.before(fechaLimitDiasHabEjecu)){
						fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
					}
					
					//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
					if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
						GregorianCalendar fechaParamEjec= new GregorianCalendar();
						fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
						if(fechaHOy.before(fechaParamEjec)){
							fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
							fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
						}
					}	
					
//					String fechaa=fechaLimitIniMesActual.getTime()+"";
//					String fechaass=fechaLimitFinMesActual.getTime()+"";
					
						if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
							
							SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
						    fmt.setCalendar(fechaLimitIniMesActual);
						    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
						    fmt.setCalendar(fechaLimitFinMesActual);
						    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//							throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
						    throw new Validador(MessageFormat.format("LA FECHA DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
									Messages.getStringToKey("dtAsistencias.fecha"),
									Messages.getStringToKey("dtAsistencias.titulotabla")));
							
						}
					}

			}
			
		}
		
		public static GregorianCalendar VerfechaLimitIniMes(Date fecha, int mesLimit){
			GregorianCalendar fechaLimitIni = new GregorianCalendar();
			fechaLimitIni.setTimeInMillis(fecha.getTime());
			fechaLimitIni.add(Calendar.MONTH,mesLimit);
			fechaLimitIni.set(Calendar.DAY_OF_MONTH, fechaLimitIni.getActualMinimum(Calendar.DAY_OF_MONTH));
			fechaLimitIni.set(Calendar.HOUR_OF_DAY, fechaLimitIni.getActualMinimum(Calendar.HOUR_OF_DAY));
			fechaLimitIni.set(Calendar.MINUTE, fechaLimitIni.getActualMinimum(Calendar.MINUTE));
			fechaLimitIni.set(Calendar.SECOND, fechaLimitIni.getActualMinimum(Calendar.SECOND));
			fechaLimitIni.set(Calendar.MILLISECOND, fechaLimitIni.getActualMinimum(Calendar.MILLISECOND));
			return fechaLimitIni;
		}
		
		public static GregorianCalendar VerfechaLimitFinMesMasXdiasHabiles(Date fecha, int mesLimit,Long diasHab){
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.add(Calendar.MONTH,mesLimit);
			fechaLimitFin.set(Calendar.DAY_OF_MONTH, fechaLimitFin.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
			
			int j=0;
			for (int i = 1; i<7; i++) {
				fechaLimitFin.add(Calendar.DAY_OF_MONTH, 1);
//				String fechaa=fechaLimitFinProgQuincena.getTime()+"";
				if(fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
						fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY ){
					j++;
				}
				if(j==(diasHab)){
					break;
				}
				}
//			String fechaa=fechaLimitFinProgQuincena.getTime()+"";
			
			return fechaLimitFin;
		}
		
		public static GregorianCalendar VerfechaLimitFinMes(Date fecha, int mesLimit){
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.add(Calendar.MONTH,mesLimit);
			fechaLimitFin.set(Calendar.DAY_OF_MONTH, fechaLimitFin.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
			return fechaLimitFin;
		}
		
		public static GregorianCalendar VerfechaLimitFinDay(Date fecha, int mesLimit){
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
			return fechaLimitFin;
		}
		
		public static GregorianCalendar VerfechaLimitdiasHabilesEjecu(Date fecha,Long diasHab){
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.set(Calendar.DAY_OF_MONTH, fechaLimitFin.getActualMinimum(Calendar.DAY_OF_MONTH));
//			String fechaa=fechaLimitFin.getTime()+"";
			fechaLimitFin.add(Calendar.DAY_OF_MONTH, -1);
//			fechaa=fechaLimitFin.getTime()+"";
			fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
//			fechaa=fechaLimitFin.getTime()+"";
			int j=0;
			for (int i = 1; i<7; i++) {
				fechaLimitFin.add(Calendar.DAY_OF_MONTH, 1);
//				String fechaa=fechaLimitFinProgQuincena.getTime()+"";
				if(fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
						fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY ){
					j++;
				}
				if(j==(diasHab)){
					break;
				}
				} 
//			 fechaa=fechaLimitFin.getTime()+"";
			
			return fechaLimitFin;
		}
		
		public static void validarDtCapacitacionFechaSoliAntesFechaServicio(Date fechaSoli, Date fechaServicio)
				throws Validador {
					if(fechaSoli!=null && fechaServicio!=null ){
						try{
							fechaSoli=new SimpleDateFormat("dd/MM/yyyy").parse(fechaSoli.toString());  
							fechaServicio=new SimpleDateFormat("dd/MM/yyyy").parse(fechaServicio.toString());
						}catch(Exception e){
						}
						GregorianCalendar fechaGreSoli = new GregorianCalendar();
						GregorianCalendar fechaGreIni = new GregorianCalendar();
						fechaGreSoli.setTimeInMillis(fechaSoli.getTime());
						fechaGreIni.setTimeInMillis(fechaServicio.getTime());
						 
						if (fechaGreSoli.getTimeInMillis()>fechaGreIni.getTimeInMillis()) {
						 	throw new Validador(MessageFormat.format(
						 			Messages.getStringToKey("validacion.fecha.soli.antes"),
						 			Messages.getStringToKey("dtAsistencias.titulotabla")));
						}	
						
						
						GregorianCalendar fechaLimit = new GregorianCalendar();
						fechaLimit=VerfechaLimiDiaMesAnterior(fechaServicio);
//						String fechaa=fechaLimit.getTime()+"";
						if (fechaGreSoli.getTimeInMillis()<fechaLimit.getTimeInMillis()) {
							throw new Validador(MessageFormat.format(
						 			Messages.getStringToKey("validación.fecha.soli.un.mes"),
						 			Messages.getStringToKey("dtAsistencias.titulotabla")));
						}
//						int mes=FuncionesStaticas.getMonthsSinConsiderarDias(fechaSoli, fechaServicio);
//						if(mes>1){
//							throw new Validador(MessageFormat.format(
//						 			Messages.getStringToKey("validación.fecha.soli.un.mes"),
//						 			Messages.getStringToKey("dtCapacitacion.titulotabla")));
//						}
					}
				}
		
		public static GregorianCalendar VerfechaLimiDiaMesAnterior(Date fecha){
			GregorianCalendar fechaLimitIni = new GregorianCalendar();
			fechaLimitIni.setTimeInMillis(fecha.getTime());
			fechaLimitIni.add(Calendar.MONTH,-1);
			fechaLimitIni.set(Calendar.HOUR_OF_DAY, fechaLimitIni.getActualMinimum(Calendar.HOUR_OF_DAY));
			fechaLimitIni.set(Calendar.MINUTE, fechaLimitIni.getActualMinimum(Calendar.MINUTE));
			fechaLimitIni.set(Calendar.SECOND, fechaLimitIni.getActualMinimum(Calendar.SECOND));
			fechaLimitIni.set(Calendar.MILLISECOND, fechaLimitIni.getActualMinimum(Calendar.MILLISECOND));
			return fechaLimitIni;
		}
		
		public static void validarFechaReactiva(DtAsistenciaBk dtAsistenciaBk, DtAmpliacionFecha autorizacionEjecucion) throws Validador{

			Date fechaHoy=new Date();
			GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
			GregorianCalendar fechaServicio = new GregorianCalendar();
			GregorianCalendar fechaHOy = new GregorianCalendar();
			fechaHOy.setTimeInMillis(fechaHoy.getTime());

			fechaServicio.setTimeInMillis(dtAsistenciaBk.getFechaAsistencia().getTime());
			fechaLimitIniMesActual=VerfechaLimitIniMes(fechaServicio.getTime(), 0);//SPRINT_4
			Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
			fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaServicio.getTime(), 0, diasHabEjec);//EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES
			
			if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
				GregorianCalendar fechaParamEjec= new GregorianCalendar();
				fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
				if(fechaHOy.before(fechaParamEjec)){
					fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
				}
			}
			
			String fechaaini=fechaLimitIniMesActual.getTime()+"";
			String fechaaFin=fechaLimitFinMesActual.getTime()+"";
			
			if(fechaHOy.after(fechaLimitFinMesActual) || fechaHOy.before(fechaLimitIniMesActual)){
				SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
			    fmt.setCalendar(fechaLimitIniMesActual);
			    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
			    fmt.setCalendar(fechaLimitFinMesActual);
			    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());
				throw new Validador(MessageFormat.format("SOLO PUEDE REACTIVAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
						Messages.getStringToKey("dtAsistencia.fechaAsistencia"),
						Messages.getStringToKey("dtAsistencias.titulotabla")));
			
			}
			
			
		}
		//MPINARES 24012023 - FIN
		
}