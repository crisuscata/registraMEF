package pe.gob.mef.registramef.bs.val.validator;
//PURIBE 14032024 -INICIO-->
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;	//PURIBE 01022024 - INICIO-->
import java.util.Calendar;	//PURIBE 01022024 - INICIO-->
import java.util.Date;	//PURIBE 01022024 - INICIO-->
import java.util.GregorianCalendar;	//PURIBE 01022024 - INICIO-->
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.mef.registramef.bs.dao.DtAmpliacionFechaDao;
import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.domain.DtVisitas;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtAmpliacionFechaBk;	//PURIBE 01022024 - INICIO-->
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg; 	//PURIBE 01022024 - INICIO-->

/**
 * DT_VISITAS SERVICIO VALIDACIÓN: ALMACENA LOS DATOS REGISTRADOS EN UNA VISITA "VISITAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:36
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 17:36                      / Creación de la clase             /
 * 
 */
public class ValidacionDtVisitasMng implements Serializable{
	public static final Logger log = Logger.getLogger(ValidacionDtVisitasMng.class.getName());
	
	//PURIBE 22042024 -INICIO-->
		@Autowired
		private static DtAmpliacionFechaDao dtAmpliacionFechaDao = null;
		@Autowired
		private Servicio servicio = null;
		//PURIBE 22042024 -FIN-->
	
	public static void validarDtVisitasBk(DtVisitasBk dtVisitasBk,DtAmpliacionFecha autorizacionProgramacion,
			DtAmpliacionFecha autorizacionEjecucion, boolean esAdminOGC, DtVisitas dtVisitasOrig)
	 throws Validador
	{
		
		//VALIDANDO
		validarCampos(dtVisitasBk.getFechaVisita(),dtVisitasBk.getIdLugar(),dtVisitasBk.getIdFinancia(),dtVisitasBk.getIdEntidad(),dtVisitasBk.getIdOrigen());
		
		if(dtVisitasBk.getIdProgramacion()!=null){
			if(!esAdminOGC){
			validarFechaServicioMensual(dtVisitasBk,autorizacionEjecucion, autorizacionProgramacion, dtVisitasOrig);
//			validarFechaCorte(dtVisitasBk, autorizacionProgramacion, autorizacionEjecucion);
			}
		}
		
                //FORANEAS
                if(dtVisitasBk.getEstado()!=null && dtVisitasBk.getEstado().longValue()<=0){
			dtVisitasBk.setEstado(null);
		}
	        if(dtVisitasBk.getIdOrigen()!=null && dtVisitasBk.getIdOrigen().longValue()<=0){
			dtVisitasBk.setIdOrigen(null);
		}
	        if(dtVisitasBk.getIdProgramacion()!=null && dtVisitasBk.getIdProgramacion().longValue()<=0){
			dtVisitasBk.setIdProgramacion(null);
		}
	        if(dtVisitasBk.getIdModalidad()!=null && dtVisitasBk.getIdModalidad().longValue()<=0){
			dtVisitasBk.setIdModalidad(null);
		}
	        if(dtVisitasBk.getIdTipo()!=null && dtVisitasBk.getIdTipo().longValue()<=0){
			dtVisitasBk.setIdTipo(null);
		}
	        if(dtVisitasBk.getIdLugar()!=null && dtVisitasBk.getIdLugar().longValue()<=0){
			dtVisitasBk.setIdLugar(null);
		}
	        if(dtVisitasBk.getIdEntidad()!=null && dtVisitasBk.getIdEntidad().longValue()<=0){
			dtVisitasBk.setIdEntidad(null);
		}
	        if(dtVisitasBk.getIdSede()!=null && dtVisitasBk.getIdSede().longValue()<=0){
			dtVisitasBk.setIdSede(null);
		}
	        if(dtVisitasBk.getIdSistAdm()!=null && dtVisitasBk.getIdSistAdm().longValue()<=0){
			dtVisitasBk.setIdSistAdm(null);
		}
	        if(dtVisitasBk.getIdFinancia()!=null && dtVisitasBk.getIdFinancia().longValue()<=0){
			dtVisitasBk.setIdFinancia(null);
		}
	       
		
		//validarConclusion(dtVisitasBk.getConclusion());
		if(dtVisitasBk.getConclusion()!=null){
				if(dtVisitasBk.getConclusion().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtVisitas.noexceder"),
							Messages.getStringToKey("dtVisitas.conclusion"),
							Messages.getStringToKey("dtVisitas.titulotabla"),
							500,
							Messages.getStringToKey("dtVisitas.articuloConclusion")
							));				
//				dtVisitasBk.setConclusion(dtVisitasBk.getConclusion().toUpperCase());
				}

		
		
		
		
		
		//validarIdOrigen(dtVisitasBk.getIdOrigen());

		//validarIdProgramacion(dtVisitasBk.getIdProgramacion());

		//validarIdModalidad(dtVisitasBk.getIdModalidad());

		//validarIdTipo(dtVisitasBk.getIdTipo());

		//validarIdLugar(dtVisitasBk.getIdLugar());

		//validarIdEntidad(dtVisitasBk.getIdEntidad());

		
		
		//validarIdSede(dtVisitasBk.getIdSede());

		//validarIdSistAdm(dtVisitasBk.getIdSistAdm());

		//validarIdFinancia(dtVisitasBk.getIdFinancia());

		//validarFechaFinalizacion(dtVisitasBk.getFechaFinalizacion());

		//validarFechaProgramada(dtVisitasBk.getFechaProgramada());

				
	}
	
	
	public static void validarFechaServicioMensual(DtVisitasBk dtVisitasBk, DtAmpliacionFecha autorizacionEjecucion, 
			DtAmpliacionFecha autorizacionProgramacion, DtVisitas dtVisitasOrig) throws Validador{
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
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		    String dateInString = "21/09/2021 10:10:45";
//		    fechaHoy = sdf.parse(dateInString);
//			System.out.println(fechaHoy); //Tue Aug 31 10:20:56 SGT 1982
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//*************
	
		fechaHOy.setTimeInMillis(fechaHoy.getTime());
		fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, 0);
		Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
		fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaHoy, 0, diasHabEjec); //EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES 
		
		//fechaServicio.setTimeInMillis(dtVisitasBk.getFechaVisita().getTime());//SPRINT_4
		
		GregorianCalendar fechaLimitIniMesSgte= new GregorianCalendar();
		GregorianCalendar fechaLimitFinMesSgte = new GregorianCalendar();
		
		Long diasLimitProg = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIALIMIT_PROGRAMAR,PropertiesMg.DEFOULT_DIALIMIT_PROGRAMAR);
		int diaHoy=fechaHOy.get(Calendar.DATE);
		//SPRINT_4.1 INICIO
		fechaServicio.setTimeInMillis(dtVisitasBk.getFechaVisita().getTime());
		
		if(diaHoy>diasLimitProg){
			fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, 2);;
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
				fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, 0);//JPUYEN 17062024
			}
		}
		
		if(dtVisitasBk.getIdVisita()==null){
			if(dtVisitasBk.getIdProgramacion().longValue()==idProgram){
				
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

				
			}else if (dtVisitasBk.getIdProgramacion().longValue()==idNoProgram){
				
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
						fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, 0);//JPUYEN 17062024
					}
				}
				
				if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
					SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
				    fmt.setCalendar(fechaLimitIniMesActual);
				    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
				    fmt.setCalendar(fechaLimitFinMesActual);
				    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//					throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
				    throw new Validador(MessageFormat.format("LA FECHA DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
							Messages.getStringToKey("dtAsistencias.fecha"),
							Messages.getStringToKey("dtVisitas.titulotabla.reunion")));
				
				}
			}
			
		}else{
			
			if(dtVisitasBk.getIdProgramacion().longValue()==idProgram){
				
				//SPRINT_4.1 INICIO
			
				//PURIBE 22042024 - INICIO-->
				if(dtVisitasBk.isVistaProgramado()){
					if(dtVisitasOrig!=null && dtVisitasOrig.getFechaVisita()!=null){
						if(!dtVisitasOrig.getFechaVisita().equals(dtVisitasBk.getFechaVisita())){
							if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
								SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
							    fmt.setCalendar(fechaLimitIniMesSgte);
							    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
							    fmt.setCalendar(fechaLimitFinMesSgte);
							    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

								throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
										Messages.getStringToKey("dtAsistencias.fecha"),
										Messages.getStringToKey("dtVisitas.titulotabla.reunion")));
							
							}
						}
					
					}}else{
						//PURIBE 22042024 - FIN-->
					//PARA NUEVA FECHA INICIAL CON LOS DIAS HABILES POSTERIOR AL FIN DE MES
					 //diasHabEjec
					GregorianCalendar fechaLimitDiasHabEjecu= new GregorianCalendar();
					fechaLimitDiasHabEjecu=VerfechaLimitdiasHabilesEjecu(fechaHoy, diasHabEjec);
					if(fechaHOy.before(fechaLimitDiasHabEjecu)){
						fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, -1);
					}
					
					//MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON AMPLIACION
					if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
						GregorianCalendar fechaParamEjec= new GregorianCalendar();
						fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
						if(fechaHOy.before(fechaParamEjec)){
							fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
//							fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaHoy, 0, diasHabEjec);
							fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
						}
					}	
					
					if(dtVisitasOrig!=null && dtVisitasOrig.getFechaVisita()!=null){
						if(!dtVisitasOrig.getFechaVisita().equals(dtVisitasBk.getFechaVisita())){
//							if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
							if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
								SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
							    fmt.setCalendar(fechaLimitIniMesActual);
							    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
							    fmt.setCalendar(fechaLimitFinMesActual);
							    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

								throw new Validador(MessageFormat.format("SOLO PUEDE EDITAR EL SERVICIO PROGRAMADO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
										Messages.getStringToKey("dtAsistencias.fecha"),
										Messages.getStringToKey("dtVisitas.titulotabla.reunion")));
							
							}
						}
					}
					
				}

				
			}else

//				if (dtAsistenciaBk.getIdProgramacion().longValue()==idNoProgram && autorizacionEjecucion==null){
			if (dtVisitasBk.getIdProgramacion().longValue()==idNoProgram ){
				
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
						fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, 0);//JPUYEN 17062024
					}
				}	
				
				if(fechaServicio.after(fechaLimitFinMesActual) || fechaServicio.before(fechaLimitIniMesActual)){
					SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
				    fmt.setCalendar(fechaLimitIniMesActual);
				    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
				    fmt.setCalendar(fechaLimitFinMesActual);
				    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//					throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
				    throw new Validador(MessageFormat.format("LA FECHA DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
							Messages.getStringToKey("dtAsistencias.fecha"),
							Messages.getStringToKey("dtVisitas.titulotabla.reunion")));
				
				}
				}

		}
		
	}
	

	
	
	public static GregorianCalendar VerfechaLimitdiasHabilesEjecu(Date fecha,Long diasHab){
		GregorianCalendar fechaLimitFin = new GregorianCalendar();
		fechaLimitFin.setTimeInMillis(fecha.getTime());
		fechaLimitFin.set(Calendar.DAY_OF_MONTH, fechaLimitFin.getActualMinimum(Calendar.DAY_OF_MONTH));
//		String fechaa=fechaLimitFin.getTime()+"";
		fechaLimitFin.add(Calendar.DAY_OF_MONTH, -1);
//		fechaa=fechaLimitFin.getTime()+"";
		fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
		fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
		fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
		fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
//		fechaa=fechaLimitFin.getTime()+"";
		int j=0;
		for (int i = 1; i<7; i++) {
			fechaLimitFin.add(Calendar.DAY_OF_MONTH, 1);
//			String fechaa=fechaLimitFinProgQuincena.getTime()+"";
			if(fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
					fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY ){
				j++;
			}
			if(j==(diasHab)){
				break;
			}
			} 
//		 fechaa=fechaLimitFin.getTime()+"";
		
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
	
	
	
		//PURIBE 01022024 - INICIO-->
	public static void validarFechaAnulacion(DtVisitasBk dtVisitasBk, DtAmpliacionFechaBk autorizacionEjecucion) throws Validador{

		Date fechaHoy=new Date();
		GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
		GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
		GregorianCalendar fechaServicio = new GregorianCalendar();
		GregorianCalendar fechaHOy = new GregorianCalendar();
		fechaHOy.setTimeInMillis(fechaHoy.getTime());
		
		
		fechaServicio.setTimeInMillis(dtVisitasBk.getFechaVisita().getTime());
		
		
//		fechaLimitIniMesActual=ValidacionDtAsistenciaMng.VerfechaLimitIniMes(dtVisitasBk.getFechaVisita(), 0);
//		fechaLimitFinMesActual=ValidacionDtAsistenciaMng.VerfechaLimitFinMes(dtVisitasBk.getFechaVisita(), 0);
		fechaLimitIniMesActual=VerfechaLimitIniMes(fechaServicio.getTime(), 0);//SPRINT_4
		Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
		fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaServicio.getTime(), 0, diasHabEjec);//EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES
//		String fechaaini=fechaLimitIniMesActual.getTime()+"";
//		String fechaaFin=fechaLimitFinMesActual.getTime()+"";
		if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
			GregorianCalendar fechaParamEjec= new GregorianCalendar();
			fechaParamEjec=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
			if(fechaHOy.before(fechaParamEjec)){
				fechaLimitFinMesActual=VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
			}
		}
		
		if(fechaHOy.after(fechaLimitFinMesActual) || fechaHOy.before(fechaLimitIniMesActual)){
			SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
		    fmt.setCalendar(fechaLimitIniMesActual);
		    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
		    fmt.setCalendar(fechaLimitFinMesActual);
		    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());
			throw new Validador(MessageFormat.format("SOLO PUEDE FINALIZAR EL SERVICIO " + dtVisitasBk.getIdVisitaTxt() +" DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					Messages.getStringToKey("dtAsistencias.fecha"),
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		
		}
		
		
	}
	
	//PURIBE 12022024 - INICIO-->
	public static void validarFechaReactiva(DtVisitasBk dtVisitasBk, DtAmpliacionFechaBk autorizacionEjecucion) throws Validador{

		Date fechaHoy=new Date();
		GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
		GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
		GregorianCalendar fechaServicio = new GregorianCalendar();
		GregorianCalendar fechaHOy = new GregorianCalendar();
		fechaHOy.setTimeInMillis(fechaHoy.getTime());
		
		fechaServicio.setTimeInMillis(dtVisitasBk.getFechaVisita().getTime());

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
		
		if(fechaHOy.after(fechaLimitFinMesActual) || fechaHOy.before(fechaLimitIniMesActual)){
			SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
		    fmt.setCalendar(fechaLimitIniMesActual);
		    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
		    fmt.setCalendar(fechaLimitFinMesActual);
		    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());
			throw new Validador(MessageFormat.format("SOLO PUEDE REACTIVAR EL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					Messages.getStringToKey("dtAsistencias.fecha"),
					Messages.getStringToKey("dtAsistencias.titulotabla")));
		
		}
		
	}
	//PURIBE 12022024 - FIN-->
	
	public static GregorianCalendar VerfechaLimitFinDay(Date fecha, int mesLimit){
		GregorianCalendar fechaLimitFin = new GregorianCalendar();
		fechaLimitFin.setTimeInMillis(fecha.getTime());
		fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
		fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
		fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
		fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
		return fechaLimitFin;
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

			if(fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
					fechaLimitFin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY ){
				j++;
			}
			if(j==(diasHab)){
				break;
			}
			}
		
		return fechaLimitFin;
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
	
	
		//PURIBE 01022024 - FIN-->
	
	public static void validarCampos(Timestamp fechaVisita,Long Idlugar,Long Idfinancia,Long Identidad,Long Idorigen)
	 throws Validador
	{				
					if(fechaVisita==null){
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.fechaVisita"),
			Messages.getStringToKey("dtVisitas.fechaVisita"),
			Messages.getStringToKey("dtVisitas.titulotabla"))); 
					}
		//	Messages.getStringToKey("dtVisitas.articuloFechaVisita"))); 
					if(Idlugar == null || Idlugar == 0  ){
						throw new Validador("Seleccionar lugar de reunión valido"); 
					}
					
					if(Idfinancia == null || Idfinancia == 0  ){
						throw new Validador("Seleccionar financiamiento valido"); 
					}
					
					if(Identidad == null || Identidad == 0  ){
						throw new Validador("Seleccionar entidad valida"); 
					}
					if(Idorigen== null || Idorigen== 0  ){
						throw new Validador("Seleccionar origen valido"); 
					}
					
		}
	
	
	public static void validarConclusion(String conclusion)
	 throws Validador
	{					
			if(conclusion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.ingrese"),
			Messages.getStringToKey("dtVisitas.conclusion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloConclusion")));
			if(conclusion.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
			Messages.getStringToKey("dtVisitas.conclusion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloConclusion")));						
			if(conclusion!=null){
				if(conclusion.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.noexceder"),
			Messages.getStringToKey("dtVisitas.conclusion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),500,
			Messages.getStringToKey("dtVisitas.articuloConclusion")));
				}
	}
	
	
	
	
	
	public static void validarIdOrigen(Long idOrigen)
			 throws Validador
				{				
								if(idOrigen==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idOrigen"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdOrigen")));
					}
	
	
	public static void validarIdProgramacion(Long idProgramacion)
	 throws Validador
	{				
					if(idProgramacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.seleccione"),
			Messages.getStringToKey("dtVisitas.idProgramacion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloIdProgramacion")));
			if(idProgramacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoseleccione"),
			Messages.getStringToKey("dtVisitas.idProgramacion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloIdProgramacion")));			
	}
	public static void validarIdModalidad(Long idModalidad)
			 throws Validador
				{				
								if(idModalidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idModalidad"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdModalidad")));
					}
	
	public static void validarIdTipo(Long idTipo)
			 throws Validador
				{				
								if(idTipo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idTipo"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdTipo")));
					}
	
	public static void validarIdLugar(Long idLugar)
			 throws Validador
				{				
								if(idLugar==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idLugar"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdLugar")));
					}
	
	public static void validarIdEntidad(Long idEntidad)
			 throws Validador
				{				
								if(idEntidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idEntidad"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdEntidad")));
					}
	
	
	
	public static void validarIdSede(Long idSede)
			 throws Validador
				{				
								if(idSede==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idSede"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdSede")));
					}
	
	
	public static void validarIdSistAdm(Long idSistAdm)
	 throws Validador
	{				
					if(idSistAdm==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.seleccione"),
			Messages.getStringToKey("dtVisitas.idSistAdm"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloIdSistAdm")));
			if(idSistAdm.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoseleccione"),
			Messages.getStringToKey("dtVisitas.idSistAdm"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloIdSistAdm")));			
	}
	public static void validarIdFinancia(Long idFinancia)
			 throws Validador
				{				
								if(idFinancia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
						Messages.getStringToKey("dtVisitas.idFinancia"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloIdFinancia")));
					}
	
	
	public static void validarFechaFinalizacion(Timestamp fechaFinalizacion)
	 throws Validador
	{				
					if(fechaFinalizacion==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
			Messages.getStringToKey("dtVisitas.fechaFinalizacion"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloFechaFinalizacion")));
		}
	
	public static void validarFechaProgramada(Timestamp fechaProgramada)
	 throws Validador
	{				
					if(fechaProgramada==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.invalidoingrese"),
			Messages.getStringToKey("dtVisitas.fechaProgramada"),
			Messages.getStringToKey("dtVisitas.titulotabla"),
			Messages.getStringToKey("dtVisitas.articuloFechaProgramada")));
		}
		//PURIBE 14032024 -FIN-->
	
	//PURIBE 22042024 - INICIO-->
		public  boolean validarFechaEdit(DtVisitasBk dtVisitasBk) throws Validador{
			boolean retorno = false;
			if(dtVisitasBk!=null && dtVisitasBk.getIdVisita()!=null){
				if(dtVisitasBk.getFechaVisita()!=null){
					GregorianCalendar fechaLimitEdit = new GregorianCalendar();
					fechaLimitEdit=VerfechaLimitEditMensual(dtVisitasBk.getFechaVisita(), -1);
					GregorianCalendar fechaHoy = new GregorianCalendar();
				//con ampliacion de fecha de programacion
				DtAmpliacionFecha autorizacionProgramacion=servicio.getautorizacionProgramacion2(dtVisitasBk.getIdSede(), dtVisitasBk.getIdSistAdm());
				if(autorizacionProgramacion!=null && autorizacionProgramacion.getFechaFin()!=null){
					GregorianCalendar fechaautorizacionProgramacion = new GregorianCalendar();
					fechaautorizacionProgramacion=VerfechaLimitFinDay(autorizacionProgramacion.getFechaFin(), 0);
//				
					if(fechaHoy.before(fechaautorizacionProgramacion) && fechaautorizacionProgramacion.after(fechaLimitEdit)){
						int meslimitEdit=fechaLimitEdit.get(Calendar.MONTH);
						int mesamplProg=fechaautorizacionProgramacion.get(Calendar.MONTH);
						if(meslimitEdit==mesamplProg){
							fechaLimitEdit=fechaautorizacionProgramacion;
						}
					}
				}
				//***************************************
					if(fechaHoy.after(fechaLimitEdit)){
						retorno = false;
					}else{
						retorno = true;
					}
				}
				}else{
					retorno = true;
				}
			return retorno;
		}
		
		public static DtAmpliacionFecha getautorizacionProgramacion2(Long idsede, Long idsisAdmin) {
			 
			
			Long idSisAdmTodos = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSISTEMA_ADMINISTRATIVO_TODOS,
					PropertiesMg.DEFOULT_IDSISTEMA_ADMINISTRATIVO_TODOS);
			Long idSedeTodas = PropertiesMg.getSistemLong(PropertiesMg.KEY_IDSEDES_TODAS,
					PropertiesMg.DEFOULT_IDSEDES_TODAS);
				int mes= FuncionesStaticas.getMonth();
			
			Long idTipoFechaCorteProgramada = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDPARAMTIPO_FECHA_CORTE_PROG);
			
			DtAmpliacionFecha autorizacionProgramacion = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
					idsede, idsisAdmin, mes);

			// ***********************************************************************************************************
			DtAmpliacionFecha autorizacionProgramacion2 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada, idSedeTodas,
					idsisAdmin, mes);
			
			if (autorizacionProgramacion2 != null) {
				if (autorizacionProgramacion != null) {
					if (autorizacionProgramacion2.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
						autorizacionProgramacion = autorizacionProgramacion2;
					}
				} else {
					autorizacionProgramacion = autorizacionProgramacion2;
				}
			}

			DtAmpliacionFecha autorizacionProgramacion3 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada,
					idsede, idSisAdmTodos, mes);
			if (autorizacionProgramacion3 != null) {
				if (autorizacionProgramacion != null) {
					if (autorizacionProgramacion3.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
						autorizacionProgramacion = autorizacionProgramacion3;
					}
				} else {
					autorizacionProgramacion = autorizacionProgramacion3;
				}
			}

			DtAmpliacionFecha autorizacionProgramacion4 = dtAmpliacionFechaDao.getXFiltro(idTipoFechaCorteProgramada, idSedeTodas,
					idSisAdmTodos,mes);
			if (autorizacionProgramacion4 != null) {
				if (autorizacionProgramacion != null) {
					if (autorizacionProgramacion4.getFechaFin().after(autorizacionProgramacion.getFechaFin())) {
						autorizacionProgramacion = autorizacionProgramacion4;
					}
				} else {
					autorizacionProgramacion = autorizacionProgramacion4;
				}
			}
			return autorizacionProgramacion;
		}
		
		public static GregorianCalendar VerfechaLimitEditMensual(Date fecha, int mesLimit){
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.add(Calendar.MONTH,mesLimit);

			GregorianCalendar fechaServicio = new GregorianCalendar();
			fechaServicio.setTimeInMillis(fecha.getTime());
			int diaHoy=fechaServicio.get(Calendar.DATE);
			
			Long diasLimitProg = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIALIMIT_PROGRAMAR,PropertiesMg.DEFOULT_DIALIMIT_PROGRAMAR);
			fechaLimitFin.set(Calendar.DAY_OF_MONTH, diasLimitProg.intValue());
			

			fechaLimitFin.set(Calendar.HOUR_OF_DAY, fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE, fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND, fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND, fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));

			return fechaLimitFin;
		} 
		//PURIBE 22042024 - FIN-->
		
		// JPUYEN 17062024 - INICIO
		public static void validarAnexos(List<DtAnexoBk> dtAnexosBkss) throws Validador {
			if (dtAnexosBkss == null || dtAnexosBkss.isEmpty() || dtAnexosBkss.size() == 0) {
				throw new Validador(MessageFormat.format(Messages.getStringToKey("dtVisitas.ingrese"),
						Messages.getStringToKey("dtVisitas.archivo"),
						Messages.getStringToKey("dtVisitas.titulotabla"),
						Messages.getStringToKey("dtVisitas.articuloArchivo")));
			}
		}
		// JPUYEN 17062024 - FIN
}