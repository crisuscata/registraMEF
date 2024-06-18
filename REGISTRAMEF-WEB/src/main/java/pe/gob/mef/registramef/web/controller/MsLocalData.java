package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsLocalBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsLocalData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsLocalData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsLocalData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsLocalBk> getMsLocalActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsLocalBk> msLocalBksss = null;
		String key = MsLocalBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msLocalBksss = (List<MsLocalBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsLocalBk> msLocalBkssss = servicio.getAllMsLocalActivosCero(kyUsuarioMod);
		    				entrada.setLista(msLocalBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msLocalBksss = servicio.getAllMsLocalActivosCero(kyUsuarioMod);
			entrada.setLista(msLocalBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msLocalBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsLocalBk msLocalC){		
		List<MsLocalBk> msLocalBksss = null;
		String key = MsLocalBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msLocalBksss = (List<MsLocalBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsLocalBk> msLocalBkssss = servicio.getAllMsLocalActivosCero(kyUsuarioMod);
		    				entrada.setLista(msLocalBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msLocalBksss = servicio.getAllMsLocalActivosCero(kyUsuarioMod);
			entrada.setLista(msLocalBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msLocalBksss.contains(msLocalC)) {
			msLocalBksss.add(msLocalC);
		} else {
			int itemIndex = msLocalBksss.indexOf(msLocalC);
			if (itemIndex != -1) {
				msLocalBksss.set(itemIndex, msLocalC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsLocalBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsLocalBk> msLocalBkssss = servicio.getAllMsLocalActivosCero(kyUsuarioMod);
    				entrada.setLista(msLocalBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
