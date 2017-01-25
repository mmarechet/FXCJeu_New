package fr.cfai.sio.dao.requete;

public class NoteRequete
{
	public static final String FIND_ALL_NOTES = "SELECT * from note";
	
//	public static final String FIND_ALL_NOTES_BY_TEST="SELECT * FROM note WHERE id_note in ( SELECT id_note FROM noter WHERE id_test=? )";
	
	public static final String FIND_ALL_NOTES_BY_TEST="select id_noter,note from noter,note where noter.id_note=note.id_note and noter.id_test=?";

	public static final String AJOUT_NOTE = "INSERT INTO noter (id_note,id_test,id_noter) VALUES(?,?,?)";
	
	public static final String ID_MAX_NOTE = "SELECT MAX (id_noter) FROM noter";
}
