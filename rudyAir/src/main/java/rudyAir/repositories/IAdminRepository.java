package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByEmail(String email);
}
