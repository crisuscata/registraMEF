package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsSedes;

/**
*
* MS_SEDES REPOSITORIO INTERFACE: LISTA LAS SEDES REGISTRADAS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsSedesDao {
	void saveMsSedes(MsSedes param);
	void updateMsSedes(MsSedes param);
	void deleteMsSedes(MsSedes param);
	List<MsSedes> getAllMsSedes();
	MsSedes getMsSedes(Long idSede);
	List<MsSedes> getNativeSQLMsSedes(String queryString, Object[] params);
	List<MsSedes> getActivasMsSedes();
	List<MsSedes> getActivasMsSedesCero();
	List<MsSedes> getDesactivasMsSedes();
	Long getMaxIdVal();
	
	List<MsSedes> getXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsSedes> getXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado);
	List<MsSedes> getListaIdSede();
	
}