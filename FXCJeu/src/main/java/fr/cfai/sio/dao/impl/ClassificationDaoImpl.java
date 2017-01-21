package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Classification;
import fr.cfai.sio.dao.ClassificationDao;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.requete.ClassificationRequete;

public class ClassificationDaoImpl implements ClassificationDao
{

	private Connection connexion = ConnexionBDD.getConnection();

	public ClassificationDaoImpl()
	{
		super();
		// System.out.println("Constructeur ClassificationDaoImpl");
	}

	@Override
	public List<Classification> findAllClassifications()
	{

		Statement statement = null;
		ResultSet resultat = null;

		List<Classification> listeClassifications = new ArrayList<>();

		int id_classification;
		String libelle_classification;
		Classification classification = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(ClassificationRequete.FIND_ALL_CLASSIFICATIONS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_classification = resultat.getInt(1);
					libelle_classification = resultat.getString(2);
					classification = new Classification(id_classification, libelle_classification);
					listeClassifications.add(classification);
				}
			}
			else
			{
				listeClassifications = null;
			}

		}
		catch (SQLException e)
		{
			System.out.println("ClassificationDaoImpl/finAllClassifications - Erreur " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, null, resultat);
		}
		return listeClassifications;
	}
}
