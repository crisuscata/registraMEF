package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class DtEntidadesFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508562677615556881L;
	private String codEjec = null;
	private String razSocial = null;
	private String ruc = null;
	private String idTipo = null;
	private String codDpto = null;
	private String codProv = null;
	private String codDistr = null;
	private String idCaract = null;
	private String idSistAdmi = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public DtEntidadesFiltro(String codEjec,String razSocial,String ruc,String idTipo,String codDpto,String codProv,String codDistr,String idCaract,String idSistAdmi,String estadoTxt,Integer estado) {
                this.codEjec = codEjec;
		this.razSocial = razSocial;
		this.ruc = ruc;
		this.idTipo = idTipo;
		this.codDpto = codDpto;
		this.codProv = codProv;
		this.codDistr = codDistr;
		this.idCaract = idCaract;
		this.idSistAdmi = idSistAdmi;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getCodEjec() {
		return this.codEjec;
	}
	public void setCodEjec(String codEjec) {
		this.codEjec = codEjec;
	}
	public String getRazSocial() {
		return this.razSocial;
	}
	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}
	public String getRuc() {
		return this.ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
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
	public String getIdCaract() {
		return this.idCaract;
	}
	public void setIdCaract(String idCaract) {
		this.idCaract = idCaract;
	}
	public String getIdSistAdmi() {
		return this.idSistAdmi;
	}
	public void setIdSistAdmi(String idSistAdmi) {
		this.idSistAdmi = idSistAdmi;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	

	public boolean isActivo() {
		if(codEjec!=null && codEjec.trim().length()>0) return true;
		if(razSocial!=null && razSocial.trim().length()>0) return true;
		if(ruc!=null && ruc.trim().length()>0) return true;
		if(idTipo!=null && idTipo.trim().length()>0) return true;
		if(codDpto!=null && codDpto.trim().length()>0) return true;
		if(codProv!=null && codProv.trim().length()>0) return true;
		if(codDistr!=null && codDistr.trim().length()>0) return true;
		if(idCaract!=null && idCaract.trim().length()>0) return true;
		if(idSistAdmi!=null && idSistAdmi.trim().length()>0) return true;
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
