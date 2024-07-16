package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsSedesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsSedes;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_SEDES REPOSITORIO: LISTA LAS SEDES REGISTRADAS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsSedesDaoImp extends
		AbstractJpaCRUDDao<MsSedes, Long> implements
		MsSedesDao {

	private static final Logger log = Logger.getLogger(MsSedesDaoImp.class.getName());

	public MsSedesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSedesDaoImp");
	}
	
	public MsSedesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSedesDaoImp");
	}
	
	@Transactional
	public void saveMsSedes(MsSedes param) {
		super.save(param);
	}

	@Transactional
	public void updateMsSedes(MsSedes param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsSedes(MsSedes param) {
		super.delete(param);
	}

	public List<MsSedes> getAllMsSedes() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsSedes getMsSedes(Long id) {
		return super.findById(id);
	}

	public List<MsSedes> getNativeSQLMsSedes(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsSedes> getDomainClass() {
		return MsSedes.class;
	}

	public List<MsSedes> getActivasMsSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsSedes> getActivasMsSedesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsSedes> getDesactivasMsSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsSedes> getByIdMsSedes(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idSede = ? order by t.idSede asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsSedes> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idSede) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsSedes> getXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (sede != null && sede.trim().length() > 0) {
			sb.append("and t.sede = ? ");
			hs.add(sede);
		}
		if (idGrupo != null) {
			sb.append("and t.idGrupo = ? ");
			hs.add(idGrupo);
		}
		if (idMacregion != null) {
			sb.append("and t.idMacregion = ? ");
			hs.add(idMacregion);
		}
		if (sigla != null && sigla.trim().length() > 0) {
			sb.append("and t.sigla = ? ");
			hs.add(sigla);
		}
		if (codDpto != null) {
			sb.append("and t.codDpto = ? ");
			hs.add(codDpto);
		}
		if (direccion != null) {
			sb.append("and t.direccion = ? ");
			hs.add(direccion);
		}
		if (orden != null) {
			sb.append("and t.orden = ? ");
			hs.add(orden);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idSede desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsSedes> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsSedes> getXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (sede != null && sede.trim().length() > 0) {
					sb.append("and t.sede = ? ");
					hs.add(sede);
				}
				if (idGrupo != null) {
					sb.append("and t.idGrupo = ? ");
					hs.add(idGrupo);
				}
				if (idMacregion != null) {
					sb.append("and t.idMacregion = ? ");
					hs.add(idMacregion);
				}
				if (sigla != null && sigla.trim().length() > 0) {
					sb.append("and t.sigla = ? ");
					hs.add(sigla);
				}
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (direccion != null) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (orden != null) {
					sb.append("and t.orden = ? ");
					hs.add(orden);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idSede desc ");

		List<MsSedes> lista = null;
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
	public long getTotalXFiltro(String sede,Long idGrupo,Long idMacregion,String sigla,Integer codDpto,String direccion,Long orden,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idSede) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (sede != null && sede.trim().length() > 0) {
					sb.append("and t.sede = ? ");
					hs.add(sede);
				}
				if (idGrupo != null) {
					sb.append("and t.idGrupo = ? ");
					hs.add(idGrupo);
				}
				if (idMacregion != null) {
					sb.append("and t.idMacregion = ? ");
					hs.add(idMacregion);
				}
				if (sigla != null && sigla.trim().length() > 0) {
					sb.append("and t.sigla = ? ");
					hs.add(sigla);
				}
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (direccion != null) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (orden != null) {
					sb.append("and t.orden = ? ");
					hs.add(orden);
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
	public List<MsSedes> getListaIdSede() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsSedes tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("ORDER BY tablaa.sede asc ");
		return super.find(sb.toString());
	}
	
	//MPINARES 24012023 - INICIO
//		@Override
//		public List<MsSedes> getListaIdSede() {
//			StringBuffer sb = new StringBuffer(100);
//			sb.append("SELECT tablaa FROM MsSedes tablaa ");
//			sb.append("WHERE tablaa.estado >= 1 ");
//			sb.append("ORDER BY tablaa.sede asc ");
//			return super.find(sb.toString());
//		}
		//MPINARES 24012023 - FIN
}