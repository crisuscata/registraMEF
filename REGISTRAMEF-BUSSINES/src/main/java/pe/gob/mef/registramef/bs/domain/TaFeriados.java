package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TA_FERIADOS ENTIDAD: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *   /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
@Entity
@Table(name = "TA_FERIADOS")
public class TaFeriados implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5785970645216170828L;

	// ID
	private Timestamp feFecha = null;

	// PROPIEDADES
	private String feDesc = null;
	private Long feIdusu = null;
	private Timestamp feFchcrear = null;
	private Long feIdusumod = null;
	private Timestamp feFchmod = null;
	private Integer feEstado = null;
	

	public TaFeriados() {
	}

	@Id
@Column(name = "FE_FECHA", unique = true, nullable = false, length = 7)
public Timestamp  getFeFecha()
{
		return this.feFecha;
}

public void setFeFecha(Timestamp feFecha)
{
		this.feFecha = feFecha;
}

@Column(name = "FE_DESC", length = 255)
public String  getFeDesc()
{
		return this.feDesc;
}

public void setFeDesc(String feDesc)
{
		this.feDesc = feDesc;
}

@Column(name = "FE_IDUSU", nullable = false, precision = 10, scale = 0)
public Long  getFeIdusu()
{
		return this.feIdusu;
}

public void setFeIdusu(Long feIdusu)
{
		this.feIdusu = feIdusu;
}

@Column(name = "FE_FCHCREAR", nullable = false, length = 7)
public Timestamp  getFeFchcrear()
{
		return this.feFchcrear;
}

public void setFeFchcrear(Timestamp feFchcrear)
{
		this.feFchcrear = feFchcrear;
}

@Column(name = "FE_IDUSUMOD", nullable = false, precision = 10, scale = 0)
public Long  getFeIdusumod()
{
		return this.feIdusumod;
}

public void setFeIdusumod(Long feIdusumod)
{
		this.feIdusumod = feIdusumod;
}

@Column(name = "FE_FCHMOD", nullable = false, length = 7)
public Timestamp  getFeFchmod()
{
		return this.feFchmod;
}

public void setFeFchmod(Timestamp feFchmod)
{
		this.feFchmod = feFchmod;
}

@Column(name = "FE_ESTADO", nullable = false, precision = 1, scale = 0)
public Integer  getFeEstado()
{
		return this.feEstado;
}

public void setFeEstado(Integer feEstado)
{
		this.feEstado = feEstado;
}


			
}
