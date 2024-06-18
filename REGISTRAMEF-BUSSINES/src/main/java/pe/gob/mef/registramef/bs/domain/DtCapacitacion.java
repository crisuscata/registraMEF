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
 * DT_CAPACITACION ENTIDAD: ALMACENA LOS DATOS REGISTRADOS EN UNA CAPACITACION "CAPACITACIONES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CAPACITACION")
public class DtCapacitacion implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7228405866882409020L;

	// ID
	private Long idCapacitacion = null;

	// PROPIEDADES
	private Timestamp fechaInic = null;
	private Timestamp fechaFin = null;
	private Integer cantPartic = null;
	private String publicObj = null;
	private String nomEvento = null;
	private String detalleCapa = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idLocal = null;
	private Long idUsuinterno = null;
	private Long estado = null;
	private Long idModo = null;
	private Long idNivel = null;
	private Long idOrigen = null;
	private Long idPrestacion = null;
	private Long idProgramacion = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Integer cantParticAsist = null;
	private Long idTipo = null;
	private Long idcapaPadre = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Long flagPubli = null;
	private Long idModalidad = null;
	private String detalleCapaVirtual = null;
	private Timestamp fechaIniProgramada = null;
	private Timestamp fechaFinProgramada = null;
	private Timestamp fechaSoli = null;
	private Long stdIddoc = null;
	private String stdNumeroSid = null;
	private Integer stdNumeroAnio = null;
	private String stdNumeroDoc = null;
	private String stdAsunto = null;
	private String stdTipoDoc = null;
	private String stdFechaRecepcion = null;
	private String stdModalidadIng = null;
	private Long flagEjec = null;
	private String motivoEjec = null;
	

	public DtCapacitacion() {
	}

	@SequenceGenerator(name = "G_DT_CAPACITACION", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CAPACITACION", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CAPACITACION")
@Id
@Column(name = "ID_CAPACITACION", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCapacitacion()
{
		return this.idCapacitacion;
}

public void setIdCapacitacion(Long idCapacitacion)
{
		this.idCapacitacion = idCapacitacion;
}

@Column(name = "FECHA_INIC", length = 7)
public Timestamp  getFechaInic()
{
		return this.fechaInic;
}

public void setFechaInic(Timestamp fechaInic)
{
		this.fechaInic = fechaInic;
}

@Column(name = "FECHA_FIN", length = 7)
public Timestamp  getFechaFin()
{
		return this.fechaFin;
}

public void setFechaFin(Timestamp fechaFin)
{
		this.fechaFin = fechaFin;
}

@Column(name = "CANT_PARTIC", precision = 5, scale = 0)
public Integer  getCantPartic()
{
		return this.cantPartic;
}

public void setCantPartic(Integer cantPartic)
{
		this.cantPartic = cantPartic;
}

@Column(name = "PUBLIC_OBJ", length = 100)
public String  getPublicObj()
{
		return this.publicObj;
}

public void setPublicObj(String publicObj)
{
		this.publicObj = publicObj;
}

@Column(name = "NOM_EVENTO", length = 1000)
public String  getNomEvento()
{
		return this.nomEvento;
}

public void setNomEvento(String nomEvento)
{
		this.nomEvento = nomEvento;
}

@Column(name = "DETALLE_CAPA", length = 500)
public String  getDetalleCapa()
{
		return this.detalleCapa;
}

public void setDetalleCapa(String detalleCapa)
{
		this.detalleCapa = detalleCapa;
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

@Column(name = "ID_LOCAL", precision = 10, scale = 0)
public Long  getIdLocal()
{
		return this.idLocal;
}

public void setIdLocal(Long idLocal)
{
		this.idLocal = idLocal;
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

@Column(name = "ESTADO", nullable = false, precision = 10, scale = 0)
public Long  getEstado()
{
		return this.estado;
}

public void setEstado(Long estado)
{
		this.estado = estado;
}

@Column(name = "ID_MODO", precision = 10, scale = 0)
public Long  getIdModo()
{
		return this.idModo;
}

public void setIdModo(Long idModo)
{
		this.idModo = idModo;
}

@Column(name = "ID_NIVEL", precision = 10, scale = 0)
public Long  getIdNivel()
{
		return this.idNivel;
}

public void setIdNivel(Long idNivel)
{
		this.idNivel = idNivel;
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

@Column(name = "ID_PRESTACION", precision = 10, scale = 0)
public Long  getIdPrestacion()
{
		return this.idPrestacion;
}

public void setIdPrestacion(Long idPrestacion)
{
		this.idPrestacion = idPrestacion;
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

@Column(name = "CANT_PARTIC_ASIST", precision = 5, scale = 0)
public Integer  getCantParticAsist()
{
		return this.cantParticAsist;
}

public void setCantParticAsist(Integer cantParticAsist)
{
		this.cantParticAsist = cantParticAsist;
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

@Column(name = "IDCAPA_PADRE", precision = 10, scale = 0)
public Long  getIdcapaPadre()
{
		return this.idcapaPadre;
}

public void setIdcapaPadre(Long idcapaPadre)
{
		this.idcapaPadre = idcapaPadre;
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

@Column(name = "FLAG_PUBLI", precision = 38, scale = 0)
public Long  getFlagPubli()
{
		return this.flagPubli;
}

public void setFlagPubli(Long flagPubli)
{
		this.flagPubli = flagPubli;
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

@Column(name = "DETALLE_CAPA_VIRTUAL", length = 1000)
public String  getDetalleCapaVirtual()
{
		return this.detalleCapaVirtual;
}

public void setDetalleCapaVirtual(String detalleCapaVirtual)
{
		this.detalleCapaVirtual = detalleCapaVirtual;
}

@Column(name = "FECHA_INI_PROGRAMADA", length = 7)
public Timestamp  getFechaIniProgramada()
{
		return this.fechaIniProgramada;
}

public void setFechaIniProgramada(Timestamp fechaIniProgramada)
{
		this.fechaIniProgramada = fechaIniProgramada;
}

@Column(name = "FECHA_FIN_PROGRAMADA", length = 7)
public Timestamp  getFechaFinProgramada()
{
		return this.fechaFinProgramada;
}

public void setFechaFinProgramada(Timestamp fechaFinProgramada)
{
		this.fechaFinProgramada = fechaFinProgramada;
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

@Column(name = "STD_IDDOC", precision = 10, scale = 0)
public Long  getStdIddoc()
{
		return this.stdIddoc;
}

public void setStdIddoc(Long stdIddoc)
{
		this.stdIddoc = stdIddoc;
}

@Column(name = "STD_NUMERO_SID", length = 50)
public String  getStdNumeroSid()
{
		return this.stdNumeroSid;
}

public void setStdNumeroSid(String stdNumeroSid)
{
		this.stdNumeroSid = stdNumeroSid;
}

@Column(name = "STD_NUMERO_ANIO", precision = 4, scale = 0)
public Integer  getStdNumeroAnio()
{
		return this.stdNumeroAnio;
}

public void setStdNumeroAnio(Integer stdNumeroAnio)
{
		this.stdNumeroAnio = stdNumeroAnio;
}

@Column(name = "STD_NUMERO_DOC", length = 200)
public String  getStdNumeroDoc()
{
		return this.stdNumeroDoc;
}

public void setStdNumeroDoc(String stdNumeroDoc)
{
		this.stdNumeroDoc = stdNumeroDoc;
}

@Column(name = "STD_ASUNTO", length = 600)
public String  getStdAsunto()
{
		return this.stdAsunto;
}

public void setStdAsunto(String stdAsunto)
{
		this.stdAsunto = stdAsunto;
}

@Column(name = "STD_TIPO_DOC", length = 100)
public String  getStdTipoDoc()
{
		return this.stdTipoDoc;
}

public void setStdTipoDoc(String stdTipoDoc)
{
		this.stdTipoDoc = stdTipoDoc;
}

@Column(name = "STD_FECHA_RECEPCION", length = 20)
public String  getStdFechaRecepcion()
{
		return this.stdFechaRecepcion;
}

public void setStdFechaRecepcion(String stdFechaRecepcion)
{
		this.stdFechaRecepcion = stdFechaRecepcion;
}

@Column(name = "STD_MODALIDAD_ING", length = 200)
public String  getStdModalidadIng()
{
		return this.stdModalidadIng;
}

public void setStdModalidadIng(String stdModalidadIng)
{
		this.stdModalidadIng = stdModalidadIng;
}

@Column(name = "FLAG_EJEC", precision = 38, scale = 0)
public Long  getFlagEjec()
{
		return this.flagEjec;
}

public void setFlagEjec(Long flagEjec)
{
		this.flagEjec = flagEjec;
}

@Column(name = "MOTIVO_EJEC", length = 500)
public String  getMotivoEjec()
{
		return this.motivoEjec;
}

public void setMotivoEjec(String motivoEjec)
{
		this.motivoEjec = motivoEjec;
}


			
}
