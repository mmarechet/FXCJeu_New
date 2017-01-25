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
	 * R�cup�re la liste de tous les commentaires
	 * @return
	 */
	public List<Commentaire> findAllCommentaire();
	
	/**
	 * R�cup�re la liste de tous les commentaires pour les tests
	 * @return
	 */
	public List<Commentaire> findAllCommentaireForTest();
	
	/**
	 * R�cup�re la liste des commentaires d'un test (via son id)
	 * @return
	 */
	public List<Commentaire> findCommentaireByIDTest(int idTest);

	/**
	 * R�cup�re la liste des commentaires d'un test (obj)
	 * @return
	 */
	public List<Commentaire>findCommentaireByTest(Test test);
	
	/**
	 * R�cup�re la liste de tous les commentaires selon un ID com
	 * @return
	 */
	public List<Commentaire>findAllCommentaireByIDCom(int idFKCom);
	
	/**
	 * R�cup�re l'ID max des commentaires
	 * @return
	 */
	public int getIDMaxCommentaire();

	/**
	 * Permet l'ajout d'une r�ponse � un commentaire
	 * @return
	 */
	public int addReponseCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur,
			int idCommentaire);

	/**
	 * Permet d'ajouter un commentaire
	 * @return
	 */
	public int addCommentaire(int idCom, String contenuCom, Date dateCom, int idTest, int idUtilisateur, int valueNote);
	

}
