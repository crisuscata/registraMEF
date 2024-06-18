package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsSubtemaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsSubtemaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsSubtemaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsSubtemaData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsSubtemaBk> getMsSubtemaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsSubtemaBk> msSubtemaBksss = null;
		String key = MsSubtemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSubtemaBksss = (List<MsSubtemaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSubtemaBk> msSubtemaBkssss = servicio.getAllMsSubtemaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSubtemaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSubtemaBksss = servicio.getAllMsSubtemaActivosCero(kyUsuarioMod);
			entrada.setLista(msSubtemaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msSubtemaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsSubtemaBk msSubtemaC){		
		List<MsSubtemaBk> msSubtemaBksss = null;
		String key = MsSubtemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSubtemaBksss = (List<MsSubtemaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSubtemaBk> msSubtemaBkssss = servicio.getAllMsSubtemaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSubtemaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSubtemaBksss = servicio.getAllMsSubtemaActivosCero(kyUsuarioMod);
			entrada.setLista(msSubtemaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msSubtemaBksss.contains(msSubtemaC)) {
			msSubtemaBksss.add(msSubtemaC);
		} else {
			int itemIndex = msSubtemaBksss.indexOf(msSubtemaC);
			if (itemIndex != -1) {
				msSubtemaBksss.set(itemIndex, msSubtemaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsSubtemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsSubtemaBk> msSubtemaBkssss = servicio.getAllMsSubtemaActivosCero(kyUsuarioMod);
    				entrada.setLista(msSubtemaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
