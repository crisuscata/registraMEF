package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtUsuariosSedesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtUsuariosSedes;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_USUARIOS_SEDES REPOSITORIO: LISTA DE LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtUsuariosSedesDaoImp extends
		AbstractJpaCRUDDao<DtUsuariosSedes, Long> implements
		DtUsuariosSedesDao {

	private static final Logger log = Logger.getLogger(DtUsuariosSedesDaoImp.class.getName());

	public DtUsuariosSedesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtUsuariosSedesDaoImp");
	}
	
	public DtUsuariosSedesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtUsuariosSedesDaoImp");
	}
	
	@Transactional
	public void saveDtUsuariosSedes(DtUsuariosSedes param) {
		super.save(param);
	}

	@Transactional
	public void updateDtUsuariosSedes(DtUsuariosSedes param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtUsuariosSedes(DtUsuariosSedes param) {
		super.delete(param);
	}

	public List<DtUsuariosSedes> getAllDtUsuariosSedes() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtUsuariosSedes getDtUsuariosSedes(Long id) {
		return super.findById(id);
	}

	public List<DtUsuariosSedes> getNativeSQLDtUsuariosSedes(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtUsuariosSedes> getDomainClass() {
		return DtUsuariosSedes.class;
	}

	public List<DtUsuariosSedes> getActivasDtUsuariosSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtUsuariosSedes> getActivasDtUsuariosSedesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtUsuariosSedes> getDesactivasDtUsuariosSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtUsuariosSedes> getByIdDtUsuariosSedes(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idUsuSede = ? order by t.idUsuSede asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtUsuariosSedes> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idUsuSede) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtUsuariosSedes> getXFiltro(Long idSede,Long idusuario) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}
		if (idusuario != null) {
			sb.append("and t.idusuario = ? ");
			hs.add(idusuario);
		}		
		// sb.append("order by t.idUsuSede desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtUsuariosSedes> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtUsuariosSedes> getXFiltro(Long idSede,Long idusuario, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (idusuario != null) {
					sb.append("and t.idusuario = ? ");
					hs.add(idusuario);
				}
		// sb.append("order by t.idUsuSede desc ");

		List<DtUsuariosSedes> lista = null;
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
	public long getTotalXFiltro(Long idSede,Long idusuario) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idUsuSede) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (idusuario != null) {
					sb.append("and t.idusuario = ? ");
					hs.add(idusuario);
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