package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.compte.Client;
import rudyAir.model.compte.Reservation;


public interface IReservationRepository extends JpaRepository<Reservation, Long>{
	
	@Query("select c.reservations from Client c where c.id=:id")
	List<Reservation> findAllClientReservations(@Param("id")Client client);
	
}
