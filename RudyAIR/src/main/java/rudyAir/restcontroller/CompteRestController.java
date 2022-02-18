package rudyAir.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import rudyAir.exceptions.CompteException;
import rudyAir.model.Views;
import rudyAir.model.compte.Compte;
import rudyAir.services.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	@Autowired
	private CompteService compteService;
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Compte> getAll() {
		return compteService.getAll();
	}
	
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Long id) {
		return compteService.getById(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		return compteService.save(compte);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Compte update(@Valid @RequestBody Compte compte, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors() || !compteService.exist(id)) {
			throw new CompteException();
		}
		return compteService.save(compte);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		compteService.deleteById(id);
	}

}
