package fr.cfai.sio.business;

import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Plateforme
{
	/**
	 * Déclaration des varaibles de Plateforme
	 */
	private int idPlateforme;
	private String libellePlateforme;
	private List<Jeu> listeJeux;

	/**
	 * Constructeur de Plateforme
	 * 
	 * @param idPlateforme
	 *            ID de la plateforme
	 * @param libellePlateforme
	 *            Libelle de la plateforme
	 */
	public Plateforme(int idPlateforme, String libellePlateforme)
	{
		super();
		this.idPlateforme = idPlateforme;
		this.libellePlateforme = libellePlateforme;
	}

	/**
	 * Getteur ID de la plateforme
	 * 
	 * @return ID de la plateforme
	 */
	public int getIdPlateforme()
	{
		return idPlateforme;
	}

	/**
	 * Setteur ID de la plateforme
	 * 
	 * @param idPlateforme
	 *            ID de la plateforme
	 */
	public void setIdPlateforme(int idPlateforme)
	{
		this.idPlateforme = idPlateforme;
	}

	/**
	 * Getteur Libelle de la plateforme
	 * 
	 * @return Libelle de la plateforme
	 */
	public String getLibellePlateforme()
	{
		return libellePlateforme;
	}

	/**
	 * Setteur Libelle de la plateforme
	 * 
	 * @param libellePlateforme
	 *            Libelle de la plateforme
	 */
	public void setLibellePlateforme(String libellePlateforme)
	{
		this.libellePlateforme = libellePlateforme;
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
