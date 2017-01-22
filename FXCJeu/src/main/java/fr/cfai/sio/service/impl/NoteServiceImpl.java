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
	public int ajouterNotePourTest(int note, int idTest)
	{
		int statut = 0;
		
		if (noteDaoImpl.addNoteForTest(note, idTest) != 0)
		{
			statut = 1;
		}
		
		return statut;
	}

}
