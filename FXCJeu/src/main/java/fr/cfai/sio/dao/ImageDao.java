package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Image;

public interface ImageDao
{
	/**
	 * Ajoute une image
	 * @param chemin
	 * @param idTest
	 * @return
	 */
	public int addImage(String chemin, int idTest);
	
	/**
	 * Récupère la liste des images
	 * @return
	 */
	public List<Image> findAllImages();
	
	/**
	 * Récupère toutes les images d'un test
	 * @param idTest
	 * @return
	 */
	public List<Image> findAllImagesByTest(int idTest);
}
