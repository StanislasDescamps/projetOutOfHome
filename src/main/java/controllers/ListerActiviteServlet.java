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

		Integer idUser = Integer.parseInt(request.getParameter("idUser"));
		String userLocalisation = request.getParameter("userLocalisation");
		Gson gson = new Gson();
				
		//Mise a jour de la localisation
		//Traitement du lieu
		Double latitude=Double.parseDouble(userLocalisation.split(";")[0]);
		Double longitude=Double.parseDouble(userLocalisation.split(";")[1]);
		
		Manager.getInstance().actualiserPositionUtilisateur(idUser, latitude, longitude);
		
		String json = gson.toJson(Manager.getInstance().activiteForUser(idUser,userLocalisation));
		PrintWriter out = response.getWriter();
		out.append(json);
		
	}
}
