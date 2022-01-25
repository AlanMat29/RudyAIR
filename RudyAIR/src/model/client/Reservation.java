package model.client;

import model.voyage.Aeroport;
import model.voyage.Vol;

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
		return vols;
	}

	public void setVols(Vol vols) {
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
