package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtVisitasTemas;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasTemasBk;

/**
 * DT_VISITAS_TEMAS SERVICIO AUDITORIA Y CAMBIO: ALAMACENA LOS TEMAS DE LA VISITA "TEMAS DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtVisitasTemasMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtVisitasTemasMng.class.getName());
	
	public static boolean auditarCambiosDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, DtVisitasTemas dtVisitasTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtVisitasTemasBk.getIdVisita() != null
							&& dtVisitasTemas.getIdVisita() != null) {
						if (!dtVisitasTemasBk.getIdVisita().equals(
								dtVisitasTemas.getIdVisita())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdVisita"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdVisita() + " :: "+ dtVisitasTemasBk.getIdVisita());
								}
							cambios = true;
							dtVisitasTemas.setIdVisita(dtVisitasTemasBk.getIdVisita());
						}
					} else if (dtVisitasTemasBk.getIdVisita() == null
							&& dtVisitasTemas.getIdVisita() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdVisita"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdVisita() + " :: "+ dtVisitasTemasBk.getIdVisita());
								}
							cambios = true;
							dtVisitasTemas.setIdVisita(dtVisitasTemasBk.getIdVisita());
						
					} else if (dtVisitasTemasBk.getIdVisita() != null
							&& dtVisitasTemas.getIdVisita() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdVisita"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdVisita() + " :: "+ dtVisitasTemasBk.getIdVisita());
								}
							cambios = true;			
							dtVisitasTemas.setIdVisita(dtVisitasTemasBk.getIdVisita());
					}
				if (dtVisitasTemasBk.getIdTema() != null
							&& dtVisitasTemas.getIdTema() != null) {
						if (!dtVisitasTemasBk.getIdTema().equals(
								dtVisitasTemas.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdTema"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdTema() + " :: "+ dtVisitasTemasBk.getIdTema());
								}
							cambios = true;
							dtVisitasTemas.setIdTema(dtVisitasTemasBk.getIdTema());
						}
					} else if (dtVisitasTemasBk.getIdTema() == null
							&& dtVisitasTemas.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdTema"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdTema() + " :: "+ dtVisitasTemasBk.getIdTema());
								}
							cambios = true;
							dtVisitasTemas.setIdTema(dtVisitasTemasBk.getIdTema());
						
					} else if (dtVisitasTemasBk.getIdTema() != null
							&& dtVisitasTemas.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IdTema"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIdTema() + " :: "+ dtVisitasTemasBk.getIdTema());
								}
							cambios = true;			
							dtVisitasTemas.setIdTema(dtVisitasTemasBk.getIdTema());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtVisitasTemas(DtVisitasTemasBk dtVisitasTemasBk, DtVisitasTemas dtVisitasTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtVisitasTemasBk.getFechaCrea() != null
							&& dtVisitasTemas.getFechaCrea() != null) {
						if (!dtVisitasTemasBk.getFechaCrea().equals(
								dtVisitasTemas.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaCrea() + " :: "+ dtVisitasTemasBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasTemas.setFechaCrea(dtVisitasTemasBk.getFechaCrea());
						}
					} else if (dtVisitasTemasBk.getFechaCrea() == null
							&& dtVisitasTemas.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaCrea() + " :: "+ dtVisitasTemasBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasTemas.setFechaCrea(dtVisitasTemasBk.getFechaCrea());
						
					} else if (dtVisitasTemasBk.getFechaCrea() != null
							&& dtVisitasTemas.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaCrea() + " :: "+ dtVisitasTemasBk.getFechaCrea());
								}
							cambios = true;			
							dtVisitasTemas.setFechaCrea(dtVisitasTemasBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtVisitasTemasBk.getFechaModif() != null
							&& dtVisitasTemas.getFechaModif() != null) {
						if (!dtVisitasTemasBk.getFechaModif().equals(
								dtVisitasTemas.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaModif() + " :: "+ dtVisitasTemasBk.getFechaModif());
								}
							cambios = true;
							dtVisitasTemas.setFechaModif(dtVisitasTemasBk.getFechaModif());
						}
					} else if (dtVisitasTemasBk.getFechaModif() == null
							&& dtVisitasTemas.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaModif() + " :: "+ dtVisitasTemasBk.getFechaModif());
								}
							cambios = true;
							dtVisitasTemas.setFechaModif(dtVisitasTemasBk.getFechaModif());
						
					} else if (dtVisitasTemasBk.getFechaModif() != null
							&& dtVisitasTemas.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:FechaModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getFechaModif() + " :: "+ dtVisitasTemasBk.getFechaModif());
								}
							cambios = true;			
							dtVisitasTemas.setFechaModif(dtVisitasTemasBk.getFechaModif());
					}
                                
				                                 
                                      if (dtVisitasTemasBk.getDuserCrea() != null
							&& dtVisitasTemas.getDuserCrea() != null) {
						if (!dtVisitasTemasBk.getDuserCrea().equals(
								dtVisitasTemas.getDuserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:DuserCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getDuserCrea() + " :: "+ dtVisitasTemasBk.getDuserCrea());
								}
							cambios = true;
							dtVisitasTemas.setDuserCrea(dtVisitasTemasBk.getDuserCrea());
						}
					} else if (dtVisitasTemasBk.getDuserCrea() == null
							&& dtVisitasTemas.getDuserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:DuserCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getDuserCrea() + " :: "+ dtVisitasTemasBk.getDuserCrea());
								}
							cambios = true;
							dtVisitasTemas.setDuserCrea(dtVisitasTemasBk.getDuserCrea());
						
					} else if (dtVisitasTemasBk.getDuserCrea() != null
							&& dtVisitasTemas.getDuserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:DuserCrea"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getDuserCrea() + " :: "+ dtVisitasTemasBk.getDuserCrea());
								}
							cambios = true;			
							dtVisitasTemas.setDuserCrea(dtVisitasTemasBk.getDuserCrea());
					}
                                
				                                 
                                      if (dtVisitasTemasBk.getIduserModif() != null
							&& dtVisitasTemas.getIduserModif() != null) {
						if (!dtVisitasTemasBk.getIduserModif().equals(
								dtVisitasTemas.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IduserModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIduserModif() + " :: "+ dtVisitasTemasBk.getIduserModif());
								}
							cambios = true;
							dtVisitasTemas.setIduserModif(dtVisitasTemasBk.getIduserModif());
						}
					} else if (dtVisitasTemasBk.getIduserModif() == null
							&& dtVisitasTemas.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IduserModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIduserModif() + " :: "+ dtVisitasTemasBk.getIduserModif());
								}
							cambios = true;
							dtVisitasTemas.setIduserModif(dtVisitasTemasBk.getIduserModif());
						
					} else if (dtVisitasTemasBk.getIduserModif() != null
							&& dtVisitasTemas.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:IduserModif"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getIduserModif() + " :: "+ dtVisitasTemasBk.getIduserModif());
								}
							cambios = true;			
							dtVisitasTemas.setIduserModif(dtVisitasTemasBk.getIduserModif());
					}
                                
				                                 
                                      if (dtVisitasTemasBk.getEstado() != null
							&& dtVisitasTemas.getEstado() != null) {
						if (!dtVisitasTemasBk.getEstado().equals(
								dtVisitasTemas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Estado"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getEstado() + " :: "+ dtVisitasTemasBk.getEstado());
								}
							cambios = true;
							dtVisitasTemas.setEstado(dtVisitasTemasBk.getEstado());
						}
					} else if (dtVisitasTemasBk.getEstado() == null
							&& dtVisitasTemas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Estado"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getEstado() + " :: "+ dtVisitasTemasBk.getEstado());
								}
							cambios = true;
							dtVisitasTemas.setEstado(dtVisitasTemasBk.getEstado());
						
					} else if (dtVisitasTemasBk.getEstado() != null
							&& dtVisitasTemas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Estado"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getEstado() + " :: "+ dtVisitasTemasBk.getEstado());
								}
							cambios = true;			
							dtVisitasTemas.setEstado(dtVisitasTemasBk.getEstado());
					}
                                
				
				                                 
                                      if (dtVisitasTemasBk.getRtmaddress() != null
							&& dtVisitasTemas.getRtmaddress() != null) {
						if (!dtVisitasTemasBk.getRtmaddress().equals(
								dtVisitasTemas.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddress"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddress() + " :: "+ dtVisitasTemasBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasTemas.setRtmaddress(dtVisitasTemasBk.getRtmaddress());
						}
					} else if (dtVisitasTemasBk.getRtmaddress() == null
							&& dtVisitasTemas.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddress"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddress() + " :: "+ dtVisitasTemasBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasTemas.setRtmaddress(dtVisitasTemasBk.getRtmaddress());
						
					} else if (dtVisitasTemasBk.getRtmaddress() != null
							&& dtVisitasTemas.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddress"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddress() + " :: "+ dtVisitasTemasBk.getRtmaddress());
								}
							cambios = true;			
							dtVisitasTemas.setRtmaddress(dtVisitasTemasBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtVisitasTemasBk.getRtmaddressrst() != null
							&& dtVisitasTemas.getRtmaddressrst() != null) {
						if (!dtVisitasTemasBk.getRtmaddressrst().equals(
								dtVisitasTemas.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddressrst"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddressrst() + " :: "+ dtVisitasTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasTemas.setRtmaddressrst(dtVisitasTemasBk.getRtmaddressrst());
						}
					} else if (dtVisitasTemasBk.getRtmaddressrst() == null
							&& dtVisitasTemas.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddressrst"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddressrst() + " :: "+ dtVisitasTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasTemas.setRtmaddressrst(dtVisitasTemasBk.getRtmaddressrst());
						
					} else if (dtVisitasTemasBk.getRtmaddressrst() != null
							&& dtVisitasTemas.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasTemas:Rtmaddressrst"+" :: "+dtVisitasTemasBk.getIdVisitaTema().toString()+" :: "+ dtVisitasTemas.getRtmaddressrst() + " :: "+ dtVisitasTemasBk.getRtmaddressrst());
								}
							cambios = true;			
							dtVisitasTemas.setRtmaddressrst(dtVisitasTemasBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}