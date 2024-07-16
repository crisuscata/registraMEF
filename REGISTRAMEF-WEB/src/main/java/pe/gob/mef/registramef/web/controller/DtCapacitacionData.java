package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtCapacitacionBk;
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtCapacitacionData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtCapacitacionData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtCapacitacionData() {
	}

	@SuppressWarnings("unchecked")
//	public List<DtCapacitacionBk> getDtCapacitacionActivos(Servicio servicio, Long kyUsuarioMod){	
	public List<DtCapacitacionBk> getDtCapacitacionActivos(Servicio servicio, Long kyUsuarioMod, String fechaInicio, String fechaFin,String idProgramacion,int reload, long sede,int rol,long sistemaadmi){	//MPINARES 14022024 - INICIO	
		List<DtCapacitacionBk> dtCapacitacionBksss = null;
		String key = DtCapacitacionBk.class.getSimpleName();
		if(reload==1)
		{
			dataCache = new HashMap<>();
		}
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtCapacitacionBksss = (List<DtCapacitacionBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	//MPINARES 14022024 - INICIO
		                	Long idProgramacionl=Long.parseLong(idProgramacion);
		                      SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		                      Date fechaIniciod=sdformat.parse(fechaInicio);
		                      Date fechaFind=sdformat.parse(fechaFin);
//		                      List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getDtCapacitacionXFiltroV(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod);
		                      List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getDtCapacitacionXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
//		                	List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getAllDtCapacitacionActivosCero(kyUsuarioMod);
		    				entrada.setLista(dtCapacitacionBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		    				//MPINARES 14022024 - FIN
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			try {
				//MPINARES 14022024 - INICIO
				Entrada entrada = new Entrada();
				Long idProgramacionl=Long.parseLong(idProgramacion);
	            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	            Date fechaIniciod=sdformat.parse(fechaInicio);
	            Date fechaFind=sdformat.parse(fechaFin);
				dtCapacitacionBksss = servicio.getDtCapacitacionXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
				entrada.setLista(dtCapacitacionBksss);
				entrada.setTiempomuerto(60000);
				entrada.setUltimoacceso(System.currentTimeMillis());
				dataCache.put(key, entrada);
			} catch (Exception ex) {
				log.info(ex.getMessage());
			}
			//MPINARES 14022024 - FIN
		}
		return dtCapacitacionBksss;		
	}
	
	@SuppressWarnings("unchecked")
	public void add(Servicio servicio, Long kyUsuarioMod, DtCapacitacionBk dtCapacitacionC, String fechaInicio, String fechaFin,String idProgramacion, long sede,int rol,long sistemaadmi){		
		List<DtCapacitacionBk> dtCapacitacionBksss = null;
		String key = DtCapacitacionBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtCapacitacionBksss = (List<DtCapacitacionBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	Long idProgramacionl=Long.parseLong(idProgramacion);
		                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		                	Date fechaIniciod=sdformat.parse(fechaInicio);
		                	Date fechaFind=sdformat.parse(fechaFin);
//		                	List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getAllDtCapacitacionActivosCero(kyUsuarioMod);
		                	List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getDtCapacitacionXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
		    				entrada.setLista(dtCapacitacionBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			try {
			Entrada entrada = new Entrada();
			Long idProgramacionl=Long.parseLong(idProgramacion);
        	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        	Date fechaIniciod=sdformat.parse(fechaInicio);
        	Date fechaFind=sdformat.parse(fechaFin);
//			dtCapacitacionBksss = servicio.getAllDtCapacitacionActivosCero(kyUsuarioMod);
        	dtCapacitacionBksss = servicio.getDtCapacitacionXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
			entrada.setLista(dtCapacitacionBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
			} catch (Exception ex) {
            	log.info(ex.getMessage());
                
            } 
		}
		if (!dtCapacitacionBksss.contains(dtCapacitacionC)) {
			dtCapacitacionBksss.add(dtCapacitacionC);
		} else {
			int itemIndex = dtCapacitacionBksss.indexOf(dtCapacitacionC);
			if (itemIndex != -1) {
				dtCapacitacionBksss.set(itemIndex, dtCapacitacionC);
			}
		}		
	}
	
//	public void refrescar(Servicio servicio, Long kyUsuarioMod){
	public void refrescar(Servicio servicio, Long kyUsuarioMod, String fechaInicio, String fechaFin,String idProgramacion, long sede,int rol,long sistemaadmi){//MPINARES 14022024 - INICIO
		String key = DtCapacitacionBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	Long idProgramacionl=Long.parseLong(idProgramacion);
                	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                	Date fechaIniciod=sdformat.parse(fechaInicio);
                	Date fechaFind=sdformat.parse(fechaFin);
//                	List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getAllDtCapacitacionActivosCero(kyUsuarioMod);
                	List<DtCapacitacionBk> dtCapacitacionBkssss = servicio.getDtCapacitacionXFiltroV2(fechaIniciod, fechaFind, idProgramacionl, kyUsuarioMod, sede, rol, sistemaadmi);
    				entrada.setLista(dtCapacitacionBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
