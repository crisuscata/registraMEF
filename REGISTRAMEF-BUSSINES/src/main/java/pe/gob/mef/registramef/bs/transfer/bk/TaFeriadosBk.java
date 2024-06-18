package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.TaFeriadosACL;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * TA_FERIADOS BAKING: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL
 * AÑO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27 / Creación de la clase
 *          /
 * 
 */
public class TaFeriadosBk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -961199719952504214L;

	// ID
	private Timestamp feFecha;

	// PROPIEDADES
	private String feDesc = null;
	private Timestamp feFchmod = null;
	private Timestamp feFchcrear = null;
	private Integer feEstado = null;
	private Long feIdusu = null;
	private Long feIdusumod = null;

	// ADICIONALES
	private String feEstadoTxt = null;

	private TaFeriadosACL taFeriadosACL = null;

	public TaFeriadosBk() {
	}

	public Timestamp getFeFecha() {
		return this.feFecha;
	}

	public void setFeFecha(Timestamp feFecha) {
		this.feFecha = feFecha;
	}

	public String getFeDesc() {
		return this.feDesc;
	}

	public void setFeDesc(String feDesc) {
		this.feDesc = feDesc;
	}

	public Timestamp getFeFchmod() {
		return this.feFchmod;
	}

	public void setFeFchmod(Timestamp feFchmod) {
		this.feFchmod = feFchmod;
	}

	public java.util.Date getFeFchmodJUD() {
		java.util.Date feFchmodJUD = null;
		if (feFchmod != null)
			feFchmodJUD = new java.util.Date(feFchmod.getTime());
		return feFchmodJUD;
	}

	public void setFeFchmodJUD(java.util.Date feFchmodJUD) {
		if (feFchmodJUD != null)
			this.feFchmod = new Timestamp(feFchmodJUD.getTime());
		else
			this.feFchmod = null;
	}

	public Timestamp getFeFchcrear() {
		return this.feFchcrear;
	}

	public void setFeFchcrear(Timestamp feFchcrear) {
		this.feFchcrear = feFchcrear;
	}

	public java.util.Date getFeFchcrearJUD() {
		java.util.Date feFchcrearJUD = null;
		if (feFchcrear != null)
			feFchcrearJUD = new java.util.Date(feFchcrear.getTime());
		return feFchcrearJUD;
	}

	public void setFeFchcrearJUD(java.util.Date feFchcrearJUD) {
		if (feFchcrearJUD != null)
			this.feFchcrear = new Timestamp(feFchcrearJUD.getTime());
		else
			this.feFchcrear = null;
	}

	public Integer getFeEstado() {
		return this.feEstado;
	}

	public void setFeEstado(Integer feEstado) {
		this.feEstado = feEstado;
	}

	public Long getFeIdusu() {
		return this.feIdusu;
	}

	public void setFeIdusu(Long feIdusu) {
		this.feIdusu = feIdusu;
	}

	public Long getFeIdusumod() {
		return this.feIdusumod;
	}

	public void setFeIdusumod(Long feIdusumod) {
		this.feIdusumod = feIdusumod;
	}

	public String getFeEstadoTxt() {
		if (feEstadoTxt==null && feEstado != null && feEstado.longValue() > Estado.ELIMINADO.getValor()) {
			feEstadoTxt="Activo";
		} else {
			if (feEstadoTxt==null && feEstado != null) 
				feEstadoTxt="Eliminado";
		}
		return this.feEstadoTxt;
	}

	public void setFeEstadoTxt(String feEstadoTxt) {
		this.feEstadoTxt = feEstadoTxt;
	}

	public TaFeriadosACL getTaFeriadosACL() {
		return taFeriadosACL;
	}

	public void setTaFeriadosACL(TaFeriadosACL taFeriadosACL) {
		this.taFeriadosACL = taFeriadosACL;
	}

	public String getCclase() {
		if (feEstado != null && feEstado.longValue() > Estado.ELIMINADO.getValor()) {
			return "cverde";
		} else {

		}
		return "camarillo";
	}

	public void setCclase(String cclase) {
	}

	public String getCestado() {
		if (feEstado != null && feEstado.longValue() > Estado.ELIMINADO.getValor()) {
			return "Activo";
		} else {
		}
		return "Eliminado";
	}

	public void setCestado(String cestado) {
	}

	public boolean getEsEliminado() {
		boolean retorno = false;
		if (feEstado != null && feEstado.longValue() == Estado.ELIMINADO.getValor()) {
			retorno = true;
		}
		return retorno;
	}

	public void setEsEliminado(boolean esEliminado) {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feFecha == null) ? 0 : feFecha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaFeriadosBk other = (TaFeriadosBk) obj;
		if (feFecha == null) {
			if (other.feFecha != null)
				return false;
		} else if (!feFecha.equals(other.feFecha))
			return false;
		return true;
	}

}
