package pe.gob.mef.registramef.bs.dao;

import java.util.Date;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.ReporteAsistencia;
import pe.gob.mef.registramef.bs.domain.ReporteAsistenciaDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacion;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacionDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteConsulta;
import pe.gob.mef.registramef.bs.domain.ReporteVisita;
import pe.gob.mef.registramef.bs.domain.ReporteVisitaDetalle;
import pe.gob.mef.registramef.bs.exception.Validador;

public interface ReporteServicioDao {

	List<ReporteAsistencia> getResumenAsistencias(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede);

	List<ReporteCapacitacion> getResumenCapacitaciones(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede);

	List<ReporteConsulta> getResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede);

	List<ReporteVisita> getResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede);

	List<ReporteAsistenciaDetallado> getResumenAsistenciasDetallado(Long idEstado, Long idUserInt, Date fechaInicio,
			Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;// SPRINT_8.3

	List<ReporteCapacitacionDetallado> getResumenCapacitacionDetallado(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;// SPRINT_8
	
	List<ReporteCapacitacionDetallado> getResumenCapacitacion(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;
	
	List<ReporteCapacitacionDetallado> getResumenCapacitacionUsersByTematica(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;
	
	List<ReporteCapacitacionDetallado> getResumenCapacitacionByModalidad(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;

	List<ReporteConsulta> getResumenConsultas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;// SPRINT_8.3/
	

	List<ReporteVisitaDetalle> getResumenVisitas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;// SPRINT_8.3
	
	List<ReporteVisitaDetalle> getResumenReunionTrabajoEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteVisitaDetalle> getResumenReunionTrabajoUsersByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteAsistencia> getResumenAsistenciaTecnicaEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteAsistencia> getResumenAsistenciaTecnicaByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteAsistencia> getResumenAsistenciaTecnicaByModalidad(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteAsistencia> getResumenAsistenciaTecnicaDentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	
	
	List<ReporteConsulta> getResumenConsultaEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteConsulta> getResumenConsultaByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReporteConsulta> getResumenConsultaByModalidad(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	
	
	List<ReporteConsulta> getResumenEstadisticaPorTema(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;

	Long getTotalResumenCapacitacionDetallado(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede,
			Long idUserInt, Long idEstado, boolean flagAsis) throws Validador;// SPRINT_8

	Long getTotalReporteAsistenciaDetalleBkList(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede,
			Long idUserInt, Long idEstado) throws Validador;// SPRINT_8.3

	Long getTotalResumenConsultas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Long idUserInt,
			Long idEstado) throws Validador;// SPRINT_8.3

	Long getTotalResumenVisitas(Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Long idUserInt,
			Long idEstado) throws Validador;// SPRINT_8.3

	public List<Object> getServicioPorSede(Long idEstado, String idSisAdm, Date fechaInicio, Date fechaFin)
			throws Validador;

	List<Object> getServicioPorAvanceMeta(String idSisAdm, Date fechaAvance) throws Validador;

}
