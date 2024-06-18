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
 * MS_SEDES ENTIDAD: ALMACENA LAS SEDES REGISTRADAS EN EL SISTEMA "SEDES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_SEDES")
public class MsSedes implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8203499229548145173L;

	// ID
	private Long idSede = null;

	// PROPIEDADES
	private String sigla = null;
	private String sede = null;
	private String direccion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idGrupo = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long estado = null;
	private Long idMacregion = null;
	private Long idpais = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long orden = null;
	private Integer flagvisible = null;
	private Integer flagvisiblerpte = null;
	

	public MsSedes() {
	}

	@SequenceGenerator(name = "G_MS_SEDES", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_SEDES", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_SEDES")
@Id
@Column(name = "ID_SEDE", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdSede()
{
		return this.idSede;
}

public void setIdSede(Long idSede)
{
		this.idSede = idSede;
}

@Column(name = "SIGLA", length = 10)
public String  getSigla()
{
		return this.sigla;
}

public void setSigla(String sigla)
{
		this.sigla = sigla;
}

@Column(name = "SEDE", length = 100)
public String  getSede()
{
		return this.sede;
}

public void setSede(String sede)
{
		this.sede = sede;
}

@Column(name = "DIRECCION", length = 1000)
public String  getDireccion()
{
		return this.direccion;
}

public void setDireccion(String direccion)
{
		this.direccion = direccion;
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

@Column(name = "ID_GRUPO", precision = 10, scale = 0)
public Long  getIdGrupo()
{
		return this.idGrupo;
}

public void setIdGrupo(Long idGrupo)
{
		this.idGrupo = idGrupo;
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

@Column(name = "ESTADO", precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
}

@Column(name = "ID_MACREGION", precision = 10, scale = 0)
public Long  getIdMacregion()
{
		return this.idMacregion;
}

public void setIdMacregion(Long idMacregion)
{
		this.idMacregion = idMacregion;
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

@Column(name = "ORDEN", precision = 10, scale = 0)
public Long  getOrden()
{
		return this.orden;
}

public void setOrden(Long orden)
{
		this.orden = orden;
}

@Column(name = "FLAGVISIBLE", precision = 1, scale = 0)
public Integer  getFlagvisible()
{
		return this.flagvisible;
}

public void setFlagvisible(Integer flagvisible)
{
		this.flagvisible = flagvisible;
}

@Column(name = "FLAGVISIBLERPTE", precision = 1, scale = 0)
public Integer  getFlagvisiblerpte()
{
		return this.flagvisiblerpte;
}

public void setFlagvisiblerpte(Integer flagvisiblerpte)
{
		this.flagvisiblerpte = flagvisiblerpte;
}


			
}
