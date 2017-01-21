package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.service.JeuService;
import fr.cfai.sio.service.impl.JeuServiceImpl;

/**
 * Servlet implementation class ListeJeuxServlet
 */
public class ListeJeuxServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private JeuService jeuServiceImpl;
	private List<Jeu> listeJeux;

	/**
	 * @throws Exception
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeJeuxServlet() throws Exception
	{
		System.out.println("Constructeur ListeJeuxServlet");

		this.jeuServiceImpl = new JeuServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		System.out.println("ListeJeuxServlet - Passe par le doGet");

		if (request.getParameter("action") != null)
		{
			HttpSession session = request.getSession(true);
			int idUtilisateur = (int) session.getAttribute("ID");
			request.setAttribute("idUtilisateur", idUtilisateur);
			listeJeux = jeuServiceImpl.recupererListeJeux();
			request.setAttribute("ListeJeu", listeJeux);
			request.getRequestDispatcher("/ajoutTest.jsp").forward(request, response);

		}
		else
		{

			if (listeJeux == null)
			{
				// System.out.println("Servlet : Passe par le if, liste null");
				listeJeux = jeuServiceImpl.recupererListeJeux();
				request.setAttribute("LISTE_JEUX", listeJeux);
				request.getRequestDispatcher("/listeJeux.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("LISTE_JEUX", listeJeux);
				request.getRequestDispatcher("/listeJeux.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		System.out.println("ListeJeuxServlet - Passe par le doPost");

	}
}
