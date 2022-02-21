package rudyAir.model.vol;

import java.time.LocalTime;

import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class Horaire {
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime heureDepart;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime heureArrivee;


	public Horaire() {
		
	}
 


	public Horaire(LocalTime heureDepart, LocalTime heureArrivee) {
		super();
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}


	public LocalTime getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}


	public LocalTime getHeureArrivee() {
		return heureArrivee;
	}


	public void setHeureArrivee(LocalTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}



}
