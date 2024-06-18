package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtVisitasUsuinternos;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuinternosBk;

/**
 * DT_VISITAS_USUINTERNOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES DE LA VISITA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtVisitasUsuinternosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtVisitasUsuinternosMng.class.getName());
	
	public static boolean auditarCambiosDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, DtVisitasUsuinternos dtVisitasUsuinternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtVisitasUsuinternosBk.getIdVisita() != null
							&& dtVisitasUsuinternos.getIdVisita() != null) {
						if (!dtVisitasUsuinternosBk.getIdVisita().equals(
								dtVisitasUsuinternos.getIdVisita())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdVisita"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdVisita() + " :: "+ dtVisitasUsuinternosBk.getIdVisita());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdVisita(dtVisitasUsuinternosBk.getIdVisita());
						}
					} else if (dtVisitasUsuinternosBk.getIdVisita() == null
							&& dtVisitasUsuinternos.getIdVisita() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdVisita"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdVisita() + " :: "+ dtVisitasUsuinternosBk.getIdVisita());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdVisita(dtVisitasUsuinternosBk.getIdVisita());
						
					} else if (dtVisitasUsuinternosBk.getIdVisita() != null
							&& dtVisitasUsuinternos.getIdVisita() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdVisita"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdVisita() + " :: "+ dtVisitasUsuinternosBk.getIdVisita());
								}
							cambios = true;			
							dtVisitasUsuinternos.setIdVisita(dtVisitasUsuinternosBk.getIdVisita());
					}
				if (dtVisitasUsuinternosBk.getIdUsuinterno() != null
							&& dtVisitasUsuinternos.getIdUsuinterno() != null) {
						if (!dtVisitasUsuinternosBk.getIdUsuinterno().equals(
								dtVisitasUsuinternos.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdUsuinterno"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdUsuinterno() + " :: "+ dtVisitasUsuinternosBk.getIdUsuinterno());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdUsuinterno(dtVisitasUsuinternosBk.getIdUsuinterno());
						}
					} else if (dtVisitasUsuinternosBk.getIdUsuinterno() == null
							&& dtVisitasUsuinternos.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdUsuinterno"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdUsuinterno() + " :: "+ dtVisitasUsuinternosBk.getIdUsuinterno());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdUsuinterno(dtVisitasUsuinternosBk.getIdUsuinterno());
						
					} else if (dtVisitasUsuinternosBk.getIdUsuinterno() != null
							&& dtVisitasUsuinternos.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdUsuinterno"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdUsuinterno() + " :: "+ dtVisitasUsuinternosBk.getIdUsuinterno());
								}
							cambios = true;			
							dtVisitasUsuinternos.setIdUsuinterno(dtVisitasUsuinternosBk.getIdUsuinterno());
					}
				
				//PURIBE 14032024 - INICIO--
				//PURIBE 22032024 - INICIO--
	            if (dtVisitasUsuinternosBk.getEstado() != null
						&& dtVisitasUsuinternos.getEstado() != null) {
					if (!dtVisitasUsuinternosBk.getEstado().equals(
						dtVisitasUsuinternos.getEstado())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Estado"+" :: "+dtVisitasUsuinternosBk.getEstado().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());								
						}
						cambios = true;
						dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
					}
				} else if (dtVisitasUsuinternosBk.getEstado() == null
						&& dtVisitasUsuinternos.getEstado() != null) {
									
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Estado"+" :: "+dtVisitasUsuinternosBk.getEstado().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());
						}
						cambios = true;
						dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
					
				} else if (dtVisitasUsuinternosBk.getEstado() != null
						&& dtVisitasUsuinternos.getEstado() == null) {
								
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Estado"+" :: "+dtVisitasUsuinternosBk.getEstado().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());
						}
						cambios = true;
						dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
					
				}
	        	//PURIBE 22032024 - FIN--
	        	//PURIBE 14032024 - FIN--
				
				
				
				if (dtVisitasUsuinternosBk.getIdTema() != null
							&& dtVisitasUsuinternos.getIdTema() != null) {
						if (!dtVisitasUsuinternosBk.getIdTema().equals(
								dtVisitasUsuinternos.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdTema"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdTema() + " :: "+ dtVisitasUsuinternosBk.getIdTema());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdTema(dtVisitasUsuinternosBk.getIdTema());
						}
					} else if (dtVisitasUsuinternosBk.getIdTema() == null
							&& dtVisitasUsuinternos.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdTema"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdTema() + " :: "+ dtVisitasUsuinternosBk.getIdTema());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdTema(dtVisitasUsuinternosBk.getIdTema());
						
					} else if (dtVisitasUsuinternosBk.getIdTema() != null
							&& dtVisitasUsuinternos.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdTema"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdTema() + " :: "+ dtVisitasUsuinternosBk.getIdTema());
								}
							cambios = true;			
							dtVisitasUsuinternos.setIdTema(dtVisitasUsuinternosBk.getIdTema());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtVisitasUsuinternos(DtVisitasUsuinternosBk dtVisitasUsuinternosBk, DtVisitasUsuinternos dtVisitasUsuinternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtVisitasUsuinternosBk.getIdusserCrea() != null
							&& dtVisitasUsuinternos.getIdusserCrea() != null) {
						if (!dtVisitasUsuinternosBk.getIdusserCrea().equals(
								dtVisitasUsuinternos.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserCrea() + " :: "+ dtVisitasUsuinternosBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdusserCrea(dtVisitasUsuinternosBk.getIdusserCrea());
						}
					} else if (dtVisitasUsuinternosBk.getIdusserCrea() == null
							&& dtVisitasUsuinternos.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserCrea() + " :: "+ dtVisitasUsuinternosBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdusserCrea(dtVisitasUsuinternosBk.getIdusserCrea());
						
					} else if (dtVisitasUsuinternosBk.getIdusserCrea() != null
							&& dtVisitasUsuinternos.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserCrea() + " :: "+ dtVisitasUsuinternosBk.getIdusserCrea());
								}
							cambios = true;			
							dtVisitasUsuinternos.setIdusserCrea(dtVisitasUsuinternosBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtVisitasUsuinternosBk.getIdusserModif() != null
							&& dtVisitasUsuinternos.getIdusserModif() != null) {
						if (!dtVisitasUsuinternosBk.getIdusserModif().equals(
								dtVisitasUsuinternos.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserModif() + " :: "+ dtVisitasUsuinternosBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdusserModif(dtVisitasUsuinternosBk.getIdusserModif());
						}
					} else if (dtVisitasUsuinternosBk.getIdusserModif() == null
							&& dtVisitasUsuinternos.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserModif() + " :: "+ dtVisitasUsuinternosBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasUsuinternos.setIdusserModif(dtVisitasUsuinternosBk.getIdusserModif());
						
					} else if (dtVisitasUsuinternosBk.getIdusserModif() != null
							&& dtVisitasUsuinternos.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:IdusserModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getIdusserModif() + " :: "+ dtVisitasUsuinternosBk.getIdusserModif());
								}
							cambios = true;			
							dtVisitasUsuinternos.setIdusserModif(dtVisitasUsuinternosBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtVisitasUsuinternosBk.getFechaCrea() != null
							&& dtVisitasUsuinternos.getFechaCrea() != null) {
						if (!dtVisitasUsuinternosBk.getFechaCrea().equals(
								dtVisitasUsuinternos.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaCrea() + " :: "+ dtVisitasUsuinternosBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasUsuinternos.setFechaCrea(dtVisitasUsuinternosBk.getFechaCrea());
						}
					} else if (dtVisitasUsuinternosBk.getFechaCrea() == null
							&& dtVisitasUsuinternos.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaCrea() + " :: "+ dtVisitasUsuinternosBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasUsuinternos.setFechaCrea(dtVisitasUsuinternosBk.getFechaCrea());
						
					} else if (dtVisitasUsuinternosBk.getFechaCrea() != null
							&& dtVisitasUsuinternos.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaCrea"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaCrea() + " :: "+ dtVisitasUsuinternosBk.getFechaCrea());
								}
							cambios = true;			
							dtVisitasUsuinternos.setFechaCrea(dtVisitasUsuinternosBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtVisitasUsuinternosBk.getFechaModif() != null
							&& dtVisitasUsuinternos.getFechaModif() != null) {
						if (!dtVisitasUsuinternosBk.getFechaModif().equals(
								dtVisitasUsuinternos.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaModif() + " :: "+ dtVisitasUsuinternosBk.getFechaModif());
								}
							cambios = true;
							dtVisitasUsuinternos.setFechaModif(dtVisitasUsuinternosBk.getFechaModif());
						}
					} else if (dtVisitasUsuinternosBk.getFechaModif() == null
							&& dtVisitasUsuinternos.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaModif() + " :: "+ dtVisitasUsuinternosBk.getFechaModif());
								}
							cambios = true;
							dtVisitasUsuinternos.setFechaModif(dtVisitasUsuinternosBk.getFechaModif());
						
					} else if (dtVisitasUsuinternosBk.getFechaModif() != null
							&& dtVisitasUsuinternos.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:FechaModif"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getFechaModif() + " :: "+ dtVisitasUsuinternosBk.getFechaModif());
								}
							cambios = true;			
							dtVisitasUsuinternos.setFechaModif(dtVisitasUsuinternosBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtVisitasUsuinternosBk.getEstado() != null
							&& dtVisitasUsuinternos.getEstado() != null) {
						if (!dtVisitasUsuinternosBk.getEstado().equals(
								dtVisitasUsuinternos.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Estado"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());
								}
							cambios = true;
							dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
						}
					} else if (dtVisitasUsuinternosBk.getEstado() == null
							&& dtVisitasUsuinternos.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Estado"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());
								}
							cambios = true;
							dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
						
					} else if (dtVisitasUsuinternosBk.getEstado() != null
							&& dtVisitasUsuinternos.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Estado"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getEstado() + " :: "+ dtVisitasUsuinternosBk.getEstado());
								}
							cambios = true;			
							dtVisitasUsuinternos.setEstado(dtVisitasUsuinternosBk.getEstado());
					}
                                
				                                 
                                      if (dtVisitasUsuinternosBk.getRtmaddress() != null
							&& dtVisitasUsuinternos.getRtmaddress() != null) {
						if (!dtVisitasUsuinternosBk.getRtmaddress().equals(
								dtVisitasUsuinternos.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddress"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddress() + " :: "+ dtVisitasUsuinternosBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasUsuinternos.setRtmaddress(dtVisitasUsuinternosBk.getRtmaddress());
						}
					} else if (dtVisitasUsuinternosBk.getRtmaddress() == null
							&& dtVisitasUsuinternos.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddress"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddress() + " :: "+ dtVisitasUsuinternosBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasUsuinternos.setRtmaddress(dtVisitasUsuinternosBk.getRtmaddress());
						
					} else if (dtVisitasUsuinternosBk.getRtmaddress() != null
							&& dtVisitasUsuinternos.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddress"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddress() + " :: "+ dtVisitasUsuinternosBk.getRtmaddress());
								}
							cambios = true;			
							dtVisitasUsuinternos.setRtmaddress(dtVisitasUsuinternosBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtVisitasUsuinternosBk.getRtmaddressrst() != null
							&& dtVisitasUsuinternos.getRtmaddressrst() != null) {
						if (!dtVisitasUsuinternosBk.getRtmaddressrst().equals(
								dtVisitasUsuinternos.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddressrst"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddressrst() + " :: "+ dtVisitasUsuinternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasUsuinternos.setRtmaddressrst(dtVisitasUsuinternosBk.getRtmaddressrst());
						}
					} else if (dtVisitasUsuinternosBk.getRtmaddressrst() == null
							&& dtVisitasUsuinternos.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddressrst"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddressrst() + " :: "+ dtVisitasUsuinternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasUsuinternos.setRtmaddressrst(dtVisitasUsuinternosBk.getRtmaddressrst());
						
					} else if (dtVisitasUsuinternosBk.getRtmaddressrst() != null
							&& dtVisitasUsuinternos.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuinternos:Rtmaddressrst"+" :: "+dtVisitasUsuinternosBk.getIdVisitUsuint().toString()+" :: "+ dtVisitasUsuinternos.getRtmaddressrst() + " :: "+ dtVisitasUsuinternosBk.getRtmaddressrst());
								}
							cambios = true;			
							dtVisitasUsuinternos.setRtmaddressrst(dtVisitasUsuinternosBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}