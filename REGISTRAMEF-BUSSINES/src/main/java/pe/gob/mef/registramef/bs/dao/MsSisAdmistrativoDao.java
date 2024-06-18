package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsSisAdmistrativo;

/**
*
* MS_SIS_ADMISTRATIVO REPOSITORIO INTERFACE: LISTA DE LOS SISTEMAS ADMINISTRATIVOS REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsSisAdmistrativoDao {
	void saveMsSisAdmistrativo(MsSisAdmistrativo param);
	void updateMsSisAdmistrativo(MsSisAdmistrativo param);
	void deleteMsSisAdmistrativo(MsSisAdmistrativo param);
	List<MsSisAdmistrativo> getAllMsSisAdmistrativo();
	MsSisAdmistrativo getMsSisAdmistrativo(Long idSistAdmi);
	List<MsSisAdmistrativo> getNativeSQLMsSisAdmistrativo(String queryString, Object[] params);
	List<MsSisAdmistrativo> getActivasMsSisAdmistrativo();
	List<MsSisAdmistrativo> getActivasMsSisAdmistrativoCero();
	List<MsSisAdmistrativo> getDesactivasMsSisAdmistrativo();
	Long getMaxIdVal();
	
	List<MsSisAdmistrativo> getXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsSisAdmistrativo> getXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	List<MsSisAdmistrativo> getListaIdSistAdmi();
	
}