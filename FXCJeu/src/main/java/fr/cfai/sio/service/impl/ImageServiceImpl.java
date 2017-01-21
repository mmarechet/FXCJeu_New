package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Image;
import fr.cfai.sio.dao.ImageDao;
import fr.cfai.sio.dao.impl.ImageDaoImpl;
import fr.cfai.sio.service.ImageService;

public class ImageServiceImpl implements ImageService
{
private ImageDao imageDaoImpl;
private List<Image> listeImages;
	
	public ImageServiceImpl() throws Exception
	{
		//	System.out.println("Constructeur ImageServiceImpl");
		super();
		this.imageDaoImpl = new ImageDaoImpl();
	}

	@Override
	public Image ajouterImage(String chemin, int idTest)
	{
		Image image = null;

		if (imageDaoImpl.addImage(chemin, idTest) != 0)
		{
			image=new Image(chemin);
		}

		return image;
	}

	@Override
	public List<Image> recupererListeImages()
	{
		
			listeImages = imageDaoImpl.findAllImages();
			return listeImages;
		
	}

}
