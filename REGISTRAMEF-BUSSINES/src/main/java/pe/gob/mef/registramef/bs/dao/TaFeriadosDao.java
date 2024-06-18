package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.TaFeriados;

/**
*
* TA_FERIADOS REPOSITORIO INTERFACE: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
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
	
	List<TaFeriados> getXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado, int iniciar, int max);
	List<TaFeriados> getXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado);
	long getTotalXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado);
	
}