package rudyAir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.Siege;
import rudyAir.model.vol.SiegeKey;

public interface ISiegeRepository extends JpaRepository<Siege, SiegeKey> {

}
