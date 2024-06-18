package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.MsPaisesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsPaises;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_PAISES REPOSITORIO: LISTA DE LOS PAÍSES REGISTRADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsPaisesDaoImp extends
		AbstractJpaCRUDDao<MsPaises, Long> implements
		MsPaisesDao {

	private static final Logger log = Logger.getLogger(MsPaisesDaoImp.class.getName());

	public MsPaisesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsPaisesDaoImp");
	}
	
	public MsPaisesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsPaisesDaoImp");
	}
	
	@Transactional
	public void saveMsPaises(MsPaises param) {
		super.save(param);
	}

	@Transactional
	public void updateMsPaises(MsPaises param) {
		super.update(param);
	}

	@Transactional
	public void deleteMsPaises(MsPaises param) {
		super.delete(param);
	}

	public List<MsPaises> getAllMsPaises() {
		return super.find("from " + getDomainClass().getName());
	}

	public MsPaises getMsPaises(Long id) {
		return super.findById(id);
	}

	public List<MsPaises> getNativeSQLMsPaises(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<MsPaises> getDomainClass() {
		return MsPaises.class;
	}

	public List<MsPaises> getActivasMsPaises() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<MsPaises> getActivasMsPaisesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<MsPaises> getDesactivasMsPaises() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<MsPaises> getByIdMsPaises(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idpais = ? order by t.idpais asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<MsPaises> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idpais) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<MsPaises> getXFiltro(String paisNombre,String acronimo,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (paisNombre != null && paisNombre.trim().length() > 0) {
			sb.append("and t.paisNombre = ? ");
			hs.add(paisNombre);
		}
		if (acronimo != null && acronimo.trim().length() > 0) {
			sb.append("and t.acronimo = ? ");
			hs.add(acronimo);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idpais desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsPaises> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsPaises> getXFiltro(String paisNombre,String acronimo,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (paisNombre != null && paisNombre.trim().length() > 0) {
					sb.append("and t.paisNombre = ? ");
					hs.add(paisNombre);
				}
				if (acronimo != null && acronimo.trim().length() > 0) {
					sb.append("and t.acronimo = ? ");
					hs.add(acronimo);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idpais desc ");

		List<MsPaises> lista = null;
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
	public long getTotalXFiltro(String paisNombre,String acronimo,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idpais) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (paisNombre != null && paisNombre.trim().length() > 0) {
					sb.append("and t.paisNombre = ? ");
					hs.add(paisNombre);
				}
				if (acronimo != null && acronimo.trim().length() > 0) {
					sb.append("and t.acronimo = ? ");
					hs.add(acronimo);
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
	
	//MPINARES 24012023 - INICIO
		@Override	
		public MsPaises getByNombreMsPaises(String nombre) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.paisNombre=? ");
			Object param[] = new Object[1];
			param[0] = nombre;
			MsPaises msPaises = null;
			try{
			List<MsPaises> lista = super.find(sb.toString(), param);
			if(!lista.isEmpty())
				msPaises = lista.get(0);			
			}catch(Exception e){}
			return msPaises;
		}
		//MPINARES 24012023 - FIN
}