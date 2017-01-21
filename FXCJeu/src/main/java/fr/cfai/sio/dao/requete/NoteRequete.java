package fr.cfai.sio.dao.requete;

public class NoteRequete
{
	public static final String FIND_ALL_NOTES = "SELECT * from note";
	
	public static final String FIND_ALL_NOTES_BY_TEST="SELECT * FROM note WHERE id_note in ( SELECT id_note FROM noter WHERE id_test=? )";
}
