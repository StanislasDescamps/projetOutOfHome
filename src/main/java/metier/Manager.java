package metier;

import java.util.List;

import model.Activite;
import model.Genre;
import model.Langue;
import model.Utilisateur;
import dao.ActiviteDao;
import dao.GenreDao;
import dao.LangueDao;
import dao.UtilisateurDao;
import dao.impl.ActiviteDaoImpl;
import dao.impl.GenreDaoImpl;
import dao.impl.LangueDaoImpl;
import dao.impl.UtilisateurDaoImpl;

public class Manager {

	private static Manager instance;
	
	private GenreDao genreDao = (GenreDao) new GenreDaoImpl();
	private ActiviteDao activiteDao = (ActiviteDao) new ActiviteDaoImpl();
	private LangueDao langueDao = (LangueDao) new LangueDaoImpl();
	private UtilisateurDao utilisateurDao = (UtilisateurDao) new UtilisateurDaoImpl();
	
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	//Utilisateur
	
	public List<Utilisateur> listerUtilisateur(){
		return utilisateurDao.listerUtilisateur();
	}
	
	public List<Utilisateur> listerAuthentifiant(){
		return utilisateurDao.listerAuthentifiant();
	}
	public boolean utilisateurtExiste(String mail, String password){
		return utilisateurDao.utilisateurExiste(mail, password);
	}
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}
	public Utilisateur getUtilisateur(Integer idUtilisateur){
		return utilisateurDao.getUtilisateur(idUtilisateur);
	}
	
	//Langue
	public List<Langue> listerLangue(){
		return langueDao.listerLangue();
	}
	
	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue){
		langueDao.ajouterChoixLangue(idUtilisateur,idLangue);
	}
	
	public List<Langue> listerLangueByUtilisateur(Integer idUtilisateur){
		return langueDao.listerLangueByUtilisateur(idUtilisateur);
	}
	//Activite
	public List<Activite> listerActivite(){
		return activiteDao.listerActivite();
	}
	
	public List<Activite> listerActiviteByLieu(String lieu){
		return activiteDao.listerActiviteByLieu(lieu);
	}
	
	public void ajouterActivite(Activite gout){
		activiteDao.ajouterActivite(gout);
	}
	
	public void voteActivite(Integer idUtilisateur, Integer idGout, Integer valeur){
		activiteDao.voteActivite(idUtilisateur,idGout, valeur);
	}
	
	public Activite getActiviteByName(String nomActivite){
		return activiteDao.getActiviteByName(nomActivite);
	}
	
	public void incrementeVoteOui(Integer idGout){
		activiteDao.incrementeVoteOui(idGout);
	}
	
	public void incrementeVoteNon(Integer idGout){
		activiteDao.incrementeVoteNon(idGout);
	}
	
	//Genre
	public List<Genre> listerGenre(){
		return genreDao.listerGenre();
	}
	
	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre){
		genreDao.ajouterChoixGenre(idUtilisateur,idGenre);
	}
}

