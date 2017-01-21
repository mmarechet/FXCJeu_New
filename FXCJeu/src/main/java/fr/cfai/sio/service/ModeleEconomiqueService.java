package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.ModeleEconomique;

public interface ModeleEconomiqueService
{
	/**
	 * Permet de récupérer objet ModeleEconomique en fonction de son ID en
	 * redirigeant vers la dao
	 * 
	 * @param idModeleEconomique
	 *            ID du ModeleEconomique
	 * @return Objet ModeleEconomique
	 */
	public ModeleEconomique recupererModeleEconomiqueParId(int idModeleEconomique);

	/**
	 * Permet de récupérer une liste des ModeleEconomique en redirigeant vers la
	 * dao
	 * 
	 * @return Liste des ModeleEconomique
	 */
	public List<ModeleEconomique> recupererListeModeleEconomiques();

	/**
	 * Pertmet de récupérer une liste des ModeleEconomique en fonction de l'id
	 * d'un jeu
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return Liste des ModeleEconomique du jeu
	 */
	public List<ModeleEconomique> recupererListeModeleEconomiquesParJeu(int idJeu);
}
