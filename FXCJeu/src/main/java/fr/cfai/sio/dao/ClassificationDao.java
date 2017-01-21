package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Classification;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface ClassificationDao
{

	/**
	 * Permet de récupérer la liste des classifications
	 * 
	 * @return liste des classifications
	 */
	public List<Classification> findAllClassifications();

}
