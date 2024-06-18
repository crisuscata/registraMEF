package pe.gob.mef.registramef.web.controller.rs;

import java.io.Serializable;
	  //PURIBE 14032024 - INICIO-->
public class DtVisitasFiltro implements Serializable{

	private String fechaVisita = null;
	private String idOrigen = null;
	private String idProgramacion = null;
	private String idModalidad = null;
	private String idTipo = null;
	private String idLugar = null;
	private String idEntidad = null;
	private String idSede = null;
	private String idSistAdm = null;
	private String idFinancia = null;
	private String fechaProgramada = null;

	private String idSistAdmTxt = null;
	private String idSedeTxt = null;
	private String idOrigenTxt = null;
	private String idProgramacionTxt= null;
	private String idVisita =null;
	private String idParticipanteTxt=null;   //PURIBE 29032024 - INICIO-->
	
	

	private Integer estado = null;		
	
	public DtVisitasFiltro(String fechaVisita,String idOrigen,String idProgramacion,String idModalidad,String idTipo,String idLugar,String idEntidad,String idSede,String idSistAdm,String idFinancia,String fechaProgramada,Integer estado,
			 String idSistAdmTxt,String idSedeTxt,String idOrigenTxt,String idProgramacionTxt,String idVisita ) {
                this.fechaVisita = fechaVisita;
		this.idOrigen = idOrigen;
		this.idProgramacion = idProgramacion;
		this.idModalidad = idModalidad;
		this.idTipo = idTipo;
		this.idLugar = idLugar;
		this.idEntidad = idEntidad;
		this.idSede = idSede;
		this.idSistAdm = idSistAdm;
		this.idFinancia = idFinancia;
		this.fechaProgramada = fechaProgramada;
		this.idSistAdmTxt=idSistAdmTxt;
		this.idSedeTxt=idSedeTxt;
		this.idOrigenTxt= idOrigenTxt;
		this.idProgramacionTxt=idProgramacionTxt;
		this.idVisita=idVisita;
		
		this.estado = estado;		
	}
	
	//PURIBE 29032024 - INICIO-->
		public String getIdParticipanteTxt() {
			return idParticipanteTxt;
		}

		public void setIdParticipanteTxt(String idParticipanteTxt) {
			this.idParticipanteTxt = idParticipanteTxt;
		}
		//PURIBE 29032024 - FIN-->
	
	public String getIdSistAdmTxt() {
		return idSistAdmTxt;
	}

	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
	}

	public String getIdSedeTxt() {
		return idSedeTxt;
	}

	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}

	public String getIdOrigenTxt() {
		return idOrigenTxt;
	}

	public void setIdOrigenTxt(String idOrigenTxt) {
		this.idOrigenTxt = idOrigenTxt;
	}

	public String getIdProgramacionTxt() {
		return idProgramacionTxt;
	}

	public void setIdProgramacionTxt(String idProgramacionTxt) {
		this.idProgramacionTxt = idProgramacionTxt;
	}

	public String getFechaVisita() {
		return this.fechaVisita;
	}
	public void setFechaVisita(String fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
	public String getIdOrigen() {
		return this.idOrigen;
	}
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}
	public String getIdProgramacion() {
		return this.idProgramacion;
	}
	public void setIdProgramacion(String idProgramacion) {
		this.idProgramacion = idProgramacion;
	}
	public String getIdModalidad() {
		return this.idModalidad;
	}
	public void setIdModalidad(String idModalidad) {
		this.idModalidad = idModalidad;
	}
	public String getIdTipo() {
		return this.idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public String getIdLugar() {
		return this.idLugar;
	}
	public void setIdLugar(String idLugar) {
		this.idLugar = idLugar;
	}
	public String getIdEntidad() {
		return this.idEntidad;
	}
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getIdSede() {
		return this.idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdSistAdm() {
		return this.idSistAdm;
	}
	public void setIdSistAdm(String idSistAdm) {
		this.idSistAdm = idSistAdm;
	}
	public String getIdFinancia() {
		return this.idFinancia;
	}
	public void setIdFinancia(String idFinancia) {
		this.idFinancia = idFinancia;
	}
	public String getFechaProgramada() {
		return this.fechaProgramada;
	}
	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public String getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(String idVisita) {
		this.idVisita = idVisita;
	}

	

	public boolean isActivo() {
		if(fechaVisita!=null && fechaVisita.trim().length()>0) return true;
		if(idOrigen!=null && idOrigen.trim().length()>0) return true;
		if(idProgramacion!=null && idProgramacion.trim().length()>0) return true;
		if(idModalidad!=null && idModalidad.trim().length()>0) return true;
		if(idTipo!=null && idTipo.trim().length()>0) return true;
		if(idLugar!=null && idLugar.trim().length()>0) return true;
		if(idEntidad!=null && idEntidad.trim().length()>0) return true;
		if(idSede!=null && idSede.trim().length()>0) return true;
		if(idSistAdm!=null && idSistAdm.trim().length()>0) return true;
		if(idFinancia!=null && idFinancia.trim().length()>0) return true;
		if(fechaProgramada!=null && fechaProgramada.trim().length()>0) return true;
		
		if(idSistAdmTxt!=null && idSistAdmTxt.trim().length()>0) return true;
		if(idSedeTxt!=null && idSedeTxt.trim().length()>0) return true;
		if(idOrigenTxt!=null && idOrigenTxt.trim().length()>0) return true;
		if(idProgramacionTxt!=null && idProgramacionTxt.trim().length()>0) return true;
		if(idVisita!=null && idVisita.trim().length()>0) return true;
		if(idParticipanteTxt!=null && idParticipanteTxt.trim().length()>0) return true;	//PURIBE 29032024 - INICIO-->
		
		if(estado!=null && estado.intValue()>-1) return true;
		return false;
	}
	  
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
//PURIBE 14032024 - FIN-->