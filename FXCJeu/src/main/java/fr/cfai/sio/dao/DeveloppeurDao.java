package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Developpeur;

public interface DeveloppeurDao
{
	/**
	 * Permet de récupérer un objet Developpeur en fonction de son ID
	 * 
	 * @param idDeveloppeur
	 *            ID du developpeur
	 * @return L'objet Developpeur
	 */
	public Developpeur findDeveloppeurById(int idDeveloppeur);

	/**
	 * Permet de récupérer la liste des developpeurs
	 * 
	 * @return Liste des developpeurs
	 */
	public List<Developpeur> findAllDeveloppeurs();

}
