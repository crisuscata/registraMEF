package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtVisitasProyectoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_VISITAS_PROYECTO BAKING: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtVisitasProyectoBk implements java.io.Serializable {

	//ID
	private Long idVisitaProyecto;
		
	//PROPIEDADES
	private Long idVisita = null;
	private Long idProyecto = null;private String nombre = null;
	private String detalle = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idVisitaTxt = null;
	private String idProyectoTxt = null;
	
	private DtVisitasProyectoACL dtVisitasProyectoACL = null;		
		
	public DtVisitasProyectoBk() {
	}
	
	public Long getIdVisitaProyecto() {
		return this.idVisitaProyecto;
	}

	public void setIdVisitaProyecto(Long idVisitaProyecto) {
		this.idVisitaProyecto = idVisitaProyecto;
	}
	
	public Long getIdVisita() {
						return this.idVisita;
					}

	public void setIdVisita(Long idVisita) {
						this.idVisita = idVisita;
					}
	
	
public Long getIdProyecto() {
						return this.idProyecto;
					}

	public void setIdProyecto(Long idProyecto) {
						this.idProyecto = idProyecto;
					}
public String getNombre() {
						return this.nombre;
					}

	public void setNombre(String nombre) {
						this.nombre = nombre;
					}

	public String getDetalle() {
						return this.detalle;
					}

	public void setDetalle(String detalle) {
						this.detalle = detalle;
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
	
	
	
	public String getIdVisitaTxt() {
		return this.idVisitaTxt;
	}
	public void setIdVisitaTxt(String idVisitaTxt) {
		this.idVisitaTxt = idVisitaTxt;
	}
	public String getIdProyectoTxt() {
		return this.idProyectoTxt;
	}
	public void setIdProyectoTxt(String idProyectoTxt) {
		this.idProyectoTxt = idProyectoTxt;
	}
		
	
	public DtVisitasProyectoACL getDtVisitasProyectoACL() {
		return dtVisitasProyectoACL;
	}

	public void setDtVisitasProyectoACL(DtVisitasProyectoACL dtVisitasProyectoACL) {
		this.dtVisitasProyectoACL = dtVisitasProyectoACL;
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
