package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsUsuarios;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;

/**
 * MS_USUARIOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS INTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 19/12/2023 17:22
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /19/12/2023 17:22  / Creación de la clase /
 * 
 */
public class AuditoriaMsUsuariosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsUsuariosMng.class.getName());
	
	public static boolean auditarCambiosMsUsuarios(MsUsuariosBk msUsuariosBk, MsUsuarios msUsuarios, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msUsuariosBk.getDni() != null
							&& msUsuarios.getDni() != null) {
						if (!msUsuariosBk.getDni().equals(
								msUsuarios.getDni())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Dni"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDni() + " :: "+ msUsuariosBk.getDni());
								}
							cambios = true;
							msUsuarios.setDni(msUsuariosBk.getDni());
						}
					} else if (msUsuariosBk.getDni() == null
							&& msUsuarios.getDni() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Dni"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDni() + " :: "+ msUsuariosBk.getDni());
								}
							cambios = true;
							msUsuarios.setDni(msUsuariosBk.getDni());
						
					} else if (msUsuariosBk.getDni() != null
							&& msUsuarios.getDni() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Dni"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDni() + " :: "+ msUsuariosBk.getDni());
								}
							cambios = true;			
							msUsuarios.setDni(msUsuariosBk.getDni());
					}
				 
		            if (msUsuariosBk.getNombres() != null
						&& msUsuarios.getNombres() != null) {
					if (!msUsuariosBk.getNombres().equals(
						msUsuarios.getNombres())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Nombres"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getNombres() + " :: "+ msUsuariosBk.getNombres());								
						}
						cambios = true;
						msUsuarios.setNombres(msUsuariosBk.getNombres());
					}
				} else if (msUsuariosBk.getNombres() == null
						&& msUsuarios.getNombres() != null) {
					if (msUsuarios.getNombres().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Nombres"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getNombres() + " :: "+ msUsuariosBk.getNombres());
						}
						cambios = true;
						msUsuarios.setNombres(msUsuariosBk.getNombres());
					}
				} else if (msUsuariosBk.getNombres() != null
						&& msUsuarios.getNombres() == null) {
					if (msUsuariosBk.getNombres().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Nombres"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getNombres() + " :: "+ msUsuariosBk.getNombres());
						}
						cambios = true;
						msUsuarios.setNombres(msUsuariosBk.getNombres());
					}
				}
				 
		            if (msUsuariosBk.getApellidoPaterno() != null
						&& msUsuarios.getApellidoPaterno() != null) {
					if (!msUsuariosBk.getApellidoPaterno().equals(
						msUsuarios.getApellidoPaterno())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoPaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoPaterno() + " :: "+ msUsuariosBk.getApellidoPaterno());								
						}
						cambios = true;
						msUsuarios.setApellidoPaterno(msUsuariosBk.getApellidoPaterno());
					}
				} else if (msUsuariosBk.getApellidoPaterno() == null
						&& msUsuarios.getApellidoPaterno() != null) {
					if (msUsuarios.getApellidoPaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoPaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoPaterno() + " :: "+ msUsuariosBk.getApellidoPaterno());
						}
						cambios = true;
						msUsuarios.setApellidoPaterno(msUsuariosBk.getApellidoPaterno());
					}
				} else if (msUsuariosBk.getApellidoPaterno() != null
						&& msUsuarios.getApellidoPaterno() == null) {
					if (msUsuariosBk.getApellidoPaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoPaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoPaterno() + " :: "+ msUsuariosBk.getApellidoPaterno());
						}
						cambios = true;
						msUsuarios.setApellidoPaterno(msUsuariosBk.getApellidoPaterno());
					}
				}
				 
		            if (msUsuariosBk.getApellidoMaterno() != null
						&& msUsuarios.getApellidoMaterno() != null) {
					if (!msUsuariosBk.getApellidoMaterno().equals(
						msUsuarios.getApellidoMaterno())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoMaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoMaterno() + " :: "+ msUsuariosBk.getApellidoMaterno());								
						}
						cambios = true;
						msUsuarios.setApellidoMaterno(msUsuariosBk.getApellidoMaterno());
					}
				} else if (msUsuariosBk.getApellidoMaterno() == null
						&& msUsuarios.getApellidoMaterno() != null) {
					if (msUsuarios.getApellidoMaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoMaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoMaterno() + " :: "+ msUsuariosBk.getApellidoMaterno());
						}
						cambios = true;
						msUsuarios.setApellidoMaterno(msUsuariosBk.getApellidoMaterno());
					}
				} else if (msUsuariosBk.getApellidoMaterno() != null
						&& msUsuarios.getApellidoMaterno() == null) {
					if (msUsuariosBk.getApellidoMaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:ApellidoMaterno"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getApellidoMaterno() + " :: "+ msUsuariosBk.getApellidoMaterno());
						}
						cambios = true;
						msUsuarios.setApellidoMaterno(msUsuariosBk.getApellidoMaterno());
					}
				}
				if (msUsuariosBk.getContrasenia() != null
							&& msUsuarios.getContrasenia() != null) {
						if (!msUsuariosBk.getContrasenia().equals(
								msUsuarios.getContrasenia())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Contrasenia"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getContrasenia() + " :: "+ msUsuariosBk.getContrasenia());
								}
							cambios = true;
							msUsuarios.setContrasenia(msUsuariosBk.getContrasenia());
						}
					} else if (msUsuariosBk.getContrasenia() == null
							&& msUsuarios.getContrasenia() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Contrasenia"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getContrasenia() + " :: "+ msUsuariosBk.getContrasenia());
								}
							cambios = true;
							msUsuarios.setContrasenia(msUsuariosBk.getContrasenia());
						
					} else if (msUsuariosBk.getContrasenia() != null
							&& msUsuarios.getContrasenia() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Contrasenia"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getContrasenia() + " :: "+ msUsuariosBk.getContrasenia());
								}
							cambios = true;			
							msUsuarios.setContrasenia(msUsuariosBk.getContrasenia());
					}
				 
		            if (msUsuariosBk.getProfesion() != null
						&& msUsuarios.getProfesion() != null) {
					if (!msUsuariosBk.getProfesion().equals(
						msUsuarios.getProfesion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Profesion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getProfesion() + " :: "+ msUsuariosBk.getProfesion());								
						}
						cambios = true;
						msUsuarios.setProfesion(msUsuariosBk.getProfesion());
					}
				} else if (msUsuariosBk.getProfesion() == null
						&& msUsuarios.getProfesion() != null) {
					if (msUsuarios.getProfesion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Profesion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getProfesion() + " :: "+ msUsuariosBk.getProfesion());
						}
						cambios = true;
						msUsuarios.setProfesion(msUsuariosBk.getProfesion());
					}
				} else if (msUsuariosBk.getProfesion() != null
						&& msUsuarios.getProfesion() == null) {
					if (msUsuariosBk.getProfesion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Profesion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getProfesion() + " :: "+ msUsuariosBk.getProfesion());
						}
						cambios = true;
						msUsuarios.setProfesion(msUsuariosBk.getProfesion());
					}
				}
				 
		            if (msUsuariosBk.getCorreo() != null
						&& msUsuarios.getCorreo() != null) {
					if (!msUsuariosBk.getCorreo().equals(
						msUsuarios.getCorreo())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Correo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCorreo() + " :: "+ msUsuariosBk.getCorreo());								
						}
						cambios = true;
						msUsuarios.setCorreo(msUsuariosBk.getCorreo());
					}
				} else if (msUsuariosBk.getCorreo() == null
						&& msUsuarios.getCorreo() != null) {
					if (msUsuarios.getCorreo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Correo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCorreo() + " :: "+ msUsuariosBk.getCorreo());
						}
						cambios = true;
						msUsuarios.setCorreo(msUsuariosBk.getCorreo());
					}
				} else if (msUsuariosBk.getCorreo() != null
						&& msUsuarios.getCorreo() == null) {
					if (msUsuariosBk.getCorreo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Correo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCorreo() + " :: "+ msUsuariosBk.getCorreo());
						}
						cambios = true;
						msUsuarios.setCorreo(msUsuariosBk.getCorreo());
					}
				}
				if (msUsuariosBk.getTelefono() != null
							&& msUsuarios.getTelefono() != null) {
						if (!msUsuariosBk.getTelefono().equals(
								msUsuarios.getTelefono())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Telefono"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getTelefono() + " :: "+ msUsuariosBk.getTelefono());
								}
							cambios = true;
							msUsuarios.setTelefono(msUsuariosBk.getTelefono());
						}
					} else if (msUsuariosBk.getTelefono() == null
							&& msUsuarios.getTelefono() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Telefono"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getTelefono() + " :: "+ msUsuariosBk.getTelefono());
								}
							cambios = true;
							msUsuarios.setTelefono(msUsuariosBk.getTelefono());
						
					} else if (msUsuariosBk.getTelefono() != null
							&& msUsuarios.getTelefono() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Telefono"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getTelefono() + " :: "+ msUsuariosBk.getTelefono());
								}
							cambios = true;			
							msUsuarios.setTelefono(msUsuariosBk.getTelefono());
					}
				if (msUsuariosBk.getFechaInic() != null
							&& msUsuarios.getFechaInic() != null) {
						if (!msUsuariosBk.getFechaInic().equals(
								msUsuarios.getFechaInic())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaInic"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaInic() + " :: "+ msUsuariosBk.getFechaInic());
								}
							cambios = true;
							msUsuarios.setFechaInic(msUsuariosBk.getFechaInic());
						}
					} else if (msUsuariosBk.getFechaInic() == null
							&& msUsuarios.getFechaInic() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaInic"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaInic() + " :: "+ msUsuariosBk.getFechaInic());
								}
							cambios = true;
							msUsuarios.setFechaInic(msUsuariosBk.getFechaInic());
						
					} else if (msUsuariosBk.getFechaInic() != null
							&& msUsuarios.getFechaInic() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaInic"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaInic() + " :: "+ msUsuariosBk.getFechaInic());
								}
							cambios = true;			
							msUsuarios.setFechaInic(msUsuariosBk.getFechaInic());
					}
				if (msUsuariosBk.getFechaCese() != null
							&& msUsuarios.getFechaCese() != null) {
						if (!msUsuariosBk.getFechaCese().equals(
								msUsuarios.getFechaCese())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCese"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCese() + " :: "+ msUsuariosBk.getFechaCese());
								}
							cambios = true;
							msUsuarios.setFechaCese(msUsuariosBk.getFechaCese());
						}
					} else if (msUsuariosBk.getFechaCese() == null
							&& msUsuarios.getFechaCese() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCese"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCese() + " :: "+ msUsuariosBk.getFechaCese());
								}
							cambios = true;
							msUsuarios.setFechaCese(msUsuariosBk.getFechaCese());
						
					} else if (msUsuariosBk.getFechaCese() != null
							&& msUsuarios.getFechaCese() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCese"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCese() + " :: "+ msUsuariosBk.getFechaCese());
								}
							cambios = true;			
							msUsuarios.setFechaCese(msUsuariosBk.getFechaCese());
					}
				 
		            if (msUsuariosBk.getDireccion() != null
						&& msUsuarios.getDireccion() != null) {
					if (!msUsuariosBk.getDireccion().equals(
						msUsuarios.getDireccion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Direccion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDireccion() + " :: "+ msUsuariosBk.getDireccion());								
						}
						cambios = true;
						msUsuarios.setDireccion(msUsuariosBk.getDireccion());
					}
				} else if (msUsuariosBk.getDireccion() == null
						&& msUsuarios.getDireccion() != null) {
					if (msUsuarios.getDireccion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Direccion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDireccion() + " :: "+ msUsuariosBk.getDireccion());
						}
						cambios = true;
						msUsuarios.setDireccion(msUsuariosBk.getDireccion());
					}
				} else if (msUsuariosBk.getDireccion() != null
						&& msUsuarios.getDireccion() == null) {
					if (msUsuariosBk.getDireccion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Direccion"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getDireccion() + " :: "+ msUsuariosBk.getDireccion());
						}
						cambios = true;
						msUsuarios.setDireccion(msUsuariosBk.getDireccion());
					}
				}
				 
		            if (msUsuariosBk.getUsername() != null
						&& msUsuarios.getUsername() != null) {
					if (!msUsuariosBk.getUsername().equals(
						msUsuarios.getUsername())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Username"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getUsername() + " :: "+ msUsuariosBk.getUsername());								
						}
						cambios = true;
						msUsuarios.setUsername(msUsuariosBk.getUsername());
					}
				} else if (msUsuariosBk.getUsername() == null
						&& msUsuarios.getUsername() != null) {
					if (msUsuarios.getUsername().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Username"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getUsername() + " :: "+ msUsuariosBk.getUsername());
						}
						cambios = true;
						msUsuarios.setUsername(msUsuariosBk.getUsername());
					}
				} else if (msUsuariosBk.getUsername() != null
						&& msUsuarios.getUsername() == null) {
					if (msUsuariosBk.getUsername().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Username"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getUsername() + " :: "+ msUsuariosBk.getUsername());
						}
						cambios = true;
						msUsuarios.setUsername(msUsuariosBk.getUsername());
					}
				}
				if (msUsuariosBk.getIdCargo() != null
							&& msUsuarios.getIdCargo() != null) {
						if (!msUsuariosBk.getIdCargo().equals(
								msUsuarios.getIdCargo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCargo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCargo() + " :: "+ msUsuariosBk.getIdCargo());
								}
							cambios = true;
							msUsuarios.setIdCargo(msUsuariosBk.getIdCargo());
						}
					} else if (msUsuariosBk.getIdCargo() == null
							&& msUsuarios.getIdCargo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCargo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCargo() + " :: "+ msUsuariosBk.getIdCargo());
								}
							cambios = true;
							msUsuarios.setIdCargo(msUsuariosBk.getIdCargo());
						
					} else if (msUsuariosBk.getIdCargo() != null
							&& msUsuarios.getIdCargo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCargo"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCargo() + " :: "+ msUsuariosBk.getIdCargo());
								}
							cambios = true;			
							msUsuarios.setIdCargo(msUsuariosBk.getIdCargo());
					}
				if (msUsuariosBk.getCodDpto() != null
							&& msUsuarios.getCodDpto() != null) {
						if (!msUsuariosBk.getCodDpto().equals(
								msUsuarios.getCodDpto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDpto"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDpto() + " :: "+ msUsuariosBk.getCodDpto());
								}
							cambios = true;
							msUsuarios.setCodDpto(msUsuariosBk.getCodDpto());
						}
					} else if (msUsuariosBk.getCodDpto() == null
							&& msUsuarios.getCodDpto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDpto"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDpto() + " :: "+ msUsuariosBk.getCodDpto());
								}
							cambios = true;
							msUsuarios.setCodDpto(msUsuariosBk.getCodDpto());
						
					} else if (msUsuariosBk.getCodDpto() != null
							&& msUsuarios.getCodDpto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDpto"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDpto() + " :: "+ msUsuariosBk.getCodDpto());
								}
							cambios = true;			
							msUsuarios.setCodDpto(msUsuariosBk.getCodDpto());
					}
				if (msUsuariosBk.getCodProv() != null
							&& msUsuarios.getCodProv() != null) {
						if (!msUsuariosBk.getCodProv().equals(
								msUsuarios.getCodProv())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodProv"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodProv() + " :: "+ msUsuariosBk.getCodProv());
								}
							cambios = true;
							msUsuarios.setCodProv(msUsuariosBk.getCodProv());
						}
					} else if (msUsuariosBk.getCodProv() == null
							&& msUsuarios.getCodProv() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodProv"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodProv() + " :: "+ msUsuariosBk.getCodProv());
								}
							cambios = true;
							msUsuarios.setCodProv(msUsuariosBk.getCodProv());
						
					} else if (msUsuariosBk.getCodProv() != null
							&& msUsuarios.getCodProv() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodProv"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodProv() + " :: "+ msUsuariosBk.getCodProv());
								}
							cambios = true;			
							msUsuarios.setCodProv(msUsuariosBk.getCodProv());
					}
				if (msUsuariosBk.getCodDistr() != null
							&& msUsuarios.getCodDistr() != null) {
						if (!msUsuariosBk.getCodDistr().equals(
								msUsuarios.getCodDistr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDistr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDistr() + " :: "+ msUsuariosBk.getCodDistr());
								}
							cambios = true;
							msUsuarios.setCodDistr(msUsuariosBk.getCodDistr());
						}
					} else if (msUsuariosBk.getCodDistr() == null
							&& msUsuarios.getCodDistr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDistr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDistr() + " :: "+ msUsuariosBk.getCodDistr());
								}
							cambios = true;
							msUsuarios.setCodDistr(msUsuariosBk.getCodDistr());
						
					} else if (msUsuariosBk.getCodDistr() != null
							&& msUsuarios.getCodDistr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:CodDistr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getCodDistr() + " :: "+ msUsuariosBk.getCodDistr());
								}
							cambios = true;			
							msUsuarios.setCodDistr(msUsuariosBk.getCodDistr());
					}
				if (msUsuariosBk.getIdpais() != null
							&& msUsuarios.getIdpais() != null) {
						if (!msUsuariosBk.getIdpais().equals(
								msUsuarios.getIdpais())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Idpais"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdpais() + " :: "+ msUsuariosBk.getIdpais());
								}
							cambios = true;
							msUsuarios.setIdpais(msUsuariosBk.getIdpais());
						}
					} else if (msUsuariosBk.getIdpais() == null
							&& msUsuarios.getIdpais() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Idpais"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdpais() + " :: "+ msUsuariosBk.getIdpais());
								}
							cambios = true;
							msUsuarios.setIdpais(msUsuariosBk.getIdpais());
						
					} else if (msUsuariosBk.getIdpais() != null
							&& msUsuarios.getIdpais() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Idpais"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdpais() + " :: "+ msUsuariosBk.getIdpais());
								}
							cambios = true;			
							msUsuarios.setIdpais(msUsuariosBk.getIdpais());
					}
				if (msUsuariosBk.getIdSistAdmi() != null
							&& msUsuarios.getIdSistAdmi() != null) {
						if (!msUsuariosBk.getIdSistAdmi().equals(
								msUsuarios.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSistAdmi"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSistAdmi() + " :: "+ msUsuariosBk.getIdSistAdmi());
								}
							cambios = true;
							msUsuarios.setIdSistAdmi(msUsuariosBk.getIdSistAdmi());
						}
					} else if (msUsuariosBk.getIdSistAdmi() == null
							&& msUsuarios.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSistAdmi"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSistAdmi() + " :: "+ msUsuariosBk.getIdSistAdmi());
								}
							cambios = true;
							msUsuarios.setIdSistAdmi(msUsuariosBk.getIdSistAdmi());
						
					} else if (msUsuariosBk.getIdSistAdmi() != null
							&& msUsuarios.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSistAdmi"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSistAdmi() + " :: "+ msUsuariosBk.getIdSistAdmi());
								}
							cambios = true;			
							msUsuarios.setIdSistAdmi(msUsuariosBk.getIdSistAdmi());
					}
				if (msUsuariosBk.getIdSede() != null
							&& msUsuarios.getIdSede() != null) {
						if (!msUsuariosBk.getIdSede().equals(
								msUsuarios.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSede"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSede() + " :: "+ msUsuariosBk.getIdSede());
								}
							cambios = true;
							msUsuarios.setIdSede(msUsuariosBk.getIdSede());
						}
					} else if (msUsuariosBk.getIdSede() == null
							&& msUsuarios.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSede"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSede() + " :: "+ msUsuariosBk.getIdSede());
								}
							cambios = true;
							msUsuarios.setIdSede(msUsuariosBk.getIdSede());
						
					} else if (msUsuariosBk.getIdSede() != null
							&& msUsuarios.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdSede"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdSede() + " :: "+ msUsuariosBk.getIdSede());
								}
							cambios = true;			
							msUsuarios.setIdSede(msUsuariosBk.getIdSede());
					}
				if (msUsuariosBk.getIdCondlabr() != null
							&& msUsuarios.getIdCondlabr() != null) {
						if (!msUsuariosBk.getIdCondlabr().equals(
								msUsuarios.getIdCondlabr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCondlabr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCondlabr() + " :: "+ msUsuariosBk.getIdCondlabr());
								}
							cambios = true;
							msUsuarios.setIdCondlabr(msUsuariosBk.getIdCondlabr());
						}
					} else if (msUsuariosBk.getIdCondlabr() == null
							&& msUsuarios.getIdCondlabr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCondlabr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCondlabr() + " :: "+ msUsuariosBk.getIdCondlabr());
								}
							cambios = true;
							msUsuarios.setIdCondlabr(msUsuariosBk.getIdCondlabr());
						
					} else if (msUsuariosBk.getIdCondlabr() != null
							&& msUsuarios.getIdCondlabr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IdCondlabr"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIdCondlabr() + " :: "+ msUsuariosBk.getIdCondlabr());
								}
							cambios = true;			
							msUsuarios.setIdCondlabr(msUsuariosBk.getIdCondlabr());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsUsuarios(MsUsuariosBk msUsuariosBk, MsUsuarios msUsuarios, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				
				
				
				                                 
                                      if (msUsuariosBk.getFechaModif() != null
							&& msUsuarios.getFechaModif() != null) {
						if (!msUsuariosBk.getFechaModif().equals(
								msUsuarios.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaModif() + " :: "+ msUsuariosBk.getFechaModif());
								}
							cambios = true;
							msUsuarios.setFechaModif(msUsuariosBk.getFechaModif());
						}
					} else if (msUsuariosBk.getFechaModif() == null
							&& msUsuarios.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaModif() + " :: "+ msUsuariosBk.getFechaModif());
								}
							cambios = true;
							msUsuarios.setFechaModif(msUsuariosBk.getFechaModif());
						
					} else if (msUsuariosBk.getFechaModif() != null
							&& msUsuarios.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaModif() + " :: "+ msUsuariosBk.getFechaModif());
								}
							cambios = true;			
							msUsuarios.setFechaModif(msUsuariosBk.getFechaModif());
					}
                                
				                                 
                                      if (msUsuariosBk.getFechaCrea() != null
							&& msUsuarios.getFechaCrea() != null) {
						if (!msUsuariosBk.getFechaCrea().equals(
								msUsuarios.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCrea() + " :: "+ msUsuariosBk.getFechaCrea());
								}
							cambios = true;
							msUsuarios.setFechaCrea(msUsuariosBk.getFechaCrea());
						}
					} else if (msUsuariosBk.getFechaCrea() == null
							&& msUsuarios.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCrea() + " :: "+ msUsuariosBk.getFechaCrea());
								}
							cambios = true;
							msUsuarios.setFechaCrea(msUsuariosBk.getFechaCrea());
						
					} else if (msUsuariosBk.getFechaCrea() != null
							&& msUsuarios.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:FechaCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getFechaCrea() + " :: "+ msUsuariosBk.getFechaCrea());
								}
							cambios = true;			
							msUsuarios.setFechaCrea(msUsuariosBk.getFechaCrea());
					}
                                
				
				
				                                 
                                      if (msUsuariosBk.getIduserCrea() != null
							&& msUsuarios.getIduserCrea() != null) {
						if (!msUsuariosBk.getIduserCrea().equals(
								msUsuarios.getIduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserCrea() + " :: "+ msUsuariosBk.getIduserCrea());
								}
							cambios = true;
							msUsuarios.setIduserCrea(msUsuariosBk.getIduserCrea());
						}
					} else if (msUsuariosBk.getIduserCrea() == null
							&& msUsuarios.getIduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserCrea() + " :: "+ msUsuariosBk.getIduserCrea());
								}
							cambios = true;
							msUsuarios.setIduserCrea(msUsuariosBk.getIduserCrea());
						
					} else if (msUsuariosBk.getIduserCrea() != null
							&& msUsuarios.getIduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserCrea"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserCrea() + " :: "+ msUsuariosBk.getIduserCrea());
								}
							cambios = true;			
							msUsuarios.setIduserCrea(msUsuariosBk.getIduserCrea());
					}
                                
				                                 
                                      if (msUsuariosBk.getIduserModif() != null
							&& msUsuarios.getIduserModif() != null) {
						if (!msUsuariosBk.getIduserModif().equals(
								msUsuarios.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserModif() + " :: "+ msUsuariosBk.getIduserModif());
								}
							cambios = true;
							msUsuarios.setIduserModif(msUsuariosBk.getIduserModif());
						}
					} else if (msUsuariosBk.getIduserModif() == null
							&& msUsuarios.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserModif() + " :: "+ msUsuariosBk.getIduserModif());
								}
							cambios = true;
							msUsuarios.setIduserModif(msUsuariosBk.getIduserModif());
						
					} else if (msUsuariosBk.getIduserModif() != null
							&& msUsuarios.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:IduserModif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getIduserModif() + " :: "+ msUsuariosBk.getIduserModif());
								}
							cambios = true;			
							msUsuarios.setIduserModif(msUsuariosBk.getIduserModif());
					}
                                
				
				
				                                 
                                      if (msUsuariosBk.getEstado() != null
							&& msUsuarios.getEstado() != null) {
						if (!msUsuariosBk.getEstado().equals(
								msUsuarios.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Estado"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getEstado() + " :: "+ msUsuariosBk.getEstado());
								}
							cambios = true;
							msUsuarios.setEstado(msUsuariosBk.getEstado());
						}
					} else if (msUsuariosBk.getEstado() == null
							&& msUsuarios.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Estado"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getEstado() + " :: "+ msUsuariosBk.getEstado());
								}
							cambios = true;
							msUsuarios.setEstado(msUsuariosBk.getEstado());
						
					} else if (msUsuariosBk.getEstado() != null
							&& msUsuarios.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Estado"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getEstado() + " :: "+ msUsuariosBk.getEstado());
								}
							cambios = true;			
							msUsuarios.setEstado(msUsuariosBk.getEstado());
					}
                                
				
				
				
				
				
				
				
				
				                                 
                                      if (msUsuariosBk.getRtmaddress() != null
							&& msUsuarios.getRtmaddress() != null) {
						if (!msUsuariosBk.getRtmaddress().equals(
								msUsuarios.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddress"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddress() + " :: "+ msUsuariosBk.getRtmaddress());
								}
							cambios = true;
							msUsuarios.setRtmaddress(msUsuariosBk.getRtmaddress());
						}
					} else if (msUsuariosBk.getRtmaddress() == null
							&& msUsuarios.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddress"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddress() + " :: "+ msUsuariosBk.getRtmaddress());
								}
							cambios = true;
							msUsuarios.setRtmaddress(msUsuariosBk.getRtmaddress());
						
					} else if (msUsuariosBk.getRtmaddress() != null
							&& msUsuarios.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddress"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddress() + " :: "+ msUsuariosBk.getRtmaddress());
								}
							cambios = true;			
							msUsuarios.setRtmaddress(msUsuariosBk.getRtmaddress());
					}
                                
				                                 
                                      if (msUsuariosBk.getRtmaddressmodif() != null
							&& msUsuarios.getRtmaddressmodif() != null) {
						if (!msUsuariosBk.getRtmaddressmodif().equals(
								msUsuarios.getRtmaddressmodif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddressmodif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddressmodif() + " :: "+ msUsuariosBk.getRtmaddressmodif());
								}
							cambios = true;
							msUsuarios.setRtmaddressmodif(msUsuariosBk.getRtmaddressmodif());
						}
					} else if (msUsuariosBk.getRtmaddressmodif() == null
							&& msUsuarios.getRtmaddressmodif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddressmodif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddressmodif() + " :: "+ msUsuariosBk.getRtmaddressmodif());
								}
							cambios = true;
							msUsuarios.setRtmaddressmodif(msUsuariosBk.getRtmaddressmodif());
						
					} else if (msUsuariosBk.getRtmaddressmodif() != null
							&& msUsuarios.getRtmaddressmodif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msUsuarios:Rtmaddressmodif"+" :: "+msUsuariosBk.getIdusuario().toString()+" :: "+ msUsuarios.getRtmaddressmodif() + " :: "+ msUsuariosBk.getRtmaddressmodif());
								}
							cambios = true;			
							msUsuarios.setRtmaddressmodif(msUsuariosBk.getRtmaddressmodif());
					}
                                
				
			
			return cambios;
	}
}