package model.voyage;

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
		return horaire;
	}


	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	public Aeroport getAeroport() {
		return aeroport;
	}


	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}


	@Override
	public String toString() {
		return "Escale [horaire=" + horaire + ", vol=" + vol + ", aeroport=" + aeroport + "]";
	}
	

}
