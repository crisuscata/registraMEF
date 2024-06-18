package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.ctlracceso.PrtParametrosACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * PRT_PARAMETROS BAKING: LISTA LOS PARAMETROS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class PrtParametrosBk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8706782721283898158L;

	//ID
	private Long idparametro;
		
	//PROPIEDADES
	private String descripcion = null;
	private Long idpadre = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Integer estado = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private String rtmaddress = null;
	private String rtmaddressmodif = null;
		
	//ADICIONALES
	private String idpadreTxt = null;
	private String estadoTxt = null;
	
	private PrtParametrosACL prtParametrosACL = null;		
		
	//PURIBE 25012024 - INICIO
	private Integer notificacion = null; 
	//PURIBE 25012024 - FIN
	
	private List<String> nofiticaciones;//PURIBE 29032024 - INICIO
	
	public PrtParametrosBk() {
	}
	
	//PURIBE 29032024 - INICIO
		public List<String> getNofiticaciones() {
			return nofiticaciones;
		}

		public void setNofiticaciones(List<String> nofiticaciones) {
			this.nofiticaciones = nofiticaciones;
		}
		//PURIBE 29032024 - FIN
	
	public Long getIdparametro() {
		return this.idparametro;
	}

	public void setIdparametro(Long idparametro) {
		this.idparametro = idparametro;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	
	public Long getIdpadre() {
						return this.idpadre;
					}

	public void setIdpadre(Long idpadre) {
						this.idpadre = idpadre;
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
	
	public Integer getEstado() {
						return this.estado;
					}

	public void setEstado(Integer estado) {
						this.estado = estado;
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
	
	public String getRtmaddress() {
						return this.rtmaddress;
					}

	public void setRtmaddress(String rtmaddress) {
						this.rtmaddress = rtmaddress;
					}
	
	public String getRtmaddressmodif() {
						return this.rtmaddressmodif;
					}

	public void setRtmaddressmodif(String rtmaddressmodif) {
						this.rtmaddressmodif = rtmaddressmodif;
					}
	
	
	
	public String getIdpadreTxt() {
		return this.idpadreTxt;
	}
	public void setIdpadreTxt(String idpadreTxt) {
		this.idpadreTxt = idpadreTxt;
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
		
	
	public PrtParametrosACL getPrtParametrosACL() {
		return prtParametrosACL;
	}

	public void setPrtParametrosACL(PrtParametrosACL prtParametrosACL) {
		this.prtParametrosACL = prtParametrosACL;
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
	
	//PURIBE 25012024 - INICIO
		public Integer getNotificacion() {
			return notificacion;
		}

		public void setNotificacion(Integer notificacion) {
			this.notificacion = notificacion;
		}
	//PURIBE 25012024 - FIN
}
