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
 * DT_VISITAS_USUEXTERNOS ENTIDAD: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_VISITAS_USUEXTERNOS")
public class DtVisitasUsuexternos implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8319636923753089840L;

	// ID
	private Long idVisitUsuext = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idVisita = null;
	private Long idUsuexterno = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idCargoUsuext = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	

	public DtVisitasUsuexternos() {
	}

	@SequenceGenerator(name = "G_DT_VISITAS_USUEXTERNOS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_VISITAS_USUEXTERNOS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_VISITAS_USUEXTERNOS")
@Id
@Column(name = "ID_VISIT_USUEXT", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdVisitUsuext()
{
		return this.idVisitUsuext;
}

public void setIdVisitUsuext(Long idVisitUsuext)
{
		this.idVisitUsuext = idVisitUsuext;
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

@Column(name = "ID_VISITA", precision = 10, scale = 0)
public Long  getIdVisita()
{
		return this.idVisita;
}

public void setIdVisita(Long idVisita)
{
		this.idVisita = idVisita;
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

@Column(name = "ID_CARGO_USUEXT", precision = 10, scale = 0)
public Long  getIdCargoUsuext()
{
		return this.idCargoUsuext;
}

public void setIdCargoUsuext(Long idCargoUsuext)
{
		this.idCargoUsuext = idCargoUsuext;
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


			
}
