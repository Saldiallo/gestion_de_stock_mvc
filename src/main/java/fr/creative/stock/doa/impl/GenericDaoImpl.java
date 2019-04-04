package fr.creative.stock.doa.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.creative.stock.doa.IGenericDao;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<E> implements IGenericDao<E> {
	
	@PersistenceContext
	EntityManager em;
	
	private Class<E> type;	
	
	public Class<E> getType() {
		return type;
	}

	public GenericDaoImpl() {
		Type t= getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}

	@Override
	public E save(E e) {
		em.persist(e);
		return e;
	}

	@Override
	public E update(E e) {
		// TODO Auto-generated method stub
		return em.merge(e);
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("SELECT t FROM "+ type.getSimpleName() +" t");
		return query.getResultList();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		Query query = em.createQuery("SELECT t FROM "+ type.getSimpleName() +" t ORDER BY "+sortField +" "+sort);
		return query.getResultList();
	}

	@Override
	public E getById(Long id) {
		return em.find(type, id);
	}

	@Override
	public void remove(Long id) {
		E tab=em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public E findOne(String paramName, Object paramValue) {
		Query query = em.createQuery("SELECT t FROM "+ type.getSimpleName() +" t WHERE "+paramName+" =:x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? (E)query.getResultList().get(0):null;
	}

	@Override
	public E findOne(String[] paramNames, Object[] paramValue) {
		if(paramNames.length!=paramNames.length)
			return null;
		
		String queryString="SELECT t FROM "+type.getName()+ " e WHERE ";
		/*int len = paramNames.length;*/
		for(int i=0;i<paramNames.length;i++) {
			queryString +=" e."+paramNames[i]+"= :x"+i;
			if((i+1)<paramNames.length) {
				queryString += " and";
			}
		}
		Query query=em.createQuery(queryString);
		for(int i=0;i<paramValue.length;i++) {
			query.setParameter("x"+i, paramValue[i]);
		}
		return query.getResultList().size() > 0 ? (E)query.getResultList().get(0):null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("SELECT t FROM "+ type.getSimpleName() +" t WHERE "+paramName+" =:x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? ((Long) query.getSingleResult()).intValue() : 0;
	
	}

}
