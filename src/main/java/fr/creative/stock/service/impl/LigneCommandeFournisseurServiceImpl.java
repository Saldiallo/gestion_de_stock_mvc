package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.ILigneCommandeFournisseurDao;
import fr.creative.stock.entities.LigneCommandeFournisseur;
import fr.creative.stock.service.ILigneCommandeFournisseurService;

@Transactional
public class LigneCommandeFournisseurServiceImpl implements ILigneCommandeFournisseurService {
	
	private ILigneCommandeFournisseurDao ligneCommandeFournisseurDao;

	public void setLigneCommandeFournisseurDao(ILigneCommandeFournisseurDao ligneCommandeFournisseurDao) {
		this.ligneCommandeFournisseurDao = ligneCommandeFournisseurDao;
	}

	@Override
	public LigneCommandeFournisseur save(LigneCommandeFournisseur e) {
		return ligneCommandeFournisseurDao.save(e);
	}

	@Override
	public LigneCommandeFournisseur update(LigneCommandeFournisseur e) {
		return ligneCommandeFournisseurDao.update(e);
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll() {
		return ligneCommandeFournisseurDao.selectAll();
	}

	@Override
	public List<LigneCommandeFournisseur> selectAll(String sortField, String sort) {
		return ligneCommandeFournisseurDao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeFournisseur getById(Long id) {
		return ligneCommandeFournisseurDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		ligneCommandeFournisseurDao.remove(id);
	}

	@Override
	public LigneCommandeFournisseur findOne(String paramName, Object paramValue) {
		return ligneCommandeFournisseurDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeFournisseur findOne(String[] paramNames, Object[] paramValue) {
		return ligneCommandeFournisseurDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ligneCommandeFournisseurDao.findCountBy(paramName, paramValue);
	}

}
