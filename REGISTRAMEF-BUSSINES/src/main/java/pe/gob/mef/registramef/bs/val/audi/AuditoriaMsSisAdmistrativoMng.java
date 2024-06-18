package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsSisAdmistrativo;
import pe.gob.mef.registramef.bs.transfer.bk.MsSisAdmistrativoBk;

/**
 * MS_SIS_ADMISTRATIVO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS SISTEMAS ADMINISTRATIVOS REGISTRADOS EN EL SISTEMA "SISTEMA ADMINISTRATIVO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsSisAdmistrativoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsSisAdmistrativoMng.class.getName());
	
	public static boolean auditarCambiosMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, MsSisAdmistrativo msSisAdmistrativo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		 
		            if (msSisAdmistrativoBk.getDescripcion() != null
						&& msSisAdmistrativo.getDescripcion() != null) {
					if (!msSisAdmistrativoBk.getDescripcion().equals(
						msSisAdmistrativo.getDescripcion())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Descripcion"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getDescripcion() + " :: "+ msSisAdmistrativoBk.getDescripcion());								
						}
						cambios = true;
						msSisAdmistrativo.setDescripcion(msSisAdmistrativoBk.getDescripcion());
					}
				} else if (msSisAdmistrativoBk.getDescripcion() == null
						&& msSisAdmistrativo.getDescripcion() != null) {
					if (msSisAdmistrativo.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Descripcion"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getDescripcion() + " :: "+ msSisAdmistrativoBk.getDescripcion());
						}
						cambios = true;
						msSisAdmistrativo.setDescripcion(msSisAdmistrativoBk.getDescripcion());
					}
				} else if (msSisAdmistrativoBk.getDescripcion() != null
						&& msSisAdmistrativo.getDescripcion() == null) {
					if (msSisAdmistrativoBk.getDescripcion().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Descripcion"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getDescripcion() + " :: "+ msSisAdmistrativoBk.getDescripcion());
						}
						cambios = true;
						msSisAdmistrativo.setDescripcion(msSisAdmistrativoBk.getDescripcion());
					}
				}
				if (msSisAdmistrativoBk.getFlagasocencuesta() != null
							&& msSisAdmistrativo.getFlagasocencuesta() != null) {
						if (!msSisAdmistrativoBk.getFlagasocencuesta().equals(
								msSisAdmistrativo.getFlagasocencuesta())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Flagasocencuesta"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFlagasocencuesta() + " :: "+ msSisAdmistrativoBk.getFlagasocencuesta());
								}
							cambios = true;
							msSisAdmistrativo.setFlagasocencuesta(msSisAdmistrativoBk.getFlagasocencuesta());
						}
					} else if (msSisAdmistrativoBk.getFlagasocencuesta() == null
							&& msSisAdmistrativo.getFlagasocencuesta() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Flagasocencuesta"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFlagasocencuesta() + " :: "+ msSisAdmistrativoBk.getFlagasocencuesta());
								}
							cambios = true;
							msSisAdmistrativo.setFlagasocencuesta(msSisAdmistrativoBk.getFlagasocencuesta());
						
					} else if (msSisAdmistrativoBk.getFlagasocencuesta() != null
							&& msSisAdmistrativo.getFlagasocencuesta() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Flagasocencuesta"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFlagasocencuesta() + " :: "+ msSisAdmistrativoBk.getFlagasocencuesta());
								}
							cambios = true;			
							msSisAdmistrativo.setFlagasocencuesta(msSisAdmistrativoBk.getFlagasocencuesta());
					}
				 
		            if (msSisAdmistrativoBk.getAbreviatura() != null
						&& msSisAdmistrativo.getAbreviatura() != null) {
					if (!msSisAdmistrativoBk.getAbreviatura().equals(
						msSisAdmistrativo.getAbreviatura())) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: " + iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Abreviatura"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getAbreviatura() + " :: "+ msSisAdmistrativoBk.getAbreviatura());								
						}
						cambios = true;
						msSisAdmistrativo.setAbreviatura(msSisAdmistrativoBk.getAbreviatura());
					}
				} else if (msSisAdmistrativoBk.getAbreviatura() == null
						&& msSisAdmistrativo.getAbreviatura() != null) {
					if (msSisAdmistrativo.getAbreviatura().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Abreviatura"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getAbreviatura() + " :: "+ msSisAdmistrativoBk.getAbreviatura());
						}
						cambios = true;
						msSisAdmistrativo.setAbreviatura(msSisAdmistrativoBk.getAbreviatura());
					}
				} else if (msSisAdmistrativoBk.getAbreviatura() != null
						&& msSisAdmistrativo.getAbreviatura() == null) {
					if (msSisAdmistrativoBk.getAbreviatura().trim().length() > 0) {						
						if(nivel>0){
						log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Abreviatura"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getAbreviatura() + " :: "+ msSisAdmistrativoBk.getAbreviatura());
						}
						cambios = true;
						msSisAdmistrativo.setAbreviatura(msSisAdmistrativoBk.getAbreviatura());
					}
				}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsSisAdmistrativo(MsSisAdmistrativoBk msSisAdmistrativoBk, MsSisAdmistrativo msSisAdmistrativo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (msSisAdmistrativoBk.getIdusserCrea() != null
							&& msSisAdmistrativo.getIdusserCrea() != null) {
						if (!msSisAdmistrativoBk.getIdusserCrea().equals(
								msSisAdmistrativo.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserCrea() + " :: "+ msSisAdmistrativoBk.getIdusserCrea());
								}
							cambios = true;
							msSisAdmistrativo.setIdusserCrea(msSisAdmistrativoBk.getIdusserCrea());
						}
					} else if (msSisAdmistrativoBk.getIdusserCrea() == null
							&& msSisAdmistrativo.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserCrea() + " :: "+ msSisAdmistrativoBk.getIdusserCrea());
								}
							cambios = true;
							msSisAdmistrativo.setIdusserCrea(msSisAdmistrativoBk.getIdusserCrea());
						
					} else if (msSisAdmistrativoBk.getIdusserCrea() != null
							&& msSisAdmistrativo.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserCrea() + " :: "+ msSisAdmistrativoBk.getIdusserCrea());
								}
							cambios = true;			
							msSisAdmistrativo.setIdusserCrea(msSisAdmistrativoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getIdusserModif() != null
							&& msSisAdmistrativo.getIdusserModif() != null) {
						if (!msSisAdmistrativoBk.getIdusserModif().equals(
								msSisAdmistrativo.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserModif() + " :: "+ msSisAdmistrativoBk.getIdusserModif());
								}
							cambios = true;
							msSisAdmistrativo.setIdusserModif(msSisAdmistrativoBk.getIdusserModif());
						}
					} else if (msSisAdmistrativoBk.getIdusserModif() == null
							&& msSisAdmistrativo.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserModif() + " :: "+ msSisAdmistrativoBk.getIdusserModif());
								}
							cambios = true;
							msSisAdmistrativo.setIdusserModif(msSisAdmistrativoBk.getIdusserModif());
						
					} else if (msSisAdmistrativoBk.getIdusserModif() != null
							&& msSisAdmistrativo.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:IdusserModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getIdusserModif() + " :: "+ msSisAdmistrativoBk.getIdusserModif());
								}
							cambios = true;			
							msSisAdmistrativo.setIdusserModif(msSisAdmistrativoBk.getIdusserModif());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getFechaCrea() != null
							&& msSisAdmistrativo.getFechaCrea() != null) {
						if (!msSisAdmistrativoBk.getFechaCrea().equals(
								msSisAdmistrativo.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaCrea() + " :: "+ msSisAdmistrativoBk.getFechaCrea());
								}
							cambios = true;
							msSisAdmistrativo.setFechaCrea(msSisAdmistrativoBk.getFechaCrea());
						}
					} else if (msSisAdmistrativoBk.getFechaCrea() == null
							&& msSisAdmistrativo.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaCrea() + " :: "+ msSisAdmistrativoBk.getFechaCrea());
								}
							cambios = true;
							msSisAdmistrativo.setFechaCrea(msSisAdmistrativoBk.getFechaCrea());
						
					} else if (msSisAdmistrativoBk.getFechaCrea() != null
							&& msSisAdmistrativo.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaCrea"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaCrea() + " :: "+ msSisAdmistrativoBk.getFechaCrea());
								}
							cambios = true;			
							msSisAdmistrativo.setFechaCrea(msSisAdmistrativoBk.getFechaCrea());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getFechaModif() != null
							&& msSisAdmistrativo.getFechaModif() != null) {
						if (!msSisAdmistrativoBk.getFechaModif().equals(
								msSisAdmistrativo.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaModif() + " :: "+ msSisAdmistrativoBk.getFechaModif());
								}
							cambios = true;
							msSisAdmistrativo.setFechaModif(msSisAdmistrativoBk.getFechaModif());
						}
					} else if (msSisAdmistrativoBk.getFechaModif() == null
							&& msSisAdmistrativo.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaModif() + " :: "+ msSisAdmistrativoBk.getFechaModif());
								}
							cambios = true;
							msSisAdmistrativo.setFechaModif(msSisAdmistrativoBk.getFechaModif());
						
					} else if (msSisAdmistrativoBk.getFechaModif() != null
							&& msSisAdmistrativo.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:FechaModif"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getFechaModif() + " :: "+ msSisAdmistrativoBk.getFechaModif());
								}
							cambios = true;			
							msSisAdmistrativo.setFechaModif(msSisAdmistrativoBk.getFechaModif());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getEstado() != null
							&& msSisAdmistrativo.getEstado() != null) {
						if (!msSisAdmistrativoBk.getEstado().equals(
								msSisAdmistrativo.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Estado"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getEstado() + " :: "+ msSisAdmistrativoBk.getEstado());
								}
							cambios = true;
							msSisAdmistrativo.setEstado(msSisAdmistrativoBk.getEstado());
						}
					} else if (msSisAdmistrativoBk.getEstado() == null
							&& msSisAdmistrativo.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Estado"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getEstado() + " :: "+ msSisAdmistrativoBk.getEstado());
								}
							cambios = true;
							msSisAdmistrativo.setEstado(msSisAdmistrativoBk.getEstado());
						
					} else if (msSisAdmistrativoBk.getEstado() != null
							&& msSisAdmistrativo.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Estado"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getEstado() + " :: "+ msSisAdmistrativoBk.getEstado());
								}
							cambios = true;			
							msSisAdmistrativo.setEstado(msSisAdmistrativoBk.getEstado());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getRtmaddress() != null
							&& msSisAdmistrativo.getRtmaddress() != null) {
						if (!msSisAdmistrativoBk.getRtmaddress().equals(
								msSisAdmistrativo.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddress"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddress() + " :: "+ msSisAdmistrativoBk.getRtmaddress());
								}
							cambios = true;
							msSisAdmistrativo.setRtmaddress(msSisAdmistrativoBk.getRtmaddress());
						}
					} else if (msSisAdmistrativoBk.getRtmaddress() == null
							&& msSisAdmistrativo.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddress"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddress() + " :: "+ msSisAdmistrativoBk.getRtmaddress());
								}
							cambios = true;
							msSisAdmistrativo.setRtmaddress(msSisAdmistrativoBk.getRtmaddress());
						
					} else if (msSisAdmistrativoBk.getRtmaddress() != null
							&& msSisAdmistrativo.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddress"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddress() + " :: "+ msSisAdmistrativoBk.getRtmaddress());
								}
							cambios = true;			
							msSisAdmistrativo.setRtmaddress(msSisAdmistrativoBk.getRtmaddress());
					}
                                
				                                 
                                      if (msSisAdmistrativoBk.getRtmaddressrst() != null
							&& msSisAdmistrativo.getRtmaddressrst() != null) {
						if (!msSisAdmistrativoBk.getRtmaddressrst().equals(
								msSisAdmistrativo.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddressrst"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddressrst() + " :: "+ msSisAdmistrativoBk.getRtmaddressrst());
								}
							cambios = true;
							msSisAdmistrativo.setRtmaddressrst(msSisAdmistrativoBk.getRtmaddressrst());
						}
					} else if (msSisAdmistrativoBk.getRtmaddressrst() == null
							&& msSisAdmistrativo.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddressrst"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddressrst() + " :: "+ msSisAdmistrativoBk.getRtmaddressrst());
								}
							cambios = true;
							msSisAdmistrativo.setRtmaddressrst(msSisAdmistrativoBk.getRtmaddressrst());
						
					} else if (msSisAdmistrativoBk.getRtmaddressrst() != null
							&& msSisAdmistrativo.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msSisAdmistrativo:Rtmaddressrst"+" :: "+msSisAdmistrativoBk.getIdSistAdmi().toString()+" :: "+ msSisAdmistrativo.getRtmaddressrst() + " :: "+ msSisAdmistrativoBk.getRtmaddressrst());
								}
							cambios = true;			
							msSisAdmistrativo.setRtmaddressrst(msSisAdmistrativoBk.getRtmaddressrst());
					}
                                
				
				
				
			
			return cambios;
	}
}