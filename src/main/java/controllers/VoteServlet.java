package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Manager;

public class VoteServlet extends HttpServlet{

	private static final long serialVersionUID = -6490047633233350007L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//Recuperation des donnees
		Integer idUtilisateur=Integer.parseInt(request.getParameter("idUser"));
		Integer idActivite=Integer.parseInt(request.getParameter("idActivite"));
		Integer valeurVote=Integer.parseInt(request.getParameter("vote"));
		Boolean dejaVote=Manager.getInstance().getVoteActiviteUtilisateur(idUtilisateur, idActivite);
		
		if(!dejaVote){
			if(valeurVote!=null){
				if(valeurVote==1){
					Manager.getInstance().voteActivite(idUtilisateur, idActivite , 1);
					out.print(1);
				}else if(valeurVote==0){
					Manager.getInstance().voteActivite(idUtilisateur, idActivite , 0);
					out.print(1);
				}
			}
		}else{
			out.print(0);
		}
		
	}
}
