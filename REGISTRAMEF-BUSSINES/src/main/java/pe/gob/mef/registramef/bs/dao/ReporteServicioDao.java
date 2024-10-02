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
import pe.gob.mef.registramef.bs.transfer.ReportDashboardDto;

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
	
	List<ReportDashboardDto> getResumenCapacitacion(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;
	
	List<ReportDashboardDto> getResumenCapacitacionUsersByTematica(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;
	
	List<ReportDashboardDto> getResumenCapacitacionByModalidad(Long idUserInt, Long idEstado, boolean flagAsis,
			Date fechaInicio, Date fechaFin, Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro)
			throws Validador;

	List<ReporteConsulta> getResumenConsultas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;// SPRINT_8.3/
	
	List<ReporteVisitaDetalle> getResumenVisitas(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;// SPRINT_8.3
	
	List<ReportDashboardDto> getResumenReunionTrabajoEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenReunionTrabajoUsersByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenAsistenciaTecnicaEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenAsistenciaTecnicaByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenAsistenciaTecnicaByModalidad(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenAsistenciaTecnicaDentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenConsultaDentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenCapacitacionDentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenAsistenciaTecnicaSADentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenConsultaSADentroFueraPlazo(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	
	
	
	
	
	
	
	
	
	
	List<ReportDashboardDto> getResumenConsultaEvolMensual(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenConsultaByTematica(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	List<ReportDashboardDto> getResumenConsultaByModalidad(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
			Long idSistAdmin, Long idSede, Integer maxRegistro, Integer minRegistro) throws Validador;
	
	
	
	List<ReportDashboardDto> getResumenEstadisticaPorTema(Long idEstado, Long idUserInt, Date fechaInicio, Date fechaFin,
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
