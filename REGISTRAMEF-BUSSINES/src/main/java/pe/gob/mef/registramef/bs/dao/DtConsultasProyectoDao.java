package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtConsultasProyecto;

/**
*
* DT_CONSULTAS_PROYECTO REPOSITORIO INTERFACE: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CONSULTAS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtConsultasProyectoDao {
	void saveDtConsultasProyecto(DtConsultasProyecto param);
	void updateDtConsultasProyecto(DtConsultasProyecto param);
	void deleteDtConsultasProyecto(DtConsultasProyecto param);
	List<DtConsultasProyecto> getAllDtConsultasProyecto();
	DtConsultasProyecto getDtConsultasProyecto(Long idConsProyecto);
	List<DtConsultasProyecto> getNativeSQLDtConsultasProyecto(String queryString, Object[] params);
	List<DtConsultasProyecto> getActivasDtConsultasProyecto();
	List<DtConsultasProyecto> getActivasDtConsultasProyectoCero();
	List<DtConsultasProyecto> getDesactivasDtConsultasProyecto();
	Long getMaxIdVal();
	
	List<DtConsultasProyecto> getXFiltro(Long idConsulta,Long idProyecto,String detalle, int iniciar, int max);
	List<DtConsultasProyecto> getXFiltro(Long idConsulta,Long idProyecto,String detalle);
	long getTotalXFiltro(Long idConsulta,Long idProyecto,String detalle);
	
}