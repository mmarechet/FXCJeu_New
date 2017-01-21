package fr.cfai.sio.dao.requete;

public class ModeleEconomiqueRequete
{
	public static final String FIND_ALL_MODELE_ECONOMIQUES = "SELECT * from modele_eco";
	
	public static final String FIND_ALL_MODELE_ECONOMIQUES_BY_JEU="SELECT * FROM modele_eco WHERE id_modele_eco in ( SELECT id_modele_eco FROM payer WHERE id_jeu=? )";

}
