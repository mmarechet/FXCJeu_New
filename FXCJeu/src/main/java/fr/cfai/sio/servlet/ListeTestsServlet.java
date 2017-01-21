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
	private List<Test> listeTests;

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
		List<Test> listeTestsParJeu = new ArrayList<>();
		List<Test> listeTestsApresMaj = new ArrayList<>();

		// System.out.println("TestServlet - actionVal = "+action);

		if (action == null)
		{
			// System.out.println("TestServlet - action = null");
			if (listeTests == null)
			{
				// System.out.println("TestServlet - action = null - liste =
				// null");
				listeTests = testServiceImpl.recupererListeTests();
			}
			request.setAttribute("LISTE_TESTS", listeTests);
		}
		else
		{
			// System.out.println("TestServlet - action <> null");
			if (action.equals("maj"))
			{
				// System.out.println("TestServlet - action = maj");
				listeTestsApresMaj = testServiceImpl.recupererListeTests();
				request.setAttribute("LISTE_TESTS", listeTestsApresMaj);
			}
			else
			{
				// System.out.println("TestServlet - action <> maj");
				idJeu = Integer.parseInt(request.getParameter("idJeu"));
				listeTestsParJeu = testServiceImpl.recupererListeTestsParJeu(idJeu);
				request.setAttribute("LISTE_TESTS", listeTestsParJeu);
			}
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
