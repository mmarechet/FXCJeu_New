package fr.cfai.sio.dao;

import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Commentaire;
import fr.cfai.sio.business.Test;

public interface CommentaireDao {
	
	/**
	 * Permet de recuperer un commentaire en fonction de son ID
	 * @return
	 */
	public Commentaire findCommentaireById(int idCommentaire);
	
	
	/**
	 * Permet de récupérer la liste de tous les commentaires
	 * @return
	 */
	
	
	public List<Commentaire> findAllCommentaire();
	
	public List<Commentaire> findAllCommentaireForTest();
	
	public List<Commentaire> findCommentaireByIDTest(int idTest);

	public List<Commentaire>findCommentaireByTest(Test test);
	
	public List<Commentaire>findAllCommentaireByIDCom(int idFKCom);
	
	public int getIDMaxCommentaire();


	public int addReponseCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur,
			int idCommentaire);


	public int addCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur);
	

}
