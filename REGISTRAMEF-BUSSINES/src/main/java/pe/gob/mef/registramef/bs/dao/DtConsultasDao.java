package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtConsultas;

/**
*
* DT_CONSULTAS REPOSITORIO INTERFACE: LISTA DE LOS DATOS REGISTRADOS EN UNA CONSULTA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtConsultasDao {
	void saveDtConsultas(DtConsultas param);
	void updateDtConsultas(DtConsultas param);
	void deleteDtConsultas(DtConsultas param);
	List<DtConsultas> getAllDtConsultas();
	DtConsultas getDtConsultas(Long idConsulta);
	List<DtConsultas> getNativeSQLDtConsultas(String queryString, Object[] params);
	List<DtConsultas> getActivasDtConsultas();
	List<DtConsultas> getActivasDtConsultasCero();
	List<DtConsultas> getDesactivasDtConsultas();
	Long getMaxIdVal();
	
	List<DtConsultas> getXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado, int iniciar, int max);
	List<DtConsultas> getXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado);
	long getTotalXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado);
	
}