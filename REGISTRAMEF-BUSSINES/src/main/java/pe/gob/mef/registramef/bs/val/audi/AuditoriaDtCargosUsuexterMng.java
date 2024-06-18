package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtCargosUsuexter;
import pe.gob.mef.registramef.bs.transfer.bk.DtCargosUsuexterBk;

/**
 * DT_CARGOS_USUEXTER SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS CARGOS DE LOS USUARIOS EXTERNOS "CARGO DE USUARIO EXTERNO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtCargosUsuexterMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtCargosUsuexterMng.class.getName());
	
	public static boolean auditarCambiosDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, DtCargosUsuexter dtCargosUsuexter, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtCargosUsuexterBk.getIdUsuextEnti() != null
							&& dtCargosUsuexter.getIdUsuextEnti() != null) {
						if (!dtCargosUsuexterBk.getIdUsuextEnti().equals(
								dtCargosUsuexter.getIdUsuextEnti())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdUsuextEnti"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdUsuextEnti() + " :: "+ dtCargosUsuexterBk.getIdUsuextEnti());
								}
							cambios = true;
							dtCargosUsuexter.setIdUsuextEnti(dtCargosUsuexterBk.getIdUsuextEnti());
						}
					} else if (dtCargosUsuexterBk.getIdUsuextEnti() == null
							&& dtCargosUsuexter.getIdUsuextEnti() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdUsuextEnti"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdUsuextEnti() + " :: "+ dtCargosUsuexterBk.getIdUsuextEnti());
								}
							cambios = true;
							dtCargosUsuexter.setIdUsuextEnti(dtCargosUsuexterBk.getIdUsuextEnti());
						
					} else if (dtCargosUsuexterBk.getIdUsuextEnti() != null
							&& dtCargosUsuexter.getIdUsuextEnti() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdUsuextEnti"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdUsuextEnti() + " :: "+ dtCargosUsuexterBk.getIdUsuextEnti());
								}
							cambios = true;			
							dtCargosUsuexter.setIdUsuextEnti(dtCargosUsuexterBk.getIdUsuextEnti());
					}
				if (dtCargosUsuexterBk.getIdCargo() != null
							&& dtCargosUsuexter.getIdCargo() != null) {
						if (!dtCargosUsuexterBk.getIdCargo().equals(
								dtCargosUsuexter.getIdCargo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdCargo"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdCargo() + " :: "+ dtCargosUsuexterBk.getIdCargo());
								}
							cambios = true;
							dtCargosUsuexter.setIdCargo(dtCargosUsuexterBk.getIdCargo());
						}
					} else if (dtCargosUsuexterBk.getIdCargo() == null
							&& dtCargosUsuexter.getIdCargo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdCargo"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdCargo() + " :: "+ dtCargosUsuexterBk.getIdCargo());
								}
							cambios = true;
							dtCargosUsuexter.setIdCargo(dtCargosUsuexterBk.getIdCargo());
						
					} else if (dtCargosUsuexterBk.getIdCargo() != null
							&& dtCargosUsuexter.getIdCargo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IdCargo"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIdCargo() + " :: "+ dtCargosUsuexterBk.getIdCargo());
								}
							cambios = true;			
							dtCargosUsuexter.setIdCargo(dtCargosUsuexterBk.getIdCargo());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtCargosUsuexter(DtCargosUsuexterBk dtCargosUsuexterBk, DtCargosUsuexter dtCargosUsuexter, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtCargosUsuexterBk.getFechaCrea() != null
							&& dtCargosUsuexter.getFechaCrea() != null) {
						if (!dtCargosUsuexterBk.getFechaCrea().equals(
								dtCargosUsuexter.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaCrea() + " :: "+ dtCargosUsuexterBk.getFechaCrea());
								}
							cambios = true;
							dtCargosUsuexter.setFechaCrea(dtCargosUsuexterBk.getFechaCrea());
						}
					} else if (dtCargosUsuexterBk.getFechaCrea() == null
							&& dtCargosUsuexter.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaCrea() + " :: "+ dtCargosUsuexterBk.getFechaCrea());
								}
							cambios = true;
							dtCargosUsuexter.setFechaCrea(dtCargosUsuexterBk.getFechaCrea());
						
					} else if (dtCargosUsuexterBk.getFechaCrea() != null
							&& dtCargosUsuexter.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaCrea() + " :: "+ dtCargosUsuexterBk.getFechaCrea());
								}
							cambios = true;			
							dtCargosUsuexter.setFechaCrea(dtCargosUsuexterBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtCargosUsuexterBk.getFechaModif() != null
							&& dtCargosUsuexter.getFechaModif() != null) {
						if (!dtCargosUsuexterBk.getFechaModif().equals(
								dtCargosUsuexter.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaModif() + " :: "+ dtCargosUsuexterBk.getFechaModif());
								}
							cambios = true;
							dtCargosUsuexter.setFechaModif(dtCargosUsuexterBk.getFechaModif());
						}
					} else if (dtCargosUsuexterBk.getFechaModif() == null
							&& dtCargosUsuexter.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaModif() + " :: "+ dtCargosUsuexterBk.getFechaModif());
								}
							cambios = true;
							dtCargosUsuexter.setFechaModif(dtCargosUsuexterBk.getFechaModif());
						
					} else if (dtCargosUsuexterBk.getFechaModif() != null
							&& dtCargosUsuexter.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:FechaModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getFechaModif() + " :: "+ dtCargosUsuexterBk.getFechaModif());
								}
							cambios = true;			
							dtCargosUsuexter.setFechaModif(dtCargosUsuexterBk.getFechaModif());
					}
                                
				                                 
                                      if (dtCargosUsuexterBk.getIduserCrea() != null
							&& dtCargosUsuexter.getIduserCrea() != null) {
						if (!dtCargosUsuexterBk.getIduserCrea().equals(
								dtCargosUsuexter.getIduserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserCrea() + " :: "+ dtCargosUsuexterBk.getIduserCrea());
								}
							cambios = true;
							dtCargosUsuexter.setIduserCrea(dtCargosUsuexterBk.getIduserCrea());
						}
					} else if (dtCargosUsuexterBk.getIduserCrea() == null
							&& dtCargosUsuexter.getIduserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserCrea() + " :: "+ dtCargosUsuexterBk.getIduserCrea());
								}
							cambios = true;
							dtCargosUsuexter.setIduserCrea(dtCargosUsuexterBk.getIduserCrea());
						
					} else if (dtCargosUsuexterBk.getIduserCrea() != null
							&& dtCargosUsuexter.getIduserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserCrea"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserCrea() + " :: "+ dtCargosUsuexterBk.getIduserCrea());
								}
							cambios = true;			
							dtCargosUsuexter.setIduserCrea(dtCargosUsuexterBk.getIduserCrea());
					}
                                
				                                 
                                      if (dtCargosUsuexterBk.getIduserModif() != null
							&& dtCargosUsuexter.getIduserModif() != null) {
						if (!dtCargosUsuexterBk.getIduserModif().equals(
								dtCargosUsuexter.getIduserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserModif() + " :: "+ dtCargosUsuexterBk.getIduserModif());
								}
							cambios = true;
							dtCargosUsuexter.setIduserModif(dtCargosUsuexterBk.getIduserModif());
						}
					} else if (dtCargosUsuexterBk.getIduserModif() == null
							&& dtCargosUsuexter.getIduserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserModif() + " :: "+ dtCargosUsuexterBk.getIduserModif());
								}
							cambios = true;
							dtCargosUsuexter.setIduserModif(dtCargosUsuexterBk.getIduserModif());
						
					} else if (dtCargosUsuexterBk.getIduserModif() != null
							&& dtCargosUsuexter.getIduserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:IduserModif"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getIduserModif() + " :: "+ dtCargosUsuexterBk.getIduserModif());
								}
							cambios = true;			
							dtCargosUsuexter.setIduserModif(dtCargosUsuexterBk.getIduserModif());
					}
                                
				
				
				                                 
                                      if (dtCargosUsuexterBk.getEstado() != null
							&& dtCargosUsuexter.getEstado() != null) {
						if (!dtCargosUsuexterBk.getEstado().equals(
								dtCargosUsuexter.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Estado"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getEstado() + " :: "+ dtCargosUsuexterBk.getEstado());
								}
							cambios = true;
							dtCargosUsuexter.setEstado(dtCargosUsuexterBk.getEstado());
						}
					} else if (dtCargosUsuexterBk.getEstado() == null
							&& dtCargosUsuexter.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Estado"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getEstado() + " :: "+ dtCargosUsuexterBk.getEstado());
								}
							cambios = true;
							dtCargosUsuexter.setEstado(dtCargosUsuexterBk.getEstado());
						
					} else if (dtCargosUsuexterBk.getEstado() != null
							&& dtCargosUsuexter.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Estado"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getEstado() + " :: "+ dtCargosUsuexterBk.getEstado());
								}
							cambios = true;			
							dtCargosUsuexter.setEstado(dtCargosUsuexterBk.getEstado());
					}
                                
				                                 
                                      if (dtCargosUsuexterBk.getRtmaddress() != null
							&& dtCargosUsuexter.getRtmaddress() != null) {
						if (!dtCargosUsuexterBk.getRtmaddress().equals(
								dtCargosUsuexter.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddress"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddress() + " :: "+ dtCargosUsuexterBk.getRtmaddress());
								}
							cambios = true;
							dtCargosUsuexter.setRtmaddress(dtCargosUsuexterBk.getRtmaddress());
						}
					} else if (dtCargosUsuexterBk.getRtmaddress() == null
							&& dtCargosUsuexter.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddress"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddress() + " :: "+ dtCargosUsuexterBk.getRtmaddress());
								}
							cambios = true;
							dtCargosUsuexter.setRtmaddress(dtCargosUsuexterBk.getRtmaddress());
						
					} else if (dtCargosUsuexterBk.getRtmaddress() != null
							&& dtCargosUsuexter.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddress"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddress() + " :: "+ dtCargosUsuexterBk.getRtmaddress());
								}
							cambios = true;			
							dtCargosUsuexter.setRtmaddress(dtCargosUsuexterBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtCargosUsuexterBk.getRtmaddressrst() != null
							&& dtCargosUsuexter.getRtmaddressrst() != null) {
						if (!dtCargosUsuexterBk.getRtmaddressrst().equals(
								dtCargosUsuexter.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddressrst"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddressrst() + " :: "+ dtCargosUsuexterBk.getRtmaddressrst());
								}
							cambios = true;
							dtCargosUsuexter.setRtmaddressrst(dtCargosUsuexterBk.getRtmaddressrst());
						}
					} else if (dtCargosUsuexterBk.getRtmaddressrst() == null
							&& dtCargosUsuexter.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddressrst"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddressrst() + " :: "+ dtCargosUsuexterBk.getRtmaddressrst());
								}
							cambios = true;
							dtCargosUsuexter.setRtmaddressrst(dtCargosUsuexterBk.getRtmaddressrst());
						
					} else if (dtCargosUsuexterBk.getRtmaddressrst() != null
							&& dtCargosUsuexter.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtCargosUsuexter:Rtmaddressrst"+" :: "+dtCargosUsuexterBk.getIdCargoUsuexter().toString()+" :: "+ dtCargosUsuexter.getRtmaddressrst() + " :: "+ dtCargosUsuexterBk.getRtmaddressrst());
								}
							cambios = true;			
							dtCargosUsuexter.setRtmaddressrst(dtCargosUsuexterBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}