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
 * PRT_PARAMETROS ENTIDAD: ALMACENA LOS PARAMETROS REGISTRADOS EN EL SISTEMA "PARÁMETROS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "PRT_PARAMETROS")
public class PrtParametros implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1337294368848507348L;

	// ID
	private Long idparametro = null;

	// PROPIEDADES
	private Long idpadre = null;
	private String descripcion = null;
	private Integer estado = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressmodif = null;
	

	public PrtParametros() {
	}

	@SequenceGenerator(name = "G_PRT_PARAMETROS", sequenceName = PropertiesMg.ESQUEMA + "SQ_PRT_PARAMETROS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_PRT_PARAMETROS")
@Id
@Column(name = "IDPARAMETRO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdparametro()
{
		return this.idparametro;
}

public void setIdparametro(Long idparametro)
{
		this.idparametro = idparametro;
}

@Column(name = "IDPADRE", precision = 10, scale = 0)
public Long  getIdpadre()
{
		return this.idpadre;
}

public void setIdpadre(Long idpadre)
{
		this.idpadre = idpadre;
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

@Column(name = "ESTADO", precision = 1, scale = 0)
public Integer  getEstado()
{
		return this.estado;
}

public void setEstado(Integer estado)
{
		this.estado = estado;
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
