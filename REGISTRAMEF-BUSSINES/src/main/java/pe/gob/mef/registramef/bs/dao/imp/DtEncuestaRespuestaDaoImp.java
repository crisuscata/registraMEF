package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtEncuestaRespuestaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEncuestaRespuesta;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ENCUESTA_RESPUESTA REPOSITORIO: LISTA DE RESPUESTAS A LAS ENCUESTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEncuestaRespuestaDaoImp extends
		AbstractJpaCRUDDao<DtEncuestaRespuesta, Long> implements
		DtEncuestaRespuestaDao {

	private static final Logger log = Logger.getLogger(DtEncuestaRespuestaDaoImp.class.getName());

	public DtEncuestaRespuestaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEncuestaRespuestaDaoImp");
	}
	
	public DtEncuestaRespuestaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEncuestaRespuestaDaoImp");
	}
	
	@Transactional
	public void saveDtEncuestaRespuesta(DtEncuestaRespuesta param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEncuestaRespuesta(DtEncuestaRespuesta param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEncuestaRespuesta(DtEncuestaRespuesta param) {
		super.delete(param);
	}

	public List<DtEncuestaRespuesta> getAllDtEncuestaRespuesta() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEncuestaRespuesta getDtEncuestaRespuesta(Long id) {
		return super.findById(id);
	}

	public List<DtEncuestaRespuesta> getNativeSQLDtEncuestaRespuesta(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEncuestaRespuesta> getDomainClass() {
		return DtEncuestaRespuesta.class;
	}

	public List<DtEncuestaRespuesta> getActivasDtEncuestaRespuesta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEncuestaRespuesta> getActivasDtEncuestaRespuestaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEncuestaRespuesta> getDesactivasDtEncuestaRespuesta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEncuestaRespuesta> getByIdDtEncuestaRespuesta(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idRespuesta = ? order by t.idRespuesta asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEncuestaRespuesta> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idRespuesta) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtEncuestaRespuesta> getXFiltro(Integer idEncuesta,String pregunta) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idEncuesta != null) {
			sb.append("and t.idEncuesta = ? ");
			hs.add(idEncuesta);
		}
		if (pregunta != null) {
			sb.append("and t.pregunta = ? ");
			hs.add(pregunta);
		}		
		// sb.append("order by t.idRespuesta desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtEncuestaRespuesta> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtEncuestaRespuesta> getXFiltro(Integer idEncuesta,String pregunta, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEncuesta != null) {
					sb.append("and t.idEncuesta = ? ");
					hs.add(idEncuesta);
				}
				if (pregunta != null) {
					sb.append("and t.pregunta = ? ");
					hs.add(pregunta);
				}
		// sb.append("order by t.idRespuesta desc ");

		List<DtEncuestaRespuesta> lista = null;
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
	public long getTotalXFiltro(Integer idEncuesta,String pregunta) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idRespuesta) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEncuesta != null) {
					sb.append("and t.idEncuesta = ? ");
					hs.add(idEncuesta);
				}
				if (pregunta != null) {
					sb.append("and t.pregunta = ? ");
					hs.add(pregunta);
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