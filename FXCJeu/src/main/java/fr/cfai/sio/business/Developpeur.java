package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Developpeur
{

	/**
	 * Déclaration des variables de Developpeur
	 */
	private int idDeveloppeur;
	private String raisonSociale;
	private List<Jeu> listeJeux;

	/**
	 * Constructeur de Developpeur
	 * 
	 * @param idDeveloppeur
	 *            ID du developpeur
	 * @param raisonSociale
	 *            raison sociale du developpeur
	 */
	public Developpeur(int idDeveloppeur, String raisonSociale)
	{
		super();
		this.idDeveloppeur = idDeveloppeur;
		this.raisonSociale = raisonSociale;
	}

	/**
	 * Getteur ID du developpeur
	 * 
	 * @return ID du developpeur
	 */
	public int getIdDeveloppeur()
	{
		return idDeveloppeur;
	}

	/**
	 * Setteur ID du developpeur
	 * 
	 * @param idDeveloppeur
	 *            ID du developpeur
	 */
	public void setIdDeveloppeur(int idDeveloppeur)
	{
		this.idDeveloppeur = idDeveloppeur;
	}

	/**
	 * Getteur Raison Sociale du developpeur
	 * 
	 * @return Raison Sociale du developpeur
	 */
	public String getRaisonSociale()
	{
		return raisonSociale;
	}

	/**
	 * Setteur Raison Sociale du developpeur
	 * 
	 * @param raisonSociale
	 *            Raison Sociale du developpeur
	 */
	public void setRaisonSociale(String raisonSociale)
	{
		this.raisonSociale = raisonSociale;
	}

	/**
	 * Getteur Liste des jeux du developpeur
	 * 
	 * @return Liste des jeux du developpeur
	 */
	public List<Jeu> getListeJeux()
	{
		return listeJeux;
	}

	/**
	 * Setteur Liste des jeux du developpeur
	 * 
	 * @param listeJeux
	 *            Liste des jeux du developpeur
	 */
	public void setListeJeux(List<Jeu> listeJeux)
	{
		this.listeJeux = listeJeux;
	}

	/**
	 * Permet d'ajouter un objet Jeu à la liste de jeu
	 * 
	 * @param jeu
	 *            un objet Jeu
	 */
	public void addJeu(Jeu jeu)
	{
		this.listeJeux.add(jeu);
	}
}
