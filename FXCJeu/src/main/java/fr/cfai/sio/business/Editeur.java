package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Editeur
{
	/**
	 * Déclaration des variables d'Editeur
	 */
	private int idEditeur;
	private String raisonSociale;
	private List<Jeu> listeJeux;

	/**
	 * Constructeur d'Editeur
	 * 
	 * @param idEditeur
	 *            ID de l'éditeur
	 * @param raisonSociale
	 *            Raison Sociale de l'éditeur
	 */
	public Editeur(int idEditeur, String raisonSociale)
	{
		super();
		this.idEditeur = idEditeur;
		this.raisonSociale = raisonSociale;
	}

	/**
	 * Getteur ID de l'éditeur
	 * 
	 * @return ID de l'éditeur
	 */
	public int getIdEditeur()
	{
		return idEditeur;
	}

	/**
	 * Setteur ID de l'éditeur
	 * 
	 * @param idEditeur
	 *            ID de l'éditeur
	 */
	public void setIdEditeur(int idEditeur)
	{
		this.idEditeur = idEditeur;
	}

	/**
	 * Getteur Raison Sociale de l'éditeur
	 * 
	 * @return Raison Sociale de l'éditeur
	 */
	public String getRaisonSociale()
	{
		return raisonSociale;
	}

	/**
	 * Setteur Raison Sociale de l'éditeur
	 * 
	 * @param raisonSociale
	 *            Raison Sociale de l'éditeur
	 */
	public void setRaisonSociale(String raisonSociale)
	{
		this.raisonSociale = raisonSociale;
	}

	/**
	 * Getteur Liste de jeu de l'éditeur
	 * 
	 * @return Liste de jeu de l'éditeur
	 */
	public List<Jeu> getListeJeux()
	{
		return listeJeux;
	}

	/**
	 * Setteur Liste de jeu de l'éditeur
	 * 
	 * @param listeJeux
	 *            Liste de jeu de l'éditeur
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
