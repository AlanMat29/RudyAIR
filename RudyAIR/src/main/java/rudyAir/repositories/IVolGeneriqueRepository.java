package rudyAir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rudyAir.model.vol.VolGenerique;


public interface IVolGeneriqueRepository extends JpaRepository<VolGenerique, Long> {
	List<VolGenerique> findByNumVolGen(String numVolGen);

}	
