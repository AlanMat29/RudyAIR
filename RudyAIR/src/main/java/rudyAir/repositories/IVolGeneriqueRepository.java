package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.VolGenerique;


public interface IVolGeneriqueRepository extends JpaRepository<VolGenerique, Long> {

	@Query("select vg from VolGenerique vg order by vg.prix desc")
	List<VolGenerique> findVolByPrixDecroissant();
	
	@Query("select vg from VolGenerique vg order by vg.prix")
	List<VolGenerique> findVolByPrixCroissant();
}	
