package fr.cfai.sio.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.cfai.sio.business.Test;
import fr.cfai.sio.dao.TestDao;
import fr.cfai.sio.dao.impl.TestDaoImpl;
import fr.cfai.sio.service.TestService;

public class TestServiceImpl implements TestService
{

	private TestDao testDaoImpl;

	public TestServiceImpl() throws Exception
	{
		super();
		// System.out.println("Constructeur TestServiceImpl");

		this.testDaoImpl = new TestDaoImpl();
	}

	@Override
	public Test recupereTestParID(int idTest)
	{
		Test test = null;

		test = testDaoImpl.findTestById(idTest);

		return test;
	}

	@Override
	public List<Test> recupererListeTests()
	{
		List<Test> listeTests = new ArrayList<>();

		listeTests = testDaoImpl.findAllTest();

		return listeTests;

	}

	@Override
	public int ajouterTest(String titre, Date date, String avantage, String inconvenient, String description, short note, int id_Jeu,
			int id_Utilisateur, String contenu)
	{
		int statut = 0;

		if (testDaoImpl.addTest(titre, date, avantage, inconvenient, description, note, id_Jeu, id_Utilisateur, contenu) != 0)
		{

			statut = 1;

		}

		return statut;
	}

	@Override
	public List<Test> recupererListeTestsParJeu(int idJeu)
	{
		List<Test> listeTestParJeu = new ArrayList<>();

		listeTestParJeu = testDaoImpl.findAllTestByJeu(idJeu);

		return listeTestParJeu;
	}
}
