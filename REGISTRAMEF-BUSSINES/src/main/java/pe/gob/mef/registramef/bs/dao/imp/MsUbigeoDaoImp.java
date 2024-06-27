package pe.gob.mef.registramef.bs.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mef.registramef.bs.dao.MsUbigeoDao;
import pe.gob.mef.registramef.bs.dao.base.AbstractJpaCRUDDao;
import pe.gob.mef.registramef.bs.domain.MsUbigeo;
import pe.gob.mef.registramef.bs.domain.MsUbigeoId;
import pe.gob.mef.registramef.bs.utils.Estado;

/**
 * MS_UBIGEO REPOSITORIO: LISTA EL UBIGEO (DEPARTAMENTO
 * 
 * @author Carlos Aguilar
 * @version 2.0, 06/03/2024 23:27
 * 
 *    /----------Nombre----------/---------fecha------/------------Motivo---------/
 *   /Carlos Aguilar Chamochumbi/ 06/03/2024 23:27   / Creación de la clase    /
 * 
 */
@Repository
public class MsUbigeoDaoImp extends
		AbstractJpaCRUDDao<MsUbigeo, MsUbigeoId> implements
		MsUbigeoDao {

	private static final Logger log = Logger.getLogger(MsUbigeoDaoImp.class.getName());

	public MsUbigeoDaoImp() {
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsUbigeoDaoImp");
	}
	
	public MsUbigeoDaoImp(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		log.log(Level.INFO,null,"INICIALIZANDO JPA TEMPLATE PARA MsUbigeoDaoImp");
	}
	
	//PURIBE 16012024 - INICIO--
		@Transactional
		public void saveMsUbigeo(MsUbigeo param) {
			super.save(param);
		}

		@Transactional
		public void updateMsUbigeo(MsUbigeo param) {
			super.update(param);
		}

		@Transactional
		public void deleteMsUbigeo(MsUbigeo param) {
			super.delete(param);
		}

		public List<MsUbigeo> getAllMsUbigeo() {
			return super.find("from " + getDomainClass().getName());
		}

		public MsUbigeo getMsUbigeo(MsUbigeoId id) {
			return super.findById(id);
		}

		public List<MsUbigeo> getNativeSQLMsUbigeo(String queryString,
				Object[] params) {
			return super.findNaviteQuery(queryString, params);
		}

		public Class<MsUbigeo> getDomainClass() {
			return MsUbigeo.class;
		}

		public List<MsUbigeo> getActivasMsUbigeo() {
			return super.find("from " + getDomainClass().getName()
					+ " t where t.estado > 0");
		}
		
		public List<MsUbigeo> getActivasMsUbigeoCero() {
			return super.find("from " + getDomainClass().getName()
					+ " t where t.estado >= 0");
		}

		public List<MsUbigeo> getDesactivasMsUbigeo() {
			return super.find("from " + getDomainClass().getName()
					+ " t where t.estado <= 0");
		}

		public List<MsUbigeo> getByIdMsUbigeo(MsUbigeoId id) {
			StringBuffer sb = new StringBuffer(100);
			sb.append("select t from " + getDomainClass().getName()
					+ " t where t.id = ? order by t.id asc ");
			Object param[] = new Object[1];
			param[0] = id;
			List<MsUbigeo> lista = super.find(sb.toString(), param);
			return lista;
		}
		

		//PURIBE 16012024 - FIN--
	
	@Override
	public Integer getMaxIdValcodDpto(){
		String queryString = "select max(t.id.codDpto) as maximo from "+getDomainClass().getName()+" t "+
	    "where t.id.codProv=0 AND t.id.codDistr=0";
		
		Integer sequence = (Integer) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public Integer getMaxIdValcodProv(Integer codDpto){
		String queryString = "select max(t.id.codProv) as maximo from "+getDomainClass().getName()+" t "+
	    "where t.id.codDpto="+codDpto+" AND t.id.codDistr=0";
		
		Integer sequence = (Integer) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0;
		}
		sequence ++;
		return sequence;
	}
	
	@Override
	public Integer getMaxIdValcodDistr(Integer codDpto,Integer codProv){
		String queryString = "select max(t.id.codDistr) as maximo from "+getDomainClass().getName()+" t "+
	    "where t.id.codDpto="+codDpto+" AND t.id.codProv="+codProv;
		
		Integer sequence = (Integer) super.findUniqueResultObject(queryString);
		if (sequence == null) {
			sequence = 0;
		}
		sequence ++;
		return sequence;
	}
	
	
	
	@Override
	public List<MsUbigeo> getXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
		if (codDpto != null) {
			sb.append("and t.codDpto = ? ");
			hs.add(codDpto);
		}
		if (codProv != null) {
			sb.append("and t.codProv = ? ");
			hs.add(codProv);
		}
		if (codDistr != null) {
			sb.append("and t.codDistr = ? ");
			hs.add(codDistr);
		}
		if (fechaCrea != null) {
			sb.append("and t.fechaCrea = ? ");
			hs.add(fechaCrea);
		}
		if (fechaModif != null) {
			sb.append("and t.fechaModif = ? ");
			hs.add(fechaModif);
		}
		if (estado != null) {
			sb.append("and t.estado = ? ");
			hs.add(estado);
		}		
		// sb.append("order by t.id desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsUbigeo> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsUbigeo> getXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.codDistr = ? ");
					hs.add(codDistr);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
				}
				if (fechaModif != null) {
					sb.append("and t.fechaModif = ? ");
					hs.add(fechaModif);
				}
				if (estado != null) {
					sb.append("and t.estado = ? ");
					hs.add(estado);
				}
		// sb.append("order by t.id desc ");

		List<MsUbigeo> lista = null;
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
	public long getTotalXFiltro(Integer codDpto,Integer codProv,Integer codDistr,Timestamp fechaCrea,Timestamp fechaModif,Long estado) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.id) from " + getDomainClass().getName() + " t where t.estado >= "+Estado.ACTIVO.getValor()+" ");

		
				if (codDpto != null) {
					sb.append("and t.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.codDistr = ? ");
					hs.add(codDistr);
				}
				if (fechaCrea != null) {
					sb.append("and t.fechaCrea = ? ");
					hs.add(fechaCrea);
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
	
	//MPINARES 24012023 - INICIO
	@Override
	public List<MsUbigeo> getDepartamentos() {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codProv = 0 AND ");
		sb.append("tablaa.id.codDistr = 0 ");
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		sb.append("ORDER BY tablaa.descripcion");
		return super.find(sb.toString());
	}

	@Override
	public List<MsUbigeo> getProvincias(Integer id_dpto) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codDpto = ? AND ");
		sb.append("tablaa.id.codDistr = 0 AND ");
		sb.append("tablaa.id.codProv <> 0 ");
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		sb.append("ORDER BY tablaa.descripcion");
		Object[] params = new Object[1];
		params[0] = id_dpto;
		return super.find(sb.toString(), params);
	}

	@Override
	public List<MsUbigeo> getDistritos(Integer id_dpto, Integer id_prov) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codDpto = ? AND ");
		sb.append("tablaa.id.codProv = ? AND ");
		sb.append("tablaa.id.codDistr <> 0 ");
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		sb.append("ORDER BY tablaa.descripcion");
		Object[] params = new Object[2];
		params[0] = id_dpto;
		params[1] = id_prov;
		return super.find(sb.toString(), params);
	}
	
	@Override
	public MsUbigeo getDepartamentosXNombre(String descripcion) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codProv = 0 ");
		sb.append("AND tablaa.id.codDistr = 0 ");
		sb.append("AND tablaa.descripcion=? ");
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		Object[] params = new Object[1];
		MsUbigeo msUbigeo = null;
		params[0] = descripcion;
		try{
		List<MsUbigeo> lista = super.find(sb.toString(), params);
		if(!lista.isEmpty())
			msUbigeo = lista.get(0);
		}catch(Exception e){}
		return msUbigeo;
	}

	@Override
	public MsUbigeo getProvinciasXNombre(Integer id_dpto, String descripcion) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codDpto = ? ");
		sb.append("AND tablaa.id.codProv>0 AND tablaa.id.codDistr = 0 ");
		sb.append("AND tablaa.descripcion=? ");		
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		Object[] params = new Object[2];
		params[0] = id_dpto;
		MsUbigeo msUbigeo = null;
		params[1] = descripcion;
		try{
		List<MsUbigeo> lista = super.find(sb.toString(), params);
		if(!lista.isEmpty())
			msUbigeo = lista.get(0);
		}catch(Exception e){}
		return msUbigeo;
	}

//	codDistr
//	codDpto
//	codProv
	
	@Override
	public MsUbigeo getDistritosXNombre(Integer id_dpto, Integer id_prov, String descripcion) {
		StringBuffer sb = new StringBuffer(100);
		sb.append("FROM MsUbigeo tablaa ");
		sb.append("WHERE tablaa.id.codDpto = ? ");
		sb.append("AND tablaa.id.codProv = ? AND tablaa.id.codDistr>0 ");
		sb.append("AND tablaa.descripcion=? ");
		sb.append("and tablaa.estado >= " +Estado.ACTIVO.getValor()+" "); 	//PURIBE 12042024 - INICIO
		Object[] params = new Object[3];
		params[0] = id_dpto;
		params[1] = id_prov;
		MsUbigeo msUbigeo = null;
		params[2] = descripcion;
		try{
		List<MsUbigeo> lista = super.find(sb.toString(), params);
		if(!lista.isEmpty())
			msUbigeo = lista.get(0);
		}catch(Exception e){}
		return msUbigeo;
	}
	
	public MsUbigeo getMsUbigeoByCodes(Long idDepart, Long idProv, Long idDist) {
		List<MsUbigeo> lista = new ArrayList<MsUbigeo>();
		try {
			StringBuffer sb = new StringBuffer(100);			
			sb.append("select t from " + getDomainClass().getName()	+ " t ");

			if (idProv != null && idProv != null && idDist != null ) {
				sb.append(" where t.id.codDpto = ? and t.id.codProv = ? and t.id.codDistr = ? and t.estado =3 ");
				sb.append(" order by t.descripcion asc ");
			}			
			Object param[] = new Object[3];
			param[0] = idDepart.intValue();
			param[1] = idProv.intValue();
			param[2] = idDist.intValue();
			lista = super.find(sb.toString(), param);									
		} catch (Exception e) {
			log.info(e.getMessage());
		}		
		return lista.get(0);
	}
	//MPINARES 24012023 - FIN
	
	@Override
	public List<MsUbigeo> getXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= 1 ");

		
		if (descripcion != null && descripcion.trim().length() > 0) {
			sb.append("and t.descripcion = ? ");
			hs.add(descripcion);
		}
		if (codDpto != null) {
			sb.append("and t.id.codDpto = ? ");
			hs.add(codDpto);
		}
		if (codProv != null) {
			sb.append("and t.id.codProv = ? ");
			hs.add(codProv);
		}
		if (codDistr != null) {
			sb.append("and t.id.codDistr = ? ");
			hs.add(codDistr);
		}		
		// sb.append("order by t.id desc ");

		Object param[] = new Object[hs.size()];
		hs.toArray(param);
		List<MsUbigeo> lista = super.find(sb.toString(), param);

		return lista;
	}

	@Override
	public List<MsUbigeo> getXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr, int iniciar, int max) {
		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select t from " + getDomainClass().getName() + " t where t.estado >= 1 ");

		
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (codDpto != null) {
					sb.append("and t.id.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.id.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.id.codDistr = ? ");
					hs.add(codDistr);
				}
		// sb.append("order by t.id desc ");

		List<MsUbigeo> lista = null;
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
	public long getTotalXFiltro(String descripcion,Integer codDpto,Integer codProv,Integer codDistr) {

		StringBuffer sb = new StringBuffer(100);
		List<Object> hs = new ArrayList<Object>();
		sb.append("select count(t.descripcion) from " + getDomainClass().getName() + " t where t.estado >= 1 ");

		
				if (descripcion != null && descripcion.trim().length() > 0) {
					sb.append("and t.descripcion = ? ");
					hs.add(descripcion);
				}
				if (codDpto != null) {
					sb.append("and t.id.codDpto = ? ");
					hs.add(codDpto);
				}
				if (codProv != null) {
					sb.append("and t.id.codProv = ? ");
					hs.add(codProv);
				}
				if (codDistr != null) {
					sb.append("and t.id.codDistr = ? ");
					hs.add(codDistr);
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
	
	//PURIBE 15012024 - INICIO--
		public Long getMaxIdVal(){
			String queryString = "select max(t.id) as maximo from "+getDomainClass().getName()+" t ";
			Long sequence = (Long) super.findUniqueResultObject(queryString);
			if (sequence == null) {
				sequence = 0L;
			}
			sequence ++;
			return sequence;
		}
		
		public Integer getMaxIdVAlCodProv(Integer codDpto){
			StringBuffer sb = new StringBuffer(100);
			sb.append("select max(t.id.codProv) as maximo from "+getDomainClass().getName()+" t where t.id.codDpto = ?");
			Object[] params = new Object[1];
			params[0] = codDpto;
			Integer sequence=0;
			try{
				sequence= (Integer) super.findUniqueResultObject(sb.toString(), params);
			
			sequence ++;}
			catch(Exception e){
				}
			return sequence;
		}
		
		public Integer getMaxIdVAlCodDistr(Integer codDpto,Integer codProv){
			StringBuffer sb = new StringBuffer(100);
			sb.append("select max(t.id.codDistr) as maximo from "+getDomainClass().getName()+" t where t.id.codDpto = ?");
			sb.append("and t.id.codProv = ?");
			Object[] params = new Object[2];
			params[0] = codDpto;
			params[1] = codProv;
			Integer sequence=0;
			try{
				sequence= (Integer) super.findUniqueResultObject(sb.toString(), params);
			
			sequence ++;}
			catch(Exception e){
				}
			return sequence;
		}

		public Integer getMaxIdVAlCodDept(){
			String queryString = "select max(t.id.codDpto) as maximo from "+getDomainClass().getName()+" t ";
			Integer sequence = (Integer) super.findUniqueResultObject(queryString);
			if (sequence == null) {
				sequence = 0;
			}
			sequence ++;
			return sequence;
		}
		
		//PURIBE 15012024 - FIN--

	
}