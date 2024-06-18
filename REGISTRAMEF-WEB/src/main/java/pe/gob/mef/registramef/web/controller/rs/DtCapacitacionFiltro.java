package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;
//MPINARES 14022024 - INICIO - SE CAMBIA TODO
public class DtCapacitacionFiltro implements Serializable{

	private String fechaInicio = null;
	private String fechaFin = null;
	private String idSedeTxt = null;
	private String entidadesTxt = null;
	private String idProgramacion = null;

	//MPINARES 14022024 - INICIO
		private String idCapacitacion = null;
		private String nomEvento = null;
		private String idSistAdmTxt = null;
		private String idUsuinternoTxt = null;
		private String temasTxt = null;
		private String flagPubliTxt = null;
		private String idModoTxt = null;
		private String estadoTxt = null;
		//MPINARES 14022024 - FIN
		
		private Integer estado = null;	

		//MPINARES 14022024 - INICIO
	public DtCapacitacionFiltro(String fechaInicio, String fechaFin, String idSedeTxt, String entidadesTxt,
				String idProgramacion, String idCapacitacion, String nomEvento, String idSistAdmTxt,
				String idUsuinternoTxt, String temasTxt, String flagPubliTxt, String idModoTxt, String estadoTxt,
				Integer estado) {
			super();
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.idSedeTxt = idSedeTxt;
			this.entidadesTxt = entidadesTxt;
			this.idProgramacion = idProgramacion;
			this.idCapacitacion = idCapacitacion;
			this.nomEvento = nomEvento;
			this.idSistAdmTxt = idSistAdmTxt;
			this.idUsuinternoTxt = idUsuinternoTxt;
			this.temasTxt = temasTxt;
			this.flagPubliTxt = flagPubliTxt;
			this.idModoTxt = idModoTxt;
			this.estadoTxt = estadoTxt;
			this.estado = estado;
		}
	//MPINARES 14022024 - FIN

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

	public String getEntidadesTxt() {
		return entidadesTxt;
	}

	public void setEntidadesTxt(String entidadesTxt) {
		this.entidadesTxt = entidadesTxt;
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
		if (entidadesTxt != null && entidadesTxt.trim().length() > 0)
			return true;
		if (idProgramacion != null && idProgramacion.trim().length() > 0)
			return true;
		if (estado != null && estado.intValue() > -1)
			return true;	
		//MPINARES 14022024 - INICIO
		if (idCapacitacion != null && idCapacitacion.trim().length() > 0)
			return true;
		if (nomEvento != null && nomEvento.trim().length() > 0)
			return true;
		if (idSistAdmTxt != null && idSistAdmTxt.trim().length() > 0)
			return true;
		if (idUsuinternoTxt != null && idUsuinternoTxt.trim().length() > 0)
			return true;
		if (temasTxt != null && temasTxt.trim().length() > 0)
			return true;
		if (flagPubliTxt != null && flagPubliTxt.trim().length() > 0)
			return true;
		if (idModoTxt != null && idModoTxt.trim().length() > 0)
			return true;
		if (estadoTxt != null && estadoTxt.trim().length() > 0)
			return true;
		//MPINARES 14022024 - FIN
		return false;
	}
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(String idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getNomEvento() {
		return nomEvento;
	}

	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}

	public String getIdSistAdmTxt() {
		return idSistAdmTxt;
	}

	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
	}

	public String getIdUsuinternoTxt() {
		return idUsuinternoTxt;
	}

	public void setIdUsuinternoTxt(String idUsuinternoTxt) {
		this.idUsuinternoTxt = idUsuinternoTxt;
	}

	public String getTemasTxt() {
		return temasTxt;
	}

	public void setTemasTxt(String temasTxt) {
		this.temasTxt = temasTxt;
	}

	public String getFlagPubliTxt() {
		return flagPubliTxt;
	}

	public void setFlagPubliTxt(String flagPubliTxt) {
		this.flagPubliTxt = flagPubliTxt;
	}

	public String getIdModoTxt() {
		return idModoTxt;
	}

	public void setIdModoTxt(String idModoTxt) {
		this.idModoTxt = idModoTxt;
	}

	public String getEstadoTxt() {
		return estadoTxt;
	}

	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
	
	
}
