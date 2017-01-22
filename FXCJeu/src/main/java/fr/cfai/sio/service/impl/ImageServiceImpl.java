package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Image;
import fr.cfai.sio.dao.ImageDao;
import fr.cfai.sio.dao.impl.ImageDaoImpl;
import fr.cfai.sio.service.ImageService;

public class ImageServiceImpl implements ImageService
{
	private ImageDao imageDaoImpl;

	public ImageServiceImpl() throws Exception
	{
		// System.out.println("Constructeur ImageServiceImpl");
		super();
		this.imageDaoImpl = new ImageDaoImpl();
	}

	@Override
	public Image ajouterImage(String chemin, int idTest)
	{
		Image image = null;

		if (imageDaoImpl.addImage(chemin, idTest) != 0)
		{
			image = new Image(chemin);
		}

		return image;
	}

	@Override
	public List<Image> recupererListeImages()
	{
		List<Image> listeImages = new ArrayList<>();

		listeImages = imageDaoImpl.findAllImages();

		return listeImages;

	}

	@Override
	public List<Image> recupererListeImagesParTest(int idTest)
	{
		List<Image> listeImages = new ArrayList<>();

		listeImages = imageDaoImpl.findAllImagesByTest(idTest);
				
		return listeImages;
	}

}
