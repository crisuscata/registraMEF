package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.ctlracceso.Roles;
import pe.gob.mef.registramef.bs.dao.MsUsuariosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsUsuarios;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_USUARIOS REPOSITORIO: ALMACENA LOS USUARIOS INTERNOS REGISTRADOS EN EL SISTEMA "USUARIOS INTERNOS"
 * 
 * @author Carlos Aguilar
 * @version 2.0, 18/12/2023 19:52
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 18/12/2023 19:52   / Creación de la clase    /
 * 
 */
@Repository
public class MsUsuariosDaoImp extends
		AbstractJpaCRUDDao<MsUsuarios, Long> implements
		MsUsuariosDao {

	private static final Logger log = Logger.getLogger(MsUsuariosDaoImp.class.getName());

	public MsUsuariosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsUsuariosDaoImp");
	}
	
	public MsUsuariosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsUsuariosDaoImp");
	}
	
	@Transactional
	public void saveMsUsuarios(MsUsuarios param) {
		super.save(param);
	}

	@Transactional
	public void updateMsUsuarios(MsUsuarios param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsUsuarios(MsUsuarios param) {
		super.delete(param);
	}

	public List<MsUsuarios> getAllMsUsuarios() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsUsuarios getMsUsuarios(Long id) {
		return super.findById(id);
	}

	public List<MsUsuarios> getNativeSQLMsUsuarios(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsUsuarios> getDomainClass() {
		return MsUsuarios.class;
	}

	public List<MsUsuarios> getActivasMsUsuarios() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ACTIVO.getValor() + " order by t.apellidoPaterno, t.apellidoMaterno, t.nombres ");
	}
	
	public List<MsUsuarios> getActivasMsUsuariosCero() {
		return super.find("from " + getDomainClass().getName()
//				+ " t where t.idusuario=1 and t.estado >= "+Estado.ELIMINADO.getValor());//QUITAR t.idusuario=1 and
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());//QUITAR t.idusuario=1 and
	}

	public List<MsUsuarios> getDesactivasMsUsuarios() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsUsuarios> getByIdMsUsuarios(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idusuario = ? order by t.idusuario asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsUsuarios> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idusuario) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsUsuarios> getXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (dni != null) {
			sb.append("and t.dni = ? ");
			hs.add(dni);
		}
		if (nombres != null && nombres.trim().length() > 0) {
			sb.append("and t.nombres = ? ");
			hs.add(nombres);
		}
		if (apellidoPaterno != null && apellidoPaterno.trim().length() > 0) {
			sb.append("and t.apellidoPaterno = ? ");
			hs.add(apellidoPaterno);
		}
		if (apellidoMaterno != null && apellidoMaterno.trim().length() > 0) {
			sb.append("and t.apellidoMaterno = ? ");
			hs.add(apellidoMaterno);
		}
		if (fechaInic != null) {
			sb.append("and t.fechaInic = ? ");
			hs.add(fechaInic);
		}
		if (fechaCese != null) {
			sb.append("and t.fechaCese = ? ");
			hs.add(fechaCese);
		}
		if (direccion != null && direccion.trim().length() > 0) {
			sb.append("and t.direccion = ? ");
			hs.add(direccion);
		}
		if (username != null && username.trim().length() > 0) {
			sb.append("and t.username = ? ");
			hs.add(username);
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
		// sb.append("order by t.idusuario desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsUsuarios> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsUsuarios> getXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (dni != null) {
					sb.append("and t.dni = ? ");
					hs.add(dni);
				}
				if (nombres != null && nombres.trim().length() > 0) {
					sb.append("and t.nombres = ? ");
					hs.add(nombres);
				}
				if (apellidoPaterno != null && apellidoPaterno.trim().length() > 0) {
					sb.append("and t.apellidoPaterno = ? ");
					hs.add(apellidoPaterno);
				}
				if (apellidoMaterno != null && apellidoMaterno.trim().length() > 0) {
					sb.append("and t.apellidoMaterno = ? ");
					hs.add(apellidoMaterno);
				}
				if (fechaInic != null) {
					sb.append("and t.fechaInic = ? ");
					hs.add(fechaInic);
				}
				if (fechaCese != null) {
					sb.append("and t.fechaCese = ? ");
					hs.add(fechaCese);
				}
				if (direccion != null && direccion.trim().length() > 0) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (username != null && username.trim().length() > 0) {
					sb.append("and t.username = ? ");
					hs.add(username);
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
		// sb.append("order by t.idusuario desc ");

		List<MsUsuarios> lista = null;
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
	public long getTotalXFiltro(Long dni,String nombres,String apellidoPaterno,String apellidoMaterno,Timestamp fechaInic,Timestamp fechaCese,String direccion,String username,Integer codDpto,Integer codProv,Integer codDistr) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idusuario) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (dni != null) {
					sb.append("and t.dni = ? ");
					hs.add(dni);
				}
				if (nombres != null && nombres.trim().length() > 0) {
					sb.append("and t.nombres = ? ");
					hs.add(nombres);
				}
				if (apellidoPaterno != null && apellidoPaterno.trim().length() > 0) {
					sb.append("and t.apellidoPaterno = ? ");
					hs.add(apellidoPaterno);
				}
				if (apellidoMaterno != null && apellidoMaterno.trim().length() > 0) {
					sb.append("and t.apellidoMaterno = ? ");
					hs.add(apellidoMaterno);
				}
				if (fechaInic != null) {
					sb.append("and t.fechaInic = ? ");
					hs.add(fechaInic);
				}
				if (fechaCese != null) {
					sb.append("and t.fechaCese = ? ");
					hs.add(fechaCese);
				}
				if (direccion != null && direccion.trim().length() > 0) {
					sb.append("and t.direccion = ? ");
					hs.add(direccion);
				}
				if (username != null && username.trim().length() > 0) {
					sb.append("and t.username = ? ");
					hs.add(username);
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
	public List<MsUsuarios> getByIdMsUsuarios(String username) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + this.getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
		List<Object> hs = new ArrayList<Object>();
		if (username != null) {
			sb.append("and t.username = ? ");
			hs.add(username);
		}
		Object[] param = new Object[hs.size()];
		hs.toArray(param);
		List<MsUsuarios> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	@Override
	public List<MsUsuarios> getXRoles(String roles[]) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select distinct t from " + this.getDomainClass().getName() + " t, MsRoles r where t.estado >= "+Estado.ACTIVO.getValor()+" "
				+ "and r.estado >0 and t.username=r.username ");
		
		if (roles!=null && roles.length>0) {
			sb.append("and ( ");
			for (int i = 0; i < roles.length; i++) {
				if(i>0)
					sb.append(" or ");
				sb.append("r.rol = ? ");
				hs.add(roles[i]);
			}
			sb.append(") ");			
		}
		
		sb.append("order by t.apellidoPaterno || t.apellidoMaterno || t.nombres ");
		
		Object[] param = new Object[hs.size()];
		hs.toArray(param);
		List<MsUsuarios> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	@Override
	public List<MsUsuarios> getXRoles(String roles[], Long idunidad) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select distinct t from " + this.getDomainClass().getName() + " t, MsRoles r where t.estado >= "+Estado.ACTIVO.getValor()+" "
				+ "and r.estado > "+Estado.ELIMINADO.getValor()+" and t.username=r.username ");
		
		if (roles!=null && roles.length>0) {
			sb.append("and ( ");
			for (int i = 0; i < roles.length; i++) {
				if(i>0)
					sb.append(" or ");
				sb.append("r.rol = ? ");
				hs.add(roles[i]);
			}
			sb.append(") ");			
		}
		
		if(idunidad!=null && idunidad.longValue()>0){
			sb.append("and t.idunidad=? ");
			hs.add(idunidad);
		}		
		sb.append("order by t.apellidoPaterno || t.apellidoMaterno || t.nombres ");
		
		Object[] param = new Object[hs.size()];
		hs.toArray(param);
		List<MsUsuarios> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	@Override
	public List<MsUsuarios> getListaIdusuario() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsUsuarios tablaa ");
		sb.append("WHERE tablaa.estado > "+Estado.ELIMINADO.getValor()+" ");
		sb.append("ORDER BY tablaa.idusuario asc ");
		return super.find(sb.toString());
	}
	
	@Override
	public Long getTotalRegistros() {
		String queryString = "select count(t.idusuario) from " + this.getDomainClass().getName() + " t  WHERE t.estado > "+Estado.ELIMINADO.getValor()+" ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence = sequence + 1L;
		return sequence;
	}
	
	//PURIBE 22032024 - INICIO--
		public List<MsUsuarios> getMsUsuarioByIdSedexUsername(Long sede,String usuario) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select DISTINCT t from " + getDomainClass().getSimpleName()
					+ " t, MsRoles r "
					+ "where t.username=r.username and t.estado >= "+Estado.ACTIVO.getValor()+" ");
			
			if (sede!= null && sede.intValue() > 0) {
				sb.append("and t.idSede = ? ");
				hs.add(sede);
			}
			if (usuario!= null && usuario.trim().length() > 0) {
				sb.append("and  t.username = ? ");
				hs.add(usuario);
			}
			
			sb.append("and r.rol='"+ Roles.PERFIL_ANALIST_ESPECIALIS_IMPLANT+"'");
			
			sb.append("and r.estado >=" +Estado.ACTIVO.getValor()+" ");
			
			sb.append(" order by t.apellidoPaterno, t.apellidoMaterno, t.nombres ");
		
			
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<MsUsuarios> lista = super.find(sb.toString(), param);
			
			return lista;
		}
		//PURIBE 22032024 - FIN--
		
		//JPUYEN 14052024 - INICIO - SE ACTUALIZÓ LA QUERY SEGUN EL NEGOCIO
		//SE CREO NUEVO METODO CON PARAMETRO SEDE
		public List<MsUsuarios> getActivasMsUsuariosFilterXsede(Long sede) {
			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");
			
			if (sede!= null && sede.intValue() > 0) {
				sb.append("and t.idSede = ? ");
				hs.add(sede);
			}
		
			
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<MsUsuarios> lista = super.find(sb.toString(), param);
			
			return lista;
		}

		@Override
		public List<MsUsuarios> getActivasMsUsuariosFilter() {
			
			return super.find("select DISTINCT t from " + getDomainClass().getName()
					+ " t, MsRoles r"
					+ " where t.username=r.username and"
					+ " t.estado >= "+Estado.ACTIVO.getValor()+" and"
					+ " r.estado >= " +Estado.ACTIVO.getValor()+" ");
		}
		
		//JPUYEN 14052024 - FIN 
}