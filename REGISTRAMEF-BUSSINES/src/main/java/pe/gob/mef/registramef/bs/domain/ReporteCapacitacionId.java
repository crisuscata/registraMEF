package pe.gob.mef.registramef.bs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReporteCapacitacionId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072001731148935282L;
	private Long idCapacitacion=null;
	private Long idCapaTemAgen=null;
	private Long idCapaUsuext=null;

	public ReporteCapacitacionId() {
	}

	public ReporteCapacitacionId(Long idCapacitacion, Long idCapaUsuext, Long idCapaTemAgen) {
		this.idCapacitacion = idCapacitacion;
		this.idCapaTemAgen = idCapaTemAgen;
		this.idCapaUsuext = idCapaUsuext;
	}
	
	@Column(name = "ID_CAPACITACION",  precision = 10, scale = 0)
	public Long getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(Long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}
	
	@Column(name = "ID_CAPA_TEM_AGEN", precision = 10, scale = 0)
	public Long getIdCapaTemAgen() {
		return idCapaTemAgen;
	}

	public void setIdCapaTemAgen(Long idCapaTemAgen) {
		this.idCapaTemAgen = idCapaTemAgen;
	}
	
	@Column(name = "ID_CAPA_USUEXT", precision = 10, scale = 0)
	public Long getIdCapaUsuext() {
		return idCapaUsuext;
	}

	public void setIdCapaUsuext(Long idCapaUsuext) {
		if(idCapaUsuext==null){
			idCapaUsuext=0L;
		}
		this.idCapaUsuext = idCapaUsuext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCapaTemAgen == null) ? 0 : idCapaTemAgen.hashCode());
		result = prime * result
				+ ((idCapaUsuext == null) ? 0 : idCapaUsuext.hashCode());
		result = prime * result
				+ ((idCapacitacion == null) ? 0 : idCapacitacion.hashCode());
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
		ReporteCapacitacionId other = (ReporteCapacitacionId) obj;
		if (idCapaTemAgen == null) {
			if (other.idCapaTemAgen != null)
				return false;
		} else if (!idCapaTemAgen.equals(other.idCapaTemAgen))
			return false;
		if (idCapaUsuext == null) {
			if (other.idCapaUsuext != null)
				return false;
		} else if (!idCapaUsuext.equals(other.idCapaUsuext))
			return false;
		if (idCapacitacion == null) {
			if (other.idCapacitacion != null)
				return false;
		} else if (!idCapacitacion.equals(other.idCapacitacion))
			return false;
		return true;
	}
	
	

//	public boolean equals(Object other) {
//		if ((this == other))
//			return true;
//		if ((other == null))
//			return false;
//		if (!(other instanceof ReporteCapacitacionId))
//			return false;
//		ReporteCapacitacionId castOther = (ReporteCapacitacionId) other;
//
//		return ((this.getIdCapacitacion() == castOther.getIdCapacitacion()) || (this
//				.getIdCapacitacion() != null && castOther.getIdCapacitacion() != null && this
//				.getIdCapacitacion().equals(castOther.getIdCapacitacion())))
//				&& ((this.getIdCapaTemAgen() == castOther.getIdCapaTemAgen()) || (this
//						.getIdCapaTemAgen() != null
//						&& castOther.getIdCapaTemAgen() != null && this
//						.getIdCapaTemAgen().equals(castOther.getIdCapaTemAgen())))
//				&& ((this.getIdCapaUsuext() == castOther.getIdCapaUsuext()) || (this
//						.getIdCapaUsuext() != null
//						&& castOther.getIdCapaUsuext() != null && this
//						.getIdCapaUsuext().equals(castOther.getIdCapaUsuext())));
//	}
//
//	public int hashCode() {
//		int result = 17;
//
//		result = 37 * result
//				+ (getIdCapacitacion() == null ? 0 : this.getIdCapacitacion().hashCode());
//		result = 37	* result
//				+ (getIdCapaTemAgen() == null ? 0 : this.getIdCapaTemAgen().hashCode());
//		result = 37	* result
//				+ (getIdCapaUsuext() == null ? 0 : this.getIdCapaUsuext().hashCode());
//		return result;
//	}
}
