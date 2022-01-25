package model.voyage;

import java.util.List;

public class Vol {
	
	private Integer id;
	private double prix;
	private String lieux;
	private statutVol statutVol;
	private String numeroVol;
	private Horaire horaire;
	private List<Escale> escales;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private Avion avion;
	
	
	public Vol(Integer id, double prix, String lieux, model.voyage.statutVol statutVol, String numeroVol,
			Horaire horaire, List<Escale> escales, Aeroport aeroportDepart, Aeroport aeroportArrivee, Avion avion) {
		this.id = id;
		this.prix = prix;
		this.lieux = lieux;
		this.statutVol = statutVol;
		this.numeroVol = numeroVol;
		this.horaire = horaire;
		this.escales = escales;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.avion = avion;
	}


	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getLieux() {
		return lieux;
	}


	public void setLieux(String lieux) {
		this.lieux = lieux;
	}


	public statutVol getStatutVol() {
		return statutVol;
	}


	public void setStatutVol(statutVol statutVol) {
		this.statutVol = statutVol;
	}


	public String getNumeroVol() {
		return numeroVol;
	}


	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}


	public Horaire getHoraire() {
		return horaire;
	}


	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}


	public List<Escale> getEscales() {
		return escales;
	}


	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}


	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}


	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}


	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}


	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}


	public Avion getAvion() {
		return avion;
	}


	public void setAvion(Avion avion) {
		this.avion = avion;
	}


	@Override
	public String toString() {
		return "Vol [id=" + id + ", prix=" + prix + ", lieux=" + lieux + ", statutVol=" + statutVol + ", numeroVol="
				+ numeroVol + ", horaire=" + horaire + ", escales=" + escales + ", aeroportDepart=" + aeroportDepart
				+ ", aeroportArrivee=" + aeroportArrivee + ", avion=" + avion + "]";
	}
	
}
