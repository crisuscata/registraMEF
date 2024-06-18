package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCapacitacion;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;

/**
 * DT_CAPACITACION SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DATOS REGISTRADOS EN UNA CAPACITACION "CAPACITACIONES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:19
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /19/12/2023 17:19  / Creación de la clase /
 * 
 */
public class AuditoriaDtCapacitacionMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCapacitacionMng.class.getName());
	
	public static boolean auditarCambiosDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, DtCapacitacion dtCapacitacion, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCapacitacionBk.getFechaInic() != null
							&& dtCapacitacion.getFechaInic() != null) {
						if (!dtCapacitacionBk.getFechaInic().equals(
								dtCapacitacion.getFechaInic())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaInic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaInic() + " :: "+ dtCapacitacionBk.getFechaInic());
								}
							cambios = true;
							dtCapacitacion.setFechaInic(dtCapacitacionBk.getFechaInic());
						}
					} else if (dtCapacitacionBk.getFechaInic() == null
							&& dtCapacitacion.getFechaInic() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaInic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaInic() + " :: "+ dtCapacitacionBk.getFechaInic());
								}
							cambios = true;
							dtCapacitacion.setFechaInic(dtCapacitacionBk.getFechaInic());
						
					} else if (dtCapacitacionBk.getFechaInic() != null
							&& dtCapacitacion.getFechaInic() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaInic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaInic() + " :: "+ dtCapacitacionBk.getFechaInic());
								}
							cambios = true;			
							dtCapacitacion.setFechaInic(dtCapacitacionBk.getFechaInic());
					}
				if (dtCapacitacionBk.getFechaFin() != null
							&& dtCapacitacion.getFechaFin() != null) {
						if (!dtCapacitacionBk.getFechaFin().equals(
								dtCapacitacion.getFechaFin())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFin"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFin() + " :: "+ dtCapacitacionBk.getFechaFin());
								}
							cambios = true;
							dtCapacitacion.setFechaFin(dtCapacitacionBk.getFechaFin());
						}
					} else if (dtCapacitacionBk.getFechaFin() == null
							&& dtCapacitacion.getFechaFin() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFin"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFin() + " :: "+ dtCapacitacionBk.getFechaFin());
								}
							cambios = true;
							dtCapacitacion.setFechaFin(dtCapacitacionBk.getFechaFin());
						
					} else if (dtCapacitacionBk.getFechaFin() != null
							&& dtCapacitacion.getFechaFin() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFin"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFin() + " :: "+ dtCapacitacionBk.getFechaFin());
								}
							cambios = true;			
							dtCapacitacion.setFechaFin(dtCapacitacionBk.getFechaFin());
					}
				if (dtCapacitacionBk.getCantPartic() != null
							&& dtCapacitacion.getCantPartic() != null) {
						if (!dtCapacitacionBk.getCantPartic().equals(
								dtCapacitacion.getCantPartic())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantPartic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantPartic() + " :: "+ dtCapacitacionBk.getCantPartic());
								}
							cambios = true;
							dtCapacitacion.setCantPartic(dtCapacitacionBk.getCantPartic());
						}
					} else if (dtCapacitacionBk.getCantPartic() == null
							&& dtCapacitacion.getCantPartic() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantPartic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantPartic() + " :: "+ dtCapacitacionBk.getCantPartic());
								}
							cambios = true;
							dtCapacitacion.setCantPartic(dtCapacitacionBk.getCantPartic());
						
					} else if (dtCapacitacionBk.getCantPartic() != null
							&& dtCapacitacion.getCantPartic() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantPartic"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantPartic() + " :: "+ dtCapacitacionBk.getCantPartic());
								}
							cambios = true;			
							dtCapacitacion.setCantPartic(dtCapacitacionBk.getCantPartic());
					}
				 
		            if (dtCapacitacionBk.getPublicObj() != null
						&& dtCapacitacion.getPublicObj() != null) {
					if (!dtCapacitacionBk.getPublicObj().equals(
						dtCapacitacion.getPublicObj())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:PublicObj"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getPublicObj() + " :: "+ dtCapacitacionBk.getPublicObj());								
						}
						cambios = true;
						dtCapacitacion.setPublicObj(dtCapacitacionBk.getPublicObj());
					}
				} else if (dtCapacitacionBk.getPublicObj() == null
						&& dtCapacitacion.getPublicObj() != null) {
					if (dtCapacitacion.getPublicObj().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:PublicObj"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getPublicObj() + " :: "+ dtCapacitacionBk.getPublicObj());
						}
						cambios = true;
						dtCapacitacion.setPublicObj(dtCapacitacionBk.getPublicObj());
					}
				} else if (dtCapacitacionBk.getPublicObj() != null
						&& dtCapacitacion.getPublicObj() == null) {
					if (dtCapacitacionBk.getPublicObj().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:PublicObj"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getPublicObj() + " :: "+ dtCapacitacionBk.getPublicObj());
						}
						cambios = true;
						dtCapacitacion.setPublicObj(dtCapacitacionBk.getPublicObj());
					}
				}
				if (dtCapacitacionBk.getNomEvento() != null
							&& dtCapacitacion.getNomEvento() != null) {
						if (!dtCapacitacionBk.getNomEvento().equals(
								dtCapacitacion.getNomEvento())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:NomEvento"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getNomEvento() + " :: "+ dtCapacitacionBk.getNomEvento());
								}
							cambios = true;
							dtCapacitacion.setNomEvento(dtCapacitacionBk.getNomEvento());
						}
					} else if (dtCapacitacionBk.getNomEvento() == null
							&& dtCapacitacion.getNomEvento() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:NomEvento"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getNomEvento() + " :: "+ dtCapacitacionBk.getNomEvento());
								}
							cambios = true;
							dtCapacitacion.setNomEvento(dtCapacitacionBk.getNomEvento());
						
					} else if (dtCapacitacionBk.getNomEvento() != null
							&& dtCapacitacion.getNomEvento() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:NomEvento"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getNomEvento() + " :: "+ dtCapacitacionBk.getNomEvento());
								}
							cambios = true;			
							dtCapacitacion.setNomEvento(dtCapacitacionBk.getNomEvento());
					}
				if (dtCapacitacionBk.getDetalleCapa() != null
							&& dtCapacitacion.getDetalleCapa() != null) {
						if (!dtCapacitacionBk.getDetalleCapa().equals(
								dtCapacitacion.getDetalleCapa())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapa"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapa() + " :: "+ dtCapacitacionBk.getDetalleCapa());
								}
							cambios = true;
							dtCapacitacion.setDetalleCapa(dtCapacitacionBk.getDetalleCapa());
						}
					} else if (dtCapacitacionBk.getDetalleCapa() == null
							&& dtCapacitacion.getDetalleCapa() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapa"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapa() + " :: "+ dtCapacitacionBk.getDetalleCapa());
								}
							cambios = true;
							dtCapacitacion.setDetalleCapa(dtCapacitacionBk.getDetalleCapa());
						
					} else if (dtCapacitacionBk.getDetalleCapa() != null
							&& dtCapacitacion.getDetalleCapa() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapa"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapa() + " :: "+ dtCapacitacionBk.getDetalleCapa());
								}
							cambios = true;			
							dtCapacitacion.setDetalleCapa(dtCapacitacionBk.getDetalleCapa());
					}
				if (dtCapacitacionBk.getIdLocal() != null
							&& dtCapacitacion.getIdLocal() != null) {
						if (!dtCapacitacionBk.getIdLocal().equals(
								dtCapacitacion.getIdLocal())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdLocal"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdLocal() + " :: "+ dtCapacitacionBk.getIdLocal());
								}
							cambios = true;
							dtCapacitacion.setIdLocal(dtCapacitacionBk.getIdLocal());
						}
					} else if (dtCapacitacionBk.getIdLocal() == null
							&& dtCapacitacion.getIdLocal() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdLocal"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdLocal() + " :: "+ dtCapacitacionBk.getIdLocal());
								}
							cambios = true;
							dtCapacitacion.setIdLocal(dtCapacitacionBk.getIdLocal());
						
					} else if (dtCapacitacionBk.getIdLocal() != null
							&& dtCapacitacion.getIdLocal() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdLocal"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdLocal() + " :: "+ dtCapacitacionBk.getIdLocal());
								}
							cambios = true;			
							dtCapacitacion.setIdLocal(dtCapacitacionBk.getIdLocal());
					}
				if (dtCapacitacionBk.getIdUsuinterno() != null
							&& dtCapacitacion.getIdUsuinterno() != null) {
						if (!dtCapacitacionBk.getIdUsuinterno().equals(
								dtCapacitacion.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdUsuinterno"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdUsuinterno() + " :: "+ dtCapacitacionBk.getIdUsuinterno());
								}
							cambios = true;
							dtCapacitacion.setIdUsuinterno(dtCapacitacionBk.getIdUsuinterno());
						}
					} else if (dtCapacitacionBk.getIdUsuinterno() == null
							&& dtCapacitacion.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdUsuinterno"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdUsuinterno() + " :: "+ dtCapacitacionBk.getIdUsuinterno());
								}
							cambios = true;
							dtCapacitacion.setIdUsuinterno(dtCapacitacionBk.getIdUsuinterno());
						
					} else if (dtCapacitacionBk.getIdUsuinterno() != null
							&& dtCapacitacion.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdUsuinterno"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdUsuinterno() + " :: "+ dtCapacitacionBk.getIdUsuinterno());
								}
							cambios = true;			
							dtCapacitacion.setIdUsuinterno(dtCapacitacionBk.getIdUsuinterno());
					}
				if (dtCapacitacionBk.getIdModo() != null
							&& dtCapacitacion.getIdModo() != null) {
						if (!dtCapacitacionBk.getIdModo().equals(
								dtCapacitacion.getIdModo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModo() + " :: "+ dtCapacitacionBk.getIdModo());
								}
							cambios = true;
							dtCapacitacion.setIdModo(dtCapacitacionBk.getIdModo());
						}
					} else if (dtCapacitacionBk.getIdModo() == null
							&& dtCapacitacion.getIdModo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModo() + " :: "+ dtCapacitacionBk.getIdModo());
								}
							cambios = true;
							dtCapacitacion.setIdModo(dtCapacitacionBk.getIdModo());
						
					} else if (dtCapacitacionBk.getIdModo() != null
							&& dtCapacitacion.getIdModo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModo() + " :: "+ dtCapacitacionBk.getIdModo());
								}
							cambios = true;			
							dtCapacitacion.setIdModo(dtCapacitacionBk.getIdModo());
					}
				if (dtCapacitacionBk.getIdNivel() != null
							&& dtCapacitacion.getIdNivel() != null) {
						if (!dtCapacitacionBk.getIdNivel().equals(
								dtCapacitacion.getIdNivel())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdNivel"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdNivel() + " :: "+ dtCapacitacionBk.getIdNivel());
								}
							cambios = true;
							dtCapacitacion.setIdNivel(dtCapacitacionBk.getIdNivel());
						}
					} else if (dtCapacitacionBk.getIdNivel() == null
							&& dtCapacitacion.getIdNivel() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdNivel"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdNivel() + " :: "+ dtCapacitacionBk.getIdNivel());
								}
							cambios = true;
							dtCapacitacion.setIdNivel(dtCapacitacionBk.getIdNivel());
						
					} else if (dtCapacitacionBk.getIdNivel() != null
							&& dtCapacitacion.getIdNivel() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdNivel"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdNivel() + " :: "+ dtCapacitacionBk.getIdNivel());
								}
							cambios = true;			
							dtCapacitacion.setIdNivel(dtCapacitacionBk.getIdNivel());
					}
				if (dtCapacitacionBk.getIdOrigen() != null
							&& dtCapacitacion.getIdOrigen() != null) {
						if (!dtCapacitacionBk.getIdOrigen().equals(
								dtCapacitacion.getIdOrigen())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdOrigen"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdOrigen() + " :: "+ dtCapacitacionBk.getIdOrigen());
								}
							cambios = true;
							dtCapacitacion.setIdOrigen(dtCapacitacionBk.getIdOrigen());
						}
					} else if (dtCapacitacionBk.getIdOrigen() == null
							&& dtCapacitacion.getIdOrigen() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdOrigen"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdOrigen() + " :: "+ dtCapacitacionBk.getIdOrigen());
								}
							cambios = true;
							dtCapacitacion.setIdOrigen(dtCapacitacionBk.getIdOrigen());
						
					} else if (dtCapacitacionBk.getIdOrigen() != null
							&& dtCapacitacion.getIdOrigen() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdOrigen"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdOrigen() + " :: "+ dtCapacitacionBk.getIdOrigen());
								}
							cambios = true;			
							dtCapacitacion.setIdOrigen(dtCapacitacionBk.getIdOrigen());
					}
				if (dtCapacitacionBk.getIdPrestacion() != null
							&& dtCapacitacion.getIdPrestacion() != null) {
						if (!dtCapacitacionBk.getIdPrestacion().equals(
								dtCapacitacion.getIdPrestacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdPrestacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdPrestacion() + " :: "+ dtCapacitacionBk.getIdPrestacion());
								}
							cambios = true;
							dtCapacitacion.setIdPrestacion(dtCapacitacionBk.getIdPrestacion());
						}
					} else if (dtCapacitacionBk.getIdPrestacion() == null
							&& dtCapacitacion.getIdPrestacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdPrestacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdPrestacion() + " :: "+ dtCapacitacionBk.getIdPrestacion());
								}
							cambios = true;
							dtCapacitacion.setIdPrestacion(dtCapacitacionBk.getIdPrestacion());
						
					} else if (dtCapacitacionBk.getIdPrestacion() != null
							&& dtCapacitacion.getIdPrestacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdPrestacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdPrestacion() + " :: "+ dtCapacitacionBk.getIdPrestacion());
								}
							cambios = true;			
							dtCapacitacion.setIdPrestacion(dtCapacitacionBk.getIdPrestacion());
					}
				if (dtCapacitacionBk.getIdProgramacion() != null
							&& dtCapacitacion.getIdProgramacion() != null) {
						if (!dtCapacitacionBk.getIdProgramacion().equals(
								dtCapacitacion.getIdProgramacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdProgramacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdProgramacion() + " :: "+ dtCapacitacionBk.getIdProgramacion());
								}
							cambios = true;
							dtCapacitacion.setIdProgramacion(dtCapacitacionBk.getIdProgramacion());
						}
					} else if (dtCapacitacionBk.getIdProgramacion() == null
							&& dtCapacitacion.getIdProgramacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdProgramacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdProgramacion() + " :: "+ dtCapacitacionBk.getIdProgramacion());
								}
							cambios = true;
							dtCapacitacion.setIdProgramacion(dtCapacitacionBk.getIdProgramacion());
						
					} else if (dtCapacitacionBk.getIdProgramacion() != null
							&& dtCapacitacion.getIdProgramacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdProgramacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdProgramacion() + " :: "+ dtCapacitacionBk.getIdProgramacion());
								}
							cambios = true;			
							dtCapacitacion.setIdProgramacion(dtCapacitacionBk.getIdProgramacion());
					}
				if (dtCapacitacionBk.getCantParticAsist() != null
							&& dtCapacitacion.getCantParticAsist() != null) {
						if (!dtCapacitacionBk.getCantParticAsist().equals(
								dtCapacitacion.getCantParticAsist())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantParticAsist"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantParticAsist() + " :: "+ dtCapacitacionBk.getCantParticAsist());
								}
							cambios = true;
							dtCapacitacion.setCantParticAsist(dtCapacitacionBk.getCantParticAsist());
						}
					} else if (dtCapacitacionBk.getCantParticAsist() == null
							&& dtCapacitacion.getCantParticAsist() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantParticAsist"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantParticAsist() + " :: "+ dtCapacitacionBk.getCantParticAsist());
								}
							cambios = true;
							dtCapacitacion.setCantParticAsist(dtCapacitacionBk.getCantParticAsist());
						
					} else if (dtCapacitacionBk.getCantParticAsist() != null
							&& dtCapacitacion.getCantParticAsist() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:CantParticAsist"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getCantParticAsist() + " :: "+ dtCapacitacionBk.getCantParticAsist());
								}
							cambios = true;			
							dtCapacitacion.setCantParticAsist(dtCapacitacionBk.getCantParticAsist());
					}
				if (dtCapacitacionBk.getIdTipo() != null
							&& dtCapacitacion.getIdTipo() != null) {
						if (!dtCapacitacionBk.getIdTipo().equals(
								dtCapacitacion.getIdTipo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdTipo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdTipo() + " :: "+ dtCapacitacionBk.getIdTipo());
								}
							cambios = true;
							dtCapacitacion.setIdTipo(dtCapacitacionBk.getIdTipo());
						}
					} else if (dtCapacitacionBk.getIdTipo() == null
							&& dtCapacitacion.getIdTipo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdTipo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdTipo() + " :: "+ dtCapacitacionBk.getIdTipo());
								}
							cambios = true;
							dtCapacitacion.setIdTipo(dtCapacitacionBk.getIdTipo());
						
					} else if (dtCapacitacionBk.getIdTipo() != null
							&& dtCapacitacion.getIdTipo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdTipo"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdTipo() + " :: "+ dtCapacitacionBk.getIdTipo());
								}
							cambios = true;			
							dtCapacitacion.setIdTipo(dtCapacitacionBk.getIdTipo());
					}
				if (dtCapacitacionBk.getIdcapaPadre() != null
							&& dtCapacitacion.getIdcapaPadre() != null) {
						if (!dtCapacitacionBk.getIdcapaPadre().equals(
								dtCapacitacion.getIdcapaPadre())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdcapaPadre"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdcapaPadre() + " :: "+ dtCapacitacionBk.getIdcapaPadre());
								}
							cambios = true;
							dtCapacitacion.setIdcapaPadre(dtCapacitacionBk.getIdcapaPadre());
						}
					} else if (dtCapacitacionBk.getIdcapaPadre() == null
							&& dtCapacitacion.getIdcapaPadre() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdcapaPadre"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdcapaPadre() + " :: "+ dtCapacitacionBk.getIdcapaPadre());
								}
							cambios = true;
							dtCapacitacion.setIdcapaPadre(dtCapacitacionBk.getIdcapaPadre());
						
					} else if (dtCapacitacionBk.getIdcapaPadre() != null
							&& dtCapacitacion.getIdcapaPadre() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdcapaPadre"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdcapaPadre() + " :: "+ dtCapacitacionBk.getIdcapaPadre());
								}
							cambios = true;			
							dtCapacitacion.setIdcapaPadre(dtCapacitacionBk.getIdcapaPadre());
					}
				if (dtCapacitacionBk.getIdSede() != null
							&& dtCapacitacion.getIdSede() != null) {
						if (!dtCapacitacionBk.getIdSede().equals(
								dtCapacitacion.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSede"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSede() + " :: "+ dtCapacitacionBk.getIdSede());
								}
							cambios = true;
							dtCapacitacion.setIdSede(dtCapacitacionBk.getIdSede());
						}
					} else if (dtCapacitacionBk.getIdSede() == null
							&& dtCapacitacion.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSede"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSede() + " :: "+ dtCapacitacionBk.getIdSede());
								}
							cambios = true;
							dtCapacitacion.setIdSede(dtCapacitacionBk.getIdSede());
						
					} else if (dtCapacitacionBk.getIdSede() != null
							&& dtCapacitacion.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSede"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSede() + " :: "+ dtCapacitacionBk.getIdSede());
								}
							cambios = true;			
							dtCapacitacion.setIdSede(dtCapacitacionBk.getIdSede());
					}
				if (dtCapacitacionBk.getIdSistAdm() != null
							&& dtCapacitacion.getIdSistAdm() != null) {
						if (!dtCapacitacionBk.getIdSistAdm().equals(
								dtCapacitacion.getIdSistAdm())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSistAdm"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSistAdm() + " :: "+ dtCapacitacionBk.getIdSistAdm());
								}
							cambios = true;
							dtCapacitacion.setIdSistAdm(dtCapacitacionBk.getIdSistAdm());
						}
					} else if (dtCapacitacionBk.getIdSistAdm() == null
							&& dtCapacitacion.getIdSistAdm() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSistAdm"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSistAdm() + " :: "+ dtCapacitacionBk.getIdSistAdm());
								}
							cambios = true;
							dtCapacitacion.setIdSistAdm(dtCapacitacionBk.getIdSistAdm());
						
					} else if (dtCapacitacionBk.getIdSistAdm() != null
							&& dtCapacitacion.getIdSistAdm() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdSistAdm"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdSistAdm() + " :: "+ dtCapacitacionBk.getIdSistAdm());
								}
							cambios = true;			
							dtCapacitacion.setIdSistAdm(dtCapacitacionBk.getIdSistAdm());
					}
				if (dtCapacitacionBk.getIdFinancia() != null
							&& dtCapacitacion.getIdFinancia() != null) {
						if (!dtCapacitacionBk.getIdFinancia().equals(
								dtCapacitacion.getIdFinancia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdFinancia"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdFinancia() + " :: "+ dtCapacitacionBk.getIdFinancia());
								}
							cambios = true;
							dtCapacitacion.setIdFinancia(dtCapacitacionBk.getIdFinancia());
						}
					} else if (dtCapacitacionBk.getIdFinancia() == null
							&& dtCapacitacion.getIdFinancia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdFinancia"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdFinancia() + " :: "+ dtCapacitacionBk.getIdFinancia());
								}
							cambios = true;
							dtCapacitacion.setIdFinancia(dtCapacitacionBk.getIdFinancia());
						
					} else if (dtCapacitacionBk.getIdFinancia() != null
							&& dtCapacitacion.getIdFinancia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdFinancia"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdFinancia() + " :: "+ dtCapacitacionBk.getIdFinancia());
								}
							cambios = true;			
							dtCapacitacion.setIdFinancia(dtCapacitacionBk.getIdFinancia());
					}
				if (dtCapacitacionBk.getFechaFinalizacion() != null
							&& dtCapacitacion.getFechaFinalizacion() != null) {
						if (!dtCapacitacionBk.getFechaFinalizacion().equals(
								dtCapacitacion.getFechaFinalizacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinalizacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinalizacion() + " :: "+ dtCapacitacionBk.getFechaFinalizacion());
								}
							cambios = true;
							dtCapacitacion.setFechaFinalizacion(dtCapacitacionBk.getFechaFinalizacion());
						}
					} else if (dtCapacitacionBk.getFechaFinalizacion() == null
							&& dtCapacitacion.getFechaFinalizacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinalizacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinalizacion() + " :: "+ dtCapacitacionBk.getFechaFinalizacion());
								}
							cambios = true;
							dtCapacitacion.setFechaFinalizacion(dtCapacitacionBk.getFechaFinalizacion());
						
					} else if (dtCapacitacionBk.getFechaFinalizacion() != null
							&& dtCapacitacion.getFechaFinalizacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinalizacion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinalizacion() + " :: "+ dtCapacitacionBk.getFechaFinalizacion());
								}
							cambios = true;			
							dtCapacitacion.setFechaFinalizacion(dtCapacitacionBk.getFechaFinalizacion());
					}
				if (dtCapacitacionBk.getFlagPubli() != null
							&& dtCapacitacion.getFlagPubli() != null) {
						if (!dtCapacitacionBk.getFlagPubli().equals(
								dtCapacitacion.getFlagPubli())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagPubli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagPubli() + " :: "+ dtCapacitacionBk.getFlagPubli());
								}
							cambios = true;
							dtCapacitacion.setFlagPubli(dtCapacitacionBk.getFlagPubli());
						}
					} else if (dtCapacitacionBk.getFlagPubli() == null
							&& dtCapacitacion.getFlagPubli() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagPubli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagPubli() + " :: "+ dtCapacitacionBk.getFlagPubli());
								}
							cambios = true;
							dtCapacitacion.setFlagPubli(dtCapacitacionBk.getFlagPubli());
						
					} else if (dtCapacitacionBk.getFlagPubli() != null
							&& dtCapacitacion.getFlagPubli() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagPubli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagPubli() + " :: "+ dtCapacitacionBk.getFlagPubli());
								}
							cambios = true;			
							dtCapacitacion.setFlagPubli(dtCapacitacionBk.getFlagPubli());
					}
				if (dtCapacitacionBk.getIdModalidad() != null
							&& dtCapacitacion.getIdModalidad() != null) {
						if (!dtCapacitacionBk.getIdModalidad().equals(
								dtCapacitacion.getIdModalidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModalidad"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModalidad() + " :: "+ dtCapacitacionBk.getIdModalidad());
								}
							cambios = true;
							dtCapacitacion.setIdModalidad(dtCapacitacionBk.getIdModalidad());
						}
					} else if (dtCapacitacionBk.getIdModalidad() == null
							&& dtCapacitacion.getIdModalidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModalidad"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModalidad() + " :: "+ dtCapacitacionBk.getIdModalidad());
								}
							cambios = true;
							dtCapacitacion.setIdModalidad(dtCapacitacionBk.getIdModalidad());
						
					} else if (dtCapacitacionBk.getIdModalidad() != null
							&& dtCapacitacion.getIdModalidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdModalidad"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdModalidad() + " :: "+ dtCapacitacionBk.getIdModalidad());
								}
							cambios = true;			
							dtCapacitacion.setIdModalidad(dtCapacitacionBk.getIdModalidad());
					}
				if (dtCapacitacionBk.getDetalleCapaVirtual() != null
							&& dtCapacitacion.getDetalleCapaVirtual() != null) {
						if (!dtCapacitacionBk.getDetalleCapaVirtual().equals(
								dtCapacitacion.getDetalleCapaVirtual())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapaVirtual"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapaVirtual() + " :: "+ dtCapacitacionBk.getDetalleCapaVirtual());
								}
							cambios = true;
							dtCapacitacion.setDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual());
						}
					} else if (dtCapacitacionBk.getDetalleCapaVirtual() == null
							&& dtCapacitacion.getDetalleCapaVirtual() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapaVirtual"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapaVirtual() + " :: "+ dtCapacitacionBk.getDetalleCapaVirtual());
								}
							cambios = true;
							dtCapacitacion.setDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual());
						
					} else if (dtCapacitacionBk.getDetalleCapaVirtual() != null
							&& dtCapacitacion.getDetalleCapaVirtual() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:DetalleCapaVirtual"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getDetalleCapaVirtual() + " :: "+ dtCapacitacionBk.getDetalleCapaVirtual());
								}
							cambios = true;			
							dtCapacitacion.setDetalleCapaVirtual(dtCapacitacionBk.getDetalleCapaVirtual());
					}
				if (dtCapacitacionBk.getFechaIniProgramada() != null
							&& dtCapacitacion.getFechaIniProgramada() != null) {
						if (!dtCapacitacionBk.getFechaIniProgramada().equals(
								dtCapacitacion.getFechaIniProgramada())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaIniProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaIniProgramada() + " :: "+ dtCapacitacionBk.getFechaIniProgramada());
								}
							cambios = true;
							dtCapacitacion.setFechaIniProgramada(dtCapacitacionBk.getFechaIniProgramada());
						}
					} else if (dtCapacitacionBk.getFechaIniProgramada() == null
							&& dtCapacitacion.getFechaIniProgramada() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaIniProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaIniProgramada() + " :: "+ dtCapacitacionBk.getFechaIniProgramada());
								}
							cambios = true;
							dtCapacitacion.setFechaIniProgramada(dtCapacitacionBk.getFechaIniProgramada());
						
					} else if (dtCapacitacionBk.getFechaIniProgramada() != null
							&& dtCapacitacion.getFechaIniProgramada() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaIniProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaIniProgramada() + " :: "+ dtCapacitacionBk.getFechaIniProgramada());
								}
							cambios = true;			
							dtCapacitacion.setFechaIniProgramada(dtCapacitacionBk.getFechaIniProgramada());
					}
				if (dtCapacitacionBk.getFechaFinProgramada() != null
							&& dtCapacitacion.getFechaFinProgramada() != null) {
						if (!dtCapacitacionBk.getFechaFinProgramada().equals(
								dtCapacitacion.getFechaFinProgramada())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinProgramada() + " :: "+ dtCapacitacionBk.getFechaFinProgramada());
								}
							cambios = true;
							dtCapacitacion.setFechaFinProgramada(dtCapacitacionBk.getFechaFinProgramada());
						}
					} else if (dtCapacitacionBk.getFechaFinProgramada() == null
							&& dtCapacitacion.getFechaFinProgramada() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinProgramada() + " :: "+ dtCapacitacionBk.getFechaFinProgramada());
								}
							cambios = true;
							dtCapacitacion.setFechaFinProgramada(dtCapacitacionBk.getFechaFinProgramada());
						
					} else if (dtCapacitacionBk.getFechaFinProgramada() != null
							&& dtCapacitacion.getFechaFinProgramada() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaFinProgramada"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaFinProgramada() + " :: "+ dtCapacitacionBk.getFechaFinProgramada());
								}
							cambios = true;			
							dtCapacitacion.setFechaFinProgramada(dtCapacitacionBk.getFechaFinProgramada());
					}
				if (dtCapacitacionBk.getFechaSoli() != null
							&& dtCapacitacion.getFechaSoli() != null) {
						if (!dtCapacitacionBk.getFechaSoli().equals(
								dtCapacitacion.getFechaSoli())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaSoli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaSoli() + " :: "+ dtCapacitacionBk.getFechaSoli());
								}
							cambios = true;
							dtCapacitacion.setFechaSoli(dtCapacitacionBk.getFechaSoli());
						}
					} else if (dtCapacitacionBk.getFechaSoli() == null
							&& dtCapacitacion.getFechaSoli() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaSoli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaSoli() + " :: "+ dtCapacitacionBk.getFechaSoli());
								}
							cambios = true;
							dtCapacitacion.setFechaSoli(dtCapacitacionBk.getFechaSoli());
						
					} else if (dtCapacitacionBk.getFechaSoli() != null
							&& dtCapacitacion.getFechaSoli() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaSoli"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaSoli() + " :: "+ dtCapacitacionBk.getFechaSoli());
								}
							cambios = true;			
							dtCapacitacion.setFechaSoli(dtCapacitacionBk.getFechaSoli());
					}
				if (dtCapacitacionBk.getStdIddoc() != null
							&& dtCapacitacion.getStdIddoc() != null) {
						if (!dtCapacitacionBk.getStdIddoc().equals(
								dtCapacitacion.getStdIddoc())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdIddoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdIddoc() + " :: "+ dtCapacitacionBk.getStdIddoc());
								}
							cambios = true;
							dtCapacitacion.setStdIddoc(dtCapacitacionBk.getStdIddoc());
						}
					} else if (dtCapacitacionBk.getStdIddoc() == null
							&& dtCapacitacion.getStdIddoc() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdIddoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdIddoc() + " :: "+ dtCapacitacionBk.getStdIddoc());
								}
							cambios = true;
							dtCapacitacion.setStdIddoc(dtCapacitacionBk.getStdIddoc());
						
					} else if (dtCapacitacionBk.getStdIddoc() != null
							&& dtCapacitacion.getStdIddoc() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdIddoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdIddoc() + " :: "+ dtCapacitacionBk.getStdIddoc());
								}
							cambios = true;			
							dtCapacitacion.setStdIddoc(dtCapacitacionBk.getStdIddoc());
					}
				 
		            if (dtCapacitacionBk.getStdNumeroSid() != null
						&& dtCapacitacion.getStdNumeroSid() != null) {
					if (!dtCapacitacionBk.getStdNumeroSid().equals(
						dtCapacitacion.getStdNumeroSid())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroSid"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroSid() + " :: "+ dtCapacitacionBk.getStdNumeroSid());								
						}
						cambios = true;
						dtCapacitacion.setStdNumeroSid(dtCapacitacionBk.getStdNumeroSid());
					}
				} else if (dtCapacitacionBk.getStdNumeroSid() == null
						&& dtCapacitacion.getStdNumeroSid() != null) {
					if (dtCapacitacion.getStdNumeroSid().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroSid"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroSid() + " :: "+ dtCapacitacionBk.getStdNumeroSid());
						}
						cambios = true;
						dtCapacitacion.setStdNumeroSid(dtCapacitacionBk.getStdNumeroSid());
					}
				} else if (dtCapacitacionBk.getStdNumeroSid() != null
						&& dtCapacitacion.getStdNumeroSid() == null) {
					if (dtCapacitacionBk.getStdNumeroSid().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroSid"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroSid() + " :: "+ dtCapacitacionBk.getStdNumeroSid());
						}
						cambios = true;
						dtCapacitacion.setStdNumeroSid(dtCapacitacionBk.getStdNumeroSid());
					}
				}
				if (dtCapacitacionBk.getStdNumeroAnio() != null
							&& dtCapacitacion.getStdNumeroAnio() != null) {
						if (!dtCapacitacionBk.getStdNumeroAnio().equals(
								dtCapacitacion.getStdNumeroAnio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroAnio"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroAnio() + " :: "+ dtCapacitacionBk.getStdNumeroAnio());
								}
							cambios = true;
							dtCapacitacion.setStdNumeroAnio(dtCapacitacionBk.getStdNumeroAnio());
						}
					} else if (dtCapacitacionBk.getStdNumeroAnio() == null
							&& dtCapacitacion.getStdNumeroAnio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroAnio"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroAnio() + " :: "+ dtCapacitacionBk.getStdNumeroAnio());
								}
							cambios = true;
							dtCapacitacion.setStdNumeroAnio(dtCapacitacionBk.getStdNumeroAnio());
						
					} else if (dtCapacitacionBk.getStdNumeroAnio() != null
							&& dtCapacitacion.getStdNumeroAnio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroAnio"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroAnio() + " :: "+ dtCapacitacionBk.getStdNumeroAnio());
								}
							cambios = true;			
							dtCapacitacion.setStdNumeroAnio(dtCapacitacionBk.getStdNumeroAnio());
					}
				 
		            if (dtCapacitacionBk.getStdNumeroDoc() != null
						&& dtCapacitacion.getStdNumeroDoc() != null) {
					if (!dtCapacitacionBk.getStdNumeroDoc().equals(
						dtCapacitacion.getStdNumeroDoc())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroDoc() + " :: "+ dtCapacitacionBk.getStdNumeroDoc());								
						}
						cambios = true;
						dtCapacitacion.setStdNumeroDoc(dtCapacitacionBk.getStdNumeroDoc());
					}
				} else if (dtCapacitacionBk.getStdNumeroDoc() == null
						&& dtCapacitacion.getStdNumeroDoc() != null) {
					if (dtCapacitacion.getStdNumeroDoc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroDoc() + " :: "+ dtCapacitacionBk.getStdNumeroDoc());
						}
						cambios = true;
						dtCapacitacion.setStdNumeroDoc(dtCapacitacionBk.getStdNumeroDoc());
					}
				} else if (dtCapacitacionBk.getStdNumeroDoc() != null
						&& dtCapacitacion.getStdNumeroDoc() == null) {
					if (dtCapacitacionBk.getStdNumeroDoc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdNumeroDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdNumeroDoc() + " :: "+ dtCapacitacionBk.getStdNumeroDoc());
						}
						cambios = true;
						dtCapacitacion.setStdNumeroDoc(dtCapacitacionBk.getStdNumeroDoc());
					}
				}
				if (dtCapacitacionBk.getStdAsunto() != null
							&& dtCapacitacion.getStdAsunto() != null) {
						if (!dtCapacitacionBk.getStdAsunto().equals(
								dtCapacitacion.getStdAsunto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdAsunto"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdAsunto() + " :: "+ dtCapacitacionBk.getStdAsunto());
								}
							cambios = true;
							dtCapacitacion.setStdAsunto(dtCapacitacionBk.getStdAsunto());
						}
					} else if (dtCapacitacionBk.getStdAsunto() == null
							&& dtCapacitacion.getStdAsunto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdAsunto"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdAsunto() + " :: "+ dtCapacitacionBk.getStdAsunto());
								}
							cambios = true;
							dtCapacitacion.setStdAsunto(dtCapacitacionBk.getStdAsunto());
						
					} else if (dtCapacitacionBk.getStdAsunto() != null
							&& dtCapacitacion.getStdAsunto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdAsunto"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdAsunto() + " :: "+ dtCapacitacionBk.getStdAsunto());
								}
							cambios = true;			
							dtCapacitacion.setStdAsunto(dtCapacitacionBk.getStdAsunto());
					}
				 
		            if (dtCapacitacionBk.getStdTipoDoc() != null
						&& dtCapacitacion.getStdTipoDoc() != null) {
					if (!dtCapacitacionBk.getStdTipoDoc().equals(
						dtCapacitacion.getStdTipoDoc())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdTipoDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdTipoDoc() + " :: "+ dtCapacitacionBk.getStdTipoDoc());								
						}
						cambios = true;
						dtCapacitacion.setStdTipoDoc(dtCapacitacionBk.getStdTipoDoc());
					}
				} else if (dtCapacitacionBk.getStdTipoDoc() == null
						&& dtCapacitacion.getStdTipoDoc() != null) {
					if (dtCapacitacion.getStdTipoDoc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdTipoDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdTipoDoc() + " :: "+ dtCapacitacionBk.getStdTipoDoc());
						}
						cambios = true;
						dtCapacitacion.setStdTipoDoc(dtCapacitacionBk.getStdTipoDoc());
					}
				} else if (dtCapacitacionBk.getStdTipoDoc() != null
						&& dtCapacitacion.getStdTipoDoc() == null) {
					if (dtCapacitacionBk.getStdTipoDoc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdTipoDoc"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdTipoDoc() + " :: "+ dtCapacitacionBk.getStdTipoDoc());
						}
						cambios = true;
						dtCapacitacion.setStdTipoDoc(dtCapacitacionBk.getStdTipoDoc());
					}
				}
				if (dtCapacitacionBk.getStdFechaRecepcion() != null
							&& dtCapacitacion.getStdFechaRecepcion() != null) {
						if (!dtCapacitacionBk.getStdFechaRecepcion().equals(
								dtCapacitacion.getStdFechaRecepcion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdFechaRecepcion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdFechaRecepcion() + " :: "+ dtCapacitacionBk.getStdFechaRecepcion());
								}
							cambios = true;
							dtCapacitacion.setStdFechaRecepcion(dtCapacitacionBk.getStdFechaRecepcion());
						}
					} else if (dtCapacitacionBk.getStdFechaRecepcion() == null
							&& dtCapacitacion.getStdFechaRecepcion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdFechaRecepcion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdFechaRecepcion() + " :: "+ dtCapacitacionBk.getStdFechaRecepcion());
								}
							cambios = true;
							dtCapacitacion.setStdFechaRecepcion(dtCapacitacionBk.getStdFechaRecepcion());
						
					} else if (dtCapacitacionBk.getStdFechaRecepcion() != null
							&& dtCapacitacion.getStdFechaRecepcion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdFechaRecepcion"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdFechaRecepcion() + " :: "+ dtCapacitacionBk.getStdFechaRecepcion());
								}
							cambios = true;			
							dtCapacitacion.setStdFechaRecepcion(dtCapacitacionBk.getStdFechaRecepcion());
					}
				 
		            if (dtCapacitacionBk.getStdModalidadIng() != null
						&& dtCapacitacion.getStdModalidadIng() != null) {
					if (!dtCapacitacionBk.getStdModalidadIng().equals(
						dtCapacitacion.getStdModalidadIng())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdModalidadIng"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdModalidadIng() + " :: "+ dtCapacitacionBk.getStdModalidadIng());								
						}
						cambios = true;
						dtCapacitacion.setStdModalidadIng(dtCapacitacionBk.getStdModalidadIng());
					}
				} else if (dtCapacitacionBk.getStdModalidadIng() == null
						&& dtCapacitacion.getStdModalidadIng() != null) {
					if (dtCapacitacion.getStdModalidadIng().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdModalidadIng"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdModalidadIng() + " :: "+ dtCapacitacionBk.getStdModalidadIng());
						}
						cambios = true;
						dtCapacitacion.setStdModalidadIng(dtCapacitacionBk.getStdModalidadIng());
					}
				} else if (dtCapacitacionBk.getStdModalidadIng() != null
						&& dtCapacitacion.getStdModalidadIng() == null) {
					if (dtCapacitacionBk.getStdModalidadIng().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:StdModalidadIng"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getStdModalidadIng() + " :: "+ dtCapacitacionBk.getStdModalidadIng());
						}
						cambios = true;
						dtCapacitacion.setStdModalidadIng(dtCapacitacionBk.getStdModalidadIng());
					}
				}
				if (dtCapacitacionBk.getFlagEjec() != null
							&& dtCapacitacion.getFlagEjec() != null) {
						if (!dtCapacitacionBk.getFlagEjec().equals(
								dtCapacitacion.getFlagEjec())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagEjec() + " :: "+ dtCapacitacionBk.getFlagEjec());
								}
							cambios = true;
							dtCapacitacion.setFlagEjec(dtCapacitacionBk.getFlagEjec());
						}
					} else if (dtCapacitacionBk.getFlagEjec() == null
							&& dtCapacitacion.getFlagEjec() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagEjec() + " :: "+ dtCapacitacionBk.getFlagEjec());
								}
							cambios = true;
							dtCapacitacion.setFlagEjec(dtCapacitacionBk.getFlagEjec());
						
					} else if (dtCapacitacionBk.getFlagEjec() != null
							&& dtCapacitacion.getFlagEjec() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FlagEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFlagEjec() + " :: "+ dtCapacitacionBk.getFlagEjec());
								}
							cambios = true;			
							dtCapacitacion.setFlagEjec(dtCapacitacionBk.getFlagEjec());
					}
				if (dtCapacitacionBk.getMotivoEjec() != null
							&& dtCapacitacion.getMotivoEjec() != null) {
						if (!dtCapacitacionBk.getMotivoEjec().equals(
								dtCapacitacion.getMotivoEjec())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:MotivoEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getMotivoEjec() + " :: "+ dtCapacitacionBk.getMotivoEjec());
								}
							cambios = true;
							dtCapacitacion.setMotivoEjec(dtCapacitacionBk.getMotivoEjec());
						}
					} else if (dtCapacitacionBk.getMotivoEjec() == null
							&& dtCapacitacion.getMotivoEjec() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:MotivoEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getMotivoEjec() + " :: "+ dtCapacitacionBk.getMotivoEjec());
								}
							cambios = true;
							dtCapacitacion.setMotivoEjec(dtCapacitacionBk.getMotivoEjec());
						
					} else if (dtCapacitacionBk.getMotivoEjec() != null
							&& dtCapacitacion.getMotivoEjec() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:MotivoEjec"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getMotivoEjec() + " :: "+ dtCapacitacionBk.getMotivoEjec());
								}
							cambios = true;			
							dtCapacitacion.setMotivoEjec(dtCapacitacionBk.getMotivoEjec());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCapacitacion(DtCapacitacionBk dtCapacitacionBk, DtCapacitacion dtCapacitacion, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				
				                                 
                                      if (dtCapacitacionBk.getIdusserCrea() != null
							&& dtCapacitacion.getIdusserCrea() != null) {
						if (!dtCapacitacionBk.getIdusserCrea().equals(
								dtCapacitacion.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserCrea() + " :: "+ dtCapacitacionBk.getIdusserCrea());
								}
							cambios = true;
							dtCapacitacion.setIdusserCrea(dtCapacitacionBk.getIdusserCrea());
						}
					} else if (dtCapacitacionBk.getIdusserCrea() == null
							&& dtCapacitacion.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserCrea() + " :: "+ dtCapacitacionBk.getIdusserCrea());
								}
							cambios = true;
							dtCapacitacion.setIdusserCrea(dtCapacitacionBk.getIdusserCrea());
						
					} else if (dtCapacitacionBk.getIdusserCrea() != null
							&& dtCapacitacion.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserCrea() + " :: "+ dtCapacitacionBk.getIdusserCrea());
								}
							cambios = true;			
							dtCapacitacion.setIdusserCrea(dtCapacitacionBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtCapacitacionBk.getIdusserModif() != null
							&& dtCapacitacion.getIdusserModif() != null) {
						if (!dtCapacitacionBk.getIdusserModif().equals(
								dtCapacitacion.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserModif() + " :: "+ dtCapacitacionBk.getIdusserModif());
								}
							cambios = true;
							dtCapacitacion.setIdusserModif(dtCapacitacionBk.getIdusserModif());
						}
					} else if (dtCapacitacionBk.getIdusserModif() == null
							&& dtCapacitacion.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserModif() + " :: "+ dtCapacitacionBk.getIdusserModif());
								}
							cambios = true;
							dtCapacitacion.setIdusserModif(dtCapacitacionBk.getIdusserModif());
						
					} else if (dtCapacitacionBk.getIdusserModif() != null
							&& dtCapacitacion.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:IdusserModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getIdusserModif() + " :: "+ dtCapacitacionBk.getIdusserModif());
								}
							cambios = true;			
							dtCapacitacion.setIdusserModif(dtCapacitacionBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtCapacitacionBk.getFechaCrea() != null
							&& dtCapacitacion.getFechaCrea() != null) {
						if (!dtCapacitacionBk.getFechaCrea().equals(
								dtCapacitacion.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaCrea() + " :: "+ dtCapacitacionBk.getFechaCrea());
								}
							cambios = true;
							dtCapacitacion.setFechaCrea(dtCapacitacionBk.getFechaCrea());
						}
					} else if (dtCapacitacionBk.getFechaCrea() == null
							&& dtCapacitacion.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaCrea() + " :: "+ dtCapacitacionBk.getFechaCrea());
								}
							cambios = true;
							dtCapacitacion.setFechaCrea(dtCapacitacionBk.getFechaCrea());
						
					} else if (dtCapacitacionBk.getFechaCrea() != null
							&& dtCapacitacion.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaCrea"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaCrea() + " :: "+ dtCapacitacionBk.getFechaCrea());
								}
							cambios = true;			
							dtCapacitacion.setFechaCrea(dtCapacitacionBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCapacitacionBk.getFechaModif() != null
							&& dtCapacitacion.getFechaModif() != null) {
						if (!dtCapacitacionBk.getFechaModif().equals(
								dtCapacitacion.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaModif() + " :: "+ dtCapacitacionBk.getFechaModif());
								}
							cambios = true;
							dtCapacitacion.setFechaModif(dtCapacitacionBk.getFechaModif());
						}
					} else if (dtCapacitacionBk.getFechaModif() == null
							&& dtCapacitacion.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaModif() + " :: "+ dtCapacitacionBk.getFechaModif());
								}
							cambios = true;
							dtCapacitacion.setFechaModif(dtCapacitacionBk.getFechaModif());
						
					} else if (dtCapacitacionBk.getFechaModif() != null
							&& dtCapacitacion.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:FechaModif"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getFechaModif() + " :: "+ dtCapacitacionBk.getFechaModif());
								}
							cambios = true;			
							dtCapacitacion.setFechaModif(dtCapacitacionBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtCapacitacionBk.getEstado() != null
							&& dtCapacitacion.getEstado() != null) {
						if (!dtCapacitacionBk.getEstado().equals(
								dtCapacitacion.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Estado"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getEstado() + " :: "+ dtCapacitacionBk.getEstado());
								}
							cambios = true;
							dtCapacitacion.setEstado(dtCapacitacionBk.getEstado());
						}
					} else if (dtCapacitacionBk.getEstado() == null
							&& dtCapacitacion.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Estado"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getEstado() + " :: "+ dtCapacitacionBk.getEstado());
								}
							cambios = true;
							dtCapacitacion.setEstado(dtCapacitacionBk.getEstado());
						
					} else if (dtCapacitacionBk.getEstado() != null
							&& dtCapacitacion.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Estado"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getEstado() + " :: "+ dtCapacitacionBk.getEstado());
								}
							cambios = true;			
							dtCapacitacion.setEstado(dtCapacitacionBk.getEstado());
					}
                                
				
				
				
				
				
				                                 
                                      if (dtCapacitacionBk.getRtmaddress() != null
							&& dtCapacitacion.getRtmaddress() != null) {
						if (!dtCapacitacionBk.getRtmaddress().equals(
								dtCapacitacion.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddress"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddress() + " :: "+ dtCapacitacionBk.getRtmaddress());
								}
							cambios = true;
							dtCapacitacion.setRtmaddress(dtCapacitacionBk.getRtmaddress());
						}
					} else if (dtCapacitacionBk.getRtmaddress() == null
							&& dtCapacitacion.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddress"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddress() + " :: "+ dtCapacitacionBk.getRtmaddress());
								}
							cambios = true;
							dtCapacitacion.setRtmaddress(dtCapacitacionBk.getRtmaddress());
						
					} else if (dtCapacitacionBk.getRtmaddress() != null
							&& dtCapacitacion.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddress"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddress() + " :: "+ dtCapacitacionBk.getRtmaddress());
								}
							cambios = true;			
							dtCapacitacion.setRtmaddress(dtCapacitacionBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCapacitacionBk.getRtmaddressrst() != null
							&& dtCapacitacion.getRtmaddressrst() != null) {
						if (!dtCapacitacionBk.getRtmaddressrst().equals(
								dtCapacitacion.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddressrst"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddressrst() + " :: "+ dtCapacitacionBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapacitacion.setRtmaddressrst(dtCapacitacionBk.getRtmaddressrst());
						}
					} else if (dtCapacitacionBk.getRtmaddressrst() == null
							&& dtCapacitacion.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddressrst"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddressrst() + " :: "+ dtCapacitacionBk.getRtmaddressrst());
								}
							cambios = true;
							dtCapacitacion.setRtmaddressrst(dtCapacitacionBk.getRtmaddressrst());
						
					} else if (dtCapacitacionBk.getRtmaddressrst() != null
							&& dtCapacitacion.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCapacitacion:Rtmaddressrst"+" :: "+dtCapacitacionBk.getIdCapacitacion().toString()+" :: "+ dtCapacitacion.getRtmaddressrst() + " :: "+ dtCapacitacionBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCapacitacion.setRtmaddressrst(dtCapacitacionBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			return cambios;
	}
}