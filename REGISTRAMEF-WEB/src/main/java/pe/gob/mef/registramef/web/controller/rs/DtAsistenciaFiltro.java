package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;

//MPINARES 24012023 - INICIO - SE CAMBIA TODO
public class DtAsistenciaFiltro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882171916017812170L;
	private String fechaInicio = null;
	private String fechaFin = null;
	private String idSedeTxt = null;
	private String idEntidadTxt = null;
	private String idProgramacion = null;
	
	//MPINARES 13022024 - INICIO
		private String idAsistencia = null;
		private String dniUserTxt = null;
		private String usuExtTxt = null;
		private String codEjecutora = null;
		private String idUsuinternoTxt = null;
		private String idSistAdmTxt = null;
		private String idOrigenTxt = null;
		private String estadoTxt = null;
		//MPINARES 13022024 - FIN

	private Integer estado = null;

	//MPINARES 13022024 - INICIO
		public DtAsistenciaFiltro(String fechaInicio, String fechaFin, String idSedeTxt, String idEntidadTxt,
				String idProgramacion, String idAsistencia, String dniUserTxt, String usuExtTxt, String codEjecutora,
				String idUsuinternoTxt, String idSistAdmTxt, String idOrigenTxt, String estadoTxt, Integer estado) {
			super();
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.idSedeTxt = idSedeTxt;
			this.idEntidadTxt = idEntidadTxt;
			this.idProgramacion = idProgramacion;
			this.idAsistencia = idAsistencia;
			this.dniUserTxt = dniUserTxt;
			this.usuExtTxt = usuExtTxt;
			this.codEjecutora = codEjecutora;
			this.idUsuinternoTxt = idUsuinternoTxt;
			this.idSistAdmTxt = idSistAdmTxt;
			this.idOrigenTxt = idOrigenTxt;
			this.estadoTxt = estadoTxt;
			this.estado = estado;
		}
		//MPINARES 13022024 - FIN

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getIdSedeTxt() {
		return idSedeTxt;
	}

	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}

	public String getIdEntidadTxt() {
		return idEntidadTxt;
	}

	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}

	public String getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(String idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public boolean isActivo() {
		if (fechaInicio != null && fechaInicio.trim().length() > 0)
			return true;
		if (fechaFin != null && fechaFin.trim().length() > 0)
			return true;
		if (idSedeTxt != null && idSedeTxt.trim().length() > 0)
			return true;
		if (idEntidadTxt != null && idEntidadTxt.trim().length() > 0)
			return true;
		if (idProgramacion != null && idProgramacion.trim().length() > 0)
			return true;
		if (estado != null && estado.intValue() > -1)
			return true;
		//MPINARES 13022024 - INICIO
				if (idAsistencia != null && idAsistencia.trim().length() > 0)
					return true;
				if (dniUserTxt != null && dniUserTxt.trim().length() > 0)
					return true;
				if (usuExtTxt != null && usuExtTxt.trim().length() > 0)
					return true;
				if (codEjecutora != null && codEjecutora.trim().length() > 0)
					return true;
				if (idUsuinternoTxt != null && idUsuinternoTxt.trim().length() > 0)
					return true;
				if (idSistAdmTxt != null && idSistAdmTxt.trim().length() > 0)
					return true;
				if (idOrigenTxt != null && idOrigenTxt.trim().length() > 0)
					return true;
				if (estadoTxt != null && estadoTxt.trim().length() > 0)
					return true;
				//MPINARES 13022024 - FIN
		return false;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	//MPINARES 13022024 - INICIO
	
		public String getIdAsistencia() {
			return idAsistencia;
		}



		public void setIdAsistencia(String idAsistencia) {
			this.idAsistencia = idAsistencia;
		}



		public String getDniUserTxt() {
			return dniUserTxt;
		}



		public void setDniUserTxt(String dniUserTxt) {
			this.dniUserTxt = dniUserTxt;
		}



		public String getUsuExtTxt() {
			return usuExtTxt;
		}



		public void setUsuExtTxt(String usuExtTxt) {
			this.usuExtTxt = usuExtTxt;
		}



		public String getCodEjecutora() {
			return codEjecutora;
		}



		public void setCodEjecutora(String codEjecutora) {
			this.codEjecutora = codEjecutora;
		}



		public String getIdUsuinternoTxt() {
			return idUsuinternoTxt;
		}



		public void setIdUsuinternoTxt(String idUsuinternoTxt) {
			this.idUsuinternoTxt = idUsuinternoTxt;
		}



		public String getIdSistAdmTxt() {
			return idSistAdmTxt;
		}



		public void setIdSistAdmTxt(String idSistAdmTxt) {
			this.idSistAdmTxt = idSistAdmTxt;
		}



		public String getIdOrigenTxt() {
			return idOrigenTxt;
		}



		public void setIdOrigenTxt(String idOrigenTxt) {
			this.idOrigenTxt = idOrigenTxt;
		}



		public String getEstadoTxt() {
			return estadoTxt;
		}



		public void setEstadoTxt(String estadoTxt) {
			this.estadoTxt = estadoTxt;
		}
		
		//MPINARES 13022024 - FIN
}
