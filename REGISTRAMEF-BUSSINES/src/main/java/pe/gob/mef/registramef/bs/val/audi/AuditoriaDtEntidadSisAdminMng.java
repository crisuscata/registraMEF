package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEntidadSisAdmin;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSisAdminBk;

/**
 * DT_ENTIDAD_SIS_ADMIN SERVICIO AUDITORIA Y CAMBIO: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEntidadSisAdminMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEntidadSisAdminMng.class.getName());
	
	public static boolean auditarCambiosDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, DtEntidadSisAdmin dtEntidadSisAdmin, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtEntidadSisAdminBk.getIdEntidad() != null
							&& dtEntidadSisAdmin.getIdEntidad() != null) {
						if (!dtEntidadSisAdminBk.getIdEntidad().equals(
								dtEntidadSisAdmin.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdEntidad"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdEntidad() + " :: "+ dtEntidadSisAdminBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdEntidad(dtEntidadSisAdminBk.getIdEntidad());
						}
					} else if (dtEntidadSisAdminBk.getIdEntidad() == null
							&& dtEntidadSisAdmin.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdEntidad"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdEntidad() + " :: "+ dtEntidadSisAdminBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdEntidad(dtEntidadSisAdminBk.getIdEntidad());
						
					} else if (dtEntidadSisAdminBk.getIdEntidad() != null
							&& dtEntidadSisAdmin.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdEntidad"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdEntidad() + " :: "+ dtEntidadSisAdminBk.getIdEntidad());
								}
							cambios = true;			
							dtEntidadSisAdmin.setIdEntidad(dtEntidadSisAdminBk.getIdEntidad());
					}
				if (dtEntidadSisAdminBk.getIdSistAdmi() != null
							&& dtEntidadSisAdmin.getIdSistAdmi() != null) {
						if (!dtEntidadSisAdminBk.getIdSistAdmi().equals(
								dtEntidadSisAdmin.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdSistAdmi"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdSistAdmi() + " :: "+ dtEntidadSisAdminBk.getIdSistAdmi());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdSistAdmi(dtEntidadSisAdminBk.getIdSistAdmi());
						}
					} else if (dtEntidadSisAdminBk.getIdSistAdmi() == null
							&& dtEntidadSisAdmin.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdSistAdmi"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdSistAdmi() + " :: "+ dtEntidadSisAdminBk.getIdSistAdmi());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdSistAdmi(dtEntidadSisAdminBk.getIdSistAdmi());
						
					} else if (dtEntidadSisAdminBk.getIdSistAdmi() != null
							&& dtEntidadSisAdmin.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdSistAdmi"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdSistAdmi() + " :: "+ dtEntidadSisAdminBk.getIdSistAdmi());
								}
							cambios = true;			
							dtEntidadSisAdmin.setIdSistAdmi(dtEntidadSisAdminBk.getIdSistAdmi());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtEntidadSisAdmin(DtEntidadSisAdminBk dtEntidadSisAdminBk, DtEntidadSisAdmin dtEntidadSisAdmin, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (dtEntidadSisAdminBk.getFechaCrea() != null
							&& dtEntidadSisAdmin.getFechaCrea() != null) {
						if (!dtEntidadSisAdminBk.getFechaCrea().equals(
								dtEntidadSisAdmin.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaCrea() + " :: "+ dtEntidadSisAdminBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadSisAdmin.setFechaCrea(dtEntidadSisAdminBk.getFechaCrea());
						}
					} else if (dtEntidadSisAdminBk.getFechaCrea() == null
							&& dtEntidadSisAdmin.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaCrea() + " :: "+ dtEntidadSisAdminBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadSisAdmin.setFechaCrea(dtEntidadSisAdminBk.getFechaCrea());
						
					} else if (dtEntidadSisAdminBk.getFechaCrea() != null
							&& dtEntidadSisAdmin.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaCrea() + " :: "+ dtEntidadSisAdminBk.getFechaCrea());
								}
							cambios = true;			
							dtEntidadSisAdmin.setFechaCrea(dtEntidadSisAdminBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getFechaModif() != null
							&& dtEntidadSisAdmin.getFechaModif() != null) {
						if (!dtEntidadSisAdminBk.getFechaModif().equals(
								dtEntidadSisAdmin.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaModif() + " :: "+ dtEntidadSisAdminBk.getFechaModif());
								}
							cambios = true;
							dtEntidadSisAdmin.setFechaModif(dtEntidadSisAdminBk.getFechaModif());
						}
					} else if (dtEntidadSisAdminBk.getFechaModif() == null
							&& dtEntidadSisAdmin.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaModif() + " :: "+ dtEntidadSisAdminBk.getFechaModif());
								}
							cambios = true;
							dtEntidadSisAdmin.setFechaModif(dtEntidadSisAdminBk.getFechaModif());
						
					} else if (dtEntidadSisAdminBk.getFechaModif() != null
							&& dtEntidadSisAdmin.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:FechaModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getFechaModif() + " :: "+ dtEntidadSisAdminBk.getFechaModif());
								}
							cambios = true;			
							dtEntidadSisAdmin.setFechaModif(dtEntidadSisAdminBk.getFechaModif());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getIdusserCrea() != null
							&& dtEntidadSisAdmin.getIdusserCrea() != null) {
						if (!dtEntidadSisAdminBk.getIdusserCrea().equals(
								dtEntidadSisAdmin.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserCrea() + " :: "+ dtEntidadSisAdminBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdusserCrea(dtEntidadSisAdminBk.getIdusserCrea());
						}
					} else if (dtEntidadSisAdminBk.getIdusserCrea() == null
							&& dtEntidadSisAdmin.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserCrea() + " :: "+ dtEntidadSisAdminBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdusserCrea(dtEntidadSisAdminBk.getIdusserCrea());
						
					} else if (dtEntidadSisAdminBk.getIdusserCrea() != null
							&& dtEntidadSisAdmin.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserCrea"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserCrea() + " :: "+ dtEntidadSisAdminBk.getIdusserCrea());
								}
							cambios = true;			
							dtEntidadSisAdmin.setIdusserCrea(dtEntidadSisAdminBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getIdusserModif() != null
							&& dtEntidadSisAdmin.getIdusserModif() != null) {
						if (!dtEntidadSisAdminBk.getIdusserModif().equals(
								dtEntidadSisAdmin.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserModif() + " :: "+ dtEntidadSisAdminBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdusserModif(dtEntidadSisAdminBk.getIdusserModif());
						}
					} else if (dtEntidadSisAdminBk.getIdusserModif() == null
							&& dtEntidadSisAdmin.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserModif() + " :: "+ dtEntidadSisAdminBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadSisAdmin.setIdusserModif(dtEntidadSisAdminBk.getIdusserModif());
						
					} else if (dtEntidadSisAdminBk.getIdusserModif() != null
							&& dtEntidadSisAdmin.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:IdusserModif"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getIdusserModif() + " :: "+ dtEntidadSisAdminBk.getIdusserModif());
								}
							cambios = true;			
							dtEntidadSisAdmin.setIdusserModif(dtEntidadSisAdminBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getEstado() != null
							&& dtEntidadSisAdmin.getEstado() != null) {
						if (!dtEntidadSisAdminBk.getEstado().equals(
								dtEntidadSisAdmin.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Estado"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getEstado() + " :: "+ dtEntidadSisAdminBk.getEstado());
								}
							cambios = true;
							dtEntidadSisAdmin.setEstado(dtEntidadSisAdminBk.getEstado());
						}
					} else if (dtEntidadSisAdminBk.getEstado() == null
							&& dtEntidadSisAdmin.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Estado"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getEstado() + " :: "+ dtEntidadSisAdminBk.getEstado());
								}
							cambios = true;
							dtEntidadSisAdmin.setEstado(dtEntidadSisAdminBk.getEstado());
						
					} else if (dtEntidadSisAdminBk.getEstado() != null
							&& dtEntidadSisAdmin.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Estado"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getEstado() + " :: "+ dtEntidadSisAdminBk.getEstado());
								}
							cambios = true;			
							dtEntidadSisAdmin.setEstado(dtEntidadSisAdminBk.getEstado());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getRtmaddress() != null
							&& dtEntidadSisAdmin.getRtmaddress() != null) {
						if (!dtEntidadSisAdminBk.getRtmaddress().equals(
								dtEntidadSisAdmin.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddress"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddress() + " :: "+ dtEntidadSisAdminBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadSisAdmin.setRtmaddress(dtEntidadSisAdminBk.getRtmaddress());
						}
					} else if (dtEntidadSisAdminBk.getRtmaddress() == null
							&& dtEntidadSisAdmin.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddress"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddress() + " :: "+ dtEntidadSisAdminBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadSisAdmin.setRtmaddress(dtEntidadSisAdminBk.getRtmaddress());
						
					} else if (dtEntidadSisAdminBk.getRtmaddress() != null
							&& dtEntidadSisAdmin.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddress"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddress() + " :: "+ dtEntidadSisAdminBk.getRtmaddress());
								}
							cambios = true;			
							dtEntidadSisAdmin.setRtmaddress(dtEntidadSisAdminBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEntidadSisAdminBk.getRtmaddressrst() != null
							&& dtEntidadSisAdmin.getRtmaddressrst() != null) {
						if (!dtEntidadSisAdminBk.getRtmaddressrst().equals(
								dtEntidadSisAdmin.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddressrst"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddressrst() + " :: "+ dtEntidadSisAdminBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadSisAdmin.setRtmaddressrst(dtEntidadSisAdminBk.getRtmaddressrst());
						}
					} else if (dtEntidadSisAdminBk.getRtmaddressrst() == null
							&& dtEntidadSisAdmin.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddressrst"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddressrst() + " :: "+ dtEntidadSisAdminBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadSisAdmin.setRtmaddressrst(dtEntidadSisAdminBk.getRtmaddressrst());
						
					} else if (dtEntidadSisAdminBk.getRtmaddressrst() != null
							&& dtEntidadSisAdmin.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSisAdmin:Rtmaddressrst"+" :: "+dtEntidadSisAdminBk.getIdentidadSisadm().toString()+" :: "+ dtEntidadSisAdmin.getRtmaddressrst() + " :: "+ dtEntidadSisAdminBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEntidadSisAdmin.setRtmaddressrst(dtEntidadSisAdminBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}