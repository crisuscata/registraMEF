package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteCapacitacionDetallado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5691254162045246558L;
	/**
	 * 
	 */

	private Long id;
	private Long idCapacitacion = null;
	private String nomEvento = null;
	private Timestamp fechaInic = null;
	private Timestamp fechaFin = null;
	private String origen = null;
	private String modo = null;
	private String programacion = null;
	private String financiamiento = null;
	private String local = null;
	private Integer cantPartic = null;
	private Integer cantParticAsist = null;
	private String nivel = null;
	private String prestacion = null;
	private String tipo = null;
	private String gestEspImpl = null;
	private String sisAdmPonente = null;
	private String tema = null;
	private String subtema = null;
	// private String estadoTema = null;
	private String userCrea = null;
	private String sede = null;
	private Long idSistAdmin = null;
	private String sistAdmin = null;
	private String abreviaturaAdmin = null;
	private Timestamp fechaCrea = null;
	private String estado = null;
	// private Integer idEstado = null;
	private Long idCapaPadre = null;
	private String participante = null;
	private String dni = null;
	private String cargo = null;
	private String telefonoFijo = null;
	private String telefonoCelular = null;
	private String otroCelular = null;
	private String otroTelefono = null;
	private String entidad = null;
	private String codEjecut = null;
	private Long idUsuExtern = null;
	private String correoParti = null;
	private String asitio = null;
	private String confirmar = null;
	// private String inscripcionVirtual = null;
	private String enlaceConeVirtual = null;
	private String publicado = null;
	private String modalidad = null;
	private Timestamp fechaFinalizacion = null;
	// private String estadoParti = null;

	// sprint_4 inicio
	private String departamentoEnt = null;
	private String provinciaEnt = null;
	private String distritoEnt = null;

	private Timestamp fechaInicRepro = null;
	private Timestamp fechaFinRepro = null;

	private Date fechaSoli = null;// SPRINT01

	// SPRINT02 INICIO
	private String hojaRuta;
	private String modalidadIng;
	private String motivoEjecucion;
	private String flagEjecucion;
	// SPRINT02 FIN
	
	private String monthYear;
	private Integer totalParticipants;
	private Integer totalEvents;
	
	private Integer totalVirtual;
	private Integer totalPresencial;

	@Column(name = "FECHA_INI_PROGRAMADA", length = 7)
	public Timestamp getFechaInicRepro() {
		return fechaInicRepro;
	}

	public void setFechaInicRepro(Timestamp fechaInicRepro) {
		this.fechaInicRepro = fechaInicRepro;
	}

	@Column(name = "FECHA_FIN_PROGRAMADA", length = 7)
	public Timestamp getFechaFinRepro() {
		return fechaFinRepro;
	}

	public void setFechaFinRepro(Timestamp fechaFinRepro) {
		this.fechaFinRepro = fechaFinRepro;
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

	public ReporteCapacitacionDetallado() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ID_CAPACITACION", insertable = false, updatable = false)
	public Long getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(Long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	@Column(name = "NOM_EVENTO", insertable = false, updatable = false)
	public String getNomEvento() {
		return nomEvento;
	}

	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}

	@Column(name = "FECHA_INIC", length = 7)
	public Timestamp getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(Timestamp fechaInic) {
		this.fechaInic = fechaInic;
	}

	@Column(name = "FECHA_FIN", length = 7)
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "ORIGEN", insertable = false, updatable = false)
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Column(name = "MODO", insertable = false, updatable = false)
	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
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

	@Column(name = "LOCAL", insertable = false, updatable = false)
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name = "PARTIC_PROGRAMADOS", insertable = false, updatable = false)
	public Integer getCantPartic() {
		return cantPartic;
	}

	public void setCantPartic(Integer cantPartic) {
		this.cantPartic = cantPartic;
	}

	@Column(name = "PARTIC_ASISTENTES", insertable = false, updatable = false)
	public Integer getCantParticAsist() {
		return cantParticAsist;
	}

	public void setCantParticAsist(Integer cantParticAsist) {
		this.cantParticAsist = cantParticAsist;
	}

	@Column(name = "NIVEL", insertable = false, updatable = false)
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Column(name = "PRESTACION", insertable = false, updatable = false)
	public String getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(String prestacion) {
		this.prestacion = prestacion;
	}

	@Column(name = "TIPO", insertable = false, updatable = false)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "GEST_ESP_IMPL", insertable = false, updatable = false)
	public String getGestEspImpl() {
		return gestEspImpl;
	}

	public void setGestEspImpl(String gestEspImpl) {
		this.gestEspImpl = gestEspImpl;
	}

	@Column(name = "SIST_ADMIN_PONENTE", insertable = false, updatable = false)
	public String getSisAdmPonente() {
		return sisAdmPonente;
	}

	public void setSisAdmPonente(String sisAdmPonente) {
		this.sisAdmPonente = sisAdmPonente;
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
	// public void setEstadoTema(String estadoTema) {
	// this.estadoTema = estadoTema;
	// }
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

	@Column(name = "SIST_ADMIN_CREA", insertable = false, updatable = false)
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

	@Column(name = "ESTADO", insertable = false, updatable = false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// @Column(name = "ESTADO_ID", insertable=false, updatable=false)
	// public Integer getIdEstado() {
	// return idEstado;
	// }
	//
	// public void setIdEstado(Integer idEstado) {
	// this.idEstado = idEstado;
	// }
	@Column(name = "IDCAPA_PADRE", insertable = false, updatable = false)
	public Long getIdCapaPadre() {
		return idCapaPadre;
	}

	public void setIdCapaPadre(Long idCapaPadre) {
		this.idCapaPadre = idCapaPadre;
	}

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

	@Column(name = "ENTIDAD", insertable = false, updatable = false)
	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	@Column(name = "CODIGO_EJECUTORA", insertable = false, updatable = false)
	public String getCodEjecut() {
		return codEjecut;
	}

	public void setCodEjecut(String codEjecut) {
		this.codEjecut = codEjecut;
	}

	@Column(name = "ID_USUEXTERNO", insertable = false, updatable = false)
	public Long getIdUsuExtern() {
		return idUsuExtern;
	}

	public void setIdUsuExtern(Long idUsuExtern) {
		this.idUsuExtern = idUsuExtern;
	}

	@Column(name = "CORREO_PARTICIPANTE", insertable = false, updatable = false)
	public String getCorreoParti() {
		return correoParti;
	}

	public void setCorreoParti(String correoParti) {
		this.correoParti = correoParti;
	}

	@Column(name = "ASISTIO", insertable = false, updatable = false)
	public String getAsitio() {
		return asitio;
	}

	public void setAsitio(String asitio) {
		this.asitio = asitio;
	}

	@Column(name = "CONFIRMAR", insertable = false, updatable = false)
	public String getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(String confirmar) {
		this.confirmar = confirmar;
	}

	// @Column(name = "INSCRIPCION_VIRTUAL", insertable=false, updatable=false)
	// public String getInscripcionVirtual() {
	// return inscripcionVirtual;
	// }
	//
	// public void setInscripcionVirtual(String inscripcionVirtual) {
	// this.inscripcionVirtual = inscripcionVirtual;
	// }
	@Column(name = "ENLACE_CONECCION_VIRTUAL", insertable = false, updatable = false)
	public String getEnlaceConeVirtual() {
		return enlaceConeVirtual;
	}

	public void setEnlaceConeVirtual(String enlaceConeVirtual) {
		this.enlaceConeVirtual = enlaceConeVirtual;
	}

	@Column(name = "PUBLICADO", insertable = false, updatable = false)
	public String getPublicado() {
		return publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

	@Column(name = "MODALIDAD", insertable = false, updatable = false)
	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Column(name = "FECHA_FINALIZACION", length = 7)
	public Timestamp getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	// @Column(name = "ESTADO_PARTI", insertable=false, updatable=false)
	// public String getEstadoParti() {
	// return estadoParti;
	// }
	//
	// public void setEstadoParti(String estadoParti) {
	// this.estadoParti = estadoParti;
	// }

	// SPRINT01 INICIO
	@Column(name = "FECHA_SOLI", length = 7)
	public Date getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	// SPRINT01 FIN
	// SPRINT02 INICIO
	@Column(name = "HOJA_RUTA", insertable = false, updatable = false)
	public String getHojaRuta() {
		return hojaRuta;
	}

	public void setHojaRuta(String hojaRuta) {
		this.hojaRuta = hojaRuta;
	}

	@Column(name = "MODALIDAD_INGRESO", insertable = false, updatable = false)
	public String getModalidadIng() {
		return modalidadIng;
	}

	public void setModalidadIng(String modalidadIng) {
		this.modalidadIng = modalidadIng;
	}

	@Column(name = "MOTIVO", insertable = false, updatable = false)
	public String getMotivoEjecucion() {
		return motivoEjecucion;
	}

	public void setMotivoEjecucion(String motivoEjecucion) {
		this.motivoEjecucion = motivoEjecucion;
	}

	@Column(name = "FLAG_EJEC", insertable = false, updatable = false)
	public String getFlagEjecucion() {
		return flagEjecucion;
	}

	public void setFlagEjecucion(String flagEjecucion) {
		this.flagEjecucion = flagEjecucion;
	}
	// SPRINT02 FIN
	
	@Column(name = "ID_SIST_ADMI", insertable = false, updatable = false)
	public Long getIdSistAdmin() {
		return idSistAdmin;
	}

	public void setIdSistAdmin(Long idSistAdmin) {
		this.idSistAdmin = idSistAdmin;
	}

	@Column(name = "SIST_ADMIN_ABREVIATURA", insertable = false, updatable = false)
	public String getAbreviaturaAdmin() {
		return abreviaturaAdmin;
	}

	public void setAbreviaturaAdmin(String abreviaturaAdmin) {
		this.abreviaturaAdmin = abreviaturaAdmin;
	}

	@Column(name = "MONTH_YEAR", insertable = false, updatable = false)
	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	@Column(name = "TOTAL_PARTICIPANTS", insertable = false, updatable = false)
	public Integer getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	@Column(name = "TOTAL_EVENTS", insertable = false, updatable = false)
	public Integer getTotalEvents() {
		return totalEvents;
	}

	public void setTotalEvents(Integer totalEvents) {
		this.totalEvents = totalEvents;
	}

	@Column(name = "TOTAL_VIRTUAL", insertable = false, updatable = false)
	public Integer getTotalVirtual() {
		return totalVirtual;
	}

	public void setTotalVirtual(Integer totalVirtual) {
		this.totalVirtual = totalVirtual;
	}

	@Column(name = "TOTAL_PRESENCIAL", insertable = false, updatable = false)
	public Integer getTotalPresencial() {
		return totalPresencial;
	}

	public void setTotalPresencial(Integer totalPresencial) {
		this.totalPresencial = totalPresencial;
	}
}
