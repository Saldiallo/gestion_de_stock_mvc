package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.ICommandeClientDao;
import fr.creative.stock.entities.CommandeClient;
import fr.creative.stock.service.ICommandeClientService;

@Transactional
public class CommandeClientServiceImpl implements ICommandeClientService {
	
	private ICommandeClientDao commandeClientDao;

	public void setCommandeClientDao(ICommandeClientDao commandeClientDao) {
		this.commandeClientDao = commandeClientDao;
	}

	@Override
	public CommandeClient save(CommandeClient e) {
		return commandeClientDao.save(e);
	}

	@Override
	public CommandeClient update(CommandeClient e) {
		return commandeClientDao.update(e);
	}

	@Override
	public List<CommandeClient> selectAll() {
		return commandeClientDao.selectAll();
	}

	@Override
	public List<CommandeClient> selectAll(String sortField, String sort) {
		return commandeClientDao.selectAll(sortField, sort);
	}

	@Override
	public CommandeClient getById(Long id) {
		return commandeClientDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		commandeClientDao.remove(id);
	}

	@Override
	public CommandeClient findOne(String paramName, Object paramValue) {
		return commandeClientDao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValue) {
		return commandeClientDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return commandeClientDao.findCountBy(paramName, paramValue);
	}

}
