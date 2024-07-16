package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtCapaPublicoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CAPA_PUBLICO BAKING: LISTA DE LOS TIPOS DE PUBLICO OBJETIVO POR CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtCapaPublicoBk implements java.io.Serializable {

	//ID
	private Long idCapaPublico;
		
	//PROPIEDADES
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Long idCapacitacion = null;
	private Long idCargo = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idCapacitacionTxt = null;
	private String idCargoTxt = null;
	private String estadoTxt = null;
	
	private DtCapaPublicoACL dtCapaPublicoACL = null;	
	
	//MPINARES 14022024 - INICIO
		private boolean add = false;
		private Long contador = null;
		private String searchText = null;
		//MPINARES 14022024 - FIN
		
	public DtCapaPublicoBk() {
	}
	
	public Long getIdCapaPublico() {
		return this.idCapaPublico;
	}

	public void setIdCapaPublico(Long idCapaPublico) {
		this.idCapaPublico = idCapaPublico;
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
	
	public Long getIdCapacitacion() {
						return this.idCapacitacion;
					}

	public void setIdCapacitacion(Long idCapacitacion) {
						this.idCapacitacion = idCapacitacion;
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
	
	
	
	public String getIdCapacitacionTxt() {
		return this.idCapacitacionTxt;
	}
	public void setIdCapacitacionTxt(String idCapacitacionTxt) {
		this.idCapacitacionTxt = idCapacitacionTxt;
	}
	public String getIdCargoTxt() {
		return this.idCargoTxt;
	}
	public void setIdCargoTxt(String idCargoTxt) {
		this.idCargoTxt = idCargoTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public DtCapaPublicoACL getDtCapaPublicoACL() {
		return dtCapaPublicoACL;
	}

	public void setDtCapaPublicoACL(DtCapaPublicoACL dtCapaPublicoACL) {
		this.dtCapaPublicoACL = dtCapaPublicoACL;
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
	
	//MPINARES 14022024 - INICIO
			public boolean isAdd() {
				return add;
			}

			public void setAdd(boolean add) {
				this.add = add;
			}

			public Long getContador() {
				return contador;
			}

			public void setContador(Long contador) {
				this.contador = contador;
			}
			//MPINARES 14022024 - FIN

			public String getSearchText() {
				return searchText;
			}

			public void setSearchText(String searchText) {
				this.searchText = searchText;
			}
			
			
}
