package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaTemas;

/**
*
* DT_ASISTENCIA_TEMAS REPOSITORIO INTERFACE: LISTA DE LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAsistenciaTemasDao {
	void saveDtAsistenciaTemas(DtAsistenciaTemas param);
	void updateDtAsistenciaTemas(DtAsistenciaTemas param);
	void deleteDtAsistenciaTemas(DtAsistenciaTemas param);
	List<DtAsistenciaTemas> getAllDtAsistenciaTemas();
	DtAsistenciaTemas getDtAsistenciaTemas(Long idAsistTema);
	List<DtAsistenciaTemas> getNativeSQLDtAsistenciaTemas(String queryString, Object[] params);
	List<DtAsistenciaTemas> getActivasDtAsistenciaTemas();
	List<DtAsistenciaTemas> getActivasDtAsistenciaTemasCero();
	List<DtAsistenciaTemas> getDesactivasDtAsistenciaTemas();
	Long getMaxIdVal();
	
	List<DtAsistenciaTemas> getXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema, int iniciar, int max);
	List<DtAsistenciaTemas> getXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema);
	long getTotalXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema);
	
	//MPINARES 24012023 - INICIO
	List<DtAsistenciaTemas> getDtAsistenciaTemasByIdAsistencia(Long idAsistencia);
//	Long getEstadoNuevo();
//	Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
		
}