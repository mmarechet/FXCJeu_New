package fr.cfai.sio.dao.requete;

public class UtilisateurRequete
{

	public static final String AJOUT_UTILISATEUR = "INSERT INTO utilisateur (id_utilisateur,login,mdp) VALUES(?,?,?)";

	public static final String ID_MAX_UTILISATEUR = "SELECT MAX (id_utilisateur) FROM utilisateur";

	public static final String FIND_ALL_UTILISATEURS = "SELECT * from utilisateur";
	
	public static final String FIND_UTILISATEUR_BY_ID = "SELECT * from utilisateur WHERE id_utilisateur = ?";

}
