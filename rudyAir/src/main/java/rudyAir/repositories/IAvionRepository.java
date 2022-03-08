package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Avion;

public interface IAvionRepository extends JpaRepository<Avion, Long> {

	public List<Avion> findAllByOrderByRefAsc();

}
