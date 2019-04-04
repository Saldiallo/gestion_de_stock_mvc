package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.CommandeFournisseur;

public interface ICommandeFournisseurService {
	
	public CommandeFournisseur save(CommandeFournisseur e);
	
	public CommandeFournisseur update(CommandeFournisseur e);
	
	public List<CommandeFournisseur> selectAll();
	
	public List<CommandeFournisseur> selectAll(String sortField,String sort);
	
	public CommandeFournisseur getById(Long id);
	
	public void remove(Long id);
	
	public CommandeFournisseur findOne(String paramName,Object paramValue);
	
	public CommandeFournisseur findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
