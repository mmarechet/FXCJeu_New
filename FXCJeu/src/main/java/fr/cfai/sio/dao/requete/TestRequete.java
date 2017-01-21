package fr.cfai.sio.dao.requete;

public class TestRequete
{
	public static final String FIND_TEST_BY_ID = "SELECT * FROM test WHERE test.id_test = ?";
	
	public static final String FIND_ALL_TESTS = "SELECT * FROM test"; 
	
	public static final String FIND_ALL_TESTS_BY_JEU  = "SELECT * FROM test WHERE test.id_jeu = ?";
	
	public static final String ADD_TEST = "INSERT INTO test (id_test, titre_test, date_test, avantage_jeu, inconvenient_jeu, description_test, id_jeu, id_utilisateur, note_jeu,contenu_test) VALUES(?,?,now(),?,?,?,?,?,?,?)";
	
	public static final String ID_MAX_TEST = "SELECT MAX (id_test) FROM test";
	
}
