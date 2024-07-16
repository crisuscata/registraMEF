package pe.gob.mef.registramef.web.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
// PURIBE 14032024 - INICIO -->
import pe.gob.mef.registramef.bs.service.Servicio;
import pe.gob.mef.registramef.bs.transfer.bk.DtVisitasBk;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;//puribe
import pe.gob.mef.registramef.web.utils.Entrada;


public class DtVisitasData implements Serializable{
	
	private static final Logger log = Logger.getLogger(DtVisitasData.class.getName());

	private Map<String, Entrada> dataCache = new HashMap<String,Entrada>();

	public DtVisitasData() {
	}

	//puribe
	//PURIBE 04042024 - INICIO-->
		@SuppressWarnings("unchecked")
		public List<DtVisitasBk> getDtVisitasActivos(Servicio servicio, Long kyUsuarioMod,Timestamp fechaInicio,Timestamp fechaFin,int reload,int programada,long sede,int rol,long sistemaadmi){		
			List<DtVisitasBk> dtVisitasBksss = null;
		String key = DtVisitasBk.class.getSimpleName();
		
		if(reload==1)
		{
			dataCache = new HashMap<>();
		}
		
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtVisitasBksss = (List<DtVisitasBk>) entrada.getLista();
			long ultimoacceso = entrada.getUltimoacceso();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((ultimoacceso+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	//PURIBE 04042024 - INICIO-->
		                	List<DtVisitasBk> dtVisitasBkssss = servicio.getAllDtVisitasActivosCero(kyUsuarioMod,fechaInicio,fechaFin,programada,sede,rol,sistemaadmi);
		                	//PURIBE 04042024 - FIN-->
		    				entrada.setLista(dtVisitasBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			//PURIBE 04042024 - INICIO-->
			dtVisitasBksss = servicio.getAllDtVisitasActivosCero(kyUsuarioMod,fechaInicio,fechaFin,programada,sede,rol,sistemaadmi);
		 	//PURIBE 04042024 - FIN-->
			entrada.setLista(dtVisitasBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		return dtVisitasBksss;		
	}
	//puribe
	//puribe
	@SuppressWarnings("unchecked") 
	public void add(Servicio servicio, Long kyUsuarioMod, DtVisitasBk dtVisitasC,Timestamp fechaInicio,Timestamp fechaFin,int programada,long sede,int rol,long sistemaadmi){// PURIBE 04042024 - INICIO
		List<DtVisitasBk> dtVisitasBksss = null;
		String key = DtVisitasBk.class.getSimpleName();
		
		

		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
			dtVisitasBksss = (List<DtVisitasBk>) entrada.getLista();
			entrada.setUltimoacceso(System.currentTimeMillis());
			if((entrada.getUltimoacceso()+entrada.getTiempomuerto())<System.currentTimeMillis()){
				new Thread() {
		            public void run() {
		                try {
		                	List<DtVisitasBk> dtVisitasBkssss = servicio.getAllDtVisitasActivosCero(kyUsuarioMod,fechaInicio,fechaFin,programada,sede,rol,sistemaadmi);// PURIBE 04042024 - INICIO
		    				entrada.setLista(dtVisitasBkssss);
		    				entrada.setUltimoacceso(System.currentTimeMillis());
		                } catch (Exception ex) {
		                	log.info(ex.getMessage());
		                    
		                } 
		            }		 
		        }.start();				
			}
		}else{
			Entrada entrada = new Entrada();
			dtVisitasBksss = servicio.getAllDtVisitasActivosCero(kyUsuarioMod,fechaInicio,fechaFin,programada,sede,rol,sistemaadmi);// PURIBE 04042024 - INICIO
			entrada.setLista(dtVisitasBksss);
			entrada.setTiempomuerto(60000);
			entrada.setUltimoacceso(System.currentTimeMillis());
			dataCache.put(key, entrada);
		}
		//dtVisitasBksss = UtilidadesLista.reemplazarYAgregar(dtVisitasBksss, visita -> visita.getId() != dtVisitasC.getId(), dtVisitasC);
	
		if (FuncionesStaticas.replaceAdd(dtVisitasBksss, visita -> visita.getIdVisita().equals(dtVisitasC.getIdVisita()), dtVisitasC)) {
			//dtVisitasBksss.add(dtVisitasC);
		} else {
			int itemIndex = dtVisitasBksss.indexOf(dtVisitasC);
			if (itemIndex != -1) {
				dtVisitasBksss.set(itemIndex, dtVisitasC);
			}
		}		
	}
	//puribe
	public void refrescar(Servicio servicio, Long kyUsuarioMod,Timestamp fechaInicio,Timestamp fechaFin,int programada,long sede,int rol,long sistemaadmi){// PURIBE 04042024 - INICIO
		String key = DtVisitasBk.class.getSimpleName();
		if(dataCache.containsKey(key)){
			Entrada entrada = dataCache.get(key);
		new Thread() {
            public void run() {
                try {
                	List<DtVisitasBk> dtVisitasBkssss = servicio.getAllDtVisitasActivosCero(kyUsuarioMod,fechaInicio,fechaFin,programada,sede,rol,sistemaadmi);// PURIBE 04042024 - INICIO
    				entrada.setLista(dtVisitasBkssss);
    				entrada.setUltimoacceso(System.currentTimeMillis());
                } catch (Exception ex) {
                	log.info(ex.getMessage());
                    
                } 
            }		 
        }.start();
		}
	}
}
//puribe
// PURIBE 14032024 - FIN -->