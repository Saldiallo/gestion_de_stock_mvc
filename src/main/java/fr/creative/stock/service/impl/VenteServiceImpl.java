package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IVenteDao;
import fr.creative.stock.entities.Vente;
import fr.creative.stock.service.IVenteService;

@Transactional
public class VenteServiceImpl implements IVenteService{
	
	private IVenteDao venteDao;

	public void setVenteDao(IVenteDao venteDao) {
		this.venteDao = venteDao;
	}

	@Override
	public Vente save(Vente e) {
		// TODO Auto-generated method stub
		return venteDao.save(e);
	}

	@Override
	public Vente update(Vente e) {
		return venteDao.update(e);
	}

	@Override
	public List<Vente> selectAll() {
		return venteDao.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		return venteDao.selectAll(sortField, sort);
	}

	@Override
	public Vente getById(Long id) {
		return venteDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		venteDao.remove(id);
	}

	@Override
	public Vente findOne(String paramName, Object paramValue) {
		return venteDao.findOne(paramName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValue) {
		return venteDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return venteDao.findCountBy(paramName, paramValue);
	}

}
