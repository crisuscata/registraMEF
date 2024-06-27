package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//PURIBE 14032024 - INICIO-->
import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasACL;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuinternosBk;

/**
 * MSUSUARIOS BAKING: USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 09/05/2020 02:37
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/ 
 *          /Carlos Aguilar Chamochumbi /09/05/2020 02:37  / Creación de la clase /
 * 
 */
@XmlRootElement
public class DtVisitasJS implements java.io.Serializable {

	// ID
	private Long idVisita;

	// PROPIEDADES
	private Timestamp fechaVisita = null;
	private String conclusion = null;

	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	
	
	private Long idOrigen = null;
	private Long idProgramacion = null;
	private Long idModalidad = null;
	private Long idTipo = null;
	private Long estado = null; //PURIBE 01022024 - INICIO-->
	private Long idLugar = null;
	private Long idEntidad = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaProgramada = null;
	private Timestamp fechaReprogramada = null; //PURIBE 22042024 - INICIO-->
	
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	// ADICIONALES
	private String estadoTxt = null;
	private String idOrigenTxt = null;
	private String idProgramacionTxt = null;
	private String idModalidadTxt = null;
	private String idTipoTxt = null;
	private String idLugarTxt = null;
	private String idEntidadTxt = null;
	private String idSedeTxt = null;
	private String idSistAdmTxt = null;
	private String idFinanciaTxt = null;
	
	private Integer editopcion = 1;
	private int editentidad = 1;//PURIBE 04042024 - INICIO-->
	private Long idParticipante = null;
	private String idParticipanteTxt = null;
	
	private Long idDepartamento = null;
	private String idDepartamentoTxt = null;
	private String fechaProgramadaMostrar = null;
	private String codEjecutora = null;//puribe
	private Long idusuario = null;//puribe
	private boolean finalizar = false; //PURIBE 22042024 - INICIO-->
	private List<DtVisitasUsuinternosBk> visitaUsuarios;//puribe
	private List<DtVisitasUsuexternosBk> visitaUsuariosExterno; //JPUYEN 14052024
	private List<DtAnexosJS> dtAnexosJSss = null;//JPUYEN 14052024


	private DtVisitasACL dtVisitasACL = null;
	
	
	public DtVisitasJS() {
	}
	
	
	
	//PURIBE
	
	public List<DtVisitasUsuinternosBk> getVisitaUsuarios() {
		return visitaUsuarios;
	}



	public void setVisitaUsuarios(List<DtVisitasUsuinternosBk> visitaUsuarios) {
		this.visitaUsuarios = visitaUsuarios;
	}
	
	//PURIBE 04042024 - INICIO-->
		public int getEditentidad() {
			return editentidad;
		}

		public void setEditentidad(int editentidad) {
			this.editentidad = editentidad;
		}
		//PURIBE 04042024 - FIN->
	
	public String getCodEjecutora() {
		return codEjecutora;
	}

	public void setCodEjecutora(String codEjecutora) {
		this.codEjecutora = codEjecutora;
	}
	
	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	
	public Long getIdusserCrea() {
		return idusserCrea;
	}
	public void setIdusserCrea(Long idusserCrea) {
		this.idusserCrea = idusserCrea;
	}
	public Long getIdusserModif() {
		return idusserModif;
	}
	public void setIdusserModif(Long idusserModif) {
		this.idusserModif = idusserModif;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Timestamp getFechaModif() {
		return fechaModif;
	}
	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}
	public String getRtmaddress() {
		return rtmaddress;
	}
	public void setRtmaddress(String rtmaddress) {
		this.rtmaddress = rtmaddress;
	}
	public String getRtmaddressrst() {
		return rtmaddressrst;
	}
	public void setRtmaddressrst(String rtmaddressrst) {
		this.rtmaddressrst = rtmaddressrst;
	}
	public Long getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}
	public String getIdParticipanteTxt() {
		return idParticipanteTxt;
	}
	public void setIdParticipanteTxt(String idParticipanteTxt) {
		this.idParticipanteTxt = idParticipanteTxt;
	}
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getIdDepartamentoTxt() {
		return idDepartamentoTxt;
	}
	public void setIdDepartamentoTxt(String idDepartamentoTxt) {
		this.idDepartamentoTxt = idDepartamentoTxt;
	}
	public String getFechaProgramadaMostrar() {
		return fechaProgramadaMostrar;
	}
	public void setFechaProgramadaMostrar(String fechaProgramadaMostrar) {
		this.fechaProgramadaMostrar = fechaProgramadaMostrar;
	}
	public DtVisitasACL getDtVisitasACL() {
		return dtVisitasACL;
	}
	public void setDtVisitasACL(DtVisitasACL dtVisitasACL) {
		this.dtVisitasACL = dtVisitasACL;
	}
	//PURIBE
	
	
	
	//PURIBE 01022024 - INICIO-->
	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}
	//PURIBE 01022024 - FIN-->
	
	public Long getIdVisita() {
		return this.idVisita;
	}

	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	
	public Timestamp getFechaVisita() {
						return this.fechaVisita;
					}

	public void setFechaVisita(Timestamp fechaVisita) {
						this.fechaVisita = fechaVisita;
					}
	public String getConclusion() {
						return this.conclusion;
					}

	public void setConclusion(String conclusion) {
						this.conclusion = conclusion;
					}
	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
					}
	public Long getIdProgramacion() {
						return this.idProgramacion;
					}

	public void setIdProgramacion(Long idProgramacion) {
						this.idProgramacion = idProgramacion;
					}
	public Long getIdModalidad() {
						return this.idModalidad;
					}

	public void setIdModalidad(Long idModalidad) {
						this.idModalidad = idModalidad;
					}
	public Long getIdTipo() {
						return this.idTipo;
					}

	public void setIdTipo(Long idTipo) {
						this.idTipo = idTipo;
					}
	public Long getIdLugar() {
						return this.idLugar;
					}

	public void setIdLugar(Long idLugar) {
						this.idLugar = idLugar;
					}
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
					}
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	public Long getIdSistAdm() {
						return this.idSistAdm;
					}

	public void setIdSistAdm(Long idSistAdm) {
						this.idSistAdm = idSistAdm;
					}
	public Long getIdFinancia() {
						return this.idFinancia;
					}

	public void setIdFinancia(Long idFinancia) {
						this.idFinancia = idFinancia;
					}
	public Timestamp getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}
	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
	public java.util.Date getFechaFinalizacionJUD() {
		java.util.Date fechaFinalizacionJUD = null;
		if (fechaFinalizacion != null)
			fechaFinalizacionJUD = new java.util.Date(fechaFinalizacion.getTime());
		return fechaFinalizacionJUD;
	}
	public void setFechaFinalizacionJUD(java.util.Date fechaFinalizacionJUD) {
		if (fechaFinalizacionJUD != null)
			this.fechaFinalizacion = new Timestamp(fechaFinalizacionJUD.getTime());
		else
			this.fechaFinalizacion = null;
	}	
	public Timestamp getFechaProgramada() {
		return this.fechaProgramada;
	}
	public void setFechaProgramada(Timestamp fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public java.util.Date getFechaProgramadaJUD() {
		java.util.Date fechaProgramadaJUD = null;
		if (fechaProgramada != null)
			fechaProgramadaJUD = new java.util.Date(fechaProgramada.getTime());
		return fechaProgramadaJUD;
	}
	public void setFechaProgramadaJUD(java.util.Date fechaProgramadaJUD) {
		if (fechaProgramadaJUD != null)
			this.fechaProgramada = new Timestamp(fechaProgramadaJUD.getTime());
		else
			this.fechaProgramada = null;
	}	
	
	
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdProgramacionTxt() {
		return this.idProgramacionTxt;
	}
	public void setIdProgramacionTxt(String idProgramacionTxt) {
		this.idProgramacionTxt = idProgramacionTxt;
	}
	public String getIdModalidadTxt() {
		return this.idModalidadTxt;
	}
	public void setIdModalidadTxt(String idModalidadTxt) {
		this.idModalidadTxt = idModalidadTxt;
	}
	public String getIdTipoTxt() {
		return this.idTipoTxt;
	}
	public void setIdTipoTxt(String idTipoTxt) {
		this.idTipoTxt = idTipoTxt;
	}
	public String getIdLugarTxt() {
		return this.idLugarTxt;
	}
	public void setIdLugarTxt(String idLugarTxt) {
		this.idLugarTxt = idLugarTxt;
	}
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getIdSistAdmTxt() {
		return this.idSistAdmTxt;
	}
	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
	}
	public String getIdFinanciaTxt() {
		return this.idFinanciaTxt;
	}
	public void setIdFinanciaTxt(String idFinanciaTxt) {
		this.idFinanciaTxt = idFinanciaTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}	
	
	//PURIBE 22042024 - INICIO-->
		public Timestamp getFechaReprogramada() {
			return fechaReprogramada;
		}


		public void setFechaReprogramada(Timestamp fechaReprogramada) {
			this.fechaReprogramada = fechaReprogramada;
		}
		
		public boolean getFinalizar() {
			return finalizar;
		}


		public void setFinalizar(boolean finalizar) {
			this.finalizar = finalizar;
		}	
		
		//PURIBE 22042024 - FIN-->
		
		public List<DtVisitasUsuexternosBk> getVisitaUsuariosExterno() {
			return visitaUsuariosExterno;
		}



		public void setVisitaUsuariosExterno(List<DtVisitasUsuexternosBk> visitaUsuariosExterno) {
			this.visitaUsuariosExterno = visitaUsuariosExterno;
		}
		
		public List<DtAnexosJS> getDtAnexosJSss() {
			return dtAnexosJSss;
		}



		public void setDtAnexosJSss(List<DtAnexosJS> dtAnexosJSss) {
			this.dtAnexosJSss = dtAnexosJSss;
		}		
		
		
		
}
//PURIBE 14032024 - FIN-->