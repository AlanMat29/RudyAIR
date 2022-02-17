package rudyAir.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rudyAir.services.CompteService;

@RestController
@RequestMapping("/api/compte")
public class VolGeneriqueRestController<VolGenerique> {
	
	@Autowired
	private VolGenerique VolGenerique;
	
	

}
