package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsIndicadorDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsIndicador;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_INDICADOR REPOSITORIO: LISTA DE LOS INDICADORES REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsIndicadorDaoImp extends
		AbstractJpaCRUDDao<MsIndicador, Long> implements
		MsIndicadorDao {

	private static final Logger log = Logger.getLogger(MsIndicadorDaoImp.class.getName());

	public MsIndicadorDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsIndicadorDaoImp");
	}
	
	public MsIndicadorDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsIndicadorDaoImp");
	}
	
	@Transactional
	public void saveMsIndicador(MsIndicador param) {
		super.save(param);
	}

	@Transactional
	public void updateMsIndicador(MsIndicador param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsIndicador(MsIndicador param) {
		super.delete(param);
	}

	public List<MsIndicador> getAllMsIndicador() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsIndicador getMsIndicador(Long id) {
		return super.findById(id);
	}

	public List<MsIndicador> getNativeSQLMsIndicador(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsIndicador> getDomainClass() {
		return MsIndicador.class;
	}

	public List<MsIndicador> getActivasMsIndicador() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsIndicador> getActivasMsIndicadorCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsIndicador> getDesactivasMsIndicador() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsIndicador> getByIdMsIndicador(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idIndicador = ? order by t.idIndicador asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsIndicador> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idIndicador) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsIndicador> getXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (descripcion != null) {
			sb.append("and t.descripcion = ? ");
			hs.add(descripcion);
		}
		if (idObjetvo != null) {
			sb.append("and t.idObjetvo = ? ");
			hs.add(idObjetvo);
		}
		if (idNivlstrat != null) {
			sb.append("and t.idNivlstrat = ? ");
			hs.add(idNivlstrat);
		}
		if (idFactor != null) {
			sb.append("and t.idFactor = ? ");
			hs.add(idFactor);
		}
		if (idFuenteinfor != null) {
			sb.append("and t.idFuenteinfor = ? ");
			hs.add(idFuenteinfor);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idIndicador desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsIndicador> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsIndicador> getXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (descripcion != null) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (idObjetvo != null) {
					sb.append("and t.idObjetvo = ? ");
					hs.add(idObjetvo);
				}
				if (idNivlstrat != null) {
					sb.append("and t.idNivlstrat = ? ");
					hs.add(idNivlstrat);
				}
				if (idFactor != null) {
					sb.append("and t.idFactor = ? ");
					hs.add(idFactor);
				}
				if (idFuenteinfor != null) {
					sb.append("and t.idFuenteinfor = ? ");
					hs.add(idFuenteinfor);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idIndicador desc ");

		List<MsIndicador> lista = null;
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
	public long getTotalXFiltro(String descripcion,Long idObjetvo,Long idNivlstrat,Long idFactor,Long idFuenteinfor,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idIndicador) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (descripcion != null) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (idObjetvo != null) {
					sb.append("and t.idObjetvo = ? ");
					hs.add(idObjetvo);
				}
				if (idNivlstrat != null) {
					sb.append("and t.idNivlstrat = ? ");
					hs.add(idNivlstrat);
				}
				if (idFactor != null) {
					sb.append("and t.idFactor = ? ");
					hs.add(idFactor);
				}
				if (idFuenteinfor != null) {
					sb.append("and t.idFuenteinfor = ? ");
					hs.add(idFuenteinfor);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
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
	
	@Override
	public List<MsIndicador> getListaIdIndicador() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsIndicador tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("ORDER BY tablaa.idIndicador asc ");
		return super.find(sb.toString());
	}
}