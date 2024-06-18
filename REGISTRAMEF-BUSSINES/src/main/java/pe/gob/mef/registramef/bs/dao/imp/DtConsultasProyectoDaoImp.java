package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtConsultasProyectoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtConsultasProyecto;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CONSULTAS_PROYECTO REPOSITORIO: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LAS CONSULTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtConsultasProyectoDaoImp extends
		AbstractJpaCRUDDao<DtConsultasProyecto, Long> implements
		DtConsultasProyectoDao {

	private static final Logger log = Logger.getLogger(DtConsultasProyectoDaoImp.class.getName());

	public DtConsultasProyectoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtConsultasProyectoDaoImp");
	}
	
	public DtConsultasProyectoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtConsultasProyectoDaoImp");
	}
	
	@Transactional
	public void saveDtConsultasProyecto(DtConsultasProyecto param) {
		super.save(param);
	}

	@Transactional
	public void updateDtConsultasProyecto(DtConsultasProyecto param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtConsultasProyecto(DtConsultasProyecto param) {
		super.delete(param);
	}

	public List<DtConsultasProyecto> getAllDtConsultasProyecto() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtConsultasProyecto getDtConsultasProyecto(Long id) {
		return super.findById(id);
	}

	public List<DtConsultasProyecto> getNativeSQLDtConsultasProyecto(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtConsultasProyecto> getDomainClass() {
		return DtConsultasProyecto.class;
	}

	public List<DtConsultasProyecto> getActivasDtConsultasProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtConsultasProyecto> getActivasDtConsultasProyectoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtConsultasProyecto> getDesactivasDtConsultasProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtConsultasProyecto> getByIdDtConsultasProyecto(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idConsProyecto = ? order by t.idConsProyecto asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtConsultasProyecto> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idConsProyecto) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtConsultasProyecto> getXFiltro(Long idConsulta,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idConsulta != null) {
			sb.append("and t.idConsulta = ? ");
			hs.add(idConsulta);
		}
		if (idProyecto != null) {
			sb.append("and t.idProyecto = ? ");
			hs.add(idProyecto);
		}
		if (detalle != null) {
			sb.append("and t.detalle = ? ");
			hs.add(detalle);
		}		
		// sb.append("order by t.idConsProyecto desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtConsultasProyecto> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtConsultasProyecto> getXFiltro(Long idConsulta,Long idProyecto,String detalle, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idConsulta != null) {
					sb.append("and t.idConsulta = ? ");
					hs.add(idConsulta);
				}
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
		// sb.append("order by t.idConsProyecto desc ");

		List<DtConsultasProyecto> lista = null;
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
	public long getTotalXFiltro(Long idConsulta,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idConsProyecto) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idConsulta != null) {
					sb.append("and t.idConsulta = ? ");
					hs.add(idConsulta);
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