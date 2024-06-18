package pe.gob.mef.registramef.bs.transfer;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsProyectoInversionACL;

/**
 * MS_PROYECTO_INVERSION BAKING: ALMACENA LOS DATOS DE PROYECTOS DE INVERSIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
public class MsProyectoInversionDto implements java.io.Serializable {

	//ID
	private Long idProyecto;
		
	//PROPIEDADES
	private String codigo = null;
	private String nombre = null;
	private Long idSede = null;
	private Long estado = null;
	private Long idusserCrea = null;
	private Long idusserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressrst = null;
	
	
	//ADICIONALES
	private String idSedeTxt = null;
	private String estadoTxt = null;
	
	private MsProyectoInversionACL msProyectoInversionACL = null;		
		
	public MsProyectoInversionDto() {
	}
	
	public Long getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	public String getCodigo() {
						return this.codigo;
					}

	public void setCodigo(String codigo) {
						this.codigo = codigo;
					}
	
	public String getNombre() {
						return this.nombre;
					}

	public void setNombre(String nombre) {
						this.nombre = nombre;
					}
	
	public Long getIdSede() {
						return this.idSede;
					}

	public void setIdSede(Long idSede) {
						this.idSede = idSede;
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
	
	
	
	public String getIdSedeTxt() {
		return this.idSedeTxt;
	}
	public void setIdSedeTxt(String idSedeTxt) {
		this.idSedeTxt = idSedeTxt;
	}
	public String getEstadoTxt() {
		return this.estadoTxt;
	}
	public void setEstadoTxt(String estadoTxt) {
		this.estadoTxt = estadoTxt;
	}
		
	
	public MsProyectoInversionACL getMsProyectoInversionACL() {
		return msProyectoInversionACL;
	}

	public void setMsProyectoInversionACL(MsProyectoInversionACL msProyectoInversionACL) {
		this.msProyectoInversionACL = msProyectoInversionACL;
	}
	
	public String getCclase(){
		if(estado!=null && estado.intValue()>0){
			return "cverde";
		}else{
			
		}return "camarillo";
	}
       
        public void setCclase(String cclase) {
	}
        
        public String getCestado(){
		if(estado!=null && estado.intValue()>0){
			return "Activo";
		}else{			
		}
		return "Anulado";
	}
         
        public void setCestado(String cestado) {
	}

}
