package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.DtAmpliacionFechaDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.DtAmpliacionFecha;
import pe.gob.mef.registramef.bs.exception.Validador;
import pe.gob.mef.registramef.bs.utils.Estado;
import pe.gob.mef.registramef.bs.utils.PropertiesMg;

/**
 * DT_AMPLIACION_FECHA REPOSITORIO: LISTA DE AMPLIACIONES DE LOS DÍAS DE PROGRAMACIÓN Y EJECUCION DEL SERVICIO PARA UN SISTEMA ADMINISTRATIVO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class DtAmpliacionFechaDaoImp extends
		AbstractJpaCRUDDao<DtAmpliacionFecha, Long> implements
		DtAmpliacionFechaDao {

	private static final Logger log = Logger.getLogger(DtAmpliacionFechaDaoImp.class.getName());
//generate registramef	
	public DtAmpliacionFechaDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAmpliacionFechaDaoImp");
	}
	
	public DtAmpliacionFechaDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA DtAmpliacionFechaDaoImp");
	}
	
	@Transactional
	public void saveDtAmpliacionFecha(DtAmpliacionFecha param) {
		super.save(param);
	}

	@Transactional
	public void updateDtAmpliacionFecha(DtAmpliacionFecha param) {
		super.update(param);
	}

	@Transactional
	public void deleteDtAmpliacionFecha(DtAmpliacionFecha param) {
		super.delete(param);
	}

	public List<DtAmpliacionFecha> getAllDtAmpliacionFecha() {
		return super.find("from " + getDomainClass().getName());
	}

	public DtAmpliacionFecha getDtAmpliacionFecha(Long id) {
		return super.findById(id);
	}

	public List<DtAmpliacionFecha> getNativeSQLDtAmpliacionFecha(String queryString,
			Object[] params) {
		return super.findNaviteQuery(queryString, params);
	}

	public Class<DtAmpliacionFecha> getDomainClass() {
		return DtAmpliacionFecha.class;
	}

	public List<DtAmpliacionFecha> getActivasDtAmpliacionFecha() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado > "+Estado.ELIMINADO.getValor());
	}
	
	public List<DtAmpliacionFecha> getActivasDtAmpliacionFechaCero() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado >= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAmpliacionFecha> getDesactivasDtAmpliacionFecha() {
		return super.find("from " + getDomainClass().getName()
				+ " t where t.estado <= "+Estado.ELIMINADO.getValor());
	}

	public List<DtAmpliacionFecha> getByIdDtAmpliacionFecha(Long id) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("select t from " + getDomainClass().getName()
				+ " t where t.idAutorizacion = ? order by t.idAutorizacion asc ");
		Object param[] = new Object[1];
		param[0] = id;
		List<DtAmpliacionFecha> lista = super.find(sb.toString(), param);
		return lista;
	}
	
	public Long getMaxIdVal(){
		String queryString = "select max(t.idAutorizacion) as maximo from "+getDomainClass().getName()+" t ";
		Long sequence = (Long) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0L;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public List<DtAmpliacionFecha> getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (tipoFechaCorte != null) {
			sb.append("and t.tipoFechaCorte = ? ");
			hs.add(tipoFechaCorte);
		}
		if (idSede != null) {
			sb.append("and t.idSede = ? ");
			hs.add(idSede);
		}
		if (idSistAdmi != null) {
			sb.append("and t.idSistAdmi = ? ");
			hs.add(idSistAdmi);
		}
		if (fechaInicio != null) {
			sb.append("and t.fechaInicio = ? ");
			hs.add(fechaInicio);
		}
		if (fechaFin != null) {
			sb.append("and t.fechaFin = ? ");
			hs.add(fechaFin);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.idAutorizacion desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<DtAmpliacionFecha> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<DtAmpliacionFecha> getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (tipoFechaCorte != null) {
					sb.append("and t.tipoFechaCorte = ? ");
					hs.add(tipoFechaCorte);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (fechaInicio != null) {
					sb.append("and t.fechaInicio = ? ");
					hs.add(fechaInicio);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.idAutorizacion desc ");

		List<DtAmpliacionFecha> lista = null;
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
	public long getTotalXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,Timestamp fechaInicio,Timestamp fechaFin,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.idAutorizacion) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (tipoFechaCorte != null) {
					sb.append("and t.tipoFechaCorte = ? ");
					hs.add(tipoFechaCorte);
				}
				if (idSede != null) {
					sb.append("and t.idSede = ? ");
					hs.add(idSede);
				}
				if (idSistAdmi != null) {
					sb.append("and t.idSistAdmi = ? ");
					hs.add(idSistAdmi);
				}
				if (fechaInicio != null) {
					sb.append("and t.fechaInicio = ? ");
					hs.add(fechaInicio);
				}
				if (fechaFin != null) {
					sb.append("and t.fechaFin = ? ");
					hs.add(fechaFin);
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
	
	//PURIBE 01022024 - INICIO-->
		@Override
		public DtAmpliacionFecha getXFiltro(Long tipoFechaCorte,Long idSede,Long idSistAdmi,int mesAutorizacion) {

			StringBuffer sb = new StringBuffer(100);
			Long estado = new Long(Estado.ACTIVO.getValor());
			List<Object> hs = new ArrayList<Object>();
			hs.add(estado);
			String smesAutorizacion="";
			smesAutorizacion= String.format("%02d", mesAutorizacion);
		
			sb.append("select t from " + getDomainClass().getName() + " t where t.estado = ? ");
			
			if (tipoFechaCorte != null) {
				sb.append("and t.tipoFechaCorte = ? ");
				hs.add(tipoFechaCorte);
			}
			if (idSede != null) {
				sb.append("and t.idSede = ? ");
				hs.add(idSede);
			}
			if (idSistAdmi != null) {
				sb.append("and t.idSistAdmi = ? ");
				hs.add(idSistAdmi);
			}		
			if (mesAutorizacion >0) {
				sb.append("and TO_CHAR(fecha_fin, 'MM') = ? ");
				hs.add(smesAutorizacion);
			}
			// sb.append("order by t.idAutorizacion desc ");
			
			Object param[] = new Object[hs.size()];
			hs.toArray(param);
			DtAmpliacionFecha registro =new DtAmpliacionFecha();
			
			try {
			registro = super.findUniqueResult(sb.toString(), param);
			return registro;
			
			} catch (NoResultException e) {
				log.log(Level.WARNING,
						" Clase:DtAmpliacionFecha Metodo:getXFiltro :No trajo Data:");
			    return null; 
			}
			catch (Exception e) {			    
			    log.log(Level.SEVERE, "Error no esperado: " + e.getMessage());
			    return null;
			}			
		
			//PURIBE 01022024 - FIN-->
		}
		
		//MPINARES 24012023 - INICIO
		public DtAmpliacionFecha find(Long tipoFechaCorte, Long idSede, Long idSistemaAdministrativo, int mesAutorizacion) throws Validador{
			//System.out.println("find("+tipoFechaCorte+", "+idSede+", "+idSistemaAdministrativo+", "+mesAutorizacion+")");
			StringBuilder query = new StringBuilder();
			query.append(" SELECT * ");
			query.append(" FROM Dt_Ampliacion_Fecha af ");
			query.append(" WHERE af.estado = ? ");
			query.append(" AND af.tipo_fecha_corte = ? ");
			query.append(" AND af.id_sede = ? ");
			query.append(" AND af.id_sist_admi = ? ");
			query.append(" AND TO_CHAR(fecha_fin, 'MM') = ? ");
			Object[] params = new Object[5];
			params[0] = new Long(PropertiesMg.DEFOULT_ESTADOS_REGISTROS_NUEVO);
			params[1] = tipoFechaCorte;
			params[2] = idSede;
			params[3] = idSistemaAdministrativo;
			params[4] = mesAutorizacion;
			//return super.findOne(query.toString(), params);
			return findOneNative(query.toString(), params);
		}
		//MPINARES 24012023 - FIN
}