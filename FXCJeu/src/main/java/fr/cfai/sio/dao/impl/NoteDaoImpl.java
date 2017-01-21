package fr.cfai.sio.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Note;
import fr.cfai.sio.dao.ConnexionBDD;
import fr.cfai.sio.dao.NoteDao;
import fr.cfai.sio.dao.requete.NoteRequete;

public class NoteDaoImpl implements NoteDao
{
	private Connection connexion = ConnexionBDD.getConnection();

	public NoteDaoImpl()
	{
		super();
		// System.out.println("Constructeur NoteDaoImpl");
	}

	@Override
	public List<Note> findAllNotes()
	{
		Statement statement = null;
		ResultSet resultat = null;
		List<Note> listeNotes = new ArrayList<>();

		int id_Note;
		short value_Note;
		Note note = null;

		try
		{
			statement = connexion.createStatement();
			resultat = statement.executeQuery(NoteRequete.FIND_ALL_NOTES);

			if (resultat != null)
			{
				while (resultat.next())
				{
					id_Note = resultat.getInt(1);
					value_Note = resultat.getShort(2);
					note = new Note(id_Note, value_Note);
					listeNotes.add(note);
				}
			}
			else
			{
				listeNotes = null;
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
		return listeNotes;
	}

	@Override
	public List<Note> findAllNotesByTest(int idTest)
	{
		ResultSet resultat = null;
		PreparedStatement preparedStatement = null;
		List<Note> listeNotes = new ArrayList<>();
		int id_Note;
		short value_Note;
		Note note = null;

		try
		{
			preparedStatement = connexion.prepareStatement(NoteRequete.FIND_ALL_NOTES_BY_TEST);
			preparedStatement.setInt(1, idTest);

			resultat = preparedStatement.executeQuery();

			if (resultat != null)
			{

				while (resultat.next())
				{
					id_Note = resultat.getInt(1);
					value_Note = resultat.getShort(2);
					note = new Note(id_Note, value_Note);
					listeNotes.add(note);
				}
			}
			else
			{
				listeNotes = null;
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
		return listeNotes;
	}

}
