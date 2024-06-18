package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class DtConsultasFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5387146399730913970L;
	private String fechaConsu = null;
	private String idUsuexterno = null;
	private String idSistAdm = null;
	private String idTema = null;
	private String idSubtema = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public DtConsultasFiltro(String fechaConsu,String idUsuexterno,String idSistAdm,String idTema,String idSubtema,String estadoTxt,Integer estado) {
                this.fechaConsu = fechaConsu;
		this.idUsuexterno = idUsuexterno;
		this.idSistAdm = idSistAdm;
		this.idTema = idTema;
		this.idSubtema = idSubtema;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getFechaConsu() {
		return this.fechaConsu;
	}
	public void setFechaConsu(String fechaConsu) {
		this.fechaConsu = fechaConsu;
	}
	public String getIdUsuexterno() {
		return this.idUsuexterno;
	}
	public void setIdUsuexterno(String idUsuexterno) {
		this.idUsuexterno = idUsuexterno;
	}
	public String getIdSistAdm() {
		return this.idSistAdm;
	}
	public void setIdSistAdm(String idSistAdm) {
		this.idSistAdm = idSistAdm;
	}
	public String getIdTema() {
		return this.idTema;
	}
	public void setIdTema(String idTema) {
		this.idTema = idTema;
	}
	public String getIdSubtema() {
		return this.idSubtema;
	}
	public void setIdSubtema(String idSubtema) {
		this.idSubtema = idSubtema;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	

	public boolean isActivo() {
		if(fechaConsu!=null && fechaConsu.trim().length()>0) return true;
		if(idUsuexterno!=null && idUsuexterno.trim().length()>0) return true;
		if(idSistAdm!=null && idSistAdm.trim().length()>0) return true;
		if(idTema!=null && idTema.trim().length()>0) return true;
		if(idSubtema!=null && idSubtema.trim().length()>0) return true;
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
