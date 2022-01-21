package model.client;

public enum Abonnement {

	sansAbonnement(0),Standard(105),Premium(210.90);
	
	private double prix;
	
	private Abonnement(double prix)
	{
		this.prix=prix;
	}
	public double getPrix()
	{
		return prix;
	}
}