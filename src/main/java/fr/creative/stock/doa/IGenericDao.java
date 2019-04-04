package fr.creative.stock.doa;

import java.util.List;

public interface IGenericDao<E> {
	
	public E save(E e);
	
	public E update(E e);
	
	public List<E> selectAll();
	
	public List<E> selectAll(String sortField,String sort);
	
	public E getById(Long id);
	
	public void remove(Long id);
	
	public E findOne(String paramName,Object paramValue);
	
	public E findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
