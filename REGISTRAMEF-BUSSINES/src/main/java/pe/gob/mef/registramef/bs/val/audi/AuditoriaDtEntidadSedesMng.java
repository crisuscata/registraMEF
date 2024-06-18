package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEntidadSedes;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadSedesBk;

/**
 * DT_ENTIDAD_SEDES SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS DISTINTAS SEDES ASIGNADAS A LA ENTIDAD "SEDES ASIGNADAS A LA ENTIDAD"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEntidadSedesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEntidadSedesMng.class.getName());
	
	public static boolean auditarCambiosDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, DtEntidadSedes dtEntidadSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtEntidadSedesBk.getEstado() != null
							&& dtEntidadSedes.getEstado() != null) {
						if (!dtEntidadSedesBk.getEstado().equals(
								dtEntidadSedes.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Estado"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getEstado() + " :: "+ dtEntidadSedesBk.getEstado());
								}
							cambios = true;
							dtEntidadSedes.setEstado(dtEntidadSedesBk.getEstado());
						}
					} else if (dtEntidadSedesBk.getEstado() == null
							&& dtEntidadSedes.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Estado"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getEstado() + " :: "+ dtEntidadSedesBk.getEstado());
								}
							cambios = true;
							dtEntidadSedes.setEstado(dtEntidadSedesBk.getEstado());
						
					} else if (dtEntidadSedesBk.getEstado() != null
							&& dtEntidadSedes.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Estado"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getEstado() + " :: "+ dtEntidadSedesBk.getEstado());
								}
							cambios = true;			
							dtEntidadSedes.setEstado(dtEntidadSedesBk.getEstado());
					}
				if (dtEntidadSedesBk.getIdEntidad() != null
							&& dtEntidadSedes.getIdEntidad() != null) {
						if (!dtEntidadSedesBk.getIdEntidad().equals(
								dtEntidadSedes.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdEntidad"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdEntidad() + " :: "+ dtEntidadSedesBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadSedes.setIdEntidad(dtEntidadSedesBk.getIdEntidad());
						}
					} else if (dtEntidadSedesBk.getIdEntidad() == null
							&& dtEntidadSedes.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdEntidad"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdEntidad() + " :: "+ dtEntidadSedesBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadSedes.setIdEntidad(dtEntidadSedesBk.getIdEntidad());
						
					} else if (dtEntidadSedesBk.getIdEntidad() != null
							&& dtEntidadSedes.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdEntidad"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdEntidad() + " :: "+ dtEntidadSedesBk.getIdEntidad());
								}
							cambios = true;			
							dtEntidadSedes.setIdEntidad(dtEntidadSedesBk.getIdEntidad());
					}
				if (dtEntidadSedesBk.getIdSede() != null
							&& dtEntidadSedes.getIdSede() != null) {
						if (!dtEntidadSedesBk.getIdSede().equals(
								dtEntidadSedes.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdSede"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdSede() + " :: "+ dtEntidadSedesBk.getIdSede());
								}
							cambios = true;
							dtEntidadSedes.setIdSede(dtEntidadSedesBk.getIdSede());
						}
					} else if (dtEntidadSedesBk.getIdSede() == null
							&& dtEntidadSedes.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdSede"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdSede() + " :: "+ dtEntidadSedesBk.getIdSede());
								}
							cambios = true;
							dtEntidadSedes.setIdSede(dtEntidadSedesBk.getIdSede());
						
					} else if (dtEntidadSedesBk.getIdSede() != null
							&& dtEntidadSedes.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdSede"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdSede() + " :: "+ dtEntidadSedesBk.getIdSede());
								}
							cambios = true;			
							dtEntidadSedes.setIdSede(dtEntidadSedesBk.getIdSede());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtEntidadSedes(DtEntidadSedesBk dtEntidadSedesBk, DtEntidadSedes dtEntidadSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtEntidadSedesBk.getIdusserModif() != null
							&& dtEntidadSedes.getIdusserModif() != null) {
						if (!dtEntidadSedesBk.getIdusserModif().equals(
								dtEntidadSedes.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserModif() + " :: "+ dtEntidadSedesBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadSedes.setIdusserModif(dtEntidadSedesBk.getIdusserModif());
						}
					} else if (dtEntidadSedesBk.getIdusserModif() == null
							&& dtEntidadSedes.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserModif() + " :: "+ dtEntidadSedesBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadSedes.setIdusserModif(dtEntidadSedesBk.getIdusserModif());
						
					} else if (dtEntidadSedesBk.getIdusserModif() != null
							&& dtEntidadSedes.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserModif() + " :: "+ dtEntidadSedesBk.getIdusserModif());
								}
							cambios = true;			
							dtEntidadSedes.setIdusserModif(dtEntidadSedesBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEntidadSedesBk.getIdusserCrea() != null
							&& dtEntidadSedes.getIdusserCrea() != null) {
						if (!dtEntidadSedesBk.getIdusserCrea().equals(
								dtEntidadSedes.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserCrea() + " :: "+ dtEntidadSedesBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadSedes.setIdusserCrea(dtEntidadSedesBk.getIdusserCrea());
						}
					} else if (dtEntidadSedesBk.getIdusserCrea() == null
							&& dtEntidadSedes.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserCrea() + " :: "+ dtEntidadSedesBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadSedes.setIdusserCrea(dtEntidadSedesBk.getIdusserCrea());
						
					} else if (dtEntidadSedesBk.getIdusserCrea() != null
							&& dtEntidadSedes.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:IdusserCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getIdusserCrea() + " :: "+ dtEntidadSedesBk.getIdusserCrea());
								}
							cambios = true;			
							dtEntidadSedes.setIdusserCrea(dtEntidadSedesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEntidadSedesBk.getFechaCrea() != null
							&& dtEntidadSedes.getFechaCrea() != null) {
						if (!dtEntidadSedesBk.getFechaCrea().equals(
								dtEntidadSedes.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaCrea() + " :: "+ dtEntidadSedesBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadSedes.setFechaCrea(dtEntidadSedesBk.getFechaCrea());
						}
					} else if (dtEntidadSedesBk.getFechaCrea() == null
							&& dtEntidadSedes.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaCrea() + " :: "+ dtEntidadSedesBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadSedes.setFechaCrea(dtEntidadSedesBk.getFechaCrea());
						
					} else if (dtEntidadSedesBk.getFechaCrea() != null
							&& dtEntidadSedes.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaCrea"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaCrea() + " :: "+ dtEntidadSedesBk.getFechaCrea());
								}
							cambios = true;			
							dtEntidadSedes.setFechaCrea(dtEntidadSedesBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEntidadSedesBk.getFechaModif() != null
							&& dtEntidadSedes.getFechaModif() != null) {
						if (!dtEntidadSedesBk.getFechaModif().equals(
								dtEntidadSedes.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaModif() + " :: "+ dtEntidadSedesBk.getFechaModif());
								}
							cambios = true;
							dtEntidadSedes.setFechaModif(dtEntidadSedesBk.getFechaModif());
						}
					} else if (dtEntidadSedesBk.getFechaModif() == null
							&& dtEntidadSedes.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaModif() + " :: "+ dtEntidadSedesBk.getFechaModif());
								}
							cambios = true;
							dtEntidadSedes.setFechaModif(dtEntidadSedesBk.getFechaModif());
						
					} else if (dtEntidadSedesBk.getFechaModif() != null
							&& dtEntidadSedes.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:FechaModif"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getFechaModif() + " :: "+ dtEntidadSedesBk.getFechaModif());
								}
							cambios = true;			
							dtEntidadSedes.setFechaModif(dtEntidadSedesBk.getFechaModif());
					}
                                
				
				
				
				                                 
                                      if (dtEntidadSedesBk.getRtmaddress() != null
							&& dtEntidadSedes.getRtmaddress() != null) {
						if (!dtEntidadSedesBk.getRtmaddress().equals(
								dtEntidadSedes.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddress"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddress() + " :: "+ dtEntidadSedesBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadSedes.setRtmaddress(dtEntidadSedesBk.getRtmaddress());
						}
					} else if (dtEntidadSedesBk.getRtmaddress() == null
							&& dtEntidadSedes.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddress"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddress() + " :: "+ dtEntidadSedesBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadSedes.setRtmaddress(dtEntidadSedesBk.getRtmaddress());
						
					} else if (dtEntidadSedesBk.getRtmaddress() != null
							&& dtEntidadSedes.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddress"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddress() + " :: "+ dtEntidadSedesBk.getRtmaddress());
								}
							cambios = true;			
							dtEntidadSedes.setRtmaddress(dtEntidadSedesBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEntidadSedesBk.getRtmaddressrst() != null
							&& dtEntidadSedes.getRtmaddressrst() != null) {
						if (!dtEntidadSedesBk.getRtmaddressrst().equals(
								dtEntidadSedes.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddressrst"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddressrst() + " :: "+ dtEntidadSedesBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadSedes.setRtmaddressrst(dtEntidadSedesBk.getRtmaddressrst());
						}
					} else if (dtEntidadSedesBk.getRtmaddressrst() == null
							&& dtEntidadSedes.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddressrst"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddressrst() + " :: "+ dtEntidadSedesBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadSedes.setRtmaddressrst(dtEntidadSedesBk.getRtmaddressrst());
						
					} else if (dtEntidadSedesBk.getRtmaddressrst() != null
							&& dtEntidadSedes.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadSedes:Rtmaddressrst"+" :: "+dtEntidadSedesBk.getIdEntiSed().toString()+" :: "+ dtEntidadSedes.getRtmaddressrst() + " :: "+ dtEntidadSedesBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEntidadSedes.setRtmaddressrst(dtEntidadSedesBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}