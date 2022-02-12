package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Avion;

public interface IAvionRepository extends JpaRepository<Avion, Long> {

}
