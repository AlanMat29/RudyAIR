package rudyAir.model.voyage;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "volGenerique")
@SequenceGenerator(name = "seqVolGen", sequenceName = "seq_volGen", initialValue = 100, allocationSize = 1)
public class VolGenerique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVolGen")
	@Column(name = "volGen_no")
	private Long id;
	@Column(name = "volGen_prix")
	private double prix;
	@Column(name = "volGen_name")
	private String numVolGen;
	@Embedded
	private Horaire horaire;
	@Embedded
	private Aeroport aeroport;
	@Column(name = "volGen_vol")
	@OneToOne(mappedBy = "volGen")
	private Vol vol;

	public VolGenerique() {

	}

	public VolGenerique(Integer id, double prix, String numVolGen, Horaire horaire, Aeroport aeroport,
			Aeroport aeroportArrivee, Avion avion) {
		this.prix = prix;
		this.numVolGen = numVolGen;
		this.horaire = horaire;
		this.aeroport = aeroport;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getnumVolGen() {
		return this.numVolGen;
	}

	public void setnumVolGen(String numVolGen) {
		this.numVolGen = numVolGen;
	}

	public Horaire getHoraire() {
		return this.horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aeroport, horaire, id, numVolGen, prix, vol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VolGenerique other = (VolGenerique) obj;
		return Objects.equals(aeroport, other.aeroport) && Objects.equals(horaire, other.horaire)
				&& Objects.equals(id, other.id) && Objects.equals(numVolGen, other.numVolGen)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix)
				&& Objects.equals(vol, other.vol);
	}

	

	

}
