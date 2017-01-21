package fr.cfai.sio.dao.requete;

public class JeuRequete
{
	public static final String FIND_JEUX_BY_ID = "SELECT * FROM jeu WHERE id_jeu = ?";

	public static final String FIND_ALL_JEUX = "SELECT id_jeu,titre_jeu,img_jeu FROM jeu";

}
