package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCapaUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapaUsuexternos;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPA_USUEXTERNOS REPOSITORIO: LISTA DE LOS PARTICIPANTES QUE ASISTEN A LA CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapaUsuexternosDaoImp extends
		AbstractJpaCRUDDao<DtCapaUsuexternos, Long> implements
		DtCapaUsuexternosDao {

	private static final Logger log = Logger.getLogger(DtCapaUsuexternosDaoImp.class.getName());

	public DtCapaUsuexternosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaUsuexternosDaoImp");
	}
	
	public DtCapaUsuexternosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaUsuexternosDaoImp");
	}
	
	@Transactional
	public void saveDtCapaUsuexternos(DtCapaUsuexternos param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapaUsuexternos(DtCapaUsuexternos param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapaUsuexternos(DtCapaUsuexternos param) {
		super.delete(param);
	}

	public List<DtCapaUsuexternos> getAllDtCapaUsuexternos() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapaUsuexternos getDtCapaUsuexternos(Long id) {
		return super.findById(id);
	}

	public List<DtCapaUsuexternos> getNativeSQLDtCapaUsuexternos(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapaUsuexternos> getDomainClass() {
		return DtCapaUsuexternos.class;
	}

	public List<DtCapaUsuexternos> getActivasDtCapaUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapaUsuexternos> getActivasDtCapaUsuexternosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaUsuexternos> getDesactivasDtCapaUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaUsuexternos> getByIdDtCapaUsuexternos(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapaUsuext = ? order by t.idCapaUsuext asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapaUsuexternos> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapaUsuext) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapaUsuexternos> getXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idCapacitacion != null) {
			sb.append("and t.idCapacitacion = ? ");
			hs.add(idCapacitacion);
		}
		if (idUsuexterno != null) {
			sb.append("and t.idUsuexterno = ? ");
			hs.add(idUsuexterno);
		}
		if (idCargoUsuext != null) {
			sb.append("and t.idCargoUsuext = ? ");
			hs.add(idCargoUsuext);
		}
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}		
		// sb.append("order by t.idCapaUsuext desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapaUsuexternos> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapaUsuexternos> getXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
				}
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
		// sb.append("order by t.idCapaUsuext desc ");

		List<DtCapaUsuexternos> lista = null;
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
	public long getTotalXFiltro(Long idCapacitacion,Long idUsuexterno,Long idCargoUsuext,Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapaUsuext) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
				}
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
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
	public List<DtCapaUsuexternos> getByIdCapacDtCapaUsuariosExt(Long idCapacitacion) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapacitacion = ? and t.estado >= "+Estado.ACTIVO.getValor()+" order by t.idCapaUsuext asc ");
		Object param[] = new Object[1];
		param[0] = idCapacitacion;
		List<DtCapaUsuexternos> lista = super.find(sb.toString(), param);
		return lista;
	}
}