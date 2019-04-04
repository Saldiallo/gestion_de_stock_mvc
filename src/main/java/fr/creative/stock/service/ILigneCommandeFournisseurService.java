package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.LigneCommandeFournisseur;

public interface ILigneCommandeFournisseurService {
	
	public LigneCommandeFournisseur save(LigneCommandeFournisseur e);
	
	public LigneCommandeFournisseur update(LigneCommandeFournisseur e);
	
	public List<LigneCommandeFournisseur> selectAll();
	
	public List<LigneCommandeFournisseur> selectAll(String sortField,String sort);
	
	public LigneCommandeFournisseur getById(Long id);
	
	public void remove(Long id);
	
	public LigneCommandeFournisseur findOne(String paramName,Object paramValue);
	
	public LigneCommandeFournisseur findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
