package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		 //Permet l'ouverture de la page
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/accueilTempo.jsp");
    	view.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/////////////////A synchroniser aver les balises sur android/////////////////////////////////////////////
		Integer idgenre=Integer.parseInt(request.getParameter("genre"));
		String nomActivite=request.getParameter("nomActivite");
		String lieu=request.getParameter("lieu");
		
		//Recuperation de l'identifiant de l'utilisateur
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		Activite nouveauGout= new Activite(null,nomActivite, idgenre, lieu);
		Manager.getInstance().ajouterActivite(nouveauGout);
		
		Integer idGout=Manager.getInstance().getActiviteByName(nomActivite).getIdActivite();
		
		Manager.getInstance().voteActivite(idUtilisateur, idGout , 1);  //nullPointerException? 
		Manager.getInstance().incrementeVoteOui(idGout);
	}
}
