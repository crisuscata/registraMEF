package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class DtUsuarioExternoFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816237017886126581L;
	private String aPaterno = null;
	private String aMaterno = null;
	private String nombre = null;
	private String numDocu = null;
	private String correo = null;
	private String telefFijo = null;
	private String telefCell = null;
	private String fechaModif = null;
	private String estadoTxt = null;
	
	private Integer estado = null;		
	
	public DtUsuarioExternoFiltro(String aPaterno,String aMaterno,String nombre,String numDocu,String correo,String telefFijo,String telefCell,String fechaModif,String estadoTxt,Integer estado) {
                this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.nombre = nombre;
		this.numDocu = numDocu;
		this.correo = correo;
		this.telefFijo = telefFijo;
		this.telefCell = telefCell;
		this.fechaModif = fechaModif;
		this.estadoTxt = estadoTxt;
		
		this.estado = estado;		
	}

	public String getAPaterno() {
		return this.aPaterno;
	}
	public void setAPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	public String getAMaterno() {
		return this.aMaterno;
	}
	public void setAMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumDocu() {
		return this.numDocu;
	}
	public void setNumDocu(String numDocu) {
		this.numDocu = numDocu;
	}
	public String getCorreo() {
		return this.correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefFijo() {
		return this.telefFijo;
	}
	public void setTelefFijo(String telefFijo) {
		this.telefFijo = telefFijo;
	}
	public String getTelefCell() {
		return this.telefCell;
	}
	public void setTelefCell(String telefCell) {
		this.telefCell = telefCell;
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
		if(aPaterno!=null && aPaterno.trim().length()>0) return true;
		if(aMaterno!=null && aMaterno.trim().length()>0) return true;
		if(nombre!=null && nombre.trim().length()>0) return true;
		if(numDocu!=null && numDocu.trim().length()>0) return true;
		if(correo!=null && correo.trim().length()>0) return true;
		if(telefFijo!=null && telefFijo.trim().length()>0) return true;
		if(telefCell!=null && telefCell.trim().length()>0) return true;
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
