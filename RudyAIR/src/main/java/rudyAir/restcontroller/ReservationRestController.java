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

import rudyAir.exceptions.ReservationException;
import rudyAir.model.Views;
import rudyAir.model.compte.Reservation;
import rudyAir.services.ReservationService;
import rudyAir.services.SiegeService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private SiegeService siegeService;

	@GetMapping("")
	@JsonView(Views.Reservation.class)
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Reservation.class)
	public Reservation getById(@PathVariable Long id) {
		return reservationService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}

	@PutMapping("/{id}")
	public Reservation update(@PathVariable Long id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		if (!reservationService.exist(id) ||reservation.getId() == null || id != reservation.getId() || br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		siegeService.deleteById(siegeService.getSiegeByReservationId(id).getId());
		reservationService.deleteById(id);

	}

}
