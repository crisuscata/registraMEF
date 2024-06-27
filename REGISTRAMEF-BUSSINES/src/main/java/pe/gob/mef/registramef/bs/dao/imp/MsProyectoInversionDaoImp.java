package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.MsProyectoInversionDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsProyectoInversion;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_PROYECTO_INVERSION REPOSITORIO: LISTA DE LOS DATOS DE PROYECTOS DE INVERSIÓN
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsProyectoInversionDaoImp extends
		AbstractJpaCRUDDao<MsProyectoInversion, Long> implements
		MsProyectoInversionDao {

	private static final Logger log = Logger.getLogger(MsProyectoInversionDaoImp.class.getName());

	public MsProyectoInversionDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsProyectoInversionDaoImp");
	}
	
	public MsProyectoInversionDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsProyectoInversionDaoImp");
	}
	
	@Transactional
	public void saveMsProyectoInversion(MsProyectoInversion param) {
		super.save(param);
	}

	@Transactional
	public void updateMsProyectoInversion(MsProyectoInversion param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsProyectoInversion(MsProyectoInversion param) {
		super.delete(param);
	}

	public List<MsProyectoInversion> getAllMsProyectoInversion() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsProyectoInversion getMsProyectoInversion(Long id) {
		return super.findById(id);
	}

	public List<MsProyectoInversion> getNativeSQLMsProyectoInversion(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsProyectoInversion> getDomainClass() {
		return MsProyectoInversion.class;
	}

	public List<MsProyectoInversion> getActivasMsProyectoInversion() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsProyectoInversion> getActivasMsProyectoInversionCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsProyectoInversion> getDesactivasMsProyectoInversion() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsProyectoInversion> getByIdMsProyectoInversion(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idProyecto = ? order by t.idProyecto asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsProyectoInversion> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idProyecto) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsProyectoInversion> getXFiltro(String codigo,String nombre,Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (codigo != null && codigo.trim().length() > 0) {
			sb.append("and t.codigo = ? ");
			hs.add(codigo);
		}
		if (nombre != null) {
			sb.append("and t.nombre = ? ");
			hs.add(nombre);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}		
		// sb.append("order by t.idProyecto desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsProyectoInversion> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsProyectoInversion> getXFiltro(String codigo,String nombre,Long idSede, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codigo != null && codigo.trim().length() > 0) {
					sb.append("and t.codigo = ? ");
					hs.add(codigo);
				}
				if (nombre != null) {
					sb.append("and t.nombre = ? ");
					hs.add(nombre);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
		// sb.append("order by t.idProyecto desc ");

		List<MsProyectoInversion> lista = null;
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
	public long getTotalXFiltro(String codigo,String nombre,Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idProyecto) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codigo != null && codigo.trim().length() > 0) {
					sb.append("and t.codigo = ? ");
					hs.add(codigo);
				}
				if (nombre != null) {
					sb.append("and t.nombre = ? ");
					hs.add(nombre);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
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
			public List<MsProyectoInversion> getListaNombre(String nombre) {
				StringBuffer sb = new StringBuffer(100);
				sb.append("SELECT tablaa FROM MsProyectoInversion tablaa ");
				sb.append("WHERE tablaa.estado >= "+Estado.ACTIVO.getValor()+" AND tablaa.nombre LIKE '%"+nombre+"%'");
				sb.append("ORDER BY tablaa.nombre asc ");
				return super.find(sb.toString());
			}
	  
	//CUSCATA - 18062024
		@Override
		public MsProyectoInversion findByPk(Long id) {
			return super.findById(id);
		}
}//CUSCATA - 18062024