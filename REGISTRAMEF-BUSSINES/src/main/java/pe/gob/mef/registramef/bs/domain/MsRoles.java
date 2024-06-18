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
 * MS_ROLES ENTIDAD: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_ROLES")
public class MsRoles implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4585744423501208111L;

	// ID
	private Long idrol = null;

	// PROPIEDADES
	private String username = null;
	private String rol = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressmodif = null;
	private Long estado = null;
	

	public MsRoles() {
	}

	@SequenceGenerator(name = "G_MS_ROLES", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_ROLES", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_ROLES")
@Id
@Column(name = "IDROL", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdrol()
{
		return this.idrol;
}

public void setIdrol(Long idrol)
{
		this.idrol = idrol;
}

@Column(name = "USERNAME", nullable = false, length = 50)
public String  getUsername()
{
		return this.username;
}

public void setUsername(String username)
{
		this.username = username;
}

@Column(name = "ROL", length = 100)
public String  getRol()
{
		return this.rol;
}

public void setRol(String rol)
{
		this.rol = rol;
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

@Column(name = "RTMADDRESS", length = 50)
public String  getRtmaddress()
{
		return this.rtmaddress;
}

public void setRtmaddress(String rtmaddress)
{
		this.rtmaddress = rtmaddress;
}

@Column(name = "RTMADDRESSMODIF", length = 50)
public String  getRtmaddressmodif()
{
		return this.rtmaddressmodif;
}

public void setRtmaddressmodif(String rtmaddressmodif)
{
		this.rtmaddressmodif = rtmaddressmodif;
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


			
}
