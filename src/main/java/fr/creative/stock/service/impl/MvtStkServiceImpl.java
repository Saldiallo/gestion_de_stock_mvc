package fr.creative.stock.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IMvtStkDao;
import fr.creative.stock.entities.MvtStk;
import fr.creative.stock.service.IMvtStkService;

@Transactional
public class MvtStkServiceImpl implements IMvtStkService{
	
	private IMvtStkDao mvtStkDao;

	public void setMvtStkDao(IMvtStkDao mvtStkDao) {
		this.mvtStkDao = mvtStkDao;
	}

	@Override
	public MvtStk save(MvtStk e) {
		// TODO Auto-generated method stub
		return mvtStkDao.save(e);
	}

	@Override
	public MvtStk update(MvtStk e) {
		// TODO Auto-generated method stub
		return mvtStkDao.update(e);
	}

	@Override
	public List<MvtStk> selectAll() {
		// TODO Auto-generated method stub
		return mvtStkDao.selectAll();
	}

	@Override
	public List<MvtStk> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return mvtStkDao.selectAll(sortField, sort);
	}

	@Override
	public MvtStk getById(Long id) {
		// TODO Auto-generated method stub
		return mvtStkDao.getById(id);
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		mvtStkDao.remove(id);
	}

	@Override
	public MvtStk findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return mvtStkDao.findOne(paramName, paramValue);
	}

	@Override
	public MvtStk findOne(String[] paramNames, Object[] paramValue) {
		// TODO Auto-generated method stub
		return mvtStkDao.findOne(paramNames, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return mvtStkDao.findCountBy(paramName, paramValue);
	}

}
