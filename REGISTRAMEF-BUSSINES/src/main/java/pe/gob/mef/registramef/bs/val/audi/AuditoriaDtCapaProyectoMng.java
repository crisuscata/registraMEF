package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapaProyecto;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaProyectoBk;

/**
 * DT_CAPA_PROYECTO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapaProyectoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapaProyectoMng.class.getName());
	
	public static boolean auditarCambiosDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, DtCapaProyecto dtCapaProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapaProyectoBk.getIdProyecto() != null
							&& dtCapaProyecto.getIdProyecto() != null) {
						if (!dtCapaProyectoBk.getIdProyecto().equals(
								dtCapaProyecto.getIdProyecto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdProyecto"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdProyecto() + " :: "+ dtCapaProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtCapaProyecto.setIdProyecto(dtCapaProyectoBk.getIdProyecto());
						}
					} else if (dtCapaProyectoBk.getIdProyecto() == null
							&& dtCapaProyecto.getIdProyecto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdProyecto"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdProyecto() + " :: "+ dtCapaProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtCapaProyecto.setIdProyecto(dtCapaProyectoBk.getIdProyecto());
						
					} else if (dtCapaProyectoBk.getIdProyecto() != null
							&& dtCapaProyecto.getIdProyecto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdProyecto"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdProyecto() + " :: "+ dtCapaProyectoBk.getIdProyecto());
								}
							cambios = true;			
							dtCapaProyecto.setIdProyecto(dtCapaProyectoBk.getIdProyecto());
					}
				if (dtCapaProyectoBk.getIdCapacitacion() != null
							&& dtCapaProyecto.getIdCapacitacion() != null) {
						if (!dtCapaProyectoBk.getIdCapacitacion().equals(
								dtCapaProyecto.getIdCapacitacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdCapacitacion"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdCapacitacion() + " :: "+ dtCapaProyectoBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaProyecto.setIdCapacitacion(dtCapaProyectoBk.getIdCapacitacion());
						}
					} else if (dtCapaProyectoBk.getIdCapacitacion() == null
							&& dtCapaProyecto.getIdCapacitacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdCapacitacion"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdCapacitacion() + " :: "+ dtCapaProyectoBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaProyecto.setIdCapacitacion(dtCapaProyectoBk.getIdCapacitacion());
						
					} else if (dtCapaProyectoBk.getIdCapacitacion() != null
							&& dtCapaProyecto.getIdCapacitacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdCapacitacion"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdCapacitacion() + " :: "+ dtCapaProyectoBk.getIdCapacitacion());
								}
							cambios = true;			
							dtCapaProyecto.setIdCapacitacion(dtCapaProyectoBk.getIdCapacitacion());
					}
				if (dtCapaProyectoBk.getDetalle() != null
							&& dtCapaProyecto.getDetalle() != null) {
						if (!dtCapaProyectoBk.getDetalle().equals(
								dtCapaProyecto.getDetalle())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Detalle"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getDetalle() + " :: "+ dtCapaProyectoBk.getDetalle());
								}
							cambios = true;
							dtCapaProyecto.setDetalle(dtCapaProyectoBk.getDetalle());
						}
					} else if (dtCapaProyectoBk.getDetalle() == null
							&& dtCapaProyecto.getDetalle() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Detalle"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getDetalle() + " :: "+ dtCapaProyectoBk.getDetalle());
								}
							cambios = true;
							dtCapaProyecto.setDetalle(dtCapaProyectoBk.getDetalle());
						
					} else if (dtCapaProyectoBk.getDetalle() != null
							&& dtCapaProyecto.getDetalle() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Detalle"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getDetalle() + " :: "+ dtCapaProyectoBk.getDetalle());
								}
							cambios = true;			
							dtCapaProyecto.setDetalle(dtCapaProyectoBk.getDetalle());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapaProyecto(DtCapaProyectoBk dtCapaProyectoBk, DtCapaProyecto dtCapaProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtCapaProyectoBk.getEstado() != null
							&& dtCapaProyecto.getEstado() != null) {
						if (!dtCapaProyectoBk.getEstado().equals(
								dtCapaProyecto.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Estado"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getEstado() + " :: "+ dtCapaProyectoBk.getEstado());
								}
							cambios = true;
							dtCapaProyecto.setEstado(dtCapaProyectoBk.getEstado());
						}
					} else if (dtCapaProyectoBk.getEstado() == null
							&& dtCapaProyecto.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Estado"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getEstado() + " :: "+ dtCapaProyectoBk.getEstado());
								}
							cambios = true;
							dtCapaProyecto.setEstado(dtCapaProyectoBk.getEstado());
						
					} else if (dtCapaProyectoBk.getEstado() != null
							&& dtCapaProyecto.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Estado"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getEstado() + " :: "+ dtCapaProyectoBk.getEstado());
								}
							cambios = true;			
							dtCapaProyecto.setEstado(dtCapaProyectoBk.getEstado());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getIdusserCrea() != null
							&& dtCapaProyecto.getIdusserCrea() != null) {
						if (!dtCapaProyectoBk.getIdusserCrea().equals(
								dtCapaProyecto.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserCrea() + " :: "+ dtCapaProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaProyecto.setIdusserCrea(dtCapaProyectoBk.getIdusserCrea());
						}
					} else if (dtCapaProyectoBk.getIdusserCrea() == null
							&& dtCapaProyecto.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserCrea() + " :: "+ dtCapaProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaProyecto.setIdusserCrea(dtCapaProyectoBk.getIdusserCrea());
						
					} else if (dtCapaProyectoBk.getIdusserCrea() != null
							&& dtCapaProyecto.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserCrea() + " :: "+ dtCapaProyectoBk.getIdusserCrea());
								}
							cambios = true;			
							dtCapaProyecto.setIdusserCrea(dtCapaProyectoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getIdusserModif() != null
							&& dtCapaProyecto.getIdusserModif() != null) {
						if (!dtCapaProyectoBk.getIdusserModif().equals(
								dtCapaProyecto.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserModif() + " :: "+ dtCapaProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtCapaProyecto.setIdusserModif(dtCapaProyectoBk.getIdusserModif());
						}
					} else if (dtCapaProyectoBk.getIdusserModif() == null
							&& dtCapaProyecto.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserModif() + " :: "+ dtCapaProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtCapaProyecto.setIdusserModif(dtCapaProyectoBk.getIdusserModif());
						
					} else if (dtCapaProyectoBk.getIdusserModif() != null
							&& dtCapaProyecto.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:IdusserModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getIdusserModif() + " :: "+ dtCapaProyectoBk.getIdusserModif());
								}
							cambios = true;			
							dtCapaProyecto.setIdusserModif(dtCapaProyectoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getFechaCrea() != null
							&& dtCapaProyecto.getFechaCrea() != null) {
						if (!dtCapaProyectoBk.getFechaCrea().equals(
								dtCapaProyecto.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaCrea() + " :: "+ dtCapaProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtCapaProyecto.setFechaCrea(dtCapaProyectoBk.getFechaCrea());
						}
					} else if (dtCapaProyectoBk.getFechaCrea() == null
							&& dtCapaProyecto.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaCrea() + " :: "+ dtCapaProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtCapaProyecto.setFechaCrea(dtCapaProyectoBk.getFechaCrea());
						
					} else if (dtCapaProyectoBk.getFechaCrea() != null
							&& dtCapaProyecto.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaCrea"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaCrea() + " :: "+ dtCapaProyectoBk.getFechaCrea());
								}
							cambios = true;			
							dtCapaProyecto.setFechaCrea(dtCapaProyectoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getFechaModif() != null
							&& dtCapaProyecto.getFechaModif() != null) {
						if (!dtCapaProyectoBk.getFechaModif().equals(
								dtCapaProyecto.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaModif() + " :: "+ dtCapaProyectoBk.getFechaModif());
								}
							cambios = true;
							dtCapaProyecto.setFechaModif(dtCapaProyectoBk.getFechaModif());
						}
					} else if (dtCapaProyectoBk.getFechaModif() == null
							&& dtCapaProyecto.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaModif() + " :: "+ dtCapaProyectoBk.getFechaModif());
								}
							cambios = true;
							dtCapaProyecto.setFechaModif(dtCapaProyectoBk.getFechaModif());
						
					} else if (dtCapaProyectoBk.getFechaModif() != null
							&& dtCapaProyecto.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:FechaModif"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getFechaModif() + " :: "+ dtCapaProyectoBk.getFechaModif());
								}
							cambios = true;			
							dtCapaProyecto.setFechaModif(dtCapaProyectoBk.getFechaModif());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getRtmaddress() != null
							&& dtCapaProyecto.getRtmaddress() != null) {
						if (!dtCapaProyectoBk.getRtmaddress().equals(
								dtCapaProyecto.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddress"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddress() + " :: "+ dtCapaProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtCapaProyecto.setRtmaddress(dtCapaProyectoBk.getRtmaddress());
						}
					} else if (dtCapaProyectoBk.getRtmaddress() == null
							&& dtCapaProyecto.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddress"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddress() + " :: "+ dtCapaProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtCapaProyecto.setRtmaddress(dtCapaProyectoBk.getRtmaddress());
						
					} else if (dtCapaProyectoBk.getRtmaddress() != null
							&& dtCapaProyecto.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddress"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddress() + " :: "+ dtCapaProyectoBk.getRtmaddress());
								}
							cambios = true;			
							dtCapaProyecto.setRtmaddress(dtCapaProyectoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapaProyectoBk.getRtmaddressrst() != null
							&& dtCapaProyecto.getRtmaddressrst() != null) {
						if (!dtCapaProyectoBk.getRtmaddressrst().equals(
								dtCapaProyecto.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddressrst"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddressrst() + " :: "+ dtCapaProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaProyecto.setRtmaddressrst(dtCapaProyectoBk.getRtmaddressrst());
						}
					} else if (dtCapaProyectoBk.getRtmaddressrst() == null
							&& dtCapaProyecto.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddressrst"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddressrst() + " :: "+ dtCapaProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaProyecto.setRtmaddressrst(dtCapaProyectoBk.getRtmaddressrst());
						
					} else if (dtCapaProyectoBk.getRtmaddressrst() != null
							&& dtCapaProyecto.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaProyecto:Rtmaddressrst"+" :: "+dtCapaProyectoBk.getIdCapaProyecto().toString()+" :: "+ dtCapaProyecto.getRtmaddressrst() + " :: "+ dtCapaProyectoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapaProyecto.setRtmaddressrst(dtCapaProyectoBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}