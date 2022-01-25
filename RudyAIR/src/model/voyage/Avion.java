package model.voyage;

public class Avion {
	
	private String ref;
	private statutAvion statutAvion;
	private Vol vol;
	
	
	public Avion(String ref, model.voyage.statutAvion statutAvion, Vol vol) {
		this.ref = ref;
		this.statutAvion = statutAvion;
		this.vol = vol;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public statutAvion getStatutAvion() {
		return statutAvion;
	}


	public void setStatutAvion(statutAvion statutAvion) {
		this.statutAvion = statutAvion;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	@Override
	public String toString() {
		return "Avion [ref=" + ref + ", statutAvion=" + statutAvion + ", vol=" + vol + "]";
	}
	
	
	
	
}
