package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Classification;
import fr.cfai.sio.dao.ClassificationDao;
import fr.cfai.sio.dao.impl.ClassificationDaoImpl;
import fr.cfai.sio.service.ClassificationService;

public class ClassificationServiceImpl implements ClassificationService
{

	private ClassificationDao classificationDaoImpl;
	private List<Classification> listeClassifications;

	public ClassificationServiceImpl() throws Exception
	{
		super();
		//System.out.println("Constructeur ClassificationServiceImpl");
		this.classificationDaoImpl = new ClassificationDaoImpl();
	}

	@Override
	public List<Classification> recupererListeClassifications()
	{

		if (listeClassifications == null)
		{
			System.out.println("ServiceCLASSIFICATION : Passe par le if, liste null");
			listeClassifications = classificationDaoImpl.findAllClassifications();
			return listeClassifications;
		}
		else
		{
			System.out.println("ServiceCLASSIFICATION : Passe par le else, liste not null");
			return listeClassifications;
		}
	}
}
