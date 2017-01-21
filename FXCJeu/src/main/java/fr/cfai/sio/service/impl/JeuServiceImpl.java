package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Jeu;
import fr.cfai.sio.dao.JeuDao;
import fr.cfai.sio.dao.impl.JeuDaoImpl;
import fr.cfai.sio.service.JeuService;

public class JeuServiceImpl implements JeuService
{

	private JeuDao jeuDaoImpl;
	private List<Jeu> listeJeux;

	public JeuServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur JeuServiceImpl");

		this.jeuDaoImpl = new JeuDaoImpl();
	}

	@Override
	public Jeu recupereJeuParID(int idJeu)
	{
		Jeu jeu = null;

		jeu = jeuDaoImpl.findJeuById(idJeu);

		return jeu;
	}

	@Override
	public List<Jeu> recupererListeJeux()
	{
		if (listeJeux == null)
		{
			// System.out.println("ServiceJEU : Passe par le if, liste null");
			listeJeux = jeuDaoImpl.findAllJeux();
			return listeJeux;
		}
		else
		{
			// System.out.println("ServiceJEU : Passe par le else, liste not
			// null");
			return listeJeux;
		}
	}
}
