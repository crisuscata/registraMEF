package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.ctlracceso.MsUsuariosACL;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_USUARIOS BAKING: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA
 * "USUARIOS INTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48 / Creación de la clase
 *          /
 * 
 */
public class MsUsuariosBk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 716642846049185965L;

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
	private Timestamp fechaModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaInic = null;
	private Timestamp fechaCese = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private String direccion = null;
	private String username = null;
	private Long estado = null;
	private Long idCargo = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private Long idSistAdmi = null;
	private Long idSede = null;
	private Long idCondlabr = null;
	private String rtmaddress = null;
	private String rtmaddressmodif = null;

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

	private MsUsuariosACL msUsuariosACL = null;

	///
	private String contraseniaConfir = null;
	private List<String> rolesSistema = null;
	private List<String> rolesSistemaDes = null;

	private List<String> perfilesSistema = null;

	public MsUsuariosBk() {
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

	public Timestamp getFechaModif() {
		return this.fechaModif;
	}

	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}

	public Timestamp getFechaCrea() {
		return this.fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
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

	public Long getIduserCrea() {
		return this.iduserCrea;
	}

	public void setIduserCrea(Long iduserCrea) {
		this.iduserCrea = iduserCrea;
	}

	public Long getIduserModif() {
		return this.iduserModif;
	}

	public void setIduserModif(Long iduserModif) {
		this.iduserModif = iduserModif;
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

	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
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

	public String getRtmaddress() {
		return this.rtmaddress;
	}

	public void setRtmaddress(String rtmaddress) {
		this.rtmaddress = rtmaddress;
	}

	public String getRtmaddressmodif() {
		return this.rtmaddressmodif;
	}

	public void setRtmaddressmodif(String rtmaddressmodif) {
		this.rtmaddressmodif = rtmaddressmodif;
	}

	public String getEstadoTxt() {
		if (estadoTxt==null && estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			estadoTxt="Activo";
		} else {
			if (estadoTxt==null && estado != null) 
			     estadoTxt="Eliminado";
		}
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

	public MsUsuariosACL getMsUsuariosACL() {
		return msUsuariosACL;
	}

	public void setMsUsuariosACL(MsUsuariosACL msUsuariosACL) {
		this.msUsuariosACL = msUsuariosACL;
	}

	public String getCclase() {
		if (estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			return "cverde";
		} else {

		}
		return "camarillo";
	}

	public void setCclase(String cclase) {
	}

	public String getCestado() {
		if (estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			return "Activo";
		} else {
		}
		return "Eliminado";
	}

	public void setCestado(String cestado) {
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

	public List<String> getRolesSistemaDes() {
		return rolesSistemaDes;
	}

	public void setRolesSistemaDes(List<String> rolesSistemaDes) {
		this.rolesSistemaDes = rolesSistemaDes;
	}

	public List<String> getPerfilesSistema() {
		return perfilesSistema;
	}

	public void setPerfilesSistema(List<String> perfilesSistema) {
		this.perfilesSistema = perfilesSistema;
	}

	public boolean getEsEliminado() {
		boolean retorno = false;
		if (estado != null && estado.longValue() == Estado.ELIMINADO.getValor()) {
			retorno = true;
		} 
		return retorno;
	}

	public void setEsEliminado(boolean esEliminado) {		
	}
	
	public String getRoles() {
		StringBuffer s = new StringBuffer();
		if (rolesSistemaDes != null) {
			for (String rol : rolesSistemaDes) {
				s.append(rol + " \n");
			}
		}
		return s.toString();
	}
	
	public void setRoles(String roles) {}
	
	public String getNombreCompleto() {
		return ((getNombres() == null ? "" : (getNombres() + " "))
				+ (getApellidoPaterno() == null ? "" : (getApellidoPaterno() + " "))
				+ (getApellidoMaterno() == null ? "" : (getApellidoMaterno() + " "))).trim().toUpperCase();
	}
	
	public void setNombreCompleto(String nombreCompleto) {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idusuario == null) ? 0 : idusuario.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MsUsuariosBk other = (MsUsuariosBk) obj;
		if (idusuario == null) {
			if (other.idusuario != null)
				return false;
		} else if (!idusuario.equals(other.idusuario))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public String getPerfil(){
		StringBuffer s = new StringBuffer();
		if (perfilesSistema != null) {
			for (String rol : perfilesSistema) {
				s.append(rol + " \n");
			}
		}
		return s.toString();
	}
	
	public void setPerfil(){} 
	
	
}
