package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaUsuexternos;

/**
*
* DT_ASISTENCIA_USUEXTERNOS REPOSITORIO INTERFACE: LISTA DE LOS USUARIOS QUE BRINDAN LA ATENCION EN LA ASISTENCIA TECNICA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAsistenciaUsuexternosDao {
	void saveDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param);
	void updateDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param);
	void deleteDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param);
	List<DtAsistenciaUsuexternos> getAllDtAsistenciaUsuexternos();
	DtAsistenciaUsuexternos getDtAsistenciaUsuexternos(Long idAsistUsuext);
	List<DtAsistenciaUsuexternos> getNativeSQLDtAsistenciaUsuexternos(String queryString, Object[] params);
	List<DtAsistenciaUsuexternos> getActivasDtAsistenciaUsuexternos();
	List<DtAsistenciaUsuexternos> getActivasDtAsistenciaUsuexternosCero();
	List<DtAsistenciaUsuexternos> getDesactivasDtAsistenciaUsuexternos();
	Long getMaxIdVal();
	
	List<DtAsistenciaUsuexternos> getXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext, int iniciar, int max);
	List<DtAsistenciaUsuexternos> getXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext);
	long getTotalXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext);
	
	List<DtAsistenciaUsuexternos> getByIdAsistDtAsisteUsuariosExt(Long idAsiste);//MPINARES 24012023 - INICIO
	void updateDtAsistenciaUsuexCorreo(Long id);//CUSCATA - 10072024
	Long getEstadoEliminado();//CUSCATA - 10072024
	
}