package model.voyage;

import java.util.List;

public class Aeroport {
	
	private String nom;
	private int nbAvion;
	private Ville ville;
	private List<Vol> vols;
	
	public Aeroport(String nom, int nbAvion, Ville ville, List<Vol> vols) {
		this.nom = nom;
		this.nbAvion = nbAvion;
		this.ville = ville;
		this.vols = vols;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbAvion() {
		return nbAvion;
	}

	public void setNbAvion(int nbAvion) {
		this.nbAvion = nbAvion;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Vol> getVols() {
		return vols;
	}

	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}

	@Override
	public String toString() {
		return "Aeroport [nom=" + nom + ", nbAvion=" + nbAvion + ", ville=" + ville + ", vols=" + vols + "]";
	}
	
}
