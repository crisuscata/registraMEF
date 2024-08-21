/**
 * 
 */
package pe.gob.mef.registramef.bs.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.collections.CollectionUtils;

import pe.gob.mef.registramef.bs.exception.Validador;
/**
 * Interface BASE simple DAO que reemplaza a JpaDaoSupport que sale de
 * circulacion.
 * 
 * @author Carlos Aguilar
 * @version 2.0, 21/03/2012 06:28:21 PM
 * 
 *          /----------Nombre----------/----fecha----/-------------Motivo------
 *          --------/ Carlos Aguilar Chamochumbi 21/03/2012 06:28:21
 *          Implementación BASE de la persistencia de la clase
 * 
 */
public abstract class AbstractJpaCRUDDao<T, PK extends Serializable> implements DAO<T, PK> {

	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(T paramT) {
		// TODO Auto-generated method stub
		entityManager.persist(paramT);
	}

	public void update(T paramT) {
		// TODO Auto-generated method stub
		entityManager.merge(paramT);
		entityManager.flush();
	}

	public void delete(T paramT) {
		// TODO Auto-generated method stub
		// entityManager.remove(paramT);
	}

	public T findById(PK paramObject) {
		// TODO Auto-generated method stub
		return entityManager.find(getDomainClass(), paramObject);
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String paramString) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findNaviteQuery(String paramString) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(paramString, getDomainClass());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findNaviteQuery(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(paramString, getDomainClass());
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueResult(String paramString) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueResult(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		return (T) query.getSingleResult();
	}

	public Object findUniqueResultObject(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		// query.setParameter(paramArrayOfObject.length+1, new Integer(1));
		// query.setFirstResult(1);
		return query.getSingleResult();
	}

	public Object findUniqueResultObject(String paramString) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> findLimitedResult(String paramString, int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		query.setFirstResult(paramInt1);
		query.setMaxResults(paramInt2);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findLimitedResult(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(paramString);
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		query.setFirstResult(paramInt1);
		query.setMaxResults(paramInt2);
		return query.getResultList();
	}

	public void removeById(PK id) {
		// TODO Auto-generated method stub
		T entity = findById(id);
		if (entity != null) {
			entityManager.remove(entity);
		}
	}

	public void remove(T paramT) {
		// TODO Auto-generated method stub
		entityManager.remove(paramT);
	}

	public abstract Class<T> getDomainClass();

	public Object findNaviteQueryObject(String paramString) {
		Query query = entityManager.createNativeQuery(paramString);
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public <b> List<b> findNaviteQueryEdtidad(String paramString, Object[] paramArrayOfObject, Class<b> e) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(paramString, e);
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		List<b> fromSql = (List<b>) query.getResultList();
		return fromSql;
	}

	@SuppressWarnings("unchecked")
	public <b> List<b> findNaviteQueryEdtidadSinP(String paramString, Class<b> e) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(paramString, e);
		List<b> fromSql = (List<b>) query.getResultList();
		return fromSql;
	}

	public Object findUniqueNaviteQuery(String paramString, Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(paramString, getDomainClass());
		for (int i = 0; i < paramArrayOfObject.length; ++i) {
			query.setParameter((i + 1), paramArrayOfObject[i]);
		}
		return query.getSingleResult();
	}

	// VBALDEONH SPRINT2 INICIO
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> List<T> findNative(String select, Object[] params) {
		Query query = entityManager.createNativeQuery(select);
		if (params != null)
			setParemeter(query, params);
		return query.getResultList();
	}

	private void setParemeter(Query query, Object[] params) {
		if (params != null && params.length > 0)
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
	}
	// SPRINT2 FIN

	// MPINARES 24012023 - INICIO
	public T findOneNative(String select, Object[] params) throws Validador {
		try {
			List<T> list = findNaviteQuery(select, params);
			if (CollectionUtils.isNotEmpty(list)) {
				if (list.size() > 1)
					System.out.println("WARNING findOneNative: HAY MÁS DE UN REGISTRO");
				return list.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new Validador(e.getMessage());
		}
	}

	@SuppressWarnings({ "hiding" })
	public <T> List<T> findList(String select, Object[] params) throws Validador {
		return findList(select, params, null);
	}

	@SuppressWarnings({ "rawtypes", "hiding", "unchecked" })
	// Para devolver Arrays de Object[], DTO o Tuples
	public <T> List<T> findList(String select, Object[] params, Class clazz) throws Validador {
		try {
			Query query = null;
			if (clazz == null) {
				query = entityManager.createQuery(select);
			} else {
				// query = entityManager.createQuery("SELECT new
				// "+clazz.getName()+select, clazz);
				query = entityManager.createQuery(select, clazz);
			}
			
			if (params != null)
				setParemeter(query, params);
			return query.getResultList();
		} catch (Exception e) {
			throw new Validador(e.getMessage());
		}
	}
	// MPINARES 24012023 - FIN
	
	//JPUYEN 17062024 - INICIO
		@SuppressWarnings("hiding")
		public <T> T findOne(String select, Object[] params) throws Validador {
			return findOne(select, params, null);
		}
		
		@SuppressWarnings({ "hiding", "rawtypes" })
		public <T> T findOne(String select, Object[] params, Class clazz) throws Validador {
			try {
				List<T> list = null;
				
				if(clazz!=null) list = findList(select, params, clazz);
				else list = findList(select, params);
			
				if (CollectionUtils.isNotEmpty(list)){
					if(list.size()>1) System.out.println("WARNING findOne: HAY MÁS DE UN REGISTRO");
					return list.get(0);
				}else{
					return null;
				}
				
			} catch (Exception e) {
				throw new Validador(e.getMessage());
			}
		}
		//JPUYEN 17062024 - FIN
		
		@SuppressWarnings("unchecked")
		public <T> List<T> findNativeQueryEntidadLimit(String queryString,
		                                               Object[] params, 
		                                               Class<T> entityClass, 
		                                               int firstResult,
		                                               int maxResults) throws Validador { 

		    Query query = entityManager.createNativeQuery(queryString, entityClass);

		    if (params != null) {
		        setParameter(query, params);
		    }
		    if(firstResult!=0) {
		    	query.setFirstResult(firstResult);
		    }
		    if(maxResults!=0) {
		    	query.setMaxResults(maxResults);
		    }
		    

		    return (List<T>) query.getResultList();
		}
		
		@SuppressWarnings("unchecked")
		public <T> List<T> findNativeQueryEntidadLimit(String queryString,
		                                               Object[] params, 
		                                               int firstResult,
		                                               int maxResults) throws Validador { 

		    if (queryString == null || queryString.trim().isEmpty()) {
		        throw new IllegalArgumentException("Query string cannot be null or empty");
		    }

		    try {
		        Query query = entityManager.createNativeQuery(queryString);

		        if (params != null) {
		            setParameter(query, params);
		        }

		        query.setFirstResult(firstResult);
		        query.setMaxResults(maxResults);

		        return (List<T>) query.getResultList();

		    } catch (Exception e) {
		        // Log the exception here if needed
		        throw new Validador("Error executing native query", e);
		    }
		}


		private void setParameter(Query query, Object[] params) {
		    if (params != null && params.length > 0) {
		        for (int i = 0; i < params.length; i++) {
		            query.setParameter(i + 1, params[i]); // Positional parameters start from 1
		        }
		    }
		}
		
		public Object findNaviteUniqueResultObject(String paramString,
				Object[] paramArrayOfObject) {
			Query query = entityManager.createNativeQuery(paramString);
			for (int i = 0; i < paramArrayOfObject.length; ++i) {
				query.setParameter((i + 1), paramArrayOfObject[i]);

			}
			return query.getSingleResult();
		}
		
		@SuppressWarnings("hiding")
		public <T> List<T> findNative(String select) throws Validador {
			return findNative(select, null);
		}
		
		
}
