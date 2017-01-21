package fr.cfai.sio.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import fr.cfai.sio.service.impl.ImageServiceImpl;

/**
 * Servlet implementation class TeleversementServlet
 */
public class TeleversementServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private ImageService imageServiceImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeleversementServlet() throws Exception
	{
		super();
		System.out.println("Constructeur TeleversementServlet");
		this.imageServiceImpl = new ImageServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<Image> listeImages = new ArrayList<>();
		listeImages=imageServiceImpl.recupererListeImages();
		
		String cheminImages = System.getProperty("catalina.base");
		String separateur = System.getProperty("file.separator");
		String nomCompletImage = cheminImages + separateur+"webapps"+separateur;
		
		
		System.out.println("Constructeur nomCompletImage = "+nomCompletImage);
		
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
		System.out.println("TeleversementServlet - DoPost");

		Image image = null;
		int idTest = 0;
		String nomImage = "Img_";
	//	String cheminImages = "D:\\Cours\\GIT JAVA\\FXC jeu\\src\\main\\webapp\\images\\";

		String cheminImages = System.getProperty("catalina.base");
		String separateur = System.getProperty("file.separator");
		
//		D:\Cours\Info - COTE Francois-Xavier\Eclipse Neon\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps
	//
		System.out.println("TeleversementServlet - catalina.base = "+System.getProperty("catalina.base")+" SEPARATEUR = "+System.getProperty("file.separator"));
		
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

					if (nomChamp.equals("ID_TEST"))
					{
						idTest = Integer.parseInt(item.getString());
					}

					if (nomChamp.equals("NOM_IMAGE"))
					{
						nomImage = valeurChamp;
					}
				}
				else
				{
					i++;
					System.out.println("TeleversementServlet - else item.isFormField");
					String nomCompletImage = cheminImages + separateur+"webapps"+separateur+ nomImage + dateImg + i + ".jpg";
					System.out.println("TeleversementServlet - nomCompletImage : " + nomCompletImage);
					
					String nomCompletPourBDD = nomImage + dateImg + i + ".jpg";
					java.io.File fichierATeleverser = new java.io.File(nomCompletImage);

					try
					{
						item.write(fichierATeleverser);
						image = imageServiceImpl.ajouterImage(nomCompletPourBDD, 1);
						//image = imageServiceImpl.ajouterImage(nomCompletImage, 1);

					}
					catch (Exception e)
					{
						System.out.println("TeleversementServlet - Try Item.Write : " + e);
					}

				}

			} // End of while
			System.out.println("TeleversementServlet - Fin du while");
		}

	}

}
