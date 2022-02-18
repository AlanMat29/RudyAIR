package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long>{
	Optional<Compte> findByEmail(String email);

}
