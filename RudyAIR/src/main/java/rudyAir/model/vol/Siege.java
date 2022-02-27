package rudyAir.model.vol;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;
import rudyAir.model.compte.Reservation;

@Entity
@Table(name = "siege")
@SequenceGenerator(name = "seqSiege", sequenceName = "seq_siege", initialValue = 100, allocationSize = 1)
public class Siege {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSiege")
	@JsonView(Views.Common.class)
	private Long id;
	@Column(name = "siege_num")
	@JsonView(Views.Common.class)
	private int numero;
	@OneToOne(mappedBy = "siege", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	private Reservation reservation;
	@ManyToOne
	@JoinColumn(name = "siege_avion_id", foreignKey = @ForeignKey(name = "siege_avion_id_fk"))
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	private Avion avion;

	public Siege() {
	}

	public Siege(Long id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public Siege(int numero, Avion avion) {
		this.numero = numero;
		this.avion = avion;
	}
	
	public Siege(int numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Siege(Long id) {
		super();
		this.id = id;
	}

}
