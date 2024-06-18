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
 * DT_CONSULTAS ENTIDAD: ALMACENA LOS DATOS REGISTRADOS EN UNA CONSULTA "CONSULTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CONSULTAS")
public class DtConsultas implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7701094125584990550L;

	// ID
	private Long idConsulta = null;

	// PROPIEDADES
	private Timestamp fechaConsu = null;
	private String detalle = null;
	private String respuesta = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idPrestservic = null;
	private Long idModalidad = null;
	private Long idUsuexterno = null;
	private Long idUsuinterno = null;
	private Long idEntidad = null;
	private Long idTema = null;
	private Long idSubtema = null;
	private Long idOrigen = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idCargo = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaSoli = null;
	

	public DtConsultas() {
	}

	@SequenceGenerator(name = "G_DT_CONSULTAS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CONSULTAS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CONSULTAS")
@Id
@Column(name = "ID_CONSULTA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdConsulta()
{
		return this.idConsulta;
}

public void setIdConsulta(Long idConsulta)
{
		this.idConsulta = idConsulta;
}

@Column(name = "FECHA_CONSU", length = 7)
public Timestamp  getFechaConsu()
{
		return this.fechaConsu;
}

public void setFechaConsu(Timestamp fechaConsu)
{
		this.fechaConsu = fechaConsu;
}

@Column(name = "DETALLE", length = 500)
public String  getDetalle()
{
		return this.detalle;
}

public void setDetalle(String detalle)
{
		this.detalle = detalle;
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

@Column(name = "ID_PRESTSERVIC", precision = 10, scale = 0)
public Long  getIdPrestservic()
{
		return this.idPrestservic;
}

public void setIdPrestservic(Long idPrestservic)
{
		this.idPrestservic = idPrestservic;
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

@Column(name = "ID_USUEXTERNO", precision = 10, scale = 0)
public Long  getIdUsuexterno()
{
		return this.idUsuexterno;
}

public void setIdUsuexterno(Long idUsuexterno)
{
		this.idUsuexterno = idUsuexterno;
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

@Column(name = "ID_ORIGEN", precision = 10, scale = 0)
public Long  getIdOrigen()
{
		return this.idOrigen;
}

public void setIdOrigen(Long idOrigen)
{
		this.idOrigen = idOrigen;
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

@Column(name = "ID_CARGO", precision = 10, scale = 0)
public Long  getIdCargo()
{
		return this.idCargo;
}

public void setIdCargo(Long idCargo)
{
		this.idCargo = idCargo;
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

@Column(name = "CORREO_USUEXT", length = 50)
public String  getCorreoUsuext()
{
		return this.correoUsuext;
}

public void setCorreoUsuext(String correoUsuext)
{
		this.correoUsuext = correoUsuext;
}

@Column(name = "FIJO_USUEXT", length = 50)
public String  getFijoUsuext()
{
		return this.fijoUsuext;
}

public void setFijoUsuext(String fijoUsuext)
{
		this.fijoUsuext = fijoUsuext;
}

@Column(name = "CELULAR_USUEXT", length = 50)
public String  getCelularUsuext()
{
		return this.celularUsuext;
}

public void setCelularUsuext(String celularUsuext)
{
		this.celularUsuext = celularUsuext;
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
