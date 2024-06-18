package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsPaisesFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2562202630042826529L;
	private String paisNombre = null;
	private String acronimo = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsPaisesFiltro(String paisNombre,String acronimo,String estadoTxt,Integer estado) {
                this.paisNombre = paisNombre;
		this.acronimo = acronimo;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getPaisNombre() {
		return this.paisNombre;
	}
	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}
	public String getAcronimo() {
		return this.acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	

	public boolean isActivo() {
		if(paisNombre!=null && paisNombre.trim().length()>0) return true;
		if(acronimo!=null && acronimo.trim().length()>0) return true;
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
