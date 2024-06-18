package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsPaises;
import pe.gob.mef.registramef.bs.transfer.bk.MsPaisesBk;

/**
 * MS_PAISES SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LOS PAISES REGISTRADOS EN EL SISTEMA "PAÍSES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsPaisesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsPaisesMng.class.getName());
	
	public static boolean auditarCambiosMsPaises(MsPaisesBk msPaisesBk, MsPaises msPaises, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msPaisesBk.getPaisNombre() != null
						&& msPaises.getPaisNombre() != null) {
					if (!msPaisesBk.getPaisNombre().equals(
						msPaises.getPaisNombre())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:PaisNombre"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getPaisNombre() + " :: "+ msPaisesBk.getPaisNombre());								
						}
						cambios = true;
						msPaises.setPaisNombre(msPaisesBk.getPaisNombre());
					}
				} else if (msPaisesBk.getPaisNombre() == null
						&& msPaises.getPaisNombre() != null) {
					if (msPaises.getPaisNombre().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:PaisNombre"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getPaisNombre() + " :: "+ msPaisesBk.getPaisNombre());
						}
						cambios = true;
						msPaises.setPaisNombre(msPaisesBk.getPaisNombre());
					}
				} else if (msPaisesBk.getPaisNombre() != null
						&& msPaises.getPaisNombre() == null) {
					if (msPaisesBk.getPaisNombre().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:PaisNombre"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getPaisNombre() + " :: "+ msPaisesBk.getPaisNombre());
						}
						cambios = true;
						msPaises.setPaisNombre(msPaisesBk.getPaisNombre());
					}
				}
				 
		            if (msPaisesBk.getAcronimo() != null
						&& msPaises.getAcronimo() != null) {
					if (!msPaisesBk.getAcronimo().equals(
						msPaises.getAcronimo())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Acronimo"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getAcronimo() + " :: "+ msPaisesBk.getAcronimo());								
						}
						cambios = true;
						msPaises.setAcronimo(msPaisesBk.getAcronimo());
					}
				} else if (msPaisesBk.getAcronimo() == null
						&& msPaises.getAcronimo() != null) {
					if (msPaises.getAcronimo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Acronimo"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getAcronimo() + " :: "+ msPaisesBk.getAcronimo());
						}
						cambios = true;
						msPaises.setAcronimo(msPaisesBk.getAcronimo());
					}
				} else if (msPaisesBk.getAcronimo() != null
						&& msPaises.getAcronimo() == null) {
					if (msPaisesBk.getAcronimo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Acronimo"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getAcronimo() + " :: "+ msPaisesBk.getAcronimo());
						}
						cambios = true;
						msPaises.setAcronimo(msPaisesBk.getAcronimo());
					}
				}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsPaises(MsPaisesBk msPaisesBk, MsPaises msPaises, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (msPaisesBk.getIdusserCrea() != null
							&& msPaises.getIdusserCrea() != null) {
						if (!msPaisesBk.getIdusserCrea().equals(
								msPaises.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserCrea() + " :: "+ msPaisesBk.getIdusserCrea());
								}
							cambios = true;
							msPaises.setIdusserCrea(msPaisesBk.getIdusserCrea());
						}
					} else if (msPaisesBk.getIdusserCrea() == null
							&& msPaises.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserCrea() + " :: "+ msPaisesBk.getIdusserCrea());
								}
							cambios = true;
							msPaises.setIdusserCrea(msPaisesBk.getIdusserCrea());
						
					} else if (msPaisesBk.getIdusserCrea() != null
							&& msPaises.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserCrea() + " :: "+ msPaisesBk.getIdusserCrea());
								}
							cambios = true;			
							msPaises.setIdusserCrea(msPaisesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msPaisesBk.getIdusserModif() != null
							&& msPaises.getIdusserModif() != null) {
						if (!msPaisesBk.getIdusserModif().equals(
								msPaises.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserModif() + " :: "+ msPaisesBk.getIdusserModif());
								}
							cambios = true;
							msPaises.setIdusserModif(msPaisesBk.getIdusserModif());
						}
					} else if (msPaisesBk.getIdusserModif() == null
							&& msPaises.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserModif() + " :: "+ msPaisesBk.getIdusserModif());
								}
							cambios = true;
							msPaises.setIdusserModif(msPaisesBk.getIdusserModif());
						
					} else if (msPaisesBk.getIdusserModif() != null
							&& msPaises.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:IdusserModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getIdusserModif() + " :: "+ msPaisesBk.getIdusserModif());
								}
							cambios = true;			
							msPaises.setIdusserModif(msPaisesBk.getIdusserModif());
					}
                                
				                                 
                                      if (msPaisesBk.getFechaCrea() != null
							&& msPaises.getFechaCrea() != null) {
						if (!msPaisesBk.getFechaCrea().equals(
								msPaises.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaCrea() + " :: "+ msPaisesBk.getFechaCrea());
								}
							cambios = true;
							msPaises.setFechaCrea(msPaisesBk.getFechaCrea());
						}
					} else if (msPaisesBk.getFechaCrea() == null
							&& msPaises.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaCrea() + " :: "+ msPaisesBk.getFechaCrea());
								}
							cambios = true;
							msPaises.setFechaCrea(msPaisesBk.getFechaCrea());
						
					} else if (msPaisesBk.getFechaCrea() != null
							&& msPaises.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaCrea"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaCrea() + " :: "+ msPaisesBk.getFechaCrea());
								}
							cambios = true;			
							msPaises.setFechaCrea(msPaisesBk.getFechaCrea());
					}
                                
				                                 
                                      if (msPaisesBk.getFechaModif() != null
							&& msPaises.getFechaModif() != null) {
						if (!msPaisesBk.getFechaModif().equals(
								msPaises.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaModif() + " :: "+ msPaisesBk.getFechaModif());
								}
							cambios = true;
							msPaises.setFechaModif(msPaisesBk.getFechaModif());
						}
					} else if (msPaisesBk.getFechaModif() == null
							&& msPaises.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaModif() + " :: "+ msPaisesBk.getFechaModif());
								}
							cambios = true;
							msPaises.setFechaModif(msPaisesBk.getFechaModif());
						
					} else if (msPaisesBk.getFechaModif() != null
							&& msPaises.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:FechaModif"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getFechaModif() + " :: "+ msPaisesBk.getFechaModif());
								}
							cambios = true;			
							msPaises.setFechaModif(msPaisesBk.getFechaModif());
					}
                                
				                                 
                                      if (msPaisesBk.getEstado() != null
							&& msPaises.getEstado() != null) {
						if (!msPaisesBk.getEstado().equals(
								msPaises.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Estado"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getEstado() + " :: "+ msPaisesBk.getEstado());
								}
							cambios = true;
							msPaises.setEstado(msPaisesBk.getEstado());
						}
					} else if (msPaisesBk.getEstado() == null
							&& msPaises.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Estado"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getEstado() + " :: "+ msPaisesBk.getEstado());
								}
							cambios = true;
							msPaises.setEstado(msPaisesBk.getEstado());
						
					} else if (msPaisesBk.getEstado() != null
							&& msPaises.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Estado"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getEstado() + " :: "+ msPaisesBk.getEstado());
								}
							cambios = true;			
							msPaises.setEstado(msPaisesBk.getEstado());
					}
                                
				                                 
                                      if (msPaisesBk.getRtmaddress() != null
							&& msPaises.getRtmaddress() != null) {
						if (!msPaisesBk.getRtmaddress().equals(
								msPaises.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddress"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddress() + " :: "+ msPaisesBk.getRtmaddress());
								}
							cambios = true;
							msPaises.setRtmaddress(msPaisesBk.getRtmaddress());
						}
					} else if (msPaisesBk.getRtmaddress() == null
							&& msPaises.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddress"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddress() + " :: "+ msPaisesBk.getRtmaddress());
								}
							cambios = true;
							msPaises.setRtmaddress(msPaisesBk.getRtmaddress());
						
					} else if (msPaisesBk.getRtmaddress() != null
							&& msPaises.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddress"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddress() + " :: "+ msPaisesBk.getRtmaddress());
								}
							cambios = true;			
							msPaises.setRtmaddress(msPaisesBk.getRtmaddress());
					}
                                
				                                 
                                      if (msPaisesBk.getRtmaddressrst() != null
							&& msPaises.getRtmaddressrst() != null) {
						if (!msPaisesBk.getRtmaddressrst().equals(
								msPaises.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddressrst"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddressrst() + " :: "+ msPaisesBk.getRtmaddressrst());
								}
							cambios = true;
							msPaises.setRtmaddressrst(msPaisesBk.getRtmaddressrst());
						}
					} else if (msPaisesBk.getRtmaddressrst() == null
							&& msPaises.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddressrst"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddressrst() + " :: "+ msPaisesBk.getRtmaddressrst());
								}
							cambios = true;
							msPaises.setRtmaddressrst(msPaisesBk.getRtmaddressrst());
						
					} else if (msPaisesBk.getRtmaddressrst() != null
							&& msPaises.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msPaises:Rtmaddressrst"+" :: "+msPaisesBk.getIdpais().toString()+" :: "+ msPaises.getRtmaddressrst() + " :: "+ msPaisesBk.getRtmaddressrst());
								}
							cambios = true;			
							msPaises.setRtmaddressrst(msPaisesBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}