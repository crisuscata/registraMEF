package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.MsUbigeo;
import pe.gob.mef.registramef.bs.domain.MsUbigeoId;

/**
*
* MS_UBIGEO REPOSITORIO INTERFACE: LISTA EL UBIGEO (DEPARTAMENTO
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface MsUbigeoDao {
	void saveMsUbigeo(MsUbigeo param);
	void updateMsUbigeo(MsUbigeo param);
	void deleteMsUbigeo(MsUbigeo param);
	List<MsUbigeo> getAllMsUbigeo();
	MsUbigeo getMsUbigeo(MsUbigeoId id);
	List<MsUbigeo> getNativeSQLMsUbigeo(String queryString, Object[] params);
	List<MsUbigeo> getActivasMsUbigeo();
	List<MsUbigeo> getActivasMsUbigeoCero();
	List<MsUbigeo> getDesactivasMsUbigeo();
	Long getMaxIdVal();
	
	List<MsUbigeo> getXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<MsUbigeo> getXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado);
	List<MsUbigeo> getDepartamentos();
	List<MsUbigeo> getProvincias(Integer id_dpto);
	List<MsUbigeo> getDistritos(Integer id_dpto, Integer id_prov);
	MsUbigeo getDepartamentosXNombre(String descripcion);
	MsUbigeo getProvinciasXNombre(Integer id_dpto, String descripcion);
	MsUbigeo getDistritosXNombre(Integer id_dpto, Integer id_prov, String descripcion);
	Integer getMaxIdValcodDpto();
	Integer getMaxIdValcodProv(Integer codDpto);
	Integer getMaxIdValcodDistr(Integer codDpto, Integer codProv);
	
	//MPINARES 14022024 - INICIO
		MsUbigeo getMsUbigeoByCodes(Long idDepart, Long idProv, Long idDist);
		//MPINARES 14022024 - FIN
		long getTotalXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr);
		List<MsUbigeo> getXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr, int iniciar, int max);
		List<MsUbigeo> getXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr);
		Integer getMaxIdVAlCodDistr(Integer codDpto,Integer codProv);
		Integer getMaxIdVAlCodProv(Integer codDpto);
		Integer getMaxIdVAlCodDept();
	
}