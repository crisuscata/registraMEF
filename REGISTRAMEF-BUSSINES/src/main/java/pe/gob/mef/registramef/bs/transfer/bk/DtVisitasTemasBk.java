package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasTemasACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_VISITAS_TEMAS BAKING: LISTA DE LOS TEMAS DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtVisitasTemasBk implements java.io.Serializable {

	//ID
	private Long idVisitaTema;
		
	//PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long duserCrea = null;
	private Long iduserModif = null;
	private Long estado = null;
	private Long idVisita = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idTema = null;
	
	
	//ADICIONALES
	private String estadoTxt = null;
	private String idVisitaTxt = null;
	private String idTemaTxt = null;
	
	private DtVisitasTemasACL dtVisitasTemasACL = null;		
		
	public DtVisitasTemasBk() {
	}
	
	public Long getIdVisitaTema() {
		return this.idVisitaTema;
	}

	public void setIdVisitaTema(Long idVisitaTema) {
		this.idVisitaTema = idVisitaTema;
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
	
	public Long getDuserCrea() {
						return this.duserCrea;
					}

	public void setDuserCrea(Long duserCrea) {
						this.duserCrea = duserCrea;
					}
	
	public Long getIduserModif() {
						return this.iduserModif;
					}

	public void setIduserModif(Long iduserModif) {
						this.iduserModif = iduserModif;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	public Long getIdVisita() {
						return this.idVisita;
					}

	public void setIdVisita(Long idVisita) {
						this.idVisita = idVisita;
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
	public String getIdVisitaTxt() {
		return this.idVisitaTxt;
	}
	public void setIdVisitaTxt(String idVisitaTxt) {
		this.idVisitaTxt = idVisitaTxt;
	}
	public String getIdTemaTxt() {
		return this.idTemaTxt;
	}
	public void setIdTemaTxt(String idTemaTxt) {
		this.idTemaTxt = idTemaTxt;
	}
		
	
	public DtVisitasTemasACL getDtVisitasTemasACL() {
		return dtVisitasTemasACL;
	}

	public void setDtVisitasTemasACL(DtVisitasTemasACL dtVisitasTemasACL) {
		this.dtVisitasTemasACL = dtVisitasTemasACL;
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
