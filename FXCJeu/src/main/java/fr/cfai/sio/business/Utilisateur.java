package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * ID com meme remarque que dans test
 * 
 * @author mathieu
 *
 */
public class Utilisateur
{
	
	//FAIRE METHODE NB COM
	
	/**
	 * Déclaration des variables de User
	 */
	private int idUtilisateur;
	private String login;
	private String password;
	private List<Test> ListeTests;
	private List<Commentaire> ListeCommentaires;

	/**
	 * Constructeur de User
	 * 
	 * @param idUtilisateur
	 *            ID de l'utilisateur
	 * @param login
	 *            Login de l'utilisateur
	 * @param password
	 *            Mot de passe de l'utilisateur
	 * @param nbCom
	 *            Nombre de commentaire de l'utilisateur
	 * @param imgUser
	 *            Image de l'utilisateur
	 */
	public Utilisateur(int idUtilisateur, String login, String password)
	{
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructeur pour l'ajout
	 * 
	 * @param login
	 *            Login de l'utilisateur
	 * @param password
	 *            Mot de passe de l'utilisateur
	 */
	public Utilisateur(String login, String password)
	{
		this.login = login;
		this.password = password;
	}

	public Utilisateur(int idUtilisateur, String login, String mdp, int nbCom)
	{
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.password = mdp;
	}

	// Test VMELE
	public Utilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Getteur ID de l'utilisateur
	 * 
	 * @return ID de l'utilisateur
	 */
	public int getIdUtilisateur()
	{
		return idUtilisateur;
	}

	/**
	 * Setteur ID de l'utilisateur
	 * 
	 * @param idUtilisateur
	 *            ID de l'utilisateur
	 */
	public void setIdUtilisateur(int idUtilisateur)
	{
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Getteur Login de l'utilisateur
	 * 
	 * @return Login de l'utilisateur
	 */
	public String getLogin()
	{
		return login;
	}

	/**
	 * Setteur Login de l'utilisateur
	 * 
	 * @param login
	 *            Login de l'utilisateur
	 */
	public void setLogin(String login)
	{
		this.login = login;
	}

	/**
	 * Getteur Mot de passe de l'utilisateur
	 * 
	 * @return Mot de passe de l'utilisateur
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * Setteur Mot de passe de l'utilisateur
	 * 
	 * @param password
	 *            Mot de passe de l'utilisateur
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}


	/**
	 * Getteur Liste des tests de l'utilisateur
	 * 
	 * @return Liste des tests de l'utilisateur
	 */
	public List<Test> getListeTests()
	{
		return ListeTests;
	}

	/**
	 * Setteur Liste des tests de l'utilisateur
	 * 
	 * @param listeTests
	 *            Liste des tests de l'utilisateur
	 */
	public void setListeTests(List<Test> listeTests)
	{
		ListeTests = listeTests;
	}


	/**
	 * Getteur Liste des commentaires de l'utilisateur
	 * 
	 * @return Liste des commentaires de l'utilisateur
	 */
	public List<Commentaire> getListeCommentaires()
	{
		return ListeCommentaires;
	}

	/**
	 * Setteur Liste des commentaires de l'utilisateur
	 * 
	 * @param listeCommentaires
	 *            Liste des commentaires de l'utilisateur
	 */
	public void setListeCommentaires(List<Commentaire> listeCommentaires)
	{
		ListeCommentaires = listeCommentaires;
	}

	/**
	 * Permet d'ajouter un objet Test à la liste des tests
	 * 
	 * @param test
	 *            un objet Test
	 */
	public void addTest(Test test)
	{
		this.ListeTests.add(test);
	}

	
	/**
	 * Permet d'ajouter un objet Commentaire à la liste des commentaires
	 * 
	 * @param commentaire
	 *            un objet Commentaire
	 */
	public void addCommentaire(Commentaire commentaire)
	{
		this.ListeCommentaires.add(commentaire);
	}
}
