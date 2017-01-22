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
import fr.cfai.sio.business.Image;
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.business.Note;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.dao.CommentaireDao;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.ImageDao;
import fr.cfai.sio.dao.NoteDao;
import fr.cfai.sio.dao.requete.ImageRequete;
import fr.cfai.sio.dao.requete.TestRequete;

public class ImageDaoImpl implements ImageDao
{
	private int statut = 0;
	private Connection connexion = ConnexionBDD.getConnection();
	
	
	
	
	public ImageDaoImpl()
	{
		super();
		System.out.println("Constructeur ImageDaoImpl");
	}

	@Override
	public int addImage(String chemin, int idTest)
	{
		int idMax = 0;
		Statement statement = null;
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(ImageRequete.ID_MAX_IMAGE);

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

			preparedStatement = connexion.prepareStatement(ImageRequete.AJOUT_IMAGE);
			preparedStatement.setInt(1, idMax);
			preparedStatement.setString(2, chemin);
			preparedStatement.setInt(3, idTest);
			statut = preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			//System.out.println("ImageDaoImpl/addUtilisateur - Erreur SQL : " + e.getMessage());
		}
		finally
		{
			ConnexionBDD.close(statement, preparedStatement, resultat);
		}

		return statut;
	}

	@Override
	public List<Image> findAllImages()
	{
		Statement statement = null;
		ResultSet resultat = null;

		List<Image> listeImages = new ArrayList<>();

		int idImage;
		String chemin;
		Image image = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(ImageRequete.FIND_ALL_IMAGES);

			if (resultat != null)
			{
				while (resultat.next())
				{
					idImage = resultat.getInt(1);
					chemin = resultat.getString(2);
					image = new Image(idImage, chemin, new Test(1));
					listeImages.add(image);
				}
			}
			else
			{
				listeImages = null;
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

		return listeImages;
	}

	@Override
	public List<Image> findAllImagesByTest(int idTest)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		
		int id_Image;
		String chemin_Image;
		Image image = null;
		List<Image> listeImages = new ArrayList<>();

		try
		{

			preparedStatement = connexion.prepareStatement(ImageRequete.FIND_ALL_IMAGES_BY_TEST);
			preparedStatement.setInt(1, idTest);
			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Image = resultat.getInt(1);
					chemin_Image = resultat.getString(2);

					image = new Image(id_Image,chemin_Image);

					listeImages.add(image);
				}
			}
			else
			{
				listeImages = null;
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
		return listeImages;
	}

}
