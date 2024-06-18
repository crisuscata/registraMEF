package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtEntidadSedesDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEntidadSedes;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ENTIDAD_SEDES REPOSITORIO: LISTA DE LAS DISTINTAS SEDES ASIGNADAS A LA ENTIDAD
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEntidadSedesDaoImp extends
		AbstractJpaCRUDDao<DtEntidadSedes, Long> implements
		DtEntidadSedesDao {

	private static final Logger log = Logger.getLogger(DtEntidadSedesDaoImp.class.getName());

	public DtEntidadSedesDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadSedesDaoImp");
	}
	
	public DtEntidadSedesDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadSedesDaoImp");
	}
	
	@Transactional
	public void saveDtEntidadSedes(DtEntidadSedes param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEntidadSedes(DtEntidadSedes param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEntidadSedes(DtEntidadSedes param) {
		super.delete(param);
	}

	public List<DtEntidadSedes> getAllDtEntidadSedes() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEntidadSedes getDtEntidadSedes(Long id) {
		return super.findById(id);
	}

	public List<DtEntidadSedes> getNativeSQLDtEntidadSedes(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEntidadSedes> getDomainClass() {
		return DtEntidadSedes.class;
	}

	public List<DtEntidadSedes> getActivasDtEntidadSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEntidadSedes> getActivasDtEntidadSedesCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadSedes> getDesactivasDtEntidadSedes() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadSedes> getByIdDtEntidadSedes(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idEntiSed = ? order by t.idEntiSed asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEntidadSedes> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idEntiSed) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtEntidadSedes> getXFiltro(Long idEntidad,Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}		
		// sb.append("order by t.idEntiSed desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtEntidadSedes> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtEntidadSedes> getXFiltro(Long idEntidad,Long idSede, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
		// sb.append("order by t.idEntiSed desc ");

		List<DtEntidadSedes> lista = null;
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
	public long getTotalXFiltro(Long idEntidad,Long idSede) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idEntiSed) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
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
}