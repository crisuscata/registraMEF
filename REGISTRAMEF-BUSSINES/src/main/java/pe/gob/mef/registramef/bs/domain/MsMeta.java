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
 * MS_META ENTIDAD: ALMACENA LAS METAS CON SUS VALORES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_META")
public class MsMeta implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5069682696059092930L;

	// ID
	private Long idMeta = null;

	// PROPIEDADES
	private Integer annio = null;
	private Long idTipoServicio = null;
	private Long idSistAdmi = null;
	private Long idSede = null;
	private Long valor = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsMeta() {
	}

	@SequenceGenerator(name = "G_MS_META", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_META", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_META")
@Id
@Column(name = "ID_META", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdMeta()
{
		return this.idMeta;
}

public void setIdMeta(Long idMeta)
{
		this.idMeta = idMeta;
}

@Column(name = "ANNIO", precision = 4, scale = 0)
public Integer  getAnnio()
{
		return this.annio;
}

public void setAnnio(Integer annio)
{
		this.annio = annio;
}

@Column(name = "ID_TIPO_SERVICIO", precision = 10, scale = 0)
public Long  getIdTipoServicio()
{
		return this.idTipoServicio;
}

public void setIdTipoServicio(Long idTipoServicio)
{
		this.idTipoServicio = idTipoServicio;
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

@Column(name = "VALOR", precision = 10, scale = 0)
public Long  getValor()
{
		return this.valor;
}

public void setValor(Long valor)
{
		this.valor = valor;
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
