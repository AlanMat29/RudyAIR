package rudyAir.model.vol;

public enum StatutAvion {
	enVol("en Vol"),enMaintenance("en Maintenance"),auSol("au Sol");
	
	private String titre;

	private StatutAvion(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}
	
	
}
