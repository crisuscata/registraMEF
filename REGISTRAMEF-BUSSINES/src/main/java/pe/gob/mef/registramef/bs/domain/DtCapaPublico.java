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
 * DT_CAPA_PUBLICO ENTIDAD: ALMACENA EL TIPO DE PUBLICO OBJETIVO POR CAPACITACION "PUBLICO OBJETIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CAPA_PUBLICO")
public class DtCapaPublico implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7803433365672832825L;

	// ID
	private Long idCapaPublico = null;

	// PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Long idCapacitacion = null;
	private Long idCargo = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtCapaPublico() {
	}

	@SequenceGenerator(name = "G_DT_CAPA_PUBLICO", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CAPA_PUBLICO", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CAPA_PUBLICO")
@Id
@Column(name = "ID_CAPA_PUBLICO", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCapaPublico()
{
		return this.idCapaPublico;
}

public void setIdCapaPublico(Long idCapaPublico)
{
		this.idCapaPublico = idCapaPublico;
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

@Column(name = "IDUSER_CREA", precision = 10, scale = 0)
public Long  getIduserCrea()
{
		return this.iduserCrea;
}

public void setIduserCrea(Long iduserCrea)
{
		this.iduserCrea = iduserCrea;
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

@Column(name = "ID_CAPACITACION", precision = 10, scale = 0)
public Long  getIdCapacitacion()
{
		return this.idCapacitacion;
}

public void setIdCapacitacion(Long idCapacitacion)
{
		this.idCapacitacion = idCapacitacion;
}

@Column(name = "ID_CARGO", precision = 10, scale = 0)
public Long  getIdCargo()
{
		return this.idCargo;
}

public void setIdCargo(Long idCargo)
{
		this.idCargo = idCargo;
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
