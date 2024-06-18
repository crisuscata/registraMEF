package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtConsultasBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtConsultasData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtConsultasData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtConsultasData() {
	}

	@SuppressWarnings("unchecked")
	public List<DtConsultasBk> getDtConsultasActivos(Servicio servicio, Long kyUsuarioMod){		
		List<DtConsultasBk> dtConsultasBksss = null;
		String key = DtConsultasBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtConsultasBksss = (List<DtConsultasBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtConsultasBk> dtConsultasBkssss = servicio.getAllDtConsultasActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtConsultasBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtConsultasBksss = servicio.getAllDtConsultasActivosCero(kyUsuarioMod);
			entrada.setLista(dtConsultasBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtConsultasBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtConsultasBk dtConsultasC){		
		List<DtConsultasBk> dtConsultasBksss = null;
		String key = DtConsultasBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtConsultasBksss = (List<DtConsultasBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtConsultasBk> dtConsultasBkssss = servicio.getAllDtConsultasActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtConsultasBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtConsultasBksss = servicio.getAllDtConsultasActivosCero(kyUsuarioMod);
			entrada.setLista(dtConsultasBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!dtConsultasBksss.contains(dtConsultasC)) {
			dtConsultasBksss.add(dtConsultasC);
		} else {
			int itemIndex = dtConsultasBksss.indexOf(dtConsultasC);
			if (itemIndex != -1) {
				dtConsultasBksss.set(itemIndex, dtConsultasC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = DtConsultasBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtConsultasBk> dtConsultasBkssss = servicio.getAllDtConsultasActivosCero(kyUsuarioMod);
    				entrada.setLista(dtConsultasBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
