package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtConsultasProyectoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CONSULTAS_PROYECTO BAKING: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CONSULTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtConsultasProyectoBk implements java.io.Serializable {

	//ID
	private Long idConsProyecto;
		
	//PROPIEDADES
	private Long idConsulta = null;
	private Long idProyecto = null;
	private String detalle = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idConsultaTxt = null;
	private String idProyectoTxt = null;
	private String estadoTxt = null;
	
	private DtConsultasProyectoACL dtConsultasProyectoACL = null;		
		
	public DtConsultasProyectoBk() {
	}
	
	public Long getIdConsProyecto() {
		return this.idConsProyecto;
	}

	public void setIdConsProyecto(Long idConsProyecto) {
		this.idConsProyecto = idConsProyecto;
	}
	
	public Long getIdConsulta() {
						return this.idConsulta;
					}

	public void setIdConsulta(Long idConsulta) {
						this.idConsulta = idConsulta;
					}
	
	public Long getIdProyecto() {
						return this.idProyecto;
					}

	public void setIdProyecto(Long idProyecto) {
						this.idProyecto = idProyecto;
					}
	
	public String getDetalle() {
						return this.detalle;
					}

	public void setDetalle(String detalle) {
						this.detalle = detalle;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public Long getIdusserCrea() {
						return this.idusserCrea;
					}

	public void setIdusserCrea(Long idusserCrea) {
						this.idusserCrea = idusserCrea;
					}
	
	public Long getIdusserModif() {
						return this.idusserModif;
					}

	public void setIdusserModif(Long idusserModif) {
						this.idusserModif = idusserModif;
					}
	
	public Timestamp getFechaCrea() {
						return this.fechaCrea;
					}

	public void setFechaCrea(Timestamp fechaCrea) {
						this.fechaCrea = fechaCrea;
					}
	
	public Timestamp getFechaModif() {
						return this.fechaModif;
					}

	public void setFechaModif(Timestamp fechaModif) {
						this.fechaModif = fechaModif;
					}
	
	public String getRtmaddress() {
						return this.rtmaddress;
					}

	public void setRtmaddress(String rtmaddress) {
						this.rtmaddress = rtmaddress;
					}
	
	public String getRtmaddressrst() {
						return this.rtmaddressrst;
					}

	public void setRtmaddressrst(String rtmaddressrst) {
						this.rtmaddressrst = rtmaddressrst;
					}
	
	
	
	public String getIdConsultaTxt() {
		return this.idConsultaTxt;
	}
	public void setIdConsultaTxt(String idConsultaTxt) {
		this.idConsultaTxt = idConsultaTxt;
	}
	public String getIdProyectoTxt() {
		return this.idProyectoTxt;
	}
	public void setIdProyectoTxt(String idProyectoTxt) {
		this.idProyectoTxt = idProyectoTxt;
	}
	public String getEstadoTxt() {
		if (estadoTxt==null && estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			estadoTxt="Activo";
		} else {
			if (estadoTxt==null && estado != null) 
			     estadoTxt="Eliminado";
		}
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public DtConsultasProyectoACL getDtConsultasProyectoACL() {
		return dtConsultasProyectoACL;
	}

	public void setDtConsultasProyectoACL(DtConsultasProyectoACL dtConsultasProyectoACL) {
		this.dtConsultasProyectoACL = dtConsultasProyectoACL;
	}
	
	public String getCclase(){
		if(estado!=null && estado.longValue()>Estado.ELIMINADO.getValor()){
			return "cverde";
		}else{
			
		}return "camarillo";
	}
       
        public void setCclase(String cclase) {
	}
        
        public String getCestado(){
		if(estado!=null && estado.longValue()>Estado.ELIMINADO.getValor()){
			return "Activo";
		}else{			
		}
		return "Eliminado";
	}
         
        public void setCestado(String cestado) {
	}
        
        public boolean getEsEliminado() {
		boolean retorno = false;
		if (estado != null && estado.longValue() == Estado.ELIMINADO.getValor()) {
			retorno = true;
		} 
		return retorno;
	}

	public void setEsEliminado(boolean esEliminado) {		
	}
}
