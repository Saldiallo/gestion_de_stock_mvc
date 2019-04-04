package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.ILigneVenteDao;
import fr.creative.stock.entities.LigneVente;
import fr.creative.stock.service.ILigneVenteService;

@Transactional
public class LigneVenteServiceImpl implements ILigneVenteService{
	
	private ILigneVenteDao ligneVenteDao; 

	public void setLigneVenteDao(ILigneVenteDao ligneVenteDao) {
		this.ligneVenteDao = ligneVenteDao;
	}

	@Override
	public LigneVente save(LigneVente e) {
		// TODO Auto-generated method stub
		return ligneVenteDao.save(e);
	}

	@Override
	public LigneVente update(LigneVente e) {
		return ligneVenteDao.update(e);
	}

	@Override
	public List<LigneVente> selectAll() {
		return ligneVenteDao.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		return ligneVenteDao.selectAll(sortField, sort);
	}

	@Override
	public LigneVente getById(Long id) {
		return ligneVenteDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		ligneVenteDao.remove(id);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return ligneVenteDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValue) {
		return ligneVenteDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ligneVenteDao.findCountBy(paramName, paramValue);
	}

}
