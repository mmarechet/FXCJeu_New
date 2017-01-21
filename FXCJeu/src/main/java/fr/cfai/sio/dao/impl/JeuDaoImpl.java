package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Classification;
import fr.cfai.sio.business.Developpeur;
import fr.cfai.sio.business.Editeur;
import fr.cfai.sio.business.Genre;
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.business.ModeleEconomique;
import fr.cfai.sio.business.Plateforme;
import fr.cfai.sio.business.Support;
import fr.cfai.sio.dao.ClassificationDao;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.DeveloppeurDao;
import fr.cfai.sio.dao.EditeurDao;
import fr.cfai.sio.dao.GenreDao;
import fr.cfai.sio.dao.JeuDao;
import fr.cfai.sio.dao.ModeleEconomiqueDao;
import fr.cfai.sio.dao.PlateformeDao;
import fr.cfai.sio.dao.SupportDao;
import fr.cfai.sio.dao.requete.JeuRequete;

public class JeuDaoImpl implements JeuDao
{
	private Connection connexion = ConnexionBDD.getConnection();

	private List<Jeu> listeJeux;

	private ClassificationDao classificationDaoImpl = new ClassificationDaoImpl();
	private List<Classification> listeClassifications;

	private DeveloppeurDao developpeurDaoImpl = new DeveloppeurDaoImpl();
	private List<Developpeur> listeDeveloppeurs;

	private GenreDao genreDaoImpl = new GenreDaoImpl();
	private List<Genre> listeGenres;

	private EditeurDao editeurDaoImpl = new EditeurDaoImpl();
	private List<Editeur> listeEditeurs;

	private SupportDao supportDaoImpl = new SupportDaoImpl();
	private PlateformeDao plateformeDaoImpl = new PlateformeDaoImpl();
	private ModeleEconomiqueDao modeleEconomiqueDaoImpl = new ModeleEconomiqueDaoImpl();

	public JeuDaoImpl() throws Exception
	{
		super();
		System.out.println("Constructeur JeuDaoImpl");

		this.listeJeux = new ArrayList<>();
	}

	@Override
	public Jeu findJeuById(int idJeu)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		
		int id_Jeu;
		String titre_Jeu;
		Date date_Sortie_Jeu;
		String description;
		String imgJeu;
		Classification classification = null;
		Editeur editeur = null;
		Genre genre = null;
		Developpeur developpeur = null;
		Jeu jeu = null;

		List<Support> listeSupports = new ArrayList<Support>();
		List<Plateforme> listePlateformes = new ArrayList<Plateforme>();
		List<ModeleEconomique> listeModeleEconomiques = new ArrayList<ModeleEconomique>();

		try
		{
			preparedStatement = connexion.prepareStatement(JeuRequete.FIND_JEUX_BY_ID);
			preparedStatement.setInt(1, idJeu);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Jeu = resultat.getInt(1);
					titre_Jeu = resultat.getString(2);
					date_Sortie_Jeu = resultat.getDate(3);
					description = resultat.getString(4);
					imgJeu = resultat.getString(9);
					editeur = getEditeurByID(resultat.getInt(5));
					genre = getGenreByID(resultat.getInt(6));
					developpeur = getDeveloppeurByID(resultat.getInt(7));
					classification = getClassificationByID(resultat.getInt(8));

					jeu = new Jeu(id_Jeu, titre_Jeu, date_Sortie_Jeu, description, imgJeu, classification, editeur, genre, developpeur);

					listeSupports = supportDaoImpl.findAllSupportsByJeu(idJeu);
					listePlateformes = plateformeDaoImpl.findAllPlateformesByJeu(idJeu);
					listeModeleEconomiques = modeleEconomiqueDaoImpl.findAllModeleEconomiquesByJeu(idJeu);

					jeu.setListeSupports(listeSupports);
					jeu.setListePlateformes(listePlateformes);
					jeu.setListeModeleEconomiques(listeModeleEconomiques);
				}
			}
			else
			{
				jeu = null;
			}

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql : " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(null, preparedStatement, resultat);
		}
		return jeu;
	}

	@Override
	public List<Jeu> findAllJeux()
	{
		Statement statement = null;
		ResultSet resultat = null;
		int id_Jeu;
		String imgJeu;
		String titreJeu;
		Jeu jeu = null;
		

		try
		{
			 statement = connexion.createStatement();
			 resultat = statement.executeQuery(JeuRequete.FIND_ALL_JEUX);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Jeu = resultat.getInt(1);
					titreJeu = resultat.getString(2);
					imgJeu = resultat.getString(3);

					jeu = new Jeu(id_Jeu, titreJeu, imgJeu);
					listeJeux.add(jeu);
				}
			}
			else
			{
				listeJeux = null;
			}

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql" + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, null, resultat);
		}
		return listeJeux;
	}

	public Classification getClassificationByID(int id)
	{
		if (listeClassifications == null)
		{
			// System.out.println("jeuDAO - getClassi ==> Liste Null");
			listeClassifications = classificationDaoImpl.findAllClassifications();
		}

		for (Classification classification : listeClassifications)
		{
			// System.out.println("JeuServlet - getClassi : " +
			// classification.getLibelleClassification());
			if (classification.getIdClassification() == id)
			{
				return classification;
			}
		}
		return null;
	}

	public Developpeur getDeveloppeurByID(int id)
	{
		if (listeDeveloppeurs == null)
		{
			listeDeveloppeurs = developpeurDaoImpl.findAllDeveloppeurs();
		}

		for (Developpeur developpeur : listeDeveloppeurs)
		{
			// System.out.println("JeuServlet - getDeveloppeur : " +
			// developpeur.getRaisonSociale());
			if (developpeur.getIdDeveloppeur() == id)
			{
				return developpeur;
			}
		}
		return null;
	}

	public Genre getGenreByID(int id)
	{
		if (listeGenres == null)
		{
			listeGenres = genreDaoImpl.findAllGenres();
		}

		for (Genre genre : listeGenres)
		{
			// System.out.println("JeuServlet - getGenre : " +
			// genre.getLibelleGenre());
			if (genre.getIdGenre() == id)
			{
				return genre;
			}
		}
		return null;
	}

	public Editeur getEditeurByID(int id)
	{
		if (listeEditeurs == null)
		{
			listeEditeurs = editeurDaoImpl.findAllEditeurs();
		}

		for (Editeur editeur : listeEditeurs)
		{
			// System.out.println("JeuServlet - getEditeur : " +
			// editeur.getRaisonSociale());

			if (editeur.getIdEditeur() == id)
			{
				return editeur;
			}
		}
		return null;
	}
}
