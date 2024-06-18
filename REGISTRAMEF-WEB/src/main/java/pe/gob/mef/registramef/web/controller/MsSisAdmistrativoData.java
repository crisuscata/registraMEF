package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsSisAdmistrativoBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsSisAdmistrativoData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsSisAdmistrativoData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsSisAdmistrativoData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsSisAdmistrativoBk> getMsSisAdmistrativoActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsSisAdmistrativoBk> msSisAdmistrativoBksss = null;
		String key = MsSisAdmistrativoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSisAdmistrativoBksss = (List<MsSisAdmistrativoBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSisAdmistrativoBk> msSisAdmistrativoBkssss = servicio.getAllMsSisAdmistrativoActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSisAdmistrativoBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSisAdmistrativoBksss = servicio.getAllMsSisAdmistrativoActivosCero(kyUsuarioMod);
			entrada.setLista(msSisAdmistrativoBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msSisAdmistrativoBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsSisAdmistrativoBk msSisAdmistrativoC){		
		List<MsSisAdmistrativoBk> msSisAdmistrativoBksss = null;
		String key = MsSisAdmistrativoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msSisAdmistrativoBksss = (List<MsSisAdmistrativoBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsSisAdmistrativoBk> msSisAdmistrativoBkssss = servicio.getAllMsSisAdmistrativoActivosCero(kyUsuarioMod);
		    				entrada.setLista(msSisAdmistrativoBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msSisAdmistrativoBksss = servicio.getAllMsSisAdmistrativoActivosCero(kyUsuarioMod);
			entrada.setLista(msSisAdmistrativoBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msSisAdmistrativoBksss.contains(msSisAdmistrativoC)) {
			msSisAdmistrativoBksss.add(msSisAdmistrativoC);
		} else {
			int itemIndex = msSisAdmistrativoBksss.indexOf(msSisAdmistrativoC);
			if (itemIndex != -1) {
				msSisAdmistrativoBksss.set(itemIndex, msSisAdmistrativoC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsSisAdmistrativoBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsSisAdmistrativoBk> msSisAdmistrativoBkssss = servicio.getAllMsSisAdmistrativoActivosCero(kyUsuarioMod);
    				entrada.setLista(msSisAdmistrativoBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
