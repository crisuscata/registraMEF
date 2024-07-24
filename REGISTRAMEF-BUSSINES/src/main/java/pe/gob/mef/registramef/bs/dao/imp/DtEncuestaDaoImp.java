package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtEncuestaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtEncuesta;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.utils.Estado;
import pe.gob.mef.registramef.bs.utils.FuncionesStaticas;

/**
 * DT_ENCUESTA REPOSITORIO: LISTA DE ENCUESTAS
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtEncuestaDaoImp extends
		AbstractJpaCRUDDao<DtEncuesta, Integer> implements
		DtEncuestaDao {

	private static final Logger log = Logger.getLogger(DtEncuestaDaoImp.class.getName());

	public DtEncuestaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEncuestaDaoImp");
	}
	
	public DtEncuestaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtEncuestaDaoImp");
	}
	
	@Transactional
	public void saveDtEncuesta(DtEncuesta param) {
		super.save(param);
	}

	@Transactional
	public void updateDtEncuesta(DtEncuesta param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtEncuesta(DtEncuesta param) {
		super.delete(param);
	}

	public List<DtEncuesta> getAllDtEncuesta() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtEncuesta getDtEncuesta(Integer id) {
		return super.findById(id);
	}

	public List<DtEncuesta> getNativeSQLDtEncuesta(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtEncuesta> getDomainClass() {
		return DtEncuesta.class;
	}

	public List<DtEncuesta> getActivasDtEncuesta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtEncuesta> getActivasDtEncuestaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEncuesta> getDesactivasDtEncuesta() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtEncuesta> getByIdDtEncuesta(Integer id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idEncuesta = ? order by t.idEncuesta asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtEncuesta> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idEncuesta) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	//PURIBE 22042024 - INICIO-->
		@Override
		public List<DtEncuesta> getXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion,Date fechaServicio) {

			StringBuffer sb = new StringBuffer(100);
			List<Object> hs = new ArrayList<Object>();
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

			
			if (tipoServicio != null) {
				sb.append("and t.tipoServicio = ? ");
				hs.add(tipoServicio);
			}
			if (fechaInicio != null) {
				sb.append("and t.fechaInicio = ? ");
				hs.add(fechaInicio);
			}
			if (fechaFin != null) {
				sb.append("and t.fechaFin = ? ");
				hs.add(fechaFin);
			}
			if (idOrigen != null) {
				sb.append("and t.idOrigen = ? ");
				hs.add(idOrigen);
			}
			if (idPrestacion != null) {
				sb.append("and t.idPrestacion = ? ");
				hs.add(idPrestacion);
			}		
			
			if (fechaServicio !=null)
			{
				sb.append(" AND TO_DATE(?, 'dd/MM/yyyy') BETWEEN t.fechaInicio AND t.fechaFin ");
				hs.add(FuncionesStaticas.toString(fechaServicio));
				
			}
			// sb.append("order by t.idEncuesta desc ");

			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			List<DtEncuesta> lista = super.find(sb.toString(), param);

			return lista;
		}
		//PURIBE 22042024 - FIN-->

	@Override
	public List<DtEncuesta> getXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (tipoServicio != null) {
					sb.append("and t.tipoServicio = ? ");
					hs.add(tipoServicio);
				}
				if (fechaInicio != null) {
					sb.append("and t.fechaInicio = ? ");
					hs.add(fechaInicio);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
				}
				if (idOrigen != null) {
					sb.append("and t.idOrigen = ? ");
					hs.add(idOrigen);
				}
				if (idPrestacion != null) {
					sb.append("and t.idPrestacion = ? ");
					hs.add(idPrestacion);
				}
		// sb.append("order by t.idEncuesta desc ");

		List<DtEncuesta> lista = null;
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
	public long getTotalXFiltro(Long tipoServicio,Timestamp fechaInicio,Timestamp fechaFin,Long idOrigen,Long idPrestacion) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idEncuesta) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (tipoServicio != null) {
					sb.append("and t.tipoServicio = ? ");
					hs.add(tipoServicio);
				}
				if (fechaInicio != null) {
					sb.append("and t.fechaInicio = ? ");
					hs.add(fechaInicio);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
				}
				if (idOrigen != null) {
					sb.append("and t.idOrigen = ? ");
					hs.add(idOrigen);
				}
				if (idPrestacion != null) {
					sb.append("and t.idPrestacion = ? ");
					hs.add(idPrestacion);
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
//	params[0] = Estado.ACTIVO.getValor();
		//INICIO CUSCATA - 10072024
		@Override
		public List<DtEncuesta> findListPeriodo(Long idTipoServicio, Date fechaServicio) throws Validador {
			System.out.println("DtEncuestaDaoImp.findPeriodo("+idTipoServicio+", "+FuncionesStaticas.toString(fechaServicio)+")");
			StringBuilder query = new StringBuilder();
			query.append(" SELECT e ");
			query.append(" FROM DtEncuesta e ");
			query.append(" WHERE e.estado = ? ");
			query.append(" AND e.tipoServicio = ? ");
			query.append(" AND TO_DATE(?, 'dd/MM/yyyy') BETWEEN e.fechaInicio AND e.fechaFin ");
			Object[] params = new Object[3];
			params[0] = Estado.ACTIVO.getValor();
			params[1] = idTipoServicio;
			params[2] = FuncionesStaticas.toString(fechaServicio);
			return super.findList(query.toString(), params);
		}
	//FIN CUSCATA - 10072024
		
		public DtEncuesta findPeriodo(Long idTipoServicio, Date fechaServicio) throws Validador{
			System.out.println("DtEncuestaDaoImp.findPeriodo("+idTipoServicio+", "+FuncionesStaticas.toString(fechaServicio)+")");
			
				StringBuilder query = new StringBuilder();
				query.append(" SELECT e ");
				query.append(" FROM DtEncuesta e ");
				query.append(" WHERE e.estado = ? ");
				query.append(" AND e.tipoServicio = ? ");
				query.append(" AND TO_DATE(?, 'dd/MM/yyyy') BETWEEN e.fechaInicio AND e.fechaFin ");
				Object[] params = new Object[3];
				params[0] = Estado.ACTIVO;
				params[1] = idTipoServicio;
				params[2] = FuncionesStaticas.toString(fechaServicio);
				
				return super.findOne(query.toString(), params);
			}
}