package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	
}
