package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCapaUsuexternos;

/**
*
* DT_CAPA_USUEXTERNOS REPOSITORIO INTERFACE: LISTA DE LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACIÓN
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCapaUsuexternosDao {
	void saveDtCapaUsuexternos(DtCapaUsuexternos param);
	void updateDtCapaUsuexternos(DtCapaUsuexternos param);
	void deleteDtCapaUsuexternos(DtCapaUsuexternos param);
	List<DtCapaUsuexternos> getAllDtCapaUsuexternos();
	DtCapaUsuexternos getDtCapaUsuexternos(Long idCapaUsuext);
	List<DtCapaUsuexternos> getNativeSQLDtCapaUsuexternos(String queryString, Object[] params);
	List<DtCapaUsuexternos> getActivasDtCapaUsuexternos();
	List<DtCapaUsuexternos> getActivasDtCapaUsuexternosCero();
	List<DtCapaUsuexternos> getDesactivasDtCapaUsuexternos();
	Long getMaxIdVal();
	
	List<DtCapaUsuexternos> getXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad, int iniciar, int max);
	List<DtCapaUsuexternos> getXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad);
	long getTotalXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad);
	List<DtCapaUsuexternos> getByIdCapacDtCapaUsuariosExt(Long idCapacitacion);
	
}