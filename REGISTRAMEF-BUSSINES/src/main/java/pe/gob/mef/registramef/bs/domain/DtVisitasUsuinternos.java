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
 * DT_VISITAS_USUINTERNOS ENTIDAD: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_VISITAS_USUINTERNOS")
public class DtVisitasUsuinternos implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2881952404653518262L;

	// ID
	private Long idVisitUsuint = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idVisita = null;
	private Long idUsuinterno = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idTema = null;
	

	public DtVisitasUsuinternos() {
	}

	@SequenceGenerator(name = "G_DT_VISITAS_USUINTERNOS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_VISITAS_USUINTERNOS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_VISITAS_USUINTERNOS")
@Id
@Column(name = "ID_VISIT_USUINT", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdVisitUsuint()
{
		return this.idVisitUsuint;
}

public void setIdVisitUsuint(Long idVisitUsuint)
{
		this.idVisitUsuint = idVisitUsuint;
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

@Column(name = "ID_USUINTERNO", precision = 10, scale = 0)
public Long  getIdUsuinterno()
{
		return this.idUsuinterno;
}

public void setIdUsuinterno(Long idUsuinterno)
{
		this.idUsuinterno = idUsuinterno;
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

@Column(name = "ID_TEMA", precision = 10, scale = 0)
public Long  getIdTema()
{
		return this.idTema;
}

public void setIdTema(Long idTema)
{
		this.idTema = idTema;
}


			
}
