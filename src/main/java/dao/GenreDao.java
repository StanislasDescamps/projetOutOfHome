package dao;

import java.util.List;

import model.Genre;

public interface GenreDao {

	public List<Genre> listerGenre(); //permet de lister tous les genres
	public void ajouterChoixGenre(Integer idUtilisateur, Integer idGenre); //permet a l'utilisateur de choisir ces preferences de genre
	public List<Genre> listerGenreByUtilisateur(Integer idUtilisateur); //permet de recupere la liste des genres d'un utilisateur
}
