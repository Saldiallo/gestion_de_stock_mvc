package fr.creative.stock.doa.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;


import fr.creative.stock.doa.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao {
	
	private Flickr flickr;
	private UploadMetaData uploadMetaData= new UploadMetaData();
	private String apiKey="9eceaf2470566e8de40e475a84f79024";
	private String sharedSecret="019fdd62b836a886";
	
	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth=new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157677551719817-76a09b21dfafacde");
		auth.setTokenSecret("6f72720b494a0d87");
		RequestContext requestContext =RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}

	@Override
	public String savePhoto(InputStream stream, String fileName) throws Exception {
		connect();
		uploadMetaData.setTitle(fileName);
		String photoId =flickr.getUploader().upload(stream, uploadMetaData);
		
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	public void auth() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		AuthInterface authInterface =flickr.getAuthInterface();
		Token token=authInterface.getRequestToken();
		
		System.out.println("TOKEN -- : "+token  );
		
		String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(url);
		System.out.println("------------------------------");
		System.out.print(">>");
		
		String tokenKey=JOptionPane.showInputDialog(null);
		
		Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
		System.out.println("success");
		
		Auth auth=null;
		try {
			auth=authInterface.checkToken(requestToken);
		} catch (FlickrException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		System.out.println("Token : "+requestToken.getToken());
		System.out.println("Secret : "+requestToken.getSecret());
		System.out.println("nsid : "+auth.getUser().getId());
		System.out.println("RealName : "+auth.getUser().getRealName());
		System.out.println("UserName : "+ auth.getUser().getUsername());
		System.out.println("---------------------------");
	}
	
	
	

}
