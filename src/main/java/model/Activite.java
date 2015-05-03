package model;

public class Activite {

	private Integer idActivite;
	private String libelleActivite;
	private Integer idGenre;
	private Double latitudeAct;
	private Double longitudeAct;
	private Integer voteOui;
	private Integer voteNon;
	
	public Activite(Integer idgout, String nomgout, Integer idgenre, Double latitude, Double longitude, Integer oui, Integer non){
		this.idActivite=idgout;
		this.libelleActivite=nomgout;
		this.idGenre=idgenre;
		this.latitudeAct=latitude;
		this.longitudeAct=longitude;
		this.voteOui=oui;
		this.voteNon=non;
	}
	
	public Activite(Integer idgout, String nomgout, Integer idgenre, Double latitude, Double longitude){
		this.idActivite=idgout;
		this.libelleActivite=nomgout;
		this.idGenre=idgenre;
		this.latitudeAct=latitude;
		this.longitudeAct=longitude;
	}

	public Integer getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(Integer idActivite) {
		this.idActivite = idActivite;
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public Double getLongitudeAct() {
		return longitudeAct;
	}

	public void setLongitudeAct(Double longitudeAct) {
		this.longitudeAct = longitudeAct;
	}

	public Double getLatitudeAct() {
		return latitudeAct;
	}

	public void setLatitudeAct(Double latitudeAct) {
		this.latitudeAct = latitudeAct;
	}

	public Integer getVoteOui() {
		return voteOui;
	}

	public void setVoteOui(Integer voteOui) {
		this.voteOui = voteOui;
	}

	public Integer getVoteNon() {
		return voteNon;
	}

	public void setVoteNon(Integer voteNon) {
		this.voteNon = voteNon;
	}
	
}
