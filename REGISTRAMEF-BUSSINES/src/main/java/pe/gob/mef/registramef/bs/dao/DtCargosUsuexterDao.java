package pe.gob.mef.registramef.bs.dao;

import java.util.List;
import pe.gob.mef.registramef.bs.domain.DtCargosUsuexter;

/**
*
* DT_CARGOS_USUEXTER REPOSITORIO INTERFACE: LISTA DE LOS CARGOS DE LOS USUARIOS EXTERNOS
*
*
* @author  Carlos Aguilar
* @version 2.0, 06/03/2024 23:27
* 
*          /----------Nombre------------------------/---------fecha------/----------Motivo---------/
*          /Carlos Aguilar Chamochumbi             / 06/03/2024 23:27         / Creación de la clase  /
* 
*/
public interface DtCargosUsuexterDao {
	void saveDtCargosUsuexter(DtCargosUsuexter param);
	void updateDtCargosUsuexter(DtCargosUsuexter param);
	void deleteDtCargosUsuexter(DtCargosUsuexter param);
	List<DtCargosUsuexter> getAllDtCargosUsuexter();
	DtCargosUsuexter getDtCargosUsuexter(Long idCargoUsuexter);
	List<DtCargosUsuexter> getNativeSQLDtCargosUsuexter(String queryString, Object[] params);
	List<DtCargosUsuexter> getActivasDtCargosUsuexter();
	List<DtCargosUsuexter> getActivasDtCargosUsuexterCero();
	List<DtCargosUsuexter> getDesactivasDtCargosUsuexter();
	Long getMaxIdVal();
	
	List<DtCargosUsuexter> getXFiltro(Long idUsuextEnti,Long idCargo, int iniciar, int max);
	List<DtCargosUsuexter> getXFiltro(Long idUsuextEnti,Long idCargo);
	long getTotalXFiltro(Long idUsuextEnti,Long idCargo);
	List<DtCargosUsuexter> getByIdDtCargosUsuexter(Long id);
	
}