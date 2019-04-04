package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IFournisseurDao;
import fr.creative.stock.entities.Fournisseur;
import fr.creative.stock.service.IFournisseurService;

@Transactional
public class FournisseurServiceImpl implements IFournisseurService {
	
	private IFournisseurDao fournisseurDao; 

	public void setFournisseurDao(IFournisseurDao fournisseurDao) {
		this.fournisseurDao = fournisseurDao;
	}

	@Override
	public Fournisseur save(Fournisseur e) {
		return fournisseurDao.save(e);
	}

	@Override
	public Fournisseur update(Fournisseur e) {
		return fournisseurDao.update(e);
	}

	@Override
	public List<Fournisseur> selectAll() {
		return fournisseurDao.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		return fournisseurDao.selectAll(sortField, sort);
	}

	@Override
	public Fournisseur getById(Long id) {
		return fournisseurDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		fournisseurDao.remove(id);
	}

	@Override
	public Fournisseur findOne(String paramName, Object paramValue) {
		return fournisseurDao.findOne(paramName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValue) {
		return fournisseurDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return fournisseurDao.findCountBy(paramName, paramValue);
	}

}
