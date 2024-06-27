package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAsistencia;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaBk;

/**
 * DT_ASISTENCIA SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA "ASISTENCIA TÉCNICA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAsistenciaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAsistenciaMng.class.getName());
	
	public static boolean auditarCambiosDtAsistencia(DtAsistenciaBk dtAsistenciaBk, DtAsistencia dtAsistencia, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAsistenciaBk.getFechaAsistencia() != null
							&& dtAsistencia.getFechaAsistencia() != null) {
						if (!dtAsistenciaBk.getFechaAsistencia().equals(
								dtAsistencia.getFechaAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaAsistencia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaAsistencia() + " :: "+ dtAsistenciaBk.getFechaAsistencia());
								}
							cambios = true;
							dtAsistencia.setFechaAsistencia(dtAsistenciaBk.getFechaAsistencia());
						}
					} else if (dtAsistenciaBk.getFechaAsistencia() == null
							&& dtAsistencia.getFechaAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaAsistencia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaAsistencia() + " :: "+ dtAsistenciaBk.getFechaAsistencia());
								}
							cambios = true;
							dtAsistencia.setFechaAsistencia(dtAsistenciaBk.getFechaAsistencia());
						
					} else if (dtAsistenciaBk.getFechaAsistencia() != null
							&& dtAsistencia.getFechaAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaAsistencia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaAsistencia() + " :: "+ dtAsistenciaBk.getFechaAsistencia());
								}
							cambios = true;			
							dtAsistencia.setFechaAsistencia(dtAsistenciaBk.getFechaAsistencia());
					}
				 
		            if (dtAsistenciaBk.getDetalle() != null
						&& dtAsistencia.getDetalle() != null) {
					if (!dtAsistenciaBk.getDetalle().equals(
						dtAsistencia.getDetalle())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Detalle"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getDetalle() + " :: "+ dtAsistenciaBk.getDetalle());								
						}
						cambios = true;
						dtAsistencia.setDetalle(dtAsistenciaBk.getDetalle());
					}
				} else if (dtAsistenciaBk.getDetalle() == null
						&& dtAsistencia.getDetalle() != null) {
					if (dtAsistencia.getDetalle().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Detalle"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getDetalle() + " :: "+ dtAsistenciaBk.getDetalle());
						}
						cambios = true;
						dtAsistencia.setDetalle(dtAsistenciaBk.getDetalle());
					}
				} else if (dtAsistenciaBk.getDetalle() != null
						&& dtAsistencia.getDetalle() == null) {
					if (dtAsistenciaBk.getDetalle().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Detalle"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getDetalle() + " :: "+ dtAsistenciaBk.getDetalle());
						}
						cambios = true;
						dtAsistencia.setDetalle(dtAsistenciaBk.getDetalle());
					}
				}
				if (dtAsistenciaBk.getIdUsuinterno() != null
							&& dtAsistencia.getIdUsuinterno() != null) {
						if (!dtAsistenciaBk.getIdUsuinterno().equals(
								dtAsistencia.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdUsuinterno"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdUsuinterno() + " :: "+ dtAsistenciaBk.getIdUsuinterno());
								}
							cambios = true;
							dtAsistencia.setIdUsuinterno(dtAsistenciaBk.getIdUsuinterno());
						}
					} else if (dtAsistenciaBk.getIdUsuinterno() == null
							&& dtAsistencia.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdUsuinterno"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdUsuinterno() + " :: "+ dtAsistenciaBk.getIdUsuinterno());
								}
							cambios = true;
							dtAsistencia.setIdUsuinterno(dtAsistenciaBk.getIdUsuinterno());
						
					} else if (dtAsistenciaBk.getIdUsuinterno() != null
							&& dtAsistencia.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdUsuinterno"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdUsuinterno() + " :: "+ dtAsistenciaBk.getIdUsuinterno());
								}
							cambios = true;			
							dtAsistencia.setIdUsuinterno(dtAsistenciaBk.getIdUsuinterno());
					}
				if (dtAsistenciaBk.getIdEntidad() != null
							&& dtAsistencia.getIdEntidad() != null) {
						if (!dtAsistenciaBk.getIdEntidad().equals(
								dtAsistencia.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdEntidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdEntidad() + " :: "+ dtAsistenciaBk.getIdEntidad());
								}
							cambios = true;
							dtAsistencia.setIdEntidad(dtAsistenciaBk.getIdEntidad());
						}
					} else if (dtAsistenciaBk.getIdEntidad() == null
							&& dtAsistencia.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdEntidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdEntidad() + " :: "+ dtAsistenciaBk.getIdEntidad());
								}
							cambios = true;
							dtAsistencia.setIdEntidad(dtAsistenciaBk.getIdEntidad());
						
					} else if (dtAsistenciaBk.getIdEntidad() != null
							&& dtAsistencia.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdEntidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdEntidad() + " :: "+ dtAsistenciaBk.getIdEntidad());
								}
							cambios = true;			
							dtAsistencia.setIdEntidad(dtAsistenciaBk.getIdEntidad());
					}
				if (dtAsistenciaBk.getIdOrigen() != null
							&& dtAsistencia.getIdOrigen() != null) {
						if (!dtAsistenciaBk.getIdOrigen().equals(
								dtAsistencia.getIdOrigen())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdOrigen"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdOrigen() + " :: "+ dtAsistenciaBk.getIdOrigen());
								}
							cambios = true;
							dtAsistencia.setIdOrigen(dtAsistenciaBk.getIdOrigen());
						}
					} else if (dtAsistenciaBk.getIdOrigen() == null
							&& dtAsistencia.getIdOrigen() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdOrigen"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdOrigen() + " :: "+ dtAsistenciaBk.getIdOrigen());
								}
							cambios = true;
							dtAsistencia.setIdOrigen(dtAsistenciaBk.getIdOrigen());
						
					} else if (dtAsistenciaBk.getIdOrigen() != null
							&& dtAsistencia.getIdOrigen() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdOrigen"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdOrigen() + " :: "+ dtAsistenciaBk.getIdOrigen());
								}
							cambios = true;			
							dtAsistencia.setIdOrigen(dtAsistenciaBk.getIdOrigen());
					}
				if (dtAsistenciaBk.getIdProgramacion() != null
							&& dtAsistencia.getIdProgramacion() != null) {
						if (!dtAsistenciaBk.getIdProgramacion().equals(
								dtAsistencia.getIdProgramacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdProgramacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdProgramacion() + " :: "+ dtAsistenciaBk.getIdProgramacion());
								}
							cambios = true;
							dtAsistencia.setIdProgramacion(dtAsistenciaBk.getIdProgramacion());
						}
					} else if (dtAsistenciaBk.getIdProgramacion() == null
							&& dtAsistencia.getIdProgramacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdProgramacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdProgramacion() + " :: "+ dtAsistenciaBk.getIdProgramacion());
								}
							cambios = true;
							dtAsistencia.setIdProgramacion(dtAsistenciaBk.getIdProgramacion());
						
					} else if (dtAsistenciaBk.getIdProgramacion() != null
							&& dtAsistencia.getIdProgramacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdProgramacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdProgramacion() + " :: "+ dtAsistenciaBk.getIdProgramacion());
								}
							cambios = true;			
							dtAsistencia.setIdProgramacion(dtAsistenciaBk.getIdProgramacion());
					}
				if (dtAsistenciaBk.getIdModalidad() != null
							&& dtAsistencia.getIdModalidad() != null) {
						if (!dtAsistenciaBk.getIdModalidad().equals(
								dtAsistencia.getIdModalidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdModalidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdModalidad() + " :: "+ dtAsistenciaBk.getIdModalidad());
								}
							cambios = true;
							dtAsistencia.setIdModalidad(dtAsistenciaBk.getIdModalidad());
						}
					} else if (dtAsistenciaBk.getIdModalidad() == null
							&& dtAsistencia.getIdModalidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdModalidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdModalidad() + " :: "+ dtAsistenciaBk.getIdModalidad());
								}
							cambios = true;
							dtAsistencia.setIdModalidad(dtAsistenciaBk.getIdModalidad());
						
					} else if (dtAsistenciaBk.getIdModalidad() != null
							&& dtAsistencia.getIdModalidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdModalidad"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdModalidad() + " :: "+ dtAsistenciaBk.getIdModalidad());
								}
							cambios = true;			
							dtAsistencia.setIdModalidad(dtAsistenciaBk.getIdModalidad());
					}
				if (dtAsistenciaBk.getIdSede() != null
							&& dtAsistencia.getIdSede() != null) {
						if (!dtAsistenciaBk.getIdSede().equals(
								dtAsistencia.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSede"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSede() + " :: "+ dtAsistenciaBk.getIdSede());
								}
							cambios = true;
							dtAsistencia.setIdSede(dtAsistenciaBk.getIdSede());
						}
					} else if (dtAsistenciaBk.getIdSede() == null
							&& dtAsistencia.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSede"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSede() + " :: "+ dtAsistenciaBk.getIdSede());
								}
							cambios = true;
							dtAsistencia.setIdSede(dtAsistenciaBk.getIdSede());
						
					} else if (dtAsistenciaBk.getIdSede() != null
							&& dtAsistencia.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSede"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSede() + " :: "+ dtAsistenciaBk.getIdSede());
								}
							cambios = true;			
							dtAsistencia.setIdSede(dtAsistenciaBk.getIdSede());
					}
				if (dtAsistenciaBk.getIdSistAdm() != null
							&& dtAsistencia.getIdSistAdm() != null) {
						if (!dtAsistenciaBk.getIdSistAdm().equals(
								dtAsistencia.getIdSistAdm())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSistAdm"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSistAdm() + " :: "+ dtAsistenciaBk.getIdSistAdm());
								}
							cambios = true;
							dtAsistencia.setIdSistAdm(dtAsistenciaBk.getIdSistAdm());
						}
					} else if (dtAsistenciaBk.getIdSistAdm() == null
							&& dtAsistencia.getIdSistAdm() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSistAdm"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSistAdm() + " :: "+ dtAsistenciaBk.getIdSistAdm());
								}
							cambios = true;
							dtAsistencia.setIdSistAdm(dtAsistenciaBk.getIdSistAdm());
						
					} else if (dtAsistenciaBk.getIdSistAdm() != null
							&& dtAsistencia.getIdSistAdm() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdSistAdm"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdSistAdm() + " :: "+ dtAsistenciaBk.getIdSistAdm());
								}
							cambios = true;			
							dtAsistencia.setIdSistAdm(dtAsistenciaBk.getIdSistAdm());
					}
				if (dtAsistenciaBk.getIdFinancia() != null
							&& dtAsistencia.getIdFinancia() != null) {
						if (!dtAsistenciaBk.getIdFinancia().equals(
								dtAsistencia.getIdFinancia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdFinancia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdFinancia() + " :: "+ dtAsistenciaBk.getIdFinancia());
								}
							cambios = true;
							dtAsistencia.setIdFinancia(dtAsistenciaBk.getIdFinancia());
						}
					} else if (dtAsistenciaBk.getIdFinancia() == null
							&& dtAsistencia.getIdFinancia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdFinancia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdFinancia() + " :: "+ dtAsistenciaBk.getIdFinancia());
								}
							cambios = true;
							dtAsistencia.setIdFinancia(dtAsistenciaBk.getIdFinancia());
						
					} else if (dtAsistenciaBk.getIdFinancia() != null
							&& dtAsistencia.getIdFinancia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdFinancia"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdFinancia() + " :: "+ dtAsistenciaBk.getIdFinancia());
								}
							cambios = true;			
							dtAsistencia.setIdFinancia(dtAsistenciaBk.getIdFinancia());
					}
				if (dtAsistenciaBk.getFechaFinalizacion() != null
							&& dtAsistencia.getFechaFinalizacion() != null) {
						if (!dtAsistenciaBk.getFechaFinalizacion().equals(
								dtAsistencia.getFechaFinalizacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaFinalizacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaFinalizacion() + " :: "+ dtAsistenciaBk.getFechaFinalizacion());
								}
							cambios = true;
							dtAsistencia.setFechaFinalizacion(dtAsistenciaBk.getFechaFinalizacion());
						}
					} else if (dtAsistenciaBk.getFechaFinalizacion() == null
							&& dtAsistencia.getFechaFinalizacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaFinalizacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaFinalizacion() + " :: "+ dtAsistenciaBk.getFechaFinalizacion());
								}
							cambios = true;
							dtAsistencia.setFechaFinalizacion(dtAsistenciaBk.getFechaFinalizacion());
						
					} else if (dtAsistenciaBk.getFechaFinalizacion() != null
							&& dtAsistencia.getFechaFinalizacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaFinalizacion"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaFinalizacion() + " :: "+ dtAsistenciaBk.getFechaFinalizacion());
								}
							cambios = true;			
							dtAsistencia.setFechaFinalizacion(dtAsistenciaBk.getFechaFinalizacion());
					}
				if (dtAsistenciaBk.getFechaProgramada() != null
							&& dtAsistencia.getFechaProgramada() != null) {
						if (!dtAsistenciaBk.getFechaProgramada().equals(
								dtAsistencia.getFechaProgramada())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaProgramada"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaProgramada() + " :: "+ dtAsistenciaBk.getFechaProgramada());
								}
							cambios = true;
							dtAsistencia.setFechaProgramada(dtAsistenciaBk.getFechaProgramada());
						}
					} else if (dtAsistenciaBk.getFechaProgramada() == null
							&& dtAsistencia.getFechaProgramada() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaProgramada"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaProgramada() + " :: "+ dtAsistenciaBk.getFechaProgramada());
								}
							cambios = true;
							dtAsistencia.setFechaProgramada(dtAsistenciaBk.getFechaProgramada());
						
					} else if (dtAsistenciaBk.getFechaProgramada() != null
							&& dtAsistencia.getFechaProgramada() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaProgramada"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaProgramada() + " :: "+ dtAsistenciaBk.getFechaProgramada());
								}
							cambios = true;			
							dtAsistencia.setFechaProgramada(dtAsistenciaBk.getFechaProgramada());
					}
				if (dtAsistenciaBk.getFechaSoli() != null
							&& dtAsistencia.getFechaSoli() != null) {
						if (!dtAsistenciaBk.getFechaSoli().equals(
								dtAsistencia.getFechaSoli())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaSoli"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaSoli() + " :: "+ dtAsistenciaBk.getFechaSoli());
								}
							cambios = true;
							dtAsistencia.setFechaSoli(dtAsistenciaBk.getFechaSoli());
						}
					} else if (dtAsistenciaBk.getFechaSoli() == null
							&& dtAsistencia.getFechaSoli() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaSoli"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaSoli() + " :: "+ dtAsistenciaBk.getFechaSoli());
								}
							cambios = true;
							dtAsistencia.setFechaSoli(dtAsistenciaBk.getFechaSoli());
						
					} else if (dtAsistenciaBk.getFechaSoli() != null
							&& dtAsistencia.getFechaSoli() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaSoli"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaSoli() + " :: "+ dtAsistenciaBk.getFechaSoli());
								}
							cambios = true;			
							dtAsistencia.setFechaSoli(dtAsistenciaBk.getFechaSoli());
					}
				//INICIO CUSCATA - 18062024
				
				if (dtAsistenciaBk.getEstado() != null
						&& dtAsistencia.getEstado() != null) {
					if (!dtAsistenciaBk.getEstado().equals(
							dtAsistencia.getEstado())) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
							}
						cambios = true;
						dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
					}
				} else if (dtAsistenciaBk.getEstado() == null
						&& dtAsistencia.getEstado() != null) {						
						if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
							}
						cambios = true;
						dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
					
				} else if (dtAsistenciaBk.getEstado() != null
						&& dtAsistencia.getEstado() == null) {						
						if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
							}
						cambios = true;			
						dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
				}
				//FIN CUSCATA - 18062024
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAsistencia(DtAsistenciaBk dtAsistenciaBk, DtAsistencia dtAsistencia, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (dtAsistenciaBk.getIdusserCrea() != null
							&& dtAsistencia.getIdusserCrea() != null) {
						if (!dtAsistenciaBk.getIdusserCrea().equals(
								dtAsistencia.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserCrea() + " :: "+ dtAsistenciaBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistencia.setIdusserCrea(dtAsistenciaBk.getIdusserCrea());
						}
					} else if (dtAsistenciaBk.getIdusserCrea() == null
							&& dtAsistencia.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserCrea() + " :: "+ dtAsistenciaBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistencia.setIdusserCrea(dtAsistenciaBk.getIdusserCrea());
						
					} else if (dtAsistenciaBk.getIdusserCrea() != null
							&& dtAsistencia.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserCrea() + " :: "+ dtAsistenciaBk.getIdusserCrea());
								}
							cambios = true;			
							dtAsistencia.setIdusserCrea(dtAsistenciaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAsistenciaBk.getIdusserModif() != null
							&& dtAsistencia.getIdusserModif() != null) {
						if (!dtAsistenciaBk.getIdusserModif().equals(
								dtAsistencia.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserModif() + " :: "+ dtAsistenciaBk.getIdusserModif());
								}
							cambios = true;
							dtAsistencia.setIdusserModif(dtAsistenciaBk.getIdusserModif());
						}
					} else if (dtAsistenciaBk.getIdusserModif() == null
							&& dtAsistencia.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserModif() + " :: "+ dtAsistenciaBk.getIdusserModif());
								}
							cambios = true;
							dtAsistencia.setIdusserModif(dtAsistenciaBk.getIdusserModif());
						
					} else if (dtAsistenciaBk.getIdusserModif() != null
							&& dtAsistencia.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:IdusserModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getIdusserModif() + " :: "+ dtAsistenciaBk.getIdusserModif());
								}
							cambios = true;			
							dtAsistencia.setIdusserModif(dtAsistenciaBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAsistenciaBk.getFechaCrea() != null
							&& dtAsistencia.getFechaCrea() != null) {
						if (!dtAsistenciaBk.getFechaCrea().equals(
								dtAsistencia.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaCrea() + " :: "+ dtAsistenciaBk.getFechaCrea());
								}
							cambios = true;
							dtAsistencia.setFechaCrea(dtAsistenciaBk.getFechaCrea());
						}
					} else if (dtAsistenciaBk.getFechaCrea() == null
							&& dtAsistencia.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaCrea() + " :: "+ dtAsistenciaBk.getFechaCrea());
								}
							cambios = true;
							dtAsistencia.setFechaCrea(dtAsistenciaBk.getFechaCrea());
						
					} else if (dtAsistenciaBk.getFechaCrea() != null
							&& dtAsistencia.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaCrea"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaCrea() + " :: "+ dtAsistenciaBk.getFechaCrea());
								}
							cambios = true;			
							dtAsistencia.setFechaCrea(dtAsistenciaBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAsistenciaBk.getFechaModif() != null
							&& dtAsistencia.getFechaModif() != null) {
						if (!dtAsistenciaBk.getFechaModif().equals(
								dtAsistencia.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaModif() + " :: "+ dtAsistenciaBk.getFechaModif());
								}
							cambios = true;
							dtAsistencia.setFechaModif(dtAsistenciaBk.getFechaModif());
						}
					} else if (dtAsistenciaBk.getFechaModif() == null
							&& dtAsistencia.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaModif() + " :: "+ dtAsistenciaBk.getFechaModif());
								}
							cambios = true;
							dtAsistencia.setFechaModif(dtAsistenciaBk.getFechaModif());
						
					} else if (dtAsistenciaBk.getFechaModif() != null
							&& dtAsistencia.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:FechaModif"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getFechaModif() + " :: "+ dtAsistenciaBk.getFechaModif());
								}
							cambios = true;			
							dtAsistencia.setFechaModif(dtAsistenciaBk.getFechaModif());
					}
                                
				                                 
                                      if (dtAsistenciaBk.getEstado() != null
							&& dtAsistencia.getEstado() != null) {
						if (!dtAsistenciaBk.getEstado().equals(
								dtAsistencia.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
								}
							cambios = true;
							dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
						}
					} else if (dtAsistenciaBk.getEstado() == null
							&& dtAsistencia.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
								}
							cambios = true;
							dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
						
					} else if (dtAsistenciaBk.getEstado() != null
							&& dtAsistencia.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Estado"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getEstado() + " :: "+ dtAsistenciaBk.getEstado());
								}
							cambios = true;			
							dtAsistencia.setEstado(dtAsistenciaBk.getEstado());
					}
                                
				
				
				
				
				                                 
                                      if (dtAsistenciaBk.getRtmaddress() != null
							&& dtAsistencia.getRtmaddress() != null) {
						if (!dtAsistenciaBk.getRtmaddress().equals(
								dtAsistencia.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddress"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddress() + " :: "+ dtAsistenciaBk.getRtmaddress());
								}
							cambios = true;
							dtAsistencia.setRtmaddress(dtAsistenciaBk.getRtmaddress());
						}
					} else if (dtAsistenciaBk.getRtmaddress() == null
							&& dtAsistencia.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddress"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddress() + " :: "+ dtAsistenciaBk.getRtmaddress());
								}
							cambios = true;
							dtAsistencia.setRtmaddress(dtAsistenciaBk.getRtmaddress());
						
					} else if (dtAsistenciaBk.getRtmaddress() != null
							&& dtAsistencia.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddress"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddress() + " :: "+ dtAsistenciaBk.getRtmaddress());
								}
							cambios = true;			
							dtAsistencia.setRtmaddress(dtAsistenciaBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAsistenciaBk.getRtmaddressrst() != null
							&& dtAsistencia.getRtmaddressrst() != null) {
						if (!dtAsistenciaBk.getRtmaddressrst().equals(
								dtAsistencia.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddressrst"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddressrst() + " :: "+ dtAsistenciaBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistencia.setRtmaddressrst(dtAsistenciaBk.getRtmaddressrst());
						}
					} else if (dtAsistenciaBk.getRtmaddressrst() == null
							&& dtAsistencia.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddressrst"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddressrst() + " :: "+ dtAsistenciaBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistencia.setRtmaddressrst(dtAsistenciaBk.getRtmaddressrst());
						
					} else if (dtAsistenciaBk.getRtmaddressrst() != null
							&& dtAsistencia.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistencia:Rtmaddressrst"+" :: "+dtAsistenciaBk.getIdAsistencia().toString()+" :: "+ dtAsistencia.getRtmaddressrst() + " :: "+ dtAsistenciaBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAsistencia.setRtmaddressrst(dtAsistenciaBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
				
				
			
			return cambios;
	}
}