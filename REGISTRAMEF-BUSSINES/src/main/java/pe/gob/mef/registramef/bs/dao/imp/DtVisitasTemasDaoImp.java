package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtVisitasTemasDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtVisitasTemas;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_VISITAS_TEMAS REPOSITORIO: LISTA DE LOS TEMAS DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtVisitasTemasDaoImp extends
		AbstractJpaCRUDDao<DtVisitasTemas, Long> implements
		DtVisitasTemasDao {

	private static final Logger log = Logger.getLogger(DtVisitasTemasDaoImp.class.getName());

	public DtVisitasTemasDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasTemasDaoImp");
	}
	
	public DtVisitasTemasDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasTemasDaoImp");
	}
	
	@Transactional
	public void saveDtVisitasTemas(DtVisitasTemas param) {
		super.save(param);
	}

	@Transactional
	public void updateDtVisitasTemas(DtVisitasTemas param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtVisitasTemas(DtVisitasTemas param) {
		super.delete(param);
	}

	public List<DtVisitasTemas> getAllDtVisitasTemas() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtVisitasTemas getDtVisitasTemas(Long id) {
		return super.findById(id);
	}

	public List<DtVisitasTemas> getNativeSQLDtVisitasTemas(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtVisitasTemas> getDomainClass() {
		return DtVisitasTemas.class;
	}

	public List<DtVisitasTemas> getActivasDtVisitasTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtVisitasTemas> getActivasDtVisitasTemasCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasTemas> getDesactivasDtVisitasTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasTemas> getByIdDtVisitasTemas(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idVisitaTema = ? order by t.idVisitaTema asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtVisitasTemas> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idVisitaTema) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtVisitasTemas> getXFiltro(Long idVisita) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idVisita != null) {
			sb.append("and t.idVisita = ? ");
			hs.add(idVisita);
		}		
		// sb.append("order by t.idVisitaTema desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtVisitasTemas> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtVisitasTemas> getXFiltro(Long idVisita, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
		// sb.append("order by t.idVisitaTema desc ");

		List<DtVisitasTemas> lista = null;
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
	public long getTotalXFiltro(Long idVisita) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idVisitaTema) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
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