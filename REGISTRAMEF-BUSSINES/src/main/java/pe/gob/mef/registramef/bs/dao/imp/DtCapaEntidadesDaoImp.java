package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCapaEntidadesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapaEntidades;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPA_ENTIDADES REPOSITORIO: LISTA DE LAS ENTIDADES PROGRAMADAS EN LA CAPACITACION
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapaEntidadesDaoImp extends
		AbstractJpaCRUDDao<DtCapaEntidades, Long> implements
		DtCapaEntidadesDao {

	private static final Logger log = Logger.getLogger(DtCapaEntidadesDaoImp.class.getName());

	public DtCapaEntidadesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaEntidadesDaoImp");
	}
	
	public DtCapaEntidadesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaEntidadesDaoImp");
	}
	
	@Transactional
	public void saveDtCapaEntidades(DtCapaEntidades param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapaEntidades(DtCapaEntidades param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapaEntidades(DtCapaEntidades param) {
		super.delete(param);
	}

	public List<DtCapaEntidades> getAllDtCapaEntidades() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapaEntidades getDtCapaEntidades(Long id) {
		return super.findById(id);
	}

	public List<DtCapaEntidades> getNativeSQLDtCapaEntidades(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapaEntidades> getDomainClass() {
		return DtCapaEntidades.class;
	}

	public List<DtCapaEntidades> getActivasDtCapaEntidades() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapaEntidades> getActivasDtCapaEntidadesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaEntidades> getDesactivasDtCapaEntidades() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaEntidades> getByIdDtCapaEntidades(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapaEnti = ? order by t.idCapaEnti asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapaEntidades> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapaEnti) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapaEntidades> getXFiltro(Long idCapacitacion,Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idCapacitacion != null) {
			sb.append("and t.idCapacitacion = ? ");
			hs.add(idCapacitacion);
		}
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}		
		// sb.append("order by t.idCapaEnti desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapaEntidades> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapaEntidades> getXFiltro(Long idCapacitacion,Long idEntidad, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
		// sb.append("order by t.idCapaEnti desc ");

		List<DtCapaEntidades> lista = null;
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
	public long getTotalXFiltro(Long idCapacitacion,Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapaEnti) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
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
	
	//MPINARES 14022024 - INICIO
			public List<DtCapaEntidades> getByIdCapacDtCapaEntidades(Long idCapacitacion) {
				StringBuffer sb = new StringBuffer(100);
				sb.append("select t from " + getDomainClass().getName()
						+ " t where t.idCapacitacion = ? and t.estado >= "+Estado.ACTIVO.getValor()+" order by t.idCapaEnti asc ");
				Object param[] = new Object[1];
				param[0] = idCapacitacion;
				List<DtCapaEntidades> lista = super.find(sb.toString(), param);
				return lista;
			}
			
			
			
			//MPINARES 14022024 - FIN
}