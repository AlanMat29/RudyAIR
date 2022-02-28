package rudyAir.model.vol;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;
import rudyAir.model.compte.Reservation;

@SuppressWarnings("serial")
@Embeddable
public class SiegeKey implements Serializable {

	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "siege_resa_id", foreignKey = @ForeignKey(name = "siege_resa_id_fk"))
	@JsonView(Views.Common.class)
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name = "siege_avion_id", foreignKey = @ForeignKey(name = "siege_avion_id_fk"))
	@JsonView(Views.Common.class)
	private Avion avion;

	public SiegeKey() {
	}

	public SiegeKey(Reservation reservation, Avion avion) {
		super();
		this.reservation = reservation;
		this.avion = avion;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avion, reservation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiegeKey other = (SiegeKey) obj;
		return Objects.equals(avion, other.avion) && Objects.equals(reservation, other.reservation);
	}

}
