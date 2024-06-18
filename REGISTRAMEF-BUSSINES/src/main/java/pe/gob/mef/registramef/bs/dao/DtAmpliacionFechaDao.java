package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.exception.Validador;

/**
*
* DT_AMPLIACION_FECHA REPOSITORIO INTERFACE: LISTA DE AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAmpliacionFechaDao {
	void saveDtAmpliacionFecha(DtAmpliacionFecha param);
	void updateDtAmpliacionFecha(DtAmpliacionFecha param);
	void deleteDtAmpliacionFecha(DtAmpliacionFecha param);
	List<DtAmpliacionFecha> getAllDtAmpliacionFecha();
	DtAmpliacionFecha getDtAmpliacionFecha(Long idAutorizacion);
	List<DtAmpliacionFecha> getNativeSQLDtAmpliacionFecha(String queryString, Object[] params);
	List<DtAmpliacionFecha> getActivasDtAmpliacionFecha();
	List<DtAmpliacionFecha> getActivasDtAmpliacionFechaCero();
	List<DtAmpliacionFecha> getDesactivasDtAmpliacionFecha();
	Long getMaxIdVal();
	
	List<DtAmpliacionFecha> getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<DtAmpliacionFecha> getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado);
	
	DtAmpliacionFecha getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,int mesAutorizacion);//PURIBE 01022024 - INICIO-->
	DtAmpliacionFecha find(Long tipoFechaCorte, Long idSede, Long idSistemaAdministrativo, int mesAutorizacion) throws Validador;//MPINARES 24012023 - INICIO
}