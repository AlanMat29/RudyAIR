package rudyAir.model.compte;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	private String password;
	@Version
	private int version;
	
	public Compte() {

	}

	public Compte(Long id, String nom, String prenom, LocalDate dateNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}

	public Compte(Long id, String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}
	
	
	//Méthodes
	public static void rechercherTrajet() {
		
	}
	
	public static void reserverTrajet() {
		
	}
	
	public static void acheterBillet() {
		
	}
	
	public static void modifierBillet() {
		
	}
	
	public static void annulerBillet() {
		
	}
	
	public static void consulterVol() {
		
	}
	

	//Getters-Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
