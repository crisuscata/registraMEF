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
 * MS_INDICADOR ENTIDAD: ALMACENA LOS INDICADORES REGISTRADOS EN EL SISTEMA "INDICADORES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "MS_INDICADOR")
public class MsIndicador implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6424674376461439369L;

	// ID
	private Long idIndicador = null;

	// PROPIEDADES
	private String descripcion = null;
	private String formula = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idObjetvo = null;
	private Long idNivlstrat = null;
	private Long idFactor = null;
	private Long idFuenteinfor = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	

	public MsIndicador() {
	}

	@SequenceGenerator(name = "G_MS_INDICADOR", sequenceName = PropertiesMg.ESQUEMA + "SQ_MS_INDICADOR", allocationSize = 1)
@GeneratedValue(strategy = SEQUENCE, generator = "G_MS_INDICADOR")
@Id
@Column(name = "ID_INDICADOR", unique = true, nullable = false, precision = 10, scale = 0)
public Long  getIdIndicador()
{
		return this.idIndicador;
}

public void setIdIndicador(Long idIndicador)
{
		this.idIndicador = idIndicador;
}

@Column(name = "DESCRIPCION", length = 500)
public String  getDescripcion()
{
		return this.descripcion;
}

public void setDescripcion(String descripcion)
{
		this.descripcion = descripcion;
}

@Column(name = "FORMULA", length = 500)
public String  getFormula()
{
		return this.formula;
}

public void setFormula(String formula)
{
		this.formula = formula;
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

@Column(name = "ID_OBJETVO", precision = 10, scale = 0)
public Long  getIdObjetvo()
{
		return this.idObjetvo;
}

public void setIdObjetvo(Long idObjetvo)
{
		this.idObjetvo = idObjetvo;
}

@Column(name = "ID_NIVLSTRAT", precision = 10, scale = 0)
public Long  getIdNivlstrat()
{
		return this.idNivlstrat;
}

public void setIdNivlstrat(Long idNivlstrat)
{
		this.idNivlstrat = idNivlstrat;
}

@Column(name = "ID_FACTOR", precision = 10, scale = 0)
public Long  getIdFactor()
{
		return this.idFactor;
}

public void setIdFactor(Long idFactor)
{
		this.idFactor = idFactor;
}

@Column(name = "ID_FUENTEINFOR", precision = 10, scale = 0)
public Long  getIdFuenteinfor()
{
		return this.idFuenteinfor;
}

public void setIdFuenteinfor(Long idFuenteinfor)
{
		this.idFuenteinfor = idFuenteinfor;
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
