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

import rudyAir.exceptions.VilleException;
import rudyAir.model.Views;
import rudyAir.model.vol.Ville;
import rudyAir.services.VilleService;

@RestController
@RequestMapping("/api/ville")
public class VilleRestController {

	@Autowired
	private VilleService villeService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Ville> getAll() {
		return villeService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Ville getById(@PathVariable Long id) {
		return villeService.getById(id);
	}

	@GetMapping("/{id}/aeroport")
	@JsonView(Views.VilleWithAeroports.class)
	public Ville getByIdWithEmploye(@PathVariable Long id) {
		return villeService.getByIdWithAeroports(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ville create(@Valid @RequestBody Ville ville, BindingResult br) {
		if (br.hasErrors()) {
			throw new VilleException();
		}
		return villeService.save(ville);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Ville update(@PathVariable Long id, @Valid @RequestBody Ville ville, BindingResult br) {
		if (ville.getId() == null || id != ville.getId() || br.hasErrors()) {
			throw new VilleException();
		}
		return villeService.save(ville);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		villeService.deleteById(id);
	}

}
