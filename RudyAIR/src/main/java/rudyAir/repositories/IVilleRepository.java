package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Ville;

public interface IVilleRepository extends JpaRepository<Ville, Long> {

}
