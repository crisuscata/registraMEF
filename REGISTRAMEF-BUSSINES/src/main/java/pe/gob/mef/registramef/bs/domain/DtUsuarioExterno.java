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
 * DT_USUARIO_EXTERNO ENTIDAD: ALMACENA A LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS EXTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_USUARIO_EXTERNO")
public class DtUsuarioExterno implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2498354359620738874L;

	// ID
	private Long idUsuexterno = null;

	// PROPIEDADES
	private String nombre = null;
	private String apaterno = null; 	// JPUYEN 14052024 
	private String amaterno = null;    // JPUYEN 14052024  
	private String direccion = null;
	private String correo = null;
	private Long telefFijo = null;
	private Long telefCell = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long numDocu = null;
	private String sexo = null;
	private Long estado = null;
	private Long idTipodocumento = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idpais = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private String otroTelefono = null;
	private String otroCelular = null;
	private String numDocum = null;
	private Long flagMedioreg = null;
	

	public DtUsuarioExterno() {
	}

	@SequenceGenerator(name = "G_DT_USUARIO_EXTERNO", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_USUARIO_EXTERNO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_USUARIO_EXTERNO")
@Id
@Column(name = "ID_USUEXTERNO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdUsuexterno()
{
		return this.idUsuexterno;
}

public void setIdUsuexterno(Long idUsuexterno)
{
		this.idUsuexterno = idUsuexterno;
}

@Column(name = "NOMBRE", length = 100)
public String  getNombre()
{
		return this.nombre;
}

public void setNombre(String nombre)
{
		this.nombre = nombre;
}

@Column(name = "A_PATERNO", length = 100)
public String  getApaterno()
{
		return this.apaterno;
}

public void setApaterno(String apaterno)
{
		this.apaterno = apaterno;
}

@Column(name = "A_MATERNO", length = 100)
public String  getAmaterno()
{
		return this.amaterno;
}

public void setAmaterno(String amaterno)
{
		this.amaterno = amaterno;
}

@Column(name = "DIRECCION", length = 300)
public String  getDireccion()
{
		return this.direccion;
}

public void setDireccion(String direccion)
{
		this.direccion = direccion;
}

@Column(name = "CORREO", length = 50)
public String  getCorreo()
{
		return this.correo;
}

public void setCorreo(String correo)
{
		this.correo = correo;
}

@Column(name = "TELEF_FIJO", precision = 20, scale = 0)
public Long  getTelefFijo()
{
		return this.telefFijo;
}

public void setTelefFijo(Long telefFijo)
{
		this.telefFijo = telefFijo;
}

@Column(name = "TELEF_CELL", precision = 20, scale = 0)
public Long  getTelefCell()
{
		return this.telefCell;
}

public void setTelefCell(Long telefCell)
{
		this.telefCell = telefCell;
}

@Column(name = "IDUSSER_CREA", precision = 10, scale = 0)
public Long  getIdusserCrea()
{
		return this.idusserCrea;
}

public void setIdusserCrea(Long idusserCrea)
{
		this.idusserCrea = idusserCrea;
}

@Column(name = "IDUSSER_MODIF", precision = 10, scale = 0)
public Long  getIdusserModif()
{
		return this.idusserModif;
}

public void setIdusserModif(Long idusserModif)
{
		this.idusserModif = idusserModif;
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

@Column(name = "FECHA_MODIF", length = 7)
public Timestamp  getFechaModif()
{
		return this.fechaModif;
}

public void setFechaModif(Timestamp fechaModif)
{
		this.fechaModif = fechaModif;
}

@Column(name = "NUM_DOCU", precision = 25, scale = 0)
public Long  getNumDocu()
{
		return this.numDocu;
}

public void setNumDocu(Long numDocu)
{
		this.numDocu = numDocu;
}

@Column(name = "SEXO", length = 1)
public String  getSexo()
{
		return this.sexo;
}

public void setSexo(String sexo)
{
		this.sexo = sexo;
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

@Column(name = "ID_TIPODOCUMENTO", precision = 10, scale = 0)
public Long  getIdTipodocumento()
{
		return this.idTipodocumento;
}

public void setIdTipodocumento(Long idTipodocumento)
{
		this.idTipodocumento = idTipodocumento;
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

@Column(name = "RTMADDRESS", length = 50)
public String  getRtmaddress()
{
		return this.rtmaddress;
}

public void setRtmaddress(String rtmaddress)
{
		this.rtmaddress = rtmaddress;
}

@Column(name = "RTMADDRESSRST", length = 50)
public String  getRtmaddressrst()
{
		return this.rtmaddressrst;
}

public void setRtmaddressrst(String rtmaddressrst)
{
		this.rtmaddressrst = rtmaddressrst;
}

@Column(name = "OTRO_TELEFONO", length = 150)
public String  getOtroTelefono()
{
		return this.otroTelefono;
}

public void setOtroTelefono(String otroTelefono)
{
		this.otroTelefono = otroTelefono;
}

@Column(name = "OTRO_CELULAR", length = 150)
public String  getOtroCelular()
{
		return this.otroCelular;
}

public void setOtroCelular(String otroCelular)
{
		this.otroCelular = otroCelular;
}

@Column(name = "NUM_DOCUM", length = 20)
public String  getNumDocum()
{
		return this.numDocum;
}

public void setNumDocum(String numDocum)
{
		this.numDocum = numDocum;
}

@Column(name = "FLAG_MEDIOREG", precision = 38, scale = 0)
public Long  getFlagMedioreg()
{
		return this.flagMedioreg;
}

public void setFlagMedioreg(Long flagMedioreg)
{
		this.flagMedioreg = flagMedioreg;
}


			
}
