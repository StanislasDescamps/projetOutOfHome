package dao;

import java.util.List;

import model.Utilisateur;

public interface UtilisateurDao {

	public List<Utilisateur> listerUtilisateur(); //inutil dans notre cas
	public List<Utilisateur> listerAuthentifiant(); //permet de recuperer tous les triplet email, pseudo, password (connection par email ou par pseudo?)
	public boolean utilisateurExiste(String mail, String password); //verifie qu'un utilisateur existe bien
	public Utilisateur getUtilisateur(Integer idUtilisateur); //recupere les informations d'un utilisateur
	public void ajouterUtilisateur(Utilisateur utilisateur); //creation d'un profil
	public List<Utilisateur> listerUtilisateurByLangues(Integer idLangue); //permet de recuperer les utilisateurs parlant cette langues
}
