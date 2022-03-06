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
	private PassagerService passagerService;

	@Autowired
	private VilleService villeService;

	@Autowired
	private ReservationService reservationService;

	@Test
	@Transactional
	@Commit
	public void testInsertAndUpdate() {

		// Users
		int nbLoop = 5; // Max 9
		for (int i = 1; i <= nbLoop; i++) {

			Client client = new Client("NomClient" + i, "PrenomClient" + i,
					LocalDate.parse("200" + i + "-0" + i + "-0" + i), "client" + i + "@rudyair.fr", "client" + i,
					new Adresse(""+i, "street" + i, "CP" + i, "Ville" + i, "Pays" + i), Abonnement.abonnementPremium);
			compteRepo.save(client);

			Ville villeArrivee = new Ville("Pays" + i, "Ville" + i, "CP" + i);
			Ville villeDepart = new Ville("Pays" + (nbLoop + i), "Ville" + (nbLoop + i), "CP" + (nbLoop + i));
			villeService.save(villeArrivee);
			villeService.save(villeDepart);

			Aeroport aeroportArrivee = new Aeroport("Aeroport" + i, villeArrivee);
			Aeroport aeroportDepart = new Aeroport("Aeroport" + (nbLoop + i), villeDepart);
			aeroportService.save(aeroportArrivee);
			aeroportService.save(aeroportDepart);

			Horaire horaire = new Horaire(LocalTime.parse("10:" + (10 + i)), LocalTime.parse("15:" + (20 + i)));

			VolGenerique volGenerique = new VolGenerique(20 + i, "NumVolGen" + i, horaire, aeroportArrivee,
					aeroportDepart);
			volGeneriqueService.save(volGenerique);

			Avion avion = new Avion("RD000" + i, StatutAvion.enVol);// , sieges);
			avionService.save(avion);

			Vol vol = new Vol(LocalDate.parse("2022-02-" + ("0" + i)), LocalDate.parse("2022-02-" + ("0" + (i + 1))),
					StatutVol.onTime, "NumVol" + i, volGenerique, avion);
			volService.save(vol);

			Passager passager = new Passager("NomPassager" + Character.toUpperCase((char) (i + 'a')),
					"PrenomPassager" + Character.toUpperCase((char) (i + 'a')),
					LocalDate.parse("1999-02-" + ("0" + (i + 1))));
			passagerService.save(passager);

			Reservation resa = new Reservation(vol, passager, client, true, 0, 2, "A" + i);
			reservationService.save(resa);

		}

		Client user = new Client();
		user.setNom("mobile");
		user.setPrenom("tata");
		user.setDateNaissance(LocalDate.parse("2001-01-01"));
		user.setEmail("user@rudyair.fr");
		user.setPassword("user1");
		user.setAdresse(new Adresse(""+25, "rue Blaise Pascal", "75000", "Paris", "France"));
		user.setAbonnement(Abonnement.sansAbonnement);
		compteRepo.save(user);

		Admin admin = new Admin();
		admin.setNom("rola");
		admin.setPrenom("moto");
		admin.setDateNaissance(LocalDate.parse("2002-02-02"));
		admin.setEmail("admin@rudyair.fr");
		admin.setPassword("admin1");
		compteRepo.save(admin);

		Ville ville = new Ville();
		ville.setPays("France");
		ville.setNom("Paris");
		ville.setCp("79000");
		villeService.save(ville);

		Aeroport aeroport = new Aeroport();
		aeroport.setNom("OrlyParis");
		aeroport.setVille(ville);
		aeroportService.save(aeroport);

		VolGenerique volGenerique = new VolGenerique();
		volGenerique.setPrix(750);
		volGenerique.setNumVolGen("ORY-G100-10A10");
		volGenerique.setHoraire(new Horaire((LocalTime.parse("20:45")), (LocalTime.parse("23:55"))));
		volGenerique.setAeroportDepart(aeroport);
		volGenerique.setAeroportArrivee(aeroportService.getById((long) 100));
		volGeneriqueService.save(volGenerique);

		Avion avion = new Avion();
		avion.setRef("A350-705");
		avion.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion);

		Vol vol = new Vol();
		vol.setDateDepart(LocalDate.parse("2022-02-02"));
		vol.setDateArrivee(LocalDate.parse("2022-02-03"));
		vol.setStatutVol(StatutVol.delayed);
		vol.setNumeroVol("ORY-2K22F03-G100");
		vol.setVolGenerique(volGenerique);
		vol.setAvion(avion);
		volService.save(vol);

		Passager passager = new Passager();
		passager.setNom("Doe");
		passager.setPrenom("John");
		passager.setDateDeNaissance(LocalDate.parse("2001-01-10"));
		passagerService.save(passager);

		Reservation resa = new Reservation();
		resa.setVol(vol);
		resa.setPassager(passager);
		resa.setClient(user);
		resa.setStatut(true);
		resa.setAnimaux(1);
		resa.setBagage(3);
		resa.setSiege("B1");
		reservationService.save(resa);

	}

}
