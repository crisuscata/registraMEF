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
 * DT_CAPA_ENTIDADES ENTIDAD: ALMACENA A LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION "ENTIDADES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CAPA_ENTIDADES")
public class DtCapaEntidades implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3921158812814333196L;

	// ID
	private Long idCapaEnti = null;

	// PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idCapacitacion = null;
	private Long idEntidad = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtCapaEntidades() {
	}

	@SequenceGenerator(name = "G_DT_CAPA_ENTIDADES", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CAPA_ENTIDADES", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CAPA_ENTIDADES")
@Id
@Column(name = "ID_CAPA_ENTI", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCapaEnti()
{
		return this.idCapaEnti;
}

public void setIdCapaEnti(Long idCapaEnti)
{
		this.idCapaEnti = idCapaEnti;
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

@Column(name = "ID_ENTIDAD", precision = 10, scale = 0)
public Long  getIdEntidad()
{
		return this.idEntidad;
}

public void setIdEntidad(Long idEntidad)
{
		this.idEntidad = idEntidad;
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
