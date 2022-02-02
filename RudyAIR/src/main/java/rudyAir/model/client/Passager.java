package rudyAir.model.client;

import java.time.LocalDate;

public class Passager {
   String nom;
   String prenom;
   LocalDate dateDeNaissance;

   public Passager(String nom, String prenom, LocalDate dateDeNaissance) {
      this.nom = nom;
      this.prenom = prenom;
      this.dateDeNaissance = dateDeNaissance;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getPrenom() {
      return this.prenom;
   }

   public void setPrenom(String prenom) {
      this.prenom = prenom;
   }

   public LocalDate getDateDeNaissance() {
      return this.dateDeNaissance;
   }

   public void setDateDeNaissance(LocalDate dateDeNaissance) {
      this.dateDeNaissance = dateDeNaissance;
   }

   public String toString() {
      return "Passager [nom=" + this.nom + ", prenom=" + this.prenom + ", dateDeNaissance=" + this.dateDeNaissance + "]";
   }
}
