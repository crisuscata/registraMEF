package pe.gob.mef.registramef.web.controller.rs.data;

import java.sql.Timestamp;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;

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
public class DtAsistenciaJS implements java.io.Serializable {

	// ID
	private Long idAsistencia;

	// PROPIEDADES
	private Timestamp fechaAsistencia = null;
	private String detalle = null;
	private Long idUsuinterno = null;
	private Long idEntidad = null;
	private Long idOrigen = null;
	private Long idProgramacion = null;
	private Long estado = null;
	private Long idModalidad = null;
	private Long idSede = null;
	private Long idSistAdm = null;
	private Long idFinancia = null;
	private Timestamp fechaFinalizacion = null;
	private Timestamp fechaProgramada = null;
	private Timestamp fechaSoli = null;
	private Timestamp fechaServicioJUD = null;
	
	
	// ADICIONALES
	private String estadoTxt = null;
	private String idUsuinternoTxt = null;
	private String idEntidadTxt = null;
	private String idOrigenTxt = null;
	private String idProgramacionTxt = null;
	private String idModalidadTxt = null;
	private String idSedeTxt = null;
	private String idSistAdmTxt = null;
	private String idFinanciaTxt = null;
	
	//MPINARES 24012023 - INICIO
		private List<DtAsistenciaTemasBk> dtAsistenciaTemasBkJSss = null;
		private List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuariosBkJSss=null;
		private String codEjecutora = null;
		private List<String> dniUser = null;
		private List<String> usuExt = null;
		private List<String> dniUserTxt = null;
		private List<String> usuExtTxt = null;
		private boolean vistaProgramado = false;
		private boolean checked = false;
		//MPINARES 24012023 - FIN
		
	private DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk=null;
	
	private Integer editopcion = 1;

	public DtAsistenciaJS() {
	}

	public Long getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	
	public Timestamp getFechaAsistencia() {
		return this.fechaAsistencia;
	}
	public void setFechaAsistencia(Timestamp fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public java.util.Date getFechaAsistenciaJUD() {
		java.util.Date fechaAsistenciaJUD = null;
		if (fechaAsistencia != null)
			fechaAsistenciaJUD = new java.util.Date(fechaAsistencia.getTime());
		return fechaAsistenciaJUD;
	}
	public void setFechaAsistenciaJUD(java.util.Date fechaAsistenciaJUD) {
		if (fechaAsistenciaJUD != null)
			this.fechaAsistencia = new Timestamp(fechaAsistenciaJUD.getTime());
		else
			this.fechaAsistencia = null;
	}	
	public String getDetalle() {
						return this.detalle;
					}

	public void setDetalle(String detalle) {
						this.detalle = detalle;
					}
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
					}
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
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
	
	
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	public String getIdUsuinternoTxt() {
		return this.idUsuinternoTxt;
	}
	public void setIdUsuinternoTxt(String idUsuinternoTxt) {
		this.idUsuinternoTxt = idUsuinternoTxt;
	}
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
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

	//MPINARES 24012023 - INICIO
		public List<DtAsistenciaTemasBk> getDtAsistenciaTemasBkJSss() {
			return dtAsistenciaTemasBkJSss;
		}

		public void setDtAsistenciaTemasBkJSss(List<DtAsistenciaTemasBk> dtAsistenciaTemasBkJSss) {
			this.dtAsistenciaTemasBkJSss = dtAsistenciaTemasBkJSss;
		}

		public String getCodEjecutora() {
			return codEjecutora;
		}

		public void setCodEjecutora(String codEjecutora) {
			this.codEjecutora = codEjecutora;
		}

		public List<String> getDniUser() {
			return dniUser;
		}

		public void setDniUser(List<String> dniUser) {
			this.dniUser = dniUser;
		}

		public List<String> getUsuExt() {
			return usuExt;
		}

		public void setUsuExt(List<String> usuExt) {
			this.usuExt = usuExt;
		}

		public boolean isVistaProgramado() {
			return vistaProgramado;
		}

		public void setVistaProgramado(boolean vistaProgramado) {
			this.vistaProgramado = vistaProgramado;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public List<String> getDniUserTxt() {
			return dniUserTxt;
		}

		public void setDniUserTxt(List<String> dniUserTxt) {
			this.dniUserTxt = dniUserTxt;
		}

		public List<String> getUsuExtTxt() {
			return usuExtTxt;
		}

		public void setUsuExtTxt(List<String> usuExtTxt) {
			this.usuExtTxt = usuExtTxt;
		}

		public Long getEstado() {
			return estado;
		}

		public void setEstado(Long estado) {
			this.estado = estado;
		}

		public Timestamp getFechaServicioJUD() {
			return fechaServicioJUD;
		}

		public void setFechaServicioJUD(Timestamp fechaServicioJUD) {
			this.fechaServicioJUD = fechaServicioJUD;
		}

		public List<DtAsistenciaUsuexternosBk> getDtAsistenciaUsuariosBkJSss() {
			return dtAsistenciaUsuariosBkJSss;
		}

		public void setDtAsistenciaUsuariosBkJSss(List<DtAsistenciaUsuexternosBk> dtAsistenciaUsuariosBkJSss) {
			this.dtAsistenciaUsuariosBkJSss = dtAsistenciaUsuariosBkJSss;
		}

		public DtAsistenciaUsuexternosBk getDtAsistenciaUsuexternosBk() {
			return dtAsistenciaUsuexternosBk;
		}

		public void setDtAsistenciaUsuexternosBk(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk) {
			this.dtAsistenciaUsuexternosBk = dtAsistenciaUsuexternosBk;
		}

		
		//MPINARES 24012023 - FIN
}
