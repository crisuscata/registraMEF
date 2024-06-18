package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapaEntidades;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaEntidadesBk;

/**
 * DT_CAPA_ENTIDADES SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION "ENTIDADES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapaEntidadesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapaEntidadesMng.class.getName());
	
	public static boolean auditarCambiosDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, DtCapaEntidades dtCapaEntidades, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapaEntidadesBk.getIdCapacitacion() != null
							&& dtCapaEntidades.getIdCapacitacion() != null) {
						if (!dtCapaEntidadesBk.getIdCapacitacion().equals(
								dtCapaEntidades.getIdCapacitacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdCapacitacion"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdCapacitacion() + " :: "+ dtCapaEntidadesBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaEntidades.setIdCapacitacion(dtCapaEntidadesBk.getIdCapacitacion());
						}
					} else if (dtCapaEntidadesBk.getIdCapacitacion() == null
							&& dtCapaEntidades.getIdCapacitacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdCapacitacion"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdCapacitacion() + " :: "+ dtCapaEntidadesBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaEntidades.setIdCapacitacion(dtCapaEntidadesBk.getIdCapacitacion());
						
					} else if (dtCapaEntidadesBk.getIdCapacitacion() != null
							&& dtCapaEntidades.getIdCapacitacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdCapacitacion"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdCapacitacion() + " :: "+ dtCapaEntidadesBk.getIdCapacitacion());
								}
							cambios = true;			
							dtCapaEntidades.setIdCapacitacion(dtCapaEntidadesBk.getIdCapacitacion());
					}
				if (dtCapaEntidadesBk.getIdEntidad() != null
							&& dtCapaEntidades.getIdEntidad() != null) {
						if (!dtCapaEntidadesBk.getIdEntidad().equals(
								dtCapaEntidades.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdEntidad"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdEntidad() + " :: "+ dtCapaEntidadesBk.getIdEntidad());
								}
							cambios = true;
							dtCapaEntidades.setIdEntidad(dtCapaEntidadesBk.getIdEntidad());
						}
					} else if (dtCapaEntidadesBk.getIdEntidad() == null
							&& dtCapaEntidades.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdEntidad"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdEntidad() + " :: "+ dtCapaEntidadesBk.getIdEntidad());
								}
							cambios = true;
							dtCapaEntidades.setIdEntidad(dtCapaEntidadesBk.getIdEntidad());
						
					} else if (dtCapaEntidadesBk.getIdEntidad() != null
							&& dtCapaEntidades.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdEntidad"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdEntidad() + " :: "+ dtCapaEntidadesBk.getIdEntidad());
								}
							cambios = true;			
							dtCapaEntidades.setIdEntidad(dtCapaEntidadesBk.getIdEntidad());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapaEntidades(DtCapaEntidadesBk dtCapaEntidadesBk, DtCapaEntidades dtCapaEntidades, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtCapaEntidadesBk.getIdusserCrea() != null
							&& dtCapaEntidades.getIdusserCrea() != null) {
						if (!dtCapaEntidadesBk.getIdusserCrea().equals(
								dtCapaEntidades.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserCrea() + " :: "+ dtCapaEntidadesBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaEntidades.setIdusserCrea(dtCapaEntidadesBk.getIdusserCrea());
						}
					} else if (dtCapaEntidadesBk.getIdusserCrea() == null
							&& dtCapaEntidades.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserCrea() + " :: "+ dtCapaEntidadesBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaEntidades.setIdusserCrea(dtCapaEntidadesBk.getIdusserCrea());
						
					} else if (dtCapaEntidadesBk.getIdusserCrea() != null
							&& dtCapaEntidades.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserCrea() + " :: "+ dtCapaEntidadesBk.getIdusserCrea());
								}
							cambios = true;			
							dtCapaEntidades.setIdusserCrea(dtCapaEntidadesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtCapaEntidadesBk.getIdusserModif() != null
							&& dtCapaEntidades.getIdusserModif() != null) {
						if (!dtCapaEntidadesBk.getIdusserModif().equals(
								dtCapaEntidades.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserModif() + " :: "+ dtCapaEntidadesBk.getIdusserModif());
								}
							cambios = true;
							dtCapaEntidades.setIdusserModif(dtCapaEntidadesBk.getIdusserModif());
						}
					} else if (dtCapaEntidadesBk.getIdusserModif() == null
							&& dtCapaEntidades.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserModif() + " :: "+ dtCapaEntidadesBk.getIdusserModif());
								}
							cambios = true;
							dtCapaEntidades.setIdusserModif(dtCapaEntidadesBk.getIdusserModif());
						
					} else if (dtCapaEntidadesBk.getIdusserModif() != null
							&& dtCapaEntidades.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:IdusserModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getIdusserModif() + " :: "+ dtCapaEntidadesBk.getIdusserModif());
								}
							cambios = true;			
							dtCapaEntidades.setIdusserModif(dtCapaEntidadesBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtCapaEntidadesBk.getFechaCrea() != null
							&& dtCapaEntidades.getFechaCrea() != null) {
						if (!dtCapaEntidadesBk.getFechaCrea().equals(
								dtCapaEntidades.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaCrea() + " :: "+ dtCapaEntidadesBk.getFechaCrea());
								}
							cambios = true;
							dtCapaEntidades.setFechaCrea(dtCapaEntidadesBk.getFechaCrea());
						}
					} else if (dtCapaEntidadesBk.getFechaCrea() == null
							&& dtCapaEntidades.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaCrea() + " :: "+ dtCapaEntidadesBk.getFechaCrea());
								}
							cambios = true;
							dtCapaEntidades.setFechaCrea(dtCapaEntidadesBk.getFechaCrea());
						
					} else if (dtCapaEntidadesBk.getFechaCrea() != null
							&& dtCapaEntidades.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaCrea"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaCrea() + " :: "+ dtCapaEntidadesBk.getFechaCrea());
								}
							cambios = true;			
							dtCapaEntidades.setFechaCrea(dtCapaEntidadesBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapaEntidadesBk.getFechaModif() != null
							&& dtCapaEntidades.getFechaModif() != null) {
						if (!dtCapaEntidadesBk.getFechaModif().equals(
								dtCapaEntidades.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaModif() + " :: "+ dtCapaEntidadesBk.getFechaModif());
								}
							cambios = true;
							dtCapaEntidades.setFechaModif(dtCapaEntidadesBk.getFechaModif());
						}
					} else if (dtCapaEntidadesBk.getFechaModif() == null
							&& dtCapaEntidades.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaModif() + " :: "+ dtCapaEntidadesBk.getFechaModif());
								}
							cambios = true;
							dtCapaEntidades.setFechaModif(dtCapaEntidadesBk.getFechaModif());
						
					} else if (dtCapaEntidadesBk.getFechaModif() != null
							&& dtCapaEntidades.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:FechaModif"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getFechaModif() + " :: "+ dtCapaEntidadesBk.getFechaModif());
								}
							cambios = true;			
							dtCapaEntidades.setFechaModif(dtCapaEntidadesBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtCapaEntidadesBk.getEstado() != null
							&& dtCapaEntidades.getEstado() != null) {
						if (!dtCapaEntidadesBk.getEstado().equals(
								dtCapaEntidades.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Estado"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getEstado() + " :: "+ dtCapaEntidadesBk.getEstado());
								}
							cambios = true;
							dtCapaEntidades.setEstado(dtCapaEntidadesBk.getEstado());
						}
					} else if (dtCapaEntidadesBk.getEstado() == null
							&& dtCapaEntidades.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Estado"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getEstado() + " :: "+ dtCapaEntidadesBk.getEstado());
								}
							cambios = true;
							dtCapaEntidades.setEstado(dtCapaEntidadesBk.getEstado());
						
					} else if (dtCapaEntidadesBk.getEstado() != null
							&& dtCapaEntidades.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Estado"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getEstado() + " :: "+ dtCapaEntidadesBk.getEstado());
								}
							cambios = true;			
							dtCapaEntidades.setEstado(dtCapaEntidadesBk.getEstado());
					}
                                
				                                 
                                      if (dtCapaEntidadesBk.getRtmaddress() != null
							&& dtCapaEntidades.getRtmaddress() != null) {
						if (!dtCapaEntidadesBk.getRtmaddress().equals(
								dtCapaEntidades.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddress"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddress() + " :: "+ dtCapaEntidadesBk.getRtmaddress());
								}
							cambios = true;
							dtCapaEntidades.setRtmaddress(dtCapaEntidadesBk.getRtmaddress());
						}
					} else if (dtCapaEntidadesBk.getRtmaddress() == null
							&& dtCapaEntidades.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddress"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddress() + " :: "+ dtCapaEntidadesBk.getRtmaddress());
								}
							cambios = true;
							dtCapaEntidades.setRtmaddress(dtCapaEntidadesBk.getRtmaddress());
						
					} else if (dtCapaEntidadesBk.getRtmaddress() != null
							&& dtCapaEntidades.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddress"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddress() + " :: "+ dtCapaEntidadesBk.getRtmaddress());
								}
							cambios = true;			
							dtCapaEntidades.setRtmaddress(dtCapaEntidadesBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapaEntidadesBk.getRtmaddressrst() != null
							&& dtCapaEntidades.getRtmaddressrst() != null) {
						if (!dtCapaEntidadesBk.getRtmaddressrst().equals(
								dtCapaEntidades.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddressrst"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddressrst() + " :: "+ dtCapaEntidadesBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaEntidades.setRtmaddressrst(dtCapaEntidadesBk.getRtmaddressrst());
						}
					} else if (dtCapaEntidadesBk.getRtmaddressrst() == null
							&& dtCapaEntidades.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddressrst"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddressrst() + " :: "+ dtCapaEntidadesBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaEntidades.setRtmaddressrst(dtCapaEntidadesBk.getRtmaddressrst());
						
					} else if (dtCapaEntidadesBk.getRtmaddressrst() != null
							&& dtCapaEntidades.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaEntidades:Rtmaddressrst"+" :: "+dtCapaEntidadesBk.getIdCapaEnti().toString()+" :: "+ dtCapaEntidades.getRtmaddressrst() + " :: "+ dtCapaEntidadesBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapaEntidades.setRtmaddressrst(dtCapaEntidadesBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}