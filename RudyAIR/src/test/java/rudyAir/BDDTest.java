package rudyAir;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.sopra.springBoot.exceptions.PosteException;
import formation.sopra.springBoot.model.Poste;
import rudyAir.model.compte.Passager;
import rudyAir.model.compte.Reservation;
import rudyAir.model.vol.Aeroport;
import rudyAir.model.vol.Avion;
import rudyAir.model.vol.Siege;
import rudyAir.model.vol.Ville;
import rudyAir.model.vol.Vol;
import rudyAir.model.vol.VolGenerique;
import rudyAir.services.VolGeneriqueService;

@SpringBootTest
public class BDDTest {
	@Autowired
	private VolGeneriqueService volGeneriqueService;
	
	@Test
	@Transactional
	//@Disabled
	public void testInsertAndUpdate() {
				
		VolGenerique volGenerique = new VolGenerique();
		volGenerique.setPrix(1000);
		volGenerique.setNumVolGen("AXB2D");
		volGenerique.setHoraire();
		volGenerique.setAeroportDepart("");
		volGenerique.setAeroportArrivee(volGenerique.getAeroportArrivee());
		volGenerique.setVol(volGenerique.getVol());
		volGeneriqueService.save(volGenerique);
				
		Vol vol = new Vol();
		vol.setDateArrivee(vol.getDateArrivee());
		vol.setDateDepart(vol.getDateDepart());
		vol.setStatutVol(vol.getStatutVol());
		vol.setNumeroVol(vol.getNumeroVol());
		vol.setVolGenerique(vol.getVolGenerique());
		vol.setAvion(vol.getAvion());
		vol.setReservations(vol.getReservations());
		volService.save(vol);
				
		Aeroport aeroport = new Aeroport();
		aeroport.setNom("OrlyParis");
		aeroport.setVille("Paris");
		aeroport.setVolsGeneriquesDeparts("ORY");
		aeroport.setVolsGeneriquesArrivees();
		aeroportService.save(aeroport);
		
		Ville ville = new Ville();
		ville.setNom(ville.getNom());
		ville.setCp(ville.getCp());
		ville.setAeroports(ville.getAeroports());
		villeService.save(ville);
		
		Avion avion = new Avion();
		avion.setRef(avion.getRef());
		avion.setStatutAvion(avion.getStatutAvion());
		avion.setVol(avion.getVol());
		avionService.save(avion);
		
		Reservation resa = new Reservation();
		resa.setVol(reservation.getVol());
		resa.setPassager(reservation.getPassager());
		resa.setClient(reservation.getClient());
		resa.setStatut(reservation.isStatut());
		resa.setAnimaux(reservation.getAnimaux());
		resa.setBagage(reservation.getBagage());
		reservationService.save(resa);
		
		Passager passager = new Passager();
		passager.setNom(passager.getNom());
		passager.setPrenom(passager.getPrenom());
		passager.setDateDeNaissance(passager.getDateDeNaissance());
		passagerService.save(passager);
		
		Siege siege = new Siege();
		siege.setNumero(siege.getNumero());
		siegeService.save(siege);
	}
	
	@Test
	@Transactional
	public void testErreurCreation() {
		assertThrows(AvionException.class, () -> {
			Avion avion = new Avion();
			
			avionService.save(avion);
		});
	}

}
