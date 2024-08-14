package pe.gob.mef.registramef.bs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReporteVisitaId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072001731148935282L;
	private Long idVisita=null;
	private Long idVisitUsuint=null;
	private Long idVisitUsuext=null;

	public ReporteVisitaId() {
	}

	public ReporteVisitaId(Long idVisita, Long idVisitUsuint, Long idVisitUsuext) {
		this.idVisita = idVisita;
		this.idVisitUsuint = idVisitUsuint;
		this.idVisitUsuext = idVisitUsuext;
	}
	
	@Column(name = "ID_VISITA",  precision = 10, scale = 0)
	public Long getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	
	@Column(name = "ID_VISIT_USUINT", precision = 10, scale = 0)
	public Long getIdVisitUsuint() {
		return idVisitUsuint;
	}
	
	public void setIdVisitUsuint(Long idVisitUsuint) {
		this.idVisitUsuint = idVisitUsuint;
	}
	
	@Column(name = "ID_VISIT_USUEXT", precision = 10, scale = 0)
	public Long getIdVisitUsuext() {
		return idVisitUsuext;
	}

	public void setIdVisitUsuext(Long idVisitUsuext) {
		this.idVisitUsuext = idVisitUsuext;
	}


	
}