package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Note;
import fr.cfai.sio.dao.NoteDao;
import fr.cfai.sio.dao.impl.NoteDaoImpl;
import fr.cfai.sio.service.NoteService;

public class NoteServiceImpl implements NoteService
{

	private NoteDao noteDaoImpl;
	private List<Note> listeNotes;

	public NoteServiceImpl()
	{
		super();
		this.noteDaoImpl = new NoteDaoImpl();
	}

	@Override
	public List<Note> recupereListeNotes()
	{
		if (listeNotes == null)
		{
			listeNotes = noteDaoImpl.findAllNotes();
			return listeNotes;
		}
		else
		{
			return listeNotes;
		}
	}

	@Override
	public Note ajouterNotePourTest(int valueNote, int idTest)
	{
		Note note = null;
		
		note=noteDaoImpl.addNoteForTest(valueNote, idTest);
		
		return note;
	}

	@Override
	public List<Note> recupererListeNotesParTest(int idTest)
	{
		List<Note> listeNotesParTest;
		
		listeNotesParTest = noteDaoImpl.findAllNotesByTest(idTest);
		
		return listeNotesParTest;
		
	}

}
