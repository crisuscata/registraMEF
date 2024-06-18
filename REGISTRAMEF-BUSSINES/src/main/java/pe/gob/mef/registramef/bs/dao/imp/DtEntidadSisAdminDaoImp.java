package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtEntidadSisAdminDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEntidadSisAdmin;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ENTIDAD_SIS_ADMIN REPOSITORIO: LISTA DE LOS SISTEMAS ADMINISTRATIVOS ASIGNADOS A LA ENTIDAD
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEntidadSisAdminDaoImp extends
		AbstractJpaCRUDDao<DtEntidadSisAdmin, Long> implements
		DtEntidadSisAdminDao {

	private static final Logger log = Logger.getLogger(DtEntidadSisAdminDaoImp.class.getName());

	public DtEntidadSisAdminDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadSisAdminDaoImp");
	}
	
	public DtEntidadSisAdminDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadSisAdminDaoImp");
	}
	
	@Transactional
	public void saveDtEntidadSisAdmin(DtEntidadSisAdmin param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEntidadSisAdmin(DtEntidadSisAdmin param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEntidadSisAdmin(DtEntidadSisAdmin param) {
		super.delete(param);
	}

	public List<DtEntidadSisAdmin> getAllDtEntidadSisAdmin() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEntidadSisAdmin getDtEntidadSisAdmin(Long id) {
		return super.findById(id);
	}

	public List<DtEntidadSisAdmin> getNativeSQLDtEntidadSisAdmin(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEntidadSisAdmin> getDomainClass() {
		return DtEntidadSisAdmin.class;
	}

	public List<DtEntidadSisAdmin> getActivasDtEntidadSisAdmin() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEntidadSisAdmin> getActivasDtEntidadSisAdminCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadSisAdmin> getDesactivasDtEntidadSisAdmin() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadSisAdmin> getByIdDtEntidadSisAdmin(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.identidadSisadm = ? order by t.identidadSisadm asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEntidadSisAdmin> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.identidadSisadm) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtEntidadSisAdmin> getXFiltro(Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}		
		// sb.append("order by t.identidadSisadm desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtEntidadSisAdmin> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtEntidadSisAdmin> getXFiltro(Long idEntidad, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
		// sb.append("order by t.identidadSisadm desc ");

		List<DtEntidadSisAdmin> lista = null;
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
	public long getTotalXFiltro(Long idEntidad) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.identidadSisadm) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
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
		public List<DtEntidadSisAdmin> getDtEntidadSistemaAdminByIdEntity(Long idEntidad) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.estado >= " + Estado.ACTIVO.getValor() + " ");

			if (idEntidad != null && idEntidad.longValue() > 0) {
				sb.append(" and t.idEntidad = ? ");
				hs.add(idEntidad);
			}

			sb.append(" order by t.idEntidad asc  ");

			List<DtEntidadSisAdmin> lista = null;
			if (hs.size() > 0) {
				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				lista = super.find(sb.toString(), param);
				return lista;
			} else {
				lista = super.find(sb.toString());
				return lista;
			}
		}
		
//		public Long getEstadoNuevo() {
//			return estadoNuevo;
//		}
//		public void setEstadoNuevo(Long estadoNuevo) {
//			this.estadoNuevo = estadoNuevo;
//		}
//		public Long getEstadoEliminado() {
//			return estadoEliminado;
//		}
//		public void setEstadoEliminado(Long estadoEliminado) {
//			this.estadoEliminado = estadoEliminado;
//		}		
		//MPINARES 24012023 - FIN
}