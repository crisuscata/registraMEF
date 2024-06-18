package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsSubtema;

/**
*
* MS_SUBTEMA REPOSITORIO INTERFACE: LISTA DE LOS SUBTEMAS REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsSubtemaDao {
	void saveMsSubtema(MsSubtema param);
	void updateMsSubtema(MsSubtema param);
	void deleteMsSubtema(MsSubtema param);
	List<MsSubtema> getAllMsSubtema();
	MsSubtema getMsSubtema(Long idSubtema);
	List<MsSubtema> getNativeSQLMsSubtema(String queryString, Object[] params);
	List<MsSubtema> getActivasMsSubtema();
	List<MsSubtema> getActivasMsSubtemaCero();
	List<MsSubtema> getDesactivasMsSubtema();
	Long getMaxIdVal();
	
	List<MsSubtema> getXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsSubtema> getXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	List<MsSubtema> getListaIdSubtema();
	//MPINARES 24012023 - INICIO
	List<MsSubtema> getSubTemaByIdSistemaAdminTema(Long idTema);
//	Long getEstadoNuevo();
//	Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
}