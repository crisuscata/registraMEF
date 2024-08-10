package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsSisAdmistrativoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsSisAdmistrativo;
import pe.gob.mef.registramef.bs.utils.Estado;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * MS_SIS_ADMISTRATIVO REPOSITORIO: LISTA DE LOS SISTEMAS ADMINISTRATIVOS REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsSisAdmistrativoDaoImp extends
		AbstractJpaCRUDDao<MsSisAdmistrativo, Long> implements
		MsSisAdmistrativoDao {

	private static final Logger log = Logger.getLogger(MsSisAdmistrativoDaoImp.class.getName());
	
	protected Long estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);

	public MsSisAdmistrativoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSisAdmistrativoDaoImp");
	}
	
	public MsSisAdmistrativoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsSisAdmistrativoDaoImp");
	}
	
	@Transactional
	public void saveMsSisAdmistrativo(MsSisAdmistrativo param) {
		super.save(param);
	}

	@Transactional
	public void updateMsSisAdmistrativo(MsSisAdmistrativo param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsSisAdmistrativo(MsSisAdmistrativo param) {
		super.delete(param);
	}

	public List<MsSisAdmistrativo> getAllMsSisAdmistrativo() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsSisAdmistrativo getMsSisAdmistrativo(Long id) {
		return super.findById(id);
	}

	public List<MsSisAdmistrativo> getNativeSQLMsSisAdmistrativo(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsSisAdmistrativo> getDomainClass() {
		return MsSisAdmistrativo.class;
	}

	public List<MsSisAdmistrativo> getActivasMsSisAdmistrativo() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsSisAdmistrativo> getActivasMsSisAdmistrativoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor()); //MPINARES 24012023 - INICIO //Estado.ELIMINADO.getValor()
	}

	public List<MsSisAdmistrativo> getDesactivasMsSisAdmistrativo() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsSisAdmistrativo> getByIdMsSisAdmistrativo(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idSistAdmi = ? order by t.idSistAdmi asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsSisAdmistrativo> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idSistAdmi) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsSisAdmistrativo> getXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
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
		// sb.append("order by t.idSistAdmi desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsSisAdmistrativo> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsSisAdmistrativo> getXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
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
		// sb.append("order by t.idSistAdmi desc ");

		List<MsSisAdmistrativo> lista = null;
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
	public long getTotalXFiltro(String descripcion,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idSistAdmi) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
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
	public List<MsSisAdmistrativo> getListaIdSistAdmi() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT tablaa FROM MsSisAdmistrativo tablaa ");
		sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" ");
		sb.append("ORDER BY tablaa.idSistAdmi asc ");
		return super.find(sb.toString());
	}
	
	public  List<MsSisAdmistrativo> getSistemaAdministrativoTemaCapa() throws Exception{

		StringBuilder query = new StringBuilder();
		query.append(" select distinct  sa ");
		query.append(" from DtCapaTemas t, MsSisAdmistrativo sa ");
		query.append(" where  ");
		query.append(" t.estado = ? ");
		query.append(" and t.idSistAdmi = sa.idSistAdmi ");

		Object[] params = new Object[1];
		params[0] = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);

		return  super.find(query.toString(), params);
	}
	
}