package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

public class GenreServlet extends HttpServlet{

	private static final long serialVersionUID = 8149048798233415146L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
		
		//Ajout du choix de l'utilisateur dans la base de donnees
		Integer idGenre=Integer.parseInt(request.getParameter("genre"));
		Manager.getInstance().ajouterChoixGenre(idUtilisateur,idGenre);
		
	}
}
