package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.LigneCommandeClient;

public interface ILigneCommandeClientService {
	
	public LigneCommandeClient save(LigneCommandeClient e);
	
	public LigneCommandeClient update(LigneCommandeClient e);
	
	public List<LigneCommandeClient> selectAll();
	
	public List<LigneCommandeClient> selectAll(String sortField,String sort);
	
	public LigneCommandeClient getById(Long id);
	
	public void remove(Long id);
	
	public LigneCommandeClient findOne(String paramName,Object paramValue);
	
	public LigneCommandeClient findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);

	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient);	

}
