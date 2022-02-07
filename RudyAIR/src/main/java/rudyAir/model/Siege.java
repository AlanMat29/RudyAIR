package rudyAir.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "siege")
public class Siege {
	
	@EmbeddedId
	private SiegeKey id;
	@Column(name="siege_num")
	private int numero;
	
	public Siege() {}

	public Siege(SiegeKey id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public SiegeKey getId() {
		return id;
	}

	public void setId(SiegeKey id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Siege other = (Siege) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
