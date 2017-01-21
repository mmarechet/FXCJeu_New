package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Editeur;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface EditeurDao
{
	/**
	 * Permet de récupérer un objet Editeur en fonction de son ID
	 * 
	 * @param idEditeur
	 *            ID de l'editeur
	 * @return L'objet Editeur
	 */
	public Editeur findEditeurById(int idEditeur);

	/**
	 * Permet de récupérer la liste des éditeurs
	 * 
	 * @return Liste des éditeurs
	 */
	public List<Editeur> findAllEditeurs();
}
