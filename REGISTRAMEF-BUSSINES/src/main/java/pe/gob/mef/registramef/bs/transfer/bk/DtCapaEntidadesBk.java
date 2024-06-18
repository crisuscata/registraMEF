package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtCapaEntidadesACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CAPA_ENTIDADES BAKING: LISTA DE LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtCapaEntidadesBk implements java.io.Serializable {

	//ID
	private Long idCapaEnti;
		
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idCapacitacion = null;
	private Long idEntidad = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idCapacitacionTxt = null;
	private String idEntidadTxt = null;
	private String estadoTxt = null;
	private String codEjecutora = null;//MPINARES 14022024 - INICIO
	
	private DtCapaEntidadesACL dtCapaEntidadesACL = null;		
		
	public DtCapaEntidadesBk() {
	}
	
	public Long getIdCapaEnti() {
		return this.idCapaEnti;
	}

	public void setIdCapaEnti(Long idCapaEnti) {
		this.idCapaEnti = idCapaEnti;
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
	
	public Long getIdCapacitacion() {
						return this.idCapacitacion;
					}

	public void setIdCapacitacion(Long idCapacitacion) {
						this.idCapacitacion = idCapacitacion;
					}
	
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
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
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public DtCapaEntidadesACL getDtCapaEntidadesACL() {
		return dtCapaEntidadesACL;
	}

	public void setDtCapaEntidadesACL(DtCapaEntidadesACL dtCapaEntidadesACL) {
		this.dtCapaEntidadesACL = dtCapaEntidadesACL;
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
			public String getCodEjecutora() {
				return codEjecutora;
			}

			public void setCodEjecutora(String codEjecutora) {
				this.codEjecutora = codEjecutora;
			}

	        
	      //MPINARES 14022024 - FIN
}
