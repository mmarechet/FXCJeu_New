package fr.cfai.sio.dao.requete;

public class PlateformeRequete
{
	public static final String FIND_ALL_PLATEFORMES = "SELECT * from plateforme";
	
	public static final String FIND_ALL_PLATEFORMES_BY_JEU="SELECT * FROM plateforme WHERE id_plateforme in ( SELECT id_plateforme FROM lire WHERE id_jeu=? )";

}
