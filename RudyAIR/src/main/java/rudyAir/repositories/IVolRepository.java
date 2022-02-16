package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Vol;

public interface IVolRepository extends JpaRepository<Vol, Long> {
	
	@Query("select v from Vol v left join fetch v.volGenerique vg on v.id=vg.vol left join vg.aeroport on v.id=vg.vol where vg.aeroportDepart=:nom")
	@Modifying
	List<Vol> findVolByAeroportNom(@Param("nom") String nom);

}
