package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MS_UBIGEO ENTIDAD: ALMACENA EL UBIGEO(DEPARTAMENTO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_UBIGEO")
public class MsUbigeo implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3876359391646298708L;

	// ID
	private MsUbigeoId id = null;

	// PROPIEDADES
	private String descripcion = null;
	private Long idusserCrea = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idusserModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idubigeo = null;
	

	public MsUbigeo() {
	}

	@EmbeddedId
@AttributeOverrides({
@AttributeOverride(name = "codDistr", column = @Column(name = "COD_DISTR", nullable = false, precision = 2, scale = 0)),
@AttributeOverride(name = "codDpto", column = @Column(name = "COD_DPTO", nullable = false, precision = 2, scale = 0)),
@AttributeOverride(name = "codProv", column = @Column(name = "COD_PROV", nullable = false, precision = 2, scale = 0))
})public MsUbigeoId  getId()
{
		return this.id;
}

public void setId(MsUbigeoId id)
{
		this.id = id;
}

@Column(name = "DESCRIPCION", length = 50)
public String  getDescripcion()
{
		return this.descripcion;
}

public void setDescripcion(String descripcion)
{
		this.descripcion = descripcion;
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

@Column(name = "IDUBIGEO", precision = 10, scale = 0)
public Long  getIdubigeo()
{
		return this.idubigeo;
}

public void setIdubigeo(Long idubigeo)
{
		this.idubigeo = idubigeo;
}


}	