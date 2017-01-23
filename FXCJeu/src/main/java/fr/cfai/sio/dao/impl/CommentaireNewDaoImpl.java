package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Commentaire;
import fr.cfai.sio.business.Note;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.dao.CommentaireDao;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.NoteDao;
import fr.cfai.sio.dao.TestDao;
import fr.cfai.sio.dao.UtilisateurDao;
import fr.cfai.sio.dao.requete.CommentaireRequete;

public class CommentaireNewDaoImpl implements CommentaireDao
{
	private Connection connexion = ConnexionBDD.getConnection();

	private List<Commentaire> listeCommentaire;
	private Commentaire commentaire;
	private int statut = 0;

	public CommentaireNewDaoImpl() throws Exception
	{
		super();
		this.listeCommentaire = new ArrayList<>();
		System.out.println("Constructeur CommentaireDaoImpl");
	}

	@Override
	public Commentaire findCommentaireById(int idCommentaire)
	{
		// TODO Auto-generated method stub
		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Test test = null;
		Utilisateur utilisateur = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		try
		{
			preparedStatement = connexion.prepareStatement(CommentaireRequete.FIND_COMMENTAIRE_BY_ID);
			preparedStatement.setInt(1, idCommentaire);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					contenuCom = resultat.getString(2);
					date_Commentaire = resultat.getDate(3);
					utilisateur = getUtilisateurByID(resultat.getInt(4));
					test = getTestByID(resultat.getInt(5));

					commentaire = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur);
				}
			}
			else
			{
				commentaire = null;
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
		return commentaire;

	}

	@Override
	public List<Commentaire> findAllCommentaire()
	{
		Statement statement = null;
		ResultSet resultat = null;
		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Test test = null;
		Utilisateur utilisateur = null;
		Commentaire commentaire = null;

		try
		{
			statement = connexion.createStatement();

			resultat = statement.executeQuery(CommentaireRequete.FIND_ALL_COMMENTAIRE);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					contenuCom = resultat.getString(2);
					date_Commentaire = resultat.getDate(3);
					utilisateur = getUtilisateurByID(resultat.getInt(4));
					test = getTestByID(resultat.getInt(5));

					commentaire = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur);
					listeCommentaire.add(commentaire);
				}
			}
			else
			{
				listeCommentaire = null;
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
		return listeCommentaire;
	}

	public int getIDMaxCommentaire()
	{
		Statement statement = null;
		ResultSet resultat = null;

		int idMax = 0;
		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(CommentaireRequete.ID_MAX_COMMENTAIRE);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idMax = resultat.getInt(1);

				}
			}
			else
			{
				idMax = 0;
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
		return idMax;
	}

	@Override
	public List<Commentaire> findCommentaireByIDTest(int idTest)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		List<Commentaire> listeCommentaireByIDTest = new ArrayList<>();

		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Test test = null;
		Utilisateur utilisateur = null;
		Commentaire commentaireByIDTest = null;
		Commentaire commentaireReponse = null;
		try
		{
			preparedStatement = connexion.prepareStatement(CommentaireRequete.FIND_COMMENTAIRE_BY_TEST);
			preparedStatement.setInt(1, idTest);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					contenuCom = resultat.getString(2);
					date_Commentaire = resultat.getDate(3);
					// test = getTestByID(resultat.getInt(4));
					utilisateur = getUtilisateurByID(resultat.getInt(4));

					commentaireByIDTest = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur, commentaireReponse);

					try
					{
						List<Commentaire> listeCommentairesReponses = new ArrayList<>();
						listeCommentairesReponses = findAllCommentaireByIDCom(idCom);
						commentaireByIDTest.setListeCommentairesReponses(listeCommentairesReponses);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					listeCommentaireByIDTest.add(commentaireByIDTest);
				}
			}
			else
			{
				listeCommentaireByIDTest = null;
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

		return listeCommentaireByIDTest;

	}

	@Override
	public int addCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur, int valueNote)
	{
		Statement statement = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		
		int idMax = 0;

		try
		{
			statement = connexion.createStatement();

			resultat = statement.executeQuery(CommentaireRequete.ID_MAX_COMMENTAIRE);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idMax = resultat.getInt(1) + 1;
				}
			}
			else
			{
				idMax = 1;
			}

			preparedStatement = connexion.prepareStatement(CommentaireRequete.AJOUT_COMMENTAIRE);
			preparedStatement.setInt(1, idMax);
			preparedStatement.setString(2, contenuCom);
			preparedStatement.setInt(3, idUtilisateur);
			preparedStatement.setInt(4, idTest);
			statut = preparedStatement.executeUpdate();
			
			try
			{
				//Test test=null;
				//test=getTestByID(idTest);
				
				Note note=null;
				NoteDao noteDaoImpl = new NoteDaoImpl();

				note=noteDaoImpl.addNoteForTest(valueNote, idTest);
				
				//test.addNote(note);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql" + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, preparedStatement, resultat);
		}
		return statut;
	}
	
	@Override
	public int addReponseCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur, int idCommentaire)
	{
		Statement statement = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		int idMax = 0;

		try
		{
			statement = connexion.createStatement();

			resultat = statement.executeQuery(CommentaireRequete.ID_MAX_COMMENTAIRE);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idMax = resultat.getInt(1) + 1;
				}
			}
			else
			{
				idMax = 1;
			}
			preparedStatement = connexion.prepareStatement(CommentaireRequete.AJOUT_COMMENTAIRE_PAR_COMMENTAIRE);
			preparedStatement.setInt(1, idMax);
			preparedStatement.setString(2, contenuCom);
			preparedStatement.setInt(3, idUtilisateur);
			preparedStatement.setInt(4, idTest);
			preparedStatement.setInt(5, idCommentaire);
			statut = preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql" + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, preparedStatement, resultat);
		}
		return statut;
	}

	public Commentaire getCommentaireByID(int id)
	{
		if (listeCommentaire == null)
		{
			listeCommentaire = findAllCommentaire();
		}

		for (Commentaire commentaire : listeCommentaire)
		{

			if (commentaire.getIdCom() == id)
			{
				return commentaire;
			}
		}
		return null;
	}

	@Override
	public List<Commentaire> findCommentaireByTest(Test test)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		listeCommentaire.clear();

		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Utilisateur utilisateur = null;
		try
		{
			preparedStatement = connexion.prepareStatement(CommentaireRequete.FIND_COMMENTAIRE_BY_TEST);
			preparedStatement.setInt(1, test.getIdTest());
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					date_Commentaire = resultat.getDate(3);
					contenuCom = resultat.getString(2);
					utilisateur = getUtilisateurByID(resultat.getInt(4));

					commentaire = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur);

					listeCommentaire.add(commentaire);
				}
			}
			else
			{
				listeCommentaire = null;
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

		return listeCommentaire;

	}

	@Override
	public List<Commentaire> findAllCommentaireForTest()
	{
		Statement statement = null;
		ResultSet resultat = null;
		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Test test = null;
		Utilisateur utilisateur = null;
		Commentaire commentaire = null;

		try
		{
			statement = connexion.createStatement();

			resultat = statement.executeQuery(CommentaireRequete.FIND_ALL_COMMENTAIRE);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					contenuCom = resultat.getString(2);
					date_Commentaire = resultat.getDate(3);
					utilisateur = getUtilisateurByID(resultat.getInt(4));
					test = new Test(resultat.getInt(5));

					commentaire = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur);
					listeCommentaire.add(commentaire);
				}
			}
			else
			{
				listeCommentaire = null;
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
		return listeCommentaire;
	}

	@Override
	public List<Commentaire> findAllCommentaireByIDCom(int idFKCom)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		List<Commentaire> listeCommentaireByIDCom = new ArrayList<>();

		int idCom;
		Date date_Commentaire;
		String contenuCom;
		Test test = null;
		Utilisateur utilisateur = null;
		Commentaire commentaireByIDCom = null;
		try
		{
			preparedStatement = connexion.prepareStatement(CommentaireRequete.FIND_ALL_COMMENTAIRE_BY_IDCOM);
			preparedStatement.setInt(1, idFKCom);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					idCom = resultat.getInt(1);
					contenuCom = resultat.getString(2);
					date_Commentaire = resultat.getDate(3);
					utilisateur = getUtilisateurByID(resultat.getInt(4));

					commentaireByIDCom = new Commentaire(idCom, contenuCom, date_Commentaire, test, utilisateur);

					listeCommentaireByIDCom.add(commentaireByIDCom);
				}
			}
			else
			{
				listeCommentaireByIDCom = null;
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

		return listeCommentaireByIDCom;
	}

	public Utilisateur getUtilisateurByID(int id)
	{
		UtilisateurDao utilisateurDaoImpl;
		Utilisateur utilisateur = null;

		try
		{
			utilisateurDaoImpl = new UtilisateurDaoImpl();
			utilisateur = utilisateurDaoImpl.findUtilisateurById(id);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateur;
	}

	public Test getTestByID(int id)
	{
		Test test = null;
		TestDao testDaoImpl;

		try
		{
			testDaoImpl = new TestDaoImpl();
			test = testDaoImpl.findTestById(id);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return test;
	}
}
