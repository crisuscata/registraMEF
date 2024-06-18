package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtConsultasDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtConsultas;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CONSULTAS REPOSITORIO: LISTA DE LOS DATOS REGISTRADOS EN UNA CONSULTA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtConsultasDaoImp extends
		AbstractJpaCRUDDao<DtConsultas, Long> implements
		DtConsultasDao {

	private static final Logger log = Logger.getLogger(DtConsultasDaoImp.class.getName());

	public DtConsultasDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtConsultasDaoImp");
	}
	
	public DtConsultasDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtConsultasDaoImp");
	}
	
	@Transactional
	public void saveDtConsultas(DtConsultas param) {
		super.save(param);
	}

	@Transactional
	public void updateDtConsultas(DtConsultas param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtConsultas(DtConsultas param) {
		super.delete(param);
	}

	public List<DtConsultas> getAllDtConsultas() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtConsultas getDtConsultas(Long id) {
		return super.findById(id);
	}

	public List<DtConsultas> getNativeSQLDtConsultas(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtConsultas> getDomainClass() {
		return DtConsultas.class;
	}

	public List<DtConsultas> getActivasDtConsultas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtConsultas> getActivasDtConsultasCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtConsultas> getDesactivasDtConsultas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtConsultas> getByIdDtConsultas(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idConsulta = ? order by t.idConsulta asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtConsultas> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idConsulta) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtConsultas> getXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (fechaConsu != null) {
			sb.append("and t.fechaConsu = ? ");
			hs.add(fechaConsu);
		}
		if (idUsuexterno != null) {
			sb.append("and t.idUsuexterno = ? ");
			hs.add(idUsuexterno);
		}
		if (idSistAdm != null) {
			sb.append("and t.idSistAdm = ? ");
			hs.add(idSistAdm);
		}
		if (idTema != null) {
			sb.append("and t.idTema = ? ");
			hs.add(idTema);
		}
		if (idSubtema != null) {
			sb.append("and t.idSubtema = ? ");
			hs.add(idSubtema);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idConsulta desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtConsultas> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtConsultas> getXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaConsu != null) {
					sb.append("and t.fechaConsu = ? ");
					hs.add(fechaConsu);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (idSubtema != null) {
					sb.append("and t.idSubtema = ? ");
					hs.add(idSubtema);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idConsulta desc ");

		List<DtConsultas> lista = null;
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
	public long getTotalXFiltro(Timestamp fechaConsu,Long idUsuexterno,Long idSistAdm,Long idTema,Long idSubtema,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idConsulta) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaConsu != null) {
					sb.append("and t.fechaConsu = ? ");
					hs.add(fechaConsu);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (idSubtema != null) {
					sb.append("and t.idSubtema = ? ");
					hs.add(idSubtema);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
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