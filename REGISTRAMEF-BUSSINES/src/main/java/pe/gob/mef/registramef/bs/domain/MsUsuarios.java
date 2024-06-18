package pe.gob.mef.registramef.bs.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * MS_USUARIOS ENTIDAD: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS INTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_USUARIOS")
public class MsUsuarios implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9193541501286856869L;

	// ID
	private Long idusuario = null;

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
	

	public MsUsuarios() {
	}

	@SequenceGenerator(name = "G_MS_USUARIOS", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_USUARIOS_INTERNOS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_USUARIOS")
@Id
@Column(name = "IDUSUARIO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdusuario()
{
		return this.idusuario;
}

public void setIdusuario(Long idusuario)
{
		this.idusuario = idusuario;
}

@Column(name = "DNI", precision = 8, scale = 0)
public Long  getDni()
{
		return this.dni;
}

public void setDni(Long dni)
{
		this.dni = dni;
}

@Column(name = "NOMBRES", length = 100)
public String  getNombres()
{
		return this.nombres;
}

public void setNombres(String nombres)
{
		this.nombres = nombres;
}

@Column(name = "APELLIDO_PATERNO", length = 100)
public String  getApellidoPaterno()
{
		return this.apellidoPaterno;
}

public void setApellidoPaterno(String apellidoPaterno)
{
		this.apellidoPaterno = apellidoPaterno;
}

@Column(name = "APELLIDO_MATERNO", length = 100)
public String  getApellidoMaterno()
{
		return this.apellidoMaterno;
}

public void setApellidoMaterno(String apellidoMaterno)
{
		this.apellidoMaterno = apellidoMaterno;
}

@Column(name = "CONTRASENIA", length = 50)
public String  getContrasenia()
{
		return this.contrasenia;
}

public void setContrasenia(String contrasenia)
{
		this.contrasenia = contrasenia;
}

@Column(name = "PROFESION", length = 130)
public String  getProfesion()
{
		return this.profesion;
}

public void setProfesion(String profesion)
{
		this.profesion = profesion;
}

@Column(name = "CORREO", length = 30)
public String  getCorreo()
{
		return this.correo;
}

public void setCorreo(String correo)
{
		this.correo = correo;
}

@Column(name = "TELEFONO", precision = 20, scale = 0)
public Long  getTelefono()
{
		return this.telefono;
}

public void setTelefono(Long telefono)
{
		this.telefono = telefono;
}

@Column(name = "FECHA_MODIF", length = 7)
public Timestamp  getFechaModif()
{
		return this.fechaModif;
}

public void setFechaModif(Timestamp fechaModif)
{
		this.fechaModif = fechaModif;
}

@Column(name = "FECHA_CREA", length = 7)
public Timestamp  getFechaCrea()
{
		return this.fechaCrea;
}

public void setFechaCrea(Timestamp fechaCrea)
{
		this.fechaCrea = fechaCrea;
}

@Column(name = "FECHA_INIC", length = 7)
public Timestamp  getFechaInic()
{
		return this.fechaInic;
}

public void setFechaInic(Timestamp fechaInic)
{
		this.fechaInic = fechaInic;
}

@Column(name = "FECHA_CESE", length = 7)
public Timestamp  getFechaCese()
{
		return this.fechaCese;
}

public void setFechaCese(Timestamp fechaCese)
{
		this.fechaCese = fechaCese;
}

@Column(name = "IDUSER_CREA", precision = 10, scale = 0)
public Long  getIduserCrea()
{
		return this.iduserCrea;
}

public void setIduserCrea(Long iduserCrea)
{
		this.iduserCrea = iduserCrea;
}

@Column(name = "IDUSER_MODIF", precision = 10, scale = 0)
public Long  getIduserModif()
{
		return this.iduserModif;
}

public void setIduserModif(Long iduserModif)
{
		this.iduserModif = iduserModif;
}

@Column(name = "DIRECCION", length = 200)
public String  getDireccion()
{
		return this.direccion;
}

public void setDireccion(String direccion)
{
		this.direccion = direccion;
}

@Column(name = "USERNAME", unique = true, length = 50)
public String  getUsername()
{
		return this.username;
}

public void setUsername(String username)
{
		this.username = username;
}

@Column(name = "ESTADO", precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
}

@Column(name = "ID_CARGO", precision = 10, scale = 0)
public Long  getIdCargo()
{
		return this.idCargo;
}

public void setIdCargo(Long idCargo)
{
		this.idCargo = idCargo;
}

@Column(name = "COD_DPTO", precision = 2, scale = 0)
public Integer  getCodDpto()
{
		return this.codDpto;
}

public void setCodDpto(Integer codDpto)
{
		this.codDpto = codDpto;
}

@Column(name = "COD_PROV", precision = 2, scale = 0)
public Integer  getCodProv()
{
		return this.codProv;
}

public void setCodProv(Integer codProv)
{
		this.codProv = codProv;
}

@Column(name = "COD_DISTR", precision = 2, scale = 0)
public Integer  getCodDistr()
{
		return this.codDistr;
}

public void setCodDistr(Integer codDistr)
{
		this.codDistr = codDistr;
}

@Column(name = "IDPAIS", precision = 10, scale = 0)
public Long  getIdpais()
{
		return this.idpais;
}

public void setIdpais(Long idpais)
{
		this.idpais = idpais;
}

@Column(name = "ID_SIST_ADMI", precision = 10, scale = 0)
public Long  getIdSistAdmi()
{
		return this.idSistAdmi;
}

public void setIdSistAdmi(Long idSistAdmi)
{
		this.idSistAdmi = idSistAdmi;
}

@Column(name = "ID_SEDE", precision = 10, scale = 0)
public Long  getIdSede()
{
		return this.idSede;
}

public void setIdSede(Long idSede)
{
		this.idSede = idSede;
}

@Column(name = "ID_CONDLABR", precision = 10, scale = 0)
public Long  getIdCondlabr()
{
		return this.idCondlabr;
}

public void setIdCondlabr(Long idCondlabr)
{
		this.idCondlabr = idCondlabr;
}

@Column(name = "RTMADDRESS", length = 50)
public String  getRtmaddress()
{
		return this.rtmaddress;
}

public void setRtmaddress(String rtmaddress)
{
		this.rtmaddress = rtmaddress;
}

@Column(name = "RTMADDRESSMODIF", length = 50)
public String  getRtmaddressmodif()
{
		return this.rtmaddressmodif;
}

public void setRtmaddressmodif(String rtmaddressmodif)
{
		this.rtmaddressmodif = rtmaddressmodif;
}


			
}
