package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Plateforme;

public interface PlateformeDao
{
	/**
	 * Permet de récupérer un Plateforme en fonction de son ID
	 * 
	 * @param idPlateforme
	 *            ID du Plateforme
	 * @return L'objet Plateforme
	 */
	public Plateforme findPlateformeById(int idPlateforme);

	/**
	 * Permet de récupérer la liste des Plateformes
	 * 
	 * @return la liste des Plateformes
	 */
	public List<Plateforme> findAllPlateformes();

	/**
	 * Permet de récupérer la liste des Plateforme en fonction d'un jeu
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return La liste des Plateforme du jeu
	 */
	public List<Plateforme> findAllPlateformesByJeu(int idJeu);
}
