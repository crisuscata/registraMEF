package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEntidades;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;

/**
 * DT_ENTIDADES SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS ENTIDAD REGISTRADAS EN EL SISTEMA "ENTIDADES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEntidadesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEntidadesMng.class.getName());
	
	public static boolean auditarCambiosDtEntidades(DtEntidadesBk dtEntidadesBk, DtEntidades dtEntidades, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (dtEntidadesBk.getCodEjec() != null
						&& dtEntidades.getCodEjec() != null) {
					if (!dtEntidadesBk.getCodEjec().equals(
						dtEntidades.getCodEjec())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodEjec"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodEjec() + " :: "+ dtEntidadesBk.getCodEjec());								
						}
						cambios = true;
						dtEntidades.setCodEjec(dtEntidadesBk.getCodEjec());
					}
				} else if (dtEntidadesBk.getCodEjec() == null
						&& dtEntidades.getCodEjec() != null) {
					if (dtEntidades.getCodEjec().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodEjec"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodEjec() + " :: "+ dtEntidadesBk.getCodEjec());
						}
						cambios = true;
						dtEntidades.setCodEjec(dtEntidadesBk.getCodEjec());
					}
				} else if (dtEntidadesBk.getCodEjec() != null
						&& dtEntidades.getCodEjec() == null) {
					if (dtEntidadesBk.getCodEjec().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodEjec"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodEjec() + " :: "+ dtEntidadesBk.getCodEjec());
						}
						cambios = true;
						dtEntidades.setCodEjec(dtEntidadesBk.getCodEjec());
					}
				}
				 
		            if (dtEntidadesBk.getRazSocial() != null
						&& dtEntidades.getRazSocial() != null) {
					if (!dtEntidadesBk.getRazSocial().equals(
						dtEntidades.getRazSocial())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:RazSocial"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRazSocial() + " :: "+ dtEntidadesBk.getRazSocial());								
						}
						cambios = true;
						dtEntidades.setRazSocial(dtEntidadesBk.getRazSocial());
					}
				} else if (dtEntidadesBk.getRazSocial() == null
						&& dtEntidades.getRazSocial() != null) {
					if (dtEntidades.getRazSocial().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:RazSocial"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRazSocial() + " :: "+ dtEntidadesBk.getRazSocial());
						}
						cambios = true;
						dtEntidades.setRazSocial(dtEntidadesBk.getRazSocial());
					}
				} else if (dtEntidadesBk.getRazSocial() != null
						&& dtEntidades.getRazSocial() == null) {
					if (dtEntidadesBk.getRazSocial().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:RazSocial"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRazSocial() + " :: "+ dtEntidadesBk.getRazSocial());
						}
						cambios = true;
						dtEntidades.setRazSocial(dtEntidadesBk.getRazSocial());
					}
				}
				if (dtEntidadesBk.getDireccion() != null
							&& dtEntidades.getDireccion() != null) {
						if (!dtEntidadesBk.getDireccion().equals(
								dtEntidades.getDireccion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Direccion"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getDireccion() + " :: "+ dtEntidadesBk.getDireccion());
								}
							cambios = true;
							dtEntidades.setDireccion(dtEntidadesBk.getDireccion());
						}
					} else if (dtEntidadesBk.getDireccion() == null
							&& dtEntidades.getDireccion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Direccion"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getDireccion() + " :: "+ dtEntidadesBk.getDireccion());
								}
							cambios = true;
							dtEntidades.setDireccion(dtEntidadesBk.getDireccion());
						
					} else if (dtEntidadesBk.getDireccion() != null
							&& dtEntidades.getDireccion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Direccion"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getDireccion() + " :: "+ dtEntidadesBk.getDireccion());
								}
							cambios = true;			
							dtEntidades.setDireccion(dtEntidadesBk.getDireccion());
					}
				if (dtEntidadesBk.getRuc() != null
							&& dtEntidades.getRuc() != null) {
						if (!dtEntidadesBk.getRuc().equals(
								dtEntidades.getRuc())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Ruc"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRuc() + " :: "+ dtEntidadesBk.getRuc());
								}
							cambios = true;
							dtEntidades.setRuc(dtEntidadesBk.getRuc());
						}
					} else if (dtEntidadesBk.getRuc() == null
							&& dtEntidades.getRuc() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Ruc"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRuc() + " :: "+ dtEntidadesBk.getRuc());
								}
							cambios = true;
							dtEntidades.setRuc(dtEntidadesBk.getRuc());
						
					} else if (dtEntidadesBk.getRuc() != null
							&& dtEntidades.getRuc() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Ruc"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRuc() + " :: "+ dtEntidadesBk.getRuc());
								}
							cambios = true;			
							dtEntidades.setRuc(dtEntidadesBk.getRuc());
					}
				if (dtEntidadesBk.getIdTipo() != null
							&& dtEntidades.getIdTipo() != null) {
						if (!dtEntidadesBk.getIdTipo().equals(
								dtEntidades.getIdTipo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdTipo"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdTipo() + " :: "+ dtEntidadesBk.getIdTipo());
								}
							cambios = true;
							dtEntidades.setIdTipo(dtEntidadesBk.getIdTipo());
						}
					} else if (dtEntidadesBk.getIdTipo() == null
							&& dtEntidades.getIdTipo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdTipo"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdTipo() + " :: "+ dtEntidadesBk.getIdTipo());
								}
							cambios = true;
							dtEntidades.setIdTipo(dtEntidadesBk.getIdTipo());
						
					} else if (dtEntidadesBk.getIdTipo() != null
							&& dtEntidades.getIdTipo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdTipo"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdTipo() + " :: "+ dtEntidadesBk.getIdTipo());
								}
							cambios = true;			
							dtEntidades.setIdTipo(dtEntidadesBk.getIdTipo());
					}
				if (dtEntidadesBk.getIdCaract() != null
							&& dtEntidades.getIdCaract() != null) {
						if (!dtEntidadesBk.getIdCaract().equals(
								dtEntidades.getIdCaract())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdCaract"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdCaract() + " :: "+ dtEntidadesBk.getIdCaract());
								}
							cambios = true;
							dtEntidades.setIdCaract(dtEntidadesBk.getIdCaract());
						}
					} else if (dtEntidadesBk.getIdCaract() == null
							&& dtEntidades.getIdCaract() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdCaract"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdCaract() + " :: "+ dtEntidadesBk.getIdCaract());
								}
							cambios = true;
							dtEntidades.setIdCaract(dtEntidadesBk.getIdCaract());
						
					} else if (dtEntidadesBk.getIdCaract() != null
							&& dtEntidades.getIdCaract() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdCaract"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdCaract() + " :: "+ dtEntidadesBk.getIdCaract());
								}
							cambios = true;			
							dtEntidades.setIdCaract(dtEntidadesBk.getIdCaract());
					}
				if (dtEntidadesBk.getCodDpto() != null
							&& dtEntidades.getCodDpto() != null) {
						if (!dtEntidadesBk.getCodDpto().equals(
								dtEntidades.getCodDpto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDpto"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDpto() + " :: "+ dtEntidadesBk.getCodDpto());
								}
							cambios = true;
							dtEntidades.setCodDpto(dtEntidadesBk.getCodDpto());
						}
					} else if (dtEntidadesBk.getCodDpto() == null
							&& dtEntidades.getCodDpto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDpto"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDpto() + " :: "+ dtEntidadesBk.getCodDpto());
								}
							cambios = true;
							dtEntidades.setCodDpto(dtEntidadesBk.getCodDpto());
						
					} else if (dtEntidadesBk.getCodDpto() != null
							&& dtEntidades.getCodDpto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDpto"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDpto() + " :: "+ dtEntidadesBk.getCodDpto());
								}
							cambios = true;			
							dtEntidades.setCodDpto(dtEntidadesBk.getCodDpto());
					}
				if (dtEntidadesBk.getCodProv() != null
							&& dtEntidades.getCodProv() != null) {
						if (!dtEntidadesBk.getCodProv().equals(
								dtEntidades.getCodProv())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodProv"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodProv() + " :: "+ dtEntidadesBk.getCodProv());
								}
							cambios = true;
							dtEntidades.setCodProv(dtEntidadesBk.getCodProv());
						}
					} else if (dtEntidadesBk.getCodProv() == null
							&& dtEntidades.getCodProv() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodProv"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodProv() + " :: "+ dtEntidadesBk.getCodProv());
								}
							cambios = true;
							dtEntidades.setCodProv(dtEntidadesBk.getCodProv());
						
					} else if (dtEntidadesBk.getCodProv() != null
							&& dtEntidades.getCodProv() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodProv"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodProv() + " :: "+ dtEntidadesBk.getCodProv());
								}
							cambios = true;			
							dtEntidades.setCodProv(dtEntidadesBk.getCodProv());
					}
				if (dtEntidadesBk.getCodDistr() != null
							&& dtEntidades.getCodDistr() != null) {
						if (!dtEntidadesBk.getCodDistr().equals(
								dtEntidades.getCodDistr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDistr"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDistr() + " :: "+ dtEntidadesBk.getCodDistr());
								}
							cambios = true;
							dtEntidades.setCodDistr(dtEntidadesBk.getCodDistr());
						}
					} else if (dtEntidadesBk.getCodDistr() == null
							&& dtEntidades.getCodDistr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDistr"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDistr() + " :: "+ dtEntidadesBk.getCodDistr());
								}
							cambios = true;
							dtEntidades.setCodDistr(dtEntidadesBk.getCodDistr());
						
					} else if (dtEntidadesBk.getCodDistr() != null
							&& dtEntidades.getCodDistr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:CodDistr"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getCodDistr() + " :: "+ dtEntidadesBk.getCodDistr());
								}
							cambios = true;			
							dtEntidades.setCodDistr(dtEntidadesBk.getCodDistr());
					}
				if (dtEntidadesBk.getIdpais() != null
							&& dtEntidades.getIdpais() != null) {
						if (!dtEntidadesBk.getIdpais().equals(
								dtEntidades.getIdpais())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Idpais"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdpais() + " :: "+ dtEntidadesBk.getIdpais());
								}
							cambios = true;
							dtEntidades.setIdpais(dtEntidadesBk.getIdpais());
						}
					} else if (dtEntidadesBk.getIdpais() == null
							&& dtEntidades.getIdpais() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Idpais"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdpais() + " :: "+ dtEntidadesBk.getIdpais());
								}
							cambios = true;
							dtEntidades.setIdpais(dtEntidadesBk.getIdpais());
						
					} else if (dtEntidadesBk.getIdpais() != null
							&& dtEntidades.getIdpais() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Idpais"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdpais() + " :: "+ dtEntidadesBk.getIdpais());
								}
							cambios = true;			
							dtEntidades.setIdpais(dtEntidadesBk.getIdpais());
					}
				if (dtEntidadesBk.getIdSistAdmi() != null
							&& dtEntidades.getIdSistAdmi() != null) {
						if (!dtEntidadesBk.getIdSistAdmi().equals(
								dtEntidades.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdSistAdmi"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdSistAdmi() + " :: "+ dtEntidadesBk.getIdSistAdmi());
								}
							cambios = true;
							dtEntidades.setIdSistAdmi(dtEntidadesBk.getIdSistAdmi());
						}
					} else if (dtEntidadesBk.getIdSistAdmi() == null
							&& dtEntidades.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdSistAdmi"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdSistAdmi() + " :: "+ dtEntidadesBk.getIdSistAdmi());
								}
							cambios = true;
							dtEntidades.setIdSistAdmi(dtEntidadesBk.getIdSistAdmi());
						
					} else if (dtEntidadesBk.getIdSistAdmi() != null
							&& dtEntidades.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdSistAdmi"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdSistAdmi() + " :: "+ dtEntidadesBk.getIdSistAdmi());
								}
							cambios = true;			
							dtEntidades.setIdSistAdmi(dtEntidadesBk.getIdSistAdmi());
					}
				if (dtEntidadesBk.getGeozona() != null
							&& dtEntidades.getGeozona() != null) {
						if (!dtEntidadesBk.getGeozona().equals(
								dtEntidades.getGeozona())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Geozona"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getGeozona() + " :: "+ dtEntidadesBk.getGeozona());
								}
							cambios = true;
							dtEntidades.setGeozona(dtEntidadesBk.getGeozona());
						}
					} else if (dtEntidadesBk.getGeozona() == null
							&& dtEntidades.getGeozona() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Geozona"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getGeozona() + " :: "+ dtEntidadesBk.getGeozona());
								}
							cambios = true;
							dtEntidades.setGeozona(dtEntidadesBk.getGeozona());
						
					} else if (dtEntidadesBk.getGeozona() != null
							&& dtEntidades.getGeozona() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Geozona"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getGeozona() + " :: "+ dtEntidadesBk.getGeozona());
								}
							cambios = true;			
							dtEntidades.setGeozona(dtEntidadesBk.getGeozona());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtEntidades(DtEntidadesBk dtEntidadesBk, DtEntidades dtEntidades, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtEntidadesBk.getIdusserCrea() != null
							&& dtEntidades.getIdusserCrea() != null) {
						if (!dtEntidadesBk.getIdusserCrea().equals(
								dtEntidades.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserCrea() + " :: "+ dtEntidadesBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidades.setIdusserCrea(dtEntidadesBk.getIdusserCrea());
						}
					} else if (dtEntidadesBk.getIdusserCrea() == null
							&& dtEntidades.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserCrea() + " :: "+ dtEntidadesBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidades.setIdusserCrea(dtEntidadesBk.getIdusserCrea());
						
					} else if (dtEntidadesBk.getIdusserCrea() != null
							&& dtEntidades.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserCrea() + " :: "+ dtEntidadesBk.getIdusserCrea());
								}
							cambios = true;			
							dtEntidades.setIdusserCrea(dtEntidadesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEntidadesBk.getIdusserModif() != null
							&& dtEntidades.getIdusserModif() != null) {
						if (!dtEntidadesBk.getIdusserModif().equals(
								dtEntidades.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserModif() + " :: "+ dtEntidadesBk.getIdusserModif());
								}
							cambios = true;
							dtEntidades.setIdusserModif(dtEntidadesBk.getIdusserModif());
						}
					} else if (dtEntidadesBk.getIdusserModif() == null
							&& dtEntidades.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserModif() + " :: "+ dtEntidadesBk.getIdusserModif());
								}
							cambios = true;
							dtEntidades.setIdusserModif(dtEntidadesBk.getIdusserModif());
						
					} else if (dtEntidadesBk.getIdusserModif() != null
							&& dtEntidades.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:IdusserModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getIdusserModif() + " :: "+ dtEntidadesBk.getIdusserModif());
								}
							cambios = true;			
							dtEntidades.setIdusserModif(dtEntidadesBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEntidadesBk.getFechaCrea() != null
							&& dtEntidades.getFechaCrea() != null) {
						if (!dtEntidadesBk.getFechaCrea().equals(
								dtEntidades.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaCrea() + " :: "+ dtEntidadesBk.getFechaCrea());
								}
							cambios = true;
							dtEntidades.setFechaCrea(dtEntidadesBk.getFechaCrea());
						}
					} else if (dtEntidadesBk.getFechaCrea() == null
							&& dtEntidades.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaCrea() + " :: "+ dtEntidadesBk.getFechaCrea());
								}
							cambios = true;
							dtEntidades.setFechaCrea(dtEntidadesBk.getFechaCrea());
						
					} else if (dtEntidadesBk.getFechaCrea() != null
							&& dtEntidades.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaCrea"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaCrea() + " :: "+ dtEntidadesBk.getFechaCrea());
								}
							cambios = true;			
							dtEntidades.setFechaCrea(dtEntidadesBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEntidadesBk.getFechaModif() != null
							&& dtEntidades.getFechaModif() != null) {
						if (!dtEntidadesBk.getFechaModif().equals(
								dtEntidades.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaModif() + " :: "+ dtEntidadesBk.getFechaModif());
								}
							cambios = true;
							dtEntidades.setFechaModif(dtEntidadesBk.getFechaModif());
						}
					} else if (dtEntidadesBk.getFechaModif() == null
							&& dtEntidades.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaModif() + " :: "+ dtEntidadesBk.getFechaModif());
								}
							cambios = true;
							dtEntidades.setFechaModif(dtEntidadesBk.getFechaModif());
						
					} else if (dtEntidadesBk.getFechaModif() != null
							&& dtEntidades.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:FechaModif"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getFechaModif() + " :: "+ dtEntidadesBk.getFechaModif());
								}
							cambios = true;			
							dtEntidades.setFechaModif(dtEntidadesBk.getFechaModif());
					}
                                
				
				                                 
                                      if (dtEntidadesBk.getEstado() != null
							&& dtEntidades.getEstado() != null) {
						if (!dtEntidadesBk.getEstado().equals(
								dtEntidades.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Estado"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getEstado() + " :: "+ dtEntidadesBk.getEstado());
								}
							cambios = true;
							dtEntidades.setEstado(dtEntidadesBk.getEstado());
						}
					} else if (dtEntidadesBk.getEstado() == null
							&& dtEntidades.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Estado"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getEstado() + " :: "+ dtEntidadesBk.getEstado());
								}
							cambios = true;
							dtEntidades.setEstado(dtEntidadesBk.getEstado());
						
					} else if (dtEntidadesBk.getEstado() != null
							&& dtEntidades.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Estado"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getEstado() + " :: "+ dtEntidadesBk.getEstado());
								}
							cambios = true;			
							dtEntidades.setEstado(dtEntidadesBk.getEstado());
					}
                                
				
				
				
				
				
				
				
				                                 
                                      if (dtEntidadesBk.getRtmaddress() != null
							&& dtEntidades.getRtmaddress() != null) {
						if (!dtEntidadesBk.getRtmaddress().equals(
								dtEntidades.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddress"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddress() + " :: "+ dtEntidadesBk.getRtmaddress());
								}
							cambios = true;
							dtEntidades.setRtmaddress(dtEntidadesBk.getRtmaddress());
						}
					} else if (dtEntidadesBk.getRtmaddress() == null
							&& dtEntidades.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddress"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddress() + " :: "+ dtEntidadesBk.getRtmaddress());
								}
							cambios = true;
							dtEntidades.setRtmaddress(dtEntidadesBk.getRtmaddress());
						
					} else if (dtEntidadesBk.getRtmaddress() != null
							&& dtEntidades.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddress"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddress() + " :: "+ dtEntidadesBk.getRtmaddress());
								}
							cambios = true;			
							dtEntidades.setRtmaddress(dtEntidadesBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEntidadesBk.getRtmaddressrst() != null
							&& dtEntidades.getRtmaddressrst() != null) {
						if (!dtEntidadesBk.getRtmaddressrst().equals(
								dtEntidades.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddressrst"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddressrst() + " :: "+ dtEntidadesBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidades.setRtmaddressrst(dtEntidadesBk.getRtmaddressrst());
						}
					} else if (dtEntidadesBk.getRtmaddressrst() == null
							&& dtEntidades.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddressrst"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddressrst() + " :: "+ dtEntidadesBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidades.setRtmaddressrst(dtEntidadesBk.getRtmaddressrst());
						
					} else if (dtEntidadesBk.getRtmaddressrst() != null
							&& dtEntidades.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidades:Rtmaddressrst"+" :: "+dtEntidadesBk.getIdEntidad().toString()+" :: "+ dtEntidades.getRtmaddressrst() + " :: "+ dtEntidadesBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEntidades.setRtmaddressrst(dtEntidadesBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}