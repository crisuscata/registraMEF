package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtEncuesta;
import pe.gob.mef.registramef.bs.exception.Validador;

/**
*
* DT_ENCUESTA REPOSITORIO INTERFACE: LISTA DE ENCUESTAS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEncuestaDao {
	void saveDtEncuesta(DtEncuesta param);
	void updateDtEncuesta(DtEncuesta param);
	void deleteDtEncuesta(DtEncuesta param);
	List<DtEncuesta> getAllDtEncuesta();
	DtEncuesta getDtEncuesta(Integer idEncuesta);
	List<DtEncuesta> getNativeSQLDtEncuesta(String queryString, Object[] params);
	List<DtEncuesta> getActivasDtEncuesta();
	List<DtEncuesta> getActivasDtEncuestaCero();
	List<DtEncuesta> getDesactivasDtEncuesta();
	Long getMaxIdVal();
	
	List<DtEncuesta> getXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion, int iniciar, int max);
	List<DtEncuesta> getXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion,Date fechaServicio); //PURIBE 22042024 - INICIO-->
	long getTotalXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion);
	List<DtEncuesta> findListPeriodo(Long idTipoServicio, Date fechaServicio) throws Validador;
	DtEncuesta findPeriodo(Long idTipoServicio, Date fechaServicio) throws Validador;
	
}