package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuexternos;

/**
*
* DT_VISITAS_USUEXTERNOS REPOSITORIO INTERFACE: LISTA DE LOS PARTICIPANTES DE LA VISITA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtVisitasUsuexternosDao {
	void saveDtVisitasUsuexternos(DtVisitasUsuexternos param);
	void updateDtVisitasUsuexternos(DtVisitasUsuexternos param);
	void deleteDtVisitasUsuexternos(DtVisitasUsuexternos param);
	List<DtVisitasUsuexternos> getAllDtVisitasUsuexternos();
	DtVisitasUsuexternos getDtVisitasUsuexternos(Long idVisitUsuext);
	List<DtVisitasUsuexternos> getNativeSQLDtVisitasUsuexternos(String queryString, Object[] params);
	List<DtVisitasUsuexternos> getActivasDtVisitasUsuexternos();
	List<DtVisitasUsuexternos> getActivasDtVisitasUsuexternosCero();
	List<DtVisitasUsuexternos> getDesactivasDtVisitasUsuexternos();
	Long getMaxIdVal();
	
	List<DtVisitasUsuexternos> getXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext, int iniciar, int max);
	List<DtVisitasUsuexternos> getXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext);
	long getTotalXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext);
	
}