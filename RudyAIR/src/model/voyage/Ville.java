package model.voyage;

import java.util.List;

public class Ville {
	
	private String nom;
	private int cp;
	private List<Aeroport> aeroports;
	
	public Ville(String nom, int cp, List<Aeroport> aeroports) {
		this.nom = nom;
		this.cp = cp;
		this.aeroports = aeroports;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}

	@Override
	public String toString() {
		return "Ville [nom=" + nom + ", cp=" + cp + ", aeroports=" + aeroports + "]";
	}
	

}
