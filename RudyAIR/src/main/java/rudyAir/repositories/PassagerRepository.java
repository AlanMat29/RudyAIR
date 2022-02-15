package rudyAir.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import rudyAir.model.compte.Compte;
import rudyAir.model.compte.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long>{

	Optional<Passager> findById(@Param("id") Long id);
	
	List<Passager> findByNom(String nom);

	List<Passager> findByNomLike(String nom);

	List<Passager> findByNomStartingWith(String nom);

	List<Passager> findByNomContaining(String nom);

	Optional<Passager> findByIdAndNom(Long id, String nom);

	List<Passager> findByIdOrNom(Long id, String nom);
}
