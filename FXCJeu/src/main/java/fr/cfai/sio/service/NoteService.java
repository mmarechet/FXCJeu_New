package fr.cfai.sio.service;

import java.util.List;
import fr.cfai.sio.business.Note;

public interface NoteService
{

	public List<Note> recupereListeNotes();
	
	public int ajouterNotePourTest(int note, int idTest);

}
