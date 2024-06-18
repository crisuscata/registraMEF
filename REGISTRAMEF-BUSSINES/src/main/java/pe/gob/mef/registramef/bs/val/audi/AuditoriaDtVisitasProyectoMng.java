package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtVisitasProyecto;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasProyectoBk;

/**
 * DT_VISITAS_PROYECTO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtVisitasProyectoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtVisitasProyectoMng.class.getName());
	
	public static boolean auditarCambiosDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, DtVisitasProyecto dtVisitasProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtVisitasProyectoBk.getIdVisita() != null
							&& dtVisitasProyecto.getIdVisita() != null) {
						if (!dtVisitasProyectoBk.getIdVisita().equals(
								dtVisitasProyecto.getIdVisita())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdVisita"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdVisita() + " :: "+ dtVisitasProyectoBk.getIdVisita());
								}
							cambios = true;
							dtVisitasProyecto.setIdVisita(dtVisitasProyectoBk.getIdVisita());
						}
					} else if (dtVisitasProyectoBk.getIdVisita() == null
							&& dtVisitasProyecto.getIdVisita() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdVisita"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdVisita() + " :: "+ dtVisitasProyectoBk.getIdVisita());
								}
							cambios = true;
							dtVisitasProyecto.setIdVisita(dtVisitasProyectoBk.getIdVisita());
						
					} else if (dtVisitasProyectoBk.getIdVisita() != null
							&& dtVisitasProyecto.getIdVisita() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdVisita"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdVisita() + " :: "+ dtVisitasProyectoBk.getIdVisita());
								}
							cambios = true;			
							dtVisitasProyecto.setIdVisita(dtVisitasProyectoBk.getIdVisita());
					}
				if (dtVisitasProyectoBk.getIdProyecto() != null
							&& dtVisitasProyecto.getIdProyecto() != null) {
						if (!dtVisitasProyectoBk.getIdProyecto().equals(
								dtVisitasProyecto.getIdProyecto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdProyecto"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdProyecto() + " :: "+ dtVisitasProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtVisitasProyecto.setIdProyecto(dtVisitasProyectoBk.getIdProyecto());
						}
					} else if (dtVisitasProyectoBk.getIdProyecto() == null
							&& dtVisitasProyecto.getIdProyecto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdProyecto"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdProyecto() + " :: "+ dtVisitasProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtVisitasProyecto.setIdProyecto(dtVisitasProyectoBk.getIdProyecto());
						
					} else if (dtVisitasProyectoBk.getIdProyecto() != null
							&& dtVisitasProyecto.getIdProyecto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdProyecto"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdProyecto() + " :: "+ dtVisitasProyectoBk.getIdProyecto());
								}
							cambios = true;			
							dtVisitasProyecto.setIdProyecto(dtVisitasProyectoBk.getIdProyecto());
					}
				if (dtVisitasProyectoBk.getDetalle() != null
							&& dtVisitasProyecto.getDetalle() != null) {
						if (!dtVisitasProyectoBk.getDetalle().equals(
								dtVisitasProyecto.getDetalle())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Detalle"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getDetalle() + " :: "+ dtVisitasProyectoBk.getDetalle());
								}
							cambios = true;
							dtVisitasProyecto.setDetalle(dtVisitasProyectoBk.getDetalle());
						}
					} else if (dtVisitasProyectoBk.getDetalle() == null
							&& dtVisitasProyecto.getDetalle() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Detalle"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getDetalle() + " :: "+ dtVisitasProyectoBk.getDetalle());
								}
							cambios = true;
							dtVisitasProyecto.setDetalle(dtVisitasProyectoBk.getDetalle());
						
					} else if (dtVisitasProyectoBk.getDetalle() != null
							&& dtVisitasProyecto.getDetalle() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Detalle"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getDetalle() + " :: "+ dtVisitasProyectoBk.getDetalle());
								}
							cambios = true;			
							dtVisitasProyecto.setDetalle(dtVisitasProyectoBk.getDetalle());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtVisitasProyecto(DtVisitasProyectoBk dtVisitasProyectoBk, DtVisitasProyecto dtVisitasProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtVisitasProyectoBk.getEstado() != null
							&& dtVisitasProyecto.getEstado() != null) {
						if (!dtVisitasProyectoBk.getEstado().equals(
								dtVisitasProyecto.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Estado"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getEstado() + " :: "+ dtVisitasProyectoBk.getEstado());
								}
							cambios = true;
							dtVisitasProyecto.setEstado(dtVisitasProyectoBk.getEstado());
						}
					} else if (dtVisitasProyectoBk.getEstado() == null
							&& dtVisitasProyecto.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Estado"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getEstado() + " :: "+ dtVisitasProyectoBk.getEstado());
								}
							cambios = true;
							dtVisitasProyecto.setEstado(dtVisitasProyectoBk.getEstado());
						
					} else if (dtVisitasProyectoBk.getEstado() != null
							&& dtVisitasProyecto.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Estado"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getEstado() + " :: "+ dtVisitasProyectoBk.getEstado());
								}
							cambios = true;			
							dtVisitasProyecto.setEstado(dtVisitasProyectoBk.getEstado());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getIdusserCrea() != null
							&& dtVisitasProyecto.getIdusserCrea() != null) {
						if (!dtVisitasProyectoBk.getIdusserCrea().equals(
								dtVisitasProyecto.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserCrea() + " :: "+ dtVisitasProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasProyecto.setIdusserCrea(dtVisitasProyectoBk.getIdusserCrea());
						}
					} else if (dtVisitasProyectoBk.getIdusserCrea() == null
							&& dtVisitasProyecto.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserCrea() + " :: "+ dtVisitasProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitasProyecto.setIdusserCrea(dtVisitasProyectoBk.getIdusserCrea());
						
					} else if (dtVisitasProyectoBk.getIdusserCrea() != null
							&& dtVisitasProyecto.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserCrea() + " :: "+ dtVisitasProyectoBk.getIdusserCrea());
								}
							cambios = true;			
							dtVisitasProyecto.setIdusserCrea(dtVisitasProyectoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getIdusserModif() != null
							&& dtVisitasProyecto.getIdusserModif() != null) {
						if (!dtVisitasProyectoBk.getIdusserModif().equals(
								dtVisitasProyecto.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserModif() + " :: "+ dtVisitasProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasProyecto.setIdusserModif(dtVisitasProyectoBk.getIdusserModif());
						}
					} else if (dtVisitasProyectoBk.getIdusserModif() == null
							&& dtVisitasProyecto.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserModif() + " :: "+ dtVisitasProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtVisitasProyecto.setIdusserModif(dtVisitasProyectoBk.getIdusserModif());
						
					} else if (dtVisitasProyectoBk.getIdusserModif() != null
							&& dtVisitasProyecto.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:IdusserModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getIdusserModif() + " :: "+ dtVisitasProyectoBk.getIdusserModif());
								}
							cambios = true;			
							dtVisitasProyecto.setIdusserModif(dtVisitasProyectoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getFechaCrea() != null
							&& dtVisitasProyecto.getFechaCrea() != null) {
						if (!dtVisitasProyectoBk.getFechaCrea().equals(
								dtVisitasProyecto.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaCrea() + " :: "+ dtVisitasProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasProyecto.setFechaCrea(dtVisitasProyectoBk.getFechaCrea());
						}
					} else if (dtVisitasProyectoBk.getFechaCrea() == null
							&& dtVisitasProyecto.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaCrea() + " :: "+ dtVisitasProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtVisitasProyecto.setFechaCrea(dtVisitasProyectoBk.getFechaCrea());
						
					} else if (dtVisitasProyectoBk.getFechaCrea() != null
							&& dtVisitasProyecto.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaCrea"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaCrea() + " :: "+ dtVisitasProyectoBk.getFechaCrea());
								}
							cambios = true;			
							dtVisitasProyecto.setFechaCrea(dtVisitasProyectoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getFechaModif() != null
							&& dtVisitasProyecto.getFechaModif() != null) {
						if (!dtVisitasProyectoBk.getFechaModif().equals(
								dtVisitasProyecto.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaModif() + " :: "+ dtVisitasProyectoBk.getFechaModif());
								}
							cambios = true;
							dtVisitasProyecto.setFechaModif(dtVisitasProyectoBk.getFechaModif());
						}
					} else if (dtVisitasProyectoBk.getFechaModif() == null
							&& dtVisitasProyecto.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaModif() + " :: "+ dtVisitasProyectoBk.getFechaModif());
								}
							cambios = true;
							dtVisitasProyecto.setFechaModif(dtVisitasProyectoBk.getFechaModif());
						
					} else if (dtVisitasProyectoBk.getFechaModif() != null
							&& dtVisitasProyecto.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:FechaModif"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getFechaModif() + " :: "+ dtVisitasProyectoBk.getFechaModif());
								}
							cambios = true;			
							dtVisitasProyecto.setFechaModif(dtVisitasProyectoBk.getFechaModif());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getRtmaddress() != null
							&& dtVisitasProyecto.getRtmaddress() != null) {
						if (!dtVisitasProyectoBk.getRtmaddress().equals(
								dtVisitasProyecto.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddress"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddress() + " :: "+ dtVisitasProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasProyecto.setRtmaddress(dtVisitasProyectoBk.getRtmaddress());
						}
					} else if (dtVisitasProyectoBk.getRtmaddress() == null
							&& dtVisitasProyecto.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddress"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddress() + " :: "+ dtVisitasProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtVisitasProyecto.setRtmaddress(dtVisitasProyectoBk.getRtmaddress());
						
					} else if (dtVisitasProyectoBk.getRtmaddress() != null
							&& dtVisitasProyecto.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddress"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddress() + " :: "+ dtVisitasProyectoBk.getRtmaddress());
								}
							cambios = true;			
							dtVisitasProyecto.setRtmaddress(dtVisitasProyectoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtVisitasProyectoBk.getRtmaddressrst() != null
							&& dtVisitasProyecto.getRtmaddressrst() != null) {
						if (!dtVisitasProyectoBk.getRtmaddressrst().equals(
								dtVisitasProyecto.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddressrst"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddressrst() + " :: "+ dtVisitasProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasProyecto.setRtmaddressrst(dtVisitasProyectoBk.getRtmaddressrst());
						}
					} else if (dtVisitasProyectoBk.getRtmaddressrst() == null
							&& dtVisitasProyecto.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddressrst"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddressrst() + " :: "+ dtVisitasProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitasProyecto.setRtmaddressrst(dtVisitasProyectoBk.getRtmaddressrst());
						
					} else if (dtVisitasProyectoBk.getRtmaddressrst() != null
							&& dtVisitasProyecto.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitasProyecto:Rtmaddressrst"+" :: "+dtVisitasProyectoBk.getIdVisitaProyecto().toString()+" :: "+ dtVisitasProyecto.getRtmaddressrst() + " :: "+ dtVisitasProyectoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtVisitasProyecto.setRtmaddressrst(dtVisitasProyectoBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}