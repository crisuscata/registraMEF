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
 * DT_VISITAS ENTIDAD: ALMACENA LOS DATOS REGISTRADOS EN UNA VISITA "VISITAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_VISITAS")
public class DtVisitas implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -948568136280323598L;

	// ID
	private Long idVisita = null;

	// PROPIEDADES
	private Timestamp fechaVisita = null;
	private String conclusion = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idOrigen = null;
	private Long idProgramacion = null;
	private Long idModalidad = null;
	private Long idTipo = null;
	private Long idLugar = null;
	private Long idEntidad = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaProgramada = null;
	

	public DtVisitas() {
	}

	@SequenceGenerator(name = "G_DT_VISITAS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_VISITAS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_VISITAS")
@Id
@Column(name = "ID_VISITA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdVisita()
{
		return this.idVisita;
}

public void setIdVisita(Long idVisita)
{
		this.idVisita = idVisita;
}

@Column(name = "FECHA_VISITA", length = 7)
public Timestamp  getFechaVisita()
{
		return this.fechaVisita;
}

public void setFechaVisita(Timestamp fechaVisita)
{
		this.fechaVisita = fechaVisita;
}

@Column(name = "CONCLUSION", length = 500)
public String  getConclusion()
{
		return this.conclusion;
}

public void setConclusion(String conclusion)
{
		this.conclusion = conclusion;
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

@Column(name = "ID_MODALIDAD", precision = 10, scale = 0)
public Long  getIdModalidad()
{
		return this.idModalidad;
}

public void setIdModalidad(Long idModalidad)
{
		this.idModalidad = idModalidad;
}

@Column(name = "ID_TIPO", precision = 10, scale = 0)
public Long  getIdTipo()
{
		return this.idTipo;
}

public void setIdTipo(Long idTipo)
{
		this.idTipo = idTipo;
}

@Column(name = "ID_LUGAR", precision = 10, scale = 0)
public Long  getIdLugar()
{
		return this.idLugar;
}

public void setIdLugar(Long idLugar)
{
		this.idLugar = idLugar;
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


			
}
