package modelClient;

import model.Aeroport;
import model.Vols;

public class Reservation {

	Vols vols;
	Aeroport aeroport;
	Integer animaux;
	int bagage;
	boolean statut;
	
	public Reservation(Vols vols, Aeroport aeroport, Integer animaux, int bagage, boolean statut) {
		this.vols = vols;
		this.aeroport = aeroport;
		this.animaux = animaux;
		this.bagage = bagage;
		this.statut = statut;
	}

	public Vols getVols() {
		return vols;
	}

	public void setVols(Vols vols) {
		this.vols = vols;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Integer getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Integer animaux) {
		this.animaux = animaux;
	}

	public int getBagage() {
		return bagage;
	}

	public void setBagage(int bagage) {
		this.bagage = bagage;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Reservation [vols=" + vols + ", aeroport=" + aeroport + ", animaux=" + animaux + ", bagage=" + bagage
				+ ", statut=" + statut + "]";
	}
	
	
	
}
