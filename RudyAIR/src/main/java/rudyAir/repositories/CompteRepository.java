package rudyAir.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import rudyAir.model.compte.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

	Optional<Compte> findById(@Param("id") Long id);
	
	List<Compte> findByNom(String nom);

	List<Compte> findByNomLike(String nom);

	List<Compte> findByNomStartingWith(String nom);

	List<Compte> findByNomContaining(String nom);

	Optional<Compte> findByIdAndNom(Long id, String nom);

	List<Compte> findByIdOrNom(Long id, String nom);

}
