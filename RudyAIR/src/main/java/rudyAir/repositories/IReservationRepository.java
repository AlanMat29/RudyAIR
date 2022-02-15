package rudyAir.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import rudyAir.model.compte.Compte;
import rudyAir.model.compte.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

	Optional<Reservation> findById(@Param("id") Long id);
}
