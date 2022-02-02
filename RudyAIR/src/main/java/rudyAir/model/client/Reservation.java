package rudyAir.model.client;

import rudyAir.model.voyage.Aeroport;
import rudyAir.model.voyage.Vol;

public class Reservation {
   Vol vols;
   Aeroport aeroport;
   Integer animaux;
   int bagage;
   boolean statut;

   public Reservation(Vol vols, Aeroport aeroport, Integer animaux, int bagage, boolean statut) {
      this.vols = vols;
      this.aeroport = aeroport;
      this.animaux = animaux;
      this.bagage = bagage;
      this.statut = statut;
   }

   public Vol getVols() {
      return this.vols;
   }

   public void setVols(Vol vols) {
      this.vols = vols;
   }

   public Aeroport getAeroport() {
      return this.aeroport;
   }

   public void setAeroport(Aeroport aeroport) {
      this.aeroport = aeroport;
   }

   public Integer getAnimaux() {
      return this.animaux;
   }

   public void setAnimaux(Integer animaux) {
      this.animaux = animaux;
   }

   public int getBagage() {
      return this.bagage;
   }

   public void setBagage(int bagage) {
      this.bagage = bagage;
   }

   public boolean isStatut() {
      return this.statut;
   }

   public void setStatut(boolean statut) {
      this.statut = statut;
   }

   public String toString() {
      return "Reservation [vols=" + this.vols + ", aeroport=" + this.aeroport + ", animaux=" + this.animaux + ", bagage=" + this.bagage + ", statut=" + this.statut + "]";
   }
}
