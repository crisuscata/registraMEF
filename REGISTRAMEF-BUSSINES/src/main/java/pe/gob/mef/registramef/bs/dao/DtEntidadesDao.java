package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtEntidades;

/**
*
* DT_ENTIDADES REPOSITORIO INTERFACE: LISTA DE LAS ENTIDADES REGISTRADAS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtEntidadesDao {
	void saveDtEntidades(DtEntidades param);
	void updateDtEntidades(DtEntidades param);
	void deleteDtEntidades(DtEntidades param);
	List<DtEntidades> getAllDtEntidades();
	DtEntidades getDtEntidades(Long idEntidad);
	List<DtEntidades> getNativeSQLDtEntidades(String queryString, Object[] params);
	List<DtEntidades> getActivasDtEntidades();
	List<DtEntidades> getActivasDtEntidadesCero();
	List<DtEntidades> getDesactivasDtEntidades();
	Long getMaxIdVal();
	
	List<DtEntidades> getXFiltro(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado, int iniciar, int max);
	List<DtEntidades> getXFiltro2(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado);
	List<DtEntidades> getXFiltro(String codEjec,String razSocial,Long ruc,Long idTipo,Long idCaract,Integer codDpto,Integer codProv,Integer codDistr,Long idSistAdmi,String geozona);//PURIBE 14032024 -INICIO-->
	long getTotalXFiltro(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado);
	List<DtEntidades> getListaRazSocial(String razSocial);
	List<DtEntidades> getListaIdEntidad();
	//MPINARES 24012023 - INICIO
	List<DtEntidades> getListaRasonsocial(String razonsocial) ;
	List<DtEntidades> getListaRasonsocialXSisAdmin(String razonsocial, Long idSistAdmi);
//	Long getEstadoNuevo();
//	Long getEstadoEliminado();
	//MPINARES 24012023 - FIN
	List<DtEntidades> getListaRasonsocialXSisAdminSede(String razonsocial, Long idSistAdmi, Long idSede);
}