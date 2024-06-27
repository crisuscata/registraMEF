package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.MsProyectoInversion;

/**
*
* MS_PROYECTO_INVERSION REPOSITORIO INTERFACE: LISTA DE LOS DATOS DE PROYECTOS DE INVERSIÓN
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsProyectoInversionDao {
	void saveMsProyectoInversion(MsProyectoInversion param);
	void updateMsProyectoInversion(MsProyectoInversion param);
	void deleteMsProyectoInversion(MsProyectoInversion param);
	List<MsProyectoInversion> getAllMsProyectoInversion();
	MsProyectoInversion getMsProyectoInversion(Long idProyecto);
	List<MsProyectoInversion> getNativeSQLMsProyectoInversion(String queryString, Object[] params);
	List<MsProyectoInversion> getActivasMsProyectoInversion();
	List<MsProyectoInversion> getActivasMsProyectoInversionCero();
	List<MsProyectoInversion> getDesactivasMsProyectoInversion();
	Long getMaxIdVal();
	
	List<MsProyectoInversion> getXFiltro(String codigo,String nombre,Long idSede, int iniciar, int max);
	List<MsProyectoInversion> getXFiltro(String codigo,String nombre,Long idSede);
	long getTotalXFiltro(String codigo,String nombre,Long idSede);
	List<MsProyectoInversion> getListaNombre(String nombre);
	public MsProyectoInversion findByPk(Long id);//CUSCATA - 18062024
	
}