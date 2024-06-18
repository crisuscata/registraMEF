package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.MsPaises;

/**
*
* MS_PAISES REPOSITORIO INTERFACE: LISTA DE LOS PAÍSES REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsPaisesDao {
	void saveMsPaises(MsPaises param);
	void updateMsPaises(MsPaises param);
	void deleteMsPaises(MsPaises param);
	List<MsPaises> getAllMsPaises();
	MsPaises getMsPaises(Long idpais);
	List<MsPaises> getNativeSQLMsPaises(String queryString, Object[] params);
	List<MsPaises> getActivasMsPaises();
	List<MsPaises> getActivasMsPaisesCero();
	List<MsPaises> getDesactivasMsPaises();
	Long getMaxIdVal();
	
	List<MsPaises> getXFiltro(String paisNombre,String acronimo,Long estado, int iniciar, int max);
	List<MsPaises> getXFiltro(String paisNombre,String acronimo,Long estado);
	long getTotalXFiltro(String paisNombre,String acronimo,Long estado);
	
	MsPaises getByNombreMsPaises(String nombre);//MPINARES 24012023 - INICIO
}