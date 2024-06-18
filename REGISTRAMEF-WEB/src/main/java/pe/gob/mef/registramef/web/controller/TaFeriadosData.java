package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.TaFeriadosBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class TaFeriadosData implements Serializable{
	
	private static final Logger log = Logger.getLogger(TaFeriadosData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public TaFeriadosData() {
	}

	@SuppressWarnings("unchecked")
	public List<TaFeriadosBk> getTaFeriadosActivos(Servicio servicio, Long kyUsuarioMod){		
		List<TaFeriadosBk> taFeriadosBksss = null;
		String key = TaFeriadosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			taFeriadosBksss = (List<TaFeriadosBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<TaFeriadosBk> taFeriadosBkssss = servicio.getAllTaFeriadosActivosCero(kyUsuarioMod);
		    				entrada.setLista(taFeriadosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			taFeriadosBksss = servicio.getAllTaFeriadosActivosCero(kyUsuarioMod);
			entrada.setLista(taFeriadosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return taFeriadosBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, TaFeriadosBk taFeriadosC){		
		List<TaFeriadosBk> taFeriadosBksss = null;
		String key = TaFeriadosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			taFeriadosBksss = (List<TaFeriadosBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<TaFeriadosBk> taFeriadosBkssss = servicio.getAllTaFeriadosActivosCero(kyUsuarioMod);
		    				entrada.setLista(taFeriadosBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			taFeriadosBksss = servicio.getAllTaFeriadosActivosCero(kyUsuarioMod);
			entrada.setLista(taFeriadosBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!taFeriadosBksss.contains(taFeriadosC)) {
			taFeriadosBksss.add(taFeriadosC);
		} else {
			int itemIndex = taFeriadosBksss.indexOf(taFeriadosC);
			if (itemIndex != -1) {
				taFeriadosBksss.set(itemIndex, taFeriadosC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = TaFeriadosBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<TaFeriadosBk> taFeriadosBkssss = servicio.getAllTaFeriadosActivosCero(kyUsuarioMod);
    				entrada.setLista(taFeriadosBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
