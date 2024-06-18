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
 * DT_CAPA_USUEXTERNOS ENTIDAD: ALMACENA A LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACION "PARTICIPANTES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CAPA_USUEXTERNOS")
public class DtCapaUsuexternos implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3389381694054700729L;

	// ID
	private Long idCapaUsuext = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idCapacitacion = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idUsuexterno = null;
	private Long idCargoUsuext = null;
	private Long idEntidad = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	private Long flagMedioreg = null;
	private Long flagAsistencia = null;
	private Long flagConfirReg = null;
	private Timestamp fechaFlagConfirReg = null;
	private Timestamp fechaFlagAsistencia = null;
	

	public DtCapaUsuexternos() {
	}

	@SequenceGenerator(name = "G_DT_CAPA_USUEXTERNOS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CAPA_USUEXTERNOS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CAPA_USUEXTERNOS")
@Id
@Column(name = "ID_CAPA_USUEXT", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCapaUsuext()
{
		return this.idCapaUsuext;
}

public void setIdCapaUsuext(Long idCapaUsuext)
{
		this.idCapaUsuext = idCapaUsuext;
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

@Column(name = "ID_CAPACITACION", precision = 10, scale = 0)
public Long  getIdCapacitacion()
{
		return this.idCapacitacion;
}

public void setIdCapacitacion(Long idCapacitacion)
{
		this.idCapacitacion = idCapacitacion;
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

@Column(name = "ID_USUEXTERNO", precision = 10, scale = 0)
public Long  getIdUsuexterno()
{
		return this.idUsuexterno;
}

public void setIdUsuexterno(Long idUsuexterno)
{
		this.idUsuexterno = idUsuexterno;
}

@Column(name = "ID_CARGO_USUEXT", precision = 10, scale = 0)
public Long  getIdCargoUsuext()
{
		return this.idCargoUsuext;
}

public void setIdCargoUsuext(Long idCargoUsuext)
{
		this.idCargoUsuext = idCargoUsuext;
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

@Column(name = "FLAG_MEDIOREG", precision = 38, scale = 0)
public Long  getFlagMedioreg()
{
		return this.flagMedioreg;
}

public void setFlagMedioreg(Long flagMedioreg)
{
		this.flagMedioreg = flagMedioreg;
}

@Column(name = "FLAG_ASISTENCIA", precision = 38, scale = 0)
public Long  getFlagAsistencia()
{
		return this.flagAsistencia;
}

public void setFlagAsistencia(Long flagAsistencia)
{
		this.flagAsistencia = flagAsistencia;
}

@Column(name = "FLAG_CONFIR_REG", precision = 38, scale = 0)
public Long  getFlagConfirReg()
{
		return this.flagConfirReg;
}

public void setFlagConfirReg(Long flagConfirReg)
{
		this.flagConfirReg = flagConfirReg;
}

@Column(name = "FECHA_FLAG_CONFIR_REG", length = 11)
public Timestamp  getFechaFlagConfirReg()
{
		return this.fechaFlagConfirReg;
}

public void setFechaFlagConfirReg(Timestamp fechaFlagConfirReg)
{
		this.fechaFlagConfirReg = fechaFlagConfirReg;
}

@Column(name = "FECHA_FLAG_ASISTENCIA", length = 11)
public Timestamp  getFechaFlagAsistencia()
{
		return this.fechaFlagAsistencia;
}

public void setFechaFlagAsistencia(Timestamp fechaFlagAsistencia)
{
		this.fechaFlagAsistencia = fechaFlagAsistencia;
}


			
}
