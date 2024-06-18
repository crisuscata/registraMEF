package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsLocal;

/**
*
* MS_LOCAL REPOSITORIO INTERFACE: LISTA DE LOS LOCALES REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsLocalDao {
	void saveMsLocal(MsLocal param);
	void updateMsLocal(MsLocal param);
	void deleteMsLocal(MsLocal param);
	List<MsLocal> getAllMsLocal();
	MsLocal getMsLocal(Long idLocal);
	List<MsLocal> getNativeSQLMsLocal(String queryString, Object[] params);
	List<MsLocal> getActivasMsLocal();
	List<MsLocal> getActivasMsLocalCero();
	List<MsLocal> getDesactivasMsLocal();
	Long getMaxIdVal();
	
	List<MsLocal> getXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsLocal> getXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado);
	List<MsLocal> getListaIdLocal();
	//MPINARES 14022024 - INICIO
//		Long getEstadoEliminado();
//		void setEstadoEliminado(Long estadoEliminado);
		List<MsLocal> getLocalByIdSede(Long idSede);
		//MPINARES 14022024 - FIN
	
}