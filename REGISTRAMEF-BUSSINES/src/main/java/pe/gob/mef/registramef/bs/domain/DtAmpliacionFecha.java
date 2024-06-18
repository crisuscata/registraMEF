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
 * DT_AMPLIACION_FECHA ENTIDAD: ALMACENA LAS AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_AMPLIACION_FECHA")
public class DtAmpliacionFecha implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5531474263911774375L;

	// ID
	private Long idAutorizacion = null;

	// PROPIEDADES
	private Long tipoFechaCorte = null;
	private Long idSede = null;
	private Long idSistAdmi = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtAmpliacionFecha() {
	}

	@SequenceGenerator(name = "G_DT_AMPLIACION_FECHA", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_AMPLIACION_FECHA", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_AMPLIACION_FECHA")
@Id
@Column(name = "ID_AUTORIZACION", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdAutorizacion()
{
		return this.idAutorizacion;
}

public void setIdAutorizacion(Long idAutorizacion)
{
		this.idAutorizacion = idAutorizacion;
}

@Column(name = "TIPO_FECHA_CORTE", nullable = false, precision = 10, scale = 0)
public Long  getTipoFechaCorte()
{
		return this.tipoFechaCorte;
}

public void setTipoFechaCorte(Long tipoFechaCorte)
{
		this.tipoFechaCorte = tipoFechaCorte;
}

@Column(name = "ID_SEDE", nullable = false, precision = 10, scale = 0)
public Long  getIdSede()
{
		return this.idSede;
}

public void setIdSede(Long idSede)
{
		this.idSede = idSede;
}

@Column(name = "ID_SIST_ADMI", nullable = false, precision = 10, scale = 0)
public Long  getIdSistAdmi()
{
		return this.idSistAdmi;
}

public void setIdSistAdmi(Long idSistAdmi)
{
		this.idSistAdmi = idSistAdmi;
}

@Column(name = "FECHA_INICIO", length = 7)
public Timestamp  getFechaInicio()
{
		return this.fechaInicio;
}

public void setFechaInicio(Timestamp fechaInicio)
{
		this.fechaInicio = fechaInicio;
}

@Column(name = "FECHA_FIN", nullable = false, length = 7)
public Timestamp  getFechaFin()
{
		return this.fechaFin;
}

public void setFechaFin(Timestamp fechaFin)
{
		this.fechaFin = fechaFin;
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
