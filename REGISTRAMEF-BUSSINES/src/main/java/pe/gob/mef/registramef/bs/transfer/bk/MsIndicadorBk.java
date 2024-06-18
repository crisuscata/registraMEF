package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsIndicadorACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * MS_INDICADOR BAKING: LISTA DE LOS INDICADORES REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class MsIndicadorBk implements java.io.Serializable {

	//ID
	private Long idIndicador;
		
	//PROPIEDADES
	private String descripcion = null;
	private Long idObjetvo = null;
	private Long idNivlstrat = null;
	private Long idFactor = null;
	private Long idFuenteinfor = null;
	private Timestamp fechaModif = null;
	private Long estado = null;
	private String formula = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idObjetvoTxt = null;
	private String idNivlstratTxt = null;
	private String idFactorTxt = null;
	private String idFuenteinforTxt = null;
	private String estadoTxt = null;
	
	private MsIndicadorACL msIndicadorACL = null;		
		
	public MsIndicadorBk() {
	}
	
	public Long getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(Long idIndicador) {
		this.idIndicador = idIndicador;
	}
	
	public String getDescripcion() {
						return this.descripcion;
					}

	public void setDescripcion(String descripcion) {
						this.descripcion = descripcion;
					}
	
	public Long getIdObjetvo() {
						return this.idObjetvo;
					}

	public void setIdObjetvo(Long idObjetvo) {
						this.idObjetvo = idObjetvo;
					}
	
	public Long getIdNivlstrat() {
						return this.idNivlstrat;
					}

	public void setIdNivlstrat(Long idNivlstrat) {
						this.idNivlstrat = idNivlstrat;
					}
	
	public Long getIdFactor() {
						return this.idFactor;
					}

	public void setIdFactor(Long idFactor) {
						this.idFactor = idFactor;
					}
	
	public Long getIdFuenteinfor() {
						return this.idFuenteinfor;
					}

	public void setIdFuenteinfor(Long idFuenteinfor) {
						this.idFuenteinfor = idFuenteinfor;
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
	
	public String getFormula() {
						return this.formula;
					}

	public void setFormula(String formula) {
						this.formula = formula;
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
	
	
	
	public String getIdObjetvoTxt() {
		return this.idObjetvoTxt;
	}
	public void setIdObjetvoTxt(String idObjetvoTxt) {
		this.idObjetvoTxt = idObjetvoTxt;
	}
	public String getIdNivlstratTxt() {
		return this.idNivlstratTxt;
	}
	public void setIdNivlstratTxt(String idNivlstratTxt) {
		this.idNivlstratTxt = idNivlstratTxt;
	}
	public String getIdFactorTxt() {
		return this.idFactorTxt;
	}
	public void setIdFactorTxt(String idFactorTxt) {
		this.idFactorTxt = idFactorTxt;
	}
	public String getIdFuenteinforTxt() {
		return this.idFuenteinforTxt;
	}
	public void setIdFuenteinforTxt(String idFuenteinforTxt) {
		this.idFuenteinforTxt = idFuenteinforTxt;
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
		
	
	public MsIndicadorACL getMsIndicadorACL() {
		return msIndicadorACL;
	}

	public void setMsIndicadorACL(MsIndicadorACL msIndicadorACL) {
		this.msIndicadorACL = msIndicadorACL;
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
