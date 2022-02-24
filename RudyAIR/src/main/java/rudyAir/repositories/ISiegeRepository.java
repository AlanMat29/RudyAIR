package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Siege;
import rudyAir.model.vol.SiegeKey;

public interface ISiegeRepository extends JpaRepository<Siege, SiegeKey> {

	@Query("select s from Siege s where s.id.reservation.id=:id")
	Optional<Siege> findSiegeByReservationId(@Param("id") Long id);
	
	@Query("select s from Siege s where s.id.avion.id=:id")
	Optional<Siege> findSiegeByAvionId(@Param("id") Long id);
	
}
