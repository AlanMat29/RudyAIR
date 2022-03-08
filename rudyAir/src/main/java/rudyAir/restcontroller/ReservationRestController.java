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

import rudyAir.exceptions.ReservationException;
import rudyAir.model.Views;
import rudyAir.model.compte.Reservation;
import rudyAir.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

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
	@JsonView(Views.Reservation.class)
	public Reservation create(@Valid @RequestBody Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Reservation.class)
	public Reservation update(@PathVariable Long id, @Valid @RequestBody Reservation reservation, BindingResult br) {
		if (!reservationService.exist(id) || reservation.getId() == null || (Long) id != (Long) reservation.getId()
				|| br.hasErrors()) {
			throw new ReservationException();
		}
		return reservationService.save(reservation);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		reservationService.deleteById(id);

	}

	@GetMapping("/sortedByIdDesc")
	@JsonView(Views.Reservation.class)
	public List<Reservation> getAllSortedByIdDesc() {
		return reservationService.getAllSortedByIdDesc();
	}

}
