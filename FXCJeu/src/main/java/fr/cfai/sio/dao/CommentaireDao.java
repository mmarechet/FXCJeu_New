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
	 * Récupère la liste de tous les commentaires
	 * @return
	 */
	public List<Commentaire> findAllCommentaire();
	
	/**
	 * Récupère la liste de tous les commentaires pour les tests
	 * @return
	 */
	public List<Commentaire> findAllCommentaireForTest();
	
	/**
	 * Récupère la liste des commentaires d'un test (via son id)
	 * @return
	 */
	public List<Commentaire> findCommentaireByIDTest(int idTest);

	/**
	 * Récupère la liste des commentaires d'un test (obj)
	 * @return
	 */
	public List<Commentaire>findCommentaireByTest(Test test);
	
	/**
	 * Récupère la liste de tous les commentaires selon un ID com
	 * @return
	 */
	public List<Commentaire>findAllCommentaireByIDCom(int idFKCom);
	
	/**
	 * Récupère l'ID max des commentaires
	 * @return
	 */
	public int getIDMaxCommentaire();

	/**
	 * Permet l'ajout d'une réponse à un commentaire
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
