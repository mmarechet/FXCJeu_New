package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Utilisateur;

/**
 * COmmentaire OK
 * 
 * @author mathieu
 *
 */
public interface UtilisateurService
{
	/**
	 * Permet d'ajouter un Utilisateur en redirigeant vers la dao
	 * 
	 * @param login
	 *            Login de l'utilisateur
	 * @param password
	 *            Mot de passe de l'utilisateur
	 * @return Utilisateur ajouté
	 */
	public Utilisateur ajouteUtilisateur(String login, String password);

	/**
	 * Permet de récupérer objet Utilisateur en fonction de son ID en
	 * redirigeant vers la dao
	 * 
	 * @param idUtilisateur
	 *            ID de l'utilisateur
	 * @return OBjet Utilisateur
	 */
	public Utilisateur recupererUtilisateurParID(int idUtilisateur);

	/**
	 * Permet de récuperer un liste d'utilisateur en redirigeant vers la dao
	 * 
	 * @return Liste d'utilisateur
	 */
	public List<Utilisateur> recupererListeUtilisateurs();
}
