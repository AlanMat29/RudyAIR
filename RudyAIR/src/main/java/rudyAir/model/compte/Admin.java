package rudyAir.model.compte;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Compte {

	public Admin() {
	}

	public Admin(Long id, String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		super(id, nom, prenom, dateNaissance, email, password);
	}

	public Admin(String nom, String prenom, LocalDate dateNaissance, String email, String password) {
		super(nom, prenom, dateNaissance, email, password);
	}

}
