package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DT_ENCUESTA ENTIDAD: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_ENCUESTA")
public class DtEncuesta implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7061466988914965581L;

	// ID
	private Integer idEncuesta = null;

	// PROPIEDADES
	private Long tipoServicio = null;
	private Timestamp fechaInicio = null;
	private Timestamp fechaFin = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long flagBloqueo = null;
	private Long idOrigen = null;
	private Long idPrestacion = null;
	

	public DtEncuesta() {
	}

	@Id
@Column(name = "ID_ENCUESTA", unique = true, nullable = false, precision = 5, scale = 0)
public Integer  getIdEncuesta()
{
		return this.idEncuesta;
}

public void setIdEncuesta(Integer idEncuesta)
{
		this.idEncuesta = idEncuesta;
}

@Column(name = "TIPO_SERVICIO", nullable = false, precision = 10, scale = 0)
public Long  getTipoServicio()
{
		return this.tipoServicio;
}

public void setTipoServicio(Long tipoServicio)
{
		this.tipoServicio = tipoServicio;
}

@Column(name = "FECHA_INICIO", nullable = false, length = 7)
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

@Column(name = "FLAG_BLOQUEO", precision = 38, scale = 0)
public Long  getFlagBloqueo()
{
		return this.flagBloqueo;
}

public void setFlagBloqueo(Long flagBloqueo)
{
		this.flagBloqueo = flagBloqueo;
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


			
}
