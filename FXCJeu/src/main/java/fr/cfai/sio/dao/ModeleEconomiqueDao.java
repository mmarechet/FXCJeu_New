package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.ModeleEconomique;

public interface ModeleEconomiqueDao
{
	/**
	 * Permet de récupérer un ModeleEconomique en fonction de son ID
	 * 
	 * @param idModeleEconomique
	 *            ID du ModeleEconomique
	 * @return L'objet ModeleEconomique
	 */
	public ModeleEconomique findModeleEconomiqueById(int idModeleEconomique);

	/**
	 * Permet de récupérer la liste des ModeleEconomiques
	 * 
	 * @return Liste des ModeleEconomiques
	 */
	public List<ModeleEconomique> findAllModeleEconomiques();

	/**
	 * Permet de récupérer la liste des ModeleEconomique en fonction d'un jeu
	 * 
	 * @param idJeu
	 *            ID du jeu
	 * @return La liste des ModeleEconomique du jeu
	 */
	public List<ModeleEconomique> findAllModeleEconomiquesByJeu(int idJeu);
}
