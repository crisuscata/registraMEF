package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtCapacitacion;

/**
*
* DT_CAPACITACION REPOSITORIO INTERFACE: LISTA DE LOS DATOS REGISTRADOS EN UNA CAPACITACIÓN
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapacitacionDao {
	void saveDtCapacitacion(DtCapacitacion param);
	void updateDtCapacitacion(DtCapacitacion param);
	void deleteDtCapacitacion(DtCapacitacion param);
	List<DtCapacitacion> getAllDtCapacitacion();
	DtCapacitacion getDtCapacitacion(Long idCapacitacion);
	List<DtCapacitacion> getNativeSQLDtCapacitacion(String queryString, Object[] params);
	List<DtCapacitacion> getActivasDtCapacitacion();
	List<DtCapacitacion> getActivasDtCapacitacionCero();
	List<DtCapacitacion> getDesactivasDtCapacitacion();
	Long getMaxIdVal();
	
	List<DtCapacitacion> getXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic, int iniciar, int max);
	List<DtCapacitacion> getXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic);
	long getTotalXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic);
	
	//MPINARES 14022024 - INICIO
		List<DtCapacitacion> getXFiltroV(Date fechaInicio, Date fechaFin,Long idProgramacion);
//		Long getEstadoNuevo(); 
//		Long getEstadoEliminado(); 
		List<DtCapacitacion> getDtcapaXIDPadre(Long idCapaPadre);
		//MPINARES 14022024 - FIN
		List<DtCapacitacion> getXFiltroV2(Date fechaInicio, Date fechaFin,Long idProgramacion, Long idSede,Long idSistAdm, Long idUsuario);
	
}