package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class PrtParametrosFiltro implements Serializable{
	//PURIBE 04012024 - INICIO
	private String idpadre = null;
	private String idpadreTxt = null;
	

	private String descripcion = null;
	
	private Integer estado = null;		
	
	public PrtParametrosFiltro(String idpadre,String descripcion,Integer estado,String idpadreTxt) {
                this.idpadre = idpadre;
		this.descripcion = descripcion;
		
		this.estado = estado;		
		this.idpadreTxt=idpadreTxt;
	}
	public String getIdpadreTxt() {
		return idpadreTxt;
	}

	public void setIdpadreTxt(String idpadreTxt) {
		this.idpadreTxt = idpadreTxt;
	}
	public String getIdpadre() {
		return this.idpadre;
	}
	public void setIdpadre(String idpadre) {
		this.idpadre = idpadre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public boolean isActivo() {
		if(idpadre!=null && idpadre.trim().length()>0) return true;
		if(descripcion!=null && descripcion.trim().length()>0) return true;
		
		if(estado!=null && estado.intValue()>-1) return true;
		if(idpadreTxt!=null && idpadreTxt.trim().length()>-1) return true;
		return false;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	//PURIBE 04012024 - FIN
}
