package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Editeur;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface EditeurService
{
	/**
	 * Permet de récupérer objet Editeur en fonction de son ID en redirigeant
	 * vers la dao
	 * 
	 * @param idEditeur
	 *            ID Editeur
	 * @return Objet Editeur
	 */
	public Editeur recupereEditeurParID(int idEditeur);

	/**
	 * Permet de récupérer liste des editeurs redirigeant vers la dao
	 * 
	 * @return Liste des editeurs
	 */
	public List<Editeur> recupererListeEditeurs();
}
