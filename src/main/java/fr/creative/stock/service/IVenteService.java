package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Vente;

public interface IVenteService {
	
	public Vente save(Vente e);
	
	public Vente update(Vente e);
	
	public List<Vente> selectAll();
	
	public List<Vente> selectAll(String sortField,String sort);
	
	public Vente getById(Long id);
	
	public void remove(Long id);
	
	public Vente findOne(String paramName,Object paramValue);
	
	public Vente findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
