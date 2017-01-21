package fr.cfai.sio.dao.requete;

public class ImageRequete
{
	public static final String AJOUT_IMAGE = "INSERT INTO image (id_image,chemin_image,id_test) VALUES(?,?,?)";

	public static final String ID_MAX_IMAGE = "SELECT MAX (id_image) FROM image";
	
	public static final String FIND_ALL_IMAGES="SELECT * from image";
}
