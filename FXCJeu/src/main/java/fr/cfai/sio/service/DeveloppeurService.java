package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Developpeur;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface DeveloppeurService
{
	/**
	 * Permet de récupérer objet Developpeur en fonction de son ID en
	 * redirigeant vers la dao
	 * 
	 * @param idDeveloppeur
	 *            ID developpeur
	 * @return Objet Developpeur
	 */
	public Developpeur recupererDeveloppeurParID(int idDeveloppeur);

	/**
	 * Permet de récupérer la liste des developpeurs en redirigeant vers la dao
	 * 
	 * @return Liste des developpeurs
	 */
	public List<Developpeur> recupererListeDeveloppeurs();
}
