package rudyAir.model.voyage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
@Table(name="vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {
	
	@Id
	@Column(name = "vol_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	private Integer id;
	private LocalDate dateArrivee;
	private LocalDate dateDepart;
	private Aeroport aeroport;
	private VolGenerique volGenerique;
	private Horaire horaire;
    private Avion avion;

   public Vol(Integer id, LocalDate dateArrivee, LocalDate dateDepart, LocalDate dateDepart, Aeroport aeroport, VolGenerique volGenerique, Horaire horaire, Avion avion) {
      this.id = id;
      this.dateArrivee = dateArrivee;
      this.dateDepart = dateDepart;
      this.statutVol = statutVol;
      this.numeroVol = numeroVol;
      this.horaire = horaire;
      this.aeroportDepart = aeroportDepart;
      this.aeroportArrivee = aeroportArrivee;
      this.avion = avion;
   }

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public double getPrix() {
      return this.prix;
   }

   public void setPrix(double prix) {
      this.prix = prix;
   }

   public String getLieux() {
      return this.lieux;
   }

   public void setLieux(String lieux) {
      this.lieux = lieux;
   }

   public StatutVol getStatutVol() {
      return this.statutVol;
   }

   public void setStatutVol(StatutVol statutVol) {
      this.statutVol = statutVol;
   }

   public String getNumeroVol() {
      return this.numeroVol;
   }

   public void setNumeroVol(String numeroVol) {
      this.numeroVol = numeroVol;
   }

   public Horaire getHoraire() {
      return this.horaire;
   }

   public void setHoraire(Horaire horaire) {
      this.horaire = horaire;
   }

   public List<Escale> getEscales() {
      return this.escales;
   }

   public void setEscales(List<Escale> escales) {
      this.escales = escales;
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

   public Avion getAvion() {
      return this.avion;
   }

   public void setAvion(Avion avion) {
      this.avion = avion;
   }

   public String toString() {
      return "Vol [id=" + this.id + ", prix=" + this.prix + ", lieux=" + this.lieux + ", statutVol=" + this.statutVol + ", numeroVol=" + this.numeroVol + ", horaire=" + this.horaire + ", escales=" + this.escales + ", aeroportDepart=" + this.aeroportDepart + ", aeroportArrivee=" + this.aeroportArrivee + ", avion=" + this.avion + "]";
   }
}
