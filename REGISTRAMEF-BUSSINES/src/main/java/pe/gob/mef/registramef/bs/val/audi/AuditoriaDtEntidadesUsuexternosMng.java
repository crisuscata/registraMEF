package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtEntidadesUsuexternos;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesUsuexternosBk;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasUsuexternosBk;

/**
 * DT_ENTIDADES_USUEXTERNOS SERVICIO AUDITORIA Y CAMBIO: ALMACENA LAS ENTIDADES A LA QUE PERTENECE EL USUARIO EXTERNO "ENTIDAD DEL USUARIO EXTERNO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtEntidadesUsuexternosMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtEntidadesUsuexternosMng.class.getName());
	
	public static boolean auditarCambiosDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, DtEntidadesUsuexternos dtEntidadesUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtEntidadesUsuexternosBk.getIdEntidad() != null
							&& dtEntidadesUsuexternos.getIdEntidad() != null) {
						if (!dtEntidadesUsuexternosBk.getIdEntidad().equals(
								dtEntidadesUsuexternos.getIdEntidad())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdEntidad"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdEntidad() + " :: "+ dtEntidadesUsuexternosBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdEntidad(dtEntidadesUsuexternosBk.getIdEntidad());
						}
					} else if (dtEntidadesUsuexternosBk.getIdEntidad() == null
							&& dtEntidadesUsuexternos.getIdEntidad() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdEntidad"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdEntidad() + " :: "+ dtEntidadesUsuexternosBk.getIdEntidad());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdEntidad(dtEntidadesUsuexternosBk.getIdEntidad());
						
					} else if (dtEntidadesUsuexternosBk.getIdEntidad() != null
							&& dtEntidadesUsuexternos.getIdEntidad() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdEntidad"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdEntidad() + " :: "+ dtEntidadesUsuexternosBk.getIdEntidad());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setIdEntidad(dtEntidadesUsuexternosBk.getIdEntidad());
					}
				if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
							&& dtEntidadesUsuexternos.getIdUsuexterno() != null) {
						if (!dtEntidadesUsuexternosBk.getIdUsuexterno().equals(
								dtEntidadesUsuexternos.getIdUsuexterno())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
						}
					} else if (dtEntidadesUsuexternosBk.getIdUsuexterno() == null
							&& dtEntidadesUsuexternos.getIdUsuexterno() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
						
					} else if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
							&& dtEntidadesUsuexternos.getIdUsuexterno() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
					}
				
			
			return cambios;
	}
	
	// JPUYEN 14052024 - INICIO
	
		public static boolean auditarCambiosDtVisitasUsuexternos(DtVisitasUsuexternosBk dtEntidadesUsuexternosBk, DtEntidadesUsuexternos dtEntidadesUsuexternos, 
				Long iduser, 
				String user, 
				String rmtaddress, 
				int nivel 
				)
				{
					boolean cambios = false;
					
					
							if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
										&& dtEntidadesUsuexternos.getIdUsuexterno() != null) {
									if (!dtEntidadesUsuexternosBk.getIdUsuexterno().equals(
											dtEntidadesUsuexternos.getIdUsuexterno())) {						
											if(nivel>0){
											log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuexterno().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
											}
										cambios = true;
										dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
									}
								} else if (dtEntidadesUsuexternosBk.getIdUsuexterno() == null
										&& dtEntidadesUsuexternos.getIdUsuexterno() != null) {						
										if(nivel>0){
										log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuexterno().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
											}
										cambios = true;
										dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
									
								} else if (dtEntidadesUsuexternosBk.getIdUsuexterno() != null
										&& dtEntidadesUsuexternos.getIdUsuexterno() == null) {						
										if(nivel>0){
										log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdUsuexterno"+" :: "+dtEntidadesUsuexternosBk.getIdUsuexterno().toString()+" :: "+ dtEntidadesUsuexternos.getIdUsuexterno() + " :: "+ dtEntidadesUsuexternosBk.getIdUsuexterno());
											}
										cambios = true;			
										dtEntidadesUsuexternos.setIdUsuexterno(dtEntidadesUsuexternosBk.getIdUsuexterno());
								}
							
						
						return cambios;
				}
		
		
		// JPUYEN 14052024 - FIN
	
        public static boolean cambiosEnAuditoriaDtEntidadesUsuexternos(DtEntidadesUsuexternosBk dtEntidadesUsuexternosBk, DtEntidadesUsuexternos dtEntidadesUsuexternos, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				                                 
                                      if (dtEntidadesUsuexternosBk.getIdusserCrea() != null
							&& dtEntidadesUsuexternos.getIdusserCrea() != null) {
						if (!dtEntidadesUsuexternosBk.getIdusserCrea().equals(
								dtEntidadesUsuexternos.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserCrea() + " :: "+ dtEntidadesUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdusserCrea(dtEntidadesUsuexternosBk.getIdusserCrea());
						}
					} else if (dtEntidadesUsuexternosBk.getIdusserCrea() == null
							&& dtEntidadesUsuexternos.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserCrea() + " :: "+ dtEntidadesUsuexternosBk.getIdusserCrea());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdusserCrea(dtEntidadesUsuexternosBk.getIdusserCrea());
						
					} else if (dtEntidadesUsuexternosBk.getIdusserCrea() != null
							&& dtEntidadesUsuexternos.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserCrea() + " :: "+ dtEntidadesUsuexternosBk.getIdusserCrea());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setIdusserCrea(dtEntidadesUsuexternosBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtEntidadesUsuexternosBk.getIdusserModif() != null
							&& dtEntidadesUsuexternos.getIdusserModif() != null) {
						if (!dtEntidadesUsuexternosBk.getIdusserModif().equals(
								dtEntidadesUsuexternos.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserModif() + " :: "+ dtEntidadesUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdusserModif(dtEntidadesUsuexternosBk.getIdusserModif());
						}
					} else if (dtEntidadesUsuexternosBk.getIdusserModif() == null
							&& dtEntidadesUsuexternos.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserModif() + " :: "+ dtEntidadesUsuexternosBk.getIdusserModif());
								}
							cambios = true;
							dtEntidadesUsuexternos.setIdusserModif(dtEntidadesUsuexternosBk.getIdusserModif());
						
					} else if (dtEntidadesUsuexternosBk.getIdusserModif() != null
							&& dtEntidadesUsuexternos.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:IdusserModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getIdusserModif() + " :: "+ dtEntidadesUsuexternosBk.getIdusserModif());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setIdusserModif(dtEntidadesUsuexternosBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtEntidadesUsuexternosBk.getFechaCrea() != null
							&& dtEntidadesUsuexternos.getFechaCrea() != null) {
						if (!dtEntidadesUsuexternosBk.getFechaCrea().equals(
								dtEntidadesUsuexternos.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaCrea() + " :: "+ dtEntidadesUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadesUsuexternos.setFechaCrea(dtEntidadesUsuexternosBk.getFechaCrea());
						}
					} else if (dtEntidadesUsuexternosBk.getFechaCrea() == null
							&& dtEntidadesUsuexternos.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaCrea() + " :: "+ dtEntidadesUsuexternosBk.getFechaCrea());
								}
							cambios = true;
							dtEntidadesUsuexternos.setFechaCrea(dtEntidadesUsuexternosBk.getFechaCrea());
						
					} else if (dtEntidadesUsuexternosBk.getFechaCrea() != null
							&& dtEntidadesUsuexternos.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaCrea"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaCrea() + " :: "+ dtEntidadesUsuexternosBk.getFechaCrea());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setFechaCrea(dtEntidadesUsuexternosBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtEntidadesUsuexternosBk.getFechaModif() != null
							&& dtEntidadesUsuexternos.getFechaModif() != null) {
						if (!dtEntidadesUsuexternosBk.getFechaModif().equals(
								dtEntidadesUsuexternos.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaModif() + " :: "+ dtEntidadesUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtEntidadesUsuexternos.setFechaModif(dtEntidadesUsuexternosBk.getFechaModif());
						}
					} else if (dtEntidadesUsuexternosBk.getFechaModif() == null
							&& dtEntidadesUsuexternos.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaModif() + " :: "+ dtEntidadesUsuexternosBk.getFechaModif());
								}
							cambios = true;
							dtEntidadesUsuexternos.setFechaModif(dtEntidadesUsuexternosBk.getFechaModif());
						
					} else if (dtEntidadesUsuexternosBk.getFechaModif() != null
							&& dtEntidadesUsuexternos.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:FechaModif"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getFechaModif() + " :: "+ dtEntidadesUsuexternosBk.getFechaModif());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setFechaModif(dtEntidadesUsuexternosBk.getFechaModif());
					}
                                
				
				                                 
                                      if (dtEntidadesUsuexternosBk.getEstado() != null
							&& dtEntidadesUsuexternos.getEstado() != null) {
						if (!dtEntidadesUsuexternosBk.getEstado().equals(
								dtEntidadesUsuexternos.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Estado"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getEstado() + " :: "+ dtEntidadesUsuexternosBk.getEstado());
								}
							cambios = true;
							dtEntidadesUsuexternos.setEstado(dtEntidadesUsuexternosBk.getEstado());
						}
					} else if (dtEntidadesUsuexternosBk.getEstado() == null
							&& dtEntidadesUsuexternos.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Estado"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getEstado() + " :: "+ dtEntidadesUsuexternosBk.getEstado());
								}
							cambios = true;
							dtEntidadesUsuexternos.setEstado(dtEntidadesUsuexternosBk.getEstado());
						
					} else if (dtEntidadesUsuexternosBk.getEstado() != null
							&& dtEntidadesUsuexternos.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Estado"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getEstado() + " :: "+ dtEntidadesUsuexternosBk.getEstado());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setEstado(dtEntidadesUsuexternosBk.getEstado());
					}
                                
				                                 
                                      if (dtEntidadesUsuexternosBk.getRtmaddress() != null
							&& dtEntidadesUsuexternos.getRtmaddress() != null) {
						if (!dtEntidadesUsuexternosBk.getRtmaddress().equals(
								dtEntidadesUsuexternos.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddress"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddress() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadesUsuexternos.setRtmaddress(dtEntidadesUsuexternosBk.getRtmaddress());
						}
					} else if (dtEntidadesUsuexternosBk.getRtmaddress() == null
							&& dtEntidadesUsuexternos.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddress"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddress() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddress());
								}
							cambios = true;
							dtEntidadesUsuexternos.setRtmaddress(dtEntidadesUsuexternosBk.getRtmaddress());
						
					} else if (dtEntidadesUsuexternosBk.getRtmaddress() != null
							&& dtEntidadesUsuexternos.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddress"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddress() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddress());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setRtmaddress(dtEntidadesUsuexternosBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtEntidadesUsuexternosBk.getRtmaddressrst() != null
							&& dtEntidadesUsuexternos.getRtmaddressrst() != null) {
						if (!dtEntidadesUsuexternosBk.getRtmaddressrst().equals(
								dtEntidadesUsuexternos.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddressrst"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddressrst() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadesUsuexternos.setRtmaddressrst(dtEntidadesUsuexternosBk.getRtmaddressrst());
						}
					} else if (dtEntidadesUsuexternosBk.getRtmaddressrst() == null
							&& dtEntidadesUsuexternos.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddressrst"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddressrst() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;
							dtEntidadesUsuexternos.setRtmaddressrst(dtEntidadesUsuexternosBk.getRtmaddressrst());
						
					} else if (dtEntidadesUsuexternosBk.getRtmaddressrst() != null
							&& dtEntidadesUsuexternos.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtEntidadesUsuexternos:Rtmaddressrst"+" :: "+dtEntidadesUsuexternosBk.getIdUsuextEnti().toString()+" :: "+ dtEntidadesUsuexternos.getRtmaddressrst() + " :: "+ dtEntidadesUsuexternosBk.getRtmaddressrst());
								}
							cambios = true;			
							dtEntidadesUsuexternos.setRtmaddressrst(dtEntidadesUsuexternosBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}