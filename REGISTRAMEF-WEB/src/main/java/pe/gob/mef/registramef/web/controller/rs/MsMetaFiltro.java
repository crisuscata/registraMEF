package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsMetaFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3763817557785508524L;
	private String annio = null;
	private String idTipoServicio = null;
	private String idSistAdmi = null;
	private String idSede = null;
	private String valor = null;
	private String fechaCrea = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsMetaFiltro(String annio,String idTipoServicio,String idSistAdmi,String idSede,String valor,String fechaCrea,String fechaModif,String estadoTxt,Integer estado) {
                this.annio = annio;
		this.idTipoServicio = idTipoServicio;
		this.idSistAdmi = idSistAdmi;
		this.idSede = idSede;
		this.valor = valor;
		this.fechaCrea = fechaCrea;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getAnnio() {
		return this.annio;
	}
	public void setAnnio(String annio) {
		this.annio = annio;
	}
	public String getIdTipoServicio() {
		return this.idTipoServicio;
	}
	public void setIdTipoServicio(String idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}
	public String getIdSistAdmi() {
		return this.idSistAdmi;
	}
	public void setIdSistAdmi(String idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}
	public String getIdSede() {
		return this.idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getValor() {
		return this.valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
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
		if(annio!=null && annio.trim().length()>0) return true;
		if(idTipoServicio!=null && idTipoServicio.trim().length()>0) return true;
		if(idSistAdmi!=null && idSistAdmi.trim().length()>0) return true;
		if(idSede!=null && idSede.trim().length()>0) return true;
		if(valor!=null && valor.trim().length()>0) return true;
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
