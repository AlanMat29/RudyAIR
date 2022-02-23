package rudyAir.model.compte;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@Table(name = "compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "compte", discriminatorType = DiscriminatorType.STRING, length = 15)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView(Views.Common.class)
	private Long id;
	@JsonView(Views.Common.class)
	@NotEmpty
	@Column(length = 50, nullable = false)
	private String nom;
	@JsonView(Views.Common.class)
	@NotEmpty
	@Column(length = 50, nullable = false)
	private String prenom;
	@JsonView(Views.Common.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateNaissance;
	@JsonView(Views.Common.class)
	//@NotEmpty
	@Column(length = 50, nullable = false, unique = true)
	@Email
	private String email;
	private String password;
	@Version
	private int version;

	public Compte() {

	}

	public Compte(Long id, String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}

	public Compte(String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
	}
	

	// Getters-Setters
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
