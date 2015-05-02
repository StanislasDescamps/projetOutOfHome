package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

import com.google.gson.Gson;

public class ProfilUtilisateurServlet extends HttpServlet{

	private static final long serialVersionUID = 4866428176454974128L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().getUtilisateur(idUtilisateur));
		PrintWriter out = response.getWriter();
		out.append(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		//Recuperation de tous les elements coces et ajout dans une liste de format string
		//Choix des langues
		String[] choixLangue = request.getParameterValues("langues");
		for(int i=0;i<choixLangue.length;i++)
		{
		//Ajout du choix de l'utilisateur dans la base de donnees
		Integer idLangue=Integer.parseInt(choixLangue[i]);
		Manager.getInstance().ajouterChoixLangue(idUtilisateur,idLangue);
		
		}
		
		//Choix des genres
		String[] choixGenre = request.getParameterValues("genre");
		for(int k=0;k<choixGenre.length;k++)
		{
		//Ajout du choix de l'utilisateur dans la base de donnees
		Integer idGenre=Integer.parseInt(choixGenre[k]);
		Manager.getInstance().ajouterChoixGenre(idUtilisateur,idGenre);
		}
	}
}
