package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;

/**
 * Servlet implementation class AjoutTestServletNew
 */
@MultipartConfig
public class AjoutTestServletNew extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutTestServletNew()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		String titre1 = request.getParameter("titre");
		Date date1 = new Date();
		String avantage1 = request.getParameter("avantage");
		String inconvenient1 = request.getParameter("inconvenient");
		String description1 = request.getParameter("description");
		short note1 = Short.parseShort(request.getParameter("notes"));
		int id_Jeu1 = Integer.parseInt(request.getParameter("jeux"));
		int id_Utilisateur1 = Integer.parseInt(request.getParameter("auteur"));
		String contenu1 = request.getParameter("contenu");
		
		
		

		
		
	}

}
