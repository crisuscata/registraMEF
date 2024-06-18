package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsSedesBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsSedesData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsSedesData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsSedesData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsSedesBk> getMsSedesActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsSedesBk> msSedesBksss = null;
		String key = MsSedesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSedesBksss = (List<MsSedesBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSedesBk> msSedesBkssss = servicio.getAllMsSedesActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSedesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSedesBksss = servicio.getAllMsSedesActivosCero(kyUsuarioMod);
			entrada.setLista(msSedesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msSedesBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsSedesBk msSedesC){		
		List<MsSedesBk> msSedesBksss = null;
		String key = MsSedesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSedesBksss = (List<MsSedesBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSedesBk> msSedesBkssss = servicio.getAllMsSedesActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSedesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSedesBksss = servicio.getAllMsSedesActivosCero(kyUsuarioMod);
			entrada.setLista(msSedesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msSedesBksss.contains(msSedesC)) {
			msSedesBksss.add(msSedesC);
		} else {
			int itemIndex = msSedesBksss.indexOf(msSedesC);
			if (itemIndex != -1) {
				msSedesBksss.set(itemIndex, msSedesC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsSedesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsSedesBk> msSedesBkssss = servicio.getAllMsSedesActivosCero(kyUsuarioMod);
    				entrada.setLista(msSedesBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
