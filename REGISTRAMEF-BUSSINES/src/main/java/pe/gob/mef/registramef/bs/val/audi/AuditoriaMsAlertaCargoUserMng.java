package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsAlertaCargoUser;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaCargoUserBk;

/**
 * MS_ALERTA_CARGO_USER SERVICIO AUDITORIA Y CAMBIO: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsAlertaCargoUserMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsAlertaCargoUserMng.class.getName());
	
	public static boolean auditarCambiosMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, MsAlertaCargoUser msAlertaCargoUser, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msAlertaCargoUserBk.getIdalerta() != null
							&& msAlertaCargoUser.getIdalerta() != null) {
						if (!msAlertaCargoUserBk.getIdalerta().equals(
								msAlertaCargoUser.getIdalerta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idalerta"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdalerta() + " :: "+ msAlertaCargoUserBk.getIdalerta());
								}
							cambios = true;
							msAlertaCargoUser.setIdalerta(msAlertaCargoUserBk.getIdalerta());
						}
					} else if (msAlertaCargoUserBk.getIdalerta() == null
							&& msAlertaCargoUser.getIdalerta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idalerta"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdalerta() + " :: "+ msAlertaCargoUserBk.getIdalerta());
								}
							cambios = true;
							msAlertaCargoUser.setIdalerta(msAlertaCargoUserBk.getIdalerta());
						
					} else if (msAlertaCargoUserBk.getIdalerta() != null
							&& msAlertaCargoUser.getIdalerta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idalerta"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdalerta() + " :: "+ msAlertaCargoUserBk.getIdalerta());
								}
							cambios = true;			
							msAlertaCargoUser.setIdalerta(msAlertaCargoUserBk.getIdalerta());
					}
				if (msAlertaCargoUserBk.getIdcargo() != null
							&& msAlertaCargoUser.getIdcargo() != null) {
						if (!msAlertaCargoUserBk.getIdcargo().equals(
								msAlertaCargoUser.getIdcargo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idcargo"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdcargo() + " :: "+ msAlertaCargoUserBk.getIdcargo());
								}
							cambios = true;
							msAlertaCargoUser.setIdcargo(msAlertaCargoUserBk.getIdcargo());
						}
					} else if (msAlertaCargoUserBk.getIdcargo() == null
							&& msAlertaCargoUser.getIdcargo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idcargo"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdcargo() + " :: "+ msAlertaCargoUserBk.getIdcargo());
								}
							cambios = true;
							msAlertaCargoUser.setIdcargo(msAlertaCargoUserBk.getIdcargo());
						
					} else if (msAlertaCargoUserBk.getIdcargo() != null
							&& msAlertaCargoUser.getIdcargo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Idcargo"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdcargo() + " :: "+ msAlertaCargoUserBk.getIdcargo());
								}
							cambios = true;			
							msAlertaCargoUser.setIdcargo(msAlertaCargoUserBk.getIdcargo());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsAlertaCargoUser(MsAlertaCargoUserBk msAlertaCargoUserBk, MsAlertaCargoUser msAlertaCargoUser, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (msAlertaCargoUserBk.getFechaCrea() != null
							&& msAlertaCargoUser.getFechaCrea() != null) {
						if (!msAlertaCargoUserBk.getFechaCrea().equals(
								msAlertaCargoUser.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaCrea() + " :: "+ msAlertaCargoUserBk.getFechaCrea());
								}
							cambios = true;
							msAlertaCargoUser.setFechaCrea(msAlertaCargoUserBk.getFechaCrea());
						}
					} else if (msAlertaCargoUserBk.getFechaCrea() == null
							&& msAlertaCargoUser.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaCrea() + " :: "+ msAlertaCargoUserBk.getFechaCrea());
								}
							cambios = true;
							msAlertaCargoUser.setFechaCrea(msAlertaCargoUserBk.getFechaCrea());
						
					} else if (msAlertaCargoUserBk.getFechaCrea() != null
							&& msAlertaCargoUser.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaCrea() + " :: "+ msAlertaCargoUserBk.getFechaCrea());
								}
							cambios = true;			
							msAlertaCargoUser.setFechaCrea(msAlertaCargoUserBk.getFechaCrea());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getFechaModif() != null
							&& msAlertaCargoUser.getFechaModif() != null) {
						if (!msAlertaCargoUserBk.getFechaModif().equals(
								msAlertaCargoUser.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaModif() + " :: "+ msAlertaCargoUserBk.getFechaModif());
								}
							cambios = true;
							msAlertaCargoUser.setFechaModif(msAlertaCargoUserBk.getFechaModif());
						}
					} else if (msAlertaCargoUserBk.getFechaModif() == null
							&& msAlertaCargoUser.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaModif() + " :: "+ msAlertaCargoUserBk.getFechaModif());
								}
							cambios = true;
							msAlertaCargoUser.setFechaModif(msAlertaCargoUserBk.getFechaModif());
						
					} else if (msAlertaCargoUserBk.getFechaModif() != null
							&& msAlertaCargoUser.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:FechaModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getFechaModif() + " :: "+ msAlertaCargoUserBk.getFechaModif());
								}
							cambios = true;			
							msAlertaCargoUser.setFechaModif(msAlertaCargoUserBk.getFechaModif());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getIdusserCrea() != null
							&& msAlertaCargoUser.getIdusserCrea() != null) {
						if (!msAlertaCargoUserBk.getIdusserCrea().equals(
								msAlertaCargoUser.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserCrea() + " :: "+ msAlertaCargoUserBk.getIdusserCrea());
								}
							cambios = true;
							msAlertaCargoUser.setIdusserCrea(msAlertaCargoUserBk.getIdusserCrea());
						}
					} else if (msAlertaCargoUserBk.getIdusserCrea() == null
							&& msAlertaCargoUser.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserCrea() + " :: "+ msAlertaCargoUserBk.getIdusserCrea());
								}
							cambios = true;
							msAlertaCargoUser.setIdusserCrea(msAlertaCargoUserBk.getIdusserCrea());
						
					} else if (msAlertaCargoUserBk.getIdusserCrea() != null
							&& msAlertaCargoUser.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserCrea"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserCrea() + " :: "+ msAlertaCargoUserBk.getIdusserCrea());
								}
							cambios = true;			
							msAlertaCargoUser.setIdusserCrea(msAlertaCargoUserBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getIdusserModif() != null
							&& msAlertaCargoUser.getIdusserModif() != null) {
						if (!msAlertaCargoUserBk.getIdusserModif().equals(
								msAlertaCargoUser.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserModif() + " :: "+ msAlertaCargoUserBk.getIdusserModif());
								}
							cambios = true;
							msAlertaCargoUser.setIdusserModif(msAlertaCargoUserBk.getIdusserModif());
						}
					} else if (msAlertaCargoUserBk.getIdusserModif() == null
							&& msAlertaCargoUser.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserModif() + " :: "+ msAlertaCargoUserBk.getIdusserModif());
								}
							cambios = true;
							msAlertaCargoUser.setIdusserModif(msAlertaCargoUserBk.getIdusserModif());
						
					} else if (msAlertaCargoUserBk.getIdusserModif() != null
							&& msAlertaCargoUser.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:IdusserModif"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getIdusserModif() + " :: "+ msAlertaCargoUserBk.getIdusserModif());
								}
							cambios = true;			
							msAlertaCargoUser.setIdusserModif(msAlertaCargoUserBk.getIdusserModif());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getEstado() != null
							&& msAlertaCargoUser.getEstado() != null) {
						if (!msAlertaCargoUserBk.getEstado().equals(
								msAlertaCargoUser.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Estado"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getEstado() + " :: "+ msAlertaCargoUserBk.getEstado());
								}
							cambios = true;
							msAlertaCargoUser.setEstado(msAlertaCargoUserBk.getEstado());
						}
					} else if (msAlertaCargoUserBk.getEstado() == null
							&& msAlertaCargoUser.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Estado"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getEstado() + " :: "+ msAlertaCargoUserBk.getEstado());
								}
							cambios = true;
							msAlertaCargoUser.setEstado(msAlertaCargoUserBk.getEstado());
						
					} else if (msAlertaCargoUserBk.getEstado() != null
							&& msAlertaCargoUser.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Estado"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getEstado() + " :: "+ msAlertaCargoUserBk.getEstado());
								}
							cambios = true;			
							msAlertaCargoUser.setEstado(msAlertaCargoUserBk.getEstado());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getRtmaddress() != null
							&& msAlertaCargoUser.getRtmaddress() != null) {
						if (!msAlertaCargoUserBk.getRtmaddress().equals(
								msAlertaCargoUser.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddress"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddress() + " :: "+ msAlertaCargoUserBk.getRtmaddress());
								}
							cambios = true;
							msAlertaCargoUser.setRtmaddress(msAlertaCargoUserBk.getRtmaddress());
						}
					} else if (msAlertaCargoUserBk.getRtmaddress() == null
							&& msAlertaCargoUser.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddress"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddress() + " :: "+ msAlertaCargoUserBk.getRtmaddress());
								}
							cambios = true;
							msAlertaCargoUser.setRtmaddress(msAlertaCargoUserBk.getRtmaddress());
						
					} else if (msAlertaCargoUserBk.getRtmaddress() != null
							&& msAlertaCargoUser.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddress"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddress() + " :: "+ msAlertaCargoUserBk.getRtmaddress());
								}
							cambios = true;			
							msAlertaCargoUser.setRtmaddress(msAlertaCargoUserBk.getRtmaddress());
					}
                                
				                                 
                                      if (msAlertaCargoUserBk.getRtmaddressrst() != null
							&& msAlertaCargoUser.getRtmaddressrst() != null) {
						if (!msAlertaCargoUserBk.getRtmaddressrst().equals(
								msAlertaCargoUser.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddressrst"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddressrst() + " :: "+ msAlertaCargoUserBk.getRtmaddressrst());
								}
							cambios = true;
							msAlertaCargoUser.setRtmaddressrst(msAlertaCargoUserBk.getRtmaddressrst());
						}
					} else if (msAlertaCargoUserBk.getRtmaddressrst() == null
							&& msAlertaCargoUser.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddressrst"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddressrst() + " :: "+ msAlertaCargoUserBk.getRtmaddressrst());
								}
							cambios = true;
							msAlertaCargoUser.setRtmaddressrst(msAlertaCargoUserBk.getRtmaddressrst());
						
					} else if (msAlertaCargoUserBk.getRtmaddressrst() != null
							&& msAlertaCargoUser.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlertaCargoUser:Rtmaddressrst"+" :: "+msAlertaCargoUserBk.getIdalertaCargo().toString()+" :: "+ msAlertaCargoUser.getRtmaddressrst() + " :: "+ msAlertaCargoUserBk.getRtmaddressrst());
								}
							cambios = true;			
							msAlertaCargoUser.setRtmaddressrst(msAlertaCargoUserBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}