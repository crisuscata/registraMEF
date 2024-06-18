package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsIndicadorFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3810614848549407143L;
	private String descripcion = null;
	private String idObjetvo = null;
	private String idNivlstrat = null;
	private String idFactor = null;
	private String idFuenteinfor = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsIndicadorFiltro(String descripcion,String idObjetvo,String idNivlstrat,String idFactor,String idFuenteinfor,String fechaModif,String estadoTxt,Integer estado) {
                this.descripcion = descripcion;
		this.idObjetvo = idObjetvo;
		this.idNivlstrat = idNivlstrat;
		this.idFactor = idFactor;
		this.idFuenteinfor = idFuenteinfor;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdObjetvo() {
		return this.idObjetvo;
	}
	public void setIdObjetvo(String idObjetvo) {
		this.idObjetvo = idObjetvo;
	}
	public String getIdNivlstrat() {
		return this.idNivlstrat;
	}
	public void setIdNivlstrat(String idNivlstrat) {
		this.idNivlstrat = idNivlstrat;
	}
	public String getIdFactor() {
		return this.idFactor;
	}
	public void setIdFactor(String idFactor) {
		this.idFactor = idFactor;
	}
	public String getIdFuenteinfor() {
		return this.idFuenteinfor;
	}
	public void setIdFuenteinfor(String idFuenteinfor) {
		this.idFuenteinfor = idFuenteinfor;
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
		if(idObjetvo!=null && idObjetvo.trim().length()>0) return true;
		if(idNivlstrat!=null && idNivlstrat.trim().length()>0) return true;
		if(idFactor!=null && idFactor.trim().length()>0) return true;
		if(idFuenteinfor!=null && idFuenteinfor.trim().length()>0) return true;
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
