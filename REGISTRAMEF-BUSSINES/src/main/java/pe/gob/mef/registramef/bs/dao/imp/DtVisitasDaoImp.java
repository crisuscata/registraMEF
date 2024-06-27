package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtVisitasDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtVisitas;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_VISITAS REPOSITORIO: LISTA DE LOS DATOS REGISTRADOS EN UNA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtVisitasDaoImp extends
		AbstractJpaCRUDDao<DtVisitas, Long> implements
		DtVisitasDao {

	private static final Logger log = Logger.getLogger(DtVisitasDaoImp.class.getName());

	public DtVisitasDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasDaoImp");
	}
	
	public DtVisitasDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasDaoImp");
	}
	
	@Transactional
	public void saveDtVisitas(DtVisitas param) {
		super.save(param);
	}

	@Transactional
	public void updateDtVisitas(DtVisitas param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtVisitas(DtVisitas param) {
		super.delete(param);
	}

	public List<DtVisitas> getAllDtVisitas() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtVisitas getDtVisitas(Long id) {
		return super.findById(id);
	}

	public List<DtVisitas> getNativeSQLDtVisitas(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtVisitas> getDomainClass() {
		return DtVisitas.class;
	}

	public List<DtVisitas> getActivasDtVisitas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	//PURIBE 01022024 - INICIO-->
		public List<DtVisitas> getActivasDtVisitasCero() {
			return super.find("from " + getDomainClass().getName()
					+ " t where id_programacion=121 and t.estado >= 0 and ROWNUM <= 10");
		}
		   //PURIBE 01022024 - FIN-->

	public List<DtVisitas> getDesactivasDtVisitas() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitas> getByIdDtVisitas(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idVisita = ? order by t.idVisita asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtVisitas> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idVisita) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (fechaVisita != null) {
			sb.append("and t.fechaVisita = ? ");
			hs.add(fechaVisita);
		}
		if (idSistAdm != null) {
			sb.append("and t.idSistAdm = ? ");
			hs.add(idSistAdm);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
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
		// sb.append("order by t.idVisita desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtVisitas> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaVisita != null) {
					sb.append("and t.fechaVisita = ? ");
					hs.add(fechaVisita);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
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
		// sb.append("order by t.idVisita desc ");

		List<DtVisitas> lista = null;
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
	public long getTotalXFiltro(Timestamp fechaVisita,Long idSistAdm,Long idSede,Long idOrigen,Long idProgramacion,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idVisita) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaVisita != null) {
					sb.append("and t.fechaVisita = ? ");
					hs.add(fechaVisita);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
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
	
	// PURIBE 14032024 - INICIO -->
	// PURIBE 04042024 - INICIO -->
			@Override
			public List<DtVisitas> getXFiltro(Timestamp fechaVisita,Long idOrigen,Long idProgramacion,Long idModalidad,Long idTipo,Long idLugar,Long idEntidad,Long idSede,Long idSistAdm,Long idFinancia,Timestamp fechaProgramada,Timestamp fechaInicio,Timestamp fechaFin,Long idUsuario) {
				
				StringBuffer sb = new StringBuffer(100);
				List<Object> hs = new ArrayList<Object>();
				sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= 0 ");

				
				if (fechaVisita != null) {
					sb.append("and t.fechaVisita = ? ");
					hs.add(fechaVisita);
				}
				if (idOrigen != null) {
					sb.append("and t.idOrigen = ? ");
					hs.add(idOrigen);
				}
				if (idProgramacion != null) {
					sb.append("and t.idProgramacion = ? ");
					hs.add(idProgramacion);
				}
				if (idModalidad != null) {
					sb.append("and t.idModalidad = ? ");
					hs.add(idModalidad);
				}
				if (idTipo != null) {
					sb.append("and t.idTipo = ? ");
					hs.add(idTipo);
				}
				if (idLugar != null) {
					sb.append("and t.idLugar = ? ");
					hs.add(idLugar);
				}
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idFinancia != null) {
					sb.append("and t.idFinancia = ? ");
					hs.add(idFinancia);
				}
				if (fechaProgramada != null) {
					sb.append("and t.fechaProgramada = ? ");
					hs.add(fechaProgramada);
				}		
				
				if (idUsuario != null) {
					sb.append("and t.idusserCrea = ? ");
					hs.add(idUsuario);
				}	
				// PURIBE 04042024 - FIN -->
			
				
				if (fechaInicio != null) {
					sb.append("and trunc(t.fechaProgramada) >= ? ");
					hs.add(fechaInicio);
				}
				if (fechaFin != null) {
					sb.append("and trunc(t.fechaProgramada) <= ? ");
					hs.add(fechaFin);
				}
			
				// sb.append("order by t.idVisita desc ");

				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				List<DtVisitas> lista = super.find(sb.toString(), param);

				return lista;
			}
			// PURIBE 14032024 - FIN -->
}