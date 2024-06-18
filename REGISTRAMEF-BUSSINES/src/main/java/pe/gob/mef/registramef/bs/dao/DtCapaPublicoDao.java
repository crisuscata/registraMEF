package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCapaPublico;

/**
*
* DT_CAPA_PUBLICO REPOSITORIO INTERFACE: LISTA DE LOS TIPOS DE PUBLICO OBJETIVO POR CAPACITACIÓN
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapaPublicoDao {
	void saveDtCapaPublico(DtCapaPublico param);
	void updateDtCapaPublico(DtCapaPublico param);
	void deleteDtCapaPublico(DtCapaPublico param);
	List<DtCapaPublico> getAllDtCapaPublico();
	DtCapaPublico getDtCapaPublico(Long idCapaPublico);
	List<DtCapaPublico> getNativeSQLDtCapaPublico(String queryString, Object[] params);
	List<DtCapaPublico> getActivasDtCapaPublico();
	List<DtCapaPublico> getActivasDtCapaPublicoCero();
	List<DtCapaPublico> getDesactivasDtCapaPublico();
	Long getMaxIdVal();
	
	List<DtCapaPublico> getXFiltro(Long idCapacitacion, int iniciar, int max);
	List<DtCapaPublico> getXFiltro(Long idCapacitacion);
	long getTotalXFiltro(Long idCapacitacion);
	//MPINARES 14022024 - INICIO
		List<DtCapaPublico> getByIdCapacDtCapaPublico(Long idCapacitacion);
//			Long getEstadoNuevo() ;
//			Long getEstadoEliminado();
			//MPINARES 14022024 - FIN
	
}