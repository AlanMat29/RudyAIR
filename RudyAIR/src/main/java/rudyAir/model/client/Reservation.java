package rudyAir.model.client;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import rudyAir.model.voyage.Vol;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue=100, allocationSize = 1)
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqReservation")
	private Long id;
	@ManyToOne
	//@JoinColumn(name="resa_vol_id", foreignKey=@ForeignKey(name="resa_vol_id_fk"), nullable=false)
	private Vol vol;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name="nom", column=@Column(name="passager_nom", length = 50)),
			@AttributeOverride(name="prenom", column=@Column(name="passager_prenom", length = 50)),
			@AttributeOverride(name="dateDeNaissance", column = @Column(name="passager_dateDeNaissance", length = 100))})
	private Passager passager;
	@ManyToOne
	private Client client;
	@Column
	private Integer animaux;
	@Column
	private int bagage;
	@Column(nullable = false)
	private boolean statut;
	
	
	public Reservation() {}


	public Reservation(Long id, Vol vol, Passager passager, Integer animaux, int bagage, boolean statut) {
		super();
		this.id = id;
		this.vol = vol;
		this.passager = passager;
		this.animaux = animaux;
		this.bagage = bagage;
		this.statut = statut;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
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

	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
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
		Reservation other = (Reservation) obj;
		return Objects.equals(id, other.id);
	}


}
