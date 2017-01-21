package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Editeur;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.EditeurDao;
import fr.cfai.sio.dao.requete.EditeurRequete;

public class EditeurDaoImpl implements EditeurDao
{

	private Connection connexion = ConnexionBDD.getConnection();

	public EditeurDaoImpl()
	{
		// System.out.println("Constructeur EditeurDaoImpl");
	}

	@Override
	public Editeur findEditeurById(int idEditeur)
	{
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public List<Editeur> findAllEditeurs()
	{
		Statement statement = null;
		ResultSet resultat = null;
		List<Editeur> listeEditeurs = new ArrayList<Editeur>();
		int id_editeur;
		String libelle_editeur;
		Editeur editeur = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(EditeurRequete.FIND_ALL_EDITEURS);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_editeur = resultat.getInt(1);
					libelle_editeur = resultat.getString(2);
					editeur = new Editeur(id_editeur, libelle_editeur);
					listeEditeurs.add(editeur);
				}
			}
			else
			{
				listeEditeurs = null;
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
		return listeEditeurs;
	}

}
