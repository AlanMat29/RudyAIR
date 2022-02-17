package rudyAir.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Ville;

public interface IVilleRepository extends JpaRepository<Ville, Long> {

	@Query("select v from Ville v left join fetch v.aeroports where v.id=:id")
	Optional<Ville> findByIdWithAeroports(@Param("id")Long id);

}
