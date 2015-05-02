package dao;

import java.util.List;

import model.Langue;

public interface LangueDao {

	public List<Langue> listerLangue(); //permet de lister toutes les langues
	public void ajouterChoixLangue(Integer idUtilisateur, Integer idLangue); //permet d'attibuer une langue a un utiisateur
	public List<Langue> listerLangueByUtilisateur(Integer idUtilisateur); //permet de recuerer les langues de l'utilisateur
}
