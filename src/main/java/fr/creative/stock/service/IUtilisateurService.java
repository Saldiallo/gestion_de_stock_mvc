package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Utilisateur;

public interface IUtilisateurService {
	
	public Utilisateur save(Utilisateur e);
	
	public Utilisateur update(Utilisateur e);
	
	public List<Utilisateur> selectAll();
	
	public List<Utilisateur> selectAll(String sortField,String sort);
	
	public Utilisateur getById(Long id);
	
	public void remove(Long id);
	
	public Utilisateur findOne(String paramName,Object paramValue);
	
	public Utilisateur findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
