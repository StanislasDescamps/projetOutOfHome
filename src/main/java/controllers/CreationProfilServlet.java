package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;
import model.Utilisateur;

public class CreationProfilServlet extends HttpServlet{

	private static final long serialVersionUID = 5571210723631022256L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		/////////////////A synchroniser aver les balises sur android/////////////////////////////////////////////
		String pseudo=request.getParameter("pseudo");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Integer sexe=Integer.parseInt(request.getParameter("sexe"));  
		Integer age=Integer.parseInt(request.getParameter("age"));
		String image=request.getParameter("image");
		String origine=request.getParameter("origine");
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Recuperation  de tous les utilisateurs dans une liste
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		listUtilisateur = Manager.getInstance().listerAuthentifiant();
				
		Integer i=0;
		Integer n = listUtilisateur.size();
		Boolean existe=false;
		//Verification que le mail n'est pas deja utilise
		while(i<n && !existe)
		{
			if(email.equalsIgnoreCase(listUtilisateur.get(i).getEmail()))
				{
				existe=true;
				}
			else i++;
		}
		//s'il n'existe pas on cree le profil
		if(!existe)
		{
			Utilisateur nouvelUtilisateur = new Utilisateur(null, password, pseudo, email, sexe, age, origine,image,true);
			Manager.getInstance().ajouterUtilisateur(nouvelUtilisateur);
		}
	}
}
