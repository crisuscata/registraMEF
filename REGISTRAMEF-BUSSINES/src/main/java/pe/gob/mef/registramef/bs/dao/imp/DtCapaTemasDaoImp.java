package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCapaTemasDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapaTemas;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPA_TEMAS REPOSITORIO: LISTA DE LOS DIFERENTES TEMAS AGENDADOS EN LA CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapaTemasDaoImp extends
		AbstractJpaCRUDDao<DtCapaTemas, Long> implements
		DtCapaTemasDao {

	private static final Logger log = Logger.getLogger(DtCapaTemasDaoImp.class.getName());

	public DtCapaTemasDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaTemasDaoImp");
	}
	
	public DtCapaTemasDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaTemasDaoImp");
	}
	
	@Transactional
	public void saveDtCapaTemas(DtCapaTemas param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapaTemas(DtCapaTemas param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapaTemas(DtCapaTemas param) {
		super.delete(param);
	}

	public List<DtCapaTemas> getAllDtCapaTemas() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapaTemas getDtCapaTemas(Long id) {
		return super.findById(id);
	}

	public List<DtCapaTemas> getNativeSQLDtCapaTemas(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapaTemas> getDomainClass() {
		return DtCapaTemas.class;
	}

	public List<DtCapaTemas> getActivasDtCapaTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapaTemas> getActivasDtCapaTemasCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaTemas> getDesactivasDtCapaTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaTemas> getByIdDtCapaTemas(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapaTemAgen = ? order by t.idCapaTemAgen asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapaTemas> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapaTemAgen) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapaTemas> getXFiltro(Long idCapacitacion,Long idTema,Long idSubtema) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idCapacitacion != null) {
			sb.append("and t.idCapacitacion = ? ");
			hs.add(idCapacitacion);
		}
		if (idTema != null) {
			sb.append("and t.idTema = ? ");
			hs.add(idTema);
		}
		if (idSubtema != null) {
			sb.append("and t.idSubtema = ? ");
			hs.add(idSubtema);
		}		
		// sb.append("order by t.idCapaTemAgen desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapaTemas> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapaTemas> getXFiltro(Long idCapacitacion,Long idTema,Long idSubtema, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (idSubtema != null) {
					sb.append("and t.idSubtema = ? ");
					hs.add(idSubtema);
				}
		// sb.append("order by t.idCapaTemAgen desc ");

		List<DtCapaTemas> lista = null;
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
	public long getTotalXFiltro(Long idCapacitacion,Long idTema,Long idSubtema) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapaTemAgen) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (idSubtema != null) {
					sb.append("and t.idSubtema = ? ");
					hs.add(idSubtema);
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
		public List<DtCapaTemas> getByIdCapacDtCapaTemas(Long idCapacitacion) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.idCapacitacion = ? and t.estado >= "+Estado.ACTIVO.getValor()+" order by t.idCapaTemAgen asc ");
			Object param[] = new Object[1];
			param[0] = idCapacitacion;
			List<DtCapaTemas> lista = super.find(sb.toString(), param);
			return lista;
		}
		
		//MPINARES 14022024 - FIN
}