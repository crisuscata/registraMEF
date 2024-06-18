package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsProyectoInversionBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsProyectoInversionData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsProyectoInversionData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsProyectoInversionData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsProyectoInversionBk> getMsProyectoInversionActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsProyectoInversionBk> msProyectoInversionBksss = null;
		String key = MsProyectoInversionBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msProyectoInversionBksss = (List<MsProyectoInversionBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsProyectoInversionBk> msProyectoInversionBkssss = servicio.getAllMsProyectoInversionActivosCero(kyUsuarioMod);
		    				entrada.setLista(msProyectoInversionBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msProyectoInversionBksss = servicio.getAllMsProyectoInversionActivosCero(kyUsuarioMod);
			entrada.setLista(msProyectoInversionBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msProyectoInversionBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsProyectoInversionBk msProyectoInversionC){		
		List<MsProyectoInversionBk> msProyectoInversionBksss = null;
		String key = MsProyectoInversionBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msProyectoInversionBksss = (List<MsProyectoInversionBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsProyectoInversionBk> msProyectoInversionBkssss = servicio.getAllMsProyectoInversionActivosCero(kyUsuarioMod);
		    				entrada.setLista(msProyectoInversionBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msProyectoInversionBksss = servicio.getAllMsProyectoInversionActivosCero(kyUsuarioMod);
			entrada.setLista(msProyectoInversionBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msProyectoInversionBksss.contains(msProyectoInversionC)) {
			msProyectoInversionBksss.add(msProyectoInversionC);
		} else {
			int itemIndex = msProyectoInversionBksss.indexOf(msProyectoInversionC);
			if (itemIndex != -1) {
				msProyectoInversionBksss.set(itemIndex, msProyectoInversionC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsProyectoInversionBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsProyectoInversionBk> msProyectoInversionBkssss = servicio.getAllMsProyectoInversionActivosCero(kyUsuarioMod);
    				entrada.setLista(msProyectoInversionBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
