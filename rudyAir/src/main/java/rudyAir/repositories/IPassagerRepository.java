package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Passager;

public interface IPassagerRepository extends JpaRepository<Passager, Long>{

}
