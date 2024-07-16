package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuinternos;

/**
*
* DT_VISITAS_USUINTERNOS REPOSITORIO INTERFACE: LISTA DE LOS PARTICIPANTES DE LA VISITA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtVisitasUsuinternosDao {
	void saveDtVisitasUsuinternos(DtVisitasUsuinternos param);
	void updateDtVisitasUsuinternos(DtVisitasUsuinternos param);
	void deleteDtVisitasUsuinternos(DtVisitasUsuinternos param);
	List<DtVisitasUsuinternos> getAllDtVisitasUsuinternos();
	DtVisitasUsuinternos getDtVisitasUsuinternos(Long idVisitUsuint);
	List<DtVisitasUsuinternos> getNativeSQLDtVisitasUsuinternos(String queryString, Object[] params);
	List<DtVisitasUsuinternos> getActivasDtVisitasUsuinternos();
	List<DtVisitasUsuinternos> getActivasDtVisitasUsuinternosCero();
	List<DtVisitasUsuinternos> getDesactivasDtVisitasUsuinternos();
	Long getMaxIdVal();
	
	List<DtVisitasUsuinternos> getXFiltro(Long idVisita,Long idUsuinterno, int iniciar, int max);
	List<DtVisitasUsuinternos> getXFiltro(Long idVisita,Long idUsuinterno);
	List<DtVisitasUsuinternos> getXFiltro(Long idVisita);//PURIBE 14032024 - INICIO-->
	long getTotalXFiltro(Long idVisita,Long idUsuinterno);
	List<DtVisitasUsuinternos> getXFiltroConcatenacionLista(Long idVisita);
	
}