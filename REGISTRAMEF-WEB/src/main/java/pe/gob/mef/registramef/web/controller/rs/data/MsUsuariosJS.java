package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37  / Creación de la clase /
 * 
 */
@XmlRootElement
public class MsUsuariosJS implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3346274853432288370L;

	// ID
	private Long idusuario;

	// PROPIEDADES
	private Long dni = null;
	private String nombres = null;
	private String apellidoPaterno = null;
	private String apellidoMaterno = null;
	private String contrasenia = null;
	private String profesion = null;
	private String correo = null;
	private Long telefono = null;
	private Timestamp fechaInic = null;
	private Timestamp fechaCese = null;
	private String direccion = null;
	private String username = null;
	private Long idCargo = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private Long idSistAdmi = null;
	private Long idSede = null;
	private Long idCondlabr = null;
	
	
	// ADICIONALES
	private String estadoTxt = null;
	private String idCargoTxt = null;
	private String codDptoTxt = null;
	private String codProvTxt = null;
	private String codDistrTxt = null;
	private String idpaisTxt = null;
	private String idSistAdmiTxt = null;
	private String idSedeTxt = null;
	private String idCondlabrTxt = null;
	
	private String contraseniaConfir = null;
	private List<String> rolesSistema = null;
	private List<String> perfilesSistema = null;
	private String nombreCompleto = null;
	private Boolean noEsEliminado = true;
	private Integer editopcion = 1;

	public MsUsuariosJS() {
	}

	public Long getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	
	public Long getDni() {
						return this.dni;
					}

	public void setDni(Long dni) {
						this.dni = dni;
					}
	public String getNombres() {
						return this.nombres;
					}

	public void setNombres(String nombres) {
						this.nombres = nombres;
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
	public String getContrasenia() {
						return this.contrasenia;
					}

	public void setContrasenia(String contrasenia) {
						this.contrasenia = contrasenia;
					}
	public String getProfesion() {
						return this.profesion;
					}

	public void setProfesion(String profesion) {
						this.profesion = profesion;
					}
	public String getCorreo() {
						return this.correo;
					}

	public void setCorreo(String correo) {
						this.correo = correo;
					}
	public Long getTelefono() {
						return this.telefono;
					}

	public void setTelefono(Long telefono) {
						this.telefono = telefono;
					}
	public Timestamp getFechaInic() {
		return this.fechaInic;
	}
	public void setFechaInic(Timestamp fechaInic) {
		this.fechaInic = fechaInic;
	}
	public java.util.Date getFechaInicJUD() {
		java.util.Date fechaInicJUD = null;
		if (fechaInic != null)
			fechaInicJUD = new java.util.Date(fechaInic.getTime());
		return fechaInicJUD;
	}
	public void setFechaInicJUD(java.util.Date fechaInicJUD) {
		if (fechaInicJUD != null)
			this.fechaInic = new Timestamp(fechaInicJUD.getTime());
		else
			this.fechaInic = null;
	}	
	public Timestamp getFechaCese() {
		return this.fechaCese;
	}
	public void setFechaCese(Timestamp fechaCese) {
		this.fechaCese = fechaCese;
	}
	public java.util.Date getFechaCeseJUD() {
		java.util.Date fechaCeseJUD = null;
		if (fechaCese != null)
			fechaCeseJUD = new java.util.Date(fechaCese.getTime());
		return fechaCeseJUD;
	}
	public void setFechaCeseJUD(java.util.Date fechaCeseJUD) {
		if (fechaCeseJUD != null)
			this.fechaCese = new Timestamp(fechaCeseJUD.getTime());
		else
			this.fechaCese = null;
	}	
	public String getDireccion() {
						return this.direccion;
					}

	public void setDireccion(String direccion) {
						this.direccion = direccion;
					}
	public String getUsername() {
						return this.username;
					}

	public void setUsername(String username) {
						this.username = username;
					}
	public Long getIdCargo() {
						return this.idCargo;
					}

	public void setIdCargo(Long idCargo) {
						this.idCargo = idCargo;
					}
	public Integer getCodDpto() {
						return this.codDpto;
					}

	public void setCodDpto(Integer codDpto) {
						this.codDpto = codDpto;
					}
	public Integer getCodProv() {
						return this.codProv;
					}

	public void setCodProv(Integer codProv) {
						this.codProv = codProv;
					}
	public Integer getCodDistr() {
						return this.codDistr;
					}

	public void setCodDistr(Integer codDistr) {
						this.codDistr = codDistr;
					}
	public Long getIdpais() {
						return this.idpais;
					}

	public void setIdpais(Long idpais) {
						this.idpais = idpais;
					}
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	public Long getIdCondlabr() {
						return this.idCondlabr;
					}

	public void setIdCondlabr(Long idCondlabr) {
						this.idCondlabr = idCondlabr;
					}
	
	
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdCargoTxt() {
		return this.idCargoTxt;
	}
	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
	}
	public String getCodDptoTxt() {
		return this.codDptoTxt;
	}
	public void setCodDptoTxt(String codDptoTxt) {
		this.codDptoTxt = codDptoTxt;
	}
	public String getCodProvTxt() {
		return this.codProvTxt;
	}
	public void setCodProvTxt(String codProvTxt) {
		this.codProvTxt = codProvTxt;
	}
	public String getCodDistrTxt() {
		return this.codDistrTxt;
	}
	public void setCodDistrTxt(String codDistrTxt) {
		this.codDistrTxt = codDistrTxt;
	}
	public String getIdpaisTxt() {
		return this.idpaisTxt;
	}
	public void setIdpaisTxt(String idpaisTxt) {
		this.idpaisTxt = idpaisTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdCondlabrTxt() {
		return this.idCondlabrTxt;
	}
	public void setIdCondlabrTxt(String idCondlabrTxt) {
		this.idCondlabrTxt = idCondlabrTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}

	public String getContraseniaConfir() {
		return contraseniaConfir;
	}

	public void setContraseniaConfir(String contraseniaConfir) {
		this.contraseniaConfir = contraseniaConfir;
	}

	public List<String> getRolesSistema() {
		return rolesSistema;
	}

	public void setRolesSistema(List<String> rolesSistema) {
		this.rolesSistema = rolesSistema;
	}

	public List<String> getPerfilesSistema() {
		return perfilesSistema;
	}

	public void setPerfilesSistema(List<String> perfilesSistema) {
		this.perfilesSistema = perfilesSistema;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Boolean getNoEsEliminado() {
		return noEsEliminado;
	}

	public void setNoEsEliminado(Boolean noEsEliminado) {
		this.noEsEliminado = noEsEliminado;
	}
}
