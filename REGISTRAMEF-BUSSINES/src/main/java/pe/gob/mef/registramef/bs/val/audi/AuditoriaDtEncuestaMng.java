package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEncuesta;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaBk;

/**
 * DT_ENCUESTA SERVICIO AUDITORIA Y CAMBIO: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEncuestaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEncuestaMng.class.getName());
	
	public static boolean auditarCambiosDtEncuesta(DtEncuestaBk dtEncuestaBk, DtEncuesta dtEncuesta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtEncuestaBk.getTipoServicio() != null
							&& dtEncuesta.getTipoServicio() != null) {
						if (!dtEncuestaBk.getTipoServicio().equals(
								dtEncuesta.getTipoServicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:TipoServicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getTipoServicio() + " :: "+ dtEncuestaBk.getTipoServicio());
								}
							cambios = true;
							dtEncuesta.setTipoServicio(dtEncuestaBk.getTipoServicio());
						}
					} else if (dtEncuestaBk.getTipoServicio() == null
							&& dtEncuesta.getTipoServicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:TipoServicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getTipoServicio() + " :: "+ dtEncuestaBk.getTipoServicio());
								}
							cambios = true;
							dtEncuesta.setTipoServicio(dtEncuestaBk.getTipoServicio());
						
					} else if (dtEncuestaBk.getTipoServicio() != null
							&& dtEncuesta.getTipoServicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:TipoServicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getTipoServicio() + " :: "+ dtEncuestaBk.getTipoServicio());
								}
							cambios = true;			
							dtEncuesta.setTipoServicio(dtEncuestaBk.getTipoServicio());
					}
				if (dtEncuestaBk.getFechaInicio() != null
							&& dtEncuesta.getFechaInicio() != null) {
						if (!dtEncuestaBk.getFechaInicio().equals(
								dtEncuesta.getFechaInicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaInicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaInicio() + " :: "+ dtEncuestaBk.getFechaInicio());
								}
							cambios = true;
							dtEncuesta.setFechaInicio(dtEncuestaBk.getFechaInicio());
						}
					} else if (dtEncuestaBk.getFechaInicio() == null
							&& dtEncuesta.getFechaInicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaInicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaInicio() + " :: "+ dtEncuestaBk.getFechaInicio());
								}
							cambios = true;
							dtEncuesta.setFechaInicio(dtEncuestaBk.getFechaInicio());
						
					} else if (dtEncuestaBk.getFechaInicio() != null
							&& dtEncuesta.getFechaInicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaInicio"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaInicio() + " :: "+ dtEncuestaBk.getFechaInicio());
								}
							cambios = true;			
							dtEncuesta.setFechaInicio(dtEncuestaBk.getFechaInicio());
					}
				if (dtEncuestaBk.getFechaFin() != null
							&& dtEncuesta.getFechaFin() != null) {
						if (!dtEncuestaBk.getFechaFin().equals(
								dtEncuesta.getFechaFin())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaFin"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaFin() + " :: "+ dtEncuestaBk.getFechaFin());
								}
							cambios = true;
							dtEncuesta.setFechaFin(dtEncuestaBk.getFechaFin());
						}
					} else if (dtEncuestaBk.getFechaFin() == null
							&& dtEncuesta.getFechaFin() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaFin"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaFin() + " :: "+ dtEncuestaBk.getFechaFin());
								}
							cambios = true;
							dtEncuesta.setFechaFin(dtEncuestaBk.getFechaFin());
						
					} else if (dtEncuestaBk.getFechaFin() != null
							&& dtEncuesta.getFechaFin() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaFin"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaFin() + " :: "+ dtEncuestaBk.getFechaFin());
								}
							cambios = true;			
							dtEncuesta.setFechaFin(dtEncuestaBk.getFechaFin());
					}
				if (dtEncuestaBk.getFlagBloqueo() != null
							&& dtEncuesta.getFlagBloqueo() != null) {
						if (!dtEncuestaBk.getFlagBloqueo().equals(
								dtEncuesta.getFlagBloqueo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FlagBloqueo"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFlagBloqueo() + " :: "+ dtEncuestaBk.getFlagBloqueo());
								}
							cambios = true;
							dtEncuesta.setFlagBloqueo(dtEncuestaBk.getFlagBloqueo());
						}
					} else if (dtEncuestaBk.getFlagBloqueo() == null
							&& dtEncuesta.getFlagBloqueo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FlagBloqueo"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFlagBloqueo() + " :: "+ dtEncuestaBk.getFlagBloqueo());
								}
							cambios = true;
							dtEncuesta.setFlagBloqueo(dtEncuestaBk.getFlagBloqueo());
						
					} else if (dtEncuestaBk.getFlagBloqueo() != null
							&& dtEncuesta.getFlagBloqueo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FlagBloqueo"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFlagBloqueo() + " :: "+ dtEncuestaBk.getFlagBloqueo());
								}
							cambios = true;			
							dtEncuesta.setFlagBloqueo(dtEncuestaBk.getFlagBloqueo());
					}
				if (dtEncuestaBk.getIdOrigen() != null
							&& dtEncuesta.getIdOrigen() != null) {
						if (!dtEncuestaBk.getIdOrigen().equals(
								dtEncuesta.getIdOrigen())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdOrigen"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdOrigen() + " :: "+ dtEncuestaBk.getIdOrigen());
								}
							cambios = true;
							dtEncuesta.setIdOrigen(dtEncuestaBk.getIdOrigen());
						}
					} else if (dtEncuestaBk.getIdOrigen() == null
							&& dtEncuesta.getIdOrigen() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdOrigen"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdOrigen() + " :: "+ dtEncuestaBk.getIdOrigen());
								}
							cambios = true;
							dtEncuesta.setIdOrigen(dtEncuestaBk.getIdOrigen());
						
					} else if (dtEncuestaBk.getIdOrigen() != null
							&& dtEncuesta.getIdOrigen() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdOrigen"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdOrigen() + " :: "+ dtEncuestaBk.getIdOrigen());
								}
							cambios = true;			
							dtEncuesta.setIdOrigen(dtEncuestaBk.getIdOrigen());
					}
				if (dtEncuestaBk.getIdPrestacion() != null
							&& dtEncuesta.getIdPrestacion() != null) {
						if (!dtEncuestaBk.getIdPrestacion().equals(
								dtEncuesta.getIdPrestacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdPrestacion"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdPrestacion() + " :: "+ dtEncuestaBk.getIdPrestacion());
								}
							cambios = true;
							dtEncuesta.setIdPrestacion(dtEncuestaBk.getIdPrestacion());
						}
					} else if (dtEncuestaBk.getIdPrestacion() == null
							&& dtEncuesta.getIdPrestacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdPrestacion"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdPrestacion() + " :: "+ dtEncuestaBk.getIdPrestacion());
								}
							cambios = true;
							dtEncuesta.setIdPrestacion(dtEncuestaBk.getIdPrestacion());
						
					} else if (dtEncuestaBk.getIdPrestacion() != null
							&& dtEncuesta.getIdPrestacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdPrestacion"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdPrestacion() + " :: "+ dtEncuestaBk.getIdPrestacion());
								}
							cambios = true;			
							dtEncuesta.setIdPrestacion(dtEncuestaBk.getIdPrestacion());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtEncuesta(DtEncuestaBk dtEncuestaBk, DtEncuesta dtEncuesta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtEncuestaBk.getEstado() != null
							&& dtEncuesta.getEstado() != null) {
						if (!dtEncuestaBk.getEstado().equals(
								dtEncuesta.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Estado"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getEstado() + " :: "+ dtEncuestaBk.getEstado());
								}
							cambios = true;
							dtEncuesta.setEstado(dtEncuestaBk.getEstado());
						}
					} else if (dtEncuestaBk.getEstado() == null
							&& dtEncuesta.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Estado"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getEstado() + " :: "+ dtEncuestaBk.getEstado());
								}
							cambios = true;
							dtEncuesta.setEstado(dtEncuestaBk.getEstado());
						
					} else if (dtEncuestaBk.getEstado() != null
							&& dtEncuesta.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Estado"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getEstado() + " :: "+ dtEncuestaBk.getEstado());
								}
							cambios = true;			
							dtEncuesta.setEstado(dtEncuestaBk.getEstado());
					}
                                
				                                 
                                      if (dtEncuestaBk.getIdusserCrea() != null
							&& dtEncuesta.getIdusserCrea() != null) {
						if (!dtEncuestaBk.getIdusserCrea().equals(
								dtEncuesta.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserCrea() + " :: "+ dtEncuestaBk.getIdusserCrea());
								}
							cambios = true;
							dtEncuesta.setIdusserCrea(dtEncuestaBk.getIdusserCrea());
						}
					} else if (dtEncuestaBk.getIdusserCrea() == null
							&& dtEncuesta.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserCrea() + " :: "+ dtEncuestaBk.getIdusserCrea());
								}
							cambios = true;
							dtEncuesta.setIdusserCrea(dtEncuestaBk.getIdusserCrea());
						
					} else if (dtEncuestaBk.getIdusserCrea() != null
							&& dtEncuesta.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserCrea() + " :: "+ dtEncuestaBk.getIdusserCrea());
								}
							cambios = true;			
							dtEncuesta.setIdusserCrea(dtEncuestaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEncuestaBk.getIdusserModif() != null
							&& dtEncuesta.getIdusserModif() != null) {
						if (!dtEncuestaBk.getIdusserModif().equals(
								dtEncuesta.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserModif() + " :: "+ dtEncuestaBk.getIdusserModif());
								}
							cambios = true;
							dtEncuesta.setIdusserModif(dtEncuestaBk.getIdusserModif());
						}
					} else if (dtEncuestaBk.getIdusserModif() == null
							&& dtEncuesta.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserModif() + " :: "+ dtEncuestaBk.getIdusserModif());
								}
							cambios = true;
							dtEncuesta.setIdusserModif(dtEncuestaBk.getIdusserModif());
						
					} else if (dtEncuestaBk.getIdusserModif() != null
							&& dtEncuesta.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:IdusserModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getIdusserModif() + " :: "+ dtEncuestaBk.getIdusserModif());
								}
							cambios = true;			
							dtEncuesta.setIdusserModif(dtEncuestaBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEncuestaBk.getFechaCrea() != null
							&& dtEncuesta.getFechaCrea() != null) {
						if (!dtEncuestaBk.getFechaCrea().equals(
								dtEncuesta.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaCrea() + " :: "+ dtEncuestaBk.getFechaCrea());
								}
							cambios = true;
							dtEncuesta.setFechaCrea(dtEncuestaBk.getFechaCrea());
						}
					} else if (dtEncuestaBk.getFechaCrea() == null
							&& dtEncuesta.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaCrea() + " :: "+ dtEncuestaBk.getFechaCrea());
								}
							cambios = true;
							dtEncuesta.setFechaCrea(dtEncuestaBk.getFechaCrea());
						
					} else if (dtEncuestaBk.getFechaCrea() != null
							&& dtEncuesta.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaCrea"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaCrea() + " :: "+ dtEncuestaBk.getFechaCrea());
								}
							cambios = true;			
							dtEncuesta.setFechaCrea(dtEncuestaBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEncuestaBk.getFechaModif() != null
							&& dtEncuesta.getFechaModif() != null) {
						if (!dtEncuestaBk.getFechaModif().equals(
								dtEncuesta.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaModif() + " :: "+ dtEncuestaBk.getFechaModif());
								}
							cambios = true;
							dtEncuesta.setFechaModif(dtEncuestaBk.getFechaModif());
						}
					} else if (dtEncuestaBk.getFechaModif() == null
							&& dtEncuesta.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaModif() + " :: "+ dtEncuestaBk.getFechaModif());
								}
							cambios = true;
							dtEncuesta.setFechaModif(dtEncuestaBk.getFechaModif());
						
					} else if (dtEncuestaBk.getFechaModif() != null
							&& dtEncuesta.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:FechaModif"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getFechaModif() + " :: "+ dtEncuestaBk.getFechaModif());
								}
							cambios = true;			
							dtEncuesta.setFechaModif(dtEncuestaBk.getFechaModif());
					}
                                
				                                 
                                      if (dtEncuestaBk.getRtmaddress() != null
							&& dtEncuesta.getRtmaddress() != null) {
						if (!dtEncuestaBk.getRtmaddress().equals(
								dtEncuesta.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddress"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddress() + " :: "+ dtEncuestaBk.getRtmaddress());
								}
							cambios = true;
							dtEncuesta.setRtmaddress(dtEncuestaBk.getRtmaddress());
						}
					} else if (dtEncuestaBk.getRtmaddress() == null
							&& dtEncuesta.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddress"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddress() + " :: "+ dtEncuestaBk.getRtmaddress());
								}
							cambios = true;
							dtEncuesta.setRtmaddress(dtEncuestaBk.getRtmaddress());
						
					} else if (dtEncuestaBk.getRtmaddress() != null
							&& dtEncuesta.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddress"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddress() + " :: "+ dtEncuestaBk.getRtmaddress());
								}
							cambios = true;			
							dtEncuesta.setRtmaddress(dtEncuestaBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEncuestaBk.getRtmaddressrst() != null
							&& dtEncuesta.getRtmaddressrst() != null) {
						if (!dtEncuestaBk.getRtmaddressrst().equals(
								dtEncuesta.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddressrst"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddressrst() + " :: "+ dtEncuestaBk.getRtmaddressrst());
								}
							cambios = true;
							dtEncuesta.setRtmaddressrst(dtEncuestaBk.getRtmaddressrst());
						}
					} else if (dtEncuestaBk.getRtmaddressrst() == null
							&& dtEncuesta.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddressrst"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddressrst() + " :: "+ dtEncuestaBk.getRtmaddressrst());
								}
							cambios = true;
							dtEncuesta.setRtmaddressrst(dtEncuestaBk.getRtmaddressrst());
						
					} else if (dtEncuestaBk.getRtmaddressrst() != null
							&& dtEncuesta.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuesta:Rtmaddressrst"+" :: "+dtEncuestaBk.getIdEncuesta().toString()+" :: "+ dtEncuesta.getRtmaddressrst() + " :: "+ dtEncuestaBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEncuesta.setRtmaddressrst(dtEncuestaBk.getRtmaddressrst());
					}
                                
				
				
				
				
			
			return cambios;
	}
}