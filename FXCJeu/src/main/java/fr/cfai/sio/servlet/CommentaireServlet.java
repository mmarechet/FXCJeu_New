package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cfai.sio.service.CommentaireService;
import fr.cfai.sio.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class CommentaireServlet
 */
public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentaireService commentaireServiceImpl;
	// private Commentaire commentaire;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentaireServlet() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		this.commentaireServiceImpl = new CommentaireServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int idUtilisateur = Integer.parseInt(request.getParameter("Utilisateur"));
		int idTest = Integer.parseInt(request.getParameter("Test"));
		Date dateCom = new Date();
		String contenuCom = request.getParameter("ContenuCom");
		String contenuReponse = request.getParameter("ContenuReponse");
		int idCom = commentaireServiceImpl.recupererIDMaxCommentaire();

		if (request.getParameter("Commentaire") != null) {
			int idCommentaire = Integer.parseInt(request.getParameter("Commentaire"));
			if (commentaireServiceImpl.ajouterReponseCommentaire(idCom, contenuReponse, dateCom, idTest, idUtilisateur,
					idCommentaire) == null) {
				request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
			}

			else {
				response.sendRedirect("TestServlet?idTest=" + idTest);
			}
		}

		else {

			if (commentaireServiceImpl.ajouterCommentaire(idCom, contenuCom, dateCom, idTest, idUtilisateur) == 0) {

				request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
			} else {
				response.sendRedirect("TestServlet?idTest=" + idTest);
			}

		}

	}

}
