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
 * DT_VISITAS_PROYECTO ENTIDAD: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_VISITAS_PROYECTO")
public class DtVisitasProyecto implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3017100095249694441L;

	// ID
	private Long idVisitaProyecto = null;

	// PROPIEDADES
	private Long idVisita = null;
	private Long idProyecto = null;
	private String detalle = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtVisitasProyecto() {
	}

	@SequenceGenerator(name = "G_DT_VISITAS_PROYECTO", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_VISITAS_PROYECTO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_VISITAS_PROYECTO")
@Id
@Column(name = "ID_VISITA_PROYECTO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdVisitaProyecto()
{
		return this.idVisitaProyecto;
}

public void setIdVisitaProyecto(Long idVisitaProyecto)
{
		this.idVisitaProyecto = idVisitaProyecto;
}

@Column(name = "ID_VISITA", nullable = false, precision = 10, scale = 0)
public Long  getIdVisita()
{
		return this.idVisita;
}

public void setIdVisita(Long idVisita)
{
		this.idVisita = idVisita;
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
