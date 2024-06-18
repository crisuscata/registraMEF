package pe.gob.mef.registramef.bs.val.audi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.domain.DtAnexo;
import pe.gob.mef.registramef.bs.transfer.bk.DtAnexoBk;

/**
 * DT_ANEXO SERVICIO AUDITORIA Y CAMBIO: ALMACENA LOS DOCUMENTOS ANEXADOS EN EL SISTEMA "ANEXO"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 18:48
 * 
 *          /----------Nombre------------/-----fecha--------/---------Motivo-------/                                                       
 *          /Carlos Aguilar Chamochumbi /18/12/2023 18:48  / Creación de la clase /
 * 
 */
public class AuditoriaDtAnexoMng implements Serializable{

	public static final Logger log = Logger.getLogger(AuditoriaDtAnexoMng.class.getName());
	
	public static boolean auditarCambiosDtAnexo(DtAnexoBk dtAnexoBk, DtAnexo dtAnexo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		if (dtAnexoBk.getFilename() != null
							&& dtAnexo.getFilename() != null) {
						if (!dtAnexoBk.getFilename().equals(
								dtAnexo.getFilename())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filename"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilename() + " :: "+ dtAnexoBk.getFilename());
								}
							cambios = true;
							dtAnexo.setFilename(dtAnexoBk.getFilename());
						}
					} else if (dtAnexoBk.getFilename() == null
							&& dtAnexo.getFilename() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filename"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilename() + " :: "+ dtAnexoBk.getFilename());
								}
							cambios = true;
							dtAnexo.setFilename(dtAnexoBk.getFilename());
						
					} else if (dtAnexoBk.getFilename() != null
							&& dtAnexo.getFilename() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filename"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilename() + " :: "+ dtAnexoBk.getFilename());
								}
							cambios = true;			
							dtAnexo.setFilename(dtAnexoBk.getFilename());
					}
				if (dtAnexoBk.getFilenameoriginal() != null
							&& dtAnexo.getFilenameoriginal() != null) {
						if (!dtAnexoBk.getFilenameoriginal().equals(
								dtAnexo.getFilenameoriginal())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filenameoriginal"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilenameoriginal() + " :: "+ dtAnexoBk.getFilenameoriginal());
								}
							cambios = true;
							dtAnexo.setFilenameoriginal(dtAnexoBk.getFilenameoriginal());
						}
					} else if (dtAnexoBk.getFilenameoriginal() == null
							&& dtAnexo.getFilenameoriginal() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filenameoriginal"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilenameoriginal() + " :: "+ dtAnexoBk.getFilenameoriginal());
								}
							cambios = true;
							dtAnexo.setFilenameoriginal(dtAnexoBk.getFilenameoriginal());
						
					} else if (dtAnexoBk.getFilenameoriginal() != null
							&& dtAnexo.getFilenameoriginal() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Filenameoriginal"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFilenameoriginal() + " :: "+ dtAnexoBk.getFilenameoriginal());
								}
							cambios = true;			
							dtAnexo.setFilenameoriginal(dtAnexoBk.getFilenameoriginal());
					}
				if (dtAnexoBk.getIdTiposervicio() != null
							&& dtAnexo.getIdTiposervicio() != null) {
						if (!dtAnexoBk.getIdTiposervicio().equals(
								dtAnexo.getIdTiposervicio())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdTiposervicio"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdTiposervicio() + " :: "+ dtAnexoBk.getIdTiposervicio());
								}
							cambios = true;
							dtAnexo.setIdTiposervicio(dtAnexoBk.getIdTiposervicio());
						}
					} else if (dtAnexoBk.getIdTiposervicio() == null
							&& dtAnexo.getIdTiposervicio() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdTiposervicio"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdTiposervicio() + " :: "+ dtAnexoBk.getIdTiposervicio());
								}
							cambios = true;
							dtAnexo.setIdTiposervicio(dtAnexoBk.getIdTiposervicio());
						
					} else if (dtAnexoBk.getIdTiposervicio() != null
							&& dtAnexo.getIdTiposervicio() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdTiposervicio"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdTiposervicio() + " :: "+ dtAnexoBk.getIdTiposervicio());
								}
							cambios = true;			
							dtAnexo.setIdTiposervicio(dtAnexoBk.getIdTiposervicio());
					}
				if (dtAnexoBk.getTipoAnexo() != null
							&& dtAnexo.getTipoAnexo() != null) {
						if (!dtAnexoBk.getTipoAnexo().equals(
								dtAnexo.getTipoAnexo())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:TipoAnexo"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getTipoAnexo() + " :: "+ dtAnexoBk.getTipoAnexo());
								}
							cambios = true;
							dtAnexo.setTipoAnexo(dtAnexoBk.getTipoAnexo());
						}
					} else if (dtAnexoBk.getTipoAnexo() == null
							&& dtAnexo.getTipoAnexo() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:TipoAnexo"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getTipoAnexo() + " :: "+ dtAnexoBk.getTipoAnexo());
								}
							cambios = true;
							dtAnexo.setTipoAnexo(dtAnexoBk.getTipoAnexo());
						
					} else if (dtAnexoBk.getTipoAnexo() != null
							&& dtAnexo.getTipoAnexo() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:TipoAnexo"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getTipoAnexo() + " :: "+ dtAnexoBk.getTipoAnexo());
								}
							cambios = true;			
							dtAnexo.setTipoAnexo(dtAnexoBk.getTipoAnexo());
					}
				if (dtAnexoBk.getIdmaestro() != null
							&& dtAnexo.getIdmaestro() != null) {
						if (!dtAnexoBk.getIdmaestro().equals(
								dtAnexo.getIdmaestro())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Idmaestro"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdmaestro() + " :: "+ dtAnexoBk.getIdmaestro());
								}
							cambios = true;
							dtAnexo.setIdmaestro(dtAnexoBk.getIdmaestro());
						}
					} else if (dtAnexoBk.getIdmaestro() == null
							&& dtAnexo.getIdmaestro() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Idmaestro"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdmaestro() + " :: "+ dtAnexoBk.getIdmaestro());
								}
							cambios = true;
							dtAnexo.setIdmaestro(dtAnexoBk.getIdmaestro());
						
					} else if (dtAnexoBk.getIdmaestro() != null
							&& dtAnexo.getIdmaestro() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Idmaestro"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdmaestro() + " :: "+ dtAnexoBk.getIdmaestro());
								}
							cambios = true;			
							dtAnexo.setIdmaestro(dtAnexoBk.getIdmaestro());
					}
				if (dtAnexoBk.getFlagMaterialCapa() != null
							&& dtAnexo.getFlagMaterialCapa() != null) {
						if (!dtAnexoBk.getFlagMaterialCapa().equals(
								dtAnexo.getFlagMaterialCapa())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FlagMaterialCapa"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFlagMaterialCapa() + " :: "+ dtAnexoBk.getFlagMaterialCapa());
								}
							cambios = true;
							dtAnexo.setFlagMaterialCapa(dtAnexoBk.getFlagMaterialCapa());
						}
					} else if (dtAnexoBk.getFlagMaterialCapa() == null
							&& dtAnexo.getFlagMaterialCapa() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FlagMaterialCapa"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFlagMaterialCapa() + " :: "+ dtAnexoBk.getFlagMaterialCapa());
								}
							cambios = true;
							dtAnexo.setFlagMaterialCapa(dtAnexoBk.getFlagMaterialCapa());
						
					} else if (dtAnexoBk.getFlagMaterialCapa() != null
							&& dtAnexo.getFlagMaterialCapa() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FlagMaterialCapa"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFlagMaterialCapa() + " :: "+ dtAnexoBk.getFlagMaterialCapa());
								}
							cambios = true;			
							dtAnexo.setFlagMaterialCapa(dtAnexoBk.getFlagMaterialCapa());
					}
				
			
			return cambios;
	}
	
        public static boolean cambiosEnAuditoriaDtAnexo(DtAnexoBk dtAnexoBk, DtAnexo dtAnexo, 
	Long iduser, 
	String user, 
	String rmtaddress, 
	int nivel 
	)
	{
		boolean cambios = false;
		
		                                 
                                      if (dtAnexoBk.getIdusserCrea() != null
							&& dtAnexo.getIdusserCrea() != null) {
						if (!dtAnexoBk.getIdusserCrea().equals(
								dtAnexo.getIdusserCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserCrea() + " :: "+ dtAnexoBk.getIdusserCrea());
								}
							cambios = true;
							dtAnexo.setIdusserCrea(dtAnexoBk.getIdusserCrea());
						}
					} else if (dtAnexoBk.getIdusserCrea() == null
							&& dtAnexo.getIdusserCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserCrea() + " :: "+ dtAnexoBk.getIdusserCrea());
								}
							cambios = true;
							dtAnexo.setIdusserCrea(dtAnexoBk.getIdusserCrea());
						
					} else if (dtAnexoBk.getIdusserCrea() != null
							&& dtAnexo.getIdusserCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserCrea() + " :: "+ dtAnexoBk.getIdusserCrea());
								}
							cambios = true;			
							dtAnexo.setIdusserCrea(dtAnexoBk.getIdusserCrea());
					}
                                
				                                 
                                      if (dtAnexoBk.getIdusserModif() != null
							&& dtAnexo.getIdusserModif() != null) {
						if (!dtAnexoBk.getIdusserModif().equals(
								dtAnexo.getIdusserModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserModif() + " :: "+ dtAnexoBk.getIdusserModif());
								}
							cambios = true;
							dtAnexo.setIdusserModif(dtAnexoBk.getIdusserModif());
						}
					} else if (dtAnexoBk.getIdusserModif() == null
							&& dtAnexo.getIdusserModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserModif() + " :: "+ dtAnexoBk.getIdusserModif());
								}
							cambios = true;
							dtAnexo.setIdusserModif(dtAnexoBk.getIdusserModif());
						
					} else if (dtAnexoBk.getIdusserModif() != null
							&& dtAnexo.getIdusserModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:IdusserModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getIdusserModif() + " :: "+ dtAnexoBk.getIdusserModif());
								}
							cambios = true;			
							dtAnexo.setIdusserModif(dtAnexoBk.getIdusserModif());
					}
                                
				                                 
                                      if (dtAnexoBk.getFechaCrea() != null
							&& dtAnexo.getFechaCrea() != null) {
						if (!dtAnexoBk.getFechaCrea().equals(
								dtAnexo.getFechaCrea())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaCrea() + " :: "+ dtAnexoBk.getFechaCrea());
								}
							cambios = true;
							dtAnexo.setFechaCrea(dtAnexoBk.getFechaCrea());
						}
					} else if (dtAnexoBk.getFechaCrea() == null
							&& dtAnexo.getFechaCrea() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaCrea() + " :: "+ dtAnexoBk.getFechaCrea());
								}
							cambios = true;
							dtAnexo.setFechaCrea(dtAnexoBk.getFechaCrea());
						
					} else if (dtAnexoBk.getFechaCrea() != null
							&& dtAnexo.getFechaCrea() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaCrea"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaCrea() + " :: "+ dtAnexoBk.getFechaCrea());
								}
							cambios = true;			
							dtAnexo.setFechaCrea(dtAnexoBk.getFechaCrea());
					}
                                
				                                 
                                      if (dtAnexoBk.getFechaModif() != null
							&& dtAnexo.getFechaModif() != null) {
						if (!dtAnexoBk.getFechaModif().equals(
								dtAnexo.getFechaModif())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaModif() + " :: "+ dtAnexoBk.getFechaModif());
								}
							cambios = true;
							dtAnexo.setFechaModif(dtAnexoBk.getFechaModif());
						}
					} else if (dtAnexoBk.getFechaModif() == null
							&& dtAnexo.getFechaModif() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaModif() + " :: "+ dtAnexoBk.getFechaModif());
								}
							cambios = true;
							dtAnexo.setFechaModif(dtAnexoBk.getFechaModif());
						
					} else if (dtAnexoBk.getFechaModif() != null
							&& dtAnexo.getFechaModif() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:FechaModif"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getFechaModif() + " :: "+ dtAnexoBk.getFechaModif());
								}
							cambios = true;			
							dtAnexo.setFechaModif(dtAnexoBk.getFechaModif());
					}
                                
				
				
				                                 
                                      if (dtAnexoBk.getEstado() != null
							&& dtAnexo.getEstado() != null) {
						if (!dtAnexoBk.getEstado().equals(
								dtAnexo.getEstado())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Estado"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getEstado() + " :: "+ dtAnexoBk.getEstado());
								}
							cambios = true;
							dtAnexo.setEstado(dtAnexoBk.getEstado());
						}
					} else if (dtAnexoBk.getEstado() == null
							&& dtAnexo.getEstado() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Estado"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getEstado() + " :: "+ dtAnexoBk.getEstado());
								}
							cambios = true;
							dtAnexo.setEstado(dtAnexoBk.getEstado());
						
					} else if (dtAnexoBk.getEstado() != null
							&& dtAnexo.getEstado() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Estado"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getEstado() + " :: "+ dtAnexoBk.getEstado());
								}
							cambios = true;			
							dtAnexo.setEstado(dtAnexoBk.getEstado());
					}
                                
				
				
				
				                                 
                                      if (dtAnexoBk.getRtmaddress() != null
							&& dtAnexo.getRtmaddress() != null) {
						if (!dtAnexoBk.getRtmaddress().equals(
								dtAnexo.getRtmaddress())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddress"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddress() + " :: "+ dtAnexoBk.getRtmaddress());
								}
							cambios = true;
							dtAnexo.setRtmaddress(dtAnexoBk.getRtmaddress());
						}
					} else if (dtAnexoBk.getRtmaddress() == null
							&& dtAnexo.getRtmaddress() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddress"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddress() + " :: "+ dtAnexoBk.getRtmaddress());
								}
							cambios = true;
							dtAnexo.setRtmaddress(dtAnexoBk.getRtmaddress());
						
					} else if (dtAnexoBk.getRtmaddress() != null
							&& dtAnexo.getRtmaddress() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddress"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddress() + " :: "+ dtAnexoBk.getRtmaddress());
								}
							cambios = true;			
							dtAnexo.setRtmaddress(dtAnexoBk.getRtmaddress());
					}
                                
				                                 
                                      if (dtAnexoBk.getRtmaddressrst() != null
							&& dtAnexo.getRtmaddressrst() != null) {
						if (!dtAnexoBk.getRtmaddressrst().equals(
								dtAnexo.getRtmaddressrst())) {						
								if(nivel>0){
								log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddressrst"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddressrst() + " :: "+ dtAnexoBk.getRtmaddressrst());
								}
							cambios = true;
							dtAnexo.setRtmaddressrst(dtAnexoBk.getRtmaddressrst());
						}
					} else if (dtAnexoBk.getRtmaddressrst() == null
							&& dtAnexo.getRtmaddressrst() != null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddressrst"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddressrst() + " :: "+ dtAnexoBk.getRtmaddressrst());
								}
							cambios = true;
							dtAnexo.setRtmaddressrst(dtAnexoBk.getRtmaddressrst());
						
					} else if (dtAnexoBk.getRtmaddressrst() != null
							&& dtAnexo.getRtmaddressrst() == null) {						
							if(nivel>0){
							log.log(Level.INFO,"CAMBIO :: "+ iduser + " :: "+ user + " :: "+ rmtaddress+" :: "+"dtAnexo:Rtmaddressrst"+" :: "+dtAnexoBk.getIdAnexo().toString()+" :: "+ dtAnexo.getRtmaddressrst() + " :: "+ dtAnexoBk.getRtmaddressrst());
								}
							cambios = true;			
							dtAnexo.setRtmaddressrst(dtAnexoBk.getRtmaddressrst());
					}
                                
				
				
			
			return cambios;
	}
}