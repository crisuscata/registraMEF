package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsTema;
import pe.gob.mef.registramef.bs.transfer.bk.MsTemaBk;

/**
 * MS_TEMA SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS TEMAS REGISTRADOS EN EL SISTEMA "TEMAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsTemaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsTemaMng.class.getName());
	
	public static boolean auditarCambiosMsTema(MsTemaBk msTemaBk, MsTema msTema, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msTemaBk.getDescripcion() != null
						&& msTema.getDescripcion() != null) {
					if (!msTemaBk.getDescripcion().equals(
						msTema.getDescripcion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Descripcion"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getDescripcion() + " :: "+ msTemaBk.getDescripcion());								
						}
						cambios = true;
						msTema.setDescripcion(msTemaBk.getDescripcion());
					}
				} else if (msTemaBk.getDescripcion() == null
						&& msTema.getDescripcion() != null) {
					if (msTema.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Descripcion"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getDescripcion() + " :: "+ msTemaBk.getDescripcion());
						}
						cambios = true;
						msTema.setDescripcion(msTemaBk.getDescripcion());
					}
				} else if (msTemaBk.getDescripcion() != null
						&& msTema.getDescripcion() == null) {
					if (msTemaBk.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Descripcion"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getDescripcion() + " :: "+ msTemaBk.getDescripcion());
						}
						cambios = true;
						msTema.setDescripcion(msTemaBk.getDescripcion());
					}
				}
				if (msTemaBk.getIdSistAdmi() != null
							&& msTema.getIdSistAdmi() != null) {
						if (!msTemaBk.getIdSistAdmi().equals(
								msTema.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdSistAdmi"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdSistAdmi() + " :: "+ msTemaBk.getIdSistAdmi());
								}
							cambios = true;
							msTema.setIdSistAdmi(msTemaBk.getIdSistAdmi());
						}
					} else if (msTemaBk.getIdSistAdmi() == null
							&& msTema.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdSistAdmi"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdSistAdmi() + " :: "+ msTemaBk.getIdSistAdmi());
								}
							cambios = true;
							msTema.setIdSistAdmi(msTemaBk.getIdSistAdmi());
						
					} else if (msTemaBk.getIdSistAdmi() != null
							&& msTema.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdSistAdmi"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdSistAdmi() + " :: "+ msTemaBk.getIdSistAdmi());
								}
							cambios = true;			
							msTema.setIdSistAdmi(msTemaBk.getIdSistAdmi());
					}
				if (msTemaBk.getTipoServicio() != null
							&& msTema.getTipoServicio() != null) {
						if (!msTemaBk.getTipoServicio().equals(
								msTema.getTipoServicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:TipoServicio"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getTipoServicio() + " :: "+ msTemaBk.getTipoServicio());
								}
							cambios = true;
							msTema.setTipoServicio(msTemaBk.getTipoServicio());
						}
					} else if (msTemaBk.getTipoServicio() == null
							&& msTema.getTipoServicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:TipoServicio"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getTipoServicio() + " :: "+ msTemaBk.getTipoServicio());
								}
							cambios = true;
							msTema.setTipoServicio(msTemaBk.getTipoServicio());
						
					} else if (msTemaBk.getTipoServicio() != null
							&& msTema.getTipoServicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:TipoServicio"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getTipoServicio() + " :: "+ msTemaBk.getTipoServicio());
								}
							cambios = true;			
							msTema.setTipoServicio(msTemaBk.getTipoServicio());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsTema(MsTemaBk msTemaBk, MsTema msTema, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (msTemaBk.getIdusserCrea() != null
							&& msTema.getIdusserCrea() != null) {
						if (!msTemaBk.getIdusserCrea().equals(
								msTema.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserCrea() + " :: "+ msTemaBk.getIdusserCrea());
								}
							cambios = true;
							msTema.setIdusserCrea(msTemaBk.getIdusserCrea());
						}
					} else if (msTemaBk.getIdusserCrea() == null
							&& msTema.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserCrea() + " :: "+ msTemaBk.getIdusserCrea());
								}
							cambios = true;
							msTema.setIdusserCrea(msTemaBk.getIdusserCrea());
						
					} else if (msTemaBk.getIdusserCrea() != null
							&& msTema.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserCrea() + " :: "+ msTemaBk.getIdusserCrea());
								}
							cambios = true;			
							msTema.setIdusserCrea(msTemaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msTemaBk.getIdusserModif() != null
							&& msTema.getIdusserModif() != null) {
						if (!msTemaBk.getIdusserModif().equals(
								msTema.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserModif() + " :: "+ msTemaBk.getIdusserModif());
								}
							cambios = true;
							msTema.setIdusserModif(msTemaBk.getIdusserModif());
						}
					} else if (msTemaBk.getIdusserModif() == null
							&& msTema.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserModif() + " :: "+ msTemaBk.getIdusserModif());
								}
							cambios = true;
							msTema.setIdusserModif(msTemaBk.getIdusserModif());
						
					} else if (msTemaBk.getIdusserModif() != null
							&& msTema.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:IdusserModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getIdusserModif() + " :: "+ msTemaBk.getIdusserModif());
								}
							cambios = true;			
							msTema.setIdusserModif(msTemaBk.getIdusserModif());
					}
                                
				                                 
                                      if (msTemaBk.getFechaCrea() != null
							&& msTema.getFechaCrea() != null) {
						if (!msTemaBk.getFechaCrea().equals(
								msTema.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaCrea() + " :: "+ msTemaBk.getFechaCrea());
								}
							cambios = true;
							msTema.setFechaCrea(msTemaBk.getFechaCrea());
						}
					} else if (msTemaBk.getFechaCrea() == null
							&& msTema.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaCrea() + " :: "+ msTemaBk.getFechaCrea());
								}
							cambios = true;
							msTema.setFechaCrea(msTemaBk.getFechaCrea());
						
					} else if (msTemaBk.getFechaCrea() != null
							&& msTema.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaCrea"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaCrea() + " :: "+ msTemaBk.getFechaCrea());
								}
							cambios = true;			
							msTema.setFechaCrea(msTemaBk.getFechaCrea());
					}
                                
				                                 
                                      if (msTemaBk.getFechaModif() != null
							&& msTema.getFechaModif() != null) {
						if (!msTemaBk.getFechaModif().equals(
								msTema.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaModif() + " :: "+ msTemaBk.getFechaModif());
								}
							cambios = true;
							msTema.setFechaModif(msTemaBk.getFechaModif());
						}
					} else if (msTemaBk.getFechaModif() == null
							&& msTema.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaModif() + " :: "+ msTemaBk.getFechaModif());
								}
							cambios = true;
							msTema.setFechaModif(msTemaBk.getFechaModif());
						
					} else if (msTemaBk.getFechaModif() != null
							&& msTema.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:FechaModif"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getFechaModif() + " :: "+ msTemaBk.getFechaModif());
								}
							cambios = true;			
							msTema.setFechaModif(msTemaBk.getFechaModif());
					}
                                
				
				                                 
                                      if (msTemaBk.getEstado() != null
							&& msTema.getEstado() != null) {
						if (!msTemaBk.getEstado().equals(
								msTema.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Estado"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getEstado() + " :: "+ msTemaBk.getEstado());
								}
							cambios = true;
							msTema.setEstado(msTemaBk.getEstado());
						}
					} else if (msTemaBk.getEstado() == null
							&& msTema.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Estado"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getEstado() + " :: "+ msTemaBk.getEstado());
								}
							cambios = true;
							msTema.setEstado(msTemaBk.getEstado());
						
					} else if (msTemaBk.getEstado() != null
							&& msTema.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Estado"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getEstado() + " :: "+ msTemaBk.getEstado());
								}
							cambios = true;			
							msTema.setEstado(msTemaBk.getEstado());
					}
                                
				                                 
                                      if (msTemaBk.getRtmaddress() != null
							&& msTema.getRtmaddress() != null) {
						if (!msTemaBk.getRtmaddress().equals(
								msTema.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddress"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddress() + " :: "+ msTemaBk.getRtmaddress());
								}
							cambios = true;
							msTema.setRtmaddress(msTemaBk.getRtmaddress());
						}
					} else if (msTemaBk.getRtmaddress() == null
							&& msTema.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddress"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddress() + " :: "+ msTemaBk.getRtmaddress());
								}
							cambios = true;
							msTema.setRtmaddress(msTemaBk.getRtmaddress());
						
					} else if (msTemaBk.getRtmaddress() != null
							&& msTema.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddress"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddress() + " :: "+ msTemaBk.getRtmaddress());
								}
							cambios = true;			
							msTema.setRtmaddress(msTemaBk.getRtmaddress());
					}
                                
				                                 
                                      if (msTemaBk.getRtmaddressrst() != null
							&& msTema.getRtmaddressrst() != null) {
						if (!msTemaBk.getRtmaddressrst().equals(
								msTema.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddressrst"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddressrst() + " :: "+ msTemaBk.getRtmaddressrst());
								}
							cambios = true;
							msTema.setRtmaddressrst(msTemaBk.getRtmaddressrst());
						}
					} else if (msTemaBk.getRtmaddressrst() == null
							&& msTema.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddressrst"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddressrst() + " :: "+ msTemaBk.getRtmaddressrst());
								}
							cambios = true;
							msTema.setRtmaddressrst(msTemaBk.getRtmaddressrst());
						
					} else if (msTemaBk.getRtmaddressrst() != null
							&& msTema.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msTema:Rtmaddressrst"+" :: "+msTemaBk.getIdTema().toString()+" :: "+ msTema.getRtmaddressrst() + " :: "+ msTemaBk.getRtmaddressrst());
								}
							cambios = true;			
							msTema.setRtmaddressrst(msTemaBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}