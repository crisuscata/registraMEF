package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsRoles;
import pe.gob.mef.registramef.bs.transfer.bk.MsRolesBk;

/**
 * MS_ROLES SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsRolesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsRolesMng.class.getName());
	
	public static boolean auditarCambiosMsRoles(MsRolesBk msRolesBk, MsRoles msRoles, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msRolesBk.getUsername() != null
						&& msRoles.getUsername() != null) {
					if (!msRolesBk.getUsername().equals(
						msRoles.getUsername())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Username"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getUsername() + " :: "+ msRolesBk.getUsername());								
						}
						cambios = true;
						msRoles.setUsername(msRolesBk.getUsername());
					}
				} else if (msRolesBk.getUsername() == null
						&& msRoles.getUsername() != null) {
					if (msRoles.getUsername().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Username"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getUsername() + " :: "+ msRolesBk.getUsername());
						}
						cambios = true;
						msRoles.setUsername(msRolesBk.getUsername());
					}
				} else if (msRolesBk.getUsername() != null
						&& msRoles.getUsername() == null) {
					if (msRolesBk.getUsername().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Username"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getUsername() + " :: "+ msRolesBk.getUsername());
						}
						cambios = true;
						msRoles.setUsername(msRolesBk.getUsername());
					}
				}
				 
		            if (msRolesBk.getRol() != null
						&& msRoles.getRol() != null) {
					if (!msRolesBk.getRol().equals(
						msRoles.getRol())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rol"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRol() + " :: "+ msRolesBk.getRol());								
						}
						cambios = true;
						msRoles.setRol(msRolesBk.getRol());
					}
				} else if (msRolesBk.getRol() == null
						&& msRoles.getRol() != null) {
					if (msRoles.getRol().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rol"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRol() + " :: "+ msRolesBk.getRol());
						}
						cambios = true;
						msRoles.setRol(msRolesBk.getRol());
					}
				} else if (msRolesBk.getRol() != null
						&& msRoles.getRol() == null) {
					if (msRolesBk.getRol().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rol"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRol() + " :: "+ msRolesBk.getRol());
						}
						cambios = true;
						msRoles.setRol(msRolesBk.getRol());
					}
				}
		            
		            if (msRolesBk.getEstado() != null
							&& msRoles.getEstado() != null) {
						if (!msRolesBk.getEstado().equals(
							msRoles.getEstado())) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getEstado().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());								
							}
							cambios = true;
							msRoles.setEstado(msRolesBk.getEstado());
						}
					} else if (msRolesBk.getEstado() == null
							&& msRoles.getEstado() != null) {					
							if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getEstado().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());
							}
							cambios = true;
							msRoles.setEstado(msRolesBk.getEstado());
					} else if (msRolesBk.getEstado() != null
							&& msRoles.getEstado() == null) {						
							if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getEstado().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());
							}
							cambios = true;
							msRoles.setEstado(msRolesBk.getEstado());
						}
		            
		            
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsRoles(MsRolesBk msRolesBk, MsRoles msRoles, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (msRolesBk.getIduserCrea() != null
							&& msRoles.getIduserCrea() != null) {
						if (!msRolesBk.getIduserCrea().equals(
								msRoles.getIduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserCrea() + " :: "+ msRolesBk.getIduserCrea());
								}
							cambios = true;
							msRoles.setIduserCrea(msRolesBk.getIduserCrea());
						}
					} else if (msRolesBk.getIduserCrea() == null
							&& msRoles.getIduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserCrea() + " :: "+ msRolesBk.getIduserCrea());
								}
							cambios = true;
							msRoles.setIduserCrea(msRolesBk.getIduserCrea());
						
					} else if (msRolesBk.getIduserCrea() != null
							&& msRoles.getIduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserCrea() + " :: "+ msRolesBk.getIduserCrea());
								}
							cambios = true;			
							msRoles.setIduserCrea(msRolesBk.getIduserCrea());
					}
                                
				                                 
                                      if (msRolesBk.getIduserModif() != null
							&& msRoles.getIduserModif() != null) {
						if (!msRolesBk.getIduserModif().equals(
								msRoles.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserModif() + " :: "+ msRolesBk.getIduserModif());
								}
							cambios = true;
							msRoles.setIduserModif(msRolesBk.getIduserModif());
						}
					} else if (msRolesBk.getIduserModif() == null
							&& msRoles.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserModif() + " :: "+ msRolesBk.getIduserModif());
								}
							cambios = true;
							msRoles.setIduserModif(msRolesBk.getIduserModif());
						
					} else if (msRolesBk.getIduserModif() != null
							&& msRoles.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:IduserModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getIduserModif() + " :: "+ msRolesBk.getIduserModif());
								}
							cambios = true;			
							msRoles.setIduserModif(msRolesBk.getIduserModif());
					}
                                
				                                 
                                      if (msRolesBk.getFechaCrea() != null
							&& msRoles.getFechaCrea() != null) {
						if (!msRolesBk.getFechaCrea().equals(
								msRoles.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaCrea() + " :: "+ msRolesBk.getFechaCrea());
								}
							cambios = true;
							msRoles.setFechaCrea(msRolesBk.getFechaCrea());
						}
					} else if (msRolesBk.getFechaCrea() == null
							&& msRoles.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaCrea() + " :: "+ msRolesBk.getFechaCrea());
								}
							cambios = true;
							msRoles.setFechaCrea(msRolesBk.getFechaCrea());
						
					} else if (msRolesBk.getFechaCrea() != null
							&& msRoles.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaCrea"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaCrea() + " :: "+ msRolesBk.getFechaCrea());
								}
							cambios = true;			
							msRoles.setFechaCrea(msRolesBk.getFechaCrea());
					}
                                
				                                 
                                      if (msRolesBk.getFechaModif() != null
							&& msRoles.getFechaModif() != null) {
						if (!msRolesBk.getFechaModif().equals(
								msRoles.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaModif() + " :: "+ msRolesBk.getFechaModif());
								}
							cambios = true;
							msRoles.setFechaModif(msRolesBk.getFechaModif());
						}
					} else if (msRolesBk.getFechaModif() == null
							&& msRoles.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaModif() + " :: "+ msRolesBk.getFechaModif());
								}
							cambios = true;
							msRoles.setFechaModif(msRolesBk.getFechaModif());
						
					} else if (msRolesBk.getFechaModif() != null
							&& msRoles.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:FechaModif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getFechaModif() + " :: "+ msRolesBk.getFechaModif());
								}
							cambios = true;			
							msRoles.setFechaModif(msRolesBk.getFechaModif());
					}
                                
				                                 
                                      if (msRolesBk.getRtmaddress() != null
							&& msRoles.getRtmaddress() != null) {
						if (!msRolesBk.getRtmaddress().equals(
								msRoles.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddress"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddress() + " :: "+ msRolesBk.getRtmaddress());
								}
							cambios = true;
							msRoles.setRtmaddress(msRolesBk.getRtmaddress());
						}
					} else if (msRolesBk.getRtmaddress() == null
							&& msRoles.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddress"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddress() + " :: "+ msRolesBk.getRtmaddress());
								}
							cambios = true;
							msRoles.setRtmaddress(msRolesBk.getRtmaddress());
						
					} else if (msRolesBk.getRtmaddress() != null
							&& msRoles.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddress"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddress() + " :: "+ msRolesBk.getRtmaddress());
								}
							cambios = true;			
							msRoles.setRtmaddress(msRolesBk.getRtmaddress());
					}
                                
				                                 
                                      if (msRolesBk.getRtmaddressmodif() != null
							&& msRoles.getRtmaddressmodif() != null) {
						if (!msRolesBk.getRtmaddressmodif().equals(
								msRoles.getRtmaddressmodif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddressmodif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddressmodif() + " :: "+ msRolesBk.getRtmaddressmodif());
								}
							cambios = true;
							msRoles.setRtmaddressmodif(msRolesBk.getRtmaddressmodif());
						}
					} else if (msRolesBk.getRtmaddressmodif() == null
							&& msRoles.getRtmaddressmodif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddressmodif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddressmodif() + " :: "+ msRolesBk.getRtmaddressmodif());
								}
							cambios = true;
							msRoles.setRtmaddressmodif(msRolesBk.getRtmaddressmodif());
						
					} else if (msRolesBk.getRtmaddressmodif() != null
							&& msRoles.getRtmaddressmodif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Rtmaddressmodif"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getRtmaddressmodif() + " :: "+ msRolesBk.getRtmaddressmodif());
								}
							cambios = true;			
							msRoles.setRtmaddressmodif(msRolesBk.getRtmaddressmodif());
					}
                                
				                                 
                                      if (msRolesBk.getEstado() != null
							&& msRoles.getEstado() != null) {
						if (!msRolesBk.getEstado().equals(
								msRoles.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());
								}
							cambios = true;
							msRoles.setEstado(msRolesBk.getEstado());
						}
					} else if (msRolesBk.getEstado() == null
							&& msRoles.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());
								}
							cambios = true;
							msRoles.setEstado(msRolesBk.getEstado());
						
					} else if (msRolesBk.getEstado() != null
							&& msRoles.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msRoles:Estado"+" :: "+msRolesBk.getIdrol().toString()+" :: "+ msRoles.getEstado() + " :: "+ msRolesBk.getEstado());
								}
							cambios = true;			
							msRoles.setEstado(msRolesBk.getEstado());
					}
                                
				
			
			return cambios;
	}
}