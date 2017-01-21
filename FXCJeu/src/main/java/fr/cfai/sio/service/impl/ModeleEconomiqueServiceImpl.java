package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.ModeleEconomique;
import fr.cfai.sio.dao.ModeleEconomiqueDao;
import fr.cfai.sio.dao.impl.ModeleEconomiqueDaoImpl;
import fr.cfai.sio.service.ModeleEconomiqueService;

public class ModeleEconomiqueServiceImpl implements ModeleEconomiqueService
{
	private ModeleEconomiqueDao modeleEconomiqueDaoImpl;
	private List<ModeleEconomique> listeModeleEconomiques;

	public ModeleEconomiqueServiceImpl() throws Exception
	{
		super();
		//System.out.println("Constructeur ModeleEcoServiceImpl");

		this.modeleEconomiqueDaoImpl = new ModeleEconomiqueDaoImpl();
	}

	@Override
	public ModeleEconomique recupererModeleEconomiqueParId(int idModeleEconomique)
	{
		ModeleEconomique modeleEconomique;

		modeleEconomique = modeleEconomiqueDaoImpl.findModeleEconomiqueById(idModeleEconomique);

		return modeleEconomique;
	}

	@Override
	public List<ModeleEconomique> recupererListeModeleEconomiques()
	{
		if (listeModeleEconomiques == null)
		{
			listeModeleEconomiques = modeleEconomiqueDaoImpl.findAllModeleEconomiques();
			return listeModeleEconomiques;
		}
		else
		{
			return listeModeleEconomiques;
		}
	}

	@Override
	public List<ModeleEconomique> recupererListeModeleEconomiquesParJeu(int idJeu)
	{
		List<ModeleEconomique> listeModeleEconomiquesParID = new ArrayList<>();

		listeModeleEconomiquesParID = modeleEconomiqueDaoImpl.findAllModeleEconomiquesByJeu(idJeu);

		return listeModeleEconomiquesParID;
	}

}
