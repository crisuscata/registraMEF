package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

public class MsUsuariosFiltro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1574305248833485668L;
	private String idusuario = null;
	private String dni = null;
	private String username = null;
	private String apellidoPaterno = null;
	private String apellidoMaterno = null;
	private String nombres = null;
	private String correo = null;
	private String idSistAdmi = null;
	private String idSede = null;
	private String fechaModif = null;
	
	private String idSistAdmiTxt = null;
	private String idSedeTxt = null;
	private String estadoTxt = null;
	private String roles = null;
	
	private Integer estado = null;		
	
	public MsUsuariosFiltro(String idusuario,String dni,String username,String apellidoPaterno,String apellidoMaterno,
			String nombres,String correo,String idSistAdmi,String idSede,String fechaModif,
			String idSistAdmiTxt, String idSedeTxt, String estadoTxt, String roles, Integer estado) {
                this.idusuario = idusuario;
		this.dni = dni;
		this.username = username;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.correo = correo;
		this.idSistAdmi = idSistAdmi;
		this.idSede = idSede;
		this.fechaModif = fechaModif;
		
		this.idSistAdmiTxt = idSistAdmiTxt;
		this.idSedeTxt = idSedeTxt;
		this.estadoTxt = estadoTxt;
		this.roles = roles;
		
		this.estado = estado;		
	}

	public String getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return this.nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCorreo() {
		return this.correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public String getFechaModif() {
		return this.fechaModif;
	}
	public void setFechaModif(String fechaModif) {
		this.fechaModif = fechaModif;
	}
	
	public boolean isActivo() {
		if(idusuario!=null && idusuario.trim().length()>0) return true;
		if(dni!=null && dni.trim().length()>0) return true;
		if(username!=null && username.trim().length()>0) return true;
		if(apellidoPaterno!=null && apellidoPaterno.trim().length()>0) return true;
		if(apellidoMaterno!=null && apellidoMaterno.trim().length()>0) return true;
		if(nombres!=null && nombres.trim().length()>0) return true;
		if(correo!=null && correo.trim().length()>0) return true;
		if(idSistAdmi!=null && idSistAdmi.trim().length()>0) return true;
		if(idSede!=null && idSede.trim().length()>0) return true;
		if(fechaModif!=null && fechaModif.trim().length()>0) return true;
		
		if(idSistAdmiTxt!=null && idSistAdmiTxt.trim().length()>0) return true;
		if(idSedeTxt!=null && idSedeTxt.trim().length()>0) return true;
		if(estadoTxt!=null && estadoTxt.trim().length()>0) return true;
		if(roles!=null && roles.trim().length()>0) return true;
		
		if(estado!=null && estado.intValue()>-1) return true;
		return false;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdSistAdmiTxt() {
		return idSistAdmiTxt;
	}

	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}

	public String getIdSedeTxt() {
		return idSedeTxt;
	}

	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}

	public String getEstadoTxt() {
		return estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
