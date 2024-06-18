package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsSubtema;
import pe.gob.mef.registramef.bs.transfer.bk.MsSubtemaBk;

/**
 * MS_SUBTEMA SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS SUBTEMAS REGISTRADOS EN EL SISTEMA "SUBTEMAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsSubtemaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsSubtemaMng.class.getName());
	
	public static boolean auditarCambiosMsSubtema(MsSubtemaBk msSubtemaBk, MsSubtema msSubtema, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msSubtemaBk.getDescripcion() != null
							&& msSubtema.getDescripcion() != null) {
						if (!msSubtemaBk.getDescripcion().equals(
								msSubtema.getDescripcion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Descripcion"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getDescripcion() + " :: "+ msSubtemaBk.getDescripcion());
								}
							cambios = true;
							msSubtema.setDescripcion(msSubtemaBk.getDescripcion());
						}
					} else if (msSubtemaBk.getDescripcion() == null
							&& msSubtema.getDescripcion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Descripcion"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getDescripcion() + " :: "+ msSubtemaBk.getDescripcion());
								}
							cambios = true;
							msSubtema.setDescripcion(msSubtemaBk.getDescripcion());
						
					} else if (msSubtemaBk.getDescripcion() != null
							&& msSubtema.getDescripcion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Descripcion"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getDescripcion() + " :: "+ msSubtemaBk.getDescripcion());
								}
							cambios = true;			
							msSubtema.setDescripcion(msSubtemaBk.getDescripcion());
					}
				if (msSubtemaBk.getIdTema() != null
							&& msSubtema.getIdTema() != null) {
						if (!msSubtemaBk.getIdTema().equals(
								msSubtema.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdTema"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdTema() + " :: "+ msSubtemaBk.getIdTema());
								}
							cambios = true;
							msSubtema.setIdTema(msSubtemaBk.getIdTema());
						}
					} else if (msSubtemaBk.getIdTema() == null
							&& msSubtema.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdTema"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdTema() + " :: "+ msSubtemaBk.getIdTema());
								}
							cambios = true;
							msSubtema.setIdTema(msSubtemaBk.getIdTema());
						
					} else if (msSubtemaBk.getIdTema() != null
							&& msSubtema.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdTema"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdTema() + " :: "+ msSubtemaBk.getIdTema());
								}
							cambios = true;			
							msSubtema.setIdTema(msSubtemaBk.getIdTema());
					}
				if (msSubtemaBk.getIdIndicador() != null
							&& msSubtema.getIdIndicador() != null) {
						if (!msSubtemaBk.getIdIndicador().equals(
								msSubtema.getIdIndicador())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdIndicador"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdIndicador() + " :: "+ msSubtemaBk.getIdIndicador());
								}
							cambios = true;
							msSubtema.setIdIndicador(msSubtemaBk.getIdIndicador());
						}
					} else if (msSubtemaBk.getIdIndicador() == null
							&& msSubtema.getIdIndicador() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdIndicador"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdIndicador() + " :: "+ msSubtemaBk.getIdIndicador());
								}
							cambios = true;
							msSubtema.setIdIndicador(msSubtemaBk.getIdIndicador());
						
					} else if (msSubtemaBk.getIdIndicador() != null
							&& msSubtema.getIdIndicador() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdIndicador"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdIndicador() + " :: "+ msSubtemaBk.getIdIndicador());
								}
							cambios = true;			
							msSubtema.setIdIndicador(msSubtemaBk.getIdIndicador());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsSubtema(MsSubtemaBk msSubtemaBk, MsSubtema msSubtema, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (msSubtemaBk.getIdusserCrea() != null
							&& msSubtema.getIdusserCrea() != null) {
						if (!msSubtemaBk.getIdusserCrea().equals(
								msSubtema.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserCrea() + " :: "+ msSubtemaBk.getIdusserCrea());
								}
							cambios = true;
							msSubtema.setIdusserCrea(msSubtemaBk.getIdusserCrea());
						}
					} else if (msSubtemaBk.getIdusserCrea() == null
							&& msSubtema.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserCrea() + " :: "+ msSubtemaBk.getIdusserCrea());
								}
							cambios = true;
							msSubtema.setIdusserCrea(msSubtemaBk.getIdusserCrea());
						
					} else if (msSubtemaBk.getIdusserCrea() != null
							&& msSubtema.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserCrea() + " :: "+ msSubtemaBk.getIdusserCrea());
								}
							cambios = true;			
							msSubtema.setIdusserCrea(msSubtemaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msSubtemaBk.getIdusserModif() != null
							&& msSubtema.getIdusserModif() != null) {
						if (!msSubtemaBk.getIdusserModif().equals(
								msSubtema.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserModif() + " :: "+ msSubtemaBk.getIdusserModif());
								}
							cambios = true;
							msSubtema.setIdusserModif(msSubtemaBk.getIdusserModif());
						}
					} else if (msSubtemaBk.getIdusserModif() == null
							&& msSubtema.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserModif() + " :: "+ msSubtemaBk.getIdusserModif());
								}
							cambios = true;
							msSubtema.setIdusserModif(msSubtemaBk.getIdusserModif());
						
					} else if (msSubtemaBk.getIdusserModif() != null
							&& msSubtema.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:IdusserModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getIdusserModif() + " :: "+ msSubtemaBk.getIdusserModif());
								}
							cambios = true;			
							msSubtema.setIdusserModif(msSubtemaBk.getIdusserModif());
					}
                                
				                                 
                                      if (msSubtemaBk.getFechaCrea() != null
							&& msSubtema.getFechaCrea() != null) {
						if (!msSubtemaBk.getFechaCrea().equals(
								msSubtema.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaCrea() + " :: "+ msSubtemaBk.getFechaCrea());
								}
							cambios = true;
							msSubtema.setFechaCrea(msSubtemaBk.getFechaCrea());
						}
					} else if (msSubtemaBk.getFechaCrea() == null
							&& msSubtema.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaCrea() + " :: "+ msSubtemaBk.getFechaCrea());
								}
							cambios = true;
							msSubtema.setFechaCrea(msSubtemaBk.getFechaCrea());
						
					} else if (msSubtemaBk.getFechaCrea() != null
							&& msSubtema.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaCrea"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaCrea() + " :: "+ msSubtemaBk.getFechaCrea());
								}
							cambios = true;			
							msSubtema.setFechaCrea(msSubtemaBk.getFechaCrea());
					}
                                
				                                 
                                      if (msSubtemaBk.getFechaModif() != null
							&& msSubtema.getFechaModif() != null) {
						if (!msSubtemaBk.getFechaModif().equals(
								msSubtema.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaModif() + " :: "+ msSubtemaBk.getFechaModif());
								}
							cambios = true;
							msSubtema.setFechaModif(msSubtemaBk.getFechaModif());
						}
					} else if (msSubtemaBk.getFechaModif() == null
							&& msSubtema.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaModif() + " :: "+ msSubtemaBk.getFechaModif());
								}
							cambios = true;
							msSubtema.setFechaModif(msSubtemaBk.getFechaModif());
						
					} else if (msSubtemaBk.getFechaModif() != null
							&& msSubtema.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:FechaModif"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getFechaModif() + " :: "+ msSubtemaBk.getFechaModif());
								}
							cambios = true;			
							msSubtema.setFechaModif(msSubtemaBk.getFechaModif());
					}
                                
				
				                                 
                                      if (msSubtemaBk.getEstado() != null
							&& msSubtema.getEstado() != null) {
						if (!msSubtemaBk.getEstado().equals(
								msSubtema.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Estado"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getEstado() + " :: "+ msSubtemaBk.getEstado());
								}
							cambios = true;
							msSubtema.setEstado(msSubtemaBk.getEstado());
						}
					} else if (msSubtemaBk.getEstado() == null
							&& msSubtema.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Estado"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getEstado() + " :: "+ msSubtemaBk.getEstado());
								}
							cambios = true;
							msSubtema.setEstado(msSubtemaBk.getEstado());
						
					} else if (msSubtemaBk.getEstado() != null
							&& msSubtema.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Estado"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getEstado() + " :: "+ msSubtemaBk.getEstado());
								}
							cambios = true;			
							msSubtema.setEstado(msSubtemaBk.getEstado());
					}
                                
				
				                                 
                                      if (msSubtemaBk.getRtmaddress() != null
							&& msSubtema.getRtmaddress() != null) {
						if (!msSubtemaBk.getRtmaddress().equals(
								msSubtema.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddress"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddress() + " :: "+ msSubtemaBk.getRtmaddress());
								}
							cambios = true;
							msSubtema.setRtmaddress(msSubtemaBk.getRtmaddress());
						}
					} else if (msSubtemaBk.getRtmaddress() == null
							&& msSubtema.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddress"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddress() + " :: "+ msSubtemaBk.getRtmaddress());
								}
							cambios = true;
							msSubtema.setRtmaddress(msSubtemaBk.getRtmaddress());
						
					} else if (msSubtemaBk.getRtmaddress() != null
							&& msSubtema.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddress"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddress() + " :: "+ msSubtemaBk.getRtmaddress());
								}
							cambios = true;			
							msSubtema.setRtmaddress(msSubtemaBk.getRtmaddress());
					}
                                
				                                 
                                      if (msSubtemaBk.getRtmaddressrst() != null
							&& msSubtema.getRtmaddressrst() != null) {
						if (!msSubtemaBk.getRtmaddressrst().equals(
								msSubtema.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddressrst"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddressrst() + " :: "+ msSubtemaBk.getRtmaddressrst());
								}
							cambios = true;
							msSubtema.setRtmaddressrst(msSubtemaBk.getRtmaddressrst());
						}
					} else if (msSubtemaBk.getRtmaddressrst() == null
							&& msSubtema.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddressrst"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddressrst() + " :: "+ msSubtemaBk.getRtmaddressrst());
								}
							cambios = true;
							msSubtema.setRtmaddressrst(msSubtemaBk.getRtmaddressrst());
						
					} else if (msSubtemaBk.getRtmaddressrst() != null
							&& msSubtema.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSubtema:Rtmaddressrst"+" :: "+msSubtemaBk.getIdSubtema().toString()+" :: "+ msSubtema.getRtmaddressrst() + " :: "+ msSubtemaBk.getRtmaddressrst());
								}
							cambios = true;			
							msSubtema.setRtmaddressrst(msSubtemaBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}