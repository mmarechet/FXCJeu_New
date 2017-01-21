package fr.cfai.sio.business;

import java.util.Date;
import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Commentaire
{
	/**
	 * Déclaration des variables de Commentaire
	 */
	private int idCom;
	private String contenuCom;
	private Date dateCom;
	private Test test;
	private Utilisateur utilisateur;
	private Commentaire idFkCom;
	private List<Commentaire> listeCommentairesReponses;

	/**
	 * Constructeur de Commentaire
	 * 
	 * @param idCom
	 *            ID du commentaire
	 * @param titreCom
	 *            Titre du commentaire
	 * @param description
	 *            Description du commentaire
	 * @param dateCom
	 *            Date du commentaire
	 * @param test
	 *            Objet Test lié au commentaire
	 * @param utilisateur
	 *            Objet Utilisateur lié au commentaire
	 */
	public Commentaire(int idCom, String contenuCom, Date dateCom, Test test, Utilisateur utilisateur,Commentaire idFkCom)
	{
		super();
		this.idCom = idCom;
		this.contenuCom = contenuCom;
		this.dateCom = dateCom;
		this.test = test;
		this.utilisateur = utilisateur;
		this.idFkCom=idFkCom;
	}

	public Commentaire(int id_Commentaire) {
		// TODO Auto-generated constructor stub
		this.idCom = id_Commentaire;
	}

	public Commentaire(int id_Commentaire, String contenu_Com, Date date_Commentaire, Test test2, Utilisateur utilisateur2)
	{
		this.idCom = id_Commentaire;
		this.contenuCom = contenu_Com;
		this.dateCom = date_Commentaire;
		this.test = test2;
		this.utilisateur = utilisateur2;
	}

	/**
	 * Getteur ID du commentaire
	 * 
	 * @return ID du commentaire
	 */
	public int getIdCom()
	{
		return idCom;
	}

	/**
	 * Setteur ID du commentaire
	 * 
	 * @param idCom
	 *            ID du commentaire
	 */
	public void setIdCom(int idCom)
	{
		this.idCom = idCom;
	}

	/**
	 * Getteur Description du commentaire
	 * 
	 * @return Description du commentaire
	 */
	public String getContenuCom()
	{
		return contenuCom;
	}

	/**
	 * Setteur Description du commentaire
	 * 
	 * @param description
	 *            Description du commentaire
	 */
	public void setContenuCom(String description)
	{
		this.contenuCom = description;
	}

	/**
	 * Getteur Date du commentaire
	 * 
	 * @return Date du commentaire
	 */
	public Date getDateCom()
	{
		return dateCom;
	}

	/**
	 * Setteur Date du commentaire
	 * 
	 * @param dateCom
	 *            Date du commentaire
	 */
	public void setDateCom(Date dateCom)
	{
		this.dateCom = dateCom;
	}

	/**
	 * Getteur Test du commentaire
	 * 
	 * @return Test du commentaire
	 */
	public Test getTest()
	{
		return test;
	}

	/**
	 * Setteur Test du commentaire
	 * 
	 * @param test
	 *            Test du commentaire
	 */
	public void setTest(Test test)
	{
		this.test = test;
	}

	/**
	 * Getteur Utilisateur du commentaire
	 * 
	 * @return Utilisateur du commentaire
	 */
	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	/**
	 * Setteur Utilisateur du commentaire
	 * 
	 * @param utilisateur
	 *            Utilisateur du commentaire
	 */
	public void setUtilisateur(Utilisateur utilisateur)
	{
		this.utilisateur = utilisateur;
	}

	public Commentaire getIdFkCom()
	{
		return idFkCom;
	}

	public void setIdFkCom(Commentaire idFkCom)
	{
		this.idFkCom = idFkCom;
	}

	public List<Commentaire> getListeCommentairesReponses()
	{
		return listeCommentairesReponses;
	}

	public void setListeCommentairesReponses(List<Commentaire> listeCommentairesReponses)
	{
		this.listeCommentairesReponses = listeCommentairesReponses;
	}
	
	
	
	
}
