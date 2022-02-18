package rudyAir.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rudyAir.model.compte.CustomUserDetails;
import rudyAir.repositories.ICompteRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private ICompteRepository compteRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new CustomUserDetails(compteRepo.findByEmail(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("email inconnu");
		}));
	}

}
