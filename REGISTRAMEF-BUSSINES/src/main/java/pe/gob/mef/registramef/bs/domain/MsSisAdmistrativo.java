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
 * MS_SIS_ADMISTRATIVO ENTIDAD: ALMACENA LOS SISTEMAS ADMINISTRATIVOS REGISTRADOS EN EL SISTEMA "SISTEMA ADMINISTRATIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_SIS_ADMISTRATIVO")
public class MsSisAdmistrativo implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2476029202505478037L;

	// ID
	private Long idSistAdmi = null;

	// PROPIEDADES
	private String descripcion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Integer flagasocencuesta = null;
	private String abreviatura = null;
	

	public MsSisAdmistrativo() {
	}

	@SequenceGenerator(name = "G_MS_SIS_ADMISTRATIVO", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_SIS_ADMISTRATIVO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_SIS_ADMISTRATIVO")
@Id
@Column(name = "ID_SIST_ADMI", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdSistAdmi()
{
		return this.idSistAdmi;
}

public void setIdSistAdmi(Long idSistAdmi)
{
		this.idSistAdmi = idSistAdmi;
}

@Column(name = "DESCRIPCION", length = 100)
public String  getDescripcion()
{
		return this.descripcion;
}

public void setDescripcion(String descripcion)
{
		this.descripcion = descripcion;
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

@Column(name = "FLAGASOCENCUESTA", precision = 1, scale = 0)
public Integer  getFlagasocencuesta()
{
		return this.flagasocencuesta;
}

public void setFlagasocencuesta(Integer flagasocencuesta)
{
		this.flagasocencuesta = flagasocencuesta;
}

@Column(name = "ABREVIATURA", length = 10)
public String  getAbreviatura()
{
		return this.abreviatura;
}

public void setAbreviatura(String abreviatura)
{
		this.abreviatura = abreviatura;
}


			
}
