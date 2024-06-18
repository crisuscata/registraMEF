package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsSubtemaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsSubtema;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_SUBTEMA REPOSITORIO: LISTA DE LOS SUBTEMAS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsSubtemaDaoImp extends
		AbstractJpaCRUDDao<MsSubtema, Long> implements
		MsSubtemaDao {

	private static final Logger log = Logger.getLogger(MsSubtemaDaoImp.class.getName());

	public MsSubtemaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSubtemaDaoImp");
	}
	
	public MsSubtemaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSubtemaDaoImp");
	}
	
	@Transactional
	public void saveMsSubtema(MsSubtema param) {
		super.save(param);
	}

	@Transactional
	public void updateMsSubtema(MsSubtema param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsSubtema(MsSubtema param) {
		super.delete(param);
	}

	public List<MsSubtema> getAllMsSubtema() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsSubtema getMsSubtema(Long id) {
		return super.findById(id);
	}

	public List<MsSubtema> getNativeSQLMsSubtema(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsSubtema> getDomainClass() {
		return MsSubtema.class;
	}

	public List<MsSubtema> getActivasMsSubtema() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsSubtema> getActivasMsSubtemaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsSubtema> getDesactivasMsSubtema() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsSubtema> getByIdMsSubtema(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idSubtema = ? order by t.idSubtema asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsSubtema> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idSubtema) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsSubtema> getXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idTema != null) {
			sb.append("and t.idTema = ? ");
			hs.add(idTema);
		}
		if (descripcion != null) {
			sb.append("and t.descripcion = ? ");
			hs.add(descripcion);
		}
		if (fechaCrea != null) {
			sb.append("and t.fechaCrea = ? ");
			hs.add(fechaCrea);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idSubtema desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsSubtema> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsSubtema> getXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (descripcion != null) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idSubtema desc ");

		List<MsSubtema> lista = null;
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
	public long getTotalXFiltro(Long idTema,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idSubtema) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idTema != null) {
					sb.append("and t.idTema = ? ");
					hs.add(idTema);
				}
				if (descripcion != null) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
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
	
	@Override
	public List<MsSubtema> getListaIdSubtema() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsSubtema tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("ORDER BY tablaa.idSubtema asc ");
		return super.find(sb.toString());
	}
	
	//MPINARES 24012023 - INICIO
	
		public List<MsSubtema> getSubTemaByIdSistemaAdminTema(Long idTema) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.estado >= " + Estado.ACTIVO.getValor() + " ");

			if (idTema != null && idTema.longValue() > 0) {
				sb.append("and t.idTema = ? ");
				hs.add(idTema);
			}


			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<MsSubtema> lista = super.find(sb.toString(), param);

			return lista;
		}

//			public Long getEstadoNuevo() {
//				return estadoNuevo;
//			}
//
//			public void setEstadoNuevo(Long estadoNuevo) {
//				this.estadoNuevo = estadoNuevo;
//			}
//
//			public Long getEstadoEliminado() {
//				return estadoEliminado;
//			}
//
//			public void setEstadoEliminado(Long estadoEliminado) {
//				this.estadoEliminado = estadoEliminado;
//			}
//			
			//MPINARES 24012023 - FIN
}