package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Utilisateur;
import fr.cfai.sio.dao.UtilisateurDao;
import fr.cfai.sio.dao.impl.UtilisateurDaoImpl;
import fr.cfai.sio.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService
{

	private UtilisateurDao utilisateurDaoImpl;
	
	public UtilisateurServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur UtilisateurServiceImpl");

		this.utilisateurDaoImpl = new UtilisateurDaoImpl();
	}

	@Override
	public Utilisateur ajouteUtilisateur(String login, String mdp)
	{
		Utilisateur utilisateur = null;

		if (utilisateurDaoImpl.addUtilisateur(login, mdp) != 0)
		{
		//	System.out.println("GG");
			utilisateur = new Utilisateur(login, mdp);
		}
		

		return utilisateur;
	}

	@Override
	public Utilisateur recupererUtilisateurParID(int idUtilisateur)
	{
		Utilisateur utilisateur;

		utilisateur = utilisateurDaoImpl.findUtilisateurById(idUtilisateur);

		return utilisateur;
	}

	@Override
	public List<Utilisateur> recupererListeUtilisateurs()
	{

		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

		listeUtilisateurs = utilisateurDaoImpl.findAllUtilisateurs();

		return listeUtilisateurs;
	}
}
