package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtCargosUsuexterACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CARGOS_USUEXTER BAKING: LISTA DE LOS CARGOS DE LOS USUARIOS EXTERNOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtCargosUsuexterBk implements java.io.Serializable {

	//ID
	private Long idCargoUsuexter;
		
	//PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Long idUsuextEnti = null;
	private Long idCargo = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idUsuextEntiTxt = null;
	private String idCargoTxt = null;
	private String estadoTxt = null;
	
	private DtCargosUsuexterACL dtCargosUsuexterACL = null;		
		
	public DtCargosUsuexterBk() {
	}
	
	public Long getIdCargoUsuexter() {
		return this.idCargoUsuexter;
	}

	public void setIdCargoUsuexter(Long idCargoUsuexter) {
		this.idCargoUsuexter = idCargoUsuexter;
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
	
	public Long getIduserCrea() {
						return this.iduserCrea;
					}

	public void setIduserCrea(Long iduserCrea) {
						this.iduserCrea = iduserCrea;
					}
	
	public Long getIduserModif() {
						return this.iduserModif;
					}

	public void setIduserModif(Long iduserModif) {
						this.iduserModif = iduserModif;
					}
	
	public Long getIdUsuextEnti() {
						return this.idUsuextEnti;
					}

	public void setIdUsuextEnti(Long idUsuextEnti) {
						this.idUsuextEnti = idUsuextEnti;
					}
	
	public Long getIdCargo() {
						return this.idCargo;
					}

	public void setIdCargo(Long idCargo) {
						this.idCargo = idCargo;
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
	
	
	
	public String getIdUsuextEntiTxt() {
		return this.idUsuextEntiTxt;
	}
	public void setIdUsuextEntiTxt(String idUsuextEntiTxt) {
		this.idUsuextEntiTxt = idUsuextEntiTxt;
	}
	public String getIdCargoTxt() {
		return this.idCargoTxt;
	}
	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
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
		
	
	public DtCargosUsuexterACL getDtCargosUsuexterACL() {
		return dtCargosUsuexterACL;
	}

	public void setDtCargosUsuexterACL(DtCargosUsuexterACL dtCargosUsuexterACL) {
		this.dtCargosUsuexterACL = dtCargosUsuexterACL;
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
