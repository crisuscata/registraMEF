package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaProyectoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaProyecto;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ASISTENCIA_PROYECTO REPOSITORIO: LISTA DE LOS DISTINTOS PROYECTOS DE INVERSIÓN RELACIONADOS A LA ASISTENCIA TÉCNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAsistenciaProyectoDaoImp extends
		AbstractJpaCRUDDao<DtAsistenciaProyecto, Long> implements
		DtAsistenciaProyectoDao {

	private static final Logger log = Logger.getLogger(DtAsistenciaProyectoDaoImp.class.getName());

	public DtAsistenciaProyectoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaProyectoDaoImp");
	}
	
	public DtAsistenciaProyectoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaProyectoDaoImp");
	}
	
	@Transactional
	public void saveDtAsistenciaProyecto(DtAsistenciaProyecto param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAsistenciaProyecto(DtAsistenciaProyecto param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtAsistenciaProyecto(DtAsistenciaProyecto param) {
		super.delete(param);
	}

	public List<DtAsistenciaProyecto> getAllDtAsistenciaProyecto() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAsistenciaProyecto getDtAsistenciaProyecto(Long id) {
		return super.findById(id);
	}

	public List<DtAsistenciaProyecto> getNativeSQLDtAsistenciaProyecto(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAsistenciaProyecto> getDomainClass() {
		return DtAsistenciaProyecto.class;
	}

	public List<DtAsistenciaProyecto> getActivasDtAsistenciaProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAsistenciaProyecto> getActivasDtAsistenciaProyectoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaProyecto> getDesactivasDtAsistenciaProyecto() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaProyecto> getByIdDtAsistenciaProyecto(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAsistProyecto = ? order by t.idAsistProyecto asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAsistenciaProyecto> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAsistProyecto) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAsistenciaProyecto> getXFiltro(Long idAsistencia,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idAsistencia != null) {
			sb.append("and t.idAsistencia = ? ");
			hs.add(idAsistencia);
		}
		if (idProyecto != null) {
			sb.append("and t.idProyecto = ? ");
			hs.add(idProyecto);
		}
		if (detalle != null && detalle.trim().length() > 0) {
			sb.append("and t.detalle = ? ");
			hs.add(detalle);
		}		
		// sb.append("order by t.idAsistProyecto desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAsistenciaProyecto> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAsistenciaProyecto> getXFiltro(Long idAsistencia,Long idProyecto,String detalle, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
				}
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null && detalle.trim().length() > 0) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
		// sb.append("order by t.idAsistProyecto desc ");

		List<DtAsistenciaProyecto> lista = null;
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
	public long getTotalXFiltro(Long idAsistencia,Long idProyecto,String detalle) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAsistProyecto) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
				}
				if (idProyecto != null) {
					sb.append("and t.idProyecto = ? ");
					hs.add(idProyecto);
				}
				if (detalle != null && detalle.trim().length() > 0) {
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