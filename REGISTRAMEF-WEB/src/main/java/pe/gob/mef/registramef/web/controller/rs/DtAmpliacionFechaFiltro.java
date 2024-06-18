package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class DtAmpliacionFechaFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8270664223339790286L;
	private String tipoFechaCorte = null;
	private String idSede = null;
	private String idSistAdmi = null;
	private String fechaInicio = null;
	private String fechaFin = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public DtAmpliacionFechaFiltro(String tipoFechaCorte,String idSede,String idSistAdmi,String fechaInicio,String fechaFin,String fechaModif,String estadoTxt,Integer estado) {
                this.tipoFechaCorte = tipoFechaCorte;
		this.idSede = idSede;
		this.idSistAdmi = idSistAdmi;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getTipoFechaCorte() {
		return this.tipoFechaCorte;
	}
	public void setTipoFechaCorte(String tipoFechaCorte) {
		this.tipoFechaCorte = tipoFechaCorte;
	}
	public String getIdSede() {
		return this.idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdSistAdmi() {
		return this.idSistAdmi;
	}
	public void setIdSistAdmi(String idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
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
	public String getFechaModif() {
		return this.fechaModif;
	}
	public void setFechaModif(String fechaModif) {
		this.fechaModif = fechaModif;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	

	public boolean isActivo() {
		if(tipoFechaCorte!=null && tipoFechaCorte.trim().length()>0) return true;
		if(idSede!=null && idSede.trim().length()>0) return true;
		if(idSistAdmi!=null && idSistAdmi.trim().length()>0) return true;
		if(fechaInicio!=null && fechaInicio.trim().length()>0) return true;
		if(fechaFin!=null && fechaFin.trim().length()>0) return true;
		if(fechaModif!=null && fechaModif.trim().length()>0) return true;
		if(estadoTxt!=null && estadoTxt.trim().length()>0) return true;
		
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
