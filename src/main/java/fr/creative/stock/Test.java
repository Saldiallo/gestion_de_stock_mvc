package fr.creative.stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import fr.creative.stock.doa.impl.FlickrDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FlickrDaoImpl daoImpl=new FlickrDaoImpl();
		//daoImpl.auth();
		
		try {
			InputStream stream = new FileInputStream(
					new File("C:\\Users\\Creative\\Pictures\\Saved Pictures\\img1.jpg"));
			String url=daoImpl.savePhoto(stream, "myImage");
			System.out.println("*** "+url+" ***");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
