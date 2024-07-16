package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtAsistencia;

/**
*
* DT_ASISTENCIA REPOSITORIO INTERFACE: LISTA DE LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAsistenciaDao {
	void saveDtAsistencia(DtAsistencia param);
	void updateDtAsistencia(DtAsistencia param);
	void deleteDtAsistencia(DtAsistencia param);
	List<DtAsistencia> getAllDtAsistencia();
	DtAsistencia getDtAsistencia(Long idAsistencia);
	List<DtAsistencia> getNativeSQLDtAsistencia(String queryString, Object[] params);
	List<DtAsistencia> getActivasDtAsistencia();
	List<DtAsistencia> getActivasDtAsistenciaCero();
	List<DtAsistencia> getDesactivasDtAsistencia();
	Long getMaxIdVal();
	
	List<DtAsistencia> getXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado, int iniciar, int max);
	List<DtAsistencia> getXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado);
	long getTotalXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado);
	//MPINARES 24012023 - INICIO
	List<DtAsistencia> getXFiltroV(Date fechaInicio, Date fechaFin,Long idProgramacion) ;
//		Long getEstadoNuevo();
//		Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
	List<DtAsistencia> getXFiltro(Date fechaInicio, Date fechaFin,Long idProgramacion, Long idSede,Long idSistAdm, Long idUsuario);
}