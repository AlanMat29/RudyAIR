package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

}
