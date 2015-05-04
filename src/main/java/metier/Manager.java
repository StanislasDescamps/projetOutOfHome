package metier;

import java.util.ArrayList;
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
	public boolean utilisateurExiste(String mail, String password){
		return utilisateurDao.utilisateurExiste(mail, password);
	}
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.ajouterUtilisateur(utilisateur);
	}
	public Utilisateur getUtilisateur(Integer idUtilisateur){
		return utilisateurDao.getUtilisateur(idUtilisateur);
	}
	public void actualiserPositionUtilisateur(Integer idUtilisateur, Double latitude, Double longitude){
		utilisateurDao.actualiserPositionUtilisateur(idUtilisateur, latitude, longitude);
	}
	public Utilisateur getUtilisateurByEmail(String email){
		return utilisateurDao.getUtilisateurByEmail(email);
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
	
	public Boolean getVoteActiviteUtilisateur(Integer idUtilisateur, Integer idActivite){
		return activiteDao.getVoteActiviteUtilisateur(idUtilisateur, idActivite);
	}
	//Genre
	public List<Genre> listerGenre(){
		return genreDao.listerGenre();
	}
	
	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre){
		genreDao.ajouterChoixGenre(idUtilisateur,idGenre);
	}
	
	public List<Activite> activiteForUser(Integer idUser, String position ){
		List<Activite> result = new ArrayList<Activite>();
		List<Activite> activityBygenre =  activiteDao.listerActiviteForUSer(idUser);
		double latUser = Double.parseDouble(position.split(";")[0]);
		double lngUser = Double.parseDouble(position.split(";")[1]);
		for(Activite a : activityBygenre){
			if(distMin(a.getLatitudeAct(),latUser,a.getLongitudeAct(),lngUser,10)){
				result.add(a);
			}
		}
		return result;
	}
	
	private static boolean distMin(double lat1,double lat2,double long1,double long2, double dist){
		//cf http://andrew.hedges.name/experiments/haversine/
		lat1 = lat1* Math.PI/180;
		lat2 = lat2* Math.PI/180;
		long1 = long1* Math.PI/180;
		long2 = long2* Math.PI/180;
		double dlon = long2-long1;
		double dlat = lat2-lat1;
		double a = (Math.sin(dlat/2)*Math.sin(dlat/2))+Math.cos(lat1)*Math.cos(lat2)*(Math.sin(dlon/2)*Math.sin(dlon/2));
		double c = 2 * Math.asin(Math.sqrt(a));
		double d = 6378 * c;
		System.out.println(d);
		if(d<=dist){
			return true;
		}else{
			return false;
		}
		
	}
}

