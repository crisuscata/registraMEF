package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCapaEntidades;

/**
*
* DT_CAPA_ENTIDADES REPOSITORIO INTERFACE: LISTA DE LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapaEntidadesDao {
	void saveDtCapaEntidades(DtCapaEntidades param);
	void updateDtCapaEntidades(DtCapaEntidades param);
	void deleteDtCapaEntidades(DtCapaEntidades param);
	List<DtCapaEntidades> getAllDtCapaEntidades();
	DtCapaEntidades getDtCapaEntidades(Long idCapaEnti);
	List<DtCapaEntidades> getNativeSQLDtCapaEntidades(String queryString, Object[] params);
	List<DtCapaEntidades> getActivasDtCapaEntidades();
	List<DtCapaEntidades> getActivasDtCapaEntidadesCero();
	List<DtCapaEntidades> getDesactivasDtCapaEntidades();
	Long getMaxIdVal();
	
	List<DtCapaEntidades> getXFiltro(Long idCapacitacion,Long idEntidad, int iniciar, int max);
	List<DtCapaEntidades> getXFiltro(Long idCapacitacion,Long idEntidad);
	long getTotalXFiltro(Long idCapacitacion,Long idEntidad);
	//MPINARES 14022024 - INICIO
		List<DtCapaEntidades> getByIdCapacDtCapaEntidades(Long idCapacitacion);
//		Long getEstadoNuevo() ;
//		Long getEstadoEliminado();
		//MPINARES 14022024 - FIN
	
}