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

import pe.gob.mef.registramef.bs.dao.DtCapacitacionDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtCapacitacion;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_CAPACITACION REPOSITORIO: LISTA DE LOS DATOS REGISTRADOS EN UNA CAPACITACIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtCapacitacionDaoImp extends
		AbstractJpaCRUDDao<DtCapacitacion, Long> implements
		DtCapacitacionDao {

	private static final Logger log = Logger.getLogger(DtCapacitacionDaoImp.class.getName());

	public DtCapacitacionDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapacitacionDaoImp");
	}
	
	public DtCapacitacionDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtCapacitacionDaoImp");
	}
	
	@Transactional
	public void saveDtCapacitacion(DtCapacitacion param) {
		super.save(param);
	}

	@Transactional
	public void updateDtCapacitacion(DtCapacitacion param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtCapacitacion(DtCapacitacion param) {
		super.delete(param);
	}

	public List<DtCapacitacion> getAllDtCapacitacion() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtCapacitacion getDtCapacitacion(Long id) {
		return super.findById(id);
	}

	public List<DtCapacitacion> getNativeSQLDtCapacitacion(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtCapacitacion> getDomainClass() {
		return DtCapacitacion.class;
	}

	public List<DtCapacitacion> getActivasDtCapacitacion() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtCapacitacion> getActivasDtCapacitacionCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapacitacion> getDesactivasDtCapacitacion() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtCapacitacion> getByIdDtCapacitacion(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idCapacitacion = ? order by t.idCapacitacion asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtCapacitacion> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idCapacitacion) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtCapacitacion> getXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (fechaInic != null) {
			sb.append("and t.fechaInic = ? ");
			hs.add(fechaInic);
		}
		if (fechaFin != null) {
			sb.append("and t.fechaFin = ? ");
			hs.add(fechaFin);
		}
		if (nomEvento != null) {
			sb.append("and t.nomEvento = ? ");
			hs.add(nomEvento);
		}
		if (idSistAdm != null) {
			sb.append("and t.idSistAdm = ? ");
			hs.add(idSistAdm);
		}
		if (idUsuinterno != null) {
			sb.append("and t.idUsuinterno = ? ");
			hs.add(idUsuinterno);
		}
		if (flagPubli != null) {
			sb.append("and t.flagPubli = ? ");
			hs.add(flagPubli);
		}
		if (idModalidad != null) {
			sb.append("and t.idModalidad = ? ");
			hs.add(idModalidad);
		}
		if (idProgramacion != null) {
			sb.append("and t.idProgramacion = ? ");
			hs.add(idProgramacion);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}
		if (cantPartic != null) {
			sb.append("and t.cantPartic = ? ");
			hs.add(cantPartic);
		}		
		// sb.append("order by t.idCapacitacion desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtCapacitacion> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtCapacitacion> getXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaInic != null) {
					sb.append("and t.fechaInic = ? ");
					hs.add(fechaInic);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
				}
				if (nomEvento != null) {
					sb.append("and t.nomEvento = ? ");
					hs.add(nomEvento);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
				}
				if (flagPubli != null) {
					sb.append("and t.flagPubli = ? ");
					hs.add(flagPubli);
				}
				if (idModalidad != null) {
					sb.append("and t.idModalidad = ? ");
					hs.add(idModalidad);
				}
				if (idProgramacion != null) {
					sb.append("and t.idProgramacion = ? ");
					hs.add(idProgramacion);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
				if (cantPartic != null) {
					sb.append("and t.cantPartic = ? ");
					hs.add(cantPartic);
				}
		// sb.append("order by t.idCapacitacion desc ");

		List<DtCapacitacion> lista = null;
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
	public long getTotalXFiltro(Timestamp fechaInic,Timestamp fechaFin,String nomEvento,Long idSistAdm,Long idUsuinterno,Long flagPubli,Long idModalidad,Long idProgramacion,Long estado,Integer cantPartic) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idCapacitacion) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (fechaInic != null) {
					sb.append("and t.fechaInic = ? ");
					hs.add(fechaInic);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
				}
				if (nomEvento != null) {
					sb.append("and t.nomEvento = ? ");
					hs.add(nomEvento);
				}
				if (idSistAdm != null) {
					sb.append("and t.idSistAdm = ? ");
					hs.add(idSistAdm);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
				}
				if (flagPubli != null) {
					sb.append("and t.flagPubli = ? ");
					hs.add(flagPubli);
				}
				if (idModalidad != null) {
					sb.append("and t.idModalidad = ? ");
					hs.add(idModalidad);
				}
				if (idProgramacion != null) {
					sb.append("and t.idProgramacion = ? ");
					hs.add(idProgramacion);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
				if (cantPartic != null) {
					sb.append("and t.cantPartic = ? ");
					hs.add(cantPartic);
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
		@Override
		public List<DtCapacitacion> getXFiltroV(Date fechaInicio, Date fechaFin,Long idProgramacion) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() 
//					+ " t where t.estado >= 0 ");
					+ " t where (t.estado="+Estado.ACTIVO.getValor()+ " or t.estado="+Estado.ELIMINADO.getValor()+" or t.estado="+Estado.FINALIZADO.getValor()+") ");
			
			if(idProgramacion!=null){
				sb.append("and t.idProgramacion = ? ");
				hs.add(idProgramacion);			
			}
			
			if (fechaInicio != null) {
				sb.append("and trunc(t.fechaInic) >= ? ");
				hs.add(fechaInicio);
			}
			if (fechaFin != null) {
				sb.append("and trunc(t.fechaInic) < ? ");
				hs.add(fechaFin);
			}
				
			 sb.append("order by t.idCapacitacion desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtCapacitacion> lista = super.find(sb.toString(), param);

			return lista;
		}
		
		@Override
		public List<DtCapacitacion> getXFiltroV2(Date fechaInicio, Date fechaFin,Long idProgramacion, Long idSede,Long idSistAdm, Long idUsuario) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() 
//					+ " t where t.estado >= 0 ");
					+ " t where (t.estado="+Estado.ACTIVO.getValor()+ " or t.estado="+Estado.ELIMINADO.getValor()+" or t.estado="+Estado.FINALIZADO.getValor()+") ");
			
			if(idProgramacion!=null){
				sb.append("and t.idProgramacion = ? ");
				hs.add(idProgramacion);			
			}
			
			if (fechaInicio != null) {
				sb.append("and trunc(t.fechaInic) >= ? ");
				hs.add(fechaInicio);
			}
			if (fechaFin != null) {
				sb.append("and trunc(t.fechaInic) < ? ");
				hs.add(fechaFin);
			}
			
			if (idSede != null) {
				sb.append("and t.idSede = ? ");
				hs.add(idSede);
			}
			if (idSistAdm != null) {
				sb.append("and t.idSistAdm = ? ");
				hs.add(idSistAdm);
			}
			
			if (idUsuario != null) {
				sb.append("and t.idusserCrea = ? ");
				hs.add(idUsuario);
			}	
				
			 sb.append("order by t.idCapacitacion desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtCapacitacion> lista = super.find(sb.toString(), param);

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
		
		public List<DtCapacitacion> getDtcapaXIDPadre(Long idCapaPadre) {
			
			StringBuffer sb = new StringBuffer(100);
	        List<Object> hs = new ArrayList<Object>();		
			sb.append("select t from " + getDomainClass().getName()	+ " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
			
			if (idCapaPadre != null && idCapaPadre.longValue() > 0) {
				sb.append("and t.idcapaPadre = ? ");
				hs.add(idCapaPadre);
			}

			sb.append("order by t.idCapacitacion desc  ");
			
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtCapacitacion> lista = super.find(sb.toString(), param);

			return lista;	
		}

		
		//MPINARES 14022024 - FIN
}