package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Note;

public interface NoteService
{

	public List<Note> recupereListeNotes();
	
	public Note ajouterNotePourTest(int note, int idTest);
	
	public List<Note> recupererListeNotesParTest(int idTest);

}
