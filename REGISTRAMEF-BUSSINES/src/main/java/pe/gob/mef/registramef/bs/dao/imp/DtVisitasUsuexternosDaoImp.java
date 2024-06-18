package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtVisitasUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuexternos;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_VISITAS_USUEXTERNOS REPOSITORIO: LISTA DE LOS PARTICIPANTES DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtVisitasUsuexternosDaoImp extends
		AbstractJpaCRUDDao<DtVisitasUsuexternos, Long> implements
		DtVisitasUsuexternosDao {

	private static final Logger log = Logger.getLogger(DtVisitasUsuexternosDaoImp.class.getName());

	public DtVisitasUsuexternosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasUsuexternosDaoImp");
	}
	
	public DtVisitasUsuexternosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasUsuexternosDaoImp");
	}
	
	@Transactional
	public void saveDtVisitasUsuexternos(DtVisitasUsuexternos param) {
		super.save(param);
	}

	@Transactional
	public void updateDtVisitasUsuexternos(DtVisitasUsuexternos param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtVisitasUsuexternos(DtVisitasUsuexternos param) {
		super.delete(param);
	}

	public List<DtVisitasUsuexternos> getAllDtVisitasUsuexternos() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtVisitasUsuexternos getDtVisitasUsuexternos(Long id) {
		return super.findById(id);
	}

	public List<DtVisitasUsuexternos> getNativeSQLDtVisitasUsuexternos(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtVisitasUsuexternos> getDomainClass() {
		return DtVisitasUsuexternos.class;
	}

	public List<DtVisitasUsuexternos> getActivasDtVisitasUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtVisitasUsuexternos> getActivasDtVisitasUsuexternosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasUsuexternos> getDesactivasDtVisitasUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasUsuexternos> getByIdDtVisitasUsuexternos(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idVisitUsuext = ? order by t.idVisitUsuext asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtVisitasUsuexternos> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idVisitUsuext) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtVisitasUsuexternos> getXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idVisita != null) {
			sb.append("and t.idVisita = ? ");
			hs.add(idVisita);
		}
		if (idUsuexterno != null) {
			sb.append("and t.idUsuexterno = ? ");
			hs.add(idUsuexterno);
		}
		if (idCargoUsuext != null) {
			sb.append("and t.idCargoUsuext = ? ");
			hs.add(idCargoUsuext);
		}		
		// sb.append("order by t.idVisitUsuext desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtVisitasUsuexternos> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtVisitasUsuexternos> getXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
				}
		// sb.append("order by t.idVisitUsuext desc ");

		List<DtVisitasUsuexternos> lista = null;
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
	public long getTotalXFiltro(Long idVisita,Long idUsuexterno,Long idCargoUsuext) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idVisitUsuext) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
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