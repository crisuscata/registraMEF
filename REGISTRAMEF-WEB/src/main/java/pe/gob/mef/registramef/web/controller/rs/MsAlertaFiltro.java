package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsAlertaFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1059054608906355563L;
	private String idCaracterst = null;
	private String otrosDestin = null;
	private String dia = null;
	private String hora = null;
	private String fechaCrea = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public MsAlertaFiltro(String idCaracterst,String otrosDestin,String dia,String hora,String fechaCrea,String fechaModif,String estadoTxt,Integer estado) {
                this.idCaracterst = idCaracterst;
		this.otrosDestin = otrosDestin;
		this.dia = dia;
		this.hora = hora;
		this.fechaCrea = fechaCrea;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getIdCaracterst() {
		return this.idCaracterst;
	}
	public void setIdCaracterst(String idCaracterst) {
		this.idCaracterst = idCaracterst;
	}
	public String getOtrosDestin() {
		return this.otrosDestin;
	}
	public void setOtrosDestin(String otrosDestin) {
		this.otrosDestin = otrosDestin;
	}
	public String getDia() {
		return this.dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return this.hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
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
		if(idCaracterst!=null && idCaracterst.trim().length()>0) return true;
		if(otrosDestin!=null && otrosDestin.trim().length()>0) return true;
		if(dia!=null && dia.trim().length()>0) return true;
		if(hora!=null && hora.trim().length()>0) return true;
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
