package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Developpeur;
import fr.cfai.sio.dao.DeveloppeurDao;
import fr.cfai.sio.dao.impl.DeveloppeurDaoImpl;
import fr.cfai.sio.service.DeveloppeurService;

public class DeveloppeurServiceImpl implements DeveloppeurService
{
	private DeveloppeurDao developpeurDaoImpl;
	private List<Developpeur> listeDeveloppeurs;

	public DeveloppeurServiceImpl() throws Exception
	{
		super();
		//System.out.println("Constructeur DevServiceImpl");

		this.developpeurDaoImpl = new DeveloppeurDaoImpl();
	}

	@Override
	public Developpeur recupererDeveloppeurParID(int idDeveloppeur)
	{
		Developpeur developpeur;

		developpeur = developpeurDaoImpl.findDeveloppeurById(idDeveloppeur);

		return developpeur;
	}

	@Override
	public List<Developpeur> recupererListeDeveloppeurs()
	{
		if (listeDeveloppeurs == null)
		{
			System.out.println("ServiceDEVELOPPEUR : Passe par le if, liste null");
			listeDeveloppeurs = developpeurDaoImpl.findAllDeveloppeurs();
			return listeDeveloppeurs;
		}
		else
		{
			System.out.println("ServiceDEVELOPPEUR : Passe par le else, liste not null");
			return listeDeveloppeurs;
		}
	}
}
