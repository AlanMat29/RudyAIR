package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.compte.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long>{

}
