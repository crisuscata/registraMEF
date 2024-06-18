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
 * DT_ASISTENCIA_TEMAS ENTIDAD: ALMACENA LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA "TEMAS DE LA ASISTENCIA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_ASISTENCIA_TEMAS")
public class DtAsistenciaTemas implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6935819130760762651L;

	// ID
	private Long idAsistTema = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String detalle = null;
	private Long idAsistencia = null;
	private Long idTema = null;
	private Long idSubtema = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idUsuinterno = null;
	private Long idSistAdmi = null;
	

	public DtAsistenciaTemas() {
	}

	@SequenceGenerator(name = "G_DT_ASISTENCIA_TEMAS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_ASISTENCIA_TEMAS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ASISTENCIA_TEMAS")
@Id
@Column(name = "ID_ASIST_TEMA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdAsistTema()
{
		return this.idAsistTema;
}

public void setIdAsistTema(Long idAsistTema)
{
		this.idAsistTema = idAsistTema;
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

@Column(name = "DETALLE", length = 400)
public String  getDetalle()
{
		return this.detalle;
}

public void setDetalle(String detalle)
{
		this.detalle = detalle;
}

@Column(name = "ID_ASISTENCIA", precision = 10, scale = 0)
public Long  getIdAsistencia()
{
		return this.idAsistencia;
}

public void setIdAsistencia(Long idAsistencia)
{
		this.idAsistencia = idAsistencia;
}

@Column(name = "ID_TEMA", precision = 10, scale = 0)
public Long  getIdTema()
{
		return this.idTema;
}

public void setIdTema(Long idTema)
{
		this.idTema = idTema;
}

@Column(name = "ID_SUBTEMA", precision = 10, scale = 0)
public Long  getIdSubtema()
{
		return this.idSubtema;
}

public void setIdSubtema(Long idSubtema)
{
		this.idSubtema = idSubtema;
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

@Column(name = "ID_USUINTERNO", precision = 10, scale = 0)
public Long  getIdUsuinterno()
{
		return this.idUsuinterno;
}

public void setIdUsuinterno(Long idUsuinterno)
{
		this.idUsuinterno = idUsuinterno;
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


			
}
