package rudyAir.model.voyage;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {
	
	@Id
	@Column(name = "vol_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	private Long id;
	@Column(name = "date_arrivee")
	private LocalDate dateArrivee;
	@Column(name = "date_depart")
	private LocalDate dateDepart;
	@Enumerated(EnumType.STRING)
	@Column(name = "vol_statut")
	private StatutVol statutVol;
	@Column(name = "vol_numero")
	private int numeroVol;
	@Column(name = "vol_volgenerique")
	@OneToOne(mappedBy = "vol")
	private VolGenerique volGenerique;
	@OneToOne(mappedBy = "vol")
    private Avion avion;

   public Vol(Long id, LocalDate dateArrivee, LocalDate dateDepart, StatutVol statutVol, int numeroVol, VolGenerique volGenerique, Horaire horaire, Avion avion) {
      this.id = id;
      this.dateArrivee = dateArrivee;
      this.dateDepart = dateDepart;
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

public int getNumeroVol() {
	return numeroVol;
}

public void setNumeroVol(int numeroVol) {
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

  