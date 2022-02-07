package rudyAir.model.voyage;

import java.util.List;

public class Vol {
   private Integer id;
   private double prix;
   private String lieux;
   private StatutVol statutVol;
   private String numeroVol;
   private Horaire horaire;
   private List<Escale> escales;
   private Aeroport aeroportDepart;
   private Aeroport aeroportArrivee;
   private Avion avion;

   public Vol(Integer id, double prix, String lieux, StatutVol statutVol, String numeroVol, Horaire horaire, List<Escale> escales, Aeroport aeroportDepart, Aeroport aeroportArrivee, Avion avion) {
      this.id = id;
      this.prix = prix;
      this.lieux = lieux;
      this.statutVol = statutVol;
      this.numeroVol = numeroVol;
      this.horaire = horaire;
      this.escales = escales;
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
