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
 * DT_CAPA_PROYECTO ENTIDAD: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CAPA_PROYECTO")
public class DtCapaProyecto implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2924171575250879180L;

	// ID
	private Long idCapaProyecto = null;

	// PROPIEDADES
	private Long idProyecto = null;
	private Long idCapacitacion = null;
	private String detalle = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtCapaProyecto() {
	}

	@SequenceGenerator(name = "G_DT_CAPA_PROYECTO", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CAPA_PROYECTO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CAPA_PROYECTO")
@Id
@Column(name = "ID_CAPA_PROYECTO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCapaProyecto()
{
		return this.idCapaProyecto;
}

public void setIdCapaProyecto(Long idCapaProyecto)
{
		this.idCapaProyecto = idCapaProyecto;
}

@Column(name = "ID_PROYECTO", nullable = false, precision = 10, scale = 0)
public Long  getIdProyecto()
{
		return this.idProyecto;
}

public void setIdProyecto(Long idProyecto)
{
		this.idProyecto = idProyecto;
}

@Column(name = "ID_CAPACITACION", nullable = false, precision = 10, scale = 0)
public Long  getIdCapacitacion()
{
		return this.idCapacitacion;
}

public void setIdCapacitacion(Long idCapacitacion)
{
		this.idCapacitacion = idCapacitacion;
}

@Column(name = "DETALLE", length = 300)
public String  getDetalle()
{
		return this.detalle;
}

public void setDetalle(String detalle)
{
		this.detalle = detalle;
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
