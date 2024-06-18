package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.MsRolesBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class MsRolesData implements Serializable{
	
	private static final Logger log = Logger.getLogger(MsRolesData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public MsRolesData() {
	}

	@SuppressWarnings("unchecked")
	public List<MsRolesBk> getMsRolesActivos(Servicio servicio, Long kyUsuarioMod){		
		List<MsRolesBk> msRolesBksss = null;
		String key = MsRolesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msRolesBksss = (List<MsRolesBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsRolesBk> msRolesBkssss = servicio.getAllMsRolesActivosCero(kyUsuarioMod);
		    				entrada.setLista(msRolesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msRolesBksss = servicio.getAllMsRolesActivosCero(kyUsuarioMod);
			entrada.setLista(msRolesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return msRolesBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, MsRolesBk msRolesC){		
		List<MsRolesBk> msRolesBksss = null;
		String key = MsRolesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			msRolesBksss = (List<MsRolesBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<MsRolesBk> msRolesBkssss = servicio.getAllMsRolesActivosCero(kyUsuarioMod);
		    				entrada.setLista(msRolesBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			msRolesBksss = servicio.getAllMsRolesActivosCero(kyUsuarioMod);
			entrada.setLista(msRolesBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		if (!msRolesBksss.contains(msRolesC)) {
			msRolesBksss.add(msRolesC);
		} else {
			int itemIndex = msRolesBksss.indexOf(msRolesC);
			if (itemIndex != -1) {
				msRolesBksss.set(itemIndex, msRolesC);
			}
		}		
	}
	
	public void refrescar(Servicio servicio, Long kyUsuarioMod){
		String key = MsRolesBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<MsRolesBk> msRolesBkssss = servicio.getAllMsRolesActivosCero(kyUsuarioMod);
    				entrada.setLista(msRolesBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
