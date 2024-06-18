package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.TaFeriadosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.TaFeriados;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * TA_FERIADOS REPOSITORIO: TABLA EN LA QUE SE REGISTRAN TODOS LOS DIAS FERIADOS DEL AÑO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class TaFeriadosDaoImp extends
		AbstractJpaCRUDDao<TaFeriados, Timestamp> implements
		TaFeriadosDao {

	private static final Logger log = Logger.getLogger(TaFeriadosDaoImp.class.getName());

	public TaFeriadosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA TaFeriadosDaoImp");
	}
	
	public TaFeriadosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA TaFeriadosDaoImp");
	}
	
	@Transactional
	public void saveTaFeriados(TaFeriados param) {
		super.save(param);
	}

	@Transactional
	public void updateTaFeriados(TaFeriados param) {
		super.update(param);
	}

	@Transactional
	public void deleteTaFeriados(TaFeriados param) {
		super.delete(param);
	}

	public List<TaFeriados> getAllTaFeriados() {
		return super.find("from " + getDomainClass().getName());
	}

	public TaFeriados getTaFeriados(Timestamp id) {
		return super.findById(id);
	}

	public List<TaFeriados> getNativeSQLTaFeriados(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<TaFeriados> getDomainClass() {
		return TaFeriados.class;
	}

	public List<TaFeriados> getActivasTaFeriados() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<TaFeriados> getActivasTaFeriadosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<TaFeriados> getDesactivasTaFeriados() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<TaFeriados> getByIdTaFeriados(Timestamp id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.feFecha = ? order by t.feFecha asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<TaFeriados> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.feFecha) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<TaFeriados> getXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (feDesc != null && feDesc.trim().length() > 0) {
			sb.append("and t.feDesc = ? ");
			hs.add(feDesc);
		}
		if (feFchmod != null) {
			sb.append("and t.feFchmod = ? ");
			hs.add(feFchmod);
		}
		if (feFchcrear != null) {
			sb.append("and t.feFchcrear = ? ");
			hs.add(feFchcrear);
		}
		if (feEstado != null) {
			sb.append("and t.feEstado = ? ");
			hs.add(feEstado);
		}		
		// sb.append("order by t.feFecha desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<TaFeriados> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<TaFeriados> getXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (feDesc != null && feDesc.trim().length() > 0) {
					sb.append("and t.feDesc = ? ");
					hs.add(feDesc);
				}
				if (feFchmod != null) {
					sb.append("and t.feFchmod = ? ");
					hs.add(feFchmod);
				}
				if (feFchcrear != null) {
					sb.append("and t.feFchcrear = ? ");
					hs.add(feFchcrear);
				}
				if (feEstado != null) {
					sb.append("and t.feEstado = ? ");
					hs.add(feEstado);
				}
		// sb.append("order by t.feFecha desc ");

		List<TaFeriados> lista = null;
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
	public long getTotalXFiltro(String feDesc,Timestamp feFchmod,Timestamp feFchcrear,Integer feEstado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.feFecha) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (feDesc != null && feDesc.trim().length() > 0) {
					sb.append("and t.feDesc = ? ");
					hs.add(feDesc);
				}
				if (feFchmod != null) {
					sb.append("and t.feFchmod = ? ");
					hs.add(feFchmod);
				}
				if (feFchcrear != null) {
					sb.append("and t.feFchcrear = ? ");
					hs.add(feFchcrear);
				}
				if (feEstado != null) {
					sb.append("and t.feEstado = ? ");
					hs.add(feEstado);
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