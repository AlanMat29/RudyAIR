package rudyAir.model.vol;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@Table(name = "avion")
@SequenceGenerator(name = "seqAvion", sequenceName = "seq_avion", initialValue = 100, allocationSize = 1)

public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvion")
	@JsonView(Views.Common.class)
	private Long id;
	@Column(length = 10, nullable = false)
	@JsonView(Views.Common.class)
	private String ref;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	@JsonView(Views.Common.class)
	private StatutAvion statutAvion;
	@OneToOne(mappedBy = "avion")
	private Vol vol;
	@JsonView(Views.AvionWithSiege.class)
	@OneToMany(mappedBy = "avion")
	private Set<Siege> sieges;

	@Version
	private int version;

	public Avion() {
	}

	public Avion(Long id, String ref, StatutAvion statutAvion, Vol vol, Set<Siege> sieges) {
		super();
		this.id = id;
		this.ref = ref;
		this.statutAvion = statutAvion;
		this.vol = vol;
		this.sieges = sieges;
	}

	public Avion(String ref, StatutAvion statutAvion, Set<Siege> sieges) {
		super();
		this.ref = ref;
		this.statutAvion = statutAvion;
		this.sieges = sieges;
	}

	public Avion(String ref, StatutAvion statutAvion) {
		super();
		this.ref = ref;
		this.statutAvion = statutAvion;
	}

	public Set<Siege> getSieges() {
		return sieges;
	}

	public void setSieges(Set<Siege> sieges) {
		this.sieges = sieges;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Avion other = (Avion) obj;
		return Objects.equals(id, other.id);
	}

}
