package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.MsAlertaCargoUserDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsAlertaCargoUser;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_ALERTA_CARGO_USER REPOSITORIO: LISTA DE LOS CARGOS DE LOS USUARIOS EN LAS ALERTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsAlertaCargoUserDaoImp extends
		AbstractJpaCRUDDao<MsAlertaCargoUser, Long> implements
		MsAlertaCargoUserDao {

	private static final Logger log = Logger.getLogger(MsAlertaCargoUserDaoImp.class.getName());

	public MsAlertaCargoUserDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsAlertaCargoUserDaoImp");
	}
	
	public MsAlertaCargoUserDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsAlertaCargoUserDaoImp");
	}
	
	@Transactional
	public void saveMsAlertaCargoUser(MsAlertaCargoUser param) {
		super.save(param);
	}

	@Transactional
	public void updateMsAlertaCargoUser(MsAlertaCargoUser param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsAlertaCargoUser(MsAlertaCargoUser param) {
		super.delete(param);
	}

	public List<MsAlertaCargoUser> getAllMsAlertaCargoUser() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsAlertaCargoUser getMsAlertaCargoUser(Long id) {
		return super.findById(id);
	}

	public List<MsAlertaCargoUser> getNativeSQLMsAlertaCargoUser(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsAlertaCargoUser> getDomainClass() {
		return MsAlertaCargoUser.class;
	}

	public List<MsAlertaCargoUser> getActivasMsAlertaCargoUser() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsAlertaCargoUser> getActivasMsAlertaCargoUserCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsAlertaCargoUser> getDesactivasMsAlertaCargoUser() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsAlertaCargoUser> getByIdMsAlertaCargoUser(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idalertaCargo = ? order by t.idalertaCargo asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsAlertaCargoUser> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idalertaCargo) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsAlertaCargoUser> getXFiltro(Long idalerta,Long idcargo) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idalerta != null) {
			sb.append("and t.idalerta = ? ");
			hs.add(idalerta);
		}
		if (idcargo != null) {
			sb.append("and t.idcargo = ? ");
			hs.add(idcargo);
		}		
		// sb.append("order by t.idalertaCargo desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsAlertaCargoUser> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsAlertaCargoUser> getXFiltro(Long idalerta,Long idcargo, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idalerta != null) {
					sb.append("and t.idalerta = ? ");
					hs.add(idalerta);
				}
				if (idcargo != null) {
					sb.append("and t.idcargo = ? ");
					hs.add(idcargo);
				}
		// sb.append("order by t.idalertaCargo desc ");

		List<MsAlertaCargoUser> lista = null;
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
	public long getTotalXFiltro(Long idalerta,Long idcargo) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idalertaCargo) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idalerta != null) {
					sb.append("and t.idalerta = ? ");
					hs.add(idalerta);
				}
				if (idcargo != null) {
					sb.append("and t.idcargo = ? ");
					hs.add(idcargo);
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
}