package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsAlerta;

/**
*
* MS_ALERTA REPOSITORIO INTERFACE: LISTA DE LAS ALERTAS GENERADAS EN EL SISTMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsAlertaDao {
	void saveMsAlerta(MsAlerta param);
	void updateMsAlerta(MsAlerta param);
	void deleteMsAlerta(MsAlerta param);
	List<MsAlerta> getAllMsAlerta();
	MsAlerta getMsAlerta(Long idAlerta);
	List<MsAlerta> getNativeSQLMsAlerta(String queryString, Object[] params);
	List<MsAlerta> getActivasMsAlerta();
	List<MsAlerta> getActivasMsAlertaCero();
	List<MsAlerta> getDesactivasMsAlerta();
	Long getMaxIdVal();
	
	List<MsAlerta> getXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsAlerta> getXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	
}