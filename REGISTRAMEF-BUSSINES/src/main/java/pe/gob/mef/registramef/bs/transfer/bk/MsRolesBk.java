package pe.gob.mef.registramef.bs.transfer.bk;

import java.sql.Timestamp;

import pe.gob.mef.registramef.bs.ctlracceso.MsRolesACL;

/**
 * MS_ROLES BAKING: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------------------/-------------fecha-----------/---------------Motivo------------/
 *          /Carlos Aguilar Chamochumbi/ 18/12/2023 18:48   / Creación de la clase    /
 * 
 */
public class MsRolesBk implements java.io.Serializable {

	//ID
	private Long idrol;
		
	//PROPIEDADES
	private String username = null;
	private String rol = null;
	private Long iduserCrea = null;
	private Long iduserModif = null;
	private Timestamp fechaCrea = null;
	private Timestamp fechaModif = null;
	private String rtmaddress = null;
	private String rtmaddressmodif = null;
	private Long estado = null;
	
	
	//ADICIONALES
	
	private MsRolesACL msRolesACL = null;		
		
	public MsRolesBk() {
	}
	
	public Long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	
	public String getUsername() {
						return this.username;
					}

	public void setUsername(String username) {
						this.username = username;
					}
	
	public String getRol() {
						return this.rol;
					}

	public void setRol(String rol) {
						this.rol = rol;
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
	
	public String getRtmaddressmodif() {
						return this.rtmaddressmodif;
					}

	public void setRtmaddressmodif(String rtmaddressmodif) {
						this.rtmaddressmodif = rtmaddressmodif;
					}
	
	public Long getEstado() {
						return this.estado;
					}

	public void setEstado(Long estado) {
						this.estado = estado;
					}
	
	
	
		
	
	public MsRolesACL getMsRolesACL() {
		return msRolesACL;
	}

	public void setMsRolesACL(MsRolesACL msRolesACL) {
		this.msRolesACL = msRolesACL;
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
