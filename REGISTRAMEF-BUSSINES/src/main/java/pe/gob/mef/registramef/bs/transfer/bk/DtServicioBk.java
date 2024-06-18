package pe.gob.mef.registramef.bs.transfer.bk;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;

import pe.gob.mef.registramef.bs.resources.Messages;
import pe.gob.mef.registramef.bs.transfer.PerfilDto;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;
import pe.gob.mef.registramef.bs.utils.PropertiesMg.Modulo;

public class DtServicioBk {
	
	public static Modulo getModulo(Object servicioBk) throws Exception{
		return (Modulo)FuncionesStaticas.getAttributeValue(servicioBk, "modulo");
	}
	public static Long getIdServicio(Object servicioBk) throws Exception{
		Long idServicio=null; 
		if(servicioBk instanceof DtAsistenciaBk) {
			idServicio = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idAsistencia");
		}else if(servicioBk instanceof DtCapacitacionBk) {
			idServicio = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idCapacitacion");
		}else if(servicioBk instanceof DtVisitasBk) {
			idServicio = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idVisita");
		}else if(servicioBk instanceof DtSeguimientoBk) {
			idServicio = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idSeguimiento");
		}
		return idServicio;
	}
	public static Date getFechaProgramacion(Object servicioBk) throws Exception{
		Date fechaProgramacion=null;
		if(servicioBk instanceof DtAsistenciaBk) {
			fechaProgramacion = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaAsistencia");
		}else if(servicioBk instanceof DtCapacitacionBk) {
			fechaProgramacion = FuncionesStaticas.toDate((Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaInic"));
		}else if(servicioBk instanceof DtVisitasBk) {
			fechaProgramacion = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaVisita");
		}else if(servicioBk instanceof DtSeguimientoBk) {
			fechaProgramacion = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaSeguimiento");
		}
		return fechaProgramacion;
	}
	public static Date getFechaProgramacionFin(Object servicioBk) throws Exception{
		Date fechaProgramacionFin=null;
		if(servicioBk instanceof DtCapacitacionBk) {
			fechaProgramacionFin = FuncionesStaticas.toDate((Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaFin"));
		}
		return fechaProgramacionFin;
	}
	public static Date getFechaEjecucion(Object servicioBk) throws Exception{
		Date fechaEjecucion=null;
		if(servicioBk instanceof DtCapacitacionBk) {
			fechaEjecucion = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaEjecucionInic");
		}else{
			fechaEjecucion = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaEjecucion");
		}
		return fechaEjecucion;
	}
	public static Date getFechaEjecucionFin(Object servicioBk) throws Exception{
		Date fechaEjecucionFin=null;
		if(servicioBk instanceof DtCapacitacionBk) {
			fechaEjecucionFin = (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaEjecucionFin");
		}
		return fechaEjecucionFin;
	}
	public static Date getFechaServicio(Object servicioBk) throws Exception{
		if(esProgramado(servicioBk)) {
			if(getModulo(servicioBk)==Modulo.REGISTRO) {
				return getFechaEjecucion(servicioBk);
			}else {
				return getFechaProgramacion(servicioBk);
			}
		}else if(esNoProgramado(servicioBk)){
			return getFechaEjecucion(servicioBk);
		}else {
			return null;
		}
	}
	
	public static Long getIdModalidad(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idModalidad");
	}
	public static Long getIdFinancia(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idFinancia");
	}
	public static Long getIdLocal(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idLocal");
	}
	
	public static Long getIdProgramacion(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idProgramacion");
	}
	public static Long getIdSede(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idSede");
	}
	public static Long getIdSistAdm(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idSistAdm");
	}
	public static Long getIdServicioOrigen(Object servicioBk) throws Exception{
		Long idServicioOrigen=null; 
		if(servicioBk instanceof DtAsistenciaBk) {
			idServicioOrigen = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idAsistenciaOrigen");
		}else if(servicioBk instanceof DtCapacitacionBk) {
			idServicioOrigen = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idCapacitacionOrigen");
		}else if(servicioBk instanceof DtVisitasBk) {
			idServicioOrigen = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idVisitaOrigen");
//		}else if(servicioBk instanceof DtSeguimientoBk) {
//			idServicioOrigen = (Long)FuncionesStaticas.getAttributeValue(servicioBk, "idSeguimientoOrigen");
		}
		return idServicioOrigen;
	}
	public static Long getEstado(Object servicioBk) throws Exception{
		return (Long)FuncionesStaticas.getAttributeValue(servicioBk, "estado");		
	}
	public static Date getFechaCrea(Object servicioBk) throws Exception{
		return (Date)FuncionesStaticas.getAttributeValue(servicioBk, "fechaCrea");
	}
	
	public static boolean esNuevo(Object servicioBk) throws Exception{
		if (servicioBk!=null && getIdServicio(servicioBk)!=null && getIdServicio(servicioBk).intValue()>0) {
			return false;
		}else {
			return true;
		}
	}
	public static boolean esProgramado(Object servicioBk) throws Exception{
		Long idProgramada = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_PROGRAMADA, PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_PROGRAMADA);
		if(getIdProgramacion(servicioBk)!=null && getIdProgramacion(servicioBk).longValue()==idProgramada.longValue()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean esNoProgramado(Object servicioBk) throws Exception{
		Long idNoProgramada = PropertiesMg.getSistemLong(PropertiesMg.KEY_PRTPARAMETROS_IDTIPO_NOPROGRAMADA, PropertiesMg.DEFOULT_PRTPARAMETROS_IDTIPO_NOPROGRAMADA);
		if(getIdProgramacion(servicioBk)!=null && getIdProgramacion(servicioBk).longValue()==idNoProgramada.longValue()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean esFinalizado(Object servicioBk) throws Exception{
		Long estadoFinalizado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_FINALIZADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_FINALIZADO);
		if(getEstado(servicioBk)!=null && getEstado(servicioBk).longValue()==estadoFinalizado.longValue()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean esAnulado(Object servicioBk) throws Exception{
		Long estadoAnulado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
		if(getEstado(servicioBk)!=null && getEstado(servicioBk).longValue()==estadoAnulado.longValue()) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean esCambioActividad(Object servicioBk) throws Exception{
		Long estadoCambioActividad = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_CAMBIO_ACTIVIDAD, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_CAMBIO_ACTIVIDAD);
		if(getEstado(servicioBk)!=null && getEstado(servicioBk).longValue()==estadoCambioActividad.longValue()) {
			return true;
		}else {
			return false;
		}
	}
	
//	public static void validarFechaEjecucion(Object servicioBk) throws Validador{
//		try {
//			if(getModulo(servicioBk)==Modulo.REGISTRO) {
//				Date fechaProgramacion=DtServicioBk.getFechaProgramacion(servicioBk);
//				Date fechaEjecucion=DtServicioBk.getFechaEjecucion(servicioBk);
//				
//				if(fechaEjecucion==null) 
//					throw new Validador(Messages.getStringToKey("comun.valida.fechaEjecucion"));
//				if(servicioBk instanceof DtCapacitacionBk && getFechaEjecucionFin(servicioBk)==null) 
//					throw new Validador(Messages.getStringToKey("comun.valida.fechaEjecucion"));
//
//				System.out.println(FuncionesStaticas.toString(fechaProgramacion, null, true)+" - "+FuncionesStaticas.toString(fechaEjecucion, null, true));
//				if(DtServicioBk.esProgramado(servicioBk) && fechaProgramacion!=null && fechaEjecucion!=null && fechaEjecucion.before(fechaProgramacion)) {
//					throw new Validador(Messages.getStringToKey("comun.valida.fechaEjecucionMenorProgramacion"));
//				}
//			}
//		} catch (Exception e) {
//			throw new Validador(e.getMessage());
//		}
//	}
	
	public static boolean esCampoDePrtParametro(String atributo) {
		try {
			String[] campos = {
					"estado", 
					"idOrigen", 
					"idProgramacion", 
					"idFinancia", 
					"idModo", 
					"idNivel", 
					"idOrigen", 
					"idPrestacion", 
					"idTipo", 
					"idModalidad", 
					"idCargo", 
					"idPrestservic", 
					"tipoFechaCorte", 
					"idEstadoActual", 
					"idEstadoSeguimiento",
					//MZARATE 27062019 INICIO 
					"tipoServicio"
					//MZARATE 27062019 FIN
				};
			if(FuncionesStaticas.contains(campos, atributo))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean esCampoSinDescripcion(String atributo) {
		try {
			String[] campos = {"class", "fechaAsistencia", "fechaInic", "fechaFin", "fechaVisita", "fechaConsu", "fechaSeguimiento", "fechaEjecucion", "fechaEjecucionInic", "fechaEjecucionFin", "detalle", "idusserCrea", "idusserModif", "fechaCrea", "fechaModif", "rtmaddress", "rtmaddressrst", "idAsistenciaOrigen", "motivoCambioActividad", "nomEvento", "detalleCapa", "cantParticAsist", "idCapaPadre", "conclusion", "respuesta", "correoUsuext", "fijoUsuext", "celularUsuext", "fechaInicio", "fechaFin", "nombre", "aPaterno", "aMaterno", "direccion", "correo", "telefFijo", "telefCell", "numDocu", "sexo", "descripcion"};
			if(FuncionesStaticas.contains(campos, atributo))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static int getIdPerfil(Object servicioBk) throws Exception{
		PerfilDto perfil = (PerfilDto)FuncionesStaticas.getAttributeValue(servicioBk, "perfil");
		return perfil.getId();
	}
	public static Long getIdSedePerfil(Object servicioBk) throws Exception{
		PerfilDto perfil = (PerfilDto)FuncionesStaticas.getAttributeValue(servicioBk, "perfil");
		return perfil.getIdSede();
	}
	public static Long getIdSistAdmiPerfil(Object servicioBk) throws Exception{
		PerfilDto perfil = (PerfilDto)FuncionesStaticas.getAttributeValue(servicioBk, "perfil");
		return perfil.getIdSistAdmi();
	}
	
	public static void validarModalidad(Object servicioBk) throws Exception{
		Long idModalidad = getIdModalidad(servicioBk);
		if(idModalidad==null || (idModalidad!=null && idModalidad.longValue()<=0)) 
			throw new Exception(Messages.getStringToKey("comun.valida.modalidadVacia"));
	}
	public static void validarFinanciamiento(Object servicioBk) throws Exception{
		Long idFinancia = getIdFinancia(servicioBk);
		if(idFinancia==null || (idFinancia!=null && idFinancia.longValue()<=0)) 
			throw new Exception(Messages.getStringToKey("comun.valida.financiamientoVacio"));
	}
	public static void validarLocal(Object servicioBk) throws Exception{
		Long idLocal = getIdLocal(servicioBk);
		if(idLocal==null || (idLocal!=null && idLocal.longValue()<=0)) 
			throw new Exception(Messages.getStringToKey("comun.valida.localVacio"));
	}
	public static void validarEntidad(DtEntidadesBk entidadBk) throws Exception{
		if(entidadBk==null || entidadBk.getIdEntidad()==null) 
			throw new Exception(Messages.getStringToKey("comun.valida.entidadVacia"));
	}
	public static void validarTemas(Collection<?> temasAgregados) throws Exception{
		if (CollectionUtils.isEmpty(temasAgregados)) 
			throw new Exception(Messages.getStringToKey("comun.valida.listaTemasVacia"));
	}
	public static void validarUsuariosExternos(Collection<?> usuariosAgregados) throws Exception{
		if (CollectionUtils.isEmpty(usuariosAgregados)) 
			throw new Exception(Messages.getStringToKey("comun.valida.listaParticipanteVacio"));
	}
	
}