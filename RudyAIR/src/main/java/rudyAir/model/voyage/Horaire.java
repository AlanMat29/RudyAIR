package rudyAir.model.voyage;

import java.time.LocalDate;

public class Horaire {
   private LocalDate dateDepart;
   private LocalDate dateArrivee;
   private LocalDate heureDepart;
   private LocalDate heureArrivee;
   private LocalDate duree;

   public Horaire(LocalDate dateDepart, LocalDate dateArrivee, LocalDate heureDepart, LocalDate heureArrivee, LocalDate duree) {
      this.dateDepart = dateDepart;
      this.dateArrivee = dateArrivee;
      this.heureDepart = heureDepart;
      this.heureArrivee = heureArrivee;
      this.duree = duree;
   }

   public LocalDate getDateDepart() {
      return this.dateDepart;
   }

   public void setDateDepart(LocalDate dateDepart) {
      this.dateDepart = dateDepart;
   }

   public LocalDate getDateArrivee() {
      return this.dateArrivee;
   }

   public void setDateArrivee(LocalDate dateArrivee) {
      this.dateArrivee = dateArrivee;
   }

   public LocalDate getHeureDepart() {
      return this.heureDepart;
   }

   public void setHeureDepart(LocalDate heureDepart) {
      this.heureDepart = heureDepart;
   }

   public LocalDate getHeureArrivee() {
      return this.heureArrivee;
   }

   public void setHeureArrivee(LocalDate heureArrivee) {
      this.heureArrivee = heureArrivee;
   }

   public LocalDate getDuree() {
      return this.duree;
   }

   public void setDuree(LocalDate duree) {
      this.duree = duree;
   }

   public String toString() {
      return "Horaire [dateDepart=" + this.dateDepart + ", dateArrivee=" + this.dateArrivee + ", heureDepart=" + this.heureDepart + ", heureArrivee=" + this.heureArrivee + ", duree=" + this.duree + "]";
   }
}
