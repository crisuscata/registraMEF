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
 * DT_ENCUESTA_RESPUESTA ENTIDAD: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_ENCUESTA_RESPUESTA")
public class DtEncuestaRespuesta implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3427632652898860536L;

	// ID
	private Long idRespuesta = null;

	// PROPIEDADES
	private Long idUsuexterno = null;
	private Integer idEncuesta = null;
	private Long idServicio = null;
	private String tipoPregunta = null;
	private String idPregunta = null;
	private String respuesta = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idExpositor = null;
	private String pregunta = null;
	

	public DtEncuestaRespuesta() {
	}

	@SequenceGenerator(name = "G_DT_ENCUESTA_RESPUESTA", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_ENCUESTA_RESPUESTA", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ENCUESTA_RESPUESTA")
@Id
@Column(name = "ID_RESPUESTA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdRespuesta()
{
		return this.idRespuesta;
}

public void setIdRespuesta(Long idRespuesta)
{
		this.idRespuesta = idRespuesta;
}

@Column(name = "ID_USUEXTERNO", nullable = false, precision = 10, scale = 0)
public Long  getIdUsuexterno()
{
		return this.idUsuexterno;
}

public void setIdUsuexterno(Long idUsuexterno)
{
		this.idUsuexterno = idUsuexterno;
}

@Column(name = "ID_ENCUESTA", nullable = false, precision = 5, scale = 0)
public Integer  getIdEncuesta()
{
		return this.idEncuesta;
}

public void setIdEncuesta(Integer idEncuesta)
{
		this.idEncuesta = idEncuesta;
}

@Column(name = "ID_SERVICIO", nullable = false, precision = 10, scale = 0)
public Long  getIdServicio()
{
		return this.idServicio;
}

public void setIdServicio(Long idServicio)
{
		this.idServicio = idServicio;
}

@Column(name = "TIPO_PREGUNTA", length = 20)
public String  getTipoPregunta()
{
		return this.tipoPregunta;
}

public void setTipoPregunta(String tipoPregunta)
{
		this.tipoPregunta = tipoPregunta;
}

@Column(name = "ID_PREGUNTA", length = 50)
public String  getIdPregunta()
{
		return this.idPregunta;
}

public void setIdPregunta(String idPregunta)
{
		this.idPregunta = idPregunta;
}

@Column(name = "RESPUESTA", length = 600)
public String  getRespuesta()
{
		return this.respuesta;
}

public void setRespuesta(String respuesta)
{
		this.respuesta = respuesta;
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

@Column(name = "ID_EXPOSITOR", precision = 10, scale = 0)
public Long  getIdExpositor()
{
		return this.idExpositor;
}

public void setIdExpositor(Long idExpositor)
{
		this.idExpositor = idExpositor;
}

@Column(name = "PREGUNTA", length = 3000)
public String  getPregunta()
{
		return this.pregunta;
}

public void setPregunta(String pregunta)
{
		this.pregunta = pregunta;
}


			
}
