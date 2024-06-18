package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaTemasDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaTemas;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ASISTENCIA_TEMAS REPOSITORIO: LISTA DE LOS DISTINTOS TEMAS AGENDADOS EN LA ASISTENCIA TECNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAsistenciaTemasDaoImp extends
		AbstractJpaCRUDDao<DtAsistenciaTemas, Long> implements
		DtAsistenciaTemasDao {

	private static final Logger log = Logger.getLogger(DtAsistenciaTemasDaoImp.class.getName());

	public DtAsistenciaTemasDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaTemasDaoImp");
	}
	
	public DtAsistenciaTemasDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaTemasDaoImp");
	}
	
	@Transactional
	public void saveDtAsistenciaTemas(DtAsistenciaTemas param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAsistenciaTemas(DtAsistenciaTemas param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtAsistenciaTemas(DtAsistenciaTemas param) {
		super.delete(param);
	}

	public List<DtAsistenciaTemas> getAllDtAsistenciaTemas() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAsistenciaTemas getDtAsistenciaTemas(Long id) {
		return super.findById(id);
	}

	public List<DtAsistenciaTemas> getNativeSQLDtAsistenciaTemas(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAsistenciaTemas> getDomainClass() {
		return DtAsistenciaTemas.class;
	}

	public List<DtAsistenciaTemas> getActivasDtAsistenciaTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAsistenciaTemas> getActivasDtAsistenciaTemasCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaTemas> getDesactivasDtAsistenciaTemas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaTemas> getByIdDtAsistenciaTemas(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAsistTema = ? order by t.idAsistTema asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAsistenciaTemas> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAsistTema) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAsistenciaTemas> getXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (detalle != null) {
			sb.append("and t.detalle = ? ");
			hs.add(detalle);
		}
		if (idAsistencia != null) {
			sb.append("and t.idAsistencia = ? ");
			hs.add(idAsistencia);
		}
		if (idTema != null) {
			sb.append("and t.idTema = ? ");
			hs.add(idTema);
		}
		if (idSubtema != null) {
			sb.append("and t.idSubtema = ? ");
			hs.add(idSubtema);
		}		
		// sb.append("order by t.idAsistTema desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAsistenciaTemas> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAsistenciaTemas> getXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
				}
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (idSubtema != null) {
					sb.append("and t.idSubtema = ? ");
					hs.add(idSubtema);
				}
		// sb.append("order by t.idAsistTema desc ");

		List<DtAsistenciaTemas> lista = null;
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
	public long getTotalXFiltro(String detalle,Long idAsistencia,Long idTema,Long idSubtema) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAsistTema) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (detalle != null) {
					sb.append("and t.detalle = ? ");
					hs.add(detalle);
				}
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
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
	
	//MPINARES 24012023 - INICIO
		public List<DtAsistenciaTemas> getDtAsistenciaTemasByIdAsistencia(Long idAsistencia){
			List<DtAsistenciaTemas> lista = new ArrayList<DtAsistenciaTemas>();
			try {
				StringBuffer sb = new StringBuffer(100);			
				sb.append("select t from " + getDomainClass().getName()	+ " t ");

				if (idAsistencia != null && idAsistencia.intValue() >= 0) {
					sb.append(" where t.estado >= "+Estado.ACTIVO.getValor()+" ");	
					sb.append(" and t.idAsistencia = ? ");	
					sb.append(" order by t.idTema, t.idSubtema asc ");
				}			
				Object param[] = new Object[1];
				param[0] = idAsistencia;
				lista = super.find(sb.toString(), param);
			} catch (Exception e) {
				log.info(e.getMessage());
			}		
			return lista;		
		}

//		public Long getEstadoNuevo() {
//			return estadoNuevo;
//		}
//
//		public void setEstadoNuevo(Long estadoNuevo) {
//			this.estadoNuevo = estadoNuevo;
//		}
//
//		public Long getEstadoEliminado() {
//			return estadoEliminado;
//		}
//
//		public void setEstadoEliminado(Long estadoEliminado) {
//			this.estadoEliminado = estadoEliminado;
//		}		
		//MPINARES 24012023 - FIN
}