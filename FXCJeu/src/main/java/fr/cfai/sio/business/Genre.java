package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Genre
{
	/**
	 * Déclaration des variables de Genre
	 */
	private int idGenre;
	private String libelleGenre;
	private List<Jeu> listeJeux;

	/**
	 * Constructeur de Genre
	 * 
	 * @param idGenre
	 *            ID du genre
	 * @param libelleGenre
	 *            Libellé du genre
	 */
	public Genre(int idGenre, String libelleGenre)
	{
		super();
		this.idGenre = idGenre;
		this.libelleGenre = libelleGenre;
	}

	/**
	 * Getteur ID du genre
	 * 
	 * @return ID du genre
	 */
	public int getIdGenre()
	{
		return idGenre;
	}

	/**
	 * Setteur ID du genre
	 * 
	 * @param idGenre
	 *            ID du genre
	 */
	public void setIdGenre(int idGenre)
	{
		this.idGenre = idGenre;
	}

	/**
	 * Getteur Libellé du genre
	 * 
	 * @return Libellé du genre
	 */
	public String getLibelleGenre()
	{
		return libelleGenre;
	}

	/**
	 * Setteur Libellé du genre
	 * 
	 * @param libelleGenre
	 *            Libellé du genre
	 */
	public void setLibelleGenre(String libelleGenre)
	{
		this.libelleGenre = libelleGenre;
	}

	/**
	 * Getteur Liste de Jeux du genre
	 * 
	 * @return Liste de Jeux du genre
	 */
	public List<Jeu> getListeJeux()
	{
		return listeJeux;
	}

	/**
	 * Setteur Liste de Jeux du genre
	 * 
	 * @param listeJeux
	 *            Liste de Jeux du genre
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
