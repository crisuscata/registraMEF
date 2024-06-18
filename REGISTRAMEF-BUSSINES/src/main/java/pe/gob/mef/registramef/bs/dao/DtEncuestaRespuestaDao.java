package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtEncuestaRespuesta;

/**
*
* DT_ENCUESTA_RESPUESTA REPOSITORIO INTERFACE: LISTA DE RESPUESTAS A LAS ENCUESTAS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEncuestaRespuestaDao {
	void saveDtEncuestaRespuesta(DtEncuestaRespuesta param);
	void updateDtEncuestaRespuesta(DtEncuestaRespuesta param);
	void deleteDtEncuestaRespuesta(DtEncuestaRespuesta param);
	List<DtEncuestaRespuesta> getAllDtEncuestaRespuesta();
	DtEncuestaRespuesta getDtEncuestaRespuesta(Long idRespuesta);
	List<DtEncuestaRespuesta> getNativeSQLDtEncuestaRespuesta(String queryString, Object[] params);
	List<DtEncuestaRespuesta> getActivasDtEncuestaRespuesta();
	List<DtEncuestaRespuesta> getActivasDtEncuestaRespuestaCero();
	List<DtEncuestaRespuesta> getDesactivasDtEncuestaRespuesta();
	Long getMaxIdVal();
	
	List<DtEncuestaRespuesta> getXFiltro(Integer idEncuesta,String pregunta, int iniciar, int max);
	List<DtEncuestaRespuesta> getXFiltro(Integer idEncuesta,String pregunta);
	long getTotalXFiltro(Integer idEncuesta,String pregunta);
	
}