package rudyAir.model.vol;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;


@Entity
@SequenceGenerator(name="seqVille", sequenceName="seq_ville", initialValue = 100, allocationSize = 1)
public class Ville {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	private Long Id;
	@Length(min = 1, max = 50)
	@NotEmpty
	@JsonView(Views.Common.class)
	private String nom;
	@NotEmpty
	@JsonView(Views.Common.class)
	private String cp;
	@OneToMany(mappedBy = "ville")
	@JsonView(Views.VilleWithAeroports.class)
	private List<Aeroport> aeroports;
	@Version
	private int version;


	public Ville() {
		
	}
	

	public Ville(Long id, String nom, String cp, List<Aeroport> aeroports) {
		super();
		Id = id;
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

	
	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public List<Aeroport> getAeroports() {
		return this.aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
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
		Ville other = (Ville) obj;
		return Objects.equals(Id, other.Id);
	}


	
}
