package rudyAir.model.voyage;

public class Avion {
   private String ref;
   private statutAvion statutAvion;
   private Vol vol;

   public Avion(String ref, statutAvion statutAvion, Vol vol) {
      this.ref = ref;
      this.statutAvion = statutAvion;
      this.vol = vol;
   }

   public String getRef() {
      return this.ref;
   }

   public void setRef(String ref) {
      this.ref = ref;
   }

   public statutAvion getStatutAvion() {
      return this.statutAvion;
   }

   public void setStatutAvion(statutAvion statutAvion) {
      this.statutAvion = statutAvion;
   }

   public Vol getVol() {
      return this.vol;
   }

   public void setVol(Vol vol) {
      this.vol = vol;
   }

   public String toString() {
      return "Avion [ref=" + this.ref + ", statutAvion=" + this.statutAvion + ", vol=" + this.vol + "]";
   }
}
