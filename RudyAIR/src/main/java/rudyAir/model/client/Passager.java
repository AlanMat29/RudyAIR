package rudyAir.model.client;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passager {

	@Column(name = "nomPassager", length = 100)
	private String nom;
	@Column(name = "prenomPassager", length = 100)
	private String prenom;
	@Column(name = "dateDeNaissance_Passager", length = 10)
	private LocalDate dateNaissance;

	
	public Passager() {

	}

	public Passager(String nom, String prenom, LocalDate dateDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Passager [nom=" + this.nom + ", prenom=" + this.prenom + ", dateNaissance=" + this.dateNaissance + "]";
	}
}
