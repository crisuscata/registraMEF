package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtVisitasProyectoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtVisitasProyecto;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_VISITAS_PROYECTO REPOSITORIO: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS VISITAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtVisitasProyectoDaoImp extends
		AbstractJpaCRUDDao<DtVisitasProyecto, Long> implements
		DtVisitasProyectoDao {

	private static final Logger log = Logger.getLogger(DtVisitasProyectoDaoImp.class.getName());

	public DtVisitasProyectoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasProyectoDaoImp");
	}
	
	public DtVisitasProyectoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasProyectoDaoImp");
	}
	
	@Transactional
	public void saveDtVisitasProyecto(DtVisitasProyecto param) {
		super.save(param);
	}

	@Transactional
	public void updateDtVisitasProyecto(DtVisitasProyecto param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtVisitasProyecto(DtVisitasProyecto param) {
		super.delete(param);
	}

	public List<DtVisitasProyecto> getAllDtVisitasProyecto() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtVisitasProyecto getDtVisitasProyecto(Long id) {
		return super.findById(id);
	}

	public List<DtVisitasProyecto> getNativeSQLDtVisitasProyecto(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtVisitasProyecto> getDomainClass() {
		return DtVisitasProyecto.class;
	}

	public List<DtVisitasProyecto> getActivasDtVisitasProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtVisitasProyecto> getActivasDtVisitasProyectoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasProyecto> getDesactivasDtVisitasProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasProyecto> getByIdDtVisitasProyecto(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idVisitaProyecto = ? order by t.idVisitaProyecto asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtVisitasProyecto> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idVisitaProyecto) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtVisitasProyecto> getXFiltro(Long idVisita,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idVisita != null) {
			sb.append("and t.idVisita = ? ");
			hs.add(idVisita);
		}
		if (idProyecto != null) {
			sb.append("and t.idProyecto = ? ");
			hs.add(idProyecto);
		}
		if (detalle != null) {
			sb.append("and t.detalle = ? ");
			hs.add(detalle);
		}		
		// sb.append("order by t.idVisitaProyecto desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtVisitasProyecto> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtVisitasProyecto> getXFiltro(Long idVisita,Long idProyecto,String detalle, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
		// sb.append("order by t.idVisitaProyecto desc ");

		List<DtVisitasProyecto> lista = null;
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
	public long getTotalXFiltro(Long idVisita,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idVisitaProyecto) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
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