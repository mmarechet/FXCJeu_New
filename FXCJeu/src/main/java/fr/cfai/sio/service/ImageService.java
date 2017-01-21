package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Image;

public interface ImageService
{

	public Image ajouterImage(String chemin, int idTest);
	
	public List<Image> recupererListeImages();
	
}
