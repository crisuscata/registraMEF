package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCapaTemas;

/**
*
* DT_CAPA_TEMAS REPOSITORIO INTERFACE: LISTA DE LOS DIFERENTES TEMAS AGENDADOS EN LA CAPACITACIÓN
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapaTemasDao {
	void saveDtCapaTemas(DtCapaTemas param);
	void updateDtCapaTemas(DtCapaTemas param);
	void deleteDtCapaTemas(DtCapaTemas param);
	List<DtCapaTemas> getAllDtCapaTemas();
	DtCapaTemas getDtCapaTemas(Long idCapaTemAgen);
	List<DtCapaTemas> getNativeSQLDtCapaTemas(String queryString, Object[] params);
	List<DtCapaTemas> getActivasDtCapaTemas();
	List<DtCapaTemas> getActivasDtCapaTemasCero();
	List<DtCapaTemas> getDesactivasDtCapaTemas();
	Long getMaxIdVal();
	
	List<DtCapaTemas> getXFiltro(Long idCapacitacion,Long idTema,Long idSubtema, int iniciar, int max);
	List<DtCapaTemas> getXFiltro(Long idCapacitacion,Long idTema,Long idSubtema);
	long getTotalXFiltro(Long idCapacitacion,Long idTema,Long idSubtema);
	
	//MPINARES 14022024 - INICIO
		List<DtCapaTemas> getByIdCapacDtCapaTemas(Long idCapacitacion);
//		Long getEstadoNuevo() ;
//		Long getEstadoEliminado();
		//MPINARES 14022024 - FIN
	
}