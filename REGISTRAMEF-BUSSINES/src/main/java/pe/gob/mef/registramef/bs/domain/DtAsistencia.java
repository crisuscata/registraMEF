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
 * DT_ASISTENCIA ENTIDAD: ALMACENA LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA "ASISTENCIA TÉCNICA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_ASISTENCIA")
public class DtAsistencia implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -110615186749921207L;

	// ID
	private Long idAsistencia = null;

	// PROPIEDADES
	private Timestamp fechaAsistencia = null;
	private String detalle = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idUsuinterno = null;
	private Long idEntidad = null;
	private Long idOrigen = null;
	private Long idProgramacion = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idModalidad = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaProgramada = null;
	private Timestamp fechaSoli = null;
	

	public DtAsistencia() {
	}

	@SequenceGenerator(name = "G_DT_ASISTENCIA", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_ASISTENCIA", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_ASISTENCIA")
@Id
@Column(name = "ID_ASISTENCIA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdAsistencia()
{
		return this.idAsistencia;
}

public void setIdAsistencia(Long idAsistencia)
{
		this.idAsistencia = idAsistencia;
}

@Column(name = "FECHA_ASISTENCIA", length = 7)
public Timestamp  getFechaAsistencia()
{
		return this.fechaAsistencia;
}

public void setFechaAsistencia(Timestamp fechaAsistencia)
{
		this.fechaAsistencia = fechaAsistencia;
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

@Column(name = "ID_USUINTERNO", precision = 10, scale = 0)
public Long  getIdUsuinterno()
{
		return this.idUsuinterno;
}

public void setIdUsuinterno(Long idUsuinterno)
{
		this.idUsuinterno = idUsuinterno;
}

@Column(name = "ID_ENTIDAD", precision = 10, scale = 0)
public Long  getIdEntidad()
{
		return this.idEntidad;
}

public void setIdEntidad(Long idEntidad)
{
		this.idEntidad = idEntidad;
}

@Column(name = "ID_ORIGEN", precision = 10, scale = 0)
public Long  getIdOrigen()
{
		return this.idOrigen;
}

public void setIdOrigen(Long idOrigen)
{
		this.idOrigen = idOrigen;
}

@Column(name = "ID_PROGRAMACION", precision = 10, scale = 0)
public Long  getIdProgramacion()
{
		return this.idProgramacion;
}

public void setIdProgramacion(Long idProgramacion)
{
		this.idProgramacion = idProgramacion;
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

@Column(name = "ID_MODALIDAD", precision = 10, scale = 0)
public Long  getIdModalidad()
{
		return this.idModalidad;
}

public void setIdModalidad(Long idModalidad)
{
		this.idModalidad = idModalidad;
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

@Column(name = "ID_SIST_ADM", precision = 10, scale = 0)
public Long  getIdSistAdm()
{
		return this.idSistAdm;
}

public void setIdSistAdm(Long idSistAdm)
{
		this.idSistAdm = idSistAdm;
}

@Column(name = "ID_FINANCIA", precision = 10, scale = 0)
public Long  getIdFinancia()
{
		return this.idFinancia;
}

public void setIdFinancia(Long idFinancia)
{
		this.idFinancia = idFinancia;
}

@Column(name = "FECHA_FINALIZACION", length = 11)
public Timestamp  getFechaFinalizacion()
{
		return this.fechaFinalizacion;
}

public void setFechaFinalizacion(Timestamp fechaFinalizacion)
{
		this.fechaFinalizacion = fechaFinalizacion;
}

@Column(name = "FECHA_PROGRAMADA", length = 7)
public Timestamp  getFechaProgramada()
{
		return this.fechaProgramada;
}

public void setFechaProgramada(Timestamp fechaProgramada)
{
		this.fechaProgramada = fechaProgramada;
}

@Column(name = "FECHA_SOLI", length = 7)
public Timestamp  getFechaSoli()
{
		return this.fechaSoli;
}

public void setFechaSoli(Timestamp fechaSoli)
{
		this.fechaSoli = fechaSoli;
}


			
}
