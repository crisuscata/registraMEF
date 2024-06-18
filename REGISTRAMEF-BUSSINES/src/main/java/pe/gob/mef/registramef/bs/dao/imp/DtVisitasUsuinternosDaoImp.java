package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtVisitasUsuinternosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtVisitasUsuinternos;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_VISITAS_USUINTERNOS REPOSITORIO: LISTA DE LOS PARTICIPANTES DE LA VISITA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtVisitasUsuinternosDaoImp extends
		AbstractJpaCRUDDao<DtVisitasUsuinternos, Long> implements
		DtVisitasUsuinternosDao {

	private static final Logger log = Logger.getLogger(DtVisitasUsuinternosDaoImp.class.getName());

	public DtVisitasUsuinternosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasUsuinternosDaoImp");
	}
	
	public DtVisitasUsuinternosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtVisitasUsuinternosDaoImp");
	}
	
	@Transactional
	public void saveDtVisitasUsuinternos(DtVisitasUsuinternos param) {
		super.save(param);
	}

	@Transactional
	public void updateDtVisitasUsuinternos(DtVisitasUsuinternos param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtVisitasUsuinternos(DtVisitasUsuinternos param) {
		super.delete(param);
	}

	public List<DtVisitasUsuinternos> getAllDtVisitasUsuinternos() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtVisitasUsuinternos getDtVisitasUsuinternos(Long id) {
		return super.findById(id);
	}

	public List<DtVisitasUsuinternos> getNativeSQLDtVisitasUsuinternos(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtVisitasUsuinternos> getDomainClass() {
		return DtVisitasUsuinternos.class;
	}

	public List<DtVisitasUsuinternos> getActivasDtVisitasUsuinternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtVisitasUsuinternos> getActivasDtVisitasUsuinternosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasUsuinternos> getDesactivasDtVisitasUsuinternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtVisitasUsuinternos> getByIdDtVisitasUsuinternos(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idVisitUsuint = ? order by t.idVisitUsuint asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtVisitasUsuinternos> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idVisitUsuint) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtVisitasUsuinternos> getXFiltro(Long idVisita,Long idUsuinterno) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idVisita != null) {
			sb.append("and t.idVisita = ? ");
			hs.add(idVisita);
		}
		if (idUsuinterno != null) {
			sb.append("and t.idUsuinterno = ? ");
			hs.add(idUsuinterno);
		}		
		// sb.append("order by t.idVisitUsuint desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtVisitasUsuinternos> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtVisitasUsuinternos> getXFiltro(Long idVisita,Long idUsuinterno, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
				}
		// sb.append("order by t.idVisitUsuint desc ");

		List<DtVisitasUsuinternos> lista = null;
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
	public long getTotalXFiltro(Long idVisita,Long idUsuinterno) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idVisitUsuint) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idVisita != null) {
					sb.append("and t.idVisita = ? ");
					hs.add(idVisita);
				}
				if (idUsuinterno != null) {
					sb.append("and t.idUsuinterno = ? ");
					hs.add(idUsuinterno);
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
		public List<DtVisitasUsuinternos> getXFiltro(Long idVisita) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
//			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= 1 ");
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >=" +Estado.ACTIVO.getValor()); //PURIBE 29032024 - INICIO-->

			
			if (idVisita != null) {
				sb.append("and t.idVisita = ? ");
				hs.add(idVisita);
			}		
			// sb.append("order by t.idVisitUsuint desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtVisitasUsuinternos> lista = super.find(sb.toString(), param);

			return lista;
		}
		//PURIBE 14032024 - FIN-->
}