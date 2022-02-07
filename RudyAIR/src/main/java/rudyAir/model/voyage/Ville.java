package rudyAir.model.voyage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="seqVille", sequenceName="seq_ville", initialValue = 100, allocationSize = 1)
public class Ville {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	@Column(name = "ville_id")
	private Long Id;
	private String nom;
	private int cp;
	@OneToMany(mappedBy = "ville")
	private List<Aeroport> aeroports;


	public Ville(String nom, int cp, List<Aeroport> aeroports) {
		this.nom = nom;
		this.cp = cp;
		this.aeroports = aeroports;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public List<Aeroport> getAeroports() {
		return this.aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	public String toString() {
		return "Ville [nom=" + this.nom + ", cp=" + this.cp + ", aeroports=" + this.aeroports + "]";
	}
}
