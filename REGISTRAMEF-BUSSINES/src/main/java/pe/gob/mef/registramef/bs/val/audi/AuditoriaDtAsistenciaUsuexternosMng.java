package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAsistenciaUsuexternos;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaUsuexternosBk;

/**
 * DT_ASISTENCIA_USUEXTERNOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS USUARIOS QUE BRINDAN LA ATENCION EN LA ASISTENCIA TECNICA "USUARIOS QUE BRINDAN LA ATENCIÓN"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAsistenciaUsuexternosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAsistenciaUsuexternosMng.class.getName());
	
	public static boolean auditarCambiosDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, DtAsistenciaUsuexternos dtAsistenciaUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAsistenciaUsuexternosBk.getIdAsistencia() != null
							&& dtAsistenciaUsuexternos.getIdAsistencia() != null) {
						if (!dtAsistenciaUsuexternosBk.getIdAsistencia().equals(
								dtAsistenciaUsuexternos.getIdAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdAsistencia"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdAsistencia() + " :: "+ dtAsistenciaUsuexternosBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdAsistencia(dtAsistenciaUsuexternosBk.getIdAsistencia());
						}
					} else if (dtAsistenciaUsuexternosBk.getIdAsistencia() == null
							&& dtAsistenciaUsuexternos.getIdAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdAsistencia"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdAsistencia() + " :: "+ dtAsistenciaUsuexternosBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdAsistencia(dtAsistenciaUsuexternosBk.getIdAsistencia());
						
					} else if (dtAsistenciaUsuexternosBk.getIdAsistencia() != null
							&& dtAsistenciaUsuexternos.getIdAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdAsistencia"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdAsistencia() + " :: "+ dtAsistenciaUsuexternosBk.getIdAsistencia());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setIdAsistencia(dtAsistenciaUsuexternosBk.getIdAsistencia());
					}
				if (dtAsistenciaUsuexternosBk.getIdUsuexterno() != null
							&& dtAsistenciaUsuexternos.getIdUsuexterno() != null) {
						if (!dtAsistenciaUsuexternosBk.getIdUsuexterno().equals(
								dtAsistenciaUsuexternos.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdUsuexterno"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdUsuexterno() + " :: "+ dtAsistenciaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdUsuexterno(dtAsistenciaUsuexternosBk.getIdUsuexterno());
						}
					} else if (dtAsistenciaUsuexternosBk.getIdUsuexterno() == null
							&& dtAsistenciaUsuexternos.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdUsuexterno"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdUsuexterno() + " :: "+ dtAsistenciaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdUsuexterno(dtAsistenciaUsuexternosBk.getIdUsuexterno());
						
					} else if (dtAsistenciaUsuexternosBk.getIdUsuexterno() != null
							&& dtAsistenciaUsuexternos.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdUsuexterno"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdUsuexterno() + " :: "+ dtAsistenciaUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setIdUsuexterno(dtAsistenciaUsuexternosBk.getIdUsuexterno());
					}
				if (dtAsistenciaUsuexternosBk.getIdCargoUsuext() != null
							&& dtAsistenciaUsuexternos.getIdCargoUsuext() != null) {
						if (!dtAsistenciaUsuexternosBk.getIdCargoUsuext().equals(
								dtAsistenciaUsuexternos.getIdCargoUsuext())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdCargoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdCargoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdCargoUsuext(dtAsistenciaUsuexternosBk.getIdCargoUsuext());
						}
					} else if (dtAsistenciaUsuexternosBk.getIdCargoUsuext() == null
							&& dtAsistenciaUsuexternos.getIdCargoUsuext() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdCargoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdCargoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdCargoUsuext(dtAsistenciaUsuexternosBk.getIdCargoUsuext());
						
					} else if (dtAsistenciaUsuexternosBk.getIdCargoUsuext() != null
							&& dtAsistenciaUsuexternos.getIdCargoUsuext() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdCargoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdCargoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getIdCargoUsuext());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setIdCargoUsuext(dtAsistenciaUsuexternosBk.getIdCargoUsuext());
					}
				 
		            if (dtAsistenciaUsuexternosBk.getCorreoUsuext() != null
						&& dtAsistenciaUsuexternos.getCorreoUsuext() != null) {
					if (!dtAsistenciaUsuexternosBk.getCorreoUsuext().equals(
						dtAsistenciaUsuexternos.getCorreoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CorreoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCorreoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCorreoUsuext());								
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCorreoUsuext(dtAsistenciaUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getCorreoUsuext() == null
						&& dtAsistenciaUsuexternos.getCorreoUsuext() != null) {
					if (dtAsistenciaUsuexternos.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CorreoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCorreoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCorreoUsuext(dtAsistenciaUsuexternosBk.getCorreoUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getCorreoUsuext() != null
						&& dtAsistenciaUsuexternos.getCorreoUsuext() == null) {
					if (dtAsistenciaUsuexternosBk.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CorreoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCorreoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCorreoUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCorreoUsuext(dtAsistenciaUsuexternosBk.getCorreoUsuext());
					}
				}
				 
		            if (dtAsistenciaUsuexternosBk.getFijoUsuext() != null
						&& dtAsistenciaUsuexternos.getFijoUsuext() != null) {
					if (!dtAsistenciaUsuexternosBk.getFijoUsuext().equals(
						dtAsistenciaUsuexternos.getFijoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FijoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFijoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getFijoUsuext());								
						}
						cambios = true;
						dtAsistenciaUsuexternos.setFijoUsuext(dtAsistenciaUsuexternosBk.getFijoUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getFijoUsuext() == null
						&& dtAsistenciaUsuexternos.getFijoUsuext() != null) {
					if (dtAsistenciaUsuexternos.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FijoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFijoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setFijoUsuext(dtAsistenciaUsuexternosBk.getFijoUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getFijoUsuext() != null
						&& dtAsistenciaUsuexternos.getFijoUsuext() == null) {
					if (dtAsistenciaUsuexternosBk.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FijoUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFijoUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getFijoUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setFijoUsuext(dtAsistenciaUsuexternosBk.getFijoUsuext());
					}
				}
				 
		            if (dtAsistenciaUsuexternosBk.getCelularUsuext() != null
						&& dtAsistenciaUsuexternos.getCelularUsuext() != null) {
					if (!dtAsistenciaUsuexternosBk.getCelularUsuext().equals(
						dtAsistenciaUsuexternos.getCelularUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CelularUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCelularUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCelularUsuext());								
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCelularUsuext(dtAsistenciaUsuexternosBk.getCelularUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getCelularUsuext() == null
						&& dtAsistenciaUsuexternos.getCelularUsuext() != null) {
					if (dtAsistenciaUsuexternos.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CelularUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCelularUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCelularUsuext(dtAsistenciaUsuexternosBk.getCelularUsuext());
					}
				} else if (dtAsistenciaUsuexternosBk.getCelularUsuext() != null
						&& dtAsistenciaUsuexternos.getCelularUsuext() == null) {
					if (dtAsistenciaUsuexternosBk.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CelularUsuext"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCelularUsuext() + " :: "+ dtAsistenciaUsuexternosBk.getCelularUsuext());
						}
						cambios = true;
						dtAsistenciaUsuexternos.setCelularUsuext(dtAsistenciaUsuexternosBk.getCelularUsuext());
					}
				}
				if (dtAsistenciaUsuexternosBk.getCtrlConfirmacion() != null
							&& dtAsistenciaUsuexternos.getCtrlConfirmacion() != null) {
						if (!dtAsistenciaUsuexternosBk.getCtrlConfirmacion().equals(
								dtAsistenciaUsuexternos.getCtrlConfirmacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CtrlConfirmacion"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCtrlConfirmacion() + " :: "+ dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setCtrlConfirmacion(dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
						}
					} else if (dtAsistenciaUsuexternosBk.getCtrlConfirmacion() == null
							&& dtAsistenciaUsuexternos.getCtrlConfirmacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CtrlConfirmacion"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCtrlConfirmacion() + " :: "+ dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setCtrlConfirmacion(dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
						
					} else if (dtAsistenciaUsuexternosBk.getCtrlConfirmacion() != null
							&& dtAsistenciaUsuexternos.getCtrlConfirmacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:CtrlConfirmacion"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getCtrlConfirmacion() + " :: "+ dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setCtrlConfirmacion(dtAsistenciaUsuexternosBk.getCtrlConfirmacion());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAsistenciaUsuexternos(DtAsistenciaUsuexternosBk dtAsistenciaUsuexternosBk, DtAsistenciaUsuexternos dtAsistenciaUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtAsistenciaUsuexternosBk.getIdusserCrea() != null
							&& dtAsistenciaUsuexternos.getIdusserCrea() != null) {
						if (!dtAsistenciaUsuexternosBk.getIdusserCrea().equals(
								dtAsistenciaUsuexternos.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserCrea() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdusserCrea(dtAsistenciaUsuexternosBk.getIdusserCrea());
						}
					} else if (dtAsistenciaUsuexternosBk.getIdusserCrea() == null
							&& dtAsistenciaUsuexternos.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserCrea() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdusserCrea(dtAsistenciaUsuexternosBk.getIdusserCrea());
						
					} else if (dtAsistenciaUsuexternosBk.getIdusserCrea() != null
							&& dtAsistenciaUsuexternos.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserCrea() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserCrea());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setIdusserCrea(dtAsistenciaUsuexternosBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAsistenciaUsuexternosBk.getIdusserModif() != null
							&& dtAsistenciaUsuexternos.getIdusserModif() != null) {
						if (!dtAsistenciaUsuexternosBk.getIdusserModif().equals(
								dtAsistenciaUsuexternos.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserModif() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdusserModif(dtAsistenciaUsuexternosBk.getIdusserModif());
						}
					} else if (dtAsistenciaUsuexternosBk.getIdusserModif() == null
							&& dtAsistenciaUsuexternos.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserModif() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setIdusserModif(dtAsistenciaUsuexternosBk.getIdusserModif());
						
					} else if (dtAsistenciaUsuexternosBk.getIdusserModif() != null
							&& dtAsistenciaUsuexternos.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:IdusserModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getIdusserModif() + " :: "+ dtAsistenciaUsuexternosBk.getIdusserModif());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setIdusserModif(dtAsistenciaUsuexternosBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAsistenciaUsuexternosBk.getFechaCrea() != null
							&& dtAsistenciaUsuexternos.getFechaCrea() != null) {
						if (!dtAsistenciaUsuexternosBk.getFechaCrea().equals(
								dtAsistenciaUsuexternos.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaCrea() + " :: "+ dtAsistenciaUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setFechaCrea(dtAsistenciaUsuexternosBk.getFechaCrea());
						}
					} else if (dtAsistenciaUsuexternosBk.getFechaCrea() == null
							&& dtAsistenciaUsuexternos.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaCrea() + " :: "+ dtAsistenciaUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setFechaCrea(dtAsistenciaUsuexternosBk.getFechaCrea());
						
					} else if (dtAsistenciaUsuexternosBk.getFechaCrea() != null
							&& dtAsistenciaUsuexternos.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaCrea"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaCrea() + " :: "+ dtAsistenciaUsuexternosBk.getFechaCrea());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setFechaCrea(dtAsistenciaUsuexternosBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAsistenciaUsuexternosBk.getFechaModif() != null
							&& dtAsistenciaUsuexternos.getFechaModif() != null) {
						if (!dtAsistenciaUsuexternosBk.getFechaModif().equals(
								dtAsistenciaUsuexternos.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaModif() + " :: "+ dtAsistenciaUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setFechaModif(dtAsistenciaUsuexternosBk.getFechaModif());
						}
					} else if (dtAsistenciaUsuexternosBk.getFechaModif() == null
							&& dtAsistenciaUsuexternos.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaModif() + " :: "+ dtAsistenciaUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setFechaModif(dtAsistenciaUsuexternosBk.getFechaModif());
						
					} else if (dtAsistenciaUsuexternosBk.getFechaModif() != null
							&& dtAsistenciaUsuexternos.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:FechaModif"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getFechaModif() + " :: "+ dtAsistenciaUsuexternosBk.getFechaModif());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setFechaModif(dtAsistenciaUsuexternosBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtAsistenciaUsuexternosBk.getEstado() != null
							&& dtAsistenciaUsuexternos.getEstado() != null) {
						if (!dtAsistenciaUsuexternosBk.getEstado().equals(
								dtAsistenciaUsuexternos.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Estado"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getEstado() + " :: "+ dtAsistenciaUsuexternosBk.getEstado());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setEstado(dtAsistenciaUsuexternosBk.getEstado());
						}
					} else if (dtAsistenciaUsuexternosBk.getEstado() == null
							&& dtAsistenciaUsuexternos.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Estado"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getEstado() + " :: "+ dtAsistenciaUsuexternosBk.getEstado());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setEstado(dtAsistenciaUsuexternosBk.getEstado());
						
					} else if (dtAsistenciaUsuexternosBk.getEstado() != null
							&& dtAsistenciaUsuexternos.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Estado"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getEstado() + " :: "+ dtAsistenciaUsuexternosBk.getEstado());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setEstado(dtAsistenciaUsuexternosBk.getEstado());
					}
                                
				                                 
                                      if (dtAsistenciaUsuexternosBk.getRtmaddress() != null
							&& dtAsistenciaUsuexternos.getRtmaddress() != null) {
						if (!dtAsistenciaUsuexternosBk.getRtmaddress().equals(
								dtAsistenciaUsuexternos.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddress"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddress() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setRtmaddress(dtAsistenciaUsuexternosBk.getRtmaddress());
						}
					} else if (dtAsistenciaUsuexternosBk.getRtmaddress() == null
							&& dtAsistenciaUsuexternos.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddress"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddress() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setRtmaddress(dtAsistenciaUsuexternosBk.getRtmaddress());
						
					} else if (dtAsistenciaUsuexternosBk.getRtmaddress() != null
							&& dtAsistenciaUsuexternos.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddress"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddress() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddress());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setRtmaddress(dtAsistenciaUsuexternosBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAsistenciaUsuexternosBk.getRtmaddressrst() != null
							&& dtAsistenciaUsuexternos.getRtmaddressrst() != null) {
						if (!dtAsistenciaUsuexternosBk.getRtmaddressrst().equals(
								dtAsistenciaUsuexternos.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddressrst"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddressrst() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setRtmaddressrst(dtAsistenciaUsuexternosBk.getRtmaddressrst());
						}
					} else if (dtAsistenciaUsuexternosBk.getRtmaddressrst() == null
							&& dtAsistenciaUsuexternos.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddressrst"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddressrst() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaUsuexternos.setRtmaddressrst(dtAsistenciaUsuexternosBk.getRtmaddressrst());
						
					} else if (dtAsistenciaUsuexternosBk.getRtmaddressrst() != null
							&& dtAsistenciaUsuexternos.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaUsuexternos:Rtmaddressrst"+" :: "+dtAsistenciaUsuexternosBk.getIdAsistUsuext().toString()+" :: "+ dtAsistenciaUsuexternos.getRtmaddressrst() + " :: "+ dtAsistenciaUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAsistenciaUsuexternos.setRtmaddressrst(dtAsistenciaUsuexternosBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
			
			return cambios;
	}
}