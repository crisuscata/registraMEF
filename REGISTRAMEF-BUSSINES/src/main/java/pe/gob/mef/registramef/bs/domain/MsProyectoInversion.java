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
 * MS_PROYECTO_INVERSION ENTIDAD: ALMACENA LOS DATOS DE PROYECTOS DE INVERSIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_PROYECTO_INVERSION")
public class MsProyectoInversion implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2146859632803241201L;

	// ID
	private Long idProyecto = null;

	// PROPIEDADES
	private String codigo = null;
	private String nombre = null;
	private Long idSede = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsProyectoInversion() {
	}

	@SequenceGenerator(name = "G_MS_PROYECTO_INVERSION", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_PROYECTO_INVERSION", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_PROYECTO_INVERSION")
@Id
@Column(name = "ID_PROYECTO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdProyecto()
{
		return this.idProyecto;
}

public void setIdProyecto(Long idProyecto)
{
		this.idProyecto = idProyecto;
}

@Column(name = "CODIGO", length = 7)
public String  getCodigo()
{
		return this.codigo;
}

public void setCodigo(String codigo)
{
		this.codigo = codigo;
}

@Column(name = "NOMBRE", length = 470)
public String  getNombre()
{
		return this.nombre;
}

public void setNombre(String nombre)
{
		this.nombre = nombre;
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

@Column(name = "ESTADO", nullable = false, precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
}

@Column(name = "IDUSSER_CREA", nullable = false, precision = 10, scale = 0)
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

@Column(name = "FECHA_CREA", nullable = false, length = 7)
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
