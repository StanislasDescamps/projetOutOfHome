package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

import com.google.gson.Gson;

public class AuthentificationServlet extends HttpServlet{

	private static final long serialVersionUID = 9055385847487401992L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().listerAuthentifiant());
		PrintWriter out = response.getWriter();
		out.append(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
}
