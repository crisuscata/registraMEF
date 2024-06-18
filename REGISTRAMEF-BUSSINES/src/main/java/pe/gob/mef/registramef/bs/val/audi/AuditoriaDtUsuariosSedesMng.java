package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtUsuariosSedes;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuariosSedesBk;

/**
 * DT_USUARIOS_SEDES SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtUsuariosSedesMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtUsuariosSedesMng.class.getName());
	
	public static boolean auditarCambiosDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, DtUsuariosSedes dtUsuariosSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtUsuariosSedesBk.getIdSede() != null
							&& dtUsuariosSedes.getIdSede() != null) {
						if (!dtUsuariosSedesBk.getIdSede().equals(
								dtUsuariosSedes.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdSede"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdSede() + " :: "+ dtUsuariosSedesBk.getIdSede());
								}
							cambios = true;
							dtUsuariosSedes.setIdSede(dtUsuariosSedesBk.getIdSede());
						}
					} else if (dtUsuariosSedesBk.getIdSede() == null
							&& dtUsuariosSedes.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdSede"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdSede() + " :: "+ dtUsuariosSedesBk.getIdSede());
								}
							cambios = true;
							dtUsuariosSedes.setIdSede(dtUsuariosSedesBk.getIdSede());
						
					} else if (dtUsuariosSedesBk.getIdSede() != null
							&& dtUsuariosSedes.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdSede"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdSede() + " :: "+ dtUsuariosSedesBk.getIdSede());
								}
							cambios = true;			
							dtUsuariosSedes.setIdSede(dtUsuariosSedesBk.getIdSede());
					}
				if (dtUsuariosSedesBk.getIdusuario() != null
							&& dtUsuariosSedes.getIdusuario() != null) {
						if (!dtUsuariosSedesBk.getIdusuario().equals(
								dtUsuariosSedes.getIdusuario())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Idusuario"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusuario() + " :: "+ dtUsuariosSedesBk.getIdusuario());
								}
							cambios = true;
							dtUsuariosSedes.setIdusuario(dtUsuariosSedesBk.getIdusuario());
						}
					} else if (dtUsuariosSedesBk.getIdusuario() == null
							&& dtUsuariosSedes.getIdusuario() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Idusuario"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusuario() + " :: "+ dtUsuariosSedesBk.getIdusuario());
								}
							cambios = true;
							dtUsuariosSedes.setIdusuario(dtUsuariosSedesBk.getIdusuario());
						
					} else if (dtUsuariosSedesBk.getIdusuario() != null
							&& dtUsuariosSedes.getIdusuario() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Idusuario"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusuario() + " :: "+ dtUsuariosSedesBk.getIdusuario());
								}
							cambios = true;			
							dtUsuariosSedes.setIdusuario(dtUsuariosSedesBk.getIdusuario());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtUsuariosSedes(DtUsuariosSedesBk dtUsuariosSedesBk, DtUsuariosSedes dtUsuariosSedes, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (dtUsuariosSedesBk.getIdusserCrea() != null
							&& dtUsuariosSedes.getIdusserCrea() != null) {
						if (!dtUsuariosSedesBk.getIdusserCrea().equals(
								dtUsuariosSedes.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserCrea() + " :: "+ dtUsuariosSedesBk.getIdusserCrea());
								}
							cambios = true;
							dtUsuariosSedes.setIdusserCrea(dtUsuariosSedesBk.getIdusserCrea());
						}
					} else if (dtUsuariosSedesBk.getIdusserCrea() == null
							&& dtUsuariosSedes.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserCrea() + " :: "+ dtUsuariosSedesBk.getIdusserCrea());
								}
							cambios = true;
							dtUsuariosSedes.setIdusserCrea(dtUsuariosSedesBk.getIdusserCrea());
						
					} else if (dtUsuariosSedesBk.getIdusserCrea() != null
							&& dtUsuariosSedes.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserCrea() + " :: "+ dtUsuariosSedesBk.getIdusserCrea());
								}
							cambios = true;			
							dtUsuariosSedes.setIdusserCrea(dtUsuariosSedesBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getIdusserModif() != null
							&& dtUsuariosSedes.getIdusserModif() != null) {
						if (!dtUsuariosSedesBk.getIdusserModif().equals(
								dtUsuariosSedes.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserModif() + " :: "+ dtUsuariosSedesBk.getIdusserModif());
								}
							cambios = true;
							dtUsuariosSedes.setIdusserModif(dtUsuariosSedesBk.getIdusserModif());
						}
					} else if (dtUsuariosSedesBk.getIdusserModif() == null
							&& dtUsuariosSedes.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserModif() + " :: "+ dtUsuariosSedesBk.getIdusserModif());
								}
							cambios = true;
							dtUsuariosSedes.setIdusserModif(dtUsuariosSedesBk.getIdusserModif());
						
					} else if (dtUsuariosSedesBk.getIdusserModif() != null
							&& dtUsuariosSedes.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:IdusserModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getIdusserModif() + " :: "+ dtUsuariosSedesBk.getIdusserModif());
								}
							cambios = true;			
							dtUsuariosSedes.setIdusserModif(dtUsuariosSedesBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getFechaCrea() != null
							&& dtUsuariosSedes.getFechaCrea() != null) {
						if (!dtUsuariosSedesBk.getFechaCrea().equals(
								dtUsuariosSedes.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaCrea() + " :: "+ dtUsuariosSedesBk.getFechaCrea());
								}
							cambios = true;
							dtUsuariosSedes.setFechaCrea(dtUsuariosSedesBk.getFechaCrea());
						}
					} else if (dtUsuariosSedesBk.getFechaCrea() == null
							&& dtUsuariosSedes.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaCrea() + " :: "+ dtUsuariosSedesBk.getFechaCrea());
								}
							cambios = true;
							dtUsuariosSedes.setFechaCrea(dtUsuariosSedesBk.getFechaCrea());
						
					} else if (dtUsuariosSedesBk.getFechaCrea() != null
							&& dtUsuariosSedes.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaCrea"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaCrea() + " :: "+ dtUsuariosSedesBk.getFechaCrea());
								}
							cambios = true;			
							dtUsuariosSedes.setFechaCrea(dtUsuariosSedesBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getFechaModif() != null
							&& dtUsuariosSedes.getFechaModif() != null) {
						if (!dtUsuariosSedesBk.getFechaModif().equals(
								dtUsuariosSedes.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaModif() + " :: "+ dtUsuariosSedesBk.getFechaModif());
								}
							cambios = true;
							dtUsuariosSedes.setFechaModif(dtUsuariosSedesBk.getFechaModif());
						}
					} else if (dtUsuariosSedesBk.getFechaModif() == null
							&& dtUsuariosSedes.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaModif() + " :: "+ dtUsuariosSedesBk.getFechaModif());
								}
							cambios = true;
							dtUsuariosSedes.setFechaModif(dtUsuariosSedesBk.getFechaModif());
						
					} else if (dtUsuariosSedesBk.getFechaModif() != null
							&& dtUsuariosSedes.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:FechaModif"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getFechaModif() + " :: "+ dtUsuariosSedesBk.getFechaModif());
								}
							cambios = true;			
							dtUsuariosSedes.setFechaModif(dtUsuariosSedesBk.getFechaModif());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getEstado() != null
							&& dtUsuariosSedes.getEstado() != null) {
						if (!dtUsuariosSedesBk.getEstado().equals(
								dtUsuariosSedes.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Estado"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getEstado() + " :: "+ dtUsuariosSedesBk.getEstado());
								}
							cambios = true;
							dtUsuariosSedes.setEstado(dtUsuariosSedesBk.getEstado());
						}
					} else if (dtUsuariosSedesBk.getEstado() == null
							&& dtUsuariosSedes.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Estado"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getEstado() + " :: "+ dtUsuariosSedesBk.getEstado());
								}
							cambios = true;
							dtUsuariosSedes.setEstado(dtUsuariosSedesBk.getEstado());
						
					} else if (dtUsuariosSedesBk.getEstado() != null
							&& dtUsuariosSedes.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Estado"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getEstado() + " :: "+ dtUsuariosSedesBk.getEstado());
								}
							cambios = true;			
							dtUsuariosSedes.setEstado(dtUsuariosSedesBk.getEstado());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getRtmaddress() != null
							&& dtUsuariosSedes.getRtmaddress() != null) {
						if (!dtUsuariosSedesBk.getRtmaddress().equals(
								dtUsuariosSedes.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddress"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddress() + " :: "+ dtUsuariosSedesBk.getRtmaddress());
								}
							cambios = true;
							dtUsuariosSedes.setRtmaddress(dtUsuariosSedesBk.getRtmaddress());
						}
					} else if (dtUsuariosSedesBk.getRtmaddress() == null
							&& dtUsuariosSedes.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddress"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddress() + " :: "+ dtUsuariosSedesBk.getRtmaddress());
								}
							cambios = true;
							dtUsuariosSedes.setRtmaddress(dtUsuariosSedesBk.getRtmaddress());
						
					} else if (dtUsuariosSedesBk.getRtmaddress() != null
							&& dtUsuariosSedes.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddress"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddress() + " :: "+ dtUsuariosSedesBk.getRtmaddress());
								}
							cambios = true;			
							dtUsuariosSedes.setRtmaddress(dtUsuariosSedesBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtUsuariosSedesBk.getRtmaddressrst() != null
							&& dtUsuariosSedes.getRtmaddressrst() != null) {
						if (!dtUsuariosSedesBk.getRtmaddressrst().equals(
								dtUsuariosSedes.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddressrst"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddressrst() + " :: "+ dtUsuariosSedesBk.getRtmaddressrst());
								}
							cambios = true;
							dtUsuariosSedes.setRtmaddressrst(dtUsuariosSedesBk.getRtmaddressrst());
						}
					} else if (dtUsuariosSedesBk.getRtmaddressrst() == null
							&& dtUsuariosSedes.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddressrst"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddressrst() + " :: "+ dtUsuariosSedesBk.getRtmaddressrst());
								}
							cambios = true;
							dtUsuariosSedes.setRtmaddressrst(dtUsuariosSedesBk.getRtmaddressrst());
						
					} else if (dtUsuariosSedesBk.getRtmaddressrst() != null
							&& dtUsuariosSedes.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuariosSedes:Rtmaddressrst"+" :: "+dtUsuariosSedesBk.getIdUsuSede().toString()+" :: "+ dtUsuariosSedes.getRtmaddressrst() + " :: "+ dtUsuariosSedesBk.getRtmaddressrst());
								}
							cambios = true;			
							dtUsuariosSedes.setRtmaddressrst(dtUsuariosSedesBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}