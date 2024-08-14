package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ReporteAsistencia implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReporteAsistenciaId id;
	private Long idAsistencia;
	private Date fechaAsistencia = null;
	private String modalidad  = null;
	private String origen  = null;
	private String programacion  = null;
	private String financiamiento  = null;
	private String codEjecutora  = null;
	private String entidad  = null;
	private String tipoEntidad  = null;
	private String tema  = null;
	private String subtema  = null;
	private String detalle  = null;
	private Long id_asist_tema= null;
	private Long idAsistUsuext= null;
	private String userCrea  = null;
	private String sede  = null;
	private String sistAdmin  = null;
	private Timestamp fechaCrea = null;
	private String estado  = null;
	private String participante  = null;
	private String dni  = null;
	private String cargo  = null;
	private String correo  = null;
	
	
	public ReporteAsistencia() {
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idAsistencia", column = @Column(name = "ID_ASISTENCIA",  precision = 10, scale = 0)),
			@AttributeOverride(name = "id_asist_tema", column = @Column(name = "ID_ASIST_TEMA", precision = 10, scale = 0)),
			@AttributeOverride(name = "idAsistUsuext", column = @Column(name = "ID_ASIST_USUEXT", precision = 10, scale = 0)) })
	public ReporteAsistenciaId getId() {
		return id;
	}

	public void setId(ReporteAsistenciaId id) {
		this.id = id;
	}
	
//	@Id
//	@Column(name = "ID_ASISTENCIA", unique = true, nullable = false, precision = 10, scale = 0)
	@Column(name = "ID_ASISTENCIA", insertable=false, updatable=false)
	public Long getIdAsistencia() {
		return idAsistencia;
	}


	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	@Column(name = "FECHA_ASISTENCIA", length = 7)
	public Date getFechaAsistencia() {
		return fechaAsistencia;
	}


	public void setFechaAsistencia(Date fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}

	@Column(name = "MODALIDAD", insertable=false, updatable=false)
	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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

	@Column(name = "TEMA", insertable=false, updatable=false)
	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}

	@Column(name = "SUBTEMA", insertable=false, updatable=false)
	public String getSubtema() {
		return subtema;
	}


	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}
	
	@Column(name = "DETALLE", length = 300)
	public String getDetalle() {
		return detalle;
	}

	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Column(name = "ID_ASIST_TEMA", insertable=false, updatable=false)
	public Long getId_asist_tema() {
		return id_asist_tema;
	}

	public void setId_asist_tema(Long id_asist_tema) {
		this.id_asist_tema = id_asist_tema;
	}
	
	@Column(name = "ID_ASIST_USUEXT", insertable=false, updatable=false)
	public Long getIdAsistUsuext() {
		return idAsistUsuext;
	}

	public void setIdAsistUsuext(Long idAsistUsuext) {
		this.idAsistUsuext = idAsistUsuext;
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

	@Column(name = "SIST_ADMIN", insertable=false, updatable=false)
	public String getSistAdmin() {
		return sistAdmin;
	}


	public void setSistAdmin(String sistAdmin) {
		this.sistAdmin = sistAdmin;
	}

	@Column(name = "FECHA_CREA", length = 7)
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}


	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
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
