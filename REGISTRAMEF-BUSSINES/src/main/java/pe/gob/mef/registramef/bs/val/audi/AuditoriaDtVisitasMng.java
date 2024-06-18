package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtVisitas;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasBk;

/**
 * DT_VISITAS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DATOS REGISTRADOS EN UNA VISITA "VISITAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtVisitasMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtVisitasMng.class.getName());
	
	// PURIBE 14032024 - INICIO -->
		public static boolean auditarCambiosDtVisitas(DtVisitasBk dtVisitasBk, DtVisitas dtVisitas, 
		Long iduser, 
		String user, 
		String rmtaddress, 
		int nivel 
		)
		{
			boolean cambios = false;
			
			if (dtVisitasBk.getFechaVisita() != null
								&& dtVisitas.getFechaVisita() != null) {
							if (!dtVisitasBk.getFechaVisita().equals(
									dtVisitas.getFechaVisita())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaVisita"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaVisita() + " :: "+ dtVisitasBk.getFechaVisita());
									}
								cambios = true;
								dtVisitas.setFechaVisita(dtVisitasBk.getFechaVisita());
							}
						} else if (dtVisitasBk.getFechaVisita() == null
								&& dtVisitas.getFechaVisita() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaVisita"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaVisita() + " :: "+ dtVisitasBk.getFechaVisita());
									}
								cambios = true;
								dtVisitas.setFechaVisita(dtVisitasBk.getFechaVisita());
							
						} else if (dtVisitasBk.getFechaVisita() != null
								&& dtVisitas.getFechaVisita() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaVisita"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaVisita() + " :: "+ dtVisitasBk.getFechaVisita());
									}
								cambios = true;			
								dtVisitas.setFechaVisita(dtVisitasBk.getFechaVisita());
						}
			
			//PURIBE
					if (dtVisitasBk.getEstado() != null
							&& dtVisitas.getEstado() != null) {
						if (!dtVisitasBk.getEstado().equals(
								dtVisitas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;
							dtVisitas.setEstado(dtVisitasBk.getEstado());
						}
					} else if (dtVisitasBk.getEstado() == null
							&& dtVisitas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;
							dtVisitas.setEstado(dtVisitasBk.getEstado());
						
					} else if (dtVisitasBk.getEstado() != null
							&& dtVisitas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;			
							dtVisitas.setEstado(dtVisitasBk.getEstado());
					}	
			
					//PURIBE
					if (dtVisitasBk.getConclusion() != null
								&& dtVisitas.getConclusion() != null) {
							if (!dtVisitasBk.getConclusion().equals(
									dtVisitas.getConclusion())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Conclusion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getConclusion() + " :: "+ dtVisitasBk.getConclusion());
									}
								cambios = true;
								dtVisitas.setConclusion(dtVisitasBk.getConclusion());
							}
						} else if (dtVisitasBk.getConclusion() == null
								&& dtVisitas.getConclusion() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Conclusion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getConclusion() + " :: "+ dtVisitasBk.getConclusion());
									}
								cambios = true;
								dtVisitas.setConclusion(dtVisitasBk.getConclusion());
							
						} else if (dtVisitasBk.getConclusion() != null
								&& dtVisitas.getConclusion() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Conclusion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getConclusion() + " :: "+ dtVisitasBk.getConclusion());
									}
								cambios = true;			
								dtVisitas.setConclusion(dtVisitasBk.getConclusion());
						}
					if (dtVisitasBk.getIdOrigen() != null
								&& dtVisitas.getIdOrigen() != null) {
							if (!dtVisitasBk.getIdOrigen().equals(
									dtVisitas.getIdOrigen())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdOrigen"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdOrigen() + " :: "+ dtVisitasBk.getIdOrigen());
									}
								cambios = true;
								dtVisitas.setIdOrigen(dtVisitasBk.getIdOrigen());
							}
						} else if (dtVisitasBk.getIdOrigen() == null
								&& dtVisitas.getIdOrigen() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdOrigen"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdOrigen() + " :: "+ dtVisitasBk.getIdOrigen());
									}
								cambios = true;
								dtVisitas.setIdOrigen(dtVisitasBk.getIdOrigen());
							
						} else if (dtVisitasBk.getIdOrigen() != null
								&& dtVisitas.getIdOrigen() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdOrigen"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdOrigen() + " :: "+ dtVisitasBk.getIdOrigen());
									}
								cambios = true;			
								dtVisitas.setIdOrigen(dtVisitasBk.getIdOrigen());
						}
					if (dtVisitasBk.getIdProgramacion() != null
								&& dtVisitas.getIdProgramacion() != null) {
							if (!dtVisitasBk.getIdProgramacion().equals(
									dtVisitas.getIdProgramacion())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdProgramacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdProgramacion() + " :: "+ dtVisitasBk.getIdProgramacion());
									}
								cambios = true;
								dtVisitas.setIdProgramacion(dtVisitasBk.getIdProgramacion());
							}
						} else if (dtVisitasBk.getIdProgramacion() == null
								&& dtVisitas.getIdProgramacion() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdProgramacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdProgramacion() + " :: "+ dtVisitasBk.getIdProgramacion());
									}
								cambios = true;
								dtVisitas.setIdProgramacion(dtVisitasBk.getIdProgramacion());
							
						} else if (dtVisitasBk.getIdProgramacion() != null
								&& dtVisitas.getIdProgramacion() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdProgramacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdProgramacion() + " :: "+ dtVisitasBk.getIdProgramacion());
									}
								cambios = true;			
								dtVisitas.setIdProgramacion(dtVisitasBk.getIdProgramacion());
						}
					if (dtVisitasBk.getIdModalidad() != null
								&& dtVisitas.getIdModalidad() != null) {
							if (!dtVisitasBk.getIdModalidad().equals(
									dtVisitas.getIdModalidad())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdModalidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdModalidad() + " :: "+ dtVisitasBk.getIdModalidad());
									}
								cambios = true;
								dtVisitas.setIdModalidad(dtVisitasBk.getIdModalidad());
							}
						} else if (dtVisitasBk.getIdModalidad() == null
								&& dtVisitas.getIdModalidad() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdModalidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdModalidad() + " :: "+ dtVisitasBk.getIdModalidad());
									}
								cambios = true;
								dtVisitas.setIdModalidad(dtVisitasBk.getIdModalidad());
							
						} else if (dtVisitasBk.getIdModalidad() != null
								&& dtVisitas.getIdModalidad() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdModalidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdModalidad() + " :: "+ dtVisitasBk.getIdModalidad());
									}
								cambios = true;			
								dtVisitas.setIdModalidad(dtVisitasBk.getIdModalidad());
						}
					if (dtVisitasBk.getIdTipo() != null
								&& dtVisitas.getIdTipo() != null) {
							if (!dtVisitasBk.getIdTipo().equals(
									dtVisitas.getIdTipo())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdTipo"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdTipo() + " :: "+ dtVisitasBk.getIdTipo());
									}
								cambios = true;
								dtVisitas.setIdTipo(dtVisitasBk.getIdTipo());
							}
						} else if (dtVisitasBk.getIdTipo() == null
								&& dtVisitas.getIdTipo() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdTipo"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdTipo() + " :: "+ dtVisitasBk.getIdTipo());
									}
								cambios = true;
								dtVisitas.setIdTipo(dtVisitasBk.getIdTipo());
							
						} else if (dtVisitasBk.getIdTipo() != null
								&& dtVisitas.getIdTipo() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdTipo"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdTipo() + " :: "+ dtVisitasBk.getIdTipo());
									}
								cambios = true;			
								dtVisitas.setIdTipo(dtVisitasBk.getIdTipo());
						}
					if (dtVisitasBk.getIdLugar() != null
								&& dtVisitas.getIdLugar() != null) {
							if (!dtVisitasBk.getIdLugar().equals(
									dtVisitas.getIdLugar())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdLugar"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdLugar() + " :: "+ dtVisitasBk.getIdLugar());
									}
								cambios = true;
								dtVisitas.setIdLugar(dtVisitasBk.getIdLugar());
							}
						} else if (dtVisitasBk.getIdLugar() == null
								&& dtVisitas.getIdLugar() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdLugar"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdLugar() + " :: "+ dtVisitasBk.getIdLugar());
									}
								cambios = true;
								dtVisitas.setIdLugar(dtVisitasBk.getIdLugar());
							
						} else if (dtVisitasBk.getIdLugar() != null
								&& dtVisitas.getIdLugar() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdLugar"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdLugar() + " :: "+ dtVisitasBk.getIdLugar());
									}
								cambios = true;			
								dtVisitas.setIdLugar(dtVisitasBk.getIdLugar());
						}
					if (dtVisitasBk.getIdEntidad() != null
								&& dtVisitas.getIdEntidad() != null) {
							if (!dtVisitasBk.getIdEntidad().equals(
									dtVisitas.getIdEntidad())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdEntidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdEntidad() + " :: "+ dtVisitasBk.getIdEntidad());
									}
								cambios = true;
								dtVisitas.setIdEntidad(dtVisitasBk.getIdEntidad());
							}
						} else if (dtVisitasBk.getIdEntidad() == null
								&& dtVisitas.getIdEntidad() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdEntidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdEntidad() + " :: "+ dtVisitasBk.getIdEntidad());
									}
								cambios = true;
								dtVisitas.setIdEntidad(dtVisitasBk.getIdEntidad());
							
						} else if (dtVisitasBk.getIdEntidad() != null
								&& dtVisitas.getIdEntidad() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdEntidad"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdEntidad() + " :: "+ dtVisitasBk.getIdEntidad());
									}
								cambios = true;			
								dtVisitas.setIdEntidad(dtVisitasBk.getIdEntidad());
						}
					if (dtVisitasBk.getIdSede() != null
								&& dtVisitas.getIdSede() != null) {
							if (!dtVisitasBk.getIdSede().equals(
									dtVisitas.getIdSede())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSede"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSede() + " :: "+ dtVisitasBk.getIdSede());
									}
								cambios = true;
								dtVisitas.setIdSede(dtVisitasBk.getIdSede());
							}
						} else if (dtVisitasBk.getIdSede() == null
								&& dtVisitas.getIdSede() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSede"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSede() + " :: "+ dtVisitasBk.getIdSede());
									}
								cambios = true;
								dtVisitas.setIdSede(dtVisitasBk.getIdSede());
							
						} else if (dtVisitasBk.getIdSede() != null
								&& dtVisitas.getIdSede() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSede"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSede() + " :: "+ dtVisitasBk.getIdSede());
									}
								cambios = true;			
								dtVisitas.setIdSede(dtVisitasBk.getIdSede());
						}
					if (dtVisitasBk.getIdSistAdm() != null
								&& dtVisitas.getIdSistAdm() != null) {
							if (!dtVisitasBk.getIdSistAdm().equals(
									dtVisitas.getIdSistAdm())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSistAdm"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSistAdm() + " :: "+ dtVisitasBk.getIdSistAdm());
									}
								cambios = true;
								dtVisitas.setIdSistAdm(dtVisitasBk.getIdSistAdm());
							}
						} else if (dtVisitasBk.getIdSistAdm() == null
								&& dtVisitas.getIdSistAdm() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSistAdm"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSistAdm() + " :: "+ dtVisitasBk.getIdSistAdm());
									}
								cambios = true;
								dtVisitas.setIdSistAdm(dtVisitasBk.getIdSistAdm());
							
						} else if (dtVisitasBk.getIdSistAdm() != null
								&& dtVisitas.getIdSistAdm() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdSistAdm"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdSistAdm() + " :: "+ dtVisitasBk.getIdSistAdm());
									}
								cambios = true;			
								dtVisitas.setIdSistAdm(dtVisitasBk.getIdSistAdm());
						}
					if (dtVisitasBk.getIdFinancia() != null
								&& dtVisitas.getIdFinancia() != null) {
							if (!dtVisitasBk.getIdFinancia().equals(
									dtVisitas.getIdFinancia())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdFinancia"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdFinancia() + " :: "+ dtVisitasBk.getIdFinancia());
									}
								cambios = true;
								dtVisitas.setIdFinancia(dtVisitasBk.getIdFinancia());
							}
						} else if (dtVisitasBk.getIdFinancia() == null
								&& dtVisitas.getIdFinancia() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdFinancia"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdFinancia() + " :: "+ dtVisitasBk.getIdFinancia());
									}
								cambios = true;
								dtVisitas.setIdFinancia(dtVisitasBk.getIdFinancia());
							
						} else if (dtVisitasBk.getIdFinancia() != null
								&& dtVisitas.getIdFinancia() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdFinancia"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdFinancia() + " :: "+ dtVisitasBk.getIdFinancia());
									}
								cambios = true;			
								dtVisitas.setIdFinancia(dtVisitasBk.getIdFinancia());
						}
					if (dtVisitasBk.getFechaFinalizacion() != null
								&& dtVisitas.getFechaFinalizacion() != null) {
							if (!dtVisitasBk.getFechaFinalizacion().equals(
									dtVisitas.getFechaFinalizacion())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaFinalizacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaFinalizacion() + " :: "+ dtVisitasBk.getFechaFinalizacion());
									}
								cambios = true;
								dtVisitas.setFechaFinalizacion(dtVisitasBk.getFechaFinalizacion());
							}
						} else if (dtVisitasBk.getFechaFinalizacion() == null
								&& dtVisitas.getFechaFinalizacion() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaFinalizacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaFinalizacion() + " :: "+ dtVisitasBk.getFechaFinalizacion());
									}
								cambios = true;
								dtVisitas.setFechaFinalizacion(dtVisitasBk.getFechaFinalizacion());
							
						} else if (dtVisitasBk.getFechaFinalizacion() != null
								&& dtVisitas.getFechaFinalizacion() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaFinalizacion"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaFinalizacion() + " :: "+ dtVisitasBk.getFechaFinalizacion());
									}
								cambios = true;			
								dtVisitas.setFechaFinalizacion(dtVisitasBk.getFechaFinalizacion());
						}
					if (dtVisitasBk.getFechaProgramada() != null
								&& dtVisitas.getFechaProgramada() != null) {
							if (!dtVisitasBk.getFechaProgramada().equals(
									dtVisitas.getFechaProgramada())) {						
									if(nivel>0){
									log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaProgramada"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaProgramada() + " :: "+ dtVisitasBk.getFechaProgramada());
									}
								cambios = true;
								dtVisitas.setFechaProgramada(dtVisitasBk.getFechaProgramada());
							}
						} else if (dtVisitasBk.getFechaProgramada() == null
								&& dtVisitas.getFechaProgramada() != null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaProgramada"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaProgramada() + " :: "+ dtVisitasBk.getFechaProgramada());
									}
								cambios = true;
								dtVisitas.setFechaProgramada(dtVisitasBk.getFechaProgramada());
							
						} else if (dtVisitasBk.getFechaProgramada() != null
								&& dtVisitas.getFechaProgramada() == null) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaProgramada"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaProgramada() + " :: "+ dtVisitasBk.getFechaProgramada());
									}
								cambios = true;			
								dtVisitas.setFechaProgramada(dtVisitasBk.getFechaProgramada());
						}
					
				
				return cambios;
		}
		// PURIBE 14032024 - FIN-->
	
        public static boolean cambiosEnAuditoriaDtVisitas(DtVisitasBk dtVisitasBk, DtVisitas dtVisitas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (dtVisitasBk.getIdusserCrea() != null
							&& dtVisitas.getIdusserCrea() != null) {
						if (!dtVisitasBk.getIdusserCrea().equals(
								dtVisitas.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserCrea() + " :: "+ dtVisitasBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitas.setIdusserCrea(dtVisitasBk.getIdusserCrea());
						}
					} else if (dtVisitasBk.getIdusserCrea() == null
							&& dtVisitas.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserCrea() + " :: "+ dtVisitasBk.getIdusserCrea());
								}
							cambios = true;
							dtVisitas.setIdusserCrea(dtVisitasBk.getIdusserCrea());
						
					} else if (dtVisitasBk.getIdusserCrea() != null
							&& dtVisitas.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserCrea() + " :: "+ dtVisitasBk.getIdusserCrea());
								}
							cambios = true;			
							dtVisitas.setIdusserCrea(dtVisitasBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtVisitasBk.getIdusserModif() != null
							&& dtVisitas.getIdusserModif() != null) {
						if (!dtVisitasBk.getIdusserModif().equals(
								dtVisitas.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserModif() + " :: "+ dtVisitasBk.getIdusserModif());
								}
							cambios = true;
							dtVisitas.setIdusserModif(dtVisitasBk.getIdusserModif());
						}
					} else if (dtVisitasBk.getIdusserModif() == null
							&& dtVisitas.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserModif() + " :: "+ dtVisitasBk.getIdusserModif());
								}
							cambios = true;
							dtVisitas.setIdusserModif(dtVisitasBk.getIdusserModif());
						
					} else if (dtVisitasBk.getIdusserModif() != null
							&& dtVisitas.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:IdusserModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getIdusserModif() + " :: "+ dtVisitasBk.getIdusserModif());
								}
							cambios = true;			
							dtVisitas.setIdusserModif(dtVisitasBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtVisitasBk.getFechaCrea() != null
							&& dtVisitas.getFechaCrea() != null) {
						if (!dtVisitasBk.getFechaCrea().equals(
								dtVisitas.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaCrea() + " :: "+ dtVisitasBk.getFechaCrea());
								}
							cambios = true;
							dtVisitas.setFechaCrea(dtVisitasBk.getFechaCrea());
						}
					} else if (dtVisitasBk.getFechaCrea() == null
							&& dtVisitas.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaCrea() + " :: "+ dtVisitasBk.getFechaCrea());
								}
							cambios = true;
							dtVisitas.setFechaCrea(dtVisitasBk.getFechaCrea());
						
					} else if (dtVisitasBk.getFechaCrea() != null
							&& dtVisitas.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaCrea"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaCrea() + " :: "+ dtVisitasBk.getFechaCrea());
								}
							cambios = true;			
							dtVisitas.setFechaCrea(dtVisitasBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtVisitasBk.getFechaModif() != null
							&& dtVisitas.getFechaModif() != null) {
						if (!dtVisitasBk.getFechaModif().equals(
								dtVisitas.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaModif() + " :: "+ dtVisitasBk.getFechaModif());
								}
							cambios = true;
							dtVisitas.setFechaModif(dtVisitasBk.getFechaModif());
						}
					} else if (dtVisitasBk.getFechaModif() == null
							&& dtVisitas.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaModif() + " :: "+ dtVisitasBk.getFechaModif());
								}
							cambios = true;
							dtVisitas.setFechaModif(dtVisitasBk.getFechaModif());
						
					} else if (dtVisitasBk.getFechaModif() != null
							&& dtVisitas.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:FechaModif"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getFechaModif() + " :: "+ dtVisitasBk.getFechaModif());
								}
							cambios = true;			
							dtVisitas.setFechaModif(dtVisitasBk.getFechaModif());
					}
                                
				                                 
                                      if (dtVisitasBk.getEstado() != null
							&& dtVisitas.getEstado() != null) {
						if (!dtVisitasBk.getEstado().equals(
								dtVisitas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;
							dtVisitas.setEstado(dtVisitasBk.getEstado());
						}
					} else if (dtVisitasBk.getEstado() == null
							&& dtVisitas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;
							dtVisitas.setEstado(dtVisitasBk.getEstado());
						
					} else if (dtVisitasBk.getEstado() != null
							&& dtVisitas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Estado"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getEstado() + " :: "+ dtVisitasBk.getEstado());
								}
							cambios = true;			
							dtVisitas.setEstado(dtVisitasBk.getEstado());
					}
                                
				
				
				
				
				
				
				                                 
                                      if (dtVisitasBk.getRtmaddress() != null
							&& dtVisitas.getRtmaddress() != null) {
						if (!dtVisitasBk.getRtmaddress().equals(
								dtVisitas.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddress"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddress() + " :: "+ dtVisitasBk.getRtmaddress());
								}
							cambios = true;
							dtVisitas.setRtmaddress(dtVisitasBk.getRtmaddress());
						}
					} else if (dtVisitasBk.getRtmaddress() == null
							&& dtVisitas.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddress"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddress() + " :: "+ dtVisitasBk.getRtmaddress());
								}
							cambios = true;
							dtVisitas.setRtmaddress(dtVisitasBk.getRtmaddress());
						
					} else if (dtVisitasBk.getRtmaddress() != null
							&& dtVisitas.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddress"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddress() + " :: "+ dtVisitasBk.getRtmaddress());
								}
							cambios = true;			
							dtVisitas.setRtmaddress(dtVisitasBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtVisitasBk.getRtmaddressrst() != null
							&& dtVisitas.getRtmaddressrst() != null) {
						if (!dtVisitasBk.getRtmaddressrst().equals(
								dtVisitas.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddressrst"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddressrst() + " :: "+ dtVisitasBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitas.setRtmaddressrst(dtVisitasBk.getRtmaddressrst());
						}
					} else if (dtVisitasBk.getRtmaddressrst() == null
							&& dtVisitas.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddressrst"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddressrst() + " :: "+ dtVisitasBk.getRtmaddressrst());
								}
							cambios = true;
							dtVisitas.setRtmaddressrst(dtVisitasBk.getRtmaddressrst());
						
					} else if (dtVisitasBk.getRtmaddressrst() != null
							&& dtVisitas.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtVisitas:Rtmaddressrst"+" :: "+dtVisitasBk.getIdVisita().toString()+" :: "+ dtVisitas.getRtmaddressrst() + " :: "+ dtVisitasBk.getRtmaddressrst());
								}
							cambios = true;			
							dtVisitas.setRtmaddressrst(dtVisitasBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
			
			return cambios;
	}
}