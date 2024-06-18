package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.transfer.bk.DtAmpliacionFechaBk;

/**
 * DT_AMPLIACION_FECHA SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAmpliacionFechaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAmpliacionFechaMng.class.getName());
	
	public static boolean auditarCambiosDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, DtAmpliacionFecha dtAmpliacionFecha, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAmpliacionFechaBk.getTipoFechaCorte() != null
							&& dtAmpliacionFecha.getTipoFechaCorte() != null) {
						if (!dtAmpliacionFechaBk.getTipoFechaCorte().equals(
								dtAmpliacionFecha.getTipoFechaCorte())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:TipoFechaCorte"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getTipoFechaCorte() + " :: "+ dtAmpliacionFechaBk.getTipoFechaCorte());
								}
							cambios = true;
							dtAmpliacionFecha.setTipoFechaCorte(dtAmpliacionFechaBk.getTipoFechaCorte());
						}
					} else if (dtAmpliacionFechaBk.getTipoFechaCorte() == null
							&& dtAmpliacionFecha.getTipoFechaCorte() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:TipoFechaCorte"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getTipoFechaCorte() + " :: "+ dtAmpliacionFechaBk.getTipoFechaCorte());
								}
							cambios = true;
							dtAmpliacionFecha.setTipoFechaCorte(dtAmpliacionFechaBk.getTipoFechaCorte());
						
					} else if (dtAmpliacionFechaBk.getTipoFechaCorte() != null
							&& dtAmpliacionFecha.getTipoFechaCorte() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:TipoFechaCorte"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getTipoFechaCorte() + " :: "+ dtAmpliacionFechaBk.getTipoFechaCorte());
								}
							cambios = true;			
							dtAmpliacionFecha.setTipoFechaCorte(dtAmpliacionFechaBk.getTipoFechaCorte());
					}
				if (dtAmpliacionFechaBk.getIdSede() != null
							&& dtAmpliacionFecha.getIdSede() != null) {
						if (!dtAmpliacionFechaBk.getIdSede().equals(
								dtAmpliacionFecha.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSede"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSede() + " :: "+ dtAmpliacionFechaBk.getIdSede());
								}
							cambios = true;
							dtAmpliacionFecha.setIdSede(dtAmpliacionFechaBk.getIdSede());
						}
					} else if (dtAmpliacionFechaBk.getIdSede() == null
							&& dtAmpliacionFecha.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSede"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSede() + " :: "+ dtAmpliacionFechaBk.getIdSede());
								}
							cambios = true;
							dtAmpliacionFecha.setIdSede(dtAmpliacionFechaBk.getIdSede());
						
					} else if (dtAmpliacionFechaBk.getIdSede() != null
							&& dtAmpliacionFecha.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSede"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSede() + " :: "+ dtAmpliacionFechaBk.getIdSede());
								}
							cambios = true;			
							dtAmpliacionFecha.setIdSede(dtAmpliacionFechaBk.getIdSede());
					}
				if (dtAmpliacionFechaBk.getIdSistAdmi() != null
							&& dtAmpliacionFecha.getIdSistAdmi() != null) {
						if (!dtAmpliacionFechaBk.getIdSistAdmi().equals(
								dtAmpliacionFecha.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSistAdmi"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSistAdmi() + " :: "+ dtAmpliacionFechaBk.getIdSistAdmi());
								}
							cambios = true;
							dtAmpliacionFecha.setIdSistAdmi(dtAmpliacionFechaBk.getIdSistAdmi());
						}
					} else if (dtAmpliacionFechaBk.getIdSistAdmi() == null
							&& dtAmpliacionFecha.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSistAdmi"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSistAdmi() + " :: "+ dtAmpliacionFechaBk.getIdSistAdmi());
								}
							cambios = true;
							dtAmpliacionFecha.setIdSistAdmi(dtAmpliacionFechaBk.getIdSistAdmi());
						
					} else if (dtAmpliacionFechaBk.getIdSistAdmi() != null
							&& dtAmpliacionFecha.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdSistAdmi"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdSistAdmi() + " :: "+ dtAmpliacionFechaBk.getIdSistAdmi());
								}
							cambios = true;			
							dtAmpliacionFecha.setIdSistAdmi(dtAmpliacionFechaBk.getIdSistAdmi());
					}
				if (dtAmpliacionFechaBk.getFechaInicio() != null
							&& dtAmpliacionFecha.getFechaInicio() != null) {
						if (!dtAmpliacionFechaBk.getFechaInicio().equals(
								dtAmpliacionFecha.getFechaInicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaInicio"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaInicio() + " :: "+ dtAmpliacionFechaBk.getFechaInicio());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaInicio(dtAmpliacionFechaBk.getFechaInicio());
						}
					} else if (dtAmpliacionFechaBk.getFechaInicio() == null
							&& dtAmpliacionFecha.getFechaInicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaInicio"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaInicio() + " :: "+ dtAmpliacionFechaBk.getFechaInicio());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaInicio(dtAmpliacionFechaBk.getFechaInicio());
						
					} else if (dtAmpliacionFechaBk.getFechaInicio() != null
							&& dtAmpliacionFecha.getFechaInicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaInicio"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaInicio() + " :: "+ dtAmpliacionFechaBk.getFechaInicio());
								}
							cambios = true;			
							dtAmpliacionFecha.setFechaInicio(dtAmpliacionFechaBk.getFechaInicio());
					}
				if (dtAmpliacionFechaBk.getFechaFin() != null
							&& dtAmpliacionFecha.getFechaFin() != null) {
						if (!dtAmpliacionFechaBk.getFechaFin().equals(
								dtAmpliacionFecha.getFechaFin())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaFin"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaFin() + " :: "+ dtAmpliacionFechaBk.getFechaFin());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaFin(dtAmpliacionFechaBk.getFechaFin());
						}
					} else if (dtAmpliacionFechaBk.getFechaFin() == null
							&& dtAmpliacionFecha.getFechaFin() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaFin"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaFin() + " :: "+ dtAmpliacionFechaBk.getFechaFin());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaFin(dtAmpliacionFechaBk.getFechaFin());
						
					} else if (dtAmpliacionFechaBk.getFechaFin() != null
							&& dtAmpliacionFecha.getFechaFin() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaFin"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaFin() + " :: "+ dtAmpliacionFechaBk.getFechaFin());
								}
							cambios = true;			
							dtAmpliacionFecha.setFechaFin(dtAmpliacionFechaBk.getFechaFin());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAmpliacionFecha(DtAmpliacionFechaBk dtAmpliacionFechaBk, DtAmpliacionFecha dtAmpliacionFecha, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				                                 
                                      if (dtAmpliacionFechaBk.getEstado() != null
							&& dtAmpliacionFecha.getEstado() != null) {
						if (!dtAmpliacionFechaBk.getEstado().equals(
								dtAmpliacionFecha.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Estado"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getEstado() + " :: "+ dtAmpliacionFechaBk.getEstado());
								}
							cambios = true;
							dtAmpliacionFecha.setEstado(dtAmpliacionFechaBk.getEstado());
						}
					} else if (dtAmpliacionFechaBk.getEstado() == null
							&& dtAmpliacionFecha.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Estado"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getEstado() + " :: "+ dtAmpliacionFechaBk.getEstado());
								}
							cambios = true;
							dtAmpliacionFecha.setEstado(dtAmpliacionFechaBk.getEstado());
						
					} else if (dtAmpliacionFechaBk.getEstado() != null
							&& dtAmpliacionFecha.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Estado"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getEstado() + " :: "+ dtAmpliacionFechaBk.getEstado());
								}
							cambios = true;			
							dtAmpliacionFecha.setEstado(dtAmpliacionFechaBk.getEstado());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getIdusserCrea() != null
							&& dtAmpliacionFecha.getIdusserCrea() != null) {
						if (!dtAmpliacionFechaBk.getIdusserCrea().equals(
								dtAmpliacionFecha.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserCrea() + " :: "+ dtAmpliacionFechaBk.getIdusserCrea());
								}
							cambios = true;
							dtAmpliacionFecha.setIdusserCrea(dtAmpliacionFechaBk.getIdusserCrea());
						}
					} else if (dtAmpliacionFechaBk.getIdusserCrea() == null
							&& dtAmpliacionFecha.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserCrea() + " :: "+ dtAmpliacionFechaBk.getIdusserCrea());
								}
							cambios = true;
							dtAmpliacionFecha.setIdusserCrea(dtAmpliacionFechaBk.getIdusserCrea());
						
					} else if (dtAmpliacionFechaBk.getIdusserCrea() != null
							&& dtAmpliacionFecha.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserCrea() + " :: "+ dtAmpliacionFechaBk.getIdusserCrea());
								}
							cambios = true;			
							dtAmpliacionFecha.setIdusserCrea(dtAmpliacionFechaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getIdusserModif() != null
							&& dtAmpliacionFecha.getIdusserModif() != null) {
						if (!dtAmpliacionFechaBk.getIdusserModif().equals(
								dtAmpliacionFecha.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserModif() + " :: "+ dtAmpliacionFechaBk.getIdusserModif());
								}
							cambios = true;
							dtAmpliacionFecha.setIdusserModif(dtAmpliacionFechaBk.getIdusserModif());
						}
					} else if (dtAmpliacionFechaBk.getIdusserModif() == null
							&& dtAmpliacionFecha.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserModif() + " :: "+ dtAmpliacionFechaBk.getIdusserModif());
								}
							cambios = true;
							dtAmpliacionFecha.setIdusserModif(dtAmpliacionFechaBk.getIdusserModif());
						
					} else if (dtAmpliacionFechaBk.getIdusserModif() != null
							&& dtAmpliacionFecha.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:IdusserModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getIdusserModif() + " :: "+ dtAmpliacionFechaBk.getIdusserModif());
								}
							cambios = true;			
							dtAmpliacionFecha.setIdusserModif(dtAmpliacionFechaBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getFechaCrea() != null
							&& dtAmpliacionFecha.getFechaCrea() != null) {
						if (!dtAmpliacionFechaBk.getFechaCrea().equals(
								dtAmpliacionFecha.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaCrea() + " :: "+ dtAmpliacionFechaBk.getFechaCrea());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaCrea(dtAmpliacionFechaBk.getFechaCrea());
						}
					} else if (dtAmpliacionFechaBk.getFechaCrea() == null
							&& dtAmpliacionFecha.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaCrea() + " :: "+ dtAmpliacionFechaBk.getFechaCrea());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaCrea(dtAmpliacionFechaBk.getFechaCrea());
						
					} else if (dtAmpliacionFechaBk.getFechaCrea() != null
							&& dtAmpliacionFecha.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaCrea"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaCrea() + " :: "+ dtAmpliacionFechaBk.getFechaCrea());
								}
							cambios = true;			
							dtAmpliacionFecha.setFechaCrea(dtAmpliacionFechaBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getFechaModif() != null
							&& dtAmpliacionFecha.getFechaModif() != null) {
						if (!dtAmpliacionFechaBk.getFechaModif().equals(
								dtAmpliacionFecha.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaModif() + " :: "+ dtAmpliacionFechaBk.getFechaModif());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaModif(dtAmpliacionFechaBk.getFechaModif());
						}
					} else if (dtAmpliacionFechaBk.getFechaModif() == null
							&& dtAmpliacionFecha.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaModif() + " :: "+ dtAmpliacionFechaBk.getFechaModif());
								}
							cambios = true;
							dtAmpliacionFecha.setFechaModif(dtAmpliacionFechaBk.getFechaModif());
						
					} else if (dtAmpliacionFechaBk.getFechaModif() != null
							&& dtAmpliacionFecha.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:FechaModif"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getFechaModif() + " :: "+ dtAmpliacionFechaBk.getFechaModif());
								}
							cambios = true;			
							dtAmpliacionFecha.setFechaModif(dtAmpliacionFechaBk.getFechaModif());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getRtmaddress() != null
							&& dtAmpliacionFecha.getRtmaddress() != null) {
						if (!dtAmpliacionFechaBk.getRtmaddress().equals(
								dtAmpliacionFecha.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddress"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddress() + " :: "+ dtAmpliacionFechaBk.getRtmaddress());
								}
							cambios = true;
							dtAmpliacionFecha.setRtmaddress(dtAmpliacionFechaBk.getRtmaddress());
						}
					} else if (dtAmpliacionFechaBk.getRtmaddress() == null
							&& dtAmpliacionFecha.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddress"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddress() + " :: "+ dtAmpliacionFechaBk.getRtmaddress());
								}
							cambios = true;
							dtAmpliacionFecha.setRtmaddress(dtAmpliacionFechaBk.getRtmaddress());
						
					} else if (dtAmpliacionFechaBk.getRtmaddress() != null
							&& dtAmpliacionFecha.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddress"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddress() + " :: "+ dtAmpliacionFechaBk.getRtmaddress());
								}
							cambios = true;			
							dtAmpliacionFecha.setRtmaddress(dtAmpliacionFechaBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAmpliacionFechaBk.getRtmaddressrst() != null
							&& dtAmpliacionFecha.getRtmaddressrst() != null) {
						if (!dtAmpliacionFechaBk.getRtmaddressrst().equals(
								dtAmpliacionFecha.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddressrst"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddressrst() + " :: "+ dtAmpliacionFechaBk.getRtmaddressrst());
								}
							cambios = true;
							dtAmpliacionFecha.setRtmaddressrst(dtAmpliacionFechaBk.getRtmaddressrst());
						}
					} else if (dtAmpliacionFechaBk.getRtmaddressrst() == null
							&& dtAmpliacionFecha.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddressrst"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddressrst() + " :: "+ dtAmpliacionFechaBk.getRtmaddressrst());
								}
							cambios = true;
							dtAmpliacionFecha.setRtmaddressrst(dtAmpliacionFechaBk.getRtmaddressrst());
						
					} else if (dtAmpliacionFechaBk.getRtmaddressrst() != null
							&& dtAmpliacionFecha.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAmpliacionFecha:Rtmaddressrst"+" :: "+dtAmpliacionFechaBk.getIdAutorizacion().toString()+" :: "+ dtAmpliacionFecha.getRtmaddressrst() + " :: "+ dtAmpliacionFechaBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAmpliacionFecha.setRtmaddressrst(dtAmpliacionFechaBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}