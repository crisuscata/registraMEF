package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ReporteVisita implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReporteVisitaId id;
	private Long idVisita;
	private String codEjecutora  = null;
	private String entidad  = null;
	private String tipoEntidad  = null;
	private String geoZona  = null;
	private Date fechaVisita = null;
	private String lugarReu  = null;
	private String origen  = null;
	private String programacion  = null;
	private String financiamiento  = null;
	private String gestEspImp  = null;
	private String sistAdminCrea  = null;
	private String sistAdminGestor  = null;
	private String tema  = null;
	private String userCrea  = null;
	private String sede  = null;
	private Timestamp fechaCrea = null;
	private Long idVisitUsuint= null;
	private Long idVisitUsuext= null;
	private String estado  = null;
	private String participante  = null;
	private String dni  = null;
	private String cargo  = null;
	private String correo  = null;
	
	public ReporteVisita() {
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idVisita", column = @Column(name = "ID_VISITA",  precision = 10, scale = 0)),
			@AttributeOverride(name = "idVisitUsuint", column = @Column(name = "ID_VISIT_USUINT", precision = 10, scale = 0)),
			@AttributeOverride(name = "idVisitUsuext", column = @Column(name = "ID_VISIT_USUEXT", precision = 10, scale = 0)) })
	public ReporteVisitaId getId() {
		return id;
	}

	public void setId(ReporteVisitaId id) {
		this.id = id;
	}
	
//	@Id
//	@Column(name = "ID_VISITA", unique = true, nullable = false, precision = 10, scale = 0)
	@Column(name = "ID_VISITA", insertable=false, updatable=false)
	public Long getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	
	@Column(name = "COD_EJECUTORA", insertable=false, updatable=false)
	public String getCodEjecutora() {
		return codEjecutora;
	}

	public void setCodEjecutora(String codEjecutora) {
		this.codEjecutora = codEjecutora;
	}
	
	@Column(name = "ENTIDAD", insertable=false, updatable=false)
	public String getEntidad() {
		return entidad;
	}
	
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	@Column(name = "TIPO_ENTIDAD", insertable=false, updatable=false)
	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	
	@Column(name = "GEOZONA", insertable=false, updatable=false)
	public String getGeoZona() {
		return geoZona;
	}

	public void setGeoZona(String geoZona) {
		this.geoZona = geoZona;
	}
	
	@Column(name = "FECHA_VISITA", length = 7)
	public Date getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(Date fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
	
	@Column(name = "LUGAR_REU", insertable=false, updatable=false)
	public String getLugarReu() {
		return lugarReu;
	}

	public void setLugarReu(String lugarReu) {
		this.lugarReu = lugarReu;
	}
	
	@Column(name = "ORIGEN", insertable=false, updatable=false)
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	@Column(name = "PROGRAMACION", insertable=false, updatable=false)
	public String getProgramacion() {
		return programacion;
	}

	public void setProgramacion(String programacion) {
		this.programacion = programacion;
	}
	
	@Column(name = "FINANCIAMIENTO", insertable=false, updatable=false)
	public String getFinanciamiento() {
		return financiamiento;
	}

	public void setFinanciamiento(String financiamiento) {
		this.financiamiento = financiamiento;
	}
	
	@Column(name = "GESTOR_ESP_IMPLAN", insertable=false, updatable=false)
	public String getGestEspImp() {
		return gestEspImp;
	}

	public void setGestEspImp(String gestEspImp) {
		this.gestEspImp = gestEspImp;
	}
	
	@Column(name = "SIST_ADMIN_CREA", insertable=false, updatable=false)
	public String getSistAdminCrea() {
		return sistAdminCrea;
	}

	public void setSistAdminCrea(String sistAdminCrea) {
		this.sistAdminCrea = sistAdminCrea;
	}
	
	@Column(name = "SIST_ADMIN_GEST", insertable=false, updatable=false)
	public String getSistAdminGestor() {
		return sistAdminGestor;
	}

	public void setSistAdminGestor(String sistAdminGestor) {
		this.sistAdminGestor = sistAdminGestor;
	}
	
	@Column(name = "TEMA", insertable=false, updatable=false)
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	@Column(name = "USUARIO_CREA", insertable=false, updatable=false)
	public String getUserCrea() {
		return userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}
	
	@Column(name = "SEDE", insertable=false, updatable=false)
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	@Column(name = "FECHA_CREA", length = 7)
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	
	@Column(name = "ID_VISIT_USUINT", insertable=false, updatable=false)
	public Long getIdVisitUsuint() {
		return idVisitUsuint;
	}

	public void setIdVisitUsuint(Long idVisitUsuint) {
		this.idVisitUsuint = idVisitUsuint;
	}
	
	@Column(name = "ID_VISIT_USUEXT", insertable=false, updatable=false)
	public Long getIdVisitUsuext() {
		return idVisitUsuext;
	}

	public void setIdVisitUsuext(Long idVisitUsuext) {
		this.idVisitUsuext = idVisitUsuext;
	}
	
	@Column(name = "ESTADO", insertable=false, updatable=false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "PARTICIPANTE", insertable=false, updatable=false)
	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}
	
	@Column(name = "DNI", insertable=false, updatable=false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Column(name = "CARGO", insertable=false, updatable=false)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Column(name = "CORREO", insertable=false, updatable=false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
			
	
}
