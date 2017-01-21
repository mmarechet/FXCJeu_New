package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Editeur;
import fr.cfai.sio.dao.EditeurDao;
import fr.cfai.sio.dao.impl.EditeurDaoImpl;
import fr.cfai.sio.service.EditeurService;

public class EditeurServiceImpl implements EditeurService
{

	private EditeurDao editeurDaoImpl;
	private List<Editeur> listeEditeurs;

	public EditeurServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur EditeurServiceImpl");

		this.editeurDaoImpl = new EditeurDaoImpl();
	}

	@Override
	public Editeur recupereEditeurParID(int idEditeur)
	{
		Editeur editeur;

		editeur = editeurDaoImpl.findEditeurById(idEditeur);

		return editeur;
	}

	public List<Editeur> recupererListeEditeurs()
	{
		if (listeEditeurs == null)
		{
			System.out.println("ServiceEDITEUR : Passe par le if, liste null");
			listeEditeurs = editeurDaoImpl.findAllEditeurs();
			return listeEditeurs;
		}
		else
		{
			System.out.println("ServiceEDITEUR : Passe par le else, liste not null");
			return listeEditeurs;
		}
	}
}
