package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IUtilisateurDao;
import fr.creative.stock.entities.Utilisateur;
import fr.creative.stock.service.IUtilisateurService;

@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService{
	
	private IUtilisateurDao utilisateurDao; 

	public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public Utilisateur save(Utilisateur e) {
		// TODO Auto-generated method stub
		return utilisateurDao.save(e);
	}

	@Override
	public Utilisateur update(Utilisateur e) {
		return utilisateurDao.update(e);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return utilisateurDao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		return utilisateurDao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getById(Long id) {
		return utilisateurDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		utilisateurDao.remove(id);
	}

	@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		return utilisateurDao.findOne(paramName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValue) {
		return utilisateurDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return utilisateurDao.findCountBy(paramName, paramValue);
	}

}
