package rudyAir;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rudyAir.model.vol.Avion;
import rudyAir.model.vol.StatutAvion;
import rudyAir.model.vol.Vol;
import rudyAir.services.AvionService;

@SpringBootTest
public class AvionTest {

	@Autowired
	private AvionService avionService;
	
	private Avion avionTest = avionCreation();
	
//	private static Long idAvionTest = 1L;
	
	
	public Avion avionCreation() {
		Avion avion = new Avion();
//		avion.setId(idAvionTest);
		avion.setRef("F-AAAA");
		avion.setStatutAvion(StatutAvion.enVol);
		avion.setVol(new Vol());
		return avion;
	}
	
	@Test
	@BeforeAll
	public static void testAvionCreation() {
		Avion avion = new Avion();
		avion.setId(1L);
		avion.setRef("F-AAAA");
		avion.setStatutAvion(StatutAvion.enVol);
		avion.setVol(new Vol());
	}
	
	
	@Test
	@Transactional
//	@Commit //Pb car le vol n'es pas dans la BDD
	public void testInsert() {	
		avionService.save(avionTest);
	}
	
	
//	@Test
//	@Transactional
////	@Commit
//	@Disabled
//	public void testDelete() {
//		avionService.delete(avionTest.getId());
//	}
//	
	
}
