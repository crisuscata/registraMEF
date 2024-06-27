package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.TaFeriados;
import pe.gob.mef.registramef.bs.transfer.bk.TaFeriadosBk;

/**
 * TA_FERIADOS SERVICIO AUDITORIA Y CAMBIO: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaTaFeriadosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaTaFeriadosMng.class.getName());
	
	public static boolean auditarCambiosTaFeriados(TaFeriadosBk taFeriadosBk, TaFeriados taFeriados, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (taFeriadosBk.getFeDesc() != null
						&& taFeriados.getFeDesc() != null) {
					if (!taFeriadosBk.getFeDesc().equals(
						taFeriados.getFeDesc())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeDesc"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeDesc() + " :: "+ taFeriadosBk.getFeDesc());								
						}
						cambios = true;
						taFeriados.setFeDesc(taFeriadosBk.getFeDesc());
					}
				} else if (taFeriadosBk.getFeDesc() == null
						&& taFeriados.getFeDesc() != null) {
					if (taFeriados.getFeDesc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeDesc"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeDesc() + " :: "+ taFeriadosBk.getFeDesc());
						}
						cambios = true;
						taFeriados.setFeDesc(taFeriadosBk.getFeDesc());
					}
				} else if (taFeriadosBk.getFeDesc() != null
						&& taFeriados.getFeDesc() == null) {
					if (taFeriadosBk.getFeDesc().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeDesc"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeDesc() + " :: "+ taFeriadosBk.getFeDesc());
						}
						cambios = true;
						taFeriados.setFeDesc(taFeriadosBk.getFeDesc());
					}
				}
		            
//PURIBE 16012024 - INICIO-->
		            
		        	if (taFeriadosBk.getFeEstado() != null
							&& taFeriados.getFeEstado() != null) {
						if (!taFeriadosBk.getFeEstado().equals(
								taFeriados.getFeEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
						}
					} else if (taFeriadosBk.getFeEstado() == null
							&& taFeriados.getFeEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+  taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
						
					} else if (taFeriadosBk.getFeEstado() != null
							&& taFeriados.getFeEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"prtParametros:Estado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;			
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
					}
				
		        	//PURIBE 16012024 -- FIN-->
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaTaFeriados(TaFeriadosBk taFeriadosBk, TaFeriados taFeriados, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (taFeriadosBk.getFeIdusu() != null
							&& taFeriados.getFeIdusu() != null) {
						if (!taFeriadosBk.getFeIdusu().equals(
								taFeriados.getFeIdusu())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusu"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusu() + " :: "+ taFeriadosBk.getFeIdusu());
								}
							cambios = true;
							taFeriados.setFeIdusu(taFeriadosBk.getFeIdusu());
						}
					} else if (taFeriadosBk.getFeIdusu() == null
							&& taFeriados.getFeIdusu() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusu"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusu() + " :: "+ taFeriadosBk.getFeIdusu());
								}
							cambios = true;
							taFeriados.setFeIdusu(taFeriadosBk.getFeIdusu());
						
					} else if (taFeriadosBk.getFeIdusu() != null
							&& taFeriados.getFeIdusu() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusu"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusu() + " :: "+ taFeriadosBk.getFeIdusu());
								}
							cambios = true;			
							taFeriados.setFeIdusu(taFeriadosBk.getFeIdusu());
					}
                                
				                                 
                                      if (taFeriadosBk.getFeFchcrear() != null
							&& taFeriados.getFeFchcrear() != null) {
						if (!taFeriadosBk.getFeFchcrear().equals(
								taFeriados.getFeFchcrear())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchcrear"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchcrear() + " :: "+ taFeriadosBk.getFeFchcrear());
								}
							cambios = true;
							taFeriados.setFeFchcrear(taFeriadosBk.getFeFchcrear());
						}
					} else if (taFeriadosBk.getFeFchcrear() == null
							&& taFeriados.getFeFchcrear() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchcrear"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchcrear() + " :: "+ taFeriadosBk.getFeFchcrear());
								}
							cambios = true;
							taFeriados.setFeFchcrear(taFeriadosBk.getFeFchcrear());
						
					} else if (taFeriadosBk.getFeFchcrear() != null
							&& taFeriados.getFeFchcrear() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchcrear"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchcrear() + " :: "+ taFeriadosBk.getFeFchcrear());
								}
							cambios = true;			
							taFeriados.setFeFchcrear(taFeriadosBk.getFeFchcrear());
					}
                                
				                                 
                                      if (taFeriadosBk.getFeIdusumod() != null
							&& taFeriados.getFeIdusumod() != null) {
						if (!taFeriadosBk.getFeIdusumod().equals(
								taFeriados.getFeIdusumod())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusumod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusumod() + " :: "+ taFeriadosBk.getFeIdusumod());
								}
							cambios = true;
							taFeriados.setFeIdusumod(taFeriadosBk.getFeIdusumod());
						}
					} else if (taFeriadosBk.getFeIdusumod() == null
							&& taFeriados.getFeIdusumod() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusumod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusumod() + " :: "+ taFeriadosBk.getFeIdusumod());
								}
							cambios = true;
							taFeriados.setFeIdusumod(taFeriadosBk.getFeIdusumod());
						
					} else if (taFeriadosBk.getFeIdusumod() != null
							&& taFeriados.getFeIdusumod() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeIdusumod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeIdusumod() + " :: "+ taFeriadosBk.getFeIdusumod());
								}
							cambios = true;			
							taFeriados.setFeIdusumod(taFeriadosBk.getFeIdusumod());
					}
                                
				                                 
                                      if (taFeriadosBk.getFeFchmod() != null
							&& taFeriados.getFeFchmod() != null) {
						if (!taFeriadosBk.getFeFchmod().equals(
								taFeriados.getFeFchmod())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchmod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchmod() + " :: "+ taFeriadosBk.getFeFchmod());
								}
							cambios = true;
							taFeriados.setFeFchmod(taFeriadosBk.getFeFchmod());
						}
					} else if (taFeriadosBk.getFeFchmod() == null
							&& taFeriados.getFeFchmod() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchmod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchmod() + " :: "+ taFeriadosBk.getFeFchmod());
								}
							cambios = true;
							taFeriados.setFeFchmod(taFeriadosBk.getFeFchmod());
						
					} else if (taFeriadosBk.getFeFchmod() != null
							&& taFeriados.getFeFchmod() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeFchmod"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeFchmod() + " :: "+ taFeriadosBk.getFeFchmod());
								}
							cambios = true;			
							taFeriados.setFeFchmod(taFeriadosBk.getFeFchmod());
					}
                                
				                                 
                                      if (taFeriadosBk.getFeEstado() != null
							&& taFeriados.getFeEstado() != null) {
						if (!taFeriadosBk.getFeEstado().equals(
								taFeriados.getFeEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeEstado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
						}
					} else if (taFeriadosBk.getFeEstado() == null
							&& taFeriados.getFeEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeEstado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
						
					} else if (taFeriadosBk.getFeEstado() != null
							&& taFeriados.getFeEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"taFeriados:FeEstado"+" :: "+taFeriadosBk.getFeFecha().toString()+" :: "+ taFeriados.getFeEstado() + " :: "+ taFeriadosBk.getFeEstado());
								}
							cambios = true;			
							taFeriados.setFeEstado(taFeriadosBk.getFeEstado());
					}
                                
				
			
			return cambios;
	}
}