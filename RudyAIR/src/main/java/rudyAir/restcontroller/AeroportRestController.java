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

import rudyAir.exceptions.AeroportException;
import rudyAir.model.Views;
import rudyAir.model.vol.Aeroport;
import rudyAir.services.AeroportService;

@RestController
@RequestMapping("/api/aeroport")
public class AeroportRestController {
	@Autowired
	private AeroportService aeroportService;

	@GetMapping("")
	@JsonView(Views.AeroportWithVille.class)
	public List<Aeroport> getAll() {
		return aeroportService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.AeroportWithVille.class)
	public Aeroport getById(@PathVariable Long id) {
		return aeroportService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.AeroportWithVille.class)
	public Aeroport create(@Valid @RequestBody Aeroport aeroport, BindingResult br) {
		if (br.hasErrors()) {
			throw new AeroportException();
		}
		return aeroportService.save(aeroport);
	}

	@PutMapping("/{id}")
	@JsonView(Views.AeroportWithVille.class)
	public Aeroport update(@Valid @RequestBody Aeroport aeroport, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors() || !aeroportService.exist(id)) {
			throw new AeroportException();
		}
		return aeroportService.save(aeroport);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		aeroportService.deleteById(id);
	}

	
}
