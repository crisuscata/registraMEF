package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.DtCapaProyectoACL;
import pe.gob.mef.registramef.bs.utils.Estado;
/**
 * DT_CAPA_PROYECTO BAKING: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
public class DtCapaProyectoBk implements java.io.Serializable {

	//ID
	private Long idCapaProyecto;
		
	//PROPIEDADES
	private Long idProyecto = null;private String nombre = null;
	private Long idCapacitacion = null;
	private String detalle = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idProyectoTxt = null;
	private String idCapacitacionTxt = null;
	
	private DtCapaProyectoACL dtCapaProyectoACL = null;		
		
	public DtCapaProyectoBk() {
	}
	
	public Long getIdCapaProyecto() {
		return this.idCapaProyecto;
	}

	public void setIdCapaProyecto(Long idCapaProyecto) {
		this.idCapaProyecto = idCapaProyecto;
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

	public Long getIdCapacitacion() {
						return this.idCapacitacion;
					}

	public void setIdCapacitacion(Long idCapacitacion) {
						this.idCapacitacion = idCapacitacion;
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
	
	
	
	public String getIdProyectoTxt() {
		return this.idProyectoTxt;
	}
	public void setIdProyectoTxt(String idProyectoTxt) {
		this.idProyectoTxt = idProyectoTxt;
	}
	public String getIdCapacitacionTxt() {
		return this.idCapacitacionTxt;
	}
	public void setIdCapacitacionTxt(String idCapacitacionTxt) {
		this.idCapacitacionTxt = idCapacitacionTxt;
	}
		
	
	public DtCapaProyectoACL getDtCapaProyectoACL() {
		return dtCapaProyectoACL;
	}

	public void setDtCapaProyectoACL(DtCapaProyectoACL dtCapaProyectoACL) {
		this.dtCapaProyectoACL = dtCapaProyectoACL;
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
