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
 * DT_CARGOS_USUEXTER ENTIDAD: ALMACENA LOS CARGOS DE LOS USUARIOS EXTERNOS "CARGO DE USUARIO EXTERNO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "DT_CARGOS_USUEXTER")
public class DtCargosUsuexter implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3383062250540789718L;

	// ID
	private Long idCargoUsuexter = null;

	// PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Long idUsuextEnti = null;
	private Long idCargo = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public DtCargosUsuexter() {
	}

	@SequenceGenerator(name = "G_DT_CARGOS_USUEXTER", sequenceName = PropertiesMg.ESQUEMA + "SQ_DT_CARGOS_USUEXTER", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_DT_CARGOS_USUEXTER")
@Id
@Column(name = "ID_CARGO_USUEXTER", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdCargoUsuexter()
{
		return this.idCargoUsuexter;
}

public void setIdCargoUsuexter(Long idCargoUsuexter)
{
		this.idCargoUsuexter = idCargoUsuexter;
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

@Column(name = "ID_USUEXT_ENTI", precision = 10, scale = 0)
public Long  getIdUsuextEnti()
{
		return this.idUsuextEnti;
}

public void setIdUsuextEnti(Long idUsuextEnti)
{
		this.idUsuextEnti = idUsuextEnti;
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
