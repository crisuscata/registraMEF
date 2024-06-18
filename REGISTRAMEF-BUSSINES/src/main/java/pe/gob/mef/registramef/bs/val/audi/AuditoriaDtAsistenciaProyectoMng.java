package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAsistenciaProyecto;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaProyectoBk;

/**
 * DT_ASISTENCIA_PROYECTO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAsistenciaProyectoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAsistenciaProyectoMng.class.getName());
	
	public static boolean auditarCambiosDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, DtAsistenciaProyecto dtAsistenciaProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAsistenciaProyectoBk.getIdAsistencia() != null
							&& dtAsistenciaProyecto.getIdAsistencia() != null) {
						if (!dtAsistenciaProyectoBk.getIdAsistencia().equals(
								dtAsistenciaProyecto.getIdAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdAsistencia"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdAsistencia() + " :: "+ dtAsistenciaProyectoBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdAsistencia(dtAsistenciaProyectoBk.getIdAsistencia());
						}
					} else if (dtAsistenciaProyectoBk.getIdAsistencia() == null
							&& dtAsistenciaProyecto.getIdAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdAsistencia"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdAsistencia() + " :: "+ dtAsistenciaProyectoBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdAsistencia(dtAsistenciaProyectoBk.getIdAsistencia());
						
					} else if (dtAsistenciaProyectoBk.getIdAsistencia() != null
							&& dtAsistenciaProyecto.getIdAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdAsistencia"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdAsistencia() + " :: "+ dtAsistenciaProyectoBk.getIdAsistencia());
								}
							cambios = true;			
							dtAsistenciaProyecto.setIdAsistencia(dtAsistenciaProyectoBk.getIdAsistencia());
					}
				if (dtAsistenciaProyectoBk.getIdProyecto() != null
							&& dtAsistenciaProyecto.getIdProyecto() != null) {
						if (!dtAsistenciaProyectoBk.getIdProyecto().equals(
								dtAsistenciaProyecto.getIdProyecto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdProyecto"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdProyecto() + " :: "+ dtAsistenciaProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdProyecto(dtAsistenciaProyectoBk.getIdProyecto());
						}
					} else if (dtAsistenciaProyectoBk.getIdProyecto() == null
							&& dtAsistenciaProyecto.getIdProyecto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdProyecto"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdProyecto() + " :: "+ dtAsistenciaProyectoBk.getIdProyecto());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdProyecto(dtAsistenciaProyectoBk.getIdProyecto());
						
					} else if (dtAsistenciaProyectoBk.getIdProyecto() != null
							&& dtAsistenciaProyecto.getIdProyecto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdProyecto"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdProyecto() + " :: "+ dtAsistenciaProyectoBk.getIdProyecto());
								}
							cambios = true;			
							dtAsistenciaProyecto.setIdProyecto(dtAsistenciaProyectoBk.getIdProyecto());
					}
				 
		            if (dtAsistenciaProyectoBk.getDetalle() != null
						&& dtAsistenciaProyecto.getDetalle() != null) {
					if (!dtAsistenciaProyectoBk.getDetalle().equals(
						dtAsistenciaProyecto.getDetalle())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Detalle"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getDetalle() + " :: "+ dtAsistenciaProyectoBk.getDetalle());								
						}
						cambios = true;
						dtAsistenciaProyecto.setDetalle(dtAsistenciaProyectoBk.getDetalle());
					}
				} else if (dtAsistenciaProyectoBk.getDetalle() == null
						&& dtAsistenciaProyecto.getDetalle() != null) {
					if (dtAsistenciaProyecto.getDetalle().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Detalle"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getDetalle() + " :: "+ dtAsistenciaProyectoBk.getDetalle());
						}
						cambios = true;
						dtAsistenciaProyecto.setDetalle(dtAsistenciaProyectoBk.getDetalle());
					}
				} else if (dtAsistenciaProyectoBk.getDetalle() != null
						&& dtAsistenciaProyecto.getDetalle() == null) {
					if (dtAsistenciaProyectoBk.getDetalle().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Detalle"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getDetalle() + " :: "+ dtAsistenciaProyectoBk.getDetalle());
						}
						cambios = true;
						dtAsistenciaProyecto.setDetalle(dtAsistenciaProyectoBk.getDetalle());
					}
				}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAsistenciaProyecto(DtAsistenciaProyectoBk dtAsistenciaProyectoBk, DtAsistenciaProyecto dtAsistenciaProyecto, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtAsistenciaProyectoBk.getEstado() != null
							&& dtAsistenciaProyecto.getEstado() != null) {
						if (!dtAsistenciaProyectoBk.getEstado().equals(
								dtAsistenciaProyecto.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Estado"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getEstado() + " :: "+ dtAsistenciaProyectoBk.getEstado());
								}
							cambios = true;
							dtAsistenciaProyecto.setEstado(dtAsistenciaProyectoBk.getEstado());
						}
					} else if (dtAsistenciaProyectoBk.getEstado() == null
							&& dtAsistenciaProyecto.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Estado"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getEstado() + " :: "+ dtAsistenciaProyectoBk.getEstado());
								}
							cambios = true;
							dtAsistenciaProyecto.setEstado(dtAsistenciaProyectoBk.getEstado());
						
					} else if (dtAsistenciaProyectoBk.getEstado() != null
							&& dtAsistenciaProyecto.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Estado"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getEstado() + " :: "+ dtAsistenciaProyectoBk.getEstado());
								}
							cambios = true;			
							dtAsistenciaProyecto.setEstado(dtAsistenciaProyectoBk.getEstado());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getIdusserCrea() != null
							&& dtAsistenciaProyecto.getIdusserCrea() != null) {
						if (!dtAsistenciaProyectoBk.getIdusserCrea().equals(
								dtAsistenciaProyecto.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserCrea() + " :: "+ dtAsistenciaProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdusserCrea(dtAsistenciaProyectoBk.getIdusserCrea());
						}
					} else if (dtAsistenciaProyectoBk.getIdusserCrea() == null
							&& dtAsistenciaProyecto.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserCrea() + " :: "+ dtAsistenciaProyectoBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdusserCrea(dtAsistenciaProyectoBk.getIdusserCrea());
						
					} else if (dtAsistenciaProyectoBk.getIdusserCrea() != null
							&& dtAsistenciaProyecto.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserCrea() + " :: "+ dtAsistenciaProyectoBk.getIdusserCrea());
								}
							cambios = true;			
							dtAsistenciaProyecto.setIdusserCrea(dtAsistenciaProyectoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getIdusserModif() != null
							&& dtAsistenciaProyecto.getIdusserModif() != null) {
						if (!dtAsistenciaProyectoBk.getIdusserModif().equals(
								dtAsistenciaProyecto.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserModif() + " :: "+ dtAsistenciaProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdusserModif(dtAsistenciaProyectoBk.getIdusserModif());
						}
					} else if (dtAsistenciaProyectoBk.getIdusserModif() == null
							&& dtAsistenciaProyecto.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserModif() + " :: "+ dtAsistenciaProyectoBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaProyecto.setIdusserModif(dtAsistenciaProyectoBk.getIdusserModif());
						
					} else if (dtAsistenciaProyectoBk.getIdusserModif() != null
							&& dtAsistenciaProyecto.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:IdusserModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getIdusserModif() + " :: "+ dtAsistenciaProyectoBk.getIdusserModif());
								}
							cambios = true;			
							dtAsistenciaProyecto.setIdusserModif(dtAsistenciaProyectoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getFechaCrea() != null
							&& dtAsistenciaProyecto.getFechaCrea() != null) {
						if (!dtAsistenciaProyectoBk.getFechaCrea().equals(
								dtAsistenciaProyecto.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaCrea() + " :: "+ dtAsistenciaProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaProyecto.setFechaCrea(dtAsistenciaProyectoBk.getFechaCrea());
						}
					} else if (dtAsistenciaProyectoBk.getFechaCrea() == null
							&& dtAsistenciaProyecto.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaCrea() + " :: "+ dtAsistenciaProyectoBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaProyecto.setFechaCrea(dtAsistenciaProyectoBk.getFechaCrea());
						
					} else if (dtAsistenciaProyectoBk.getFechaCrea() != null
							&& dtAsistenciaProyecto.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaCrea"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaCrea() + " :: "+ dtAsistenciaProyectoBk.getFechaCrea());
								}
							cambios = true;			
							dtAsistenciaProyecto.setFechaCrea(dtAsistenciaProyectoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getFechaModif() != null
							&& dtAsistenciaProyecto.getFechaModif() != null) {
						if (!dtAsistenciaProyectoBk.getFechaModif().equals(
								dtAsistenciaProyecto.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaModif() + " :: "+ dtAsistenciaProyectoBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaProyecto.setFechaModif(dtAsistenciaProyectoBk.getFechaModif());
						}
					} else if (dtAsistenciaProyectoBk.getFechaModif() == null
							&& dtAsistenciaProyecto.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaModif() + " :: "+ dtAsistenciaProyectoBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaProyecto.setFechaModif(dtAsistenciaProyectoBk.getFechaModif());
						
					} else if (dtAsistenciaProyectoBk.getFechaModif() != null
							&& dtAsistenciaProyecto.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:FechaModif"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getFechaModif() + " :: "+ dtAsistenciaProyectoBk.getFechaModif());
								}
							cambios = true;			
							dtAsistenciaProyecto.setFechaModif(dtAsistenciaProyectoBk.getFechaModif());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getRtmaddress() != null
							&& dtAsistenciaProyecto.getRtmaddress() != null) {
						if (!dtAsistenciaProyectoBk.getRtmaddress().equals(
								dtAsistenciaProyecto.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddress"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddress() + " :: "+ dtAsistenciaProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaProyecto.setRtmaddress(dtAsistenciaProyectoBk.getRtmaddress());
						}
					} else if (dtAsistenciaProyectoBk.getRtmaddress() == null
							&& dtAsistenciaProyecto.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddress"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddress() + " :: "+ dtAsistenciaProyectoBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaProyecto.setRtmaddress(dtAsistenciaProyectoBk.getRtmaddress());
						
					} else if (dtAsistenciaProyectoBk.getRtmaddress() != null
							&& dtAsistenciaProyecto.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddress"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddress() + " :: "+ dtAsistenciaProyectoBk.getRtmaddress());
								}
							cambios = true;			
							dtAsistenciaProyecto.setRtmaddress(dtAsistenciaProyectoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAsistenciaProyectoBk.getRtmaddressrst() != null
							&& dtAsistenciaProyecto.getRtmaddressrst() != null) {
						if (!dtAsistenciaProyectoBk.getRtmaddressrst().equals(
								dtAsistenciaProyecto.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddressrst"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddressrst() + " :: "+ dtAsistenciaProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaProyecto.setRtmaddressrst(dtAsistenciaProyectoBk.getRtmaddressrst());
						}
					} else if (dtAsistenciaProyectoBk.getRtmaddressrst() == null
							&& dtAsistenciaProyecto.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddressrst"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddressrst() + " :: "+ dtAsistenciaProyectoBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaProyecto.setRtmaddressrst(dtAsistenciaProyectoBk.getRtmaddressrst());
						
					} else if (dtAsistenciaProyectoBk.getRtmaddressrst() != null
							&& dtAsistenciaProyecto.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaProyecto:Rtmaddressrst"+" :: "+dtAsistenciaProyectoBk.getIdAsistProyecto().toString()+" :: "+ dtAsistenciaProyecto.getRtmaddressrst() + " :: "+ dtAsistenciaProyectoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAsistenciaProyecto.setRtmaddressrst(dtAsistenciaProyectoBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}