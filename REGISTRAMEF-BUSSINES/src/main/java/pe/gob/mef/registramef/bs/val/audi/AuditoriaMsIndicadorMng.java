package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.MsIndicador;
import pe.gob.mef.registramef.bs.transfer.bk.MsIndicadorBk;

/**
 * MS_INDICADOR SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS INDICADORES REGISTRADOS EN EL SISTEMA "INDICADORES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaMsIndicadorMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaMsIndicadorMng.class.getName());
	
	public static boolean auditarCambiosMsIndicador(MsIndicadorBk msIndicadorBk, MsIndicador msIndicador, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (msIndicadorBk.getDescripcion() != null
							&& msIndicador.getDescripcion() != null) {
						if (!msIndicadorBk.getDescripcion().equals(
								msIndicador.getDescripcion())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Descripcion"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getDescripcion() + " :: "+ msIndicadorBk.getDescripcion());
								}
							cambios = true;
							msIndicador.setDescripcion(msIndicadorBk.getDescripcion());
						}
					} else if (msIndicadorBk.getDescripcion() == null
							&& msIndicador.getDescripcion() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Descripcion"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getDescripcion() + " :: "+ msIndicadorBk.getDescripcion());
								}
							cambios = true;
							msIndicador.setDescripcion(msIndicadorBk.getDescripcion());
						
					} else if (msIndicadorBk.getDescripcion() != null
							&& msIndicador.getDescripcion() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Descripcion"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getDescripcion() + " :: "+ msIndicadorBk.getDescripcion());
								}
							cambios = true;			
							msIndicador.setDescripcion(msIndicadorBk.getDescripcion());
					}
				if (msIndicadorBk.getFormula() != null
							&& msIndicador.getFormula() != null) {
						if (!msIndicadorBk.getFormula().equals(
								msIndicador.getFormula())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Formula"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFormula() + " :: "+ msIndicadorBk.getFormula());
								}
							cambios = true;
							msIndicador.setFormula(msIndicadorBk.getFormula());
						}
					} else if (msIndicadorBk.getFormula() == null
							&& msIndicador.getFormula() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Formula"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFormula() + " :: "+ msIndicadorBk.getFormula());
								}
							cambios = true;
							msIndicador.setFormula(msIndicadorBk.getFormula());
						
					} else if (msIndicadorBk.getFormula() != null
							&& msIndicador.getFormula() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Formula"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFormula() + " :: "+ msIndicadorBk.getFormula());
								}
							cambios = true;			
							msIndicador.setFormula(msIndicadorBk.getFormula());
					}
				if (msIndicadorBk.getIdObjetvo() != null
							&& msIndicador.getIdObjetvo() != null) {
						if (!msIndicadorBk.getIdObjetvo().equals(
								msIndicador.getIdObjetvo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdObjetvo"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdObjetvo() + " :: "+ msIndicadorBk.getIdObjetvo());
								}
							cambios = true;
							msIndicador.setIdObjetvo(msIndicadorBk.getIdObjetvo());
						}
					} else if (msIndicadorBk.getIdObjetvo() == null
							&& msIndicador.getIdObjetvo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdObjetvo"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdObjetvo() + " :: "+ msIndicadorBk.getIdObjetvo());
								}
							cambios = true;
							msIndicador.setIdObjetvo(msIndicadorBk.getIdObjetvo());
						
					} else if (msIndicadorBk.getIdObjetvo() != null
							&& msIndicador.getIdObjetvo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdObjetvo"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdObjetvo() + " :: "+ msIndicadorBk.getIdObjetvo());
								}
							cambios = true;			
							msIndicador.setIdObjetvo(msIndicadorBk.getIdObjetvo());
					}
				if (msIndicadorBk.getIdNivlstrat() != null
							&& msIndicador.getIdNivlstrat() != null) {
						if (!msIndicadorBk.getIdNivlstrat().equals(
								msIndicador.getIdNivlstrat())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdNivlstrat"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdNivlstrat() + " :: "+ msIndicadorBk.getIdNivlstrat());
								}
							cambios = true;
							msIndicador.setIdNivlstrat(msIndicadorBk.getIdNivlstrat());
						}
					} else if (msIndicadorBk.getIdNivlstrat() == null
							&& msIndicador.getIdNivlstrat() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdNivlstrat"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdNivlstrat() + " :: "+ msIndicadorBk.getIdNivlstrat());
								}
							cambios = true;
							msIndicador.setIdNivlstrat(msIndicadorBk.getIdNivlstrat());
						
					} else if (msIndicadorBk.getIdNivlstrat() != null
							&& msIndicador.getIdNivlstrat() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdNivlstrat"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdNivlstrat() + " :: "+ msIndicadorBk.getIdNivlstrat());
								}
							cambios = true;			
							msIndicador.setIdNivlstrat(msIndicadorBk.getIdNivlstrat());
					}
				if (msIndicadorBk.getIdFactor() != null
							&& msIndicador.getIdFactor() != null) {
						if (!msIndicadorBk.getIdFactor().equals(
								msIndicador.getIdFactor())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFactor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFactor() + " :: "+ msIndicadorBk.getIdFactor());
								}
							cambios = true;
							msIndicador.setIdFactor(msIndicadorBk.getIdFactor());
						}
					} else if (msIndicadorBk.getIdFactor() == null
							&& msIndicador.getIdFactor() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFactor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFactor() + " :: "+ msIndicadorBk.getIdFactor());
								}
							cambios = true;
							msIndicador.setIdFactor(msIndicadorBk.getIdFactor());
						
					} else if (msIndicadorBk.getIdFactor() != null
							&& msIndicador.getIdFactor() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFactor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFactor() + " :: "+ msIndicadorBk.getIdFactor());
								}
							cambios = true;			
							msIndicador.setIdFactor(msIndicadorBk.getIdFactor());
					}
				if (msIndicadorBk.getIdFuenteinfor() != null
							&& msIndicador.getIdFuenteinfor() != null) {
						if (!msIndicadorBk.getIdFuenteinfor().equals(
								msIndicador.getIdFuenteinfor())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFuenteinfor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFuenteinfor() + " :: "+ msIndicadorBk.getIdFuenteinfor());
								}
							cambios = true;
							msIndicador.setIdFuenteinfor(msIndicadorBk.getIdFuenteinfor());
						}
					} else if (msIndicadorBk.getIdFuenteinfor() == null
							&& msIndicador.getIdFuenteinfor() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFuenteinfor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFuenteinfor() + " :: "+ msIndicadorBk.getIdFuenteinfor());
								}
							cambios = true;
							msIndicador.setIdFuenteinfor(msIndicadorBk.getIdFuenteinfor());
						
					} else if (msIndicadorBk.getIdFuenteinfor() != null
							&& msIndicador.getIdFuenteinfor() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdFuenteinfor"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdFuenteinfor() + " :: "+ msIndicadorBk.getIdFuenteinfor());
								}
							cambios = true;			
							msIndicador.setIdFuenteinfor(msIndicadorBk.getIdFuenteinfor());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaMsIndicador(MsIndicadorBk msIndicadorBk, MsIndicador msIndicador, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		
				
				                                 
                                      if (msIndicadorBk.getIdusserCrea() != null
							&& msIndicador.getIdusserCrea() != null) {
						if (!msIndicadorBk.getIdusserCrea().equals(
								msIndicador.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserCrea() + " :: "+ msIndicadorBk.getIdusserCrea());
								}
							cambios = true;
							msIndicador.setIdusserCrea(msIndicadorBk.getIdusserCrea());
						}
					} else if (msIndicadorBk.getIdusserCrea() == null
							&& msIndicador.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserCrea() + " :: "+ msIndicadorBk.getIdusserCrea());
								}
							cambios = true;
							msIndicador.setIdusserCrea(msIndicadorBk.getIdusserCrea());
						
					} else if (msIndicadorBk.getIdusserCrea() != null
							&& msIndicador.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserCrea() + " :: "+ msIndicadorBk.getIdusserCrea());
								}
							cambios = true;			
							msIndicador.setIdusserCrea(msIndicadorBk.getIdusserCrea());
					}
                                
				                                 
                                      if (msIndicadorBk.getIdusserModif() != null
							&& msIndicador.getIdusserModif() != null) {
						if (!msIndicadorBk.getIdusserModif().equals(
								msIndicador.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserModif() + " :: "+ msIndicadorBk.getIdusserModif());
								}
							cambios = true;
							msIndicador.setIdusserModif(msIndicadorBk.getIdusserModif());
						}
					} else if (msIndicadorBk.getIdusserModif() == null
							&& msIndicador.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserModif() + " :: "+ msIndicadorBk.getIdusserModif());
								}
							cambios = true;
							msIndicador.setIdusserModif(msIndicadorBk.getIdusserModif());
						
					} else if (msIndicadorBk.getIdusserModif() != null
							&& msIndicador.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:IdusserModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getIdusserModif() + " :: "+ msIndicadorBk.getIdusserModif());
								}
							cambios = true;			
							msIndicador.setIdusserModif(msIndicadorBk.getIdusserModif());
					}
                                
				                                 
                                      if (msIndicadorBk.getFechaCrea() != null
							&& msIndicador.getFechaCrea() != null) {
						if (!msIndicadorBk.getFechaCrea().equals(
								msIndicador.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaCrea() + " :: "+ msIndicadorBk.getFechaCrea());
								}
							cambios = true;
							msIndicador.setFechaCrea(msIndicadorBk.getFechaCrea());
						}
					} else if (msIndicadorBk.getFechaCrea() == null
							&& msIndicador.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaCrea() + " :: "+ msIndicadorBk.getFechaCrea());
								}
							cambios = true;
							msIndicador.setFechaCrea(msIndicadorBk.getFechaCrea());
						
					} else if (msIndicadorBk.getFechaCrea() != null
							&& msIndicador.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaCrea"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaCrea() + " :: "+ msIndicadorBk.getFechaCrea());
								}
							cambios = true;			
							msIndicador.setFechaCrea(msIndicadorBk.getFechaCrea());
					}
                                
				                                 
                                      if (msIndicadorBk.getFechaModif() != null
							&& msIndicador.getFechaModif() != null) {
						if (!msIndicadorBk.getFechaModif().equals(
								msIndicador.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaModif() + " :: "+ msIndicadorBk.getFechaModif());
								}
							cambios = true;
							msIndicador.setFechaModif(msIndicadorBk.getFechaModif());
						}
					} else if (msIndicadorBk.getFechaModif() == null
							&& msIndicador.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaModif() + " :: "+ msIndicadorBk.getFechaModif());
								}
							cambios = true;
							msIndicador.setFechaModif(msIndicadorBk.getFechaModif());
						
					} else if (msIndicadorBk.getFechaModif() != null
							&& msIndicador.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:FechaModif"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getFechaModif() + " :: "+ msIndicadorBk.getFechaModif());
								}
							cambios = true;			
							msIndicador.setFechaModif(msIndicadorBk.getFechaModif());
					}
                                
				
				
				
				
				                                 
                                      if (msIndicadorBk.getEstado() != null
							&& msIndicador.getEstado() != null) {
						if (!msIndicadorBk.getEstado().equals(
								msIndicador.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Estado"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getEstado() + " :: "+ msIndicadorBk.getEstado());
								}
							cambios = true;
							msIndicador.setEstado(msIndicadorBk.getEstado());
						}
					} else if (msIndicadorBk.getEstado() == null
							&& msIndicador.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Estado"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getEstado() + " :: "+ msIndicadorBk.getEstado());
								}
							cambios = true;
							msIndicador.setEstado(msIndicadorBk.getEstado());
						
					} else if (msIndicadorBk.getEstado() != null
							&& msIndicador.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Estado"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getEstado() + " :: "+ msIndicadorBk.getEstado());
								}
							cambios = true;			
							msIndicador.setEstado(msIndicadorBk.getEstado());
					}
                                
				                                 
                                      if (msIndicadorBk.getRtmaddress() != null
							&& msIndicador.getRtmaddress() != null) {
						if (!msIndicadorBk.getRtmaddress().equals(
								msIndicador.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddress"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddress() + " :: "+ msIndicadorBk.getRtmaddress());
								}
							cambios = true;
							msIndicador.setRtmaddress(msIndicadorBk.getRtmaddress());
						}
					} else if (msIndicadorBk.getRtmaddress() == null
							&& msIndicador.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddress"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddress() + " :: "+ msIndicadorBk.getRtmaddress());
								}
							cambios = true;
							msIndicador.setRtmaddress(msIndicadorBk.getRtmaddress());
						
					} else if (msIndicadorBk.getRtmaddress() != null
							&& msIndicador.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddress"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddress() + " :: "+ msIndicadorBk.getRtmaddress());
								}
							cambios = true;			
							msIndicador.setRtmaddress(msIndicadorBk.getRtmaddress());
					}
                                
				                                 
                                      if (msIndicadorBk.getRtmaddressrst() != null
							&& msIndicador.getRtmaddressrst() != null) {
						if (!msIndicadorBk.getRtmaddressrst().equals(
								msIndicador.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddressrst"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddressrst() + " :: "+ msIndicadorBk.getRtmaddressrst());
								}
							cambios = true;
							msIndicador.setRtmaddressrst(msIndicadorBk.getRtmaddressrst());
						}
					} else if (msIndicadorBk.getRtmaddressrst() == null
							&& msIndicador.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddressrst"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddressrst() + " :: "+ msIndicadorBk.getRtmaddressrst());
								}
							cambios = true;
							msIndicador.setRtmaddressrst(msIndicadorBk.getRtmaddressrst());
						
					} else if (msIndicadorBk.getRtmaddressrst() != null
							&& msIndicador.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"msIndicador:Rtmaddressrst"+" :: "+msIndicadorBk.getIdIndicador().toString()+" :: "+ msIndicador.getRtmaddressrst() + " :: "+ msIndicadorBk.getRtmaddressrst());
								}
							cambios = true;			
							msIndicador.setRtmaddressrst(msIndicadorBk.getRtmaddressrst());
					}
                                
				
			
			return cambios;
	}
}