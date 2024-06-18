package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsLocal;
import pe.gob.mef.registramef.bs.transfer.bk.MsLocalBk;

/**
 * MS_LOCAL SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS LOCALES REGISTRADOS EN EL SISTEMA "LOCALES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsLocalMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsLocalMng.class.getName());
	
	public static boolean auditarCambiosMsLocal(MsLocalBk msLocalBk, MsLocal msLocal, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msLocalBk.getDescripcion() != null
						&& msLocal.getDescripcion() != null) {
					if (!msLocalBk.getDescripcion().equals(
						msLocal.getDescripcion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Descripcion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDescripcion() + " :: "+ msLocalBk.getDescripcion());								
						}
						cambios = true;
						msLocal.setDescripcion(msLocalBk.getDescripcion());
					}
				} else if (msLocalBk.getDescripcion() == null
						&& msLocal.getDescripcion() != null) {
					if (msLocal.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Descripcion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDescripcion() + " :: "+ msLocalBk.getDescripcion());
						}
						cambios = true;
						msLocal.setDescripcion(msLocalBk.getDescripcion());
					}
				} else if (msLocalBk.getDescripcion() != null
						&& msLocal.getDescripcion() == null) {
					if (msLocalBk.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Descripcion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDescripcion() + " :: "+ msLocalBk.getDescripcion());
						}
						cambios = true;
						msLocal.setDescripcion(msLocalBk.getDescripcion());
					}
				}
				 
		            if (msLocalBk.getDireccion() != null
						&& msLocal.getDireccion() != null) {
					if (!msLocalBk.getDireccion().equals(
						msLocal.getDireccion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Direccion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDireccion() + " :: "+ msLocalBk.getDireccion());								
						}
						cambios = true;
						msLocal.setDireccion(msLocalBk.getDireccion());
					}
				} else if (msLocalBk.getDireccion() == null
						&& msLocal.getDireccion() != null) {
					if (msLocal.getDireccion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Direccion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDireccion() + " :: "+ msLocalBk.getDireccion());
						}
						cambios = true;
						msLocal.setDireccion(msLocalBk.getDireccion());
					}
				} else if (msLocalBk.getDireccion() != null
						&& msLocal.getDireccion() == null) {
					if (msLocalBk.getDireccion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Direccion"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getDireccion() + " :: "+ msLocalBk.getDireccion());
						}
						cambios = true;
						msLocal.setDireccion(msLocalBk.getDireccion());
					}
				}
				 
		            if (msLocalBk.getReferencia() != null
						&& msLocal.getReferencia() != null) {
					if (!msLocalBk.getReferencia().equals(
						msLocal.getReferencia())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Referencia"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getReferencia() + " :: "+ msLocalBk.getReferencia());								
						}
						cambios = true;
						msLocal.setReferencia(msLocalBk.getReferencia());
					}
				} else if (msLocalBk.getReferencia() == null
						&& msLocal.getReferencia() != null) {
					if (msLocal.getReferencia().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Referencia"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getReferencia() + " :: "+ msLocalBk.getReferencia());
						}
						cambios = true;
						msLocal.setReferencia(msLocalBk.getReferencia());
					}
				} else if (msLocalBk.getReferencia() != null
						&& msLocal.getReferencia() == null) {
					if (msLocalBk.getReferencia().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Referencia"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getReferencia() + " :: "+ msLocalBk.getReferencia());
						}
						cambios = true;
						msLocal.setReferencia(msLocalBk.getReferencia());
					}
				}
				if (msLocalBk.getCodDpto() != null
							&& msLocal.getCodDpto() != null) {
						if (!msLocalBk.getCodDpto().equals(
								msLocal.getCodDpto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDpto"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDpto() + " :: "+ msLocalBk.getCodDpto());
								}
							cambios = true;
							msLocal.setCodDpto(msLocalBk.getCodDpto());
						}
					} else if (msLocalBk.getCodDpto() == null
							&& msLocal.getCodDpto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDpto"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDpto() + " :: "+ msLocalBk.getCodDpto());
								}
							cambios = true;
							msLocal.setCodDpto(msLocalBk.getCodDpto());
						
					} else if (msLocalBk.getCodDpto() != null
							&& msLocal.getCodDpto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDpto"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDpto() + " :: "+ msLocalBk.getCodDpto());
								}
							cambios = true;			
							msLocal.setCodDpto(msLocalBk.getCodDpto());
					}
				if (msLocalBk.getCodProv() != null
							&& msLocal.getCodProv() != null) {
						if (!msLocalBk.getCodProv().equals(
								msLocal.getCodProv())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodProv"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodProv() + " :: "+ msLocalBk.getCodProv());
								}
							cambios = true;
							msLocal.setCodProv(msLocalBk.getCodProv());
						}
					} else if (msLocalBk.getCodProv() == null
							&& msLocal.getCodProv() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodProv"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodProv() + " :: "+ msLocalBk.getCodProv());
								}
							cambios = true;
							msLocal.setCodProv(msLocalBk.getCodProv());
						
					} else if (msLocalBk.getCodProv() != null
							&& msLocal.getCodProv() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodProv"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodProv() + " :: "+ msLocalBk.getCodProv());
								}
							cambios = true;			
							msLocal.setCodProv(msLocalBk.getCodProv());
					}
				if (msLocalBk.getCodDistr() != null
							&& msLocal.getCodDistr() != null) {
						if (!msLocalBk.getCodDistr().equals(
								msLocal.getCodDistr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDistr"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDistr() + " :: "+ msLocalBk.getCodDistr());
								}
							cambios = true;
							msLocal.setCodDistr(msLocalBk.getCodDistr());
						}
					} else if (msLocalBk.getCodDistr() == null
							&& msLocal.getCodDistr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDistr"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDistr() + " :: "+ msLocalBk.getCodDistr());
								}
							cambios = true;
							msLocal.setCodDistr(msLocalBk.getCodDistr());
						
					} else if (msLocalBk.getCodDistr() != null
							&& msLocal.getCodDistr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:CodDistr"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getCodDistr() + " :: "+ msLocalBk.getCodDistr());
								}
							cambios = true;			
							msLocal.setCodDistr(msLocalBk.getCodDistr());
					}
				if (msLocalBk.getIdSede() != null
							&& msLocal.getIdSede() != null) {
						if (!msLocalBk.getIdSede().equals(
								msLocal.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdSede"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdSede() + " :: "+ msLocalBk.getIdSede());
								}
							cambios = true;
							msLocal.setIdSede(msLocalBk.getIdSede());
						}
					} else if (msLocalBk.getIdSede() == null
							&& msLocal.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdSede"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdSede() + " :: "+ msLocalBk.getIdSede());
								}
							cambios = true;
							msLocal.setIdSede(msLocalBk.getIdSede());
						
					} else if (msLocalBk.getIdSede() != null
							&& msLocal.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdSede"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdSede() + " :: "+ msLocalBk.getIdSede());
								}
							cambios = true;			
							msLocal.setIdSede(msLocalBk.getIdSede());
					}
				if (msLocalBk.getIdpais() != null
							&& msLocal.getIdpais() != null) {
						if (!msLocalBk.getIdpais().equals(
								msLocal.getIdpais())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Idpais"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdpais() + " :: "+ msLocalBk.getIdpais());
								}
							cambios = true;
							msLocal.setIdpais(msLocalBk.getIdpais());
						}
					} else if (msLocalBk.getIdpais() == null
							&& msLocal.getIdpais() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Idpais"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdpais() + " :: "+ msLocalBk.getIdpais());
								}
							cambios = true;
							msLocal.setIdpais(msLocalBk.getIdpais());
						
					} else if (msLocalBk.getIdpais() != null
							&& msLocal.getIdpais() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Idpais"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdpais() + " :: "+ msLocalBk.getIdpais());
								}
							cambios = true;			
							msLocal.setIdpais(msLocalBk.getIdpais());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsLocal(MsLocalBk msLocalBk, MsLocal msLocal, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (msLocalBk.getIdduserCrea() != null
							&& msLocal.getIdduserCrea() != null) {
						if (!msLocalBk.getIdduserCrea().equals(
								msLocal.getIdduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserCrea() + " :: "+ msLocalBk.getIdduserCrea());
								}
							cambios = true;
							msLocal.setIdduserCrea(msLocalBk.getIdduserCrea());
						}
					} else if (msLocalBk.getIdduserCrea() == null
							&& msLocal.getIdduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserCrea() + " :: "+ msLocalBk.getIdduserCrea());
								}
							cambios = true;
							msLocal.setIdduserCrea(msLocalBk.getIdduserCrea());
						
					} else if (msLocalBk.getIdduserCrea() != null
							&& msLocal.getIdduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserCrea() + " :: "+ msLocalBk.getIdduserCrea());
								}
							cambios = true;			
							msLocal.setIdduserCrea(msLocalBk.getIdduserCrea());
					}
                                
				                                 
                                      if (msLocalBk.getIdduserModif() != null
							&& msLocal.getIdduserModif() != null) {
						if (!msLocalBk.getIdduserModif().equals(
								msLocal.getIdduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserModif() + " :: "+ msLocalBk.getIdduserModif());
								}
							cambios = true;
							msLocal.setIdduserModif(msLocalBk.getIdduserModif());
						}
					} else if (msLocalBk.getIdduserModif() == null
							&& msLocal.getIdduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserModif() + " :: "+ msLocalBk.getIdduserModif());
								}
							cambios = true;
							msLocal.setIdduserModif(msLocalBk.getIdduserModif());
						
					} else if (msLocalBk.getIdduserModif() != null
							&& msLocal.getIdduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:IdduserModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getIdduserModif() + " :: "+ msLocalBk.getIdduserModif());
								}
							cambios = true;			
							msLocal.setIdduserModif(msLocalBk.getIdduserModif());
					}
                                
				                                 
                                      if (msLocalBk.getFechaCrea() != null
							&& msLocal.getFechaCrea() != null) {
						if (!msLocalBk.getFechaCrea().equals(
								msLocal.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaCrea() + " :: "+ msLocalBk.getFechaCrea());
								}
							cambios = true;
							msLocal.setFechaCrea(msLocalBk.getFechaCrea());
						}
					} else if (msLocalBk.getFechaCrea() == null
							&& msLocal.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaCrea() + " :: "+ msLocalBk.getFechaCrea());
								}
							cambios = true;
							msLocal.setFechaCrea(msLocalBk.getFechaCrea());
						
					} else if (msLocalBk.getFechaCrea() != null
							&& msLocal.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaCrea"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaCrea() + " :: "+ msLocalBk.getFechaCrea());
								}
							cambios = true;			
							msLocal.setFechaCrea(msLocalBk.getFechaCrea());
					}
                                
				                                 
                                      if (msLocalBk.getFechaModif() != null
							&& msLocal.getFechaModif() != null) {
						if (!msLocalBk.getFechaModif().equals(
								msLocal.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaModif() + " :: "+ msLocalBk.getFechaModif());
								}
							cambios = true;
							msLocal.setFechaModif(msLocalBk.getFechaModif());
						}
					} else if (msLocalBk.getFechaModif() == null
							&& msLocal.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaModif() + " :: "+ msLocalBk.getFechaModif());
								}
							cambios = true;
							msLocal.setFechaModif(msLocalBk.getFechaModif());
						
					} else if (msLocalBk.getFechaModif() != null
							&& msLocal.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:FechaModif"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getFechaModif() + " :: "+ msLocalBk.getFechaModif());
								}
							cambios = true;			
							msLocal.setFechaModif(msLocalBk.getFechaModif());
					}
                                
				
				
				
				
				
				                                 
                                      if (msLocalBk.getEstado() != null
							&& msLocal.getEstado() != null) {
						if (!msLocalBk.getEstado().equals(
								msLocal.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Estado"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getEstado() + " :: "+ msLocalBk.getEstado());
								}
							cambios = true;
							msLocal.setEstado(msLocalBk.getEstado());
						}
					} else if (msLocalBk.getEstado() == null
							&& msLocal.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Estado"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getEstado() + " :: "+ msLocalBk.getEstado());
								}
							cambios = true;
							msLocal.setEstado(msLocalBk.getEstado());
						
					} else if (msLocalBk.getEstado() != null
							&& msLocal.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Estado"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getEstado() + " :: "+ msLocalBk.getEstado());
								}
							cambios = true;			
							msLocal.setEstado(msLocalBk.getEstado());
					}
                                
				                                 
                                      if (msLocalBk.getRtmaddress() != null
							&& msLocal.getRtmaddress() != null) {
						if (!msLocalBk.getRtmaddress().equals(
								msLocal.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddress"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddress() + " :: "+ msLocalBk.getRtmaddress());
								}
							cambios = true;
							msLocal.setRtmaddress(msLocalBk.getRtmaddress());
						}
					} else if (msLocalBk.getRtmaddress() == null
							&& msLocal.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddress"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddress() + " :: "+ msLocalBk.getRtmaddress());
								}
							cambios = true;
							msLocal.setRtmaddress(msLocalBk.getRtmaddress());
						
					} else if (msLocalBk.getRtmaddress() != null
							&& msLocal.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddress"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddress() + " :: "+ msLocalBk.getRtmaddress());
								}
							cambios = true;			
							msLocal.setRtmaddress(msLocalBk.getRtmaddress());
					}
                                
				                                 
                                      if (msLocalBk.getRtmaddressrst() != null
							&& msLocal.getRtmaddressrst() != null) {
						if (!msLocalBk.getRtmaddressrst().equals(
								msLocal.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddressrst"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddressrst() + " :: "+ msLocalBk.getRtmaddressrst());
								}
							cambios = true;
							msLocal.setRtmaddressrst(msLocalBk.getRtmaddressrst());
						}
					} else if (msLocalBk.getRtmaddressrst() == null
							&& msLocal.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddressrst"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddressrst() + " :: "+ msLocalBk.getRtmaddressrst());
								}
							cambios = true;
							msLocal.setRtmaddressrst(msLocalBk.getRtmaddressrst());
						
					} else if (msLocalBk.getRtmaddressrst() != null
							&& msLocal.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msLocal:Rtmaddressrst"+" :: "+msLocalBk.getIdLocal().toString()+" :: "+ msLocal.getRtmaddressrst() + " :: "+ msLocalBk.getRtmaddressrst());
								}
							cambios = true;			
							msLocal.setRtmaddressrst(msLocalBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}