package rudyAir.model.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
public class Client {

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "cnumber", length = 50)),
		@AttributeOverride(name = "rue", column = @Column(name = "cstreet", length = 200)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "czipcode", length = 5)),
		@AttributeOverride(name = "ville", column = @Column(name ="ccity", length = 100)) })
	private Adresse adresse;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Abonnement")
	private Abonnement abonnement;
	@OneToMany(mappedBy = "Client")
	private List<Reservation> resa = new ArrayList();
	

	public Client() {
		
	}

	public Client(Adresse adresse, Abonnement abonnement, List<Reservation> resa) {
		this.adresse = adresse;
		this.abonnement = abonnement;
		this.resa = resa;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Abonnement getAbonnement() {
		return this.abonnement;
	}

	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}

	public List<Reservation> getResa() {
		return this.resa;
	}

	public void setResa(List<Reservation> resa) {
		this.resa = resa;
	}

	@Override
	public String toString() {
		return "Client [adresse=" + adresse + ", abonnement=" + abonnement + ", resa=" + resa + "]";
	}
	
	
	
}


