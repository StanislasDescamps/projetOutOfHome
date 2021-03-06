package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

//import com.google.gson.Gson;

public class ProfilUtilisateurServlet extends HttpServlet{

	private static final long serialVersionUID = 4866428176454974128L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		
		
		//Ajout du choix de l'utilisateur dans la base de donnees
		Integer idLangue=Integer.parseInt(request.getParameter("langues"));
		Manager.getInstance().ajouterChoixLangue(idUtilisateur,idLangue);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
}
