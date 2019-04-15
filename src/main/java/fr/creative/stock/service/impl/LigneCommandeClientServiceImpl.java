package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.ILigneCommandeClientDao;
import fr.creative.stock.entities.LigneCommandeClient;
import fr.creative.stock.service.ILigneCommandeClientService;

@Transactional
public class LigneCommandeClientServiceImpl implements ILigneCommandeClientService{
	
	private ILigneCommandeClientDao ligneCommandeClientDao;

	public void setLigneCommandeClientDao(ILigneCommandeClientDao ligneCommandeClientDao) {
		this.ligneCommandeClientDao = ligneCommandeClientDao;
	}

	@Override
	public LigneCommandeClient save(LigneCommandeClient e) {
		return ligneCommandeClientDao.save(e);
	}

	@Override
	public LigneCommandeClient update(LigneCommandeClient e) {
		return ligneCommandeClientDao.update(e);
	}

	@Override
	public List<LigneCommandeClient> selectAll() {
		return ligneCommandeClientDao.selectAll();
	}

	@Override
	public List<LigneCommandeClient> selectAll(String sortField, String sort) {
		return ligneCommandeClientDao.selectAll(sortField, sort);
	}

	@Override
	public LigneCommandeClient getById(Long id) {
		return ligneCommandeClientDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		ligneCommandeClientDao.remove(id);
	}

	@Override
	public LigneCommandeClient findOne(String paramName, Object paramValue) {
		return ligneCommandeClientDao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCommandeClient findOne(String[] paramNames, Object[] paramValue) {
		return ligneCommandeClientDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return ligneCommandeClientDao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient) {
		// TODO Auto-generated method stub
		return ligneCommandeClientDao.getByIdCommande(idCommandeClient);
	}

}
