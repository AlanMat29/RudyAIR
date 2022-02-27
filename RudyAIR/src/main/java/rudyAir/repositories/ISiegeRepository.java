package rudyAir.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Siege;

public interface ISiegeRepository extends JpaRepository<Siege, Long> {

	@Query("select s from Siege s where s.reservation.id=:id")
	Optional<Siege> findSiegeByReservationId(@Param("id") Long id);

	@Query("select s from Siege s where s.avion.id=:id")
	List<Siege> findSiegesByAvionId(@Param("id") Long id);

}
