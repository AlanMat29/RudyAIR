package rudyAir.model.voyage;

import java.util.List;

public class Ville {
   private String nom;
   private int cp;
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
