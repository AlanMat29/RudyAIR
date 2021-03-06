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

import rudyAir.exceptions.PassagerException;
import rudyAir.model.Views;
import rudyAir.model.compte.Passager;
import rudyAir.services.PassagerService;

@RestController
@RequestMapping("/api/passager")
@CrossOrigin(origins = "*")
public class PassagerRestController {

	@Autowired
	private PassagerService passagerService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Passager> getAll() {
		return passagerService.getAll();
	}

	@GetMapping("/reservation")
	@JsonView(Views.PassagerWithReservation.class)
	public List<Passager> getAllWithReservation() {
		return passagerService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Passager getById(@PathVariable Long id) {
		return passagerService.getById(id);
	}

	@GetMapping("/{id}/reservation")
	@JsonView(Views.PassagerWithReservation.class)
	public Passager getByIdWithReservation(@PathVariable Long id) {
		return passagerService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.PassagerWithReservation.class)
	public Passager create(@Valid @RequestBody Passager passager, BindingResult br) {
		if (br.hasErrors()) {
			throw new PassagerException();
		}
		return passagerService.save(passager);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Passager update(@PathVariable Long id, @Valid @RequestBody Passager passager, BindingResult br) {
		if (!passagerService.exist(id) || passager.getId() == null || (Long)id != (Long)passager.getId() || br.hasErrors()) {
			throw new PassagerException();
		}
		return passagerService.save(passager);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		passagerService.deleteById(id);
	}

}
