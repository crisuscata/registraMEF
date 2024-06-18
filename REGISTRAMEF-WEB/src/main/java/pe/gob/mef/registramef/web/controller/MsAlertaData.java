package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsAlertaBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsAlertaData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsAlertaData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsAlertaData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsAlertaBk> getMsAlertaActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsAlertaBk> msAlertaBksss = null;
		String key = MsAlertaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msAlertaBksss = (List<MsAlertaBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsAlertaBk> msAlertaBkssss = servicio.getAllMsAlertaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msAlertaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msAlertaBksss = servicio.getAllMsAlertaActivosCero(kyUsuarioMod);
			entrada.setLista(msAlertaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msAlertaBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsAlertaBk msAlertaC){		
		List<MsAlertaBk> msAlertaBksss = null;
		String key = MsAlertaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msAlertaBksss = (List<MsAlertaBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsAlertaBk> msAlertaBkssss = servicio.getAllMsAlertaActivosCero(kyUsuarioMod);
		    				entrada.setLista(msAlertaBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msAlertaBksss = servicio.getAllMsAlertaActivosCero(kyUsuarioMod);
			entrada.setLista(msAlertaBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msAlertaBksss.contains(msAlertaC)) {
			msAlertaBksss.add(msAlertaC);
		} else {
			int itemIndex = msAlertaBksss.indexOf(msAlertaC);
			if (itemIndex != -1) {
				msAlertaBksss.set(itemIndex, msAlertaC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsAlertaBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsAlertaBk> msAlertaBkssss = servicio.getAllMsAlertaActivosCero(kyUsuarioMod);
    				entrada.setLista(msAlertaBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
