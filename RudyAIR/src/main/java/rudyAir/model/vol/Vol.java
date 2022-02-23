package rudyAir.model.vol;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.model.Views;
import rudyAir.model.compte.Reservation;

@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "vol_id")
	@JsonView({Views.Common.class, Views.ReservationPassagerWithVol.class})
	private Long id;
	@Column(name = "vol_date_depart")
	@JsonView({Views.ReservationPassagerWithVol.class})
	private LocalDate dateDepart;
	@Column(name = "vol_date_arrivee")
	@JsonView({Views.ReservationPassagerWithVol.class})
	private LocalDate dateArrivee;
	@Enumerated(EnumType.STRING)
	@Column(name = "vol_statut")
	@JsonView(Views.Common.class)
	private StatutVol statutVol;
	@Column(name = "vol_numero")
	@JsonView(Views.Common.class)
	private String numeroVol;
	@OneToOne
	@JoinColumn(name = "vol_volGen_id", foreignKey = @ForeignKey(name = "vol_volGen_id_fk"))
	private VolGenerique volGenerique;
	@OneToOne
	@JoinColumn(name = "vol_avion_id", foreignKey = @ForeignKey(name = "vol_avion_id_fk"))
	private Avion avion;
	@OneToMany(mappedBy = "vol")
	private List<Reservation> reservations;
	@Version
	private int version;

	public Vol() {
	}

	public Vol(Long id, LocalDate dateDepart, LocalDate dateArrivee, StatutVol statutVol, String numeroVol,
			VolGenerique volGenerique, Avion avion, List<Reservation> reservations) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.statutVol = statutVol;
		this.numeroVol = numeroVol;
		this.volGenerique = volGenerique;
		this.avion = avion;
		this.reservations = reservations;
	}

	public Vol(LocalDate dateDepart, LocalDate dateArrivee, StatutVol statutVol, String numeroVol,
			VolGenerique volGenerique, Avion avion) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.statutVol = statutVol;
		this.numeroVol = numeroVol;
		this.volGenerique = volGenerique;
		this.avion = avion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public StatutVol getStatutVol() {
		return statutVol;
	}

	public void setStatutVol(StatutVol statutVol) {
		this.statutVol = statutVol;
	}

	public String getNumeroVol() {
		return numeroVol;
	}

	public void setNumeroVol(String numeroVol) {
		this.numeroVol = numeroVol;
	}

	public VolGenerique getVolGenerique() {
		return volGenerique;
	}

	public void setVolGenerique(VolGenerique volGenerique) {
		this.volGenerique = volGenerique;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Vol other = (Vol) obj;
		return Objects.equals(id, other.id);
	}

}
