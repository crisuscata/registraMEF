package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasUsuinternosACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_VISITAS_USUINTERNOS BAKING: LISTA DE LOS PARTICIPANTES DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtVisitasUsuinternosBk implements java.io.Serializable {

	//ID
	private Long idVisitUsuint;
		//PURIBE 14032024 -INICIO-->
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idVisita = null;
	private Long idUsuinterno = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;

	private Long idTema = null;
	
	private String idSistAdmTxt=null;
	private Long  idSistAdm = null;
	
	
	//ADICIONALES
	private String idVisitaTxt = null;
	private String idUsuinternoTxt = null;
	private String estadoTxt = null;
	private String idTemaTxt = null;
	
	private DtVisitasUsuinternosACL dtVisitasUsuinternosACL = null;		
		
	
	
	public String getIdSistAdmTxt() {
		return idSistAdmTxt;
	}

	public void setIdSistAdmTxt(String idSistAdmTxt) {
		this.idSistAdmTxt = idSistAdmTxt;
	}

	public Long getIdSistAdm() {
		return idSistAdm;
	}

	public void setIdSistAdm(Long idSistAdm) {
		this.idSistAdm = idSistAdm;
	}
	public DtVisitasUsuinternosBk() {
	}
	
	public Long getIdVisitUsuint() {
		return this.idVisitUsuint;
	}

	public void setIdVisitUsuint(Long idVisitUsuint) {
		this.idVisitUsuint = idVisitUsuint;
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
	
	public Long getIdVisita() {
						return this.idVisita;
					}

	public void setIdVisita(Long idVisita) {
						this.idVisita = idVisita;
					}
	
	public Long getIdUsuinterno() {
						return this.idUsuinterno;
					}

	public void setIdUsuinterno(Long idUsuinterno) {
						this.idUsuinterno = idUsuinterno;
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
	
	public Long getIdTema() {
						return this.idTema;
					}

	public void setIdTema(Long idTema) {
						this.idTema = idTema;
					}
	
	
	
	public String getIdVisitaTxt() {
		return this.idVisitaTxt;
	}
	public void setIdVisitaTxt(String idVisitaTxt) {
		this.idVisitaTxt = idVisitaTxt;
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
	public String getIdTemaTxt() {
		return this.idTemaTxt;
	}
	public void setIdTemaTxt(String idTemaTxt) {
		this.idTemaTxt = idTemaTxt;
	}
		
	
	public DtVisitasUsuinternosACL getDtVisitasUsuinternosACL() {
		return dtVisitasUsuinternosACL;
	}

	public void setDtVisitasUsuinternosACL(DtVisitasUsuinternosACL dtVisitasUsuinternosACL) {
		this.dtVisitasUsuinternosACL = dtVisitasUsuinternosACL;
	}
	
	public String getCclase(){
		if(estado!=null && estado.intValue()>0){
			return "cverde";
		}else{
			
		}return "camarillo";
	}
       
        public void setCclase(String cclase) {
	}
        
        public String getCestado(){
		if(estado!=null && estado.intValue()>0){
			return "Activo";
		}else{			
		}
		return "Anulado";
	}
      //PURIBE 14032024 -FIN-->
         
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
