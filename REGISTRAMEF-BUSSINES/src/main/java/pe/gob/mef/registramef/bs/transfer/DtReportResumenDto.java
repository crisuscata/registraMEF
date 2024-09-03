package pe.gob.mef.registramef.bs.transfer;

import java.util.ArrayList;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.ReporteAsistencia;
import pe.gob.mef.registramef.bs.domain.ReporteAsistenciaDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacionDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteConsulta;
import pe.gob.mef.registramef.bs.domain.ReporteVisitaDetalle;

public class DtReportResumenDto {
	
	private List<ReporteAsistenciaDetallado> listAsistencia;
	private List<ReporteCapacitacionDetallado> listCapacitacion;
	private List<ReporteCapacitacionDetallado> listCapacitacionEvolMensual;
	private List<ReporteCapacitacionDetallado> listCapacitacionUsSegunTematica;
	private List<ReporteCapacitacionDetallado> listCapacitacionModalidad;
	private List<ReporteVisitaDetalle> listReunionTrabajoEvolMensual;
	private List<ReporteVisitaDetalle> listReunionTrabajoUsSegunTematica;
	
	private List<ReporteAsistencia> listReporteAsistenciaTecnicaEvolMensual;
	private List<ReporteConsulta> 	listEstadisticaPorTema;
	/*private List<ReporteConsulta> listConsulta;
	private List<ReporteVisitaDetalle> listVisita;*/
	
	public DtReportResumenDto() {
		this.listAsistencia = new ArrayList<>();
		this.listCapacitacion = new ArrayList<>();
		this.listCapacitacionEvolMensual = new ArrayList<>();
		this.listCapacitacionUsSegunTematica = new ArrayList<>();
		this.listCapacitacionModalidad = new ArrayList<>();
		this.listReunionTrabajoEvolMensual  = new ArrayList<>();
		this.listReunionTrabajoUsSegunTematica  = new ArrayList<>();
		this.listReporteAsistenciaTecnicaEvolMensual = new ArrayList<>();
		this.listEstadisticaPorTema = new ArrayList<>();	
	}
	
	public List<ReporteAsistenciaDetallado> getListAsistencia() {
		return listAsistencia;
	}
	public void setListAsistencia(List<ReporteAsistenciaDetallado> listAsistencia) {
		this.listAsistencia = listAsistencia;
	}
	public List<ReporteCapacitacionDetallado> getListCapacitacion() {
		return listCapacitacion;
	}
	public void setListCapacitacion(List<ReporteCapacitacionDetallado> listCapacitacion) {
		this.listCapacitacion = listCapacitacion;
	}
	public List<ReporteCapacitacionDetallado> getListCapacitacionEvolMensual() {
		return listCapacitacionEvolMensual;
	}

	public void setListCapacitacionEvolMensual(List<ReporteCapacitacionDetallado> listCapacitacionEvolMensual) {
		this.listCapacitacionEvolMensual = listCapacitacionEvolMensual;
	}

	public List<ReporteCapacitacionDetallado> getListCapacitacionUsSegunTematica() {
		return listCapacitacionUsSegunTematica;
	}

	public void setListCapacitacionUsSegunTematica(List<ReporteCapacitacionDetallado> listCapacitacionUsSegunTematica) {
		this.listCapacitacionUsSegunTematica = listCapacitacionUsSegunTematica;
	}

	public List<ReporteCapacitacionDetallado> getListCapacitacionModalidad() {
		return listCapacitacionModalidad;
	}

	public void setListCapacitacionModalidad(List<ReporteCapacitacionDetallado> listCapacitacionModalidad) {
		this.listCapacitacionModalidad = listCapacitacionModalidad;
	}

	public List<ReporteVisitaDetalle> getListReunionTrabajoEvolMensual() {
		return listReunionTrabajoEvolMensual;
	}

	public void setListReunionTrabajoEvolMensual(List<ReporteVisitaDetalle> listReunionTrabajoEvolMensual) {
		this.listReunionTrabajoEvolMensual = listReunionTrabajoEvolMensual;
	}

	public List<ReporteVisitaDetalle> getListReunionTrabajoUsSegunTematica() {
		return listReunionTrabajoUsSegunTematica;
	}

	public void setListReunionTrabajoUsSegunTematica(List<ReporteVisitaDetalle> listReunionTrabajoUsSegunTematica) {
		this.listReunionTrabajoUsSegunTematica = listReunionTrabajoUsSegunTematica;
	}

	public List<ReporteAsistencia> getListReporteAsistenciaTecnicaEvolMensual() {
		return listReporteAsistenciaTecnicaEvolMensual;
	}

	public void setListReporteAsistenciaTecnicaEvolMensual(List<ReporteAsistencia> listReporteAsistenciaTecnicaEvolMensual) {
		this.listReporteAsistenciaTecnicaEvolMensual = listReporteAsistenciaTecnicaEvolMensual;
	}

	public List<ReporteConsulta> getListEstadisticaPorTema() {
		return listEstadisticaPorTema;
	}

	public void setListEstadisticaPorTema(List<ReporteConsulta> listEstadisticaPorTema) {
		this.listEstadisticaPorTema = listEstadisticaPorTema;
	}
}