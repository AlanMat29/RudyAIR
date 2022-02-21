package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Aeroport;
import rudyAir.model.vol.Vol;

public interface IVolRepository extends JpaRepository<Vol, Long> {
	
	@Query("select v from Vol v left join fetch v.volGenerique vg left join vg.aeroportDepart where vg.aeroportDepart.nom=:nom")
	List<Vol> findVolByAeroportDepartNom(@Param("nom") String nom);
	
	@Query("select v from Vol v left join fetch v.volGenerique vg left join vg.aeroportDepart where vg.aeroportDepart=:aeroport")
	List<Vol> findVolByAeroportDepart(@Param("aeroport") Aeroport aeroport);

}
