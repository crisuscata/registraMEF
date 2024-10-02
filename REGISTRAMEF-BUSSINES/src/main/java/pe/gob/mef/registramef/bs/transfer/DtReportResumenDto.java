package pe.gob.mef.registramef.bs.transfer;

import java.util.ArrayList;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.ReporteAsistencia;
import pe.gob.mef.registramef.bs.domain.ReporteAsistenciaDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacion;
import pe.gob.mef.registramef.bs.domain.ReporteCapacitacionDetallado;
import pe.gob.mef.registramef.bs.domain.ReporteConsulta;
import pe.gob.mef.registramef.bs.domain.ReporteVisitaDetalle;

public class DtReportResumenDto {
	
	private List<ReporteAsistenciaDetallado> listAsistencia;
	private List<ReporteCapacitacionDetallado> listCapacitacion;
	private List<ReportDashboardDto> listCapacitacionEvolMensual;
	private List<ReportDashboardDto> listCapacitacionUsSegunTematica;
	private List<ReportDashboardDto> listCapacitacionModalidad;
	private List<ReportDashboardDto> listReunionTrabajoEvolMensual;
	private List<ReportDashboardDto> listReunionTrabajoUsSegunTematica;
	
	private List<ReportDashboardDto> listReporteAsistenciaTecnicaEvolMensual;
	private List<ReportDashboardDto> listReporteAsistenciaTecnicaSegunTematica;
	private List<ReportDashboardDto> listReporteAsistenciaTecnicaModalidad;
	
	private List<ReportDashboardDto> lisConsultaEvolMensual;
	private List<ReportDashboardDto> listConsultaSegunTematica;
	private List<ReportDashboardDto> listConsultaModalidad;
	
	
	private List<ReportDashboardDto> 	listEstadisticaPorTema;
	
	private List<ReportDashboardDto> listAsistenciaDentroFueraPlazo;
	private List<ReportDashboardDto> listConsultaDentroFueraPlazo;
	private List<ReportDashboardDto> listCapacitacionDentroFueraPlazo;
	
	private List<ReportDashboardDto> listAsistenciaSADentroFueraPlazo;
	private List<ReportDashboardDto> listConsultaSADentroFueraPlazo;
	
	
	public List<ReportDashboardDto> getListReporteAsistenciaTecnicaSegunTematica() {
		return listReporteAsistenciaTecnicaSegunTematica;
	}

	public void setListReporteAsistenciaTecnicaSegunTematica(
			List<ReportDashboardDto> listReporteAsistenciaTecnicaSegunTematica) {
		this.listReporteAsistenciaTecnicaSegunTematica = listReporteAsistenciaTecnicaSegunTematica;
	}

	public List<ReportDashboardDto> getListReporteAsistenciaTecnicaModalidad() {
		return listReporteAsistenciaTecnicaModalidad;
	}

	public void setListReporteAsistenciaTecnicaModalidad(List<ReportDashboardDto> listReporteAsistenciaTecnicaModalidad) {
		this.listReporteAsistenciaTecnicaModalidad = listReporteAsistenciaTecnicaModalidad;
	}

	public List<ReportDashboardDto> getLisConsultaEvolMensual() {
		return lisConsultaEvolMensual;
	}

	public void setLisConsultaEvolMensual(List<ReportDashboardDto> lisConsultaEvolMensual) {
		this.lisConsultaEvolMensual = lisConsultaEvolMensual;
	}

	public List<ReportDashboardDto> getListConsultaSegunTematica() {
		return listConsultaSegunTematica;
	}

	public void setListConsultaSegunTematica(List<ReportDashboardDto> listConsultaSegunTematica) {
		this.listConsultaSegunTematica = listConsultaSegunTematica;
	}

	public List<ReportDashboardDto> getListConsultaModalidad() {
		return listConsultaModalidad;
	}

	public void setListConsultaModalidad(List<ReportDashboardDto> listConsultaModalidad) {
		this.listConsultaModalidad = listConsultaModalidad;
	}

	public List<ReportDashboardDto> getListEstadisticaPorTema() {
		return listEstadisticaPorTema;
	}

	public void setListEstadisticaPorTema(List<ReportDashboardDto> listEstadisticaPorTema) {
		this.listEstadisticaPorTema = listEstadisticaPorTema;
	}

	public List<ReportDashboardDto> getListAsistenciaDentroFueraPlazo() {
		return listAsistenciaDentroFueraPlazo;
	}

	public void setListAsistenciaDentroFueraPlazo(List<ReportDashboardDto> listAsistenciaDentroFueraPlazo) {
		this.listAsistenciaDentroFueraPlazo = listAsistenciaDentroFueraPlazo;
	}

	public List<ReportDashboardDto> getListConsultaDentroFueraPlazo() {
		return listConsultaDentroFueraPlazo;
	}

	public void setListConsultaDentroFueraPlazo(List<ReportDashboardDto> listConsultaDentroFueraPlazo) {
		this.listConsultaDentroFueraPlazo = listConsultaDentroFueraPlazo;
	}

	public List<ReportDashboardDto> getListCapacitacionDentroFueraPlazo() {
		return listCapacitacionDentroFueraPlazo;
	}

	public void setListCapacitacionDentroFueraPlazo(List<ReportDashboardDto> listCapacitacionDentroFueraPlazo) {
		this.listCapacitacionDentroFueraPlazo = listCapacitacionDentroFueraPlazo;
	}

	public List<ReportDashboardDto> getListAsistenciaSADentroFueraPlazo() {
		return listAsistenciaSADentroFueraPlazo;
	}

	public void setListAsistenciaSADentroFueraPlazo(List<ReportDashboardDto> listAsistenciaSADentroFueraPlazo) {
		this.listAsistenciaSADentroFueraPlazo = listAsistenciaSADentroFueraPlazo;
	}

	public List<ReportDashboardDto> getListConsultaSADentroFueraPlazo() {
		return listConsultaSADentroFueraPlazo;
	}

	public void setListConsultaSADentroFueraPlazo(List<ReportDashboardDto> listConsultaSADentroFueraPlazo) {
		this.listConsultaSADentroFueraPlazo = listConsultaSADentroFueraPlazo;
	}

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
		this.listReporteAsistenciaTecnicaSegunTematica = new ArrayList<>();
		this.listReporteAsistenciaTecnicaModalidad = new ArrayList<>();
		this.lisConsultaEvolMensual = new ArrayList<>();	
		this.listConsultaSegunTematica = new ArrayList<>();
		this.listConsultaModalidad = new ArrayList<>();
		this.listAsistenciaDentroFueraPlazo = new ArrayList<>();
		this.listConsultaDentroFueraPlazo = new ArrayList<>();
		this.listCapacitacionDentroFueraPlazo = new ArrayList<>();
		this.listAsistenciaSADentroFueraPlazo = new ArrayList<>();
		this.listConsultaSADentroFueraPlazo = new ArrayList<>();
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
	public List<ReportDashboardDto> getListCapacitacionEvolMensual() {
		return listCapacitacionEvolMensual;
	}

	public void setListCapacitacionEvolMensual(List<ReportDashboardDto> listCapacitacionEvolMensual) {
		this.listCapacitacionEvolMensual = listCapacitacionEvolMensual;
	}

	public List<ReportDashboardDto> getListCapacitacionUsSegunTematica() {
		return listCapacitacionUsSegunTematica;
	}

	public void setListCapacitacionUsSegunTematica(List<ReportDashboardDto> listCapacitacionUsSegunTematica) {
		this.listCapacitacionUsSegunTematica = listCapacitacionUsSegunTematica;
	}

	public List<ReportDashboardDto> getListCapacitacionModalidad() {
		return listCapacitacionModalidad;
	}

	public void setListCapacitacionModalidad(List<ReportDashboardDto> listCapacitacionModalidad) {
		this.listCapacitacionModalidad = listCapacitacionModalidad;
	}

	public List<ReportDashboardDto> getListReunionTrabajoEvolMensual() {
		return listReunionTrabajoEvolMensual;
	}

	public void setListReunionTrabajoEvolMensual(List<ReportDashboardDto> listReunionTrabajoEvolMensual) {
		this.listReunionTrabajoEvolMensual = listReunionTrabajoEvolMensual;
	}

	public List<ReportDashboardDto> getListReunionTrabajoUsSegunTematica() {
		return listReunionTrabajoUsSegunTematica;
	}

	public void setListReunionTrabajoUsSegunTematica(List<ReportDashboardDto> listReunionTrabajoUsSegunTematica) {
		this.listReunionTrabajoUsSegunTematica = listReunionTrabajoUsSegunTematica;
	}

	public List<ReportDashboardDto> getListReporteAsistenciaTecnicaEvolMensual() {
		return listReporteAsistenciaTecnicaEvolMensual;
	}

	public void setListReporteAsistenciaTecnicaEvolMensual(List<ReportDashboardDto> listReporteAsistenciaTecnicaEvolMensual) {
		this.listReporteAsistenciaTecnicaEvolMensual = listReporteAsistenciaTecnicaEvolMensual;
	}

}
