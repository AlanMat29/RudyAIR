package rudyAir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rudyAir.exceptions.AeroportException;
import rudyAir.model.vol.Aeroport;
import rudyAir.repositories.IAeroportRepository;

@Service
public class AeroportService {
	@Autowired
	private IAeroportRepository aeroportRepo;

	private void checkData(Aeroport aeroport) {
		if (aeroport.getNom() == null || aeroport.getNom().isEmpty()) {
			throw new AeroportException("Donnees incorrectes");
		}
	}

	
	
	public List<Aeroport> getAll() {
		return aeroportRepo.findAll();
	}
	
	public Aeroport getById(Long id) {
		return aeroportRepo.findById(id).orElseThrow(AeroportException::new);
	}
	
	public Aeroport save(Aeroport aeroport) {
		// Create new
		if (aeroport.getId() == null) {
			checkData(aeroport);
			return aeroportRepo.save(aeroport);
		}
		// Update existing
		else {
			Aeroport aeroportEnBase = getById(aeroport.getId());
			aeroportEnBase.setNom(aeroport.getNom());
			aeroportEnBase.setVille(aeroport.getVille());
			aeroportEnBase.setVolsGeneriquesDeparts(aeroport.getVolsGeneriquesArrivees());
			aeroportEnBase.setVersion(aeroport.getVersion());
			return aeroportRepo.save(aeroportEnBase);
		}
	}
	
	public void delete(Long id) {
		aeroportRepo.delete(getById(id));
	}

}