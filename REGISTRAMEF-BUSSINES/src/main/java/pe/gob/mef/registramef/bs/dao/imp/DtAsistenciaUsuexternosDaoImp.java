package pe.gob.mef.registramef.bs.dao.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mef.registramef.bs.dao.DtAsistenciaUsuexternosDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAsistenciaUsuexternos;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * DT_ASISTENCIA_USUEXTERNOS REPOSITORIO: LISTA DE LOS USUARIOS QUE BRINDAN LA ATENCION EN LA ASISTENCIA TECNICA
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAsistenciaUsuexternosDaoImp extends
		AbstractJpaCRUDDao<DtAsistenciaUsuexternos, Long> implements
		DtAsistenciaUsuexternosDao {

	private static final Logger log = Logger.getLogger(DtAsistenciaUsuexternosDaoImp.class.getName());

	public DtAsistenciaUsuexternosDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaUsuexternosDaoImp");
	}
	
	public DtAsistenciaUsuexternosDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAsistenciaUsuexternosDaoImp");
	}
	
	@Transactional
	public void saveDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param) {
		super.update(param);
	}
	
	//INICIO CUSCATA - 10072024
		@Transactional
		public void updateDtAsistenciaUsuexCorreo(Long id) {
			
			DtAsistenciaUsuexternos dtAsistenciaUsuexternos = this.getDtAsistenciaUsuexternos(id);
			dtAsistenciaUsuexternos.setCtrlConfirmacion(2L);
			
			super.update(dtAsistenciaUsuexternos);
		}
	    //FIN CUSCATA - 10072024

	@Transactional
	public void deleteDtAsistenciaUsuexternos(DtAsistenciaUsuexternos param) {
		super.delete(param);
	}

	public List<DtAsistenciaUsuexternos> getAllDtAsistenciaUsuexternos() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAsistenciaUsuexternos getDtAsistenciaUsuexternos(Long id) {
		return super.findById(id);
	}

	public List<DtAsistenciaUsuexternos> getNativeSQLDtAsistenciaUsuexternos(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAsistenciaUsuexternos> getDomainClass() {
		return DtAsistenciaUsuexternos.class;
	}

	public List<DtAsistenciaUsuexternos> getActivasDtAsistenciaUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAsistenciaUsuexternos> getActivasDtAsistenciaUsuexternosCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaUsuexternos> getDesactivasDtAsistenciaUsuexternos() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAsistenciaUsuexternos> getByIdDtAsistenciaUsuexternos(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAsistUsuext = ? order by t.idAsistUsuext asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAsistenciaUsuexternos> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAsistUsuext) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAsistenciaUsuexternos> getXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (idAsistencia != null) {
			sb.append("and t.idAsistencia = ? ");
			hs.add(idAsistencia);
		}
		if (idUsuexterno != null) {
			sb.append("and t.idUsuexterno = ? ");
			hs.add(idUsuexterno);
		}
		if (idCargoUsuext != null) {
			sb.append("and t.idCargoUsuext = ? ");
			hs.add(idCargoUsuext);
		}		
		// sb.append("order by t.idAsistUsuext desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAsistenciaUsuexternos> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAsistenciaUsuexternos> getXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
				}
		// sb.append("order by t.idAsistUsuext desc ");

		List<DtAsistenciaUsuexternos> lista = null;
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
	public long getTotalXFiltro(Long idAsistencia,Long idUsuexterno,Long idCargoUsuext) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAsistUsuext) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (idAsistencia != null) {
					sb.append("and t.idAsistencia = ? ");
					hs.add(idAsistencia);
				}
				if (idUsuexterno != null) {
					sb.append("and t.idUsuexterno = ? ");
					hs.add(idUsuexterno);
				}
				if (idCargoUsuext != null) {
					sb.append("and t.idCargoUsuext = ? ");
					hs.add(idCargoUsuext);
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
		public List<DtAsistenciaUsuexternos> getByIdAsistDtAsisteUsuariosExt(Long idAsiste) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.idAsistencia = ? and t.estado >= "+Estado.ACTIVO.getValor()+" order by t.idAsistUsuext asc ");
			Object param[] = new Object[1];
			param[0] = idAsiste;
			List<DtAsistenciaUsuexternos> lista = super.find(sb.toString(), param);
			return lista;
		}
		//MPINARES 24012023 - FIN
}