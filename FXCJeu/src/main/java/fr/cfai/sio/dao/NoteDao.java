package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Note;

public interface NoteDao
{
	/**
	 * R�cup�re la liste des notes
	 * @return
	 */
	public List<Note> findAllNotes();
	
	/**
	 * R�cup�re la liste des notes par test
	 * @param idTest
	 * @return
	 */
	public List<Note> findAllNotesByTest(int idTest);
	
	/**
	 * Permet d'ajouter une note pour un test donn�
	 * @param note
	 * @param idTest
	 * @return
	 */
	public Note addNoteForTest(int note, int idTest);
}
