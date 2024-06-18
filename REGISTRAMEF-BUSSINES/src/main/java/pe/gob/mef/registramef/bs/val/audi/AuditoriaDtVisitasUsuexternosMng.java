package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtVisitasUsuexternos;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;

/**
 * DT_VISITAS_USUEXTERNOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LOS PARTICIPANTES DE LA VISITA "PARTICIPANTES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtVisitasUsuexternosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtVisitasUsuexternosMng.class.getName());
	
	public static boolean auditarCambiosDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, DtVisitasUsuexternos dtVisitasUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtVisitasUsuexternosBk.getIdVisita() != null
							&& dtVisitasUsuexternos.getIdVisita() != null) {
						if (!dtVisitasUsuexternosBk.getIdVisita().equals(
								dtVisitasUsuexternos.getIdVisita())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdVisita"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdVisita() + " :: "+ dtVisitasUsuexternosBk.getIdVisita());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdVisita(dtVisitasUsuexternosBk.getIdVisita());
						}
					} else if (dtVisitasUsuexternosBk.getIdVisita() == null
							&& dtVisitasUsuexternos.getIdVisita() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdVisita"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdVisita() + " :: "+ dtVisitasUsuexternosBk.getIdVisita());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdVisita(dtVisitasUsuexternosBk.getIdVisita());
						
					} else if (dtVisitasUsuexternosBk.getIdVisita() != null
							&& dtVisitasUsuexternos.getIdVisita() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdVisita"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdVisita() + " :: "+ dtVisitasUsuexternosBk.getIdVisita());
								}
							cambios = true;			
							dtVisitasUsuexternos.setIdVisita(dtVisitasUsuexternosBk.getIdVisita());
					}
				if (dtVisitasUsuexternosBk.getIdUsuexterno() != null
							&& dtVisitasUsuexternos.getIdUsuexterno() != null) {
						if (!dtVisitasUsuexternosBk.getIdUsuexterno().equals(
								dtVisitasUsuexternos.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdUsuexterno"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdUsuexterno() + " :: "+ dtVisitasUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdUsuexterno(dtVisitasUsuexternosBk.getIdUsuexterno());
						}
					} else if (dtVisitasUsuexternosBk.getIdUsuexterno() == null
							&& dtVisitasUsuexternos.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdUsuexterno"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdUsuexterno() + " :: "+ dtVisitasUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdUsuexterno(dtVisitasUsuexternosBk.getIdUsuexterno());
						
					} else if (dtVisitasUsuexternosBk.getIdUsuexterno() != null
							&& dtVisitasUsuexternos.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdUsuexterno"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdUsuexterno() + " :: "+ dtVisitasUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;			
							dtVisitasUsuexternos.setIdUsuexterno(dtVisitasUsuexternosBk.getIdUsuexterno());
					}
				if (dtVisitasUsuexternosBk.getIdCargoUsuext() != null
							&& dtVisitasUsuexternos.getIdCargoUsuext() != null) {
						if (!dtVisitasUsuexternosBk.getIdCargoUsuext().equals(
								dtVisitasUsuexternos.getIdCargoUsuext())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdCargoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdCargoUsuext() + " :: "+ dtVisitasUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdCargoUsuext(dtVisitasUsuexternosBk.getIdCargoUsuext());
						}
					} else if (dtVisitasUsuexternosBk.getIdCargoUsuext() == null
							&& dtVisitasUsuexternos.getIdCargoUsuext() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdCargoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdCargoUsuext() + " :: "+ dtVisitasUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdCargoUsuext(dtVisitasUsuexternosBk.getIdCargoUsuext());
						
					} else if (dtVisitasUsuexternosBk.getIdCargoUsuext() != null
							&& dtVisitasUsuexternos.getIdCargoUsuext() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdCargoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdCargoUsuext() + " :: "+ dtVisitasUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;			
							dtVisitasUsuexternos.setIdCargoUsuext(dtVisitasUsuexternosBk.getIdCargoUsuext());
					}
				 
		            if (dtVisitasUsuexternosBk.getCorreoUsuext() != null
						&& dtVisitasUsuexternos.getCorreoUsuext() != null) {
					if (!dtVisitasUsuexternosBk.getCorreoUsuext().equals(
						dtVisitasUsuexternos.getCorreoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CorreoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCorreoUsuext() + " :: "+ dtVisitasUsuexternosBk.getCorreoUsuext());								
						}
						cambios = true;
						dtVisitasUsuexternos.setCorreoUsuext(dtVisitasUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getCorreoUsuext() == null
						&& dtVisitasUsuexternos.getCorreoUsuext() != null) {
					if (dtVisitasUsuexternos.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CorreoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCorreoUsuext() + " :: "+ dtVisitasUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setCorreoUsuext(dtVisitasUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getCorreoUsuext() != null
						&& dtVisitasUsuexternos.getCorreoUsuext() == null) {
					if (dtVisitasUsuexternosBk.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CorreoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCorreoUsuext() + " :: "+ dtVisitasUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setCorreoUsuext(dtVisitasUsuexternosBk.getCorreoUsuext());
					}
				}
				 
		            if (dtVisitasUsuexternosBk.getFijoUsuext() != null
						&& dtVisitasUsuexternos.getFijoUsuext() != null) {
					if (!dtVisitasUsuexternosBk.getFijoUsuext().equals(
						dtVisitasUsuexternos.getFijoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FijoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFijoUsuext() + " :: "+ dtVisitasUsuexternosBk.getFijoUsuext());								
						}
						cambios = true;
						dtVisitasUsuexternos.setFijoUsuext(dtVisitasUsuexternosBk.getFijoUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getFijoUsuext() == null
						&& dtVisitasUsuexternos.getFijoUsuext() != null) {
					if (dtVisitasUsuexternos.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FijoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFijoUsuext() + " :: "+ dtVisitasUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setFijoUsuext(dtVisitasUsuexternosBk.getFijoUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getFijoUsuext() != null
						&& dtVisitasUsuexternos.getFijoUsuext() == null) {
					if (dtVisitasUsuexternosBk.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FijoUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFijoUsuext() + " :: "+ dtVisitasUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setFijoUsuext(dtVisitasUsuexternosBk.getFijoUsuext());
					}
				}
				 
		            if (dtVisitasUsuexternosBk.getCelularUsuext() != null
						&& dtVisitasUsuexternos.getCelularUsuext() != null) {
					if (!dtVisitasUsuexternosBk.getCelularUsuext().equals(
						dtVisitasUsuexternos.getCelularUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CelularUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCelularUsuext() + " :: "+ dtVisitasUsuexternosBk.getCelularUsuext());								
						}
						cambios = true;
						dtVisitasUsuexternos.setCelularUsuext(dtVisitasUsuexternosBk.getCelularUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getCelularUsuext() == null
						&& dtVisitasUsuexternos.getCelularUsuext() != null) {
					if (dtVisitasUsuexternos.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CelularUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCelularUsuext() + " :: "+ dtVisitasUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setCelularUsuext(dtVisitasUsuexternosBk.getCelularUsuext());
					}
				} else if (dtVisitasUsuexternosBk.getCelularUsuext() != null
						&& dtVisitasUsuexternos.getCelularUsuext() == null) {
					if (dtVisitasUsuexternosBk.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:CelularUsuext"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getCelularUsuext() + " :: "+ dtVisitasUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtVisitasUsuexternos.setCelularUsuext(dtVisitasUsuexternosBk.getCelularUsuext());
					}
				}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtVisitasUsuexternos(DtVisitasUsuexternosBk dtVisitasUsuexternosBk, DtVisitasUsuexternos dtVisitasUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtVisitasUsuexternosBk.getIdusserCrea() != null
							&& dtVisitasUsuexternos.getIdusserCrea() != null) {
						if (!dtVisitasUsuexternosBk.getIdusserCrea().equals(
								dtVisitasUsuexternos.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserCrea() + " :: "+ dtVisitasUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdusserCrea(dtVisitasUsuexternosBk.getIdusserCrea());
						}
					} else if (dtVisitasUsuexternosBk.getIdusserCrea() == null
							&& dtVisitasUsuexternos.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserCrea() + " :: "+ dtVisitasUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdusserCrea(dtVisitasUsuexternosBk.getIdusserCrea());
						
					} else if (dtVisitasUsuexternosBk.getIdusserCrea() != null
							&& dtVisitasUsuexternos.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserCrea() + " :: "+ dtVisitasUsuexternosBk.getIdusserCrea());
								}
							cambios = true;			
							dtVisitasUsuexternos.setIdusserCrea(dtVisitasUsuexternosBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtVisitasUsuexternosBk.getIdusserModif() != null
							&& dtVisitasUsuexternos.getIdusserModif() != null) {
						if (!dtVisitasUsuexternosBk.getIdusserModif().equals(
								dtVisitasUsuexternos.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserModif() + " :: "+ dtVisitasUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdusserModif(dtVisitasUsuexternosBk.getIdusserModif());
						}
					} else if (dtVisitasUsuexternosBk.getIdusserModif() == null
							&& dtVisitasUsuexternos.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserModif() + " :: "+ dtVisitasUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasUsuexternos.setIdusserModif(dtVisitasUsuexternosBk.getIdusserModif());
						
					} else if (dtVisitasUsuexternosBk.getIdusserModif() != null
							&& dtVisitasUsuexternos.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:IdusserModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getIdusserModif() + " :: "+ dtVisitasUsuexternosBk.getIdusserModif());
								}
							cambios = true;			
							dtVisitasUsuexternos.setIdusserModif(dtVisitasUsuexternosBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtVisitasUsuexternosBk.getFechaCrea() != null
							&& dtVisitasUsuexternos.getFechaCrea() != null) {
						if (!dtVisitasUsuexternosBk.getFechaCrea().equals(
								dtVisitasUsuexternos.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaCrea() + " :: "+ dtVisitasUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasUsuexternos.setFechaCrea(dtVisitasUsuexternosBk.getFechaCrea());
						}
					} else if (dtVisitasUsuexternosBk.getFechaCrea() == null
							&& dtVisitasUsuexternos.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaCrea() + " :: "+ dtVisitasUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasUsuexternos.setFechaCrea(dtVisitasUsuexternosBk.getFechaCrea());
						
					} else if (dtVisitasUsuexternosBk.getFechaCrea() != null
							&& dtVisitasUsuexternos.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaCrea"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaCrea() + " :: "+ dtVisitasUsuexternosBk.getFechaCrea());
								}
							cambios = true;			
							dtVisitasUsuexternos.setFechaCrea(dtVisitasUsuexternosBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtVisitasUsuexternosBk.getFechaModif() != null
							&& dtVisitasUsuexternos.getFechaModif() != null) {
						if (!dtVisitasUsuexternosBk.getFechaModif().equals(
								dtVisitasUsuexternos.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaModif() + " :: "+ dtVisitasUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtVisitasUsuexternos.setFechaModif(dtVisitasUsuexternosBk.getFechaModif());
						}
					} else if (dtVisitasUsuexternosBk.getFechaModif() == null
							&& dtVisitasUsuexternos.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaModif() + " :: "+ dtVisitasUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtVisitasUsuexternos.setFechaModif(dtVisitasUsuexternosBk.getFechaModif());
						
					} else if (dtVisitasUsuexternosBk.getFechaModif() != null
							&& dtVisitasUsuexternos.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:FechaModif"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getFechaModif() + " :: "+ dtVisitasUsuexternosBk.getFechaModif());
								}
							cambios = true;			
							dtVisitasUsuexternos.setFechaModif(dtVisitasUsuexternosBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtVisitasUsuexternosBk.getEstado() != null
							&& dtVisitasUsuexternos.getEstado() != null) {
						if (!dtVisitasUsuexternosBk.getEstado().equals(
								dtVisitasUsuexternos.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Estado"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getEstado() + " :: "+ dtVisitasUsuexternosBk.getEstado());
								}
							cambios = true;
							dtVisitasUsuexternos.setEstado(dtVisitasUsuexternosBk.getEstado());
						}
					} else if (dtVisitasUsuexternosBk.getEstado() == null
							&& dtVisitasUsuexternos.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Estado"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getEstado() + " :: "+ dtVisitasUsuexternosBk.getEstado());
								}
							cambios = true;
							dtVisitasUsuexternos.setEstado(dtVisitasUsuexternosBk.getEstado());
						
					} else if (dtVisitasUsuexternosBk.getEstado() != null
							&& dtVisitasUsuexternos.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Estado"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getEstado() + " :: "+ dtVisitasUsuexternosBk.getEstado());
								}
							cambios = true;			
							dtVisitasUsuexternos.setEstado(dtVisitasUsuexternosBk.getEstado());
					}
                                
				                                 
                                      if (dtVisitasUsuexternosBk.getRtmaddress() != null
							&& dtVisitasUsuexternos.getRtmaddress() != null) {
						if (!dtVisitasUsuexternosBk.getRtmaddress().equals(
								dtVisitasUsuexternos.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddress"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddress() + " :: "+ dtVisitasUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasUsuexternos.setRtmaddress(dtVisitasUsuexternosBk.getRtmaddress());
						}
					} else if (dtVisitasUsuexternosBk.getRtmaddress() == null
							&& dtVisitasUsuexternos.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddress"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddress() + " :: "+ dtVisitasUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasUsuexternos.setRtmaddress(dtVisitasUsuexternosBk.getRtmaddress());
						
					} else if (dtVisitasUsuexternosBk.getRtmaddress() != null
							&& dtVisitasUsuexternos.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddress"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddress() + " :: "+ dtVisitasUsuexternosBk.getRtmaddress());
								}
							cambios = true;			
							dtVisitasUsuexternos.setRtmaddress(dtVisitasUsuexternosBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtVisitasUsuexternosBk.getRtmaddressrst() != null
							&& dtVisitasUsuexternos.getRtmaddressrst() != null) {
						if (!dtVisitasUsuexternosBk.getRtmaddressrst().equals(
								dtVisitasUsuexternos.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddressrst"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddressrst() + " :: "+ dtVisitasUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasUsuexternos.setRtmaddressrst(dtVisitasUsuexternosBk.getRtmaddressrst());
						}
					} else if (dtVisitasUsuexternosBk.getRtmaddressrst() == null
							&& dtVisitasUsuexternos.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddressrst"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddressrst() + " :: "+ dtVisitasUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasUsuexternos.setRtmaddressrst(dtVisitasUsuexternosBk.getRtmaddressrst());
						
					} else if (dtVisitasUsuexternosBk.getRtmaddressrst() != null
							&& dtVisitasUsuexternos.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasUsuexternos:Rtmaddressrst"+" :: "+dtVisitasUsuexternosBk.getIdVisitUsuext().toString()+" :: "+ dtVisitasUsuexternos.getRtmaddressrst() + " :: "+ dtVisitasUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;			
							dtVisitasUsuexternos.setRtmaddressrst(dtVisitasUsuexternosBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
			
			return cambios;
	}
}