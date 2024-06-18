package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.PrtParametrosBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class PrtParametrosData implements Serializable{
	
	private static final Logger log = Logger.getLogger(PrtParametrosData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public PrtParametrosData() {
	}

	@SuppressWarnings("unchecked")
	public List<PrtParametrosBk> getPrtParametrosActivos(Servicio servicio, Long kyUsuarioMod){		
		List<PrtParametrosBk> prtParametrosBksss = null;
		String key = PrtParametrosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			prtParametrosBksss = (List<PrtParametrosBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<PrtParametrosBk> prtParametrosBkssss = servicio.getAllPrtParametrosActivosCero(kyUsuarioMod);
		    				entrada.setLista(prtParametrosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			prtParametrosBksss = servicio.getAllPrtParametrosActivosCero(kyUsuarioMod);
			entrada.setLista(prtParametrosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return prtParametrosBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, PrtParametrosBk prtParametrosC){		
		List<PrtParametrosBk> prtParametrosBksss = null;
		String key = PrtParametrosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			prtParametrosBksss = (List<PrtParametrosBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<PrtParametrosBk> prtParametrosBkssss = servicio.getAllPrtParametrosActivosCero(kyUsuarioMod);
		    				entrada.setLista(prtParametrosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			prtParametrosBksss = servicio.getAllPrtParametrosActivosCero(kyUsuarioMod);
			entrada.setLista(prtParametrosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!prtParametrosBksss.contains(prtParametrosC)) {
			prtParametrosBksss.add(prtParametrosC);
		} else {
			int itemIndex = prtParametrosBksss.indexOf(prtParametrosC);
			if (itemIndex != -1) {
				prtParametrosBksss.set(itemIndex, prtParametrosC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = PrtParametrosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<PrtParametrosBk> prtParametrosBkssss = servicio.getAllPrtParametrosActivosCero(kyUsuarioMod);
    				entrada.setLista(prtParametrosBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
