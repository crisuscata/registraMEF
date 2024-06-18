package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsTema;

/**
*
* MS_TEMA REPOSITORIO INTERFACE: LISTA DE LOS TEMAS REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsTemaDao {
	void saveMsTema(MsTema param);
	void updateMsTema(MsTema param);
	void deleteMsTema(MsTema param);
	List<MsTema> getAllMsTema();
	MsTema getMsTema(Long idTema);
	List<MsTema> getNativeSQLMsTema(String queryString, Object[] params);
	List<MsTema> getActivasMsTema();
	List<MsTema> getActivasMsTemaCero();
	List<MsTema> getDesactivasMsTema();
	Long getMaxIdVal();
	
	List<MsTema> getXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsTema> getXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	//PURIBE 14032024 - INICIO-->
		List<MsTema> getXFiltro(String descripcion,Long idSistAdmi,Long tipoServicio);
		//PURIBE 14032024 - FIN-->
	long getTotalXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	List<MsTema> getListaIdTema();
	//MPINARES 24012023 - INICIO
	List<MsTema> getTemaByIdSistemaAdmin(Long idSistemaAdmin);
//	Long getEstadoNuevo();
//	Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
}