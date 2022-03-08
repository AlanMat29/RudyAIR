package rudyAir.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rudyAir.model.vol.Vol;

public interface IVolRepository extends JpaRepository<Vol, Long> {

	//Aeroport
	@Query("select v from Vol v left join fetch v.volGenerique vg left join vg.aeroportDepart where vg.aeroportDepart.nom=:nom")
	List<Vol> findVolByNomAeroportDepart(@Param("nom") String nom);

	@Query("select v from Vol v left join fetch v.volGenerique vg left join vg.aeroportArrivee where vg.aeroportArrivee.nom=:nom")
	List<Vol> findVolByNomAeroportArrivee(@Param("nom") String nom);

	
	//Date
	@Query("select v from Vol v where dateDepart=:date")
	List<Vol> findVolByDateDepart(@Param("date") LocalDate date);

	@Query("select v from Vol v where dateArrivee=:date")
	List<Vol> findVolByDateArrivee(@Param("date") LocalDate date);

	
	//Prix
	@Query("select v from Vol v left join fetch v.volGenerique vg order by vg.prix desc")
	List<Vol> findVolByPrixDecroissant();

	@Query("select v from Vol v left join fetch v.volGenerique vg order by vg.prix")
	List<Vol> findVolByPrixCroissant();

	@Query("select v from Vol v left join fetch v.volGenerique vg where vg.prix between :minPrix and :maxPrix order by vg.prix desc")
	List<Vol> findVolByintervalPrixOrderByPrixDecroissant(@Param("minPrix") double minPrix, @Param("maxPrix") double maxPrix);

	@Query("select v from Vol v left join fetch v.volGenerique vg where vg.prix between :minPrix and :maxPrix order by vg.prix")
	List<Vol> findVolByintervalPrixOrderByPrixCroissant(@Param("minPrix") double minPrix, @Param("maxPrix") double maxPrix);

	// Avion
	@Query("select v from Vol v where v.avion.id=:id")
	List<Vol> findVolByAvionId(@Param("id") Long id);
}
