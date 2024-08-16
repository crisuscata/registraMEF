package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteAsistenciaDetallado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idAsistencia;
	private Date fechaAsistencia = null;
	private String modalidad = null;
	private String origen = null;
	private String programacion = null;
	private String financiamiento = null;
	private String codEjecutora = null;
	private String entidad = null;
	private String tipoEntidad = null;
	private String tema = null;
	private String subtema = null;
	// private String estadoTema=null;
	private String detalle = null;
	private String userCrea = null;
	private String sede = null;
	private String sistAdmin = null;
	private Timestamp fechaCrea = null;
	// private String estadoParti=null;
	private String participante = null;
	private String dni = null;
	private String cargo = null;
	private String correo = null;
	private String telefonoFijo = null;
	private String telefonoCelular = null;
	private String otroCelular = null;
	private String otroTelefono = null;
	private Timestamp fechaFinalizacion = null;
	private String estado = null;
	// private Long idEstado = null;
	private Long idAsistUsuext = null;

	// SPRINT_4 INICIO

	private String departamentoEnt = null;
	private String provinciaEnt = null;
	private String distritoEnt = null;

	private Date fechaReprog = null;

	private Date fechaSoli = null;// SPRINT01
	private String usuarioInterno = null;// SPRINT01

	private String controlConfirmacion_txt = null;// SPRINT02

	@Column(name = "FECHA_PROGRAMADA", length = 7)
	public Date getFechaReprog() {
		return fechaReprog;
	}

	public void setFechaReprog(Date fechaReprog) {
		this.fechaReprog = fechaReprog;
	}

	@Column(name = "DEPARTAMENTO_ENTIDAD", insertable = false, updatable = false)
	public String getDepartamentoEnt() {
		return departamentoEnt;
	}

	public void setDepartamentoEnt(String departamentoEnt) {
		this.departamentoEnt = departamentoEnt;
	}

	@Column(name = "PROVINCIA_ENTIDAD", insertable = false, updatable = false)
	public String getProvinciaEnt() {
		return provinciaEnt;
	}

	public void setProvinciaEnt(String provinciaEnt) {
		this.provinciaEnt = provinciaEnt;
	}

	@Column(name = "DISTRITO_ENTIDAD", insertable = false, updatable = false)
	public String getDistritoEnt() {
		return distritoEnt;
	}

	public void setDistritoEnt(String distritoEnt) {
		this.distritoEnt = distritoEnt;
	}

	// SPRINT_4 FIN

	public ReporteAsistenciaDetallado() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ID_ASISTENCIA", insertable = false, updatable = false)
	public Long getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	@Column(name = "FECHA_SERVICIO", length = 7)
	public Date getFechaAsistencia() {
		return fechaAsistencia;
	}

	public void setFechaAsistencia(Date fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}

	@Column(name = "MODALIDAD", insertable = false, updatable = false)
	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Column(name = "ORIGEN", insertable = false, updatable = false)
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Column(name = "PROGRAMACION", insertable = false, updatable = false)
	public String getProgramacion() {
		return programacion;
	}

	public void setProgramacion(String programacion) {
		this.programacion = programacion;
	}

	@Column(name = "FINANCIAMIENTO", insertable = false, updatable = false)
	public String getFinanciamiento() {
		return financiamiento;
	}

	public void setFinanciamiento(String financiamiento) {
		this.financiamiento = financiamiento;
	}

	@Column(name = "COD_EJECUTORA", insertable = false, updatable = false)
	public String getCodEjecutora() {
		return codEjecutora;
	}

	public void setCodEjecutora(String codEjecutora) {
		this.codEjecutora = codEjecutora;
	}

	@Column(name = "ENTIDAD", insertable = false, updatable = false)
	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	@Column(name = "TIPO_ENTIDAD", insertable = false, updatable = false)
	public String getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	@Column(name = "TEMA", insertable = false, updatable = false)
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Column(name = "SUBTEMA", insertable = false, updatable = false)
	public String getSubtema() {
		return subtema;
	}

	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}

	// @Column(name = "ESTADO_TEMA", insertable=false, updatable=false)
	// public String getEstadoTema() {
	// return estadoTema;
	// }
	//
	//
	//
	// public void setEstadoTema(String estadoTema) {
	// this.estadoTema = estadoTema;
	// }

	@Column(name = "DETALLE", insertable = false, updatable = false)
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Column(name = "USUARIO_CREA", insertable = false, updatable = false)
	public String getUserCrea() {
		return userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}

	@Column(name = "SEDE", insertable = false, updatable = false)
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@Column(name = "SIST_ADMIN", insertable = false, updatable = false)
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

	// @Column(name = "ESTADO_PARTI", insertable=false, updatable=false)
	// public String getEstadoParti() {
	// return estadoParti;
	// }
	//
	//
	//
	// public void setEstadoParti(String estadoParti) {
	// this.estadoParti = estadoParti;
	// }

	@Column(name = "PARTICIPANTE", insertable = false, updatable = false)
	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	@Column(name = "DNI", insertable = false, updatable = false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "CARGO", insertable = false, updatable = false)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Column(name = "CORREO", insertable = false, updatable = false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// @Column(name = "TELEFONO_FIJO", insertable=false, updatable=false)
	@Column(name = "OTRO_TELEFONO", insertable = false, updatable = false)
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	// @Column(name = "TELEFONO_CELULAR", insertable=false, updatable=false)
	@Column(name = "OTRO_CELULAR", insertable = false, updatable = false)
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	// @Column(name = "OTRO_CELULAR", insertable=false, updatable=false)
	@Column(name = "TELEFONO_CELULAR", insertable = false, updatable = false)
	public String getOtroCelular() {
		return otroCelular;
	}

	public void setOtroCelular(String otroCelular) {
		this.otroCelular = otroCelular;
	}

	// @Column(name = "OTRO_TELEFONO", insertable=false, updatable=false)
	@Column(name = "TELEFONO_FIJO", insertable = false, updatable = false)
	public String getOtroTelefono() {
		return otroTelefono;
	}

	public void setOtroTelefono(String otroTelefono) {
		this.otroTelefono = otroTelefono;
	}

	@Column(name = "FECHA_FINALIZACION", length = 7)
	public Timestamp getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	@Column(name = "ESTADO", insertable = false, updatable = false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// @Column(name = "ESTADO_1", insertable=false, updatable=false)
	// public Long getIdEstado() {
	// return idEstado;
	// }
	//
	//
	//
	// public void setIdEstado(Long idEstado) {
	// this.idEstado = idEstado;
	// }

	@Column(name = "ID_ASIST_USUEXT", insertable = false, updatable = false)
	public Long getIdAsistUsuext() {
		return idAsistUsuext;
	}

	public void setIdAsistUsuext(Long idAsistUsuext) {
		this.idAsistUsuext = idAsistUsuext;
	}

	// SPRINT01 INICIO
	@Column(name = "FECHA_SOLI", length = 7)
	public Date getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	@Column(name = "GEST_ESP_IMPL", insertable = false, updatable = false) // USUARIO
																			// INTERNO
	public String getUsuarioInterno() {
		return usuarioInterno;
	}

	public void setUsuarioInterno(String usuarioInterno) {
		this.usuarioInterno = usuarioInterno;
	}
	// SPRINT01 FIN

	// SPRINT02 INICIO
	@Column(name = "CTRL_CONFIRMACION", insertable = false, updatable = false) // USUARIO
																				// INTERNO
	public String getControlConfirmacion_txt() {
		return controlConfirmacion_txt;
	}

	public void setControlConfirmacion_txt(String controlConfirmacion_txt) {
		this.controlConfirmacion_txt = controlConfirmacion_txt;
	}
	// SPRINT02 FIN
}
