package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtVisitas;

/**
*
* DT_VISITAS REPOSITORIO INTERFACE: LISTA DE LOS DATOS REGISTRADOS EN UNA VISITA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtVisitasDao {
	void saveDtVisitas(DtVisitas param);
	void updateDtVisitas(DtVisitas param);
	void deleteDtVisitas(DtVisitas param);
	List<DtVisitas> getAllDtVisitas();
	DtVisitas getDtVisitas(Long idVisita);
	List<DtVisitas> getNativeSQLDtVisitas(String queryString, Object[] params);
	List<DtVisitas> getActivasDtVisitas();
	List<DtVisitas> getActivasDtVisitasCero();
	List<DtVisitas> getDesactivasDtVisitas();
	Long getMaxIdVal();
	
	List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado, int iniciar, int max);
	List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado);
	List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idOrigen,Long idProgramacion,Long idModalidad,Long idTipo,Long idLugar,Long idEntidad,Long idSede,Long idSistAdm,Long idFinancia,Timestamp fechaProgramada,Timestamp fechaInicio,Timestamp fechaFin);// PURIBE 14032024 - INICIO -->
	long getTotalXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado);
	
}