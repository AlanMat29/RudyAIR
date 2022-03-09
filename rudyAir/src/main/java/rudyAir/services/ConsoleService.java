package rudyAir.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rudyAir.model.compte.Abonnement;
import rudyAir.model.compte.Admin;
import rudyAir.model.compte.Adresse;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Compte;
import rudyAir.model.compte.Role;
import rudyAir.repositories.ICompteRepository;

@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ICompteRepository compteRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	@Override
	public void run(String... args) throws Exception {
		//initDataBase();
	}

	private void initDataBase() {
		Compte admin = new Admin();
		admin.setNom("boss");
		admin.setPrenom("boris");
		admin.setDateNaissance(LocalDate.parse("2000-12-12"));
		admin.setEmail("boss@rudyair.fr");
		admin.setPassword(passwordEncoder.encode("boss"));
		admin.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		compteRepo.save(admin);
		
		Client user = new Client();
		user.setNom("mobile");
		user.setPrenom("tata");
		user.setDateNaissance(LocalDate.parse("2010-10-10"));
		user.setEmail("clerk@rudyair.fr");
		user.setPassword(passwordEncoder.encode("clerk"));
		user.setAdresse(new Adresse("" + 25, "rue Blaise Pascal", "75000", "Paris", "France"));
		user.setAbonnement(Abonnement.sansAbonnement);
		user.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		compteRepo.save(user);

	}

}
