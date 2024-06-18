package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsIndicadorBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsIndicadorData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsIndicadorData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsIndicadorData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsIndicadorBk> getMsIndicadorActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsIndicadorBk> msIndicadorBksss = null;
		String key = MsIndicadorBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msIndicadorBksss = (List<MsIndicadorBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsIndicadorBk> msIndicadorBkssss = servicio.getAllMsIndicadorActivosCero(kyUsuarioMod);
		    				entrada.setLista(msIndicadorBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msIndicadorBksss = servicio.getAllMsIndicadorActivosCero(kyUsuarioMod);
			entrada.setLista(msIndicadorBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msIndicadorBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsIndicadorBk msIndicadorC){		
		List<MsIndicadorBk> msIndicadorBksss = null;
		String key = MsIndicadorBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msIndicadorBksss = (List<MsIndicadorBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsIndicadorBk> msIndicadorBkssss = servicio.getAllMsIndicadorActivosCero(kyUsuarioMod);
		    				entrada.setLista(msIndicadorBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msIndicadorBksss = servicio.getAllMsIndicadorActivosCero(kyUsuarioMod);
			entrada.setLista(msIndicadorBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msIndicadorBksss.contains(msIndicadorC)) {
			msIndicadorBksss.add(msIndicadorC);
		} else {
			int itemIndex = msIndicadorBksss.indexOf(msIndicadorC);
			if (itemIndex != -1) {
				msIndicadorBksss.set(itemIndex, msIndicadorC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsIndicadorBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsIndicadorBk> msIndicadorBkssss = servicio.getAllMsIndicadorActivosCero(kyUsuarioMod);
    				entrada.setLista(msIndicadorBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
