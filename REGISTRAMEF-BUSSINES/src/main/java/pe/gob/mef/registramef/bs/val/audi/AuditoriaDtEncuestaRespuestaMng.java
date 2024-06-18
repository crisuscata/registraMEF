package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEncuestaRespuesta;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaRespuestaBk;

/**
 * DT_ENCUESTA_RESPUESTA SERVICIO AUDITORIA Y CAMBIO: 
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEncuestaRespuestaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEncuestaRespuestaMng.class.getName());
	
	public static boolean auditarCambiosDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, DtEncuestaRespuesta dtEncuestaRespuesta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtEncuestaRespuestaBk.getIdUsuexterno() != null
							&& dtEncuestaRespuesta.getIdUsuexterno() != null) {
						if (!dtEncuestaRespuestaBk.getIdUsuexterno().equals(
								dtEncuestaRespuesta.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdUsuexterno"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdUsuexterno() + " :: "+ dtEncuestaRespuestaBk.getIdUsuexterno());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdUsuexterno(dtEncuestaRespuestaBk.getIdUsuexterno());
						}
					} else if (dtEncuestaRespuestaBk.getIdUsuexterno() == null
							&& dtEncuestaRespuesta.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdUsuexterno"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdUsuexterno() + " :: "+ dtEncuestaRespuestaBk.getIdUsuexterno());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdUsuexterno(dtEncuestaRespuestaBk.getIdUsuexterno());
						
					} else if (dtEncuestaRespuestaBk.getIdUsuexterno() != null
							&& dtEncuestaRespuesta.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdUsuexterno"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdUsuexterno() + " :: "+ dtEncuestaRespuestaBk.getIdUsuexterno());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdUsuexterno(dtEncuestaRespuestaBk.getIdUsuexterno());
					}
				if (dtEncuestaRespuestaBk.getIdEncuesta() != null
							&& dtEncuestaRespuesta.getIdEncuesta() != null) {
						if (!dtEncuestaRespuestaBk.getIdEncuesta().equals(
								dtEncuestaRespuesta.getIdEncuesta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdEncuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdEncuesta() + " :: "+ dtEncuestaRespuestaBk.getIdEncuesta());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdEncuesta(dtEncuestaRespuestaBk.getIdEncuesta());
						}
					} else if (dtEncuestaRespuestaBk.getIdEncuesta() == null
							&& dtEncuestaRespuesta.getIdEncuesta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdEncuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdEncuesta() + " :: "+ dtEncuestaRespuestaBk.getIdEncuesta());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdEncuesta(dtEncuestaRespuestaBk.getIdEncuesta());
						
					} else if (dtEncuestaRespuestaBk.getIdEncuesta() != null
							&& dtEncuestaRespuesta.getIdEncuesta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdEncuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdEncuesta() + " :: "+ dtEncuestaRespuestaBk.getIdEncuesta());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdEncuesta(dtEncuestaRespuestaBk.getIdEncuesta());
					}
				if (dtEncuestaRespuestaBk.getIdServicio() != null
							&& dtEncuestaRespuesta.getIdServicio() != null) {
						if (!dtEncuestaRespuestaBk.getIdServicio().equals(
								dtEncuestaRespuesta.getIdServicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdServicio"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdServicio() + " :: "+ dtEncuestaRespuestaBk.getIdServicio());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdServicio(dtEncuestaRespuestaBk.getIdServicio());
						}
					} else if (dtEncuestaRespuestaBk.getIdServicio() == null
							&& dtEncuestaRespuesta.getIdServicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdServicio"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdServicio() + " :: "+ dtEncuestaRespuestaBk.getIdServicio());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdServicio(dtEncuestaRespuestaBk.getIdServicio());
						
					} else if (dtEncuestaRespuestaBk.getIdServicio() != null
							&& dtEncuestaRespuesta.getIdServicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdServicio"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdServicio() + " :: "+ dtEncuestaRespuestaBk.getIdServicio());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdServicio(dtEncuestaRespuestaBk.getIdServicio());
					}
				 
		            if (dtEncuestaRespuestaBk.getTipoPregunta() != null
						&& dtEncuestaRespuesta.getTipoPregunta() != null) {
					if (!dtEncuestaRespuestaBk.getTipoPregunta().equals(
						dtEncuestaRespuesta.getTipoPregunta())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:TipoPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getTipoPregunta() + " :: "+ dtEncuestaRespuestaBk.getTipoPregunta());								
						}
						cambios = true;
						dtEncuestaRespuesta.setTipoPregunta(dtEncuestaRespuestaBk.getTipoPregunta());
					}
				} else if (dtEncuestaRespuestaBk.getTipoPregunta() == null
						&& dtEncuestaRespuesta.getTipoPregunta() != null) {
					if (dtEncuestaRespuesta.getTipoPregunta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:TipoPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getTipoPregunta() + " :: "+ dtEncuestaRespuestaBk.getTipoPregunta());
						}
						cambios = true;
						dtEncuestaRespuesta.setTipoPregunta(dtEncuestaRespuestaBk.getTipoPregunta());
					}
				} else if (dtEncuestaRespuestaBk.getTipoPregunta() != null
						&& dtEncuestaRespuesta.getTipoPregunta() == null) {
					if (dtEncuestaRespuestaBk.getTipoPregunta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:TipoPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getTipoPregunta() + " :: "+ dtEncuestaRespuestaBk.getTipoPregunta());
						}
						cambios = true;
						dtEncuestaRespuesta.setTipoPregunta(dtEncuestaRespuestaBk.getTipoPregunta());
					}
				}
				 
		            if (dtEncuestaRespuestaBk.getIdPregunta() != null
						&& dtEncuestaRespuesta.getIdPregunta() != null) {
					if (!dtEncuestaRespuestaBk.getIdPregunta().equals(
						dtEncuestaRespuesta.getIdPregunta())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdPregunta() + " :: "+ dtEncuestaRespuestaBk.getIdPregunta());								
						}
						cambios = true;
						dtEncuestaRespuesta.setIdPregunta(dtEncuestaRespuestaBk.getIdPregunta());
					}
				} else if (dtEncuestaRespuestaBk.getIdPregunta() == null
						&& dtEncuestaRespuesta.getIdPregunta() != null) {
					if (dtEncuestaRespuesta.getIdPregunta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdPregunta() + " :: "+ dtEncuestaRespuestaBk.getIdPregunta());
						}
						cambios = true;
						dtEncuestaRespuesta.setIdPregunta(dtEncuestaRespuestaBk.getIdPregunta());
					}
				} else if (dtEncuestaRespuestaBk.getIdPregunta() != null
						&& dtEncuestaRespuesta.getIdPregunta() == null) {
					if (dtEncuestaRespuestaBk.getIdPregunta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdPregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdPregunta() + " :: "+ dtEncuestaRespuestaBk.getIdPregunta());
						}
						cambios = true;
						dtEncuestaRespuesta.setIdPregunta(dtEncuestaRespuestaBk.getIdPregunta());
					}
				}
				 
		            if (dtEncuestaRespuestaBk.getRespuesta() != null
						&& dtEncuestaRespuesta.getRespuesta() != null) {
					if (!dtEncuestaRespuestaBk.getRespuesta().equals(
						dtEncuestaRespuesta.getRespuesta())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Respuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRespuesta() + " :: "+ dtEncuestaRespuestaBk.getRespuesta());								
						}
						cambios = true;
						dtEncuestaRespuesta.setRespuesta(dtEncuestaRespuestaBk.getRespuesta());
					}
				} else if (dtEncuestaRespuestaBk.getRespuesta() == null
						&& dtEncuestaRespuesta.getRespuesta() != null) {
					if (dtEncuestaRespuesta.getRespuesta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Respuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRespuesta() + " :: "+ dtEncuestaRespuestaBk.getRespuesta());
						}
						cambios = true;
						dtEncuestaRespuesta.setRespuesta(dtEncuestaRespuestaBk.getRespuesta());
					}
				} else if (dtEncuestaRespuestaBk.getRespuesta() != null
						&& dtEncuestaRespuesta.getRespuesta() == null) {
					if (dtEncuestaRespuestaBk.getRespuesta().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Respuesta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRespuesta() + " :: "+ dtEncuestaRespuestaBk.getRespuesta());
						}
						cambios = true;
						dtEncuestaRespuesta.setRespuesta(dtEncuestaRespuestaBk.getRespuesta());
					}
				}
				if (dtEncuestaRespuestaBk.getIdExpositor() != null
							&& dtEncuestaRespuesta.getIdExpositor() != null) {
						if (!dtEncuestaRespuestaBk.getIdExpositor().equals(
								dtEncuestaRespuesta.getIdExpositor())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdExpositor"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdExpositor() + " :: "+ dtEncuestaRespuestaBk.getIdExpositor());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdExpositor(dtEncuestaRespuestaBk.getIdExpositor());
						}
					} else if (dtEncuestaRespuestaBk.getIdExpositor() == null
							&& dtEncuestaRespuesta.getIdExpositor() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdExpositor"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdExpositor() + " :: "+ dtEncuestaRespuestaBk.getIdExpositor());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdExpositor(dtEncuestaRespuestaBk.getIdExpositor());
						
					} else if (dtEncuestaRespuestaBk.getIdExpositor() != null
							&& dtEncuestaRespuesta.getIdExpositor() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdExpositor"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdExpositor() + " :: "+ dtEncuestaRespuestaBk.getIdExpositor());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdExpositor(dtEncuestaRespuestaBk.getIdExpositor());
					}
				if (dtEncuestaRespuestaBk.getPregunta() != null
							&& dtEncuestaRespuesta.getPregunta() != null) {
						if (!dtEncuestaRespuestaBk.getPregunta().equals(
								dtEncuestaRespuesta.getPregunta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Pregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getPregunta() + " :: "+ dtEncuestaRespuestaBk.getPregunta());
								}
							cambios = true;
							dtEncuestaRespuesta.setPregunta(dtEncuestaRespuestaBk.getPregunta());
						}
					} else if (dtEncuestaRespuestaBk.getPregunta() == null
							&& dtEncuestaRespuesta.getPregunta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Pregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getPregunta() + " :: "+ dtEncuestaRespuestaBk.getPregunta());
								}
							cambios = true;
							dtEncuestaRespuesta.setPregunta(dtEncuestaRespuestaBk.getPregunta());
						
					} else if (dtEncuestaRespuestaBk.getPregunta() != null
							&& dtEncuestaRespuesta.getPregunta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Pregunta"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getPregunta() + " :: "+ dtEncuestaRespuestaBk.getPregunta());
								}
							cambios = true;			
							dtEncuestaRespuesta.setPregunta(dtEncuestaRespuestaBk.getPregunta());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtEncuestaRespuesta(DtEncuestaRespuestaBk dtEncuestaRespuestaBk, DtEncuestaRespuesta dtEncuestaRespuesta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				
				                                 
                                      if (dtEncuestaRespuestaBk.getEstado() != null
							&& dtEncuestaRespuesta.getEstado() != null) {
						if (!dtEncuestaRespuestaBk.getEstado().equals(
								dtEncuestaRespuesta.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Estado"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getEstado() + " :: "+ dtEncuestaRespuestaBk.getEstado());
								}
							cambios = true;
							dtEncuestaRespuesta.setEstado(dtEncuestaRespuestaBk.getEstado());
						}
					} else if (dtEncuestaRespuestaBk.getEstado() == null
							&& dtEncuestaRespuesta.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Estado"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getEstado() + " :: "+ dtEncuestaRespuestaBk.getEstado());
								}
							cambios = true;
							dtEncuestaRespuesta.setEstado(dtEncuestaRespuestaBk.getEstado());
						
					} else if (dtEncuestaRespuestaBk.getEstado() != null
							&& dtEncuestaRespuesta.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Estado"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getEstado() + " :: "+ dtEncuestaRespuestaBk.getEstado());
								}
							cambios = true;			
							dtEncuestaRespuesta.setEstado(dtEncuestaRespuestaBk.getEstado());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getIdusserCrea() != null
							&& dtEncuestaRespuesta.getIdusserCrea() != null) {
						if (!dtEncuestaRespuestaBk.getIdusserCrea().equals(
								dtEncuestaRespuesta.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserCrea() + " :: "+ dtEncuestaRespuestaBk.getIdusserCrea());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdusserCrea(dtEncuestaRespuestaBk.getIdusserCrea());
						}
					} else if (dtEncuestaRespuestaBk.getIdusserCrea() == null
							&& dtEncuestaRespuesta.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserCrea() + " :: "+ dtEncuestaRespuestaBk.getIdusserCrea());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdusserCrea(dtEncuestaRespuestaBk.getIdusserCrea());
						
					} else if (dtEncuestaRespuestaBk.getIdusserCrea() != null
							&& dtEncuestaRespuesta.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserCrea() + " :: "+ dtEncuestaRespuestaBk.getIdusserCrea());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdusserCrea(dtEncuestaRespuestaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getIdusserModif() != null
							&& dtEncuestaRespuesta.getIdusserModif() != null) {
						if (!dtEncuestaRespuestaBk.getIdusserModif().equals(
								dtEncuestaRespuesta.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserModif() + " :: "+ dtEncuestaRespuestaBk.getIdusserModif());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdusserModif(dtEncuestaRespuestaBk.getIdusserModif());
						}
					} else if (dtEncuestaRespuestaBk.getIdusserModif() == null
							&& dtEncuestaRespuesta.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserModif() + " :: "+ dtEncuestaRespuestaBk.getIdusserModif());
								}
							cambios = true;
							dtEncuestaRespuesta.setIdusserModif(dtEncuestaRespuestaBk.getIdusserModif());
						
					} else if (dtEncuestaRespuestaBk.getIdusserModif() != null
							&& dtEncuestaRespuesta.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:IdusserModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getIdusserModif() + " :: "+ dtEncuestaRespuestaBk.getIdusserModif());
								}
							cambios = true;			
							dtEncuestaRespuesta.setIdusserModif(dtEncuestaRespuestaBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getFechaCrea() != null
							&& dtEncuestaRespuesta.getFechaCrea() != null) {
						if (!dtEncuestaRespuestaBk.getFechaCrea().equals(
								dtEncuestaRespuesta.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaCrea() + " :: "+ dtEncuestaRespuestaBk.getFechaCrea());
								}
							cambios = true;
							dtEncuestaRespuesta.setFechaCrea(dtEncuestaRespuestaBk.getFechaCrea());
						}
					} else if (dtEncuestaRespuestaBk.getFechaCrea() == null
							&& dtEncuestaRespuesta.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaCrea() + " :: "+ dtEncuestaRespuestaBk.getFechaCrea());
								}
							cambios = true;
							dtEncuestaRespuesta.setFechaCrea(dtEncuestaRespuestaBk.getFechaCrea());
						
					} else if (dtEncuestaRespuestaBk.getFechaCrea() != null
							&& dtEncuestaRespuesta.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaCrea"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaCrea() + " :: "+ dtEncuestaRespuestaBk.getFechaCrea());
								}
							cambios = true;			
							dtEncuestaRespuesta.setFechaCrea(dtEncuestaRespuestaBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getFechaModif() != null
							&& dtEncuestaRespuesta.getFechaModif() != null) {
						if (!dtEncuestaRespuestaBk.getFechaModif().equals(
								dtEncuestaRespuesta.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaModif() + " :: "+ dtEncuestaRespuestaBk.getFechaModif());
								}
							cambios = true;
							dtEncuestaRespuesta.setFechaModif(dtEncuestaRespuestaBk.getFechaModif());
						}
					} else if (dtEncuestaRespuestaBk.getFechaModif() == null
							&& dtEncuestaRespuesta.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaModif() + " :: "+ dtEncuestaRespuestaBk.getFechaModif());
								}
							cambios = true;
							dtEncuestaRespuesta.setFechaModif(dtEncuestaRespuestaBk.getFechaModif());
						
					} else if (dtEncuestaRespuestaBk.getFechaModif() != null
							&& dtEncuestaRespuesta.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:FechaModif"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getFechaModif() + " :: "+ dtEncuestaRespuestaBk.getFechaModif());
								}
							cambios = true;			
							dtEncuestaRespuesta.setFechaModif(dtEncuestaRespuestaBk.getFechaModif());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getRtmaddress() != null
							&& dtEncuestaRespuesta.getRtmaddress() != null) {
						if (!dtEncuestaRespuestaBk.getRtmaddress().equals(
								dtEncuestaRespuesta.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddress"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddress() + " :: "+ dtEncuestaRespuestaBk.getRtmaddress());
								}
							cambios = true;
							dtEncuestaRespuesta.setRtmaddress(dtEncuestaRespuestaBk.getRtmaddress());
						}
					} else if (dtEncuestaRespuestaBk.getRtmaddress() == null
							&& dtEncuestaRespuesta.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddress"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddress() + " :: "+ dtEncuestaRespuestaBk.getRtmaddress());
								}
							cambios = true;
							dtEncuestaRespuesta.setRtmaddress(dtEncuestaRespuestaBk.getRtmaddress());
						
					} else if (dtEncuestaRespuestaBk.getRtmaddress() != null
							&& dtEncuestaRespuesta.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddress"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddress() + " :: "+ dtEncuestaRespuestaBk.getRtmaddress());
								}
							cambios = true;			
							dtEncuestaRespuesta.setRtmaddress(dtEncuestaRespuestaBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEncuestaRespuestaBk.getRtmaddressrst() != null
							&& dtEncuestaRespuesta.getRtmaddressrst() != null) {
						if (!dtEncuestaRespuestaBk.getRtmaddressrst().equals(
								dtEncuestaRespuesta.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddressrst"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddressrst() + " :: "+ dtEncuestaRespuestaBk.getRtmaddressrst());
								}
							cambios = true;
							dtEncuestaRespuesta.setRtmaddressrst(dtEncuestaRespuestaBk.getRtmaddressrst());
						}
					} else if (dtEncuestaRespuestaBk.getRtmaddressrst() == null
							&& dtEncuestaRespuesta.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddressrst"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddressrst() + " :: "+ dtEncuestaRespuestaBk.getRtmaddressrst());
								}
							cambios = true;
							dtEncuestaRespuesta.setRtmaddressrst(dtEncuestaRespuestaBk.getRtmaddressrst());
						
					} else if (dtEncuestaRespuestaBk.getRtmaddressrst() != null
							&& dtEncuestaRespuesta.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEncuestaRespuesta:Rtmaddressrst"+" :: "+dtEncuestaRespuestaBk.getIdRespuesta().toString()+" :: "+ dtEncuestaRespuesta.getRtmaddressrst() + " :: "+ dtEncuestaRespuestaBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEncuestaRespuesta.setRtmaddressrst(dtEncuestaRespuestaBk.getRtmaddressrst());
					}
                                
				
				
				
			
			return cambios;
	}
}