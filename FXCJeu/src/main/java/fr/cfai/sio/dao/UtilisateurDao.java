package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Utilisateur;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public interface UtilisateurDao
{
	/**
	 * Permet d'ajouter un objet Utilisateur en BDD
	 * 
	 * @param login
	 *            Login de l'utilisateur
	 * @param mdp
	 *            Mot de passe du l'utilisateur
	 * @return le statut de la requete sql
	 */
	public int addUtilisateur(String login, String mdp);

	/**
	 * Permet de récupérer un objet Utilisateur en fonction de son ID
	 * 
	 * @param idUtilisateur
	 *            ID de l'utilisateur
	 * @return L'objet Utilisateur
	 */
	public Utilisateur findUtilisateurById(int idUtilisateur);

	/**
	 * Permet de récupérer la liste des utilisateurs
	 * 
	 * @return Liste des utilisateurs
	 */
	public List<Utilisateur> findAllUtilisateurs();
}
