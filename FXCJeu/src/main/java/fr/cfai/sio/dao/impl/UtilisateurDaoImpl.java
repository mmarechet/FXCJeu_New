package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.UtilisateurDao;
import fr.cfai.sio.dao.requete.UtilisateurRequete;

public class UtilisateurDaoImpl implements UtilisateurDao
{

	private int statut = 0;
	private Connection connexion = ConnexionBDD.getConnection();

	public UtilisateurDaoImpl() throws Exception
	{
		super();
//		System.out.println("Constructeur UtilisateurDaoImpl");
	}

	@Override
	public int addUtilisateur(String login, String mdp)
	{
		int idMax = 0;
		Statement statement = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(UtilisateurRequete.ID_MAX_UTILISATEUR);

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

			preparedStatement = connexion.prepareStatement(UtilisateurRequete.AJOUT_UTILISATEUR);
			preparedStatement.setInt(1, idMax);
			preparedStatement.setString(2, login);
			preparedStatement.setString(3, mdp);
			statut = preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			System.out.println("UtilisateurDaoImpl/addUtilisateur - Erreur SQL : " + e.getMessage());
			return statut;
		}
		finally
		{
			ConnexionBDD.close(statement, preparedStatement, resultat);
		}

		return statut;
	}

	@Override
	public Utilisateur findUtilisateurById(int idUtilisateur)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		int id_Utilisateur;
		String login;
		String mdp;
		Utilisateur utilisateur = null;

		try
		{
			preparedStatement = connexion.prepareStatement(UtilisateurRequete.FIND_UTILISATEUR_BY_ID);
			preparedStatement.setInt(1, idUtilisateur);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Utilisateur = resultat.getInt(1);
					login = resultat.getString(2);
					mdp = resultat.getString(3);

					utilisateur = new Utilisateur(id_Utilisateur, login, mdp);
				}
			}
			else
			{
				utilisateur = null;
			}

		}
		catch (SQLException e)
		{
			System.out.println("UtilisateurDaoImpl/findUtilisateurById - Erreur SQL : " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(null, preparedStatement, resultat);
		}
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAllUtilisateurs()
	{
		Statement statement = null;
		ResultSet resultat = null;

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		int idUtilisateur;
		String login;
		String mdp;
		Utilisateur utilisateur = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(UtilisateurRequete.FIND_ALL_UTILISATEURS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idUtilisateur = resultat.getInt(1);
					login = resultat.getString(2);
					mdp = resultat.getString(3);
					utilisateur = new Utilisateur(idUtilisateur, login, mdp);
					listeUtilisateurs.add(utilisateur);
				}
			}
			else
			{
				listeUtilisateurs = null;
			}

		}
		catch (SQLException e)
		{
			System.out.println("UtilisateurDaoImpl/findAllUtilisateurs - Erreur SQL : " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, null, resultat);
		}

		return listeUtilisateurs;
	}
}
