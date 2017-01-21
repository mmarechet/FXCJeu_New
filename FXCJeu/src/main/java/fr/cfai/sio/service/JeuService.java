package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Jeu;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface JeuService
{
	/**
	 * Permet de récupérer objet Jeu en fonction de son ID en redirigeant vers
	 * la dao
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return Objet Jeu
	 */
	public Jeu recupereJeuParID(int idJeu);

	/**
	 * Permet de récupérer une liste de jeux en redirigeant vers la dao
	 * 
	 * @return Liste des jeux
	 */
	public List<Jeu> recupererListeJeux();
}
