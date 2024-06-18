package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class DtEncuestaFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1492354048421775284L;
	private String tipoServicio = null;
	private String fechaInicio = null;
	private String fechaFin = null;
	private String idOrigen = null;
	private String idPrestacion = null;
	
	private Integer estado = null;		
	
	public DtEncuestaFiltro(String tipoServicio,String fechaInicio,String fechaFin,String idOrigen,String idPrestacion,Integer estado) {
                this.tipoServicio = tipoServicio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idOrigen = idOrigen;
		this.idPrestacion = idPrestacion;
		
		this.estado = estado;		
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getIdOrigen() {
		return this.idOrigen;
	}
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}
	public String getIdPrestacion() {
		return this.idPrestacion;
	}
	public void setIdPrestacion(String idPrestacion) {
		this.idPrestacion = idPrestacion;
	}
	

	public boolean isActivo() {
		if(tipoServicio!=null && tipoServicio.trim().length()>0) return true;
		if(fechaInicio!=null && fechaInicio.trim().length()>0) return true;
		if(fechaFin!=null && fechaFin.trim().length()>0) return true;
		if(idOrigen!=null && idOrigen.trim().length()>0) return true;
		if(idPrestacion!=null && idPrestacion.trim().length()>0) return true;
		
		if(estado!=null && estado.intValue()>-1) return true;
		return false;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
