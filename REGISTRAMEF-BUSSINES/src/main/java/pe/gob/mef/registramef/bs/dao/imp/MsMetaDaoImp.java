package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsMetaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsMeta;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_META REPOSITORIO: LISTA DE LAS METAS CON SUS VALORES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsMetaDaoImp extends
		AbstractJpaCRUDDao<MsMeta, Long> implements
		MsMetaDao {

	private static final Logger log = Logger.getLogger(MsMetaDaoImp.class.getName());

	public MsMetaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsMetaDaoImp");
	}
	
	public MsMetaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsMetaDaoImp");
	}
	
	@Transactional
	public void saveMsMeta(MsMeta param) {
		super.save(param);
	}

	@Transactional
	public void updateMsMeta(MsMeta param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsMeta(MsMeta param) {
		super.delete(param);
	}

	public List<MsMeta> getAllMsMeta() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsMeta getMsMeta(Long id) {
		return super.findById(id);
	}

	public List<MsMeta> getNativeSQLMsMeta(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsMeta> getDomainClass() {
		return MsMeta.class;
	}

	public List<MsMeta> getActivasMsMeta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsMeta> getActivasMsMetaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsMeta> getDesactivasMsMeta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsMeta> getByIdMsMeta(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idMeta = ? order by t.idMeta asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsMeta> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idMeta) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsMeta> getXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (annio != null) {
			sb.append("and t.annio = ? ");
			hs.add(annio);
		}
		if (idTipoServicio != null) {
			sb.append("and t.idTipoServicio = ? ");
			hs.add(idTipoServicio);
		}
		if (idSistAdmi != null) {
			sb.append("and t.idSistAdmi = ? ");
			hs.add(idSistAdmi);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}
		if (valor != null) {
			sb.append("and t.valor = ? ");
			hs.add(valor);
		}
		if (fechaCrea != null) {
			sb.append("and t.fechaCrea = ? ");
			hs.add(fechaCrea);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idMeta desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsMeta> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsMeta> getXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (annio != null) {
					sb.append("and t.annio = ? ");
					hs.add(annio);
				}
				if (idTipoServicio != null) {
					sb.append("and t.idTipoServicio = ? ");
					hs.add(idTipoServicio);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (valor != null) {
					sb.append("and t.valor = ? ");
					hs.add(valor);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idMeta desc ");

		List<MsMeta> lista = null;
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
	public long getTotalXFiltro(Integer annio,Long idTipoServicio,Long idSistAdmi,Long idSede,Long valor,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idMeta) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (annio != null) {
					sb.append("and t.annio = ? ");
					hs.add(annio);
				}
				if (idTipoServicio != null) {
					sb.append("and t.idTipoServicio = ? ");
					hs.add(idTipoServicio);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (valor != null) {
					sb.append("and t.valor = ? ");
					hs.add(valor);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
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
}