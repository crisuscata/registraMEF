package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtConsultas;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasBk;

/**
 * DT_CONSULTAS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DATOS REGISTRADOS EN UNA CONSULTA "CONSULTAS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtConsultasMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtConsultasMng.class.getName());
	
	public static boolean auditarCambiosDtConsultas(DtConsultasBk dtConsultasBk, DtConsultas dtConsultas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtConsultasBk.getFechaConsu() != null
							&& dtConsultas.getFechaConsu() != null) {
						if (!dtConsultasBk.getFechaConsu().equals(
								dtConsultas.getFechaConsu())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaConsu"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaConsu() + " :: "+ dtConsultasBk.getFechaConsu());
								}
							cambios = true;
							dtConsultas.setFechaConsu(dtConsultasBk.getFechaConsu());
						}
					} else if (dtConsultasBk.getFechaConsu() == null
							&& dtConsultas.getFechaConsu() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaConsu"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaConsu() + " :: "+ dtConsultasBk.getFechaConsu());
								}
							cambios = true;
							dtConsultas.setFechaConsu(dtConsultasBk.getFechaConsu());
						
					} else if (dtConsultasBk.getFechaConsu() != null
							&& dtConsultas.getFechaConsu() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaConsu"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaConsu() + " :: "+ dtConsultasBk.getFechaConsu());
								}
							cambios = true;			
							dtConsultas.setFechaConsu(dtConsultasBk.getFechaConsu());
					}
				if (dtConsultasBk.getDetalle() != null
							&& dtConsultas.getDetalle() != null) {
						if (!dtConsultasBk.getDetalle().equals(
								dtConsultas.getDetalle())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Detalle"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getDetalle() + " :: "+ dtConsultasBk.getDetalle());
								}
							cambios = true;
							dtConsultas.setDetalle(dtConsultasBk.getDetalle());
						}
					} else if (dtConsultasBk.getDetalle() == null
							&& dtConsultas.getDetalle() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Detalle"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getDetalle() + " :: "+ dtConsultasBk.getDetalle());
								}
							cambios = true;
							dtConsultas.setDetalle(dtConsultasBk.getDetalle());
						
					} else if (dtConsultasBk.getDetalle() != null
							&& dtConsultas.getDetalle() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Detalle"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getDetalle() + " :: "+ dtConsultasBk.getDetalle());
								}
							cambios = true;			
							dtConsultas.setDetalle(dtConsultasBk.getDetalle());
					}
				if (dtConsultasBk.getRespuesta() != null
							&& dtConsultas.getRespuesta() != null) {
						if (!dtConsultasBk.getRespuesta().equals(
								dtConsultas.getRespuesta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Respuesta"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRespuesta() + " :: "+ dtConsultasBk.getRespuesta());
								}
							cambios = true;
							dtConsultas.setRespuesta(dtConsultasBk.getRespuesta());
						}
					} else if (dtConsultasBk.getRespuesta() == null
							&& dtConsultas.getRespuesta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Respuesta"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRespuesta() + " :: "+ dtConsultasBk.getRespuesta());
								}
							cambios = true;
							dtConsultas.setRespuesta(dtConsultasBk.getRespuesta());
						
					} else if (dtConsultasBk.getRespuesta() != null
							&& dtConsultas.getRespuesta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Respuesta"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRespuesta() + " :: "+ dtConsultasBk.getRespuesta());
								}
							cambios = true;			
							dtConsultas.setRespuesta(dtConsultasBk.getRespuesta());
					}
				if (dtConsultasBk.getIdPrestservic() != null
							&& dtConsultas.getIdPrestservic() != null) {
						if (!dtConsultasBk.getIdPrestservic().equals(
								dtConsultas.getIdPrestservic())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdPrestservic"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdPrestservic() + " :: "+ dtConsultasBk.getIdPrestservic());
								}
							cambios = true;
							dtConsultas.setIdPrestservic(dtConsultasBk.getIdPrestservic());
						}
					} else if (dtConsultasBk.getIdPrestservic() == null
							&& dtConsultas.getIdPrestservic() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdPrestservic"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdPrestservic() + " :: "+ dtConsultasBk.getIdPrestservic());
								}
							cambios = true;
							dtConsultas.setIdPrestservic(dtConsultasBk.getIdPrestservic());
						
					} else if (dtConsultasBk.getIdPrestservic() != null
							&& dtConsultas.getIdPrestservic() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdPrestservic"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdPrestservic() + " :: "+ dtConsultasBk.getIdPrestservic());
								}
							cambios = true;			
							dtConsultas.setIdPrestservic(dtConsultasBk.getIdPrestservic());
					}
				if (dtConsultasBk.getIdModalidad() != null
							&& dtConsultas.getIdModalidad() != null) {
						if (!dtConsultasBk.getIdModalidad().equals(
								dtConsultas.getIdModalidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdModalidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdModalidad() + " :: "+ dtConsultasBk.getIdModalidad());
								}
							cambios = true;
							dtConsultas.setIdModalidad(dtConsultasBk.getIdModalidad());
						}
					} else if (dtConsultasBk.getIdModalidad() == null
							&& dtConsultas.getIdModalidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdModalidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdModalidad() + " :: "+ dtConsultasBk.getIdModalidad());
								}
							cambios = true;
							dtConsultas.setIdModalidad(dtConsultasBk.getIdModalidad());
						
					} else if (dtConsultasBk.getIdModalidad() != null
							&& dtConsultas.getIdModalidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdModalidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdModalidad() + " :: "+ dtConsultasBk.getIdModalidad());
								}
							cambios = true;			
							dtConsultas.setIdModalidad(dtConsultasBk.getIdModalidad());
					}
				if (dtConsultasBk.getIdUsuexterno() != null
							&& dtConsultas.getIdUsuexterno() != null) {
						if (!dtConsultasBk.getIdUsuexterno().equals(
								dtConsultas.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuexterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuexterno() + " :: "+ dtConsultasBk.getIdUsuexterno());
								}
							cambios = true;
							dtConsultas.setIdUsuexterno(dtConsultasBk.getIdUsuexterno());
						}
					} else if (dtConsultasBk.getIdUsuexterno() == null
							&& dtConsultas.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuexterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuexterno() + " :: "+ dtConsultasBk.getIdUsuexterno());
								}
							cambios = true;
							dtConsultas.setIdUsuexterno(dtConsultasBk.getIdUsuexterno());
						
					} else if (dtConsultasBk.getIdUsuexterno() != null
							&& dtConsultas.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuexterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuexterno() + " :: "+ dtConsultasBk.getIdUsuexterno());
								}
							cambios = true;			
							dtConsultas.setIdUsuexterno(dtConsultasBk.getIdUsuexterno());
					}
				if (dtConsultasBk.getIdUsuinterno() != null
							&& dtConsultas.getIdUsuinterno() != null) {
						if (!dtConsultasBk.getIdUsuinterno().equals(
								dtConsultas.getIdUsuinterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuinterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuinterno() + " :: "+ dtConsultasBk.getIdUsuinterno());
								}
							cambios = true;
							dtConsultas.setIdUsuinterno(dtConsultasBk.getIdUsuinterno());
						}
					} else if (dtConsultasBk.getIdUsuinterno() == null
							&& dtConsultas.getIdUsuinterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuinterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuinterno() + " :: "+ dtConsultasBk.getIdUsuinterno());
								}
							cambios = true;
							dtConsultas.setIdUsuinterno(dtConsultasBk.getIdUsuinterno());
						
					} else if (dtConsultasBk.getIdUsuinterno() != null
							&& dtConsultas.getIdUsuinterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdUsuinterno"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdUsuinterno() + " :: "+ dtConsultasBk.getIdUsuinterno());
								}
							cambios = true;			
							dtConsultas.setIdUsuinterno(dtConsultasBk.getIdUsuinterno());
					}
				if (dtConsultasBk.getIdEntidad() != null
							&& dtConsultas.getIdEntidad() != null) {
						if (!dtConsultasBk.getIdEntidad().equals(
								dtConsultas.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdEntidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdEntidad() + " :: "+ dtConsultasBk.getIdEntidad());
								}
							cambios = true;
							dtConsultas.setIdEntidad(dtConsultasBk.getIdEntidad());
						}
					} else if (dtConsultasBk.getIdEntidad() == null
							&& dtConsultas.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdEntidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdEntidad() + " :: "+ dtConsultasBk.getIdEntidad());
								}
							cambios = true;
							dtConsultas.setIdEntidad(dtConsultasBk.getIdEntidad());
						
					} else if (dtConsultasBk.getIdEntidad() != null
							&& dtConsultas.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdEntidad"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdEntidad() + " :: "+ dtConsultasBk.getIdEntidad());
								}
							cambios = true;			
							dtConsultas.setIdEntidad(dtConsultasBk.getIdEntidad());
					}
				if (dtConsultasBk.getIdTema() != null
							&& dtConsultas.getIdTema() != null) {
						if (!dtConsultasBk.getIdTema().equals(
								dtConsultas.getIdTema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdTema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdTema() + " :: "+ dtConsultasBk.getIdTema());
								}
							cambios = true;
							dtConsultas.setIdTema(dtConsultasBk.getIdTema());
						}
					} else if (dtConsultasBk.getIdTema() == null
							&& dtConsultas.getIdTema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdTema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdTema() + " :: "+ dtConsultasBk.getIdTema());
								}
							cambios = true;
							dtConsultas.setIdTema(dtConsultasBk.getIdTema());
						
					} else if (dtConsultasBk.getIdTema() != null
							&& dtConsultas.getIdTema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdTema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdTema() + " :: "+ dtConsultasBk.getIdTema());
								}
							cambios = true;			
							dtConsultas.setIdTema(dtConsultasBk.getIdTema());
					}
				if (dtConsultasBk.getIdSubtema() != null
							&& dtConsultas.getIdSubtema() != null) {
						if (!dtConsultasBk.getIdSubtema().equals(
								dtConsultas.getIdSubtema())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSubtema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSubtema() + " :: "+ dtConsultasBk.getIdSubtema());
								}
							cambios = true;
							dtConsultas.setIdSubtema(dtConsultasBk.getIdSubtema());
						}
					} else if (dtConsultasBk.getIdSubtema() == null
							&& dtConsultas.getIdSubtema() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSubtema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSubtema() + " :: "+ dtConsultasBk.getIdSubtema());
								}
							cambios = true;
							dtConsultas.setIdSubtema(dtConsultasBk.getIdSubtema());
						
					} else if (dtConsultasBk.getIdSubtema() != null
							&& dtConsultas.getIdSubtema() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSubtema"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSubtema() + " :: "+ dtConsultasBk.getIdSubtema());
								}
							cambios = true;			
							dtConsultas.setIdSubtema(dtConsultasBk.getIdSubtema());
					}
				if (dtConsultasBk.getIdOrigen() != null
							&& dtConsultas.getIdOrigen() != null) {
						if (!dtConsultasBk.getIdOrigen().equals(
								dtConsultas.getIdOrigen())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdOrigen"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdOrigen() + " :: "+ dtConsultasBk.getIdOrigen());
								}
							cambios = true;
							dtConsultas.setIdOrigen(dtConsultasBk.getIdOrigen());
						}
					} else if (dtConsultasBk.getIdOrigen() == null
							&& dtConsultas.getIdOrigen() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdOrigen"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdOrigen() + " :: "+ dtConsultasBk.getIdOrigen());
								}
							cambios = true;
							dtConsultas.setIdOrigen(dtConsultasBk.getIdOrigen());
						
					} else if (dtConsultasBk.getIdOrigen() != null
							&& dtConsultas.getIdOrigen() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdOrigen"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdOrigen() + " :: "+ dtConsultasBk.getIdOrigen());
								}
							cambios = true;			
							dtConsultas.setIdOrigen(dtConsultasBk.getIdOrigen());
					}
				if (dtConsultasBk.getIdCargo() != null
							&& dtConsultas.getIdCargo() != null) {
						if (!dtConsultasBk.getIdCargo().equals(
								dtConsultas.getIdCargo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdCargo"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdCargo() + " :: "+ dtConsultasBk.getIdCargo());
								}
							cambios = true;
							dtConsultas.setIdCargo(dtConsultasBk.getIdCargo());
						}
					} else if (dtConsultasBk.getIdCargo() == null
							&& dtConsultas.getIdCargo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdCargo"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdCargo() + " :: "+ dtConsultasBk.getIdCargo());
								}
							cambios = true;
							dtConsultas.setIdCargo(dtConsultasBk.getIdCargo());
						
					} else if (dtConsultasBk.getIdCargo() != null
							&& dtConsultas.getIdCargo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdCargo"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdCargo() + " :: "+ dtConsultasBk.getIdCargo());
								}
							cambios = true;			
							dtConsultas.setIdCargo(dtConsultasBk.getIdCargo());
					}
				if (dtConsultasBk.getIdSede() != null
							&& dtConsultas.getIdSede() != null) {
						if (!dtConsultasBk.getIdSede().equals(
								dtConsultas.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSede"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSede() + " :: "+ dtConsultasBk.getIdSede());
								}
							cambios = true;
							dtConsultas.setIdSede(dtConsultasBk.getIdSede());
						}
					} else if (dtConsultasBk.getIdSede() == null
							&& dtConsultas.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSede"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSede() + " :: "+ dtConsultasBk.getIdSede());
								}
							cambios = true;
							dtConsultas.setIdSede(dtConsultasBk.getIdSede());
						
					} else if (dtConsultasBk.getIdSede() != null
							&& dtConsultas.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSede"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSede() + " :: "+ dtConsultasBk.getIdSede());
								}
							cambios = true;			
							dtConsultas.setIdSede(dtConsultasBk.getIdSede());
					}
				if (dtConsultasBk.getIdSistAdm() != null
							&& dtConsultas.getIdSistAdm() != null) {
						if (!dtConsultasBk.getIdSistAdm().equals(
								dtConsultas.getIdSistAdm())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSistAdm"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSistAdm() + " :: "+ dtConsultasBk.getIdSistAdm());
								}
							cambios = true;
							dtConsultas.setIdSistAdm(dtConsultasBk.getIdSistAdm());
						}
					} else if (dtConsultasBk.getIdSistAdm() == null
							&& dtConsultas.getIdSistAdm() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSistAdm"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSistAdm() + " :: "+ dtConsultasBk.getIdSistAdm());
								}
							cambios = true;
							dtConsultas.setIdSistAdm(dtConsultasBk.getIdSistAdm());
						
					} else if (dtConsultasBk.getIdSistAdm() != null
							&& dtConsultas.getIdSistAdm() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdSistAdm"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdSistAdm() + " :: "+ dtConsultasBk.getIdSistAdm());
								}
							cambios = true;			
							dtConsultas.setIdSistAdm(dtConsultasBk.getIdSistAdm());
					}
				 
		            if (dtConsultasBk.getCorreoUsuext() != null
						&& dtConsultas.getCorreoUsuext() != null) {
					if (!dtConsultasBk.getCorreoUsuext().equals(
						dtConsultas.getCorreoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CorreoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCorreoUsuext() + " :: "+ dtConsultasBk.getCorreoUsuext());								
						}
						cambios = true;
						dtConsultas.setCorreoUsuext(dtConsultasBk.getCorreoUsuext());
					}
				} else if (dtConsultasBk.getCorreoUsuext() == null
						&& dtConsultas.getCorreoUsuext() != null) {
					if (dtConsultas.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CorreoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCorreoUsuext() + " :: "+ dtConsultasBk.getCorreoUsuext());
						}
						cambios = true;
						dtConsultas.setCorreoUsuext(dtConsultasBk.getCorreoUsuext());
					}
				} else if (dtConsultasBk.getCorreoUsuext() != null
						&& dtConsultas.getCorreoUsuext() == null) {
					if (dtConsultasBk.getCorreoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CorreoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCorreoUsuext() + " :: "+ dtConsultasBk.getCorreoUsuext());
						}
						cambios = true;
						dtConsultas.setCorreoUsuext(dtConsultasBk.getCorreoUsuext());
					}
				}
				 
		            if (dtConsultasBk.getFijoUsuext() != null
						&& dtConsultas.getFijoUsuext() != null) {
					if (!dtConsultasBk.getFijoUsuext().equals(
						dtConsultas.getFijoUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FijoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFijoUsuext() + " :: "+ dtConsultasBk.getFijoUsuext());								
						}
						cambios = true;
						dtConsultas.setFijoUsuext(dtConsultasBk.getFijoUsuext());
					}
				} else if (dtConsultasBk.getFijoUsuext() == null
						&& dtConsultas.getFijoUsuext() != null) {
					if (dtConsultas.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FijoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFijoUsuext() + " :: "+ dtConsultasBk.getFijoUsuext());
						}
						cambios = true;
						dtConsultas.setFijoUsuext(dtConsultasBk.getFijoUsuext());
					}
				} else if (dtConsultasBk.getFijoUsuext() != null
						&& dtConsultas.getFijoUsuext() == null) {
					if (dtConsultasBk.getFijoUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FijoUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFijoUsuext() + " :: "+ dtConsultasBk.getFijoUsuext());
						}
						cambios = true;
						dtConsultas.setFijoUsuext(dtConsultasBk.getFijoUsuext());
					}
				}
				 
		            if (dtConsultasBk.getCelularUsuext() != null
						&& dtConsultas.getCelularUsuext() != null) {
					if (!dtConsultasBk.getCelularUsuext().equals(
						dtConsultas.getCelularUsuext())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CelularUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCelularUsuext() + " :: "+ dtConsultasBk.getCelularUsuext());								
						}
						cambios = true;
						dtConsultas.setCelularUsuext(dtConsultasBk.getCelularUsuext());
					}
				} else if (dtConsultasBk.getCelularUsuext() == null
						&& dtConsultas.getCelularUsuext() != null) {
					if (dtConsultas.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CelularUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCelularUsuext() + " :: "+ dtConsultasBk.getCelularUsuext());
						}
						cambios = true;
						dtConsultas.setCelularUsuext(dtConsultasBk.getCelularUsuext());
					}
				} else if (dtConsultasBk.getCelularUsuext() != null
						&& dtConsultas.getCelularUsuext() == null) {
					if (dtConsultasBk.getCelularUsuext().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:CelularUsuext"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getCelularUsuext() + " :: "+ dtConsultasBk.getCelularUsuext());
						}
						cambios = true;
						dtConsultas.setCelularUsuext(dtConsultasBk.getCelularUsuext());
					}
				}
				if (dtConsultasBk.getFechaFinalizacion() != null
							&& dtConsultas.getFechaFinalizacion() != null) {
						if (!dtConsultasBk.getFechaFinalizacion().equals(
								dtConsultas.getFechaFinalizacion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaFinalizacion"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaFinalizacion() + " :: "+ dtConsultasBk.getFechaFinalizacion());
								}
							cambios = true;
							dtConsultas.setFechaFinalizacion(dtConsultasBk.getFechaFinalizacion());
						}
					} else if (dtConsultasBk.getFechaFinalizacion() == null
							&& dtConsultas.getFechaFinalizacion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaFinalizacion"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaFinalizacion() + " :: "+ dtConsultasBk.getFechaFinalizacion());
								}
							cambios = true;
							dtConsultas.setFechaFinalizacion(dtConsultasBk.getFechaFinalizacion());
						
					} else if (dtConsultasBk.getFechaFinalizacion() != null
							&& dtConsultas.getFechaFinalizacion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaFinalizacion"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaFinalizacion() + " :: "+ dtConsultasBk.getFechaFinalizacion());
								}
							cambios = true;			
							dtConsultas.setFechaFinalizacion(dtConsultasBk.getFechaFinalizacion());
					}
				if (dtConsultasBk.getFechaSoli() != null
							&& dtConsultas.getFechaSoli() != null) {
						if (!dtConsultasBk.getFechaSoli().equals(
								dtConsultas.getFechaSoli())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaSoli"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaSoli() + " :: "+ dtConsultasBk.getFechaSoli());
								}
							cambios = true;
							dtConsultas.setFechaSoli(dtConsultasBk.getFechaSoli());
						}
					} else if (dtConsultasBk.getFechaSoli() == null
							&& dtConsultas.getFechaSoli() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaSoli"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaSoli() + " :: "+ dtConsultasBk.getFechaSoli());
								}
							cambios = true;
							dtConsultas.setFechaSoli(dtConsultasBk.getFechaSoli());
						
					} else if (dtConsultasBk.getFechaSoli() != null
							&& dtConsultas.getFechaSoli() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaSoli"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaSoli() + " :: "+ dtConsultasBk.getFechaSoli());
								}
							cambios = true;			
							dtConsultas.setFechaSoli(dtConsultasBk.getFechaSoli());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtConsultas(DtConsultasBk dtConsultasBk, DtConsultas dtConsultas, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				                                 
                                      if (dtConsultasBk.getIdusserCrea() != null
							&& dtConsultas.getIdusserCrea() != null) {
						if (!dtConsultasBk.getIdusserCrea().equals(
								dtConsultas.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserCrea() + " :: "+ dtConsultasBk.getIdusserCrea());
								}
							cambios = true;
							dtConsultas.setIdusserCrea(dtConsultasBk.getIdusserCrea());
						}
					} else if (dtConsultasBk.getIdusserCrea() == null
							&& dtConsultas.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserCrea() + " :: "+ dtConsultasBk.getIdusserCrea());
								}
							cambios = true;
							dtConsultas.setIdusserCrea(dtConsultasBk.getIdusserCrea());
						
					} else if (dtConsultasBk.getIdusserCrea() != null
							&& dtConsultas.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserCrea() + " :: "+ dtConsultasBk.getIdusserCrea());
								}
							cambios = true;			
							dtConsultas.setIdusserCrea(dtConsultasBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtConsultasBk.getIdusserModif() != null
							&& dtConsultas.getIdusserModif() != null) {
						if (!dtConsultasBk.getIdusserModif().equals(
								dtConsultas.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserModif() + " :: "+ dtConsultasBk.getIdusserModif());
								}
							cambios = true;
							dtConsultas.setIdusserModif(dtConsultasBk.getIdusserModif());
						}
					} else if (dtConsultasBk.getIdusserModif() == null
							&& dtConsultas.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserModif() + " :: "+ dtConsultasBk.getIdusserModif());
								}
							cambios = true;
							dtConsultas.setIdusserModif(dtConsultasBk.getIdusserModif());
						
					} else if (dtConsultasBk.getIdusserModif() != null
							&& dtConsultas.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:IdusserModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getIdusserModif() + " :: "+ dtConsultasBk.getIdusserModif());
								}
							cambios = true;			
							dtConsultas.setIdusserModif(dtConsultasBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtConsultasBk.getFechaCrea() != null
							&& dtConsultas.getFechaCrea() != null) {
						if (!dtConsultasBk.getFechaCrea().equals(
								dtConsultas.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaCrea() + " :: "+ dtConsultasBk.getFechaCrea());
								}
							cambios = true;
							dtConsultas.setFechaCrea(dtConsultasBk.getFechaCrea());
						}
					} else if (dtConsultasBk.getFechaCrea() == null
							&& dtConsultas.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaCrea() + " :: "+ dtConsultasBk.getFechaCrea());
								}
							cambios = true;
							dtConsultas.setFechaCrea(dtConsultasBk.getFechaCrea());
						
					} else if (dtConsultasBk.getFechaCrea() != null
							&& dtConsultas.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaCrea"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaCrea() + " :: "+ dtConsultasBk.getFechaCrea());
								}
							cambios = true;			
							dtConsultas.setFechaCrea(dtConsultasBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtConsultasBk.getFechaModif() != null
							&& dtConsultas.getFechaModif() != null) {
						if (!dtConsultasBk.getFechaModif().equals(
								dtConsultas.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaModif() + " :: "+ dtConsultasBk.getFechaModif());
								}
							cambios = true;
							dtConsultas.setFechaModif(dtConsultasBk.getFechaModif());
						}
					} else if (dtConsultasBk.getFechaModif() == null
							&& dtConsultas.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaModif() + " :: "+ dtConsultasBk.getFechaModif());
								}
							cambios = true;
							dtConsultas.setFechaModif(dtConsultasBk.getFechaModif());
						
					} else if (dtConsultasBk.getFechaModif() != null
							&& dtConsultas.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:FechaModif"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getFechaModif() + " :: "+ dtConsultasBk.getFechaModif());
								}
							cambios = true;			
							dtConsultas.setFechaModif(dtConsultasBk.getFechaModif());
					}
                                
				                                 
                                      if (dtConsultasBk.getEstado() != null
							&& dtConsultas.getEstado() != null) {
						if (!dtConsultasBk.getEstado().equals(
								dtConsultas.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Estado"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getEstado() + " :: "+ dtConsultasBk.getEstado());
								}
							cambios = true;
							dtConsultas.setEstado(dtConsultasBk.getEstado());
						}
					} else if (dtConsultasBk.getEstado() == null
							&& dtConsultas.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Estado"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getEstado() + " :: "+ dtConsultasBk.getEstado());
								}
							cambios = true;
							dtConsultas.setEstado(dtConsultasBk.getEstado());
						
					} else if (dtConsultasBk.getEstado() != null
							&& dtConsultas.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Estado"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getEstado() + " :: "+ dtConsultasBk.getEstado());
								}
							cambios = true;			
							dtConsultas.setEstado(dtConsultasBk.getEstado());
					}
                                
				
				
				
				
				
				
				
				
				                                 
                                      if (dtConsultasBk.getRtmaddress() != null
							&& dtConsultas.getRtmaddress() != null) {
						if (!dtConsultasBk.getRtmaddress().equals(
								dtConsultas.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddress"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddress() + " :: "+ dtConsultasBk.getRtmaddress());
								}
							cambios = true;
							dtConsultas.setRtmaddress(dtConsultasBk.getRtmaddress());
						}
					} else if (dtConsultasBk.getRtmaddress() == null
							&& dtConsultas.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddress"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddress() + " :: "+ dtConsultasBk.getRtmaddress());
								}
							cambios = true;
							dtConsultas.setRtmaddress(dtConsultasBk.getRtmaddress());
						
					} else if (dtConsultasBk.getRtmaddress() != null
							&& dtConsultas.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddress"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddress() + " :: "+ dtConsultasBk.getRtmaddress());
								}
							cambios = true;			
							dtConsultas.setRtmaddress(dtConsultasBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtConsultasBk.getRtmaddressrst() != null
							&& dtConsultas.getRtmaddressrst() != null) {
						if (!dtConsultasBk.getRtmaddressrst().equals(
								dtConsultas.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddressrst"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddressrst() + " :: "+ dtConsultasBk.getRtmaddressrst());
								}
							cambios = true;
							dtConsultas.setRtmaddressrst(dtConsultasBk.getRtmaddressrst());
						}
					} else if (dtConsultasBk.getRtmaddressrst() == null
							&& dtConsultas.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddressrst"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddressrst() + " :: "+ dtConsultasBk.getRtmaddressrst());
								}
							cambios = true;
							dtConsultas.setRtmaddressrst(dtConsultasBk.getRtmaddressrst());
						
					} else if (dtConsultasBk.getRtmaddressrst() != null
							&& dtConsultas.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtConsultas:Rtmaddressrst"+" :: "+dtConsultasBk.getIdConsulta().toString()+" :: "+ dtConsultas.getRtmaddressrst() + " :: "+ dtConsultasBk.getRtmaddressrst());
								}
							cambios = true;			
							dtConsultas.setRtmaddressrst(dtConsultasBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
				
				
				
				
			
			return cambios;
	}
}