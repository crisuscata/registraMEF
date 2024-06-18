package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadSisAdminACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ENTIDAD_SIS_ADMIN BAKING: LISTA DE LOS SISTEMAS ADMINISTRATIVOS ASIGNADOS A LA ENTIDAD
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtEntidadSisAdminBk implements java.io.Serializable {

	//ID
	private Long identidadSisadm;
		
	//PROPIEDADES
	private Long idEntidad = null;
	private Long idSistAdmi = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idEntidadTxt = null;
	private String idSistAdmiTxt = null;
	private String estadoTxt = null;
	
	private DtEntidadSisAdminACL dtEntidadSisAdminACL = null;	
	
	//MPINARES 24012023 - INICIO
		private Long idSede = null;
			private boolean add = false;
			private Long contador = null;
			//MPINARES 24012023 - FIN
		
	public DtEntidadSisAdminBk() {
	}
	
	public Long getIdentidadSisadm() {
		return this.identidadSisadm;
	}

	public void setIdentidadSisadm(Long identidadSisadm) {
		this.identidadSisadm = identidadSisadm;
	}
	
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
					}
	
	public Long getIdSistAdmi() {
						return this.idSistAdmi;
					}

	public void setIdSistAdmi(Long idSistAdmi) {
						this.idSistAdmi = idSistAdmi;
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
	
	
	
	public String getIdEntidadTxt() {
		return this.idEntidadTxt;
	}
	public void setIdEntidadTxt(String idEntidadTxt) {
		this.idEntidadTxt = idEntidadTxt;
	}
	public String getIdSistAdmiTxt() {
		return this.idSistAdmiTxt;
	}
	public void setIdSistAdmiTxt(String idSistAdmiTxt) {
		this.idSistAdmiTxt = idSistAdmiTxt;
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
		
	
	public DtEntidadSisAdminACL getDtEntidadSisAdminACL() {
		return dtEntidadSisAdminACL;
	}

	public void setDtEntidadSisAdminACL(DtEntidadSisAdminACL dtEntidadSisAdminACL) {
		this.dtEntidadSisAdminACL = dtEntidadSisAdminACL;
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
	
	//MPINARES 24012023 - INICIO

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

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
	
	
	//MPINARES 24012023 - FIN
}
