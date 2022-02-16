package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AeroportException;
import rudyAir.model.vol.Vol;
import rudyAir.repositories.IAeroportRepository;
import rudyAir.repositories.IClientRepository;
import rudyAir.repositories.IVolRepository;

@Service
public class ClientService {
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Autowired
	private IVolRepository volRepo;
	
	@Autowired
	private IAeroportRepository aeroportRepo;
	

	public List<Vol> getVolByAeroportDepart(String nomAeroport){
		if (nomAeroport == null || nomAeroport.isEmpty()) {
			throw new AeroportException();
		}
		
		if (!aeroportRepo.findByNom(nomAeroport).isPresent()) {
			throw new AeroportException();
		}
		
		return volRepo.findVolByAeroportNom(nomAeroport);
	}

}
