package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsMetaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_META BAKING: LISTA DE LAS METAS CON SUS VALORES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsMetaBk implements java.io.Serializable {

	//ID
	private Long idMeta;
		
	//PROPIEDADES
	private Integer annio = null;
	private Long idTipoServicio = null;
	private Long idSistAdmi = null;
	private Long idSede = null;
	private Long valor = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idTipoServicioTxt = null;
	private String idSistAdmiTxt = null;
	private String idSedeTxt = null;
	private String estadoTxt = null;
	
	private MsMetaACL msMetaACL = null;		
		
	public MsMetaBk() {
	}
	
	public Long getIdMeta() {
		return this.idMeta;
	}

	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}
	
	public Integer getAnnio() {
						return this.annio;
					}

	public void setAnnio(Integer annio) {
						this.annio = annio;
					}
	
	public Long getIdTipoServicio() {
						return this.idTipoServicio;
					}

	public void setIdTipoServicio(Long idTipoServicio) {
						this.idTipoServicio = idTipoServicio;
					}
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
					}
	
	public Long getValor() {
						return this.valor;
					}

	public void setValor(Long valor) {
						this.valor = valor;
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
	
	
	
	public String getIdTipoServicioTxt() {
		return this.idTipoServicioTxt;
	}
	public void setIdTipoServicioTxt(String idTipoServicioTxt) {
		this.idTipoServicioTxt = idTipoServicioTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
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
		
	
	public MsMetaACL getMsMetaACL() {
		return msMetaACL;
	}

	public void setMsMetaACL(MsMetaACL msMetaACL) {
		this.msMetaACL = msMetaACL;
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
