package rudyAir.repositories;

<<<<<<< HEAD

=======
>>>>>>> main
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
<<<<<<< HEAD

=======
>>>>>>> main

import rudyAir.model.vol.VolGenerique;


public interface IVolGeneriqueRepository extends JpaRepository<VolGenerique, Long> {

<<<<<<< HEAD
	@Query("select v from VolGenerique v where v.aeroportDepart.nom=:nom")
	List<VolGenerique> findVolGeneriqueByAeroportDepartName(@Param("nom") String nom);
	
	
	}
=======
	@Query("select vg from VolGenerique vg order by vg.prix desc")
	List<VolGenerique> findVolByPrixDecroissant();
	
	@Query("select vg from VolGenerique vg order by vg.prix")
	List<VolGenerique> findVolByPrixCroissant();
}	
>>>>>>> main
