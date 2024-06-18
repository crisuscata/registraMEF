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
 * DT_VISITAS_TEMAS ENTIDAD: ALAMACENA LOS TEMAS DE LA VISITA "TEMAS DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_VISITAS_TEMAS")
public class DtVisitasTemas implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7676709523539612966L;

	// ID
	private Long idVisitaTema = null;

	// PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long duserCrea = null;
	private Long iduserModif = null;
	private Long estado = null;
	private Long idVisita = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idTema = null;
	

	public DtVisitasTemas() {
	}

	@SequenceGenerator(name = "G_DT_VISITAS_TEMAS", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_VISITAS_TEMAS", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_VISITAS_TEMAS")
@Id
@Column(name = "ID_VISITA_TEMA", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdVisitaTema()
{
		return this.idVisitaTema;
}

public void setIdVisitaTema(Long idVisitaTema)
{
		this.idVisitaTema = idVisitaTema;
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

@Column(name = "DUSER_CREA", precision = 10, scale = 0)
public Long  getDuserCrea()
{
		return this.duserCrea;
}

public void setDuserCrea(Long duserCrea)
{
		this.duserCrea = duserCrea;
}

@Column(name = "IDUSER_MODIF", precision = 10, scale = 0)
public Long  getIduserModif()
{
		return this.iduserModif;
}

public void setIduserModif(Long iduserModif)
{
		this.iduserModif = iduserModif;
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

@Column(name = "ID_VISITA", precision = 10, scale = 0)
public Long  getIdVisita()
{
		return this.idVisita;
}

public void setIdVisita(Long idVisita)
{
		this.idVisita = idVisita;
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
