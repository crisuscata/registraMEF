package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class PrtParametrosFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5970890726837202479L;
	private String descripcion = null;
	private String idpadre = null;
	private String fechaCrea = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	private String idpadreTxt = null;
	
	private Integer estado = null;		
	
	public PrtParametrosFiltro(String descripcion,String idpadre,String fechaCrea,String fechaModif,String estadoTxt, String idpadreTxt, Integer estado) {
                this.descripcion = descripcion;
		this.idpadre = idpadre;
		this.fechaCrea = fechaCrea;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		this.idpadreTxt = idpadreTxt;
		this.estado = estado;		
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdpadre() {
		return this.idpadre;
	}
	public void setIdpadre(String idpadre) {
		this.idpadre = idpadre;
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
		if(descripcion!=null && descripcion.trim().length()>0) return true;
		if(idpadre!=null && idpadre.trim().length()>0) return true;
		if(fechaCrea!=null && fechaCrea.trim().length()>0) return true;
		if(fechaModif!=null && fechaModif.trim().length()>0) return true;
		if(estadoTxt!=null && estadoTxt.trim().length()>0) return true;
		if(idpadreTxt!=null && idpadreTxt.trim().length()>0) return true;
		
		if(estado!=null && estado.intValue()>-1) return true;
		return false;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdpadreTxt() {
		return idpadreTxt;
	}

	public void setIdpadreTxt(String idpadreTxt) {
		this.idpadreTxt = idpadreTxt;
	}
}
