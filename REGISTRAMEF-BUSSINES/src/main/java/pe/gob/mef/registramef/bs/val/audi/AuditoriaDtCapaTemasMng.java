package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapaTemas;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaTemasBk;

/**
 * DT_CAPA_TEMAS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DIFERENTES TEMAS AGENDADOS EN LA CAPACITACION "TEMAS DE CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapaTemasMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapaTemasMng.class.getName());
	
	public static boolean auditarCambiosDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, DtCapaTemas dtCapaTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapaTemasBk.getIdCapacitacion() != null
							&& dtCapaTemas.getIdCapacitacion() != null) {
						if (!dtCapaTemasBk.getIdCapacitacion().equals(
								dtCapaTemas.getIdCapacitacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdCapacitacion"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdCapacitacion() + " :: "+ dtCapaTemasBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaTemas.setIdCapacitacion(dtCapaTemasBk.getIdCapacitacion());
						}
					} else if (dtCapaTemasBk.getIdCapacitacion() == null
							&& dtCapaTemas.getIdCapacitacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdCapacitacion"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdCapacitacion() + " :: "+ dtCapaTemasBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaTemas.setIdCapacitacion(dtCapaTemasBk.getIdCapacitacion());
						
					} else if (dtCapaTemasBk.getIdCapacitacion() != null
							&& dtCapaTemas.getIdCapacitacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdCapacitacion"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdCapacitacion() + " :: "+ dtCapaTemasBk.getIdCapacitacion());
								}
							cambios = true;			
							dtCapaTemas.setIdCapacitacion(dtCapaTemasBk.getIdCapacitacion());
					}
				if (dtCapaTemasBk.getIdTema() != null
							&& dtCapaTemas.getIdTema() != null) {
						if (!dtCapaTemasBk.getIdTema().equals(
								dtCapaTemas.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdTema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdTema() + " :: "+ dtCapaTemasBk.getIdTema());
								}
							cambios = true;
							dtCapaTemas.setIdTema(dtCapaTemasBk.getIdTema());
						}
					} else if (dtCapaTemasBk.getIdTema() == null
							&& dtCapaTemas.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdTema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdTema() + " :: "+ dtCapaTemasBk.getIdTema());
								}
							cambios = true;
							dtCapaTemas.setIdTema(dtCapaTemasBk.getIdTema());
						
					} else if (dtCapaTemasBk.getIdTema() != null
							&& dtCapaTemas.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdTema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdTema() + " :: "+ dtCapaTemasBk.getIdTema());
								}
							cambios = true;			
							dtCapaTemas.setIdTema(dtCapaTemasBk.getIdTema());
					}
				if (dtCapaTemasBk.getIdSubtema() != null
							&& dtCapaTemas.getIdSubtema() != null) {
						if (!dtCapaTemasBk.getIdSubtema().equals(
								dtCapaTemas.getIdSubtema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSubtema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSubtema() + " :: "+ dtCapaTemasBk.getIdSubtema());
								}
							cambios = true;
							dtCapaTemas.setIdSubtema(dtCapaTemasBk.getIdSubtema());
						}
					} else if (dtCapaTemasBk.getIdSubtema() == null
							&& dtCapaTemas.getIdSubtema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSubtema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSubtema() + " :: "+ dtCapaTemasBk.getIdSubtema());
								}
							cambios = true;
							dtCapaTemas.setIdSubtema(dtCapaTemasBk.getIdSubtema());
						
					} else if (dtCapaTemasBk.getIdSubtema() != null
							&& dtCapaTemas.getIdSubtema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSubtema"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSubtema() + " :: "+ dtCapaTemasBk.getIdSubtema());
								}
							cambios = true;			
							dtCapaTemas.setIdSubtema(dtCapaTemasBk.getIdSubtema());
					}
				if (dtCapaTemasBk.getEstado() != null
							&& dtCapaTemas.getEstado() != null) {
						if (!dtCapaTemasBk.getEstado().equals(
								dtCapaTemas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Estado"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getEstado() + " :: "+ dtCapaTemasBk.getEstado());
								}
							cambios = true;
							dtCapaTemas.setEstado(dtCapaTemasBk.getEstado());
						}
					} else if (dtCapaTemasBk.getEstado() == null
							&& dtCapaTemas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Estado"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getEstado() + " :: "+ dtCapaTemasBk.getEstado());
								}
							cambios = true;
							dtCapaTemas.setEstado(dtCapaTemasBk.getEstado());
						
					} else if (dtCapaTemasBk.getEstado() != null
							&& dtCapaTemas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Estado"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getEstado() + " :: "+ dtCapaTemasBk.getEstado());
								}
							cambios = true;			
							dtCapaTemas.setEstado(dtCapaTemasBk.getEstado());
					}
				if (dtCapaTemasBk.getIdUsuinterno() != null
							&& dtCapaTemas.getIdUsuinterno() != null) {
						if (!dtCapaTemasBk.getIdUsuinterno().equals(
								dtCapaTemas.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdUsuinterno"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdUsuinterno() + " :: "+ dtCapaTemasBk.getIdUsuinterno());
								}
							cambios = true;
							dtCapaTemas.setIdUsuinterno(dtCapaTemasBk.getIdUsuinterno());
						}
					} else if (dtCapaTemasBk.getIdUsuinterno() == null
							&& dtCapaTemas.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdUsuinterno"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdUsuinterno() + " :: "+ dtCapaTemasBk.getIdUsuinterno());
								}
							cambios = true;
							dtCapaTemas.setIdUsuinterno(dtCapaTemasBk.getIdUsuinterno());
						
					} else if (dtCapaTemasBk.getIdUsuinterno() != null
							&& dtCapaTemas.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdUsuinterno"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdUsuinterno() + " :: "+ dtCapaTemasBk.getIdUsuinterno());
								}
							cambios = true;			
							dtCapaTemas.setIdUsuinterno(dtCapaTemasBk.getIdUsuinterno());
					}
				if (dtCapaTemasBk.getIdSistAdmi() != null
							&& dtCapaTemas.getIdSistAdmi() != null) {
						if (!dtCapaTemasBk.getIdSistAdmi().equals(
								dtCapaTemas.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSistAdmi"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSistAdmi() + " :: "+ dtCapaTemasBk.getIdSistAdmi());
								}
							cambios = true;
							dtCapaTemas.setIdSistAdmi(dtCapaTemasBk.getIdSistAdmi());
						}
					} else if (dtCapaTemasBk.getIdSistAdmi() == null
							&& dtCapaTemas.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSistAdmi"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSistAdmi() + " :: "+ dtCapaTemasBk.getIdSistAdmi());
								}
							cambios = true;
							dtCapaTemas.setIdSistAdmi(dtCapaTemasBk.getIdSistAdmi());
						
					} else if (dtCapaTemasBk.getIdSistAdmi() != null
							&& dtCapaTemas.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdSistAdmi"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdSistAdmi() + " :: "+ dtCapaTemasBk.getIdSistAdmi());
								}
							cambios = true;			
							dtCapaTemas.setIdSistAdmi(dtCapaTemasBk.getIdSistAdmi());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapaTemas(DtCapaTemasBk dtCapaTemasBk, DtCapaTemas dtCapaTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtCapaTemasBk.getIdusserCrea() != null
							&& dtCapaTemas.getIdusserCrea() != null) {
						if (!dtCapaTemasBk.getIdusserCrea().equals(
								dtCapaTemas.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserCrea() + " :: "+ dtCapaTemasBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaTemas.setIdusserCrea(dtCapaTemasBk.getIdusserCrea());
						}
					} else if (dtCapaTemasBk.getIdusserCrea() == null
							&& dtCapaTemas.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserCrea() + " :: "+ dtCapaTemasBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaTemas.setIdusserCrea(dtCapaTemasBk.getIdusserCrea());
						
					} else if (dtCapaTemasBk.getIdusserCrea() != null
							&& dtCapaTemas.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserCrea() + " :: "+ dtCapaTemasBk.getIdusserCrea());
								}
							cambios = true;			
							dtCapaTemas.setIdusserCrea(dtCapaTemasBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtCapaTemasBk.getIdusserModif() != null
							&& dtCapaTemas.getIdusserModif() != null) {
						if (!dtCapaTemasBk.getIdusserModif().equals(
								dtCapaTemas.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserModif() + " :: "+ dtCapaTemasBk.getIdusserModif());
								}
							cambios = true;
							dtCapaTemas.setIdusserModif(dtCapaTemasBk.getIdusserModif());
						}
					} else if (dtCapaTemasBk.getIdusserModif() == null
							&& dtCapaTemas.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserModif() + " :: "+ dtCapaTemasBk.getIdusserModif());
								}
							cambios = true;
							dtCapaTemas.setIdusserModif(dtCapaTemasBk.getIdusserModif());
						
					} else if (dtCapaTemasBk.getIdusserModif() != null
							&& dtCapaTemas.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:IdusserModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getIdusserModif() + " :: "+ dtCapaTemasBk.getIdusserModif());
								}
							cambios = true;			
							dtCapaTemas.setIdusserModif(dtCapaTemasBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtCapaTemasBk.getFechaCrea() != null
							&& dtCapaTemas.getFechaCrea() != null) {
						if (!dtCapaTemasBk.getFechaCrea().equals(
								dtCapaTemas.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaCrea() + " :: "+ dtCapaTemasBk.getFechaCrea());
								}
							cambios = true;
							dtCapaTemas.setFechaCrea(dtCapaTemasBk.getFechaCrea());
						}
					} else if (dtCapaTemasBk.getFechaCrea() == null
							&& dtCapaTemas.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaCrea() + " :: "+ dtCapaTemasBk.getFechaCrea());
								}
							cambios = true;
							dtCapaTemas.setFechaCrea(dtCapaTemasBk.getFechaCrea());
						
					} else if (dtCapaTemasBk.getFechaCrea() != null
							&& dtCapaTemas.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaCrea"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaCrea() + " :: "+ dtCapaTemasBk.getFechaCrea());
								}
							cambios = true;			
							dtCapaTemas.setFechaCrea(dtCapaTemasBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapaTemasBk.getFechaModif() != null
							&& dtCapaTemas.getFechaModif() != null) {
						if (!dtCapaTemasBk.getFechaModif().equals(
								dtCapaTemas.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaModif() + " :: "+ dtCapaTemasBk.getFechaModif());
								}
							cambios = true;
							dtCapaTemas.setFechaModif(dtCapaTemasBk.getFechaModif());
						}
					} else if (dtCapaTemasBk.getFechaModif() == null
							&& dtCapaTemas.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaModif() + " :: "+ dtCapaTemasBk.getFechaModif());
								}
							cambios = true;
							dtCapaTemas.setFechaModif(dtCapaTemasBk.getFechaModif());
						
					} else if (dtCapaTemasBk.getFechaModif() != null
							&& dtCapaTemas.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:FechaModif"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getFechaModif() + " :: "+ dtCapaTemasBk.getFechaModif());
								}
							cambios = true;			
							dtCapaTemas.setFechaModif(dtCapaTemasBk.getFechaModif());
					}
                                
				
				
				
				
				                                 
                                      if (dtCapaTemasBk.getRtmaddress() != null
							&& dtCapaTemas.getRtmaddress() != null) {
						if (!dtCapaTemasBk.getRtmaddress().equals(
								dtCapaTemas.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddress"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddress() + " :: "+ dtCapaTemasBk.getRtmaddress());
								}
							cambios = true;
							dtCapaTemas.setRtmaddress(dtCapaTemasBk.getRtmaddress());
						}
					} else if (dtCapaTemasBk.getRtmaddress() == null
							&& dtCapaTemas.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddress"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddress() + " :: "+ dtCapaTemasBk.getRtmaddress());
								}
							cambios = true;
							dtCapaTemas.setRtmaddress(dtCapaTemasBk.getRtmaddress());
						
					} else if (dtCapaTemasBk.getRtmaddress() != null
							&& dtCapaTemas.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddress"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddress() + " :: "+ dtCapaTemasBk.getRtmaddress());
								}
							cambios = true;			
							dtCapaTemas.setRtmaddress(dtCapaTemasBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapaTemasBk.getRtmaddressrst() != null
							&& dtCapaTemas.getRtmaddressrst() != null) {
						if (!dtCapaTemasBk.getRtmaddressrst().equals(
								dtCapaTemas.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddressrst"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddressrst() + " :: "+ dtCapaTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaTemas.setRtmaddressrst(dtCapaTemasBk.getRtmaddressrst());
						}
					} else if (dtCapaTemasBk.getRtmaddressrst() == null
							&& dtCapaTemas.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddressrst"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddressrst() + " :: "+ dtCapaTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaTemas.setRtmaddressrst(dtCapaTemasBk.getRtmaddressrst());
						
					} else if (dtCapaTemasBk.getRtmaddressrst() != null
							&& dtCapaTemas.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaTemas:Rtmaddressrst"+" :: "+dtCapaTemasBk.getIdCapaTemAgen().toString()+" :: "+ dtCapaTemas.getRtmaddressrst() + " :: "+ dtCapaTemasBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapaTemas.setRtmaddressrst(dtCapaTemasBk.getRtmaddressrst());
					}
                                
				
				
				
			
			return cambios;
	}
}