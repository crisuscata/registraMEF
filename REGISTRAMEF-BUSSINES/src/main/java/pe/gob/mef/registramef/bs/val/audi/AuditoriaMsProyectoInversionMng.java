package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsProyectoInversion;
import pe.gob.mef.registramef.bs.transfer.bk.MsProyectoInversionBk;

/**
 * MS_PROYECTO_INVERSION SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DATOS DE PROYECTOS DE INVERSIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsProyectoInversionMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsProyectoInversionMng.class.getName());
	
	public static boolean auditarCambiosMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, MsProyectoInversion msProyectoInversion, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msProyectoInversionBk.getCodigo() != null
						&& msProyectoInversion.getCodigo() != null) {
					if (!msProyectoInversionBk.getCodigo().equals(
						msProyectoInversion.getCodigo())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Codigo"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getCodigo() + " :: "+ msProyectoInversionBk.getCodigo());								
						}
						cambios = true;
						msProyectoInversion.setCodigo(msProyectoInversionBk.getCodigo());
					}
				} else if (msProyectoInversionBk.getCodigo() == null
						&& msProyectoInversion.getCodigo() != null) {
					if (msProyectoInversion.getCodigo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Codigo"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getCodigo() + " :: "+ msProyectoInversionBk.getCodigo());
						}
						cambios = true;
						msProyectoInversion.setCodigo(msProyectoInversionBk.getCodigo());
					}
				} else if (msProyectoInversionBk.getCodigo() != null
						&& msProyectoInversion.getCodigo() == null) {
					if (msProyectoInversionBk.getCodigo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Codigo"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getCodigo() + " :: "+ msProyectoInversionBk.getCodigo());
						}
						cambios = true;
						msProyectoInversion.setCodigo(msProyectoInversionBk.getCodigo());
					}
				}
				if (msProyectoInversionBk.getNombre() != null
							&& msProyectoInversion.getNombre() != null) {
						if (!msProyectoInversionBk.getNombre().equals(
								msProyectoInversion.getNombre())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Nombre"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getNombre() + " :: "+ msProyectoInversionBk.getNombre());
								}
							cambios = true;
							msProyectoInversion.setNombre(msProyectoInversionBk.getNombre());
						}
					} else if (msProyectoInversionBk.getNombre() == null
							&& msProyectoInversion.getNombre() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Nombre"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getNombre() + " :: "+ msProyectoInversionBk.getNombre());
								}
							cambios = true;
							msProyectoInversion.setNombre(msProyectoInversionBk.getNombre());
						
					} else if (msProyectoInversionBk.getNombre() != null
							&& msProyectoInversion.getNombre() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Nombre"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getNombre() + " :: "+ msProyectoInversionBk.getNombre());
								}
							cambios = true;			
							msProyectoInversion.setNombre(msProyectoInversionBk.getNombre());
					}
				if (msProyectoInversionBk.getIdSede() != null
							&& msProyectoInversion.getIdSede() != null) {
						if (!msProyectoInversionBk.getIdSede().equals(
								msProyectoInversion.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdSede"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdSede() + " :: "+ msProyectoInversionBk.getIdSede());
								}
							cambios = true;
							msProyectoInversion.setIdSede(msProyectoInversionBk.getIdSede());
						}
					} else if (msProyectoInversionBk.getIdSede() == null
							&& msProyectoInversion.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdSede"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdSede() + " :: "+ msProyectoInversionBk.getIdSede());
								}
							cambios = true;
							msProyectoInversion.setIdSede(msProyectoInversionBk.getIdSede());
						
					} else if (msProyectoInversionBk.getIdSede() != null
							&& msProyectoInversion.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdSede"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdSede() + " :: "+ msProyectoInversionBk.getIdSede());
								}
							cambios = true;			
							msProyectoInversion.setIdSede(msProyectoInversionBk.getIdSede());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsProyectoInversion(MsProyectoInversionBk msProyectoInversionBk, MsProyectoInversion msProyectoInversion, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (msProyectoInversionBk.getEstado() != null
							&& msProyectoInversion.getEstado() != null) {
						if (!msProyectoInversionBk.getEstado().equals(
								msProyectoInversion.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Estado"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getEstado() + " :: "+ msProyectoInversionBk.getEstado());
								}
							cambios = true;
							msProyectoInversion.setEstado(msProyectoInversionBk.getEstado());
						}
					} else if (msProyectoInversionBk.getEstado() == null
							&& msProyectoInversion.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Estado"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getEstado() + " :: "+ msProyectoInversionBk.getEstado());
								}
							cambios = true;
							msProyectoInversion.setEstado(msProyectoInversionBk.getEstado());
						
					} else if (msProyectoInversionBk.getEstado() != null
							&& msProyectoInversion.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Estado"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getEstado() + " :: "+ msProyectoInversionBk.getEstado());
								}
							cambios = true;			
							msProyectoInversion.setEstado(msProyectoInversionBk.getEstado());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getIdusserCrea() != null
							&& msProyectoInversion.getIdusserCrea() != null) {
						if (!msProyectoInversionBk.getIdusserCrea().equals(
								msProyectoInversion.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserCrea() + " :: "+ msProyectoInversionBk.getIdusserCrea());
								}
							cambios = true;
							msProyectoInversion.setIdusserCrea(msProyectoInversionBk.getIdusserCrea());
						}
					} else if (msProyectoInversionBk.getIdusserCrea() == null
							&& msProyectoInversion.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserCrea() + " :: "+ msProyectoInversionBk.getIdusserCrea());
								}
							cambios = true;
							msProyectoInversion.setIdusserCrea(msProyectoInversionBk.getIdusserCrea());
						
					} else if (msProyectoInversionBk.getIdusserCrea() != null
							&& msProyectoInversion.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserCrea() + " :: "+ msProyectoInversionBk.getIdusserCrea());
								}
							cambios = true;			
							msProyectoInversion.setIdusserCrea(msProyectoInversionBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getIdusserModif() != null
							&& msProyectoInversion.getIdusserModif() != null) {
						if (!msProyectoInversionBk.getIdusserModif().equals(
								msProyectoInversion.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserModif() + " :: "+ msProyectoInversionBk.getIdusserModif());
								}
							cambios = true;
							msProyectoInversion.setIdusserModif(msProyectoInversionBk.getIdusserModif());
						}
					} else if (msProyectoInversionBk.getIdusserModif() == null
							&& msProyectoInversion.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserModif() + " :: "+ msProyectoInversionBk.getIdusserModif());
								}
							cambios = true;
							msProyectoInversion.setIdusserModif(msProyectoInversionBk.getIdusserModif());
						
					} else if (msProyectoInversionBk.getIdusserModif() != null
							&& msProyectoInversion.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:IdusserModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getIdusserModif() + " :: "+ msProyectoInversionBk.getIdusserModif());
								}
							cambios = true;			
							msProyectoInversion.setIdusserModif(msProyectoInversionBk.getIdusserModif());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getFechaCrea() != null
							&& msProyectoInversion.getFechaCrea() != null) {
						if (!msProyectoInversionBk.getFechaCrea().equals(
								msProyectoInversion.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaCrea() + " :: "+ msProyectoInversionBk.getFechaCrea());
								}
							cambios = true;
							msProyectoInversion.setFechaCrea(msProyectoInversionBk.getFechaCrea());
						}
					} else if (msProyectoInversionBk.getFechaCrea() == null
							&& msProyectoInversion.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaCrea() + " :: "+ msProyectoInversionBk.getFechaCrea());
								}
							cambios = true;
							msProyectoInversion.setFechaCrea(msProyectoInversionBk.getFechaCrea());
						
					} else if (msProyectoInversionBk.getFechaCrea() != null
							&& msProyectoInversion.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaCrea"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaCrea() + " :: "+ msProyectoInversionBk.getFechaCrea());
								}
							cambios = true;			
							msProyectoInversion.setFechaCrea(msProyectoInversionBk.getFechaCrea());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getFechaModif() != null
							&& msProyectoInversion.getFechaModif() != null) {
						if (!msProyectoInversionBk.getFechaModif().equals(
								msProyectoInversion.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaModif() + " :: "+ msProyectoInversionBk.getFechaModif());
								}
							cambios = true;
							msProyectoInversion.setFechaModif(msProyectoInversionBk.getFechaModif());
						}
					} else if (msProyectoInversionBk.getFechaModif() == null
							&& msProyectoInversion.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaModif() + " :: "+ msProyectoInversionBk.getFechaModif());
								}
							cambios = true;
							msProyectoInversion.setFechaModif(msProyectoInversionBk.getFechaModif());
						
					} else if (msProyectoInversionBk.getFechaModif() != null
							&& msProyectoInversion.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:FechaModif"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getFechaModif() + " :: "+ msProyectoInversionBk.getFechaModif());
								}
							cambios = true;			
							msProyectoInversion.setFechaModif(msProyectoInversionBk.getFechaModif());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getRtmaddress() != null
							&& msProyectoInversion.getRtmaddress() != null) {
						if (!msProyectoInversionBk.getRtmaddress().equals(
								msProyectoInversion.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddress"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddress() + " :: "+ msProyectoInversionBk.getRtmaddress());
								}
							cambios = true;
							msProyectoInversion.setRtmaddress(msProyectoInversionBk.getRtmaddress());
						}
					} else if (msProyectoInversionBk.getRtmaddress() == null
							&& msProyectoInversion.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddress"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddress() + " :: "+ msProyectoInversionBk.getRtmaddress());
								}
							cambios = true;
							msProyectoInversion.setRtmaddress(msProyectoInversionBk.getRtmaddress());
						
					} else if (msProyectoInversionBk.getRtmaddress() != null
							&& msProyectoInversion.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddress"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddress() + " :: "+ msProyectoInversionBk.getRtmaddress());
								}
							cambios = true;			
							msProyectoInversion.setRtmaddress(msProyectoInversionBk.getRtmaddress());
					}
                                
				                                 
                                      if (msProyectoInversionBk.getRtmaddressrst() != null
							&& msProyectoInversion.getRtmaddressrst() != null) {
						if (!msProyectoInversionBk.getRtmaddressrst().equals(
								msProyectoInversion.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddressrst"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddressrst() + " :: "+ msProyectoInversionBk.getRtmaddressrst());
								}
							cambios = true;
							msProyectoInversion.setRtmaddressrst(msProyectoInversionBk.getRtmaddressrst());
						}
					} else if (msProyectoInversionBk.getRtmaddressrst() == null
							&& msProyectoInversion.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddressrst"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddressrst() + " :: "+ msProyectoInversionBk.getRtmaddressrst());
								}
							cambios = true;
							msProyectoInversion.setRtmaddressrst(msProyectoInversionBk.getRtmaddressrst());
						
					} else if (msProyectoInversionBk.getRtmaddressrst() != null
							&& msProyectoInversion.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msProyectoInversion:Rtmaddressrst"+" :: "+msProyectoInversionBk.getIdProyecto().toString()+" :: "+ msProyectoInversion.getRtmaddressrst() + " :: "+ msProyectoInversionBk.getRtmaddressrst());
								}
							cambios = true;			
							msProyectoInversion.setRtmaddressrst(msProyectoInversionBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}