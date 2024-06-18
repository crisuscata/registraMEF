package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtEntidadesUsuexternosACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_ENTIDADES_USUEXTERNOS BAKING: LISTA DE LAS ENTIDADES A LA QUE PERTENECE EL USUARIO EXTERNO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtEntidadesUsuexternosBk implements java.io.Serializable {

	//ID
	private Long idUsuextEnti;
		
	//PROPIEDADES
	private Long idEntidad = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idUsuexterno = null;private String nombre = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idEntidadTxt = null;
	private String idUsuexternoTxt = null;
	private String estadoTxt = null;
	
	private DtEntidadesUsuexternosACL dtEntidadesUsuexternosACL = null;		
		
	public DtEntidadesUsuexternosBk() {
	}
	
	public Long getIdUsuextEnti() {
		return this.idUsuextEnti;
	}

	public void setIdUsuextEnti(Long idUsuextEnti) {
		this.idUsuextEnti = idUsuextEnti;
	}
	
	public Long getIdEntidad() {
						return this.idEntidad;
					}

	public void setIdEntidad(Long idEntidad) {
						this.idEntidad = idEntidad;
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
	
	
public Long getIdUsuexterno() {
						return this.idUsuexterno;
					}

	public void setIdUsuexterno(Long idUsuexterno) {
						this.idUsuexterno = idUsuexterno;
					}
public String getNombre() {
						return this.nombre;
					}

	public void setNombre(String nombre) {
						this.nombre = nombre;
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
	public String getIdUsuexternoTxt() {
		return this.idUsuexternoTxt;
	}
	public void setIdUsuexternoTxt(String idUsuexternoTxt) {
		this.idUsuexternoTxt = idUsuexternoTxt;
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
		
	
	public DtEntidadesUsuexternosACL getDtEntidadesUsuexternosACL() {
		return dtEntidadesUsuexternosACL;
	}

	public void setDtEntidadesUsuexternosACL(DtEntidadesUsuexternosACL dtEntidadesUsuexternosACL) {
		this.dtEntidadesUsuexternosACL = dtEntidadesUsuexternosACL;
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
