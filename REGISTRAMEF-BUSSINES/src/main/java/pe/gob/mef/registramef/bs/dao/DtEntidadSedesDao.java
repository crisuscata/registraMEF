package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtEntidadSedes;

/**
*
* DT_ENTIDAD_SEDES REPOSITORIO INTERFACE: LISTA DE LAS DISTINTAS SEDES ASIGNADAS A LA ENTIDAD
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEntidadSedesDao {
	void saveDtEntidadSedes(DtEntidadSedes param);
	void updateDtEntidadSedes(DtEntidadSedes param);
	void deleteDtEntidadSedes(DtEntidadSedes param);
	List<DtEntidadSedes> getAllDtEntidadSedes();
	DtEntidadSedes getDtEntidadSedes(Long idEntiSed);
	List<DtEntidadSedes> getNativeSQLDtEntidadSedes(String queryString, Object[] params);
	List<DtEntidadSedes> getActivasDtEntidadSedes();
	List<DtEntidadSedes> getActivasDtEntidadSedesCero();
	List<DtEntidadSedes> getDesactivasDtEntidadSedes();
	Long getMaxIdVal();
	
	List<DtEntidadSedes> getXFiltro(Long idEntidad,Long idSede, int iniciar, int max);
	List<DtEntidadSedes> getXFiltro(Long idEntidad,Long idSede);
	long getTotalXFiltro(Long idEntidad,Long idSede);
	
}