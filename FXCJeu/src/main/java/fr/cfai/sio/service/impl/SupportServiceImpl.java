package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.List;
import fr.cfai.sio.business.Support;
import fr.cfai.sio.dao.SupportDao;
import fr.cfai.sio.dao.impl.SupportDaoImpl;
import fr.cfai.sio.service.SupportService;

public class SupportServiceImpl implements SupportService
{
	private SupportDao supportDaoImpl;
	private List<Support> listeSupports;

	public SupportServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur SupportServiceImpl");

		this.supportDaoImpl = new SupportDaoImpl();
	}

	@Override
	public List<Support> recupererListeSupports()
	{
		if (listeSupports == null)
		{
			listeSupports = supportDaoImpl.findAllSupports();
			return listeSupports;
		}
		else
		{
			return listeSupports;
		}
	}

	@Override
	public Support recupererSupportParId(int idSupport)
	{
		Support support;

		support = supportDaoImpl.findSupportById(idSupport);

		return support;
	}

	@Override
	public List<Support> recupererListeSupportsParJeu(int idJeu)
	{
		List<Support> listeSupportsParID = new ArrayList<>();

		listeSupportsParID = supportDaoImpl.findAllSupportsByJeu(idJeu);

		return listeSupportsParID;
	}

}
