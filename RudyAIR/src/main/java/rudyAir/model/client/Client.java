package rudyAir.model.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import rudyAir.model.Compte;

@Entity
public class Client extends Compte{

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "cnumber", length = 50)),
		@AttributeOverride(name = "rue", column = @Column(name = "cstreet", length = 200)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "czipcode", length = 5)),
		@AttributeOverride(name = "ville", column = @Column(name ="ccity", length = 100)) })
	private Adresse adresse;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Abonnement")
	private Abonnement abonnement;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList();


	public Client() {

	}


	public Client(Adresse adresse, Abonnement abonnement, List<Reservation> reservations) {
		super();
		this.adresse = adresse;
		this.abonnement = abonnement;
		this.reservations = reservations;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Abonnement getAbonnement() {
		return abonnement;
	}


	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}





}


