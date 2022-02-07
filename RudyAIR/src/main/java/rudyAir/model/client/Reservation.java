package rudyAir.model.client;

import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import rudyAir.model.voyage.Aeroport;
import rudyAir.model.voyage.Vol;


@Entity
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_resa")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	private Long id;
	@ManyToOne
	private Client client;
	@Embedded
	private Vol vols;
	@Embedded
	private Aeroport aeroport;
	@Embedded
	private Integer animaux;
	@Embedded
	private Siege siege;
	private int bagage;
	private boolean statut;


	public Reservation() {

	}

	public Reservation(Vol vols, Aeroport aeroport, Integer animaux, int bagage, boolean statut) {
		this.vols = vols;
		this.aeroport = aeroport;
		this.animaux = animaux;
		this.bagage = bagage;
		this.statut = statut;
	}

	public Vol getVols() {
		return this.vols;
	}

	public void setVols(Vol vols) {
		this.vols = vols;
	}

	public Aeroport getAeroport() {
		return this.aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Integer getAnimaux() {
		return this.animaux;
	}

	public void setAnimaux(Integer animaux) {
		this.animaux = animaux;
	}

	public int getBagage() {
		return this.bagage;
	}

	public void setBagage(int bagage) {
		this.bagage = bagage;
	}

	public boolean isStatut() {
		return this.statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	@Override
	public String toString() {
		return "Reservation [vols=" + this.vols + ", aeroport=" + this.aeroport + ", animaux=" + this.animaux + ", bagage=" + this.bagage + ", statut=" + this.statut + "]";
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
