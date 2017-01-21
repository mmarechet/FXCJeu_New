package fr.cfai.sio.dao.requete;

public class SupportRequete
{
	public static final String FIND_ALL_SUPPORTS = "SELECT * from support";
	
	public static final String FIND_ALL_SUPPORTS_BY_JEU="SELECT * FROM support WHERE id_support in ( SELECT id_support FROM stocker WHERE id_jeu=? )";
}
