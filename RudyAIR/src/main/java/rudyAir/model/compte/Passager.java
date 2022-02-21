package rudyAir.model.compte;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
public class Passager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@JsonView(Views.Common.class)
	private Long id;
	@Length(min = 1, max = 100)
	@Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$")
	@NotEmpty
	@JsonView(Views.Common.class)
	private String nom;
	@Length(min = 1, max = 100)
	@Pattern(regexp = "^[a-zA-Z]((-|')?([a-zA-Z]{1,}))*$")
	@NotEmpty
	@JsonView(Views.Common.class)
	private String prenom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@JsonView(Views.Common.class)
	private LocalDate dateDeNaissance;
	@OneToOne(mappedBy = "passager")
	@JsonView(Views.Common.class)
	private Reservation reservation;

	@Version
	private int version;

	public Passager() {
	}

	public Passager(Long id, String nom, String prenom, LocalDate dateDeNaissance, Reservation reservation) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.reservation = reservation;
	}
	
	public Passager(String nom, String prenom, LocalDate dateDeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
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

	public LocalDate getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
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
		Passager other = (Passager) obj;
		return Objects.equals(id, other.id);
	}

}
