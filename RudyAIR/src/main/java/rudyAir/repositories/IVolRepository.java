package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Vol;

public interface IVolRepository extends JpaRepository<Vol, Long> {

}
