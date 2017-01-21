package fr.cfai.sio.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.service.UtilisateurService;
import fr.cfai.sio.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService;

	public InscriptionServlet() throws Exception
	{
		super();
		System.out.println("Constructeur InscriptionServlet");

		this.utilisateurService=new UtilisateurServiceImpl();
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
		HttpSession session = null;
			
		session=request.getSession(true);

		List<Utilisateur> listeUtilisateurs = utilisateurService.recupererListeUtilisateurs();

		Boolean existePas = true;
		String login = request.getParameter("LOGIN");
		String mdp = request.getParameter("PASSWORD");
		String loginBase;

		for (Utilisateur utilisateur : listeUtilisateurs)
		{
			loginBase = utilisateur.getLogin();

			if (login.equals(loginBase))
			{
				existePas = false;
			}
		}

		if (existePas == true)
		{
			session.setAttribute("CONTROLE_INSCRIPTION", "OK");

			if (utilisateurService.ajouteUtilisateur(login, mdp) != null)
			{
				request.getRequestDispatcher("/validationInscription.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("/pageErreur.jsp").forward(request, response);
			}
		}
		else
		{
			session.setAttribute("CONTROLE_INSCRIPTION", "NOK");
			request.getRequestDispatcher("/inscription.jsp").forward(request, response);
		}
	}
}
