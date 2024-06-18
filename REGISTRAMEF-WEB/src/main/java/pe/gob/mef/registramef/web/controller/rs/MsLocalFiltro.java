package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsLocalFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2422564707890729249L;
	private String descripcion = null;
	private String direccion = null;
	private String referencia = null;
	private String codDpto = null;
	private String codProv = null;
	private String codDistr = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsLocalFiltro(String descripcion,String direccion,String referencia,String codDpto,String codProv,String codDistr,String fechaModif,String estadoTxt,Integer estado) {
                this.descripcion = descripcion;
		this.direccion = direccion;
		this.referencia = referencia;
		this.codDpto = codDpto;
		this.codProv = codProv;
		this.codDistr = codDistr;
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
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getReferencia() {
		return this.referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getCodDpto() {
		return this.codDpto;
	}
	public void setCodDpto(String codDpto) {
		this.codDpto = codDpto;
	}
	public String getCodProv() {
		return this.codProv;
	}
	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}
	public String getCodDistr() {
		return this.codDistr;
	}
	public void setCodDistr(String codDistr) {
		this.codDistr = codDistr;
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
		if(direccion!=null && direccion.trim().length()>0) return true;
		if(referencia!=null && referencia.trim().length()>0) return true;
		if(codDpto!=null && codDpto.trim().length()>0) return true;
		if(codProv!=null && codProv.trim().length()>0) return true;
		if(codDistr!=null && codDistr.trim().length()>0) return true;
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
