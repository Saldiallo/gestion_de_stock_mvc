package fr.creative.stock.service.impl;

import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

import fr.creative.stock.doa.IFlickrDao;
import fr.creative.stock.service.IFlickrService;

@Transactional
public class FlickrServiceImpl implements IFlickrService {
	
	private IFlickrDao flickrDao;

	public void setFlickrDao(IFlickrDao flickrDao) {
		this.flickrDao = flickrDao;
	}

	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		// TODO Auto-generated method stub
		return flickrDao.savePhoto(stream, fileName);
	}

}
