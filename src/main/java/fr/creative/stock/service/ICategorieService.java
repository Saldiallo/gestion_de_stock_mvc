package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Categorie;

public interface ICategorieService {
	
	public Categorie save(Categorie e);
	
	public Categorie update(Categorie e);
	
	public List<Categorie> selectAll();
	
	public List<Categorie> selectAll(String sortField,String sort);
	
	public Categorie getById(Long id);
	
	public void remove(Long id);
	
	public Categorie findOne(String paramName,Object paramValue);
	
	public Categorie findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
