package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.PrtParametros;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;

/**
 * PRT_PARAMETROS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS PARAMETROS REGISTRADOS EN EL SISTEMA "PARÁMETROS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaPrtParametrosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaPrtParametrosMng.class.getName());
	
	public static boolean auditarCambiosPrtParametros(PrtParametrosBk prtParametrosBk, PrtParametros prtParametros, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (prtParametrosBk.getIdpadre() != null
							&& prtParametros.getIdpadre() != null) {
						if (!prtParametrosBk.getIdpadre().equals(
								prtParametros.getIdpadre())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Idpadre"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIdpadre() + " :: "+ prtParametrosBk.getIdpadre());
								}
							cambios = true;
							prtParametros.setIdpadre(prtParametrosBk.getIdpadre());
						}
					} else if (prtParametrosBk.getIdpadre() == null
							&& prtParametros.getIdpadre() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Idpadre"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIdpadre() + " :: "+ prtParametrosBk.getIdpadre());
								}
							cambios = true;
							prtParametros.setIdpadre(prtParametrosBk.getIdpadre());
						
					} else if (prtParametrosBk.getIdpadre() != null
							&& prtParametros.getIdpadre() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Idpadre"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIdpadre() + " :: "+ prtParametrosBk.getIdpadre());
								}
							cambios = true;			
							prtParametros.setIdpadre(prtParametrosBk.getIdpadre());
					}
				 
		            if (prtParametrosBk.getDescripcion() != null
						&& prtParametros.getDescripcion() != null) {
					if (!prtParametrosBk.getDescripcion().equals(
						prtParametros.getDescripcion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Descripcion"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getDescripcion() + " :: "+ prtParametrosBk.getDescripcion());								
						}
						cambios = true;
						prtParametros.setDescripcion(prtParametrosBk.getDescripcion());
					}
				} else if (prtParametrosBk.getDescripcion() == null
						&& prtParametros.getDescripcion() != null) {
					if (prtParametros.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Descripcion"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getDescripcion() + " :: "+ prtParametrosBk.getDescripcion());
						}
						cambios = true;
						prtParametros.setDescripcion(prtParametrosBk.getDescripcion());
					}
				} else if (prtParametrosBk.getDescripcion() != null
						&& prtParametros.getDescripcion() == null) {
					if (prtParametrosBk.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Descripcion"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getDescripcion() + " :: "+ prtParametrosBk.getDescripcion());
						}
						cambios = true;
						prtParametros.setDescripcion(prtParametrosBk.getDescripcion());
					}
				}
				if (prtParametrosBk.getEstado() != null
							&& prtParametros.getEstado() != null) {
						if (!prtParametrosBk.getEstado().equals(
								prtParametros.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getEstado() + " :: "+ prtParametrosBk.getEstado());
								}
							cambios = true;
							prtParametros.setEstado(prtParametrosBk.getEstado());
						}
					} else if (prtParametrosBk.getEstado() == null
							&& prtParametros.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getEstado() + " :: "+ prtParametrosBk.getEstado());
								}
							cambios = true;
							prtParametros.setEstado(prtParametrosBk.getEstado());
						
					} else if (prtParametrosBk.getEstado() != null
							&& prtParametros.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getEstado() + " :: "+ prtParametrosBk.getEstado());
								}
							cambios = true;			
							prtParametros.setEstado(prtParametrosBk.getEstado());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaPrtParametros(PrtParametrosBk prtParametrosBk, PrtParametros prtParametros, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (prtParametrosBk.getIduserCrea() != null
							&& prtParametros.getIduserCrea() != null) {
						if (!prtParametrosBk.getIduserCrea().equals(
								prtParametros.getIduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserCrea() + " :: "+ prtParametrosBk.getIduserCrea());
								}
							cambios = true;
							prtParametros.setIduserCrea(prtParametrosBk.getIduserCrea());
						}
					} else if (prtParametrosBk.getIduserCrea() == null
							&& prtParametros.getIduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserCrea() + " :: "+ prtParametrosBk.getIduserCrea());
								}
							cambios = true;
							prtParametros.setIduserCrea(prtParametrosBk.getIduserCrea());
						
					} else if (prtParametrosBk.getIduserCrea() != null
							&& prtParametros.getIduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserCrea() + " :: "+ prtParametrosBk.getIduserCrea());
								}
							cambios = true;			
							prtParametros.setIduserCrea(prtParametrosBk.getIduserCrea());
					}
                                
				                                 
                                      if (prtParametrosBk.getIduserModif() != null
							&& prtParametros.getIduserModif() != null) {
						if (!prtParametrosBk.getIduserModif().equals(
								prtParametros.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserModif() + " :: "+ prtParametrosBk.getIduserModif());
								}
							cambios = true;
							prtParametros.setIduserModif(prtParametrosBk.getIduserModif());
						}
					} else if (prtParametrosBk.getIduserModif() == null
							&& prtParametros.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserModif() + " :: "+ prtParametrosBk.getIduserModif());
								}
							cambios = true;
							prtParametros.setIduserModif(prtParametrosBk.getIduserModif());
						
					} else if (prtParametrosBk.getIduserModif() != null
							&& prtParametros.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:IduserModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getIduserModif() + " :: "+ prtParametrosBk.getIduserModif());
								}
							cambios = true;			
							prtParametros.setIduserModif(prtParametrosBk.getIduserModif());
					}
                                
				                                 
                                      if (prtParametrosBk.getFechaCrea() != null
							&& prtParametros.getFechaCrea() != null) {
						if (!prtParametrosBk.getFechaCrea().equals(
								prtParametros.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaCrea() + " :: "+ prtParametrosBk.getFechaCrea());
								}
							cambios = true;
							prtParametros.setFechaCrea(prtParametrosBk.getFechaCrea());
						}
					} else if (prtParametrosBk.getFechaCrea() == null
							&& prtParametros.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaCrea() + " :: "+ prtParametrosBk.getFechaCrea());
								}
							cambios = true;
							prtParametros.setFechaCrea(prtParametrosBk.getFechaCrea());
						
					} else if (prtParametrosBk.getFechaCrea() != null
							&& prtParametros.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaCrea"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaCrea() + " :: "+ prtParametrosBk.getFechaCrea());
								}
							cambios = true;			
							prtParametros.setFechaCrea(prtParametrosBk.getFechaCrea());
					}
                                
				                                 
                                      if (prtParametrosBk.getFechaModif() != null
							&& prtParametros.getFechaModif() != null) {
						if (!prtParametrosBk.getFechaModif().equals(
								prtParametros.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaModif() + " :: "+ prtParametrosBk.getFechaModif());
								}
							cambios = true;
							prtParametros.setFechaModif(prtParametrosBk.getFechaModif());
						}
					} else if (prtParametrosBk.getFechaModif() == null
							&& prtParametros.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaModif() + " :: "+ prtParametrosBk.getFechaModif());
								}
							cambios = true;
							prtParametros.setFechaModif(prtParametrosBk.getFechaModif());
						
					} else if (prtParametrosBk.getFechaModif() != null
							&& prtParametros.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:FechaModif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getFechaModif() + " :: "+ prtParametrosBk.getFechaModif());
								}
							cambios = true;			
							prtParametros.setFechaModif(prtParametrosBk.getFechaModif());
					}
                                
				                                 
                                      if (prtParametrosBk.getRtmaddress() != null
							&& prtParametros.getRtmaddress() != null) {
						if (!prtParametrosBk.getRtmaddress().equals(
								prtParametros.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddress"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddress() + " :: "+ prtParametrosBk.getRtmaddress());
								}
							cambios = true;
							prtParametros.setRtmaddress(prtParametrosBk.getRtmaddress());
						}
					} else if (prtParametrosBk.getRtmaddress() == null
							&& prtParametros.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddress"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddress() + " :: "+ prtParametrosBk.getRtmaddress());
								}
							cambios = true;
							prtParametros.setRtmaddress(prtParametrosBk.getRtmaddress());
						
					} else if (prtParametrosBk.getRtmaddress() != null
							&& prtParametros.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddress"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddress() + " :: "+ prtParametrosBk.getRtmaddress());
								}
							cambios = true;			
							prtParametros.setRtmaddress(prtParametrosBk.getRtmaddress());
					}
                                
				                                 
                                      if (prtParametrosBk.getRtmaddressmodif() != null
							&& prtParametros.getRtmaddressmodif() != null) {
						if (!prtParametrosBk.getRtmaddressmodif().equals(
								prtParametros.getRtmaddressmodif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddressmodif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddressmodif() + " :: "+ prtParametrosBk.getRtmaddressmodif());
								}
							cambios = true;
							prtParametros.setRtmaddressmodif(prtParametrosBk.getRtmaddressmodif());
						}
					} else if (prtParametrosBk.getRtmaddressmodif() == null
							&& prtParametros.getRtmaddressmodif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddressmodif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddressmodif() + " :: "+ prtParametrosBk.getRtmaddressmodif());
								}
							cambios = true;
							prtParametros.setRtmaddressmodif(prtParametrosBk.getRtmaddressmodif());
						
					} else if (prtParametrosBk.getRtmaddressmodif() != null
							&& prtParametros.getRtmaddressmodif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Rtmaddressmodif"+" :: "+prtParametrosBk.getIdparametro().toString()+" :: "+ prtParametros.getRtmaddressmodif() + " :: "+ prtParametrosBk.getRtmaddressmodif());
								}
							cambios = true;			
							prtParametros.setRtmaddressmodif(prtParametrosBk.getRtmaddressmodif());
					}
                                
				
			
			return cambios;
	}
}