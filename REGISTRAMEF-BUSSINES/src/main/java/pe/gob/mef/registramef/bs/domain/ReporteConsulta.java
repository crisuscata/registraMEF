package pe.gob.mef.registramef.bs.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReporteConsulta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idConsulta;
	private String entidad = null;
	private String ejecutora = null;
	private Date fechaConsu = null;
	private String modalidad = null;
	private String tema = null;
	private String subtema = null;
	private String respuesta = null;
	private String estado = null;
	private String userCrea = null;
	private Timestamp fechaCrea = null;
	private String sede = null;
	private String sistAdmin = null;
	private String participante = null;
	private String dni = null;
	private String cargo = null;
	private String correo = null;
	
	//SPRINT22 INICIO
	private String telefonoFijo=null;
	private String telefonoCelular=null;
	private String otroCelular=null;
	private String otroTelefono=null;	
	private Timestamp fechaFinalizacion = null;
	//SPRINT22 FIN
	
	//SPRINT_4 INICIO
	private String departamentoEnt=null;
	private String provinciaEnt=null;
	private String distritoEnt=null;
	
	private Date fechaSoli = null;//SPRINT01
	
	
	@Column(name = "DEPARTAMENTO_ENTIDAD", insertable=false, updatable=false)
	public String getDepartamentoEnt() {
		return departamentoEnt;
	}


	public void setDepartamentoEnt(String departamentoEnt) {
		this.departamentoEnt = departamentoEnt;
	}

	@Column(name = "PROVINCIA_ENTIDAD", insertable=false, updatable=false)
	public String getProvinciaEnt() {
		return provinciaEnt;
	}


	public void setProvinciaEnt(String provinciaEnt) {
		this.provinciaEnt = provinciaEnt;
	}

	@Column(name = "DISTRITO_ENTIDAD", insertable=false, updatable=false)
	public String getDistritoEnt() {
		return distritoEnt;
	}


	public void setDistritoEnt(String distritoEnt) {
		this.distritoEnt = distritoEnt;
	}
	
	//SPRINT_4 FIN

	public ReporteConsulta() {
	}

	@Id
	@Column(name = "ID_CONSULTA", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	@Column(name = "ENTIDAD", insertable=false, updatable=false)
	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	@Column(name = "EJECUTORA", insertable=false, updatable=false)
	public String getEjecutora() {
		return ejecutora;
	}

	public void setEjecutora(String ejecutora) {
		this.ejecutora = ejecutora;
	}

	@Column(name = "FECHA_CONSU", length = 7)
	public Date getFechaConsu() {
		return fechaConsu;
	}

	public void setFechaConsu(Date fechaConsu) {
		this.fechaConsu = fechaConsu;
	}
	
	@Column(name = "MODALIDAD", insertable=false, updatable=false)
	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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
	
	@Column(name = "RESPUESTA", length = 500)
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	@Column(name = "ESTADO", insertable=false, updatable=false)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Column(name = "USUARIO_CREA", insertable=false, updatable=false)
	public String getUserCrea() {
		return userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}
	
	@Column(name = "FECHA_CREA", length = 7)
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	
//	@Column(name = "SEDE", insertable=false, updatable=false)
	@Column(name = "SEDE_CREA", insertable=false, updatable=false)  //SPRINT23
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
	
	//SPRINT22 INICIO

    
//   	@Column(name = "TELEFONO_FIJO", insertable=false, updatable=false)
	@Column(name = "OTRO_TELEFONO", insertable=false, updatable=false)
	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
//	@Column(name = "TELEFONO_CELULAR", insertable=false, updatable=false)
	@Column(name = "OTRO_CELULAR", insertable=false, updatable=false)
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
//	@Column(name = "OTRO_CELULAR", insertable=false, updatable=false)
	@Column(name = "TELEFONO_CELULAR", insertable=false, updatable=false)
	public String getOtroCelular() {
		return otroCelular;
	}

	public void setOtroCelular(String otroCelular) {
		this.otroCelular = otroCelular;
	}
//	@Column(name = "OTRO_TELEFONO", insertable=false, updatable=false)
	@Column(name = "TELEFONO_FIJO", insertable=false, updatable=false)
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
	
	//SPRINT22 FIN
	
	//SPRINT01 INICIO
	@Column(name = "FECHA_SOLI", length = 7)
	public Date getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSoli = fechaSoli;
	}	
	//SPRINT01  FIN


}
