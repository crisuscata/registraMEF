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
import pe.gob.mef.registramef.bs.domain.DtCapacitacion;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_CAPACITACION SERVICIO VALIDACIÓN: ALMACENA LOS DATOS REGISTRADOS EN UNA CAPACITACION "CAPACITACIONES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 19:17
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi             / 19/12/2023 19:17                      / Creación de la clase             /
 * 
 */
public class ValidacionDtCapacitacionMng implements Serializable{
	
	private static final long serialVersionUID = 2302739717975163699L;//MPINARES 14022024 - INICIO
	public static final Logger log = Logger.getLogger(ValidacionDtCapacitacionMng.class.getName());
	
	public static void validarDtCapacitacionBk(DtCapacitacionBk dtCapacitacionBk,
			DtAmpliacionFecha autorizacionProgramacion,
			DtAmpliacionFecha autorizacionEjecucion, boolean esAdminOGC,
			DtCapacitacion dtCapacitacionOrig)
	 throws Validador
	{
		
		//MPINARES 14022024 - INICIO
//				validarFechaSoli(dtCapacitacionBk.getFechaSoli());
				validarFechaInic(dtCapacitacionBk.getFechaInic());
				validarFechaFin(dtCapacitacionBk.getFechaFin());
//				validarDtCapacitacionFechaInicioAntesFechaFin(dtCapacitacionBk.getFechaInic(),dtCapacitacionBk.getFechaFin());
				
				Long idNoProgram = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
				Long idModoUnSistema = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDMODO_UNSISTEMA,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDMODO_UNSISTEMA);
				Long idPresencial = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PRESENCIAL,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PRESENCIAL);
				Long idVirtual = PropertiesMg.getSistemLong(
						PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_VIRTUAL,
						PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_VIRTUAL);
				
				if (dtCapacitacionBk.getIdProgramacion() != null) {
//					if (!esAdminOGC) {
						validarFechaServicioMensual(dtCapacitacionBk, autorizacionEjecucion, autorizacionProgramacion, dtCapacitacionOrig);
//					}
				}
				
				validarIdModo(dtCapacitacionBk.getIdModo());
				if (dtCapacitacionBk.getIdModo().longValue() == idModoUnSistema) {
					validarIdModalidad(dtCapacitacionBk.getIdModalidad());
					if (dtCapacitacionBk.getIdModalidad().longValue() == idPresencial) {
						validarIdLocal(dtCapacitacionBk.getIdLocal());
						dtCapacitacionBk.setDetalleCapaVirtual(null);
					}

					if (dtCapacitacionBk.getIdModalidad().longValue() == idVirtual) {
						validarDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual());
						dtCapacitacionBk.setIdLocal(null);
					}
					validarNomEvento(dtCapacitacionBk.getNomEvento());
					validarCantPartic(dtCapacitacionBk.getCantPartic());
					validarIdFinancia(dtCapacitacionBk.getIdFinancia());
					validarIdNivel(dtCapacitacionBk.getIdNivel());
					validarIdPrestacion(dtCapacitacionBk.getIdPrestacion());
					validarIdTipo(dtCapacitacionBk.getIdTipo());
					validarFechaSoli(dtCapacitacionBk.getFechaSoli()); 
					validarDtCapacitacionFechaSoliAntesFechaServicio(dtCapacitacionBk.getFechaSoli(),dtCapacitacionBk.getFechaInic());//SPRINT03
					
				}
				
				validarIdFinancia(dtCapacitacionBk.getIdFinancia());
				//MPINARES 14022024 - FIN
				
                //FORANEAS
                if(dtCapacitacionBk.getIdLocal()!=null && dtCapacitacionBk.getIdLocal().longValue()<=0){
			dtCapacitacionBk.setIdLocal(null);
		}
	        if(dtCapacitacionBk.getIdUsuinterno()!=null && dtCapacitacionBk.getIdUsuinterno().longValue()<=0){
			dtCapacitacionBk.setIdUsuinterno(null);
		}
	        if(dtCapacitacionBk.getEstado()!=null && dtCapacitacionBk.getEstado().longValue()<=0){
			dtCapacitacionBk.setEstado(null);
		}
	        if(dtCapacitacionBk.getIdModo()!=null && dtCapacitacionBk.getIdModo().longValue()<=0){
			dtCapacitacionBk.setIdModo(null);
		}
	        if(dtCapacitacionBk.getIdNivel()!=null && dtCapacitacionBk.getIdNivel().longValue()<=0){
			dtCapacitacionBk.setIdNivel(null);
		}
	        if(dtCapacitacionBk.getIdOrigen()!=null && dtCapacitacionBk.getIdOrigen().longValue()<=0){
			dtCapacitacionBk.setIdOrigen(null);
		}
	        if(dtCapacitacionBk.getIdPrestacion()!=null && dtCapacitacionBk.getIdPrestacion().longValue()<=0){
			dtCapacitacionBk.setIdPrestacion(null);
		}
	        if(dtCapacitacionBk.getIdProgramacion()!=null && dtCapacitacionBk.getIdProgramacion().longValue()<=0){
			dtCapacitacionBk.setIdProgramacion(null);
		}
	        if(dtCapacitacionBk.getIdTipo()!=null && dtCapacitacionBk.getIdTipo().longValue()<=0){
			dtCapacitacionBk.setIdTipo(null);
		}
	        if(dtCapacitacionBk.getIdSede()!=null && dtCapacitacionBk.getIdSede().longValue()<=0){
			dtCapacitacionBk.setIdSede(null);
		}
	        if(dtCapacitacionBk.getIdSistAdm()!=null && dtCapacitacionBk.getIdSistAdm().longValue()<=0){
			dtCapacitacionBk.setIdSistAdm(null);
		}
	        if(dtCapacitacionBk.getIdFinancia()!=null && dtCapacitacionBk.getIdFinancia().longValue()<=0){
			dtCapacitacionBk.setIdFinancia(null);
		}
	        if(dtCapacitacionBk.getIdModalidad()!=null && dtCapacitacionBk.getIdModalidad().longValue()<=0){
			dtCapacitacionBk.setIdModalidad(null);
		}
	        
		//VALIDANDO
		//validarFechaInic(dtCapacitacionBk.getFechaInic());

		//validarFechaFin(dtCapacitacionBk.getFechaFin());

		//validarCantPartic(dtCapacitacionBk.getCantPartic());

		
		//validarPublicObj(dtCapacitacionBk.getPublicObj());
		if(dtCapacitacionBk.getPublicObj()!=null){
				if(dtCapacitacionBk.getPublicObj().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.publicObj"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							100,
							Messages.getStringToKey("dtCapacitacion.articuloPublicObj")
									));				
//				dtCapacitacionBk.setPublicObj(dtCapacitacionBk.getPublicObj().toUpperCase());
				}

		
		//validarNomEvento(dtCapacitacionBk.getNomEvento());
		if(dtCapacitacionBk.getNomEvento()!=null){
				if(dtCapacitacionBk.getNomEvento().trim().length()>1000)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.nomEvento"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							1000,
							Messages.getStringToKey("dtCapacitacion.articuloNomEvento")
							));				
//				dtCapacitacionBk.setNomEvento(dtCapacitacionBk.getNomEvento().toUpperCase());
				}

		
		//validarDetalleCapa(dtCapacitacionBk.getDetalleCapa());
		if(dtCapacitacionBk.getDetalleCapa()!=null){
				if(dtCapacitacionBk.getDetalleCapa().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.detalleCapa"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							500,
							Messages.getStringToKey("dtCapacitacion.articuloDetalleCapa")
							));				
//				dtCapacitacionBk.setDetalleCapa(dtCapacitacionBk.getDetalleCapa().toUpperCase());
				}

		
		
		
		
		//validarIdLocal(dtCapacitacionBk.getIdLocal());

		//validarIdUsuinterno(dtCapacitacionBk.getIdUsuinterno());

		
		//validarIdModo(dtCapacitacionBk.getIdModo());

		//validarIdNivel(dtCapacitacionBk.getIdNivel());

		//validarIdOrigen(dtCapacitacionBk.getIdOrigen());

		//validarIdPrestacion(dtCapacitacionBk.getIdPrestacion());

		//validarIdProgramacion(dtCapacitacionBk.getIdProgramacion());

		
		
		//validarCantParticAsist(dtCapacitacionBk.getCantParticAsist());

		//validarIdTipo(dtCapacitacionBk.getIdTipo());

		//validarIdcapaPadre(dtCapacitacionBk.getIdcapaPadre());

		//validarIdSede(dtCapacitacionBk.getIdSede());

		//validarIdSistAdm(dtCapacitacionBk.getIdSistAdm());

		//validarIdFinancia(dtCapacitacionBk.getIdFinancia());

		//validarFechaFinalizacion(dtCapacitacionBk.getFechaFinalizacion());

		//validarFlagPubli(dtCapacitacionBk.getFlagPubli());

		//validarIdModalidad(dtCapacitacionBk.getIdModalidad());

		
		//validarDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual());
		if(dtCapacitacionBk.getDetalleCapaVirtual()!=null){
				if(dtCapacitacionBk.getDetalleCapaVirtual().trim().length()>1000)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.detalleCapaVirtual"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							1000,
							Messages.getStringToKey("dtCapacitacion.articuloDetalleCapaVirtual")
							));				
//				dtCapacitacionBk.setDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual().toUpperCase());
				}

		//validarFechaIniProgramada(dtCapacitacionBk.getFechaIniProgramada());

		//validarFechaFinProgramada(dtCapacitacionBk.getFechaFinProgramada());

		//validarFechaSoli(dtCapacitacionBk.getFechaSoli());

		//validarStdIddoc(dtCapacitacionBk.getStdIddoc());

		
		//validarStdNumeroSid(dtCapacitacionBk.getStdNumeroSid());
		if(dtCapacitacionBk.getStdNumeroSid()!=null){
				if(dtCapacitacionBk.getStdNumeroSid().trim().length()>50)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.stdNumeroSid"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							50,
							Messages.getStringToKey("dtCapacitacion.articuloStdNumeroSid")
									));				
//				dtCapacitacionBk.setStdNumeroSid(dtCapacitacionBk.getStdNumeroSid().toUpperCase());
				}

		//validarStdNumeroAnio(dtCapacitacionBk.getStdNumeroAnio());

		
		//validarStdNumeroDoc(dtCapacitacionBk.getStdNumeroDoc());
		if(dtCapacitacionBk.getStdNumeroDoc()!=null){
				if(dtCapacitacionBk.getStdNumeroDoc().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.stdNumeroDoc"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							200,
							Messages.getStringToKey("dtCapacitacion.articuloStdNumeroDoc")
									));				
//				dtCapacitacionBk.setStdNumeroDoc(dtCapacitacionBk.getStdNumeroDoc().toUpperCase());
				}

		
		//validarStdAsunto(dtCapacitacionBk.getStdAsunto());
		if(dtCapacitacionBk.getStdAsunto()!=null){
				if(dtCapacitacionBk.getStdAsunto().trim().length()>600)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.stdAsunto"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							600,
							Messages.getStringToKey("dtCapacitacion.articuloStdAsunto")
							));				
//				dtCapacitacionBk.setStdAsunto(dtCapacitacionBk.getStdAsunto().toUpperCase());
				}

		
		//validarStdTipoDoc(dtCapacitacionBk.getStdTipoDoc());
		if(dtCapacitacionBk.getStdTipoDoc()!=null){
				if(dtCapacitacionBk.getStdTipoDoc().trim().length()>100)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.stdTipoDoc"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							100,
							Messages.getStringToKey("dtCapacitacion.articuloStdTipoDoc")
									));				
//				dtCapacitacionBk.setStdTipoDoc(dtCapacitacionBk.getStdTipoDoc().toUpperCase());
				}

		//validarStdFechaRecepcion(dtCapacitacionBk.getStdFechaRecepcion());

		
		//validarStdModalidadIng(dtCapacitacionBk.getStdModalidadIng());
		if(dtCapacitacionBk.getStdModalidadIng()!=null){
				if(dtCapacitacionBk.getStdModalidadIng().trim().length()>200)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.stdModalidadIng"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							200,
							Messages.getStringToKey("dtCapacitacion.articuloStdModalidadIng")
									));				
//				dtCapacitacionBk.setStdModalidadIng(dtCapacitacionBk.getStdModalidadIng().toUpperCase());
				}

		//validarFlagEjec(dtCapacitacionBk.getFlagEjec());

		
		//validarMotivoEjec(dtCapacitacionBk.getMotivoEjec());
		if(dtCapacitacionBk.getMotivoEjec()!=null){
				if(dtCapacitacionBk.getMotivoEjec().trim().length()>500)
					throw new Validador(MessageFormat.format(
							Messages.getStringToKey("dtCapacitacion.noexceder"),
							Messages.getStringToKey("dtCapacitacion.motivoEjec"),
							Messages.getStringToKey("dtCapacitacion.titulotabla"),
							500,
							Messages.getStringToKey("dtCapacitacion.articuloMotivoEjec")
									));				
//				dtCapacitacionBk.setMotivoEjec(dtCapacitacionBk.getMotivoEjec().toUpperCase());
				}

				
	}

	public static void validarFechaInic(Timestamp fechaInic)
	 throws Validador
	{				
					if(fechaInic==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
			Messages.getStringToKey("dtCapacitacion.fechaInic"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaInic")));
		}
	
	public static void validarFechaFin(Timestamp fechaFin)
	 throws Validador
	{				
					if(fechaFin==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
			Messages.getStringToKey("dtCapacitacion.fechaFin"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaFin")));
		}
	
	public static void validarCantPartic(Integer cantPartic)
	 throws Validador
	{				
					if(cantPartic==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),//MPINARES 14022024 - INICIO
			Messages.getStringToKey("dtCapacitacion.cantPartic"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloCantPartic")));
			if(cantPartic.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.cantPartic"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloCantPartic")));			
	}
	
	public static void validarPublicObj(String publicObj)
	 throws Validador
	{					
			if(publicObj==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.publicObj"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloPublicObj")));
			if(publicObj.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.publicObj"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(publicObj!=null){
				if(publicObj.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.publicObj"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),100,
			Messages.getStringToKey("dtCapacitacion.articuloPublicObj")));
				}
	}
	
	public static void validarNomEvento(String nomEvento)
	 throws Validador
	{					
			if(nomEvento==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.nomEvento"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloNomEvento")));
			if(nomEvento.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.nomEvento"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloNomEvento")));						
			if(nomEvento!=null){
				if(nomEvento.trim().length()>1000)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.nomEvento"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),1000,
			Messages.getStringToKey("dtCapacitacion.articuloNomEvento")));
				}
	}
	
	public static void validarDetalleCapa(String detalleCapa)
	 throws Validador
	{					
			if(detalleCapa==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.detalleCapa"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapa")));
			if(detalleCapa.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.detalleCapa"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapa")));						
			if(detalleCapa!=null){
				if(detalleCapa.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.detalleCapa"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),500,
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapa")));
				}
	}
	
	
	
	
	public static void validarIdLocal(Long idLocal)
			 throws Validador
				{				
								if(idLocal==null)
										throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idLocal"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdLocal")));
					}
	
	
	public static void validarIdUsuinterno(Long idUsuinterno)
	 throws Validador
	{				
					if(idUsuinterno==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.idUsuinterno"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdUsuinterno")));
			if(idUsuinterno.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.idUsuinterno"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdUsuinterno")));			
	}
	
	public static void validarIdModo(Long idModo)
			 throws Validador
				{				
								if(idModo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idModo"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdModo")));
					}
	
	public static void validarIdNivel(Long idNivel)
			 throws Validador
				{				
								if(idNivel==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idNivel"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdNivel")));
					}
	
	public static void validarIdOrigen(Long idOrigen)
			 throws Validador
				{				
								if(idOrigen==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
						Messages.getStringToKey("dtCapacitacion.idOrigen"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdOrigen")));
					}
	
	public static void validarIdPrestacion(Long idPrestacion)
			 throws Validador
				{				
								if(idPrestacion==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idPrestacion"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdPrestacion")));
					}
	
	
	public static void validarIdProgramacion(Long idProgramacion)
	 throws Validador
	{				
					if(idProgramacion==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.idProgramacion"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdProgramacion")));
			if(idProgramacion.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.idProgramacion"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdProgramacion")));			
	}
	
	
	
	public static void validarCantParticAsist(Integer cantParticAsist)
	 throws Validador
	{				
					if(cantParticAsist==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.cantParticAsist"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloCantParticAsist")));
			if(cantParticAsist.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.cantParticAsist"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloCantParticAsist")));			
	}
	public static void validarIdTipo(Long idTipo)
			 throws Validador
				{				
								if(idTipo==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idTipo"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdTipo")));
					}
	
	
	public static void validarIdcapaPadre(Long idcapaPadre)
	 throws Validador
	{				
					if(idcapaPadre==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.idcapaPadre"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdcapaPadre")));
			if(idcapaPadre.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.idcapaPadre"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdcapaPadre")));			
	}
	
	public static void validarIdSede(Long idSede)
	 throws Validador
	{				
					if(idSede==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.idSede"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdSede")));
			if(idSede.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.idSede"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdSede")));			
	}
	
	public static void validarIdSistAdm(Long idSistAdm)
	 throws Validador
	{				
					if(idSistAdm==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.idSistAdm"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdSistAdm")));
			if(idSistAdm.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.idSistAdm"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloIdSistAdm")));			
	}
	public static void validarIdFinancia(Long idFinancia)
			 throws Validador
				{				
								if(idFinancia==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idFinancia"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdFinancia")));
					}
	
	
	public static void validarFechaFinalizacion(Timestamp fechaFinalizacion)
	 throws Validador
	{				
					if(fechaFinalizacion==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.fechaFinalizacion"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaFinalizacion")));
		}
	
	public static void validarFlagPubli(Long flagPubli)
	 throws Validador
	{				
					if(flagPubli==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.flagPubli"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFlagPubli")));
	}	
	
	public static void validarIdModalidad(Long idModalidad)
			 throws Validador
				{				
								if(idModalidad==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
						Messages.getStringToKey("dtCapacitacion.idModalidad"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloIdModalidad")));
					}
	
	
	public static void validarDetalleCapaVirtual(String detalleCapaVirtual)
	 throws Validador
	{					
			if(detalleCapaVirtual==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.detalleCapaVirtual"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapaVirtual")));
			if(detalleCapaVirtual.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.detalleCapaVirtual"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapaVirtual")));						
			if(detalleCapaVirtual!=null){
				if(detalleCapaVirtual.trim().length()>1000)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.detalleCapaVirtual"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),1000,
			Messages.getStringToKey("dtCapacitacion.articuloDetalleCapaVirtual")));
				}
	}
	
	public static void validarFechaIniProgramada(Timestamp fechaIniProgramada)
	 throws Validador
	{				
					if(fechaIniProgramada==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.fechaIniProgramada"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaIniProgramada")));
		}
	
	public static void validarFechaFinProgramada(Timestamp fechaFinProgramada)
	 throws Validador
	{				
					if(fechaFinProgramada==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.fechaFinProgramada"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaFinProgramada")));
		}
	
	public static void validarFechaSoli(Timestamp fechaSoli)
	 throws Validador
	{				
					if(fechaSoli==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),//MPINARES 14022024 - INICIO
			Messages.getStringToKey("dtCapacitacion.fechaSoli"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFechaSoli")));
		}
	
	public static void validarStdIddoc(Long stdIddoc)
	 throws Validador
	{				
					if(stdIddoc==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.stdIddoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdIddoc")));
			if(stdIddoc.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.stdIddoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdIddoc")));			
	}
	
	public static void validarStdNumeroSid(String stdNumeroSid)
	 throws Validador
	{					
			if(stdNumeroSid==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroSid"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdNumeroSid")));
			if(stdNumeroSid.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroSid"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(stdNumeroSid!=null){
				if(stdNumeroSid.trim().length()>50)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroSid"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),50,
			Messages.getStringToKey("dtCapacitacion.articuloStdNumeroSid")));
				}
	}
	public static void validarStdNumeroAnio(Integer stdNumeroAnio)
			 throws Validador
				{				
								if(stdNumeroAnio==null)
									throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
						Messages.getStringToKey("dtCapacitacion.stdNumeroAnio"),
						Messages.getStringToKey("dtCapacitacion.titulotabla"),
						Messages.getStringToKey("dtCapacitacion.articuloStdNumeroAnio")));
					}
	
	
	public static void validarStdNumeroDoc(String stdNumeroDoc)
	 throws Validador
	{					
			if(stdNumeroDoc==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdNumeroDoc")));
			if(stdNumeroDoc.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(stdNumeroDoc!=null){
				if(stdNumeroDoc.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.stdNumeroDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),200,
			Messages.getStringToKey("dtCapacitacion.articuloStdNumeroDoc")));
				}
	}
	
	public static void validarStdAsunto(String stdAsunto)
	 throws Validador
	{					
			if(stdAsunto==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.stdAsunto"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdAsunto")));
			if(stdAsunto.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdAsunto"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdAsunto")));						
			if(stdAsunto!=null){
				if(stdAsunto.trim().length()>600)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.stdAsunto"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),600,
			Messages.getStringToKey("dtCapacitacion.articuloStdAsunto")));
				}
	}
	
	public static void validarStdTipoDoc(String stdTipoDoc)
	 throws Validador
	{					
			if(stdTipoDoc==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.stdTipoDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdTipoDoc")));
			if(stdTipoDoc.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdTipoDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(stdTipoDoc!=null){
				if(stdTipoDoc.trim().length()>100)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.stdTipoDoc"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),100,
			Messages.getStringToKey("dtCapacitacion.articuloStdTipoDoc")));
				}
	}
	
	public static void validarStdFechaRecepcion(String stdFechaRecepcion)
	 throws Validador
	{				
					if(stdFechaRecepcion==null)
						throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdFechaRecepcion"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdFechaRecepcion")));
		}
	
	public static void validarStdModalidadIng(String stdModalidadIng)
	 throws Validador
	{					
			if(stdModalidadIng==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.stdModalidadIng"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloStdModalidadIng")));
			if(stdModalidadIng.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.stdModalidadIng"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(stdModalidadIng!=null){
				if(stdModalidadIng.trim().length()>200)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.stdModalidadIng"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),200,
			Messages.getStringToKey("dtCapacitacion.articuloStdModalidadIng")));
				}
	}
	
	public static void validarFlagEjec(Long flagEjec)
	 throws Validador
	{				
					if(flagEjec==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.seleccione"),
			Messages.getStringToKey("dtCapacitacion.flagEjec"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFlagEjec")));
			if(flagEjec.longValue()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoseleccione"),
			Messages.getStringToKey("dtCapacitacion.flagEjec"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloFlagEjec")));			
	}
	
	public static void validarMotivoEjec(String motivoEjec)
	 throws Validador
	{					
			if(motivoEjec==null)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.ingrese"),
			Messages.getStringToKey("dtCapacitacion.motivoEjec"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),
			Messages.getStringToKey("dtCapacitacion.articuloMotivoEjec")));
			if(motivoEjec.trim().length()<=0)
			throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.invalidoingrese"),
			Messages.getStringToKey("dtCapacitacion.motivoEjec"),
			Messages.getStringToKey("dtCapacitacion.titulotabla")));						
			if(motivoEjec!=null){
				if(motivoEjec.trim().length()>500)
					throw new Validador(MessageFormat.format(Messages.getStringToKey("dtCapacitacion.noexceder"),
			Messages.getStringToKey("dtCapacitacion.motivoEjec"),
			Messages.getStringToKey("dtCapacitacion.titulotabla"),500,
			Messages.getStringToKey("dtCapacitacion.articuloMotivoEjec")));
				}
	}
	
	//MPINARES 14022024 - INICIO
		public static void validarFechaServicioMensual(DtCapacitacionBk dtCapacitacionBk,
				DtAmpliacionFecha autorizacionEjecucion, DtAmpliacionFecha autorizacionProgramacion,
				DtCapacitacion dtCapacitacionOrig) throws Validador {
			// ID PROGRAMADA Y NO PROG
			Long idNoProgram = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
			Long idProgram = PropertiesMg.getSistemLong(
					PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA,
					PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);

			GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
			GregorianCalendar fechaIniCapa = new GregorianCalendar();
			GregorianCalendar fechaFinCapa = new GregorianCalendar();
			GregorianCalendar fechaHOy = new GregorianCalendar();
			Date fechaHoy=new Date();

			fechaHOy.setTimeInMillis(fechaHoy.getTime());
			fechaLimitIniMesActual = VerfechaLimitIniMes(fechaHoy, 0);
			Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
			fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaHoy, 0, diasHabEjec); //EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES 
			
			fechaIniCapa.setTimeInMillis(dtCapacitacionBk.getFechaInic().getTime());
			fechaFinCapa.setTimeInMillis(dtCapacitacionBk.getFechaFin().getTime());
			
			GregorianCalendar fechaLimitIniMesSgte= new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesSgte = new GregorianCalendar();
			
			Long diasLimitProg = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIALIMIT_PROGRAMAR,PropertiesMg.DEFOULT_DIALIMIT_PROGRAMAR);
			int diaHoy=fechaHOy.get(Calendar.DATE);
			
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
					fechaLimitIniMesActual=VerfechaLimitIniMes(fechaHoy, -1);
				}
			}


			if (dtCapacitacionBk.getIdCapacitacion() == null) {
				if (dtCapacitacionBk.getIdProgramacion().longValue() == idProgram) {
					
					if(fechaIniCapa.after(fechaLimitFinMesSgte) || fechaIniCapa.before(fechaLimitIniMesSgte)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesSgte);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
					    fmt.setCalendar(fechaLimitFinMesSgte);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

						throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE INICIO DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					
					if(fechaFinCapa.after(fechaLimitFinMesSgte) || fechaFinCapa.before(fechaLimitIniMesSgte)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesSgte);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
					    fmt.setCalendar(fechaLimitFinMesSgte);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

						throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE FIN DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					

				} else if (dtCapacitacionBk.getIdProgramacion().longValue() == idNoProgram) {
					
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
					
					if(fechaIniCapa.after(fechaLimitFinMesActual) || fechaIniCapa.before(fechaLimitIniMesActual)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesActual);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
					    fmt.setCalendar(fechaLimitFinMesActual);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//						throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR LA FECHA DE INICIO DE LA CAPACITACION DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					    throw new Validador(MessageFormat.format("LA FECHA DE INICIO DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					
					if(fechaFinCapa.after(fechaLimitFinMesActual) || fechaFinCapa.before(fechaLimitIniMesActual)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesActual);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
					    fmt.setCalendar(fechaLimitFinMesActual);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//						throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR LA FECHA DE INICIO DE LA CAPACITACION DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					    throw new Validador(MessageFormat.format("LA FECHA DE FIN DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					
				}

			} else {
				
//				// MPINARES - CREACION DE SERV NO PROGRAM DE MES ANTERIOR - CON  AMPLIACION
//				if (autorizacionEjecucion != null && autorizacionEjecucion.getIdAutorizacion() != null) {
//					fechaLimitFinMesActual = VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
//					fechaLimitIniMesActual = VerfechaLimitIniMes(fechaHoy, -1);
//				}
				
				if (dtCapacitacionBk.getIdProgramacion().longValue() == idProgram) {
					
					if(dtCapacitacionBk.isVistaProgramado()){
						if(dtCapacitacionOrig!=null && dtCapacitacionOrig.getFechaInic()!=null){
							if(!dtCapacitacionOrig.getFechaInic().equals(dtCapacitacionBk.getFechaInic())){
								if(fechaIniCapa.after(fechaLimitFinMesSgte) || fechaIniCapa.before(fechaLimitIniMesSgte)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesSgte);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
								    fmt.setCalendar(fechaLimitFinMesSgte);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

									throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE INICIO DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
											Messages.getStringToKey("dtAsistencias.fecha"),
											Messages.getStringToKey("dtAsistencias.titulotabla")));
								
								}
							}
						}
						
						if(dtCapacitacionOrig!=null && dtCapacitacionOrig.getFechaFin()!=null){
							if(!dtCapacitacionOrig.getFechaFin().equals(dtCapacitacionBk.getFechaFin())){
								if(fechaFinCapa.after(fechaLimitFinMesSgte) || fechaFinCapa.before(fechaLimitIniMesSgte)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesSgte);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesSgte.getTime());
								    fmt.setCalendar(fechaLimitFinMesSgte);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesSgte.getTime());

									throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE FIN DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
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
							fechaLimitIniMesSgte=VerfechaLimitIniMes(fechaHoy, -1);
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
						
						if(dtCapacitacionOrig!=null && dtCapacitacionOrig.getFechaInic()!=null){
							if(!dtCapacitacionOrig.getFechaInic().equals(dtCapacitacionBk.getFechaInic())){
//								if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
								if(fechaIniCapa.after(fechaLimitFinMesActual) || fechaIniCapa.before(fechaLimitIniMesActual)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesActual);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
								    fmt.setCalendar(fechaLimitFinMesActual);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

								    throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE INICIO DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
											Messages.getStringToKey("dtAsistencias.fecha"),
											Messages.getStringToKey("dtAsistencias.titulotabla")));
								
								}
							}
						}
						
						if(dtCapacitacionOrig!=null && dtCapacitacionOrig.getFechaFin()!=null){
							if(!dtCapacitacionOrig.getFechaFin().equals(dtCapacitacionBk.getFechaFin())){
//								if(fechaServicio.after(fechaLimitFinMesSgte) || fechaServicio.before(fechaLimitIniMesSgte)){
								if(fechaFinCapa.after(fechaLimitFinMesActual) || fechaFinCapa.before(fechaLimitIniMesActual)){
									SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
								    fmt.setCalendar(fechaLimitIniMesActual);
								    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
								    fmt.setCalendar(fechaLimitFinMesActual);
								    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

								    throw new Validador(MessageFormat.format("SOLO PUEDE PROGRAMAR LA FECHA DE INICIO DEL SERVICIO DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
											Messages.getStringToKey("dtAsistencias.fecha"),
											Messages.getStringToKey("dtAsistencias.titulotabla")));
								
								}
							}
						}
						
					}
					

				} else	if (dtCapacitacionBk.getIdProgramacion().longValue() == idNoProgram	) {
					
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
					
					if(fechaIniCapa.after(fechaLimitFinMesActual) || fechaIniCapa.before(fechaLimitIniMesActual)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesActual);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
					    fmt.setCalendar(fechaLimitFinMesActual);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//						throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR LA FECHA DE INICIO DE LA CAPACITACION DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					    throw new Validador(MessageFormat.format("LA FECHA DE INICIO DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					
					if(fechaFinCapa.after(fechaLimitFinMesActual) || fechaFinCapa.before(fechaLimitIniMesActual)){
						SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
					    fmt.setCalendar(fechaLimitIniMesActual);
					    String dateFormatteIni = fmt.format(fechaLimitIniMesActual.getTime());
					    fmt.setCalendar(fechaLimitFinMesActual);
					    String dateFormatteFin = fmt.format(fechaLimitFinMesActual.getTime());

//						throw new Validador(MessageFormat.format("SOLO PUEDE REGISTRAR LA FECHA DE INICIO DE LA CAPACITACION DESDE EL "+dateFormatteIni.toUpperCase()+" HASTA EL "+dateFormatteFin.toUpperCase() ,
					    throw new Validador(MessageFormat.format("LA FECHA DE FIN DEL SERVICIO NO ESTA DENTRO DEL RANGO PERMITIDO",
								Messages.getStringToKey("dtAsistencias.fecha"),
								Messages.getStringToKey("dtAsistencias.titulotabla")));
					
					}
					
					
				}

			}

		}
		
		public static GregorianCalendar VerfechaLimitIniMes(Date fecha, int mesLimit) {
			GregorianCalendar fechaLimitIni = new GregorianCalendar();
			fechaLimitIni.setTimeInMillis(fecha.getTime());
			fechaLimitIni.add(Calendar.MONTH, mesLimit);
			fechaLimitIni.set(Calendar.DAY_OF_MONTH,
					fechaLimitIni.getActualMinimum(Calendar.DAY_OF_MONTH));
			fechaLimitIni.set(Calendar.HOUR_OF_DAY,
					fechaLimitIni.getActualMinimum(Calendar.HOUR_OF_DAY));
			fechaLimitIni.set(Calendar.MINUTE,
					fechaLimitIni.getActualMinimum(Calendar.MINUTE));
			fechaLimitIni.set(Calendar.SECOND,
					fechaLimitIni.getActualMinimum(Calendar.SECOND));
			fechaLimitIni.set(Calendar.MILLISECOND,
					fechaLimitIni.getActualMinimum(Calendar.MILLISECOND));
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
		
		public static GregorianCalendar VerfechaLimitFinMes(Date fecha, int mesLimit) {
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.add(Calendar.MONTH, mesLimit);
			fechaLimitFin.set(Calendar.DAY_OF_MONTH,
					fechaLimitFin.getActualMaximum(Calendar.DAY_OF_MONTH));
			fechaLimitFin.set(Calendar.HOUR_OF_DAY,
					fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE,
					fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND,
					fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND,
					fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
			return fechaLimitFin;
		}
		
		public static GregorianCalendar VerfechaLimitFinDay(Date fecha, int mesLimit) {
			GregorianCalendar fechaLimitFin = new GregorianCalendar();
			fechaLimitFin.setTimeInMillis(fecha.getTime());
			fechaLimitFin.set(Calendar.HOUR_OF_DAY,
					fechaLimitFin.getActualMaximum(Calendar.HOUR_OF_DAY));
			fechaLimitFin.set(Calendar.MINUTE,
					fechaLimitFin.getActualMaximum(Calendar.MINUTE));
			fechaLimitFin.set(Calendar.SECOND,
					fechaLimitFin.getActualMaximum(Calendar.SECOND));
			fechaLimitFin.set(Calendar.MILLISECOND,
					fechaLimitFin.getActualMaximum(Calendar.MILLISECOND));
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
		
		public static void validarFechaReactiva(DtCapacitacionBk dtCapacitacionBk, DtAmpliacionFecha autorizacionEjecucion) throws Validador{

			Date fechaHoy=new Date();
			GregorianCalendar fechaLimitIniMesActual = new GregorianCalendar();
			GregorianCalendar fechaLimitFinMesActual = new GregorianCalendar();
			GregorianCalendar fechaServicioini = new GregorianCalendar();
			GregorianCalendar fechaHOy = new GregorianCalendar();
			fechaHOy.setTimeInMillis(fechaHoy.getTime());
			
			fechaServicioini.setTimeInMillis(dtCapacitacionBk.getFechaInic().getTime());
			
			
			fechaLimitIniMesActual=ValidacionDtAsistenciaMng.VerfechaLimitIniMes(fechaServicioini.getTime(), 0);
			Long diasHabEjec = PropertiesMg.getSistemLong(PropertiesMg.KEY_DIASHAB_EJECUCION,PropertiesMg.DEFOULT_DIASHAB_EJECUCION);
			fechaLimitFinMesActual=VerfechaLimitFinMesMasXdiasHabiles(fechaServicioini.getTime(), 0, diasHabEjec);//EN REALIDAD ESTE NO TRAE EL FIN DE MES ... SINO 0X DIAS HABILES POSTERIORES AL FIN DE MES
			
			if(autorizacionEjecucion!=null && autorizacionEjecucion.getFechaFin()!=null){
				GregorianCalendar fechaParamEjec= new GregorianCalendar();
				fechaParamEjec=ValidacionDtAsistenciaMng.VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
				if(fechaHOy.before(fechaParamEjec)){
					fechaLimitFinMesActual=ValidacionDtAsistenciaMng.VerfechaLimitFinDay(autorizacionEjecucion.getFechaFin(), 0);
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
		
		public static void validarDtCapacitacionFechaInicioAntesFechaFin(Date fechaInicReprog, Date fechaFinReprog)
				throws Validador {
					 if(fechaInicReprog!=null &&fechaFinReprog!=null){
						 GregorianCalendar fechaHoraInicio = new GregorianCalendar();
						 GregorianCalendar fechaHoraFin = new GregorianCalendar();
						 fechaHoraInicio.setTimeInMillis(fechaInicReprog.getTime());
						 fechaHoraFin.setTimeInMillis(fechaFinReprog.getTime());
					
						 if (fechaHoraInicio.getTimeInMillis()>=fechaHoraFin.getTimeInMillis()) {
						 	throw new Validador(MessageFormat.format(
						 			Messages.getStringToKey("dtCapacitacion.invalidoMayorInicioFin"),
						 			Messages.getStringToKey("dtCapacitacion.titulotabla")));
						 }			 
					 }
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
						 
						if (fechaGreSoli.getTimeInMillis()>fechaGreIni.getTimeInMillis()) {//MPINARES 02062023 - INICIO
						 	throw new Validador(MessageFormat.format(
						 			Messages.getStringToKey("validacion.fecha.soli.antes"),
						 			Messages.getStringToKey("dtCapacitacion.titulotabla")));
						}	
						GregorianCalendar fechaLimit = new GregorianCalendar();
						fechaLimit=VerfechaLimiDiaMesAnterior(fechaServicio);
//						String fechaa=fechaLimit.getTime()+"";
						if (fechaGreSoli.getTimeInMillis()<fechaLimit.getTimeInMillis()) {
							throw new Validador(MessageFormat.format(
						 			Messages.getStringToKey("validación.fecha.soli.un.mes"),
						 			Messages.getStringToKey("dtCapacitacion.titulotabla")));
						}
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
		
}