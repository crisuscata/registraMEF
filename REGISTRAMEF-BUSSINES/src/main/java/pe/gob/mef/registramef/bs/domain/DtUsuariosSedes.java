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
 * DT_USUARIOS_SEDES ENTIDAD: ALMACENA A LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_USUARIOS_SEDES")
public class DtUsuariosSedes implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 340508727132181331L;

	// ID
	private Long idUsuSede = null;

	// PROPIEDADES
	private Long idSede = null;
	private Long idusuario = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtUsuariosSedes() {
	}

	@SequenceGenerator(name = "G_DT_USUARIOS_SEDES", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_USUARIOS_SEDES", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_USUARIOS_SEDES")
@Id
@Column(name = "ID_USU_SEDE", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdUsuSede()
{
		return this.idUsuSede;
}

public void setIdUsuSede(Long idUsuSede)
{
		this.idUsuSede = idUsuSede;
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

@Column(name = "IDUSUARIO", nullable = false, precision = 10, scale = 0)
public Long  getIdusuario()
{
		return this.idusuario;
}

public void setIdusuario(Long idusuario)
{
		this.idusuario = idusuario;
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
