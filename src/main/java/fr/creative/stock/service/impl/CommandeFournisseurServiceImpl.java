package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import fr.creative.stock.doa.ICommandeFournisseurDao;
import fr.creative.stock.entities.CommandeFournisseur;
import fr.creative.stock.service.ICommandeFournisseurService;

@Transactional
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService {
	
	private ICommandeFournisseurDao commandeFournisseurDao;

	public void setCommandeFournisseurDao(ICommandeFournisseurDao commandeFournisseurDao) {
		this.commandeFournisseurDao = commandeFournisseurDao;
	}

	@Override
	public CommandeFournisseur save(CommandeFournisseur e) {
		return commandeFournisseurDao.save(e);
	}

	@Override
	public CommandeFournisseur update(CommandeFournisseur e) {
		return commandeFournisseurDao.update(e);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		return commandeFournisseurDao.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		return commandeFournisseurDao.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getById(Long id) {
		return commandeFournisseurDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		commandeFournisseurDao.remove(id);
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return commandeFournisseurDao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValue) {
		return commandeFournisseurDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return commandeFournisseurDao.findCountBy(paramName, paramValue);
	}

}
