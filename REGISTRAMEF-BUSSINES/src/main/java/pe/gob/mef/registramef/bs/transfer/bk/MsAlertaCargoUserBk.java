package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsAlertaCargoUserACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_ALERTA_CARGO_USER BAKING: LISTA DE LOS CARGOS DE LOS USUARIOS EN LAS ALERTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsAlertaCargoUserBk implements java.io.Serializable {

	//ID
	private Long idalertaCargo;
		
	//PROPIEDADES
	private Long idalerta = null;
	private Long idcargo = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idalertaTxt = null;
	private String idcargoTxt = null;
	private String estadoTxt = null;
	
	private MsAlertaCargoUserACL msAlertaCargoUserACL = null;		
		
	public MsAlertaCargoUserBk() {
	}
	
	public Long getIdalertaCargo() {
		return this.idalertaCargo;
	}

	public void setIdalertaCargo(Long idalertaCargo) {
		this.idalertaCargo = idalertaCargo;
	}
	
	public Long getIdalerta() {
						return this.idalerta;
					}

	public void setIdalerta(Long idalerta) {
						this.idalerta = idalerta;
					}
	
	public Long getIdcargo() {
						return this.idcargo;
					}

	public void setIdcargo(Long idcargo) {
						this.idcargo = idcargo;
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
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
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
	
	
	
	public String getIdalertaTxt() {
		return this.idalertaTxt;
	}
	public void setIdalertaTxt(String idalertaTxt) {
		this.idalertaTxt = idalertaTxt;
	}
	public String getIdcargoTxt() {
		return this.idcargoTxt;
	}
	public void setIdcargoTxt(String idcargoTxt) {
		this.idcargoTxt = idcargoTxt;
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
		
	
	public MsAlertaCargoUserACL getMsAlertaCargoUserACL() {
		return msAlertaCargoUserACL;
	}

	public void setMsAlertaCargoUserACL(MsAlertaCargoUserACL msAlertaCargoUserACL) {
		this.msAlertaCargoUserACL = msAlertaCargoUserACL;
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
