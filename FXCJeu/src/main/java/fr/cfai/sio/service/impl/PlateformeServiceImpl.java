package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Plateforme;
import fr.cfai.sio.dao.PlateformeDao;
import fr.cfai.sio.dao.impl.PlateformeDaoImpl;
import fr.cfai.sio.service.PlateformeService;

public class PlateformeServiceImpl implements PlateformeService
{
	private PlateformeDao plateformeDaoImpl;
	private List<Plateforme> listePlateformes;

	public PlateformeServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur PlateformeServiceImpl");

		this.plateformeDaoImpl = new PlateformeDaoImpl();
	}

	@Override
	public Plateforme recupererPlateformeParId(int idPlateforme)
	{
		Plateforme plateforme;

		plateforme = plateformeDaoImpl.findPlateformeById(idPlateforme);

		return plateforme;
	}

	@Override
	public List<Plateforme> recupererListePlateformes()
	{
		if (listePlateformes == null)
		{
			listePlateformes = plateformeDaoImpl.findAllPlateformes();
			return listePlateformes;
		}
		else
		{
			return listePlateformes;
		}
	}

	@Override
	public List<Plateforme> recupererListePlateformesParJeu(int idJeu)
	{
		List<Plateforme> listePlateformesParID = new ArrayList<>();

		listePlateformesParID = plateformeDaoImpl.findAllPlateformesByJeu(idJeu);

		return listePlateformesParID;
	}

}
