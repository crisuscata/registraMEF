package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasUsuexternosACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_VISITAS_USUEXTERNOS BAKING: LISTA DE LOS PARTICIPANTES DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtVisitasUsuexternosBk implements java.io.Serializable {

	//ID
	private Long idVisitUsuext;
		
	//PROPIEDADES
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private Long idVisita = null;
	private Long idUsuexterno = null;private String nombre = null;
	private Long estado = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	private Long idCargoUsuext = null;
	private String correoUsuext = null;
	private String fijoUsuext = null;
	private String celularUsuext = null;
	
	
	//ADICIONALES
	private String idVisitaTxt = null;
	private String idUsuexternoTxt = null;
	private String estadoTxt = null;
	private String idCargoUsuextTxt = null;
	
	private DtVisitasUsuexternosACL dtVisitasUsuexternosACL = null;		
		
	public DtVisitasUsuexternosBk() {
	}
	
	public Long getIdVisitUsuext() {
		return this.idVisitUsuext;
	}

	public void setIdVisitUsuext(Long idVisitUsuext) {
		this.idVisitUsuext = idVisitUsuext;
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
	
	public Long getIdVisita() {
						return this.idVisita;
					}

	public void setIdVisita(Long idVisita) {
						this.idVisita = idVisita;
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
	
	public Long getIdCargoUsuext() {
						return this.idCargoUsuext;
					}

	public void setIdCargoUsuext(Long idCargoUsuext) {
						this.idCargoUsuext = idCargoUsuext;
					}
	
	public String getCorreoUsuext() {
						return this.correoUsuext;
					}

	public void setCorreoUsuext(String correoUsuext) {
						this.correoUsuext = correoUsuext;
					}
	
	public String getFijoUsuext() {
						return this.fijoUsuext;
					}

	public void setFijoUsuext(String fijoUsuext) {
						this.fijoUsuext = fijoUsuext;
					}
	
	public String getCelularUsuext() {
						return this.celularUsuext;
					}

	public void setCelularUsuext(String celularUsuext) {
						this.celularUsuext = celularUsuext;
					}
	
	
	
	public String getIdVisitaTxt() {
		return this.idVisitaTxt;
	}
	public void setIdVisitaTxt(String idVisitaTxt) {
		this.idVisitaTxt = idVisitaTxt;
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
	public String getIdCargoUsuextTxt() {
		return this.idCargoUsuextTxt;
	}
	public void setIdCargoUsuextTxt(String idCargoUsuextTxt) {
		this.idCargoUsuextTxt = idCargoUsuextTxt;
	}
		
	
	public DtVisitasUsuexternosACL getDtVisitasUsuexternosACL() {
		return dtVisitasUsuexternosACL;
	}

	public void setDtVisitasUsuexternosACL(DtVisitasUsuexternosACL dtVisitasUsuexternosACL) {
		this.dtVisitasUsuexternosACL = dtVisitasUsuexternosACL;
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
