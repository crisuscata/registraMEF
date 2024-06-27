package pe.gob.mef.registramef.bs.dao;

import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsRoles;
import pe.gob.mef.registramef.bs.exception.Validador;

/**
*
* MS_ROLES REPOSITORIO INTERFACE: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
*
*
* @author  Carlos Aguilar
* @version 2.0, 18/12/2023 18:48
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 18/12/2023 18:48         / Creación de la clase  /
* 
*/
public interface MsRolesDao {
	void saveMsRoles(MsRoles param);
	void updateMsRoles(MsRoles param);
	void deleteMsRoles(MsRoles param);
	List<MsRoles> getAllMsRoles();
	MsRoles getMsRoles(Long idrol);
	List<MsRoles> getNativeSQLMsRoles(String queryString, Object[] params);
	List<MsRoles> getActivasMsRoles();
	List<MsRoles> getActivasMsRolesCero();
	List<MsRoles> getDesactivasMsRoles();
	Long getMaxIdVal();
	
	List<MsRoles> getXFiltro(String username,String rol, int iniciar, int max);
	List<MsRoles> getXFiltro(String username,String rol);
	long getTotalXFiltro(String username,String rol);
	MsRoles getXUserRol(String username, String rol);
	public boolean isRolAdministradorOGC(Long idUsuario) throws Validador;//MPINARES 24012023 - INICIO
	List<MsRoles> getXFiltro(String username);
}