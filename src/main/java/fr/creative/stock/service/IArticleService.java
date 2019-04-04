package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Article;

public interface IArticleService {
	
	public Article save(Article e);
	
	public Article update(Article e);
	
	public List<Article> selectAll();
	
	public List<Article> selectAll(String sortField,String sort);
	
	public Article getById(Long id);
	
	public void remove(Long id);
	
	public Article findOne(String paramName,Object paramValue);
	
	public Article findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
