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

import rudyAir.exceptions.VolGeneriqueException;
import rudyAir.model.Views;
import rudyAir.model.vol.VolGenerique;
import rudyAir.services.VolGeneriqueService;

@RestController
@RequestMapping("/api/volgen")
public class VolGeneriqueRestController {

	@Autowired
	private VolGeneriqueService volGeneriqueService;

	@GetMapping("")
	@JsonView(Views.VolGeneneriqueWithHoraire.class)
	public List<VolGenerique> getAll() {
		return volGeneriqueService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.VolGeneneriqueWithHoraire.class)
	public VolGenerique getById(@PathVariable Long id) {
		return volGeneriqueService.getById(id);
	}

	@PostMapping("")
	@JsonView(Views.VolGeneneriqueWithHoraire.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public VolGenerique create(@Valid @RequestBody VolGenerique volGenerique, BindingResult br) {
		if (br.hasErrors()) {
			throw new VolGeneriqueException();
		}
		return volGeneriqueService.save(volGenerique);
	}

	@PutMapping("/{id}")
	@JsonView(Views.VolGeneneriqueWithHoraire.class)
	public VolGenerique update(@Valid @RequestBody VolGenerique volGenerique, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors() || !volGeneriqueService.exist(id) || volGenerique.getId() == null
				|| id != volGenerique.getId()) {
			throw new VolGeneriqueException();
		}
		return volGeneriqueService.save(volGenerique);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		volGeneriqueService.deleteById(id);
	}

	// Additional Web Service
	@GetMapping("/{id}/horaire")
	@JsonView(Views.VolGeneneriqueWithHoraire.class)
	public VolGenerique getByIdWithHoraire(@PathVariable Long id) {
		return volGeneriqueService.getById(id);
	}

	@GetMapping("/{id}/vol")
	@JsonView(Views.VolGeneneriqueWithVol.class)
	public VolGenerique getByIdWithVol(@PathVariable Long id) {
		return volGeneriqueService.getById(id);
	}

	@GetMapping("/{nom}/aeroportDepart")
	@JsonView(Views.VolGeneneriquetWithAeroport.class)
	public List<VolGenerique> getByVolGeneriqueWithAeroports(@PathVariable String nom) {
		return volGeneriqueService.getVolGeneriqueByAeroportDepartName(nom);

	}
}