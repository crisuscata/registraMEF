package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtAnexo;

/**
*
* DT_ANEXO REPOSITORIO INTERFACE: LISTA DE LOS DOCUMENTOS ANEXADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtAnexoDao {
	void saveDtAnexo(DtAnexo param);
	void updateDtAnexo(DtAnexo param);
	void deleteDtAnexo(DtAnexo param);
	List<DtAnexo> getAllDtAnexo();
	DtAnexo getDtAnexo(Long idAnexo);
	List<DtAnexo> getNativeSQLDtAnexo(String queryString, Object[] params);
	List<DtAnexo> getActivasDtAnexo();
	List<DtAnexo> getActivasDtAnexoCero();
	List<DtAnexo> getDesactivasDtAnexo();
	Long getMaxIdVal();
	
	List<DtAnexo> getXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro, int iniciar, int max);
	List<DtAnexo> getXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro);
	long getTotalXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro);
	
}