package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsUsuarios;

/**
*
* MS_USUARIOS REPOSITORIO INTERFACE: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS INTERNOS"
*
*
* @author  Carlos Aguilar
* @version 2.0, 18/12/2023 18:48
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 18/12/2023 18:48         / Creación de la clase  /
* 
*/
public interface MsUsuariosDao {
	void saveMsUsuarios(MsUsuarios param);
	void updateMsUsuarios(MsUsuarios param);
	void deleteMsUsuarios(MsUsuarios param);
	List<MsUsuarios> getAllMsUsuarios();
	MsUsuarios getMsUsuarios(Long idusuario);
	List<MsUsuarios> getNativeSQLMsUsuarios(String queryString, Object[] params);
	List<MsUsuarios> getActivasMsUsuarios();
	List<MsUsuarios> getActivasMsUsuariosCero();
	List<MsUsuarios> getDesactivasMsUsuarios();
	Long getMaxIdVal();
	
	List<MsUsuarios> getXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr, int iniciar, int max);
	List<MsUsuarios> getXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr);
	long getTotalXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr);
	List<MsUsuarios> getByIdMsUsuarios(String username);
	List<MsUsuarios> getXRoles(String[] roles);
	List<MsUsuarios> getXRoles(String[] roles, Long idunidad);
	List<MsUsuarios> getListaIdusuario();
	Long getTotalRegistros();
	
	List<MsUsuarios> getMsUsuarioByIdSedexUsername(Long sede,String usuario); 	//PURIBE 22032024 - INICIO--
	
}