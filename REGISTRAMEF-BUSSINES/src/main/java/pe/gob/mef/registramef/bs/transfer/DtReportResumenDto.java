package pe.gob.mef.registramef.bs.transfer;

import java.util.ArrayList;
import java.util.List;

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
	private List<ReporteConsulta> listConsulta;
	private List<ReporteVisitaDetalle> listVisita;
	
	public DtReportResumenDto() {
		this.listAsistencia = new ArrayList<>();
		this.listCapacitacion = new ArrayList<>();
		this.listConsulta = new ArrayList<>();
		this.listVisita = new ArrayList<>();
		this.listCapacitacionEvolMensual = new ArrayList<>();
		this.listCapacitacionUsSegunTematica = new ArrayList<>();
		this.listCapacitacionModalidad = new ArrayList<>();
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
	public List<ReporteConsulta> getListConsulta() {
		return listConsulta;
	}
	public void setListConsulta(List<ReporteConsulta> listConsulta) {
		this.listConsulta = listConsulta;
	}
	public List<ReporteVisitaDetalle> getListVisita() {
		return listVisita;
	}
	public void setListVisita(List<ReporteVisitaDetalle> listVisita) {
		this.listVisita = listVisita;
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
}
