package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsAlertaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsAlerta;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_ALERTA REPOSITORIO: LISTA DE LAS ALERTAS GENERADAS EN EL SISTMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsAlertaDaoImp extends
		AbstractJpaCRUDDao<MsAlerta, Long> implements
		MsAlertaDao {

	private static final Logger log = Logger.getLogger(MsAlertaDaoImp.class.getName());

	public MsAlertaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsAlertaDaoImp");
	}
	
	public MsAlertaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsAlertaDaoImp");
	}
	
	@Transactional
	public void saveMsAlerta(MsAlerta param) {
		super.save(param);
	}

	@Transactional
	public void updateMsAlerta(MsAlerta param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsAlerta(MsAlerta param) {
		super.delete(param);
	}

	public List<MsAlerta> getAllMsAlerta() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsAlerta getMsAlerta(Long id) {
		return super.findById(id);
	}

	public List<MsAlerta> getNativeSQLMsAlerta(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsAlerta> getDomainClass() {
		return MsAlerta.class;
	}

	public List<MsAlerta> getActivasMsAlerta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsAlerta> getActivasMsAlertaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsAlerta> getDesactivasMsAlerta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsAlerta> getByIdMsAlerta(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAlerta = ? order by t.idAlerta asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsAlerta> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAlerta) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsAlerta> getXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idCaracterst != null) {
			sb.append("and t.idCaracterst = ? ");
			hs.add(idCaracterst);
		}
		if (otrosDestin != null && otrosDestin.trim().length() > 0) {
			sb.append("and t.otrosDestin = ? ");
			hs.add(otrosDestin);
		}
		if (dia != null) {
			sb.append("and t.dia = ? ");
			hs.add(dia);
		}
		if (hora != null) {
			sb.append("and t.hora = ? ");
			hs.add(hora);
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
		// sb.append("order by t.idAlerta desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsAlerta> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsAlerta> getXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCaracterst != null) {
					sb.append("and t.idCaracterst = ? ");
					hs.add(idCaracterst);
				}
				if (otrosDestin != null && otrosDestin.trim().length() > 0) {
					sb.append("and t.otrosDestin = ? ");
					hs.add(otrosDestin);
				}
				if (dia != null) {
					sb.append("and t.dia = ? ");
					hs.add(dia);
				}
				if (hora != null) {
					sb.append("and t.hora = ? ");
					hs.add(hora);
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
		// sb.append("order by t.idAlerta desc ");

		List<MsAlerta> lista = null;
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
	public long getTotalXFiltro(Long idCaracterst,String otrosDestin,Integer dia,Integer hora,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAlerta) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idCaracterst != null) {
					sb.append("and t.idCaracterst = ? ");
					hs.add(idCaracterst);
				}
				if (otrosDestin != null && otrosDestin.trim().length() > 0) {
					sb.append("and t.otrosDestin = ? ");
					hs.add(otrosDestin);
				}
				if (dia != null) {
					sb.append("and t.dia = ? ");
					hs.add(dia);
				}
				if (hora != null) {
					sb.append("and t.hora = ? ");
					hs.add(hora);
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
}