package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsUsuariosBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsUsuariosData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5241687233693781822L;

	private static final Logger log = Logger.getLogger(MsUsuariosData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsUsuariosData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsUsuariosBk> getMsUsuariosActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsUsuariosBk> msUsuariosBksss = null;
		String key = MsUsuariosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msUsuariosBksss = (List<MsUsuariosBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsUsuariosBk> msUsuariosBkssss = servicio.getAllMsUsuariosActivosCero(kyUsuarioMod);
		    				entrada.setLista(msUsuariosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msUsuariosBksss = servicio.getAllMsUsuariosActivosCero(kyUsuarioMod);
			entrada.setLista(msUsuariosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msUsuariosBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsUsuariosBk msUsuariosC){		
		List<MsUsuariosBk> msUsuariosBksss = null;
		String key = MsUsuariosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msUsuariosBksss = (List<MsUsuariosBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsUsuariosBk> msUsuariosBkssss = servicio.getAllMsUsuariosActivosCero(kyUsuarioMod);
		    				entrada.setLista(msUsuariosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msUsuariosBksss = servicio.getAllMsUsuariosActivosCero(kyUsuarioMod);
			entrada.setLista(msUsuariosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msUsuariosBksss.contains(msUsuariosC)) {
			msUsuariosBksss.add(msUsuariosC);
		} else {
			int itemIndex = msUsuariosBksss.indexOf(msUsuariosC);
			if (itemIndex != -1) {
				msUsuariosBksss.set(itemIndex, msUsuariosC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsUsuariosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsUsuariosBk> msUsuariosBkssss = servicio.getAllMsUsuariosActivosCero(kyUsuarioMod);
    				entrada.setLista(msUsuariosBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());                    
                } 
            }		 
        }.start();
		}
	}
}
