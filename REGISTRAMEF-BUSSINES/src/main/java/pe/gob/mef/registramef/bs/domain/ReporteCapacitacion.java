package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ReporteCapacitacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReporteCapacitacionId id;
	private Long idCapacitacion=null;
	private String nomEvento = null;
	private Timestamp fechaInic = null;
	private Timestamp fechaFin = null;
	private String origen  = null;
	private String modalidad  = null;
	private String programacion  = null;
	private String financiamiento  = null;
	private String local  = null;
	private Integer cantPartic = null;
	private Integer cantParticAsist = null;
	private String nivel  = null;
	private String prestacion  = null;
	private String tipo  = null;
	private String gestEspImpl  = null;
	private String sisAdmPonente  = null;
	private String tema  = null;
	private String subtema  = null;
	private String userCrea  = null;
	private String sede  = null;
	private String sistAdmin  = null;
	private Timestamp fechaCrea = null;
	private String estado  = null;
	private Long idCapaPadre = null;
	private Long idUsuExtern = null;
	private Long idCapaUsuext=null;
	private Long idCapaTemAgen=null;
	private String participante  = null;
	private String dni  = null;
	private String cargo  = null;
	private String codEjecut  = null;
	private String entidad  = null;
	
	
	
	
	public ReporteCapacitacion() {
	}


	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCapacitacion", column = @Column(name = "ID_CAPACITACION",  precision = 10, scale = 0)),
			@AttributeOverride(name = "idCapaTemAgen", column = @Column(name = "ID_CAPA_TEM_AGEN", precision = 10, scale = 0)),
			@AttributeOverride(name = "idCapaUsuext", column = @Column(name = "ID_CAPA_USUEXT", precision = 10, scale = 0)) })
	public ReporteCapacitacionId getId() {
		return this.id;
	}

	public void setId(ReporteCapacitacionId id) {
		this.id = id;
	}
	
//	@Id
//	@Column(name = "ID_CAPACITACION", unique = true, nullable = false, precision = 10, scale = 0)
	@Column(name = "ID_CAPACITACION", insertable=false, updatable=false)
	public Long getIdCapacitacion() {
		return idCapacitacion;
	}


	public void setIdCapacitacion(Long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	@Column(name = "NOM_EVENTO", length = 300)
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

	@Column(name = "ORIGEN", insertable=false, updatable=false)
	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Column(name = "MODO", insertable=false, updatable=false)
	public String getModalidad() {
		return modalidad;
	}


	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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

	@Column(name = "LOCAL", insertable=false, updatable=false)
	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}

	@Column(name = "CANT_PARTIC", precision = 5, scale = 0)
	public Integer getCantPartic() {
		return cantPartic;
	}


	public void setCantPartic(Integer cantPartic) {
		this.cantPartic = cantPartic;
	}

	@Column(name = "CANT_PARTIC_ASIST", precision = 5, scale = 0)
	public Integer getCantParticAsist() {
		return cantParticAsist;
	}


	public void setCantParticAsist(Integer cantParticAsist) {
		this.cantParticAsist = cantParticAsist;
	}

	@Column(name = "NIVEL", insertable=false, updatable=false)
	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Column(name = "PRESTACION", insertable=false, updatable=false)
	public String getPrestacion() {
		return prestacion;
	}


	public void setPrestacion(String prestacion) {
		this.prestacion = prestacion;
	}

	@Column(name = "TIPO", insertable=false, updatable=false)
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "GEST_ESP_IMPL", insertable=false, updatable=false)
	public String getGestEspImpl() {
		return gestEspImpl;
	}


	public void setGestEspImpl(String gestEspImpl) {
		this.gestEspImpl = gestEspImpl;
	}

	@Column(name = "SIST_ADMIN_PONENTE", insertable=false, updatable=false)
	public String getSisAdmPonente() {
		return sisAdmPonente;
	}


	public void setSisAdmPonente(String sisAdmPonente) {
		this.sisAdmPonente = sisAdmPonente;
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

	@Column(name = "SIST_ADMIN_CREA", insertable=false, updatable=false)
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

	@Column(name = "IDCAPA_PADRE", precision = 10, scale = 0)
	public Long getIdCapaPadre() {
		return idCapaPadre;
	}


	public void setIdCapaPadre(Long idCapaPadre) {
		this.idCapaPadre = idCapaPadre;
	}
	
	@Column(name = "ID_USUEXTERNO", insertable=false, updatable=false)
	public Long getIdUsuExtern() {
		return idUsuExtern;
	}

	public void setIdUsuExtern(Long idUsuExtern) {
		this.idUsuExtern = idUsuExtern;
	}
	
	@Column(name = "ID_CAPA_USUEXT", insertable=false, updatable=false)
	public Long getIdCapaUsuext() {
		return idCapaUsuext;
	}


	public void setIdCapaUsuext(Long idCapaUsuext) {
		this.idCapaUsuext = idCapaUsuext;
	}
	
	@Column(name = "ID_CAPA_TEM_AGEN", insertable=false, updatable=false)
	public Long getIdCapaTemAgen() {
		return idCapaTemAgen;
	}


	public void setIdCapaTemAgen(Long idCapaTemAgen) {
		this.idCapaTemAgen = idCapaTemAgen;
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

	@Column(name = "COD_EJECUTOR", insertable=false, updatable=false)
	public String getCodEjecut() {
		return codEjecut;
	}


	public void setCodEjecut(String codEjecut) {
		this.codEjecut = codEjecut;
	}

	@Column(name = "ENTIDAD", insertable=false, updatable=false)
	public String getEntidad() {
		return entidad;
	}


	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	


			
	
}
