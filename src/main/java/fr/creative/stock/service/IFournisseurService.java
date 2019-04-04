package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Fournisseur;

public interface IFournisseurService {
	
	public Fournisseur save(Fournisseur e);
	
	public Fournisseur update(Fournisseur e);
	
	public List<Fournisseur> selectAll();
	
	public List<Fournisseur> selectAll(String sortField,String sort);
	
	public Fournisseur getById(Long id);
	
	public void remove(Long id);
	
	public Fournisseur findOne(String paramName,Object paramValue);
	
	public Fournisseur findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
