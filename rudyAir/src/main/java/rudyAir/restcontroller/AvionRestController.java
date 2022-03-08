package rudyAir.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import rudyAir.exceptions.AvionException;
import rudyAir.model.Views;
import rudyAir.model.vol.Avion;
import rudyAir.services.AvionService;

@RestController
@RequestMapping("/api/avion")
@CrossOrigin(origins = "*")
public class AvionRestController {

	@Autowired
	private AvionService avionService;

	@GetMapping("")
	@JsonView(Views.AvionWithSiege.class)
	public List<Avion> getAll() {
		return avionService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.AvionWithSiege.class)
	public Avion getById(@PathVariable Long id) {
		return avionService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.AvionWithSiege.class)
	public Avion create(@Valid @RequestBody Avion avion, BindingResult br) {
		if (br.hasErrors()) {
			throw new AvionException();
		}
		return avionService.save(avion);
	}

	@PutMapping("/{id}")
	@JsonView(Views.AvionWithSiege.class)
	public Avion update(@PathVariable Long id, @Valid @RequestBody Avion avion, BindingResult br) {
		if (!avionService.exist(id) || avion.getId() == null || id != avion.getId() || br.hasErrors()) {
			throw new AvionException();
		}
		return avionService.save(avion);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		avionService.deleteById(id);
	}

	@GetMapping("/sortedRefAsc")
	@JsonView(Views.Reservation.class)
	public List<Avion> getAllByOrderByRefAsc() {
		return avionService.getAllByOrderByRefAsc();
	}
}
