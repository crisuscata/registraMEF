package pe.gob.mef.registramef.bs.dao;
//PURIBE 16012024 - INICIO- 
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.TaFeriados;

/**
*
* TA_FERIADOS REPOSITORIO INTERFACE: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
*
*
* @author  Carlos Aguilar
* @version 2.0, 18/12/2023 18:48
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 18/12/2023 18:48         / Creación de la clase  /
* 
*/
public interface TaFeriadosDao {
	void saveTaFeriados(TaFeriados param);
	void updateTaFeriados(TaFeriados param);
	void deleteTaFeriados(TaFeriados param);
	List<TaFeriados> getAllTaFeriados();
	TaFeriados getTaFeriados(Timestamp feFecha);
	List<TaFeriados> getNativeSQLTaFeriados(String queryString, Object[] params);
	List<TaFeriados> getActivasTaFeriados();
	List<TaFeriados> getActivasTaFeriadosCero();
	List<TaFeriados> getDesactivasTaFeriados();
	Long getMaxIdVal();
	
	List<TaFeriados> getXFiltro(String feDesc, int iniciar, int max);
	List<TaFeriados> getXFiltro(String feDesc);
	List<TaFeriados> getByIdTaFeriados(java.util.Date id); 
	//PURIBE 16012024 - FIN 
	long getTotalXFiltro(String feDesc);
	
}