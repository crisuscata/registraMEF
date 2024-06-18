package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsMeta;
import pe.gob.mef.registramef.bs.transfer.bk.MsMetaBk;

/**
 * MS_META SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS METAS CON SUS VALORES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsMetaMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsMetaMng.class.getName());
	
	public static boolean auditarCambiosMsMeta(MsMetaBk msMetaBk, MsMeta msMeta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msMetaBk.getAnnio() != null
							&& msMeta.getAnnio() != null) {
						if (!msMetaBk.getAnnio().equals(
								msMeta.getAnnio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Annio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getAnnio() + " :: "+ msMetaBk.getAnnio());
								}
							cambios = true;
							msMeta.setAnnio(msMetaBk.getAnnio());
						}
					} else if (msMetaBk.getAnnio() == null
							&& msMeta.getAnnio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Annio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getAnnio() + " :: "+ msMetaBk.getAnnio());
								}
							cambios = true;
							msMeta.setAnnio(msMetaBk.getAnnio());
						
					} else if (msMetaBk.getAnnio() != null
							&& msMeta.getAnnio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Annio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getAnnio() + " :: "+ msMetaBk.getAnnio());
								}
							cambios = true;			
							msMeta.setAnnio(msMetaBk.getAnnio());
					}
				if (msMetaBk.getIdTipoServicio() != null
							&& msMeta.getIdTipoServicio() != null) {
						if (!msMetaBk.getIdTipoServicio().equals(
								msMeta.getIdTipoServicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdTipoServicio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdTipoServicio() + " :: "+ msMetaBk.getIdTipoServicio());
								}
							cambios = true;
							msMeta.setIdTipoServicio(msMetaBk.getIdTipoServicio());
						}
					} else if (msMetaBk.getIdTipoServicio() == null
							&& msMeta.getIdTipoServicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdTipoServicio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdTipoServicio() + " :: "+ msMetaBk.getIdTipoServicio());
								}
							cambios = true;
							msMeta.setIdTipoServicio(msMetaBk.getIdTipoServicio());
						
					} else if (msMetaBk.getIdTipoServicio() != null
							&& msMeta.getIdTipoServicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdTipoServicio"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdTipoServicio() + " :: "+ msMetaBk.getIdTipoServicio());
								}
							cambios = true;			
							msMeta.setIdTipoServicio(msMetaBk.getIdTipoServicio());
					}
				if (msMetaBk.getIdSistAdmi() != null
							&& msMeta.getIdSistAdmi() != null) {
						if (!msMetaBk.getIdSistAdmi().equals(
								msMeta.getIdSistAdmi())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSistAdmi"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSistAdmi() + " :: "+ msMetaBk.getIdSistAdmi());
								}
							cambios = true;
							msMeta.setIdSistAdmi(msMetaBk.getIdSistAdmi());
						}
					} else if (msMetaBk.getIdSistAdmi() == null
							&& msMeta.getIdSistAdmi() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSistAdmi"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSistAdmi() + " :: "+ msMetaBk.getIdSistAdmi());
								}
							cambios = true;
							msMeta.setIdSistAdmi(msMetaBk.getIdSistAdmi());
						
					} else if (msMetaBk.getIdSistAdmi() != null
							&& msMeta.getIdSistAdmi() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSistAdmi"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSistAdmi() + " :: "+ msMetaBk.getIdSistAdmi());
								}
							cambios = true;			
							msMeta.setIdSistAdmi(msMetaBk.getIdSistAdmi());
					}
				if (msMetaBk.getIdSede() != null
							&& msMeta.getIdSede() != null) {
						if (!msMetaBk.getIdSede().equals(
								msMeta.getIdSede())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSede"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSede() + " :: "+ msMetaBk.getIdSede());
								}
							cambios = true;
							msMeta.setIdSede(msMetaBk.getIdSede());
						}
					} else if (msMetaBk.getIdSede() == null
							&& msMeta.getIdSede() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSede"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSede() + " :: "+ msMetaBk.getIdSede());
								}
							cambios = true;
							msMeta.setIdSede(msMetaBk.getIdSede());
						
					} else if (msMetaBk.getIdSede() != null
							&& msMeta.getIdSede() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdSede"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdSede() + " :: "+ msMetaBk.getIdSede());
								}
							cambios = true;			
							msMeta.setIdSede(msMetaBk.getIdSede());
					}
				if (msMetaBk.getValor() != null
							&& msMeta.getValor() != null) {
						if (!msMetaBk.getValor().equals(
								msMeta.getValor())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Valor"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getValor() + " :: "+ msMetaBk.getValor());
								}
							cambios = true;
							msMeta.setValor(msMetaBk.getValor());
						}
					} else if (msMetaBk.getValor() == null
							&& msMeta.getValor() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Valor"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getValor() + " :: "+ msMetaBk.getValor());
								}
							cambios = true;
							msMeta.setValor(msMetaBk.getValor());
						
					} else if (msMetaBk.getValor() != null
							&& msMeta.getValor() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Valor"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getValor() + " :: "+ msMetaBk.getValor());
								}
							cambios = true;			
							msMeta.setValor(msMetaBk.getValor());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsMeta(MsMetaBk msMetaBk, MsMeta msMeta, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				
				
				
				                                 
                                      if (msMetaBk.getEstado() != null
							&& msMeta.getEstado() != null) {
						if (!msMetaBk.getEstado().equals(
								msMeta.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Estado"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getEstado() + " :: "+ msMetaBk.getEstado());
								}
							cambios = true;
							msMeta.setEstado(msMetaBk.getEstado());
						}
					} else if (msMetaBk.getEstado() == null
							&& msMeta.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Estado"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getEstado() + " :: "+ msMetaBk.getEstado());
								}
							cambios = true;
							msMeta.setEstado(msMetaBk.getEstado());
						
					} else if (msMetaBk.getEstado() != null
							&& msMeta.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Estado"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getEstado() + " :: "+ msMetaBk.getEstado());
								}
							cambios = true;			
							msMeta.setEstado(msMetaBk.getEstado());
					}
                                
				                                 
                                      if (msMetaBk.getIdusserCrea() != null
							&& msMeta.getIdusserCrea() != null) {
						if (!msMetaBk.getIdusserCrea().equals(
								msMeta.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserCrea() + " :: "+ msMetaBk.getIdusserCrea());
								}
							cambios = true;
							msMeta.setIdusserCrea(msMetaBk.getIdusserCrea());
						}
					} else if (msMetaBk.getIdusserCrea() == null
							&& msMeta.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserCrea() + " :: "+ msMetaBk.getIdusserCrea());
								}
							cambios = true;
							msMeta.setIdusserCrea(msMetaBk.getIdusserCrea());
						
					} else if (msMetaBk.getIdusserCrea() != null
							&& msMeta.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserCrea() + " :: "+ msMetaBk.getIdusserCrea());
								}
							cambios = true;			
							msMeta.setIdusserCrea(msMetaBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msMetaBk.getIdusserModif() != null
							&& msMeta.getIdusserModif() != null) {
						if (!msMetaBk.getIdusserModif().equals(
								msMeta.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserModif() + " :: "+ msMetaBk.getIdusserModif());
								}
							cambios = true;
							msMeta.setIdusserModif(msMetaBk.getIdusserModif());
						}
					} else if (msMetaBk.getIdusserModif() == null
							&& msMeta.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserModif() + " :: "+ msMetaBk.getIdusserModif());
								}
							cambios = true;
							msMeta.setIdusserModif(msMetaBk.getIdusserModif());
						
					} else if (msMetaBk.getIdusserModif() != null
							&& msMeta.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:IdusserModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getIdusserModif() + " :: "+ msMetaBk.getIdusserModif());
								}
							cambios = true;			
							msMeta.setIdusserModif(msMetaBk.getIdusserModif());
					}
                                
				                                 
                                      if (msMetaBk.getFechaCrea() != null
							&& msMeta.getFechaCrea() != null) {
						if (!msMetaBk.getFechaCrea().equals(
								msMeta.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaCrea() + " :: "+ msMetaBk.getFechaCrea());
								}
							cambios = true;
							msMeta.setFechaCrea(msMetaBk.getFechaCrea());
						}
					} else if (msMetaBk.getFechaCrea() == null
							&& msMeta.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaCrea() + " :: "+ msMetaBk.getFechaCrea());
								}
							cambios = true;
							msMeta.setFechaCrea(msMetaBk.getFechaCrea());
						
					} else if (msMetaBk.getFechaCrea() != null
							&& msMeta.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaCrea"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaCrea() + " :: "+ msMetaBk.getFechaCrea());
								}
							cambios = true;			
							msMeta.setFechaCrea(msMetaBk.getFechaCrea());
					}
                                
				                                 
                                      if (msMetaBk.getFechaModif() != null
							&& msMeta.getFechaModif() != null) {
						if (!msMetaBk.getFechaModif().equals(
								msMeta.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaModif() + " :: "+ msMetaBk.getFechaModif());
								}
							cambios = true;
							msMeta.setFechaModif(msMetaBk.getFechaModif());
						}
					} else if (msMetaBk.getFechaModif() == null
							&& msMeta.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaModif() + " :: "+ msMetaBk.getFechaModif());
								}
							cambios = true;
							msMeta.setFechaModif(msMetaBk.getFechaModif());
						
					} else if (msMetaBk.getFechaModif() != null
							&& msMeta.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:FechaModif"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getFechaModif() + " :: "+ msMetaBk.getFechaModif());
								}
							cambios = true;			
							msMeta.setFechaModif(msMetaBk.getFechaModif());
					}
                                
				                                 
                                      if (msMetaBk.getRtmaddress() != null
							&& msMeta.getRtmaddress() != null) {
						if (!msMetaBk.getRtmaddress().equals(
								msMeta.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddress"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddress() + " :: "+ msMetaBk.getRtmaddress());
								}
							cambios = true;
							msMeta.setRtmaddress(msMetaBk.getRtmaddress());
						}
					} else if (msMetaBk.getRtmaddress() == null
							&& msMeta.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddress"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddress() + " :: "+ msMetaBk.getRtmaddress());
								}
							cambios = true;
							msMeta.setRtmaddress(msMetaBk.getRtmaddress());
						
					} else if (msMetaBk.getRtmaddress() != null
							&& msMeta.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddress"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddress() + " :: "+ msMetaBk.getRtmaddress());
								}
							cambios = true;			
							msMeta.setRtmaddress(msMetaBk.getRtmaddress());
					}
                                
				                                 
                                      if (msMetaBk.getRtmaddressrst() != null
							&& msMeta.getRtmaddressrst() != null) {
						if (!msMetaBk.getRtmaddressrst().equals(
								msMeta.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddressrst"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddressrst() + " :: "+ msMetaBk.getRtmaddressrst());
								}
							cambios = true;
							msMeta.setRtmaddressrst(msMetaBk.getRtmaddressrst());
						}
					} else if (msMetaBk.getRtmaddressrst() == null
							&& msMeta.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddressrst"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddressrst() + " :: "+ msMetaBk.getRtmaddressrst());
								}
							cambios = true;
							msMeta.setRtmaddressrst(msMetaBk.getRtmaddressrst());
						
					} else if (msMetaBk.getRtmaddressrst() != null
							&& msMeta.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msMeta:Rtmaddressrst"+" :: "+msMetaBk.getIdMeta().toString()+" :: "+ msMeta.getRtmaddressrst() + " :: "+ msMetaBk.getRtmaddressrst());
								}
							cambios = true;			
							msMeta.setRtmaddressrst(msMetaBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}