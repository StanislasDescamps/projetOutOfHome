package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import metier.Manager;
import model.Activite;

import com.google.gson.Gson;

public class AjouterActiviteServlet extends HttpServlet{

	private static final long serialVersionUID = 6151212621129131277L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().listerGenre());
		PrintWriter out = response.getWriter();
		out.append(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//recuperation des parametres
		Integer idgenre=Integer.parseInt(request.getParameter("genre"));
		String nomActivite=request.getParameter("nomActivite");
		String lieu=request.getParameter("lieu");
		Integer valeurVote=Integer.parseInt(request.getParameter("vote"));
		
		//Recuperation de l'identifiant de l'utilisateur
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		//verification que l'activite n'existe pas deja
		List<Activite> listeActivites=Manager.getInstance().listerActivite();
		Boolean activiteExiste=false;
		Integer i=0;
		while(activiteExiste==false && i<listeActivites.size()){
			
			if(nomActivite.equalsIgnoreCase(listeActivites.get(i).getLibelleActivite())){
				activiteExiste=true;
			}else{
				i++;
			}
		}
		if(!activiteExiste){
			//Traitement du lieu
			Double latitude=Double.parseDouble(lieu.split(";")[0]);
			Double longitude=Double.parseDouble(lieu.split(";")[1]);
			
			Activite nouveauGout= new Activite(null,nomActivite, idgenre, latitude, longitude);
			Manager.getInstance().ajouterActivite(nouveauGout);
			
			Integer idGout=Manager.getInstance().getActiviteByName(nomActivite).getIdActivite();
			
			if(valeurVote!=null){
				if(valeurVote==1){
					Manager.getInstance().voteActivite(idUtilisateur, idGout , 1); 
					
				}else if(valeurVote==0){
					Manager.getInstance().voteActivite(idUtilisateur, idGout , 0);  
					
				}
			
			}
		}
	}
	
	
}
