package pe.gob.mef.registramef.bs.dao;

import java.sql.Timestamp;
import java.util.List;

import pe.gob.mef.registramef.bs.domain.DtUsuarioExterno;

/**
*
* DT_USUARIO_EXTERNO REPOSITORIO INTERFACE: LISTA DE LOS USUARIOS EXTERNOS REGISTRADOS EN EL SISTEMA
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtUsuarioExternoDao {
	void saveDtUsuarioExterno(DtUsuarioExterno param);
	void updateDtUsuarioExterno(DtUsuarioExterno param);
	void deleteDtUsuarioExterno(DtUsuarioExterno param);
	List<DtUsuarioExterno> getAllDtUsuarioExterno();
	DtUsuarioExterno getDtUsuarioExterno(Long idUsuexterno);
	List<DtUsuarioExterno> getNativeSQLDtUsuarioExterno(String queryString, Object[] params);
	List<DtUsuarioExterno> getActivasDtUsuarioExterno();
	List<DtUsuarioExterno> getActivasDtUsuarioExternoCero();
	List<DtUsuarioExterno> getDesactivasDtUsuarioExterno();
	Long getMaxIdVal();
	
	List<DtUsuarioExterno> getXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado, int iniciar, int max);
	List<DtUsuarioExterno> getXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado);
	List<DtUsuarioExterno> getXFiltro(String nombre,String aPaterno,String aMaterno,String direccion,Integer codDpto,Integer codProv,Integer codDistr,String numDocum);//PURIBE 14032024 - INICIO-->
	long getTotalXFiltro(String aPaterno,String aMaterno,String nombre,Long numDocu,String correo,Long telefFijo,Long telefCell,Timestamp fechaModif,Long estado);
	long getTotalXFiltro(String nombre,String aPaterno,String aMaterno,String direccion,Integer codDpto,Integer codProv,Integer codDistr,String numDocum);//PURIBE 14032024 - INICIO-->
	
	List<DtUsuarioExterno> getListaNombre(String nombre);
	List<DtUsuarioExterno> getDtUsuarioExtByNombreapellido(String[] nombreapellido);
	
}