package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Jeu;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface JeuDao
{
	/**
	 * Permet de récupérer un Objet Jeu en fonction de son ID
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return L'Objet Jeu
	 */
	public Jeu findJeuById(int idJeu);

	/**
	 * Permet de récupérer la liste des jeux
	 * 
	 * @return Liste des jeux
	 */
	//public List<Jeu> findAllJeux();

	public List<Jeu> findAllJeux();
}
