package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsIndicador;

/**
*
* MS_INDICADOR REPOSITORIO INTERFACE: LISTA DE LOS INDICADORES REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsIndicadorDao {
	void saveMsIndicador(MsIndicador param);
	void updateMsIndicador(MsIndicador param);
	void deleteMsIndicador(MsIndicador param);
	List<MsIndicador> getAllMsIndicador();
	MsIndicador getMsIndicador(Long idIndicador);
	List<MsIndicador> getNativeSQLMsIndicador(String queryString, Object[] params);
	List<MsIndicador> getActivasMsIndicador();
	List<MsIndicador> getActivasMsIndicadorCero();
	List<MsIndicador> getDesactivasMsIndicador();
	Long getMaxIdVal();
	
	List<MsIndicador> getXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsIndicador> getXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado);
	List<MsIndicador> getListaIdIndicador();
	
}