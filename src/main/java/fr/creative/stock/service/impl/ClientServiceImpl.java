package fr.creative.stock.service.impl;

import java.util.List;

import fr.creative.stock.doa.IClientDao;
import fr.creative.stock.entities.Client;
import fr.creative.stock.service.IClientService;

public class ClientServiceImpl implements IClientService {
	
	private IClientDao clientDao;

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public Client save(Client e) {
		return clientDao.save(e);
	}

	@Override
	public Client update(Client e) {
		return clientDao.update(e);
	}

	@Override
	public List<Client> selectAll() {
		return clientDao.selectAll();
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		return clientDao.selectAll(sortField, sort);
	}

	@Override
	public Client getById(Long id) {
		return clientDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		clientDao.remove(id);
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		return clientDao.findOne(paramName, paramValue);
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValue) {
		return clientDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return clientDao.findCountBy(paramName, paramValue);
	}

}
