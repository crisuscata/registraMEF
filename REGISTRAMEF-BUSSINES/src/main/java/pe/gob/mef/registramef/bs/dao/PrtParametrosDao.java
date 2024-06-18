package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.PrtParametros;

/**
*
* PRT_PARAMETROS REPOSITORIO INTERFACE: ALMACENA LOS PARAMETROS REGISTRADOS EN EL SISTEMA "PARÁMETROS"
*
*
* @author  Carlos Aguilar
* @version 2.0, 18/12/2023 18:48
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 18/12/2023 18:48         / Creación de la clase  /
* 
*/
public interface PrtParametrosDao {
	void savePrtParametros(PrtParametros param);
	void updatePrtParametros(PrtParametros param);
	void deletePrtParametros(PrtParametros param);
	List<PrtParametros> getAllPrtParametros();
	PrtParametros getPrtParametros(Long idparametro);
	List<PrtParametros> getNativeSQLPrtParametros(String queryString, Object[] params);
	List<PrtParametros> getActivasPrtParametros();
	List<PrtParametros> getActivasPrtParametrosCero();
	List<PrtParametros> getDesactivasPrtParametros();
	Long getMaxIdVal();
	
	List<PrtParametros> getXFiltro(Long idpadre,String descripcion, int iniciar, int max);
	List<PrtParametros> getXFiltro(Long idpadre,String descripcion);
	long getTotalXFiltro(Long idpadre,String descripcion);
	List<PrtParametros> getListaIdparametro();
//	List<PrtParametros> getHijosXDescripcion(String descripcionpadre);
	List<PrtParametros> getHijosXDescripcion(String descripcionpadre);//MPINARES 24012023 - INICIO
}