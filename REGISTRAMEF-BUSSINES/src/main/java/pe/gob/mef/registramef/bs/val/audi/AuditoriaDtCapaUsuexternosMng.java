package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapaUsuexternos;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapaUsuexternosBk;

/**
 * DT_CAPA_USUEXTERNOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACION "PARTICIPANTES EN LA CAPACITACIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapaUsuexternosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapaUsuexternosMng.class.getName());
	
	public static boolean auditarCambiosDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, DtCapaUsuexternos dtCapaUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapaUsuexternosBk.getIdCapacitacion() != null
							&& dtCapaUsuexternos.getIdCapacitacion() != null) {
						if (!dtCapaUsuexternosBk.getIdCapacitacion().equals(
								dtCapaUsuexternos.getIdCapacitacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCapacitacion"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCapacitacion() + " :: "+ dtCapaUsuexternosBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaUsuexternos.setIdCapacitacion(dtCapaUsuexternosBk.getIdCapacitacion());
						}
					} else if (dtCapaUsuexternosBk.getIdCapacitacion() == null
							&& dtCapaUsuexternos.getIdCapacitacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCapacitacion"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCapacitacion() + " :: "+ dtCapaUsuexternosBk.getIdCapacitacion());
								}
							cambios = true;
							dtCapaUsuexternos.setIdCapacitacion(dtCapaUsuexternosBk.getIdCapacitacion());
						
					} else if (dtCapaUsuexternosBk.getIdCapacitacion() != null
							&& dtCapaUsuexternos.getIdCapacitacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCapacitacion"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCapacitacion() + " :: "+ dtCapaUsuexternosBk.getIdCapacitacion());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdCapacitacion(dtCapaUsuexternosBk.getIdCapacitacion());
					}
				if (dtCapaUsuexternosBk.getIdUsuexterno() != null
							&& dtCapaUsuexternos.getIdUsuexterno() != null) {
						if (!dtCapaUsuexternosBk.getIdUsuexterno().equals(
								dtCapaUsuexternos.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdUsuexterno"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdUsuexterno() + " :: "+ dtCapaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtCapaUsuexternos.setIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());
						}
					} else if (dtCapaUsuexternosBk.getIdUsuexterno() == null
							&& dtCapaUsuexternos.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdUsuexterno"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdUsuexterno() + " :: "+ dtCapaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtCapaUsuexternos.setIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());
						
					} else if (dtCapaUsuexternosBk.getIdUsuexterno() != null
							&& dtCapaUsuexternos.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdUsuexterno"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdUsuexterno() + " :: "+ dtCapaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdUsuexterno(dtCapaUsuexternosBk.getIdUsuexterno());
					}
				if (dtCapaUsuexternosBk.getIdCargoUsuext() != null
							&& dtCapaUsuexternos.getIdCargoUsuext() != null) {
						if (!dtCapaUsuexternosBk.getIdCargoUsuext().equals(
								dtCapaUsuexternos.getIdCargoUsuext())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCargoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCargoUsuext() + " :: "+ dtCapaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtCapaUsuexternos.setIdCargoUsuext(dtCapaUsuexternosBk.getIdCargoUsuext());
						}
					} else if (dtCapaUsuexternosBk.getIdCargoUsuext() == null
							&& dtCapaUsuexternos.getIdCargoUsuext() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCargoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCargoUsuext() + " :: "+ dtCapaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtCapaUsuexternos.setIdCargoUsuext(dtCapaUsuexternosBk.getIdCargoUsuext());
						
					} else if (dtCapaUsuexternosBk.getIdCargoUsuext() != null
							&& dtCapaUsuexternos.getIdCargoUsuext() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdCargoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdCargoUsuext() + " :: "+ dtCapaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdCargoUsuext(dtCapaUsuexternosBk.getIdCargoUsuext());
					}
				if (dtCapaUsuexternosBk.getIdEntidad() != null
							&& dtCapaUsuexternos.getIdEntidad() != null) {
						if (!dtCapaUsuexternosBk.getIdEntidad().equals(
								dtCapaUsuexternos.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdEntidad"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdEntidad() + " :: "+ dtCapaUsuexternosBk.getIdEntidad());
								}
							cambios = true;
							dtCapaUsuexternos.setIdEntidad(dtCapaUsuexternosBk.getIdEntidad());
						}
					} else if (dtCapaUsuexternosBk.getIdEntidad() == null
							&& dtCapaUsuexternos.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdEntidad"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdEntidad() + " :: "+ dtCapaUsuexternosBk.getIdEntidad());
								}
							cambios = true;
							dtCapaUsuexternos.setIdEntidad(dtCapaUsuexternosBk.getIdEntidad());
						
					} else if (dtCapaUsuexternosBk.getIdEntidad() != null
							&& dtCapaUsuexternos.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdEntidad"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdEntidad() + " :: "+ dtCapaUsuexternosBk.getIdEntidad());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdEntidad(dtCapaUsuexternosBk.getIdEntidad());
					}
				 
		            if (dtCapaUsuexternosBk.getCorreoUsuext() != null
						&& dtCapaUsuexternos.getCorreoUsuext() != null) {
					if (!dtCapaUsuexternosBk.getCorreoUsuext().equals(
						dtCapaUsuexternos.getCorreoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CorreoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCorreoUsuext() + " :: "+ dtCapaUsuexternosBk.getCorreoUsuext());								
						}
						cambios = true;
						dtCapaUsuexternos.setCorreoUsuext(dtCapaUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtCapaUsuexternosBk.getCorreoUsuext() == null
						&& dtCapaUsuexternos.getCorreoUsuext() != null) {
					if (dtCapaUsuexternos.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CorreoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCorreoUsuext() + " :: "+ dtCapaUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setCorreoUsuext(dtCapaUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtCapaUsuexternosBk.getCorreoUsuext() != null
						&& dtCapaUsuexternos.getCorreoUsuext() == null) {
					if (dtCapaUsuexternosBk.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CorreoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCorreoUsuext() + " :: "+ dtCapaUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setCorreoUsuext(dtCapaUsuexternosBk.getCorreoUsuext());
					}
				}
				 
		            if (dtCapaUsuexternosBk.getFijoUsuext() != null
						&& dtCapaUsuexternos.getFijoUsuext() != null) {
					if (!dtCapaUsuexternosBk.getFijoUsuext().equals(
						dtCapaUsuexternos.getFijoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FijoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFijoUsuext() + " :: "+ dtCapaUsuexternosBk.getFijoUsuext());								
						}
						cambios = true;
						dtCapaUsuexternos.setFijoUsuext(dtCapaUsuexternosBk.getFijoUsuext());
					}
				} else if (dtCapaUsuexternosBk.getFijoUsuext() == null
						&& dtCapaUsuexternos.getFijoUsuext() != null) {
					if (dtCapaUsuexternos.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FijoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFijoUsuext() + " :: "+ dtCapaUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setFijoUsuext(dtCapaUsuexternosBk.getFijoUsuext());
					}
				} else if (dtCapaUsuexternosBk.getFijoUsuext() != null
						&& dtCapaUsuexternos.getFijoUsuext() == null) {
					if (dtCapaUsuexternosBk.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FijoUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFijoUsuext() + " :: "+ dtCapaUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setFijoUsuext(dtCapaUsuexternosBk.getFijoUsuext());
					}
				}
				 
		            if (dtCapaUsuexternosBk.getCelularUsuext() != null
						&& dtCapaUsuexternos.getCelularUsuext() != null) {
					if (!dtCapaUsuexternosBk.getCelularUsuext().equals(
						dtCapaUsuexternos.getCelularUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CelularUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCelularUsuext() + " :: "+ dtCapaUsuexternosBk.getCelularUsuext());								
						}
						cambios = true;
						dtCapaUsuexternos.setCelularUsuext(dtCapaUsuexternosBk.getCelularUsuext());
					}
				} else if (dtCapaUsuexternosBk.getCelularUsuext() == null
						&& dtCapaUsuexternos.getCelularUsuext() != null) {
					if (dtCapaUsuexternos.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CelularUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCelularUsuext() + " :: "+ dtCapaUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setCelularUsuext(dtCapaUsuexternosBk.getCelularUsuext());
					}
				} else if (dtCapaUsuexternosBk.getCelularUsuext() != null
						&& dtCapaUsuexternos.getCelularUsuext() == null) {
					if (dtCapaUsuexternosBk.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:CelularUsuext"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getCelularUsuext() + " :: "+ dtCapaUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtCapaUsuexternos.setCelularUsuext(dtCapaUsuexternosBk.getCelularUsuext());
					}
				}
				if (dtCapaUsuexternosBk.getFlagMedioreg() != null
							&& dtCapaUsuexternos.getFlagMedioreg() != null) {
						if (!dtCapaUsuexternosBk.getFlagMedioreg().equals(
								dtCapaUsuexternos.getFlagMedioreg())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagMedioreg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagMedioreg() + " :: "+ dtCapaUsuexternosBk.getFlagMedioreg());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagMedioreg(dtCapaUsuexternosBk.getFlagMedioreg());
						}
					} else if (dtCapaUsuexternosBk.getFlagMedioreg() == null
							&& dtCapaUsuexternos.getFlagMedioreg() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagMedioreg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagMedioreg() + " :: "+ dtCapaUsuexternosBk.getFlagMedioreg());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagMedioreg(dtCapaUsuexternosBk.getFlagMedioreg());
						
					} else if (dtCapaUsuexternosBk.getFlagMedioreg() != null
							&& dtCapaUsuexternos.getFlagMedioreg() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagMedioreg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagMedioreg() + " :: "+ dtCapaUsuexternosBk.getFlagMedioreg());
								}
							cambios = true;			
							dtCapaUsuexternos.setFlagMedioreg(dtCapaUsuexternosBk.getFlagMedioreg());
					}
				if (dtCapaUsuexternosBk.getFlagAsistencia() != null
							&& dtCapaUsuexternos.getFlagAsistencia() != null) {
						if (!dtCapaUsuexternosBk.getFlagAsistencia().equals(
								dtCapaUsuexternos.getFlagAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFlagAsistencia());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagAsistencia(dtCapaUsuexternosBk.getFlagAsistencia());
						}
					} else if (dtCapaUsuexternosBk.getFlagAsistencia() == null
							&& dtCapaUsuexternos.getFlagAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFlagAsistencia());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagAsistencia(dtCapaUsuexternosBk.getFlagAsistencia());
						
					} else if (dtCapaUsuexternosBk.getFlagAsistencia() != null
							&& dtCapaUsuexternos.getFlagAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFlagAsistencia());
								}
							cambios = true;			
							dtCapaUsuexternos.setFlagAsistencia(dtCapaUsuexternosBk.getFlagAsistencia());
					}
				if (dtCapaUsuexternosBk.getFlagConfirReg() != null
							&& dtCapaUsuexternos.getFlagConfirReg() != null) {
						if (!dtCapaUsuexternosBk.getFlagConfirReg().equals(
								dtCapaUsuexternos.getFlagConfirReg())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFlagConfirReg());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagConfirReg(dtCapaUsuexternosBk.getFlagConfirReg());
						}
					} else if (dtCapaUsuexternosBk.getFlagConfirReg() == null
							&& dtCapaUsuexternos.getFlagConfirReg() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFlagConfirReg());
								}
							cambios = true;
							dtCapaUsuexternos.setFlagConfirReg(dtCapaUsuexternosBk.getFlagConfirReg());
						
					} else if (dtCapaUsuexternosBk.getFlagConfirReg() != null
							&& dtCapaUsuexternos.getFlagConfirReg() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFlagConfirReg());
								}
							cambios = true;			
							dtCapaUsuexternos.setFlagConfirReg(dtCapaUsuexternosBk.getFlagConfirReg());
					}
				if (dtCapaUsuexternosBk.getFechaFlagConfirReg() != null
							&& dtCapaUsuexternos.getFechaFlagConfirReg() != null) {
						if (!dtCapaUsuexternosBk.getFechaFlagConfirReg().equals(
								dtCapaUsuexternos.getFechaFlagConfirReg())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFechaFlagConfirReg());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaFlagConfirReg(dtCapaUsuexternosBk.getFechaFlagConfirReg());
						}
					} else if (dtCapaUsuexternosBk.getFechaFlagConfirReg() == null
							&& dtCapaUsuexternos.getFechaFlagConfirReg() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFechaFlagConfirReg());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaFlagConfirReg(dtCapaUsuexternosBk.getFechaFlagConfirReg());
						
					} else if (dtCapaUsuexternosBk.getFechaFlagConfirReg() != null
							&& dtCapaUsuexternos.getFechaFlagConfirReg() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagConfirReg"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagConfirReg() + " :: "+ dtCapaUsuexternosBk.getFechaFlagConfirReg());
								}
							cambios = true;			
							dtCapaUsuexternos.setFechaFlagConfirReg(dtCapaUsuexternosBk.getFechaFlagConfirReg());
					}
				if (dtCapaUsuexternosBk.getFechaFlagAsistencia() != null
							&& dtCapaUsuexternos.getFechaFlagAsistencia() != null) {
						if (!dtCapaUsuexternosBk.getFechaFlagAsistencia().equals(
								dtCapaUsuexternos.getFechaFlagAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFechaFlagAsistencia());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaFlagAsistencia(dtCapaUsuexternosBk.getFechaFlagAsistencia());
						}
					} else if (dtCapaUsuexternosBk.getFechaFlagAsistencia() == null
							&& dtCapaUsuexternos.getFechaFlagAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFechaFlagAsistencia());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaFlagAsistencia(dtCapaUsuexternosBk.getFechaFlagAsistencia());
						
					} else if (dtCapaUsuexternosBk.getFechaFlagAsistencia() != null
							&& dtCapaUsuexternos.getFechaFlagAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaFlagAsistencia"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaFlagAsistencia() + " :: "+ dtCapaUsuexternosBk.getFechaFlagAsistencia());
								}
							cambios = true;			
							dtCapaUsuexternos.setFechaFlagAsistencia(dtCapaUsuexternosBk.getFechaFlagAsistencia());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapaUsuexternos(DtCapaUsuexternosBk dtCapaUsuexternosBk, DtCapaUsuexternos dtCapaUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtCapaUsuexternosBk.getIdusserCrea() != null
							&& dtCapaUsuexternos.getIdusserCrea() != null) {
						if (!dtCapaUsuexternosBk.getIdusserCrea().equals(
								dtCapaUsuexternos.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserCrea() + " :: "+ dtCapaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaUsuexternos.setIdusserCrea(dtCapaUsuexternosBk.getIdusserCrea());
						}
					} else if (dtCapaUsuexternosBk.getIdusserCrea() == null
							&& dtCapaUsuexternos.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserCrea() + " :: "+ dtCapaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtCapaUsuexternos.setIdusserCrea(dtCapaUsuexternosBk.getIdusserCrea());
						
					} else if (dtCapaUsuexternosBk.getIdusserCrea() != null
							&& dtCapaUsuexternos.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserCrea() + " :: "+ dtCapaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdusserCrea(dtCapaUsuexternosBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtCapaUsuexternosBk.getIdusserModif() != null
							&& dtCapaUsuexternos.getIdusserModif() != null) {
						if (!dtCapaUsuexternosBk.getIdusserModif().equals(
								dtCapaUsuexternos.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserModif() + " :: "+ dtCapaUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtCapaUsuexternos.setIdusserModif(dtCapaUsuexternosBk.getIdusserModif());
						}
					} else if (dtCapaUsuexternosBk.getIdusserModif() == null
							&& dtCapaUsuexternos.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserModif() + " :: "+ dtCapaUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtCapaUsuexternos.setIdusserModif(dtCapaUsuexternosBk.getIdusserModif());
						
					} else if (dtCapaUsuexternosBk.getIdusserModif() != null
							&& dtCapaUsuexternos.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:IdusserModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getIdusserModif() + " :: "+ dtCapaUsuexternosBk.getIdusserModif());
								}
							cambios = true;			
							dtCapaUsuexternos.setIdusserModif(dtCapaUsuexternosBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtCapaUsuexternosBk.getFechaCrea() != null
							&& dtCapaUsuexternos.getFechaCrea() != null) {
						if (!dtCapaUsuexternosBk.getFechaCrea().equals(
								dtCapaUsuexternos.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaCrea() + " :: "+ dtCapaUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaCrea(dtCapaUsuexternosBk.getFechaCrea());
						}
					} else if (dtCapaUsuexternosBk.getFechaCrea() == null
							&& dtCapaUsuexternos.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaCrea() + " :: "+ dtCapaUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaCrea(dtCapaUsuexternosBk.getFechaCrea());
						
					} else if (dtCapaUsuexternosBk.getFechaCrea() != null
							&& dtCapaUsuexternos.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaCrea"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaCrea() + " :: "+ dtCapaUsuexternosBk.getFechaCrea());
								}
							cambios = true;			
							dtCapaUsuexternos.setFechaCrea(dtCapaUsuexternosBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapaUsuexternosBk.getFechaModif() != null
							&& dtCapaUsuexternos.getFechaModif() != null) {
						if (!dtCapaUsuexternosBk.getFechaModif().equals(
								dtCapaUsuexternos.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaModif() + " :: "+ dtCapaUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaModif(dtCapaUsuexternosBk.getFechaModif());
						}
					} else if (dtCapaUsuexternosBk.getFechaModif() == null
							&& dtCapaUsuexternos.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaModif() + " :: "+ dtCapaUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtCapaUsuexternos.setFechaModif(dtCapaUsuexternosBk.getFechaModif());
						
					} else if (dtCapaUsuexternosBk.getFechaModif() != null
							&& dtCapaUsuexternos.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:FechaModif"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getFechaModif() + " :: "+ dtCapaUsuexternosBk.getFechaModif());
								}
							cambios = true;			
							dtCapaUsuexternos.setFechaModif(dtCapaUsuexternosBk.getFechaModif());
					}
                                
				
				                                 
                                      if (dtCapaUsuexternosBk.getEstado() != null
							&& dtCapaUsuexternos.getEstado() != null) {
						if (!dtCapaUsuexternosBk.getEstado().equals(
								dtCapaUsuexternos.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Estado"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getEstado() + " :: "+ dtCapaUsuexternosBk.getEstado());
								}
							cambios = true;
							dtCapaUsuexternos.setEstado(dtCapaUsuexternosBk.getEstado());
						}
					} else if (dtCapaUsuexternosBk.getEstado() == null
							&& dtCapaUsuexternos.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Estado"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getEstado() + " :: "+ dtCapaUsuexternosBk.getEstado());
								}
							cambios = true;
							dtCapaUsuexternos.setEstado(dtCapaUsuexternosBk.getEstado());
						
					} else if (dtCapaUsuexternosBk.getEstado() != null
							&& dtCapaUsuexternos.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Estado"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getEstado() + " :: "+ dtCapaUsuexternosBk.getEstado());
								}
							cambios = true;			
							dtCapaUsuexternos.setEstado(dtCapaUsuexternosBk.getEstado());
					}
                                
				                                 
                                      if (dtCapaUsuexternosBk.getRtmaddress() != null
							&& dtCapaUsuexternos.getRtmaddress() != null) {
						if (!dtCapaUsuexternosBk.getRtmaddress().equals(
								dtCapaUsuexternos.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddress"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddress() + " :: "+ dtCapaUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtCapaUsuexternos.setRtmaddress(dtCapaUsuexternosBk.getRtmaddress());
						}
					} else if (dtCapaUsuexternosBk.getRtmaddress() == null
							&& dtCapaUsuexternos.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddress"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddress() + " :: "+ dtCapaUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtCapaUsuexternos.setRtmaddress(dtCapaUsuexternosBk.getRtmaddress());
						
					} else if (dtCapaUsuexternosBk.getRtmaddress() != null
							&& dtCapaUsuexternos.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddress"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddress() + " :: "+ dtCapaUsuexternosBk.getRtmaddress());
								}
							cambios = true;			
							dtCapaUsuexternos.setRtmaddress(dtCapaUsuexternosBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapaUsuexternosBk.getRtmaddressrst() != null
							&& dtCapaUsuexternos.getRtmaddressrst() != null) {
						if (!dtCapaUsuexternosBk.getRtmaddressrst().equals(
								dtCapaUsuexternos.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddressrst"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddressrst() + " :: "+ dtCapaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaUsuexternos.setRtmaddressrst(dtCapaUsuexternosBk.getRtmaddressrst());
						}
					} else if (dtCapaUsuexternosBk.getRtmaddressrst() == null
							&& dtCapaUsuexternos.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddressrst"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddressrst() + " :: "+ dtCapaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapaUsuexternos.setRtmaddressrst(dtCapaUsuexternosBk.getRtmaddressrst());
						
					} else if (dtCapaUsuexternosBk.getRtmaddressrst() != null
							&& dtCapaUsuexternos.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapaUsuexternos:Rtmaddressrst"+" :: "+dtCapaUsuexternosBk.getIdCapaUsuext().toString()+" :: "+ dtCapaUsuexternos.getRtmaddressrst() + " :: "+ dtCapaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapaUsuexternos.setRtmaddressrst(dtCapaUsuexternosBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
				
				
				
				
				
				
			
			return cambios;
	}
}