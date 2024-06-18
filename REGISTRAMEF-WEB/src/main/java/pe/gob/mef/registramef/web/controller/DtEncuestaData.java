package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtEncuestaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtEncuestaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtEncuestaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtEncuestaData() {
	}

	@SuppressWarnings("unchecked")
	public List<DtEncuestaBk> getDtEncuestaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<DtEncuestaBk> dtEncuestaBksss = null;
		String key = DtEncuestaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtEncuestaBksss = (List<DtEncuestaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtEncuestaBk> dtEncuestaBkssss = servicio.getAllDtEncuestaActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtEncuestaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtEncuestaBksss = servicio.getAllDtEncuestaActivosCero(kyUsuarioMod);
			entrada.setLista(dtEncuestaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtEncuestaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtEncuestaBk dtEncuestaC){		
		List<DtEncuestaBk> dtEncuestaBksss = null;
		String key = DtEncuestaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtEncuestaBksss = (List<DtEncuestaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtEncuestaBk> dtEncuestaBkssss = servicio.getAllDtEncuestaActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtEncuestaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtEncuestaBksss = servicio.getAllDtEncuestaActivosCero(kyUsuarioMod);
			entrada.setLista(dtEncuestaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!dtEncuestaBksss.contains(dtEncuestaC)) {
			dtEncuestaBksss.add(dtEncuestaC);
		} else {
			int itemIndex = dtEncuestaBksss.indexOf(dtEncuestaC);
			if (itemIndex != -1) {
				dtEncuestaBksss.set(itemIndex, dtEncuestaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = DtEncuestaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtEncuestaBk> dtEncuestaBkssss = servicio.getAllDtEncuestaActivosCero(kyUsuarioMod);
    				entrada.setLista(dtEncuestaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
