package rudyAir.model.voyage;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Horaire {
   private LocalDate dateDepart;
   private LocalDate dateArrivee;
   private LocalDate heureDepart;
   private LocalDate heureArrivee;
 

   public Horaire() {
	   
   }
   
   public Horaire(LocalDate dateDepart, LocalDate dateArrivee, LocalDate heureDepart, LocalDate heureArrivee, LocalDate duree) {
      this.dateDepart = dateDepart;
      this.dateArrivee = dateArrivee;
      this.heureDepart = heureDepart;
      this.heureArrivee = heureArrivee;
   }

   public LocalDate getDateDepart() {
      return this.dateDepart;
   }

   public void setDateDepart(LocalDate dateDepart) {
      this.dateDepart = dateDepart;
   }

   public LocalDate getDateArrivee() {
      return this.dateArrivee;
   }

   public void setDateArrivee(LocalDate dateArrivee) {
      this.dateArrivee = dateArrivee;
   }

   public LocalDate getHeureDepart() {
      return this.heureDepart;
   }

   public void setHeureDepart(LocalDate heureDepart) {
      this.heureDepart = heureDepart;
   }

   public LocalDate getHeureArrivee() {
      return this.heureArrivee;
   }

   public void setHeureArrivee(LocalDate heureArrivee) {
      this.heureArrivee = heureArrivee;
   }

@Override
public int hashCode() {
	return Objects.hash(dateArrivee, dateDepart, heureArrivee, heureDepart);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Horaire other = (Horaire) obj;
	return Objects.equals(dateArrivee, other.dateArrivee) && Objects.equals(dateDepart, other.dateDepart)
			&& Objects.equals(heureArrivee, other.heureArrivee) && Objects.equals(heureDepart, other.heureDepart);
}

   		

}
