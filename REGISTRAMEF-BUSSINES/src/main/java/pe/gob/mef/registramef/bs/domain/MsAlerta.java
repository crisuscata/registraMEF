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
 * MS_ALERTA ENTIDAD: ALMACENA LAS ALERTAS GENERADAS EN EL SISTMA "ALERTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_ALERTA")
public class MsAlerta implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3313752457615293511L;

	// ID
	private Long idAlerta = null;

	// PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Integer dia = null;
	private Integer hora = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private String otrosDestin = null;
	private Long idCaracterst = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsAlerta() {
	}

	@SequenceGenerator(name = "G_MS_ALERTA", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_ALERTA", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_ALERTA")
@Id
@Column(name = "ID_ALERTA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdAlerta()
{
		return this.idAlerta;
}

public void setIdAlerta(Long idAlerta)
{
		this.idAlerta = idAlerta;
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

@Column(name = "DIA", precision = 4, scale = 0)
public Integer  getDia()
{
		return this.dia;
}

public void setDia(Integer dia)
{
		this.dia = dia;
}

@Column(name = "HORA", precision = 4, scale = 0)
public Integer  getHora()
{
		return this.hora;
}

public void setHora(Integer hora)
{
		this.hora = hora;
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

@Column(name = "OTROS_DESTIN", length = 100)
public String  getOtrosDestin()
{
		return this.otrosDestin;
}

public void setOtrosDestin(String otrosDestin)
{
		this.otrosDestin = otrosDestin;
}

@Column(name = "ID_CARACTERST", precision = 10, scale = 0)
public Long  getIdCaracterst()
{
		return this.idCaracterst;
}

public void setIdCaracterst(Long idCaracterst)
{
		this.idCaracterst = idCaracterst;
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
