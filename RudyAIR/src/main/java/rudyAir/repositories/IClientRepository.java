package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findByEmail(String email);

	
	
}
