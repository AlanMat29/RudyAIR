package rudyAir.model.vol;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Horaire {
	private LocalDate heureDepart;
	private LocalDate heureArrivee;


	public Horaire() {}


	public Horaire(LocalDate heureDepart, LocalDate heureArrivee) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}


	public LocalDate getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(LocalDate heureDepart) {
		this.heureDepart = heureDepart;
	}


	public LocalDate getHeureArrivee() {
		return heureArrivee;
	}


	public void setHeureArrivee(LocalDate heureArrivee) {
		this.heureArrivee = heureArrivee;
	}



}
