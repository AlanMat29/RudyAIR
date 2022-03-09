package rudyAir;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import rudyAir.model.compte.Abonnement;
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
					new Adresse("" + i, "street" + i, "CP" + i, "Ville" + i, "Pays" + i), Abonnement.abonnementPremium);
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

			Avion avion = new Avion("RD000" + i, StatutAvion.enVol);
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


		
		
		
		
		/*		
		
		Avion avion = new Avion();
		avion.setRef("A220-300");
		avion.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion);

		Avion avion1 = new Avion();
		avion1.setRef("A300 B2/B4");
		avion1.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion1);

		Avion avion2 = new Avion();
		avion2.setRef("A340-200");
		avion2.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion2);

		Avion avion3 = new Avion();
		avion3.setRef("737-200");
		avion3.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion3);

		Avion avion4 = new Avion();
		avion4.setRef("737-500");
		avion4.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion4);

		Avion avion5 = new Avion();
		avion5.setRef("787-9");
		avion5.setStatutAvion(StatutAvion.auSol);
		avionService.save(avion5);

		Avion avion6 = new Avion();
		avion6.setRef("A350-900");
		avion6.setStatutAvion(StatutAvion.enMaintenance);
		avionService.save(avion6);

		Avion avion7 = new Avion();
		avion7.setRef("A380");
		avion7.setStatutAvion(StatutAvion.enVol);
		avionService.save(avion7);

//		Passager passager = new Passager();
//		passager.setNom("Doe");
//		passager.setPrenom("John");
//		passager.setDateDeNaissance(LocalDate.parse("2001-01-10"));
//		passagerService.save(passager);
//
//		Reservation resa = new Reservation();
//		resa.setVol(vol);
//		resa.setPassager(passager);
//		resa.setClient(user);
//		resa.setStatut(true);
//		resa.setAnimaux(1);
//		resa.setBagage(3);
//		resa.setSiege("B1");
//		reservationService.save(resa);
//		
//		
		///////////////////////////////////////////////////////////////////////////////////////
		// Admin

		Admin admin1 = new Admin();
		admin1.setNom("Clamy");
		admin1.setPrenom("Rudyard");
		admin1.setDateNaissance(LocalDate.parse("1994-02-02"));
		admin1.setEmail("admin1@rudyair.fr");
		admin1.setPassword("admin1");
		compteRepo.save(admin1);

		Admin admin2 = new Admin();
		admin2.setNom("admin");
		admin2.setPrenom("admin");
		admin2.setDateNaissance(LocalDate.parse("1995-03-12"));
		admin2.setEmail("admin2@rudyair.fr");
		admin2.setPassword("admin2");
		compteRepo.save(admin2);

		// Client

		Client user1 = new Client();
		user1.setNom("Jean");
		user1.setPrenom("Noel");
		user1.setDateNaissance(LocalDate.parse("1979-08-12"));
		user1.setEmail("jean.noel84@gmail.com");
		user1.setPassword("Jean25");
		user1.setAdresse(new Adresse("" + 25, "rue Blaise Pascal", "75000", "Paris", "France"));
		user1.setAbonnement(Abonnement.sansAbonnement);
		compteRepo.save(user1);

		Client user2 = new Client();
		user2.setNom("Thomas");
		user2.setPrenom("Patrick");
		user2.setDateNaissance(LocalDate.parse("1981-01-09"));
		user2.setEmail("patrick.thomas41@gmail.com");
		user2.setPassword("Patrick32");
		user2.setAdresse(new Adresse("" + 45, "Avenue d'Armor", "35360", "Le Lou-du-Lac", "France"));
		user2.setAbonnement(Abonnement.sansAbonnement);
		compteRepo.save(user2);

		Client user3 = new Client();
		user3.setNom("Bastien");
		user3.setPrenom("Robin");
		user3.setDateNaissance(LocalDate.parse("1993-12-25"));
		user3.setEmail("mariechristine.lefebvre39@hotmail.fr");
		user3.setPassword("Robin12");
		user3.setAdresse(new Adresse("" + 28, "Rue du Gai Verger", "07330", "Barnas", "France"));
		user3.setAbonnement(Abonnement.sansAbonnement);
		compteRepo.save(user3);

		// ville + Aeroport

		Ville ville1 = new Ville();
		ville1.setPays("France");
		ville1.setNom("Paris");
		ville1.setCp("79000");
		villeService.save(ville1);

		Aeroport aeroport1 = new Aeroport();
		aeroport1.setNom("OrlyParis");
		aeroport1.setVille(ville1);
		aeroportService.save(aeroport1);

		Aeroport aeroport2 = new Aeroport();
		aeroport2.setNom("RoissyParis");
		aeroport2.setVille(ville1);
		aeroportService.save(aeroport2);

		Ville ville3 = new Ville();
		ville3.setPays("Turquie");
		ville3.setNom("Ankara");
		ville3.setCp("33289");
		villeService.save(ville3);

		Aeroport aeroport3 = new Aeroport();
		aeroport3.setNom("Istanbul");
		aeroport3.setVille(ville3);
		aeroportService.save(aeroport3);

		Ville ville4 = new Ville();
		ville4.setPays("United Kingdom");
		ville4.setNom("Londre");
		ville4.setCp("AB12");
		villeService.save(ville4);

		Aeroport aeroport4 = new Aeroport();
		aeroport4.setNom("Stansted");
		aeroport4.setVille(ville4);
		aeroportService.save(aeroport4);

		Ville ville5 = new Ville();
		ville5.setPays("Espagne");
		ville5.setNom("Barcelone");
		ville5.setCp("05482");
		villeService.save(ville5);

		Aeroport aeroport5 = new Aeroport();
		aeroport5.setNom("El Prat");
		aeroport5.setVille(ville5);
		aeroportService.save(aeroport5);

		Ville ville6 = new Ville();
		ville6.setPays("Afrique du sud");
		ville6.setNom("OR Tambo");
		ville6.setCp("39620");
		villeService.save(ville6);

		Aeroport aeroport6 = new Aeroport();
		aeroport6.setNom("Johannesbourg");
		aeroport6.setVille(ville6);
		aeroportService.save(aeroport6);

		Ville ville7 = new Ville();
		ville7.setPays("États-Unis");
		ville7.setNom("Miami");
		ville7.setCp("35495");
		villeService.save(ville7);

		Aeroport aeroport7 = new Aeroport();
		aeroport7.setNom("Miami");
		aeroport7.setVille(ville7);
		aeroportService.save(aeroport7);

		Ville ville8 = new Ville();
		ville8.setPays("Pays-Bas");
		ville8.setNom("Amsterdam");
		ville8.setCp("31086 AM");
		villeService.save(ville8);

		Aeroport aeroport8 = new Aeroport();
		aeroport8.setNom("Schiphol");
		aeroport8.setVille(ville8);
		aeroportService.save(aeroport8);

		Ville ville9 = new Ville();
		ville9.setPays("Égypte");
		ville9.setNom("Le Caire");
		ville9.setCp("99301");
		villeService.save(ville9);

		Aeroport aeroport9 = new Aeroport();
		aeroport9.setNom("Le Caire");
		aeroport9.setVille(ville9);
		aeroportService.save(aeroport9);

		Ville ville10 = new Ville();
		ville10.setPays("Espagne");
		ville10.setNom("Las Palmas de Gran Canaria");
		ville10.setCp("28755");
		villeService.save(ville10);

		Aeroport aeroport10 = new Aeroport();
		aeroport10.setNom("Las Palmas de Gran Canaria");
		aeroport10.setVille(ville10);
		aeroportService.save(aeroport10);

		Ville ville11 = new Ville();
		ville11.setPays("Éthiopie");
		ville11.setNom("Addis-Abeba");
		ville11.setCp("7240");
		villeService.save(ville11);

		Aeroport aeroport11 = new Aeroport();
		aeroport11.setNom("Bole");
		aeroport11.setVille(ville11);
		aeroportService.save(aeroport11);

		Ville ville12 = new Ville();
		ville12.setPays("Maroc");
		ville12.setNom("Casablanca");
		ville12.setCp("13560");
		villeService.save(ville12);

		Aeroport aeroport12 = new Aeroport();
		aeroport12.setNom("Casablanca");
		aeroport12.setVille(ville12);
		aeroportService.save(aeroport12);

		Ville ville13 = new Ville();
		ville13.setPays("Algérie");
		ville13.setNom("Alger");
		ville13.setCp("89083");
		villeService.save(ville13);

		Aeroport aeroport13 = new Aeroport();
		aeroport13.setNom("Alger");
		aeroport13.setVille(ville13);
		aeroportService.save(aeroport13);

		Ville ville14 = new Ville();
		ville14.setPays("Kenya");
		ville14.setNom("Lagos");
		ville14.setCp("20102");
		villeService.save(ville14);

		Aeroport aeroport14 = new Aeroport();
		aeroport14.setNom("Lagos");
		aeroport14.setVille(ville14);
		aeroportService.save(aeroport14);

		Ville ville15 = new Ville();
		ville15.setPays("Tunisie");
		ville15.setNom("Tunis");
		ville15.setCp("53316");
		villeService.save(ville15);

		Aeroport aeroport15 = new Aeroport();
		aeroport15.setNom("Tunis");
		aeroport15.setVille(ville15);
		aeroportService.save(aeroport15);

		Ville ville16 = new Ville();
		ville16.setPays("Afrique du Sud");
		ville16.setNom("Durban");
		ville16.setCp("71534");
		villeService.save(ville16);

		Aeroport aeroport16 = new Aeroport();
		aeroport16.setNom("Durban");
		aeroport16.setVille(ville16);
		aeroportService.save(aeroport16);

		Ville ville17 = new Ville();
		ville17.setPays("Maroc");
		ville17.setNom("Marrakech");
		ville17.setCp("12989");
		villeService.save(ville17);

		Aeroport aeroport17 = new Aeroport();
		aeroport17.setNom("Marrakech");
		aeroport17.setVille(ville17);
		aeroportService.save(aeroport17);

		Ville ville18 = new Ville();
		ville18.setPays("Nigeria");
		ville18.setNom("Abuja");
		ville18.setCp("74210");
		villeService.save(ville18);

		Aeroport aeroport18 = new Aeroport();
		aeroport18.setNom("Abuja");
		aeroport18.setVille(ville18);
		aeroportService.save(aeroport18);

		Ville ville19 = new Ville();
		ville19.setPays("Nouvelle-Calédonie");
		ville19.setNom("Nouméa-La Tontouta");
		ville19.setCp("32784");
		villeService.save(ville19);

		Aeroport aeroport19 = new Aeroport();
		aeroport19.setNom("Nouméa-La Tontouta");
		aeroport19.setVille(ville19);
		aeroportService.save(aeroport19);

		Ville ville20 = new Ville();
		ville20.setPays("Nouvelle-Zélande");
		ville20.setNom("Auckland");
		ville20.setCp("8688");
		villeService.save(ville20);

		Aeroport aeroport20 = new Aeroport();
		aeroport20.setNom("Auckland");
		aeroport20.setVille(ville20);
		aeroportService.save(aeroport20);

		// Vile + aeroport

		// Vol +Volgen

		VolGenerique volGenerique1 = new VolGenerique();
		volGenerique1.setPrix(161);
		volGenerique1.setNumVolGen("RUD-G100-10A10");
		volGenerique1.setHoraire(new Horaire((LocalTime.parse("20:45")), (LocalTime.parse("23:55"))));
		volGenerique1.setAeroportDepart(aeroport2);
		volGenerique1.setAeroportArrivee(aeroport3);
		volGeneriqueService.save(volGenerique1);

		Vol vol1 = new Vol();
		vol1.setDateDepart(LocalDate.parse("2022-05-28"));
		vol1.setDateArrivee(LocalDate.parse("2022-05-28"));
		vol1.setStatutVol(StatutVol.onTime);
		vol1.setNumeroVol("RUD-74NR-41YX");
		vol1.setVolGenerique(volGenerique1);
		vol1.setAvion(avion3);
		volService.save(vol1);

		VolGenerique volGenerique2 = new VolGenerique();
		volGenerique2.setPrix(60);
		volGenerique2.setNumVolGen("RUD-9F5W-X7Q7");
		volGenerique2.setHoraire(new Horaire((LocalTime.parse("07:55")), (LocalTime.parse("11:55"))));
		volGenerique2.setAeroportDepart(aeroport1);
		volGenerique2.setAeroportArrivee(aeroport10);
		volGeneriqueService.save(volGenerique2);

		Vol vol2 = new Vol();
		vol2.setDateDepart(LocalDate.parse("2022-03-22"));
		vol2.setDateArrivee(LocalDate.parse("2022-03-22"));
		vol2.setStatutVol(StatutVol.onTime);
		vol2.setNumeroVol("RUD-2BR9-J25N");
		vol2.setVolGenerique(volGenerique2);
		vol2.setAvion(avion4);
		volService.save(vol2);

		VolGenerique volGenerique3 = new VolGenerique();
		volGenerique3.setPrix(83);
		volGenerique3.setNumVolGen("RUD-5Q0Y-41JM");
		volGenerique3.setHoraire(new Horaire((LocalTime.parse("09:30")), (LocalTime.parse("13:55"))));
		volGenerique3.setAeroportDepart(aeroport1);
		volGenerique3.setAeroportArrivee(aeroport9);
		volGeneriqueService.save(volGenerique3);

		Vol vol3 = new Vol();
		vol3.setDateDepart(LocalDate.parse("2022-03-11"));
		vol3.setDateArrivee(LocalDate.parse("2022-03-11"));
		vol3.setStatutVol(StatutVol.onTime);
		vol3.setNumeroVol("RUD-41JM-J60F");
		vol3.setVolGenerique(volGenerique3);
		vol3.setAvion(avion7);
		volService.save(vol3);

		VolGenerique volGenerique4 = new VolGenerique();
		volGenerique4.setPrix(105);
		volGenerique4.setNumVolGen("RUD-X5V1-54QI");
		volGenerique4.setHoraire(new Horaire((LocalTime.parse("17:40")), (LocalTime.parse("21:40"))));
		volGenerique4.setAeroportDepart(aeroport12);
		volGenerique4.setAeroportArrivee(aeroport1);
		volGeneriqueService.save(volGenerique4);

		Vol vol4 = new Vol();
		vol4.setDateDepart(LocalDate.parse("2022-03-26"));
		vol4.setDateArrivee(LocalDate.parse("2022-03-26"));
		vol4.setStatutVol(StatutVol.onTime);
		vol4.setNumeroVol("RUD-D87Q-5ZM4");
		vol4.setVolGenerique(volGenerique4);
		vol4.setAvion(avion6);
		volService.save(vol4);

		VolGenerique volGenerique5 = new VolGenerique();
		volGenerique5.setPrix(492);
		volGenerique5.setNumVolGen("RUD-47XV-7BS6");
		volGenerique5.setHoraire(new Horaire((LocalTime.parse("16:25")), (LocalTime.parse("10:20"))));
		volGenerique5.setAeroportDepart(aeroport7);
		volGenerique5.setAeroportArrivee(aeroport8);
		volGeneriqueService.save(volGenerique5);

		Vol vol5 = new Vol();
		vol5.setDateDepart(LocalDate.parse("2022-04-04"));
		vol5.setDateArrivee(LocalDate.parse("2022-04-05"));
		vol5.setStatutVol(StatutVol.delayed);
		vol5.setNumeroVol("RUD-5ZM4-MS69");
		vol5.setVolGenerique(volGenerique5);
		vol5.setAvion(avion6);
		volService.save(vol5);

		VolGenerique volGenerique6 = new VolGenerique();
		volGenerique6.setPrix(525);
		volGenerique6.setNumVolGen("RUD-0GB7-4AF6");
		volGenerique6.setHoraire(new Horaire((LocalTime.parse("20:25")), (LocalTime.parse("03:10"))));
		volGenerique6.setAeroportDepart(aeroport1);
		volGenerique6.setAeroportArrivee(aeroport14);
		volGeneriqueService.save(volGenerique6);

		Vol vol6 = new Vol();
		vol6.setDateDepart(LocalDate.parse("2022-06-05"));
		vol6.setDateArrivee(LocalDate.parse("2022-06-06"));
		vol6.setStatutVol(StatutVol.onTime);
		vol6.setNumeroVol("RUD-41PN-6J6G");
		vol6.setVolGenerique(volGenerique6);
		vol6.setAvion(avion5);
		volService.save(vol6);

		VolGenerique volGenerique7 = new VolGenerique();
		volGenerique7.setPrix(603);
		volGenerique7.setNumVolGen("RUD-JY04-4PW9");
		volGenerique7.setHoraire(new Horaire((LocalTime.parse("16:50")), (LocalTime.parse("21:25"))));
		volGenerique7.setAeroportDepart(aeroport19);
		volGenerique7.setAeroportArrivee(aeroport20);
		volGeneriqueService.save(volGenerique7);

		Vol vol7 = new Vol();
		vol7.setDateDepart(LocalDate.parse("2022-06-09"));
		vol7.setDateArrivee(LocalDate.parse("2022-06-09"));
		vol7.setStatutVol(StatutVol.onTime);
		vol7.setNumeroVol("RUD-T3A2-N98W");
		vol7.setVolGenerique(volGenerique7);
		vol7.setAvion(avion3);
		volService.save(vol7);

		VolGenerique volGenerique8 = new VolGenerique();
		volGenerique8.setPrix(889);
		volGenerique8.setNumVolGen("RUD-23NX-48NO");
		volGenerique8.setHoraire(new Horaire((LocalTime.parse("12:35")), (LocalTime.parse("18:30"))));
		volGenerique8.setAeroportDepart(aeroport16);
		volGenerique8.setAeroportArrivee(aeroport14);
		volGeneriqueService.save(volGenerique8);

		Vol vol8 = new Vol();
		vol8.setDateDepart(LocalDate.parse("2022-07-20"));
		vol8.setDateArrivee(LocalDate.parse("2022-07-20"));
		vol8.setStatutVol(StatutVol.onTime);
		vol8.setNumeroVol("RUD-24IR-X3F7");
		vol8.setVolGenerique(volGenerique8);
		vol8.setAvion(avion4);
		volService.save(vol8);

		VolGenerique volGenerique9 = new VolGenerique();
		volGenerique9.setPrix(234);
		volGenerique9.setNumVolGen("RUD-2OK6-4S7C");
		volGenerique9.setHoraire(new Horaire((LocalTime.parse("14:35")), (LocalTime.parse("15:45"))));
		volGenerique9.setAeroportDepart(aeroport13);
		volGenerique9.setAeroportArrivee(aeroport15);
		volGeneriqueService.save(volGenerique9);

		Vol vol9 = new Vol();
		vol9.setDateDepart(LocalDate.parse("2022-04-09"));
		vol9.setDateArrivee(LocalDate.parse("2022-04-09"));
		vol9.setStatutVol(StatutVol.onTime);
		vol9.setNumeroVol("RUD-HH78-U8L1");
		vol9.setVolGenerique(volGenerique9);
		vol9.setAvion(avion2);
		volService.save(vol9);

		VolGenerique volGenerique10 = new VolGenerique();
		volGenerique10.setPrix(251);
		volGenerique10.setNumVolGen("RUD-9KY1-LF54");
		volGenerique10.setHoraire(new Horaire((LocalTime.parse("11:15")), (LocalTime.parse("15:50"))));
		volGenerique10.setAeroportDepart(aeroport4);
		volGenerique10.setAeroportArrivee(aeroport2);
		volGeneriqueService.save(volGenerique10);

		Vol vol10 = new Vol();
		vol10.setDateDepart(LocalDate.parse("2022-09-17"));
		vol10.setDateArrivee(LocalDate.parse("2022-09-17"));
		vol10.setStatutVol(StatutVol.canceled);
		vol10.setNumeroVol("RUD-A39Q-2A6T");
		vol10.setVolGenerique(volGenerique10);
		vol10.setAvion(avion6);
		volService.save(vol10);

		// Reservation + Passager

		Passager passager1 = new Passager();
		passager1.setNom("Jean");
		passager1.setPrenom("Noel");
		passager1.setDateDeNaissance(LocalDate.parse("1979-08-12"));
		passagerService.save(passager1);

		Reservation resa1 = new Reservation();
		resa1.setVol(vol1);
		resa1.setPassager(passager1);
		resa1.setClient(user1);
		resa1.setStatut(true);
		resa1.setAnimaux(1);
		resa1.setBagage(3);
		resa1.setSiege("B1");
		reservationService.save(resa1);

		Passager passager2 = new Passager();
		passager2.setNom("Aubert");
		passager2.setPrenom("Fernand");
		passager2.setDateDeNaissance(LocalDate.parse("2001-05-26"));
		passagerService.save(passager2);

		Reservation resa2 = new Reservation();
		resa2.setVol(vol2);
		resa2.setPassager(passager2);
		resa2.setClient(user2);
		resa2.setStatut(true);
		resa2.setAnimaux(0);
		resa2.setBagage(1);
		resa2.setSiege("B1");
		reservationService.save(resa2);
*/
	}

}
