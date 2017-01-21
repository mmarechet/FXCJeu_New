package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Image;

public interface ImageDao
{
	public int addImage(String chemin, int idTest);
	
	public List<Image> findAllImages();
}
