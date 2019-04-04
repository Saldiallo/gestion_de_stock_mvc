package fr.creative.stock.service;

import java.util.List;

import fr.creative.stock.entities.MvtStk;

public interface IMvtStkService {
	
	public MvtStk save(MvtStk e);
	
	public MvtStk update(MvtStk e);
	
	public List<MvtStk> selectAll();
	
	public List<MvtStk> selectAll(String sortField,String sort);
	
	public MvtStk getById(Long id);
	
	public void remove(Long id);
	
	public MvtStk findOne(String paramName,Object paramValue);
	
	public MvtStk findOne(String[] paramNames,Object[] paramValue);
	
	public int findCountBy(String paramName,String paramValue);	

}
