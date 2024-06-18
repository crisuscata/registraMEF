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
 * MS_LOCAL ENTIDAD: ALMACENA LOS LOCALES REGISTRADOS EN EL SISTEMA "LOCALES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_LOCAL")
public class MsLocal implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2618987593384671911L;

	// ID
	private Long idLocal = null;

	// PROPIEDADES
	private String descripcion = null;
	private String direccion = null;
	private String referencia = null;
	private Long idduserCrea = null;
	private Long idduserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Integer codDpto = null;
	private Integer codProv = null;
	private Integer codDistr = null;
	private Long idSede = null;
	private Long idpais = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsLocal() {
	}

	@SequenceGenerator(name = "G_MS_LOCAL", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_LOCAL", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_LOCAL")
@Id
@Column(name = "ID_LOCAL", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdLocal()
{
		return this.idLocal;
}

public void setIdLocal(Long idLocal)
{
		this.idLocal = idLocal;
}

@Column(name = "DESCRIPCION", length = 200)
public String  getDescripcion()
{
		return this.descripcion;
}

public void setDescripcion(String descripcion)
{
		this.descripcion = descripcion;
}

@Column(name = "DIRECCION", length = 100)
public String  getDireccion()
{
		return this.direccion;
}

public void setDireccion(String direccion)
{
		this.direccion = direccion;
}

@Column(name = "REFERENCIA", length = 200)
public String  getReferencia()
{
		return this.referencia;
}

public void setReferencia(String referencia)
{
		this.referencia = referencia;
}

@Column(name = "IDDUSER_CREA", precision = 10, scale = 0)
public Long  getIdduserCrea()
{
		return this.idduserCrea;
}

public void setIdduserCrea(Long idduserCrea)
{
		this.idduserCrea = idduserCrea;
}

@Column(name = "IDDUSER_MODIF", precision = 10, scale = 0)
public Long  getIdduserModif()
{
		return this.idduserModif;
}

public void setIdduserModif(Long idduserModif)
{
		this.idduserModif = idduserModif;
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

@Column(name = "ID_SEDE", precision = 10, scale = 0)
public Long  getIdSede()
{
		return this.idSede;
}

public void setIdSede(Long idSede)
{
		this.idSede = idSede;
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

@Column(name = "ESTADO", precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
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


			
}
