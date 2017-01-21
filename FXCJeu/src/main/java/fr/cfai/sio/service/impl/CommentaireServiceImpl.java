package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Commentaire;
import fr.cfai.sio.dao.CommentaireDao;
import fr.cfai.sio.dao.impl.CommentaireDaoImpl;
import fr.cfai.sio.service.CommentaireService;

public class CommentaireServiceImpl implements CommentaireService {

	private CommentaireDao commentaireDaoImpl;
	private List<Commentaire> listeCommentaire;

	public CommentaireServiceImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		this.commentaireDaoImpl = new CommentaireDaoImpl();
	}

	@Override
	public List<Commentaire> recupererListeCommentaire() {
		// TODO Auto-generated method stub
		if (listeCommentaire == null) {
			// System.out.println("ServiceJEU : Passe par le if, liste null");
			listeCommentaire = commentaireDaoImpl.findAllCommentaire();
			return listeCommentaire;
		}

		else {
			// System.out.println("ServiceJEU : Passe par le else, liste not
			// null");
			return listeCommentaire;
		}

	}

	@Override
	public Commentaire recupererCommentaireParId(int idcommentaire) {
		// TODO Auto-generated method stub
		Commentaire commentaire = null;

		commentaire = commentaireDaoImpl.findCommentaireById(idcommentaire);

		return commentaire;
	}

	public int recupererIDMaxCommentaire()
	{
		int idMax = 0;
		
		idMax = commentaireDaoImpl.getIDMaxCommentaire();
		
		return idMax;
	}

	@Override
	public List<Commentaire> recupererCommentaireParTest(int idTest) {
		// TODO Auto-generated method stub
		List<Commentaire> listeCommentaire = new ArrayList<>();

		listeCommentaire = commentaireDaoImpl.findCommentaireByIDTest(idTest);

		return listeCommentaire;
	}

	@Override
	public int ajouterCommentaire(int idCom, String contenuCom, Date dateCom, int idTest,
			int idUtilisateur) {
		int statut = 0;
		if (commentaireDaoImpl.addCommentaire(idCom, contenuCom, dateCom, idTest, idUtilisateur) != 0) {
			System.out.println("GG");
			statut=1;
			//commentaire = new Commentaire(idCom, contenuCom, dateCom, idTest, idUtilisateur);
		}

		return statut;
	}

	@Override
	public Commentaire ajouterReponseCommentaire(int idCom, String contenuCom, Date dateCom, int idTest,
			int idUtilisateur, int idCommentaire) {
		Commentaire commentaire = null;

		if (commentaireDaoImpl.addReponseCommentaire(idCom, contenuCom, dateCom, idTest, idUtilisateur, idCommentaire) != 0) {
			System.out.println("GG");
			//commentaire = new Commentaire(idCom, contenuCom, dateCom, idTest, idUtilisateur, commentaire);
		}

		return commentaire;
	}

}
