package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsMeta;

/**
*
* MS_META REPOSITORIO INTERFACE: LISTA DE LAS METAS CON SUS VALORES
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsMetaDao {
	void saveMsMeta(MsMeta param);
	void updateMsMeta(MsMeta param);
	void deleteMsMeta(MsMeta param);
	List<MsMeta> getAllMsMeta();
	MsMeta getMsMeta(Long idMeta);
	List<MsMeta> getNativeSQLMsMeta(String queryString, Object[] params);
	List<MsMeta> getActivasMsMeta();
	List<MsMeta> getActivasMsMetaCero();
	List<MsMeta> getDesactivasMsMeta();
	Long getMaxIdVal();
	
	List<MsMeta> getXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsMeta> getXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	
}