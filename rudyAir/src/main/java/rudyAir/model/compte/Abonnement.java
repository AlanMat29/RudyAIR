package rudyAir.model.compte;

public enum Abonnement {
	sansAbonnement(0), abonnementConfort(105), abonnementPremium(210.9);

	private double prix;

	private Abonnement(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return this.prix;
	}
}
