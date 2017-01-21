package fr.cfai.sio.business;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Commentaire OK
 * 
 * Suppression nbCom ==> CHamps calculé ???
 * 
 * @author mathieu
 *
 */
public class Test
{
	// Faire methode nb com + moyenne note

	/**
	 * Déclaration des variables de Test
	 */
	private int idTest;
	private String titreTest;
	private Date dateTest;
	private short noteJeu;
	private String avantageJeu;
	private String inconvenientJeu;
	private String descriptionTest;
	private String contenuTest;
	private String imgTest;
	private Jeu jeu;
	private Utilisateur utilisateur;
	private List<Image> listeImages;
	private List<Note> listeNotes;
	private List<Commentaire> listeCommentaires;

	/**
	 * Constructeur de Test
	 * 
	 * @param idTest
	 *            ID du test
	 * @param titreTest
	 *            Titre du test
	 * @param dateTest
	 *            Date du test
	 * @param noteJeu
	 *            Note du jeu du test
	 * @param nbCom
	 *            Nombre de commentaire du test
	 * @param avantageJeu
	 *            Avantage du Jeu du test
	 * @param inconvenientJeu
	 *            Inconvénient du jeu du test
	 * @param jeu
	 *            Jeu du test
	 * @param utilisateur
	 *            Utilisateur du test
	 */
	public Test(int idTest, String titreTest, Date dateTest, short noteJeu, String avantageJeu, String inconvenientJeu, String descriptionTest,
			String contenuTest, String imgTest, Jeu jeu, Utilisateur utilisateur)
	{
		super();
		this.idTest = idTest;
		this.titreTest = titreTest;
		this.dateTest = dateTest;
		this.noteJeu = noteJeu;
		this.avantageJeu = avantageJeu;
		this.inconvenientJeu = inconvenientJeu;
		this.descriptionTest = descriptionTest;
		this.contenuTest = contenuTest;
		this.imgTest = imgTest;
		this.jeu = jeu;
		this.utilisateur = utilisateur;
		this.listeNotes = new ArrayList<>();
		this.listeCommentaires = new ArrayList<>();
	}

	public Test(int id)
	{
		this.idTest = id;
	}

	/**
	 * Getteur Description du test
	 * 
	 * @return Description du test
	 */
	public String getDescriptionTest()
	{
		return descriptionTest;
	}

	/**
	 * Setteur Description du test
	 * 
	 * @param descriptionTest
	 *            Description du test
	 */
	public void setDescriptionTest(String descriptionTest)
	{
		this.descriptionTest = descriptionTest;
	}

	/**
	 * Getteur ID du test
	 * 
	 * @return ID du test
	 */
	public int getIdTest()
	{
		return idTest;
	}

	/**
	 * Setteur ID du test
	 * 
	 * @param idTest
	 *            ID du test
	 */
	public void setIdTest(int idTest)
	{
		this.idTest = idTest;
	}

	/**
	 * Getteur Titre du test
	 * 
	 * @return
	 */
	public String getTitreTest()
	{
		return titreTest;
	}

	/**
	 * Setteur Titre du test
	 * 
	 * @param titreTest
	 */
	public void setTitreTest(String titreTest)
	{
		this.titreTest = titreTest;
	}

	/**
	 * Getteur Date du test
	 * 
	 * @return
	 */
	public Date getDateTest()
	{
		return dateTest;
	}

	/**
	 * Setteur Date du test
	 * 
	 * @param dateTest
	 *            Date du test
	 */
	public void setDateTest(Date dateTest)
	{
		this.dateTest = dateTest;
	}

	/**
	 * Getteur Note du jeu du test
	 * 
	 * @return Note du jeu du test
	 */
	public short getNoteJeu()
	{
		return noteJeu;
	}

	/**
	 * Setteur Note du jeu du test
	 * 
	 * @param noteJeu
	 *            Note du jeu du test
	 */
	public void setNoteJeu(short noteJeu)
	{
		this.noteJeu = noteJeu;
	}

	/**
	 * Getteur Avantage du jeu du test
	 * 
	 * @return Avantage du jeu du test
	 */
	public String getAvantageJeu()
	{
		return avantageJeu;
	}

	/**
	 * Setteur Avantage du jeu du test
	 * 
	 * @param avantageJeu
	 *            Avantage du jeu du test
	 */
	public void setAvantageJeu(String avantageJeu)
	{
		this.avantageJeu = avantageJeu;
	}

	/**
	 * Getteur Inconvénient du jeu du test
	 * 
	 * @return Inconvénient du jeu du test
	 */
	public String getInconvenientJeu()
	{
		return inconvenientJeu;
	}

	/**
	 * Setteur Inconvénient du jeu du test
	 * 
	 * @param inconvenientJeu
	 *            Inconvénient du jeu du test
	 */
	public void setInconvenientJeu(String inconvenientJeu)
	{
		this.inconvenientJeu = inconvenientJeu;
	}

	public String getContenuTest()
	{
		return contenuTest;
	}

	public void setContenuTest(String contenuTest)
	{
		this.contenuTest = contenuTest;
	}

	public String getImgTest()
	{
		return imgTest;
	}

	public void setImgTest(String imgTest)
	{
		this.imgTest = imgTest;
	}

	/**
	 * Getteur Jeu du test
	 * 
	 * @return Jeu du test
	 */
	public Jeu getJeu()
	{
		return jeu;
	}

	/**
	 * Setteur Jeu du test
	 * 
	 * @param jeu
	 *            Jeu du test
	 */
	public void setJeu(Jeu jeu)
	{
		this.jeu = jeu;
	}

	/**
	 * Getteur Utilisateur du test
	 * 
	 * @return Utilisateur du test
	 */
	public Utilisateur getUtilisateur()
	{
		return utilisateur;
	}

	/**
	 * Setteur Utilisateur du test
	 * 
	 * @param utilisateur
	 *            Utilisateur du test
	 */
	public void setUtilisateur(Utilisateur utilisateur)
	{
		this.utilisateur = utilisateur;
	}

	/**
	 * Getteur Liste des images du test
	 * 
	 * @return Liste des images du test
	 */
	public List<Image> getListeImages()
	{
		return listeImages;
	}

	/**
	 * Setteur Liste des images du test
	 * 
	 * @param listeImages
	 *            Liste des images du test
	 */
	public void setListeImages(List<Image> listeImages)
	{
		this.listeImages = listeImages;
	}

	/**
	 * Getteur Liste des notes du test
	 * 
	 * @return Liste des notes du test
	 */
	public List<Note> getListeNotes()
	{
		return listeNotes;
	}

	/**
	 * Setteur Liste des notes du test
	 * 
	 * @param listeNotes
	 *            Liste des notes du test
	 */
	public void setListeNotes(List<Note> listeNotes)
	{
		this.listeNotes = listeNotes;
	}

	/**
	 * Permet d'ajouter un objet Image à la liste des images
	 * 
	 * @param image
	 *            un objet Image
	 */
	public void addImage(Image image)
	{
		this.listeImages.add(image);
	}

	/**
	 * Permet d'ajouter un objet Note à la liste des notes
	 * 
	 * @param note
	 *            un objet Note
	 */
	public void addNote(Note note)
	{
		this.listeNotes.add(note);
	}

	public List<Commentaire> getListeCommentaires()
	{
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires)
	{
		this.listeCommentaires = listeCommentaires;
	}

	public String getMoyenne()
	{
		double tailleListe = listeNotes.size();
		double cumul_Note = 0;
		String chaineReturn;

		DecimalFormat format = new DecimalFormat("#.##");
		format.setRoundingMode(RoundingMode.HALF_UP);

		if (tailleListe != 0)
		{
			for (Note note : listeNotes)
			{
				cumul_Note += note.getNote();
			}

			chaineReturn = format.format(cumul_Note / tailleListe) + " / 5";

		}
		else
		{
			chaineReturn = "Il n'y a pas de note";
		}

		return chaineReturn;
	}

	public String getNbCom()
	{
		String chaineReturn;
		int tailleListe = listeCommentaires.size();

		if (tailleListe != 0)
		{
			chaineReturn = tailleListe+" commentaire(s)";
		}
		else
		{
			chaineReturn = "Pas de commentaire";
		}
		return chaineReturn;
	}
}
