package model.client;

import java.util.ArrayList;
import java.util.List;

public class Client {

	Adresse adresse;
	Abonnement abonnement;
	List<Reservation> resa = new ArrayList();
	
	public Client(Adresse adresse, Abonnement abonnement, List<Reservation> resa) {
		this.adresse = adresse;
		this.abonnement = abonnement;
		this.resa = resa;
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

	public List<Reservation> getResa() {
		return resa;
	}

	public void setResa(List<Reservation> resa) {
		this.resa = resa;
	}
	
	
}
