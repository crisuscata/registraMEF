package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtAsistenciaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAsistencia;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ASISTENCIA REPOSITORIO: LISTA DE LOS DATOS REGISTRADOS EN UNA ASISTENCIA TECNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAsistenciaDaoImp extends
		AbstractJpaCRUDDao<DtAsistencia, Long> implements
		DtAsistenciaDao {

	private static final Logger log = Logger.getLogger(DtAsistenciaDaoImp.class.getName());

	//MPINARES 24012023 - INICIO
//			private Long estadoNuevo = 3L;
//			private Long estadoEliminado = 2L;
//
//		public DtAsistenciaDaoImp() {
////			log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaDaoImp");
//			this.estadoNuevo = PropertiesMg.getSistemLong(
//					PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO,
//					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
//			this.estadoEliminado = PropertiesMg.getSistemLong(
//					PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO,
//					PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
//			log.log(Level.INFO, "INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaDaoImp "+ "Nuevo: " + estadoNuevo + " Eliminado:" + estadoEliminado);
//		}
		//MPINARES 24012023 - FIN
		
	public DtAsistenciaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaDaoImp");
	}
	
	public DtAsistenciaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaDaoImp");
	}
	
	@Transactional
	public void saveDtAsistencia(DtAsistencia param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAsistencia(DtAsistencia param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtAsistencia(DtAsistencia param) {
		super.delete(param);
	}

	public List<DtAsistencia> getAllDtAsistencia() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAsistencia getDtAsistencia(Long id) {
		return super.findById(id);
	}

	public List<DtAsistencia> getNativeSQLDtAsistencia(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAsistencia> getDomainClass() {
		return DtAsistencia.class;
	}

	public List<DtAsistencia> getActivasDtAsistencia() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAsistencia> getActivasDtAsistenciaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO); 
	}

	public List<DtAsistencia> getDesactivasDtAsistencia() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistencia> getByIdDtAsistencia(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAsistencia = ? order by t.idAsistencia asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAsistencia> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAsistencia) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAsistencia> getXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}
		if (fechaAsistencia != null) {
			sb.append("and t.fechaAsistencia = ? ");
			hs.add(fechaAsistencia);
		}
		if (idUsuinterno != null) {
			sb.append("and t.idUsuinterno = ? ");
			hs.add(idUsuinterno);
		}
		if (idSistAdm != null) {
			sb.append("and t.idSistAdm = ? ");
			hs.add(idSistAdm);
		}
		if (idOrigen != null) {
			sb.append("and t.idOrigen = ? ");
			hs.add(idOrigen);
		}
		if (idProgramacion != null) {
			sb.append("and t.idProgramacion = ? ");
			hs.add(idProgramacion);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idAsistencia desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAsistencia> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAsistencia> getXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (fechaAsistencia != null) {
					sb.append("and t.fechaAsistencia = ? ");
					hs.add(fechaAsistencia);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idOrigen != null) {
					sb.append("and t.idOrigen = ? ");
					hs.add(idOrigen);
				}
				if (idProgramacion != null) {
					sb.append("and t.idProgramacion = ? ");
					hs.add(idProgramacion);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idAsistencia desc ");

		List<DtAsistencia> lista = null;
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
	public long getTotalXFiltro(Long idEntidad,Long idSede,Timestamp fechaAsistencia,Long idUsuinterno,Long idSistAdm,Long idOrigen,Long idProgramacion,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAsistencia) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (fechaAsistencia != null) {
					sb.append("and t.fechaAsistencia = ? ");
					hs.add(fechaAsistencia);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idOrigen != null) {
					sb.append("and t.idOrigen = ? ");
					hs.add(idOrigen);
				}
				if (idProgramacion != null) {
					sb.append("and t.idProgramacion = ? ");
					hs.add(idProgramacion);
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
	
	//MPINARES 24012023 - INICIO
		@Override
		public List<DtAsistencia> getXFiltroV(Date fechaInicio, Date fechaFin,Long idProgramacion) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ELIMINADO.getValor()+" ");
			
			if(idProgramacion!=null){
				sb.append("and t.idProgramacion = ? ");
				hs.add(idProgramacion);			
			}
			
			if (fechaInicio != null) {
				sb.append("and trunc(t.fechaAsistencia) >= ? ");
				hs.add(fechaInicio);
			}
			if (fechaFin != null) {
				sb.append("and trunc(t.fechaAsistencia) < ? ");
				hs.add(fechaFin);
			}
			
//			sb.append(" and t.idAsistencia = ? ");
//			hs.add(345687L);
			 sb.append(" order by t.idAsistencia desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtAsistencia> lista = super.find(sb.toString(), param);

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