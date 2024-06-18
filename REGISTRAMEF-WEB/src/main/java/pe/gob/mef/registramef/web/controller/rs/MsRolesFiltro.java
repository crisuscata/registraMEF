package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsRolesFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 55526950135808285L;
	private String username = null;
	private String rol = null;
	
	private Integer estado = null;		
	
	public MsRolesFiltro(String username,String rol,Integer estado) {
                this.username = username;
		this.rol = rol;
		
		this.estado = estado;		
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRol() {
		return this.rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	

	public boolean isActivo() {
		if(username!=null && username.trim().length()>0) return true;
		if(rol!=null && rol.trim().length()>0) return true;
		
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
