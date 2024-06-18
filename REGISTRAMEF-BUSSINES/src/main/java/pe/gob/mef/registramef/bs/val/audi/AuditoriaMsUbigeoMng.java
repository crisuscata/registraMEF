package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsUbigeo;
import pe.gob.mef.registramef.bs.transfer.bk.MsUbigeoBk;

/**
 * MS_UBIGEO SERVICIO AUDITORIA Y CAMBIO: ALMACENA EL UBIGEO(DEPARTAMENTO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsUbigeoMng implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7158049393209955891L;
	public static final Logger log = Logger.getLogger(AuditoriaMsUbigeoMng.class.getName());
	
	public static boolean auditarCambiosMsUbigeo(MsUbigeoBk msUbigeoBk, MsUbigeo msUbigeo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msUbigeoBk.getDescripcion() != null
						&& msUbigeo.getDescripcion() != null) {
					if (!msUbigeoBk.getDescripcion().equals(
						msUbigeo.getDescripcion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Descripcion"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getDescripcion() + " :: "+ msUbigeoBk.getDescripcion());								
						}
						cambios = true;
						msUbigeo.setDescripcion(msUbigeoBk.getDescripcion());
					}
				} else if (msUbigeoBk.getDescripcion() == null
						&& msUbigeo.getDescripcion() != null) {
					if (msUbigeo.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Descripcion"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getDescripcion() + " :: "+ msUbigeoBk.getDescripcion());
						}
						cambios = true;
						msUbigeo.setDescripcion(msUbigeoBk.getDescripcion());
					}
				} else if (msUbigeoBk.getDescripcion() != null
						&& msUbigeo.getDescripcion() == null) {
					if (msUbigeoBk.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Descripcion"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getDescripcion() + " :: "+ msUbigeoBk.getDescripcion());
						}
						cambios = true;
						msUbigeo.setDescripcion(msUbigeoBk.getDescripcion());
					}
				}
//				if (msUbigeoBk.getCodDpto() != null
//							&& msUbigeo.getCodDpto() != null) {
//						if (!msUbigeoBk.getCodDpto().equals(
//								msUbigeo.getCodDpto())) {						
//								if(nivel>0){
//								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodDpto"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodDpto() + " :: "+ msUbigeoBk.getCodDpto());
//								}
//							cambios = true;
//							msUbigeo.setCodDpto(msUbigeoBk.getCodDpto());
//						}
//					} else if (msUbigeoBk.getCodDpto() == null
//							&& msUbigeo.getCodDpto() != null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodDpto"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodDpto() + " :: "+ msUbigeoBk.getCodDpto());
//								}
//							cambios = true;
//							msUbigeo.setCodDpto(msUbigeoBk.getCodDpto());
//						
//					} else if (msUbigeoBk.getCodDpto() != null
//							&& msUbigeo.getCodDpto() == null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodDpto"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodDpto() + " :: "+ msUbigeoBk.getCodDpto());
//								}
//							cambios = true;			
//							msUbigeo.setCodDpto(msUbigeoBk.getCodDpto());
//					}
//				if (msUbigeoBk.getCodProv() != null
//							&& msUbigeo.getCodProv() != null) {
//						if (!msUbigeoBk.getCodProv().equals(
//								msUbigeo.getCodProv())) {						
//								if(nivel>0){
//								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodProv"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodProv() + " :: "+ msUbigeoBk.getCodProv());
//								}
//							cambios = true;
//							msUbigeo.setCodProv(msUbigeoBk.getCodProv());
//						}
//					} else if (msUbigeoBk.getCodProv() == null
//							&& msUbigeo.getCodProv() != null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodProv"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodProv() + " :: "+ msUbigeoBk.getCodProv());
//								}
//							cambios = true;
//							msUbigeo.setCodProv(msUbigeoBk.getCodProv());
//						
//					} else if (msUbigeoBk.getCodProv() != null
//							&& msUbigeo.getCodProv() == null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:CodProv"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getCodProv() + " :: "+ msUbigeoBk.getCodProv());
//								}
//							cambios = true;			
//							msUbigeo.setCodProv(msUbigeoBk.getCodProv());
//					}
//				if (msUbigeoBk.getIdubigeo() != null
//							&& msUbigeo.getIdubigeo() != null) {
//						if (!msUbigeoBk.getIdubigeo().equals(
//								msUbigeo.getIdubigeo())) {						
//								if(nivel>0){
//								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Idubigeo"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdubigeo() + " :: "+ msUbigeoBk.getIdubigeo());
//								}
//							cambios = true;
//							msUbigeo.setIdubigeo(msUbigeoBk.getIdubigeo());
//						}
//					} else if (msUbigeoBk.getIdubigeo() == null
//							&& msUbigeo.getIdubigeo() != null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Idubigeo"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdubigeo() + " :: "+ msUbigeoBk.getIdubigeo());
//								}
//							cambios = true;
//							msUbigeo.setIdubigeo(msUbigeoBk.getIdubigeo());
//						
//					} else if (msUbigeoBk.getIdubigeo() != null
//							&& msUbigeo.getIdubigeo() == null) {						
//							if(nivel>0){
//							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Idubigeo"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdubigeo() + " :: "+ msUbigeoBk.getIdubigeo());
//								}
//							cambios = true;			
//							msUbigeo.setIdubigeo(msUbigeoBk.getIdubigeo());
//					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsUbigeo(MsUbigeoBk msUbigeoBk, MsUbigeo msUbigeo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (msUbigeoBk.getIdusserCrea() != null
							&& msUbigeo.getIdusserCrea() != null) {
						if (!msUbigeoBk.getIdusserCrea().equals(
								msUbigeo.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserCrea() + " :: "+ msUbigeoBk.getIdusserCrea());
								}
							cambios = true;
							msUbigeo.setIdusserCrea(msUbigeoBk.getIdusserCrea());
						}
					} else if (msUbigeoBk.getIdusserCrea() == null
							&& msUbigeo.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserCrea() + " :: "+ msUbigeoBk.getIdusserCrea());
								}
							cambios = true;
							msUbigeo.setIdusserCrea(msUbigeoBk.getIdusserCrea());
						
					} else if (msUbigeoBk.getIdusserCrea() != null
							&& msUbigeo.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserCrea() + " :: "+ msUbigeoBk.getIdusserCrea());
								}
							cambios = true;			
							msUbigeo.setIdusserCrea(msUbigeoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msUbigeoBk.getFechaCrea() != null
							&& msUbigeo.getFechaCrea() != null) {
						if (!msUbigeoBk.getFechaCrea().equals(
								msUbigeo.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaCrea() + " :: "+ msUbigeoBk.getFechaCrea());
								}
							cambios = true;
							msUbigeo.setFechaCrea(msUbigeoBk.getFechaCrea());
						}
					} else if (msUbigeoBk.getFechaCrea() == null
							&& msUbigeo.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaCrea() + " :: "+ msUbigeoBk.getFechaCrea());
								}
							cambios = true;
							msUbigeo.setFechaCrea(msUbigeoBk.getFechaCrea());
						
					} else if (msUbigeoBk.getFechaCrea() != null
							&& msUbigeo.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaCrea"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaCrea() + " :: "+ msUbigeoBk.getFechaCrea());
								}
							cambios = true;			
							msUbigeo.setFechaCrea(msUbigeoBk.getFechaCrea());
					}
                                
				                                 
                                      if (msUbigeoBk.getFechaModif() != null
							&& msUbigeo.getFechaModif() != null) {
						if (!msUbigeoBk.getFechaModif().equals(
								msUbigeo.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaModif() + " :: "+ msUbigeoBk.getFechaModif());
								}
							cambios = true;
							msUbigeo.setFechaModif(msUbigeoBk.getFechaModif());
						}
					} else if (msUbigeoBk.getFechaModif() == null
							&& msUbigeo.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaModif() + " :: "+ msUbigeoBk.getFechaModif());
								}
							cambios = true;
							msUbigeo.setFechaModif(msUbigeoBk.getFechaModif());
						
					} else if (msUbigeoBk.getFechaModif() != null
							&& msUbigeo.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:FechaModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getFechaModif() + " :: "+ msUbigeoBk.getFechaModif());
								}
							cambios = true;			
							msUbigeo.setFechaModif(msUbigeoBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (msUbigeoBk.getIdusserModif() != null
							&& msUbigeo.getIdusserModif() != null) {
						if (!msUbigeoBk.getIdusserModif().equals(
								msUbigeo.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserModif() + " :: "+ msUbigeoBk.getIdusserModif());
								}
							cambios = true;
							msUbigeo.setIdusserModif(msUbigeoBk.getIdusserModif());
						}
					} else if (msUbigeoBk.getIdusserModif() == null
							&& msUbigeo.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserModif() + " :: "+ msUbigeoBk.getIdusserModif());
								}
							cambios = true;
							msUbigeo.setIdusserModif(msUbigeoBk.getIdusserModif());
						
					} else if (msUbigeoBk.getIdusserModif() != null
							&& msUbigeo.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:IdusserModif"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getIdusserModif() + " :: "+ msUbigeoBk.getIdusserModif());
								}
							cambios = true;			
							msUbigeo.setIdusserModif(msUbigeoBk.getIdusserModif());
					}
                                
				                                 
                                      if (msUbigeoBk.getEstado() != null
							&& msUbigeo.getEstado() != null) {
						if (!msUbigeoBk.getEstado().equals(
								msUbigeo.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Estado"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getEstado() + " :: "+ msUbigeoBk.getEstado());
								}
							cambios = true;
							msUbigeo.setEstado(msUbigeoBk.getEstado());
						}
					} else if (msUbigeoBk.getEstado() == null
							&& msUbigeo.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Estado"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getEstado() + " :: "+ msUbigeoBk.getEstado());
								}
							cambios = true;
							msUbigeo.setEstado(msUbigeoBk.getEstado());
						
					} else if (msUbigeoBk.getEstado() != null
							&& msUbigeo.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Estado"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getEstado() + " :: "+ msUbigeoBk.getEstado());
								}
							cambios = true;			
							msUbigeo.setEstado(msUbigeoBk.getEstado());
					}
                                
				                                 
                                      if (msUbigeoBk.getRtmaddress() != null
							&& msUbigeo.getRtmaddress() != null) {
						if (!msUbigeoBk.getRtmaddress().equals(
								msUbigeo.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddress"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddress() + " :: "+ msUbigeoBk.getRtmaddress());
								}
							cambios = true;
							msUbigeo.setRtmaddress(msUbigeoBk.getRtmaddress());
						}
					} else if (msUbigeoBk.getRtmaddress() == null
							&& msUbigeo.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddress"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddress() + " :: "+ msUbigeoBk.getRtmaddress());
								}
							cambios = true;
							msUbigeo.setRtmaddress(msUbigeoBk.getRtmaddress());
						
					} else if (msUbigeoBk.getRtmaddress() != null
							&& msUbigeo.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddress"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddress() + " :: "+ msUbigeoBk.getRtmaddress());
								}
							cambios = true;			
							msUbigeo.setRtmaddress(msUbigeoBk.getRtmaddress());
					}
                                
				                                 
                                      if (msUbigeoBk.getRtmaddressrst() != null
							&& msUbigeo.getRtmaddressrst() != null) {
						if (!msUbigeoBk.getRtmaddressrst().equals(
								msUbigeo.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddressrst"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddressrst() + " :: "+ msUbigeoBk.getRtmaddressrst());
								}
							cambios = true;
							msUbigeo.setRtmaddressrst(msUbigeoBk.getRtmaddressrst());
						}
					} else if (msUbigeoBk.getRtmaddressrst() == null
							&& msUbigeo.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddressrst"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddressrst() + " :: "+ msUbigeoBk.getRtmaddressrst());
								}
							cambios = true;
							msUbigeo.setRtmaddressrst(msUbigeoBk.getRtmaddressrst());
						
					} else if (msUbigeoBk.getRtmaddressrst() != null
							&& msUbigeo.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUbigeo:Rtmaddressrst"+" :: "+msUbigeoBk.getId().toString()+" :: "+ msUbigeo.getRtmaddressrst() + " :: "+ msUbigeoBk.getRtmaddressrst());
								}
							cambios = true;			
							msUbigeo.setRtmaddressrst(msUbigeoBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}