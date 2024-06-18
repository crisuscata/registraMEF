package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCapaProyectoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapaProyecto;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPA_PROYECTO REPOSITORIO: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CAPACITACIONES
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapaProyectoDaoImp extends
		AbstractJpaCRUDDao<DtCapaProyecto, Long> implements
		DtCapaProyectoDao {

	private static final Logger log = Logger.getLogger(DtCapaProyectoDaoImp.class.getName());

	public DtCapaProyectoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaProyectoDaoImp");
	}
	
	public DtCapaProyectoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaProyectoDaoImp");
	}
	
	@Transactional
	public void saveDtCapaProyecto(DtCapaProyecto param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapaProyecto(DtCapaProyecto param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapaProyecto(DtCapaProyecto param) {
		super.delete(param);
	}

	public List<DtCapaProyecto> getAllDtCapaProyecto() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapaProyecto getDtCapaProyecto(Long id) {
		return super.findById(id);
	}

	public List<DtCapaProyecto> getNativeSQLDtCapaProyecto(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapaProyecto> getDomainClass() {
		return DtCapaProyecto.class;
	}

	public List<DtCapaProyecto> getActivasDtCapaProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapaProyecto> getActivasDtCapaProyectoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaProyecto> getDesactivasDtCapaProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaProyecto> getByIdDtCapaProyecto(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapaProyecto = ? order by t.idCapaProyecto asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapaProyecto> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapaProyecto) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapaProyecto> getXFiltro(Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idProyecto != null) {
			sb.append("and t.idProyecto = ? ");
			hs.add(idProyecto);
		}
		if (detalle != null) {
			sb.append("and t.detalle = ? ");
			hs.add(detalle);
		}		
		// sb.append("order by t.idCapaProyecto desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapaProyecto> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapaProyecto> getXFiltro(Long idProyecto,String detalle, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
		// sb.append("order by t.idCapaProyecto desc ");

		List<DtCapaProyecto> lista = null;
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
	public long getTotalXFiltro(Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapaProyecto) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
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