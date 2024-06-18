package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsTemaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsTemaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsTemaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsTemaData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsTemaBk> getMsTemaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsTemaBk> msTemaBksss = null;
		String key = MsTemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msTemaBksss = (List<MsTemaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsTemaBk> msTemaBkssss = servicio.getAllMsTemaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msTemaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msTemaBksss = servicio.getAllMsTemaActivosCero(kyUsuarioMod);
			entrada.setLista(msTemaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msTemaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsTemaBk msTemaC){		
		List<MsTemaBk> msTemaBksss = null;
		String key = MsTemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msTemaBksss = (List<MsTemaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsTemaBk> msTemaBkssss = servicio.getAllMsTemaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msTemaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msTemaBksss = servicio.getAllMsTemaActivosCero(kyUsuarioMod);
			entrada.setLista(msTemaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msTemaBksss.contains(msTemaC)) {
			msTemaBksss.add(msTemaC);
		} else {
			int itemIndex = msTemaBksss.indexOf(msTemaC);
			if (itemIndex != -1) {
				msTemaBksss.set(itemIndex, msTemaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsTemaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsTemaBk> msTemaBkssss = servicio.getAllMsTemaActivosCero(kyUsuarioMod);
    				entrada.setLista(msTemaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
