package rudyAirtSecurite;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import rudyAir.model.compte.Admin;
import rudyAir.model.compte.Client;
import rudyAir.repositories.ICompteRepository;

@SpringBootTest
public class InitUserTest {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ICompteRepository compteRepo;

	@Test
	@Transactional
	@Commit
	public void initUser() {
		Client u = new Client();
		u.setEmail("u@u.fr");
		u.setPassword(passwordEncoder.encode("user"));
		compteRepo.save(u);

		Admin a = new Admin();
		a.setEmail("a@a.fr");
		a.setPassword(passwordEncoder.encode("admin"));
		compteRepo.save(a);
	}
}
