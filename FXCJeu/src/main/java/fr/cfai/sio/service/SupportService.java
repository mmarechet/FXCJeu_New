package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Support;

/**
 * COmmentaire OK
 * 
 * @author mathieu
 *
 */
public interface SupportService
{
	/**
	 * Permet de récupérer objet Support en fonction de son ID en redirigeant
	 * vers la dao
	 * 
	 * @param idSupport
	 *            ID du support
	 * @return Objet SUpport
	 */
	public Support recupererSupportParId(int idSupport);

	/**
	 * Permet de récupérer une liste des supports en redirigeant vers la dao
	 * 
	 * @return Liste des supports
	 */
	public List<Support> recupererListeSupports();

	/**
	 * Pertmet de récupérer une liste des supports en fonction de l'id d'un jeu
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return Liste des support du jeu
	 */
	public List<Support> recupererListeSupportsParJeu(int idJeu);
}
