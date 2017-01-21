package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Support;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.SupportDao;
import fr.cfai.sio.dao.requete.SupportRequete;

public class SupportDaoImpl implements SupportDao
{
	private Connection connexion = ConnexionBDD.getConnection();

	public SupportDaoImpl()
	{
		super();
		// System.out.println("Constructeur SupportDaoImpl");
	}

	@Override

	public List<Support> findAllSupports()
	{
		Statement statement = null;
		ResultSet resultat = null;
		List<Support> listeSupports = new ArrayList<>();
		int id_support;
		String libelle_support;
		Support support = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(SupportRequete.FIND_ALL_SUPPORTS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_support = resultat.getInt(1);
					libelle_support = resultat.getString(2);
					support = new Support(id_support, libelle_support);
					listeSupports.add(support);
				}
			}
			else
			{
				listeSupports = null;
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
		return listeSupports;
	}

	@Override
	public Support findSupportById(int idSupport)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Support> findAllSupportsByJeu(int idJeu)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		List<Support> listeSupports = new ArrayList<Support>();
		int id_support;
		String libelle_support;
		Support support = null;

		try
		{
			preparedStatement = connexion.prepareStatement(SupportRequete.FIND_ALL_SUPPORTS_BY_JEU);
			preparedStatement.setInt(1, idJeu);
			preparedStatement.executeQuery();
			try
			{
				resultat = preparedStatement.executeQuery();

				if (resultat != null)
				{
					while (resultat.next())
					{
						id_support = resultat.getInt(1);
						libelle_support = resultat.getString(2);
						support = new Support(id_support, libelle_support);
						listeSupports.add(support);
					}
				}
				else
				{
					listeSupports = null;
				}

			}
			catch (SQLException e)
			{
				System.out.println("Erreur sql" + e.getMessage());
			}

		}
		catch (SQLException e)
		{
			System.out.println("Erreur sql" + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(null, preparedStatement, resultat);
		}
		return listeSupports;
	}
}
