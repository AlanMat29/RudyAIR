package rudyAir.model.voyage;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="avion")
@SequenceGenerator(name = "seqAvion", sequenceName = "seq_avion", initialValue = 100, allocationSize = 1)

public class Avion {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@Column(name = "refno")
	private Long id;
	@Column(name = "refname", length= 10, nullable=false)
	private String ref;
	@Enumerated(EnumType.STRING)
	@Column(name = "statutAvion", length=10)
	private StatutAvion statutAvion;
	@Column(name = "refVol")
	@OneToOne(mappedBy= "vol_avion")
	private Vol vol;
	



	public Avion() {

	}

	public Avion(String ref, StatutAvion statutAvion, Vol vol) {
		this.ref = ref;
		this.statutAvion = statutAvion;
		this.vol = vol;
	}

	public String getRef() {
		return this.ref;
	}	

	public void setRef(String ref) {
		this.ref = ref;
	}

	public StatutAvion getStatutAvion() {
		return this.statutAvion;
	}

	public void setStatutAvion(StatutAvion statutAvion) {
		this.statutAvion = statutAvion;
	}

	public Vol getVol() {
		return this.vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public String toString() {
		return "Avion [ref=" + this.ref + ", statutAvion=" + this.statutAvion + ", vol=" + this.vol + "]";
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
		Avion other = (Avion) obj;
		return Objects.equals(id, other.id) && Objects.equals(ref, other.ref) && statutAvion == other.statutAvion
				&& Objects.equals(vol, other.vol);
	}
	
	
}
