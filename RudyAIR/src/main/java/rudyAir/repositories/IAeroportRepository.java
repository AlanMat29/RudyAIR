package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Aeroport;

public interface IAeroportRepository extends JpaRepository<Aeroport, Long> {

}
