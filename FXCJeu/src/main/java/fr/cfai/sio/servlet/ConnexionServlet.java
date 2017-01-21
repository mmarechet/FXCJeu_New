package fr.cfai.sio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnexionServlet
 */
public class ConnexionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365; // 1 an

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet()
	{
		super();
		System.out.println("Constructeur ConnexionServlet");

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String contenuCookie = getCookieValue(request, "LOGIN");
		String login = "";
		String mdp = "";
		String memoire = "";
		int index1;
		int index2;

		if (contenuCookie != null)
		{
			index1 = contenuCookie.indexOf("-");
			index2 = contenuCookie.indexOf("/");

			memoire = contenuCookie.substring(0, index1);

			if (memoire.equals("OK"))
			{
				login = contenuCookie.substring(index1 + 1, index2);
				mdp = contenuCookie.substring(index2 + 1);
			}
			request.setAttribute("LOGIN", login);
			request.setAttribute("MDP", mdp);
			request.setAttribute("MEMOIRE", memoire);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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

	private static String getCookieValue(HttpServletRequest request, String login)
	{
		Cookie[] cookies = request.getCookies();

		if (cookies != null)
		{
			for (Cookie cookie : cookies)
			{
				if (cookie != null && login.equals(cookie.getName()))
				{
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
