package rudyAir.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.compte.Client;
import rudyAir.model.compte.Reservation;

public interface IClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByEmail(String email);

	@Query("select c.reservations from Client c where c.id=:id")
	List<Reservation> findAllClientReservationsByClientId(@Param("id") Long id);

}
