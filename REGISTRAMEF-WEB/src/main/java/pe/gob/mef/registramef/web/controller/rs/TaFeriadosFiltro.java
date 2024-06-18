package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class TaFeriadosFiltro implements Serializable{

	private String feDesc = null;
	private String feFchmod = null;
	private String feFchcrear = null;
	private String feEstado = null;
	
	private Integer estado = null;		
	
	public TaFeriadosFiltro(String feDesc,String feFchmod,String feFchcrear,String feEstado,Integer estado) {
                this.feDesc = feDesc;
		this.feFchmod = feFchmod;
		this.feFchcrear = feFchcrear;
		this.feEstado = feEstado;
		
		this.estado = estado;		
	}

	public String getFeDesc() {
		return this.feDesc;
	}
	public void setFeDesc(String feDesc) {
		this.feDesc = feDesc;
	}
	public String getFeFchmod() {
		return this.feFchmod;
	}
	public void setFeFchmod(String feFchmod) {
		this.feFchmod = feFchmod;
	}
	public String getFeFchcrear() {
		return this.feFchcrear;
	}
	public void setFeFchcrear(String feFchcrear) {
		this.feFchcrear = feFchcrear;
	}
	public String getFeEstado() {
		return this.feEstado;
	}
	public void setFeEstado(String feEstado) {
		this.feEstado = feEstado;
	}
	

	public boolean isActivo() {
		if(feDesc!=null && feDesc.trim().length()>0) return true;
		if(feFchmod!=null && feFchmod.trim().length()>0) return true;
		if(feFchcrear!=null && feFchcrear.trim().length()>0) return true;
		if(feEstado!=null && feEstado.trim().length()>0) return true;
		
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
