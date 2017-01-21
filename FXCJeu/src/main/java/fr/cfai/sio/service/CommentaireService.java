package fr.cfai.sio.service;

import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Commentaire;

public interface CommentaireService {
	
	public List<Commentaire> recupererListeCommentaire();
	
	public Commentaire recupererCommentaireParId(int idcommentaire);
	
	public List<Commentaire> recupererCommentaireParTest(int idTest);
	
	
	public int recupererIDMaxCommentaire();

	public int ajouterCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur);


	Commentaire ajouterReponseCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur,
			int idCommentaire);

}
