package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

	
}
