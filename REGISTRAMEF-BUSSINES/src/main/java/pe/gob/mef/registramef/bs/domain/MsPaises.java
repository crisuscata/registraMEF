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
 * MS_PAISES ENTIDAD: ALMACENA A LOS PAISES REGISTRADOS EN EL SISTEMA "PAÍSES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_PAISES")
public class MsPaises implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 807243153210806220L;

	// ID
	private Long idpais = null;

	// PROPIEDADES
	private String paisNombre = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private String acronimo = null;
	

	public MsPaises() {
	}

	@SequenceGenerator(name = "G_MS_PAISES", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_PAISES", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_PAISES")
@Id
@Column(name = "IDPAIS", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdpais()
{
		return this.idpais;
}

public void setIdpais(Long idpais)
{
		this.idpais = idpais;
}

@Column(name = "PAIS_NOMBRE", length = 100)
public String  getPaisNombre()
{
		return this.paisNombre;
}

public void setPaisNombre(String paisNombre)
{
		this.paisNombre = paisNombre;
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

@Column(name = "ACRONIMO", length = 20)
public String  getAcronimo()
{
		return this.acronimo;
}

public void setAcronimo(String acronimo)
{
		this.acronimo = acronimo;
}


			
}
