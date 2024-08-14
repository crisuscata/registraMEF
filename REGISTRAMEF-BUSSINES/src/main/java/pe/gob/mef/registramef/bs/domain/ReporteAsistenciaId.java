package pe.gob.mef.registramef.bs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReporteAsistenciaId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072001731148935282L;
	private Long idAsistencia=null;
	private Long id_asist_tema=null;
	private Long idAsistUsuext=null;

	public ReporteAsistenciaId() {
	}

	public ReporteAsistenciaId(Long idAsistencia, Long id_asist_tema, Long idAsistUsuext) {
		this.idAsistencia = idAsistencia;
		this.id_asist_tema = id_asist_tema;
		this.idAsistUsuext = idAsistUsuext;
	}
	
	@Column(name = "ID_ASISTENCIA",  precision = 10, scale = 0)
	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	
	@Column(name = "ID_ASIST_TEMA", precision = 10, scale = 0)
	public Long getId_asist_tema() {
		return id_asist_tema;
	}

	public void setId_asist_tema(Long id_asist_tema) {
		this.id_asist_tema = id_asist_tema;
	}
	
	@Column(name = "ID_ASIST_USUEXT", precision = 10, scale = 0)
	public Long getIdAsistUsuext() {
		return idAsistUsuext;
	}

	public void setIdAsistUsuext(Long idAsistUsuext) {
		this.idAsistUsuext = idAsistUsuext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idAsistUsuext == null) ? 0 : idAsistUsuext.hashCode());
		result = prime * result
				+ ((idAsistencia == null) ? 0 : idAsistencia.hashCode());
		result = prime * result
				+ ((id_asist_tema == null) ? 0 : id_asist_tema.hashCode());
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
		ReporteAsistenciaId other = (ReporteAsistenciaId) obj;
		if (idAsistUsuext == null) {
			if (other.idAsistUsuext != null)
				return false;
		} else if (!idAsistUsuext.equals(other.idAsistUsuext))
			return false;
		if (idAsistencia == null) {
			if (other.idAsistencia != null)
				return false;
		} else if (!idAsistencia.equals(other.idAsistencia))
			return false;
		if (id_asist_tema == null) {
			if (other.id_asist_tema != null)
				return false;
		} else if (!id_asist_tema.equals(other.id_asist_tema))
			return false;
		return true;
	}


}
