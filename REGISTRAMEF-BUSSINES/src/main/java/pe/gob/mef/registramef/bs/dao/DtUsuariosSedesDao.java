package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtUsuariosSedes;

/**
*
* DT_USUARIOS_SEDES REPOSITORIO INTERFACE: LISTA DE LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtUsuariosSedesDao {
	void saveDtUsuariosSedes(DtUsuariosSedes param);
	void updateDtUsuariosSedes(DtUsuariosSedes param);
	void deleteDtUsuariosSedes(DtUsuariosSedes param);
	List<DtUsuariosSedes> getAllDtUsuariosSedes();
	DtUsuariosSedes getDtUsuariosSedes(Long idUsuSede);
	List<DtUsuariosSedes> getNativeSQLDtUsuariosSedes(String queryString, Object[] params);
	List<DtUsuariosSedes> getActivasDtUsuariosSedes();
	List<DtUsuariosSedes> getActivasDtUsuariosSedesCero();
	List<DtUsuariosSedes> getDesactivasDtUsuariosSedes();
	Long getMaxIdVal();
	
	List<DtUsuariosSedes> getXFiltro(Long idSede,Long idusuario, int iniciar, int max);
	List<DtUsuariosSedes> getXFiltro(Long idSede,Long idusuario);
	long getTotalXFiltro(Long idSede,Long idusuario);
	
}