package rudyAir.restcontroller;

import java.time.LocalDate;
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

import rudyAir.exceptions.VolException;
import rudyAir.model.Views;
import rudyAir.model.vol.Vol;
import rudyAir.services.VolService;

@RestController
@RequestMapping("/api/vol")
@CrossOrigin(origins = "*")
public class VolRestController {

	@Autowired
	private VolService volService;

	@GetMapping("")
	@JsonView(Views.VolWithVolGenAndAvion.class)
	public List<Vol> getAll() {
		return volService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.VolWithVolGenAndAvion.class)
	public Vol getById(@PathVariable Long id) {
		return volService.getById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(Views.VolWithVolGenAndAvion.class)
	public Vol create(@Valid @RequestBody Vol vol, BindingResult br) {
		if (br.hasErrors()) {
			throw new VolException();
		}
		return volService.save(vol);
	}

	@PutMapping("/{id}")
	@JsonView(Views.VolWithVolGenAndAvion.class)
	public Vol update(@PathVariable Long id, @Valid @RequestBody Vol vol, BindingResult br) {
		if (!volService.exist(id) || vol.getId() == null || id != vol.getId() || br.hasErrors()) {
			throw new VolException();
		}
		return volService.save(vol);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		volService.deleteById(id);
	}

	// Additional Web Service
	@GetMapping("/{nomAeroportDepart}/aeroportdepart")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByAeroportDepart(@PathVariable String nomAeroportDepart) {
		return volService.getVolByAeroportDepart(nomAeroportDepart);
	}

	@GetMapping("/{nomAeroportArrivee}/aeroportarrivee")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByAeroportArrivee(@PathVariable String nomAeroportArrivee) {
		return volService.getVolByAeroportArrivee(nomAeroportArrivee);
	}

	@GetMapping("/{dateDepart}/datedepart") // date format = yyyy-MM-dd
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByDateDepart(@PathVariable String dateDepart) {
		LocalDate parseDateArrivee = LocalDate.parse(dateDepart);
		return volService.getVolByDateDepart(parseDateArrivee);
	}

	@GetMapping("/{dateArrivee}/datearrivee") // date format = yyyy-MM-dd
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByDateArrivee(@PathVariable String dateArrivee) {
		LocalDate parseDateArrivee = LocalDate.parse(dateArrivee);
		return volService.getVolByDateArrivee(parseDateArrivee);
	}

	
	@GetMapping("/prixdecroissant")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByPrixDecroissant() {
		return volService.getVolByPrixDecroissant();
	}
	
	@GetMapping("/prixcroissant")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByPrixCroissant() {
		return volService.getVolByPrixCroissant();
	}
	
	@GetMapping("/prixdecroissant/{minPrix}to{maxPrix}")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByintervalPrixOrderByPrixDecroissant(@PathVariable double minPrix, @PathVariable double maxPrix) {
		return volService.getVolByintervalPrixOrderByPrixDecroissant(minPrix, maxPrix);
	}
	
	@GetMapping("/prixcroissant/{minPrix}to{maxPrix}")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByintervalPrixOrderByPrixCroissant(@PathVariable double minPrix, @PathVariable double maxPrix) {
		return volService.getVolByintervalPrixOrderByPrixCroissant(minPrix, maxPrix);
	}
	
	@GetMapping("/avion/{id}")
	@JsonView(Views.VolWithAeroport.class)
	public List<Vol> getVolByAvionId(@PathVariable Long avionId) {
		return volService.getVolByAvionId(avionId);
	}
	
	
}
