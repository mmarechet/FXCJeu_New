package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cfai.sio.business.Commentaire;
import fr.cfai.sio.service.CommentaireService;
import fr.cfai.sio.service.impl.CommentaireServiceImpl;

/**
 * Servlet implementation class ListeCommentaireServlet
 */

public class ListeCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentaireService commentaireServiceImpl;
	private List<Commentaire> listeCommentaire;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeCommentaireServlet() throws Exception {
        super();
        // TODO Auto-generated constructor stub
        this.commentaireServiceImpl = new CommentaireServiceImpl();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (listeCommentaire == null)
		{
			//int idTest = 0;
			//idTest = Integer.parseInt(request.getParameter("idTest"));
			// System.out.println("Servlet : Passe par le if, liste null");
			//listeCommentaire = commentaireServiceImpl.recupererCommentaireParTest(idTest);
			listeCommentaire = commentaireServiceImpl.recupererListeCommentaire();
		}

		request.setAttribute("LISTE_COMMENTAIRE", listeCommentaire);
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
