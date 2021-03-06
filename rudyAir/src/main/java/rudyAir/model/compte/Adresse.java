package rudyAir.model.compte;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;

@Embeddable
public class Adresse {
	@Column(length = 5, nullable = true)
	@NotEmpty
	@JsonView(Views.Common.class)
	private String numero;
	@NotEmpty
	@JsonView(Views.Common.class)
	private String voie;
	@NotEmpty
	@JsonView(Views.Common.class)
	private String cp;
	@NotEmpty
	@JsonView(Views.Common.class)
	private String ville;
	@NotEmpty
	@JsonView(Views.Common.class)
	private String pays;

	public Adresse() {

	}

	public Adresse(String numero, String voie, String cp, String ville, String pays) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return this.voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String toString() {
		return "Adresse [numero=" + this.numero + ", voie=" + this.voie + ", cp=" + this.cp + ", ville=" + this.ville
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cp, numero, ville, voie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(cp, other.cp) && numero == other.numero && Objects.equals(ville, other.ville)
				&& Objects.equals(voie, other.voie);
	}

}
