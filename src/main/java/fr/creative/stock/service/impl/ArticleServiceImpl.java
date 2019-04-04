package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IArticleDao;
import fr.creative.stock.entities.Article;
import fr.creative.stock.service.IArticleService;

@Transactional
public class ArticleServiceImpl implements IArticleService{
	
	private IArticleDao articleDao;

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article save(Article e) {
		return articleDao.save(e);
	}

	@Override
	public Article update(Article e) {
		return articleDao.update(e);
	}

	@Override
	public List<Article> selectAll() {
		return articleDao.selectAll();
	}

	@Override
	public List<Article> selectAll(String sortField, String sort) {
		return articleDao.selectAll(sortField, sort);
	}

	@Override
	public Article getById(Long id) {
		return articleDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		articleDao.remove(id);
	}

	@Override
	public Article findOne(String paramName, Object paramValue) {
		return articleDao.findOne(paramName, paramValue);
	}

	@Override
	public Article findOne(String[] paramNames, Object[] paramValue) {
		return articleDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return articleDao.findCountBy(paramName, paramValue);
	}

}
