package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtVisitasProyecto;

/**
*
* DT_VISITAS_PROYECTO REPOSITORIO INTERFACE: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtVisitasProyectoDao {
	void saveDtVisitasProyecto(DtVisitasProyecto param);
	void updateDtVisitasProyecto(DtVisitasProyecto param);
	void deleteDtVisitasProyecto(DtVisitasProyecto param);
	List<DtVisitasProyecto> getAllDtVisitasProyecto();
	DtVisitasProyecto getDtVisitasProyecto(Long idVisitaProyecto);
	List<DtVisitasProyecto> getNativeSQLDtVisitasProyecto(String queryString, Object[] params);
	List<DtVisitasProyecto> getActivasDtVisitasProyecto();
	List<DtVisitasProyecto> getActivasDtVisitasProyectoCero();
	List<DtVisitasProyecto> getDesactivasDtVisitasProyecto();
	Long getMaxIdVal();
	
	List<DtVisitasProyecto> getXFiltro(Long idVisita,Long idProyecto,String detalle, int iniciar, int max);
	List<DtVisitasProyecto> getXFiltro(Long idVisita,Long idProyecto,String detalle);
	long getTotalXFiltro(Long idVisita,Long idProyecto,String detalle);
	
}