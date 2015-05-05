package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;
import model.Langue;
import model.Utilisateur;

import com.google.gson.Gson;

public class ListerUtilisateurServlet extends HttpServlet{

	private static final long serialVersionUID = 6510946148612038556L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		//Recuperation de tous les utilisateur (-l'utilisateurActuel)
		Utilisateur utilisateurActuel=Manager.getInstance().getUtilisateur(idUtilisateur);	
		List<Utilisateur> toutUtilisateur=Manager.getInstance().listerUtilisateur();
		toutUtilisateur.remove(utilisateurActuel);
		
		//liste des utilisateur environnant 
		List<Utilisateur> listeUtilisateurArround=new ArrayList<Utilisateur>();
		Integer rayon=40; //distance du rayon en km?
		
		//recuperation des autres utilisateurs proche de l'utilisateur 
		for(Utilisateur utilisateur : toutUtilisateur){
			if(distMin(utilisateurActuel.getLatitude(),utilisateur.getLatitude(),utilisateurActuel.getLongitude(),utilisateur.getLongitude(),rayon)){  //voir comment ca marche
				listeUtilisateurArround.add(utilisateur);
			}
		}
		
		//Initialisation de la liste finale
		List<Utilisateur> newListeUtilisateurArround=new ArrayList<Utilisateur>();
		
		//voir si dans cette nouvelle liste il y a quelqu'un parlant la meme langue
		if(listeUtilisateurArround!=null){
			//Recuperation des langues de l'utilisateur actuel
			List<Langue> listeLangueUtilisateurActuel=Manager.getInstance().listerLangueByUtilisateur(idUtilisateur);
			
			for(Utilisateur utilisateur2 : listeUtilisateurArround){
				//Recuperation des langues de l'utilisateur lambda
				List<Langue> listeLangue=Manager.getInstance().listerLangueByUtilisateur(utilisateur2.getIdUtilisateur());
					
				//comparaison de la liste de langue de l'utilisateur actuel et du lambda
					for(Langue langue: listeLangueUtilisateurActuel ){
						if(listeLangue.contains(langue)){
							newListeUtilisateurArround.add(utilisateur2);
						}
					}
			}
		}
    	
		Gson gson = new Gson();
		
		String json = gson.toJson(newListeUtilisateurArround);
		
		PrintWriter out = response.getWriter();
		out.append(json);
		
		
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
