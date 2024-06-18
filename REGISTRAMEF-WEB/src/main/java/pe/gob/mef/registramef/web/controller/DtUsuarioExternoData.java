package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtUsuarioExternoBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtUsuarioExternoData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtUsuarioExternoData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtUsuarioExternoData() {
	}

	@SuppressWarnings("unchecked")
	public List<DtUsuarioExternoBk> getDtUsuarioExternoActivos(Servicio servicio, Long kyUsuarioMod){		
		List<DtUsuarioExternoBk> dtUsuarioExternoBksss = null;
		String key = DtUsuarioExternoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtUsuarioExternoBksss = (List<DtUsuarioExternoBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtUsuarioExternoBk> dtUsuarioExternoBkssss = servicio.getAllDtUsuarioExternoActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtUsuarioExternoBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtUsuarioExternoBksss = servicio.getAllDtUsuarioExternoActivosCero(kyUsuarioMod);
			entrada.setLista(dtUsuarioExternoBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtUsuarioExternoBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtUsuarioExternoBk dtUsuarioExternoC){		
		List<DtUsuarioExternoBk> dtUsuarioExternoBksss = null;
		String key = DtUsuarioExternoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtUsuarioExternoBksss = (List<DtUsuarioExternoBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtUsuarioExternoBk> dtUsuarioExternoBkssss = servicio.getAllDtUsuarioExternoActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtUsuarioExternoBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtUsuarioExternoBksss = servicio.getAllDtUsuarioExternoActivosCero(kyUsuarioMod);
			entrada.setLista(dtUsuarioExternoBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!dtUsuarioExternoBksss.contains(dtUsuarioExternoC)) {
			dtUsuarioExternoBksss.add(dtUsuarioExternoC);
		} else {
			int itemIndex = dtUsuarioExternoBksss.indexOf(dtUsuarioExternoC);
			if (itemIndex != -1) {
				dtUsuarioExternoBksss.set(itemIndex, dtUsuarioExternoC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = DtUsuarioExternoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtUsuarioExternoBk> dtUsuarioExternoBkssss = servicio.getAllDtUsuarioExternoActivosCero(kyUsuarioMod);
    				entrada.setLista(dtUsuarioExternoBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
