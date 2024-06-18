package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtEntidadesUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEntidadesUsuexternos;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ENTIDADES_USUEXTERNOS REPOSITORIO: LISTA DE LAS ENTIDADES A LA QUE PERTENECE EL USUARIO EXTERNO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEntidadesUsuexternosDaoImp extends
		AbstractJpaCRUDDao<DtEntidadesUsuexternos, Long> implements
		DtEntidadesUsuexternosDao {

	private static final Logger log = Logger.getLogger(DtEntidadesUsuexternosDaoImp.class.getName());

	public DtEntidadesUsuexternosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadesUsuexternosDaoImp");
	}
	
	public DtEntidadesUsuexternosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEntidadesUsuexternosDaoImp");
	}
	
	@Transactional
	public void saveDtEntidadesUsuexternos(DtEntidadesUsuexternos param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEntidadesUsuexternos(DtEntidadesUsuexternos param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEntidadesUsuexternos(DtEntidadesUsuexternos param) {
		super.delete(param);
	}

	public List<DtEntidadesUsuexternos> getAllDtEntidadesUsuexternos() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEntidadesUsuexternos getDtEntidadesUsuexternos(Long id) {
		return super.findById(id);
	}

	public List<DtEntidadesUsuexternos> getNativeSQLDtEntidadesUsuexternos(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEntidadesUsuexternos> getDomainClass() {
		return DtEntidadesUsuexternos.class;
	}

	public List<DtEntidadesUsuexternos> getActivasDtEntidadesUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEntidadesUsuexternos> getActivasDtEntidadesUsuexternosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadesUsuexternos> getDesactivasDtEntidadesUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEntidadesUsuexternos> getByIdDtEntidadesUsuexternos(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idUsuextEnti = ? order by t.idUsuextEnti asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEntidadesUsuexternos> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idUsuextEnti) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtEntidadesUsuexternos> getXFiltro(Long idEntidad,Long idUsuexterno) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idEntidad != null) {
			sb.append("and t.idEntidad = ? ");
			hs.add(idEntidad);
		}
		if (idUsuexterno != null) {
			sb.append("and t.idUsuexterno = ? ");
			hs.add(idUsuexterno);
		}		
		// sb.append("order by t.idUsuextEnti desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtEntidadesUsuexternos> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtEntidadesUsuexternos> getXFiltro(Long idEntidad,Long idUsuexterno, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
		// sb.append("order by t.idUsuextEnti desc ");

		List<DtEntidadesUsuexternos> lista = null;
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
	public long getTotalXFiltro(Long idEntidad,Long idUsuexterno) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idUsuextEnti) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idEntidad != null) {
					sb.append("and t.idEntidad = ? ");
					hs.add(idEntidad);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
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
	
	//PURIBE 14032024 - INICIO-->
			@Override
			public List<DtEntidadesUsuexternos> getXFiltroidUsuexterno(Long idUsuexterno) {

				StringBuffer sb = new StringBuffer(100);
				List<Object> hs = new ArrayList<Object>();
				sb.append("select t from " + getDomainClass().getName() + " t where t.estado = 3 ");

				
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}		
			
				Object param[] = new Object[hs.size()];
				hs.toArray(param);
				List<DtEntidadesUsuexternos> lista = super.find(sb.toString(), param);

				return lista;
			}
			//PURIBE 14032024 - FIN-->
}