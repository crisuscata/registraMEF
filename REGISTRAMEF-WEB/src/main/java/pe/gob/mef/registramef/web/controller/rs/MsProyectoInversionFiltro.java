package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsProyectoInversionFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1864187379739400975L;
	private String codigo = null;
	private String nombre = null;
	private String idSede = null;
	
	private Integer estado = null;		
	
	public MsProyectoInversionFiltro(String codigo,String nombre,String idSede,Integer estado) {
                this.codigo = codigo;
		this.nombre = nombre;
		this.idSede = idSede;
		
		this.estado = estado;		
	}

	public String getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdSede() {
		return this.idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	

	public boolean isActivo() {
		if(codigo!=null && codigo.trim().length()>0) return true;
		if(nombre!=null && nombre.trim().length()>0) return true;
		if(idSede!=null && idSede.trim().length()>0) return true;
		
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
