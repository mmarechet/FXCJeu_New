package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.ModeleEconomique;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.ModeleEconomiqueDao;
import fr.cfai.sio.dao.requete.ModeleEconomiqueRequete;

public class ModeleEconomiqueDaoImpl implements ModeleEconomiqueDao
{

	private Connection connexion = ConnexionBDD.getConnection();
	
	public ModeleEconomiqueDaoImpl()
	{
		super();
		// System.out.println("Constructeur ModeleEcoDaoImpl");
	}

	@Override
	public ModeleEconomique findModeleEconomiqueById(int idModeleEconomique)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModeleEconomique> findAllModeleEconomiques()
	{
		Statement statement = null;
		ResultSet resultat = null;
		List<ModeleEconomique> listeModeleEconomiques = new ArrayList<ModeleEconomique>();
		int id_ModeleEconomique;
		String libelle_ModeleEconomique;
		ModeleEconomique modeleEconomique = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(ModeleEconomiqueRequete.FIND_ALL_MODELE_ECONOMIQUES);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_ModeleEconomique = resultat.getInt(1);
					libelle_ModeleEconomique = resultat.getString(2);
					modeleEconomique = new ModeleEconomique(id_ModeleEconomique, libelle_ModeleEconomique);
					listeModeleEconomiques.add(modeleEconomique);
				}
			}
			else
			{
				listeModeleEconomiques = null;
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
		return listeModeleEconomiques;
	}

	@Override
	public List<ModeleEconomique> findAllModeleEconomiquesByJeu(int idJeu)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		List<ModeleEconomique> listeModeleEconomiques = new ArrayList<ModeleEconomique>();
		int id_ModeleEconomique;
		String libelle_ModeleEconomique;
		ModeleEconomique modeleEconomique = null;

		try
		{
			preparedStatement = connexion.prepareStatement(ModeleEconomiqueRequete.FIND_ALL_MODELE_ECONOMIQUES_BY_JEU);
			preparedStatement.setInt(1, idJeu);

			try
			{
				resultat = preparedStatement.executeQuery();

				if (resultat != null)
				{
					while (resultat.next())
					{
						id_ModeleEconomique = resultat.getInt(1);
						libelle_ModeleEconomique = resultat.getString(2);
						modeleEconomique = new ModeleEconomique(id_ModeleEconomique, libelle_ModeleEconomique);
						listeModeleEconomiques.add(modeleEconomique);
					}
				}
				else
				{
					listeModeleEconomiques = null;
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
		return listeModeleEconomiques;
	}
}
