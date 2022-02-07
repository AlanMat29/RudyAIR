
package rudyAir.model.voyage;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqAeroport", sequenceName="seq_aeroport", initialValue = 100, allocationSize = 1)
public class Aeroport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	@Column(name = "aeroport_id")
	private Long Id;
	private String nom;
	private int nbAvion;
	@ManyToOne
	private Ville ville;
	@OneToMany(mappedBy = "aeroportDepart")
	private List<VolGenerique> volsGeneriquesDeparts;

	@OneToMany(mappedBy = "aeroportArrivee")
	private List<VolGenerique> volsGeneriquesArrivees;
	
	public Aeroport() {}

	public Aeroport(Long id, String nom, int nbAvion, Ville ville, List<VolGenerique> volsGeneriquesDeparts,
			List<VolGenerique> volsGeneriquesArrivees) {
		super();
		Id = id;
		this.nom = nom;
		this.nbAvion = nbAvion;
		this.ville = ville;
		this.volsGeneriquesDeparts = volsGeneriquesDeparts;
		this.volsGeneriquesArrivees = volsGeneriquesArrivees;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbAvion() {
		return nbAvion;
	}

	public void setNbAvion(int nbAvion) {
		this.nbAvion = nbAvion;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<VolGenerique> getVolsGeneriquesDeparts() {
		return volsGeneriquesDeparts;
	}

	public void setVolsGeneriquesDeparts(List<VolGenerique> volsGeneriquesDeparts) {
		this.volsGeneriquesDeparts = volsGeneriquesDeparts;
	}

	public List<VolGenerique> getVolsGeneriquesArrivees() {
		return volsGeneriquesArrivees;
	}

	public void setVolsGeneriquesArrivees(List<VolGenerique> volsGeneriquesArrivees) {
		this.volsGeneriquesArrivees = volsGeneriquesArrivees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroport other = (Aeroport) obj;
		return Objects.equals(Id, other.Id);
	}

	
}
