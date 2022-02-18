package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rudyAir.model.compte.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long>{

	
}
