package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAsistenciaTemas;
import pe.gob.mef.registramef.bs.transfer.bk.DtAsistenciaTemasBk;

/**
 * DT_ASISTENCIA_TEMAS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA "TEMAS DE LA ASISTENCIA"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAsistenciaTemasMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAsistenciaTemasMng.class.getName());
	
	public static boolean auditarCambiosDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, DtAsistenciaTemas dtAsistenciaTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAsistenciaTemasBk.getDetalle() != null
							&& dtAsistenciaTemas.getDetalle() != null) {
						if (!dtAsistenciaTemasBk.getDetalle().equals(
								dtAsistenciaTemas.getDetalle())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Detalle"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getDetalle() + " :: "+ dtAsistenciaTemasBk.getDetalle());
								}
							cambios = true;
							dtAsistenciaTemas.setDetalle(dtAsistenciaTemasBk.getDetalle());
						}
					} else if (dtAsistenciaTemasBk.getDetalle() == null
							&& dtAsistenciaTemas.getDetalle() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Detalle"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getDetalle() + " :: "+ dtAsistenciaTemasBk.getDetalle());
								}
							cambios = true;
							dtAsistenciaTemas.setDetalle(dtAsistenciaTemasBk.getDetalle());
						
					} else if (dtAsistenciaTemasBk.getDetalle() != null
							&& dtAsistenciaTemas.getDetalle() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Detalle"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getDetalle() + " :: "+ dtAsistenciaTemasBk.getDetalle());
								}
							cambios = true;			
							dtAsistenciaTemas.setDetalle(dtAsistenciaTemasBk.getDetalle());
					}
				if (dtAsistenciaTemasBk.getIdAsistencia() != null
							&& dtAsistenciaTemas.getIdAsistencia() != null) {
						if (!dtAsistenciaTemasBk.getIdAsistencia().equals(
								dtAsistenciaTemas.getIdAsistencia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdAsistencia"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdAsistencia() + " :: "+ dtAsistenciaTemasBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaTemas.setIdAsistencia(dtAsistenciaTemasBk.getIdAsistencia());
						}
					} else if (dtAsistenciaTemasBk.getIdAsistencia() == null
							&& dtAsistenciaTemas.getIdAsistencia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdAsistencia"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdAsistencia() + " :: "+ dtAsistenciaTemasBk.getIdAsistencia());
								}
							cambios = true;
							dtAsistenciaTemas.setIdAsistencia(dtAsistenciaTemasBk.getIdAsistencia());
						
					} else if (dtAsistenciaTemasBk.getIdAsistencia() != null
							&& dtAsistenciaTemas.getIdAsistencia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdAsistencia"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdAsistencia() + " :: "+ dtAsistenciaTemasBk.getIdAsistencia());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdAsistencia(dtAsistenciaTemasBk.getIdAsistencia());
					}
				if (dtAsistenciaTemasBk.getIdTema() != null
							&& dtAsistenciaTemas.getIdTema() != null) {
						if (!dtAsistenciaTemasBk.getIdTema().equals(
								dtAsistenciaTemas.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdTema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdTema() + " :: "+ dtAsistenciaTemasBk.getIdTema());
								}
							cambios = true;
							dtAsistenciaTemas.setIdTema(dtAsistenciaTemasBk.getIdTema());
						}
					} else if (dtAsistenciaTemasBk.getIdTema() == null
							&& dtAsistenciaTemas.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdTema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdTema() + " :: "+ dtAsistenciaTemasBk.getIdTema());
								}
							cambios = true;
							dtAsistenciaTemas.setIdTema(dtAsistenciaTemasBk.getIdTema());
						
					} else if (dtAsistenciaTemasBk.getIdTema() != null
							&& dtAsistenciaTemas.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdTema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdTema() + " :: "+ dtAsistenciaTemasBk.getIdTema());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdTema(dtAsistenciaTemasBk.getIdTema());
					}
				if (dtAsistenciaTemasBk.getIdSubtema() != null
							&& dtAsistenciaTemas.getIdSubtema() != null) {
						if (!dtAsistenciaTemasBk.getIdSubtema().equals(
								dtAsistenciaTemas.getIdSubtema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSubtema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSubtema() + " :: "+ dtAsistenciaTemasBk.getIdSubtema());
								}
							cambios = true;
							dtAsistenciaTemas.setIdSubtema(dtAsistenciaTemasBk.getIdSubtema());
						}
					} else if (dtAsistenciaTemasBk.getIdSubtema() == null
							&& dtAsistenciaTemas.getIdSubtema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSubtema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSubtema() + " :: "+ dtAsistenciaTemasBk.getIdSubtema());
								}
							cambios = true;
							dtAsistenciaTemas.setIdSubtema(dtAsistenciaTemasBk.getIdSubtema());
						
					} else if (dtAsistenciaTemasBk.getIdSubtema() != null
							&& dtAsistenciaTemas.getIdSubtema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSubtema"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSubtema() + " :: "+ dtAsistenciaTemasBk.getIdSubtema());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdSubtema(dtAsistenciaTemasBk.getIdSubtema());
					}
				if (dtAsistenciaTemasBk.getIdUsuinterno() != null
							&& dtAsistenciaTemas.getIdUsuinterno() != null) {
						if (!dtAsistenciaTemasBk.getIdUsuinterno().equals(
								dtAsistenciaTemas.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdUsuinterno"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdUsuinterno() + " :: "+ dtAsistenciaTemasBk.getIdUsuinterno());
								}
							cambios = true;
							dtAsistenciaTemas.setIdUsuinterno(dtAsistenciaTemasBk.getIdUsuinterno());
						}
					} else if (dtAsistenciaTemasBk.getIdUsuinterno() == null
							&& dtAsistenciaTemas.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdUsuinterno"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdUsuinterno() + " :: "+ dtAsistenciaTemasBk.getIdUsuinterno());
								}
							cambios = true;
							dtAsistenciaTemas.setIdUsuinterno(dtAsistenciaTemasBk.getIdUsuinterno());
						
					} else if (dtAsistenciaTemasBk.getIdUsuinterno() != null
							&& dtAsistenciaTemas.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdUsuinterno"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdUsuinterno() + " :: "+ dtAsistenciaTemasBk.getIdUsuinterno());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdUsuinterno(dtAsistenciaTemasBk.getIdUsuinterno());
					}
				if (dtAsistenciaTemasBk.getIdSistAdmi() != null
							&& dtAsistenciaTemas.getIdSistAdmi() != null) {
						if (!dtAsistenciaTemasBk.getIdSistAdmi().equals(
								dtAsistenciaTemas.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSistAdmi"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSistAdmi() + " :: "+ dtAsistenciaTemasBk.getIdSistAdmi());
								}
							cambios = true;
							dtAsistenciaTemas.setIdSistAdmi(dtAsistenciaTemasBk.getIdSistAdmi());
						}
					} else if (dtAsistenciaTemasBk.getIdSistAdmi() == null
							&& dtAsistenciaTemas.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSistAdmi"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSistAdmi() + " :: "+ dtAsistenciaTemasBk.getIdSistAdmi());
								}
							cambios = true;
							dtAsistenciaTemas.setIdSistAdmi(dtAsistenciaTemasBk.getIdSistAdmi());
						
					} else if (dtAsistenciaTemasBk.getIdSistAdmi() != null
							&& dtAsistenciaTemas.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdSistAdmi"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdSistAdmi() + " :: "+ dtAsistenciaTemasBk.getIdSistAdmi());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdSistAdmi(dtAsistenciaTemasBk.getIdSistAdmi());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAsistenciaTemas(DtAsistenciaTemasBk dtAsistenciaTemasBk, DtAsistenciaTemas dtAsistenciaTemas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtAsistenciaTemasBk.getIdusserCrea() != null
							&& dtAsistenciaTemas.getIdusserCrea() != null) {
						if (!dtAsistenciaTemasBk.getIdusserCrea().equals(
								dtAsistenciaTemas.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserCrea() + " :: "+ dtAsistenciaTemasBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaTemas.setIdusserCrea(dtAsistenciaTemasBk.getIdusserCrea());
						}
					} else if (dtAsistenciaTemasBk.getIdusserCrea() == null
							&& dtAsistenciaTemas.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserCrea() + " :: "+ dtAsistenciaTemasBk.getIdusserCrea());
								}
							cambios = true;
							dtAsistenciaTemas.setIdusserCrea(dtAsistenciaTemasBk.getIdusserCrea());
						
					} else if (dtAsistenciaTemasBk.getIdusserCrea() != null
							&& dtAsistenciaTemas.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserCrea() + " :: "+ dtAsistenciaTemasBk.getIdusserCrea());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdusserCrea(dtAsistenciaTemasBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAsistenciaTemasBk.getIdusserModif() != null
							&& dtAsistenciaTemas.getIdusserModif() != null) {
						if (!dtAsistenciaTemasBk.getIdusserModif().equals(
								dtAsistenciaTemas.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserModif() + " :: "+ dtAsistenciaTemasBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaTemas.setIdusserModif(dtAsistenciaTemasBk.getIdusserModif());
						}
					} else if (dtAsistenciaTemasBk.getIdusserModif() == null
							&& dtAsistenciaTemas.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserModif() + " :: "+ dtAsistenciaTemasBk.getIdusserModif());
								}
							cambios = true;
							dtAsistenciaTemas.setIdusserModif(dtAsistenciaTemasBk.getIdusserModif());
						
					} else if (dtAsistenciaTemasBk.getIdusserModif() != null
							&& dtAsistenciaTemas.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:IdusserModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getIdusserModif() + " :: "+ dtAsistenciaTemasBk.getIdusserModif());
								}
							cambios = true;			
							dtAsistenciaTemas.setIdusserModif(dtAsistenciaTemasBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAsistenciaTemasBk.getFechaCrea() != null
							&& dtAsistenciaTemas.getFechaCrea() != null) {
						if (!dtAsistenciaTemasBk.getFechaCrea().equals(
								dtAsistenciaTemas.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaCrea() + " :: "+ dtAsistenciaTemasBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaTemas.setFechaCrea(dtAsistenciaTemasBk.getFechaCrea());
						}
					} else if (dtAsistenciaTemasBk.getFechaCrea() == null
							&& dtAsistenciaTemas.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaCrea() + " :: "+ dtAsistenciaTemasBk.getFechaCrea());
								}
							cambios = true;
							dtAsistenciaTemas.setFechaCrea(dtAsistenciaTemasBk.getFechaCrea());
						
					} else if (dtAsistenciaTemasBk.getFechaCrea() != null
							&& dtAsistenciaTemas.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaCrea"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaCrea() + " :: "+ dtAsistenciaTemasBk.getFechaCrea());
								}
							cambios = true;			
							dtAsistenciaTemas.setFechaCrea(dtAsistenciaTemasBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAsistenciaTemasBk.getFechaModif() != null
							&& dtAsistenciaTemas.getFechaModif() != null) {
						if (!dtAsistenciaTemasBk.getFechaModif().equals(
								dtAsistenciaTemas.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaModif() + " :: "+ dtAsistenciaTemasBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaTemas.setFechaModif(dtAsistenciaTemasBk.getFechaModif());
						}
					} else if (dtAsistenciaTemasBk.getFechaModif() == null
							&& dtAsistenciaTemas.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaModif() + " :: "+ dtAsistenciaTemasBk.getFechaModif());
								}
							cambios = true;
							dtAsistenciaTemas.setFechaModif(dtAsistenciaTemasBk.getFechaModif());
						
					} else if (dtAsistenciaTemasBk.getFechaModif() != null
							&& dtAsistenciaTemas.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:FechaModif"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getFechaModif() + " :: "+ dtAsistenciaTemasBk.getFechaModif());
								}
							cambios = true;			
							dtAsistenciaTemas.setFechaModif(dtAsistenciaTemasBk.getFechaModif());
					}
                                
				
				
				
				
				                                 
                                      if (dtAsistenciaTemasBk.getEstado() != null
							&& dtAsistenciaTemas.getEstado() != null) {
						if (!dtAsistenciaTemasBk.getEstado().equals(
								dtAsistenciaTemas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Estado"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getEstado() + " :: "+ dtAsistenciaTemasBk.getEstado());
								}
							cambios = true;
							dtAsistenciaTemas.setEstado(dtAsistenciaTemasBk.getEstado());
						}
					} else if (dtAsistenciaTemasBk.getEstado() == null
							&& dtAsistenciaTemas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Estado"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getEstado() + " :: "+ dtAsistenciaTemasBk.getEstado());
								}
							cambios = true;
							dtAsistenciaTemas.setEstado(dtAsistenciaTemasBk.getEstado());
						
					} else if (dtAsistenciaTemasBk.getEstado() != null
							&& dtAsistenciaTemas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Estado"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getEstado() + " :: "+ dtAsistenciaTemasBk.getEstado());
								}
							cambios = true;			
							dtAsistenciaTemas.setEstado(dtAsistenciaTemasBk.getEstado());
					}
                                
				                                 
                                      if (dtAsistenciaTemasBk.getRtmaddress() != null
							&& dtAsistenciaTemas.getRtmaddress() != null) {
						if (!dtAsistenciaTemasBk.getRtmaddress().equals(
								dtAsistenciaTemas.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddress"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddress() + " :: "+ dtAsistenciaTemasBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaTemas.setRtmaddress(dtAsistenciaTemasBk.getRtmaddress());
						}
					} else if (dtAsistenciaTemasBk.getRtmaddress() == null
							&& dtAsistenciaTemas.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddress"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddress() + " :: "+ dtAsistenciaTemasBk.getRtmaddress());
								}
							cambios = true;
							dtAsistenciaTemas.setRtmaddress(dtAsistenciaTemasBk.getRtmaddress());
						
					} else if (dtAsistenciaTemasBk.getRtmaddress() != null
							&& dtAsistenciaTemas.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddress"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddress() + " :: "+ dtAsistenciaTemasBk.getRtmaddress());
								}
							cambios = true;			
							dtAsistenciaTemas.setRtmaddress(dtAsistenciaTemasBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAsistenciaTemasBk.getRtmaddressrst() != null
							&& dtAsistenciaTemas.getRtmaddressrst() != null) {
						if (!dtAsistenciaTemasBk.getRtmaddressrst().equals(
								dtAsistenciaTemas.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddressrst"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddressrst() + " :: "+ dtAsistenciaTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaTemas.setRtmaddressrst(dtAsistenciaTemasBk.getRtmaddressrst());
						}
					} else if (dtAsistenciaTemasBk.getRtmaddressrst() == null
							&& dtAsistenciaTemas.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddressrst"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddressrst() + " :: "+ dtAsistenciaTemasBk.getRtmaddressrst());
								}
							cambios = true;
							dtAsistenciaTemas.setRtmaddressrst(dtAsistenciaTemasBk.getRtmaddressrst());
						
					} else if (dtAsistenciaTemasBk.getRtmaddressrst() != null
							&& dtAsistenciaTemas.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAsistenciaTemas:Rtmaddressrst"+" :: "+dtAsistenciaTemasBk.getIdAsistTema().toString()+" :: "+ dtAsistenciaTemas.getRtmaddressrst() + " :: "+ dtAsistenciaTemasBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAsistenciaTemas.setRtmaddressrst(dtAsistenciaTemasBk.getRtmaddressrst());
					}
                                
				
				
				
			
			return cambios;
	}
}