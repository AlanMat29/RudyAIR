package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Aeroport;

public interface IAeroportRepository extends JpaRepository<Aeroport, Long> {

	Optional<Aeroport> findByNom(String nomAeroport);
}
