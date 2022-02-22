package rudyAir;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import rudyAir.model.compte.Abonnement;
import rudyAir.model.compte.Admin;
import rudyAir.model.compte.Adresse;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Passager;
import rudyAir.model.compte.Reservation;
import rudyAir.model.vol.Aeroport;
import rudyAir.model.vol.Avion;
import rudyAir.model.vol.Horaire;
import rudyAir.model.vol.Siege;
import rudyAir.model.vol.StatutAvion;
import rudyAir.model.vol.StatutVol;
import rudyAir.model.vol.Ville;
import rudyAir.model.vol.Vol;
import rudyAir.model.vol.VolGenerique;
import rudyAir.repositories.IAeroportRepository;
import rudyAir.repositories.ICompteRepository;
import rudyAir.repositories.IVilleRepository;
import rudyAir.services.AeroportService;
import rudyAir.services.AvionService;
import rudyAir.services.PassagerService;
import rudyAir.services.ReservationService;
import rudyAir.services.SiegeService;
import rudyAir.services.VilleService;
import rudyAir.services.VolGeneriqueService;
import rudyAir.services.VolService;

@SpringBootTest
public class BDDTest {
	@Autowired
	private VolGeneriqueService volGeneriqueService;

	@Autowired
	ICompteRepository compteRepo;
	
	@Autowired
	IVilleRepository villeRepo;
	
	@Autowired
	IAeroportRepository aeroRepo;
	
	@Autowired
	private VolService volService;

	@Autowired
	private AeroportService aeroportService;

	@Autowired
	private AvionService avionService;

	@Autowired
	private SiegeService siegeService;

	@Autowired
	private PassagerService passagerService;

	@Autowired
	private VilleService villeService;

	@Autowired
	private ReservationService reservationService;

	@Test
	@Transactional
	@Commit
	public void testInsertAndUpdate() {

		Client user = new Client();
//		user.setId((long) 100);
		user.setNom("mobile");
		user.setPrenom("tata");
		user.setDateNaissance(LocalDate.parse("2001-01-01"));
		user.setEmail("user@rudyair.fr");
		user.setPassword("user1");
		user.setAdresse(new Adresse(1,"rue Blaise Pascal","75000","Paris"));
		user.setAbonnement(Abonnement.Premium);
		compteRepo.save(user);

		Admin admin = new Admin();
//		admin.setId((long) 100);
		admin.setNom("rola");
		admin.setPrenom("moto");
		admin.setDateNaissance(LocalDate.parse("2002-02-02"));
		admin.setEmail("admin@rudyairr.fr");
		admin.setPassword("admin1");
		compteRepo.save(admin);
		
		Ville ville = new Ville();
//		ville.setId((long) 100);
		ville.setNom("Paris");
		ville.setCp("79000");
		villeService.save(ville);

		Aeroport aeroport = new Aeroport();
//		aeroport.setId((long) 100);
		aeroport.setNom("OrlyParis");
		aeroport.setVille(ville);
		aeroportService.save(aeroport);
		
		Avion avion = new Avion();
//		avion.setId((long) 100);
		avion.setRef("A350-705");
		avion.setStatutAvion(StatutAvion.enVol);
		avionService.save(avion);

		VolGenerique volGenerique = new VolGenerique();
//		volGenerique.setId((long) 100);
		volGenerique.setPrix(750);
		volGenerique.setNumVolGen("ORY-G100-10A10");
		volGenerique.setHoraire(new Horaire((LocalTime.parse("10:10")), (LocalTime.parse("15:10"))));
		volGenerique.setAeroportDepart(aeroport);
		volGenerique.setAeroportArrivee(aeroportService.getById((long) 100));
		volGeneriqueService.save(volGenerique);
		
		Vol vol = new Vol();
//		vol.setId((long) 100);
		vol.setDateDepart(LocalDate.parse("2022-02-02"));
		vol.setDateArrivee(LocalDate.parse("2022-02-03"));		
		vol.setStatutVol(StatutVol.onTime);
		vol.setNumeroVol("ORY-2K22F03-G100");
		vol.setVolGenerique(volGenerique);
		vol.setAvion(avion);
		volService.save(vol);
			
		Passager passager = new Passager();
//		passager.setId((long) 100);
		passager.setNom("Doe");
		passager.setPrenom("John");
		passager.setDateDeNaissance(LocalDate.parse("2001-01-10"));
		passagerService.save(passager);
		
		Reservation resa = new Reservation();
//		resa.setId((long) 100);
		resa.setVol(vol);
		resa.setPassager(passager);
		resa.setClient(user);
		resa.setStatut(true);
		resa.setAnimaux(1);
		resa.setBagage(3);
		reservationService.save(resa);

		Siege siege = new Siege();
		siege.setNumero(13);
		siege.setId(null);
//		siege.setAvion(avion);
//		siege.setReservation(resa);
		siegeService.save(siege);


	}

}
