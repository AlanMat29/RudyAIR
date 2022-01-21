package model.client;

import java.util.List;

public class SansAbonnement extends Client{

	Abonnement abonnement;
	int bagage=0;
	
	public SansAbonnement(Adresse adresse, Abonnement abonnement, List<Reservation> resa, Abonnement abonnement2,
			int bagage) {
		super(adresse, abonnement, resa);
		abonnement = abonnement2;
		this.bagage = bagage;
	}
	
	
}
