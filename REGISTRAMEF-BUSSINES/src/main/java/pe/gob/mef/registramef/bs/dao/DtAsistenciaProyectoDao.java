package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaProyecto;

/**
*
* DT_ASISTENCIA_PROYECTO REPOSITORIO INTERFACE: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAsistenciaProyectoDao {
	void saveDtAsistenciaProyecto(DtAsistenciaProyecto param);
	void updateDtAsistenciaProyecto(DtAsistenciaProyecto param);
	void deleteDtAsistenciaProyecto(DtAsistenciaProyecto param);
	List<DtAsistenciaProyecto> getAllDtAsistenciaProyecto();
	DtAsistenciaProyecto getDtAsistenciaProyecto(Long idAsistProyecto);
	List<DtAsistenciaProyecto> getNativeSQLDtAsistenciaProyecto(String queryString, Object[] params);
	List<DtAsistenciaProyecto> getActivasDtAsistenciaProyecto();
	List<DtAsistenciaProyecto> getActivasDtAsistenciaProyectoCero();
	List<DtAsistenciaProyecto> getDesactivasDtAsistenciaProyecto();
	Long getMaxIdVal();
	
	List<DtAsistenciaProyecto> getXFiltro(Long idAsistencia,Long idProyecto,String detalle, int iniciar, int max);
	List<DtAsistenciaProyecto> getXFiltro(Long idAsistencia,Long idProyecto,String detalle);
	long getTotalXFiltro(Long idAsistencia,Long idProyecto,String detalle);
	
}