package rudyAir.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import rudyAir.services.CompteService;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	
	@Autowired
	private CompteService compteService;
	
	

}
