package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsMetaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsMetaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsMetaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsMetaData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsMetaBk> getMsMetaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsMetaBk> msMetaBksss = null;
		String key = MsMetaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msMetaBksss = (List<MsMetaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsMetaBk> msMetaBkssss = servicio.getAllMsMetaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msMetaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msMetaBksss = servicio.getAllMsMetaActivosCero(kyUsuarioMod);
			entrada.setLista(msMetaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msMetaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsMetaBk msMetaC){		
		List<MsMetaBk> msMetaBksss = null;
		String key = MsMetaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msMetaBksss = (List<MsMetaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsMetaBk> msMetaBkssss = servicio.getAllMsMetaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msMetaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msMetaBksss = servicio.getAllMsMetaActivosCero(kyUsuarioMod);
			entrada.setLista(msMetaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msMetaBksss.contains(msMetaC)) {
			msMetaBksss.add(msMetaC);
		} else {
			int itemIndex = msMetaBksss.indexOf(msMetaC);
			if (itemIndex != -1) {
				msMetaBksss.set(itemIndex, msMetaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsMetaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsMetaBk> msMetaBkssss = servicio.getAllMsMetaActivosCero(kyUsuarioMod);
    				entrada.setLista(msMetaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
