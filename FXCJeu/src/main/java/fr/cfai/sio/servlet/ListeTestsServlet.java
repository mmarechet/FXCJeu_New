package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.service.TestService;
import fr.cfai.sio.service.impl.TestServiceImpl;

/**
 * Servlet implementation class ListeTestsServlet
 */
public class ListeTestsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private TestService testServiceImpl;

	/**
	 * @throws Exception
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeTestsServlet() throws Exception
	{
		super();
		// System.out.println("Constructeur TestServlet");
		this.testServiceImpl = new TestServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int idJeu;
		String action = request.getParameter("action");

		// System.out.println("TestServlet - actionVal = "+action);

		if (action == null)
		{
			List<Test> listeTests = new ArrayList<>();

			listeTests = testServiceImpl.recupererListeTests();

			request.setAttribute("LISTE_TESTS", listeTests);
		}
		else
		{
			idJeu = Integer.parseInt(request.getParameter("idJeu"));

			List<Test> listeTestsParJeu = new ArrayList<>();
			

			listeTestsParJeu = testServiceImpl.recupererListeTestsParJeu(idJeu);
			
			request.setAttribute("LISTE_TESTS", listeTestsParJeu);
		}

		request.getRequestDispatcher("/listeTests.jsp").forward(request, response);
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
