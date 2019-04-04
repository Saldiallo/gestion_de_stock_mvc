package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.ICategorieDao;
import fr.creative.stock.entities.Categorie;
import fr.creative.stock.service.ICategorieService;

@Transactional
public class CategorieServiceImpl implements ICategorieService {
	
	private ICategorieDao categorieDao;
	
	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	@Override
	public Categorie save(Categorie e) {
		return categorieDao.save(e);
	}

	@Override
	public Categorie update(Categorie e) {
		return categorieDao.update(e);
	}

	@Override
	public List<Categorie> selectAll() {
		return categorieDao.selectAll();
	}

	@Override
	public List<Categorie> selectAll(String sortField, String sort) {
		return categorieDao.selectAll(sortField, sort);
	}

	@Override
	public Categorie getById(Long id) {
		return categorieDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		categorieDao.remove(id);
		
	}

	@Override
	public Categorie findOne(String paramName, Object paramValue) {
		return categorieDao.findOne(paramName, paramValue);
	}

	@Override
	public Categorie findOne(String[] paramNames, Object[] paramValue) {
		return categorieDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return categorieDao.findCountBy(paramName, paramValue);
	}

}
