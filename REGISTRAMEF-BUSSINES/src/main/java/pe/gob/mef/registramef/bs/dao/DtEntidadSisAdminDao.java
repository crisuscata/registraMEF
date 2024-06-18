package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtEntidadSisAdmin;

/**
*
* DT_ENTIDAD_SIS_ADMIN REPOSITORIO INTERFACE: LISTA DE LOS SISTEMAS ADMINISTRATIVOS ASIGNADOS A LA ENTIDAD
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEntidadSisAdminDao {
	void saveDtEntidadSisAdmin(DtEntidadSisAdmin param);
	void updateDtEntidadSisAdmin(DtEntidadSisAdmin param);
	void deleteDtEntidadSisAdmin(DtEntidadSisAdmin param);
	List<DtEntidadSisAdmin> getAllDtEntidadSisAdmin();
	DtEntidadSisAdmin getDtEntidadSisAdmin(Long identidadSisadm);
	List<DtEntidadSisAdmin> getNativeSQLDtEntidadSisAdmin(String queryString, Object[] params);
	List<DtEntidadSisAdmin> getActivasDtEntidadSisAdmin();
	List<DtEntidadSisAdmin> getActivasDtEntidadSisAdminCero();
	List<DtEntidadSisAdmin> getDesactivasDtEntidadSisAdmin();
	Long getMaxIdVal();
	
	List<DtEntidadSisAdmin> getXFiltro(Long idEntidad, int iniciar, int max);
	List<DtEntidadSisAdmin> getXFiltro(Long idEntidad);
	long getTotalXFiltro(Long idEntidad);
	
	//MPINARES 24012023 - INICIO
	List<DtEntidadSisAdmin> getDtEntidadSistemaAdminByIdEntity(Long idEntidad);
//	Long getEstadoNuevo();
//	Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
	
}