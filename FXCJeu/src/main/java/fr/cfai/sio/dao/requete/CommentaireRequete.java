package fr.cfai.sio.dao.requete;

public class CommentaireRequete {

	public static final String FIND_COMMENTAIRE_BY_ID = "SELECT * FROM commentaire WHERE id_com= ?";

	public static final String FIND_ALL_COMMENTAIRE = "SELECT * FROM commentaire";
	
	public static final String FIND_ALL_COMMENTAIRE_BY_IDCOM ="SELECT * FROM commentaire WHERE id_fk_com=?";
	
	public static final String FIND_COMMENTAIRE_BY_TEST = "SELECT * FROM commentaire WHERE id_test = ? and id_fk_com is null";
	
	public static final String ID_MAX_COMMENTAIRE = "SELECT MAX (id_com) FROM commentaire";
	
	public static final String AJOUT_COMMENTAIRE= "INSERT INTO commentaire (id_com,contenu_com,date_com,id_utilisateur,id_test) VALUES(?,?,now(),?,?)";
	
	public static final String SUPPRESSION_COMMENTAIRE= "DELETE FROM commentaire WHERE id_com=?";
	
	public static final String MAX_ID_COMMENTAIRE= "SELECT MAX(id_com) FROM commentaire";

	public static final String AJOUT_COMMENTAIRE_PAR_COMMENTAIRE= "INSERT INTO commentaire (id_com,contenu_com,date_com,id_utilisateur,id_test,id_fk_com) VALUES(?,?,now(),?,?,?)";
}
