package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsTemaACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_TEMA BAKING: LISTA DE LOS TEMAS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsTemaBk implements java.io.Serializable {

	//ID
	private Long idTema;
		
	//PROPIEDADES
	private Long idSistAdmi = null;
	private String descripcion = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long tipoServicio = null;
	
	//PURIBE 14032024 -INICIO-->
		//ADICIONALES
		private String idTemaTxt  = null;

		private String idSistAdmiTxt = null;
		private String estadoTxt = null;
		private String tipoServicioTxt = null;
		
		private MsTemaACL msTemaACL = null;		
			
		public MsTemaBk() {
		}
		
		
		public String getIdTemaTxt() {
			return idTemaTxt;
		}

		public void setIdTemaTxt(String idTemaTxt) {
			this.idTemaTxt = idTemaTxt;
		}
		
		public Long getIdTema() {
			return this.idTema;
		}
		
		//PURIBE 14032024 -FIN-->

	public void setIdTema(Long idTema) {
		this.idTema = idTema;
	}
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
					}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
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
	
	public Long getTipoServicio() {
						return this.tipoServicio;
					}

	public void setTipoServicio(Long tipoServicio) {
						this.tipoServicio = tipoServicio;
					}
	
	
	
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		if (estadoTxt==null && estado != null && estado.longValue() > Estado.ELIMINADO.getValor()) {
			estadoTxt="Activo";
		} else {
			if (estadoTxt==null && estado != null) 
			     estadoTxt="Eliminado";
		}
		this.estadoTxt = estadoTxt;
	}
	public String getTipoServicioTxt() {
		return this.tipoServicioTxt;
	}
	public void setTipoServicioTxt(String tipoServicioTxt) {
		this.tipoServicioTxt = tipoServicioTxt;
	}
		
	
	public MsTemaACL getMsTemaACL() {
		return msTemaACL;
	}

	public void setMsTemaACL(MsTemaACL msTemaACL) {
		this.msTemaACL = msTemaACL;
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
