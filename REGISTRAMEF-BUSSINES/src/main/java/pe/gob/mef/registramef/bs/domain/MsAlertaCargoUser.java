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
 * MS_ALERTA_CARGO_USER ENTIDAD: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_ALERTA_CARGO_USER")
public class MsAlertaCargoUser implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2995774547567060268L;

	// ID
	private Long idalertaCargo = null;

	// PROPIEDADES
	private Long idalerta = null;
	private Long idcargo = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsAlertaCargoUser() {
	}

	@SequenceGenerator(name = "G_MS_ALERTA_CARGO_USER", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_ALERTA_CARGO_USER", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_ALERTA_CARGO_USER")
@Id
@Column(name = "IDALERTA_CARGO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdalertaCargo()
{
		return this.idalertaCargo;
}

public void setIdalertaCargo(Long idalertaCargo)
{
		this.idalertaCargo = idalertaCargo;
}

@Column(name = "IDALERTA", precision = 10, scale = 0)
public Long  getIdalerta()
{
		return this.idalerta;
}

public void setIdalerta(Long idalerta)
{
		this.idalerta = idalerta;
}

@Column(name = "IDCARGO", precision = 10, scale = 0)
public Long  getIdcargo()
{
		return this.idcargo;
}

public void setIdcargo(Long idcargo)
{
		this.idcargo = idcargo;
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


			
}
