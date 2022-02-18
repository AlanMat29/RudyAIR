package rudyAirtSecurite;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import rudyAirtSecurite.model.Administrateur;
import rudyAirtSecurite.model.Utilisateur;
import rudyAirtSecurite.repository.CompteRepository;

@SpringBootTest
public class InitUserTest {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	CompteRepository compteRepo;

	@Test
	@Transactional
	@Commit
	public void initUser() {
		Utilisateur u = new Utilisateur();
		u.setEmail("u@u.fr");
		u.setPassword(passwordEncoder.encode("user"));
		compteRepo.save(u);

		Administrateur a = new Administrateur();
		a.setEmail("a@a.fr");
		a.setPassword(passwordEncoder.encode("admin"));
		compteRepo.save(a);
	}
}
