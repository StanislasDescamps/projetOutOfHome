package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import metier.Manager;
import model.Langue;
import model.Utilisateur;


public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = 7197388426155502162L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		 //Permet l'ouverture de la page
    	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/accueilTempo.jsp");
    	view.forward(request, response);
	}
}
