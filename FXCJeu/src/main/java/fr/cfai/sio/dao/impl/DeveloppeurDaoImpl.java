package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Developpeur;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.DeveloppeurDao;
import fr.cfai.sio.dao.requete.DeveloppeurRequete;

public class DeveloppeurDaoImpl implements DeveloppeurDao
{

	private Connection connexion = ConnexionBDD.getConnection();

	public DeveloppeurDaoImpl()
	{
		super();
		// System.out.println("Constructeur DevDaoImpl");
	}

	@Override

	public List<Developpeur> findAllDeveloppeurs()
	{
		Statement statement = null;
		ResultSet resultat = null;
		List<Developpeur> listeDeveloppeurs = new ArrayList<>();

		int id_developpeur;
		String libelle_developpeur;
		Developpeur developpeur = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(DeveloppeurRequete.FIND_ALL_DEVELOPPEURS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_developpeur = resultat.getInt(1);
					libelle_developpeur = resultat.getString(2);
					developpeur = new Developpeur(id_developpeur, libelle_developpeur);
					listeDeveloppeurs.add(developpeur);
				}
			}
			else
			{
				listeDeveloppeurs = null;
			}
		}
		catch (SQLException e)
		{
			System.out.println("DeveloppeurDaoImpl/findAllDeveloppeur - Erreur SQL : " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, null, resultat);
		}
		return listeDeveloppeurs;

	}

	public Developpeur findDeveloppeurById(int idDeveloppeur)
	{
		return null;
	}

}
