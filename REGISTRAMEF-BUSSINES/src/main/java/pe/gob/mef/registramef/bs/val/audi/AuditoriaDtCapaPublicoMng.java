package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapaPublico;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaPublicoBk;

/**
 * DT_CAPA_PUBLICO SERVICIO AUDITORIA Y CAMBIO: ALMACENA EL TIPO DE PUBLICO OBJETIVO POR CAPACITACION "PUBLICO OBJETIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapaPublicoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapaPublicoMng.class.getName());
	
	public static boolean auditarCambiosDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, DtCapaPublico dtCapaPublico, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapaPublicoBk.getIdCapacitacion() != null
							&& dtCapaPublico.getIdCapacitacion() != null) {
						if (!dtCapaPublicoBk.getIdCapacitacion().equals(
								dtCapaPublico.getIdCapacitacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCapacitacion"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCapacitacion() + " :: "+ dtCapaPublicoBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaPublico.setIdCapacitacion(dtCapaPublicoBk.getIdCapacitacion());
						}
					} else if (dtCapaPublicoBk.getIdCapacitacion() == null
							&& dtCapaPublico.getIdCapacitacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCapacitacion"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCapacitacion() + " :: "+ dtCapaPublicoBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaPublico.setIdCapacitacion(dtCapaPublicoBk.getIdCapacitacion());
						
					} else if (dtCapaPublicoBk.getIdCapacitacion() != null
							&& dtCapaPublico.getIdCapacitacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCapacitacion"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCapacitacion() + " :: "+ dtCapaPublicoBk.getIdCapacitacion());
								}
							cambios = true;			
							dtCapaPublico.setIdCapacitacion(dtCapaPublicoBk.getIdCapacitacion());
					}
				if (dtCapaPublicoBk.getIdCargo() != null
							&& dtCapaPublico.getIdCargo() != null) {
						if (!dtCapaPublicoBk.getIdCargo().equals(
								dtCapaPublico.getIdCargo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCargo"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCargo() + " :: "+ dtCapaPublicoBk.getIdCargo());
								}
							cambios = true;
							dtCapaPublico.setIdCargo(dtCapaPublicoBk.getIdCargo());
						}
					} else if (dtCapaPublicoBk.getIdCargo() == null
							&& dtCapaPublico.getIdCargo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCargo"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCargo() + " :: "+ dtCapaPublicoBk.getIdCargo());
								}
							cambios = true;
							dtCapaPublico.setIdCargo(dtCapaPublicoBk.getIdCargo());
						
					} else if (dtCapaPublicoBk.getIdCargo() != null
							&& dtCapaPublico.getIdCargo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IdCargo"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIdCargo() + " :: "+ dtCapaPublicoBk.getIdCargo());
								}
							cambios = true;			
							dtCapaPublico.setIdCargo(dtCapaPublicoBk.getIdCargo());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapaPublico(DtCapaPublicoBk dtCapaPublicoBk, DtCapaPublico dtCapaPublico, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtCapaPublicoBk.getFechaCrea() != null
							&& dtCapaPublico.getFechaCrea() != null) {
						if (!dtCapaPublicoBk.getFechaCrea().equals(
								dtCapaPublico.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaCrea() + " :: "+ dtCapaPublicoBk.getFechaCrea());
								}
							cambios = true;
							dtCapaPublico.setFechaCrea(dtCapaPublicoBk.getFechaCrea());
						}
					} else if (dtCapaPublicoBk.getFechaCrea() == null
							&& dtCapaPublico.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaCrea() + " :: "+ dtCapaPublicoBk.getFechaCrea());
								}
							cambios = true;
							dtCapaPublico.setFechaCrea(dtCapaPublicoBk.getFechaCrea());
						
					} else if (dtCapaPublicoBk.getFechaCrea() != null
							&& dtCapaPublico.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaCrea() + " :: "+ dtCapaPublicoBk.getFechaCrea());
								}
							cambios = true;			
							dtCapaPublico.setFechaCrea(dtCapaPublicoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapaPublicoBk.getFechaModif() != null
							&& dtCapaPublico.getFechaModif() != null) {
						if (!dtCapaPublicoBk.getFechaModif().equals(
								dtCapaPublico.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaModif() + " :: "+ dtCapaPublicoBk.getFechaModif());
								}
							cambios = true;
							dtCapaPublico.setFechaModif(dtCapaPublicoBk.getFechaModif());
						}
					} else if (dtCapaPublicoBk.getFechaModif() == null
							&& dtCapaPublico.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaModif() + " :: "+ dtCapaPublicoBk.getFechaModif());
								}
							cambios = true;
							dtCapaPublico.setFechaModif(dtCapaPublicoBk.getFechaModif());
						
					} else if (dtCapaPublicoBk.getFechaModif() != null
							&& dtCapaPublico.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:FechaModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getFechaModif() + " :: "+ dtCapaPublicoBk.getFechaModif());
								}
							cambios = true;			
							dtCapaPublico.setFechaModif(dtCapaPublicoBk.getFechaModif());
					}
                                
				                                 
                                      if (dtCapaPublicoBk.getIduserCrea() != null
							&& dtCapaPublico.getIduserCrea() != null) {
						if (!dtCapaPublicoBk.getIduserCrea().equals(
								dtCapaPublico.getIduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserCrea() + " :: "+ dtCapaPublicoBk.getIduserCrea());
								}
							cambios = true;
							dtCapaPublico.setIduserCrea(dtCapaPublicoBk.getIduserCrea());
						}
					} else if (dtCapaPublicoBk.getIduserCrea() == null
							&& dtCapaPublico.getIduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserCrea() + " :: "+ dtCapaPublicoBk.getIduserCrea());
								}
							cambios = true;
							dtCapaPublico.setIduserCrea(dtCapaPublicoBk.getIduserCrea());
						
					} else if (dtCapaPublicoBk.getIduserCrea() != null
							&& dtCapaPublico.getIduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserCrea"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserCrea() + " :: "+ dtCapaPublicoBk.getIduserCrea());
								}
							cambios = true;			
							dtCapaPublico.setIduserCrea(dtCapaPublicoBk.getIduserCrea());
					}
                                
				                                 
                                      if (dtCapaPublicoBk.getIduserModif() != null
							&& dtCapaPublico.getIduserModif() != null) {
						if (!dtCapaPublicoBk.getIduserModif().equals(
								dtCapaPublico.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserModif() + " :: "+ dtCapaPublicoBk.getIduserModif());
								}
							cambios = true;
							dtCapaPublico.setIduserModif(dtCapaPublicoBk.getIduserModif());
						}
					} else if (dtCapaPublicoBk.getIduserModif() == null
							&& dtCapaPublico.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserModif() + " :: "+ dtCapaPublicoBk.getIduserModif());
								}
							cambios = true;
							dtCapaPublico.setIduserModif(dtCapaPublicoBk.getIduserModif());
						
					} else if (dtCapaPublicoBk.getIduserModif() != null
							&& dtCapaPublico.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:IduserModif"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getIduserModif() + " :: "+ dtCapaPublicoBk.getIduserModif());
								}
							cambios = true;			
							dtCapaPublico.setIduserModif(dtCapaPublicoBk.getIduserModif());
					}
                                
				
				
				                                 
                                      if (dtCapaPublicoBk.getEstado() != null
							&& dtCapaPublico.getEstado() != null) {
						if (!dtCapaPublicoBk.getEstado().equals(
								dtCapaPublico.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Estado"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getEstado() + " :: "+ dtCapaPublicoBk.getEstado());
								}
							cambios = true;
							dtCapaPublico.setEstado(dtCapaPublicoBk.getEstado());
						}
					} else if (dtCapaPublicoBk.getEstado() == null
							&& dtCapaPublico.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Estado"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getEstado() + " :: "+ dtCapaPublicoBk.getEstado());
								}
							cambios = true;
							dtCapaPublico.setEstado(dtCapaPublicoBk.getEstado());
						
					} else if (dtCapaPublicoBk.getEstado() != null
							&& dtCapaPublico.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Estado"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getEstado() + " :: "+ dtCapaPublicoBk.getEstado());
								}
							cambios = true;			
							dtCapaPublico.setEstado(dtCapaPublicoBk.getEstado());
					}
                                
				                                 
                                      if (dtCapaPublicoBk.getRtmaddress() != null
							&& dtCapaPublico.getRtmaddress() != null) {
						if (!dtCapaPublicoBk.getRtmaddress().equals(
								dtCapaPublico.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddress"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddress() + " :: "+ dtCapaPublicoBk.getRtmaddress());
								}
							cambios = true;
							dtCapaPublico.setRtmaddress(dtCapaPublicoBk.getRtmaddress());
						}
					} else if (dtCapaPublicoBk.getRtmaddress() == null
							&& dtCapaPublico.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddress"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddress() + " :: "+ dtCapaPublicoBk.getRtmaddress());
								}
							cambios = true;
							dtCapaPublico.setRtmaddress(dtCapaPublicoBk.getRtmaddress());
						
					} else if (dtCapaPublicoBk.getRtmaddress() != null
							&& dtCapaPublico.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddress"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddress() + " :: "+ dtCapaPublicoBk.getRtmaddress());
								}
							cambios = true;			
							dtCapaPublico.setRtmaddress(dtCapaPublicoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapaPublicoBk.getRtmaddressrst() != null
							&& dtCapaPublico.getRtmaddressrst() != null) {
						if (!dtCapaPublicoBk.getRtmaddressrst().equals(
								dtCapaPublico.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddressrst"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddressrst() + " :: "+ dtCapaPublicoBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaPublico.setRtmaddressrst(dtCapaPublicoBk.getRtmaddressrst());
						}
					} else if (dtCapaPublicoBk.getRtmaddressrst() == null
							&& dtCapaPublico.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddressrst"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddressrst() + " :: "+ dtCapaPublicoBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaPublico.setRtmaddressrst(dtCapaPublicoBk.getRtmaddressrst());
						
					} else if (dtCapaPublicoBk.getRtmaddressrst() != null
							&& dtCapaPublico.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaPublico:Rtmaddressrst"+" :: "+dtCapaPublicoBk.getIdCapaPublico().toString()+" :: "+ dtCapaPublico.getRtmaddressrst() + " :: "+ dtCapaPublicoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapaPublico.setRtmaddressrst(dtCapaPublicoBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}