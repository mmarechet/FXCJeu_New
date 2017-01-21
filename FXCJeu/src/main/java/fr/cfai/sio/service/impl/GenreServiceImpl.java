package fr.cfai.sio.service.impl;

import java.util.List;
import fr.cfai.sio.business.Genre;
import fr.cfai.sio.dao.GenreDao;
import fr.cfai.sio.dao.impl.GenreDaoImpl;
import fr.cfai.sio.service.GenreService;

public class GenreServiceImpl implements GenreService
{
	private GenreDao genreDaoImpl;
	private List<Genre> listeGenres;

	public GenreServiceImpl() throws Exception
	{
		super();
	//	System.out.println("Constructeur GenreServiceImpl");

		this.genreDaoImpl = new GenreDaoImpl();
	}

	@Override
	public Genre recupererGenreParID(int idGenre)
	{
		Genre genre;

		genre = genreDaoImpl.findGenreById(idGenre);

		return genre;
	}

	@Override
	public List<Genre> recupererListeGenres()
	{
		if (listeGenres == null)
		{
			System.out.println("ServiceGENRE : Passe par le if, liste null");
			listeGenres = genreDaoImpl.findAllGenres();
			return listeGenres;
		}
		else
		{
			System.out.println("ServiceGENRE : Passe par le else, liste not null");
			return listeGenres;
		}
	}
}
