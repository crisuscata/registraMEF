package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsLocalDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsLocal;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_LOCAL REPOSITORIO: LISTA DE LOS LOCALES REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsLocalDaoImp extends
		AbstractJpaCRUDDao<MsLocal, Long> implements
		MsLocalDao {

	private static final Logger log = Logger.getLogger(MsLocalDaoImp.class.getName());

	public MsLocalDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsLocalDaoImp");
	}
	
	public MsLocalDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsLocalDaoImp");
	}
	
	@Transactional
	public void saveMsLocal(MsLocal param) {
		super.save(param);
	}

	@Transactional
	public void updateMsLocal(MsLocal param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsLocal(MsLocal param) {
		super.delete(param);
	}

	public List<MsLocal> getAllMsLocal() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsLocal getMsLocal(Long id) {
		return super.findById(id);
	}

	public List<MsLocal> getNativeSQLMsLocal(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsLocal> getDomainClass() {
		return MsLocal.class;
	}

	public List<MsLocal> getActivasMsLocal() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor()+" order by t.descripcion asc ");
	}
	
	public List<MsLocal> getActivasMsLocalCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsLocal> getDesactivasMsLocal() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsLocal> getByIdMsLocal(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idLocal = ? order by t.idLocal asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsLocal> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idLocal) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsLocal> getXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (descripcion != null && descripcion.trim().length() > 0) {
			sb.append("and t.descripcion = ? ");
			hs.add(descripcion);
		}
		if (direccion != null && direccion.trim().length() > 0) {
			sb.append("and t.direccion = ? ");
			hs.add(direccion);
		}
		if (referencia != null && referencia.trim().length() > 0) {
			sb.append("and t.referencia = ? ");
			hs.add(referencia);
		}
		if (codDpto != null) {
			sb.append("and t.codDpto = ? ");
			hs.add(codDpto);
		}
		if (codProv != null) {
			sb.append("and t.codProv = ? ");
			hs.add(codProv);
		}
		if (codDistr != null) {
			sb.append("and t.codDistr = ? ");
			hs.add(codDistr);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idLocal desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsLocal> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsLocal> getXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (direccion != null && direccion.trim().length() > 0) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (referencia != null && referencia.trim().length() > 0) {
					sb.append("and t.referencia = ? ");
					hs.add(referencia);
				}
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.codDistr = ? ");
					hs.add(codDistr);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idLocal desc ");

		List<MsLocal> lista = null;
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
	public long getTotalXFiltro(String descripcion,String direccion,String referencia,Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idLocal) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (direccion != null && direccion.trim().length() > 0) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (referencia != null && referencia.trim().length() > 0) {
					sb.append("and t.referencia = ? ");
					hs.add(referencia);
				}
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.codDistr = ? ");
					hs.add(codDistr);
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
	public List<MsLocal> getListaIdLocal() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsLocal tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("ORDER BY tablaa.idLocal asc ");
		return super.find(sb.toString());
	}
	//MPINARES 14022024 - INICIO
	 
		 public List<MsLocal> getLocalByIdSede(Long idSede) {
				List<MsLocal> lista = new ArrayList<MsLocal>();
				try {
					StringBuffer sb = new StringBuffer(100);			
					sb.append("select t from " + getDomainClass().getName()	+ " t ");

					if (idSede != null && idSede.intValue() >= 0) {
						sb.append(" where t.estado >= " + Estado.ACTIVO.getValor() );
						sb.append(" and t.idSede = ? ");	
						sb.append(" order by t.descripcion asc ");
					}			
					Object param[] = new Object[1];
					param[0] = idSede;
					lista = super.find(sb.toString(), param);						
					
				} catch (Exception e) {
					log.info(e.getMessage());
				}		
				return lista;		
			}
		 
		//MPINARES 14022024 - FIN
}