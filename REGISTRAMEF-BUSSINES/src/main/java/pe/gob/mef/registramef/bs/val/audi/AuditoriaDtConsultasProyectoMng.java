package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtConsultasProyecto;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasProyectoBk;

/**
 * DT_CONSULTAS_PROYECTO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CONSULTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtConsultasProyectoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtConsultasProyectoMng.class.getName());
	
	public static boolean auditarCambiosDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, DtConsultasProyecto dtConsultasProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtConsultasProyectoBk.getIdConsulta() != null
							&& dtConsultasProyecto.getIdConsulta() != null) {
						if (!dtConsultasProyectoBk.getIdConsulta().equals(
								dtConsultasProyecto.getIdConsulta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdConsulta"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdConsulta() + " :: "+ dtConsultasProyectoBk.getIdConsulta());
								}
							cambios = true;
							dtConsultasProyecto.setIdConsulta(dtConsultasProyectoBk.getIdConsulta());
						}
					} else if (dtConsultasProyectoBk.getIdConsulta() == null
							&& dtConsultasProyecto.getIdConsulta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdConsulta"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdConsulta() + " :: "+ dtConsultasProyectoBk.getIdConsulta());
								}
							cambios = true;
							dtConsultasProyecto.setIdConsulta(dtConsultasProyectoBk.getIdConsulta());
						
					} else if (dtConsultasProyectoBk.getIdConsulta() != null
							&& dtConsultasProyecto.getIdConsulta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdConsulta"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdConsulta() + " :: "+ dtConsultasProyectoBk.getIdConsulta());
								}
							cambios = true;			
							dtConsultasProyecto.setIdConsulta(dtConsultasProyectoBk.getIdConsulta());
					}
				if (dtConsultasProyectoBk.getIdProyecto() != null
							&& dtConsultasProyecto.getIdProyecto() != null) {
						if (!dtConsultasProyectoBk.getIdProyecto().equals(
								dtConsultasProyecto.getIdProyecto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdProyecto"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdProyecto() + " :: "+ dtConsultasProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtConsultasProyecto.setIdProyecto(dtConsultasProyectoBk.getIdProyecto());
						}
					} else if (dtConsultasProyectoBk.getIdProyecto() == null
							&& dtConsultasProyecto.getIdProyecto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdProyecto"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdProyecto() + " :: "+ dtConsultasProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtConsultasProyecto.setIdProyecto(dtConsultasProyectoBk.getIdProyecto());
						
					} else if (dtConsultasProyectoBk.getIdProyecto() != null
							&& dtConsultasProyecto.getIdProyecto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdProyecto"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdProyecto() + " :: "+ dtConsultasProyectoBk.getIdProyecto());
								}
							cambios = true;			
							dtConsultasProyecto.setIdProyecto(dtConsultasProyectoBk.getIdProyecto());
					}
				if (dtConsultasProyectoBk.getDetalle() != null
							&& dtConsultasProyecto.getDetalle() != null) {
						if (!dtConsultasProyectoBk.getDetalle().equals(
								dtConsultasProyecto.getDetalle())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Detalle"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getDetalle() + " :: "+ dtConsultasProyectoBk.getDetalle());
								}
							cambios = true;
							dtConsultasProyecto.setDetalle(dtConsultasProyectoBk.getDetalle());
						}
					} else if (dtConsultasProyectoBk.getDetalle() == null
							&& dtConsultasProyecto.getDetalle() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Detalle"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getDetalle() + " :: "+ dtConsultasProyectoBk.getDetalle());
								}
							cambios = true;
							dtConsultasProyecto.setDetalle(dtConsultasProyectoBk.getDetalle());
						
					} else if (dtConsultasProyectoBk.getDetalle() != null
							&& dtConsultasProyecto.getDetalle() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Detalle"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getDetalle() + " :: "+ dtConsultasProyectoBk.getDetalle());
								}
							cambios = true;			
							dtConsultasProyecto.setDetalle(dtConsultasProyectoBk.getDetalle());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtConsultasProyecto(DtConsultasProyectoBk dtConsultasProyectoBk, DtConsultasProyecto dtConsultasProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtConsultasProyectoBk.getEstado() != null
							&& dtConsultasProyecto.getEstado() != null) {
						if (!dtConsultasProyectoBk.getEstado().equals(
								dtConsultasProyecto.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Estado"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getEstado() + " :: "+ dtConsultasProyectoBk.getEstado());
								}
							cambios = true;
							dtConsultasProyecto.setEstado(dtConsultasProyectoBk.getEstado());
						}
					} else if (dtConsultasProyectoBk.getEstado() == null
							&& dtConsultasProyecto.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Estado"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getEstado() + " :: "+ dtConsultasProyectoBk.getEstado());
								}
							cambios = true;
							dtConsultasProyecto.setEstado(dtConsultasProyectoBk.getEstado());
						
					} else if (dtConsultasProyectoBk.getEstado() != null
							&& dtConsultasProyecto.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Estado"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getEstado() + " :: "+ dtConsultasProyectoBk.getEstado());
								}
							cambios = true;			
							dtConsultasProyecto.setEstado(dtConsultasProyectoBk.getEstado());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getIdusserCrea() != null
							&& dtConsultasProyecto.getIdusserCrea() != null) {
						if (!dtConsultasProyectoBk.getIdusserCrea().equals(
								dtConsultasProyecto.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserCrea() + " :: "+ dtConsultasProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtConsultasProyecto.setIdusserCrea(dtConsultasProyectoBk.getIdusserCrea());
						}
					} else if (dtConsultasProyectoBk.getIdusserCrea() == null
							&& dtConsultasProyecto.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserCrea() + " :: "+ dtConsultasProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtConsultasProyecto.setIdusserCrea(dtConsultasProyectoBk.getIdusserCrea());
						
					} else if (dtConsultasProyectoBk.getIdusserCrea() != null
							&& dtConsultasProyecto.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserCrea() + " :: "+ dtConsultasProyectoBk.getIdusserCrea());
								}
							cambios = true;			
							dtConsultasProyecto.setIdusserCrea(dtConsultasProyectoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getIdusserModif() != null
							&& dtConsultasProyecto.getIdusserModif() != null) {
						if (!dtConsultasProyectoBk.getIdusserModif().equals(
								dtConsultasProyecto.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserModif() + " :: "+ dtConsultasProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtConsultasProyecto.setIdusserModif(dtConsultasProyectoBk.getIdusserModif());
						}
					} else if (dtConsultasProyectoBk.getIdusserModif() == null
							&& dtConsultasProyecto.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserModif() + " :: "+ dtConsultasProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtConsultasProyecto.setIdusserModif(dtConsultasProyectoBk.getIdusserModif());
						
					} else if (dtConsultasProyectoBk.getIdusserModif() != null
							&& dtConsultasProyecto.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:IdusserModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getIdusserModif() + " :: "+ dtConsultasProyectoBk.getIdusserModif());
								}
							cambios = true;			
							dtConsultasProyecto.setIdusserModif(dtConsultasProyectoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getFechaCrea() != null
							&& dtConsultasProyecto.getFechaCrea() != null) {
						if (!dtConsultasProyectoBk.getFechaCrea().equals(
								dtConsultasProyecto.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaCrea() + " :: "+ dtConsultasProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtConsultasProyecto.setFechaCrea(dtConsultasProyectoBk.getFechaCrea());
						}
					} else if (dtConsultasProyectoBk.getFechaCrea() == null
							&& dtConsultasProyecto.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaCrea() + " :: "+ dtConsultasProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtConsultasProyecto.setFechaCrea(dtConsultasProyectoBk.getFechaCrea());
						
					} else if (dtConsultasProyectoBk.getFechaCrea() != null
							&& dtConsultasProyecto.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaCrea"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaCrea() + " :: "+ dtConsultasProyectoBk.getFechaCrea());
								}
							cambios = true;			
							dtConsultasProyecto.setFechaCrea(dtConsultasProyectoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getFechaModif() != null
							&& dtConsultasProyecto.getFechaModif() != null) {
						if (!dtConsultasProyectoBk.getFechaModif().equals(
								dtConsultasProyecto.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaModif() + " :: "+ dtConsultasProyectoBk.getFechaModif());
								}
							cambios = true;
							dtConsultasProyecto.setFechaModif(dtConsultasProyectoBk.getFechaModif());
						}
					} else if (dtConsultasProyectoBk.getFechaModif() == null
							&& dtConsultasProyecto.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaModif() + " :: "+ dtConsultasProyectoBk.getFechaModif());
								}
							cambios = true;
							dtConsultasProyecto.setFechaModif(dtConsultasProyectoBk.getFechaModif());
						
					} else if (dtConsultasProyectoBk.getFechaModif() != null
							&& dtConsultasProyecto.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:FechaModif"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getFechaModif() + " :: "+ dtConsultasProyectoBk.getFechaModif());
								}
							cambios = true;			
							dtConsultasProyecto.setFechaModif(dtConsultasProyectoBk.getFechaModif());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getRtmaddress() != null
							&& dtConsultasProyecto.getRtmaddress() != null) {
						if (!dtConsultasProyectoBk.getRtmaddress().equals(
								dtConsultasProyecto.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddress"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddress() + " :: "+ dtConsultasProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtConsultasProyecto.setRtmaddress(dtConsultasProyectoBk.getRtmaddress());
						}
					} else if (dtConsultasProyectoBk.getRtmaddress() == null
							&& dtConsultasProyecto.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddress"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddress() + " :: "+ dtConsultasProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtConsultasProyecto.setRtmaddress(dtConsultasProyectoBk.getRtmaddress());
						
					} else if (dtConsultasProyectoBk.getRtmaddress() != null
							&& dtConsultasProyecto.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddress"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddress() + " :: "+ dtConsultasProyectoBk.getRtmaddress());
								}
							cambios = true;			
							dtConsultasProyecto.setRtmaddress(dtConsultasProyectoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtConsultasProyectoBk.getRtmaddressrst() != null
							&& dtConsultasProyecto.getRtmaddressrst() != null) {
						if (!dtConsultasProyectoBk.getRtmaddressrst().equals(
								dtConsultasProyecto.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddressrst"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddressrst() + " :: "+ dtConsultasProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtConsultasProyecto.setRtmaddressrst(dtConsultasProyectoBk.getRtmaddressrst());
						}
					} else if (dtConsultasProyectoBk.getRtmaddressrst() == null
							&& dtConsultasProyecto.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddressrst"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddressrst() + " :: "+ dtConsultasProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtConsultasProyecto.setRtmaddressrst(dtConsultasProyectoBk.getRtmaddressrst());
						
					} else if (dtConsultasProyectoBk.getRtmaddressrst() != null
							&& dtConsultasProyecto.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultasProyecto:Rtmaddressrst"+" :: "+dtConsultasProyectoBk.getIdConsProyecto().toString()+" :: "+ dtConsultasProyecto.getRtmaddressrst() + " :: "+ dtConsultasProyectoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtConsultasProyecto.setRtmaddressrst(dtConsultasProyectoBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}