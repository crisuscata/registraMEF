package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCargosUsuexterDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCargosUsuexter;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CARGOS_USUEXTER REPOSITORIO: LISTA DE LOS CARGOS DE LOS USUARIOS EXTERNOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCargosUsuexterDaoImp extends
		AbstractJpaCRUDDao<DtCargosUsuexter, Long> implements
		DtCargosUsuexterDao {

	private static final Logger log = Logger.getLogger(DtCargosUsuexterDaoImp.class.getName());

	public DtCargosUsuexterDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCargosUsuexterDaoImp");
	}
	
	public DtCargosUsuexterDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCargosUsuexterDaoImp");
	}
	
	@Transactional
	public void saveDtCargosUsuexter(DtCargosUsuexter param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCargosUsuexter(DtCargosUsuexter param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCargosUsuexter(DtCargosUsuexter param) {
		super.delete(param);
	}

	public List<DtCargosUsuexter> getAllDtCargosUsuexter() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCargosUsuexter getDtCargosUsuexter(Long id) {
		return super.findById(id);
	}

	public List<DtCargosUsuexter> getNativeSQLDtCargosUsuexter(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCargosUsuexter> getDomainClass() {
		return DtCargosUsuexter.class;
	}

	public List<DtCargosUsuexter> getActivasDtCargosUsuexter() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCargosUsuexter> getActivasDtCargosUsuexterCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCargosUsuexter> getDesactivasDtCargosUsuexter() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCargosUsuexter> getByIdDtCargosUsuexter(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCargoUsuexter = ? order by t.idCargoUsuexter asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCargosUsuexter> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCargoUsuexter) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCargosUsuexter> getXFiltro(Long idUsuextEnti,Long idCargo) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idUsuextEnti != null) {
			sb.append("and t.idUsuextEnti = ? ");
			hs.add(idUsuextEnti);
		}
		if (idCargo != null) {
			sb.append("and t.idCargo = ? ");
			hs.add(idCargo);
		}		
		// sb.append("order by t.idCargoUsuexter desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCargosUsuexter> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCargosUsuexter> getXFiltro(Long idUsuextEnti,Long idCargo, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idUsuextEnti != null) {
					sb.append("and t.idUsuextEnti = ? ");
					hs.add(idUsuextEnti);
				}
				if (idCargo != null) {
					sb.append("and t.idCargo = ? ");
					hs.add(idCargo);
				}
		// sb.append("order by t.idCargoUsuexter desc ");

		List<DtCargosUsuexter> lista = null;
		if (hs.size() > 0) {
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			lista = super.findLimitedResult(sb.toString(), iniciar, (max + 1), param);
			return lista;
		} else {
			lista = super.findLimitedResult(sb.toString(), iniciar, (max + 1));
			return lista;
		}
	}

	@Override
	public long getTotalXFiltro(Long idUsuextEnti,Long idCargo) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCargoUsuexter) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idUsuextEnti != null) {
					sb.append("and t.idUsuextEnti = ? ");
					hs.add(idUsuextEnti);
				}
				if (idCargo != null) {
					sb.append("and t.idCargo = ? ");
					hs.add(idCargo);
				}
						
		if (hs.size() > 0) {
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			Object o = super.findUniqueResultObject(sb.toString(), param);
			long retorno = 0;
			if (o instanceof java.lang.Long) {
				retorno = ((Long) o).longValue();
			}
			return retorno;
		} else {
			Object o = super.findUniqueResultObject(sb.toString());
			long retorno = 0;
			if (o instanceof java.lang.Long) {
				retorno = ((Long) o).longValue();
			}
			return retorno;
		}
	}
}