package fr.cfai.sio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.service.JeuService;
import fr.cfai.sio.service.impl.JeuServiceImpl;

/**
 * Servlet implementation class JeuServlet
 */
public class JeuServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private JeuService jeuServiceImpl;
	

	/**
	 * @throws Exception
	 * @see HttpServlet#HttpServlet()
	 */
	public JeuServlet() throws Exception
	{
		super();
		System.out.println("Constructeur JeuServlet");

		this.jeuServiceImpl = new JeuServiceImpl();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int idJeu;
		Jeu jeu = null;

		idJeu = Integer.parseInt(request.getParameter("idJeu"));

		jeu = jeuServiceImpl.recupereJeuParID(idJeu);


		request.setAttribute("JEU", jeu);

		request.getRequestDispatcher("/jeu.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
