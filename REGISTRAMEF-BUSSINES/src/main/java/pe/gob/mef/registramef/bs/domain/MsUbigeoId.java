package pe.gob.mef.registramef.bs.domain;

import java.text.DecimalFormat;

// Generated 21/03/2012 11:09:32 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

@Embeddable
public class MsUbigeoId implements java.io.Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5677363054987380500L;
private Integer codDistr;
private Integer codDpto;
private Integer codProv;
public MsUbigeoId() {
	}
@Column(name = "COD_DISTR", nullable = false, precision = 2, scale = 0)
public Integer  getCodDistr()
{
		return this.codDistr;
}

public void setCodDistr(Integer codDistr)
{
		this.codDistr = codDistr;
}

@Column(name = "COD_DPTO", nullable = false, precision = 2, scale = 0)
public Integer  getCodDpto()
{
		return this.codDpto;
}

public void setCodDpto(Integer codDpto)
{
		this.codDpto = codDpto;
}

@Column(name = "COD_PROV", nullable = false, precision = 2, scale = 0)
public Integer  getCodProv()
{
		return this.codProv;
}

public void setCodProv(Integer codProv)
{
		this.codProv = codProv;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codDistr == null) ? 0 : codDistr.hashCode());
	result = prime * result + ((codDpto == null) ? 0 : codDpto.hashCode());
	result = prime * result + ((codProv == null) ? 0 : codProv.hashCode());
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
	MsUbigeoId other = (MsUbigeoId) obj;
	if (codDistr == null) {
		if (other.codDistr != null)
			return false;
	} else if (!codDistr.equals(other.codDistr))
		return false;
	if (codDpto == null) {
		if (other.codDpto != null)
			return false;
	} else if (!codDpto.equals(other.codDpto))
		return false;
	if (codProv == null) {
		if (other.codProv != null)
			return false;
	} else if (!codProv.equals(other.codProv))
		return false;
	return true;
}

@Override
public String toString() {
	DecimalFormat dcf = new DecimalFormat("00");
	String retorno = ""+ (codDpto==null?"00":dcf.format(codDpto.intValue())) + (codProv==null?"00":dcf.format(codProv.intValue())) + (codDistr==null?"00":dcf.format(codDistr.intValue()));
	return retorno;
}

}