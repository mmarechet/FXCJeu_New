package fr.cfai.sio.dao;

import java.util.List;
import fr.cfai.sio.business.Note;

public interface NoteDao
{
	public List<Note> findAllNotes();
	
	public List<Note> findAllNotesByTest(int idTest);
}
