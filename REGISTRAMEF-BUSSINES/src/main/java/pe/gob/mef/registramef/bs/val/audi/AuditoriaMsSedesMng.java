package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsSedes;
import pe.gob.mef.registramef.bs.transfer.bk.MsSedesBk;

/**
 * MS_SEDES SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS SEDES REGISTRADAS EN EL SISTEMA "SEDES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsSedesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsSedesMng.class.getName());
	
	public static boolean auditarCambiosMsSedes(MsSedesBk msSedesBk, MsSedes msSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msSedesBk.getSigla() != null
						&& msSedes.getSigla() != null) {
					if (!msSedesBk.getSigla().equals(
						msSedes.getSigla())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sigla"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSigla() + " :: "+ msSedesBk.getSigla());								
						}
						cambios = true;
						msSedes.setSigla(msSedesBk.getSigla());
					}
				} else if (msSedesBk.getSigla() == null
						&& msSedes.getSigla() != null) {
					if (msSedes.getSigla().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sigla"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSigla() + " :: "+ msSedesBk.getSigla());
						}
						cambios = true;
						msSedes.setSigla(msSedesBk.getSigla());
					}
				} else if (msSedesBk.getSigla() != null
						&& msSedes.getSigla() == null) {
					if (msSedesBk.getSigla().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sigla"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSigla() + " :: "+ msSedesBk.getSigla());
						}
						cambios = true;
						msSedes.setSigla(msSedesBk.getSigla());
					}
				}
				 
		            if (msSedesBk.getSede() != null
						&& msSedes.getSede() != null) {
					if (!msSedesBk.getSede().equals(
						msSedes.getSede())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sede"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSede() + " :: "+ msSedesBk.getSede());								
						}
						cambios = true;
						msSedes.setSede(msSedesBk.getSede());
					}
				} else if (msSedesBk.getSede() == null
						&& msSedes.getSede() != null) {
					if (msSedes.getSede().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sede"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSede() + " :: "+ msSedesBk.getSede());
						}
						cambios = true;
						msSedes.setSede(msSedesBk.getSede());
					}
				} else if (msSedesBk.getSede() != null
						&& msSedes.getSede() == null) {
					if (msSedesBk.getSede().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Sede"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getSede() + " :: "+ msSedesBk.getSede());
						}
						cambios = true;
						msSedes.setSede(msSedesBk.getSede());
					}
				}
				if (msSedesBk.getDireccion() != null
							&& msSedes.getDireccion() != null) {
						if (!msSedesBk.getDireccion().equals(
								msSedes.getDireccion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Direccion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getDireccion() + " :: "+ msSedesBk.getDireccion());
								}
							cambios = true;
							msSedes.setDireccion(msSedesBk.getDireccion());
						}
					} else if (msSedesBk.getDireccion() == null
							&& msSedes.getDireccion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Direccion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getDireccion() + " :: "+ msSedesBk.getDireccion());
								}
							cambios = true;
							msSedes.setDireccion(msSedesBk.getDireccion());
						
					} else if (msSedesBk.getDireccion() != null
							&& msSedes.getDireccion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Direccion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getDireccion() + " :: "+ msSedesBk.getDireccion());
								}
							cambios = true;			
							msSedes.setDireccion(msSedesBk.getDireccion());
					}
				if (msSedesBk.getIdGrupo() != null
							&& msSedes.getIdGrupo() != null) {
						if (!msSedesBk.getIdGrupo().equals(
								msSedes.getIdGrupo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdGrupo"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdGrupo() + " :: "+ msSedesBk.getIdGrupo());
								}
							cambios = true;
							msSedes.setIdGrupo(msSedesBk.getIdGrupo());
						}
					} else if (msSedesBk.getIdGrupo() == null
							&& msSedes.getIdGrupo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdGrupo"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdGrupo() + " :: "+ msSedesBk.getIdGrupo());
								}
							cambios = true;
							msSedes.setIdGrupo(msSedesBk.getIdGrupo());
						
					} else if (msSedesBk.getIdGrupo() != null
							&& msSedes.getIdGrupo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdGrupo"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdGrupo() + " :: "+ msSedesBk.getIdGrupo());
								}
							cambios = true;			
							msSedes.setIdGrupo(msSedesBk.getIdGrupo());
					}
				if (msSedesBk.getCodDpto() != null
							&& msSedes.getCodDpto() != null) {
						if (!msSedesBk.getCodDpto().equals(
								msSedes.getCodDpto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDpto"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDpto() + " :: "+ msSedesBk.getCodDpto());
								}
							cambios = true;
							msSedes.setCodDpto(msSedesBk.getCodDpto());
						}
					} else if (msSedesBk.getCodDpto() == null
							&& msSedes.getCodDpto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDpto"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDpto() + " :: "+ msSedesBk.getCodDpto());
								}
							cambios = true;
							msSedes.setCodDpto(msSedesBk.getCodDpto());
						
					} else if (msSedesBk.getCodDpto() != null
							&& msSedes.getCodDpto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDpto"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDpto() + " :: "+ msSedesBk.getCodDpto());
								}
							cambios = true;			
							msSedes.setCodDpto(msSedesBk.getCodDpto());
					}
				if (msSedesBk.getCodProv() != null
							&& msSedes.getCodProv() != null) {
						if (!msSedesBk.getCodProv().equals(
								msSedes.getCodProv())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodProv"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodProv() + " :: "+ msSedesBk.getCodProv());
								}
							cambios = true;
							msSedes.setCodProv(msSedesBk.getCodProv());
						}
					} else if (msSedesBk.getCodProv() == null
							&& msSedes.getCodProv() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodProv"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodProv() + " :: "+ msSedesBk.getCodProv());
								}
							cambios = true;
							msSedes.setCodProv(msSedesBk.getCodProv());
						
					} else if (msSedesBk.getCodProv() != null
							&& msSedes.getCodProv() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodProv"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodProv() + " :: "+ msSedesBk.getCodProv());
								}
							cambios = true;			
							msSedes.setCodProv(msSedesBk.getCodProv());
					}
				if (msSedesBk.getCodDistr() != null
							&& msSedes.getCodDistr() != null) {
						if (!msSedesBk.getCodDistr().equals(
								msSedes.getCodDistr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDistr"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDistr() + " :: "+ msSedesBk.getCodDistr());
								}
							cambios = true;
							msSedes.setCodDistr(msSedesBk.getCodDistr());
						}
					} else if (msSedesBk.getCodDistr() == null
							&& msSedes.getCodDistr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDistr"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDistr() + " :: "+ msSedesBk.getCodDistr());
								}
							cambios = true;
							msSedes.setCodDistr(msSedesBk.getCodDistr());
						
					} else if (msSedesBk.getCodDistr() != null
							&& msSedes.getCodDistr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:CodDistr"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getCodDistr() + " :: "+ msSedesBk.getCodDistr());
								}
							cambios = true;			
							msSedes.setCodDistr(msSedesBk.getCodDistr());
					}
				if (msSedesBk.getIdMacregion() != null
							&& msSedes.getIdMacregion() != null) {
						if (!msSedesBk.getIdMacregion().equals(
								msSedes.getIdMacregion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdMacregion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdMacregion() + " :: "+ msSedesBk.getIdMacregion());
								}
							cambios = true;
							msSedes.setIdMacregion(msSedesBk.getIdMacregion());
						}
					} else if (msSedesBk.getIdMacregion() == null
							&& msSedes.getIdMacregion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdMacregion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdMacregion() + " :: "+ msSedesBk.getIdMacregion());
								}
							cambios = true;
							msSedes.setIdMacregion(msSedesBk.getIdMacregion());
						
					} else if (msSedesBk.getIdMacregion() != null
							&& msSedes.getIdMacregion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdMacregion"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdMacregion() + " :: "+ msSedesBk.getIdMacregion());
								}
							cambios = true;			
							msSedes.setIdMacregion(msSedesBk.getIdMacregion());
					}
				if (msSedesBk.getIdpais() != null
							&& msSedes.getIdpais() != null) {
						if (!msSedesBk.getIdpais().equals(
								msSedes.getIdpais())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Idpais"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdpais() + " :: "+ msSedesBk.getIdpais());
								}
							cambios = true;
							msSedes.setIdpais(msSedesBk.getIdpais());
						}
					} else if (msSedesBk.getIdpais() == null
							&& msSedes.getIdpais() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Idpais"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdpais() + " :: "+ msSedesBk.getIdpais());
								}
							cambios = true;
							msSedes.setIdpais(msSedesBk.getIdpais());
						
					} else if (msSedesBk.getIdpais() != null
							&& msSedes.getIdpais() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Idpais"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdpais() + " :: "+ msSedesBk.getIdpais());
								}
							cambios = true;			
							msSedes.setIdpais(msSedesBk.getIdpais());
					}
				if (msSedesBk.getOrden() != null
							&& msSedes.getOrden() != null) {
						if (!msSedesBk.getOrden().equals(
								msSedes.getOrden())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Orden"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getOrden() + " :: "+ msSedesBk.getOrden());
								}
							cambios = true;
							msSedes.setOrden(msSedesBk.getOrden());
						}
					} else if (msSedesBk.getOrden() == null
							&& msSedes.getOrden() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Orden"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getOrden() + " :: "+ msSedesBk.getOrden());
								}
							cambios = true;
							msSedes.setOrden(msSedesBk.getOrden());
						
					} else if (msSedesBk.getOrden() != null
							&& msSedes.getOrden() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Orden"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getOrden() + " :: "+ msSedesBk.getOrden());
								}
							cambios = true;			
							msSedes.setOrden(msSedesBk.getOrden());
					}
				if (msSedesBk.getFlagvisible() != null
							&& msSedes.getFlagvisible() != null) {
						if (!msSedesBk.getFlagvisible().equals(
								msSedes.getFlagvisible())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisible"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisible() + " :: "+ msSedesBk.getFlagvisible());
								}
							cambios = true;
							msSedes.setFlagvisible(msSedesBk.getFlagvisible());
						}
					} else if (msSedesBk.getFlagvisible() == null
							&& msSedes.getFlagvisible() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisible"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisible() + " :: "+ msSedesBk.getFlagvisible());
								}
							cambios = true;
							msSedes.setFlagvisible(msSedesBk.getFlagvisible());
						
					} else if (msSedesBk.getFlagvisible() != null
							&& msSedes.getFlagvisible() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisible"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisible() + " :: "+ msSedesBk.getFlagvisible());
								}
							cambios = true;			
							msSedes.setFlagvisible(msSedesBk.getFlagvisible());
					}
				if (msSedesBk.getFlagvisiblerpte() != null
							&& msSedes.getFlagvisiblerpte() != null) {
						if (!msSedesBk.getFlagvisiblerpte().equals(
								msSedes.getFlagvisiblerpte())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisiblerpte"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisiblerpte() + " :: "+ msSedesBk.getFlagvisiblerpte());
								}
							cambios = true;
							msSedes.setFlagvisiblerpte(msSedesBk.getFlagvisiblerpte());
						}
					} else if (msSedesBk.getFlagvisiblerpte() == null
							&& msSedes.getFlagvisiblerpte() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisiblerpte"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisiblerpte() + " :: "+ msSedesBk.getFlagvisiblerpte());
								}
							cambios = true;
							msSedes.setFlagvisiblerpte(msSedesBk.getFlagvisiblerpte());
						
					} else if (msSedesBk.getFlagvisiblerpte() != null
							&& msSedes.getFlagvisiblerpte() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Flagvisiblerpte"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFlagvisiblerpte() + " :: "+ msSedesBk.getFlagvisiblerpte());
								}
							cambios = true;			
							msSedes.setFlagvisiblerpte(msSedesBk.getFlagvisiblerpte());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsSedes(MsSedesBk msSedesBk, MsSedes msSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (msSedesBk.getIdusserCrea() != null
							&& msSedes.getIdusserCrea() != null) {
						if (!msSedesBk.getIdusserCrea().equals(
								msSedes.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserCrea() + " :: "+ msSedesBk.getIdusserCrea());
								}
							cambios = true;
							msSedes.setIdusserCrea(msSedesBk.getIdusserCrea());
						}
					} else if (msSedesBk.getIdusserCrea() == null
							&& msSedes.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserCrea() + " :: "+ msSedesBk.getIdusserCrea());
								}
							cambios = true;
							msSedes.setIdusserCrea(msSedesBk.getIdusserCrea());
						
					} else if (msSedesBk.getIdusserCrea() != null
							&& msSedes.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserCrea() + " :: "+ msSedesBk.getIdusserCrea());
								}
							cambios = true;			
							msSedes.setIdusserCrea(msSedesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msSedesBk.getIdusserModif() != null
							&& msSedes.getIdusserModif() != null) {
						if (!msSedesBk.getIdusserModif().equals(
								msSedes.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserModif() + " :: "+ msSedesBk.getIdusserModif());
								}
							cambios = true;
							msSedes.setIdusserModif(msSedesBk.getIdusserModif());
						}
					} else if (msSedesBk.getIdusserModif() == null
							&& msSedes.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserModif() + " :: "+ msSedesBk.getIdusserModif());
								}
							cambios = true;
							msSedes.setIdusserModif(msSedesBk.getIdusserModif());
						
					} else if (msSedesBk.getIdusserModif() != null
							&& msSedes.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:IdusserModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getIdusserModif() + " :: "+ msSedesBk.getIdusserModif());
								}
							cambios = true;			
							msSedes.setIdusserModif(msSedesBk.getIdusserModif());
					}
                                
				                                 
                                      if (msSedesBk.getFechaCrea() != null
							&& msSedes.getFechaCrea() != null) {
						if (!msSedesBk.getFechaCrea().equals(
								msSedes.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaCrea() + " :: "+ msSedesBk.getFechaCrea());
								}
							cambios = true;
							msSedes.setFechaCrea(msSedesBk.getFechaCrea());
						}
					} else if (msSedesBk.getFechaCrea() == null
							&& msSedes.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaCrea() + " :: "+ msSedesBk.getFechaCrea());
								}
							cambios = true;
							msSedes.setFechaCrea(msSedesBk.getFechaCrea());
						
					} else if (msSedesBk.getFechaCrea() != null
							&& msSedes.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaCrea"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaCrea() + " :: "+ msSedesBk.getFechaCrea());
								}
							cambios = true;			
							msSedes.setFechaCrea(msSedesBk.getFechaCrea());
					}
                                
				                                 
                                      if (msSedesBk.getFechaModif() != null
							&& msSedes.getFechaModif() != null) {
						if (!msSedesBk.getFechaModif().equals(
								msSedes.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaModif() + " :: "+ msSedesBk.getFechaModif());
								}
							cambios = true;
							msSedes.setFechaModif(msSedesBk.getFechaModif());
						}
					} else if (msSedesBk.getFechaModif() == null
							&& msSedes.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaModif() + " :: "+ msSedesBk.getFechaModif());
								}
							cambios = true;
							msSedes.setFechaModif(msSedesBk.getFechaModif());
						
					} else if (msSedesBk.getFechaModif() != null
							&& msSedes.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:FechaModif"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getFechaModif() + " :: "+ msSedesBk.getFechaModif());
								}
							cambios = true;			
							msSedes.setFechaModif(msSedesBk.getFechaModif());
					}
                                
				
				
				
				
				                                 
                                      if (msSedesBk.getEstado() != null
							&& msSedes.getEstado() != null) {
						if (!msSedesBk.getEstado().equals(
								msSedes.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Estado"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getEstado() + " :: "+ msSedesBk.getEstado());
								}
							cambios = true;
							msSedes.setEstado(msSedesBk.getEstado());
						}
					} else if (msSedesBk.getEstado() == null
							&& msSedes.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Estado"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getEstado() + " :: "+ msSedesBk.getEstado());
								}
							cambios = true;
							msSedes.setEstado(msSedesBk.getEstado());
						
					} else if (msSedesBk.getEstado() != null
							&& msSedes.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Estado"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getEstado() + " :: "+ msSedesBk.getEstado());
								}
							cambios = true;			
							msSedes.setEstado(msSedesBk.getEstado());
					}
                                
				
				
				                                 
                                      if (msSedesBk.getRtmaddress() != null
							&& msSedes.getRtmaddress() != null) {
						if (!msSedesBk.getRtmaddress().equals(
								msSedes.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddress"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddress() + " :: "+ msSedesBk.getRtmaddress());
								}
							cambios = true;
							msSedes.setRtmaddress(msSedesBk.getRtmaddress());
						}
					} else if (msSedesBk.getRtmaddress() == null
							&& msSedes.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddress"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddress() + " :: "+ msSedesBk.getRtmaddress());
								}
							cambios = true;
							msSedes.setRtmaddress(msSedesBk.getRtmaddress());
						
					} else if (msSedesBk.getRtmaddress() != null
							&& msSedes.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddress"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddress() + " :: "+ msSedesBk.getRtmaddress());
								}
							cambios = true;			
							msSedes.setRtmaddress(msSedesBk.getRtmaddress());
					}
                                
				                                 
                                      if (msSedesBk.getRtmaddressrst() != null
							&& msSedes.getRtmaddressrst() != null) {
						if (!msSedesBk.getRtmaddressrst().equals(
								msSedes.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddressrst"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddressrst() + " :: "+ msSedesBk.getRtmaddressrst());
								}
							cambios = true;
							msSedes.setRtmaddressrst(msSedesBk.getRtmaddressrst());
						}
					} else if (msSedesBk.getRtmaddressrst() == null
							&& msSedes.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddressrst"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddressrst() + " :: "+ msSedesBk.getRtmaddressrst());
								}
							cambios = true;
							msSedes.setRtmaddressrst(msSedesBk.getRtmaddressrst());
						
					} else if (msSedesBk.getRtmaddressrst() != null
							&& msSedes.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSedes:Rtmaddressrst"+" :: "+msSedesBk.getIdSede().toString()+" :: "+ msSedes.getRtmaddressrst() + " :: "+ msSedesBk.getRtmaddressrst());
								}
							cambios = true;			
							msSedes.setRtmaddressrst(msSedesBk.getRtmaddressrst());
					}
                                
				
				
				
				
			
			return cambios;
	}
}