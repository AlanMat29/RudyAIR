package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {

	public List<Reservation> findAllByOrderByIdDesc();
}
