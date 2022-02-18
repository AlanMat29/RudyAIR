
package rudyAir.model.vol;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@SequenceGenerator(name="seqAeroport", sequenceName="seq_aeroport", initialValue = 100, allocationSize = 1)
public class Aeroport {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	private Long Id;
	@Length(min = 1, max = 50)
	@NotEmpty
	@JsonView(Views.Common.class)
	@Column(unique = true)
	private String nom;
	@ManyToOne
	@JoinColumn(name="ville_id", foreignKey=@ForeignKey(name="aeroport_ville_id_fk"))
	@JsonView(Views.AeroportWithVille.class)
	private Ville ville;
	@OneToMany(mappedBy = "aeroportDepart")
	@JsonView(Views.AeroportWithVolsGeneneriquesDeparts.class)
	private List<VolGenerique> volsGeneriquesDeparts;
	@OneToMany(mappedBy = "aeroportArrivee")
	@JsonView(Views.AeroportWithVolsGeneneriquesArrivees.class)
	private List<VolGenerique> volsGeneriquesArrivees;
	@Version
	private int version;

	public Aeroport() {
		
	}

	public Aeroport(Long id, String nom, Ville ville, List<VolGenerique> volsGeneriquesDeparts,
			List<VolGenerique> volsGeneriquesArrivees) {
		super();
		Id = id;
		this.nom = nom;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
