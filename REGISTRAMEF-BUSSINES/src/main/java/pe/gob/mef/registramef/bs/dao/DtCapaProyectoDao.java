package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCapaProyecto;

/**
*
* DT_CAPA_PROYECTO REPOSITORIO INTERFACE: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapaProyectoDao {
	void saveDtCapaProyecto(DtCapaProyecto param);
	void updateDtCapaProyecto(DtCapaProyecto param);
	void deleteDtCapaProyecto(DtCapaProyecto param);
	List<DtCapaProyecto> getAllDtCapaProyecto();
	DtCapaProyecto getDtCapaProyecto(Long idCapaProyecto);
	List<DtCapaProyecto> getNativeSQLDtCapaProyecto(String queryString, Object[] params);
	List<DtCapaProyecto> getActivasDtCapaProyecto();
	List<DtCapaProyecto> getActivasDtCapaProyectoCero();
	List<DtCapaProyecto> getDesactivasDtCapaProyecto();
	Long getMaxIdVal();
	
	List<DtCapaProyecto> getXFiltro(Long idProyecto,String detalle, int iniciar, int max);
	List<DtCapaProyecto> getXFiltro(Long idProyecto,String detalle);
	long getTotalXFiltro(Long idProyecto,String detalle);
	
}