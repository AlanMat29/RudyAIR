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
import rudyAir.model.compte.Admin;
import rudyAir.model.compte.Client;
import rudyAir.model.compte.Compte;
import rudyAir.model.compte.Reservation;
import rudyAir.services.AdminService;
import rudyAir.services.ClientService;
import rudyAir.services.CompteService;
import rudyAir.services.ReservationService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {

	@Autowired
	private CompteService compteService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ReservationService reservationService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Compte> getAll() {
		return compteService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
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
	public Compte update(@PathVariable Long id, @Valid @RequestBody Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		return compteService.save(compte);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		// Delete Client reservation before deleting account
		if (getById(id) instanceof Client) {
			for (Reservation r : ((Client) getById(id)).getReservations()) {
				reservationService.deleteById(r.getId());
			}
		}
		compteService.deleteById(id);
	}

	// Additional Web Service
	// admin
	@GetMapping("/client")
	@JsonView(Views.CompteClient.class)
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}

	@GetMapping("/client/{id}/reservations")
	@JsonView(Views.Reservation.class)
	public List<Reservation> getAllClientReservationsByClientId(@PathVariable Long id) {
		return clientService.getAllClientReservationsByClientId(id);
	}

	@GetMapping("/admin")
	@JsonView(Views.CompteClient.class)
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

}
