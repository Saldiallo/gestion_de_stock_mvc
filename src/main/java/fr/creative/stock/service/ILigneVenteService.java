package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.LigneVente;

public interface ILigneVenteService {
	
	public LigneVente save(LigneVente e);

	public LigneVente update(LigneVente e);
	
	public List<LigneVente> selectAll();
	
	public List<LigneVente> selectAll(String sortField,String sort);
	
	public LigneVente getById(Long id);
	
	public void remove(Long id);
	
	public LigneVente findOne(String paramName,Object paramValue);
	
	public LigneVente findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
