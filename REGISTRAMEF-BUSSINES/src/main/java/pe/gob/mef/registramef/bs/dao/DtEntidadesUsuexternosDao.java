package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtEntidadesUsuexternos;

/**
*
* DT_ENTIDADES_USUEXTERNOS REPOSITORIO INTERFACE: LISTA DE LAS ENTIDADES A LA QUE PERTENECE EL USUARIO EXTERNO
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEntidadesUsuexternosDao {
	void saveDtEntidadesUsuexternos(DtEntidadesUsuexternos param);
	void updateDtEntidadesUsuexternos(DtEntidadesUsuexternos param);
	void deleteDtEntidadesUsuexternos(DtEntidadesUsuexternos param);
	List<DtEntidadesUsuexternos> getAllDtEntidadesUsuexternos();
	DtEntidadesUsuexternos getDtEntidadesUsuexternos(Long idUsuextEnti);
	List<DtEntidadesUsuexternos> getNativeSQLDtEntidadesUsuexternos(String queryString, Object[] params);
	List<DtEntidadesUsuexternos> getActivasDtEntidadesUsuexternos();
	List<DtEntidadesUsuexternos> getActivasDtEntidadesUsuexternosCero();
	List<DtEntidadesUsuexternos> getDesactivasDtEntidadesUsuexternos();
	List<DtEntidadesUsuexternos> getByIdDtEntidadesUsuexternos(Long idUsuextEnti);	//PURIBE 14032024 - INICIO-->
	List<DtEntidadesUsuexternos> getXFiltroidUsuexterno(Long idUsuexterno);	//PURIBE 14032024 - INICIO-->
	Long getMaxIdVal();
	
	List<DtEntidadesUsuexternos> getXFiltro(Long idEntidad,Long idUsuexterno, int iniciar, int max);
	List<DtEntidadesUsuexternos> getXFiltro(Long idEntidad,Long idUsuexterno);
	long getTotalXFiltro(Long idEntidad,Long idUsuexterno);
	List<DtEntidadesUsuexternos> getDtEntidadUsuarioByUser(Long idUsuexterno);
	Long getEstadoEliminado();
}