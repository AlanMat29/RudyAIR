package rudyAir.model.client;

public enum Abonnement {
   sansAbonnement(0.0D),
   Standard(105.0D),
   Premium(210.9D);

   private double prix;

   private Abonnement(double prix) {
      this.prix = prix;
   }

   public double getPrix() {
      return this.prix;
   }
}
