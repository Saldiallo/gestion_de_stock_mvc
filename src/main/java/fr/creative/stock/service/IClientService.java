package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.Client;

public interface IClientService {
	
	public Client save(Client e);
	
	public Client update(Client e);
	
	public List<Client> selectAll();
	
	public List<Client> selectAll(String sortField,String sort);
	
	public Client getById(Long id);
	
	public void remove(Long id);
	
	public Client findOne(String paramName,Object paramValue);
	
	public Client findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
