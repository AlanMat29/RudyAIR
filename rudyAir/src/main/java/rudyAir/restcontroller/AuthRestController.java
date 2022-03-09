package rudyAir.restcontroller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.exceptions.ClientException;
import rudyAir.exceptions.CompteException;
import rudyAir.model.Views;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Compte;
import rudyAir.model.compte.Role;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.ICompteRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@Autowired
	private IClientRepository clientRepo;
	@Autowired
	private ICompteRepository compteRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;


	@GetMapping("")
	public void auth(@AuthenticationPrincipal UserDetails compte) {
		System.out.println(((Compte) compte).getNom());
	}

	@PreAuthorize("isAnonymous()")
	@JsonView(Views.Common.class)
	@PostMapping("/inscription")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client inscription(@Valid @RequestBody Client compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		if (clientRepo.findByEmail(compte.getEmail()).isPresent()) {
			throw new ClientException();
		}
		compte.setNom(compte.getNom());
		compte.setPrenom(compte.getPrenom());
		compte.setEmail(compte.getEmail());
		compte.setDateNaissance(compte.getDateNaissance());
		compte.setPassword(passwordEncoder.encode(compte.getPassword()));
		compte.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		return clientRepo.save(compte);
	}
	
	@GetMapping("/search/{email}")
	public boolean emailDejaUtilise(@PathVariable String email) {
		return compteRepo.findByEmail(email).isPresent();
	}
	
	
}
