package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsAlerta;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaBk;

/**
 * MS_ALERTA SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS ALERTAS GENERADAS EN EL SISTMA "ALERTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsAlertaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsAlertaMng.class.getName());
	
	public static boolean auditarCambiosMsAlerta(MsAlertaBk msAlertaBk, MsAlerta msAlerta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msAlertaBk.getDia() != null
							&& msAlerta.getDia() != null) {
						if (!msAlertaBk.getDia().equals(
								msAlerta.getDia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Dia"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getDia() + " :: "+ msAlertaBk.getDia());
								}
							cambios = true;
							msAlerta.setDia(msAlertaBk.getDia());
						}
					} else if (msAlertaBk.getDia() == null
							&& msAlerta.getDia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Dia"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getDia() + " :: "+ msAlertaBk.getDia());
								}
							cambios = true;
							msAlerta.setDia(msAlertaBk.getDia());
						
					} else if (msAlertaBk.getDia() != null
							&& msAlerta.getDia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Dia"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getDia() + " :: "+ msAlertaBk.getDia());
								}
							cambios = true;			
							msAlerta.setDia(msAlertaBk.getDia());
					}
				if (msAlertaBk.getHora() != null
							&& msAlerta.getHora() != null) {
						if (!msAlertaBk.getHora().equals(
								msAlerta.getHora())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Hora"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getHora() + " :: "+ msAlertaBk.getHora());
								}
							cambios = true;
							msAlerta.setHora(msAlertaBk.getHora());
						}
					} else if (msAlertaBk.getHora() == null
							&& msAlerta.getHora() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Hora"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getHora() + " :: "+ msAlertaBk.getHora());
								}
							cambios = true;
							msAlerta.setHora(msAlertaBk.getHora());
						
					} else if (msAlertaBk.getHora() != null
							&& msAlerta.getHora() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Hora"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getHora() + " :: "+ msAlertaBk.getHora());
								}
							cambios = true;			
							msAlerta.setHora(msAlertaBk.getHora());
					}
				 
		            if (msAlertaBk.getOtrosDestin() != null
						&& msAlerta.getOtrosDestin() != null) {
					if (!msAlertaBk.getOtrosDestin().equals(
						msAlerta.getOtrosDestin())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:OtrosDestin"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getOtrosDestin() + " :: "+ msAlertaBk.getOtrosDestin());								
						}
						cambios = true;
						msAlerta.setOtrosDestin(msAlertaBk.getOtrosDestin());
					}
				} else if (msAlertaBk.getOtrosDestin() == null
						&& msAlerta.getOtrosDestin() != null) {
					if (msAlerta.getOtrosDestin().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:OtrosDestin"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getOtrosDestin() + " :: "+ msAlertaBk.getOtrosDestin());
						}
						cambios = true;
						msAlerta.setOtrosDestin(msAlertaBk.getOtrosDestin());
					}
				} else if (msAlertaBk.getOtrosDestin() != null
						&& msAlerta.getOtrosDestin() == null) {
					if (msAlertaBk.getOtrosDestin().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:OtrosDestin"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getOtrosDestin() + " :: "+ msAlertaBk.getOtrosDestin());
						}
						cambios = true;
						msAlerta.setOtrosDestin(msAlertaBk.getOtrosDestin());
					}
				}
				if (msAlertaBk.getIdCaracterst() != null
							&& msAlerta.getIdCaracterst() != null) {
						if (!msAlertaBk.getIdCaracterst().equals(
								msAlerta.getIdCaracterst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdCaracterst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdCaracterst() + " :: "+ msAlertaBk.getIdCaracterst());
								}
							cambios = true;
							msAlerta.setIdCaracterst(msAlertaBk.getIdCaracterst());
						}
					} else if (msAlertaBk.getIdCaracterst() == null
							&& msAlerta.getIdCaracterst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdCaracterst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdCaracterst() + " :: "+ msAlertaBk.getIdCaracterst());
								}
							cambios = true;
							msAlerta.setIdCaracterst(msAlertaBk.getIdCaracterst());
						
					} else if (msAlertaBk.getIdCaracterst() != null
							&& msAlerta.getIdCaracterst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdCaracterst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdCaracterst() + " :: "+ msAlertaBk.getIdCaracterst());
								}
							cambios = true;			
							msAlerta.setIdCaracterst(msAlertaBk.getIdCaracterst());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsAlerta(MsAlertaBk msAlertaBk, MsAlerta msAlerta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (msAlertaBk.getFechaCrea() != null
							&& msAlerta.getFechaCrea() != null) {
						if (!msAlertaBk.getFechaCrea().equals(
								msAlerta.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaCrea() + " :: "+ msAlertaBk.getFechaCrea());
								}
							cambios = true;
							msAlerta.setFechaCrea(msAlertaBk.getFechaCrea());
						}
					} else if (msAlertaBk.getFechaCrea() == null
							&& msAlerta.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaCrea() + " :: "+ msAlertaBk.getFechaCrea());
								}
							cambios = true;
							msAlerta.setFechaCrea(msAlertaBk.getFechaCrea());
						
					} else if (msAlertaBk.getFechaCrea() != null
							&& msAlerta.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaCrea() + " :: "+ msAlertaBk.getFechaCrea());
								}
							cambios = true;			
							msAlerta.setFechaCrea(msAlertaBk.getFechaCrea());
					}
                                
				                                 
                                      if (msAlertaBk.getFechaModif() != null
							&& msAlerta.getFechaModif() != null) {
						if (!msAlertaBk.getFechaModif().equals(
								msAlerta.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaModif() + " :: "+ msAlertaBk.getFechaModif());
								}
							cambios = true;
							msAlerta.setFechaModif(msAlertaBk.getFechaModif());
						}
					} else if (msAlertaBk.getFechaModif() == null
							&& msAlerta.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaModif() + " :: "+ msAlertaBk.getFechaModif());
								}
							cambios = true;
							msAlerta.setFechaModif(msAlertaBk.getFechaModif());
						
					} else if (msAlertaBk.getFechaModif() != null
							&& msAlerta.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:FechaModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getFechaModif() + " :: "+ msAlertaBk.getFechaModif());
								}
							cambios = true;			
							msAlerta.setFechaModif(msAlertaBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (msAlertaBk.getIdusserCrea() != null
							&& msAlerta.getIdusserCrea() != null) {
						if (!msAlertaBk.getIdusserCrea().equals(
								msAlerta.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserCrea() + " :: "+ msAlertaBk.getIdusserCrea());
								}
							cambios = true;
							msAlerta.setIdusserCrea(msAlertaBk.getIdusserCrea());
						}
					} else if (msAlertaBk.getIdusserCrea() == null
							&& msAlerta.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserCrea() + " :: "+ msAlertaBk.getIdusserCrea());
								}
							cambios = true;
							msAlerta.setIdusserCrea(msAlertaBk.getIdusserCrea());
						
					} else if (msAlertaBk.getIdusserCrea() != null
							&& msAlerta.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserCrea"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserCrea() + " :: "+ msAlertaBk.getIdusserCrea());
								}
							cambios = true;			
							msAlerta.setIdusserCrea(msAlertaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msAlertaBk.getIdusserModif() != null
							&& msAlerta.getIdusserModif() != null) {
						if (!msAlertaBk.getIdusserModif().equals(
								msAlerta.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserModif() + " :: "+ msAlertaBk.getIdusserModif());
								}
							cambios = true;
							msAlerta.setIdusserModif(msAlertaBk.getIdusserModif());
						}
					} else if (msAlertaBk.getIdusserModif() == null
							&& msAlerta.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserModif() + " :: "+ msAlertaBk.getIdusserModif());
								}
							cambios = true;
							msAlerta.setIdusserModif(msAlertaBk.getIdusserModif());
						
					} else if (msAlertaBk.getIdusserModif() != null
							&& msAlerta.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:IdusserModif"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getIdusserModif() + " :: "+ msAlertaBk.getIdusserModif());
								}
							cambios = true;			
							msAlerta.setIdusserModif(msAlertaBk.getIdusserModif());
					}
                                
				
				
				                                 
                                      if (msAlertaBk.getEstado() != null
							&& msAlerta.getEstado() != null) {
						if (!msAlertaBk.getEstado().equals(
								msAlerta.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Estado"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getEstado() + " :: "+ msAlertaBk.getEstado());
								}
							cambios = true;
							msAlerta.setEstado(msAlertaBk.getEstado());
						}
					} else if (msAlertaBk.getEstado() == null
							&& msAlerta.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Estado"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getEstado() + " :: "+ msAlertaBk.getEstado());
								}
							cambios = true;
							msAlerta.setEstado(msAlertaBk.getEstado());
						
					} else if (msAlertaBk.getEstado() != null
							&& msAlerta.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Estado"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getEstado() + " :: "+ msAlertaBk.getEstado());
								}
							cambios = true;			
							msAlerta.setEstado(msAlertaBk.getEstado());
					}
                                
				                                 
                                      if (msAlertaBk.getRtmaddress() != null
							&& msAlerta.getRtmaddress() != null) {
						if (!msAlertaBk.getRtmaddress().equals(
								msAlerta.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddress"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddress() + " :: "+ msAlertaBk.getRtmaddress());
								}
							cambios = true;
							msAlerta.setRtmaddress(msAlertaBk.getRtmaddress());
						}
					} else if (msAlertaBk.getRtmaddress() == null
							&& msAlerta.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddress"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddress() + " :: "+ msAlertaBk.getRtmaddress());
								}
							cambios = true;
							msAlerta.setRtmaddress(msAlertaBk.getRtmaddress());
						
					} else if (msAlertaBk.getRtmaddress() != null
							&& msAlerta.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddress"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddress() + " :: "+ msAlertaBk.getRtmaddress());
								}
							cambios = true;			
							msAlerta.setRtmaddress(msAlertaBk.getRtmaddress());
					}
                                
				                                 
                                      if (msAlertaBk.getRtmaddressrst() != null
							&& msAlerta.getRtmaddressrst() != null) {
						if (!msAlertaBk.getRtmaddressrst().equals(
								msAlerta.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddressrst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddressrst() + " :: "+ msAlertaBk.getRtmaddressrst());
								}
							cambios = true;
							msAlerta.setRtmaddressrst(msAlertaBk.getRtmaddressrst());
						}
					} else if (msAlertaBk.getRtmaddressrst() == null
							&& msAlerta.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddressrst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddressrst() + " :: "+ msAlertaBk.getRtmaddressrst());
								}
							cambios = true;
							msAlerta.setRtmaddressrst(msAlertaBk.getRtmaddressrst());
						
					} else if (msAlertaBk.getRtmaddressrst() != null
							&& msAlerta.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msAlerta:Rtmaddressrst"+" :: "+msAlertaBk.getIdAlerta().toString()+" :: "+ msAlerta.getRtmaddressrst() + " :: "+ msAlertaBk.getRtmaddressrst());
								}
							cambios = true;			
							msAlerta.setRtmaddressrst(msAlertaBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}