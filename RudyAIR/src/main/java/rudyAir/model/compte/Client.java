package rudyAir.model.compte;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {

	@Embedded
	private Adresse adresse;
	@Enumerated(EnumType.ORDINAL)
	private Abonnement abonnement;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList<Reservation>();


	public Client() {}

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
