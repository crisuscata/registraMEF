package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsSedesFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1652126929327637994L;
	private String sede = null;
	private String idGrupo = null;
	private String idMacregion = null;
	private String sigla = null;
	private String codDpto = null;
	private String direccion = null;
	private String orden = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsSedesFiltro(String sede,String idGrupo,String idMacregion,String sigla,String codDpto,String direccion,String orden,String fechaModif,String estadoTxt,Integer estado) {
                this.sede = sede;
		this.idGrupo = idGrupo;
		this.idMacregion = idMacregion;
		this.sigla = sigla;
		this.codDpto = codDpto;
		this.direccion = direccion;
		this.orden = orden;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getSede() {
		return this.sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getIdGrupo() {
		return this.idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getIdMacregion() {
		return this.idMacregion;
	}
	public void setIdMacregion(String idMacregion) {
		this.idMacregion = idMacregion;
	}
	public String getSigla() {
		return this.sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getCodDpto() {
		return this.codDpto;
	}
	public void setCodDpto(String codDpto) {
		this.codDpto = codDpto;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getOrden() {
		return this.orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
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
		if(sede!=null && sede.trim().length()>0) return true;
		if(idGrupo!=null && idGrupo.trim().length()>0) return true;
		if(idMacregion!=null && idMacregion.trim().length()>0) return true;
		if(sigla!=null && sigla.trim().length()>0) return true;
		if(codDpto!=null && codDpto.trim().length()>0) return true;
		if(direccion!=null && direccion.trim().length()>0) return true;
		if(orden!=null && orden.trim().length()>0) return true;
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
