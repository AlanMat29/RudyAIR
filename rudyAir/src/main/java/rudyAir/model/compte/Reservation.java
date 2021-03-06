package rudyAir.model.compte;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;
import rudyAir.model.vol.Vol;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 100, allocationSize = 1)
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@JsonView(Views.Common.class)
	private Long id;
	@JsonView({ Views.Reservation.class, Views.SiegeWithReservationAndAvion.class,
			Views.CompteClientWithReservation.class })
	private boolean statut;
	@DecimalMin("0")
	@JsonView({ Views.Reservation.class, Views.SiegeWithReservationAndAvion.class,
			Views.CompteClientWithReservation.class })
	private Integer animaux;
	@DecimalMin("0")
	@JsonView({ Views.Reservation.class, Views.SiegeWithReservationAndAvion.class,
			Views.CompteClientWithReservation.class })
	private int bagage;
	@JsonView({ Views.Reservation.class, Views.SiegeWithReservationAndAvion.class,
			Views.CompteClientWithReservation.class })
	private String siege;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "resa_passager_id", foreignKey = @ForeignKey(name = "resa_passager_id_fk"), nullable = false)
	@JsonView({ Views.Reservation.class, Views.SiegeWithReservationAndAvion.class,
			Views.CompteClientWithReservation.class })
	private Passager passager;
	@ManyToOne
	@JoinColumn(name = "resa_vol_id", foreignKey = @ForeignKey(name = "resa_vol_id_fk"), nullable = false)
	@JsonView({ Views.Reservation.class, Views.CompteClientWithReservation.class })
	private Vol vol;

	@ManyToOne
	@JoinColumn(name = "resa_client_id", foreignKey = @ForeignKey(name = "resa_client_id_fk"), nullable = false)
	@JsonView(Views.Reservation.class)
	private Client client;

	@Version
	private int version;

	public Reservation() {
	}

	public Reservation(Long id, Vol vol, Passager passager, Client client, boolean statut,
			@DecimalMin("0") Integer animaux, @DecimalMin("0") int bagage, String siege) {
		super();
		this.id = id;
		this.vol = vol;
		this.passager = passager;
		this.client = client;
		this.statut = statut;
		this.animaux = animaux;
		this.bagage = bagage;
		this.siege = siege;
	}

	public Reservation(Vol vol, Passager passager, Client client, boolean statut, @DecimalMin("0") Integer animaux,
			@DecimalMin("0") int bagage, String siege) {
		super();
		this.vol = vol;
		this.passager = passager;
		this.client = client;
		this.statut = statut;
		this.animaux = animaux;
		this.bagage = bagage;
		this.siege = siege;
	}

	public Reservation(Vol vol, Passager passager, Client client, boolean statut, @DecimalMin("0") Integer animaux,
			@DecimalMin("0") int bagage) {
		super();
		this.vol = vol;
		this.passager = passager;
		this.client = client;
		this.statut = statut;
		this.animaux = animaux;
		this.bagage = bagage;
	}

	public String getSiege() {
		return siege;
	}

	public void setSiege(String siege) {
		this.siege = siege;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", statut=" + statut + ", animaux=" + animaux + ", bagage=" + bagage
				+ ", siege=" + siege + ", passager=" + passager + ", vol=" + vol + ", client=" + client + ", version="
				+ version + "]";
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
