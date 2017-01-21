package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Support
{

	/**
	 * Déclaration des variables de Support
	 */
	private int idSupport;
	private String libelleSupport;
	private List<Jeu> listeJeux;

	/**
	 * Constructeur de Support
	 * 
	 * @param idSupport
	 *            ID du support
	 * @param libelleSupport
	 *            libelle du support
	 */
	public Support(int idSupport, String libelleSupport)
	{
		super();
		this.idSupport = idSupport;
		this.libelleSupport = libelleSupport;
	}

	/**
	 * Getteur ID du support
	 * 
	 * @return ID du support
	 */
	public int getIdSupport()
	{
		return idSupport;
	}

	/**
	 * Setteur ID du support
	 * 
	 * @param idSupport
	 *            ID du support
	 */
	public void setIdSupport(int idSupport)
	{
		this.idSupport = idSupport;
	}

	/**
	 * GetteurLibelle du support
	 * 
	 * @return Libelle du support
	 */
	public String getLibelleSupport()
	{
		return libelleSupport;
	}

	/**
	 * Setteur Libelle du support
	 * 
	 * @param libelleSupport
	 *            Libelle du support
	 */
	public void setLibelleSupport(String libelleSupport)
	{
		this.libelleSupport = libelleSupport;
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
