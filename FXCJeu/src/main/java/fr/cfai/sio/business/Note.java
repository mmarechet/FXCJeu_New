package fr.cfai.sio.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Commentaire OK
 * 
 * @author mathieu
 *
 */
public class Note
{
	/**
	 * Déclaration des variables de Note
	 */
	private int idNote;
	private short note;
	private List<Test> listetests;

	/**
	 * Constructeur de Note
	 * 
	 * @param idNote
	 *            ID de la note
	 * @param note
	 *            note de la note
	 * @param test
	 *            Test de la note
	 */
	public Note(int idNote, short note)
	{
		super();
		this.idNote = idNote;
		this.note = note;
		this.listetests = new ArrayList<>();
	}

	/**
	 * Getteur ID de la note
	 * 
	 * @return ID de la note
	 */
	public int getIdNote()
	{
		return idNote;
	}

	/**
	 * Setteur ID de la note
	 * 
	 * @param idNote
	 *            ID de la note
	 */
	public void setIdNote(int idNote)
	{
		this.idNote = idNote;
	}

	/**
	 * Getteur Note de la note
	 * 
	 * @return Note de la note
	 */
	public short getNote()
	{
		return note;
	}

	/**
	 * Setteur Note de la note
	 * 
	 * @param note
	 *            Note de la note
	 */
	public void setNote(short note)
	{
		this.note = note;
	}

	public List<Test> getListetests()
	{
		return listetests;
	}

	public void setListetests(List<Test> listetests)
	{
		this.listetests = listetests;
	}

}
