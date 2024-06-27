package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.dao.MsRolesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsRoles;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_ROLES REPOSITORIO: ALMACENA LOS ROLES DEL SISTEMA "ROLES"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 19:52
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 19:52   / Creación de la clase    /
 * 
 */
@Repository
public class MsRolesDaoImp extends
		AbstractJpaCRUDDao<MsRoles, Long> implements
		MsRolesDao {

	private static final Logger log = Logger.getLogger(MsRolesDaoImp.class.getName());

	public MsRolesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsRolesDaoImp");
	}
	
	public MsRolesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsRolesDaoImp");
	}
	
	@Transactional
	public void saveMsRoles(MsRoles param) {
		super.save(param);
	}

	@Transactional
	public void updateMsRoles(MsRoles param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsRoles(MsRoles param) {
		super.delete(param);
	}

	public List<MsRoles> getAllMsRoles() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsRoles getMsRoles(Long id) {
		return super.findById(id);
	}

	public List<MsRoles> getNativeSQLMsRoles(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsRoles> getDomainClass() {
		return MsRoles.class;
	}

	public List<MsRoles> getActivasMsRoles() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsRoles> getActivasMsRolesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsRoles> getDesactivasMsRoles() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsRoles> getByIdMsRoles(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idrol = ? order by t.idrol asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsRoles> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idrol) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsRoles> getXFiltro(String username,String rol) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (username != null && username.trim().length() > 0) {
			sb.append("and t.username = ? ");
			hs.add(username);
		}
		if (rol != null && rol.trim().length() > 0) {
			sb.append("and t.rol = ? ");
			hs.add(rol);
		}		
		// sb.append("order by t.idrol desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsRoles> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsRoles> getXFiltro(String username,String rol, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (username != null && username.trim().length() > 0) {
					sb.append("and t.username = ? ");
					hs.add(username);
				}
				if (rol != null && rol.trim().length() > 0) {
					sb.append("and t.rol = ? ");
					hs.add(rol);
				}
		// sb.append("order by t.idrol desc ");

		List<MsRoles> lista = null;
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
	public long getTotalXFiltro(String username,String rol) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idrol) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (username != null && username.trim().length() > 0) {
					sb.append("and t.username = ? ");
					hs.add(username);
				}
				if (rol != null && rol.trim().length() > 0) {
					sb.append("and t.rol = ? ");
					hs.add(rol);
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
	public MsRoles getXUserRol(String username, String rol) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + this.getDomainClass().getName() + " t where t.username = ? and t.rol = ? ");
		hs.add(username);
		hs.add(rol);
		MsRoles msRoles = null;

		try {
			Object[] param = new Object[hs.size()];
			hs.toArray(param);
			msRoles = (MsRoles) super.findUniqueResultObject(sb.toString(), param);
		} catch (Exception var7) {
			;
		}

		return msRoles;
	}
	
	//MPINARES 24012023 - INICIO
		public boolean isRolAdministradorOGC(Long idUsuario) throws Validador{
			//System.out.println("isRolAdministradorOGC("+idUsuario+")");
			StringBuilder query = new StringBuilder();
			query.append(" SELECT r.rol ");
			query.append(" FROM MsUsuarios u, MsRoles r ");
			query.append(" WHERE u.idusuario = ? ");
			query.append(" AND u.estado = ? ");
			query.append(" AND u.username=r.username ");
			query.append(" and r.estado = ? ");
			Object[] params = new Object[3];
			params[0] = idUsuario;
			params[1] = Estado.ACTIVO.getValor();
			params[2] = Estado.ACTIVO.getValor();
			List<String> lista = findList(query.toString(), params);
			if(CollectionUtils.isEmpty(lista)){
				return false;
			}else{
				for (String rol : lista) {
//					if(rol.equals(Roles.ADMINISTRADOR_OGC)) return true;
					if(rol.equals(Roles.PERFIL_USU_OGC)) return true; //PURIBE 14032024 - INICIO -->
				}
				return false;
			}
		}
		//MPINARES 24012023 - FIN
		
		public List<MsRoles> getXFiltro(String username) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
			if (username != null && username.trim().length() > 0) {
				sb.append("and t.username = ?1 ");
				hs.add(username);
			}

			Object[] param = new Object[hs.size()];
			hs.toArray(param);
			List<MsRoles> lista = super.find(sb.toString(), param);
			return lista;
		}
}