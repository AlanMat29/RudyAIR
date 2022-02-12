package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.SiegeException;
import rudyAir.model.vol.Siege;
import rudyAir.model.vol.SiegeKey;
import rudyAir.repositories.ISiegeRepository;

@Service
public class SiegeService {
	
	
	@Autowired
	private ISiegeRepository siegeRepo;
	

	private void checkData(Siege s) {
		if (s.getNumero() < 0 || s.getNumero() > 800) {
			throw new SiegeException("Donnees incorrectes");
		}
	}

	
	
	public List<Siege> getAll() {
		return siegeRepo.findAll();
	}
	
	public Siege getById(SiegeKey siegeKey) {
		return siegeRepo.findById(siegeKey).orElseThrow(SiegeException::new);
	}
	
	public Siege save(Siege siege) {
		// Create new
		if (siege.getId() == null) {
			checkData(siege);
			return siegeRepo.save(siege);
		}
		// Update existing
		else {
			Siege siegeEnBase = getById(siege.getId());
			siegeEnBase.setNumero(siege.getNumero());
			return siegeRepo.save(siegeEnBase);
		}
	}
	
	public void delete(SiegeKey siegeKey) {
		siegeRepo.delete(getById(siegeKey));
	}

}
