package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtAmpliacionFechaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtAmpliacionFechaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtAmpliacionFechaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtAmpliacionFechaData() {
	}

	@SuppressWarnings("unchecked")
	public List<DtAmpliacionFechaBk> getDtAmpliacionFechaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBksss = null;
		String key = DtAmpliacionFechaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtAmpliacionFechaBksss = (List<DtAmpliacionFechaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtAmpliacionFechaBk> dtAmpliacionFechaBkssss = servicio.getAllDtAmpliacionFechaActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtAmpliacionFechaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtAmpliacionFechaBksss = servicio.getAllDtAmpliacionFechaActivosCero(kyUsuarioMod);
			entrada.setLista(dtAmpliacionFechaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtAmpliacionFechaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtAmpliacionFechaBk dtAmpliacionFechaC){		
		List<DtAmpliacionFechaBk> dtAmpliacionFechaBksss = null;
		String key = DtAmpliacionFechaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtAmpliacionFechaBksss = (List<DtAmpliacionFechaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtAmpliacionFechaBk> dtAmpliacionFechaBkssss = servicio.getAllDtAmpliacionFechaActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtAmpliacionFechaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtAmpliacionFechaBksss = servicio.getAllDtAmpliacionFechaActivosCero(kyUsuarioMod);
			entrada.setLista(dtAmpliacionFechaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!dtAmpliacionFechaBksss.contains(dtAmpliacionFechaC)) {
			dtAmpliacionFechaBksss.add(dtAmpliacionFechaC);
		} else {
			int itemIndex = dtAmpliacionFechaBksss.indexOf(dtAmpliacionFechaC);
			if (itemIndex != -1) {
				dtAmpliacionFechaBksss.set(itemIndex, dtAmpliacionFechaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = DtAmpliacionFechaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtAmpliacionFechaBk> dtAmpliacionFechaBkssss = servicio.getAllDtAmpliacionFechaActivosCero(kyUsuarioMod);
    				entrada.setLista(dtAmpliacionFechaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
