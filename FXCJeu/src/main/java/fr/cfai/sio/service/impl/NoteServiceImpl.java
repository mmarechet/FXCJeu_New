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
	//	System.out.println("Constructeur NoteServiceImpl");

		this.noteDaoImpl = new NoteDaoImpl();
	}



	@Override
	public List<Note> recupereListeNotes()
	{
		if (listeNotes == null)
		{
			System.out.println("ServiceNOTE : Passe par le if, liste null");
			listeNotes = noteDaoImpl.findAllNotes();
			return listeNotes;
		}
		else
		{
			System.out.println("ServiceNOTE : Passe par le else, liste not null");
			return listeNotes;
		}
	}

}
