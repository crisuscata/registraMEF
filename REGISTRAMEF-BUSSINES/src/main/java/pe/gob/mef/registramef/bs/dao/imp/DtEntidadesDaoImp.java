package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtEntidadesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEntidades;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ENTIDADES REPOSITORIO: LISTA DE LAS ENTIDADES REGISTRADAS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEntidadesDaoImp extends 
		AbstractJpaCRUDDao<DtEntidades, Long> implements
		DtEntidadesDao {

	private static final Logger log = Logger.getLogger(DtEntidadesDaoImp.class.getName());

	public DtEntidadesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadesDaoImp");
	}
	
	public DtEntidadesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadesDaoImp");
	}
	
	@Transactional
	public void saveDtEntidades(DtEntidades param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEntidades(DtEntidades param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEntidades(DtEntidades param) {
		super.delete(param);
	}

	public List<DtEntidades> getAllDtEntidades() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEntidades getDtEntidades(Long id) {
		return super.findById(id);
	}

	public List<DtEntidades> getNativeSQLDtEntidades(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEntidades> getDomainClass() {
		return DtEntidades.class;
	}

	public List<DtEntidades> getActivasDtEntidades() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEntidades> getActivasDtEntidadesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidades> getDesactivasDtEntidades() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidades> getByIdDtEntidades(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idEntidad = ? order by t.idEntidad asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEntidades> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idEntidad) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtEntidades> getXFiltro2(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (codEjec != null && codEjec.trim().length() > 0) {
			sb.append("and t.codEjec = ? ");
			hs.add(codEjec);
		}
		if (razSocial != null && razSocial.trim().length() > 0) {
			sb.append("and t.razSocial = ? ");
			hs.add(razSocial);
		}
		if (ruc != null) {
			sb.append("and t.ruc = ? ");
			hs.add(ruc);
		}
		if (idTipo != null) {
			sb.append("and t.idTipo = ? ");
			hs.add(idTipo);
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
		if (idCaract != null) {
			sb.append("and t.idCaract = ? ");
			hs.add(idCaract);
		}
		if (idSistAdmi != null) {
			sb.append("and t.idSistAdmi = ? ");
			hs.add(idSistAdmi);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idEntidad desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtEntidades> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtEntidades> getXFiltro(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codEjec != null && codEjec.trim().length() > 0) {
					sb.append("and t.codEjec = ? ");
					hs.add(codEjec);
				}
				if (razSocial != null && razSocial.trim().length() > 0) {
					sb.append("and t.razSocial = ? ");
					hs.add(razSocial);
				}
				if (ruc != null) {
					sb.append("and t.ruc = ? ");
					hs.add(ruc);
				}
				if (idTipo != null) {
					sb.append("and t.idTipo = ? ");
					hs.add(idTipo);
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
				if (idCaract != null) {
					sb.append("and t.idCaract = ? ");
					hs.add(idCaract);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idEntidad desc ");

		List<DtEntidades> lista = null;
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
	public long getTotalXFiltro(String codEjec,String razSocial,Long ruc,Long idTipo,Integer codDpto,Integer codProv,Integer codDistr,Long idCaract,Long idSistAdmi,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idEntidad) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codEjec != null && codEjec.trim().length() > 0) {
					sb.append("and t.codEjec = ? ");
					hs.add(codEjec);
				}
				if (razSocial != null && razSocial.trim().length() > 0) {
					sb.append("and t.razSocial = ? ");
					hs.add(razSocial);
				}
				if (ruc != null) {
					sb.append("and t.ruc = ? ");
					hs.add(ruc);
				}
				if (idTipo != null) {
					sb.append("and t.idTipo = ? ");
					hs.add(idTipo);
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
				if (idCaract != null) {
					sb.append("and t.idCaract = ? ");
					hs.add(idCaract);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
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
		public List<DtEntidades> getListaRazSocial(String razSocial) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM DtEntidades tablaa ");
			sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" AND tablaa.razSocial LIKE '%"+razSocial+"%'");
			sb.append("ORDER BY tablaa.razSocial asc ");
			return super.find(sb.toString());
		}
	 
	 @Override
		public List<DtEntidades> getListaIdEntidad() {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM DtEntidades tablaa ");
			sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
			sb.append("ORDER BY tablaa.idEntidad asc ");
			return super.find(sb.toString());
		}
	 
	//MPINARES 24012023 - INICIO
		@Override
		public List<DtEntidades> getListaRasonsocial(String razonsocial) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM DtEntidades tablaa ");
			sb.append("WHERE tablaa.estado > 2 ");
			sb.append("AND tablaa.razSocial LIKE '%"+razonsocial+"%'");
			sb.append("ORDER BY tablaa.razSocial asc ");
			return super.find(sb.toString());
		}
		
		@Override
		public List<DtEntidades> getListaRasonsocialXSisAdmin(String razonsocial, Long idSistAdmi) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("SELECT tablaa FROM DtEntidades tablaa, DtEntidadSisAdmin e ");
			sb.append("WHERE tablaa.idEntidad=e.idEntidad and tablaa.estado >= "+Estado.ACTIVO.getValor()+" and e.estado >= "+Estado.ACTIVO.getValor()+" ");
			sb.append("AND e.idSistAdmi = "+idSistAdmi+" ");
			sb.append("AND tablaa.razSocial LIKE '%"+razonsocial+"%'");
			sb.append(" ORDER BY tablaa.razSocial asc ");
			return super.find(sb.toString());
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
		
		//PURIBE 14032024 -INICIO-->
		@Override
		public List<DtEntidades> getXFiltro(String codEjec, String razSocial, Long ruc, Long idTipo, Long idCaract,
				Integer codDpto, Integer codProv, Integer codDistr, Long idSistAdmi, String geozona) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+ Estado.ACTIVO.getValor() +" ");

			if (codEjec != null && codEjec.trim().length() > 0) {
				sb.append("and t.codEjec = ? ");
				hs.add(codEjec);
			}
			if (razSocial != null && razSocial.trim().length() > 0) {
				sb.append("and t.razSocial = ? ");
				hs.add(razSocial);
			}
			if (ruc != null) {
				sb.append("and t.ruc = ? ");
				hs.add(ruc);
			}
			if (idTipo != null) {
				sb.append("and t.idTipo = ? ");
				hs.add(idTipo);
			}
			if (idCaract != null) {
				sb.append("and t.idCaract = ? ");
				hs.add(idCaract);
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
			if (idSistAdmi != null) {
				sb.append("and t.idSistAdmi = ? ");
				hs.add(idSistAdmi);
			}
			if (geozona != null) {
				sb.append("and t.geozona = ? ");
				hs.add(geozona);
			}
			// sb.append("order by t.idEntidad desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtEntidades> lista = super.find(sb.toString(), param);

			return lista;
		}
		//PURIBE 14032024 - FIN-->
	 
}