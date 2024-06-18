package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.PrtParametrosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.PrtParametros;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * PRT_PARAMETROS REPOSITORIO: ALMACENA LOS PARAMETROS REGISTRADOS EN EL SISTEMA "PARÁMETROS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 19:52
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 19:52   / Creación de la clase    /
 * 
 */
@Repository
public class PrtParametrosDaoImp extends
		AbstractJpaCRUDDao<PrtParametros, Long> implements
		PrtParametrosDao {

	private static final Logger log = Logger.getLogger(PrtParametrosDaoImp.class.getName());

	public PrtParametrosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA PrtParametrosDaoImp");
	}
	
	public PrtParametrosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA PrtParametrosDaoImp");
	}
	
	@Transactional
	public void savePrtParametros(PrtParametros param) {
		super.save(param);
	}

	@Transactional
	public void updatePrtParametros(PrtParametros param) {
		super.update(param);
	}

	@Transactional
	public void deletePrtParametros(PrtParametros param) {
		super.delete(param);
	}

	public List<PrtParametros> getAllPrtParametros() {
		return super.find("from " + getDomainClass().getName());
	}

	public PrtParametros getPrtParametros(Long id) {
		return super.findById(id);
	}

	public List<PrtParametros> getNativeSQLPrtParametros(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<PrtParametros> getDomainClass() {
		return PrtParametros.class;
	}

	public List<PrtParametros> getActivasPrtParametros() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<PrtParametros> getActivasPrtParametrosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<PrtParametros> getDesactivasPrtParametros() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<PrtParametros> getByIdPrtParametros(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idparametro = ? order by t.idparametro asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<PrtParametros> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idparametro) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<PrtParametros> getXFiltro(Long idpadre,String descripcion) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idpadre != null) {
			sb.append("and t.idpadre = ? ");
			hs.add(idpadre);
		}
		if (descripcion != null && descripcion.trim().length() > 0) {
			sb.append("and t.descripcion = ? ");
			hs.add(descripcion);
		}		
		// sb.append("order by t.idparametro desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<PrtParametros> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<PrtParametros> getXFiltro(Long idpadre,String descripcion, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
				if (idpadre != null) {
					sb.append("and t.idpadre = ? ");
					hs.add(idpadre);
				}
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
		// sb.append("order by t.idparametro desc ");

		List<PrtParametros> lista = null;
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
	public long getTotalXFiltro(Long idpadre,String descripcion) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idparametro) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idpadre != null) {
					sb.append("and t.idpadre = ? ");
					hs.add(idpadre);
				}
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
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
	
//	@Override
//	public List<PrtParametros> getListaIdparametro() {
//		StringBuffer sb = new StringBuffer(100);
//		sb.append("SELECT tablaa FROM PrtParametros tablaa ");
//		sb.append("WHERE tablaa.estado >= 1 ");
//		sb.append("ORDER BY tablaa.idparametro asc ");
//		return super.find(sb.toString());
//	}
	
	//MPINARES 24012023 - INICIO
	@Override
	public List<PrtParametros> getHijosXDescripcion(String descripcionpadre) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("and t.idpadre in (select g.idparametro from " + this.getDomainClass().getName()
				+ " g where g.descripcion = ?) ");
		hs.add(descripcionpadre);
		sb.append("order by t.descripcion asc ");
		Object[] param = new Object[hs.size()];
		hs.toArray(param);
		List<PrtParametros> lista = super.find(sb.toString(), param);
		return lista;
	}
	//MPINARES 24012023 - FIN
	
	
	//PURIBE 25012024 - INICIO
	@Override
	public List<PrtParametros> getListaIdparametro() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM PrtParametros tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" and tablaa.idpadre is null or tablaa.idpadre=0 ");
		sb.append("ORDER BY tablaa.idparametro asc ");
		return super.find(sb.toString());
	}
	//PURIBE 25012024 - FIN
}