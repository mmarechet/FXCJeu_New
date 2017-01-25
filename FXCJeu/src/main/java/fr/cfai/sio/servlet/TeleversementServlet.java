package fr.cfai.sio.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import fr.cfai.sio.business.Image;
import fr.cfai.sio.service.ImageService;
import fr.cfai.sio.service.TestService;
import fr.cfai.sio.service.impl.ImageServiceImpl;
import fr.cfai.sio.service.impl.TestServiceImpl;

/**
 * Servlet implementation class TeleversementServlet
 */
public class TeleversementServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private TestService testServiceImpl;
	private ImageService imageServiceImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeleversementServlet() throws Exception
	{
		super();
		System.out.println("Constructeur TeleversementServlet");
		this.imageServiceImpl = new ImageServiceImpl();
		this.testServiceImpl = new TestServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Image> listeImages = new ArrayList<>();
	
		int id_Test=0;
		
		id_Test=Integer.parseInt(request.getParameter("idTest"));
		
		listeImages = imageServiceImpl.recupererListeImagesParTest(id_Test);

		String cheminImages = System.getProperty("catalina.base");
		String separateur = System.getProperty("file.separator");
		String nomCompletImage = cheminImages + separateur + "wtpwebapps" + separateur;

		System.out.println("Constructeur nomCompletImage = " + nomCompletImage);

		request.setAttribute("LISTE_IMAGE", listeImages);
		request.setAttribute("CHEMIN", nomCompletImage);

		request.getRequestDispatcher("/listeImage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
			
		
		
		
		String titre = null;
		Date date = new Date();
		String avantage = null;
		String inconvenient = null;
		String description = null;
		short note = 0;
		int id_Jeu = 0;
		int id_Utilisateur = 0;
		String contenu = null;
		boolean chaineVerif = true;
		String verification = "Ok" ;

		System.out.println("TeleversementServlet - DoPost");

		Image image = null;
		int idTest = 0;
		String nomImage = "Img_";
		// String cheminImages = "D:\\Cours\\GIT JAVA\\FXC
		// jeu\\src\\main\\webapp\\images\\";

		String cheminImages = System.getProperty("catalina.base");
		String separateur = System.getProperty("file.separator");
		String nomApp = request.getContextPath().substring(1);

		System.out.println("TeleversementServlet - nomApp " + nomApp);

		// Création du format de la date pour le fichier, il sera donc renomer
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss_");
		String dateImg = dateFormat.format(new Date());

		// java.io.File repository = new java.io.File(cheminImages);
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(10);
		// factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(60000000);

		List<FileItem> items = null;

		try
		{
			items = (List<FileItem>) upload.parseRequest(request);
		}
		catch (FileUploadException e)
		{
			System.out.println("TeleversementServlet - 1er Try : " + e);
		}

		if (items != null)
		{
			System.out.println("TeleversementServlet - Liste Items non null");

			Iterator<FileItem> iter = (Iterator<FileItem>) items.iterator();
			int i = 0;
			while (iter.hasNext())
			{

				System.out.println("TeleversementServlet - Lecture Iterator");
				FileItem item = (FileItem) iter.next();

				if (item.isFormField())
				{
					System.out.println("TeleversementServlet - if item.isFormField");
					String nomChamp = item.getFieldName();
					String valeurChamp = item.getString();

					switch (nomChamp)
					{
					case "ID_TEST":
						
						idTest = Integer.parseInt(valeurChamp);
						break;
					case "titre":
						chaineVerif =  verificationSaisie(valeurChamp);
						titre = valeurChamp;
						break;
					case "avantage":
						chaineVerif =  verificationSaisie(valeurChamp);
						avantage = valeurChamp;
						break;
					case "inconvenient":
						chaineVerif =  verificationSaisie(valeurChamp);
						inconvenient = valeurChamp;
						break;
					case "description":
						chaineVerif =  verificationSaisie(valeurChamp);
						description = valeurChamp;
						break;
					case "notes":
						
						note = Short.parseShort(valeurChamp);
						break;
					case "jeux":
						
						id_Jeu = Integer.parseInt(valeurChamp);
						break;
					case "auteur":
						
						id_Utilisateur = Integer.parseInt(valeurChamp);
						break;
					case "contenu":
						chaineVerif =  verificationSaisie(valeurChamp);
						contenu = valeurChamp;
						break;
					case "NOM_IMAGE":
						nomImage = valeurChamp;
						break;
					default:
						break;

					}
					
					if(chaineVerif == false){
						
						 verification = "erreurTrue";
					}
					
				}
				
				
				else
				{
					i++;
					System.out.println("TeleversementServlet - else item.isFormField");
					String nomCompletImage = cheminImages + separateur + "wtpwebapps" + separateur + nomApp + separateur + "images" + separateur
							+ nomImage + dateImg + i + ".jpg";
					System.out.println("TeleversementServlet - nomCompletImage : " + nomCompletImage);

					String nomCompletPourBDD = nomImage + dateImg + i + ".jpg";
					java.io.File fichierATeleverser = new java.io.File(nomCompletImage);

					try
					{
						if(idTest==0 && verification.equals("Ok"))
						{
							System.out.println("TeleversementServlet - idTest=0");
							System.out.println("TeleversementServlet - titre ="+titre);
							System.out.println("TeleversementServlet - avantage ="+avantage);
							System.out.println("TeleversementServlet - inconvenient ="+inconvenient);
							System.out.println("TeleversementServlet - description ="+description);
							System.out.println("TeleversementServlet - note ="+note);
							System.out.println("TeleversementServlet - id_Jeu ="+id_Jeu);
							System.out.println("TeleversementServlet - id_Utilisateur ="+id_Utilisateur);
							System.out.println("TeleversementServlet - contenu ="+contenu);
							
							
							
							
							idTest=testServiceImpl.ajouterTest(titre, date, avantage, inconvenient, description, note, id_Jeu, id_Utilisateur, contenu);
						}
						
						item.write(fichierATeleverser);
						image = imageServiceImpl.ajouterImage(nomCompletPourBDD, idTest);
						// image =
						// imageServiceImpl.ajouterImage(nomCompletImage, 1);

					}
					catch (Exception e)
					{
						System.out.println("TeleversementServlet - Try Item.Write : " + e);
					}

				}

			} // End of while
			System.out.println("TeleversementServlet - Fin du while");
		}
		
			if(verification.equals("erreurTrue")){
				
				request.setAttribute("ERREURSAISIE", verification);
				//request.getRequestDispatcher("ListeJeuxServlet").forward(request, response);
				response.sendRedirect("ListeJeuxServlet?ERREURSAISIE="+ verification);
				
			}else{
				request.setAttribute("idTest", idTest);
				request.getRequestDispatcher("/ajoutTestValidation.jsp").forward(request, response);
			}
			
		
		
			
		
			
		
		
	}
	
	// test des entrées
	
	private static boolean verificationSaisie(String chaine){
		
		Pattern p = Pattern.compile("[a-zA-Z_0-9]+");	
		Matcher m = p.matcher(chaine);
		boolean chaineOk = m.matches();
		
		
		for(int x=0; x<chaine.length();x++){
			String variable = Character.toString(chaine.charAt(x));
			if(variable.equalsIgnoreCase("'") || variable.equalsIgnoreCase(" ")){
				chaineOk = true;
			}
		}
		return chaineOk;
		
		/*if (!pseudoOk) {
			System.out.println("passe ici");
			response.sendRedirect("/pageErreur.jsp");
		}*/
	}
	

}
