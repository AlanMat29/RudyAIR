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

import rudyAir.exceptions.SiegeException;
import rudyAir.model.Views;
import rudyAir.model.vol.Siege;
import rudyAir.services.SiegeService;

@RestController
@RequestMapping("/api/siege")
public class SiegeRestController {

	@Autowired
	private SiegeService siegeService;

	@GetMapping("")
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public List<Siege> getAll() {
		return siegeService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public Siege getById(@PathVariable Long id) {
		return siegeService.getById(id);
	}

	@GetMapping("/{id}/reservation")
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public Siege getSiegeByReservationId(@PathVariable Long id) {
		return siegeService.getSiegeByReservationId(id);
	}

	@GetMapping("/{id}/avion")
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public List<Siege> getByIdWithAvion(@PathVariable Long id) {
		return siegeService.getSiegeByAvionId(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public Siege create(@Valid @RequestBody Siege siege, BindingResult br) {
		if (br.hasErrors()) {
			throw new SiegeException();
		}
		return siegeService.save(siege);
	}

	@PutMapping("/{id}")
	@JsonView(Views.SiegeWithReservationAndAvion.class)
	public Siege update(@PathVariable Long id, @Valid @RequestBody Siege siege, BindingResult br) {
		if (siege.getId() == null || id != siege.getId() || br.hasErrors()) {
			throw new SiegeException();
		}
		return siegeService.save(siege);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		siegeService.deleteById(id);
	}

}
