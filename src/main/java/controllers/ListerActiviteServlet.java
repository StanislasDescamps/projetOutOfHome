package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

import com.google.gson.Gson;

public class ListerActiviteServlet extends HttpServlet{

	private static final long serialVersionUID = 5056248032744865526L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Gson gson = new Gson();
		String json = gson.toJson(Manager.getInstance().listerActivite());
		PrintWriter out = response.getWriter();
		out.append(json);
		
	}
}