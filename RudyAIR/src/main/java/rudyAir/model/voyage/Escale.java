package rudyAir.model.voyage;
public class Escale {
   Horaire horaire;
   Vol vol;
   Aeroport aeroport;

   public Escale(Horaire horaire, Vol vol, Aeroport aeroport) {
      this.horaire = horaire;
      this.vol = vol;
      this.aeroport = aeroport;
   }

   public Horaire getHoraire() {
      return this.horaire;
   }

   public void setHoraire(Horaire horaire) {
      this.horaire = horaire;
   }

   public Vol getVol() {
      return this.vol;
   }

   public void setVol(Vol vol) {
      this.vol = vol;
   }

   public Aeroport getAeroport() {
      return this.aeroport;
   }

   public void setAeroport(Aeroport aeroport) {
      this.aeroport = aeroport;
   }

   public String toString() {
      return "Escale [horaire=" + this.horaire + ", vol=" + this.vol + ", aeroport=" + this.aeroport + "]";
   }
}
