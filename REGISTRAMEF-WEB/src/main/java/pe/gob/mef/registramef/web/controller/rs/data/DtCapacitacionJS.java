package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.transfer.bk.DtCapaEntidadesBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaPublicoBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaUsuexternosBk;//CUSCATA - 07082024
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;

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
public class DtCapacitacionJS implements java.io.Serializable {

	// ID
	private Long idCapacitacion;

	// PROPIEDADES
	private Timestamp fechaInic = null;
	private Timestamp fechaFin = null;
	private Integer cantPartic = null;
	private String publicObj = null;
	private String nomEvento = null;
	private String detalleCapa = null;
	private Long idLocal = null;
	private Long idUsuinterno = null;
	private Long idModo = null;
	private Long idNivel = null;
	private Long idOrigen = null;
	private Long idPrestacion = null;
	private Long idProgramacion = null;
	private Long estado = null;
	private Integer cantParticAsist = null;
	private Long idTipo = null;
	private Long idcapaPadre = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Long flagPubli = null;
	private Long idModalidad = null;
	private String detalleCapaVirtual = null;
	private Timestamp fechaIniProgramada = null;
	private Timestamp fechaFinProgramada = null;
	private Timestamp fechaSoli = null;
	private Long stdIddoc = null;
	private String stdNumeroSid = null;
	private Integer stdNumeroAnio = null;
	private String stdNumeroDoc = null;
	private String stdAsunto = null;
	private String stdTipoDoc = null;
	private String stdFechaRecepcion = null;
	private String stdModalidadIng = null;
	private Long flagEjec = null;
	private String motivoEjec = null;
	
	
	// ADICIONALES
	private String idLocalTxt = null;
	private String idUsuinternoTxt = null;
	private String estadoTxt = null;
	private String idModoTxt = null;
	private String idNivelTxt = null;
	private String idOrigenTxt = null;
	private String idPrestacionTxt = null;
	private String idProgramacionTxt = null;
	private String idTipoTxt = null;
	private String idSedeTxt = null;
	private String idSistAdmTxt = null;
	private String idFinanciaTxt = null;
	private String idModalidadTxt = null;
	
	private Integer editopcion = 1;
	
	//MPINARES 14022024 - INICIO
		private List<DtCapaTemasBk> dtCapaTemasBkJSss = null;
		private List<DtCapaEntidadesBk> dtCapaEntidadesBkJSss = null;
		private List<DtCapaPublicoBk> dtCapaPublicoBkJSss = null;
		private List<DtCapacitacionBk> dtCapaAcumulaListBkJSss = null;
		
		private List<DtCapaUsuexternosBk> dtCapacitacionUsuariosBkJSss = null;////CUSCATA - 07082024
		//MPINARES 14022024 - FIN
        private List<DtAnexosJS> tdAnexosJSss = null;//CUSCATA - 07082024
		private boolean addEntidad = false;

	public boolean isAddEntidad() {
			return addEntidad;
		}

		public void setAddEntidad(boolean addEntidad) {
			this.addEntidad = addEntidad;
		}

	public DtCapacitacionJS() {
	}

	public Long getIdCapacitacion() {
		return this.idCapacitacion;
	}

	public void setIdCapacitacion(Long idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}
	
	public Timestamp getFechaInic() {
		return this.fechaInic;
	}
	public void setFechaInic(Timestamp fechaInic) {
		this.fechaInic = fechaInic;
	}
	public java.util.Date getFechaInicJUD() {
		java.util.Date fechaInicJUD = null;
		if (fechaInic != null)
			fechaInicJUD = new java.util.Date(fechaInic.getTime());
		return fechaInicJUD;
	}
	public void setFechaInicJUD(java.util.Date fechaInicJUD) {
		if (fechaInicJUD != null)
			this.fechaInic = new Timestamp(fechaInicJUD.getTime());
		else
			this.fechaInic = null;
	}	
	public Timestamp getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public java.util.Date getFechaFinJUD() {
		java.util.Date fechaFinJUD = null;
		if (fechaFin != null)
			fechaFinJUD = new java.util.Date(fechaFin.getTime());
		return fechaFinJUD;
	}
	public void setFechaFinJUD(java.util.Date fechaFinJUD) {
		if (fechaFinJUD != null)
			this.fechaFin = new Timestamp(fechaFinJUD.getTime());
		else
			this.fechaFin = null;
	}	
	public Integer getCantPartic() {
						return this.cantPartic;
					}

	public void setCantPartic(Integer cantPartic) {
						this.cantPartic = cantPartic;
					}
	public String getPublicObj() {
						return this.publicObj;
					}

	public void setPublicObj(String publicObj) {
						this.publicObj = publicObj;
					}
	public String getNomEvento() {
						return this.nomEvento;
					}

	public void setNomEvento(String nomEvento) {
						this.nomEvento = nomEvento;
					}
	public String getDetalleCapa() {
						return this.detalleCapa;
					}

	public void setDetalleCapa(String detalleCapa) {
						this.detalleCapa = detalleCapa;
					}
	public Long getIdLocal() {
						return this.idLocal;
					}

	public void setIdLocal(Long idLocal) {
						this.idLocal = idLocal;
					}
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
					}
	public Long getIdModo() {
						return this.idModo;
					}

	public void setIdModo(Long idModo) {
						this.idModo = idModo;
					}
	public Long getIdNivel() {
						return this.idNivel;
					}

	public void setIdNivel(Long idNivel) {
						this.idNivel = idNivel;
					}
	public Long getIdOrigen() {
						return this.idOrigen;
					}

	public void setIdOrigen(Long idOrigen) {
						this.idOrigen = idOrigen;
					}
	public Long getIdPrestacion() {
						return this.idPrestacion;
					}

	public void setIdPrestacion(Long idPrestacion) {
						this.idPrestacion = idPrestacion;
					}
	public Long getIdProgramacion() {
						return this.idProgramacion;
					}

	public void setIdProgramacion(Long idProgramacion) {
						this.idProgramacion = idProgramacion;
					}
	public Integer getCantParticAsist() {
						return this.cantParticAsist;
					}

	public void setCantParticAsist(Integer cantParticAsist) {
						this.cantParticAsist = cantParticAsist;
					}
	public Long getIdTipo() {
						return this.idTipo;
					}

	public void setIdTipo(Long idTipo) {
						this.idTipo = idTipo;
					}
	public Long getIdcapaPadre() {
						return this.idcapaPadre;
					}

	public void setIdcapaPadre(Long idcapaPadre) {
						this.idcapaPadre = idcapaPadre;
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
	public Long getFlagPubli() {
						return this.flagPubli;
					}

	public void setFlagPubli(Long flagPubli) {
						this.flagPubli = flagPubli;
					}
	public Long getIdModalidad() {
						return this.idModalidad;
					}

	public void setIdModalidad(Long idModalidad) {
						this.idModalidad = idModalidad;
					}
	public String getDetalleCapaVirtual() {
						return this.detalleCapaVirtual;
					}

	public void setDetalleCapaVirtual(String detalleCapaVirtual) {
						this.detalleCapaVirtual = detalleCapaVirtual;
					}
	public Timestamp getFechaIniProgramada() {
		return this.fechaIniProgramada;
	}
	public void setFechaIniProgramada(Timestamp fechaIniProgramada) {
		this.fechaIniProgramada = fechaIniProgramada;
	}
	public java.util.Date getFechaIniProgramadaJUD() {
		java.util.Date fechaIniProgramadaJUD = null;
		if (fechaIniProgramada != null)
			fechaIniProgramadaJUD = new java.util.Date(fechaIniProgramada.getTime());
		return fechaIniProgramadaJUD;
	}
	public void setFechaIniProgramadaJUD(java.util.Date fechaIniProgramadaJUD) {
		if (fechaIniProgramadaJUD != null)
			this.fechaIniProgramada = new Timestamp(fechaIniProgramadaJUD.getTime());
		else
			this.fechaIniProgramada = null;
	}	
	public Timestamp getFechaFinProgramada() {
		return this.fechaFinProgramada;
	}
	public void setFechaFinProgramada(Timestamp fechaFinProgramada) {
		this.fechaFinProgramada = fechaFinProgramada;
	}
	public java.util.Date getFechaFinProgramadaJUD() {
		java.util.Date fechaFinProgramadaJUD = null;
		if (fechaFinProgramada != null)
			fechaFinProgramadaJUD = new java.util.Date(fechaFinProgramada.getTime());
		return fechaFinProgramadaJUD;
	}
	public void setFechaFinProgramadaJUD(java.util.Date fechaFinProgramadaJUD) {
		if (fechaFinProgramadaJUD != null)
			this.fechaFinProgramada = new Timestamp(fechaFinProgramadaJUD.getTime());
		else
			this.fechaFinProgramada = null;
	}	
	public Timestamp getFechaSoli() {
		return this.fechaSoli;
	}
	public void setFechaSoli(Timestamp fechaSoli) {
		this.fechaSoli = fechaSoli;
	}
	public java.util.Date getFechaSoliJUD() {
		java.util.Date fechaSoliJUD = null;
		if (fechaSoli != null)
			fechaSoliJUD = new java.util.Date(fechaSoli.getTime());
		return fechaSoliJUD;
	}
	public void setFechaSoliJUD(java.util.Date fechaSoliJUD) {
		if (fechaSoliJUD != null)
			this.fechaSoli = new Timestamp(fechaSoliJUD.getTime());
		else
			this.fechaSoli = null;
	}	
	public Long getStdIddoc() {
						return this.stdIddoc;
					}

	public void setStdIddoc(Long stdIddoc) {
						this.stdIddoc = stdIddoc;
					}
	public String getStdNumeroSid() {
						return this.stdNumeroSid;
					}

	public void setStdNumeroSid(String stdNumeroSid) {
						this.stdNumeroSid = stdNumeroSid;
					}
	public Integer getStdNumeroAnio() {
						return this.stdNumeroAnio;
					}

	public void setStdNumeroAnio(Integer stdNumeroAnio) {
						this.stdNumeroAnio = stdNumeroAnio;
					}
	public String getStdNumeroDoc() {
						return this.stdNumeroDoc;
					}

	public void setStdNumeroDoc(String stdNumeroDoc) {
						this.stdNumeroDoc = stdNumeroDoc;
					}
	public String getStdAsunto() {
						return this.stdAsunto;
					}

	public void setStdAsunto(String stdAsunto) {
						this.stdAsunto = stdAsunto;
					}
	public String getStdTipoDoc() {
						return this.stdTipoDoc;
					}

	public void setStdTipoDoc(String stdTipoDoc) {
						this.stdTipoDoc = stdTipoDoc;
					}
	public String getStdFechaRecepcion() {
		return this.stdFechaRecepcion;
	}
	public void setStdFechaRecepcion(String stdFechaRecepcion) {
		this.stdFechaRecepcion = stdFechaRecepcion;
	}
	
	public String getStdModalidadIng() {
						return this.stdModalidadIng;
					}

	public void setStdModalidadIng(String stdModalidadIng) {
						this.stdModalidadIng = stdModalidadIng;
					}
	public Long getFlagEjec() {
						return this.flagEjec;
					}

	public void setFlagEjec(Long flagEjec) {
						this.flagEjec = flagEjec;
					}
	public String getMotivoEjec() {
						return this.motivoEjec;
					}

	public void setMotivoEjec(String motivoEjec) {
						this.motivoEjec = motivoEjec;
					}
	
	
	public String getIdLocalTxt() {
		return this.idLocalTxt;
	}
	public void setIdLocalTxt(String idLocalTxt) {
		this.idLocalTxt = idLocalTxt;
	}
	public String getIdUsuinternoTxt() {
		return this.idUsuinternoTxt;
	}
	public void setIdUsuinternoTxt(String idUsuinternoTxt) {
		this.idUsuinternoTxt = idUsuinternoTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdModoTxt() {
		return this.idModoTxt;
	}
	public void setIdModoTxt(String idModoTxt) {
		this.idModoTxt = idModoTxt;
	}
	public String getIdNivelTxt() {
		return this.idNivelTxt;
	}
	public void setIdNivelTxt(String idNivelTxt) {
		this.idNivelTxt = idNivelTxt;
	}
	public String getIdOrigenTxt() {
		return this.idOrigenTxt;
	}
	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}
	public String getIdPrestacionTxt() {
		return this.idPrestacionTxt;
	}
	public void setIdPrestacionTxt(String idPrestacionTxt) {
		this.idPrestacionTxt = idPrestacionTxt;
	}
	public String getIdProgramacionTxt() {
		return this.idProgramacionTxt;
	}
	public void setIdProgramacionTxt(String idProgramacionTxt) {
		this.idProgramacionTxt = idProgramacionTxt;
	}
	public String getIdTipoTxt() {
		return this.idTipoTxt;
	}
	public void setIdTipoTxt(String idTipoTxt) {
		this.idTipoTxt = idTipoTxt;
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
	public String getIdModalidadTxt() {
		return this.idModalidadTxt;
	}
	public void setIdModalidadTxt(String idModalidadTxt) {
		this.idModalidadTxt = idModalidadTxt;
	}
		

	public Integer getEditopcion() {
		return editopcion;
	}

	public void setEditopcion(Integer editopcion) {
		this.editopcion = editopcion;
	}	
	
	//MPINARES 14022024 - INICIO
	
		public List<DtCapaTemasBk> getDtCapaTemasBkJSss() {
			return dtCapaTemasBkJSss;
		}

		public void setDtCapaTemasBkJSss(List<DtCapaTemasBk> dtCapaTemasBkJSss) {
			this.dtCapaTemasBkJSss = dtCapaTemasBkJSss;
		}

		public List<DtCapaEntidadesBk> getDtCapaEntidadesBkJSss() {
			return dtCapaEntidadesBkJSss;
		}

		public void setDtCapaEntidadesBkJSss(List<DtCapaEntidadesBk> dtCapaEntidadesBkJSss) {
			this.dtCapaEntidadesBkJSss = dtCapaEntidadesBkJSss;
		}

		public List<DtCapaPublicoBk> getDtCapaPublicoBkJSss() {
			return dtCapaPublicoBkJSss;
		}

		public void setDtCapaPublicoBkJSss(List<DtCapaPublicoBk> dtCapaPublicoBkJSss) {
			this.dtCapaPublicoBkJSss = dtCapaPublicoBkJSss;
		}	
		
		public List<DtCapacitacionBk> getDtCapaAcumulaListBkJSss() {
			return dtCapaAcumulaListBkJSss;
		}

		public void setDtCapaAcumulaListBkJSss(List<DtCapacitacionBk> dtCapaAcumulaListBkJSss) {
			this.dtCapaAcumulaListBkJSss = dtCapaAcumulaListBkJSss;
		}

		public Long getEstado() {
			return estado;
		}

		public void setEstado(Long estado) {
			this.estado = estado;
		}
//INICIO CUSCATA - 07082024
		public List<DtAnexosJS> getTdAnexosJSss() {
			return tdAnexosJSss;
		}

		public void setTdAnexosJSss(List<DtAnexosJS> tdAnexosJSss) {
			this.tdAnexosJSss = tdAnexosJSss;
		}

		public List<DtCapaUsuexternosBk> getDtCapacitacionUsuariosBkJSss() {
			return dtCapacitacionUsuariosBkJSss;
		}

		public void setDtCapacitacionUsuariosBkJSss(List<DtCapaUsuexternosBk> dtCapacitacionUsuariosBkJSss) {
			this.dtCapacitacionUsuariosBkJSss = dtCapacitacionUsuariosBkJSss;
		}
		//FIN CUSCATA - 07082024
		
		
		//MPINARES 14022024 - FIN
}
