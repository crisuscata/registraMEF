package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsSubtemaFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980586641927601747L;
	private String idTema = null;
	private String descripcion = null;
	private String fechaCrea = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsSubtemaFiltro(String idTema,String descripcion,String fechaCrea,String fechaModif,String estadoTxt,Integer estado) {
                this.idTema = idTema;
		this.descripcion = descripcion;
		this.fechaCrea = fechaCrea;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getIdTema() {
		return this.idTema;
	}
	public void setIdTema(String idTema) {
		this.idTema = idTema;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaCrea() {
		return this.fechaCrea;
	}
	public void setFechaCrea(String fechaCrea) {
		this.fechaCrea = fechaCrea;
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
		if(idTema!=null && idTema.trim().length()>0) return true;
		if(descripcion!=null && descripcion.trim().length()>0) return true;
		if(fechaCrea!=null && fechaCrea.trim().length()>0) return true;
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
