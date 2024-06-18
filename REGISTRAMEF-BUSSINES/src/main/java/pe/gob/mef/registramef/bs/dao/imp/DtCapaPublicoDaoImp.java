package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtCapaPublicoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapaPublico;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPA_PUBLICO REPOSITORIO: LISTA DE LOS TIPOS DE PUBLICO OBJETIVO POR CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapaPublicoDaoImp extends
		AbstractJpaCRUDDao<DtCapaPublico, Long> implements
		DtCapaPublicoDao {

	private static final Logger log = Logger.getLogger(DtCapaPublicoDaoImp.class.getName());

	public DtCapaPublicoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaPublicoDaoImp");
	}
	
	public DtCapaPublicoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapaPublicoDaoImp");
	}
	
	@Transactional
	public void saveDtCapaPublico(DtCapaPublico param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapaPublico(DtCapaPublico param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapaPublico(DtCapaPublico param) {
		super.delete(param);
	}

	public List<DtCapaPublico> getAllDtCapaPublico() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapaPublico getDtCapaPublico(Long id) {
		return super.findById(id);
	}

	public List<DtCapaPublico> getNativeSQLDtCapaPublico(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapaPublico> getDomainClass() {
		return DtCapaPublico.class;
	}

	public List<DtCapaPublico> getActivasDtCapaPublico() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapaPublico> getActivasDtCapaPublicoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaPublico> getDesactivasDtCapaPublico() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapaPublico> getByIdDtCapaPublico(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapaPublico = ? order by t.idCapaPublico asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapaPublico> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapaPublico) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapaPublico> getXFiltro(Long idCapacitacion) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idCapacitacion != null) {
			sb.append("and t.idCapacitacion = ? ");
			hs.add(idCapacitacion);
		}		
		// sb.append("order by t.idCapaPublico desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapaPublico> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapaPublico> getXFiltro(Long idCapacitacion, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
				}
		// sb.append("order by t.idCapaPublico desc ");

		List<DtCapaPublico> lista = null;
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
	public long getTotalXFiltro(Long idCapacitacion) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapaPublico) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCapacitacion != null) {
					sb.append("and t.idCapacitacion = ? ");
					hs.add(idCapacitacion);
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
		public List<DtCapaPublico> getByIdCapacDtCapaPublico(Long idCapacitacion) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.idCapacitacion = ? and t.estado >= "+Estado.ACTIVO.getValor()+" order by t.idCapaPublico asc ");
			Object param[] = new Object[1];
			param[0] = idCapacitacion;
			List<DtCapaPublico> lista = super.find(sb.toString(), param);
			return lista;
		}
		
		
		//MPINARES 14022024 - FIN
}