package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsUbigeoFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4205982837798205894L;
	private String idTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String fechaCrea = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsUbigeoFiltro(String idTxt, String codDptoTxt,String codProvTxt,String codDistrTxt,String fechaCrea,String fechaModif,String estadoTxt,Integer estado) {
        this.idTxt = idTxt;        
		this.codDptoTxt = codDptoTxt;
		this.codProvTxt = codProvTxt;
		this.codDistrTxt = codDistrTxt;
		this.fechaCrea = fechaCrea;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;		
		this.estado = estado;		
	}

	public String getCodDptoTxt() {
		return this.codDptoTxt;
	}
	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}
	public String getCodProvTxt() {
		return this.codProvTxt;
	}
	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}
	public String getCodDistrTxt() {
		return this.codDistrTxt;
	}
	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
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
		
		if(idTxt!=null && idTxt.trim().length()>0) return true;
		if(codDptoTxt!=null && codDptoTxt.trim().length()>0) return true;
		if(codProvTxt!=null && codProvTxt.trim().length()>0) return true;
		if(codDistrTxt!=null && codDistrTxt.trim().length()>0) return true;
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
