package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsAlertaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_ALERTA BAKING: LISTA DE LAS ALERTAS GENERADAS EN EL SISTMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsAlertaBk implements java.io.Serializable {

	//ID
	private Long idAlerta;
		
	//PROPIEDADES
	private Long idCaracterst = null;
	private String otrosDestin = null;
	private Integer dia = null;
	private Integer hora = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idCaracterstTxt = null;
	private String diaTxt = null;
	private String horaTxt = null;
	private String estadoTxt = null;
	
	private MsAlertaACL msAlertaACL = null;		
		
	public MsAlertaBk() {
	}
	
	public Long getIdAlerta() {
		return this.idAlerta;
	}

	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}
	
	public Long getIdCaracterst() {
						return this.idCaracterst;
					}

	public void setIdCaracterst(Long idCaracterst) {
						this.idCaracterst = idCaracterst;
					}
	
	public String getOtrosDestin() {
						return this.otrosDestin;
					}

	public void setOtrosDestin(String otrosDestin) {
						this.otrosDestin = otrosDestin;
					}
	
	public Integer getDia() {
						return this.dia;
					}

	public void setDia(Integer dia) {
						this.dia = dia;
					}
	
	public Integer getHora() {
						return this.hora;
					}

	public void setHora(Integer hora) {
						this.hora = hora;
					}
	
	public Timestamp getFechaCrea() {
		return this.fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public java.util.Date getFechaCreaJUD() {
		java.util.Date fechaCreaJUD = null;
		if (fechaCrea != null)
			fechaCreaJUD = new java.util.Date(fechaCrea.getTime());
		return fechaCreaJUD;
	}
	public void setFechaCreaJUD(java.util.Date fechaCreaJUD) {
		if (fechaCreaJUD != null)
			this.fechaCrea = new Timestamp(fechaCreaJUD.getTime());
		else
			this.fechaCrea = null;
	}	
	
	public Timestamp getFechaModif() {
		return this.fechaModif;
	}
	public void setFechaModif(Timestamp fechaModif) {
		this.fechaModif = fechaModif;
	}
	public java.util.Date getFechaModifJUD() {
		java.util.Date fechaModifJUD = null;
		if (fechaModif != null)
			fechaModifJUD = new java.util.Date(fechaModif.getTime());
		return fechaModifJUD;
	}
	public void setFechaModifJUD(java.util.Date fechaModifJUD) {
		if (fechaModifJUD != null)
			this.fechaModif = new Timestamp(fechaModifJUD.getTime());
		else
			this.fechaModif = null;
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
	
	
	
	public String getIdCaracterstTxt() {
		return this.idCaracterstTxt;
	}
	public void setIdCaracterstTxt(String idCaracterstTxt) {
		this.idCaracterstTxt = idCaracterstTxt;
	}
	public String getDiaTxt() {
		return this.diaTxt;
	}
	public void setDiaTxt(String diaTxt) {
		this.diaTxt = diaTxt;
	}
	public String getHoraTxt() {
		return this.horaTxt;
	}
	public void setHoraTxt(String horaTxt) {
		this.horaTxt = horaTxt;
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
		
	
	public MsAlertaACL getMsAlertaACL() {
		return msAlertaACL;
	}

	public void setMsAlertaACL(MsAlertaACL msAlertaACL) {
		this.msAlertaACL = msAlertaACL;
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
