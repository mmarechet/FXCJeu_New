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
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.business.Note;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.dao.CommentaireDao;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.JeuDao;
import fr.cfai.sio.dao.NoteDao;
import fr.cfai.sio.dao.TestDao;
import fr.cfai.sio.dao.UtilisateurDao;
import fr.cfai.sio.dao.requete.TestRequete;

public class TestDaoImpl implements TestDao
{

	private Connection connexion = ConnexionBDD.getConnection();
	private List<Test> listeTests;
	private int statut =0;

	public TestDaoImpl() throws Exception
	{
		super();
		this.listeTests = new ArrayList<>();
		System.out.println("Constructeur TestDaoImpl");
	}

	@Override
	public Test findTestById(int idTest)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		int id_Test;
		String titreTest;
		Date dateTest;
		short noteJeu;
		String avantageJeu;
		String inconvenientJeu;
		String descriptionTest;
		String contenuTest;
		String imgTest;
		Jeu jeu;
		Utilisateur utilisateur;
		Test test = null;

		try
		{
			preparedStatement = connexion.prepareStatement(TestRequete.FIND_TEST_BY_ID);
			preparedStatement.setInt(1, idTest);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Test = resultat.getInt(1);
					titreTest = resultat.getString(2);
					dateTest = resultat.getDate(3);
					avantageJeu = resultat.getString(4);
					inconvenientJeu = resultat.getString(5);
					descriptionTest = resultat.getString(6);
					jeu = getJeuByID(resultat.getInt(7));
					utilisateur = getUtilisateurByID(resultat.getInt(8));
					noteJeu = resultat.getShort(9);
					contenuTest = resultat.getString(10);
					imgTest = resultat.getString(11);

					test = new Test(id_Test, titreTest, dateTest, noteJeu, avantageJeu, inconvenientJeu, descriptionTest, contenuTest, imgTest, jeu,
							utilisateur);

					try
					{
						NoteDao noteDaoImpl = new NoteDaoImpl();
						List<Note> listeNotes = new ArrayList<>();
						listeNotes = noteDaoImpl.findAllNotesByTest(id_Test);
						test.setListeNotes(listeNotes);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try
					{
						CommentaireDao commentaireDaoImpl = new CommentaireDaoImpl();
						List<Commentaire> listeCommentaires = new ArrayList<>();
						listeCommentaires = commentaireDaoImpl.findCommentaireByIDTest(id_Test);
						test.setListeCommentaires(listeCommentaires);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			else
			{
				test = null;
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
		return test;
	}

	@Override
	public List<Test> findAllTest()
	{
		Statement statement = null;
		ResultSet resultat = null;
		int id_Test;
		String titreTest;
		Date dateTest;
		short noteJeu;
		String avantageJeu;
		String inconvenientJeu;
		String descriptionTest;
		String contenuTest;
		String imgTest;
		Jeu jeu;
		Utilisateur utilisateur;
		Test test = null;

		try
		{
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery(TestRequete.FIND_ALL_TESTS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Test = resultat.getInt(1);
					titreTest = resultat.getString(2);
					dateTest = resultat.getDate(3);
					avantageJeu = resultat.getString(4);
					inconvenientJeu = resultat.getString(5);
					descriptionTest = resultat.getString(6);
					jeu = getJeuByID(resultat.getInt(7));
					utilisateur = getUtilisateurByID(resultat.getInt(8));
					noteJeu = resultat.getShort(9);
					contenuTest = resultat.getString(10);
					imgTest = resultat.getString(11);

					test = new Test(id_Test, titreTest, dateTest, noteJeu, avantageJeu, inconvenientJeu, descriptionTest, contenuTest, imgTest, jeu,
							utilisateur);
					
					try
					{
						NoteDao noteDaoImpl = new NoteDaoImpl();
						List<Note> listeNotes = new ArrayList<>();
						listeNotes = noteDaoImpl.findAllNotesByTest(id_Test);
						test.setListeNotes(listeNotes);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try
					{
						CommentaireDao commentaireDaoImpl = new CommentaireDaoImpl();
						List<Commentaire> listeCommentaires = new ArrayList<>();
						listeCommentaires = commentaireDaoImpl.findCommentaireByTest(test);
						test.setListeCommentaires(listeCommentaires);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					listeTests.add(test);
				}
			}
			else
			{
				listeTests = null;
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
		return listeTests;
	}

	@Override
	public List<Test> findAllTestByJeu(int idJeu)
	{

		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		int id_Test;
		String titreTest;
		Date dateTest;
		short noteJeu;
		String avantageJeu;
		String inconvenientJeu;
		String descriptionTest;
		String contenuTest;
		String imgTest;
		Jeu jeu;
		Utilisateur utilisateur;
		Test test = null;
		List<Test> listeTests = new ArrayList<>();

		try
		{

			preparedStatement = connexion.prepareStatement(TestRequete.FIND_ALL_TESTS_BY_JEU);
			preparedStatement.setInt(1, idJeu);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Test = resultat.getInt(1);
					titreTest = resultat.getString(2);
					dateTest = resultat.getDate(3);
					avantageJeu = resultat.getString(4);
					inconvenientJeu = resultat.getString(5);
					descriptionTest = resultat.getString(6);
					jeu = getJeuByID(resultat.getInt(7));
					utilisateur = getUtilisateurByID(resultat.getInt(8));
					noteJeu = resultat.getShort(9);
					contenuTest = resultat.getString(10);
					imgTest = resultat.getString(11);

					test = new Test(id_Test, titreTest, dateTest, noteJeu, avantageJeu, inconvenientJeu, descriptionTest, contenuTest, imgTest, jeu,
							utilisateur);

					try
					{
						NoteDao noteDaoImpl = new NoteDaoImpl();
						List<Note> listeNotes = new ArrayList<>();
						listeNotes = noteDaoImpl.findAllNotesByTest(id_Test);
						test.setListeNotes(listeNotes);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try
					{
						CommentaireDao commentaireDaoImpl = new CommentaireDaoImpl();
						List<Commentaire> listeCommentaires = new ArrayList<>();
						listeCommentaires = commentaireDaoImpl.findCommentaireByIDTest(id_Test);
						test.setListeCommentaires(listeCommentaires);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					listeTests.add(test);
				}
			}
			else
			{
				listeTests = null;
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
		return listeTests;
	}

	@Override
	public int addTest(String titre, Date date, String avantage, String inconvenient, String description, short note, int id_Jeu,
			int id_Utilisateur, String contenu)
	{
		Statement statement = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		int idMax = 0;
	
		
	//	java.sql.Date dateSql;
		//dateSql=(java.sql.Date) dateCom;
		
		try
		{
			statement = connexion.createStatement();

			resultat = statement.executeQuery(TestRequete.ID_MAX_TEST);

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

			preparedStatement = connexion.prepareStatement(TestRequete.ADD_TEST);
			preparedStatement.setInt(1, idMax);
			preparedStatement.setString(2, titre);
			//preparedStatement.setDate(3, (java.sql.Date) date);
			preparedStatement.setString(3, avantage);
			preparedStatement.setString(4, inconvenient);
			preparedStatement.setString(5, description);
			preparedStatement.setShort(8, note);
			preparedStatement.setInt(6, id_Jeu);
			preparedStatement.setInt(7, id_Utilisateur);
			preparedStatement.setString(9, contenu);
			
			
			
			statut = preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, preparedStatement, resultat);
		}
		return statut;
	}

	public Jeu getJeuByID(int id)
	{
		JeuDao jeuDaoImpl;
		Jeu jeu = null;
		try
		{
			jeuDaoImpl = new JeuDaoImpl();

			jeu = jeuDaoImpl.findJeuById(id);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jeu;

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

}
