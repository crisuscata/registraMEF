package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtUsuarioExterno;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;

/**
 * DT_USUARIO_EXTERNO SERVICIO AUDITORIA Y CAMBIO: ALMACENA A LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS EXTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtUsuarioExternoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtUsuarioExternoMng.class.getName());
	
	public static boolean auditarCambiosDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, DtUsuarioExterno dtUsuarioExterno, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (dtUsuarioExternoBk.getNombre() != null
						&& dtUsuarioExterno.getNombre() != null) {
					if (!dtUsuarioExternoBk.getNombre().equals(
						dtUsuarioExterno.getNombre())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Nombre"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNombre() + " :: "+ dtUsuarioExternoBk.getNombre());								
						}
						cambios = true;
						dtUsuarioExterno.setNombre(dtUsuarioExternoBk.getNombre());
					}
				} else if (dtUsuarioExternoBk.getNombre() == null
						&& dtUsuarioExterno.getNombre() != null) {
					if (dtUsuarioExterno.getNombre().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Nombre"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNombre() + " :: "+ dtUsuarioExternoBk.getNombre());
						}
						cambios = true;
						dtUsuarioExterno.setNombre(dtUsuarioExternoBk.getNombre());
					}
				} else if (dtUsuarioExternoBk.getNombre() != null
						&& dtUsuarioExterno.getNombre() == null) {
					if (dtUsuarioExternoBk.getNombre().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Nombre"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNombre() + " :: "+ dtUsuarioExternoBk.getNombre());
						}
						cambios = true;
						dtUsuarioExterno.setNombre(dtUsuarioExternoBk.getNombre());
					}
				}
				 
		          //INICIO CUSCATA - 18062024
		            if (dtUsuarioExternoBk.getApaterno() != null
						&& dtUsuarioExterno.getApaterno() != null) {
					if (!dtUsuarioExternoBk.getApaterno().equals(
						dtUsuarioExterno.getApaterno())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:APaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getApaterno() + " :: "+ dtUsuarioExternoBk.getApaterno());								
						}
						cambios = true;
						dtUsuarioExterno.setApaterno(dtUsuarioExternoBk.getApaterno());
					}
				} else if (dtUsuarioExternoBk.getApaterno() == null
						&& dtUsuarioExterno.getApaterno() != null) {
					if (dtUsuarioExterno.getApaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:APaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getApaterno() + " :: "+ dtUsuarioExternoBk.getApaterno());
						}
						cambios = true;
						dtUsuarioExterno.setApaterno(dtUsuarioExternoBk.getApaterno());
					}
				} else if (dtUsuarioExternoBk.getApaterno() != null
						&& dtUsuarioExterno.getApaterno() == null) {
					if (dtUsuarioExternoBk.getApaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:APaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getApaterno() + " :: "+ dtUsuarioExternoBk.getApaterno());
						}
						cambios = true;
						dtUsuarioExterno.setApaterno(dtUsuarioExternoBk.getApaterno());
					}
				}
				 
		            if (dtUsuarioExternoBk.getAmaterno() != null
						&& dtUsuarioExterno.getAmaterno() != null) {
					if (!dtUsuarioExternoBk.getAmaterno().equals(
						dtUsuarioExterno.getAmaterno())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:AMaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getAmaterno() + " :: "+ dtUsuarioExternoBk.getAmaterno());								
						}
						cambios = true;
						dtUsuarioExterno.setAmaterno(dtUsuarioExternoBk.getAmaterno());
					}
				} else if (dtUsuarioExternoBk.getAmaterno() == null
						&& dtUsuarioExterno.getAmaterno() != null) {
					if (dtUsuarioExterno.getAmaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:AMaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getAmaterno() + " :: "+ dtUsuarioExternoBk.getAmaterno());
						}
						cambios = true;
						dtUsuarioExterno.setAmaterno(dtUsuarioExternoBk.getAmaterno());
					}
				} else if (dtUsuarioExternoBk.getAmaterno() != null
						&& dtUsuarioExterno.getAmaterno() == null) {
					if (dtUsuarioExternoBk.getAmaterno().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:AMaterno"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getAmaterno() + " :: "+ dtUsuarioExternoBk.getAmaterno());
						}
						cambios = true;
						dtUsuarioExterno.setAmaterno(dtUsuarioExternoBk.getAmaterno());
					}
				}
                //FIN CUSCATA - 18062024
				if (dtUsuarioExternoBk.getDireccion() != null
							&& dtUsuarioExterno.getDireccion() != null) {
						if (!dtUsuarioExternoBk.getDireccion().equals(
								dtUsuarioExterno.getDireccion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Direccion"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getDireccion() + " :: "+ dtUsuarioExternoBk.getDireccion());
								}
							cambios = true;
							dtUsuarioExterno.setDireccion(dtUsuarioExternoBk.getDireccion());
						}
					} else if (dtUsuarioExternoBk.getDireccion() == null
							&& dtUsuarioExterno.getDireccion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Direccion"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getDireccion() + " :: "+ dtUsuarioExternoBk.getDireccion());
								}
							cambios = true;
							dtUsuarioExterno.setDireccion(dtUsuarioExternoBk.getDireccion());
						
					} else if (dtUsuarioExternoBk.getDireccion() != null
							&& dtUsuarioExterno.getDireccion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Direccion"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getDireccion() + " :: "+ dtUsuarioExternoBk.getDireccion());
								}
							cambios = true;			
							dtUsuarioExterno.setDireccion(dtUsuarioExternoBk.getDireccion());
					}
				 
		            if (dtUsuarioExternoBk.getCorreo() != null
						&& dtUsuarioExterno.getCorreo() != null) {
					if (!dtUsuarioExternoBk.getCorreo().equals(
						dtUsuarioExterno.getCorreo())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Correo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCorreo() + " :: "+ dtUsuarioExternoBk.getCorreo());								
						}
						cambios = true;
						dtUsuarioExterno.setCorreo(dtUsuarioExternoBk.getCorreo());
					}
				} else if (dtUsuarioExternoBk.getCorreo() == null
						&& dtUsuarioExterno.getCorreo() != null) {
					if (dtUsuarioExterno.getCorreo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Correo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCorreo() + " :: "+ dtUsuarioExternoBk.getCorreo());
						}
						cambios = true;
						dtUsuarioExterno.setCorreo(dtUsuarioExternoBk.getCorreo());
					}
				} else if (dtUsuarioExternoBk.getCorreo() != null
						&& dtUsuarioExterno.getCorreo() == null) {
					if (dtUsuarioExternoBk.getCorreo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Correo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCorreo() + " :: "+ dtUsuarioExternoBk.getCorreo());
						}
						cambios = true;
						dtUsuarioExterno.setCorreo(dtUsuarioExternoBk.getCorreo());
					}
				}
				if (dtUsuarioExternoBk.getTelefFijo() != null
							&& dtUsuarioExterno.getTelefFijo() != null) {
						if (!dtUsuarioExternoBk.getTelefFijo().equals(
								dtUsuarioExterno.getTelefFijo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefFijo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefFijo() + " :: "+ dtUsuarioExternoBk.getTelefFijo());
								}
							cambios = true;
							dtUsuarioExterno.setTelefFijo(dtUsuarioExternoBk.getTelefFijo());
						}
					} else if (dtUsuarioExternoBk.getTelefFijo() == null
							&& dtUsuarioExterno.getTelefFijo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefFijo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefFijo() + " :: "+ dtUsuarioExternoBk.getTelefFijo());
								}
							cambios = true;
							dtUsuarioExterno.setTelefFijo(dtUsuarioExternoBk.getTelefFijo());
						
					} else if (dtUsuarioExternoBk.getTelefFijo() != null
							&& dtUsuarioExterno.getTelefFijo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefFijo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefFijo() + " :: "+ dtUsuarioExternoBk.getTelefFijo());
								}
							cambios = true;			
							dtUsuarioExterno.setTelefFijo(dtUsuarioExternoBk.getTelefFijo());
					}
				if (dtUsuarioExternoBk.getTelefCell() != null
							&& dtUsuarioExterno.getTelefCell() != null) {
						if (!dtUsuarioExternoBk.getTelefCell().equals(
								dtUsuarioExterno.getTelefCell())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefCell"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefCell() + " :: "+ dtUsuarioExternoBk.getTelefCell());
								}
							cambios = true;
							dtUsuarioExterno.setTelefCell(dtUsuarioExternoBk.getTelefCell());
						}
					} else if (dtUsuarioExternoBk.getTelefCell() == null
							&& dtUsuarioExterno.getTelefCell() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefCell"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefCell() + " :: "+ dtUsuarioExternoBk.getTelefCell());
								}
							cambios = true;
							dtUsuarioExterno.setTelefCell(dtUsuarioExternoBk.getTelefCell());
						
					} else if (dtUsuarioExternoBk.getTelefCell() != null
							&& dtUsuarioExterno.getTelefCell() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:TelefCell"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getTelefCell() + " :: "+ dtUsuarioExternoBk.getTelefCell());
								}
							cambios = true;			
							dtUsuarioExterno.setTelefCell(dtUsuarioExternoBk.getTelefCell());
					}
				if (dtUsuarioExternoBk.getNumDocu() != null
							&& dtUsuarioExterno.getNumDocu() != null) {
						if (!dtUsuarioExternoBk.getNumDocu().equals(
								dtUsuarioExterno.getNumDocu())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocu"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocu() + " :: "+ dtUsuarioExternoBk.getNumDocu());
								}
							cambios = true;
							dtUsuarioExterno.setNumDocu(dtUsuarioExternoBk.getNumDocu());
						}
					} else if (dtUsuarioExternoBk.getNumDocu() == null
							&& dtUsuarioExterno.getNumDocu() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocu"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocu() + " :: "+ dtUsuarioExternoBk.getNumDocu());
								}
							cambios = true;
							dtUsuarioExterno.setNumDocu(dtUsuarioExternoBk.getNumDocu());
						
					} else if (dtUsuarioExternoBk.getNumDocu() != null
							&& dtUsuarioExterno.getNumDocu() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocu"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocu() + " :: "+ dtUsuarioExternoBk.getNumDocu());
								}
							cambios = true;			
							dtUsuarioExterno.setNumDocu(dtUsuarioExternoBk.getNumDocu());
					}
				 
		            if (dtUsuarioExternoBk.getSexo() != null
						&& dtUsuarioExterno.getSexo() != null) {
					if (!dtUsuarioExternoBk.getSexo().equals(
						dtUsuarioExterno.getSexo())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Sexo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getSexo() + " :: "+ dtUsuarioExternoBk.getSexo());								
						}
						cambios = true;
						dtUsuarioExterno.setSexo(dtUsuarioExternoBk.getSexo());
					}
				} else if (dtUsuarioExternoBk.getSexo() == null
						&& dtUsuarioExterno.getSexo() != null) {
					if (dtUsuarioExterno.getSexo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Sexo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getSexo() + " :: "+ dtUsuarioExternoBk.getSexo());
						}
						cambios = true;
						dtUsuarioExterno.setSexo(dtUsuarioExternoBk.getSexo());
					}
				} else if (dtUsuarioExternoBk.getSexo() != null
						&& dtUsuarioExterno.getSexo() == null) {
					if (dtUsuarioExternoBk.getSexo().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Sexo"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getSexo() + " :: "+ dtUsuarioExternoBk.getSexo());
						}
						cambios = true;
						dtUsuarioExterno.setSexo(dtUsuarioExternoBk.getSexo());
					}
				}
				if (dtUsuarioExternoBk.getIdTipodocumento() != null
							&& dtUsuarioExterno.getIdTipodocumento() != null) {
						if (!dtUsuarioExternoBk.getIdTipodocumento().equals(
								dtUsuarioExterno.getIdTipodocumento())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdTipodocumento"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdTipodocumento() + " :: "+ dtUsuarioExternoBk.getIdTipodocumento());
								}
							cambios = true;
							dtUsuarioExterno.setIdTipodocumento(dtUsuarioExternoBk.getIdTipodocumento());
						}
					} else if (dtUsuarioExternoBk.getIdTipodocumento() == null
							&& dtUsuarioExterno.getIdTipodocumento() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdTipodocumento"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdTipodocumento() + " :: "+ dtUsuarioExternoBk.getIdTipodocumento());
								}
							cambios = true;
							dtUsuarioExterno.setIdTipodocumento(dtUsuarioExternoBk.getIdTipodocumento());
						
					} else if (dtUsuarioExternoBk.getIdTipodocumento() != null
							&& dtUsuarioExterno.getIdTipodocumento() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdTipodocumento"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdTipodocumento() + " :: "+ dtUsuarioExternoBk.getIdTipodocumento());
								}
							cambios = true;			
							dtUsuarioExterno.setIdTipodocumento(dtUsuarioExternoBk.getIdTipodocumento());
					}
				if (dtUsuarioExternoBk.getCodDpto() != null
							&& dtUsuarioExterno.getCodDpto() != null) {
						if (!dtUsuarioExternoBk.getCodDpto().equals(
								dtUsuarioExterno.getCodDpto())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDpto"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDpto() + " :: "+ dtUsuarioExternoBk.getCodDpto());
								}
							cambios = true;
							dtUsuarioExterno.setCodDpto(dtUsuarioExternoBk.getCodDpto());
						}
					} else if (dtUsuarioExternoBk.getCodDpto() == null
							&& dtUsuarioExterno.getCodDpto() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDpto"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDpto() + " :: "+ dtUsuarioExternoBk.getCodDpto());
								}
							cambios = true;
							dtUsuarioExterno.setCodDpto(dtUsuarioExternoBk.getCodDpto());
						
					} else if (dtUsuarioExternoBk.getCodDpto() != null
							&& dtUsuarioExterno.getCodDpto() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDpto"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDpto() + " :: "+ dtUsuarioExternoBk.getCodDpto());
								}
							cambios = true;			
							dtUsuarioExterno.setCodDpto(dtUsuarioExternoBk.getCodDpto());
					}
				if (dtUsuarioExternoBk.getCodProv() != null
							&& dtUsuarioExterno.getCodProv() != null) {
						if (!dtUsuarioExternoBk.getCodProv().equals(
								dtUsuarioExterno.getCodProv())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodProv"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodProv() + " :: "+ dtUsuarioExternoBk.getCodProv());
								}
							cambios = true;
							dtUsuarioExterno.setCodProv(dtUsuarioExternoBk.getCodProv());
						}
					} else if (dtUsuarioExternoBk.getCodProv() == null
							&& dtUsuarioExterno.getCodProv() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodProv"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodProv() + " :: "+ dtUsuarioExternoBk.getCodProv());
								}
							cambios = true;
							dtUsuarioExterno.setCodProv(dtUsuarioExternoBk.getCodProv());
						
					} else if (dtUsuarioExternoBk.getCodProv() != null
							&& dtUsuarioExterno.getCodProv() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodProv"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodProv() + " :: "+ dtUsuarioExternoBk.getCodProv());
								}
							cambios = true;			
							dtUsuarioExterno.setCodProv(dtUsuarioExternoBk.getCodProv());
					}
				if (dtUsuarioExternoBk.getCodDistr() != null
							&& dtUsuarioExterno.getCodDistr() != null) {
						if (!dtUsuarioExternoBk.getCodDistr().equals(
								dtUsuarioExterno.getCodDistr())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDistr"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDistr() + " :: "+ dtUsuarioExternoBk.getCodDistr());
								}
							cambios = true;
							dtUsuarioExterno.setCodDistr(dtUsuarioExternoBk.getCodDistr());
						}
					} else if (dtUsuarioExternoBk.getCodDistr() == null
							&& dtUsuarioExterno.getCodDistr() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDistr"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDistr() + " :: "+ dtUsuarioExternoBk.getCodDistr());
								}
							cambios = true;
							dtUsuarioExterno.setCodDistr(dtUsuarioExternoBk.getCodDistr());
						
					} else if (dtUsuarioExternoBk.getCodDistr() != null
							&& dtUsuarioExterno.getCodDistr() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:CodDistr"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getCodDistr() + " :: "+ dtUsuarioExternoBk.getCodDistr());
								}
							cambios = true;			
							dtUsuarioExterno.setCodDistr(dtUsuarioExternoBk.getCodDistr());
					}
				if (dtUsuarioExternoBk.getIdpais() != null
							&& dtUsuarioExterno.getIdpais() != null) {
						if (!dtUsuarioExternoBk.getIdpais().equals(
								dtUsuarioExterno.getIdpais())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Idpais"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdpais() + " :: "+ dtUsuarioExternoBk.getIdpais());
								}
							cambios = true;
							dtUsuarioExterno.setIdpais(dtUsuarioExternoBk.getIdpais());
						}
					} else if (dtUsuarioExternoBk.getIdpais() == null
							&& dtUsuarioExterno.getIdpais() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Idpais"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdpais() + " :: "+ dtUsuarioExternoBk.getIdpais());
								}
							cambios = true;
							dtUsuarioExterno.setIdpais(dtUsuarioExternoBk.getIdpais());
						
					} else if (dtUsuarioExternoBk.getIdpais() != null
							&& dtUsuarioExterno.getIdpais() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Idpais"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdpais() + " :: "+ dtUsuarioExternoBk.getIdpais());
								}
							cambios = true;			
							dtUsuarioExterno.setIdpais(dtUsuarioExternoBk.getIdpais());
					}
				 
		            if (dtUsuarioExternoBk.getOtroTelefono() != null
						&& dtUsuarioExterno.getOtroTelefono() != null) {
					if (!dtUsuarioExternoBk.getOtroTelefono().equals(
						dtUsuarioExterno.getOtroTelefono())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroTelefono"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroTelefono() + " :: "+ dtUsuarioExternoBk.getOtroTelefono());								
						}
						cambios = true;
						dtUsuarioExterno.setOtroTelefono(dtUsuarioExternoBk.getOtroTelefono());
					}
				} else if (dtUsuarioExternoBk.getOtroTelefono() == null
						&& dtUsuarioExterno.getOtroTelefono() != null) {
					if (dtUsuarioExterno.getOtroTelefono().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroTelefono"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroTelefono() + " :: "+ dtUsuarioExternoBk.getOtroTelefono());
						}
						cambios = true;
						dtUsuarioExterno.setOtroTelefono(dtUsuarioExternoBk.getOtroTelefono());
					}
				} else if (dtUsuarioExternoBk.getOtroTelefono() != null
						&& dtUsuarioExterno.getOtroTelefono() == null) {
					if (dtUsuarioExternoBk.getOtroTelefono().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroTelefono"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroTelefono() + " :: "+ dtUsuarioExternoBk.getOtroTelefono());
						}
						cambios = true;
						dtUsuarioExterno.setOtroTelefono(dtUsuarioExternoBk.getOtroTelefono());
					}
				}
				 
		            if (dtUsuarioExternoBk.getOtroCelular() != null
						&& dtUsuarioExterno.getOtroCelular() != null) {
					if (!dtUsuarioExternoBk.getOtroCelular().equals(
						dtUsuarioExterno.getOtroCelular())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroCelular"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroCelular() + " :: "+ dtUsuarioExternoBk.getOtroCelular());								
						}
						cambios = true;
						dtUsuarioExterno.setOtroCelular(dtUsuarioExternoBk.getOtroCelular());
					}
				} else if (dtUsuarioExternoBk.getOtroCelular() == null
						&& dtUsuarioExterno.getOtroCelular() != null) {
					if (dtUsuarioExterno.getOtroCelular().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroCelular"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroCelular() + " :: "+ dtUsuarioExternoBk.getOtroCelular());
						}
						cambios = true;
						dtUsuarioExterno.setOtroCelular(dtUsuarioExternoBk.getOtroCelular());
					}
				} else if (dtUsuarioExternoBk.getOtroCelular() != null
						&& dtUsuarioExterno.getOtroCelular() == null) {
					if (dtUsuarioExternoBk.getOtroCelular().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:OtroCelular"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getOtroCelular() + " :: "+ dtUsuarioExternoBk.getOtroCelular());
						}
						cambios = true;
						dtUsuarioExterno.setOtroCelular(dtUsuarioExternoBk.getOtroCelular());
					}
				}
				 
		            if (dtUsuarioExternoBk.getNumDocum() != null
						&& dtUsuarioExterno.getNumDocum() != null) {
					if (!dtUsuarioExternoBk.getNumDocum().equals(
						dtUsuarioExterno.getNumDocum())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocum"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocum() + " :: "+ dtUsuarioExternoBk.getNumDocum());								
						}
						cambios = true;
						dtUsuarioExterno.setNumDocum(dtUsuarioExternoBk.getNumDocum());
					}
				} else if (dtUsuarioExternoBk.getNumDocum() == null
						&& dtUsuarioExterno.getNumDocum() != null) {
					if (dtUsuarioExterno.getNumDocum().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocum"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocum() + " :: "+ dtUsuarioExternoBk.getNumDocum());
						}
						cambios = true;
						dtUsuarioExterno.setNumDocum(dtUsuarioExternoBk.getNumDocum());
					}
				} else if (dtUsuarioExternoBk.getNumDocum() != null
						&& dtUsuarioExterno.getNumDocum() == null) {
					if (dtUsuarioExternoBk.getNumDocum().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:NumDocum"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getNumDocum() + " :: "+ dtUsuarioExternoBk.getNumDocum());
						}
						cambios = true;
						dtUsuarioExterno.setNumDocum(dtUsuarioExternoBk.getNumDocum());
					}
				}
				if (dtUsuarioExternoBk.getFlagMedioreg() != null
							&& dtUsuarioExterno.getFlagMedioreg() != null) {
						if (!dtUsuarioExternoBk.getFlagMedioreg().equals(
								dtUsuarioExterno.getFlagMedioreg())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FlagMedioreg"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFlagMedioreg() + " :: "+ dtUsuarioExternoBk.getFlagMedioreg());
								}
							cambios = true;
							dtUsuarioExterno.setFlagMedioreg(dtUsuarioExternoBk.getFlagMedioreg());
						}
					} else if (dtUsuarioExternoBk.getFlagMedioreg() == null
							&& dtUsuarioExterno.getFlagMedioreg() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FlagMedioreg"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFlagMedioreg() + " :: "+ dtUsuarioExternoBk.getFlagMedioreg());
								}
							cambios = true;
							dtUsuarioExterno.setFlagMedioreg(dtUsuarioExternoBk.getFlagMedioreg());
						
					} else if (dtUsuarioExternoBk.getFlagMedioreg() != null
							&& dtUsuarioExterno.getFlagMedioreg() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FlagMedioreg"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFlagMedioreg() + " :: "+ dtUsuarioExternoBk.getFlagMedioreg());
								}
							cambios = true;			
							dtUsuarioExterno.setFlagMedioreg(dtUsuarioExternoBk.getFlagMedioreg());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtUsuarioExterno(DtUsuarioExternoBk dtUsuarioExternoBk, DtUsuarioExterno dtUsuarioExterno, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				
				
				                                 
                                      if (dtUsuarioExternoBk.getIdusserCrea() != null
							&& dtUsuarioExterno.getIdusserCrea() != null) {
						if (!dtUsuarioExternoBk.getIdusserCrea().equals(
								dtUsuarioExterno.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserCrea() + " :: "+ dtUsuarioExternoBk.getIdusserCrea());
								}
							cambios = true;
							dtUsuarioExterno.setIdusserCrea(dtUsuarioExternoBk.getIdusserCrea());
						}
					} else if (dtUsuarioExternoBk.getIdusserCrea() == null
							&& dtUsuarioExterno.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserCrea() + " :: "+ dtUsuarioExternoBk.getIdusserCrea());
								}
							cambios = true;
							dtUsuarioExterno.setIdusserCrea(dtUsuarioExternoBk.getIdusserCrea());
						
					} else if (dtUsuarioExternoBk.getIdusserCrea() != null
							&& dtUsuarioExterno.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserCrea() + " :: "+ dtUsuarioExternoBk.getIdusserCrea());
								}
							cambios = true;			
							dtUsuarioExterno.setIdusserCrea(dtUsuarioExternoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtUsuarioExternoBk.getIdusserModif() != null
							&& dtUsuarioExterno.getIdusserModif() != null) {
						if (!dtUsuarioExternoBk.getIdusserModif().equals(
								dtUsuarioExterno.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserModif() + " :: "+ dtUsuarioExternoBk.getIdusserModif());
								}
							cambios = true;
							dtUsuarioExterno.setIdusserModif(dtUsuarioExternoBk.getIdusserModif());
						}
					} else if (dtUsuarioExternoBk.getIdusserModif() == null
							&& dtUsuarioExterno.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserModif() + " :: "+ dtUsuarioExternoBk.getIdusserModif());
								}
							cambios = true;
							dtUsuarioExterno.setIdusserModif(dtUsuarioExternoBk.getIdusserModif());
						
					} else if (dtUsuarioExternoBk.getIdusserModif() != null
							&& dtUsuarioExterno.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:IdusserModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getIdusserModif() + " :: "+ dtUsuarioExternoBk.getIdusserModif());
								}
							cambios = true;			
							dtUsuarioExterno.setIdusserModif(dtUsuarioExternoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtUsuarioExternoBk.getFechaCrea() != null
							&& dtUsuarioExterno.getFechaCrea() != null) {
						if (!dtUsuarioExternoBk.getFechaCrea().equals(
								dtUsuarioExterno.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaCrea() + " :: "+ dtUsuarioExternoBk.getFechaCrea());
								}
							cambios = true;
							dtUsuarioExterno.setFechaCrea(dtUsuarioExternoBk.getFechaCrea());
						}
					} else if (dtUsuarioExternoBk.getFechaCrea() == null
							&& dtUsuarioExterno.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaCrea() + " :: "+ dtUsuarioExternoBk.getFechaCrea());
								}
							cambios = true;
							dtUsuarioExterno.setFechaCrea(dtUsuarioExternoBk.getFechaCrea());
						
					} else if (dtUsuarioExternoBk.getFechaCrea() != null
							&& dtUsuarioExterno.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaCrea"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaCrea() + " :: "+ dtUsuarioExternoBk.getFechaCrea());
								}
							cambios = true;			
							dtUsuarioExterno.setFechaCrea(dtUsuarioExternoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtUsuarioExternoBk.getFechaModif() != null
							&& dtUsuarioExterno.getFechaModif() != null) {
						if (!dtUsuarioExternoBk.getFechaModif().equals(
								dtUsuarioExterno.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaModif() + " :: "+ dtUsuarioExternoBk.getFechaModif());
								}
							cambios = true;
							dtUsuarioExterno.setFechaModif(dtUsuarioExternoBk.getFechaModif());
						}
					} else if (dtUsuarioExternoBk.getFechaModif() == null
							&& dtUsuarioExterno.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaModif() + " :: "+ dtUsuarioExternoBk.getFechaModif());
								}
							cambios = true;
							dtUsuarioExterno.setFechaModif(dtUsuarioExternoBk.getFechaModif());
						
					} else if (dtUsuarioExternoBk.getFechaModif() != null
							&& dtUsuarioExterno.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:FechaModif"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getFechaModif() + " :: "+ dtUsuarioExternoBk.getFechaModif());
								}
							cambios = true;			
							dtUsuarioExterno.setFechaModif(dtUsuarioExternoBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtUsuarioExternoBk.getEstado() != null
							&& dtUsuarioExterno.getEstado() != null) {
						if (!dtUsuarioExternoBk.getEstado().equals(
								dtUsuarioExterno.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Estado"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getEstado() + " :: "+ dtUsuarioExternoBk.getEstado());
								}
							cambios = true;
							dtUsuarioExterno.setEstado(dtUsuarioExternoBk.getEstado());
						}
					} else if (dtUsuarioExternoBk.getEstado() == null
							&& dtUsuarioExterno.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Estado"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getEstado() + " :: "+ dtUsuarioExternoBk.getEstado());
								}
							cambios = true;
							dtUsuarioExterno.setEstado(dtUsuarioExternoBk.getEstado());
						
					} else if (dtUsuarioExternoBk.getEstado() != null
							&& dtUsuarioExterno.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Estado"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getEstado() + " :: "+ dtUsuarioExternoBk.getEstado());
								}
							cambios = true;			
							dtUsuarioExterno.setEstado(dtUsuarioExternoBk.getEstado());
					}
                                
				
				
				
				
				
				                                 
                                      if (dtUsuarioExternoBk.getRtmaddress() != null
							&& dtUsuarioExterno.getRtmaddress() != null) {
						if (!dtUsuarioExternoBk.getRtmaddress().equals(
								dtUsuarioExterno.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddress"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddress() + " :: "+ dtUsuarioExternoBk.getRtmaddress());
								}
							cambios = true;
							dtUsuarioExterno.setRtmaddress(dtUsuarioExternoBk.getRtmaddress());
						}
					} else if (dtUsuarioExternoBk.getRtmaddress() == null
							&& dtUsuarioExterno.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddress"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddress() + " :: "+ dtUsuarioExternoBk.getRtmaddress());
								}
							cambios = true;
							dtUsuarioExterno.setRtmaddress(dtUsuarioExternoBk.getRtmaddress());
						
					} else if (dtUsuarioExternoBk.getRtmaddress() != null
							&& dtUsuarioExterno.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddress"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddress() + " :: "+ dtUsuarioExternoBk.getRtmaddress());
								}
							cambios = true;			
							dtUsuarioExterno.setRtmaddress(dtUsuarioExternoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtUsuarioExternoBk.getRtmaddressrst() != null
							&& dtUsuarioExterno.getRtmaddressrst() != null) {
						if (!dtUsuarioExternoBk.getRtmaddressrst().equals(
								dtUsuarioExterno.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddressrst"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddressrst() + " :: "+ dtUsuarioExternoBk.getRtmaddressrst());
								}
							cambios = true;
							dtUsuarioExterno.setRtmaddressrst(dtUsuarioExternoBk.getRtmaddressrst());
						}
					} else if (dtUsuarioExternoBk.getRtmaddressrst() == null
							&& dtUsuarioExterno.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddressrst"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddressrst() + " :: "+ dtUsuarioExternoBk.getRtmaddressrst());
								}
							cambios = true;
							dtUsuarioExterno.setRtmaddressrst(dtUsuarioExternoBk.getRtmaddressrst());
						
					} else if (dtUsuarioExternoBk.getRtmaddressrst() != null
							&& dtUsuarioExterno.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtUsuarioExterno:Rtmaddressrst"+" :: "+dtUsuarioExternoBk.getIdUsuexterno().toString()+" :: "+ dtUsuarioExterno.getRtmaddressrst() + " :: "+ dtUsuarioExternoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtUsuarioExterno.setRtmaddressrst(dtUsuarioExternoBk.getRtmaddressrst());
					}
                                
				
				
				
				
				
			
			return cambios;
	}
}