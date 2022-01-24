package model.client;

import java.time.LocalDate;

public class Passager {

	String nom;
	String prenom;
	LocalDate dateDeNaissance;
	
	public Passager(String nom, String prenom, LocalDate dateDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	@Override
	public String toString() {
		return "Passager [nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + "]";
	}
	
	
	
	
}
