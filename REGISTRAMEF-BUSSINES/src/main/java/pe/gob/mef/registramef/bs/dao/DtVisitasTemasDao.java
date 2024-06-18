package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtVisitasTemas;

/**
*
* DT_VISITAS_TEMAS REPOSITORIO INTERFACE: LISTA DE LOS TEMAS DE LA VISITA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtVisitasTemasDao {
	void saveDtVisitasTemas(DtVisitasTemas param);
	void updateDtVisitasTemas(DtVisitasTemas param);
	void deleteDtVisitasTemas(DtVisitasTemas param);
	List<DtVisitasTemas> getAllDtVisitasTemas();
	DtVisitasTemas getDtVisitasTemas(Long idVisitaTema);
	List<DtVisitasTemas> getNativeSQLDtVisitasTemas(String queryString, Object[] params);
	List<DtVisitasTemas> getActivasDtVisitasTemas();
	List<DtVisitasTemas> getActivasDtVisitasTemasCero();
	List<DtVisitasTemas> getDesactivasDtVisitasTemas();
	Long getMaxIdVal();
	
	List<DtVisitasTemas> getXFiltro(Long idVisita, int iniciar, int max);
	List<DtVisitasTemas> getXFiltro(Long idVisita);
	long getTotalXFiltro(Long idVisita);
	
}