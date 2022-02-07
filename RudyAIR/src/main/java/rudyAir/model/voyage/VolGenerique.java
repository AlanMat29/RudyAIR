package rudyAir.model.voyage;

import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name ="volGenerique")
@SequenceGenerator(name= "seqVolGen", sequenceName = "seq_volGen", initialValue = 100, allocationSize = 1)
public class VolGenerique {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVolGen")
	@Column(name = "volGen_no")
   private Long id;
	@Column(name = "volGen_prix")
   private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "statuvol", length=10)
	private StatutVol statutVol;
	@Column(name = "volGen_name")
   private String numVolGen;
	@Column(name = "volGen_time")
   private Horaire horaire;
	@Column(name = "aeroDept")
   private Aeroport aeroportDepart;
	@Column(name = "aeroArr")
   private Aeroport aeroportArrivee;
	@Column(name = "refno")
	@OneToOne(mappedBy= "vol_volGen")
	private Vol vol;

   public VolGenerique() {
	   
   }
   
   public VolGenerique(Integer id, double prix, String lieux, StatutVol statutVol, String numVolGen, Horaire horaire, Aeroport aeroportDepart, Aeroport aeroportArrivee, Avion avion) {
      this.prix = prix;
      this.statutVol = statutVol;
      this.numVolGen = numVolGen;
      this.horaire = horaire;
      this.aeroportDepart = aeroportDepart;
      this.aeroportArrivee = aeroportArrivee;
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

   public StatutVol getStatutVol() {
      return this.statutVol;
   }

   public void setStatutVol(StatutVol statutVol) {
      this.statutVol = statutVol;
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

   public Aeroport getAeroportDepart() {
      return this.aeroportDepart;
   }

   public void setAeroportDepart(Aeroport aeroportDepart) {
      this.aeroportDepart = aeroportDepart;
   }

   public Aeroport getAeroportArrivee() {
      return this.aeroportArrivee;
   }

   public void setAeroportArrivee(Aeroport aeroportArrivee) {
      this.aeroportArrivee = aeroportArrivee;
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
	return Objects.equals(aeroportArrivee, other.aeroportArrivee)
			&& Objects.equals(aeroportDepart, other.aeroportDepart) && Objects.equals(horaire, other.horaire)
			&& Objects.equals(id, other.id) && Objects.equals(numVolGen, other.numVolGen)
			&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix) && statutVol == other.statutVol
			&& Objects.equals(vol, other.vol);
}




   
}
