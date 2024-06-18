package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.MsAlertaCargoUser;

/**
*
* MS_ALERTA_CARGO_USER REPOSITORIO INTERFACE: LISTA DE LOS CARGOS DE LOS USUARIOS EN LAS ALERTAS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsAlertaCargoUserDao {
	void saveMsAlertaCargoUser(MsAlertaCargoUser param);
	void updateMsAlertaCargoUser(MsAlertaCargoUser param);
	void deleteMsAlertaCargoUser(MsAlertaCargoUser param);
	List<MsAlertaCargoUser> getAllMsAlertaCargoUser();
	MsAlertaCargoUser getMsAlertaCargoUser(Long idalertaCargo);
	List<MsAlertaCargoUser> getNativeSQLMsAlertaCargoUser(String queryString, Object[] params);
	List<MsAlertaCargoUser> getActivasMsAlertaCargoUser();
	List<MsAlertaCargoUser> getActivasMsAlertaCargoUserCero();
	List<MsAlertaCargoUser> getDesactivasMsAlertaCargoUser();
	Long getMaxIdVal();
	
	List<MsAlertaCargoUser> getXFiltro(Long idalerta,Long idcargo, int iniciar, int max);
	List<MsAlertaCargoUser> getXFiltro(Long idalerta,Long idcargo);
	long getTotalXFiltro(Long idalerta,Long idcargo);
	
}