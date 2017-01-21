package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cfai.sio.service.TestService;
import fr.cfai.sio.service.impl.TestServiceImpl;

/**
 * Servlet implementation class AjoutTestServlet
 */
public class AjoutTestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private TestService testServiceImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutTestServlet() throws Exception
	{
		// System.out.println("Constructeur AjoutTestServlet");
		this.testServiceImpl = new TestServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String titre = request.getParameter("titre");
		Date date = new Date();
		String avantage = request.getParameter("avantage");
		String inconvenient = request.getParameter("inconvenient");
		String description = request.getParameter("description");
		short note = Short.parseShort(request.getParameter("notes"));
		int id_Jeu = Integer.parseInt(request.getParameter("jeux"));
		int id_Utilisateur = Integer.parseInt(request.getParameter("auteur"));
		String contenu = request.getParameter("contenu");

		if (testServiceImpl.ajouterTest(titre, date, avantage, inconvenient, description, note, id_Jeu, id_Utilisateur, contenu) == 0)
		{
			request.getRequestDispatcher("/pageErreur.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/ajoutTestValidation.jsp").forward(request, response);
		}

	}

}
