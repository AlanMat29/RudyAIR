package rudyAir.model.vol;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Entity
@Table(name = "vol_generique")
@SequenceGenerator(name = "seqVolGen", sequenceName = "seq_volGen", initialValue = 100, allocationSize = 1)
public class VolGenerique {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVolGen")
	@JsonView(Views.Common.class)
	@Column(name = "volGen_id")
	private Long id;
	@Column(name = "volGen_prix")
	@JsonView(Views.Common.class)
	private double prix;
	@JsonView(Views.Common.class)
	@Column(name = "volGen_num")
	private String numVolGen;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "heureDepart", column = @Column(name = "volGen_heuredepart")),
			@AttributeOverride(name = "heureArrivee", column = @Column(name = "volGen_heurearrivee")) })
	@JsonView({Views.VolGeneneriqueWithHoraire.class, Views.Vol.class})
	private Horaire horaire;
	@ManyToOne
	@JoinColumn(name = "volGen_aeroportDepart_id", foreignKey = @ForeignKey(name = "volGen_aeroportDepart_id_fk"), nullable = false)
	@JsonView({ Views.VolGeneneriquetWithAeroport.class, Views.VolWithAeroport.class,  Views.Vol.class })
	private Aeroport aeroportDepart;
	@ManyToOne
	@JoinColumn(name = "volGen_aeroportArrivee_id", foreignKey = @ForeignKey(name = "volGen_aeroportArrivee_id_fk"), nullable = false)
	@JsonView({ Views.VolGeneneriquetWithAeroport.class, Views.VolWithAeroport.class,  Views.Vol.class })
	private Aeroport aeroportArrivee;
	@OneToOne(mappedBy = "volGenerique")
	private Vol vol;

	@Version
	private int version;

	public VolGenerique() {

	}

	public VolGenerique(Long id, double prix, String numVolGen, Horaire horaire, Aeroport aeroportDepart,
			Aeroport aeroportArrivee, Vol vol) {
		super();
		this.id = id;
		this.prix = prix;
		this.numVolGen = numVolGen;
		this.horaire = horaire;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.vol = vol;
	}

	public VolGenerique(double prix, String numVolGen, Horaire horaire, Aeroport aeroportDepart,
			Aeroport aeroportArrivee) {
		super();
		this.prix = prix;
		this.numVolGen = numVolGen;
		this.horaire = horaire;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNumVolGen() {
		return numVolGen;
	}

	public void setNumVolGen(String numVolGen) {
		this.numVolGen = numVolGen;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VolGenerique [id=" + id + ", prix=" + prix + ", numVolGen=" + numVolGen + ", horaire=" + horaire
				+ ", aeroportDepart=" + aeroportDepart + ", aeroportArrivee=" + aeroportArrivee + ", vol=" + vol
				+ ", version=" + version + "]";
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
		VolGenerique other = (VolGenerique) obj;
		return Objects.equals(id, other.id);
	}

}
