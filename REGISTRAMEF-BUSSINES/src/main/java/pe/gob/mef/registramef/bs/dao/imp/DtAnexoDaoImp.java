package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtAnexoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAnexo;
import pe.gob.mef.registramef.bs.utils.Estado;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_ANEXO REPOSITORIO: LISTA DE LOS DOCUMENTOS ANEXADOS EN EL SISTEMA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAnexoDaoImp extends
		AbstractJpaCRUDDao<DtAnexo, Long> implements
		DtAnexoDao {

	private static final Logger log = Logger.getLogger(DtAnexoDaoImp.class.getName());
	private Long estadoNuevo = 1L;
	private Long estadoEliminado = 0L;

	public DtAnexoDaoImp() {
		this.estadoNuevo = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_NUEVO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
		this.estadoEliminado = PropertiesMg.getSistemLong(PropertiesMg.KEY_ESTADOS_REGISTROS_ELIMINADO, PropertiesMg.DEFOULT_ESTADOS_REGISTROS_ELIMINADO);
		log.log(Level.INFO,"INICIALIZANDO JPA TEMPLATE PARA DtAnexoDaoImp "+"Nuevo: "+estadoNuevo+" Eliminado:"+estadoEliminado);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAnexoDaoImp");
	}
	
	public DtAnexoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAnexoDaoImp");
	}
	
	@Transactional
	public void saveDtAnexo(DtAnexo param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAnexo(DtAnexo param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtAnexo(DtAnexo param) {
		super.delete(param);
	}

	public List<DtAnexo> getAllDtAnexo() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAnexo getDtAnexo(Long id) {
		return super.findById(id);
	}

	public List<DtAnexo> getNativeSQLDtAnexo(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAnexo> getDomainClass() {
		return DtAnexo.class;
	}

	public List<DtAnexo> getActivasDtAnexo() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAnexo> getActivasDtAnexoCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAnexo> getDesactivasDtAnexo() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAnexo> getByIdDtAnexo(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAnexo = ? order by t.idAnexo asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAnexo> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAnexo) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAnexo> getXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (filename != null) {
			sb.append("and t.filename = ? ");
			hs.add(filename);
		}
		if (filenameoriginal != null) {
			sb.append("and t.filenameoriginal = ? ");
			hs.add(filenameoriginal);
		}
		if (idTiposervicio != null) {
			sb.append("and t.idTiposervicio = ? ");
			hs.add(idTiposervicio);
		}
		if (tipoAnexo != null) {
			sb.append("and t.tipoAnexo = ? ");
			hs.add(tipoAnexo);
		}
		if (idmaestro != null) {
			sb.append("and t.idmaestro = ? ");
			hs.add(idmaestro);
		}		
		// sb.append("order by t.idAnexo desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAnexo> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAnexo> getXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (filename != null) {
					sb.append("and t.filename = ? ");
					hs.add(filename);
				}
				if (filenameoriginal != null) {
					sb.append("and t.filenameoriginal = ? ");
					hs.add(filenameoriginal);
				}
				if (idTiposervicio != null) {
					sb.append("and t.idTiposervicio = ? ");
					hs.add(idTiposervicio);
				}
				if (tipoAnexo != null) {
					sb.append("and t.tipoAnexo = ? ");
					hs.add(tipoAnexo);
				}
				if (idmaestro != null) {
					sb.append("and t.idmaestro = ? ");
					hs.add(idmaestro);
				}
		// sb.append("order by t.idAnexo desc ");

		List<DtAnexo> lista = null;
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
	public long getTotalXFiltro(String filename,String filenameoriginal,Long idTiposervicio,Long tipoAnexo,Long idmaestro) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAnexo) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (filename != null) {
					sb.append("and t.filename = ? ");
					hs.add(filename);
				}
				if (filenameoriginal != null) {
					sb.append("and t.filenameoriginal = ? ");
					hs.add(filenameoriginal);
				}
				if (idTiposervicio != null) {
					sb.append("and t.idTiposervicio = ? ");
					hs.add(idTiposervicio);
				}
				if (tipoAnexo != null) {
					sb.append("and t.tipoAnexo = ? ");
					hs.add(tipoAnexo);
				}
				if (idmaestro != null) {
					sb.append("and t.idmaestro = ? ");
					hs.add(idmaestro);
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
	public Long getEstadoEliminado() {
		return estadoEliminado;
	}
	
	
	
}