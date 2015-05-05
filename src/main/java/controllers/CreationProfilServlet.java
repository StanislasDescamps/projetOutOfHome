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
request.setCharacterEncoding("UTF-8");
		
		/////////////////A synchroniser aver les balises sur android/////////////////////////////////////////////
		String pseudo=request.getParameter("pseudo");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String age=request.getParameter("age");
		String sexe=request.getParameter("sexe");  
		String image=request.getParameter("image");
		String origine=request.getParameter("origine");
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		Double lat=0.00;
		Double longi=0.00;
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
			Utilisateur nouvelUtilisateur = new Utilisateur(null, password, pseudo, email, Integer.parseInt(sexe), Integer.parseInt(age), origine, lat, longi,image,true);
			Manager.getInstance().ajouterUtilisateur(nouvelUtilisateur);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
}
