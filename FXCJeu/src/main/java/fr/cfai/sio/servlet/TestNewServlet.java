package fr.cfai.sio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.service.TestService;
import fr.cfai.sio.service.impl.TestServiceImpl;

/**
 * Servlet implementation class TestServlet
 */
public class TestNewServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private TestService testServiceImpl;

	/**
	 * @throws Exception
	 * @see HttpServlet#HttpServlet()
	 */
	public TestNewServlet() throws Exception
	{
		super();
		System.out.println("Constructeur TestServlet");

		this.testServiceImpl = new TestServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("TestServlet - passe par le doGet");
		HttpSession session = request.getSession(true);

		int idTest;
		Test test = null;
		int idUtilisateur = (int) session.getAttribute("ID");
		String loginUtilisateur = (String) session.getAttribute("LOGIN");

		idTest = Integer.parseInt(request.getParameter("idTest"));
		test = testServiceImpl.recupereTestParID(idTest);

		request.setAttribute("TEST", test);
		request.setAttribute("idUtilisateur", idUtilisateur);
		request.setAttribute("loginUtilisateur", loginUtilisateur);

		request.getRequestDispatcher("/test.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("TestServlet - passe par le doPost");
		
	}

}
