package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

import com.google.gson.Gson;

public class ListerUtilisateurServlet extends HttpServlet{

	private static final long serialVersionUID = 6510946148612038556L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().listerUtilisateur());
		PrintWriter out = response.getWriter();
		out.append(json);
		
	}
}
