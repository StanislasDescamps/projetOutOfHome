package model;

public class Utilisateur {

	private Integer idUtilisateur;
	private String password;
	private String pseudo;
	private Integer age;
	private Integer sexe;
	private String email;
	private String regionOrigine;
	private Double longitude;
	private Double latitude;
	private String image;
	private Boolean communication;
	
	public Utilisateur(Integer idUser, String pass, String pseudo, String mail, Integer sexe, Integer age, String origine, Double latitude, Double longitude, String logo, Boolean comm){
		this.idUtilisateur=idUser;
		this.password=pass;
		this.pseudo=pseudo;
		this.email=mail;
		this.sexe=sexe;
		this.age=age;
		this.regionOrigine=origine;
		this.longitude=longitude;
		this.latitude=latitude;
		this.image=logo;
		this.communication=comm;
	}
	
	public Utilisateur(Integer idUser, String pass, String pseudo, String mail, Integer sexe, Integer age, String origine, String logo, Boolean comm){
		this.idUtilisateur=idUser;
		this.password=pass;
		this.pseudo=pseudo;
		this.email=mail;
		this.sexe=sexe;
		this.age=age;
		this.regionOrigine=origine;
		this.image=logo;
		this.communication=comm;
	}
	
	public Utilisateur(Integer idUser, String pseudo, String mail, Integer sexe, Integer age, String origine, Double latitude, Double longitude, String logo, Boolean comm){
		this.idUtilisateur=idUser;
		this.pseudo=pseudo;
		this.email=mail;
		this.sexe=sexe;
		this.age=age;
		this.regionOrigine=origine;
		this.longitude=longitude;
		this.latitude=latitude;
		this.image=logo;
		this.communication=comm;
	}
	
	public Utilisateur(String mail, String pseudo, String password){
		this.email=mail;
		this.pseudo=pseudo;
		this.password=password;
	}
	
	public Utilisateur(String mail, String password){
		this.email=mail;
		this.password=password;
	}
	
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSexe() {
		return sexe;
	}

	public void setSexe(Integer sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicile() {
		return regionOrigine;
	}

	public void setDomicile(String domicile) {
		this.regionOrigine = domicile;
	}

	public String getRegionOrigine() {
		return regionOrigine;
	}

	public void setRegionOrigine(String regionOrigine) {
		this.regionOrigine = regionOrigine;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Boolean getCommunication() {
		return communication;
	}

	public void setCommunication(Boolean communication) {
		this.communication = communication;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
