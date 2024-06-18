package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtEntidadesBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtEntidadesData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtEntidadesData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtEntidadesData() {
	}

	@SuppressWarnings("unchecked")
	public List<DtEntidadesBk> getDtEntidadesActivos(Servicio servicio, Long kyUsuarioMod){		
		List<DtEntidadesBk> dtEntidadesBksss = null;
		String key = DtEntidadesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtEntidadesBksss = (List<DtEntidadesBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtEntidadesBk> dtEntidadesBkssss = servicio.getAllDtEntidadesActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtEntidadesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtEntidadesBksss = servicio.getAllDtEntidadesActivosCero(kyUsuarioMod);
			entrada.setLista(dtEntidadesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtEntidadesBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtEntidadesBk dtEntidadesC){		
		List<DtEntidadesBk> dtEntidadesBksss = null;
		String key = DtEntidadesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtEntidadesBksss = (List<DtEntidadesBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtEntidadesBk> dtEntidadesBkssss = servicio.getAllDtEntidadesActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtEntidadesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtEntidadesBksss = servicio.getAllDtEntidadesActivosCero(kyUsuarioMod);
			entrada.setLista(dtEntidadesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!dtEntidadesBksss.contains(dtEntidadesC)) {
			dtEntidadesBksss.add(dtEntidadesC);
		} else {
			int itemIndex = dtEntidadesBksss.indexOf(dtEntidadesC);
			if (itemIndex != -1) {
				dtEntidadesBksss.set(itemIndex, dtEntidadesC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = DtEntidadesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtEntidadesBk> dtEntidadesBkssss = servicio.getAllDtEntidadesActivosCero(kyUsuarioMod);
    				entrada.setLista(dtEntidadesBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
