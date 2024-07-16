package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsTemaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsTema;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_TEMA REPOSITORIO: LISTA DE LOS TEMAS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsTemaDaoImp extends
		AbstractJpaCRUDDao<MsTema, Long> implements
		MsTemaDao {

	private static final Logger log = Logger.getLogger(MsTemaDaoImp.class.getName());

	public MsTemaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsTemaDaoImp");
	}
	
	public MsTemaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsTemaDaoImp");
	}
	
	@Transactional
	public void saveMsTema(MsTema param) {
		super.save(param);
	}

	@Transactional
	public void updateMsTema(MsTema param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsTema(MsTema param) {
		super.delete(param);
	}

	public List<MsTema> getAllMsTema() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsTema getMsTema(Long id) {
		return super.findById(id);
	}

	public List<MsTema> getNativeSQLMsTema(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsTema> getDomainClass() {
		return MsTema.class;
	}

	public List<MsTema> getActivasMsTema() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsTema> getActivasMsTemaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsTema> getDesactivasMsTema() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsTema> getByIdMsTema(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idTema = ? order by t.idTema asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsTema> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idTema) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsTema> getXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idSistAdmi != null) {
			sb.append("and t.idSistAdmi = ? ");
			hs.add(idSistAdmi);
		}
		if (descripcion != null && descripcion.trim().length() > 0) {
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
		// sb.append("order by t.idTema desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsTema> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsTema> getXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (descripcion != null && descripcion.trim().length() > 0) {
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
		// sb.append("order by t.idTema desc ");

		List<MsTema> lista = null;
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
	public long getTotalXFiltro(Long idSistAdmi,String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idTema) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (descripcion != null && descripcion.trim().length() > 0) {
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
		public List<MsTema> getListaIdTema() {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM MsTema tablaa ");
			sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
			sb.append("ORDER BY tablaa.descripcion asc ");
			return super.find(sb.toString());
		}
	 
	//MPINARES 24012023 - INICIO
		public List<MsTema> getTemaByIdSistemaAdmin(Long idSistemaAdmin) {
			List<MsTema> lista = new ArrayList<MsTema>();
			try {
				StringBuffer sb = new StringBuffer(100);			
				sb.append("select t from " + getDomainClass().getName()	+ " t ");

				if (idSistemaAdmin != null && idSistemaAdmin.intValue() >= 0) {
					sb.append(" where t.estado >= " + Estado.ACTIVO.getValor() );
					sb.append(" and t.idSistAdmi = ? ");	
					sb.append(" order by t.descripcion asc ");
				}			
				Object param[] = new Object[1];
				param[0] = idSistemaAdmin;
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
		
		//PURIBE 14032024 - INICIO-->
		@Override
		public List<MsTema> getXFiltro(String descripcion, Long idSistAdmi, Long tipoServicio) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >=  "+ Estado.ACTIVO.getValor()+" ");

			if (descripcion != null && descripcion.trim().length() > 0) {
				sb.append("and t.descripcion = ? ");
				hs.add(descripcion);
			}
			if (idSistAdmi != null) {
				sb.append("and t.idSistAdmi = ? ");
				hs.add(idSistAdmi);
			}
			if (tipoServicio != null) {
				sb.append("and t.tipoServicio = ? ");
				hs.add(tipoServicio);
			}
			 sb.append("order by t.descripcion asc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<MsTema> lista = super.find(sb.toString(), param);

			return lista;
		}
		//PURIBE 14032024 - FIN-->
}